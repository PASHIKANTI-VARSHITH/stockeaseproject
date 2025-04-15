package com.mini.stockeaseproject.Controller;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.supplier;
import com.mini.stockeaseproject.Service.SupplierService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public String showSuppliers(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        List<supplier> suppliers = supplierService.fetchsuppliers(user);
        model.addAttribute("supplierdetails", suppliers);
        return "supplier";
    }

    @GetMapping("/add-supplier")
    public String showAddSupplierForm(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        return "add-supplier";
    }

    @PostMapping("/addsupplier")
    public String addSupplier(
            @RequestParam String suppliercompanyname,
            @RequestParam String suppliercontactname,
            @RequestParam String suppliermobilenumber,
            @RequestParam String supplieraddress,
            @RequestParam(required = false, defaultValue = "0.0") Double supplierpendingamount,
            @RequestParam(required = false, defaultValue = "0.0") Double suppliertotalamountpaid,
            HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        supplier newSupplier = new supplier(
                user,
                suppliercompanyname,
                suppliercontactname,
                suppliermobilenumber,
                supplieraddress,
                supplierpendingamount,
                suppliertotalamountpaid
        );

        supplierService.addSupplier(newSupplier);

        return "redirect:/landing";
    }

    @GetMapping("/edit-supplier/{id}")
    public String showEditSupplierForm(@PathVariable("id") Long supplierId,
                                       HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Optional<supplier> supplierOptional = supplierService.getSupplierById(supplierId);

        if (supplierOptional.isPresent()) {
            supplier supplierToEdit = supplierOptional.get();
            model.addAttribute("supplier", supplierToEdit);
            return "edit-supplier";
        }

        return "redirect:/suppliers";
    }

    @PostMapping("/updatesupplier")
    public String updateSupplier(@RequestParam("supplierid") Long supplierid,
                                 @RequestParam("suppliercompanyname") String suppliercompanyname,
                                 @RequestParam("suppliercontactname") String suppliercontactname,
                                 @RequestParam("suppliermobilenumber") String suppliermobilenumber,
                                 @RequestParam("supplieraddress") String supplieraddress,
                                 @RequestParam("supplierpendingamount") double supplierpendingamount,
                                 @RequestParam("suppliertotalamountpaid") double suppliertotalamountpaid,
                                 HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Optional<supplier> optionalSupplier = supplierService.getSupplierById(supplierid);
        if (optionalSupplier.isPresent()) {
            supplier existing = optionalSupplier.get();
            existing.setSuppliercompanyname(suppliercompanyname);
            existing.setSuppliercontactname(suppliercontactname);
            existing.setSuppliermobilenumber(suppliermobilenumber);
            existing.setSupplieraddress(supplieraddress);
            existing.setSupplierpendingamount(supplierpendingamount);
            existing.setSuppliertotalamountpaid(suppliertotalamountpaid);
            supplierService.addSupplier(existing);
        }

        return "redirect:/landing";
    }



    @GetMapping("/delete-supplier/{id}")
    public String deleteSupplier(@PathVariable("id") Long supplierId, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        supplierService.deleteSupplier(supplierId);

        return "redirect:/landing";
    }
}