package com.hackerrank.sample.controller;

import com.hackerrank.sample.model.Model;
import com.hackerrank.sample.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping(value = "/model", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewModel(@RequestBody @Valid Model model) {
        modelService.createModel(model);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllModels() {
        modelService.deleteAllModels();
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteModelById(@RequestParam Long id) {
        modelService.deleteModelById(id);
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Model getModelById(Long id) {
        return modelService.getModelById(id);
    }
}
