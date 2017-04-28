package com.yan.controller;

import com.yan.entity.*;
import com.yan.repository.HunterCreateCapacityDescRepository;
import com.yan.repository.HunterCreateEducationRepository;
import com.yan.repository.HunterCreateInformRepository;
import com.yan.repository.HunterCreateResumeRepository;
import com.yan.utils.PageSizeUtil;
import com.yan.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/25.
 *
 */
@RestController
@RequestMapping("hunter/resume")
public class HunterCreateResumeController {

    @Autowired
    private HunterCreateResumeRepository hunterCreateResumeRepository;

    @Autowired
    private HunterCreateInformRepository hunterCreateInformRepository;
    @Autowired
    private HunterCreateEducationRepository hunterCreateEducationRepository;
    @Autowired
    private HunterCreateCapacityDescRepository hunterCreateCapacityDescRepository;

    @RequestMapping("create")
    public ResultMsg createResume(@RequestBody HunterResume hunterResume){
        //先创建一个简历（null)
        HunterResume resume = new HunterResume();
        resume.setHunterAccountID(hunterResume.getHunterAccountID());
        HunterResume  result = hunterCreateResumeRepository.save(resume);

        //保存能力描述
        List<HunterCapacityDesc> hunterCapacityDescs = new ArrayList<>();
        for (HunterCapacityDesc h:hunterResume.getHunterCapacityDescList()){
            hunterCapacityDescs.add(hunterCreateCapacityDescRepository.save(h));
        }

        //保存教育背景
        List<HunterEducation> hunterEducations = new ArrayList<>();
        for (HunterEducation e:hunterResume.getHunterEducation()){
            hunterEducations.add(hunterCreateEducationRepository.save(e));
        }

        //保存个人信息
        HunterInformation information = hunterCreateInformRepository.save(hunterResume.getHunterInformation());

        //构建简历
        result.setHunterCapacityDescList(hunterCapacityDescs);
        result.setHunterEducation(hunterEducations);
        result.setHunterInformation(information);

        //保存个人简历
        hunterCreateResumeRepository.save(result);

        ResultMsg resultMsg = new ResultMsg("200","succeess",null);
        return resultMsg;
    }

    //根据求职者ID ，查看求职者简历信息(列表）
    @RequestMapping("find")
    public ResultMsg findHunterResumeWithHunterAccountId(@RequestBody HunterAccount hunterAccount){
        return  new ResultMsg("200","succeess", hunterCreateResumeRepository.findByHunterAccountID(hunterAccount.getId()));
    }

    //查看全部的简历
    @PostMapping("query/{pageIndex}/{pageSize}")
    public ResultMsg queryAllHunterResum(@PathVariable  int pageIndex,@PathVariable  int pageSize){
        return new ResultMsg("200","success",hunterCreateResumeRepository.queryHunterResumesByPageIndex(pageIndex,pageSize));
    }


}
