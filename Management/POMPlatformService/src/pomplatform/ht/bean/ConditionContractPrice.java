package pomplatform.ht.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionContractPrice extends GenericCondition{

	public ConditionContractPrice(){
		setParameterCount(6);
	}

	public String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( Integer value ) {
		this.__main_project_stage_id = value;
	}

	public Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( Integer value ) {
		this.__client_id = value;
	}

	public String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( String value ) {
		this.__customer_name = value;
	}

	public Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( Integer value ) {
		this.__customer_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(1, "mainProjectStageId", getMainProjectStageId()));
		if(getClientId() != null) sb.append(__wrapNumber(1, "clientId", getClientId()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getCustomerId() != null) sb.append(__wrapNumber(1, "customerId", getCustomerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val)); 
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getMainProjectStageId() != null) res.add("mainProjectStageId");
		if(getClientId() != null) res.add("clientId");
		if(getCustomerName() != null) res.add("customerName");
		if(getCustomerId() != null) res.add("customerId");
		return res;
	}

	private String __project_code = null;
	private String __project_name = null;
	private Integer __main_project_stage_id = null;
	private Integer __client_id = null;
	private String __customer_name = null;
	private Integer __customer_id = null;
}

