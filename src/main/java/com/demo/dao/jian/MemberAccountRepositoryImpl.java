package com.demo.dao.jian;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.demo.model.AwardRecords;
import com.demo.model.MemberAccount;
import com.demo.model.Members;

public class MemberAccountRepositoryImpl implements MemberAccountDao{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Object[]> findall(Integer page,Integer size,Members members,MemberAccount memberAccount,AwardRecords awardRecords) {
		String sql="select * from ( select cc.* , rownum as rid from (select m.mobile_phone,m.member_name,"
				+ "m.invitationcode,m.invitedcode,a.invest_amount,m.status,aw.isaward,aw.addtime,m.member_id,aw.invitingid "
				+ "from members m,member_account a,award_records aw where m.member_id=a.member_id and m.member_id=aw.invitingid"
				+") cc  where 1=1";
		//ÐÕÃû
		if(members.getMemberName()!=null&&!"".equals(members.getMemberName())){
			sql+="  and cc.member_name like '%"+members.getMemberName()+"%'";

		}
		//ÊÖ»úºÅ
		if(members.getMobilePhone()!=null&&!"".equals(members.getMobilePhone())){
			sql+=" and cc.mobile_phone="+members.getMobilePhone()+"";

		}
		//ÑûÇëÂë
		if(members.getInvitationcode()!=null&&!"".equals(members.getInvitationcode())){
			sql+=" and cc.invitationcode like '"+members.getInvitationcode()+"%'";
		}
		//±»ÑûÇëÂë
		if (members.getInvitedcode()!=null&&!"".equals(members.getInvitedcode())) {
			sql+=" and cc.invitedcode like '"+members.getInvitedcode()+"%'";
		}
		//ÊÇ·ñ×¢²á½±Àø
        if (awardRecords.getAwardRecordsType()!=null&&!"".equals(awardRecords.getAwardRecordsType())) {
			sql+=" and cc.Award_Records_Type ="+awardRecords.getAwardRecordsType()+"";
		}
	
		sql+=" and rownum <= "+page+"*"+size+" )where rid >"+size+"*("+page+"-1) ";
		List<Object[]> mlist=entityManager.createNativeQuery(sql).getResultList();
		return mlist;
	}
	@Override
	public Integer selectCount(MemberAccount memberAccount, Members members, AwardRecords awardRecords) {
		String sql="select count(*) from (select m.mobile_phone,m.member_name,"
				+ "m.invitationcode,m.invitedcode,a.invest_amount,aw.award_records_type,aw.isaward,aw.addtime "
				+ "from members m,member_account a,award_records aw where m.member_id=a.member_id and m.member_id=aw.invitingid) where 1=1";
		Integer count =Integer.parseInt(entityManager.createNativeQuery(sql).getSingleResult().toString());

		return count;
	}
	@Override
	public List<Object[]> findAwardRecords(Integer memberId) {
		String sql="select c.mobile_phone,c.award_records_type,c.amount,c.add_time  from"+

"(select * from members m,award_records a where m.member_id=a.invitingid ) c  where member_id="+memberId+"";
		List<Object[]> mlist=entityManager.createNativeQuery(sql).getResultList();

		return mlist;
	}
	@Override
	public List<Object[]> findRecords(Integer memberId) {
		String sql="select distinct c.mobile_phone,c.invitationcode from"+

    "(select * from members m,award_records a where m.member_id=a.invitingid ) b inner join"+

    "(select * from members m,award_records aw where  m.member_id=aw.byinvitingid) c on b.award_records_id=c.award_records_id  where c.member_id="+memberId+"";
		List<Object[]> o=entityManager.createNativeQuery(sql).getResultList();
		return o;
	}

}
