package pomplatform.subContractInfo.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadContractByMainProjectEmployeeId extends GenericBase implements BaseFactory<BaseOnLoadContractByMainProjectEmployeeId>, Comparable<BaseOnLoadContractByMainProjectEmployeeId> 
{


	public static BaseOnLoadContractByMainProjectEmployeeId newInstance(){
		return new BaseOnLoadContractByMainProjectEmployeeId();
	}

	@Override
	public BaseOnLoadContractByMainProjectEmployeeId make(){
		BaseOnLoadContractByMainProjectEmployeeId b = new BaseOnLoadContractByMainProjectEmployeeId();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_RELATION = "relation" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_EMPLOYEE_ID = "main_project_employee_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,主项目编码,主订单编号,主订单名称,员工和主项目的关系    1项目秘书   2运营董事   3项目经理   4项目主管领导 5.项目负责人,员工编码,编码";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
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

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getMainProjectEmployeeId() {
		return this.__main_project_employee_id;
	}

	public void setMainProjectEmployeeId( java.lang.Integer value ) {
		this.__main_project_employee_id = value;
	}

	public void cloneCopy(BaseOnLoadContractByMainProjectEmployeeId __bean){
		__bean.setContractId(getContractId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setRelation(getRelation());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMainProjectEmployeeId(getMainProjectEmployeeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getRelation() == null ? "" : getRelation());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getMainProjectEmployeeId() == null ? "" : getMainProjectEmployeeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadContractByMainProjectEmployeeId o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__relation);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_employee_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadContractByMainProjectEmployeeId o = (BaseOnLoadContractByMainProjectEmployeeId)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__relation, o.getRelation())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__main_project_employee_id, o.getMainProjectEmployeeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getRelation() != null) sb.append(__wrapNumber(count++, "relation", getRelation()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMainProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "mainProjectEmployeeId", getMainProjectEmployeeId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getRelation() != null) res.put("relation", getRelation());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getMainProjectEmployeeId() != null) res.put("mainProjectEmployeeId", getMainProjectEmployeeId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("mainProjectEmployeeId")) != null) setMainProjectEmployeeId(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __relation ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __main_project_employee_id ;
}
