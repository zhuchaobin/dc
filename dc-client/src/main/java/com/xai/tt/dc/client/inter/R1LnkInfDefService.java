package com.xai.tt.dc.client.inter;

import com.tianan.common.api.bean.Result;

public interface R1LnkInfDefService {


    /**
     * 查询个性化字段
     * @param aplyPcstpCd
     * @return
     */
    Result<String> querySpecialDiv(String aplyPcstpCd);

}
