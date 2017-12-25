package com.demo.service.lan;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.SubjectPurchaseRecord;
import com.demo.model.UserRole;
import com.demo.model.Users;

public interface YJProjectService {
	//��̨-��Ա����-ȫ���û���ѯ
	public Page<Members> selectmembers(final Members members,Integer page,Integer rowsize);
	//��̨-��Ա����-һ���û���Ϣ��ѯ
	public Members selectonemember(Integer mid);	
	//��̨-��Ա����-һ���û��ʽ��ѯ
	public MemberAccount selectmemberoneaccount(Integer mid);
	//��̨-��Ա����-һ���û����ʦ��ѯ
	public FinancialPlanner selectonefinancialplanner(Integer mid);


	//��̨-��Ա����-һ���û����ֲ�ѯ
	public List<MemberWithdrawRecord> selectoneonememberwithdrawrecord(Integer mid);
	//��̨-��Ա����-һ���û�����Ǯ����ѯ
	public List<MemberTradeRecord> selectoneonemembertraderecord(Integer mid);
	//��̨-��Ա����-һ���û����г�ֵ��¼��ѯ
	public List<MemberDepositRecord> selectonememberdepositrecord(Integer mid);
	/*//��̨-��Ա����-һ���û�����Ͷ�ʼ�¼��ѯ
	public List<SubjectPurchaseRecord> selectonesubjectpurchaserecord(Integer mid);
	 */



	//��̨-��Ա����-���ʦ���
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize);
	//��̨-��Ա����-���ʦ��ѯ����
	public Integer getfinacialplannercount(Map<String, Object> maps);
	//��̨-��Ա����-���ʦ���-�޸�״̬
	public void updatestatus(Integer status,Integer id);



	//��̨-��Ա����-�󿨹���
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize);
	//��̨-��Ա����-�󿨹����ѯ����
	public Integer getselectmemberbankcardsrcount(Map<String, Object> maps);
	//��̨-��Ա����-�󿨹���--�޸�״̬
	public void updatedelflag(Integer delflag,Integer id);


	//��̨-��Ա����-��Ϣ�ƻ�
	public List<Object[]> selectmembersubject(Map<String, Object> maps,Integer page,Integer rowsize);
	//��̨-��Ա����-���ʦ��ѯ����
	public Integer getselectmembersubjectcount(Map<String, Object> maps);
	//��̨-��Ա����-��Ϣ�ƻ�-�����Ϣ
	public List<Object[]> selectmembersubjectBbinpurchaserecord(Integer id,Integer page,Integer rowsize);
	//��̨-��Ա����-�����Ϣ��ѯ����
	public Integer getselectmemberBbinpurchaserecordcount(Integer id);
	//��̨-��Ա����-��Ϣ�ƻ�-�����Ϣ
	public List<Object[]> selectmembersubjectpurchaserecord(Integer id,Integer page,Integer rowsize);
	//��̨-��Ա����-�����Ϣ��ѯ����
	public Integer getselectmemberpurchaserecordcount(Integer id);

	//==========================================================

	//��̨-ϵͳ����-�˻�����-ȫ���û���ѯ
	public List<Object[]> selectuses(Integer page,Integer rowsize);
	//��̨-ϵͳ����-�˻�����-ȫ���û���ѯ����
	public Integer getusercount();
	//��̨-ϵͳ����-�˻�����-ȫ����ɫ��ѯ
	public List<UserRole> selectuserrole();
	//��̨-ϵͳ����-�˻�����-����˺�
	public void adduser(Users user);
	//��̨-ϵͳ����-�˻�����-����˺�ʱ�ж��û���
	public List<Object[]> validateUserName(String uname);
	//��̨-ϵͳ����-�˻�����-��id��ѯһ���˺�
	public Object[] selectoneuserrole(Integer uid);
	public Users findone(Integer uid);
	public Object findpassword(String name);
	public Object finduserid(String name);
	

	//��̨-ϵͳ����-�˻�����-�޸��˺�
	public void updateuser(String pwd,String phone,Date update,Integer uid);
	public void updateuserrole(Integer roleid,Integer uid);
	//��̨-ϵͳ����-�˻�����-ɾ���˺�
	public void deleteuser(Integer uid);


	//��̨-ϵͳ����-��ɫ����-��ӽ�ɫ
	public void adduserrole(UserRole userrole);
	//��̨-ϵͳ����-��������-�޸�����
	public void updateuserpwd(String pwd,Integer uid);
	//��̨-ϵͳ����-�˻�����-�޸��˺�ʱ�ж������Ƿ���
	public List<Object[]> validateUserpwd(String pwd);








}
