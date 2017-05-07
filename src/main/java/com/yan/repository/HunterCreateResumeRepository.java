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
     * 根据求职者账号ID ，查找求职者发布的简历列表
     * @param hunterAccountID
     * @return
     */
    public List<HunterResume> findHunterResumeByHunterAccountID(int hunterAccountID);


    /**
     * 根据简历ID，查看简历详情
     * @param resumeID
     * @return
     */
    public List<HunterResume> findHunterResumeById(int resumeID);


    /**
     * 分页查询简历
     * @param pageIndex 起始页面
     * @param pageSize  页面长度
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM hunter_resume ORDER BY rand() LIMIT ?1 , ?2",nativeQuery = true)
    public List<HunterResume> queryHunterResumesByPageIndex(int pageIndex,int pageSize);



}
