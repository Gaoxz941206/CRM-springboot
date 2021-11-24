package com.myself.crm.service;

import com.myself.crm.model.User;

import java.util.List;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 16:44
 * @apiNote
 */
public interface UserService {

    List<User> selectAll();
}
