package test;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.tianan.kltsp.dc.App;
import com.tianan.kltsp.dc.biz.mapper.T1ARInfMapper;
import com.tianan.kltsp.dc.client.entity.T1ARInf;
import com.tianan.kltsp.dc.client.inter.T1ARInfDcService;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = App.class) 
//@ContextConfiguration({ "classpath*:*dubbo-reference.xml" })
public class TestT1ARInf{
	
	@Autowired
	private T1ARInfDcService t1ARInfDcService2;
	@Autowired
	private T1ARInfMapper t1ARInfMapper;
		
	@Test
	@Rollback(false)
	public void testSave() {
		T1ARInf req = new T1ARInf();
		// ID
		req.setId(3);
		// 长约编号
		req.setArId("4");
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
		req.setFncPctg("11");
		// 预付金比率
		req.setPrpyGldRto("12");
		// 额度
		req.setLmt("13");
		// 警戒线
		req.setCrdn("14");
		// 平仓线
		req.setClsposLn("15");
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

		
		Condition condition = new Condition(T1ARInf.class);
        condition.orderBy("id").desc();
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("id = 1");

        List<T1ARInf> result = t1ARInfMapper.selectByCondition(condition);
        System.out.println("xxxxxxxxxxxxxxxxresult =" + JSON.toJSONString(result.get(0)));
        
		Result<Boolean> rlt = t1ARInfDcService2.save(req);
		System.out.println(JSON.toJSONString(rlt));
	}
	
/*	@Test
	@Rollback(false)
	public void testQueryPage() {
		T1ARInfVo query = new T1ARInfVo();

		Result<PageData<T1ARInfVo>> rlt = t1ARInfDcService.queryPage(query, null);
		System.out.println("rrrrrrrrrrrr" + JSON.toJSONString(rlt));
	}*/

}
