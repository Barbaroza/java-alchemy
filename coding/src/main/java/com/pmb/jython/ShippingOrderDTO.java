package com.pmb.jython;

import lombok.Data;

/**
 * @author lvrui
 */
@Data
public class ShippingOrderDTO {
    private Long id;
    private Integer originType;
    private Integer orderStatus;
    //订单号
    private String originId;
    //订单创建时间
    private Long orderCreateTime;
    //需求板数
    private Integer demandCapacitySize;
    private Long createUserId;
    //有效期 截至时间
    private Long deadline;
    //申请人联系方式
    private String applicantContactInfo;
    //收货人联系方式
    private String consigneeContactInfo;
    //申请人
    private String applicant;
    //收货人
    private String consignee;
    //出发站点
    private Integer srcStationId;
    //目标站点
    private Integer dstStationId;
}
