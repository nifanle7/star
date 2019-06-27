package com.uncoverman.star.common.authentication;

import com.uncoverman.star.system.entity.User;
import com.uncoverman.star.system.service.IMenuService;
import com.uncoverman.star.system.service.IRoleService;
import com.uncoverman.star.system.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by NFL on 2019/6/27.
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;

    /**
     * 授权
     * @param principal
     * @return
     */
    //@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //User user = (User) SecurityUtils.getSubject().getPrincipal();
        //String username = user.getUsername();
        //
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //
        //List<Role> roleList = this.roleService.findUserRole(username);
        //Set<String> roleSet = new HashSet<String>();
        //for (Role r : roleList) {
        //    roleSet.add(r.getRoleName());
        //}
        //simpleAuthorizationInfo.setRoles(roleSet);
        //
        //List<Menu> permissionList = this.menuService.findUserPermissions(username);
        //Set<String> permissionSet = new HashSet<String>();
        //for (Menu m : permissionList) {
        //    permissionSet.add(m.getPerms());
        //}
        //simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1. token中获取登录的username，注意不需要获取password.
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //2. 利用 username 查询数据库得到用户的信息.
        User user = this.userService.findByUsername(username);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if ("0".equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }


}
