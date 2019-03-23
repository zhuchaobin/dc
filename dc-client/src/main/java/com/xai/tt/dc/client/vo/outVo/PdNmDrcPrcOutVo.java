package com.xai.tt.dc.client.vo.outVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 品名指导价返回报文
 * </pre>
 * <small> 2019-03-21 15:23:49 | zhuchaobin</small>
 */
 @Data
public class PdNmDrcPrcOutVo extends UserInfoQuery {


    /** ID */
    private Long id;


    /** 品名ID */
    private Long pdId;
    
    /** 品名 */
    private String pdNm;


    /** 获取日期 */
    private String acqDt;


    /** 来源类型代码 */
    private String srcTpcd;


    /** 来源描述 */
    private String srcDsc;


    /** 指导价 */
    private Float drcPrc;


    /** 时间戳 */
    private Date tms;


    /** 操作员 */
    private String username;


    /** 备注 */
    private String rmrk;

}
