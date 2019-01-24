package com.capco.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capco.travel.model.LoginDetailsBO;

public interface LoginRepo extends JpaRepository<LoginDetailsBO, String> {
    LoginDetailsBO findBycapcoUserId(String capcoUserId);
    LoginDetailsBO findByEmailId(String emailId);
}
