package com.xai.tt.dc.biz.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.PostAddressMapper;
import com.xai.tt.dc.client.entity.PostAddress;
import com.xai.tt.dc.client.inter.PostAddressDcService;
import com.xai.tt.dc.client.request.PostAddressDcReq;
import com.xai.tt.dc.client.vo.PostAddressVo;

@SuppressWarnings("deprecation")
@Service("postAddressServiceImpl")
public class PostAddressDcServiceImpl implements PostAddressDcService{
	private static final Logger logger = LoggerFactory.getLogger(PostAddressDcServiceImpl.class);
	@Autowired
	private PostAddressMapper postAddressMapper;
	
	/**
	 * 描述：根据收货地址id修改收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	@Override
	public Result<Boolean> save(PostAddressDcReq req) {
	        logger.info("start update PostAddress ======> PostAddress:{}", req);
	        try {
	        	postAddressMapper.save(req);
	        } catch (Exception e) {

	            logger.error("根据收货地址id修改收货地址信息异常 {}", e);
	            return Result.createFailResult("更新异常");
	        }
	        return Result.createSuccessResult(true);
	}

	/**
	 * 描述：根据收货地址id删除收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	@Override
	public Result<?> delete(PostAddress model) {
		if(model.getId() == null) {
			return Result.createFailResult("id不能为空！");
		}
		postAddressMapper.deleteByPrimaryKey(model.getId());
		return Result.createSuccessResult();
	}

	/**
	 * 描述：根据车主用户id查询收货地址列表信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	@Override
	public Result<List<PostAddressVo>> list(Integer carOwnerId) {
		if(carOwnerId == null) {
    		logger.error("查询用户收货地址列表信息参数不能为空");
			return Result.createFailResult("查询用户收货地址列表信息参数不能为空");
    	}
		
		try {
			List<PostAddressVo> cars = postAddressMapper.list(carOwnerId);
			return Result.createSuccessResult(cars);
		} catch(Exception e) {
			logger.error("查询车主车辆信息异常", e);
			return Result.createFailResult("系统异常");
		}
		
	}

	/**
	 * 描述：根据收货地址id查询收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	@Override
	public Result<PostAddress> query(Integer id) {
		// TODO Auto-generated method stub		
		if(id == null) {
			logger.error("id不能为空");
			return Result.createFailResult("id不能为空");
		}
		try {
			PostAddress postAddress = postAddressMapper.selectByPrimaryKey(id);
			return Result.createSuccessResult(postAddress);
		} catch(Exception e) {
			logger.error("查找车主车辆信息异常", e);
			return Result.createFailResult("系统异常");
		}
	}
	
	/**
	 * 描述：新增车主收货地址信息
	 * 
	 * @author zhucb 2018-07-21
	 */
	@Override
	public Result<Boolean> add(PostAddress model) {
	       logger.info("start insert PostAddress =======> PostAddress:{}", model);
	        try {
	        	postAddressMapper.insertSelective(model);
	        } catch (Exception e) {
	            logger.error("插入收货地址信息出现异常", e);
	            return Result.createFailResult("新增收货地址信息出现异常");
	        }
	        return Result.createSuccessResult(true);
	}
	
	/**
	 * 描述：设置车主默认收货地址
	 * 
	 * @author zhucb 2018-06-30
	 */
	public Result<Boolean> setPreferredPostAddres(PostAddress model){
		logger.info("start setPreferredPostAddres =======> PostAddress:{}", model);
		PostAddressDcReq req = new PostAddressDcReq();
        try {
			BeanUtils.copyProperties(model, req);
			// 设置本地址之外的默认地址为非默认地址
			postAddressMapper.expOtherPreferred(req);
        } catch (Exception e) {
            logger.error("设置本地址之外的默认地址为非默认地址出现异常", e);
            return Result.createFailResult("设置车主默认收货地址");
        }
        try {
			// 设置本地址为默认收货地址
			req.setPreferred(1);
			save(req);
        } catch (Exception e) {
            logger.error("设置本地址为默认收货地址出现异常", e);
            return Result.createFailResult("设置本地址为默认收货地址出现异常");
        }
		return Result.createSuccessResult(true);
	}
	
	/**
	 * 描述：根据条件查询收货地址列表信息
	 * 
	 * @author zhucb 2018-07-21
	 */
	@Override
    public Result<PageData<PostAddressVo>> queryPage(PostAddressDcReq query, PageParam pageParam) {
		logger.info("start query PostAddressDcReq List =======> query:{},page:{}", query, pageParam);
		
	       Page<PostAddressVo> page = null;
	        int count = 0;
	        if (pageParam != null) {
	            PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
	        }
	        try {
	            page = postAddressMapper.pageQuery(query);
	            count = postAddressMapper.count(query);
	        } catch (Exception e) {

	            logger.error("根据条件查询收货地址列表信息异常 {}", e);
	            return Result.createFailResult("查询异常");
	        }
	        logger.info("query PostAddressDcReq list success!");
	        return Result.createSuccessResult(new PageData<>(count, page.getResult()));
    }
	
//	/**
//	 * 描述：根据条件查询收货地址列表信息
//	 * 
//	 * @author zhucb 2018-07-21
//	 */
//	@Override
//    public Result<PageData<PostAddressDcReq>> queryPostAddressPage(PostAddressDcReq query, PageParam pageParam) {
//		logger.info("start query PostAddressDcReq List =======> query:{},page:{}", query, pageParam);
//		
//	       Page<PostAddressVo> page = null;
//	        int count = 0;
//	        if (pageParam != null) {
//	            PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
//	        }
//	        try {
//	            page = postAddressMapper.pageQuery(query);
//	            count = postAddressMapper.count(query);
//	        } catch (Exception e) {
//
//	            logger.error("根据条件查询收货地址列表信息异常 {}", e);
//	            return Result.createFailResult("查询异常");
//	        }
//	        logger.info("query PostAddressDcReq list success!");
//	        return Result.createSuccessResult(new PageData<>(count, page.getResult()));
//    }
	
}
