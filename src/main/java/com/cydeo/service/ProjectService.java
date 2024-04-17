package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

public interface ProjectService extends CRUDService<ProjectDTO,String>{
    void deleteById(String projectCode);

    void  complete(ProjectDTO projectDTO);
}
