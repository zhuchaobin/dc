/*package test;

import com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.App;

import com.xai.tt.dc.client.inter.R1LnkInfDefService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
//@ContextConfiguration({ "classpath*:*dubbo-reference.xml" })
public class TestR1LnkInfDefService {

	@Autowired
	private R1LnkInfDefService r1LnkInfDefService;



	@Test
	@Rollback(false)
	public void testQuerySpecialDiv() {

		Result<String> res = r1LnkInfDefService.querySpecialDiv("61");



		System.out.println("###########"+JSON.toJSONString(res));

	}


}
*/