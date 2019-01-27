package com.xai.tt.dc.biz.utils;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xai.tt.dc.biz.mapper.R1LnkInfDefMapper;
import com.xai.tt.dc.biz.mapper.T10MsgStMapper;
import com.xai.tt.dc.biz.mapper.T9MsgSndMapper;
import com.xai.tt.dc.biz.mapper.UserMapper;
import com.xai.tt.dc.client.model.R1LnkInfDef;
import com.xai.tt.dc.client.model.T10MsgSt;
import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.model.T3OrderInf;
import com.xai.tt.dc.client.model.T6SpgInf;
import com.xai.tt.dc.client.model.T9MsgSnd;
import com.xai.tt.dc.client.model.User;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * 消息服务处理工具类
 * zhuchaobin
 * 2019-1-27 
 */
@SuppressWarnings("deprecation")
@Service("msgUtils")
public class MsgUtils {
	private static final Logger logger = LoggerFactory.getLogger(MsgUtils.class);
	@Autowired
	private T9MsgSndMapper t9MsgSndMapper;
	@Autowired
	private T10MsgStMapper t10MsgStMapper;	
	@Autowired
	private R1LnkInfDefMapper r1LnkInfDefMapper;
	@Autowired
	private UserMapper userMapper;
	
	public void sendMsg(T9MsgSnd t9) {
		try {
			t9.setMsgSndTm(new Date());
			t9MsgSndMapper.insert(t9);
			// 如果是发送
			if("02".equals(t9.getMsgStcd())) {
				String[] str = t9.getRcvPsnIdList().split(";");
				for(String id : str) {
					// 获取信息id
					t9.setTms(null);
					t9.setMsgSndTm(null);
					t9.setMulInd(null);
					T9MsgSnd t9Rlt = t9MsgSndMapper.select(t9).get(0); 
					if(null != t9Rlt) {
						T10MsgSt t10 = new T10MsgSt();
						t10.setMsgId(t9Rlt.getId().intValue());
						t10.setMsgStcd(DataConstants.MSG_STCD_WD);
						t10.setRcvPsnId(Long.parseLong(id));
						t10.setTms(new Date());
						t10.setUsername(t9.getUsername());
						t10MsgStMapper.insertSelective(t10);
					} 
				}
			}	
			logger.info("消息发送成功！");
		} catch (Exception e) {
			logger.error("消息发送发生异常" + e);
		}		
	}
	
	public void sendNewArTaskMsg(T1ArInf t1, T3OrderInf t3, T6SpgInf t6, String processType) {
		try {
			String aplyPcstpCd = "";
			String msgTitle = "";
			String msgCntnt = "";
			String rcvPsnList = "";
			String rcvPsnIdList = "";
			String operTips = "";

			// 长约流程
			if(DataConstants.PROCESS_TPCD_AR.equals(processType)) {
				aplyPcstpCd = t1.getArSt();
				msgTitle = "您有一笔长约"+ t1.getArId()+"需要处理！";
				operTips = "操作指引：点击[长约管理]->[待处理]，请根据长约编号查询出相应长约并点击处理。";
			} else if(DataConstants.PROCESS_TPCD_ORDER.equals(processType)) {
				aplyPcstpCd = t3.getOrdrSt();
				msgTitle = "您有一笔订单"+ t3.getOrdrId()+"需要处理！";
				operTips = "操作指引：点击[订单管理]->[待处理]，请根据订单编号查询出相应订单并点击处理。";
			} else if(DataConstants.PROCESS_TPCD_SPG.equals(processType)) {
				aplyPcstpCd = t6.getSpgSt();
				msgTitle = "您有一笔货物"+ t6.getSpgId()+"需要处理！";
				operTips = "操作指引：点击[货物管理]->[待处理]，请根据货物编号查询出相应货物并点击处理。";
			}
			Condition condition0 = new Condition(R1LnkInfDef.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Aply_PcStp_Cd = '" + aplyPcstpCd + "'");
			R1LnkInfDef r1 = r1LnkInfDefMapper.selectByCondition(condition0).get(0);
			if(null != r1) {
				// 查询待提醒用户
//				Condition condition1 = new Condition(User.class);
//				Example.Criteria criteria1 = condition1.createCriteria();
//				criteria1.andCondition("user_type = '" + r1.getUserType() + "'");
//				criteria1.andCondition("SplChain_Co = '" + t1.getSplchainCo() + "'");
//				List<User> userList = userMapper.selectByCondition(condition1);
				
				if(2 == r1.getUserType())
					rcvPsnIdList = t1.getUstrmSplr() + "";
				else if(3 == r1.getUserType())
					rcvPsnIdList = t1.getSplchainCo() + "";
				else if(4 == r1.getUserType())
					rcvPsnIdList = t1.getFncEntp() + "";
				else if(5 == r1.getUserType())
					rcvPsnIdList = t1.getInsCo() + "";
				else if(6 == r1.getUserType())
					rcvPsnIdList = t1.getBnk() + "";
				else if(7 == r1.getUserType())
					rcvPsnIdList = t1.getLgstcCo() + "";
				else if(8 == r1.getUserType())
					rcvPsnIdList = t1.getStgco() + "";
				else if(1 == r1.getUserType())
				rcvPsnIdList = "27";
				
				Condition condition1 = new Condition(User.class);
				Example.Criteria criteria1 = condition1.createCriteria();
				criteria1.andCondition("user_type = '" + r1.getUserType() + "'");
				criteria1.andCondition("SplChain_Co = '" + t1.getSplchainCo() + "'");
				User us = userMapper.selectByPrimaryKey(Integer.parseInt(rcvPsnIdList));
				if(null != us) {
						rcvPsnList = us.getChineseName();
				}
				
				msgCntnt = "尊敬的中检供应链金融服务平台用户"+rcvPsnList+",您好：\r\n" + msgTitle + ",您需要提交的环节为：" 
				+ r1.getAplyPcstpChnNm() + "。\r\n" + operTips;
			}
			
			if(StringUtils.isNoneBlank(rcvPsnIdList)) {
				T9MsgSnd t9 = new T9MsgSnd();
				t9.setMsgTitle(msgTitle);
				t9.setMsgCntnt(msgCntnt);
				t9.setRcvPsnIdList(rcvPsnIdList);
				t9.setMsgTpcd("99");
				t9.setUsername("系统");
				t9.setRcvPsnList(rcvPsnList);
				t9.setSndPsnId(99999999L);
				t9.setMulInd(false);
				t9.setMsgStcd(DataConstants.MSG_STCD_YF);
				sendMsg(t9);
			}
					
			logger.info("消息发送成功！");
		} catch (Exception e) {
			logger.error("消息发送发生异常" + e);
		}		
	}
	
	public static void main(String[] args) {

	}
}
