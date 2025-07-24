package pomplatform.orderplacement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadApplyListOfOrderInfo extends GenericCondition{

	public ConditionOnLoadApplyListOfOrderInfo(){
		setParameterCount(6);
	}

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( Integer value ) {
		this.__contract_id = value;
	}

	public String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( String value ) {
		this.__contract_code = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( String value ) {
		this.__contract_name = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProcessType() != null) res.add("processType");
		if(getContractId() != null) res.add("contractId");
		if(getContractCode() != null) res.add("contractCode");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getInfoCode() != null) res.add("infoCode");
		if(getContractName() != null) res.add("contractName");
		return res;
	}

	private Integer __process_type = null;
	private Integer __contract_id = null;
	private String __contract_code = null;
	private Integer __employee_id = null;
	private String __info_code = null;
	private String __contract_name = null;
}

