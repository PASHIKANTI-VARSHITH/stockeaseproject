package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.withdraw;
import com.mini.stockeaseproject.Repository.WithdrawRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawService {
    private final WithdrawRepository wdrep;

    public WithdrawService(WithdrawRepository wdrep) {
        this.wdrep = wdrep;
    }

    public List<withdraw> fetchwithdraw(User user) {
        return wdrep.findByUser(user);
    }

    public void addWithdraws(withdraw withdraws) {
        wdrep.save(withdraws);
    }
}
