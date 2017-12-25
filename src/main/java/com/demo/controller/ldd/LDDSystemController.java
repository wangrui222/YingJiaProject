package com.demo.controller.ldd;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.UserRole;
import com.demo.model.Users;
import com.demo.service.lan.YJProjectService;




/**
 * ��̨ϵͳ����controller
 * @author ldd
 *
 */
@Controller
@RequestMapping(value="lddsystem")
public class LDDSystemController {

	@Autowired
	YJProjectService yjprojectservice;
	//��̨-ϵͳ����-�˻�����
	@RequestMapping(value="system/userlist/{name}")
	public String userlist(@PathVariable(value="name")String name,Integer page,Map<String, Object> map) {
		System.out.println("-�˻�����");
		map.put("username", name);
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=20;
		//������
		Integer counts=yjprojectservice.getusercount();
		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectuses(allpage, rowsize);
		map.put("list", list);

		return "/system/user_list";
	}
	//��̨-ϵͳ����-�˻�����-��ת������
	@RequestMapping(value="system/addAccountPage")
	public String toadduser(Map<String, Object> map) {
		List<UserRole> list=yjprojectservice.selectuserrole();
		map.put("list", list);
		return "/system/add_account";
	}
	//��̨-ϵͳ����-�˻�����-ȷ������
	@RequestMapping(value="system/createAccount")
	public String adduser(Users users,Integer roleId) {
		UserRole userrole=new UserRole();
		userrole.setUserRoleId(roleId);
		users.getUserRole().add(userrole);

		Object credentials = new SimpleHash("MD5", users.getUsersPassword(), ByteSource.Util.bytes(users.getUserName()), 1024);

		users.setUsersPassword(credentials.toString());
		users.setUsersSalt(ByteSource.Util.bytes(users.getUserName()).toString());
		users.setCreateDate(new Date());
		users.setUpdateDate(new Date());
		users.setStatus(0);
		yjprojectservice.adduser(users);
		return "redirect:/lddsystem/system/userlist";
	}
	//��̨-ϵͳ����-�˻�����-��ת���޸�
	@RequestMapping(value="system/eidtUserView/{uid},{uname}")
	public String toedituser(@PathVariable(value="uid")Integer uid,@PathVariable(value="uname")String uname,Map<String, Object> map) {
		Object[] list=yjprojectservice.selectoneuserrole(uid);
		map.put("object", list);
		List<UserRole> rolelist=yjprojectservice.selectuserrole();
		map.put("rolelist", rolelist);
		map.put("uname", uname);
		return "/system/edit_account";
	}
	//��̨-ϵͳ����-�˻�����-ȷ���޸�
	@RequestMapping(value="system/updateAccount")
	public String edituser(Users users,Integer roleId,String uname){
	
		//�������������ɵļ�������
		Object credentials = new SimpleHash("MD5", users.getUsersPassword(), ByteSource.Util.bytes(users.getUserName()), 1024);
		yjprojectservice.updateuserrole(roleId, users.getUsersId());
		yjprojectservice.updateuser(credentials.toString(),users.getMobilePhone(), new Date(), users.getUsersId());
		return "redirect:/lddsystem/system/userlist/"+uname;
	}
	//��̨-ϵͳ����-�˻�����-ɾ��
	@RequestMapping(value="system/deleteAccount/{uid},{uname}")
	public String deluser(@PathVariable(value="uid")Integer uid,@PathVariable(value="uname")String uname) {
		yjprojectservice.deleteuser(uid);
		return "redirect:/lddsystem/system/userlist/"+uname;
	}
	//��̨-ϵͳ����-��ɫ����
	@RequestMapping(value="system/rolelist")
	public String rolelist(Map<String, Object> map) {
		List<UserRole> rolelist=yjprojectservice.selectuserrole();
		map.put("rolelist", rolelist);
		return "/system/role_list";
	}
	//��̨-ϵͳ����-��ɫ����-��ת������
	@RequestMapping(value="system/addRolePage")
	public String toaddrole() {
		return "/system/role_add";
	}
	//��̨-ϵͳ����-��ɫ����-ȷ������
	@RequestMapping(value="system/addRole")
	public String addrole(UserRole userrole) {
		userrole.setCreateDate(new Date());
		yjprojectservice.adduserrole(userrole);
		return "redirect:/lddsystem/system/rolelist";
	}

	//��̨-ϵͳ����-��ɫ����-��ת�˵�����
	@RequestMapping(value="system/permisssion")
	public String tousespermisssion() {
		return "/system/permission";
	}

	//��̨-ϵͳ����-��������-��ת�޸��������
	@RequestMapping(value="system/updatePasswdPage/{name}")
	public String toupdatePasswdPage(@PathVariable(value="name")String name,Map<String, Object> map) {
		Object object=yjprojectservice.findpassword(name);
		map.put("object", object);
		map.put("name", name);
		return "/system/update_passwd";
	}
	//��̨-ϵͳ����-��������-ȷ���޸�����
	@RequestMapping(value="system/savePasswd")
	public String updatePasswdPage(Users user,String oldpassword,Map<String, Object> map) {
		//��������������ɵļ�������
		Object credentials = new SimpleHash("MD5", user.getUsersPassword(), ByteSource.Util.bytes(user.getUserName()), 1024);
		//�����ԭ�������ɵļ�������
		Object oldcredentials = new SimpleHash("MD5", oldpassword, ByteSource.Util.bytes(user.getUserName()), 1024);
		//�ɵ�½���ֲ��ҵ����ݿ�ļ�������
		Object password=yjprojectservice.findpassword(user.getUserName());
		Integer uid=Integer.parseInt(yjprojectservice.finduserid(user.getUserName()).toString());
		if (password.equals(oldcredentials.toString())) {
			yjprojectservice.updateuserpwd(credentials.toString(),uid);		
		}		
		return "redirect:/view/login.jsp";

	}
	//����˻���֤�û����Ƿ��Ѵ���	
	@RequestMapping("system/checkUserExsit")
	@ResponseBody
	public Map<String,Object> validateUserName(String userName){
		Map<String,Object> map = new HashMap<>();
		List<Object[]> userslist=yjprojectservice.validateUserName(userName);
		if (userslist.size()==0&&userName.length()>1) {
			map.put("msg", "�û�����Ч");
			map.put("code",0);
		}else if(userslist.size()!=0&&userName.length()>1){
			map.put("msg", "�û�����Ч���Ѵ��ڣ�");
			map.put("code",1);
		}	
		return map;		
	}

	//�޸�������֤���������Ƿ���ԭ����һ��	
	@RequestMapping("system/checkPasswordExsit")
	@ResponseBody
	public Map<String,Object> validatepassword(String oldpassword,String userName){
		Map<String,Object> map = new HashMap<>();
		//�����ԭ�������ɵļ�������
		Object oldcredentials = new SimpleHash("MD5", oldpassword, ByteSource.Util.bytes(userName), 1024);
		List<Object[]> userslist=yjprojectservice.validateUserpwd(oldcredentials.toString());
		if (userslist.size()==0&&oldpassword.length()>2) {
			map.put("msg", "ԭ�����������");
			map.put("code",0);
		}else if(userslist.size()!=0&&oldpassword.length()>2){
			map.put("msg", "ԭ����������ȷ");
			map.put("code",1);
		}	
		return map;		
	}

	/*//�޸��˻���Ϣʱ��֤���˻��ǲ������ڵ�½���˻�	
	@RequestMapping("system/checkusersExsit")
	@ResponseBody
	public Map<String,Object> validateusers(String userName){
		Map<String,Object> map = new HashMap<>();
		
		List<Object[]> userslist=yjprojectservice.validateUserpwd(oldcredentials.toString());
		if (userslist.size()==0&&oldpassword.length()>2) {
			map.put("msg", "ԭ�����������");
			map.put("code",0);
		}else if(userslist.size()!=0&&oldpassword.length()>2){
			map.put("msg", "ԭ����������ȷ");
			map.put("code",1);
		}	
		return map;		
	}*/
}
