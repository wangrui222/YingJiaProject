package com.demo.service.jian;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.demo.dao.jian.SubjectOrderRecordRepository;
import com.demo.model.SubjectOrderRecord;
/**
 * @author thinkpad
 * @time 2017年12月6日上午11:53:29
 */
@Service
public class SubjectOrderRecordServiceImpl implements SubjectOrderRecordService{

	@Autowired
	SubjectOrderRecordRepository subjectOrderRecordRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordService()
	 */
	/**@Override
	public List<SubjectOrderRecord> findSubjectOrderRecordService() {
		List<SubjectOrderRecord> olist=subjectOrderRecordRepository.findAll();
		return olist;
	}
	 */
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#pageSubjectOrderRecordService()
	 */
	@Override
	public Page<SubjectOrderRecord> pageSubjectOrderRecordService(Integer page,Integer size,final SubjectOrderRecord subjectOrderRecord) {
		
		Pageable pageable=new PageRequest(page-1, size);
		Specification<SubjectOrderRecord> specification=new Specification<SubjectOrderRecord>() {
			@Override
			public Predicate toPredicate(Root<SubjectOrderRecord> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> plist=new ArrayList<>();
				if(subjectOrderRecord!=null){
					//订单编号
					if (subjectOrderRecord.getSerialNumber()!=null&&!"".equals(subjectOrderRecord.getSerialNumber())) {
						Path serialNumberPath=root.get("serialNumber");
						plist.add(builder.equal(serialNumberPath, subjectOrderRecord.getSerialNumber()));
					} 
					//手机号

					if(subjectOrderRecord.getMembers()!=null&&!"".equals(subjectOrderRecord.getMembers().getMobilePhone())){
						Join<SubjectOrderRecord, Member> join=root.join("members");
						Path mobilePhonePath=join.get("mobilePhone");
						plist.add(builder.equal(mobilePhonePath,subjectOrderRecord.getMembers().getMobilePhone()));

					}
					//订单状态
					if(subjectOrderRecord.getStatus()!=null&&subjectOrderRecord.getStatus()!=-1){
						Path statusPath=root.get("status");
						plist.add(builder.equal(statusPath,subjectOrderRecord.getStatus()));

					}
					//富友订单
					//订单时间
					/**if(subjectOrderRecord.getCreateDate()!=null&&!"".equals(subjectOrderRecord.getCreateDate())){
						Path createDatepath=root.get("createDate");
						plist.add(builder.equal(createDatepath, subjectOrderRecord.getCreateDate()));

					}*/
				}
				return builder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};
		return subjectOrderRecordRepository.findAll(specification,pageable);
	}
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordById()
	 */
	@Override
	public SubjectOrderRecord findSubjectOrderRecordById(Integer sorId) {
		return subjectOrderRecordRepository.findOne(sorId);
	}

}