package com.example.shiro.realm;

import com.example.shiro.pojo.User;
import com.example.shiro.service.UsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UsersService usersService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    /**
     * 验证当前登录的Subject
     * <p>
     * 本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User users = usersService.getUserByUserName(token.getUsername());
        if (users == null) {
            return null;
        }
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(users.getName(), users.getPassword(), "realm123");
        System.out.println("----------------登陆");
        return authcInfo;
    }
}