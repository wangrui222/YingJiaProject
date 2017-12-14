package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.ldd.MemberwithdrawrecordRepository;
import com.demo.dao.wr.OverseaConfigRepository;
import com.demo.model.OverseaConfig;

import junit.framework.TestCase;

public class WTest extends TestCase {

	public void test05(){
		System.out.println("038bdaf98f2037b31f1e75b5b4c9b26e"=="038bdaf98f2037b31f1e75b5b4c9b26e");
	}

	public void test(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberwithdrawrecordRepository memberwithdrawrecordRepository = (MemberwithdrawrecordRepository) app.getBean("memberwithdrawrecordRepository");
		System.out.println(memberwithdrawrecordRepository.selectMemberWithdrawRecord(2));
		//List<Object[]> object = productRepository.getGushouList();
		//Float subjectPurchaseRecord = productRepository.getSumamount();
		//	System.out.println(subjectPurchaseRecord);
	}


	public void test04(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
		OverseaConfigRepository fPFundsRepository = (OverseaConfigRepository) app.getBean("overseaConfigRepository");
		//List<OverseaConfig> object = fPFundsRepository.getOverseaList();
		OverseaConfig object = fPFundsRepository.getOverSeaGouMai(2);
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
