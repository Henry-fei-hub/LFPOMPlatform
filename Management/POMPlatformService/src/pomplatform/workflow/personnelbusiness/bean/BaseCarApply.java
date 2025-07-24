package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseCarCostAllocation;

public class BaseCarApply extends GenericBase implements BaseFactory<BaseCarApply>, Comparable<BaseCarApply> 
{


	public static BaseCarApply newInstance(){
		return new BaseCarApply();
	}

	@Override
	public BaseCarApply make(){
		BaseCarApply b = new BaseCarApply();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_END_DATE_DETAIL = "end_date_detail" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_PLAN = "plan" ;
	public final static java.lang.String CS_TRANSPORTATION = "transportation" ;
	public final static java.lang.String CS_FEE = "fee" ;
	public final static java.lang.String CS_UNIT = "unit" ;
	public final static java.lang.String CS_CONTACT_PERSON = "contact_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_NEXT_AUDITOR = "next_auditor" ;
	public final static java.lang.String CS_SUB_TYPE = "sub_type" ;
	public final static java.lang.String CS_HOURS = "hours" ;
	public final static java.lang.String CS_COMPANY_PROVINCE = "company_province" ;
	public final static java.lang.String CS_TARGET_PROVINCE = "target_province" ;
	public final static java.lang.String CS_NUMBER_OF_BABY = "number_of_baby" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_SUB_TYPE_STR = "sub_type_str" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_IS_REMOTE_CITY = "is_remote_city" ;
	public final static java.lang.String CS_PROVIDE_ACCOMMODATION = "provide_accommodation" ;
	public final static java.lang.String CS_LIVING_EXPENSES = "living_expenses" ;
	public final static java.lang.String CS_HOUSING_FINANCE = "housing_finance" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_CARD = "card" ;
	public final static java.lang.String CS_DUTY_ID = "duty_id" ;
	public final static java.lang.String CS_EQUIVALENT_NUMBER = "equivalent_number" ;
	public final static java.lang.String CS_LINK_ID = "link_id" ;

	public final static java.lang.String ALL_CAPTIONS = "人事业务编码,类型 13请假  14出差  15打卡  16外出  17加班,申请人,工号,部门,归属公司,假期类型,开始日期,0上午   1下午,截止日期,0上午   1下午,天数,申请缘由,备注,地址,计划安排,交通工具,预计费用,外访单位,联系人,起草时间,删除状态  0未删除    1已删除,自定义的审核人,假期类型明细项,小时,公司所在省份,目标省份,多胞胎假请填写婴儿数量,附件,是否审批通过,假期类型明细项,项目类型 1项目 2前期项目,项目主键,项目名称,项目编号,父级编码  用于记录是根据哪一条记录进行延期,是否为边远城市,是否提供住宿,生活费用(元/月),住房费用(元/月),起草人,身份证,职务,对等号  与  冲账结合实现 借款与冲账与还款,关联表编码";

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getEndDateDetail() {
		return this.__end_date_detail;
	}

	public void setEndDateDetail( java.lang.Integer value ) {
		this.__end_date_detail = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getPlan() {
		return this.__plan;
	}

	public void setPlan( java.lang.String value ) {
		this.__plan = value;
	}

	public java.lang.String getTransportation() {
		return this.__transportation;
	}

	public void setTransportation( java.lang.String value ) {
		this.__transportation = value;
	}

	public java.math.BigDecimal getFee() {
		return this.__fee;
	}

	public void setFee( java.math.BigDecimal value ) {
		this.__fee = value;
	}

	public java.lang.String getUnit() {
		return this.__unit;
	}

	public void setUnit( java.lang.String value ) {
		this.__unit = value;
	}

	public java.lang.String getContactPerson() {
		return this.__contact_person;
	}

	public void setContactPerson( java.lang.String value ) {
		this.__contact_person = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getNextAuditor() {
		return this.__next_auditor;
	}

	public void setNextAuditor( java.lang.Integer value ) {
		this.__next_auditor = value;
	}

	public java.lang.String getSubType() {
		return this.__sub_type;
	}

	public void setSubType( java.lang.String value ) {
		this.__sub_type = value;
	}

	public java.math.BigDecimal getHours() {
		return this.__hours;
	}

	public void setHours( java.math.BigDecimal value ) {
		this.__hours = value;
	}

	public java.lang.Integer getCompanyProvince() {
		return this.__company_province;
	}

	public void setCompanyProvince( java.lang.Integer value ) {
		this.__company_province = value;
	}

	public java.lang.Integer getTargetProvince() {
		return this.__target_province;
	}

	public void setTargetProvince( java.lang.Integer value ) {
		this.__target_province = value;
	}

	public java.lang.Integer getNumberOfBaby() {
		return this.__number_of_baby;
	}

	public void setNumberOfBaby( java.lang.Integer value ) {
		this.__number_of_baby = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.String getSubTypeStr() {
		return this.__sub_type_str;
	}

	public void setSubTypeStr( java.lang.String value ) {
		this.__sub_type_str = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getIsRemoteCity() {
		return this.__is_remote_city;
	}

	public void setIsRemoteCity( java.lang.Boolean value ) {
		this.__is_remote_city = value;
	}

	public java.lang.Boolean getProvideAccommodation() {
		return this.__provide_accommodation;
	}

	public void setProvideAccommodation( java.lang.Boolean value ) {
		this.__provide_accommodation = value;
	}

	public java.math.BigDecimal getLivingExpenses() {
		return this.__living_expenses;
	}

	public void setLivingExpenses( java.math.BigDecimal value ) {
		this.__living_expenses = value;
	}

	public java.math.BigDecimal getHousingFinance() {
		return this.__housing_finance;
	}

	public void setHousingFinance( java.math.BigDecimal value ) {
		this.__housing_finance = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.String getCard() {
		return this.__card;
	}

	public void setCard( java.lang.String value ) {
		this.__card = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.String getEquivalentNumber() {
		return this.__equivalent_number;
	}

	public void setEquivalentNumber( java.lang.String value ) {
		this.__equivalent_number = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.util.List<BaseCarCostAllocation> getDetailCarCostAllocation() {
		return this.__detailCarCostAllocation;
	}

	public void setDetailCarCostAllocation( java.util.List<BaseCarCostAllocation> value ) {
		this.__detailCarCostAllocation = value;
	}

	public void cloneCopy(BaseCarApply __bean){
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setType(getType());
		__bean.setStartDate(getStartDate());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setEndDate(getEndDate());
		__bean.setEndDateDetail(getEndDateDetail());
		__bean.setDays(getDays());
		__bean.setReason(getReason());
		__bean.setRemark(getRemark());
		__bean.setAddress(getAddress());
		__bean.setPlan(getPlan());
		__bean.setTransportation(getTransportation());
		__bean.setFee(getFee());
		__bean.setUnit(getUnit());
		__bean.setContactPerson(getContactPerson());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setNextAuditor(getNextAuditor());
		__bean.setSubType(getSubType());
		__bean.setHours(getHours());
		__bean.setCompanyProvince(getCompanyProvince());
		__bean.setTargetProvince(getTargetProvince());
		__bean.setNumberOfBaby(getNumberOfBaby());
		__bean.setAttachment(getAttachment());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setSubTypeStr(getSubTypeStr());
		__bean.setProjectType(getProjectType());
		__bean.setProjectId(getProjectId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setParentId(getParentId());
		__bean.setIsRemoteCity(getIsRemoteCity());
		__bean.setProvideAccommodation(getProvideAccommodation());
		__bean.setLivingExpenses(getLivingExpenses());
		__bean.setHousingFinance(getHousingFinance());
		__bean.setDrafter(getDrafter());
		__bean.setCard(getCard());
		__bean.setDutyId(getDutyId());
		__bean.setEquivalentNumber(getEquivalentNumber());
		__bean.setLinkId(getLinkId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getStartDateDetail() == null ? "" : getStartDateDetail());
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getEndDateDetail() == null ? "" : getEndDateDetail());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getPlan() == null ? "" : getPlan());
		sb.append(",");
		sb.append(getTransportation() == null ? "" : getTransportation());
		sb.append(",");
		sb.append(getFee() == null ? "" : getFee());
		sb.append(",");
		sb.append(getUnit() == null ? "" : getUnit());
		sb.append(",");
		sb.append(getContactPerson() == null ? "" : getContactPerson());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getNextAuditor() == null ? "" : getNextAuditor());
		sb.append(",");
		sb.append(getSubType() == null ? "" : getSubType());
		sb.append(",");
		sb.append(getHours() == null ? "" : getHours());
		sb.append(",");
		sb.append(getCompanyProvince() == null ? "" : getCompanyProvince());
		sb.append(",");
		sb.append(getTargetProvince() == null ? "" : getTargetProvince());
		sb.append(",");
		sb.append(getNumberOfBaby() == null ? "" : getNumberOfBaby());
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getSubTypeStr() == null ? "" : getSubTypeStr());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strProjectCode = delicacy.system.executor.SelectValueCache.getSelectValue("main_projects", String.valueOf(getProjectCode()));
		sb.append(strProjectCode == null ? "" : strProjectCode);
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getIsRemoteCity() == null ? "" : getIsRemoteCity());
		sb.append(",");
		sb.append(getProvideAccommodation() == null ? "" : getProvideAccommodation());
		sb.append(",");
		sb.append(getLivingExpenses() == null ? "" : getLivingExpenses());
		sb.append(",");
		sb.append(getHousingFinance() == null ? "" : getHousingFinance());
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		sb.append(getCard() == null ? "" : getCard());
		sb.append(",");
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getEquivalentNumber() == null ? "" : getEquivalentNumber());
		sb.append(",");
		sb.append(getLinkId() == null ? "" : getLinkId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCarApply o) {
		return __personnel_business_id == null ? -1 : __personnel_business_id.compareTo(o.getPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__plan);
		hash = 97 * hash + Objects.hashCode(this.__transportation);
		hash = 97 * hash + Objects.hashCode(this.__fee);
		hash = 97 * hash + Objects.hashCode(this.__unit);
		hash = 97 * hash + Objects.hashCode(this.__contact_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__next_auditor);
		hash = 97 * hash + Objects.hashCode(this.__sub_type);
		hash = 97 * hash + Objects.hashCode(this.__hours);
		hash = 97 * hash + Objects.hashCode(this.__company_province);
		hash = 97 * hash + Objects.hashCode(this.__target_province);
		hash = 97 * hash + Objects.hashCode(this.__number_of_baby);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__sub_type_str);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__is_remote_city);
		hash = 97 * hash + Objects.hashCode(this.__provide_accommodation);
		hash = 97 * hash + Objects.hashCode(this.__living_expenses);
		hash = 97 * hash + Objects.hashCode(this.__housing_finance);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__card);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__equivalent_number);
		hash = 97 * hash + Objects.hashCode(this.__link_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCarApply o = (BaseCarApply)obj;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__end_date_detail, o.getEndDateDetail())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__plan, o.getPlan())) return false;
		if(!Objects.equals(this.__transportation, o.getTransportation())) return false;
		if(!Objects.equals(this.__fee, o.getFee())) return false;
		if(!Objects.equals(this.__unit, o.getUnit())) return false;
		if(!Objects.equals(this.__contact_person, o.getContactPerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__next_auditor, o.getNextAuditor())) return false;
		if(!Objects.equals(this.__sub_type, o.getSubType())) return false;
		if(!Objects.equals(this.__hours, o.getHours())) return false;
		if(!Objects.equals(this.__company_province, o.getCompanyProvince())) return false;
		if(!Objects.equals(this.__target_province, o.getTargetProvince())) return false;
		if(!Objects.equals(this.__number_of_baby, o.getNumberOfBaby())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__sub_type_str, o.getSubTypeStr())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__is_remote_city, o.getIsRemoteCity())) return false;
		if(!Objects.equals(this.__provide_accommodation, o.getProvideAccommodation())) return false;
		if(!Objects.equals(this.__living_expenses, o.getLivingExpenses())) return false;
		if(!Objects.equals(this.__housing_finance, o.getHousingFinance())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__equivalent_number, o.getEquivalentNumber())) return false;
		if(!Objects.equals(this.__link_id, o.getLinkId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getEndDateDetail() != null) sb.append(__wrapNumber(count++, "endDateDetail", getEndDateDetail()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getPlan() != null) sb.append(__wrapString(count++, "plan", getPlan()));
		if(getTransportation() != null) sb.append(__wrapString(count++, "transportation", getTransportation()));
		if(getFee() != null) sb.append(__wrapDecimal(count++, "fee", getFee()));
		if(getUnit() != null) sb.append(__wrapString(count++, "unit", getUnit()));
		if(getContactPerson() != null) sb.append(__wrapString(count++, "contactPerson", getContactPerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getNextAuditor() != null) sb.append(__wrapNumber(count++, "nextAuditor", getNextAuditor()));
		if(getSubType() != null) sb.append(__wrapString(count++, "subType", getSubType()));
		if(getHours() != null) sb.append(__wrapDecimal(count++, "hours", getHours()));
		if(getCompanyProvince() != null) sb.append(__wrapNumber(count++, "companyProvince", getCompanyProvince()));
		if(getTargetProvince() != null) sb.append(__wrapNumber(count++, "targetProvince", getTargetProvince()));
		if(getNumberOfBaby() != null) sb.append(__wrapNumber(count++, "numberOfBaby", getNumberOfBaby()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getSubTypeStr() != null) sb.append(__wrapString(count++, "subTypeStr", getSubTypeStr()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getIsRemoteCity() != null) sb.append(__wrapBoolean(count++, "isRemoteCity", getIsRemoteCity()));
		if(getProvideAccommodation() != null) sb.append(__wrapBoolean(count++, "provideAccommodation", getProvideAccommodation()));
		if(getLivingExpenses() != null) sb.append(__wrapDecimal(count++, "livingExpenses", getLivingExpenses()));
		if(getHousingFinance() != null) sb.append(__wrapDecimal(count++, "housingFinance", getHousingFinance()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		if(getEquivalentNumber() != null) sb.append(__wrapString(count++, "equivalentNumber", getEquivalentNumber()));
		if(getLinkId() != null) sb.append(__wrapNumber(count++, "linkId", getLinkId()));
		if(getDetailCarCostAllocation() != null)  sb.append(__wrapList(count++, "detailCarCostAllocation", getDetailCarCostAllocation()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("endDateDetail")) != null) setEndDateDetail(__getInt(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("plan")) != null) setPlan(__getString(val));
		if((val = values.get("transportation")) != null) setTransportation(__getString(val));
		if((val = values.get("fee")) != null) setFee(__getDecimal(val));  
		if((val = values.get("unit")) != null) setUnit(__getString(val));
		if((val = values.get("contactPerson")) != null) setContactPerson(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("nextAuditor")) != null) setNextAuditor(__getInt(val)); 
		if((val = values.get("subType")) != null) setSubType(__getString(val));
		if((val = values.get("hours")) != null) setHours(__getDecimal(val));  
		if((val = values.get("companyProvince")) != null) setCompanyProvince(__getInt(val)); 
		if((val = values.get("targetProvince")) != null) setTargetProvince(__getInt(val)); 
		if((val = values.get("numberOfBaby")) != null) setNumberOfBaby(__getInt(val)); 
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("subTypeStr")) != null) setSubTypeStr(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("isRemoteCity")) != null) setIsRemoteCity(__getBoolean(val));
		if((val = values.get("provideAccommodation")) != null) setProvideAccommodation(__getBoolean(val));
		if((val = values.get("livingExpenses")) != null) setLivingExpenses(__getDecimal(val));  
		if((val = values.get("housingFinance")) != null) setHousingFinance(__getDecimal(val));  
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("card")) != null) setCard(__getString(val));
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("equivalentNumber")) != null) setEquivalentNumber(__getString(val));
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("detailCarCostAllocation")) != null) setDetailCarCostAllocation(__getList(val, BaseCarCostAllocation.newInstance()));
	}

	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __type ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __end_date_detail ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.String  __reason ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __address ;
	protected java.lang.String  __plan ;
	protected java.lang.String  __transportation ;
	protected java.math.BigDecimal  __fee ;
	protected java.lang.String  __unit ;
	protected java.lang.String  __contact_person ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __next_auditor ;
	protected java.lang.String  __sub_type ;
	protected java.math.BigDecimal  __hours ;
	protected java.lang.Integer  __company_province ;
	protected java.lang.Integer  __target_province ;
	protected java.lang.Integer  __number_of_baby ;
	protected java.lang.String  __attachment ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.String  __sub_type_str ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __is_remote_city ;
	protected java.lang.Boolean  __provide_accommodation ;
	protected java.math.BigDecimal  __living_expenses ;
	protected java.math.BigDecimal  __housing_finance ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.String  __card ;
	protected java.lang.Integer  __duty_id ;
	protected java.lang.String  __equivalent_number ;
	protected java.lang.Integer  __link_id ;
	protected java.util.List<BaseCarCostAllocation> __detailCarCostAllocation = null;
}
