package com.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.wr.UserLoginRepository;
import com.demo.model.Users;
public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserLoginRepository userLoginRepository;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
//		Object[] users = userLoginRepository.getUsers("admin");
//		Users userses = new Users(users[0].toString(), users[1].toString(), users[2].toString(),Integer.parseInt(users[3].toString()));


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
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("AuthorizationInfo");
		return null;

	}

	public static void main(String[] args) {
		System.out.println("038bdaf98f2037b31f1e75b5b4c9b26e".equals("038bdaf98f2037b31f1e75b5b4c9b26e"));
		SimpleHash	credentials = new SimpleHash("MD5","123456", ByteSource.Util.bytes("admin"), 1024);
		System.out.println(credentials);
	}


}  

