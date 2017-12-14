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

import com.demo.dao.wr.OverseaConfigRepository;
import com.demo.model.OverseaConfig;
import com.demo.service.wr.OverseaConfigService;

@Service
public class OverseaConfigServiceImpl implements OverseaConfigService {

	@Autowired
	OverseaConfigRepository overseaConfigRepository;
	//"FROM OverseaConfig c WHERE c.status != 0 order by c.sortcolum desc,c.addtime desc"

	@Override
	public Page<OverseaConfig> selectOversea(Integer page, Integer rowsize) {

		Order order1 = new Order(Direction.DESC, "sortcolum");
		Order order2 = new Order(Direction.DESC, "addtime");
		List<Order> list = new ArrayList<>();
		list.add(order2);
		list.add(order1);
		Sort sort = new Sort(list);

		Pageable pageable = new PageRequest(page-1, rowsize, sort);


		Specification<OverseaConfig> paramSpecification = new Specification<OverseaConfig>() {

			@Override
			public Predicate toPredicate(Root<OverseaConfig> paramRoot, CriteriaQuery<?> paramCriteriaQuery,
					CriteriaBuilder paramCriteriaBuilder) {
				Path p = paramRoot.get("status");
				return paramCriteriaBuilder.notEqual(p, 0);
			}
		};
		return overseaConfigRepository.findAll(paramSpecification , pageable);
	}

}
