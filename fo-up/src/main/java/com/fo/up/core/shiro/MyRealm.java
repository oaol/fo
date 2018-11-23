package com.fo.up.core.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.fo.common.core.util.MD5Util;
import com.fo.up.entity.UpPermission;
import com.fo.up.entity.UpRole;
import com.fo.up.entity.UpUser;
import com.fo.up.service.UpPermissionService;
import com.fo.up.service.UpRoleService;
import com.fo.up.service.UpUserService;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UpUserService upUserService;

    @Autowired
    private UpRoleService upRoleService;
    
    @Autowired
    private UpPermissionService upPermissionService;

    /**
     * 鉴权
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        UpUser user = new UpUser();
        user.setUsername(name);
        // 从数据库获取对应用户名密码的用户
        UpUser findUserByUsernameAndPassword = this.upUserService.findUserByUsernameAndPassword(user);
        if (findUserByUsernameAndPassword != null) {
            // 验证密码 
            String salt = findUserByUsernameAndPassword.getSalt();
            String md5 = MD5Util.md5(password + salt);
            if (md5 == null || !md5.equals(findUserByUsernameAndPassword.getPassword())) {
                throw new UnknownAccountException();
            }
            // 用户为禁用状态
            if (findUserByUsernameAndPassword.getLocked() != 0) {
                throw new DisabledAccountException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    findUserByUsernameAndPassword, //用户
                    password, //密码
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof UpUser) {
            UpUser currentUser = (UpUser) principal;
            List<UpRole> upRoles = this.upRoleService.findRoleByUserId(currentUser.getUserId());
            List<String> roles = new ArrayList<>();
            upRoles.forEach((role) -> {
                roles.add(role.getName());
            });
            authorizationInfo.addRoles(roles);

            List<UpPermission> upPermissions = upPermissionService.findPermissionByUserId(currentUser.getUserId());
            Set<String> permissions = new HashSet<>();
            upPermissions.forEach((permission) -> {
                if (StringUtils.isNoneBlank(permission.getPermissionValue())) {
                    permissions.add(permission.getPermissionValue());
                }
            });
            authorizationInfo.addStringPermissions(permissions);
        }
        return authorizationInfo;
    }

}