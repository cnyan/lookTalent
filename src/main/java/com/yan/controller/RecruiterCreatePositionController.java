package com.yan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yan.entity.*;
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

    /**
     * 创建职位
     *
     * @param recruiterPosition
     * @return
     */
    @RequestMapping("create")
    public ResultMsg createPosition(@RequestBody RecruiterPosition recruiterPosition) {

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
        for (RecruiterPositionDesc desc : recruiterPosition.getRecruiterPositionDescs()) {
            recruiterPositionDescs.add(createPositionDescRepository.save(desc));
        }

        //构建职位
        position.setRecruiterInformation(recruiterInformation);
        position.setRecruiterCompanyInfo(recruiterCompanyInfo);
        position.setRecruiterPositionDescs(recruiterPositionDescs);

        //保存职位
        createPositionRepository.save(position);

        return new ResultMsg("200", "success", null);
    }

    /**
     * 查看全部职位
     *
     * @return List<position>
     */
    @RequestMapping("queryall")
    public ResultMsg queryAllPosition() {
        return new ResultMsg("200", "success",
                createPositionRepository.findAll());
    }

    /**
     * 根据招聘者ID，查看职位《列表》
     *
     * @param recruiterAccount
     * @return
     */
    @RequestMapping("findwithrecruiter")
    public ResultMsg findPositionByRecruiterAccountID(@RequestBody RecruiterAccount recruiterAccount) {

        return new ResultMsg("200", "succeess",
                createPositionRepository.findPositionByRecruiterAccountID(recruiterAccount.getId()));
    }

    /**
     * 根据职位ID，查询职位详情信息
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("findwithposition")
    public ResultMsg findRecruiterPositionById(@RequestBody JSONObject jsonObject) {

        int positionID = Integer.parseInt(jsonObject.get("positionID").toString());

        List<RecruiterPosition> recruiterPositionList =
                createPositionRepository.findRecruiterPositionById(positionID);

        if (recruiterPositionList.size() > 0) {

            RecruiterPosition recruiterPosition = recruiterPositionList.get(0);
            return new ResultMsg("200", "succeess", recruiterPosition);
        }

        return new ResultMsg("4004", "find recruiter position fail", null);
    }


    /**
     * 分页获取职位列表
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("querypage")
    public ResultMsg queryRecruiterPositionsByPageIndex(@RequestBody JSONObject jsonObject) {
        int pageIndex = Integer.parseInt(jsonObject.get("pageIndex").toString());
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());
       // System.out.println("pageIndex:" + jsonObject.get("pageIndex") + ",pageSize:" + jsonObject.get("pageSize"));
        return new ResultMsg("200", "success",
                createPositionRepository.queryRecruiterPositionsByPageIndex(pageIndex, pageSize));
    }

}
