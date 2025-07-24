package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractsRecords extends GenericBase implements BaseFactory<BaseContractsRecords>, Comparable<BaseContractsRecords> 
{


	public static BaseContractsRecords newInstance(){
		return new BaseContractsRecords();
	}

	@Override
	public BaseContractsRecords make(){
		BaseContractsRecords b = new BaseContractsRecords();
		return b;
	}

	public final static java.lang.String CS_CONTRACTS_RECORDS_ID = "contracts_records_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_TRACK_DATE = "track_date" ;
	public final static java.lang.String CS_REGISTER_EMPLOYEE = "register_employee" ;
	public final static java.lang.String CS_REGISTER_DATE = "register_date" ;
	public final static java.lang.String CS_RELEVANT_EMPLOYEES = "relevant_employees" ;
	public final static java.lang.String CS_RELEVANT_EMPLOYEES_NAME = "relevant_employees_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_SENDING_DATE = "sending_date" ;
	public final static java.lang.String CS_TRACK_TYPE = "track_type" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,合同编码,合同名称,合同金额,合同签订状态,跟踪情况描述,跟踪时间,登记人,登记时间,相关人员,相关人员名称,客户名称,合同编号,合同签订日期,合同寄出日期,跟踪类型1.合同跟踪，2.前期项目跟踪,信息编号";

	public java.lang.Integer getContractsRecordsId() {
		return this.__contracts_records_id;
	}

	public void setContractsRecordsId( java.lang.Integer value ) {
		this.__contracts_records_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getTrackDate() {
		return this.__track_date;
	}

	public void setTrackDate( java.util.Date value ) {
		this.__track_date = value;
	}

	public java.lang.Integer getRegisterEmployee() {
		return this.__register_employee;
	}

	public void setRegisterEmployee( java.lang.Integer value ) {
		this.__register_employee = value;
	}

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}

	public java.lang.String getRelevantEmployees() {
		return this.__relevant_employees;
	}

	public void setRelevantEmployees( java.lang.String value ) {
		this.__relevant_employees = value;
	}

	public java.lang.String getRelevantEmployeesName() {
		return this.__relevant_employees_name;
	}

	public void setRelevantEmployeesName( java.lang.String value ) {
		this.__relevant_employees_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public java.util.Date getSendingDate() {
		return this.__sending_date;
	}

	public void setSendingDate( java.util.Date value ) {
		this.__sending_date = value;
	}

	public java.lang.Integer getTrackType() {
		return this.__track_type;
	}

	public void setTrackType( java.lang.Integer value ) {
		this.__track_type = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public void cloneCopy(BaseContractsRecords __bean){
		__bean.setContractsRecordsId(getContractsRecordsId());
		__bean.setContractId(getContractId());
		__bean.setContractName(getContractName());
		__bean.setContractAmount(getContractAmount());
		__bean.setContractStatus(getContractStatus());
		__bean.setRemark(getRemark());
		__bean.setTrackDate(getTrackDate());
		__bean.setRegisterEmployee(getRegisterEmployee());
		__bean.setRegisterDate(getRegisterDate());
		__bean.setRelevantEmployees(getRelevantEmployees());
		__bean.setRelevantEmployeesName(getRelevantEmployeesName());
		__bean.setCustomerName(getCustomerName());
		__bean.setContractCode(getContractCode());
		__bean.setContractDate(getContractDate());
		__bean.setSendingDate(getSendingDate());
		__bean.setTrackType(getTrackType());
		__bean.setInfoCode(getInfoCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractsRecordsId() == null ? "" : getContractsRecordsId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getContractStatus() == null ? "" : getContractStatus());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getTrackDate() == null ? "" : sdf.format(getTrackDate()));
		sb.append(",");
		sb.append(getRegisterEmployee() == null ? "" : getRegisterEmployee());
		sb.append(",");
		sb.append(getRegisterDate() == null ? "" : sdf.format(getRegisterDate()));
		sb.append(",");
		sb.append(getRelevantEmployees() == null ? "" : getRelevantEmployees());
		sb.append(",");
		sb.append(getRelevantEmployeesName() == null ? "" : getRelevantEmployeesName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getSendingDate() == null ? "" : sdf.format(getSendingDate()));
		sb.append(",");
		sb.append(getTrackType() == null ? "" : getTrackType());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractsRecords o) {
		return __contracts_records_id == null ? -1 : __contracts_records_id.compareTo(o.getContractsRecordsId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contracts_records_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__track_date);
		hash = 97 * hash + Objects.hashCode(this.__register_employee);
		hash = 97 * hash + Objects.hashCode(this.__register_date);
		hash = 97 * hash + Objects.hashCode(this.__relevant_employees);
		hash = 97 * hash + Objects.hashCode(this.__relevant_employees_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__sending_date);
		hash = 97 * hash + Objects.hashCode(this.__track_type);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractsRecords o = (BaseContractsRecords)obj;
		if(!Objects.equals(this.__contracts_records_id, o.getContractsRecordsId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__track_date, o.getTrackDate())) return false;
		if(!Objects.equals(this.__register_employee, o.getRegisterEmployee())) return false;
		if(!Objects.equals(this.__register_date, o.getRegisterDate())) return false;
		if(!Objects.equals(this.__relevant_employees, o.getRelevantEmployees())) return false;
		if(!Objects.equals(this.__relevant_employees_name, o.getRelevantEmployeesName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__sending_date, o.getSendingDate())) return false;
		if(!Objects.equals(this.__track_type, o.getTrackType())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractsRecordsId() != null) sb.append(__wrapNumber(count++, "contractsRecordsId", getContractsRecordsId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getTrackDate() != null) sb.append(__wrapDate(count++, "trackDate", getTrackDate()));
		if(getRegisterEmployee() != null) sb.append(__wrapNumber(count++, "registerEmployee", getRegisterEmployee()));
		if(getRegisterDate() != null) sb.append(__wrapDate(count++, "registerDate", getRegisterDate()));
		if(getRelevantEmployees() != null) sb.append(__wrapString(count++, "relevantEmployees", getRelevantEmployees()));
		if(getRelevantEmployeesName() != null) sb.append(__wrapString(count++, "relevantEmployeesName", getRelevantEmployeesName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getSendingDate() != null) sb.append(__wrapDate(count++, "sendingDate", getSendingDate()));
		if(getTrackType() != null) sb.append(__wrapNumber(count++, "trackType", getTrackType()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractsRecordsId")) != null) setContractsRecordsId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("trackDate")) != null) setTrackDate(__getDate(val)); 
		if((val = values.get("registerEmployee")) != null) setRegisterEmployee(__getInt(val)); 
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val)); 
		if((val = values.get("relevantEmployees")) != null) setRelevantEmployees(__getString(val));
		if((val = values.get("relevantEmployeesName")) != null) setRelevantEmployeesName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("sendingDate")) != null) setSendingDate(__getDate(val)); 
		if((val = values.get("trackType")) != null) setTrackType(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
	}

	protected java.lang.Integer  __contracts_records_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.Integer  __contract_status ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __track_date ;
	protected java.lang.Integer  __register_employee ;
	protected java.util.Date  __register_date ;
	protected java.lang.String  __relevant_employees ;
	protected java.lang.String  __relevant_employees_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __contract_code ;
	protected java.util.Date  __contract_date ;
	protected java.util.Date  __sending_date ;
	protected java.lang.Integer  __track_type ;
	protected java.lang.String  __info_code ;
}
