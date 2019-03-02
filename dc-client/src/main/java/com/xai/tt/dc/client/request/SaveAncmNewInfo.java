package com.xai.tt.dc.client.request;

import com.xai.tt.dc.client.entity.KnowledgeCatalogInfo;
import com.xai.tt.dc.client.model.T14AncmNews;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linkun
 */
public class SaveAncmNewInfo extends T14AncmNews implements Serializable{

    private String fileNames;
    private String username;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFileNames() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
    }
}
