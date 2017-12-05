
package com.demo.dao.jian;

import java.util.List;

import javax.persistence.EntityManager;

/**
*@author 作者：
*@version 创建时间：2017年12月5日
*类说明
*/
public class SubjectOrderRecordDaoImpl implements SubjectOrderRecordDao {
     EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.demo.dao.jian.SubjectOrderRecordDao#FindSubjectOrderRecord()
	 */
	@Override
	public List<Object> FindSubjectOrderRecord() {
		String sql="";
		List<Object> olist=entityManager.createNativeQuery(sql).getResultList();
		return olist;
	}


}
