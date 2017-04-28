package com.yan.controller;

import com.yan.entity.RecruiterCompanyInfo;
import com.yan.entity.RecruiterInformation;
import com.yan.entity.RecruiterPosition;
import com.yan.entity.RecruiterPositionDesc;
import com.yan.repository.RecruiterCreateCompanyInfoRepository;
import com.yan.repository.RecruiterCreateInformRepository;
import com.yan.repository.RecruiterCreatePositionDescRepository;
import com.yan.repository.RecruiterCreatePositionRepository;
import com.yan.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 招聘者创建职位
 */

@RestController
@RequestMapping("recruiter/position")
public class RecruiterCreatePositionController {
    @Autowired
    private RecruiterCreatePositionRepository createPositionRepository;
    @Autowired
    private RecruiterCreateInformRepository createInformRepository;
    @Autowired
    private RecruiterCreateCompanyInfoRepository createCompanyInfoRepository;
    @Autowired
    private RecruiterCreatePositionDescRepository createPositionDescRepository;


    @RequestMapping("create")
    public ResultMsg createPosition(@RequestBody RecruiterPosition recruiterPosition){

        //先创建一个职位
        RecruiterPosition position = new RecruiterPosition();
        position.setRecruiterAccountID(recruiterPosition.getRecruiterAccountID());
        position = createPositionRepository.save(position);

        //保存职位信息
        RecruiterInformation recruiterInformation = createInformRepository.save(recruiterPosition.getRecruiterInformation());

        //保存公司信息
        RecruiterCompanyInfo recruiterCompanyInfo = createCompanyInfoRepository.save(recruiterPosition.getRecruiterCompanyInfo());

        //保存职位描述
        List<RecruiterPositionDesc> recruiterPositionDescs = new ArrayList<>();
        for (RecruiterPositionDesc desc:recruiterPosition.getRecruiterPositionDescs()) {
            recruiterPositionDescs.add(createPositionDescRepository.save(desc));
        }

        //构建职位
        position.setRecruiterInformation(recruiterInformation);
        position.setRecruiterCompanyInfo(recruiterCompanyInfo);
        position.setRecruiterPositionDescs(recruiterPositionDescs);

        //保存职位
        createPositionRepository.save(position);

        return new ResultMsg("200","success",null);
    }


    @RequestMapping("query")
    public ResultMsg queryAllPosition(){
        return new ResultMsg("200","success",createPositionRepository.findAll());
    }
}
