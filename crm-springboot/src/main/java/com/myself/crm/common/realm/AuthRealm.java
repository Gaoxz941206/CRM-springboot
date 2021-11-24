package com.myself.crm.common.realm;

import com.myself.crm.exception.IllegalIP;
import com.myself.crm.mapper.UserMapper;
import com.myself.crm.model.User;
import com.myself.crm.util.DateTimeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 09:45
 * @apiNote
 */
public class AuthRealm extends AuthenticatingRealm {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Session session = SecurityUtils.getSubject().getSession();
        String loginAct = token.getUsername();
        User user = userMapper.selectByLoginAct(loginAct);
        if(user == null){
            throw new UnknownAccountException();
        }
        //获取访问IP
        String ip = session.getHost();
        if(!user.getAllowIp().contains(ip)){
            throw new IllegalIP();
        }
        if("0".equals(user.getLockState())){
            throw new LockedAccountException();
        }
        if(user.getExpireTime() != null && DateTimeUtil.CURRENT_TIME().compareTo(user.getExpireTime()) > 0){
            throw new ExpiredCredentialsException();
        }

        //对token中的密码进行加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(2);
        this.setCredentialsMatcher(matcher);

        session.setAttribute("user",user);

        return new SimpleAuthenticationInfo(user.getLoginAct(),user.getLoginPwd(),getName());
    }
}
