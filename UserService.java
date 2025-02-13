package com.example.rest.demo_user.service;

import com.example.rest.demo_user.entity.User;
import com.example.rest.demo_user.repository.UserRepository;
import com.example.rest.demo_user.vo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUserDetails(User user) {
        return userRepository.save(user);
    }

    public Map<String, Object> getUserWithDepartment(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return Map.of("error", "User not found");
        }
        String departmentUrl = "http://localhost:8081/departments/"+ user.getDepartmentId();
        Department department = restTemplate.getForObject(departmentUrl, Department.class);
        return Map.of("user", user, "department", department);
    }

   /* public Map<String, Object> fallbackDepartment(Long userId, Throwable throwable) {
        User user = new User(userId, "Fallback User", "N/A", -1L);
        Map<String, Object> fallbackResponse = new HashMap<>();
        fallbackResponse.put("user", user);
        fallbackResponse.put("department", "Service unavailable");
        return fallbackResponse;
    }*/

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}