package com.yan.repository;

import com.sun.org.apache.regexp.internal.RE;
import com.yan.entity.RecruiterAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 招聘者操作账号repository
 */
public interface RecruiterAccountRepository extends CrudRepository<RecruiterAccount,Integer> {

    /**
     * 根据招聘者账号和密码查询求职者
     * @param recruiterAccount
     * @param passwordMD5 密码经过md5加密处理
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM recruiter_account WHERE recruiter_account = ?1 AND password = ?2",nativeQuery = true)
    public List<RecruiterAccount> loginToApp(String recruiterAccount, String passwordMD5);

    /**
     * 根据账号查找招聘者
     * @param recruiterAccount
     * @return
     */
    public List<RecruiterAccount> findRecruiterAccountByRecruiterAccount(String recruiterAccount);
}
