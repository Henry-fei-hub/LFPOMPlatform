package pomplatform.workflow.contractstatus.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractStatusMonth extends GenericBase implements BaseFactory<BaseContractStatusMonth>, Comparable<BaseContractStatusMonth> 
{


	public static BaseContractStatusMonth newInstance(){
		return new BaseContractStatusMonth();
	}

	@Override
	public BaseContractStatusMonth make(){
		BaseContractStatusMonth b = new BaseContractStatusMonth();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_MONTH = "contract_month" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_LEADER = "department_leader" ;

	public final static java.lang.String ALL_CAPTIONS = "合同,月份数,合同编号,合同名称,报备人,报备人所在部门负责人";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getContractMonth() {
		return this.__contract_month;
	}

	public void setContractMonth( java.lang.Integer value ) {
		this.__contract_month = value;
	}

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

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.String getDepartmentLeader() {
		return this.__department_leader;
	}

	public void setDepartmentLeader( java.lang.String value ) {
		this.__department_leader = value;
	}

	public void cloneCopy(BaseContractStatusMonth __bean){
		__bean.setContractId(getContractId());
		__bean.setContractMonth(getContractMonth());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setDepartmentLeader(getDepartmentLeader());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getContractMonth() == null ? "" : getContractMonth());
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		String strApplyEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplyEmployeeId()));
		sb.append(strApplyEmployeeId == null ? "" : strApplyEmployeeId);
		sb.append(",");
		sb.append(getDepartmentLeader() == null ? "" : getDepartmentLeader());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractStatusMonth o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_month);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_leader);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractStatusMonth o = (BaseContractStatusMonth)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_month, o.getContractMonth())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__department_leader, o.getDepartmentLeader())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractMonth() != null) sb.append(__wrapNumber(count++, "contractMonth", getContractMonth()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getDepartmentLeader() != null) sb.append(__wrapString(count++, "departmentLeader", getDepartmentLeader()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractMonth() != null) res.put("contractMonth", getContractMonth());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getApplyEmployeeId() != null) res.put("applyEmployeeId", getApplyEmployeeId());
		if(getDepartmentLeader() != null) res.put("departmentLeader", getDepartmentLeader());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractMonth")) != null) setContractMonth(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("departmentLeader")) != null) setDepartmentLeader(__getString(val));
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __contract_month ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.String  __department_leader ;
}
