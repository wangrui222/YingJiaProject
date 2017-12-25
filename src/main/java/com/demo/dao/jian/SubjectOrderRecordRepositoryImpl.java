package com.demo.dao.jian;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.demo.model.MemberDepositRecord;
import com.demo.model.Members;

public class SubjectOrderRecordRepositoryImpl implements SubjectOrderDao{
	@PersistenceContext
    EntityManager entityManager;
	@Override
	public List<Object[]> selectMemberDepositRecord( Integer page,Integer size,Members members,MemberDepositRecord memberDepositRecord) {
		String sql="select * from ( select a.* , rownum as rid from ( select m.member_id,m.serial_number,me.mobile_phone,m.amount,"
				+ "m.status,m.pay_channel_name,m.pay_channel_order_no,m.create_date from member_deposit_record m,members me where me.member_id=m.member_id"
                +") a where 1=1";
		
		//流水号
		if (memberDepositRecord.getSerialNumber()!=null&&!"".equals(memberDepositRecord.getSerialNumber())) {
			sql+=" and a.serial_number = "+memberDepositRecord.getSerialNumber()+"";
		}
		//手机号
		if (members.getMobilePhone()!=null&&!"".equals(members.getMobilePhone())) {
			sql=" and a.mobile_phone ="+members.getMobilePhone()+"";
		}
		//订单状态
		if (memberDepositRecord.getStatus()!=null&&memberDepositRecord.getStatus()!=-1) {
			sql=" and  a.status ="+memberDepositRecord.getStatus()+"";
		}
		//富有订单
		if (memberDepositRecord.getPayChannelOrderNo()!=null&&!"".equals(memberDepositRecord.getPayChannelOrderNo())) {
			sql+=" and a.pay_channel_order_no ="+memberDepositRecord.getPayChannelOrderNo()+"";
		}
		
		//创建时间
		sql+=" and rownum <= "+page+"*"+size+" )where rid >"+size+"*("+page+"-1) ";
		
		List<Object[]> mlist=(List<Object[]>) entityManager.createNativeQuery(sql).getResultList();
		
		return mlist;
	}
	@Override
	public Integer selectCount(MemberDepositRecord memberDepositRecord, Members members) {
		String sql="select count(*) from (select m.member_id,m.serial_number,me.mobile_phone,m.amount,"
				+ "m.status,m.pay_channel_name,m.pay_channel_order_no,m.create_date from member_deposit_record m,members me where me.member_id=m.member_id) where 1=1";
		
			//流水号
			if (memberDepositRecord.getSerialNumber()!=null&&!memberDepositRecord.getSerialNumber().equals("")) {
				sql+=" and a.serial_number = "+memberDepositRecord.getSerialNumber()+"";
			}
			//手机号
			if (members.getMobilePhone()!=null&&!members.getMobilePhone().equals("")) {
				sql=" and a.mobile_phone ="+members.getMobilePhone()+"";
			}
			//订单状态
			if (memberDepositRecord.getStatus()!=null&&memberDepositRecord.getStatus()!=-1) {
				sql=" and  a.status ="+memberDepositRecord.getStatus()+"";
			}
			//富有订单
			if (memberDepositRecord.getPayChannelOrderNo()!=null&&!memberDepositRecord.getPayChannelOrderNo().equals("")) {
				sql+=" and a.pay_channel_order_no ="+memberDepositRecord.getPayChannelOrderNo()+"";
			}
		 
	
		Integer count=Integer.parseInt(entityManager.createNativeQuery(sql).getSingleResult().toString()) ;
		return count;
}}
