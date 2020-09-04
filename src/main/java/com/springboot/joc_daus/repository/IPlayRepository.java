package com.springboot.joc_daus.repository;

import com.springboot.joc_daus.model.Plays;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayRepository extends CrudRepository<Plays,Integer> {
    List<Plays> findAllByUserId(int id);
}
