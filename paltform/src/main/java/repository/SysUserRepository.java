package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Integer>{
	SysUser findById(Integer id);
	
	@Query(value="select * from platform.sys_user where user_name=:username and password=:password")
	SysUser findByUsernameAndPassword(String username, String password);
}
