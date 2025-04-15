package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.stock;
import com.mini.stockeaseproject.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StockServise {

    private final StockRepository stockRepository;

    @Autowired
    public StockServise(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<stock> fetchstock(User user) {
        return stockRepository.findByUser(user);
    }

    public stock addStock(stock stock) {
        return stockRepository.save(stock);
    }

    public Optional<stock> findById(Long stockid) {
        return stockRepository.findById(stockid);
    }

    public stock updateStock(stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long stockid) {
        stockRepository.deleteById(stockid);
    }

    public List<stock> getAllStocks(User user) {
        return stockRepository.findByUser(user);
    }

    public Optional<stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }


}