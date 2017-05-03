package com.yan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yan.entity.MyMessage;
import com.yan.repository.MyMessageRepository;
import com.yan.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 闫继龙 on 2017/5/1.
 * * 我的消息
 * 对应关系：
 *  1.求职者发送简历sendResume对应（求职者我的申请，招聘者收到简历消息）
 *  2.招聘者发送邀请sendInvite对应（求职者我的offer，招聘者我的邀请消息）
 */
@RestController
@RequestMapping(value = "message")
public class MyMessageController {
    @Autowired
    private MyMessageRepository messageRepository;

    /**
     * 求职者发送简历,messageType=sendResume,name对应公司名称
     * @param myMessage
     * @return
     */
    @RequestMapping(value = "send/action")
    public ResultMsg hunterSendResume(@RequestBody MyMessage myMessage){

        if (!(myMessage.getMessageType().equals("sendResume")||myMessage.getMessageType().equals("sendInvite"))){
            return new ResultMsg("4004","the messageType must be  sendResume or sendInvite",null);
        }
        messageRepository.save(myMessage);
        return new ResultMsg("200","send resume success",null);
    }

    /**
     * 查询所有消息
     * @return
     */
    @RequestMapping(value = "query/allmessage")
    public ResultMsg queryAllMessage(){
        return new ResultMsg("200","success",messageRepository.findAll());
    }

    /**
     * 求职者查看我的申请消息(分页查询)
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "my/apply")
    public ResultMsg queryMyApplyMessage(@RequestBody JSONObject jsonObject){

        int hunterID = Integer.parseInt(jsonObject.get("hunterID").toString());
        int pageIndex = Integer.parseInt(jsonObject.get("pageIndex").toString());
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());


        return new ResultMsg("200","success" ,
                messageRepository.queryMyApplyByHunterID(hunterID,pageIndex,pageSize));
    }

    /**
     * 求职者查看我的offer
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "my/offer")
    public ResultMsg queryMyOfferMessage(@RequestBody JSONObject jsonObject){

        int hunterID = Integer.parseInt(jsonObject.get("hunterID").toString());
        int pageIndex = Integer.parseInt(jsonObject.get("pageIndex").toString());
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());


        return new ResultMsg("200","success" ,
                messageRepository.queryMyOfferByHunterID(hunterID,pageIndex,pageSize));
    }


    /**
     * 招聘者查看我的邀请消息（分页查询）
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "my/invite")
    public ResultMsg queryMyInviteMessage(@RequestBody JSONObject jsonObject){

        int recruiterID = Integer.parseInt(jsonObject.get("recruiterID").toString());
        int pageIndex = Integer.parseInt(jsonObject.get("pageIndex").toString());
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());


        return new ResultMsg("200","success" ,
                messageRepository.queryMyInviteByRecruiterID(recruiterID,pageIndex,pageSize));
    }

    /**
     * 招聘者查看 收到简历消息
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "my/resume")
    public ResultMsg queryMyResumeMessage(@RequestBody JSONObject jsonObject){

        int recruiterID = Integer.parseInt(jsonObject.get("recruiterID").toString());
        int pageIndex = Integer.parseInt(jsonObject.get("pageIndex").toString());
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());


        return new ResultMsg("200","success" ,
                messageRepository.queryMyResumeByRecruiterID(recruiterID,pageIndex,pageSize));
    }



}
