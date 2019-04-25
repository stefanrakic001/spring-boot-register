package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Construction;
import com.codecool.springbootregister.repository.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructionService {

    @Autowired
    private ConstructionRepository constructionRepository;

    public Construction addOrUpdateConstruction(Construction construction) {
        return constructionRepository.save(construction);
    }

    public Construction getById(long constructionId) {
        return constructionRepository.findById(constructionId).orElse(null);
    }

    public List<Construction> getAll() {
        return constructionRepository.findAll();
    }
}
