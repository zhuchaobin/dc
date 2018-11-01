package com.xai.tt.dc.biz.job;
/*package com.xai.tt.dc.biz.job;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.mapper.MaintenanceRemindMapper;
import com.xai.tt.dc.biz.utils.DateUtils;
import com.xai.tt.dc.client.entity.MaintenanceRemind;
import com.xai.tt.mc.client.enums.JpushPlatform;
import com.xai.tt.mc.client.service.JpushService;
import com.xai.tt.mc.client.vo.JpushVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.*;

*//**
 * Created by fanyouchen on 2018/7/11.
 *//*
@Service
public class MaintenanceRemindPushJob implements SimpleJob{

    private static final Logger logger = LoggerFactory.getLogger(MaintenanceRemindPushJob.class);

    @Autowired
    private MaintenanceRemindMapper maintenanceRemindMapper;

    @Autowired
    private JpushService jpushService;

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.debug("开始执行保养提醒任务:"+DateUtils.defaultYesterdayDate());
        Map map = new HashMap<>();
        Condition condition = new Condition(MaintenanceRemind.class);
        Date date = DateUtils.dateResetZero(new Date());
        condition.createCriteria().andBetween("remindTime", DateUtils.dateResetZero(date),DateUtils.dateReset23(date));
        List<MaintenanceRemind> list = maintenanceRemindMapper.selectByCondition(condition);
        for (int i=0;i<list.size();i++){
            Result<?> adResult = null;
            Result<?> iosResult = null;
            MaintenanceRemind mr = list.get(i);
            try {
                JpushVo vo = this.buildPushVo4Andriod(mr);
                logger.info("安卓推送保养提醒请求参数:{}", JSON.toJSONString(vo));

                adResult = jpushService.sendMessage(vo);
                logger.info("安卓推送保养提醒返回结果:{}", JSON.toJSONString(adResult));
            } catch (Exception e) {
                // TODO: handle exception
            }

            try {
                JpushVo vo = this.buildPushVo4Ios(mr);
                logger.info("ios推送保养提醒请求参数:{}", JSON.toJSONString(vo));

                iosResult = jpushService.sendNotifacation(vo);
                logger.info("ios推送保养提醒返回结果:{}", JSON.toJSONString(iosResult));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        logger.info("执行保养提醒任务完成:"+DateUtils.defaultYesterdayDate());
    }


    private JpushVo buildPushVo4Andriod(MaintenanceRemind mr) {
        JpushVo vo = new JpushVo();
        List<String> tags = new ArrayList<String>();
        tags.add("Company"+"_"+String.valueOf(""));
        vo.setTags(tags);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "保养提醒");
        map.put("type", 4);
        map.put("body", "您的车辆需要保养了" + "，车架号："+mr.getVin());
        map.put("id", mr.getId());
        vo.setContent(JSON.toJSONString(map));
        vo.setPlatform(JpushPlatform.android);
        return vo;
    }



    private JpushVo buildPushVo4Ios(MaintenanceRemind mr) {
        JpushVo vo = new JpushVo();
        List<String> tags = new ArrayList<String>();
        tags.add("Company"+"_"+String.valueOf(""));
        vo.setTags(tags);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "保养提醒");
        map.put("type", 4);
        map.put("body", "您的车辆需要保养了" + "，车架号："+mr.getVin());
        map.put("id", mr.getId());
        vo.setContent(JSON.toJSONString(map));
        vo.setPlatform(JpushPlatform.ios);

        return vo;
    }

}
*/