package com.yan.repository;

import com.yan.entity.HunterResume;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/25.
 * 求职者操作简历repository
 */
public interface HunterCreateResumeRepository extends CrudRepository<HunterResume,Integer>{

    /**
     * 根据账号查找求职者账号
     * @param hunterAccountID
     * @return
     */
    public List<HunterResume> findHunterResumeByHunterAccountID(int hunterAccountID);

    /**
     * 分页查询简历
     * @param pageIndex 起始页面
     * @param pageSize  页面长度
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM hunter_resume LIMIT ?1 , ?2",nativeQuery = true)
    public List<HunterResume> queryHunterResumesByPageIndex(int pageIndex,int pageSize);

}
