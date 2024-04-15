package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import org.springframework.core.convert.converter.Converter;

public abstract class RoleDtoConverter implements Converter<String, RoleDTO>{

    @Override
    public RoleDTO convert(String source){

        return null;
    }
}


