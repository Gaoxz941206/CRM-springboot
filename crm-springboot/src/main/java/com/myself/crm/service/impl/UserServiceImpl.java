package com.myself.crm.service.impl;

import com.myself.crm.mapper.UserMapper;
import com.myself.crm.model.User;
import com.myself.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 16:44
 * @apiNote
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
