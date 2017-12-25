package com.demo.dao.wr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.MemberDepositRecord;
/**
 * ³äÖµ¼ÇÂ¼
 * @author admin
 *
 */
public interface MemberDepositRecordRepository extends JpaRepository<MemberDepositRecord, Integer>,MemberDepositRecordRepositoryDao{

	
	@Modifying
	@Query(value="update Member_Deposit_Record set status=1,PAY_CHANNEL_ORDER_NO= :trade_no,UPDATE_DATE=sysdate where SERIAL_NUMBER= :out_trade_no",nativeQuery=true)
	public void updateMemberDepositRecord(@Param("out_trade_no")String out_trade_no,@Param("trade_no")String trade_no);

	
	@Query("select m.memberId From MemberDepositRecord m where m.serialNumber = ?")
	public Integer selectMemberId(String out_trade_no);


	
}
