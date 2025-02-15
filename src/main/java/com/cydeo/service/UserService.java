package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService extends CRUDService<UserDTO,String> {


    void deleteById(String username);

    List<UserDTO> findManagers();
}
