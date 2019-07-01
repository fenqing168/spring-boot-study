package cn.fenqing168.springboot.dao;

import cn.fenqing168.springboot.pojo.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserPojo, Integer> {
}
