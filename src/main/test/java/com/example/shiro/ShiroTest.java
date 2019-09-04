package com.example.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest {
    private Logger logger = LoggerFactory.getLogger(ShiroTest.class);

    @Test
    public void shiroIniRealmTest() {
        logger.info("My First Apache Shiro Application");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
        try {
            currentUser.login(token);
            logger.info("User [" + currentUser.getPrincipal() + "] 验证成功");
        } catch (AuthenticationException ae) {
            logger.error("验证失败");
            ae.printStackTrace();
        }
        currentUser.logout();
        System.exit(0);
    }

    @Test
    public void shiroJdbcRealmTest() {
        logger.info("My First Apache Shiro Application");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.4/mytest?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("zmqwe123");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        defaultSecurityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
        try {
            currentUser.login(token);
            logger.info("User [" + currentUser.getPrincipal() + "] 验证成功");
        } catch (AuthenticationException ae) {
            logger.error("验证失败");
            ae.printStackTrace();
        }
        currentUser.logout();
        System.exit(0);
    }

}
