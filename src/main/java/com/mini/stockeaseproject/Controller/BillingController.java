package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.*;
import com.mini.stockeaseproject.Repository.BillRepository;
import com.mini.stockeaseproject.Repository.CustomerRepository;
import com.mini.stockeaseproject.Repository.StockRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class BillingController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/billing")
    public String getBillingPage() {
        return "billing";
    }

    @GetMapping("/api/products")
    @ResponseBody
    public List<stock> getProducts(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return stockRepository.findByUser(user);
    }

    @PostMapping("/api/create-bill")
    @ResponseBody
    public ResponseEntity<?> createBill(@RequestBody Map<String, Object> payload, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");

            // Get customer information
            String customerName = (String) payload.get("customerName");
            String customerMobile = (String) payload.get("customerMobile");
            Double amountPaid = Double.parseDouble(payload.get("amountPaid").toString());
            List<Map<String, Object>> items = (List<Map<String, Object>>) payload.get("items");

            // Find or create customer
            Customer customer;
            Optional<Customer> existingCustomer = customerRepository.findByCustomerMobileNumberAndUser(customerMobile, user);

            if (existingCustomer.isPresent()) {
                customer = existingCustomer.get();
                customer.setCustomerName(customerName); // Update name in case it changed
            } else {
                customer = new Customer(customerName, customerMobile, user);
                customer.setCustomerTotalSales(0.0);
            }

            // Calculate total amount and pending amount
            double calculatedTotalAmount = 0.0;
            for (Map<String, Object> item : items) {
                Double salePrice = Double.parseDouble(item.get("salePrice").toString());
                Double quantity = Double.parseDouble(item.get("quantity").toString());
                calculatedTotalAmount += salePrice * quantity;
            }

            // Calculate pending amount
            double amountPending = calculatedTotalAmount - amountPaid;
            // Update customer's total sales and pending amount
            customer.setCustomerTotalSales(customer.getCustomerTotalSales() + calculatedTotalAmount);
            if (amountPending > 0) {
                customer.setMoneyInPending(customer.getMoneyInPending() + amountPending);
            }
            customerRepository.save(customer);

            // Create bill
            Bill bill = new Bill(user, customer);
            bill.setTotalAmount(calculatedTotalAmount); // Use the calculated total
            bill.setAmountPaid(amountPaid);
            bill.setAmountPending(amountPending);


            // Add bill items and update stock
            for (Map<String, Object> item : items) {
                Long stockId = Long.parseLong(item.get("productId").toString());
                Double salePrice = Double.parseDouble(item.get("salePrice").toString());
                Double quantity = Double.parseDouble(item.get("quantity").toString());

                Optional<stock> stockOptional = stockRepository.findById(stockId);
                if (stockOptional.isPresent()) {
                    stock stockItem = stockOptional.get();

                    // Ensure there's enough stock
                    if (stockItem.getStockquantity() >= quantity) {
                        // Update stock quantity
                        double newQuantity = stockItem.getStockquantity() - quantity;
                        stockItem.setStockquantity(newQuantity);

                        // Update total value of stock item
                        stockItem.setTotalvalue(newQuantity * stockItem.getCostprice());
                        stockRepository.save(stockItem);

                        // Create bill item
                        BillItem billItem = new BillItem(stockItem, salePrice, quantity);
                        bill.addBillItem(billItem);
                    } else {
                        return ResponseEntity.badRequest().body(Map.of(
                                "success", false,
                                "message", "Not enough stock for " + stockItem.getProductname()
                        ));
                    }
                }
            }

            billRepository.save(bill);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "billId", bill.getBillId()
            ));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }
}