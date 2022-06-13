package com.hackerrank.sample.service;

import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.exception.BadResourceRequestException;
import com.hackerrank.sample.model.Model;
import com.hackerrank.sample.repository.ModelRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("modelService")
public class ModelServiceImpl implements ModelService {
  @Autowired
  private ModelRepository modelRepository;

  @Override
  public void deleteAllModels() {
    modelRepository.deleteAll();
  }

  @Override
  public void deleteModelById(Long id) {
    modelRepository.deleteById(id);
  }

  @Override
  public void createModel(Model model) {
    Optional<Model> existingModel = modelRepository.findById(model.getId());

    if (existingModel.isPresent()) {
      throw new BadResourceRequestException("Model with same id exists.");
    }

    modelRepository.save(model);
  }

  @Override
  public Model getModelById(Long id) {
    Optional<Model> model = modelRepository.findById(id);

    if (!model.isPresent()) {
      throw new NoSuchResourceFoundException("No model with given id found.");
    }

    return model.get();
  }

  @Override
  public List<Model> getAllModels() {
    return StreamSupport.stream(modelRepository.findAll().spliterator(), false).collect(Collectors.toList());
  }
}
