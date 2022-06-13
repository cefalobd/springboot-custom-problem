package com.hackerrank.sample.repository;

import com.hackerrank.sample.model.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("modelRepository")
public interface ModelRepository extends CrudRepository<Model, Long> {
}
