package pomplatform.revenueStatistical.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRevenueStatisticalOfRevenue extends GenericBase implements BaseFactory<BaseRevenueStatisticalOfRevenue>, Comparable<BaseRevenueStatisticalOfRevenue> 
{


	public static BaseRevenueStatisticalOfRevenue newInstance(){
		return new BaseRevenueStatisticalOfRevenue();
	}

	@Override
	public BaseRevenueStatisticalOfRevenue make(){
		BaseRevenueStatisticalOfRevenue b = new BaseRevenueStatisticalOfRevenue();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SHEET_CODE = "sheet_code" ;
	public final static java.lang.String CS_SHEET_NAME = "sheet_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_OLD_SHEET_AMOUNT = "old_sheet_amount" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_OLD_PROJECT_INTEGRAL = "old_project_integral" ;
	public final static java.lang.String CS_SHEET_PERCENT = "sheet_percent" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_SHEET_PERCENT_STR = "sheet_percent_str" ;
	public final static java.lang.String CS_MODIFY_PERCENT = "modify_percent" ;
	public final static java.lang.String CS_MODIFY_PERCENT_STR = "modify_percent_str" ;
	public final static java.lang.String CS_TOTAL_PERCENT = "total_percent" ;
	public final static java.lang.String CS_TOTAL_PERCENT_STR = "total_percent_str" ;
	public final static java.lang.String CS_TOTAL_TAX_REVENUE = "total_tax_revenue" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_CURRENT_REVENUE = "current_revenue" ;
	public final static java.lang.String CS_LAST_MONTH_REVENUE = "last_month_revenue" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RATE_PERCENT = "rate_percent" ;
	public final static java.lang.String CS_RATE_PERCENT_STR = "rate_percent_str" ;
	public final static java.lang.String CS_REVENUE_STATISTICAL_RECORD_ID = "revenue_statistical_record_id" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_TOTAL_SURE_REVENUE = "total_sure_revenue" ;
	public final static java.lang.String CS_TOTAL_SURE_PERCENT_STR = "total_sure_percent_str" ;
	public final static java.lang.String CS_CONTRACT_SAVE = "contract_save" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;

	public final static java.lang.String ALL_CAPTIONS = "项目代码,板块,订单编号,订单名称,合同编号,项目总积分,订单合同金额,实时订单合同金额,合同金额,项目积分,实时项目积分,订单完成百分比,确认积分,订单生成百分比,运营调节百分比,运营调节百分比,累计百分比,累计百分比,累计含税营收,累计营收,本月营收,上月累计营收,年份,月份,税率,税率,主键编码,事业部负责人,部门经理,专业负责人,,结算状态,累计确认营收,累计百分比,合同存量";
	public final static java.lang.String CUSTOM_CAPTIONS = "业务部门,订单编号,订单名称,年份,月份,订单金额,税率,订单生成百分比,运营调节百分比,累计百分比,累计含税营收,累计营收,本月营收,累计确认百分比,累计确认营收,合同存量,活跃合同存量,非活跃合同存量,暂停合同存量,项目未启动合同存量,项目状态,专业负责人,是否保存";
	
	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code;
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name;
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getOldSheetAmount() {
		return this.__old_sheet_amount;
	}

	public void setOldSheetAmount( java.math.BigDecimal value ) {
		this.__old_sheet_amount = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getOldProjectIntegral() {
		return this.__old_project_integral;
	}

	public void setOldProjectIntegral( java.math.BigDecimal value ) {
		this.__old_project_integral = value;
	}

	public java.math.BigDecimal getSheetPercent() {
		return this.__sheet_percent;
	}

	public void setSheetPercent( java.math.BigDecimal value ) {
		this.__sheet_percent = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.lang.String getSheetPercentStr() {
		return this.__sheet_percent_str;
	}

	public void setSheetPercentStr( java.lang.String value ) {
		this.__sheet_percent_str = value;
	}

	public java.math.BigDecimal getModifyPercent() {
		return this.__modify_percent;
	}

	public void setModifyPercent( java.math.BigDecimal value ) {
		this.__modify_percent = value;
	}

	public java.lang.String getModifyPercentStr() {
		return this.__modify_percent_str;
	}

	public void setModifyPercentStr( java.lang.String value ) {
		this.__modify_percent_str = value;
	}

	public java.math.BigDecimal getTotalPercent() {
		return this.__total_percent;
	}

	public void setTotalPercent( java.math.BigDecimal value ) {
		this.__total_percent = value;
	}

	public java.lang.String getTotalPercentStr() {
		return this.__total_percent_str;
	}

	public void setTotalPercentStr( java.lang.String value ) {
		this.__total_percent_str = value;
	}

	public java.math.BigDecimal getTotalTaxRevenue() {
		return this.__total_tax_revenue;
	}

	public void setTotalTaxRevenue( java.math.BigDecimal value ) {
		this.__total_tax_revenue = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return this.__current_revenue;
	}

	public void setCurrentRevenue( java.math.BigDecimal value ) {
		this.__current_revenue = value;
	}

	public java.math.BigDecimal getLastMonthRevenue() {
		return this.__last_month_revenue;
	}

	public void setLastMonthRevenue( java.math.BigDecimal value ) {
		this.__last_month_revenue = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getRatePercent() {
		return this.__rate_percent;
	}

	public void setRatePercent( java.math.BigDecimal value ) {
		this.__rate_percent = value;
	}

	public java.lang.String getRatePercentStr() {
		return this.__rate_percent_str;
	}

	public void setRatePercentStr( java.lang.String value ) {
		this.__rate_percent_str = value;
	}

	public java.lang.Integer getRevenueStatisticalRecordId() {
		return this.__revenue_statistical_record_id;
	}

	public void setRevenueStatisticalRecordId( java.lang.Integer value ) {
		this.__revenue_statistical_record_id = value;
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

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getTotalSureRevenue() {
		return this.__total_sure_revenue;
	}

	public void setTotalSureRevenue( java.math.BigDecimal value ) {
		this.__total_sure_revenue = value;
	}

	public java.lang.String getTotalSurePercentStr() {
		return this.__total_sure_percent_str;
	}

	public void setTotalSurePercentStr( java.lang.String value ) {
		this.__total_sure_percent_str = value;
	}

	public java.math.BigDecimal getContractSave() {
		return this.__contract_save;
	}

	public void setContractSave( java.math.BigDecimal value ) {
		this.__contract_save = value;
	}
	
	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}
	
	public java.math.BigDecimal getContractSaveActive() {
		return this.__contract_save_active;
	}

	public void setContractSaveActive( java.math.BigDecimal value ) {
		this.__contract_save_active = value;
	}
	
	public java.lang.Integer getDayStatus() {
		return this.__day_status;
	}

	public void setDayStatus( java.lang.Integer value ) {
		this.__day_status = value;
	}
	
	
	public java.math.BigDecimal getContractSaveActiveUn() {
		return __contract_save_active_un;
	}

	public void setContractSaveActiveUn(java.math.BigDecimal value) {
		this.__contract_save_active_un = value;
	}

	public java.math.BigDecimal getContractSaveActivePause() {
		return __contract_save_active_pause;
	}

	public void setContractSaveActivePause(java.math.BigDecimal value) {
		this.__contract_save_active_pause = value;
	}

	public java.math.BigDecimal getContractSaveActiveNever() {
		return __contract_save_active_never;
	}

	public void setContractSaveActiveNever(java.math.BigDecimal value) {
		this.__contract_save_active_never = value;
	}
	
	public java.math.BigDecimal getContractSaveOther() {
		return __contract_save_other;
	}
	
	public void setContractSaveOther(java.math.BigDecimal value) {
		this.__contract_save_other = value;
	}

	public java.lang.Integer getContractStatus() {
		return __contract_status;
	}

	public void setContractStatus(java.lang.Integer value) {
		this.__contract_status = value;
	}

	public void cloneCopy(BaseRevenueStatisticalOfRevenue __bean){
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setSheetCode(getSheetCode());
		__bean.setSheetName(getSheetName());
		__bean.setContractCode(getContractCode());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setOldSheetAmount(getOldSheetAmount());
		__bean.setContractAmount(getContractAmount());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setOldProjectIntegral(getOldProjectIntegral());
		__bean.setSheetPercent(getSheetPercent());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setSheetPercentStr(getSheetPercentStr());
		__bean.setModifyPercent(getModifyPercent());
		__bean.setModifyPercentStr(getModifyPercentStr());
		__bean.setTotalPercent(getTotalPercent());
		__bean.setTotalPercentStr(getTotalPercentStr());
		__bean.setTotalTaxRevenue(getTotalTaxRevenue());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setCurrentRevenue(getCurrentRevenue());
		__bean.setLastMonthRevenue(getLastMonthRevenue());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRatePercent(getRatePercent());
		__bean.setRatePercentStr(getRatePercentStr());
		__bean.setRevenueStatisticalRecordId(getRevenueStatisticalRecordId());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setFlag(getFlag());
		__bean.setStatus(getStatus());
		__bean.setTotalSureRevenue(getTotalSureRevenue());
		__bean.setTotalSurePercentStr(getTotalSurePercentStr());
		__bean.setContractSave(getContractSave());
		__bean.setIsLocked(getIsLocked());
		__bean.setContractSaveActive(getContractSaveActive());
		__bean.setDayStatus(getDayStatus());
		__bean.setContractSaveActiveUn(getContractSaveActiveUn());
		__bean.setContractSaveActivePause(getContractSaveActivePause());
		__bean.setContractSaveActiveNever(getContractSaveActiveNever());
		__bean.setContractSaveOther(getContractSaveOther());
		__bean.setContractStatus(getContractStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getSheetCode() == null ? "" : getSheetCode());
		sb.append(",");
		sb.append(getSheetName() == null ? "" : getSheetName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getOldSheetAmount() == null ? "" : getOldSheetAmount());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getOldProjectIntegral() == null ? "" : getOldProjectIntegral());
		sb.append(",");
		sb.append(getSheetPercent() == null ? "" : getSheetPercent());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getSheetPercentStr() == null ? "" : getSheetPercentStr());
		sb.append(",");
		sb.append(getModifyPercent() == null ? "" : getModifyPercent());
		sb.append(",");
		sb.append(getModifyPercentStr() == null ? "" : getModifyPercentStr());
		sb.append(",");
		sb.append(getTotalPercent() == null ? "" : getTotalPercent());
		sb.append(",");
		sb.append(getTotalPercentStr() == null ? "" : getTotalPercentStr());
		sb.append(",");
		sb.append(getTotalTaxRevenue() == null ? "" : getTotalTaxRevenue());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		sb.append(",");
		sb.append(getLastMonthRevenue() == null ? "" : getLastMonthRevenue());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getRatePercent() == null ? "" : getRatePercent());
		sb.append(",");
		sb.append(getRatePercentStr() == null ? "" : getRatePercentStr());
		sb.append(",");
		sb.append(getRevenueStatisticalRecordId() == null ? "" : getRevenueStatisticalRecordId());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getTotalSureRevenue() == null ? "" : getTotalSureRevenue());
		sb.append(",");
		sb.append(getTotalSurePercentStr() == null ? "" : getTotalSurePercentStr());
		sb.append(",");
		sb.append(getContractSave() == null ? "" : getContractSave());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueStatisticalOfRevenue o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_code);
		hash = 97 * hash + Objects.hashCode(this.__sheet_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__old_sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__old_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_percent);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__modify_percent);
		hash = 97 * hash + Objects.hashCode(this.__modify_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__total_percent);
		hash = 97 * hash + Objects.hashCode(this.__total_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__total_tax_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__last_month_revenue);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__rate_percent);
		hash = 97 * hash + Objects.hashCode(this.__rate_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__revenue_statistical_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__contract_save);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active);
		hash = 97 * hash + Objects.hashCode(this.__day_status);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active_un);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active_pause);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active_never);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_other);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueStatisticalOfRevenue o = (BaseRevenueStatisticalOfRevenue)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__sheet_code, o.getSheetCode())) return false;
		if(!Objects.equals(this.__sheet_name, o.getSheetName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__old_sheet_amount, o.getOldSheetAmount())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__old_project_integral, o.getOldProjectIntegral())) return false;
		if(!Objects.equals(this.__sheet_percent, o.getSheetPercent())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__sheet_percent_str, o.getSheetPercentStr())) return false;
		if(!Objects.equals(this.__modify_percent, o.getModifyPercent())) return false;
		if(!Objects.equals(this.__modify_percent_str, o.getModifyPercentStr())) return false;
		if(!Objects.equals(this.__total_percent, o.getTotalPercent())) return false;
		if(!Objects.equals(this.__total_percent_str, o.getTotalPercentStr())) return false;
		if(!Objects.equals(this.__total_tax_revenue, o.getTotalTaxRevenue())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		if(!Objects.equals(this.__last_month_revenue, o.getLastMonthRevenue())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__rate_percent, o.getRatePercent())) return false;
		if(!Objects.equals(this.__rate_percent_str, o.getRatePercentStr())) return false;
		if(!Objects.equals(this.__revenue_statistical_record_id, o.getRevenueStatisticalRecordId())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__total_sure_revenue, o.getTotalSureRevenue())) return false;
		if(!Objects.equals(this.__total_sure_percent_str, o.getTotalSurePercentStr())) return false;
		if(!Objects.equals(this.__contract_save, o.getContractSave())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		if(!Objects.equals(this.__contract_save_active, o.getContractSaveActive())) return false;
		if(!Objects.equals(this.__day_status, o.getDayStatus())) return false;
		if(!Objects.equals(this.__contract_save_active_un, o.getContractSaveActiveUn())) return false;
		if(!Objects.equals(this.__contract_save_active_pause, o.getContractSaveActivePause())) return false;
		if(!Objects.equals(this.__contract_save_active_never, o.getContractSaveActiveNever())) return false;
		if(!Objects.equals(this.__contract_save_other, o.getContractSaveOther())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSheetCode() != null) sb.append(__wrapString(count++, "sheetCode", getSheetCode()));
		if(getSheetName() != null) sb.append(__wrapString(count++, "sheetName", getSheetName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getOldSheetAmount() != null) sb.append(__wrapDecimal(count++, "oldSheetAmount", getOldSheetAmount()));
		if(getContractAmount() != null) sb.append(__wrapNumber(count++, "contractAmount", getContractAmount()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getOldProjectIntegral() != null) sb.append(__wrapDecimal(count++, "oldProjectIntegral", getOldProjectIntegral()));
		if(getSheetPercent() != null) sb.append(__wrapDecimal(count++, "sheetPercent", getSheetPercent()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getSheetPercentStr() != null) sb.append(__wrapString(count++, "sheetPercentStr", getSheetPercentStr()));
		if(getModifyPercent() != null) sb.append(__wrapDecimal(count++, "modifyPercent", getModifyPercent()));
		if(getModifyPercentStr() != null) sb.append(__wrapString(count++, "modifyPercentStr", getModifyPercentStr()));
		if(getTotalPercent() != null) sb.append(__wrapDecimal(count++, "totalPercent", getTotalPercent()));
		if(getTotalPercentStr() != null) sb.append(__wrapString(count++, "totalPercentStr", getTotalPercentStr()));
		if(getTotalTaxRevenue() != null) sb.append(__wrapDecimal(count++, "totalTaxRevenue", getTotalTaxRevenue()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		if(getLastMonthRevenue() != null) sb.append(__wrapDecimal(count++, "lastMonthRevenue", getLastMonthRevenue()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRatePercent() != null) sb.append(__wrapDecimal(count++, "ratePercent", getRatePercent()));
		if(getRatePercentStr() != null) sb.append(__wrapString(count++, "ratePercentStr", getRatePercentStr()));
		if(getRevenueStatisticalRecordId() != null) sb.append(__wrapNumber(count++, "revenueStatisticalRecordId", getRevenueStatisticalRecordId()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getTotalSureRevenue() != null) sb.append(__wrapDecimal(count++, "totalSureRevenue", getTotalSureRevenue()));
		if(getTotalSurePercentStr() != null) sb.append(__wrapString(count++, "totalSurePercentStr", getTotalSurePercentStr()));
		if(getContractSave() != null) sb.append(__wrapDecimal(count++, "contractSave", getContractSave()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		if(getContractSaveActive()!= null) sb.append(__wrapDecimal(count++, "contractSaveActive", getContractSaveActive()));
		if(getDayStatus() != null) sb.append(__wrapNumber(count++, "dayStatus", getDayStatus()));
		if(getContractSaveActiveUn()!= null) sb.append(__wrapDecimal(count++, "contractSaveActiveUn", getContractSaveActiveUn()));
		if(getContractSaveActivePause()!= null) sb.append(__wrapDecimal(count++, "contractSaveActivePause", getContractSaveActivePause()));
		if(getContractSaveActiveNever()!= null) sb.append(__wrapDecimal(count++, "contractSaveActiveNever", getContractSaveActiveNever()));
		if(getContractSaveOther()!= null) sb.append(__wrapDecimal(count++, "contractSaveOther", getContractSaveOther()));
		if(getContractStatus()!= null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("oldSheetAmount")) != null) setOldSheetAmount(__getDecimal(val));  
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val)); 
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("oldProjectIntegral")) != null) setOldProjectIntegral(__getDecimal(val));  
		if((val = values.get("sheetPercent")) != null) setSheetPercent(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("sheetPercentStr")) != null) setSheetPercentStr(__getString(val));
		if((val = values.get("modifyPercent")) != null) setModifyPercent(__getDecimal(val));  
		if((val = values.get("modifyPercentStr")) != null) setModifyPercentStr(__getString(val));
		if((val = values.get("totalPercent")) != null) setTotalPercent(__getDecimal(val));  
		if((val = values.get("totalPercentStr")) != null) setTotalPercentStr(__getString(val));
		if((val = values.get("totalTaxRevenue")) != null) setTotalTaxRevenue(__getDecimal(val));  
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));  
		if((val = values.get("lastMonthRevenue")) != null) setLastMonthRevenue(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("ratePercent")) != null) setRatePercent(__getDecimal(val));  
		if((val = values.get("ratePercentStr")) != null) setRatePercentStr(__getString(val));
		if((val = values.get("revenueStatisticalRecordId")) != null) setRevenueStatisticalRecordId(__getInt(val)); 
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("totalSureRevenue")) != null) setTotalSureRevenue(__getDecimal(val));  
		if((val = values.get("totalSurePercentStr")) != null) setTotalSurePercentStr(__getString(val));
		if((val = values.get("contractSave")) != null) setContractSave(__getDecimal(val));
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
		if((val = values.get("contractSaveActive")) != null) setContractSaveActive(__getDecimal(val));
		if((val = values.get("dayStatus")) != null) setDayStatus(__getInt(val)); 
		if((val = values.get("contractSaveActiveUn")) != null) setContractSaveActiveUn(__getDecimal(val));
		if((val = values.get("contractSaveActivePause")) != null) setContractSaveActivePause(__getDecimal(val));
		if((val = values.get("contractSaveActiveNever")) != null) setContractSaveActiveNever(__getDecimal(val));
		if((val = values.get("contractSaveOther")) != null) setContractSaveOther(__getDecimal(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val));
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __sheet_code ;
	protected java.lang.String  __sheet_name ;
	protected java.lang.String  __contract_code ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __old_sheet_amount ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __old_project_integral ;
	protected java.math.BigDecimal  __sheet_percent ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.lang.String  __sheet_percent_str ;
	protected java.math.BigDecimal  __modify_percent ;
	protected java.lang.String  __modify_percent_str ;
	protected java.math.BigDecimal  __total_percent ;
	protected java.lang.String  __total_percent_str ;
	protected java.math.BigDecimal  __total_tax_revenue ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal  __current_revenue ;
	protected java.math.BigDecimal  __last_month_revenue ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __rate_percent ;
	protected java.lang.String  __rate_percent_str ;
	protected java.lang.Integer  __revenue_statistical_record_id ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __day_status ;
	protected java.math.BigDecimal  __total_sure_revenue ;
	protected java.lang.String  __total_sure_percent_str ;
	protected java.math.BigDecimal  __contract_save ;
	protected java.math.BigDecimal  __contract_save_active ;
	protected java.lang.Boolean  __is_locked ;
	protected java.math.BigDecimal  __contract_save_active_un ;
	protected java.math.BigDecimal  __contract_save_active_pause ;
	protected java.math.BigDecimal  __contract_save_active_never ;
	protected java.math.BigDecimal  __contract_save_other ;
	protected java.lang.Integer  __contract_status ;
}
