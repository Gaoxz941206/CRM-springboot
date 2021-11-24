package com.myself.crm.controller;

import com.myself.crm.exception.IllegalIP;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 09:27
 * @apiNote
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public @ResponseBody String login(String loginAct,String loginPwd){
        UsernamePasswordToken token = new UsernamePasswordToken(loginAct,loginPwd);
        Subject subject = SecurityUtils.getSubject();
        String msg = "yes";
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            msg = "用户名不存在";
        } catch (IllegalIP e) {
            msg = "非法的访问IP";
        } catch (LockedAccountException e) {
            msg = "用户被锁定";
        } catch (ExpiredCredentialsException e) {
            msg = "用户已过期";
        } catch (IncorrectCredentialsException e) {
            msg = "密码不正确";
        }
        return msg;
    }

    /*@RequestMapping("/logout")
    public String logout(){
        return "login";
    }*/

}
