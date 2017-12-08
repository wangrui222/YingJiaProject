package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.model.Members;
/**
 * ÕËºÅ¼ÇÂ¼
 * @author ldd
 *
 */
public interface MembersRepository extends JpaRepository<Members, Integer>,JpaSpecificationExecutor<Members>,MembersDao {

}
