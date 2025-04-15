package com.mini.stockeaseproject.Service;

import com.mini.stockeaseproject.Model.User;
import com.mini.stockeaseproject.Model.deposition;
import com.mini.stockeaseproject.Repository.DepositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositionService {
    private final DepositionRepository deprep;

    public DepositionService(DepositionRepository reprep) {
        this.deprep = reprep;
    }

    public List<deposition> fetchdepositions(User user) {
        return deprep.findByUser(user);
    }

    public void addDeposition(deposition depositions) {
        deprep.save(depositions);
    }
}
