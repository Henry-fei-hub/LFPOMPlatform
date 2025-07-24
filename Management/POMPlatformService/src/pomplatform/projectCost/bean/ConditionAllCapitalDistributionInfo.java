package pomplatform.projectCost.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAllCapitalDistributionInfo extends GenericCondition{

	public ConditionAllCapitalDistributionInfo(){
		setParameterCount(8);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.util.Date getStartHappenDate() {
		return this.__start_happen_date;
	}

	public void setStartHappenDate( java.util.Date value ) {
		this.__start_happen_date = value;
	}

	public java.util.Date getEndHappenDate() {
		return this.__end_happen_date;
	}

	public void setEndHappenDate( java.util.Date value ) {
		this.__end_happen_date = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public java.util.Date getStartDistributeTime() {
		return this.__start_distribute_time;
	}

	public void setStartDistributeTime( java.util.Date value ) {
		this.__start_distribute_time = value;
	}

	public java.util.Date getEndDistributeTime() {
		return this.__end_distribute_time;
	}

	public void setEndDistributeTime( java.util.Date value ) {
		this.__end_distribute_time = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getStartHappenDate() != null) sb.append(__wrapDate(1, "startHappenDate", getStartHappenDate()));
		if(getEndHappenDate() != null) sb.append(__wrapDate(1, "endHappenDate", getEndHappenDate()));
		if(getLocked() != null) sb.append(__wrapBoolean(1, "locked", getLocked()));
		if(getStartDistributeTime() != null) sb.append(__wrapDate(1, "startDistributeTime", getStartDistributeTime()));
		if(getEndDistributeTime() != null) sb.append(__wrapDate(1, "endDistributeTime", getEndDistributeTime()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("startHappenDate")) != null) setStartHappenDate(__getDate(val)); 
		if((val = values.get("endHappenDate")) != null) setEndHappenDate(__getDate(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("startDistributeTime")) != null) setStartDistributeTime(__getDate(val)); 
		if((val = values.get("endDistributeTime")) != null) setEndDistributeTime(__getDate(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.util.Date __start_happen_date = null;
	private java.util.Date __end_happen_date = null;
	private java.lang.Boolean __locked = null;
	private java.util.Date __start_distribute_time = null;
	private java.util.Date __end_distribute_time = null;
	private java.lang.Integer __project_manage_id = null;
}

