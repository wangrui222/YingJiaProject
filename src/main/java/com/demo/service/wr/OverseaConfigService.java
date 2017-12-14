package com.demo.service.wr;

import org.springframework.data.domain.Page;

import com.demo.model.OverseaConfig;

public interface OverseaConfigService {
	
	public Page<OverseaConfig> selectOversea(Integer page, Integer rowsize);

}
