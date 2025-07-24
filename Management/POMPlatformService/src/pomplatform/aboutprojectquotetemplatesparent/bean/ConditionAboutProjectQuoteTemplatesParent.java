package pomplatform.aboutprojectquotetemplatesparent.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAboutProjectQuoteTemplatesParent extends GenericCondition{

	public ConditionAboutProjectQuoteTemplatesParent(){
		setParameterCount(7);
	}

	public java.lang.String getParentName() {
		return this.__parent_name == null ? null : (this.__parent_name.indexOf("%") >= 0 ? this.__parent_name : "%"+this.__parent_name+"%");
	}

	public void setParentName( java.lang.String value ) {
		this.__parent_name = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateDateStart() {
		return this.__create_date_start;
	}

	public void setCreateDateStart( java.util.Date value ) {
		this.__create_date_start = value;
	}

	public java.util.Date getCreateDateEnd() {
		return this.__create_date_end;
	}

	public void setCreateDateEnd( java.util.Date value ) {
		this.__create_date_end = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getParentName() != null) sb.append(__wrapString(1, "parentName", getParentName()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(1, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateDateStart() != null) sb.append(__wrapDate(1, "createDateStart", getCreateDateStart()));
		if(getCreateDateEnd() != null) sb.append(__wrapDate(1, "createDateEnd", getCreateDateEnd()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("parentName")) != null) setParentName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createDateStart")) != null) setCreateDateStart(__getDate(val)); 
		if((val = values.get("createDateEnd")) != null) setCreateDateEnd(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	private java.lang.String __parent_name = null;
	private java.lang.Integer __business_type = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __create_employee_id = null;
	private java.util.Date __create_date_start = null;
	private java.util.Date __create_date_end = null;
	private java.lang.String __remark = null;
}

