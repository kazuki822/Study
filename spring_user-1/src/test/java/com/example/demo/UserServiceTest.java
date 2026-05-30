package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;

class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindUser() {
        // ① 準備（モックの動作定義）
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("テスト太郎");

        when(userDao.findById(1)).thenReturn(mockUser);

        // ② 実行
        User result = userService.findById(1);

        // ③ 検証
        assertEquals("テスト太郎", result.getName());

        // DAOが呼ばれたか確認
        verify(userDao).findById(1);
    }
}