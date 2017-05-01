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

    /**
     * 根据招聘者ID，查看招聘者发布的所有职位
     * @param recruiterAccountID
     * @return
     */
    public List<RecruiterPosition> findPositionByRecruiterAccountID(int recruiterAccountID);

    /**
     * 根据职位ID，查询职位详情信息
     * @param positionID
     * @return
     */
    public List<RecruiterPosition> findRecruiterPositionById(int positionID);

    /**
     * 分页查询职位列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM recruiter_position LIMIT ?1 , ?2",nativeQuery = true)
    public List<RecruiterPosition> queryRecruiterPositionsByPageIndex(int pageIndex,int pageSize);
}
