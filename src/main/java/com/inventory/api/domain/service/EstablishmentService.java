package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Establishment;
import com.inventory.api.domain.repository.EstablishementRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EstablishmentService {

    private EstablishementRepository establishementRepository;

    public EstablishmentService(EstablishementRepository establishementRepository) {
        this.establishementRepository = establishementRepository;
    }

    public List<Establishment> listBySectors(@RequestParam Long sector) {

        return establishementRepository.findBySectorId(sector);
    }

    public List<Establishment> list() {

        return establishementRepository.findAll();
    }
}
