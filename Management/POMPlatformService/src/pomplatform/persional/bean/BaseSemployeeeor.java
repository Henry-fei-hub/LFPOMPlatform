package pomplatform.persional.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSemployeeeor extends GenericBase implements BaseFactory<BaseSemployeeeor>, Comparable<BaseSemployeeeor> 
{


	public static BaseSemployeeeor newInstance(){
		return new BaseSemployeeeor();
	}

	@Override
	public BaseSemployeeeor make(){
		BaseSemployeeeor b = new BaseSemployeeeor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ROLE_ID = "role_id" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_PHONE = "phone" ;
	public final static java.lang.String CS_QQ = "qq" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_PHOTO = "photo" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工编号,员工姓名,角色编码,部门编码,等级,手机,电话,QQ,邮箱,头像,家庭地址,板块";

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

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( java.lang.Integer value ) {
		this.__grade_id = value;
	}

	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
	}

	public java.lang.String getPhone() {
		return this.__phone;
	}

	public void setPhone( java.lang.String value ) {
		this.__phone = value;
	}

	public java.lang.String getQq() {
		return this.__qq;
	}

	public void setQq( java.lang.String value ) {
		this.__qq = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.lang.String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( java.lang.String value ) {
		this.__photo = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public void cloneCopy(BaseSemployeeeor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRoleId(getRoleId());
		__bean.setGradeId(getGradeId());
		__bean.setMobile(getMobile());
		__bean.setPhone(getPhone());
		__bean.setQq(getQq());
		__bean.setEmail(getEmail());
		__bean.setPhoto(getPhoto());
		__bean.setAddress(getAddress());
		__bean.setPlateId(getPlateId());
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
		sb.append(getRoleId() == null ? "" : getRoleId());
		sb.append(",");
		sb.append(getGradeId() == null ? "" : getGradeId());
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getPhone() == null ? "" : getPhone());
		sb.append(",");
		sb.append(getQq() == null ? "" : getQq());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getPhoto() == null ? "" : getPhoto());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSemployeeeor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__role_id);
		hash = 97 * hash + Objects.hashCode(this.__grade_id);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__phone);
		hash = 97 * hash + Objects.hashCode(this.__qq);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSemployeeeor o = (BaseSemployeeeor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__role_id, o.getRoleId())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__phone, o.getPhone())) return false;
		if(!Objects.equals(this.__qq, o.getQq())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
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
		if(getRoleId() != null) sb.append(__wrapNumber(count++, "roleId", getRoleId()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getPhone() != null) sb.append(__wrapString(count++, "phone", getPhone()));
		if(getQq() != null) sb.append(__wrapString(count++, "qq", getQq()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("phone")) != null) setPhone(__getString(val));
		if((val = values.get("qq")) != null) setQq(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __role_id ;
	protected java.lang.Integer  __grade_id ;
	protected java.lang.String  __mobile ;
	protected java.lang.String  __phone ;
	protected java.lang.String  __qq ;
	protected java.lang.String  __email ;
	protected java.lang.String  __photo ;
	protected java.lang.String  __address ;
	protected java.lang.Integer  __plate_id ;
}
