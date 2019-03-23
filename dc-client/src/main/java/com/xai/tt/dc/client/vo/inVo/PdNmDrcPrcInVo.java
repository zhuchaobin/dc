package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 品名指导价请求报文
 * </pre>
 * <small> 2019-03-21 15:23:49 | zhuchaobin</small>
 */
 @Data
public class PdNmDrcPrcInVo extends UserInfoQuery {
	
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


    /** 品名ID */
    private Long pdId;


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
