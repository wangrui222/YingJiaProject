package com.demo.service.lan;

import java.util.List;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.Members;

public interface YJProjectService {
	//��̨-��Ա����-ȫ���û���ѯ
	public List<Members> selectmembers();
	//��̨-��Ա����-һ���û���Ϣ��ѯ
	public Members selectonemember(Integer mid);	
	//��̨-��Ա����-һ���û��ʽ��ѯ
	public MemberAccount selectmemberoneaccount(Integer mid);
	//��̨-��Ա����-һ���û����ʦ��ѯ
	public FinancialPlanner selectonefinancialplanner(Integer mid);
}
