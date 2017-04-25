package com.yan.repository;

import com.yan.entity.HunterResume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/25.
 *
 */
public interface HunterCreateResumeRepository extends CrudRepository<HunterResume,Integer>{

    public List<HunterResume> findByHunterAccountID(int hunterAccountID);

}
