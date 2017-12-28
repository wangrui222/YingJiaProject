package com.demo.dao.ldd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * 登陆账号DaoImpl
 * @author ldd
 *
 */
public class UsersRepositoryImpl implements UsersDao{
	@PersistenceContext
	EntityManager em;
	//后台-系统设置-账号设置-查询全部账号
	@Override
	public List<Object[]> selectusers(Integer page, Integer rowsize) {
		String sql="select u.users_id,u.user_name,ur.cname,u.mobile_phone,u.create_date from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id";		

		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//后台-系统设置-账号设置-全部账号查询总数
	@Override
	public Integer getcounts() {
		String sql="SELECT count(*) from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id";

		Query query=em.createNativeQuery(sql);		
		Object object=query.getSingleResult();
		Integer count=Integer.parseInt(object.toString());
		return count;
	}
	////后台-系统设置-密码设置-按ID查询账号
	@Override
	public List<Object[]> selectoneusersrole(Integer uid) {
		String sql="select u.users_id,u.user_name,ur.user_role_id,u.mobile_phone,u.create_date,u.users_password from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id and u.users_id="+uid;		
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//后台-系统设置-账号设置-按name查询id
	@Override
	public Object selectuserid(String name) {
		String sql="select u.users_id from Users u where u.user_name='"+name+"'";		
		Query query=em.createNativeQuery(sql);
		Object object=query.getSingleResult();	
		return object;
	}

	//后台-系统设置-密码设置-按name查询密码
	@Override
	public Object selectpassword(String name) {
		String sql="select u.users_password from Users u where u.user_name='"+name+"'";		
		Query query=em.createNativeQuery(sql);
		Object object=query.getSingleResult();	
		return object;
	}
	/*//后台-系统设置-密码设置-按name查询ID
	@Override
	public Object selectID(String name) {
		String sql="select * from Users u where u.user_name='"+name+"'";		
		Query query=em.createNativeQuery(sql);
		Object object=query.getSingleResult();	
		return object;
	}*/
	//后台-系统设置-密码设置-修改账号角色
	@Override
	@Transactional
	public void updaterole(Integer roleid, Integer uid) {
		String sql="update USER_ROLE_RELATION u set u.role_id="+roleid+" where u.user_id="+uid;		
		Query query=em.createNativeQuery(sql);
		query.executeUpdate();			
	}
	//后台-系统设置-密码设置-按名字查询账号,判断是否存在
	@Override
	public List<Object[]> selectusersrole(String uname) {
		String sql="select u.* from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id and u.user_name='"+uname+"'";		
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}

	//后台-系统设置-密码设置-按角色名字查询账号,判断是否存在
	@Override
	public List<Object[]> selectusersroleexit(String cname) {
		String sql="select * from USER_ROLE t where t.cname='"+cname+"'";		
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}




}
