
package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.model.SubjectOrderRecord;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��5��
*��˵��
*/
public interface SubjectOrderRecordRepository extends JpaRepository<SubjectOrderRecord, Integer>,SubjectOrderRecordDao{
	

}
