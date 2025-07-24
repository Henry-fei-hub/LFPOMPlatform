package pomplatform.financialStatements.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScapitalipcor extends GenericCondition{

	public ConditionScapitalipcor(){
		setParameterCount(11);
	}

	public java.util.Date getMinHappenDate() {
		return this.__min_happen_date;
	}

	public void setMinHappenDate( java.util.Date value ) {
		this.__min_happen_date = value;
	}

	public java.util.Date getMaxHappenDate() {
		return this.__max_happen_date;
	}

	public void setMaxHappenDate( java.util.Date value ) {
		this.__max_happen_date = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.Integer getCapitalType() {
		return this.__capital_type;
	}

	public void setCapitalType( java.lang.Integer value ) {
		this.__capital_type = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		if(getCapitalType() != null) sb.append(__wrapNumber(1, "capitalType", getCapitalType()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("capitalType")) != null) setCapitalType(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
	private java.lang.String __info_code = null;
	private java.lang.String __project_code = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __capital_id = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __money_attribute = null;
	private java.lang.Integer __self_name = null;
	private java.lang.Integer __capital_type = null;
	private java.lang.Integer __process_status = null;
}

