package com.demo.service.lan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ldd.FinancialplannerDao;
import com.demo.dao.ldd.MemberaccountDao;
import com.demo.dao.ldd.MemberpucchargeitemDao;
import com.demo.dao.ldd.MembersDao;
import com.demo.dao.ldd.MemberwithdrawrecordDao;
import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
@Service
public class YJProjectServiceImpl implements YJProjectService{
	@Autowired
	MembersDao memberdao;
	@Autowired
	MemberaccountDao memberaccountdao;
	@Autowired
	FinancialplannerDao financialplannerdao;
	@Autowired
	MemberwithdrawrecordDao memeberwithdrawrecorddao;
	@Autowired
	MemberpucchargeitemDao memberpucchargeitemdao;
	
	
	//��̨-��Ա����-ȫ���û���ѯ
	@Override
	public List<Members> selectmembers() {
		
		return memberdao.findAll();
	}
	//��̨-��Ա����-һ���û���Ϣ��ѯ
	@Override
	public Members selectonemember(Integer mid) {
		return memberdao.findOne(mid);
	}
	//��̨-��Ա����-һ���û��ʽ��ѯ
	@Override
	public MemberAccount selectmemberoneaccount(Integer mid) {
		
		return memberaccountdao.findOne(mid);
	}
	//��̨-��Ա����-һ���û����ʦ��ѯ
	@Override
	public FinancialPlanner selectonefinancialplanner(Integer mid) {
		return financialplannerdao.findOne(mid);
	}
	//��̨-��Ա����-һ���û����ֲ�ѯ
	@Override
	public MemberWithdrawRecord selectoneonememberwithdrawrecord(Integer mid) {
		return memeberwithdrawrecorddao.findOne(mid);
	}
	//��̨-��Ա����-һ���û�Ǯ����ѯ
	@Override
	public MemberPucChargeItem selectoneonememberpucchargeitem(Integer mid) {		
		return memberpucchargeitemdao.findOne(mid);
	}
	
	

}
