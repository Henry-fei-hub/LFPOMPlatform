package pomplatform.contractsRecords.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

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
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
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
	public final static java.lang.String CS_TRACK_TYPE = "track_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,主键编码,信息编号,项目名称,合同编码,合同名称,合同金额,合同签订状态,跟踪情况描述,跟踪时间,登记人,登记时间,相关人员,相关人员名称,客户名称,合同编号,跟踪类型1.合同跟踪，2.前期项目跟踪";
	public final static java.lang.String EXPORT_CAPTIONS = "信息编号,项目名称,合同编号,合同名称,合同金额,合同签订状态,跟踪情况描述,跟踪时间,登记人,相关人员名称,客户名称,跟踪类型";

	public java.lang.Integer getContractsRecordsId() {
		return this.__contracts_records_id;
	}

	public void setContractsRecordsId( java.lang.Integer value ) {
		this.__contracts_records_id = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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

	public java.lang.Integer getTrackType() {
		return this.__track_type;
	}

	public void setTrackType( java.lang.Integer value ) {
		this.__track_type = value;
	}

	public void cloneCopy(BaseContractsRecords __bean){
		__bean.setContractsRecordsId(getContractsRecordsId());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectName(getProjectName());
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
		__bean.setTrackType(getTrackType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		String status= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_139", String.valueOf(getContractStatus()));
		sb.append(getContractStatus() == null ? "" : status);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getTrackDate() == null ? "" : sdf.format(getTrackDate()));
		sb.append(",");
		String registerEmployee= delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getRegisterEmployee()));
		sb.append(getRegisterEmployee() == null ? "" : registerEmployee);
		sb.append(",");
		sb.append(getRelevantEmployeesName() == null ? "" : getRelevantEmployeesName().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName().replaceAll(",", "，"));
		sb.append(",");
		String trackType= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_209", String.valueOf(getTrackType()));
		sb.append(getTrackType() == null ? "" : trackType);
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
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
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
		hash = 97 * hash + Objects.hashCode(this.__track_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractsRecords o = (BaseContractsRecords)obj;
		if(!Objects.equals(this.__contracts_records_id, o.getContractsRecordsId())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
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
		if(!Objects.equals(this.__track_type, o.getTrackType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractsRecordsId() != null) sb.append(__wrapNumber(count++, "contractsRecordsId", getContractsRecordsId()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
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
		if(getTrackType() != null) sb.append(__wrapNumber(count++, "trackType", getTrackType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractsRecordsId")) != null) setContractsRecordsId(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
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
		if((val = values.get("trackType")) != null) setTrackType(__getInt(val)); 
	}

	protected java.lang.Integer  __contracts_records_id ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_name ;
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
	protected java.lang.Integer  __track_type ;
}
