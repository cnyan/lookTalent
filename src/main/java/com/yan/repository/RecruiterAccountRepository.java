package com.yan.repository;

import com.yan.entity.RecruiterAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 招聘者操作账号repository
 */
public interface RecruiterAccountRepository extends CrudRepository<RecruiterAccount,Integer> {

}
