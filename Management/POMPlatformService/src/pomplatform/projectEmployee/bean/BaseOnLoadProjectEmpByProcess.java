package pomplatform.projectEmployee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectEmpByProcess extends GenericBase implements BaseFactory<BaseOnLoadProjectEmpByProcess>, Comparable<BaseOnLoadProjectEmpByProcess> 
{


	public static BaseOnLoadProjectEmpByProcess newInstance(){
		return new BaseOnLoadProjectEmpByProcess();
	}

	@Override
	public BaseOnLoadProjectEmpByProcess make(){
		BaseOnLoadProjectEmpByProcess b = new BaseOnLoadProjectEmpByProcess();
		return b;
	}

	public final static java.lang.String CS_PROJECT_EMPLOYEE_ID = "project_employee_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DESIGN_PHASE = "design_phase" ;
	public final static java.lang.String CS_PLAN_WORK_HOURS = "plan_work_hours" ;
	public final static java.lang.String CS_REAL_WORK_HOURS = "real_work_hours" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_PLAN_START_DATE = "plan_start_date" ;
	public final static java.lang.String CS_PLAN_END_DATE = "plan_end_date" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_WORK_CONTENT = "work_content" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;
	public final static java.lang.String CS_ALTERNATE_FIELD3 = "alternate_field3" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_SETTLEMENT = "settlement" ;
	public final static java.lang.String CS_EMPLOYEE_ACHIEVE_INTEGRAL_RETURN = "employee_achieve_integral_return" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ROLE_ID = "role_id" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;
	public final static java.lang.String CS_EMPLOYEE_PASSWORD = "employee_password" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_PHONE = "phone" ;
	public final static java.lang.String CS_QQ = "qq" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_RESIGNATION_DATE = "resignation_date" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_USABLE_STATUS = "usable_status" ;
	public final static java.lang.String CS_IS_DEPARTMENT = "is_department" ;
	public final static java.lang.String CS_PHOTO = "photo" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_AUTOGRAPH = "autograph" ;
	public final static java.lang.String CS_AGE = "age" ;
	public final static java.lang.String CS_BIRTH = "birth" ;
	public final static java.lang.String CS_CARD = "card" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "项目组建编码,项目主键,创建人,设计阶段,预估工时,实际工时,预分配积分,实际获得积分,计划开始日期,计划结束日期,开始日期,截止日期,工作内容,备用字段1,备用字段2,备用字段3,费用,结算积分,积分回流,阶段id,状态（1草稿保存，2确认保存）,业务编码,工号,员工姓名,部门,角色,等级,密码,手机,电话,QQ,邮箱,入职日期,离职日期,状态,是否可用,是否为部门负责人,头像,性别,我的签名,age,出生日期,身份证,地址,是否锁定";

	public java.lang.Integer getProjectEmployeeId() {
		return this.__project_employee_id;
	}

	public void setProjectEmployeeId( java.lang.Integer value ) {
		this.__project_employee_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.Integer getPlanWorkHours() {
		return this.__plan_work_hours;
	}

	public void setPlanWorkHours( java.lang.Integer value ) {
		this.__plan_work_hours = value;
	}

	public java.lang.Integer getRealWorkHours() {
		return this.__real_work_hours;
	}

	public void setRealWorkHours( java.lang.Integer value ) {
		this.__real_work_hours = value;
	}

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getRealIntegral() {
		return this.__real_integral;
	}

	public void setRealIntegral( java.math.BigDecimal value ) {
		this.__real_integral = value;
	}

	public java.util.Date getPlanStartDate() {
		return this.__plan_start_date;
	}

	public void setPlanStartDate( java.util.Date value ) {
		this.__plan_start_date = value;
	}

	public java.util.Date getPlanEndDate() {
		return this.__plan_end_date;
	}

	public void setPlanEndDate( java.util.Date value ) {
		this.__plan_end_date = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getWorkContent() {
		return this.__work_content;
	}

	public void setWorkContent( java.lang.String value ) {
		this.__work_content = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1;
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.String getAlternateField3() {
		return this.__alternate_field3;
	}

	public void setAlternateField3( java.lang.String value ) {
		this.__alternate_field3 = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.math.BigDecimal getSettlement() {
		return this.__settlement;
	}

	public void setSettlement( java.math.BigDecimal value ) {
		this.__settlement = value;
	}

	public java.math.BigDecimal getEmployeeAchieveIntegralReturn() {
		return this.__employee_achieve_integral_return;
	}

	public void setEmployeeAchieveIntegralReturn( java.math.BigDecimal value ) {
		this.__employee_achieve_integral_return = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
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

	public java.lang.String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( java.lang.String value ) {
		this.__photo = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.String getAutograph() {
		return this.__autograph;
	}

	public void setAutograph( java.lang.String value ) {
		this.__autograph = value;
	}

	public java.lang.Integer getAge() {
		return this.__age;
	}

	public void setAge( java.lang.Integer value ) {
		this.__age = value;
	}

	public java.util.Date getBirth() {
		return this.__birth;
	}

	public void setBirth( java.util.Date value ) {
		this.__birth = value;
	}

	public java.lang.String getCard() {
		return this.__card;
	}

	public void setCard( java.lang.String value ) {
		this.__card = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public void cloneCopy(BaseOnLoadProjectEmpByProcess __bean){
		__bean.setProjectEmployeeId(getProjectEmployeeId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDesignPhase(getDesignPhase());
		__bean.setPlanWorkHours(getPlanWorkHours());
		__bean.setRealWorkHours(getRealWorkHours());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setPlanStartDate(getPlanStartDate());
		__bean.setPlanEndDate(getPlanEndDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setWorkContent(getWorkContent());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
		__bean.setAlternateField3(getAlternateField3());
		__bean.setCost(getCost());
		__bean.setSettlement(getSettlement());
		__bean.setEmployeeAchieveIntegralReturn(getEmployeeAchieveIntegralReturn());
		__bean.setStageId(getStageId());
		__bean.setFlag(getFlag());
		__bean.setBusinessId(getBusinessId());
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

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectEmployeeId() == null ? "" : getProjectEmployeeId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		sb.append(getPlanWorkHours() == null ? "" : getPlanWorkHours());
		sb.append(",");
		sb.append(getRealWorkHours() == null ? "" : getRealWorkHours());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getRealIntegral() == null ? "" : getRealIntegral());
		sb.append(",");
		sb.append(getPlanStartDate() == null ? "" : sdf.format(getPlanStartDate()));
		sb.append(",");
		sb.append(getPlanEndDate() == null ? "" : sdf.format(getPlanEndDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getWorkContent() == null ? "" : getWorkContent());
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		sb.append(",");
		sb.append(getAlternateField3() == null ? "" : getAlternateField3());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		sb.append(getSettlement() == null ? "" : getSettlement());
		sb.append(",");
		sb.append(getEmployeeAchieveIntegralReturn() == null ? "" : getEmployeeAchieveIntegralReturn());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
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
	public int compareTo(BaseOnLoadProjectEmpByProcess o) {
		return __project_employee_id == null ? -1 : __project_employee_id.compareTo(o.getProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__design_phase);
		hash = 97 * hash + Objects.hashCode(this.__plan_work_hours);
		hash = 97 * hash + Objects.hashCode(this.__real_work_hours);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__plan_start_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_end_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__work_content);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field3);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__settlement);
		hash = 97 * hash + Objects.hashCode(this.__employee_achieve_integral_return);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
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
		final BaseOnLoadProjectEmpByProcess o = (BaseOnLoadProjectEmpByProcess)obj;
		if(!Objects.equals(this.__project_employee_id, o.getProjectEmployeeId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__design_phase, o.getDesignPhase())) return false;
		if(!Objects.equals(this.__plan_work_hours, o.getPlanWorkHours())) return false;
		if(!Objects.equals(this.__real_work_hours, o.getRealWorkHours())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__plan_start_date, o.getPlanStartDate())) return false;
		if(!Objects.equals(this.__plan_end_date, o.getPlanEndDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__work_content, o.getWorkContent())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		if(!Objects.equals(this.__alternate_field3, o.getAlternateField3())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__settlement, o.getSettlement())) return false;
		if(!Objects.equals(this.__employee_achieve_integral_return, o.getEmployeeAchieveIntegralReturn())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
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
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "projectEmployeeId", getProjectEmployeeId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(count++, "designPhase", getDesignPhase()));
		if(getPlanWorkHours() != null) sb.append(__wrapNumber(count++, "planWorkHours", getPlanWorkHours()));
		if(getRealWorkHours() != null) sb.append(__wrapNumber(count++, "realWorkHours", getRealWorkHours()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getPlanStartDate() != null) sb.append(__wrapDate(count++, "planStartDate", getPlanStartDate()));
		if(getPlanEndDate() != null) sb.append(__wrapDate(count++, "planEndDate", getPlanEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getWorkContent() != null) sb.append(__wrapString(count++, "workContent", getWorkContent()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		if(getAlternateField3() != null) sb.append(__wrapString(count++, "alternateField3", getAlternateField3()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getSettlement() != null) sb.append(__wrapDecimal(count++, "settlement", getSettlement()));
		if(getEmployeeAchieveIntegralReturn() != null) sb.append(__wrapDecimal(count++, "employeeAchieveIntegralReturn", getEmployeeAchieveIntegralReturn()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
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
		if(getProjectEmployeeId() != null) res.put("projectEmployeeId", getProjectEmployeeId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getDesignPhase() != null) res.put("designPhase", getDesignPhase());
		if(getPlanWorkHours() != null) res.put("planWorkHours", getPlanWorkHours());
		if(getRealWorkHours() != null) res.put("realWorkHours", getRealWorkHours());
		if(getPlanIntegral() != null) res.put("planIntegral", getPlanIntegral());
		if(getRealIntegral() != null) res.put("realIntegral", getRealIntegral());
		if(getPlanStartDate() != null) res.put("planStartDate", getPlanStartDate());
		if(getPlanEndDate() != null) res.put("planEndDate", getPlanEndDate());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getWorkContent() != null) res.put("workContent", getWorkContent());
		if(getAlternateField1() != null) res.put("alternateField1", getAlternateField1());
		if(getAlternateField2() != null) res.put("alternateField2", getAlternateField2());
		if(getAlternateField3() != null) res.put("alternateField3", getAlternateField3());
		if(getCost() != null) res.put("cost", getCost());
		if(getSettlement() != null) res.put("settlement", getSettlement());
		if(getEmployeeAchieveIntegralReturn() != null) res.put("employeeAchieveIntegralReturn", getEmployeeAchieveIntegralReturn());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getFlag() != null) res.put("flag", getFlag());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
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
		if((val = values.get("projectEmployeeId")) != null) setProjectEmployeeId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("planWorkHours")) != null) setPlanWorkHours(__getInt(val)); 
		if((val = values.get("realWorkHours")) != null) setRealWorkHours(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("planStartDate")) != null) setPlanStartDate(__getDate(val)); 
		if((val = values.get("planEndDate")) != null) setPlanEndDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("workContent")) != null) setWorkContent(__getString(val));
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("alternateField3")) != null) setAlternateField3(__getString(val));
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("settlement")) != null) setSettlement(__getDecimal(val));  
		if((val = values.get("employeeAchieveIntegralReturn")) != null) setEmployeeAchieveIntegralReturn(__getDecimal(val));  
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
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

	protected java.lang.Integer  __project_employee_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __design_phase ;
	protected java.lang.Integer  __plan_work_hours ;
	protected java.lang.Integer  __real_work_hours ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.util.Date  __plan_start_date ;
	protected java.util.Date  __plan_end_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.String  __work_content ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
	protected java.lang.String  __alternate_field3 ;
	protected java.math.BigDecimal  __cost ;
	protected java.math.BigDecimal  __settlement ;
	protected java.math.BigDecimal  __employee_achieve_integral_return ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __role_id ;
	protected java.lang.Integer  __grade_id ;
	protected java.lang.String  __employee_password ;
	protected java.lang.String  __mobile ;
	protected java.lang.String  __phone ;
	protected java.lang.String  __qq ;
	protected java.lang.String  __email ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __resignation_date ;
	protected java.lang.Integer  __status ;
	protected java.lang.Boolean  __usable_status ;
	protected java.lang.Boolean  __is_department ;
	protected java.lang.String  __photo ;
	protected java.lang.Integer  __gender ;
	protected java.lang.String  __autograph ;
	protected java.lang.Integer  __age ;
	protected java.util.Date  __birth ;
	protected java.lang.String  __card ;
	protected java.lang.String  __address ;
	protected java.lang.Boolean  __locked ;
}
