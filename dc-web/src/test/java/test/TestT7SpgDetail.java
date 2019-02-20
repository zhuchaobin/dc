/*package test;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.App;
import com.xai.tt.dc.biz.mapper.T1ArInfMapper;
import com.xai.tt.dc.biz.mapper.T7SpgDetailMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.model.T7SpgDetail;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.TB0001SubInVo;
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
public class TestT7SpgDetail {

	@Autowired
	private WfDcService wfDcService;
	@Autowired
	private T7SpgDetailMapper t7SpgDetailMapper;
	@Test
	@Rollback(false)
	public void testSave() {


		T7SpgDetail t7SpgDetail = new T7SpgDetail();
		t7SpgDetail.setSpgId("1");
		t7SpgDetail.setPdNm("1");
		t7SpgDetail.setSpec("1");
		t7SpgDetail.setQlyStd("1");
		t7SpgDetail.setBrnd("1");
		t7SpgDetail.setPdFctr("1");
		t7SpgDetail.setNum(1.0F);


		t7SpgDetailMapper.insert(t7SpgDetail);

	}
	

}
*/