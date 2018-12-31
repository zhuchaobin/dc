package test;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.App;
import com.xai.tt.dc.biz.mapper.T1ArInfMapper;
import com.xai.tt.dc.biz.mapper.T6SpgInfMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.model.T6SpgInf;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.T6SpgInfDetailVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.TB0001SubInVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageSpgOutVo;
import com.xai.tt.dc.client.vo.outVo.QuerySpgInfDetailOutVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = App.class) 
//@ContextConfiguration({ "classpath*:*dubbo-reference.xml" })
public class TestT6SpgInfMapper {


	@Autowired
	private T6SpgInfMapper t6SpgInfMapper;

	@Test
	@Rollback(false)
	public void testSave() {

		T6SpgInf t6SpgInf = new T6SpgInf();
		t6SpgInf.setArId("CY201811250111");
		t6SpgInf.setOrdrId("1");
		t6SpgInf.setSpgId("1");
		t6SpgInf.setProcessInstId("1");
		t6SpgInf.setSpgTm(new Date());
		t6SpgInf.setSpgPsn("1");
		t6SpgInf.setSpgPsnCtcTel("1");
		t6SpgInf.setCnsgn("1");
		t6SpgInf.setCnsgnCtcTel("1");
		t6SpgInf.setPpsLnd("1");
		t6SpgInf.setTms(new Date());
		t6SpgInf.setSpgSt("1");
		t6SpgInf.setUsername("1");
		t6SpgInf.setCrtTm(new Date());

		t6SpgInfMapper.insert(t6SpgInf);


	}

	@Test
	@Rollback(false)
	public void testQuerySpgDetail() {

		QuerySpgInfDetailOutVo querySpgInfDetailOutVo = t6SpgInfMapper.querySpgDetail(4);
		System.out.println("========="+ JSON.toJSONString(querySpgInfDetailOutVo));
	}


	@Test
	@Rollback(false)
	public void testQuerySpgDetailBySpgId() {

		QuerySpgInfDetailOutVo querySpgInfDetailOutVo = t6SpgInfMapper.querySpgDetailBySpgId("1");
		System.out.println("========="+ JSON.toJSONString(querySpgInfDetailOutVo));
	}








}
