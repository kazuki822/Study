package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    void findById_モックを使ってDB依存を回避() {

        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("花子");

        when(userMapper.getOne(1)).thenReturn(user);

        UserEntity result = userService.findById(1);

        assertEquals("花子", result.getName());
    }
}