package com.nkcode.user.service;

import com.nkcode.user.VO.Department;
import com.nkcode.user.VO.ResponseTemplate;
import com.nkcode.user.entity.User;
import com.nkcode.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser in User service");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment in User service");
        ResponseTemplate vo = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject(
                "http://localhost:9001/departments/" + user.getDepartmentId()
                , Department.class );

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
