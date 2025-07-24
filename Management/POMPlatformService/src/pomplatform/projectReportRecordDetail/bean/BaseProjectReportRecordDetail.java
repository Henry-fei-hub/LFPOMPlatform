package pomplatform.projectReportRecordDetail.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectReportRecordDetail extends GenericBase implements BaseFactory<BaseProjectReportRecordDetail>, Comparable<BaseProjectReportRecordDetail> 
{


	public static BaseProjectReportRecordDetail newInstance(){
		return new BaseProjectReportRecordDetail();
	}

	@Override
	public BaseProjectReportRecordDetail make(){
		BaseProjectReportRecordDetail b = new BaseProjectReportRecordDetail();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_SUBTRACT_COMPLAINT_INTEGRAL = "subtract_complaint_integral" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_PROJECT_FLAG = "project_flag" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_PROGRESS_PERCENTAGE = "progress_percentage" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static java.lang.String CS_MSG_COUNT = "msg_count" ;
	public final static java.lang.String CS_MSG_STATUS = "msg_status" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_TOSTRING_3 = "employee_name_tostring_3" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_TOSTRING_5 = "employee_name_tostring_5" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_MAIN_PROJECT_STAGE_ID = "main_project_stage_id" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_CUMULATIVE_TOTAL_AMOUNT_PROPORTION = "cumulative_total_amount_proportion" ;
	public final static java.lang.String CS_YEAR_TOTAL_AMOUNT_PROPORTION = "year_total_amount_proportion" ;
	public final static java.lang.String CS_YEAR_TOTAL_AMOUNT = "year_total_amount" ;
	public final static java.lang.String CS_SURPLUS_YEAR_TOTAL_AMOUNT = "surplus_year_total_amount" ;
	public final static java.lang.String CS_SURPLUS_YEAR_TOTAL_AMOUNT_PROPORTION = "surplus_year_total_amount_proportion" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;


	public final static java.lang.String ALL_CAPTIONS = "业务部门,项目编号,订单编号,订单名称,项目类别,立项类型,项目等级,项目状态,专业负责人,部门经理,项目经理,项目负责人,项目总积分,投诉保证金,项目积分,预留积分,确认积分,项目进度百分比(%),项目成本,扣除的投诉保证金,项目类型标识,合同订单金额,消息推送次数,消息状态,项目累计结算比例(%),本年度结算比例(%),本年度结算产值,本年度结算后剩余产值,本年度结算后剩余比例(%),合同额,回款率";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.lang.Integer getSubtractComplaintIntegral() {
		return this.__subtract_complaint_integral;
	}

	public void setSubtractComplaintIntegral( java.lang.Integer value ) {
		this.__subtract_complaint_integral = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getProgressPercentage() {
		return this.__progress_percentage;
	}

	public void setProgressPercentage( java.math.BigDecimal value ) {
		this.__progress_percentage = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.Integer getMsgCount() {
		return this.__msg_count;
	}

	public void setMsgCount( java.lang.Integer value ) {
		this.__msg_count = value;
	}

	public java.lang.Integer getMsgStatus() {
		return this.__msg_status;
	}

	public void setMsgStatus( java.lang.Integer value ) {
		this.__msg_status = value;
	}
	
	public java.lang.String getEmployeeNameTostring3() {
		return this.__employee_name_tostring_3;
	}

	public void setEmployeeNameTostring3( java.lang.String value ) {
		this.__employee_name_tostring_3 = value;
	}

	public java.lang.String getEmployeeNameTostring5() {
		return this.__employee_name_tostring_5;
	}

	public void setEmployeeNameTostring5( java.lang.String value ) {
		this.__employee_name_tostring_5 = value;
	}


	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getCumulativeTotalAmountProportion() {
		return this.__cumulative_total_amount_proportion;
	}

	public void setCumulativeTotalAmountProportion( java.math.BigDecimal value ) {
		this.__cumulative_total_amount_proportion = value;
	}

	public java.math.BigDecimal getYearTotalAmountProportion() {
		return this.__year_total_amount_proportion;
	}

	public void setYearTotalAmountProportion( java.math.BigDecimal value ) {
		this.__year_total_amount_proportion = value;
	}

	public java.math.BigDecimal getYearTotalAmount() {
		return this.__year_total_amount;
	}

	public void setYearTotalAmount( java.math.BigDecimal value ) {
		this.__year_total_amount = value;
	}

	public java.math.BigDecimal getSurplusYearTotalAmount() {
		return this.__surplus_year_total_amount;
	}

	public void setSurplusYearTotalAmount( java.math.BigDecimal value ) {
		this.__surplus_year_total_amount = value;
	}

	public java.math.BigDecimal getSurplusYearTotalAmountProportion() {
		return this.__surplus_year_total_amount_proportion;
	}

	public void setSurplusYearTotalAmountProportion( java.math.BigDecimal value ) {
		this.__surplus_year_total_amount_proportion = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}


	public void cloneCopy(BaseProjectReportRecordDetail __bean){
		__bean.setPlateId(getPlateId());
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setSubtractComplaintIntegral(getSubtractComplaintIntegral());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setProjectFlag(getProjectFlag());
		__bean.setStatus(getStatus());
		__bean.setProjectCost(getProjectCost());
		__bean.setProgressPercentage(getProgressPercentage());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setMsgCount(getMsgCount());
		__bean.setMsgStatus(getMsgStatus());
		__bean.setEmployeeNameTostring3(getEmployeeNameTostring3());
		__bean.setEmployeeNameTostring5(getEmployeeNameTostring5());
		__bean.setProjectType(getProjectType());
		__bean.setMainProjectStageId(getMainProjectStageId());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setCumulativeTotalAmountProportion(getCumulativeTotalAmountProportion());
		__bean.setYearTotalAmountProportion(getYearTotalAmountProportion());
		__bean.setYearTotalAmount(getYearTotalAmount());
		__bean.setSurplusYearTotalAmount(getSurplusYearTotalAmount());
		__bean.setSurplusYearTotalAmountProportion(getSurplusYearTotalAmountProportion());
		__bean.setBorrowMoney(getBorrowMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_244", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		String strMainProjectStageId = delicacy.system.executor.SelectValueCache.getSelectValue("main_project_stages", String.valueOf(getMainProjectStageId()));
		sb.append(strMainProjectStageId == null ? "" : strMainProjectStageId);
		sb.append(",");
		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(strProjectLevel == null ? "" : strProjectLevel);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_4", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		sb.append(",");
		String strDepartmentManagerId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDepartmentManagerId()));
		sb.append(strDepartmentManagerId == null ? "" : strDepartmentManagerId);
		sb.append(",");
		sb.append(getEmployeeNameTostring3() == null ? "" : getEmployeeNameTostring3());
		sb.append(",");
		sb.append(getEmployeeNameTostring5() == null ? "" : getEmployeeNameTostring5());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getProgressPercentage() == null ? "" : getProgressPercentage());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getSubtractComplaintIntegral() == null ? "" : getSubtractComplaintIntegral());
		sb.append(",");
		String strProjectFlag = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_71", String.valueOf(getProjectFlag()));
		sb.append(strProjectFlag == null ? "" : strProjectFlag);
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getMsgCount() == null ? "" : getMsgCount());
		sb.append(",");
		String strMsgStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_243", String.valueOf(getMsgStatus()));
		sb.append(strMsgStatus == null ? "" : strMsgStatus);
		sb.append(",");
		sb.append(getCumulativeTotalAmountProportion() == null ? "" : getCumulativeTotalAmountProportion());
		sb.append(",");
		sb.append(getYearTotalAmountProportion() == null ? "" : getYearTotalAmountProportion());
		sb.append(",");
		sb.append(getYearTotalAmount() == null ? "" : getYearTotalAmount());
		sb.append(",");
		sb.append(getSurplusYearTotalAmount() == null ? "" : getSurplusYearTotalAmount());
		sb.append(",");
		sb.append(getSurplusYearTotalAmountProportion() == null ? "" : getSurplusYearTotalAmountProportion());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectReportRecordDetail o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__subtract_complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__project_flag);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__progress_percentage);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__msg_count);
		hash = 97 * hash + Objects.hashCode(this.__msg_status);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_tostring_3);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_tostring_5);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__main_project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__cumulative_total_amount_proportion);
		hash = 97 * hash + Objects.hashCode(this.__year_total_amount_proportion);
		hash = 97 * hash + Objects.hashCode(this.__year_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__surplus_year_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__surplus_year_total_amount_proportion);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectReportRecordDetail o = (BaseProjectReportRecordDetail)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__subtract_complaint_integral, o.getSubtractComplaintIntegral())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__project_flag, o.getProjectFlag())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__progress_percentage, o.getProgressPercentage())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__msg_count, o.getMsgCount())) return false;
		if(!Objects.equals(this.__msg_status, o.getMsgStatus())) return false;
		if(!Objects.equals(this.__employee_name_tostring_3, o.getEmployeeNameTostring3())) return false;
		if(!Objects.equals(this.__employee_name_tostring_5, o.getEmployeeNameTostring5())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__main_project_stage_id, o.getMainProjectStageId())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__cumulative_total_amount_proportion, o.getCumulativeTotalAmountProportion())) return false;
		if(!Objects.equals(this.__year_total_amount_proportion, o.getYearTotalAmountProportion())) return false;
		if(!Objects.equals(this.__year_total_amount, o.getYearTotalAmount())) return false;
		if(!Objects.equals(this.__surplus_year_total_amount, o.getSurplusYearTotalAmount())) return false;
		if(!Objects.equals(this.__surplus_year_total_amount_proportion, o.getSurplusYearTotalAmountProportion())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getSubtractComplaintIntegral() != null) sb.append(__wrapNumber(count++, "subtractComplaintIntegral", getSubtractComplaintIntegral()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(count++, "projectFlag", getProjectFlag()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getProgressPercentage() != null) sb.append(__wrapDecimal(count++, "progressPercentage", getProgressPercentage()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getMsgCount() != null) sb.append(__wrapNumber(count++, "msgCount", getMsgCount()));
		if(getMsgStatus() != null) sb.append(__wrapNumber(count++, "msgStatus", getMsgStatus()));
		if(getEmployeeNameTostring3() != null) sb.append(__wrapString(count++, "employeeNameTostring3", getEmployeeNameTostring3()));
		if(getEmployeeNameTostring5() != null) sb.append(__wrapString(count++, "employeeNameTostring5", getEmployeeNameTostring5()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(count++, "mainProjectStageId", getMainProjectStageId()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getCumulativeTotalAmountProportion() != null) sb.append(__wrapDecimal(count++, "cumulativeTotalAmountProportion", getCumulativeTotalAmountProportion()));
		if(getYearTotalAmountProportion() != null) sb.append(__wrapDecimal(count++, "yearTotalAmountProportion", getYearTotalAmountProportion()));
		if(getYearTotalAmount() != null) sb.append(__wrapDecimal(count++, "yearTotalAmount", getYearTotalAmount()));
		if(getSurplusYearTotalAmount() != null) sb.append(__wrapDecimal(count++, "surplusYearTotalAmount", getSurplusYearTotalAmount()));
		if(getSurplusYearTotalAmountProportion() != null) sb.append(__wrapDecimal(count++, "surplusYearTotalAmountProportion", getSurplusYearTotalAmountProportion()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getTotalIntegral() != null) res.put("totalIntegral", getTotalIntegral());
		if(getComplaintIntegral() != null) res.put("complaintIntegral", getComplaintIntegral());
		if(getProjectIntegral() != null) res.put("projectIntegral", getProjectIntegral());
		if(getReserveIntegral() != null) res.put("reserveIntegral", getReserveIntegral());
		if(getSureIntegral() != null) res.put("sureIntegral", getSureIntegral());
		if(getSubtractComplaintIntegral() != null) res.put("subtractComplaintIntegral", getSubtractComplaintIntegral());
		if(getProjectManageId() != null) res.put("projectManageId", getProjectManageId());
		if(getProjectLevel() != null) res.put("projectLevel", getProjectLevel());
		if(getProjectFlag() != null) res.put("projectFlag", getProjectFlag());
		if(getStatus() != null) res.put("status", getStatus());
		if(getProjectCost() != null) res.put("projectCost", getProjectCost());
		if(getProgressPercentage() != null) res.put("progressPercentage", getProgressPercentage());
		if(getSheetAmount() != null) res.put("sheetAmount", getSheetAmount());
		if(getPlateManagerId() != null) res.put("plateManagerId", getPlateManagerId());
		if(getDepartmentManagerId() != null) res.put("departmentManagerId", getDepartmentManagerId());
		if(getMsgCount() != null) res.put("msgCount", getMsgCount());
		if(getMsgStatus() != null) res.put("msgStatus", getMsgStatus());
		if(getEmployeeNameTostring3() != null) res.put("employeeNameTostring3", getEmployeeNameTostring3());
		if(getEmployeeNameTostring5() != null) res.put("employeeNameTostring5", getEmployeeNameTostring5());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getMainProjectStageId() != null) res.put("mainProjectStageId", getMainProjectStageId());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getCumulativeTotalAmountProportion() != null) res.put("cumulativeTotalAmountProportion", getCumulativeTotalAmountProportion());
		if(getYearTotalAmountProportion() != null) res.put("yearTotalAmountProportion", getYearTotalAmountProportion());
		if(getYearTotalAmount() != null) res.put("yearTotalAmount", getYearTotalAmount());
		if(getSurplusYearTotalAmount() != null) res.put("surplusYearTotalAmount", getSurplusYearTotalAmount());
		if(getSurplusYearTotalAmountProportion() != null) res.put("surplusYearTotalAmountProportion", getSurplusYearTotalAmountProportion());
		if(getBorrowMoney() != null) res.put("borrowMoney", getBorrowMoney());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("subtractComplaintIntegral")) != null) setSubtractComplaintIntegral(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("progressPercentage")) != null) setProgressPercentage(__getDecimal(val));  
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("msgCount")) != null) setMsgCount(__getInt(val)); 
		if((val = values.get("msgStatus")) != null) setMsgStatus(__getInt(val)); 
		if((val = values.get("employeeNameTostring3")) != null) setEmployeeNameTostring3(__getString(val));
		if((val = values.get("employeeNameTostring5")) != null) setEmployeeNameTostring5(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val));
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));
		if((val = values.get("cumulativeTotalAmountProportion")) != null) setCumulativeTotalAmountProportion(__getDecimal(val));
		if((val = values.get("yearTotalAmountProportion")) != null) setYearTotalAmountProportion(__getDecimal(val));
		if((val = values.get("yearTotalAmount")) != null) setYearTotalAmount(__getDecimal(val));
		if((val = values.get("surplusYearTotalAmount")) != null) setSurplusYearTotalAmount(__getDecimal(val));
		if((val = values.get("surplusYearTotalAmountProportion")) != null) setSurplusYearTotalAmountProportion(__getDecimal(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.lang.Integer  __subtract_complaint_integral ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __project_flag ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __progress_percentage ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.Integer  __msg_count ;
	protected java.lang.Integer  __msg_status ;
	protected java.lang.String  __employee_name_tostring_3 ;
	protected java.lang.String  __employee_name_tostring_5 ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __main_project_stage_id ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __cumulative_total_amount_proportion ;
	protected java.math.BigDecimal  __year_total_amount_proportion ;
	protected java.math.BigDecimal  __year_total_amount ;
	protected java.math.BigDecimal  __surplus_year_total_amount ;
	protected java.math.BigDecimal  __surplus_year_total_amount_proportion ;
	protected java.math.BigDecimal  __borrow_money ;
}
