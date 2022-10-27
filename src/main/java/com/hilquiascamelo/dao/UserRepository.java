package com.hilquiascamelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hilquiascamelo.models.Users;

import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Transactional(readOnly=true)
	Users findByEmail(String email);
}
