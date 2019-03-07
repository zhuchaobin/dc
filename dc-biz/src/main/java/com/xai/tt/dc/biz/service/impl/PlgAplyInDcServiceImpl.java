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
import com.xai.tt.dc.client.service.PlgAplyDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.inVo.PlgAplyInVo;

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
@Service("plgAplyDcService")
public class PlgAplyInDcServiceImpl implements PlgAplyDcService {
	private static final Logger logger = LoggerFactory.getLogger(PlgAplyInDcServiceImpl.class);
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
	
	
	/**
	 * 描述：保存质押信息
	 *  2019-03-06
	 * @author
	 */
	@Override
	public Result<Boolean> save(PlgAplyInVo inVo) {
		logger.info("保存质押信息请求报文{}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		try {
		// 保存质押信息
		T18PlgAply t18 = new T18PlgAply();
		BeanUtils.copyProperties(inVo, t18);
		t18.setPlgAplyTm(new Date());
		t18.setPlgAplyMnpltPsn(inVo.getUsername());
		t18.setTms(new Date());
		t18.setPlgAplySt("01");//待审核
		String StrPost = DateUtils.noFormatDate() + sequenceUtils.getSequence("Cd_Seq", 4);
		t18.setWhrecptId("CD" + StrPost);
		t18.setPlgBillno("ZY" + StrPost);
		t18PlgAplyMapper.insert(t18);
		
		for(T13GdsDetail t13 : inVo.getT13GdsDetailList()) {
			// 保存质押货物明细
			t13.setRltvTp("02");//01:发货明细 02：质押明细 03：发货入库明细 04：出库明细
			t13.setRltvId("CD" + StrPost);
			t13.setTms(new Date());
			t13.setCrtTm(new Date());
			t13.setUsername(inVo.getUsername());
			t13GdsDetailMapper.insert(t13);
			// 质押品入库
			T17IvntDtl t17 = new T17IvntDtl();
			BeanUtils.copyProperties(inVo, t17, CommonUtils.getNullPropertyNames(inVo));
			t17.setWhrecptId(t13.getRltvId()); 
			t17.setIntrsrTp("02");// 02：存入自有货物 03：上游发货形成 
			t17.setIntrsrTnum(t13.getNum());
			t17.setInthestgTnum(t13.getNum());
			t17.setOutstgTnum(0f);
/*			t17.setArId(inVo.getArId());
			t17.setOrdrId(inVo.getOrdrId());
			t17.setSpgId(inVo.getSpgId());*/
			t17.setPlgBillno("ZY" + StrPost);
/*			t17.setBnk(inVo.getBnk());
			t17.setBnkNm(inVo.getBnkNm());
			t17.setStgco(inVo.getStgco());
			t17.setStgcoNm(inVo.getStgcoNm());*/
			t17.setGdsBlgId(inVo.getFncEntp());
			t17.setGdsBlgNm(inVo.getFncEntpNm());
			t17.setPlgAplySt("01");
			t17IvntDtlMapper.insert(t17);			
		}
		
		/*	// 保存质押附件信息
			try {
				if (StringUtils.isNotEmpty(inVo.getFileNames())) {
					T2UploadAtch t2UploadAtch = new T2UploadAtch();
					t2UploadAtch.setRltvTp("03");
					t2UploadAtch.setUsername(inVo.getUsername());
					t2UploadAtch.setRltvId(spgId);
					insertFile(t2UploadAtch, inVo.getFileNames());
				}
			else {
					logger.error("保存质押信息，质押附件为空！");
				}
			} catch (Exception e) {
				logger.error("保存质押附件信息异常 {}", e);
				return Result.createFailResult("保存质押附件信息发生异常" + e);
			}

			// 删除质押附件信息
			if (StringUtils.isNotBlank(inVo.getFilesToDelete())) {
				try {
					String[] files = inVo.getFilesToDelete().split("\\|\\|");
					for(String fileId : files) {
						logger.info("删除附件开始，附件id:" + fileId);
						t2UploadAtchMapper.deleteByPrimaryKey(Long.parseLong(fileId));
						logger.info("删除附件结束，附件id:" + fileId);
					}
				} catch (Exception e) {
					logger.error("删除质押附件信息异常 {}", e);
					return Result.createFailResult("删除质押附件信息发生异常" + e);
				}
			}*/

					logger.info("更新质押申请成功！");
					return Result.createSuccessResult();
				} catch (Exception e) {
					logger.error("更新质押申请异常 {}", e);
					return Result.createFailResult("更新质押申请异常:" + e);
				}
			}


	/**
	 * 描述：删除质押
	 * 
	 * @author 
	 */
	@Override
	public Result<Boolean> delete(String id) {
		logger.info("删除质押,请求参数:{}", id);
		try {
			T18PlgAplyMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除质押成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除质押异常 {}", e);
			return Result.createFailResult("删除质押异常" + e);
		}
	}

	// 保存附件信息
	private void insertFile(T2UploadAtch t2UploadAtch, String fileNames) {
		try {
			List<T2UploadAtch> t2UploadAtchs = Arrays.asList(fileNames.split(",")).stream().map(item -> {
				T2UploadAtch t2 = new T2UploadAtch();
				BeanUtils.copyProperties(t2UploadAtch, t2);
				String[] str = item.split("\\|\\|");
				// 取原始文件名
				String oriFileNm = str[1];
				int lastSeparator = oriFileNm.lastIndexOf("\\");
				if (lastSeparator >= 0) {
					oriFileNm = oriFileNm.substring(lastSeparator + 1);
				}
				t2.setOriFileNm(oriFileNm);
				t2.setSrFileRte(str[0]);
				t2.setCrtTm(new Date());
				t2.setTms(new Date());
				return t2;
			}).collect(Collectors.toList());
			for (T2UploadAtch t2 : t2UploadAtchs) {
				if (null != t2UploadAtchMapper.selectByPrimaryKey(t2.getId())) {
					// 更新记录
					logger.debug("保存质押附件信息");
					t2UploadAtchMapper.updateByPrimaryKeySelective(t2);
				} else {
					// 插入记录
					logger.debug("更新质押附件信息");
					t2UploadAtchMapper.insert(t2);
				}
			}

		} catch (Exception e) {
			logger.info("保存质押附件信息发生异常：", e);
		}

	}

	/**
	 * 描述：查询质押列表（分页）
	 * 
	 * @author
	 */
	@Override
	public Result<PageData<PlgAplyInVo>> queryPage(PlgAplyInVo query, PageParam pageParam) {
		logger.info("start query 质押信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());
		
		Page<PlgAplyInVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = T18PlgAplyMapper.selectByPage(query);
			count = T18PlgAplyMapper.count(query);
		} catch (Exception e) {

			logger.error("查询质押列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}",JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询质押详情
	 * 
	 * @author
	 */
	@Override
	public Result<PlgAplyInVo> queryDetail(PlgAplyInVo query ) {
		logger.info("查询质押详情,请求参数:{}", JSON.toJSONString(query));
		try {		
			PlgAplyInVo t18 = T18PlgAplyMapper.queryDetail(query.getId()+"");

			/*t3 = T18PlgAplyMapper.querySpgDetail(query.getId().intValue());*/
			if (t18 == null) {
				logger.error("查询质押详情无数据");
				return Result.createFailResult("查询质押详情无数据");
			} else {
				// 查询货物明细信息
				Condition condition0 = new Condition(T13GdsDetail.class);
				Example.Criteria criteria0 = condition0.createCriteria();
				criteria0.andCondition("Rltv_ID = '" + t18.getWhrecptId()+ "'");
				criteria0.andCondition("Rltv_Tp = '02'");
				List<T13GdsDetail> t13List = t13GdsDetailMapper.selectByCondition(condition0);
				t18.setT13GdsDetailList(t13List);
				logger.info("查询货物明细信息成功!");
				
				Result<PlgAplyInVo>  rlt = new Result<PlgAplyInVo> ();
				rlt.setData(t18);
				return rlt;
			}
			
/*			// 查询质押附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + t3.getSpgId() + "'");
			criteria0.andCondition("Rltv_Tp = '03'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			t3.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询质押附件信息成功!");*/

/*			return Result.createSuccessResult(t3);*/
		} catch (Exception e) {
			logger.error("查询质押详情异常 {}", e);
			return Result.createFailResult("查询质押详情异常" + e);
		}
	}
	

}
