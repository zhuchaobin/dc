package com.xai.tt.dc.biz.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.tianan.kltsp.mc.client.service.MultiAppJpushService;
import com.xai.tt.dc.client.service.PdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NcPrcJob implements SimpleJob {
	
	private static final Logger logger = LoggerFactory.getLogger(NcPrcJob.class);
	
	@Autowired
	private PdService pdService;
	

	@Override
	public void execute(ShardingContext arg0) {
		logger.info("开始执行南储商务网定时任务 》》》》》");
		pdService.savePrc();
	}

}
