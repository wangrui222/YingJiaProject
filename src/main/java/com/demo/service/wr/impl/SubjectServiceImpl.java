package com.demo.service.wr.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.dao.wr.SubjectRepository;
import com.demo.model.Subject;
import com.demo.service.wr.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Page<Subject> selectSubject(final Subject subject, Integer page, Integer rowsize) {
		Order order1 = new Order(Direction.DESC, "createDate");  
		Order order2 = new Order(Direction.ASC,"status");
		List<Order> orderlist = new ArrayList<>();
		orderlist.add(order1);
		orderlist.add(order2);
		Sort sort = new Sort(orderlist);
		Pageable pageable= new PageRequest(page-1, rowsize,sort);
		Specification<Subject> specification=new Specification<Subject>() {
			@Override
			public Predicate toPredicate(Root<Subject> paramRoot, CriteriaQuery<?> paramCriteriaQuery,
					CriteriaBuilder builder) {
				List<Predicate> plist = new ArrayList<Predicate>();
				Path subjectType = paramRoot.get("subjectType");
				Path yearRate = paramRoot.get("yearRate");
				Path period = paramRoot.get("period");
				Path status = paramRoot.get("status");
				//标的类型
				if(subject.getSubjectType() == 0) plist.add(builder.equal(subjectType,0));
				if(subject.getSubjectType() == 1) plist.add(builder.equal(subjectType,1));
				//年化收益
				if(subject.getYearRate() == 6) plist.add(builder.equal(yearRate,6));
				if(subject.getYearRate() == 7) plist.add(builder.equal(yearRate,7));
				if(subject.getYearRate() == 7.5) plist.add(builder.equal(yearRate,7.5));
				if(subject.getYearRate() == 8) plist.add(builder.equal(yearRate,8));
				if(subject.getYearRate() == 9) plist.add(builder.gt(yearRate,8));
				//项目期限
				if(subject.getPeriod() == 15) plist.add(builder.le(period,15));
				if(subject.getPeriod() == 30){
					List<Predicate> periods = new ArrayList<Predicate>();
					periods.add(builder.gt(period,15));
					periods.add(builder.le(period, 30));
					plist.addAll(periods);
				}
				if(subject.getPeriod() == 180){
					List<Predicate> periods = new ArrayList<Predicate>();
					periods.add(builder.gt(period,30));
					periods.add(builder.le(period, 180));
					plist.addAll(periods);
				}
				if(subject.getPeriod() == 365){
					List<Predicate> periods = new ArrayList<Predicate>();
					periods.add(builder.gt(period,180));
					periods.add(builder.le(period, 365));
					plist.addAll(periods);
				}
				if(subject.getPeriod() == 366) plist.add(builder.gt(period,365));
				
				//标的状态：
				if(subject.getStatus() == 1) plist.add(builder.equal(status, 1));
				if(subject.getStatus() == 2) plist.add(builder.equal(status, 2));
				if(subject.getStatus() == 3) plist.add(builder.equal(status, 3));
				
				
				
				
				return builder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};
		return subjectRepository.findAll(specification, pageable);
	}

}
