package com.xai.tt.dc.client.vo.outVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 质押指导价返回报文
 * </pre>
 * <small> 2019-03-16 01:56:08 | xai-auto</small>
 */
 @Data
public class PlgDrcPrcOutVo extends UserInfoQuery {


    /** id */
    private Long id;


    /** 长约编号 */
    private String arId;


    /** 订单编号 */
    private String ordrId;


    /** 银行id */
    private Long bnk;


    /** 银行名称 */
    private String bnkNm;


    /** 品名id */
    private Long pdId;


    /** 品名 */
    private String pdNm;


    /** 规格 */
    private String spec;


    /** 质押指导价 */
    private Float plgDrcPrc;


    /** 操作员 */
    private String username;


    /** 创建时间 */
    private Date crtTm;


    /** 更新时间 */
    private Date udtTm;


    /** 时间戳 */
    private Date tms;


    /** 备注 */
    private String rmrk;

}
