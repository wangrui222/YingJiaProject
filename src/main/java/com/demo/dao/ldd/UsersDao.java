package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

import com.demo.model.Users;

/**
 * ��½�˺�Dao
 * @author ldd
 *
 */
public interface UsersDao {
	//��̨-ϵͳ����-�˺�����-��ѯȫ���˺�
	public List<Object[]> selectusers(Integer page,Integer rowsize);
	//��̨-ϵͳ����-�˺�����-ȫ���˺Ų�ѯ����
	public Integer getcounts();


	//��̨-ϵͳ����-�˺�����-��id��ѯһ���˺�
	public List<Object[]> selectoneusersrole(Integer uid);
	//��̨-ϵͳ����-�˺�����-��name��ѯ����
	public Object selectpassword(String name);
	//��̨-ϵͳ����-�˺�����-��name��ѯ����
	public Object selectuserid(String name);
	//��̨-ϵͳ����-�˺�����-�޸Ľ�ɫ
	public void updaterole(Integer roleid,Integer uid);
	//��̨-ϵͳ����-�˺�����-�����ֲ�ѯһ���˺�,�ж��Ƿ����
	public List<Object[]> selectusersrole(String uname);
	//��̨-ϵͳ����-�˺�����-����ɫ���ֲ�ѯһ���˺ţ��ж��Ƿ����
	public List<Object[]> selectusersroleexit(String cname);
	
}
