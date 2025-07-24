package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePoolManageEmployee extends GenericBase implements BaseFactory<BasePoolManageEmployee>, Comparable<BasePoolManageEmployee> 
{


	public static BasePoolManageEmployee newInstance(){
		return new BasePoolManageEmployee();
	}

	@Override
	public BasePoolManageEmployee make(){
		BasePoolManageEmployee b = new BasePoolManageEmployee();
		return b;
	}

	public final static java.lang.String CS_POOL_MANAGE_EMPLOYEE_ID = "pool_manage_employee_id" ;
	public final static java.lang.String CS_POOL_MANAGE_ID = "pool_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_BUSINESS_IDS = "business_ids" ;
	public final static java.lang.String CS_BUSINESS_NAMES = "business_names" ;
	public final static java.lang.String CS_PROFESSIONAL_IDS = "professional_ids" ;
	public final static java.lang.String CS_PROFESSIONAL_NAMES = "professional_names" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,池子id,人员,业态编码集,业态名称集,专业编码集,专业名称集,备注";

	public java.lang.Integer getPoolManageEmployeeId() {
		return this.__pool_manage_employee_id;
	}

	public void setPoolManageEmployeeId( java.lang.Integer value ) {
		this.__pool_manage_employee_id = value;
	}

	public java.lang.Integer getPoolManageId() {
		return this.__pool_manage_id;
	}

	public void setPoolManageId( java.lang.Integer value ) {
		this.__pool_manage_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getBusinessIds() {
		return this.__business_ids;
	}

	public void setBusinessIds( java.lang.String value ) {
		this.__business_ids = value;
	}

	public java.lang.String getBusinessNames() {
		return this.__business_names;
	}

	public void setBusinessNames( java.lang.String value ) {
		this.__business_names = value;
	}

	public java.lang.String getProfessionalIds() {
		return this.__professional_ids;
	}

	public void setProfessionalIds( java.lang.String value ) {
		this.__professional_ids = value;
	}

	public java.lang.String getProfessionalNames() {
		return this.__professional_names;
	}

	public void setProfessionalNames( java.lang.String value ) {
		this.__professional_names = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePoolManageEmployee __bean){
		__bean.setPoolManageEmployeeId(getPoolManageEmployeeId());
		__bean.setPoolManageId(getPoolManageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setBusinessIds(getBusinessIds());
		__bean.setBusinessNames(getBusinessNames());
		__bean.setProfessionalIds(getProfessionalIds());
		__bean.setProfessionalNames(getProfessionalNames());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPoolManageEmployeeId() == null ? "" : getPoolManageEmployeeId());
		sb.append(",");
		sb.append(getPoolManageId() == null ? "" : getPoolManageId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getBusinessIds() == null ? "" : getBusinessIds());
		sb.append(",");
		sb.append(getBusinessNames() == null ? "" : getBusinessNames());
		sb.append(",");
		sb.append(getProfessionalIds() == null ? "" : getProfessionalIds());
		sb.append(",");
		sb.append(getProfessionalNames() == null ? "" : getProfessionalNames());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePoolManageEmployee o) {
		return __pool_manage_employee_id == null ? -1 : __pool_manage_employee_id.compareTo(o.getPoolManageEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pool_manage_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__pool_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__business_ids);
		hash = 97 * hash + Objects.hashCode(this.__business_names);
		hash = 97 * hash + Objects.hashCode(this.__professional_ids);
		hash = 97 * hash + Objects.hashCode(this.__professional_names);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePoolManageEmployee o = (BasePoolManageEmployee)obj;
		if(!Objects.equals(this.__pool_manage_employee_id, o.getPoolManageEmployeeId())) return false;
		if(!Objects.equals(this.__pool_manage_id, o.getPoolManageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__business_ids, o.getBusinessIds())) return false;
		if(!Objects.equals(this.__business_names, o.getBusinessNames())) return false;
		if(!Objects.equals(this.__professional_ids, o.getProfessionalIds())) return false;
		if(!Objects.equals(this.__professional_names, o.getProfessionalNames())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPoolManageEmployeeId() != null) sb.append(__wrapNumber(count++, "poolManageEmployeeId", getPoolManageEmployeeId()));
		if(getPoolManageId() != null) sb.append(__wrapNumber(count++, "poolManageId", getPoolManageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getBusinessIds() != null) sb.append(__wrapString(count++, "businessIds", getBusinessIds()));
		if(getBusinessNames() != null) sb.append(__wrapString(count++, "businessNames", getBusinessNames()));
		if(getProfessionalIds() != null) sb.append(__wrapString(count++, "professionalIds", getProfessionalIds()));
		if(getProfessionalNames() != null) sb.append(__wrapString(count++, "professionalNames", getProfessionalNames()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPoolManageEmployeeId() != null) res.put("poolManageEmployeeId", getPoolManageEmployeeId());
		if(getPoolManageId() != null) res.put("poolManageId", getPoolManageId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getBusinessIds() != null) res.put("businessIds", getBusinessIds());
		if(getBusinessNames() != null) res.put("businessNames", getBusinessNames());
		if(getProfessionalIds() != null) res.put("professionalIds", getProfessionalIds());
		if(getProfessionalNames() != null) res.put("professionalNames", getProfessionalNames());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("poolManageEmployeeId")) != null) setPoolManageEmployeeId(__getInt(val)); 
		if((val = values.get("poolManageId")) != null) setPoolManageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("businessIds")) != null) setBusinessIds(__getString(val));
		if((val = values.get("businessNames")) != null) setBusinessNames(__getString(val));
		if((val = values.get("professionalIds")) != null) setProfessionalIds(__getString(val));
		if((val = values.get("professionalNames")) != null) setProfessionalNames(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __pool_manage_employee_id ;
	protected java.lang.Integer  __pool_manage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __business_ids ;
	protected java.lang.String  __business_names ;
	protected java.lang.String  __professional_ids ;
	protected java.lang.String  __professional_names ;
	protected java.lang.String  __remark ;
}
