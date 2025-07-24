package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadFlowRefuseListOfCostAllocationBuisnessData extends GenericCondition{

	public ConditionOnLoadFlowRefuseListOfCostAllocationBuisnessData(){
		setParameterCount(16);
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}
	
	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getCustomerAddress() {
		return this.__customer_address == null ? null : (this.__customer_address.indexOf("%") >= 0 ? this.__customer_address : "%"+this.__customer_address+"%");
	}

	public void setCustomerAddress( java.lang.String value ) {
		this.__customer_address = value;
	}

	public java.lang.Integer getOldEmployeeId() {
		return this.__old_employee_id;
	}

	public void setOldEmployeeId( java.lang.Integer value ) {
		this.__old_employee_id = value;
	}
	
	public java.lang.Integer getTransferEmployeeId() {
		return this.__transfer_employee_id;
	}

	public void setTransferEmployeeId( java.lang.Integer value ) {
		this.__transfer_employee_id = value;
	}

	public java.util.Date getOperateTimeStart() {
		return this.__operate_time_start;
	}

	public void setOperateTimeStart( java.util.Date value ) {
		this.__operate_time_start = value;
	}

	public java.util.Date getOperateTimeEnd() {
		return this.__operate_time_end;
	}

	public void setOperateTimeEnd( java.util.Date value ) {
		this.__operate_time_end = value;
	}
	
	public java.lang.String getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.String value ) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getCustomerAddress() != null) sb.append(__wrapString(1, "customerAddress", getCustomerAddress()));
		if(getOldEmployeeId() != null) sb.append(__wrapNumber(1, "oldEmployeeId", getOldEmployeeId()));
		if(getTransferEmployeeId() != null) sb.append(__wrapNumber(1, "transferEmployeeId", getTransferEmployeeId()));
		if(getOperateTimeStart() != null) sb.append(__wrapDate(1, "operateTimeStart", getOperateTimeStart()));
		if(getOperateTimeEnd() != null) sb.append(__wrapDate(1, "operateTimeEnd", getOperateTimeEnd()));
		if(getProvince() != null) sb.append(__wrapString(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(1, "city", getCity()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("customerAddress")) != null) setCustomerAddress(__getString(val));
		if((val = values.get("oldEmployeeId")) != null) setOldEmployeeId(__getInt(val)); 
		if((val = values.get("transferEmployeeId")) != null) setTransferEmployeeId(__getInt(val)); 
		if((val = values.get("operateTimeStart")) != null) setOperateTimeStart(__getDate(val)); 
		if((val = values.get("operateTimeEnd")) != null) setOperateTimeEnd(__getDate(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
	}

	private java.lang.Integer __process_status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __status = null;
	private java.lang.String __customer_name = null;
	private java.lang.String __project_name = null;
	private java.lang.String __business_type = null;
	private java.lang.String __customer_address = null;
	private java.lang.Integer __old_employee_id = null;
	private java.lang.Integer __transfer_employee_id = null;
	private java.util.Date __operate_time_start = null;
	private java.util.Date __operate_time_end = null;
	private java.lang.String __province = null;
	private java.lang.String __city = null;
}

