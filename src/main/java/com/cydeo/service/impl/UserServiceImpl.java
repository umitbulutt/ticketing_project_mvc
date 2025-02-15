package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {
    @Override
    public UserDTO save(UserDTO user) {
        return super.save(user.getUserName(),user);
    }

    @Override
    public UserDTO findById(String username) {
        return super.findById(username);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }



    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }

    @Override
    public void deleteById(String username) {
        super.deleteBYId(username);
    }

    @Override
    public List<UserDTO> findManagers() {
        return findAll().stream().filter(user-> user.getRole().getId() == 2)
                .collect(Collectors.toList());
    }


}
