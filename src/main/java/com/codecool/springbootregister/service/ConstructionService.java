package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Construction;
import com.codecool.springbootregister.repository.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}