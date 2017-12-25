package com.demo.dao.wr;

import java.util.List;

import com.demo.model.FinanceProductSubscribe;

public interface FinanceProductSubscribeDao {

	public List<FinanceProductSubscribe> findFinanceProductSubscribe(Integer memberid,Integer page,Integer rowsize);
	
	public Integer getCount(Integer memberid);
}
