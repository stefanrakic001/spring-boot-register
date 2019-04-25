package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.model.Construction;
import com.codecool.springbootregister.service.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/construction")
public class ConstructionController {

    private ConstructionService constructionService;

    @Autowired
    public ConstructionController(ConstructionService constructionService) {
        this.constructionService = constructionService;
    }

    @PostMapping("/add")
    public Construction addConstruction(@RequestBody Construction construction){
        return constructionService.addConstruction(construction);
    }
}
