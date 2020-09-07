package com.springboot.joc_daus.service;

import com.springboot.joc_daus.model.UserAdmin;
import com.springboot.joc_daus.repository.IUserAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserAdminService extends IUserAdminRepository {

    UserAdmin findByUser (String userAdmin);
}
