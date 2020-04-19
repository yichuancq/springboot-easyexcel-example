package com.example.repostiory.user;


import com.example.model.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author yichuan
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>,
        JpaSpecificationExecutor<UserInfo> {
}
