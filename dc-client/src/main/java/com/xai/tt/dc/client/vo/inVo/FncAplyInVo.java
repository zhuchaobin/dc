package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 融资申请请求报文
 * </pre>
 * <small> 2019-03-20 23:41:27 | zhuchaobin</small>
 */
 @Data
public class FncAplyInVo extends UserInfoQuery {
	
	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	/**
     * 全字段模糊检索关键字
     */
	private String secSrvCd;


    /** ID */
    private Long id;


    /** 公司全称 */
    private String companyName;


    /** 电子邮箱 */
    private String email;


    /** 联系人 */
    private String ctcpsn;


    /** 联系电话 */
    private String ctcTel;


    /** 融资需求描述 */
    private String fncRqmDsc;


    /** 申请时间 */
    private Date aplyTm;


    /** 申请渠道 */
    private String aplyChnl;


    /** 修改时间 */
    private Date modTm;


    /** 处理人 */
    private String username;


    /** 处理时间 */
    private Date pcsTm;


    /** 处理备注 */
    private String rmrk;

}
