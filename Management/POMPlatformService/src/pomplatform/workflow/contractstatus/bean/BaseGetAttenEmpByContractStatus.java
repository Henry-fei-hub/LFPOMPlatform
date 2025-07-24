package pomplatform.workflow.contractstatus.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGetAttenEmpByContractStatus extends GenericBase implements BaseFactory<BaseGetAttenEmpByContractStatus>, Comparable<BaseGetAttenEmpByContractStatus> 
{


	public static BaseGetAttenEmpByContractStatus newInstance(){
		return new BaseGetAttenEmpByContractStatus();
	}

	@Override
	public BaseGetAttenEmpByContractStatus make(){
		BaseGetAttenEmpByContractStatus b = new BaseGetAttenEmpByContractStatus();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SENDING_DATE = "sending_date" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编号,主订单名称,合同寄出日期,报备人,报备人所在部门负责人";

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.util.Date getSendingDate() {
		return this.__sending_date;
	}

	public void setSendingDate( java.util.Date value ) {
		this.__sending_date = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public void cloneCopy(BaseGetAttenEmpByContractStatus __bean){
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSendingDate(getSendingDate());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setEmployeeId(getEmployeeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSendingDate() == null ? "" : sdf.format(getSendingDate()));
		sb.append(",");
		String strApplyEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplyEmployeeId()));
		sb.append(strApplyEmployeeId == null ? "" : strApplyEmployeeId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetAttenEmpByContractStatus o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__sending_date);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetAttenEmpByContractStatus o = (BaseGetAttenEmpByContractStatus)obj;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__sending_date, o.getSendingDate())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSendingDate() != null) sb.append(__wrapDate(count++, "sendingDate", getSendingDate()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getSendingDate() != null) res.put("sendingDate", getSendingDate());
		if(getApplyEmployeeId() != null) res.put("applyEmployeeId", getApplyEmployeeId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("sendingDate")) != null) setSendingDate(__getDate(val)); 
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.util.Date  __sending_date ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __employee_id ;
}
