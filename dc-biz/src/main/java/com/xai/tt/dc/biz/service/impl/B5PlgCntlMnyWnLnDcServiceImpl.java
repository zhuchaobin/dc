package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.*;
import com.xai.tt.dc.client.inter.R1LnkInfDefService;
import com.xai.tt.dc.client.model.*;
import com.xai.tt.dc.client.service.B5PlgCntlMnyWnLnDcService;
import com.xai.tt.dc.client.service.PlgAplyDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.B5PlgCntlMnyWnLnVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
@Service("b5PlgCntlMnyWnLnDcService")
public class B5PlgCntlMnyWnLnDcServiceImpl implements B5PlgCntlMnyWnLnDcService {
	private static final Logger logger = LoggerFactory.getLogger(B5PlgCntlMnyWnLnDcServiceImpl.class);
	@Autowired
	private T2UploadAtchMapper t2UploadAtchMapper;
	@Autowired
	private SequenceUtils sequenceUtils;
	@Autowired
	private T18PlgAplyMapper T18PlgAplyMapper;
	@Autowired
	private T13GdsDetailMapper t13GdsDetailMapper;
	@Autowired
	private T18PlgAplyMapper t18PlgAplyMapper;
	@Autowired
	private T17IvntDtlMapper t17IvntDtlMapper;
	@Autowired
	private B5PlgCntlMnyWnLnMapper b5PlgCntlMnyWnlnMapper;
	@Autowired
	private B4PlgDrcPrcMapper b4PlgDrcPrcMapper;

	/**
	 * 描述：保存最低控货预警线信息 2019-03-06
	 * 
	 * @author
	 */
	@Override
	public Result<Boolean> save(B5PlgCntlMnyWnLnVo inVo) {
		logger.info("保存最低控货预警线信息请求报文{}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		return null;
/*		try {
			// 保存最低控货预警线信息
			T18PlgAply t18 = new T18PlgAply();
			BeanUtils.copyProperties(inVo, t18);
			t18.setPlgAplyTm(new Date());
			t18.setPlgAplyMnpltPsn(inVo.getUsername());
			t18.setTms(new Date());
			t18.setPlgAplySt("01");// 待审核
			String StrPost = DateUtils.noFormatDate() + sequenceUtils.getSequence("Cd_Seq", 4);
			t18.setWhrecptId("CD" + StrPost);
			t18.setPlgBillno("ZY" + StrPost);
			t18PlgAplyMapper.insert(t18);

			for (T13GdsDetail t13 : inVo.getT13GdsDetailList()) {
				// 保存最低控货预警线货物明细
				t13.setRltvTp("02");// 01:发货明细 02：最低控货预警线明细 03：发货入库明细 04：出库明细
				t13.setRltvId("CD" + StrPost);
				t13.setTms(new Date());
				t13.setCrtTm(new Date());
				t13.setUsername(inVo.getUsername());
				t13GdsDetailMapper.insert(t13);
				// 最低控货预警线品入库
				T17IvntDtl t17 = new T17IvntDtl();
				BeanUtils.copyProperties(inVo, t17, CommonUtils.getNullPropertyNames(inVo));
				t17.setWhrecptId(t13.getRltvId());
				t17.setIntrsrTp("02");// 02：存入自有货物 03：上游发货形成
				t17.setIntrsrTnum(t13.getNum());
				t17.setInthestgTnum(t13.getNum());
				t17.setOutstgTnum(0f);
				
				 * t17.setArId(inVo.getArId()); t17.setOrdrId(inVo.getOrdrId());
				 * t17.setSpgId(inVo.getSpgId());
				 
				t17.setPlgBillno("ZY" + StrPost);
				
				 * t17.setBnk(inVo.getBnk()); t17.setBnkNm(inVo.getBnkNm());
				 * t17.setStgco(inVo.getStgco()); t17.setStgcoNm(inVo.getStgcoNm());
				 
				t17.setGdsBlgId(inVo.getFncEntp());
				t17.setGdsBlgNm(inVo.getFncEntpNm());
				t17.setPlgAplySt("01");
				t17IvntDtlMapper.insert(t17);
			}

			logger.info("更新最低控货预警线申请成功！");
			return Result.createSuccessResult();
		} catch (Exception e) {
			logger.error("更新最低控货预警线申请异常 {}", e);
			return Result.createFailResult("更新最低控货预警线申请异常:" + e);
		}*/
	}


	/**
	 * 描述：删除最低控货预警线
	 * 
	 * @author
	 */
	@Override
	public Result<Boolean> delete(String id) {
		logger.info("删除最低控货预警线,请求参数:{}", id);
		try {
			T18PlgAplyMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除最低控货预警线成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除最低控货预警线异常 {}", e);
			return Result.createFailResult("删除最低控货预警线异常" + e);
		}
	}

	/**
	 * 描述：查询最低控货预警线列表（分页）
	 * 
	 * @author
	 */
	@Override
	public Result<PageData<B5PlgCntlMnyWnLnVo>> queryPage(B5PlgCntlMnyWnLnVo query, PageParam pageParam) {
		logger.info("start query 最低控货预警线信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());

/*		Page<B5PlgCntlMnyWnLnVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = T18PlgAplyMapper.selectByPage(query);
			count = T18PlgAplyMapper.count(query);
		} catch (Exception e) {

			logger.error("查询最低控货预警线列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}", JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));*/
		return null;
	}

	/**
	 * 描述：查询最低控货预警线详情
	 * 
	 * @author
	 */
	@Override
	public Result<B5PlgCntlMnyWnLnVo> queryDetail(B5PlgCntlMnyWnLnVo query) {
		logger.info("查询最低控货预警线详情,请求参数:{}", JSON.toJSONString(query));
	/*	try {
			B5PlgCntlMnyWnLnVo t18 = T18PlgAplyMapper.queryDetail(query.getId() + "");

			 t3 = T18PlgAplyMapper.querySpgDetail(query.getId().intValue()); 
			if (t18 == null) {
				logger.error("查询最低控货预警线详情无数据");
				return Result.createFailResult("查询最低控货预警线详情无数据");
			} else {
				// 查询货物明细信息
				Condition condition0 = new Condition(T13GdsDetail.class);
				Example.Criteria criteria0 = condition0.createCriteria();
				criteria0.andCondition("Rltv_ID = '" + t18.getWhrecptId() + "'");
				criteria0.andCondition("Rltv_Tp = '02'");
				List<T13GdsDetail> t13List = t13GdsDetailMapper.selectByCondition(condition0);
				t18.setT13GdsDetailList(t13List);
				logger.info("查询货物明细信息成功!");

				Result<B5PlgCntlMnyWnLnVo> rlt = new Result<B5PlgCntlMnyWnLnVo>();
				rlt.setData(t18);
				return rlt;
			}

			
			 * // 查询最低控货预警线附件信息 Condition condition0 = new Condition(T2UploadAtch.class);
			 * Example.Criteria criteria0 = condition0.createCriteria();
			 * criteria0.andCondition("Rltv_ID = '" + t3.getSpgId() + "'");
			 * criteria0.andCondition("Rltv_Tp = '03'"); List<T2UploadAtch>
			 * t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			 * t3.setT2UploadAtch01List(t2UploadAtch01List); logger.info("查询最低控货预警线附件信息成功!");
			 

			 return Result.createSuccessResult(t3); 
		} catch (Exception e) {
			logger.error("查询最低控货预警线详情异常 {}", e);
			return Result.createFailResult("查询最低控货预警线详情异常" + e);
		}*/
		return null;
	}
}
