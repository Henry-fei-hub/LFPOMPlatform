package pomplatform.clocks.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeFingers extends GenericBase implements BaseFactory<BaseEmployeeFingers>, Comparable<BaseEmployeeFingers> 
{


	public static BaseEmployeeFingers newInstance(){
		return new BaseEmployeeFingers();
	}

	@Override
	public BaseEmployeeFingers make(){
		BaseEmployeeFingers b = new BaseEmployeeFingers();
		return b;
	}

	public final static java.lang.String CS_HR_EMP_FINGER_ID = "hr_emp_finger_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SN = "sn" ;
	public final static java.lang.String CS_EMP_CODE = "emp_code" ;
	public final static java.lang.String CS_TEMPLATE = "template" ;
	public final static java.lang.String CS_FPVERSION = "fpversion" ;
	public final static java.lang.String CS_FINGER_TYPE = "finger_type" ;
	public final static java.lang.String CS_SIZE = "size" ;
	public final static java.lang.String CS_VALID = "valid" ;
	public final static java.lang.String CS_IS_ACTIVE = "is_active" ;
	public final static java.lang.String CS_FID = "fid" ;
	public final static java.lang.String CS_UTIME = "utime" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,序列号,考勤号码,指纹,指纹版本,指纹类型,大小,有效日期,是否可用,指纹序号,时区,员工编号,员工姓名,部门";

	public java.lang.Integer getHrEmpFingerId() {
		return this.__hr_emp_finger_id;
	}

	public void setHrEmpFingerId( java.lang.Integer value ) {
		this.__hr_emp_finger_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getSn() {
		return this.__sn;
	}

	public void setSn( java.lang.String value ) {
		this.__sn = value;
	}

	public java.lang.String getEmpCode() {
		return this.__emp_code;
	}

	public void setEmpCode( java.lang.String value ) {
		this.__emp_code = value;
	}

	public java.lang.String getTemplate() {
		return this.__template;
	}

	public void setTemplate( java.lang.String value ) {
		this.__template = value;
	}

	public java.lang.Integer getFpversion() {
		return this.__fpversion;
	}

	public void setFpversion( java.lang.Integer value ) {
		this.__fpversion = value;
	}

	public java.lang.Integer getFingerType() {
		return this.__finger_type;
	}

	public void setFingerType( java.lang.Integer value ) {
		this.__finger_type = value;
	}

	public java.lang.Integer getSize() {
		return this.__size;
	}

	public void setSize( java.lang.Integer value ) {
		this.__size = value;
	}

	public java.lang.Integer getValid() {
		return this.__valid;
	}

	public void setValid( java.lang.Integer value ) {
		this.__valid = value;
	}

	public java.lang.Integer getIsActive() {
		return this.__is_active;
	}

	public void setIsActive( java.lang.Integer value ) {
		this.__is_active = value;
	}

	public java.lang.Integer getFid() {
		return this.__fid;
	}

	public void setFid( java.lang.Integer value ) {
		this.__fid = value;
	}

	public java.util.Date getUtime() {
		return this.__utime;
	}

	public void setUtime( java.util.Date value ) {
		this.__utime = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BaseEmployeeFingers __bean){
		__bean.setHrEmpFingerId(getHrEmpFingerId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSn(getSn());
		__bean.setEmpCode(getEmpCode());
		__bean.setTemplate(getTemplate());
		__bean.setFpversion(getFpversion());
		__bean.setFingerType(getFingerType());
		__bean.setSize(getSize());
		__bean.setValid(getValid());
		__bean.setIsActive(getIsActive());
		__bean.setFid(getFid());
		__bean.setUtime(getUtime());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getHrEmpFingerId() == null ? "" : getHrEmpFingerId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getSn() == null ? "" : getSn());
		sb.append(",");
		sb.append(getEmpCode() == null ? "" : getEmpCode());
		sb.append(",");
		sb.append(getTemplate() == null ? "" : getTemplate());
		sb.append(",");
		sb.append(getFpversion() == null ? "" : getFpversion());
		sb.append(",");
		sb.append(getFingerType() == null ? "" : getFingerType());
		sb.append(",");
		sb.append(getSize() == null ? "" : getSize());
		sb.append(",");
		sb.append(getValid() == null ? "" : getValid());
		sb.append(",");
		sb.append(getIsActive() == null ? "" : getIsActive());
		sb.append(",");
		sb.append(getFid() == null ? "" : getFid());
		sb.append(",");
		sb.append(getUtime() == null ? "" : sdf.format(getUtime()));
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeFingers o) {
		return __hr_emp_finger_id == null ? -1 : __hr_emp_finger_id.compareTo(o.getHrEmpFingerId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__hr_emp_finger_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__sn);
		hash = 97 * hash + Objects.hashCode(this.__emp_code);
		hash = 97 * hash + Objects.hashCode(this.__template);
		hash = 97 * hash + Objects.hashCode(this.__fpversion);
		hash = 97 * hash + Objects.hashCode(this.__finger_type);
		hash = 97 * hash + Objects.hashCode(this.__size);
		hash = 97 * hash + Objects.hashCode(this.__valid);
		hash = 97 * hash + Objects.hashCode(this.__is_active);
		hash = 97 * hash + Objects.hashCode(this.__fid);
		hash = 97 * hash + Objects.hashCode(this.__utime);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeFingers o = (BaseEmployeeFingers)obj;
		if(!Objects.equals(this.__hr_emp_finger_id, o.getHrEmpFingerId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__sn, o.getSn())) return false;
		if(!Objects.equals(this.__emp_code, o.getEmpCode())) return false;
		if(!Objects.equals(this.__template, o.getTemplate())) return false;
		if(!Objects.equals(this.__fpversion, o.getFpversion())) return false;
		if(!Objects.equals(this.__finger_type, o.getFingerType())) return false;
		if(!Objects.equals(this.__size, o.getSize())) return false;
		if(!Objects.equals(this.__valid, o.getValid())) return false;
		if(!Objects.equals(this.__is_active, o.getIsActive())) return false;
		if(!Objects.equals(this.__fid, o.getFid())) return false;
		if(!Objects.equals(this.__utime, o.getUtime())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getHrEmpFingerId() != null) sb.append(__wrapNumber(count++, "hrEmpFingerId", getHrEmpFingerId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSn() != null) sb.append(__wrapString(count++, "sn", getSn()));
		if(getEmpCode() != null) sb.append(__wrapString(count++, "empCode", getEmpCode()));
		if(getTemplate() != null) sb.append(__wrapString(count++, "template", getTemplate()));
		if(getFpversion() != null) sb.append(__wrapNumber(count++, "fpversion", getFpversion()));
		if(getFingerType() != null) sb.append(__wrapNumber(count++, "fingerType", getFingerType()));
		if(getSize() != null) sb.append(__wrapNumber(count++, "size", getSize()));
		if(getValid() != null) sb.append(__wrapNumber(count++, "valid", getValid()));
		if(getIsActive() != null) sb.append(__wrapNumber(count++, "isActive", getIsActive()));
		if(getFid() != null) sb.append(__wrapNumber(count++, "fid", getFid()));
		if(getUtime() != null) sb.append(__wrapDate(count++, "utime", getUtime()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("hrEmpFingerId")) != null) setHrEmpFingerId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("sn")) != null) setSn(__getString(val));
		if((val = values.get("empCode")) != null) setEmpCode(__getString(val));
		if((val = values.get("template")) != null) setTemplate(__getString(val));
		if((val = values.get("fpversion")) != null) setFpversion(__getInt(val)); 
		if((val = values.get("fingerType")) != null) setFingerType(__getInt(val)); 
		if((val = values.get("size")) != null) setSize(__getInt(val)); 
		if((val = values.get("valid")) != null) setValid(__getInt(val)); 
		if((val = values.get("isActive")) != null) setIsActive(__getInt(val)); 
		if((val = values.get("fid")) != null) setFid(__getInt(val)); 
		if((val = values.get("utime")) != null) setUtime(__getDate(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	protected java.lang.Integer  __hr_emp_finger_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __sn ;
	protected java.lang.String  __emp_code ;
	protected java.lang.String  __template ;
	protected java.lang.Integer  __fpversion ;
	protected java.lang.Integer  __finger_type ;
	protected java.lang.Integer  __size ;
	protected java.lang.Integer  __valid ;
	protected java.lang.Integer  __is_active ;
	protected java.lang.Integer  __fid ;
	protected java.util.Date  __utime ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
}
