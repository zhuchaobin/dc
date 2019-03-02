package com.xai.tt.dc.client.request;

import com.xai.tt.dc.client.entity.KnowledgeCatalogInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linkun
 */
public class SaveKnowledgeCatalogInfo extends KnowledgeCatalogInfo implements Serializable{

    private String fileNames;

    public String getFileNames() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
    }
}
