package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.client.entity.HelpFaq;
import com.xai.tt.dc.client.query.HelpFaqQuery;

/**
 * Created by linkun
 */
public interface IHelpFaqService {
    /**
     * 1.支持分页条件查询
     *
     * @param helpFaqQuery
     * @return
     */
    Result<PageInfo<HelpFaq>> queryPage(HelpFaqQuery helpFaqQuery);


    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Result<HelpFaq> findHelpFaqById(Integer id);

    /**
     * 新增保存 (新增保存,修改保存)
     * @param companyIntroduce
     * @return
     */
    Result<?> saveHelpFaq(HelpFaq companyIntroduce);


    /**
     * 根据Id删除
     * @param id
     * @return
     */
    Result<?> delById(Integer id);

}
