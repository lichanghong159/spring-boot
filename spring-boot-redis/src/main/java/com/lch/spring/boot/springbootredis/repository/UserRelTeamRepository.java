package com.lch.spring.boot.springbootredis.repository;

import com.lch.spring.boot.springbootredis.entity.UserRelTeam;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/12 11:14
 **/
public interface UserRelTeamRepository extends PagingAndSortingRepository<UserRelTeam,Long> {
    boolean existsByTeamIdAndUserEmail(Long teamId,String userEmail);
    List<UserRelTeam> findAll();
}
