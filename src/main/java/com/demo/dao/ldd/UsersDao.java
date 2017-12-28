package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

import com.demo.model.Users;

/**
 * 登陆账号Dao
 * @author ldd
 *
 */
public interface UsersDao {
	//后台-系统设置-账号设置-查询全部账号
	public List<Object[]> selectusers(Integer page,Integer rowsize);
	//后台-系统设置-账号设置-全部账号查询总数
	public Integer getcounts();


	//后台-系统设置-账号设置-按id查询一个账号
	public List<Object[]> selectoneusersrole(Integer uid);
	//后台-系统设置-账号设置-按name查询密码
	public Object selectpassword(String name);
	//后台-系统设置-账号设置-按name查询密码
	public Object selectuserid(String name);
	//后台-系统设置-账号设置-修改角色
	public void updaterole(Integer roleid,Integer uid);
	//后台-系统设置-账号设置-按名字查询一个账号,判断是否存在
	public List<Object[]> selectusersrole(String uname);
	//后台-系统设置-账号设置-按角色名字查询一个账号，判断是否存在
	public List<Object[]> selectusersroleexit(String cname);
	
}
