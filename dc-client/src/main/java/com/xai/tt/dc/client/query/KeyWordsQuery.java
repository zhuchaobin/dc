package com.xai.tt.dc.client.query;

import com.xai.tt.dc.client.request.PageQuery;

/**
 * Created by linkun
 */
public class KeyWordsQuery extends PageQuery {

    /**
     * 关键字
     */
    private String keyWorlds;

    public String getKeyWorlds() {
        return keyWorlds;
    }

    public void setKeyWorlds(String keyWorlds) {
        this.keyWorlds = keyWorlds;
    }
}
