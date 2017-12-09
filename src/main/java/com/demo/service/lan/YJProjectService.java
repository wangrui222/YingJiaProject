package com.demo.service.lan;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;

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
	public MemberWithdrawRecord selectoneonememberwithdrawrecord(Integer mid);
	//��̨-��Ա����-һ���û�Ǯ����ѯ
	public MemberTradeRecord selectoneonemembertraderecord(Integer mid);




	//��̨-��Ա����-���ʦ���
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize);
	//��̨-��Ա����-���ʦ��ѯ����
	public Integer getfinacialplannercount(Map<String, Object> maps);

	//��̨-��Ա����-���ʦ���
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize);

	//��̨-��Ա����-���ʦ��ѯ����
	public Integer getselectmemberbankcardsrcount(Map<String, Object> maps);

}
