package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.client.entity.KnowledgeCatalog;
import com.xai.tt.dc.client.entity.KnowledgeCatalogInfo;
import com.xai.tt.dc.client.model.T14AncmNews;
import com.xai.tt.dc.client.query.KeyWordsQuery;
import com.xai.tt.dc.client.query.KnowledgeCatalogQuery;
import com.xai.tt.dc.client.request.SaveAncmNewInfo;
import com.xai.tt.dc.client.request.SaveKnowledgeCatalogInfo;
import com.xai.tt.dc.client.response.AncmNewsInfoRes;
import com.xai.tt.dc.client.response.KnowledgeCatalogInfoRes;

/**
 * Created by linkun
 */
public interface IAncmNewsBaseService {

    /**
     * 分页查询公告新闻
     * @param KeyWordsQuery
     * @return
     */
    Result<PageInfo<T14AncmNews>> queryPage(KeyWordsQuery keyWordsQuery);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Result<AncmNewsInfoRes> findAncmNewsById(Integer id);

    /**
     * 新增保存 (新增保存,修改保存)
     * @param T14AncmNews
     * @return
     */
    Result<?> saveAncmNewInfo(SaveAncmNewInfo saveAncmNewInfo);

    /**
     *   根据Id删除知识库内容
     * @param id
     * @return
     */
    Result<?> delInfoById(Integer id);
}
