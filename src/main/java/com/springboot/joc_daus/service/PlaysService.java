package com.springboot.joc_daus.service;

import com.springboot.joc_daus.model.Plays;
import com.springboot.joc_daus.repository.IPlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaysService implements IPlaysService {

    @Autowired
    IPlayRepository repoPlays;

    @Override
    public <S extends Plays> S save(S play) {
        return repoPlays.save(play);
    }

    @Override
    public <S extends Plays> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Plays> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Plays> findAll() {
        return (List<Plays>) repoPlays.findAll();
    }

    @Override
    public Iterable<Plays> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public List<Plays> findAllByUserId(int id) {
        return repoPlays.findAllByUserId(id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        repoPlays.deleteById(id);
    }

    @Override
    public void delete(Plays entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Plays> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
