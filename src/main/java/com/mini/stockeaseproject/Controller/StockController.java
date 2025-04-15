package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.supplier;
import com.mini.stockeaseproject.Model.stock;
import com.mini.stockeaseproject.Service.StockServise;
import com.mini.stockeaseproject.Service.SupplierService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class StockController {
    private final StockServise stcser;
    private final SupplierService supplierService;

    public StockController(StockServise stcser, SupplierService supplierService) {
        this.stcser = stcser;
        this.supplierService = supplierService;
    }

    //getting stock in landing page
    @GetMapping("/stock")
    public String showStock(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }
        List<stock> stocklist = stcser.fetchstock(user);
        List<supplier> suppliers = supplierService.getAllSuppliers(user);

        model.addAttribute("stock", stocklist);
        model.addAttribute("suppliers", suppliers);
        return "stock"; // Renders stock.html
    }

    @PostMapping("/addstock")
    public String addstock(@RequestParam String productname,
                           HttpSession session){
        User user=(User) session.getAttribute("user");

        stock stocks=new stock(user,productname,0.0,0.0,0.0);
        stcser.addStock(stocks);
        return "redirect:/landing";
    }

    @PostMapping("/addmorestock")
    public String addMoreStock(
            @RequestParam Long stockid,
            @RequestParam Double stockquantity,
            @RequestParam Double costprice,
            @RequestParam Double totalvalue,
            @RequestParam Long supplierid,
            @RequestParam Double moneypaidtosupplier,
            @RequestParam Double moneypendingtosupplier,
            HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        // Update stock information
        Optional<stock> stockOptional = stcser.findById(stockid);
        if (stockOptional.isPresent()) {
            stock existingStock = stockOptional.get();

            // Update stock quantities and values
            Double currentQuantity = existingStock.getStockquantity() != null ? existingStock.getStockquantity() : 0.0;
            Double currentTotalValue = existingStock.getTotalvalue() != null ? existingStock.getTotalvalue() : 0.0;

            existingStock.setStockquantity(currentQuantity + stockquantity);
            existingStock.setCostprice(costprice); // Replace with new cost price
            existingStock.setTotalvalue(currentTotalValue + totalvalue); // Add new total value

            stcser.updateStock(existingStock);
        }

        // Update supplier information
        Optional<supplier> supplierOptional = supplierService.findById(supplierid);
        if (supplierOptional.isPresent()) {
            supplier existingSupplier = supplierOptional.get();

            Double currentPendingAmount = existingSupplier.getSupplierpendingamount() != null ?
                    existingSupplier.getSupplierpendingamount() : 0.0;
            Double currentPaidAmount = existingSupplier.getSuppliertotalamountpaid() != null ?
                    existingSupplier.getSuppliertotalamountpaid() : 0.0;

            existingSupplier.setSupplierpendingamount(currentPendingAmount + moneypendingtosupplier);
            existingSupplier.setSuppliertotalamountpaid(currentPaidAmount + moneypaidtosupplier);

            supplierService.updateSupplier(existingSupplier);
        }

        return "redirect:/landing";
    }
}