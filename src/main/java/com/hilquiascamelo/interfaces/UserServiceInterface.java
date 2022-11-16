package com.hilquiascamelo.interfaces;

import com.hilquiascamelo.dto.UserNewDTO;
import com.hilquiascamelo.models.Users;

import java.util.List;

public interface UserServiceInterface {
    Users find(Integer id);

    void delete(Integer id);

    List<Users> findAll();

    Users insert(Users obj);

    Users fromDTO(UserNewDTO objDto);

    Users update(Users obj);
}
