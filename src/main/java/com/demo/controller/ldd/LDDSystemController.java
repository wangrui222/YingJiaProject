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
 * 后台系统设置controller
 * @author ldd
 *
 */
@Controller
@RequestMapping(value="lddsystem")
public class LDDSystemController {

	@Autowired
	YJProjectService yjprojectservice;
	//后台-系统设置-账户设置
	@RequestMapping(value="system/userlist")
	public String userlist(Integer page,Map<String, Object> map) {
		System.out.println("-账户设置");

		//当前第几页
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=20;
		//总条数
		Integer counts=yjprojectservice.getusercount();
		//总页数
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectuses(allpage, rowsize);
		map.put("list", list);

		return "/system/user_list";
	}
	//后台-系统设置-账户设置-跳转到新增
	@RequestMapping(value="system/addAccountPage")
	public String toadduser(Map<String, Object> map) {
		List<UserRole> list=yjprojectservice.selectuserrole();
		map.put("list", list);
		return "/system/add_account";
	}
	//后台-系统设置-账户设置-确认新增
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
	//后台-系统设置-账户设置-跳转到修改
	@RequestMapping(value="system/eidtUserView/{uid}")
	public String toedituser(@PathVariable(value="uid")Integer uid,Map<String, Object> map) {
		Object[] list=yjprojectservice.selectoneuserrole(uid);
		map.put("object", list);
		List<UserRole> rolelist=yjprojectservice.selectuserrole();
		map.put("rolelist", rolelist);

		return "/system/edit_account";
	}
	//后台-系统设置-账户设置-确认修改
	@RequestMapping(value="system/updateAccount")
	public String edituser(Users users,Integer roleId,String name){
		System.out.println(name);
		if (name.equals(users.getUserName())) {
			//输入新密码生成的加密密码
			Object credentials = new SimpleHash("MD5", users.getUsersPassword(), ByteSource.Util.bytes(users.getUserName()), 1024);
			yjprojectservice.updateuserrole(roleId, users.getUsersId());
			yjprojectservice.updateuser(credentials.toString(),users.getMobilePhone(), new Date(), users.getUsersId());
			return "redirect:/view/login.jsp";
		}else if(name.equals("")){
			return "redirect:/lddsystem/system/userlist";
		}else{
			//输入新密码生成的加密密码
			Object credentials = new SimpleHash("MD5", users.getUsersPassword(), ByteSource.Util.bytes(users.getUserName()), 1024);
			yjprojectservice.updateuserrole(roleId, users.getUsersId());
			yjprojectservice.updateuser(credentials.toString(),users.getMobilePhone(), new Date(), users.getUsersId());
			return "redirect:/lddsystem/system/userlist";
		}	
	}
	//后台-系统设置-账户设置-判断删除是否是删除正在登陆的账户
	@RequestMapping(value="system/deleteAccount")
	@ResponseBody
	public Map<String,Object> deluser(String loginuserName,Integer userId) {
		Map<String,Object> map = new HashMap<>();
		Users user=yjprojectservice.findone(userId);
		if (loginuserName.equals(user.getUserName())) {
			map.put("code",0);
		}
		return map;
	}	
	//后台-系统设置-账户设置-删除
	@RequestMapping(value="system/deleteotherAccount/{id}")
	public String deleteuser(@PathVariable("id") Integer id) {
		yjprojectservice.deleteuser(id);
		return "redirect:/lddsystem/system/userlist";
	}
	//后台-系统设置-角色设置
	@RequestMapping(value="system/rolelist")
	public String rolelist(Map<String, Object> map) {
		List<UserRole> rolelist=yjprojectservice.selectuserrole();
		map.put("rolelist", rolelist);
		return "/system/role_list";
	}
	//后台-系统设置-角色设置-跳转到新增
	@RequestMapping(value="system/addRolePage")
	public String toaddrole() {
		return "/system/role_add";
	}
	//后台-系统设置-角色设置-确认新增
	@RequestMapping(value="system/addRole")
	public String addrole(UserRole userrole) {
		userrole.setCreateDate(new Date());
		yjprojectservice.adduserrole(userrole);
		return "redirect:/lddsystem/system/rolelist";
	}

	//后台-系统设置-角色设置-跳转菜单配置
	@RequestMapping(value="system/permisssion")
	public String tousespermisssion() {
		return "/system/permission";
	}

	//后台-系统设置-密码设置-跳转修改密码界面
	@RequestMapping(value="system/updatePasswdPage/{name}")
	public String toupdatePasswdPage(@PathVariable(value="name")String name,Map<String, Object> map) {
		Object object=yjprojectservice.findpassword(name);
		map.put("object", object);
		map.put("name", name);
		return "/system/update_passwd";
	}
	//后台-系统设置-密码设置-确认修改密码
	@RequestMapping(value="system/savePasswd")
	public String updatePasswdPage(Users user,String oldpassword,Map<String, Object> map) {
		//输入的新密码生成的加密密码
		Object credentials = new SimpleHash("MD5", user.getUsersPassword(), ByteSource.Util.bytes(user.getUserName()), 1024);
		//输入的原密码生成的加密密码
		Object oldcredentials = new SimpleHash("MD5", oldpassword, ByteSource.Util.bytes(user.getUserName()), 1024);
		//由登陆名字查找的数据库的加密密码
		Object password=yjprojectservice.findpassword(user.getUserName());
		Integer uid=Integer.parseInt(yjprojectservice.finduserid(user.getUserName()).toString());
		if (password.equals(oldcredentials.toString())) {
			yjprojectservice.updateuserpwd(credentials.toString(),uid);		
		}		
		return "redirect:/view/login.jsp";

	}
	//添加账户验证用户名是否已存在	
	@RequestMapping("system/checkUserExsit")
	@ResponseBody
	public Map<String,Object> validateUserName(String userName){
		Map<String,Object> map = new HashMap<>();
		List<Object[]> userslist=yjprojectservice.validateUserName(userName);
		if (userslist.size()==0&&userName.length()>1) {
			map.put("msg", "用户名有效");
			map.put("code",0);
		}else if(userslist.size()!=0&&userName.length()>1){
			map.put("msg", "用户名无效，已存在！");
			map.put("code",1);
		}	
		return map;		
	}

	//修改密码验证输入密码是否与原密码一样	
	@RequestMapping("system/checkPasswordExsit")
	@ResponseBody
	public Map<String,Object> validatepassword(String oldpassword,String userName){
		Map<String,Object> map = new HashMap<>();
		//输入的原密码生成的加密密码
		Object oldcredentials = new SimpleHash("MD5", oldpassword, ByteSource.Util.bytes(userName), 1024);
		Object pwd=yjprojectservice.validateUserpwd(userName);
		if (!pwd.equals(oldcredentials.toString())) {
			map.put("msg", "原密码输入错误");
			map.put("code",0);
		}else if(pwd.equals(oldcredentials.toString())){
			map.put("msg", "原密码输入正确");
			map.put("code",1);
		}	
		return map;		
	}

	/*//修改账户信息时验证当账户是不是正在登陆的账户	
	@RequestMapping("system/checkusersExsit")
	@ResponseBody
	public Map<String,Object> validateusers(String userName){
		Map<String,Object> map = new HashMap<>();

		List<Object[]> userslist=yjprojectservice.validateUserpwd(oldcredentials.toString());
		if (userslist.size()==0&&oldpassword.length()>2) {
			map.put("msg", "原密码输入错误");
			map.put("code",0);
		}else if(userslist.size()!=0&&oldpassword.length()>2){
			map.put("msg", "原密码输入正确");
			map.put("code",1);
		}	
		return map;		
	}*/
}
