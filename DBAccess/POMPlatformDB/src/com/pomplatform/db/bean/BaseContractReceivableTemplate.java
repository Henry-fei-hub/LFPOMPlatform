package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractReceivableTemplate extends GenericBase implements BaseFactory<BaseContractReceivableTemplate>, Comparable<BaseContractReceivableTemplate> 
{


	public static BaseContractReceivableTemplate newInstance(){
		return new BaseContractReceivableTemplate();
	}

	@Override
	public BaseContractReceivableTemplate make(){
		BaseContractReceivableTemplate b = new BaseContractReceivableTemplate();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_RECEIVABLE_TEMPLATE_ID = "contract_receivable_template_id" ;
	public final static java.lang.String CS_RECEIVABLE_NAME = "receivable_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_RECEIVABLE_PERCENTAGE = "receivable_percentage" ;

	public final static java.lang.String ALL_CAPTIONS = ",阶段名称,备注,收款阶段id的父节点,操作人,创建时间,修改时间,收款百分比";

	public java.lang.Integer getContractReceivableTemplateId() {
		return this.__contract_receivable_template_id;
	}

	public void setContractReceivableTemplateId( java.lang.Integer value ) {
		this.__contract_receivable_template_id = value;
	}

	public java.lang.String getReceivableName() {
		return this.__receivable_name;
	}

	public void setReceivableName( java.lang.String value ) {
		this.__receivable_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.math.BigDecimal getReceivablePercentage() {
		return this.__receivable_percentage;
	}

	public void setReceivablePercentage( java.math.BigDecimal value ) {
		this.__receivable_percentage = value;
	}

	public void cloneCopy(BaseContractReceivableTemplate __bean){
		__bean.setContractReceivableTemplateId(getContractReceivableTemplateId());
		__bean.setReceivableName(getReceivableName());
		__bean.setRemark(getRemark());
		__bean.setParentId(getParentId());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setReceivablePercentage(getReceivablePercentage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractReceivableTemplateId() == null ? "" : getContractReceivableTemplateId());
		sb.append(",");
		sb.append(getReceivableName() == null ? "" : getReceivableName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getReceivablePercentage() == null ? "" : getReceivablePercentage());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractReceivableTemplate o) {
		return __contract_receivable_template_id == null ? -1 : __contract_receivable_template_id.compareTo(o.getContractReceivableTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_template_id);
		hash = 97 * hash + Objects.hashCode(this.__receivable_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__receivable_percentage);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractReceivableTemplate o = (BaseContractReceivableTemplate)obj;
		if(!Objects.equals(this.__contract_receivable_template_id, o.getContractReceivableTemplateId())) return false;
		if(!Objects.equals(this.__receivable_name, o.getReceivableName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__receivable_percentage, o.getReceivablePercentage())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractReceivableTemplateId() != null) sb.append(__wrapNumber(count++, "contractReceivableTemplateId", getContractReceivableTemplateId()));
		if(getReceivableName() != null) sb.append(__wrapString(count++, "receivableName", getReceivableName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getReceivablePercentage() != null) sb.append(__wrapDecimal(count++, "receivablePercentage", getReceivablePercentage()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractReceivableTemplateId() != null) res.put("contractReceivableTemplateId", getContractReceivableTemplateId());
		if(getReceivableName() != null) res.put("receivableName", getReceivableName());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getReceivablePercentage() != null) res.put("receivablePercentage", getReceivablePercentage());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractReceivableTemplateId")) != null) setContractReceivableTemplateId(__getInt(val)); 
		if((val = values.get("receivableName")) != null) setReceivableName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("receivablePercentage")) != null) setReceivablePercentage(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_receivable_template_id ;
	protected java.lang.String  __receivable_name ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.math.BigDecimal  __receivable_percentage ;
}
