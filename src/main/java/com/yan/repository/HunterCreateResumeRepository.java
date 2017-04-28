package com.yan.repository;

import com.yan.entity.HunterResume;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/25.
 *
 */
public interface HunterCreateResumeRepository extends CrudRepository<HunterResume,Integer>{

    public List<HunterResume> findByHunterAccountID(int hunterAccountID);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM hunter_resume LIMIT ?1 , ?2",nativeQuery = true)
    public List<HunterResume> queryHunterResumesByPageIndex(int pageIndex,int pageSize);

}
