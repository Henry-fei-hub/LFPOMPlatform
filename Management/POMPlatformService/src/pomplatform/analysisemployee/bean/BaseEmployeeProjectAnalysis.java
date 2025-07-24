package pomplatform.analysisemployee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeProjectAnalysis extends GenericBase implements BaseFactory<BaseEmployeeProjectAnalysis>, Comparable<BaseEmployeeProjectAnalysis> 
{


	public static BaseEmployeeProjectAnalysis newInstance(){
		return new BaseEmployeeProjectAnalysis();
	}

	@Override
	public BaseEmployeeProjectAnalysis make(){
		BaseEmployeeProjectAnalysis b = new BaseEmployeeProjectAnalysis();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_ISBUSY = "isbusy" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工编号,员工姓名,业务部门,归属部门,剩余积分,参与项目数量,状态";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public java.lang.Long getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Long value ) {
		this.__num = value;
	}

	public java.lang.Integer getIsbusy() {
		return this.__isbusy;
	}

	public void setIsbusy( java.lang.Integer value ) {
		this.__isbusy = value;
	}

	public void cloneCopy(BaseEmployeeProjectAnalysis __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setNum(getNum());
		__bean.setIsbusy(getIsbusy());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getIsbusy() == null ? "" : getIsbusy());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeProjectAnalysis o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__isbusy);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeProjectAnalysis o = (BaseEmployeeProjectAnalysis)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__isbusy, o.getIsbusy())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getIsbusy() != null) sb.append(__wrapNumber(count++, "isbusy", getIsbusy()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getLong(val)); 
		if((val = values.get("isbusy")) != null) setIsbusy(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __left_integral ;
	protected java.lang.Long  __num ;
	protected java.lang.Integer  __isbusy ;
}
