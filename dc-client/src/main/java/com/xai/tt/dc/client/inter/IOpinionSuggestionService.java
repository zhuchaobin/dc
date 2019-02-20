package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.client.entity.OpinionSuggestion;
import com.xai.tt.dc.client.query.OpinionSuggestionQuery;

/**
 * Created by linkun
 */
public interface IOpinionSuggestionService {

    /**
     * 1.支持分页条件查询
     *
     * @param opinionSuggestionQuery
     * @return
     */
    Result<PageInfo<OpinionSuggestion>> queryPage(OpinionSuggestionQuery opinionSuggestionQuery);


    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Result<OpinionSuggestion> findOpinionSuggestionById(Integer id);

    /**
     * 新增保存 (新增保存,修改保存
     * @param opinionSuggestion
     * @return
     */
    Result<?> saveOpinionSuggestion(OpinionSuggestion opinionSuggestion);

    /**
     * 根据Id删除
     *
     * @param id
     * @return
     */
    Result<?> delById(Integer id);
}
