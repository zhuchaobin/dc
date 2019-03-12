package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.biz.utils.HttpUtil;
import com.xai.tt.dc.client.model.B1VrtyPdNm;
import com.xai.tt.dc.client.model.B3PdNmDrcPrc;
import com.xai.tt.dc.client.model.T13GdsDetail;
import com.xai.tt.dc.client.model.User;
import com.xai.tt.dc.client.model.vrty;
import com.xai.tt.dc.client.service.KcDcService;
import com.xai.tt.dc.client.service.PdService;
import com.xai.tt.dc.client.vo.inVo.KcManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryKcDetailOutVo;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@SuppressWarnings("deprecation")
@Service("pdService")
public class PdServiceImpl implements PdService {
    private static final Logger logger = LoggerFactory.getLogger(PdServiceImpl.class);


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private T11IvntInfMapper t11IvntInfMapper;


    @Autowired
    private T13GdsDetailMapper t13GdsDetailMapper;


    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    private B1VrtyPdNmMapper b1VrtyPdNmMapper;
    @Autowired
    vrtyMapper vrtymapper;
    @Autowired
    private B3PdNmDrcPrcMapper b3PdNmDrcPrcMapper;


    @Override
    public Result<Boolean> savePrc() {

        String url = "http://www.enanchu.com/quotation/1/ajaxQuoteRecordsToday.action";
        Map<String, String> map = new HashMap<String, String>();
        map.put("tabId", "1");
//		map.put("code", "vms2.0");
        String msg = httpUtil.post(url, map);

        String jsonString = JSON.toJSONString(msg);
        jsonString = jsonString.replace("\\", "");
        jsonString = jsonString.substring(1, jsonString.length() - 1);

        System.out.println("jsonString=" + jsonString);
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            // 返回json的数组
            JSONArray jsonArray = jsonObject.getJSONArray("records");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                System.out.println(jsonObject2.getString("gbName"));
                String gbName = jsonObject2.getString("gbName");

                //日期
                String quotationTimeFormatString = jsonObject2.getString("quotationTimeFormatString");
                quotationTimeFormatString = quotationTimeFormatString.replace("-", "");
                System.out.println(quotationTimeFormatString);


                //均价
                String lowPrice = jsonObject2.getString("lowPrice");
                String highPrice = jsonObject2.getString("highPrice");
                float avgPrice = 0;
                if (org.apache.commons.lang3.StringUtils.isNotBlank(lowPrice)) {
                    avgPrice = (Integer.parseInt(lowPrice) + Integer.parseInt(highPrice)) / 2;
                    System.out.println(avgPrice);
                }

                setPrc(gbName, quotationTimeFormatString, avgPrice, url);
                //牌号
                String quotationType = jsonObject2.getString("quotationType");
                System.out.println(quotationType);
                //涨跌
                String priceRate = jsonObject2.getString("priceRate");
                System.out.println(priceRate);


            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return Result.createSuccessResult();

    }


    public void setPrc(String gbName, String quotationTime, float avgPrice, String url) {
/*        Condition condition = new Condition(B1VrtyPdNm.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("name = '" + gbName + "'");
        criteria.andCondition("folder = '0'");
        List<B1VrtyPdNm> b1List = b1VrtyPdNmMapper.selectByCondition(condition);*/
        // zhu,品种品名表修改为vrty，b1表不再使用
        Condition condition = new Condition(vrty.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("name = '" + gbName + "'");
        criteria.andCondition("folder = '0'");
        List<vrty> b1List = vrtymapper.selectByCondition(condition);
        if (b1List != null && b1List.size() > 0) {
            for (vrty b1 : b1List) {

                B3PdNmDrcPrc b3 = new B3PdNmDrcPrc();
                b3.setPdId((long)b1.getId());
                b3.setAcqDt(quotationTime);
                b3.setSrcTpcd("04");
                b3.setSrcDsc("南储商务网");
                b3.setDrcPrc(avgPrice);
                b3.setTms(new Date());
                b3.setUsername("99999999");
                b3.setRmrk(url);


                try {
                    b3PdNmDrcPrcMapper.insert(b3);

                } catch (DuplicateKeyException e) {

                    int effectRow = b3PdNmDrcPrcMapper.updateByPrimaryKey(b3);

                    logger.info("更新南储商务网价格信息出现异常e{}", e);


                } catch (Exception e) {
                    logger.info("保存南储商务网价格信息出现异常e{}", e);

                }


            }
        }
    }

}
