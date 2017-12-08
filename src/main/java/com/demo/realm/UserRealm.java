package com.demo.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.wr.UserLoginRepository;
import com.demo.model.Users;
import com.demo.service.wr.UserService;
public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	UserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String username = upToken.getUsername();

		String password = new String((char[])upToken.getCredentials());

		Object[] users = userLoginRepository.getUsers(username);
		Users userses = new Users(users[0].toString(), users[1].toString(), users[2].toString(),Integer.parseInt(users[3].toString()));

		if(userses.equals("")||userses==null||userses.getStatus()==2){ 
			throw new UnknownAccountException("用户名不存在");
		}
		if(userses.getStatus()==1){
			throw new LockedAccountException("用户名被锁定");
		}
		Object principal = username;
		Object credentials = new SimpleHash("MD5", password, ByteSource.Util.bytes(username), 1024);
		if(!userses.getUsersPassword().toString().equals(credentials.toString())){
			throw new IncorrectCredentialsException("密码错误");
		}
		String realmName = getName();
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, credentials, credentialsSalt, realmName);
		return info;
	}






	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1. 从 PrincipalCollection 中来获取登录用户的信息
		Object principal = principals.getPrimaryPrincipal();
		//2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
		Set<String> roles = new HashSet<>();
		roles.addAll(userService.findRoles(principal.toString()));
		//3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//4. 返回 SimpleAuthorizationInfo 对象. 
		return info;
	}

	public static void main(String[] args) {
		System.out.println("038bdaf98f2037b31f1e75b5b4c9b26e".equals("038bdaf98f2037b31f1e75b5b4c9b26e"));
		SimpleHash	credentials = new SimpleHash("MD5","123456", ByteSource.Util.bytes("wangrui"), 1024);
		System.out.println(credentials);
	}

}  

