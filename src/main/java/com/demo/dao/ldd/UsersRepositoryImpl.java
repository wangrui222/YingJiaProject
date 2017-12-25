package com.demo.dao.ldd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.demo.model.Users;

/**
 * ��½�˺�DaoImpl
 * @author ldd
 *
 */
public class UsersRepositoryImpl implements UsersDao{
	@PersistenceContext
	EntityManager em;
	//��̨-ϵͳ����-�˺�����-��ѯȫ���˺�
	@Override
	public List<Object[]> selectusers(Integer page, Integer rowsize) {
		String sql="select u.users_id,u.user_name,ur.cname,u.mobile_phone,u.create_date from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id";		
		
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//��̨-ϵͳ����-�˺�����-ȫ���˺Ų�ѯ����
	@Override
	public Integer getcounts() {
		String sql="SELECT count(*) from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id";
		
		Query query=em.createNativeQuery(sql);		
		Object object=query.getSingleResult();
		Integer count=Integer.parseInt(object.toString());
		return count;
	}
////��̨-ϵͳ����-��������-��ID��ѯ�˺�
	@Override
	public List<Object[]> selectoneusersrole(Integer uid) {
		String sql="select u.users_id,u.user_name,ur.user_role_id,u.mobile_phone,u.create_date,u.users_password from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id and u.users_id="+uid;		
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//��̨-ϵͳ����-�˺�����-��name��ѯid
	@Override
	public Object selectuserid(String name) {
		String sql="select u.users_id from Users u where u.user_name='"+name+"'";		
		Query query=em.createNativeQuery(sql);
		Object object=query.getSingleResult();	
		return object;
	}
	
	//��̨-ϵͳ����-��������-��name��ѯ����
	@Override
	public Object selectpassword(String name) {
		String sql="select u.users_password from Users u where u.user_name='"+name+"'";		
		Query query=em.createNativeQuery(sql);
		Object object=query.getSingleResult();	
		return object;
	}
	/*//��̨-ϵͳ����-��������-��name��ѯID
	@Override
	public Object selectID(String name) {
		String sql="select * from Users u where u.user_name='"+name+"'";		
		Query query=em.createNativeQuery(sql);
		Object object=query.getSingleResult();	
		return object;
	}*/
	//��̨-ϵͳ����-��������-�޸��˺Ž�ɫ
	@Override
	@Transactional
	public void updaterole(Integer roleid, Integer uid) {
		String sql="update USER_ROLE_RELATION u set u.role_id="+roleid+" where u.user_id="+uid;		
		Query query=em.createNativeQuery(sql);
		query.executeUpdate();			
	}
	////��̨-ϵͳ����-��������-�����ֲ�ѯ�˺�
	@Override
	public List<Object[]> selectusersrole(String uname) {
		String sql="select u.* from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id and u.user_name='"+uname+"'";		
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
////��̨-ϵͳ����-��������-�������ѯ�˺�
	@Override
	public List<Object[]> selectusersonpwd(String pwd) {
		String sql="select u.* from Users u,User_Role ur,User_Role_Relation urr where u.users_id=urr.user_id and ur.user_role_id=urr.role_id and u.users_password='"+pwd+"'";		
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}



}
