package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePaymentTemplateDetail extends GenericBase implements BaseFactory<BasePaymentTemplateDetail>, Comparable<BasePaymentTemplateDetail> 
{


	public static BasePaymentTemplateDetail newInstance(){
		return new BasePaymentTemplateDetail();
	}

	@Override
	public BasePaymentTemplateDetail make(){
		BasePaymentTemplateDetail b = new BasePaymentTemplateDetail();
		return b;
	}

	public final static java.lang.String CS_PAYMENT_TEMPLATE_DETAIL_ID = "payment_template_detail_id" ;
	public final static java.lang.String CS_PAYMENT_TEMPLATE_ID = "payment_template_id" ;
	public final static java.lang.String CS_PAYMENT_NAME = "payment_name" ;
	public final static java.lang.String CS_DELAY_DAY = "delay_day" ;
	public final static java.lang.String CS_ORDER_NUM = "order_num" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PAYMENT_CONDITION = "payment_condition" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PAYMENT_RATIO = "payment_ratio" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,模板主表主键,支付名称(预付款、第一次付款),延迟天数,排序值  升序排列,创建时间,付款条件,备注,付款比例";

	public java.lang.Integer getPaymentTemplateDetailId() {
		return this.__payment_template_detail_id;
	}

	public void setPaymentTemplateDetailId( java.lang.Integer value ) {
		this.__payment_template_detail_id = value;
	}

	public java.lang.Integer getPaymentTemplateId() {
		return this.__payment_template_id;
	}

	public void setPaymentTemplateId( java.lang.Integer value ) {
		this.__payment_template_id = value;
	}

	public java.lang.String getPaymentName() {
		return this.__payment_name;
	}

	public void setPaymentName( java.lang.String value ) {
		this.__payment_name = value;
	}

	public java.lang.Integer getDelayDay() {
		return this.__delay_day;
	}

	public void setDelayDay( java.lang.Integer value ) {
		this.__delay_day = value;
	}

	public java.lang.Integer getOrderNum() {
		return this.__order_num;
	}

	public void setOrderNum( java.lang.Integer value ) {
		this.__order_num = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getPaymentCondition() {
		return this.__payment_condition;
	}

	public void setPaymentCondition( java.lang.String value ) {
		this.__payment_condition = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.math.BigDecimal getPaymentRatio() {
		return this.__payment_ratio;
	}

	public void setPaymentRatio( java.math.BigDecimal value ) {
		this.__payment_ratio = value;
	}

	public void cloneCopy(BasePaymentTemplateDetail __bean){
		__bean.setPaymentTemplateDetailId(getPaymentTemplateDetailId());
		__bean.setPaymentTemplateId(getPaymentTemplateId());
		__bean.setPaymentName(getPaymentName());
		__bean.setDelayDay(getDelayDay());
		__bean.setOrderNum(getOrderNum());
		__bean.setCreateTime(getCreateTime());
		__bean.setPaymentCondition(getPaymentCondition());
		__bean.setRemark(getRemark());
		__bean.setPaymentRatio(getPaymentRatio());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPaymentTemplateDetailId() == null ? "" : getPaymentTemplateDetailId());
		sb.append(",");
		sb.append(getPaymentTemplateId() == null ? "" : getPaymentTemplateId());
		sb.append(",");
		sb.append(getPaymentName() == null ? "" : getPaymentName());
		sb.append(",");
		sb.append(getDelayDay() == null ? "" : getDelayDay());
		sb.append(",");
		sb.append(getOrderNum() == null ? "" : getOrderNum());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getPaymentCondition() == null ? "" : getPaymentCondition());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPaymentRatio() == null ? "" : getPaymentRatio());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePaymentTemplateDetail o) {
		return __payment_template_detail_id == null ? -1 : __payment_template_detail_id.compareTo(o.getPaymentTemplateDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__payment_template_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_template_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_name);
		hash = 97 * hash + Objects.hashCode(this.__delay_day);
		hash = 97 * hash + Objects.hashCode(this.__order_num);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__payment_condition);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__payment_ratio);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePaymentTemplateDetail o = (BasePaymentTemplateDetail)obj;
		if(!Objects.equals(this.__payment_template_detail_id, o.getPaymentTemplateDetailId())) return false;
		if(!Objects.equals(this.__payment_template_id, o.getPaymentTemplateId())) return false;
		if(!Objects.equals(this.__payment_name, o.getPaymentName())) return false;
		if(!Objects.equals(this.__delay_day, o.getDelayDay())) return false;
		if(!Objects.equals(this.__order_num, o.getOrderNum())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__payment_condition, o.getPaymentCondition())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__payment_ratio, o.getPaymentRatio())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPaymentTemplateDetailId() != null) sb.append(__wrapNumber(count++, "paymentTemplateDetailId", getPaymentTemplateDetailId()));
		if(getPaymentTemplateId() != null) sb.append(__wrapNumber(count++, "paymentTemplateId", getPaymentTemplateId()));
		if(getPaymentName() != null) sb.append(__wrapString(count++, "paymentName", getPaymentName()));
		if(getDelayDay() != null) sb.append(__wrapNumber(count++, "delayDay", getDelayDay()));
		if(getOrderNum() != null) sb.append(__wrapNumber(count++, "orderNum", getOrderNum()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getPaymentCondition() != null) sb.append(__wrapString(count++, "paymentCondition", getPaymentCondition()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPaymentRatio() != null) sb.append(__wrapDecimal(count++, "paymentRatio", getPaymentRatio()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPaymentTemplateDetailId() != null) res.put("paymentTemplateDetailId", getPaymentTemplateDetailId());
		if(getPaymentTemplateId() != null) res.put("paymentTemplateId", getPaymentTemplateId());
		if(getPaymentName() != null) res.put("paymentName", getPaymentName());
		if(getDelayDay() != null) res.put("delayDay", getDelayDay());
		if(getOrderNum() != null) res.put("orderNum", getOrderNum());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getPaymentCondition() != null) res.put("paymentCondition", getPaymentCondition());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getPaymentRatio() != null) res.put("paymentRatio", getPaymentRatio());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("paymentTemplateDetailId")) != null) setPaymentTemplateDetailId(__getInt(val)); 
		if((val = values.get("paymentTemplateId")) != null) setPaymentTemplateId(__getInt(val)); 
		if((val = values.get("paymentName")) != null) setPaymentName(__getString(val));
		if((val = values.get("delayDay")) != null) setDelayDay(__getInt(val)); 
		if((val = values.get("orderNum")) != null) setOrderNum(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("paymentCondition")) != null) setPaymentCondition(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("paymentRatio")) != null) setPaymentRatio(__getDecimal(val));  
	}

	protected java.lang.Integer  __payment_template_detail_id ;
	protected java.lang.Integer  __payment_template_id ;
	protected java.lang.String  __payment_name ;
	protected java.lang.Integer  __delay_day ;
	protected java.lang.Integer  __order_num ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __payment_condition ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __payment_ratio ;
}
