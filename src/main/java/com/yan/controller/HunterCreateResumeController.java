package com.yan.controller;

import com.yan.entity.*;
import com.yan.repository.HunterCreateCapacityDescRepository;
import com.yan.repository.HunterCreateEducationRepository;
import com.yan.repository.HunterCreateInformRepository;
import com.yan.repository.HunterCreateResumeRepository;
import com.yan.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultMsg createResum(@RequestBody HunterResume hunterResume){
        HunterResume hunterResume1 = new HunterResume();
        hunterResume1.setHunterAccountID(hunterResume.getHunterAccountID());
        HunterResume  result = hunterCreateResumeRepository.save(hunterResume1);

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
        HunterInformation i = hunterCreateInformRepository.save(hunterResume.getHunterInformation());
        result.setHunterCapacityDescList(hunterCapacityDescs);
        result.setHunterEducation(hunterEducations);
        result.setHunterInformation(i);

        ResultMsg resultMsg = new ResultMsg("200","succeess",hunterCreateResumeRepository.save(result));
        return resultMsg;
    }

    @RequestMapping("find")
    public ResultMsg findHunterResumeWithHunterAccountId(@RequestBody HunterAccount hunterAccount){
        return  new ResultMsg("200","succeess", hunterCreateResumeRepository.findByHunterAccountID(hunterAccount.getId()));
    }
}
