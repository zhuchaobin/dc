package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.TSequence;
import tk.mybatis.mapper.common.Mapper;

public interface TSequenceMapper extends Mapper<TSequence> {
	Integer getSequence(TSequence tSequence);
}