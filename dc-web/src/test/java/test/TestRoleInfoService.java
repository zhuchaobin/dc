package test;

import com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.App;

import com.xai.tt.dc.client.inter.RoleInfoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
//@ContextConfiguration({ "classpath*:*dubbo-reference.xml" })
public class TestRoleInfoService {

	@Autowired
	private RoleInfoService roleInfoService;



	@Test
	@Rollback(false)
	public void testQuerySpecialDiv() {

		Result<String> res = roleInfoService.querySpecialDiv("TT");



		System.out.println("###########"+JSON.toJSONString(res));

	}


}
