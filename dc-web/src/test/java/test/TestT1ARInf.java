/*package test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.App;
import com.xai.tt.dc.biz.mapper.T1ARInfMapper;
import com.xai.tt.dc.biz.mapper.T1ARInfMapper_bak;
import com.xai.tt.dc.biz.mapper.T2ARAtchMapper;
import com.xai.tt.dc.client.model.T1ARInf;
import com.xai.tt.dc.client.model.T2ARAtch;
import com.xai.tt.dc.client.service.TB0001DcService;
import com.xai.tt.dc.client.vo.inVo.TB0001InVo;
import com.xai.tt.dc.client.vo.inVo.TB0001SubInVo;
import com.xai.tt.dc.client.inter.T1ARInfDcService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = App.class) 
//@ContextConfiguration({ "classpath*:*dubbo-reference.xml" })
public class TestT1ARInf{
	
	@Autowired
	private TB0001DcService tB0001DcService;
	@Autowired
	private T1ARInfMapper t1ARInfMapper;
//	@Test
	@Rollback(false)
	public void testSave() {
		TB0001InVo req = new TB0001InVo();
		// ID
//		req.setId((long) 3);
		// 长约编号
		req.setArId("23");
		// 长约类型
		req.setArTp("3");
		// 采购方
		req.setPchPrty("4");
		// 长约开始日期
		req.setArStdt("5");
		// 长约结束日期
		req.setArEddt("6");
		// 供应商
		req.setSplr("7");
		// 提货周期
		req.setPckupgdsCyc(8);
		// 协议仓库
		req.setAgrmStg("9");
		// 业务类型
		req.setBtp("10");
		// 融资比例
		req.setFncPctg(4f);
		// 预付金比率
		req.setPrpyGldRto(12f);
		// 额度
		req.setLmt(1f);
		// 警戒线
		req.setCrdn(3f);
		// 平仓线
		req.setClsposLn(4f);
		// 服务费收取方式
		req.setSvcfeeCmd("16");
		// 溢短结转方式
		req.setSplovCrrovMod("17");
		// 长约状态
		req.setArSt("18");
		// 时间戳
		Date date = new Date();
		req.setTms(date);
		// 创建人
		req.setCrtPsn("20");
		// 创建时间
		req.setCrtTm(date);
		// 确认人
		req.setCfmPsn("22");
		// 确认时间
		req.setCfmTm(date);
		// 一审审核意见
		req.setFrstinsCkop("24");
		// 一审审核人
		req.setFrstinsAdtPsn("25");
		// 一审审核时间
		req.setFrstinsAdtTm(date);
		// 二审审核意见
		req.setSndinscCkop("27");
		// 二审审核人
		req.setSndinsAdtPsn("28");
		// 二审审核时间
		req.setSndinsAdtTm(date);
		
        T1ARInf t1ARInf = new T1ARInf();
        BeanUtils.copyProperties(req, t1ARInf);
    	t1ARInfMapper.insertSelective(t1ARInf);
		List<TB0001SubInVo> list = new ArrayList<TB0001SubInVo>();
		TB0001SubInVo subInVo = new TB0001SubInVo();
		subInVo.setArId(req.getArId());
		subInVo.setAtchTp("12");
		subInVo.setRmrk("ee");
		subInVo.setCrtPsn("eeeee");
		subInVo.setCrtTm(date);
		subInVo.setTms(date);
		subInVo.setOriFileNm("22");
		subInVo.setSrFileNm("44");
		subInVo.setSrFileRte("667");
		list.add(subInVo);

		list.add(subInVo);

		list.add(subInVo);
	
		list.add(subInVo);

		list.add(subInVo);
		req.setList(list);
				
    	System.out.println("xxxxxxxxxxxxxxxxresult =" );
    	Result<Boolean> rlt = new Result<Boolean>();
        for(int i = 0; i < 10; i++ ) {
			rlt = tB0001DcService.save(req);
        }
		
		Condition condition = new Condition(T1ARInf.class);
        condition.orderBy("id").desc();
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("id = 1");

        List<T1ARInf> result = t1ARInfMapper.selectByCondition(condition);
        System.out.println("xxxxxxxxxxxxxxxxresult =" + JSON.toJSONString(result.get(0)));
        
		System.out.println(JSON.toJSONString(rlt));
	}
	
	@Test
	@Rollback(false)
	public void testQueryPage() {
		T1ARInfVo query = new T1ARInfVo();

		Result<PageData<T1ARInfVo>> rlt = t1ARInfDcService.queryPage(query, null);
		System.out.println("rrrrrrrrrrrr" + JSON.toJSONString(rlt));
	}

}
*/