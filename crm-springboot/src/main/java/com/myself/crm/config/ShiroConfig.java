package com.myself.crm.config;

import com.myself.crm.common.realm.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 09:46
 * @apiNote
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm(){
        return new AuthRealm();
    }

    @Bean
    public SecurityManager manager(Realm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean factoryBean(SecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
        factoryBean.setLoginUrl("/");
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/login","anon");
        map.put("/logout","logout");
        map.put("/jquery/**","anon");
        map.put("/image/**","anon");
        map.put("/favicon.ico","anon");
        map.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

}
