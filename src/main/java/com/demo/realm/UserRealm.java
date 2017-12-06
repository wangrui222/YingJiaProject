package com.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.demo.model.Users;
public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		//1. �� AuthenticationToken ת��Ϊ UsernamePasswordToken 
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		//2. �� UsernamePasswordToken ������ȡ username
		String username = upToken.getUsername();
		
		String password = new String((char[])upToken.getCredentials());

		if(username=="zhangjian"){ throw new UnknownAccountException("用户名不存在");}
		if("liqi".equals(username)){
			throw new LockedAccountException("用户名被锁定");
		}
		Object principal = username;
		//2). credentials: ����. 
		Object credentials = null; //"fc1709d0a95a6be30bc5926fdb7f22f4";
		if(username.equals("wangrui")){
			credentials = new SimpleHash("MD5", password, ByteSource.Util.bytes(username), 1024);
		}
		String realmName = getName();
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, credentials, credentialsSalt, realmName);
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("AuthorizationInfo");
				return null;
		
	}


}  

