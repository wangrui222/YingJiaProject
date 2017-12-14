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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.dao.wr.FinanceProductFundsRepository;
import com.demo.model.FinanceProductFunds;
import com.demo.service.wr.FinanceProductFundService;

@Service
public class FinanceProductFundServiceImpl implements FinanceProductFundService {

	@Autowired
	FinanceProductFundsRepository financeProductFundsRepository;

	@Override
	public Page<FinanceProductFunds> selectGuShouAndGuQuan(final String name, Integer page,
			Integer rowsize) {
		Pageable pageable= new PageRequest(page-1, rowsize);
		Specification<FinanceProductFunds> specification=new Specification<FinanceProductFunds>() {
			@Override
			public Predicate toPredicate(Root<FinanceProductFunds> paramRoot, CriteriaQuery<?> paramCriteriaQuery,
					CriteriaBuilder builder) {
				List<Predicate>  plist = new ArrayList<Predicate>();

				Path financeProductFundsType = paramRoot.get("financeProductFundsType");
				plist.add(builder.equal(financeProductFundsType,name));
				return builder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};
		return financeProductFundsRepository.findAll(specification, pageable);
	}

}
