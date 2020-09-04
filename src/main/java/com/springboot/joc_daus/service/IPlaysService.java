package com.springboot.joc_daus.service;

import com.springboot.joc_daus.model.Plays;
import com.springboot.joc_daus.repository.IPlayRepository;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
public interface IPlaysService extends IPlayRepository {
    List<Plays> findAllByUserId(int id);
}
