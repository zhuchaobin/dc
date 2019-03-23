package com.xai.tt.dc.client.vo.outVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 企业信息2返回报文
 * </pre>
 * <small> 2019-03-23 23:10:26 | zhuchaobin</small>
 */
 @Data
public class Company2OutVo extends UserInfoQuery {


    /**  */
    private Integer id;


    /**  */
    private Date createTime;


    /** 代码 */
    private String code;


    /** 名称 */
    private String name;


    /** 负责人 */
    private String managerName;


    /** 邮件 */
    private String email;


    /** 电话号 */
    private String mobile;


    /** 省份 */
    private String province;


    /** 城市 */
    private String city;


    /** 地址信息 */
    private String address;


    /** 是否冻结 冻结:TRUE  ;未冻结：FALSE */
    private Boolean locked;


    /** 用户类型 */
    private String usrTp;


    /** 注册地址 */
    private String rgtads;


    /** 纳税人识别号 */
    private String taxpyrIdNo;


    /** 开户行 */
    private String depbnk;


    /** 银行账户号 */
    private String bnkAccNo;


    /** 备注 */
    private String rmrk;


    /** 企业社会信用代码 */
    private String entpSocCrCd;

}
