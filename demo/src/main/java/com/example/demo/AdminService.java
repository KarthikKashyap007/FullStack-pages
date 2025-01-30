package com.example.demo;
import java.util.Optional;


import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.request.LoginRequest;

@Service
public class AdminService {
//  @Autowired
//  AdminService adminService;

    @Autowired
    AdminRepo adminRepo;

    public Admin addUser(Admin user) {
        return adminRepo.save(user);
    }

    public Boolean loginUser(LoginRequest loginRequest) {
        Optional<Admin> admin = adminRepo.findById(loginRequest.getUserId());

        if (!admin.isPresent()) {
            System.out.println("error");
            return false;
        }
        Admin user1 = admin.get();
        if (!user1.getPassword().equals(loginRequest.getPassword())) {
            return false;
        }
        return true;
    }
}
