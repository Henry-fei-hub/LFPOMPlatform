package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSelectGridEmployeeValues extends GenericBase implements BaseFactory<BaseSelectGridEmployeeValues>, Comparable<BaseSelectGridEmployeeValues> 
{


	public static BaseSelectGridEmployeeValues newInstance(){
		return new BaseSelectGridEmployeeValues();
	}

	@Override
	public BaseSelectGridEmployeeValues make(){
		BaseSelectGridEmployeeValues b = new BaseSelectGridEmployeeValues();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_ROLE_ID = "role_id" ;
	public final static String CS_MOBILE = "mobile" ;
	public final static String CS_PHONE = "phone" ;
	public final static String CS_QQ = "qq" ;
	public final static String CS_EMAIL = "email" ;
	public final static String CS_PHOTO = "photo" ;
	public final static String CS_CARD = "card" ;
	public final static String CS_USER_ACCT = "user_acct" ;
	public final static String CS_EMPLOYEE_NAME_EN = "employee_name_en" ;
	public final static String CS_WORK_ADDRESS = "work_address" ;

	public final static String ALL_CAPTIONS = "处理人,员工编号,员工姓名,部门编码,角色,手机,电话,QQ,邮箱,头像,身份证号,上级领导,英文名,工作地";

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

	public String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( String value ) {
		this.__photo = value;
	}

	public String getCard() {
		return this.__card;
	}

	public void setCard( String value ) {
		this.__card = value;
	}

	public String getUserAcct() {
		return this.__user_acct;
	}

	public void setUserAcct( String value ) {
		this.__user_acct = value;
	}

	public String getEmployeeNameEn() {
		return this.__employee_name_en;
	}

	public void setEmployeeNameEn( String value ) {
		this.__employee_name_en = value;
	}

	public String getWorkAddress() {
		return this.__work_address;
	}

	public void setWorkAddress( String value ) {
		this.__work_address = value;
	}

	public void cloneCopy(BaseSelectGridEmployeeValues __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRoleId(getRoleId());
		__bean.setMobile(getMobile());
		__bean.setPhone(getPhone());
		__bean.setQq(getQq());
		__bean.setEmail(getEmail());
		__bean.setPhoto(getPhoto());
		__bean.setCard(getCard());
		__bean.setUserAcct(getUserAcct());
		__bean.setEmployeeNameEn(getEmployeeNameEn());
		__bean.setWorkAddress(getWorkAddress());
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
		sb.append(getCard() == null ? "" : getCard());
		sb.append(",");
		sb.append(getUserAcct() == null ? "" : getUserAcct());
		sb.append(",");
		sb.append(getEmployeeNameEn() == null ? "" : getEmployeeNameEn());
		sb.append(",");
		sb.append(getWorkAddress() == null ? "" : getWorkAddress());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSelectGridEmployeeValues o) {
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
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__phone);
		hash = 97 * hash + Objects.hashCode(this.__qq);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__card);
		hash = 97 * hash + Objects.hashCode(this.__user_acct);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_en);
		hash = 97 * hash + Objects.hashCode(this.__work_address);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSelectGridEmployeeValues o = (BaseSelectGridEmployeeValues)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__role_id, o.getRoleId())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__phone, o.getPhone())) return false;
		if(!Objects.equals(this.__qq, o.getQq())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
		if(!Objects.equals(this.__user_acct, o.getUserAcct())) return false;
		if(!Objects.equals(this.__employee_name_en, o.getEmployeeNameEn())) return false;
		if(!Objects.equals(this.__work_address, o.getWorkAddress())) return false;
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
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getPhone() != null) sb.append(__wrapString(count++, "phone", getPhone()));
		if(getQq() != null) sb.append(__wrapString(count++, "qq", getQq()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
		if(getUserAcct() != null) sb.append(__wrapString(count++, "userAcct", getUserAcct()));
		if(getEmployeeNameEn() != null) sb.append(__wrapString(count++, "employeeNameEn", getEmployeeNameEn()));
		if(getWorkAddress() != null) sb.append(__wrapString(count++, "workAddress", getWorkAddress()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getRoleId() != null) res.put("roleId", getRoleId());
		if(getMobile() != null) res.put("mobile", getMobile());
		if(getPhone() != null) res.put("phone", getPhone());
		if(getQq() != null) res.put("qq", getQq());
		if(getEmail() != null) res.put("email", getEmail());
		if(getPhoto() != null) res.put("photo", getPhoto());
		if(getCard() != null) res.put("card", getCard());
		if(getUserAcct() != null) res.put("userAcct", getUserAcct());
		if(getEmployeeNameEn() != null) res.put("employeeNameEn", getEmployeeNameEn());
		if(getWorkAddress() != null) res.put("workAddress", getWorkAddress());
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
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("phone")) != null) setPhone(__getString(val));
		if((val = values.get("qq")) != null) setQq(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("card")) != null) setCard(__getString(val));
		if((val = values.get("userAcct")) != null) setUserAcct(__getString(val));
		if((val = values.get("employeeNameEn")) != null) setEmployeeNameEn(__getString(val));
		if((val = values.get("workAddress")) != null) setWorkAddress(__getString(val));
	}

	protected Integer  __employee_id ;
	protected String  __employee_no ;
	protected String  __employee_name ;
	protected Integer  __department_id ;
	protected Integer  __role_id ;
	protected String  __mobile ;
	protected String  __phone ;
	protected String  __qq ;
	protected String  __email ;
	protected String  __photo ;
	protected String  __card ;
	protected String  __user_acct ;
	protected String  __employee_name_en ;
	protected String  __work_address ;
}
