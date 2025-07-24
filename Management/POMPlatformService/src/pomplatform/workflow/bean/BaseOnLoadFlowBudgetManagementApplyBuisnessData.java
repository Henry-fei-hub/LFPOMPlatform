package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadFlowBudgetManagementApplyBuisnessData extends GenericBase implements BaseFactory<BaseOnLoadFlowBudgetManagementApplyBuisnessData>, Comparable<BaseOnLoadFlowBudgetManagementApplyBuisnessData> 
{


	public static BaseOnLoadFlowBudgetManagementApplyBuisnessData newInstance(){
		return new BaseOnLoadFlowBudgetManagementApplyBuisnessData();
	}

	@Override
	public BaseOnLoadFlowBudgetManagementApplyBuisnessData make(){
		BaseOnLoadFlowBudgetManagementApplyBuisnessData b = new BaseOnLoadFlowBudgetManagementApplyBuisnessData();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static java.lang.String CS_PROCESS_POOLED_TASK_ID = "process_pooled_task_id" ;
	public final static java.lang.String CS_TYPE_FLAG = "type_flag" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_NODE_TYPE = "node_type" ;
	public final static java.lang.String CS_ACTIVITY_ID = "activity_id" ;
	public final static java.lang.String CS_NEXT_ACTIVITY_ID = "next_activity_id" ;
	public final static java.lang.String CS_MAIN_ACTIVITY_ID = "main_activity_id" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ACTIVITY_TYPE = "activity_type" ;
	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BD_CODE = "bd_code" ;
	public final static java.lang.String CS_BD_TYPE = "bd_type" ;
	public final static java.lang.String CS_BD_TOTAL_AMOUNT = "bd_total_amount" ;
	public final static java.lang.String CS_BD_USE_AMOUNT = "bd_use_amount" ;
	public final static java.lang.String CS_BD_REST_AMOUNT = "bd_rest_amount" ;
	public final static java.lang.String CS_BD_APPLY_EMPLOYEE_ID = "bd_apply_employee_id" ;
	public final static java.lang.String CS_BD_APPLY_TIME = "bd_apply_time" ;
	public final static java.lang.String CS_BD_ESTIMATECLOSE_TIME = "bd_estimateclose_time" ;
	public final static java.lang.String CS_BD_STATUS = "bd_status" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_BD_REMARK = "bd_remark" ;
	public final static java.lang.String CS_INPUT_TAX_INVOICE_ID = "input_tax_invoice_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COST_BEARING = "cost_bearing" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_END_DATE_DETAIL = "end_date_detail" ;
	public final static java.lang.String CS_DAYS = "days" ;
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
	public final static java.lang.String CS_SEVERANCE = "severance" ;
	public final static java.lang.String CS_SALARY_1 = "salary_1" ;
	public final static java.lang.String CS_SALARY_2 = "salary_2" ;
	public final static java.lang.String CS_ORIGINAL_PAY = "original_pay" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_BASIC_PROPORTION_STR = "basic_proportion_str" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_FOREMAN_PAY = "foreman_pay" ;
	public final static java.lang.String CS_OTHER_SUBSIDY = "other_subsidy" ;
	public final static java.lang.String CS_TOTAL_PAY = "total_pay" ;
	public final static java.lang.String CS_ANNUAL_PERFORMANCE = "annual_performance" ;
	public final static java.lang.String CS_COST_ATTRIBUTION = "cost_attribution" ;
	public final static java.lang.String CS_CERTIFICATION_TIME = "certification_time" ;
	public final static java.lang.String CS_PROJECT_IDS = "project_ids" ;
	public final static java.lang.String CS_PAYMENT_SEQUENCE_ID = "payment_sequence_id" ;
	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_EMP_STATUS = "emp_status" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型名称,主键编码,,主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人,当前流程实例节点的内部编码,下一个流程节点的编码,如果是知会节点，所依附的主节点,流程实例节点创建时间,流程实例节点开始处于活动时间,操作时间,提交意见,状态,节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会,返回数据集,预算管理编码,预算编号,预算类型,预算总金额,预算已用金额,预算剩余金额,申请人id,申请时间,预期关闭时间,预算单状态1,已立项，2立项进行中,项目主键,预算备注,发票编码,部门,归属公司,费用承担,人事业务编码,流程类型,工号,假期类型,开始日期,0上午   1下午,截止日期,0上午   1下午,天数,备注,地址,计划安排,交通工具,预计费用,外访单位,联系人,创建时间,删除状态  0未删除    1已删除,自定义的审核人,假期类型明细项,小时,公司所在省份,目标省份,多胞胎假请填写婴儿数量,附件,是否审批通过,假期类型明细项,项目类型 1项目 2前期项目,项目名称,项目编号,父级编码  用于记录是根据哪一条记录进行延期,是否为边远城市,是否提供住宿,生活费用(元/月),住房费用(元/月),起草人,身份证,职务,对等号  与  冲账结合实现 借款与冲账与还款,关联表编码,离职补偿金,薪资1,薪资2,现薪资,月薪,基本比例（显示用）,基本比例（计算用）,月基本工资,月绩效工资,工龄工资,其他补贴,全薪,年度绩效,费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员),领证时间,项目编码,付款序列编码,预算附件编码,阶段id,";

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Integer getProcessPooledTaskId() {
		return this.__process_pooled_task_id;
	}

	public void setProcessPooledTaskId( java.lang.Integer value ) {
		this.__process_pooled_task_id = value;
	}

	public java.lang.Integer getTypeFlag() {
		return this.__type_flag;
	}

	public void setTypeFlag( java.lang.Integer value ) {
		this.__type_flag = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getProcessActivityId() {
		return this.__process_activity_id;
	}

	public void setProcessActivityId( java.lang.Integer value ) {
		this.__process_activity_id = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getNodeType() {
		return this.__node_type;
	}

	public void setNodeType( java.lang.Integer value ) {
		this.__node_type = value;
	}

	public java.lang.Integer getActivityId() {
		return this.__activity_id;
	}

	public void setActivityId( java.lang.Integer value ) {
		this.__activity_id = value;
	}

	public java.lang.Integer getNextActivityId() {
		return this.__next_activity_id;
	}

	public void setNextActivityId( java.lang.Integer value ) {
		this.__next_activity_id = value;
	}

	public java.lang.Integer getMainActivityId() {
		return this.__main_activity_id;
	}

	public void setMainActivityId( java.lang.Integer value ) {
		this.__main_activity_id = value;
	}

	public java.util.Date getInstanceActivityCreateTime() {
		return this.__instance_activity_create_time;
	}

	public void setInstanceActivityCreateTime( java.util.Date value ) {
		this.__instance_activity_create_time = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getProcessComment() {
		return this.__process_comment;
	}

	public void setProcessComment( java.lang.String value ) {
		this.__process_comment = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( java.lang.Integer value ) {
		this.__activity_type = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.String getBdCode() {
		return this.__bd_code;
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public java.lang.Integer getBdType() {
		return this.__bd_type;
	}

	public void setBdType( java.lang.Integer value ) {
		this.__bd_type = value;
	}

	public java.math.BigDecimal getBdTotalAmount() {
		return this.__bd_total_amount;
	}

	public void setBdTotalAmount( java.math.BigDecimal value ) {
		this.__bd_total_amount = value;
	}

	public java.math.BigDecimal getBdUseAmount() {
		return this.__bd_use_amount;
	}

	public void setBdUseAmount( java.math.BigDecimal value ) {
		this.__bd_use_amount = value;
	}

	public java.math.BigDecimal getBdRestAmount() {
		return this.__bd_rest_amount;
	}

	public void setBdRestAmount( java.math.BigDecimal value ) {
		this.__bd_rest_amount = value;
	}

	public java.lang.Integer getBdApplyEmployeeId() {
		return this.__bd_apply_employee_id;
	}

	public void setBdApplyEmployeeId( java.lang.Integer value ) {
		this.__bd_apply_employee_id = value;
	}

	public java.util.Date getBdApplyTime() {
		return this.__bd_apply_time;
	}

	public void setBdApplyTime( java.util.Date value ) {
		this.__bd_apply_time = value;
	}

	public java.util.Date getBdEstimatecloseTime() {
		return this.__bd_estimateclose_time;
	}

	public void setBdEstimatecloseTime( java.util.Date value ) {
		this.__bd_estimateclose_time = value;
	}

	public java.lang.Integer getBdStatus() {
		return this.__bd_status;
	}

	public void setBdStatus( java.lang.Integer value ) {
		this.__bd_status = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getBdRemark() {
		return this.__bd_remark;
	}

	public void setBdRemark( java.lang.String value ) {
		this.__bd_remark = value;
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return this.__input_tax_invoice_id;
	}

	public void setInputTaxInvoiceId( java.lang.Integer value ) {
		this.__input_tax_invoice_id = value;
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

	public java.lang.String getCostBearing() {
		return this.__cost_bearing;
	}

	public void setCostBearing( java.lang.String value ) {
		this.__cost_bearing = value;
	}

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

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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

	public java.math.BigDecimal getSeverance() {
		return this.__severance;
	}

	public void setSeverance( java.math.BigDecimal value ) {
		this.__severance = value;
	}

	public java.lang.String getSalary1() {
		return this.__salary_1;
	}

	public void setSalary1( java.lang.String value ) {
		this.__salary_1 = value;
	}

	public java.lang.String getSalary2() {
		return this.__salary_2;
	}

	public void setSalary2( java.lang.String value ) {
		this.__salary_2 = value;
	}

	public java.lang.String getOriginalPay() {
		return this.__original_pay;
	}

	public void setOriginalPay( java.lang.String value ) {
		this.__original_pay = value;
	}

	public java.lang.String getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.lang.String value ) {
		this.__month_pay = value;
	}

	public java.lang.String getBasicProportionStr() {
		return this.__basic_proportion_str;
	}

	public void setBasicProportionStr( java.lang.String value ) {
		this.__basic_proportion_str = value;
	}

	public java.math.BigDecimal getBasicProportion() {
		return this.__basic_proportion;
	}

	public void setBasicProportion( java.math.BigDecimal value ) {
		this.__basic_proportion = value;
	}

	public java.lang.String getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.lang.String value ) {
		this.__month_basic_pay = value;
	}

	public java.lang.String getMonthPerformancePay() {
		return this.__month_performance_pay;
	}

	public void setMonthPerformancePay( java.lang.String value ) {
		this.__month_performance_pay = value;
	}

	public java.lang.String getForemanPay() {
		return this.__foreman_pay;
	}

	public void setForemanPay( java.lang.String value ) {
		this.__foreman_pay = value;
	}

	public java.lang.String getOtherSubsidy() {
		return this.__other_subsidy;
	}

	public void setOtherSubsidy( java.lang.String value ) {
		this.__other_subsidy = value;
	}

	public java.lang.String getTotalPay() {
		return this.__total_pay;
	}

	public void setTotalPay( java.lang.String value ) {
		this.__total_pay = value;
	}

	public java.lang.String getAnnualPerformance() {
		return this.__annual_performance;
	}

	public void setAnnualPerformance( java.lang.String value ) {
		this.__annual_performance = value;
	}

	public java.lang.Integer getCostAttribution() {
		return this.__cost_attribution;
	}

	public void setCostAttribution( java.lang.Integer value ) {
		this.__cost_attribution = value;
	}

	public java.util.Date getCertificationTime() {
		return this.__certification_time;
	}

	public void setCertificationTime( java.util.Date value ) {
		this.__certification_time = value;
	}

	public java.lang.Integer getProjectIds() {
		return this.__project_ids;
	}

	public void setProjectIds( java.lang.Integer value ) {
		this.__project_ids = value;
	}

	public java.lang.Integer getPaymentSequenceId() {
		return this.__payment_sequence_id;
	}

	public void setPaymentSequenceId( java.lang.Integer value ) {
		this.__payment_sequence_id = value;
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getEmpStatus() {
		return this.__emp_status;
	}

	public void setEmpStatus( java.lang.Integer value ) {
		this.__emp_status = value;
	}

	public void cloneCopy(BaseOnLoadFlowBudgetManagementApplyBuisnessData __bean){
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setProcessPooledTaskId(getProcessPooledTaskId());
		__bean.setTypeFlag(getTypeFlag());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setNodeType(getNodeType());
		__bean.setActivityId(getActivityId());
		__bean.setNextActivityId(getNextActivityId());
		__bean.setMainActivityId(getMainActivityId());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
		__bean.setStatus(getStatus());
		__bean.setActivityType(getActivityType());
		__bean.setBackViewName(getBackViewName());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBdCode(getBdCode());
		__bean.setBdType(getBdType());
		__bean.setBdTotalAmount(getBdTotalAmount());
		__bean.setBdUseAmount(getBdUseAmount());
		__bean.setBdRestAmount(getBdRestAmount());
		__bean.setBdApplyEmployeeId(getBdApplyEmployeeId());
		__bean.setBdApplyTime(getBdApplyTime());
		__bean.setBdEstimatecloseTime(getBdEstimatecloseTime());
		__bean.setBdStatus(getBdStatus());
		__bean.setProjectId(getProjectId());
		__bean.setBdRemark(getBdRemark());
		__bean.setInputTaxInvoiceId(getInputTaxInvoiceId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setCostBearing(getCostBearing());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setType(getType());
		__bean.setStartDate(getStartDate());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setEndDate(getEndDate());
		__bean.setEndDateDetail(getEndDateDetail());
		__bean.setDays(getDays());
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
		__bean.setSeverance(getSeverance());
		__bean.setSalary1(getSalary1());
		__bean.setSalary2(getSalary2());
		__bean.setOriginalPay(getOriginalPay());
		__bean.setMonthPay(getMonthPay());
		__bean.setBasicProportionStr(getBasicProportionStr());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setForemanPay(getForemanPay());
		__bean.setOtherSubsidy(getOtherSubsidy());
		__bean.setTotalPay(getTotalPay());
		__bean.setAnnualPerformance(getAnnualPerformance());
		__bean.setCostAttribution(getCostAttribution());
		__bean.setCertificationTime(getCertificationTime());
		__bean.setProjectIds(getProjectIds());
		__bean.setPaymentSequenceId(getPaymentSequenceId());
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setStageId(getStageId());
		__bean.setEmpStatus(getEmpStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getProcessPooledTaskId() == null ? "" : getProcessPooledTaskId());
		sb.append(",");
		sb.append(getTypeFlag() == null ? "" : getTypeFlag());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessActivityId() == null ? "" : getProcessActivityId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getNodeType() == null ? "" : getNodeType());
		sb.append(",");
		sb.append(getActivityId() == null ? "" : getActivityId());
		sb.append(",");
		sb.append(getNextActivityId() == null ? "" : getNextActivityId());
		sb.append(",");
		sb.append(getMainActivityId() == null ? "" : getMainActivityId());
		sb.append(",");
		sb.append(getInstanceActivityCreateTime() == null ? "" : sdf.format(getInstanceActivityCreateTime()));
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getActivityType() == null ? "" : getActivityType());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getBdCode() == null ? "" : getBdCode());
		sb.append(",");
		sb.append(getBdType() == null ? "" : getBdType());
		sb.append(",");
		sb.append(getBdTotalAmount() == null ? "" : getBdTotalAmount());
		sb.append(",");
		sb.append(getBdUseAmount() == null ? "" : getBdUseAmount());
		sb.append(",");
		sb.append(getBdRestAmount() == null ? "" : getBdRestAmount());
		sb.append(",");
		sb.append(getBdApplyEmployeeId() == null ? "" : getBdApplyEmployeeId());
		sb.append(",");
		sb.append(getBdApplyTime() == null ? "" : sdf.format(getBdApplyTime()));
		sb.append(",");
		sb.append(getBdEstimatecloseTime() == null ? "" : sdf.format(getBdEstimatecloseTime()));
		sb.append(",");
		sb.append(getBdStatus() == null ? "" : getBdStatus());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getBdRemark() == null ? "" : getBdRemark());
		sb.append(",");
		sb.append(getInputTaxInvoiceId() == null ? "" : getInputTaxInvoiceId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCostBearing() == null ? "" : getCostBearing());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
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
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getIsRemoteCity() == null ? "" : getIsRemoteCity());
		sb.append(",");
		sb.append(getProvideAccommodation() == null ? "" : getProvideAccommodation());
		sb.append(",");
		sb.append(getLivingExpenses() == null ? "" : getLivingExpenses());
		sb.append(",");
		sb.append(getHousingFinance() == null ? "" : getHousingFinance());
		sb.append(",");
		sb.append(getDrafter() == null ? "" : getDrafter());
		sb.append(",");
		sb.append(getCard() == null ? "" : getCard());
		sb.append(",");
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getEquivalentNumber() == null ? "" : getEquivalentNumber());
		sb.append(",");
		sb.append(getLinkId() == null ? "" : getLinkId());
		sb.append(",");
		sb.append(getSeverance() == null ? "" : getSeverance());
		sb.append(",");
		sb.append(getSalary1() == null ? "" : getSalary1());
		sb.append(",");
		sb.append(getSalary2() == null ? "" : getSalary2());
		sb.append(",");
		sb.append(getOriginalPay() == null ? "" : getOriginalPay());
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getBasicProportionStr() == null ? "" : getBasicProportionStr());
		sb.append(",");
		sb.append(getBasicProportion() == null ? "" : getBasicProportion());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getMonthPerformancePay() == null ? "" : getMonthPerformancePay());
		sb.append(",");
		sb.append(getForemanPay() == null ? "" : getForemanPay());
		sb.append(",");
		sb.append(getOtherSubsidy() == null ? "" : getOtherSubsidy());
		sb.append(",");
		sb.append(getTotalPay() == null ? "" : getTotalPay());
		sb.append(",");
		sb.append(getAnnualPerformance() == null ? "" : getAnnualPerformance());
		sb.append(",");
		sb.append(getCostAttribution() == null ? "" : getCostAttribution());
		sb.append(",");
		sb.append(getCertificationTime() == null ? "" : sdf.format(getCertificationTime()));
		sb.append(",");
		sb.append(getProjectIds() == null ? "" : getProjectIds());
		sb.append(",");
		sb.append(getPaymentSequenceId() == null ? "" : getPaymentSequenceId());
		sb.append(",");
		sb.append(getBudgetAttachmentId() == null ? "" : getBudgetAttachmentId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getEmpStatus() == null ? "" : getEmpStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadFlowBudgetManagementApplyBuisnessData o) {
		return __process_pooled_task_id == null ? -1 : __process_pooled_task_id.compareTo(o.getProcessPooledTaskId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__process_pooled_task_id);
		hash = 97 * hash + Objects.hashCode(this.__type_flag);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__node_type);
		hash = 97 * hash + Objects.hashCode(this.__activity_id);
		hash = 97 * hash + Objects.hashCode(this.__next_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__main_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_code);
		hash = 97 * hash + Objects.hashCode(this.__bd_type);
		hash = 97 * hash + Objects.hashCode(this.__bd_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__bd_use_amount);
		hash = 97 * hash + Objects.hashCode(this.__bd_rest_amount);
		hash = 97 * hash + Objects.hashCode(this.__bd_apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_apply_time);
		hash = 97 * hash + Objects.hashCode(this.__bd_estimateclose_time);
		hash = 97 * hash + Objects.hashCode(this.__bd_status);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_remark);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__cost_bearing);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__days);
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
		hash = 97 * hash + Objects.hashCode(this.__severance);
		hash = 97 * hash + Objects.hashCode(this.__salary_1);
		hash = 97 * hash + Objects.hashCode(this.__salary_2);
		hash = 97 * hash + Objects.hashCode(this.__original_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__foreman_pay);
		hash = 97 * hash + Objects.hashCode(this.__other_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__total_pay);
		hash = 97 * hash + Objects.hashCode(this.__annual_performance);
		hash = 97 * hash + Objects.hashCode(this.__cost_attribution);
		hash = 97 * hash + Objects.hashCode(this.__certification_time);
		hash = 97 * hash + Objects.hashCode(this.__project_ids);
		hash = 97 * hash + Objects.hashCode(this.__payment_sequence_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__emp_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadFlowBudgetManagementApplyBuisnessData o = (BaseOnLoadFlowBudgetManagementApplyBuisnessData)obj;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__process_pooled_task_id, o.getProcessPooledTaskId())) return false;
		if(!Objects.equals(this.__type_flag, o.getTypeFlag())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__node_type, o.getNodeType())) return false;
		if(!Objects.equals(this.__activity_id, o.getActivityId())) return false;
		if(!Objects.equals(this.__next_activity_id, o.getNextActivityId())) return false;
		if(!Objects.equals(this.__main_activity_id, o.getMainActivityId())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__bd_code, o.getBdCode())) return false;
		if(!Objects.equals(this.__bd_type, o.getBdType())) return false;
		if(!Objects.equals(this.__bd_total_amount, o.getBdTotalAmount())) return false;
		if(!Objects.equals(this.__bd_use_amount, o.getBdUseAmount())) return false;
		if(!Objects.equals(this.__bd_rest_amount, o.getBdRestAmount())) return false;
		if(!Objects.equals(this.__bd_apply_employee_id, o.getBdApplyEmployeeId())) return false;
		if(!Objects.equals(this.__bd_apply_time, o.getBdApplyTime())) return false;
		if(!Objects.equals(this.__bd_estimateclose_time, o.getBdEstimatecloseTime())) return false;
		if(!Objects.equals(this.__bd_status, o.getBdStatus())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__bd_remark, o.getBdRemark())) return false;
		if(!Objects.equals(this.__input_tax_invoice_id, o.getInputTaxInvoiceId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__cost_bearing, o.getCostBearing())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__end_date_detail, o.getEndDateDetail())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
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
		if(!Objects.equals(this.__severance, o.getSeverance())) return false;
		if(!Objects.equals(this.__salary_1, o.getSalary1())) return false;
		if(!Objects.equals(this.__salary_2, o.getSalary2())) return false;
		if(!Objects.equals(this.__original_pay, o.getOriginalPay())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__basic_proportion_str, o.getBasicProportionStr())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__foreman_pay, o.getForemanPay())) return false;
		if(!Objects.equals(this.__other_subsidy, o.getOtherSubsidy())) return false;
		if(!Objects.equals(this.__total_pay, o.getTotalPay())) return false;
		if(!Objects.equals(this.__annual_performance, o.getAnnualPerformance())) return false;
		if(!Objects.equals(this.__cost_attribution, o.getCostAttribution())) return false;
		if(!Objects.equals(this.__certification_time, o.getCertificationTime())) return false;
		if(!Objects.equals(this.__project_ids, o.getProjectIds())) return false;
		if(!Objects.equals(this.__payment_sequence_id, o.getPaymentSequenceId())) return false;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__emp_status, o.getEmpStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, "processTypeName", getProcessTypeName()));
		if(getProcessPooledTaskId() != null) sb.append(__wrapNumber(count++, "processPooledTaskId", getProcessPooledTaskId()));
		if(getTypeFlag() != null) sb.append(__wrapNumber(count++, "typeFlag", getTypeFlag()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, "nodeType", getNodeType()));
		if(getActivityId() != null) sb.append(__wrapNumber(count++, "activityId", getActivityId()));
		if(getNextActivityId() != null) sb.append(__wrapNumber(count++, "nextActivityId", getNextActivityId()));
		if(getMainActivityId() != null) sb.append(__wrapNumber(count++, "mainActivityId", getMainActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getActivityType() != null) sb.append(__wrapNumber(count++, "activityType", getActivityType()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBdCode() != null) sb.append(__wrapString(count++, "bdCode", getBdCode()));
		if(getBdType() != null) sb.append(__wrapNumber(count++, "bdType", getBdType()));
		if(getBdTotalAmount() != null) sb.append(__wrapDecimal(count++, "bdTotalAmount", getBdTotalAmount()));
		if(getBdUseAmount() != null) sb.append(__wrapDecimal(count++, "bdUseAmount", getBdUseAmount()));
		if(getBdRestAmount() != null) sb.append(__wrapDecimal(count++, "bdRestAmount", getBdRestAmount()));
		if(getBdApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "bdApplyEmployeeId", getBdApplyEmployeeId()));
		if(getBdApplyTime() != null) sb.append(__wrapDate(count++, "bdApplyTime", getBdApplyTime()));
		if(getBdEstimatecloseTime() != null) sb.append(__wrapDate(count++, "bdEstimatecloseTime", getBdEstimatecloseTime()));
		if(getBdStatus() != null) sb.append(__wrapNumber(count++, "bdStatus", getBdStatus()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getBdRemark() != null) sb.append(__wrapString(count++, "bdRemark", getBdRemark()));
		if(getInputTaxInvoiceId() != null) sb.append(__wrapNumber(count++, "inputTaxInvoiceId", getInputTaxInvoiceId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCostBearing() != null) sb.append(__wrapString(count++, "costBearing", getCostBearing()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getEndDateDetail() != null) sb.append(__wrapNumber(count++, "endDateDetail", getEndDateDetail()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
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
		if(getSeverance() != null) sb.append(__wrapDecimal(count++, "severance", getSeverance()));
		if(getSalary1() != null) sb.append(__wrapString(count++, "salary1", getSalary1()));
		if(getSalary2() != null) sb.append(__wrapString(count++, "salary2", getSalary2()));
		if(getOriginalPay() != null) sb.append(__wrapString(count++, "originalPay", getOriginalPay()));
		if(getMonthPay() != null) sb.append(__wrapString(count++, "monthPay", getMonthPay()));
		if(getBasicProportionStr() != null) sb.append(__wrapString(count++, "basicProportionStr", getBasicProportionStr()));
		if(getBasicProportion() != null) sb.append(__wrapDecimal(count++, "basicProportion", getBasicProportion()));
		if(getMonthBasicPay() != null) sb.append(__wrapString(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapString(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getForemanPay() != null) sb.append(__wrapString(count++, "foremanPay", getForemanPay()));
		if(getOtherSubsidy() != null) sb.append(__wrapString(count++, "otherSubsidy", getOtherSubsidy()));
		if(getTotalPay() != null) sb.append(__wrapString(count++, "totalPay", getTotalPay()));
		if(getAnnualPerformance() != null) sb.append(__wrapString(count++, "annualPerformance", getAnnualPerformance()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(count++, "costAttribution", getCostAttribution()));
		if(getCertificationTime() != null) sb.append(__wrapDate(count++, "certificationTime", getCertificationTime()));
		if(getProjectIds() != null) sb.append(__wrapNumber(count++, "projectIds", getProjectIds()));
		if(getPaymentSequenceId() != null) sb.append(__wrapNumber(count++, "paymentSequenceId", getPaymentSequenceId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getEmpStatus() != null) sb.append(__wrapNumber(count++, "empStatus", getEmpStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processTypeName")) != null) setProcessTypeName(__getString(val));
		if((val = values.get("processPooledTaskId")) != null) setProcessPooledTaskId(__getInt(val)); 
		if((val = values.get("typeFlag")) != null) setTypeFlag(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("nodeType")) != null) setNodeType(__getInt(val)); 
		if((val = values.get("activityId")) != null) setActivityId(__getInt(val)); 
		if((val = values.get("nextActivityId")) != null) setNextActivityId(__getInt(val)); 
		if((val = values.get("mainActivityId")) != null) setMainActivityId(__getInt(val)); 
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("bdCode")) != null) setBdCode(__getString(val));
		if((val = values.get("bdType")) != null) setBdType(__getInt(val)); 
		if((val = values.get("bdTotalAmount")) != null) setBdTotalAmount(__getDecimal(val));  
		if((val = values.get("bdUseAmount")) != null) setBdUseAmount(__getDecimal(val));  
		if((val = values.get("bdRestAmount")) != null) setBdRestAmount(__getDecimal(val));  
		if((val = values.get("bdApplyEmployeeId")) != null) setBdApplyEmployeeId(__getInt(val)); 
		if((val = values.get("bdApplyTime")) != null) setBdApplyTime(__getDate(val)); 
		if((val = values.get("bdEstimatecloseTime")) != null) setBdEstimatecloseTime(__getDate(val)); 
		if((val = values.get("bdStatus")) != null) setBdStatus(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("bdRemark")) != null) setBdRemark(__getString(val));
		if((val = values.get("inputTaxInvoiceId")) != null) setInputTaxInvoiceId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("costBearing")) != null) setCostBearing(__getString(val));
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("endDateDetail")) != null) setEndDateDetail(__getInt(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
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
		if((val = values.get("severance")) != null) setSeverance(__getDecimal(val));  
		if((val = values.get("salary1")) != null) setSalary1(__getString(val));
		if((val = values.get("salary2")) != null) setSalary2(__getString(val));
		if((val = values.get("originalPay")) != null) setOriginalPay(__getString(val));
		if((val = values.get("monthPay")) != null) setMonthPay(__getString(val));
		if((val = values.get("basicProportionStr")) != null) setBasicProportionStr(__getString(val));
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getString(val));
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getString(val));
		if((val = values.get("foremanPay")) != null) setForemanPay(__getString(val));
		if((val = values.get("otherSubsidy")) != null) setOtherSubsidy(__getString(val));
		if((val = values.get("totalPay")) != null) setTotalPay(__getString(val));
		if((val = values.get("annualPerformance")) != null) setAnnualPerformance(__getString(val));
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
		if((val = values.get("certificationTime")) != null) setCertificationTime(__getDate(val)); 
		if((val = values.get("projectIds")) != null) setProjectIds(__getInt(val)); 
		if((val = values.get("paymentSequenceId")) != null) setPaymentSequenceId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("empStatus")) != null) setEmpStatus(__getInt(val)); 
	}

	protected java.lang.String  __process_type_name ;
	protected java.lang.Integer  __process_pooled_task_id ;
	protected java.lang.Integer  __type_flag ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_activity_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __node_type ;
	protected java.lang.Integer  __activity_id ;
	protected java.lang.Integer  __next_activity_id ;
	protected java.lang.Integer  __main_activity_id ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __process_comment ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __activity_type ;
	protected java.lang.String  __back_view_name ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.String  __bd_code ;
	protected java.lang.Integer  __bd_type ;
	protected java.math.BigDecimal  __bd_total_amount ;
	protected java.math.BigDecimal  __bd_use_amount ;
	protected java.math.BigDecimal  __bd_rest_amount ;
	protected java.lang.Integer  __bd_apply_employee_id ;
	protected java.util.Date  __bd_apply_time ;
	protected java.util.Date  __bd_estimateclose_time ;
	protected java.lang.Integer  __bd_status ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __bd_remark ;
	protected java.lang.Integer  __input_tax_invoice_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __cost_bearing ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __type ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __end_date_detail ;
	protected java.math.BigDecimal  __days ;
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
	protected java.math.BigDecimal  __severance ;
	protected java.lang.String  __salary_1 ;
	protected java.lang.String  __salary_2 ;
	protected java.lang.String  __original_pay ;
	protected java.lang.String  __month_pay ;
	protected java.lang.String  __basic_proportion_str ;
	protected java.math.BigDecimal  __basic_proportion ;
	protected java.lang.String  __month_basic_pay ;
	protected java.lang.String  __month_performance_pay ;
	protected java.lang.String  __foreman_pay ;
	protected java.lang.String  __other_subsidy ;
	protected java.lang.String  __total_pay ;
	protected java.lang.String  __annual_performance ;
	protected java.lang.Integer  __cost_attribution ;
	protected java.util.Date  __certification_time ;
	protected java.lang.Integer  __project_ids ;
	protected java.lang.Integer  __payment_sequence_id ;
	protected java.lang.Integer  __budget_attachment_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __emp_status ;
}
