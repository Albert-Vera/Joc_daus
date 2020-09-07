package com.springboot.joc_daus.repository;

import com.springboot.joc_daus.model.User;
import com.springboot.joc_daus.model.UserAdmin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserAdminRepository extends CrudRepository<UserAdmin, Integer> {
    UserAdmin findByUser(String userAdmin);
}
