package pomplatform.alreadyapprovalbudgetmanagementapplywork.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAlreadyApprovalBudgetManagementApplyWork extends GenericBase implements BaseFactory<BaseAlreadyApprovalBudgetManagementApplyWork>, Comparable<BaseAlreadyApprovalBudgetManagementApplyWork> 
{


	public static BaseAlreadyApprovalBudgetManagementApplyWork newInstance(){
		return new BaseAlreadyApprovalBudgetManagementApplyWork();
	}

	@Override
	public BaseAlreadyApprovalBudgetManagementApplyWork make(){
		BaseAlreadyApprovalBudgetManagementApplyWork b = new BaseAlreadyApprovalBudgetManagementApplyWork();
		return b;
	}

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

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人,当前流程实例节点的内部编码,下一个流程节点的编码,如果是知会节点，所依附的主节点,流程实例节点创建时间,流程实例节点开始处于活动时间,操作时间,提交意见,状态,节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会,返回数据集,主键id,预算编号,预算类型,预算总金额,预算已用金额,预算剩余金额,申请人id,申请时间,预期关闭时间,预算单状态1,已立项，2立项进行中,项目编码,预算备注,发票编码,申请人归属部门,申请人归属公司";

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

	public java.lang.String getCostBearIng() {
		return this.__cost_bearing;
	}

	public void setCostBearIng( java.lang.String value ) {
		this.__cost_bearing = value;
	}
	
	public void cloneCopy(BaseAlreadyApprovalBudgetManagementApplyWork __bean){
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
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAlreadyApprovalBudgetManagementApplyWork o) {
		return __process_instance_activity_id == null ? -1 : __process_instance_activity_id.compareTo(o.getProcessInstanceActivityId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAlreadyApprovalBudgetManagementApplyWork o = (BaseAlreadyApprovalBudgetManagementApplyWork)obj;
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
		if(!Objects.equals(this.__cost_bearing, o.getCostBearIng())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
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
		if(getCostBearIng() != null) sb.append(__wrapString(count++, "costBearIng", getCostBearIng()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
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
		if((val = values.get("costBearing")) != null) setCostBearIng(__getString(val));
	}

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
	protected java.lang.String  __cost_bearing;
}
