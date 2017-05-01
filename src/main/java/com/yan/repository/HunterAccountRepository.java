package com.yan.repository;

import com.yan.entity.HunterAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/22.
 * 求职者操作账号repository
 */
public interface HunterAccountRepository extends CrudRepository<HunterAccount,Integer>{

    /**
     * 根据求职者账号和密码查询求职者
     * @param recruiter_account
     * @param passwordMD5 密码经过md5加密处理
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM recruiter_account WHERE recruiter_account = ?1 AND password = ?2",nativeQuery = true)
    public List<HunterAccount> loginToApp(String recruiter_account, String passwordMD5);


    //根据账号，查找用户
    public List<HunterAccount> findHunterAccountByHunterAccount(String hunterAccount);


}
