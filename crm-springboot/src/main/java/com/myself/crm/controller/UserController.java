package com.myself.crm.controller;

import com.myself.crm.mapper.UserMapper;
import com.myself.crm.model.User;
import com.myself.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 10:33
 * @apiNote
 */
@Controller
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/user/selectAll")
    @ResponseBody
    public List<User> selectAll(){
        return userService.selectAll();
    }

}
