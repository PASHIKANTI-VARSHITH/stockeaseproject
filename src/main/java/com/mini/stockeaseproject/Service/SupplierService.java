package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.supplier;
import com.mini.stockeaseproject.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<supplier> fetchsuppliers(User user) {
        return supplierRepository.findByUser(user);
    }

    public List<supplier> getAllSuppliers(User user) {
        return supplierRepository.findByUser(user);
    }

    public supplier addSupplier(supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Optional<supplier> getSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId);
    }

    public Optional<supplier> findById(Long supplierId) {
        return supplierRepository.findById(supplierId);
    }

    public supplier updateSupplier(supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long supplierId) {
        supplierRepository.deleteById(supplierId);
    }
}