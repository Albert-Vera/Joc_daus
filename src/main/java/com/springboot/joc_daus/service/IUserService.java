package com.springboot.joc_daus.service;

import com.springboot.joc_daus.model.User;
import com.springboot.joc_daus.repository.IUserRepository;

import java.util.List;

public interface IUserService extends IUserRepository {
    List<User> findByIdUser(Integer id);
}
