package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.model.Construction;
import com.codecool.springbootregister.service.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/construction")
public class ConstructionController {

    private ConstructionService constructionService;

    @Autowired
    public ConstructionController(ConstructionService constructionService) {
        this.constructionService = constructionService;
    }

    @GetMapping("/{id}")
    public Construction getBy(@PathVariable long id){
        return constructionService.getById(id);
    }

    @GetMapping("/all")
    public List<Construction> getAll(){
        return constructionService.getAll();
    }

    @PostMapping("/add")
    public Construction addConstruction(@RequestBody Construction construction){
        return constructionService.addOrUpdateConstruction(construction);
    }

    @PutMapping("/{constructionId}")
    public Construction updateConstructtion(@PathVariable("constructionId") long constructionId, @RequestBody Construction updated){
        Construction current = constructionService.getById(constructionId);
        if(current==null) throw new NullPointerException("Not found!");
        current.setLocation(updated.getLocation());
        return constructionService.addOrUpdateConstruction(current);
    }
}
