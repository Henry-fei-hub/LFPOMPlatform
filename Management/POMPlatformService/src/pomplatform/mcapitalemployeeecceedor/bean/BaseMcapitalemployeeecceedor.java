package pomplatform.mcapitalemployeeecceedor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcapitalemployeeecceedor extends GenericBase implements BaseFactory<BaseMcapitalemployeeecceedor>, Comparable<BaseMcapitalemployeeecceedor> 
{


	public static BaseMcapitalemployeeecceedor newInstance(){
		return new BaseMcapitalemployeeecceedor();
	}

	@Override
	public BaseMcapitalemployeeecceedor make(){
		BaseMcapitalemployeeecceedor b = new BaseMcapitalemployeeecceedor();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_EMPLOYEE_ID = "capital_employee_id" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_EN = "employee_name_en" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREAT_TIME = "creat_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,回款编码,员工主键,员工姓名,英文名,员工编号,部门,金额,操作人,创建时间";

	public java.lang.Integer getCapitalEmployeeId() {
		return this.__capital_employee_id;
	}

	public void setCapitalEmployeeId( java.lang.Integer value ) {
		this.__capital_employee_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNameEn() {
		return this.__employee_name_en;
	}

	public void setEmployeeNameEn( java.lang.String value ) {
		this.__employee_name_en = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreatTime() {
		return this.__creat_time;
	}

	public void setCreatTime( java.util.Date value ) {
		this.__creat_time = value;
	}

	public void cloneCopy(BaseMcapitalemployeeecceedor __bean){
		__bean.setCapitalEmployeeId(getCapitalEmployeeId());
		__bean.setCapitalId(getCapitalId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNameEn(getEmployeeNameEn());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setMoney(getMoney());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreatTime(getCreatTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalEmployeeId() == null ? "" : getCapitalEmployeeId());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getEmployeeNameEn() == null ? "" : getEmployeeNameEn());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreatTime() == null ? "" : sdf.format(getCreatTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcapitalemployeeecceedor o) {
		return __capital_employee_id == null ? -1 : __capital_employee_id.compareTo(o.getCapitalEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_en);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__creat_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcapitalemployeeecceedor o = (BaseMcapitalemployeeecceedor)obj;
		if(!Objects.equals(this.__capital_employee_id, o.getCapitalEmployeeId())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_name_en, o.getEmployeeNameEn())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__creat_time, o.getCreatTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalEmployeeId() != null) sb.append(__wrapNumber(count++, "capitalEmployeeId", getCapitalEmployeeId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEmployeeNameEn() != null) sb.append(__wrapString(count++, "employeeNameEn", getEmployeeNameEn()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreatTime() != null) sb.append(__wrapDate(count++, "creatTime", getCreatTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalEmployeeId")) != null) setCapitalEmployeeId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNameEn")) != null) setEmployeeNameEn(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("creatTime")) != null) setCreatTime(__getDate(val)); 
	}

	protected java.lang.Integer  __capital_employee_id ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_name_en ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __money ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __creat_time ;
}
