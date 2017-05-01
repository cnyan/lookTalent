package com.yan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yan.entity.HunterAccount;
import com.yan.repository.HunterAccountRepository;
import com.yan.utils.CheckSumBuilder;
import com.yan.utils.GetNIMTokenKey;
import com.yan.utils.ResultMsg;
import com.yan.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/22.
 * 求职者注册登录接口
 */
@RestController
@RequestMapping("/hunter/account")
public class HunterAccountController {
    @Autowired
    private HunterAccountRepository hunterAccountRepository;


    /**
     * 求职者注册方法
     *
     * @param hunterAccount
     * @return
     */
    @PostMapping("regist")
    public ResultMsg hunterRegist(@RequestBody HunterAccount hunterAccount) {
        System.out.println("求职者注册API");
        ResultMsg resultMsg = new ResultMsg();

        try {
            JSONObject object = GetNIMTokenKey.getTokenKey(hunterAccount.getHunterAccount(), hunterAccount.getName());
            if (!object.get("code").toString().equals("200")) {
                //返回结果错误，返回错误信息与状态码
                resultMsg = new ResultMsg(object.get("code").toString(), object.get("desc").toString(), null);
                return resultMsg;
            }
            System.out.println("网易云信注册结果：" + object);
            //返回网易token_key结果，hunterAccount设置token_key
            hunterAccount.setTokenKey(object.getJSONObject("info").get("token").toString());
            //hunterAccount的密码进行md5 加密
            hunterAccount.setPassword(CheckSumBuilder.getMD5(hunterAccount.getPassword()));
            //执行保存
            hunterAccountRepository.save(hunterAccount);
            resultMsg = new ResultMsg(ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrcode(), ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrmsg(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMsg;
    }

    /**
     * 求职者登录app
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("login")
    public ResultMsg loginToApp(@RequestBody JSONObject jsonObject) {

        String hunter_account = jsonObject.get("hunterAccount").toString();
        String password = CheckSumBuilder.getMD5(jsonObject.get("password").toString());

        List<HunterAccount> hunterAccountList = hunterAccountRepository.loginToApp(hunter_account, password);

        if (hunterAccountList.size() > 0) {
            HunterAccount hunterAccount = hunterAccountList.get(0);
            hunterAccount.setPassword("");
            System.out.println(hunterAccount);
            return new ResultMsg("200", "success", hunterAccount);
        }

        return new ResultMsg(ResultStatusCode.ERROR_ACCOUNT.getErrcode(), ResultStatusCode.ERROR_ACCOUNT.getErrmsg(), null);
    }

    /**
     * 求职者修改密码
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("newpassword")
    public ResultMsg updateNewPassword(@RequestBody JSONObject jsonObject) {

        String hunter_account = jsonObject.get("hunterAccount").toString();
        String password = CheckSumBuilder.getMD5(jsonObject.get("newPassword").toString());
        //根据账号查找求职者
        List<HunterAccount> hunterAccountList = hunterAccountRepository.findHunterAccountByHunterAccount(hunter_account);

        if (hunterAccountList.size() > 0) {
            HunterAccount hunterAccount = hunterAccountList.get(0);
            hunterAccount.setPassword(password);
            hunterAccountRepository.save(hunterAccount);
            return new ResultMsg("200", "success", null);
        }
        return new ResultMsg("4004", "update new password fail", null);
    }

    /**
     * 修改求职者信息，姓名和头像
     * @param hunterAccount
     * @return
     */
    @RequestMapping("updateInfo")
    public ResultMsg updateHunterAccountInfo(@RequestBody HunterAccount hunterAccount) {

        //根据账号查找求职者
        List<HunterAccount> hunterAccountList = hunterAccountRepository.findHunterAccountByHunterAccount(hunterAccount.getHunterAccount());

        if (hunterAccountList.size() > 0){
            HunterAccount newHunterAccount = hunterAccountList.get(0);
            //账号、密码和token_key不可更改

            newHunterAccount.setName(hunterAccount.getName());
            newHunterAccount.setHeadImage(hunterAccount.getHeadImage());

            hunterAccountRepository.save(newHunterAccount);
            return new ResultMsg("200", "success", null);
        }
        return new ResultMsg("4004", "update person info fail", null);
    }


}
