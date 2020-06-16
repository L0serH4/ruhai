package com.lx.ruhai.config;


import com.lx.ruhai.pojo.User;
import com.lx.ruhai.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的Realm extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证了=>授权doGetAuthenticationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken)token;

        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null){
            return null;
        }
        return new SimpleAuthenticationInfo("",user.getPwd(), "");
    }
}
