package com.bonjourcs.java.shiro.app;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description: hello world app in shiro
 * Date: 2019/8/1
 */
public class HelloWorld {

    @SuppressWarnings("depreaction")
    @Test
    public void test() {

        // initialize security factory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // initialize login subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        // login
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());

        subject.logout();

    }

}
