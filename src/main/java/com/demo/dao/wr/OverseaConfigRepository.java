package com.demo.dao.wr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.OverseaConfig;

public interface OverseaConfigRepository extends JpaRepository<OverseaConfig, Integer>,JpaSpecificationExecutor<OverseaConfig>{

	//@Query("FROM OverseaConfig c WHERE c.status != 0 order by c.sortcolum desc,c.addtime desc")
	//public List<OverseaConfig> getOverseaList();
	
	
	@Query("FROM OverseaConfig oc WHERE oc.ocId=?")
	public OverseaConfig getOverSeaGouMai(Integer ocid);
	
	

}
