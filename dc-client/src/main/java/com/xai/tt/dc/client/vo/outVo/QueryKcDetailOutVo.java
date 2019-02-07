package com.xai.tt.dc.client.vo.outVo;

import com.xai.tt.dc.client.model.T11IvntInf;
import com.xai.tt.dc.client.model.T13GdsDetail;

import java.util.List;

public class QueryKcDetailOutVo extends T11IvntInf {

    List<T13GdsDetail> t13GdsDetailList;

    // 用户角色参数权限信息
    List<String> roleParmsList;


    public List<T13GdsDetail> getT13GdsDetailList() {
        return t13GdsDetailList;
    }

    public void setT13GdsDetailList(List<T13GdsDetail> t13GdsDetailList) {
        this.t13GdsDetailList = t13GdsDetailList;
    }

    public List<String> getRoleParmsList() {
        return roleParmsList;
    }

    public void setRoleParmsList(List<String> roleParmsList) {
        this.roleParmsList = roleParmsList;
    }
}
