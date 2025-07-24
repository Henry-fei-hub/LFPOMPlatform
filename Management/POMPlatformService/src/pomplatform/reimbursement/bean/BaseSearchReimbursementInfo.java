package pomplatform.reimbursement.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSearchReimbursementInfo extends GenericBase implements BaseFactory<BaseSearchReimbursementInfo>, Comparable<BaseSearchReimbursementInfo> 
{


	public static BaseSearchReimbursementInfo newInstance(){
		return new BaseSearchReimbursementInfo();
	}

	@Override
	public BaseSearchReimbursementInfo make(){
		BaseSearchReimbursementInfo b = new BaseSearchReimbursementInfo();
		return b;
	}

	public final static String CS_PROCESS_TYPE = "process_type" ;
	public final static String CS_BUSINESS_ID = "business_id" ;
	public final static String CS_PROCESS_ID = "process_id" ;
	public final static String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static String CS_BEAR_FEE_ID = "bear_fee_id" ;
	public final static String CS_BEAR_FEE_CODE = "bear_fee_code" ;
	public final static String CS_BEAR_FEE_NAME = "bear_fee_name" ;
	public final static String CS_CODE = "code" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_CREATE_TIME = "create_time" ;
	public final static String CS_PROCESS_STATUS = "process_status" ;
	public final static String CS_AMOUNT = "amount" ;
	public final static String CS_INPUT_TAX = "input_tax" ;
	public final static String CS_FINAL_AMOUNT = "final_amount" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_COMPLETE_TIME = "complete_time" ;
	public final static String CS_SUB_TABLE_ID = "sub_table_id" ;
	public final static String CS_PACKAGE_CODE = "package_code" ;
	public final static String CS_CURRENCY = "currency" ;
	public final static String CS_CONTRACT_CODE = "contract_code" ;
	public final static String CS_REMARK = "remark" ;
	public final static String CS_COMPANY_ID = "company_id" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_BD_CODE = "bd_code" ;
	public final static String CS_MAIN_ITEM_ID = "main_item_id" ;
	public final static String CS_SUB_ITEM_ID = "sub_item_id" ;
	public final static String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static String CS_OUT_DAY = "out_day" ;

	public final static String NAME_PROCESS_TYPE = "processType" ;
	public final static String NAME_BUSINESS_ID = "businessId" ;
	public final static String NAME_PROCESS_ID = "processId" ;
	public final static String NAME_PROCESS_INSTANCE_ID = "processInstanceId" ;
	public final static String NAME_BEAR_FEE_ID = "bearFeeId" ;
	public final static String NAME_BEAR_FEE_CODE = "bearFeeCode" ;
	public final static String NAME_BEAR_FEE_NAME = "bearFeeName" ;
	public final static String NAME_CODE = "code" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_CREATE_TIME = "createTime" ;
	public final static String NAME_PROCESS_STATUS = "processStatus" ;
	public final static String NAME_AMOUNT = "amount" ;
	public final static String NAME_INPUT_TAX = "inputTax" ;
	public final static String NAME_FINAL_AMOUNT = "finalAmount" ;
	public final static String NAME_PLATE_ID = "plateId" ;
	public final static String NAME_COMPLETE_TIME = "completeTime" ;
	public final static String NAME_SUB_TABLE_ID = "subTableId" ;
	public final static String NAME_PACKAGE_CODE = "packageCode" ;
	public final static String NAME_CURRENCY = "currency" ;
	public final static String NAME_CONTRACT_CODE = "contractCode" ;
	public final static String NAME_REMARK = "remark" ;
	public final static String NAME_COMPANY_ID = "companyId" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_BD_CODE = "bdCode" ;
	public final static String NAME_MAIN_ITEM_ID = "mainItemId" ;
	public final static String NAME_SUB_ITEM_ID = "subItemId" ;
	public final static String NAME_BACK_VIEW_NAME = "backViewName" ;
	public final static String NAME_INSTANCE_ACTIVITY_START_TIME = "instanceActivityStartTime" ;
	public final static String NAME_OUT_DAY = "outDay" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,流程表编码,流程编码,流程实例编码,,,,编号,创建人,创建时间,流程状态 0 发起中  1,报销金额,进项税,成本,板块,完成时间,,,货币种类  0人民币   1港币   2美元,订单编号,备注,,,预算编号,一级报销科目,二级报销科目,返回数据集,流程实例节点开始处于活动时间,";

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
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

	public java.lang.Integer getBearFeeId() {
		return this.__bear_fee_id;
	}

	public void setBearFeeId( java.lang.Integer value ) {
		this.__bear_fee_id = value;
	}

	public java.lang.String getBearFeeCode() {
		return this.__bear_fee_code;
	}

	public void setBearFeeCode( java.lang.String value ) {
		this.__bear_fee_code = value;
	}

	public java.lang.String getBearFeeName() {
		return this.__bear_fee_name;
	}

	public void setBearFeeName( java.lang.String value ) {
		this.__bear_fee_name = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getSubTableId() {
		return this.__sub_table_id;
	}

	public void setSubTableId( java.lang.Integer value ) {
		this.__sub_table_id = value;
	}

	public java.lang.String getPackageCode() {
		return this.__package_code;
	}

	public void setPackageCode( java.lang.String value ) {
		this.__package_code = value;
	}

	public java.lang.Integer getCurrency() {
		return this.__currency;
	}

	public void setCurrency( java.lang.Integer value ) {
		this.__currency = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.String value ) {
		this.__company_id = value;
	}

	public java.lang.String getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.String value ) {
		this.__department_id = value;
	}

	public java.lang.String getBdCode() {
		return this.__bd_code;
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public java.lang.Integer getMainItemId() {
		return this.__main_item_id;
	}

	public void setMainItemId( java.lang.Integer value ) {
		this.__main_item_id = value;
	}

	public java.lang.Integer getSubItemId() {
		return this.__sub_item_id;
	}

	public void setSubItemId( java.lang.Integer value ) {
		this.__sub_item_id = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.lang.Integer getOutDay() {
		return this.__out_day;
	}

	public void setOutDay( java.lang.Integer value ) {
		this.__out_day = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		return name;
	}

	public void cloneCopy(BaseSearchReimbursementInfo __bean){
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBearFeeId(getBearFeeId());
		__bean.setBearFeeCode(getBearFeeCode());
		__bean.setBearFeeName(getBearFeeName());
		__bean.setCode(getCode());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setAmount(getAmount());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setPlateId(getPlateId());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setSubTableId(getSubTableId());
		__bean.setPackageCode(getPackageCode());
		__bean.setCurrency(getCurrency());
		__bean.setContractCode(getContractCode());
		__bean.setRemark(getRemark());
		__bean.setCompanyId(getCompanyId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setBdCode(getBdCode());
		__bean.setMainItemId(getMainItemId());
		__bean.setSubItemId(getSubItemId());
		__bean.setBackViewName(getBackViewName());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setOutDay(getOutDay());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getBearFeeId() == null ? "" : getBearFeeId());
		sb.append(",");
		sb.append(getBearFeeCode() == null ? "" : getBearFeeCode());
		sb.append(",");
		sb.append(getBearFeeName() == null ? "" : getBearFeeName());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getSubTableId() == null ? "" : getSubTableId());
		sb.append(",");
		sb.append(getPackageCode() == null ? "" : getPackageCode());
		sb.append(",");
		sb.append(getCurrency() == null ? "" : getCurrency());
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getBdCode() == null ? "" : getBdCode());
		sb.append(",");
		sb.append(getMainItemId() == null ? "" : getMainItemId());
		sb.append(",");
		sb.append(getSubItemId() == null ? "" : getSubItemId());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getOutDay() == null ? "" : getOutDay());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSearchReimbursementInfo o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__bear_fee_id);
		hash = 97 * hash + Objects.hashCode(this.__bear_fee_code);
		hash = 97 * hash + Objects.hashCode(this.__bear_fee_name);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__sub_table_id);
		hash = 97 * hash + Objects.hashCode(this.__package_code);
		hash = 97 * hash + Objects.hashCode(this.__currency);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__bd_code);
		hash = 97 * hash + Objects.hashCode(this.__main_item_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_item_id);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__out_day);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSearchReimbursementInfo o = (BaseSearchReimbursementInfo)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__bear_fee_id, o.getBearFeeId())) return false;
		if(!Objects.equals(this.__bear_fee_code, o.getBearFeeCode())) return false;
		if(!Objects.equals(this.__bear_fee_name, o.getBearFeeName())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__sub_table_id, o.getSubTableId())) return false;
		if(!Objects.equals(this.__package_code, o.getPackageCode())) return false;
		if(!Objects.equals(this.__currency, o.getCurrency())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__bd_code, o.getBdCode())) return false;
		if(!Objects.equals(this.__main_item_id, o.getMainItemId())) return false;
		if(!Objects.equals(this.__sub_item_id, o.getSubItemId())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__out_day, o.getOutDay())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		return toJSONString(false);
	}

	@Override
	public java.lang.String toJSONString(boolean outDefault) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROCESS_TYPE, getProcessType()));
		if(getBusinessId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_BUSINESS_ID, getBusinessId()));
		if(getProcessId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROCESS_ID, getProcessId()));
		if(getProcessInstanceId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROCESS_INSTANCE_ID, getProcessInstanceId()));
		if(getBearFeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_BEAR_FEE_ID, getBearFeeId()));
		if(getBearFeeCode() != null || outDefault) sb.append(__wrapString(count++, NAME_BEAR_FEE_CODE, getBearFeeCode()));
		if(getBearFeeName() != null || outDefault) sb.append(__wrapString(count++, NAME_BEAR_FEE_NAME, getBearFeeName()));
		if(getCode() != null || outDefault) sb.append(__wrapString(count++, NAME_CODE, getCode()));
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getCreateTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_CREATE_TIME, getCreateTime()));
		if(getProcessStatus() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROCESS_STATUS, getProcessStatus()));
		if(getAmount() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_AMOUNT, getAmount()));
		if(getInputTax() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_INPUT_TAX, getInputTax()));
		if(getFinalAmount() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_FINAL_AMOUNT, getFinalAmount()));
		if(getPlateId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PLATE_ID, getPlateId()));
		if(getCompleteTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_COMPLETE_TIME, getCompleteTime()));
		if(getSubTableId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_SUB_TABLE_ID, getSubTableId()));
		if(getPackageCode() != null || outDefault) sb.append(__wrapString(count++, NAME_PACKAGE_CODE, getPackageCode()));
		if(getCurrency() != null || outDefault) sb.append(__wrapNumber(count++, NAME_CURRENCY, getCurrency()));
		if(getContractCode() != null || outDefault) sb.append(__wrapString(count++, NAME_CONTRACT_CODE, getContractCode()));
		if(getRemark() != null || outDefault) sb.append(__wrapString(count++, NAME_REMARK, getRemark()));
		if(getCompanyId() != null || outDefault) sb.append(__wrapString(count++, NAME_COMPANY_ID, getCompanyId()));
		if(getDepartmentId() != null || outDefault) sb.append(__wrapString(count++, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getBdCode() != null || outDefault) sb.append(__wrapString(count++, NAME_BD_CODE, getBdCode()));
		if(getMainItemId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_MAIN_ITEM_ID, getMainItemId()));
		if(getSubItemId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_SUB_ITEM_ID, getSubItemId()));
		if(getBackViewName() != null || outDefault) sb.append(__wrapString(count++, NAME_BACK_VIEW_NAME, getBackViewName()));
		if(getInstanceActivityStartTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_INSTANCE_ACTIVITY_START_TIME, getInstanceActivityStartTime()));
		if(getOutDay() != null || outDefault) sb.append(__wrapNumber(count++, NAME_OUT_DAY, getOutDay()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessType() != null) res.put(NAME_PROCESS_TYPE, getProcessType());
		if(getBusinessId() != null) res.put(NAME_BUSINESS_ID, getBusinessId());
		if(getProcessId() != null) res.put(NAME_PROCESS_ID, getProcessId());
		if(getProcessInstanceId() != null) res.put(NAME_PROCESS_INSTANCE_ID, getProcessInstanceId());
		if(getBearFeeId() != null) res.put(NAME_BEAR_FEE_ID, getBearFeeId());
		if(getBearFeeCode() != null) res.put(NAME_BEAR_FEE_CODE, getBearFeeCode());
		if(getBearFeeName() != null) res.put(NAME_BEAR_FEE_NAME, getBearFeeName());
		if(getCode() != null) res.put(NAME_CODE, getCode());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getCreateTime() != null) res.put(NAME_CREATE_TIME, getCreateTime());
		if(getProcessStatus() != null) res.put(NAME_PROCESS_STATUS, getProcessStatus());
		if(getAmount() != null) res.put(NAME_AMOUNT, getAmount());
		if(getInputTax() != null) res.put(NAME_INPUT_TAX, getInputTax());
		if(getFinalAmount() != null) res.put(NAME_FINAL_AMOUNT, getFinalAmount());
		if(getPlateId() != null) res.put(NAME_PLATE_ID, getPlateId());
		if(getCompleteTime() != null) res.put(NAME_COMPLETE_TIME, getCompleteTime());
		if(getSubTableId() != null) res.put(NAME_SUB_TABLE_ID, getSubTableId());
		if(getPackageCode() != null) res.put(NAME_PACKAGE_CODE, getPackageCode());
		if(getCurrency() != null) res.put(NAME_CURRENCY, getCurrency());
		if(getContractCode() != null) res.put(NAME_CONTRACT_CODE, getContractCode());
		if(getRemark() != null) res.put(NAME_REMARK, getRemark());
		if(getCompanyId() != null) res.put(NAME_COMPANY_ID, getCompanyId());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getBdCode() != null) res.put(NAME_BD_CODE, getBdCode());
		if(getMainItemId() != null) res.put(NAME_MAIN_ITEM_ID, getMainItemId());
		if(getSubItemId() != null) res.put(NAME_SUB_ITEM_ID, getSubItemId());
		if(getBackViewName() != null) res.put(NAME_BACK_VIEW_NAME, getBackViewName());
		if(getInstanceActivityStartTime() != null) res.put(NAME_INSTANCE_ACTIVITY_START_TIME, getInstanceActivityStartTime());
		if(getOutDay() != null) res.put(NAME_OUT_DAY, getOutDay());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseSearchReimbursementInfo> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseSearchReimbursementInfo b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_PROCESS_TYPE) && (val = values.get(NAME_PROCESS_TYPE)) != null) setProcessType(__getInt(val)); 
		if(values.containsKey(NAME_BUSINESS_ID) && (val = values.get(NAME_BUSINESS_ID)) != null) setBusinessId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_ID) && (val = values.get(NAME_PROCESS_ID)) != null) setProcessId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_INSTANCE_ID) && (val = values.get(NAME_PROCESS_INSTANCE_ID)) != null) setProcessInstanceId(__getInt(val)); 
		if(values.containsKey(NAME_BEAR_FEE_ID) && (val = values.get(NAME_BEAR_FEE_ID)) != null) setBearFeeId(__getInt(val)); 
		if(values.containsKey(NAME_BEAR_FEE_CODE) && (val = values.get(NAME_BEAR_FEE_CODE)) != null) setBearFeeCode(__getString(val));
		if(values.containsKey(NAME_BEAR_FEE_NAME) && (val = values.get(NAME_BEAR_FEE_NAME)) != null) setBearFeeName(__getString(val));
		if(values.containsKey(NAME_CODE) && (val = values.get(NAME_CODE)) != null) setCode(__getString(val));
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_CREATE_TIME) && (val = values.get(NAME_CREATE_TIME)) != null) setCreateTime(__getDate(val)); 
		if(values.containsKey(NAME_PROCESS_STATUS) && (val = values.get(NAME_PROCESS_STATUS)) != null) setProcessStatus(__getInt(val)); 
		if(values.containsKey(NAME_AMOUNT) && (val = values.get(NAME_AMOUNT)) != null) setAmount(__getDecimal(val));  
		if(values.containsKey(NAME_INPUT_TAX) && (val = values.get(NAME_INPUT_TAX)) != null) setInputTax(__getDecimal(val));  
		if(values.containsKey(NAME_FINAL_AMOUNT) && (val = values.get(NAME_FINAL_AMOUNT)) != null) setFinalAmount(__getDecimal(val));  
		if(values.containsKey(NAME_PLATE_ID) && (val = values.get(NAME_PLATE_ID)) != null) setPlateId(__getInt(val)); 
		if(values.containsKey(NAME_COMPLETE_TIME) && (val = values.get(NAME_COMPLETE_TIME)) != null) setCompleteTime(__getDate(val)); 
		if(values.containsKey(NAME_SUB_TABLE_ID) && (val = values.get(NAME_SUB_TABLE_ID)) != null) setSubTableId(__getInt(val)); 
		if(values.containsKey(NAME_PACKAGE_CODE) && (val = values.get(NAME_PACKAGE_CODE)) != null) setPackageCode(__getString(val));
		if(values.containsKey(NAME_CURRENCY) && (val = values.get(NAME_CURRENCY)) != null) setCurrency(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_CODE) && (val = values.get(NAME_CONTRACT_CODE)) != null) setContractCode(__getString(val));
		if(values.containsKey(NAME_REMARK) && (val = values.get(NAME_REMARK)) != null) setRemark(__getString(val));
		if(values.containsKey(NAME_COMPANY_ID) && (val = values.get(NAME_COMPANY_ID)) != null) setCompanyId(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getString(val));
		if(values.containsKey(NAME_BD_CODE) && (val = values.get(NAME_BD_CODE)) != null) setBdCode(__getString(val));
		if(values.containsKey(NAME_MAIN_ITEM_ID) && (val = values.get(NAME_MAIN_ITEM_ID)) != null) setMainItemId(__getInt(val)); 
		if(values.containsKey(NAME_SUB_ITEM_ID) && (val = values.get(NAME_SUB_ITEM_ID)) != null) setSubItemId(__getInt(val)); 
		if(values.containsKey(NAME_BACK_VIEW_NAME) && (val = values.get(NAME_BACK_VIEW_NAME)) != null) setBackViewName(__getString(val));
		if(values.containsKey(NAME_INSTANCE_ACTIVITY_START_TIME) && (val = values.get(NAME_INSTANCE_ACTIVITY_START_TIME)) != null) setInstanceActivityStartTime(__getDate(val)); 
		if(values.containsKey(NAME_OUT_DAY) && (val = values.get(NAME_OUT_DAY)) != null) setOutDay(__getInt(val)); 
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __bear_fee_id ;
	protected java.lang.String  __bear_fee_code ;
	protected java.lang.String  __bear_fee_name ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __process_status ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.Integer  __plate_id ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __sub_table_id ;
	protected java.lang.String  __package_code ;
	protected java.lang.Integer  __currency ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __company_id ;
	protected java.lang.String  __department_id ;
	protected java.lang.String  __bd_code ;
	protected java.lang.Integer  __main_item_id ;
	protected java.lang.Integer  __sub_item_id ;
	protected java.lang.String  __back_view_name ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.lang.Integer  __out_day ;
}
