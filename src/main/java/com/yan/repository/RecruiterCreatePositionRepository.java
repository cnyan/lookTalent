package com.yan.repository;

import com.yan.entity.RecruiterPosition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 招聘者操作职位repository
 */
public interface RecruiterCreatePositionRepository extends CrudRepository<RecruiterPosition,Integer> {

    //根据招聘者ID，查看职位《列表》
    public List<RecruiterPosition> findPositionByRecruiterAccountID(int recruiterAccountID);


    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM recruiter_position LIMIT ?1 , ?2",nativeQuery = true)
    public List<RecruiterPosition> queryRecruiterPositionsByPageIndex(int pageIndex,int pageSize);
}
