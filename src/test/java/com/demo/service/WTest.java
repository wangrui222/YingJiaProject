package com.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.jian.MemberWithdrawRecordRepository;
import com.demo.dao.wr.SubjectRepository;
import com.demo.model.MemberWithdrawRecord;
import com.demo.service.wr.MemberAmountService;

import junit.framework.TestCase;

public class WTest extends TestCase {

	public void test05(){
		Object credentials = new SimpleHash("MD5", "123456", ByteSource.Util.bytes("admin"), 1024);
		System.out.println(credentials.toString().contentEquals("038bdaf98f2037b31f1e75b5b4c9b26e"));
	}

	public void test(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
		SubjectRepository memberRepository =(SubjectRepository) app.getBean("subjectRepository");
		System.out.println(memberRepository.getGushouGouMai(1638).length);
		//MemberService memberService = app.getBean(MemberService.class);
		//System.out.println(memberRepository.findMemberAll(1));
		//memberService.addMemberYanZheng(1, "wangui", "123");
		//System.out.println(memberwithdrawrecordRepository.selectMemberWithdrawRecord(2));
		//List<Object[]> object = productRepository.getGushouList();
		//Float subjectPurchaseRecord = productRepository.getSumamount();
		//	System.out.println(subjectPurchaseRecord);
	}

	
	public void test08(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberAmountService memberAccountRepository =(MemberAmountService) app.getBean("memberAmountService");
		memberAccountRepository.updateMA(1, 1);
	}
	
	public void test07(){
		Calendar  c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 15);
		System.out.println(c.getTime());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(c.getTime());
		System.out.println(date);
	}

	public void test04(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
		SubjectRepository fPFundsRepository = (SubjectRepository) app.getBean("subjectRepository");
		//List<OverseaConfig> object = fPFundsRepository.getOverseaList();
		List<Object[]> ojb= fPFundsRepository.findTouZiJiLu(1, 1, 5);
		System.out.println(ojb);
	}
	public void test06(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberWithdrawRecordRepository fPFundsRepository = (MemberWithdrawRecordRepository) app.getBean("memberWithdrawRecordRepository");
		List<MemberWithdrawRecord> object = fPFundsRepository.getMemberWithdrawRecord(1, 1, 4);
		System.out.println(object);
	}


	public void test02(){
		List<Object[]> list = new ArrayList<>();
		Object[] object01 = {1,2,3,4};
		Object[] object02 = {5,6,7,8};
		Object[] object03 = {13,12,11,10};
		list.add(object03);
		list.add(object02);
		list.add(object01);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)[0]+"=="+list.get(i)[1]+"=="+list.get(i)[2]);

		}
	}
	/*String sql = "SELECT s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status,"
				+"(COALESCE(SUM(r.amount),0)+ (SELECT COALESCE(SUM(sb.amount),0) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id)) as 'hasSold'," 
				+"(COUNT(r.spr_id)+s.bought+(SELECT COUNT(sb.sbpr_id) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id) )  as 'hasBought'"
				+"FROM SUBJECT s LEFT JOIN subject_purchase_record r ON s.subject_id = r.subject_id where s.status!=0 GROUP BY  s.subject_id,s.subject_name"
				+",s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status "
				+" order by s.create_date desc,s.status ";
		Sort sort = new Sort(Direction.DESC, "s.create_date");
		//Sort sort1 = new Sort(Direction.ASC, "s.status");
		//sort.and(sort1);
		Pageable pageable = new PageRequest(1-1, 5, sort);
		Page<Subject> page = productRepository.findAll(pageable);*/
}
