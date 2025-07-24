package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePaymentTemplate extends GenericBase implements BaseFactory<BasePaymentTemplate>, Comparable<BasePaymentTemplate> 
{


	public static BasePaymentTemplate newInstance(){
		return new BasePaymentTemplate();
	}

	@Override
	public BasePaymentTemplate make(){
		BasePaymentTemplate b = new BasePaymentTemplate();
		return b;
	}

	public final static java.lang.String CS_PAYMENT_TEMPLATE_ID = "payment_template_id" ;
	public final static java.lang.String CS_TEMPLATE_NAME = "template_name" ;
	public final static java.lang.String CS_PAYMENT_CYCLE = "payment_cycle" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = ",模板名称,支付周期(天),备注,操作人,创建时间";

	public java.lang.Integer getPaymentTemplateId() {
		return this.__payment_template_id;
	}

	public void setPaymentTemplateId( java.lang.Integer value ) {
		this.__payment_template_id = value;
	}

	public java.lang.String getTemplateName() {
		return this.__template_name;
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
	}

	public java.lang.Integer getPaymentCycle() {
		return this.__payment_cycle;
	}

	public void setPaymentCycle( java.lang.Integer value ) {
		this.__payment_cycle = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BasePaymentTemplate __bean){
		__bean.setPaymentTemplateId(getPaymentTemplateId());
		__bean.setTemplateName(getTemplateName());
		__bean.setPaymentCycle(getPaymentCycle());
		__bean.setRemark(getRemark());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPaymentTemplateId() == null ? "" : getPaymentTemplateId());
		sb.append(",");
		sb.append(getTemplateName() == null ? "" : getTemplateName());
		sb.append(",");
		sb.append(getPaymentCycle() == null ? "" : getPaymentCycle());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BasePaymentTemplate o) {
		return __payment_template_id == null ? -1 : __payment_template_id.compareTo(o.getPaymentTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__payment_template_id);
		hash = 97 * hash + Objects.hashCode(this.__template_name);
		hash = 97 * hash + Objects.hashCode(this.__payment_cycle);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePaymentTemplate o = (BasePaymentTemplate)obj;
		if(!Objects.equals(this.__payment_template_id, o.getPaymentTemplateId())) return false;
		if(!Objects.equals(this.__template_name, o.getTemplateName())) return false;
		if(!Objects.equals(this.__payment_cycle, o.getPaymentCycle())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPaymentTemplateId() != null) sb.append(__wrapNumber(count++, "paymentTemplateId", getPaymentTemplateId()));
		if(getTemplateName() != null) sb.append(__wrapString(count++, "templateName", getTemplateName()));
		if(getPaymentCycle() != null) sb.append(__wrapNumber(count++, "paymentCycle", getPaymentCycle()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPaymentTemplateId() != null) res.put("paymentTemplateId", getPaymentTemplateId());
		if(getTemplateName() != null) res.put("templateName", getTemplateName());
		if(getPaymentCycle() != null) res.put("paymentCycle", getPaymentCycle());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("paymentTemplateId")) != null) setPaymentTemplateId(__getInt(val)); 
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("paymentCycle")) != null) setPaymentCycle(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __payment_template_id ;
	protected java.lang.String  __template_name ;
	protected java.lang.Integer  __payment_cycle ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
}
