package com.xai.tt.dc.client.model;

import javax.persistence.*;

@Table(name = "role_parms")
public class RoleParms {
    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    private String parms;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return parms
     */
    public String getParms() {
        return parms;
    }

    /**
     * @param parms
     */
    public void setParms(String parms) {
        this.parms = parms;
    }
}