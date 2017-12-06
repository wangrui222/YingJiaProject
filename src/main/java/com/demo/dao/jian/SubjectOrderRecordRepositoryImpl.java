
package com.demo.dao.jian;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
/**
 *@author 作者：
 *@version 创建时间：2017年12月5日
 *类说明
 */
@Repository
public class SubjectOrderRecordRepositoryImpl implements SubjectOrderRecordDao {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.demo.dao.jian.SubjectOrderRecordDao#FindSubjectOrderRecord()
	 */
	@Override
	public List<Object[]> FindSubjectOrderRecord() {
		String sql="select s.*,m.mobile_phone from members m,subject_order_record s where m.member_id=s.member_id";
		List<Object[]> olist=entityManager.createNativeQuery(sql).getResultList();
		return olist;
	}

	


}
