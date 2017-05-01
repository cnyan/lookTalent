package com.yan.controller;

import com.alibaba.fastjson.JSONObject;
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
    public ResultMsg createResume(@RequestBody HunterResume hunterResume) {
        //先创建一个简历（null)
        HunterResume resume = new HunterResume();
        resume.setHunterAccountID(hunterResume.getHunterAccountID());
        HunterResume result = hunterCreateResumeRepository.save(resume);

        //保存能力描述
        List<HunterCapacityDesc> hunterCapacityDescs = new ArrayList<>();
        for (HunterCapacityDesc h : hunterResume.getHunterCapacityDescList()) {
            hunterCapacityDescs.add(hunterCreateCapacityDescRepository.save(h));
        }

        //保存教育背景
        List<HunterEducation> hunterEducations = new ArrayList<>();
        for (HunterEducation e : hunterResume.getHunterEducation()) {
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

        ResultMsg resultMsg = new ResultMsg("200", "succeess", null);
        return resultMsg;
    }

    /**
     * 根据求职者账号ID ，查找求职者发布的简历列表
     * @param hunterAccount
     * @return
     */
    @RequestMapping("findwithhunter")
    public ResultMsg findHunterResumeWithHunterAccountId(@RequestBody HunterAccount hunterAccount) {
        return new ResultMsg("200", "succeess", hunterCreateResumeRepository.findHunterResumeByHunterAccountID(hunterAccount.getId()));
    }

    /**
     * 根据简历ID，查看简历详情
     * @param jsonObject
     * @return
     */
    @RequestMapping("findwithresume")
    public ResultMsg findHunterResumeById(@RequestBody JSONObject jsonObject){

        int resumeID = Integer.parseInt(jsonObject.get("resumeID").toString());
        List<HunterResume> hunterResumeList = hunterCreateResumeRepository.findHunterResumeById(resumeID);

        if (hunterResumeList.size() > 0) {

            HunterResume hunterResume = hunterResumeList.get(0);
            return new ResultMsg("200", "succeess", hunterResume);
        }

        return new ResultMsg("4004", "find recruiter position fail", null);
    }

    //查看全部的简历
//    @PostMapping("query/{pageIndex}/{pageSize}")
//    public ResultMsg queryAllHunterResume(@PathVariable  int pageIndex,@PathVariable  int pageSize){
//        return new ResultMsg("200","success",hunterCreateResumeRepository.queryHunterResumesByPageIndex(pageIndex,pageSize));
//    }

    //查看全部的简历
    @RequestMapping("queryall")
    public ResultMsg queryAllHunterResume() {

        return new ResultMsg("200", "success", hunterCreateResumeRepository.findAll());
    }

    //分页查询求职者简历
    @RequestMapping("querypage")
    public ResultMsg queryHunterResumesByPageIndex(@RequestBody JSONObject jsonObject) {
        int pageIndex =  Integer.parseInt(jsonObject.get("pageIndex").toString());
        int pageSize =  Integer.parseInt(jsonObject.get("pageSize").toString());
        System.out.println("pageIndex:" + jsonObject.get("pageIndex") + ",pageSize:" +jsonObject.get("pageSize"));
        return new ResultMsg("200", "success", hunterCreateResumeRepository.queryHunterResumesByPageIndex(pageIndex, pageSize));
    }



}
