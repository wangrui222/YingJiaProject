package com.demo.dao.ldd;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.model.UserRole;
import com.demo.model.Users;
/**
 * µÇÂ½ÕËºÅ
 * @author ldd
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>,UsersDao {
	@Modifying
	@Query(value="update Users u set u.users_password=?1 where u.users_id=?2",nativeQuery=true)
	public void updatepassword(String pwd,Integer uid);
	
	@Modifying
	@Query(value="update Users u set u.users_password=?1,u.mobile_phone=?2,u.update_date=?3 where u.users_id=?4",nativeQuery=true)
	public void updatuser(String pwd,String phone,Date update,Integer uid);
}
