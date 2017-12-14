package com.demo.dao.wr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>,SubjectDao,JpaSpecificationExecutor<Subject> {
	

	/*@Query(value="FROM SUBJECT s where s.status!=0")
	public List<Subject> getGushouList();*/
	
	@Query("FROM Subject s WHERE s.subjectId = ?")
	public Subject getGushouGouMai(Integer subjectId);
	

	
	
	
	
	/**
	 * @Query(value="SELECT s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status,"
			+"(COALESCE(SUM(r.amount),0)+ (SELECT COALESCE(SUM(sb.amount),0) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id)) hasSold," 
			+"(COUNT(r.spr_id)+s.bought+(SELECT COUNT(sb.sbpr_id) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id) ) hasBought "
			+"FROM SUBJECT s LEFT JOIN subject_purchase_record r ON s.subject_id = r.subject_id where s.status!=0 GROUP BY  s.subject_id,s.subject_name"
			+",s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status "
	 * 
	 * 
	 * 
	 * 
		select id, serial_number, serial_no, name, type, status, floor_amount, amount, first_id, parent_id, period, purpose, raise_start, raise_end, refund_way, safeGuard_way, start_date, end_date, year_rate, comment,folder_id, delflag, update_date, create_date,borrowername,borrowerid,bought,projectDetails,safetyControl,exper_status from subject where id = ? 

		SELECT COALESCE (SUM(amount),0) sumamount FROM `subject_purchase_record` WHERE subject_id=?  
		
		select id, subject_id, field_id, field_value, delflag, create_date, update_date from subject_field_record where subject_id=? 

		select count(*) from (SELECT pr.*,m.`name` FROM `subject_purchase_record` pr,`member` m WHERE pr.`member_id`=m.`id` AND subject_id=? group by create_date desc) tmp_count

		SELECT pr.*,m.`name` FROM `subject_purchase_record` pr,`member` m WHERE pr.`member_id`=m.`id` AND subject_id=? group by create_date desc 
			
	 */

}
//subject_purchase_record subject_field_record subject














			
			
			
			
			
			
			
			
			
			
			
