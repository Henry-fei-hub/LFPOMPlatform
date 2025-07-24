package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeesOrders extends GenericBase implements BaseFactory<BaseEmployeesOrders>, Comparable<BaseEmployeesOrders> 
{


	public static BaseEmployeesOrders newInstance(){
		return new BaseEmployeesOrders();
	}

	@Override
	public BaseEmployeesOrders make(){
		BaseEmployeesOrders b = new BaseEmployeesOrders();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ESTATUS = "estatus" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PSTATUS = "pstatus" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编号,员工姓名,所属部门,在职状态,合同编号,项目名称,订单状态";

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getEstatus() {
		return this.__estatus;
	}

	public void setEstatus( java.lang.Integer value ) {
		this.__estatus = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getPstatus() {
		return this.__pstatus;
	}

	public void setPstatus( java.lang.Integer value ) {
		this.__pstatus = value;
	}

	public void cloneCopy(BaseEmployeesOrders __bean){
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEstatus(getEstatus());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setPstatus(getPstatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getEstatus() == null ? "" : getEstatus());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getPstatus() == null ? "" : getPstatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeesOrders o) {
		return __employee_no == null ? -1 : __employee_no.compareTo(o.getEmployeeNo());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__estatus);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__pstatus);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeesOrders o = (BaseEmployeesOrders)obj;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__estatus, o.getEstatus())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__pstatus, o.getPstatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEstatus() != null) sb.append(__wrapNumber(count++, "estatus", getEstatus()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getPstatus() != null) sb.append(__wrapNumber(count++, "pstatus", getPstatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getEstatus() != null) res.put("estatus", getEstatus());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getPstatus() != null) res.put("pstatus", getPstatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("estatus")) != null) setEstatus(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("pstatus")) != null) setPstatus(__getInt(val)); 
	}

	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __estatus ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __pstatus ;
}
