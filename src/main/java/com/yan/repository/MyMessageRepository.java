package com.yan.repository;

import com.yan.entity.MyMessage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 闫继龙 on 2017/5/1.
 * 求职者和招聘者消息活动
 */
public interface MyMessageRepository extends CrudRepository<MyMessage,Integer>{

    /**
     * 求职者查看我的申请消息(分页查询)
     * @param hunterID  求职者ID
     * @param pageIndex 分页开始
     * @param pageSize  分页大小
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM my_message WHERE (hunterid = ?1 AND message_type='sendResume') order by message_date desc  LIMIT ?2,?3",nativeQuery = true)
    public List<MyMessage> queryMyApplyByHunterID(int hunterID,int pageIndex,int pageSize);


    /**
     * 求职者查看我的offer
     * @param hunterID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM my_message WHERE (hunterid = ?1 AND message_type='sendInvite') order by message_date desc LIMIT ?2,?3",nativeQuery = true)
    public List<MyMessage> queryMyOfferByHunterID(int hunterID,int pageIndex,int pageSize);

    /**
     * 招聘者查看我的邀请消息
     * @param recruiterID  招聘者ID
     * @param pageIndex 分页开始
     * @param pageSize  分页大小
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM my_message WHERE (recruiterid = ?1 AND message_type='sendInvite') order by message_date desc  LIMIT ?2,?3",nativeQuery = true)
    public List<MyMessage> queryMyInviteByRecruiterID(int recruiterID,int pageIndex,int pageSize);


    /**
     * 招聘者 查看收到的简历
     * @param recruiterID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM my_message WHERE (recruiterid = ?1 AND message_type='sendResume') order by message_date desc  LIMIT ?2,?3",nativeQuery = true)
    public List<MyMessage> queryMyResumeByRecruiterID(int recruiterID,int pageIndex,int pageSize);

}
