package pomplatform.projectteambuild.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSemployeeedror extends GenericBase implements BaseFactory<BaseSemployeeedror>, Comparable<BaseSemployeeedror> 
{


	public static BaseSemployeeedror newInstance(){
		return new BaseSemployeeedror();
	}

	@Override
	public BaseSemployeeedror make(){
		BaseSemployeeedror b = new BaseSemployeeedror();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_ROLE_ID = "role_id" ;
	public final static String CS_GRADE_ID = "grade_id" ;
	public final static String CS_EMPLOYEE_PASSWORD = "employee_password" ;
	public final static String CS_MOBILE = "mobile" ;
	public final static String CS_PHONE = "phone" ;
	public final static String CS_QQ = "qq" ;
	public final static String CS_EMAIL = "email" ;
	public final static String CS_ONBOARD_DATE = "onboard_date" ;
	public final static String CS_RESIGNATION_DATE = "resignation_date" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_USABLE_STATUS = "usable_status" ;
	public final static String CS_IS_DEPARTMENT = "is_department" ;
	public final static String CS_PHOTO = "photo" ;
	public final static String CS_GENDER = "gender" ;
	public final static String CS_AUTOGRAPH = "autograph" ;
	public final static String CS_AGE = "age" ;
	public final static String CS_BIRTH = "birth" ;
	public final static String CS_CARD = "card" ;
	public final static String CS_ADDRESS = "address" ;
	public final static String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工编号,员工姓名,角色编码,部门编码,等级,密码,手机,电话,QQ,邮箱,入职日期,离职日期,状态,是否可用,是否为部门负责人,头像,性别,我的签名,age,出生日期,身份证号,家庭地址,是否锁定";

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( Integer value ) {
		this.__role_id = value;
	}

	public Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( Integer value ) {
		this.__grade_id = value;
	}

	public String getEmployeePassword() {
		return this.__employee_password;
	}

	public void setEmployeePassword( String value ) {
		this.__employee_password = value;
	}

	public String getMobile() {
		return this.__mobile;
	}

	public void setMobile( String value ) {
		this.__mobile = value;
	}

	public String getPhone() {
		return this.__phone;
	}

	public void setPhone( String value ) {
		this.__phone = value;
	}

	public String getQq() {
		return this.__qq;
	}

	public void setQq( String value ) {
		this.__qq = value;
	}

	public String getEmail() {
		return this.__email;
	}

	public void setEmail( String value ) {
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

	public Integer getStatus() {
		return this.__status;
	}

	public void setStatus( Integer value ) {
		this.__status = value;
	}

	public Boolean getUsableStatus() {
		return this.__usable_status;
	}

	public void setUsableStatus( Boolean value ) {
		this.__usable_status = value;
	}

	public Boolean getIsDepartment() {
		return this.__is_department;
	}

	public void setIsDepartment( Boolean value ) {
		this.__is_department = value;
	}

	public String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( String value ) {
		this.__photo = value;
	}

	public Integer getGender() {
		return this.__gender;
	}

	public void setGender( Integer value ) {
		this.__gender = value;
	}

	public String getAutograph() {
		return this.__autograph;
	}

	public void setAutograph( String value ) {
		this.__autograph = value;
	}

	public Integer getAge() {
		return this.__age;
	}

	public void setAge( Integer value ) {
		this.__age = value;
	}

	public java.util.Date getBirth() {
		return this.__birth;
	}

	public void setBirth( java.util.Date value ) {
		this.__birth = value;
	}

	public String getCard() {
		return this.__card;
	}

	public void setCard( String value ) {
		this.__card = value;
	}

	public String getAddress() {
		return this.__address;
	}

	public void setAddress( String value ) {
		this.__address = value;
	}

	public Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( Boolean value ) {
		this.__locked = value;
	}

	public void cloneCopy(BaseSemployeeedror __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRoleId(getRoleId());
		__bean.setGradeId(getGradeId());
		__bean.setEmployeePassword(getEmployeePassword());
		__bean.setMobile(getMobile());
		__bean.setPhone(getPhone());
		__bean.setQq(getQq());
		__bean.setEmail(getEmail());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setResignationDate(getResignationDate());
		__bean.setStatus(getStatus());
		__bean.setUsableStatus(getUsableStatus());
		__bean.setIsDepartment(getIsDepartment());
		__bean.setPhoto(getPhoto());
		__bean.setGender(getGender());
		__bean.setAutograph(getAutograph());
		__bean.setAge(getAge());
		__bean.setBirth(getBirth());
		__bean.setCard(getCard());
		__bean.setAddress(getAddress());
		__bean.setLocked(getLocked());
	}

	public String toCSVString() {

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
		sb.append(getEmployeePassword() == null ? "" : getEmployeePassword());
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getPhone() == null ? "" : getPhone());
		sb.append(",");
		sb.append(getQq() == null ? "" : getQq());
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
		sb.append(getPhoto() == null ? "" : getPhoto());
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		sb.append(getAutograph() == null ? "" : getAutograph());
		sb.append(",");
		sb.append(getAge() == null ? "" : getAge());
		sb.append(",");
		sb.append(getBirth() == null ? "" : sdf.format(getBirth()));
		sb.append(",");
		sb.append(getCard() == null ? "" : getCard());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSemployeeedror o) {
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
		hash = 97 * hash + Objects.hashCode(this.__employee_password);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__phone);
		hash = 97 * hash + Objects.hashCode(this.__qq);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__usable_status);
		hash = 97 * hash + Objects.hashCode(this.__is_department);
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__autograph);
		hash = 97 * hash + Objects.hashCode(this.__age);
		hash = 97 * hash + Objects.hashCode(this.__birth);
		hash = 97 * hash + Objects.hashCode(this.__card);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSemployeeedror o = (BaseSemployeeedror)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__role_id, o.getRoleId())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		if(!Objects.equals(this.__employee_password, o.getEmployeePassword())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__phone, o.getPhone())) return false;
		if(!Objects.equals(this.__qq, o.getQq())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__usable_status, o.getUsableStatus())) return false;
		if(!Objects.equals(this.__is_department, o.getIsDepartment())) return false;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__autograph, o.getAutograph())) return false;
		if(!Objects.equals(this.__age, o.getAge())) return false;
		if(!Objects.equals(this.__birth, o.getBirth())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRoleId() != null) sb.append(__wrapNumber(count++, "roleId", getRoleId()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		if(getEmployeePassword() != null) sb.append(__wrapString(count++, "employeePassword", getEmployeePassword()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getPhone() != null) sb.append(__wrapString(count++, "phone", getPhone()));
		if(getQq() != null) sb.append(__wrapString(count++, "qq", getQq()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(count++, "resignationDate", getResignationDate()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getUsableStatus() != null) sb.append(__wrapBoolean(count++, "usableStatus", getUsableStatus()));
		if(getIsDepartment() != null) sb.append(__wrapBoolean(count++, "isDepartment", getIsDepartment()));
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getAutograph() != null) sb.append(__wrapString(count++, "autograph", getAutograph()));
		if(getAge() != null) sb.append(__wrapNumber(count++, "age", getAge()));
		if(getBirth() != null) sb.append(__wrapDate(count++, "birth", getBirth()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getRoleId() != null) res.put("roleId", getRoleId());
		if(getGradeId() != null) res.put("gradeId", getGradeId());
		if(getEmployeePassword() != null) res.put("employeePassword", getEmployeePassword());
		if(getMobile() != null) res.put("mobile", getMobile());
		if(getPhone() != null) res.put("phone", getPhone());
		if(getQq() != null) res.put("qq", getQq());
		if(getEmail() != null) res.put("email", getEmail());
		if(getOnboardDate() != null) res.put("onboardDate", getOnboardDate());
		if(getResignationDate() != null) res.put("resignationDate", getResignationDate());
		if(getStatus() != null) res.put("status", getStatus());
		if(getUsableStatus() != null) res.put("usableStatus", getUsableStatus());
		if(getIsDepartment() != null) res.put("isDepartment", getIsDepartment());
		if(getPhoto() != null) res.put("photo", getPhoto());
		if(getGender() != null) res.put("gender", getGender());
		if(getAutograph() != null) res.put("autograph", getAutograph());
		if(getAge() != null) res.put("age", getAge());
		if(getBirth() != null) res.put("birth", getBirth());
		if(getCard() != null) res.put("card", getCard());
		if(getAddress() != null) res.put("address", getAddress());
		if(getLocked() != null) res.put("locked", getLocked());
		return res;
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
		if((val = values.get("employeePassword")) != null) setEmployeePassword(__getString(val));
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("phone")) != null) setPhone(__getString(val));
		if((val = values.get("qq")) != null) setQq(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("usableStatus")) != null) setUsableStatus(__getBoolean(val));
		if((val = values.get("isDepartment")) != null) setIsDepartment(__getBoolean(val));
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("autograph")) != null) setAutograph(__getString(val));
		if((val = values.get("age")) != null) setAge(__getInt(val)); 
		if((val = values.get("birth")) != null) setBirth(__getDate(val)); 
		if((val = values.get("card")) != null) setCard(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
	}

	protected Integer  __employee_id ;
	protected String  __employee_no ;
	protected String  __employee_name ;
	protected Integer  __department_id ;
	protected Integer  __role_id ;
	protected Integer  __grade_id ;
	protected String  __employee_password ;
	protected String  __mobile ;
	protected String  __phone ;
	protected String  __qq ;
	protected String  __email ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __resignation_date ;
	protected Integer  __status ;
	protected Boolean  __usable_status ;
	protected Boolean  __is_department ;
	protected String  __photo ;
	protected Integer  __gender ;
	protected String  __autograph ;
	protected Integer  __age ;
	protected java.util.Date  __birth ;
	protected String  __card ;
	protected String  __address ;
	protected Boolean  __locked ;
}
