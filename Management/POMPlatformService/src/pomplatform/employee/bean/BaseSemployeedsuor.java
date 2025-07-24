package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseEmployeeRole;

public class BaseSemployeedsuor extends GenericBase implements BaseFactory<BaseSemployeedsuor>, Comparable<BaseSemployeedsuor> 
{


	public static BaseSemployeedsuor newInstance(){
		return new BaseSemployeedsuor();
	}

	@Override
	public BaseSemployeedsuor make(){
		BaseSemployeedsuor b = new BaseSemployeedsuor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_EMPLOYEE_PASSWORD = "employee_password" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_RESIGNATION_DATE = "resignation_date" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_USABLE_STATUS = "usable_status" ;
	public final static java.lang.String CS_IS_DEPARTMENT = "is_department" ;
	public final static java.lang.String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工编号,员工姓名,部门编码,密码,手机,邮箱,入职日期,离职日期,是否离职,是否可用,是否为部门负责人,是否锁定";

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getEmployeePassword() {
		return this.__employee_password;
	}

	public void setEmployeePassword( java.lang.String value ) {
		this.__employee_password = value;
	}

	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}

	public java.lang.Boolean getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Boolean value ) {
		this.__status = value;
	}

	public java.lang.Boolean getUsableStatus() {
		return this.__usable_status;
	}

	public void setUsableStatus( java.lang.Boolean value ) {
		this.__usable_status = value;
	}

	public java.lang.Boolean getIsDepartment() {
		return this.__is_department;
	}

	public void setIsDepartment( java.lang.Boolean value ) {
		this.__is_department = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public java.util.List<BaseEmployeeRole> getDetailEmployeeRole() {
		return this.__detailEmployeeRole;
	}

	public void setDetailEmployeeRole( java.util.List<BaseEmployeeRole> value ) {
		this.__detailEmployeeRole = value;
	}

	public void cloneCopy(BaseSemployeedsuor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeePassword(getEmployeePassword());
		__bean.setMobile(getMobile());
		__bean.setEmail(getEmail());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setResignationDate(getResignationDate());
		__bean.setStatus(getStatus());
		__bean.setUsableStatus(getUsableStatus());
		__bean.setIsDepartment(getIsDepartment());
		__bean.setLocked(getLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getEmployeePassword() == null ? "" : getEmployeePassword());
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getResignationDate() == null ? "" : sdf.format(getResignationDate()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getUsableStatus() == null ? "" : getUsableStatus());
		sb.append(",");
		sb.append(getIsDepartment() == null ? "" : getIsDepartment());
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSemployeedsuor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_password);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__usable_status);
		hash = 97 * hash + Objects.hashCode(this.__is_department);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSemployeedsuor o = (BaseSemployeedsuor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_password, o.getEmployeePassword())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__usable_status, o.getUsableStatus())) return false;
		if(!Objects.equals(this.__is_department, o.getIsDepartment())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeePassword() != null) sb.append(__wrapString(count++, "employeePassword", getEmployeePassword()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(count++, "resignationDate", getResignationDate()));
		if(getStatus() != null) sb.append(__wrapBoolean(count++, "status", getStatus()));
		if(getUsableStatus() != null) sb.append(__wrapBoolean(count++, "usableStatus", getUsableStatus()));
		if(getIsDepartment() != null) sb.append(__wrapBoolean(count++, "isDepartment", getIsDepartment()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		if(getDetailEmployeeRole() != null)  sb.append(__wrapList(count++, "detailEmployeeRole", getDetailEmployeeRole()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeePassword")) != null) setEmployeePassword(__getString(val));
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getBoolean(val));
		if((val = values.get("usableStatus")) != null) setUsableStatus(__getBoolean(val));
		if((val = values.get("isDepartment")) != null) setIsDepartment(__getBoolean(val));
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("detailEmployeeRole")) != null) setDetailEmployeeRole(__getList(val, BaseEmployeeRole.newInstance()));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __employee_password ;
	protected java.lang.String  __mobile ;
	protected java.lang.String  __email ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __resignation_date ;
	protected java.lang.Boolean  __status ;
	protected java.lang.Boolean  __usable_status ;
	protected java.lang.Boolean  __is_department ;
	protected java.lang.Boolean  __locked ;
	protected java.util.List<BaseEmployeeRole> __detailEmployeeRole = null;
}
