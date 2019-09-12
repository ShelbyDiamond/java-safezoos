package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Animal findByAnimaltype(String type);
}
