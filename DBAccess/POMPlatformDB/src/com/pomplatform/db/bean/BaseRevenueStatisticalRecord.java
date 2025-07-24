package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRevenueStatisticalRecord extends GenericBase implements BaseFactory<BaseRevenueStatisticalRecord>, Comparable<BaseRevenueStatisticalRecord> 
{


	public static BaseRevenueStatisticalRecord newInstance(){
		return new BaseRevenueStatisticalRecord();
	}

	@Override
	public BaseRevenueStatisticalRecord make(){
		BaseRevenueStatisticalRecord b = new BaseRevenueStatisticalRecord();
		return b;
	}

	public final static java.lang.String CS_REVENUE_STATISTICAL_RECORD_ID = "revenue_statistical_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_SHEET_PERCENT = "sheet_percent" ;
	public final static java.lang.String CS_MODIFY_PERCENT = "modify_percent" ;
	public final static java.lang.String CS_TOTAL_PERCENT = "total_percent" ;
	public final static java.lang.String CS_TOTAL_TAX_REVENUE = "total_tax_revenue" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_CURRENT_REVENUE = "current_revenue" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_RATE_PERCENT = "rate_percent" ;
	public final static java.lang.String CS_RATE_PERCENT_STR = "rate_percent_str" ;
	public final static java.lang.String CS_SHEET_PERCENT_STR = "sheet_percent_str" ;
	public final static java.lang.String CS_MODIFY_PERCENT_STR = "modify_percent_str" ;
	public final static java.lang.String CS_TOTAL_PERCENT_STR = "total_percent_str" ;
	public final static java.lang.String CS_TOTAL_SURE_PERCENT = "total_sure_percent" ;
	public final static java.lang.String CS_TOTAL_SURE_PERCENT_STR = "total_sure_percent_str" ;
	public final static java.lang.String CS_TOTAL_SURE_REVENUE = "total_sure_revenue" ;
	public final static java.lang.String CS_CONTRACT_SAVE = "contract_save" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_CONTRACT_SAVE_ACTIVE = "contract_save_active" ;
	public final static java.lang.String CS_CONTRACT_SAVE_ACTIVE_UN = "contract_save_active_un" ;
	public final static java.lang.String CS_CONTRACT_SAVE_ACTIVE_PAUSE = "contract_save_active_pause" ;
	public final static java.lang.String CS_CONTRACT_SAVE_ACTIVE_NEVER = "contract_save_active_never" ;
	public final static java.lang.String CS_CONTRACT_SAVE_OTHER = "contract_save_other" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,年份,月份,订单生成百分比,运营调节百分比,累计百分比,累计含税营收,累计营收,本月营收,操作人,操作时间,备注,订单合同金额,税率,税率,订单生成百分比,运营调节百分比,累计百分比,累计确认百分比,累计百分比,累计确认营收,合同存量,是否加锁,项目积分,活跃合同存量,非活跃合同存量,暂停合同存量,项目未启动合同存量,其他合同存量";

	public java.lang.Integer getRevenueStatisticalRecordId() {
		return this.__revenue_statistical_record_id;
	}

	public void setRevenueStatisticalRecordId( java.lang.Integer value ) {
		this.__revenue_statistical_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
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

	public java.math.BigDecimal getSheetPercent() {
		return this.__sheet_percent;
	}

	public void setSheetPercent( java.math.BigDecimal value ) {
		this.__sheet_percent = value;
	}

	public java.math.BigDecimal getModifyPercent() {
		return this.__modify_percent;
	}

	public void setModifyPercent( java.math.BigDecimal value ) {
		this.__modify_percent = value;
	}

	public java.math.BigDecimal getTotalPercent() {
		return this.__total_percent;
	}

	public void setTotalPercent( java.math.BigDecimal value ) {
		this.__total_percent = value;
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

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
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

	public java.lang.String getSheetPercentStr() {
		return this.__sheet_percent_str;
	}

	public void setSheetPercentStr( java.lang.String value ) {
		this.__sheet_percent_str = value;
	}

	public java.lang.String getModifyPercentStr() {
		return this.__modify_percent_str;
	}

	public void setModifyPercentStr( java.lang.String value ) {
		this.__modify_percent_str = value;
	}

	public java.lang.String getTotalPercentStr() {
		return this.__total_percent_str;
	}

	public void setTotalPercentStr( java.lang.String value ) {
		this.__total_percent_str = value;
	}

	public java.math.BigDecimal getTotalSurePercent() {
		return this.__total_sure_percent;
	}

	public void setTotalSurePercent( java.math.BigDecimal value ) {
		this.__total_sure_percent = value;
	}

	public java.lang.String getTotalSurePercentStr() {
		return this.__total_sure_percent_str;
	}

	public void setTotalSurePercentStr( java.lang.String value ) {
		this.__total_sure_percent_str = value;
	}

	public java.math.BigDecimal getTotalSureRevenue() {
		return this.__total_sure_revenue;
	}

	public void setTotalSureRevenue( java.math.BigDecimal value ) {
		this.__total_sure_revenue = value;
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

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getContractSaveActive() {
		return this.__contract_save_active;
	}

	public void setContractSaveActive( java.math.BigDecimal value ) {
		this.__contract_save_active = value;
	}

	public java.math.BigDecimal getContractSaveActiveUn() {
		return this.__contract_save_active_un;
	}

	public void setContractSaveActiveUn( java.math.BigDecimal value ) {
		this.__contract_save_active_un = value;
	}

	public java.math.BigDecimal getContractSaveActivePause() {
		return this.__contract_save_active_pause;
	}

	public void setContractSaveActivePause( java.math.BigDecimal value ) {
		this.__contract_save_active_pause = value;
	}

	public java.math.BigDecimal getContractSaveActiveNever() {
		return this.__contract_save_active_never;
	}

	public void setContractSaveActiveNever( java.math.BigDecimal value ) {
		this.__contract_save_active_never = value;
	}

	public java.math.BigDecimal getContractSaveOther() {
		return this.__contract_save_other;
	}

	public void setContractSaveOther( java.math.BigDecimal value ) {
		this.__contract_save_other = value;
	}

	public void cloneCopy(BaseRevenueStatisticalRecord __bean){
		__bean.setRevenueStatisticalRecordId(getRevenueStatisticalRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setSheetPercent(getSheetPercent());
		__bean.setModifyPercent(getModifyPercent());
		__bean.setTotalPercent(getTotalPercent());
		__bean.setTotalTaxRevenue(getTotalTaxRevenue());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setCurrentRevenue(getCurrentRevenue());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setRatePercent(getRatePercent());
		__bean.setRatePercentStr(getRatePercentStr());
		__bean.setSheetPercentStr(getSheetPercentStr());
		__bean.setModifyPercentStr(getModifyPercentStr());
		__bean.setTotalPercentStr(getTotalPercentStr());
		__bean.setTotalSurePercent(getTotalSurePercent());
		__bean.setTotalSurePercentStr(getTotalSurePercentStr());
		__bean.setTotalSureRevenue(getTotalSureRevenue());
		__bean.setContractSave(getContractSave());
		__bean.setIsLocked(getIsLocked());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setContractSaveActive(getContractSaveActive());
		__bean.setContractSaveActiveUn(getContractSaveActiveUn());
		__bean.setContractSaveActivePause(getContractSaveActivePause());
		__bean.setContractSaveActiveNever(getContractSaveActiveNever());
		__bean.setContractSaveOther(getContractSaveOther());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRevenueStatisticalRecordId() == null ? "" : getRevenueStatisticalRecordId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strYear = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_18", String.valueOf(getYear()));
		sb.append(strYear == null ? "" : strYear);
		sb.append(",");
		String strMonth = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_19", String.valueOf(getMonth()));
		sb.append(strMonth == null ? "" : strMonth);
		sb.append(",");
		sb.append(getSheetPercent() == null ? "" : getSheetPercent());
		sb.append(",");
		sb.append(getModifyPercent() == null ? "" : getModifyPercent());
		sb.append(",");
		sb.append(getTotalPercent() == null ? "" : getTotalPercent());
		sb.append(",");
		sb.append(getTotalTaxRevenue() == null ? "" : getTotalTaxRevenue());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getRatePercent() == null ? "" : getRatePercent());
		sb.append(",");
		sb.append(getRatePercentStr() == null ? "" : getRatePercentStr());
		sb.append(",");
		sb.append(getSheetPercentStr() == null ? "" : getSheetPercentStr());
		sb.append(",");
		sb.append(getModifyPercentStr() == null ? "" : getModifyPercentStr());
		sb.append(",");
		sb.append(getTotalPercentStr() == null ? "" : getTotalPercentStr());
		sb.append(",");
		sb.append(getTotalSurePercent() == null ? "" : getTotalSurePercent());
		sb.append(",");
		sb.append(getTotalSurePercentStr() == null ? "" : getTotalSurePercentStr());
		sb.append(",");
		sb.append(getTotalSureRevenue() == null ? "" : getTotalSureRevenue());
		sb.append(",");
		sb.append(getContractSave() == null ? "" : getContractSave());
		sb.append(",");
		sb.append(getIsLocked() == null ? "" : getIsLocked());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getContractSaveActive() == null ? "" : getContractSaveActive());
		sb.append(",");
		sb.append(getContractSaveActiveUn() == null ? "" : getContractSaveActiveUn());
		sb.append(",");
		sb.append(getContractSaveActivePause() == null ? "" : getContractSaveActivePause());
		sb.append(",");
		sb.append(getContractSaveActiveNever() == null ? "" : getContractSaveActiveNever());
		sb.append(",");
		sb.append(getContractSaveOther() == null ? "" : getContractSaveOther());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueStatisticalRecord o) {
		return __revenue_statistical_record_id == null ? -1 : __revenue_statistical_record_id.compareTo(o.getRevenueStatisticalRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__revenue_statistical_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__sheet_percent);
		hash = 97 * hash + Objects.hashCode(this.__modify_percent);
		hash = 97 * hash + Objects.hashCode(this.__total_percent);
		hash = 97 * hash + Objects.hashCode(this.__total_tax_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__rate_percent);
		hash = 97 * hash + Objects.hashCode(this.__rate_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__sheet_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__modify_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__total_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_percent);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_revenue);
		hash = 97 * hash + Objects.hashCode(this.__contract_save);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active_un);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active_pause);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_active_never);
		hash = 97 * hash + Objects.hashCode(this.__contract_save_other);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueStatisticalRecord o = (BaseRevenueStatisticalRecord)obj;
		if(!Objects.equals(this.__revenue_statistical_record_id, o.getRevenueStatisticalRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__sheet_percent, o.getSheetPercent())) return false;
		if(!Objects.equals(this.__modify_percent, o.getModifyPercent())) return false;
		if(!Objects.equals(this.__total_percent, o.getTotalPercent())) return false;
		if(!Objects.equals(this.__total_tax_revenue, o.getTotalTaxRevenue())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__rate_percent, o.getRatePercent())) return false;
		if(!Objects.equals(this.__rate_percent_str, o.getRatePercentStr())) return false;
		if(!Objects.equals(this.__sheet_percent_str, o.getSheetPercentStr())) return false;
		if(!Objects.equals(this.__modify_percent_str, o.getModifyPercentStr())) return false;
		if(!Objects.equals(this.__total_percent_str, o.getTotalPercentStr())) return false;
		if(!Objects.equals(this.__total_sure_percent, o.getTotalSurePercent())) return false;
		if(!Objects.equals(this.__total_sure_percent_str, o.getTotalSurePercentStr())) return false;
		if(!Objects.equals(this.__total_sure_revenue, o.getTotalSureRevenue())) return false;
		if(!Objects.equals(this.__contract_save, o.getContractSave())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__contract_save_active, o.getContractSaveActive())) return false;
		if(!Objects.equals(this.__contract_save_active_un, o.getContractSaveActiveUn())) return false;
		if(!Objects.equals(this.__contract_save_active_pause, o.getContractSaveActivePause())) return false;
		if(!Objects.equals(this.__contract_save_active_never, o.getContractSaveActiveNever())) return false;
		if(!Objects.equals(this.__contract_save_other, o.getContractSaveOther())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRevenueStatisticalRecordId() != null) sb.append(__wrapNumber(count++, "revenueStatisticalRecordId", getRevenueStatisticalRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getSheetPercent() != null) sb.append(__wrapDecimal(count++, "sheetPercent", getSheetPercent()));
		if(getModifyPercent() != null) sb.append(__wrapDecimal(count++, "modifyPercent", getModifyPercent()));
		if(getTotalPercent() != null) sb.append(__wrapDecimal(count++, "totalPercent", getTotalPercent()));
		if(getTotalTaxRevenue() != null) sb.append(__wrapDecimal(count++, "totalTaxRevenue", getTotalTaxRevenue()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getRatePercent() != null) sb.append(__wrapDecimal(count++, "ratePercent", getRatePercent()));
		if(getRatePercentStr() != null) sb.append(__wrapString(count++, "ratePercentStr", getRatePercentStr()));
		if(getSheetPercentStr() != null) sb.append(__wrapString(count++, "sheetPercentStr", getSheetPercentStr()));
		if(getModifyPercentStr() != null) sb.append(__wrapString(count++, "modifyPercentStr", getModifyPercentStr()));
		if(getTotalPercentStr() != null) sb.append(__wrapString(count++, "totalPercentStr", getTotalPercentStr()));
		if(getTotalSurePercent() != null) sb.append(__wrapDecimal(count++, "totalSurePercent", getTotalSurePercent()));
		if(getTotalSurePercentStr() != null) sb.append(__wrapString(count++, "totalSurePercentStr", getTotalSurePercentStr()));
		if(getTotalSureRevenue() != null) sb.append(__wrapDecimal(count++, "totalSureRevenue", getTotalSureRevenue()));
		if(getContractSave() != null) sb.append(__wrapDecimal(count++, "contractSave", getContractSave()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getContractSaveActive() != null) sb.append(__wrapDecimal(count++, "contractSaveActive", getContractSaveActive()));
		if(getContractSaveActiveUn() != null) sb.append(__wrapDecimal(count++, "contractSaveActiveUn", getContractSaveActiveUn()));
		if(getContractSaveActivePause() != null) sb.append(__wrapDecimal(count++, "contractSaveActivePause", getContractSaveActivePause()));
		if(getContractSaveActiveNever() != null) sb.append(__wrapDecimal(count++, "contractSaveActiveNever", getContractSaveActiveNever()));
		if(getContractSaveOther() != null) sb.append(__wrapDecimal(count++, "contractSaveOther", getContractSaveOther()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getRevenueStatisticalRecordId() != null) res.put("revenueStatisticalRecordId", getRevenueStatisticalRecordId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getSheetPercent() != null) res.put("sheetPercent", getSheetPercent());
		if(getModifyPercent() != null) res.put("modifyPercent", getModifyPercent());
		if(getTotalPercent() != null) res.put("totalPercent", getTotalPercent());
		if(getTotalTaxRevenue() != null) res.put("totalTaxRevenue", getTotalTaxRevenue());
		if(getTotalRevenue() != null) res.put("totalRevenue", getTotalRevenue());
		if(getCurrentRevenue() != null) res.put("currentRevenue", getCurrentRevenue());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getSheetAmount() != null) res.put("sheetAmount", getSheetAmount());
		if(getRatePercent() != null) res.put("ratePercent", getRatePercent());
		if(getRatePercentStr() != null) res.put("ratePercentStr", getRatePercentStr());
		if(getSheetPercentStr() != null) res.put("sheetPercentStr", getSheetPercentStr());
		if(getModifyPercentStr() != null) res.put("modifyPercentStr", getModifyPercentStr());
		if(getTotalPercentStr() != null) res.put("totalPercentStr", getTotalPercentStr());
		if(getTotalSurePercent() != null) res.put("totalSurePercent", getTotalSurePercent());
		if(getTotalSurePercentStr() != null) res.put("totalSurePercentStr", getTotalSurePercentStr());
		if(getTotalSureRevenue() != null) res.put("totalSureRevenue", getTotalSureRevenue());
		if(getContractSave() != null) res.put("contractSave", getContractSave());
		if(getIsLocked() != null) res.put("isLocked", getIsLocked());
		if(getProjectIntegral() != null) res.put("projectIntegral", getProjectIntegral());
		if(getContractSaveActive() != null) res.put("contractSaveActive", getContractSaveActive());
		if(getContractSaveActiveUn() != null) res.put("contractSaveActiveUn", getContractSaveActiveUn());
		if(getContractSaveActivePause() != null) res.put("contractSaveActivePause", getContractSaveActivePause());
		if(getContractSaveActiveNever() != null) res.put("contractSaveActiveNever", getContractSaveActiveNever());
		if(getContractSaveOther() != null) res.put("contractSaveOther", getContractSaveOther());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("revenueStatisticalRecordId")) != null) setRevenueStatisticalRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("sheetPercent")) != null) setSheetPercent(__getDecimal(val));  
		if((val = values.get("modifyPercent")) != null) setModifyPercent(__getDecimal(val));  
		if((val = values.get("totalPercent")) != null) setTotalPercent(__getDecimal(val));  
		if((val = values.get("totalTaxRevenue")) != null) setTotalTaxRevenue(__getDecimal(val));  
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));  
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("ratePercent")) != null) setRatePercent(__getDecimal(val));  
		if((val = values.get("ratePercentStr")) != null) setRatePercentStr(__getString(val));
		if((val = values.get("sheetPercentStr")) != null) setSheetPercentStr(__getString(val));
		if((val = values.get("modifyPercentStr")) != null) setModifyPercentStr(__getString(val));
		if((val = values.get("totalPercentStr")) != null) setTotalPercentStr(__getString(val));
		if((val = values.get("totalSurePercent")) != null) setTotalSurePercent(__getDecimal(val));  
		if((val = values.get("totalSurePercentStr")) != null) setTotalSurePercentStr(__getString(val));
		if((val = values.get("totalSureRevenue")) != null) setTotalSureRevenue(__getDecimal(val));  
		if((val = values.get("contractSave")) != null) setContractSave(__getDecimal(val));  
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("contractSaveActive")) != null) setContractSaveActive(__getDecimal(val));  
		if((val = values.get("contractSaveActiveUn")) != null) setContractSaveActiveUn(__getDecimal(val));  
		if((val = values.get("contractSaveActivePause")) != null) setContractSaveActivePause(__getDecimal(val));  
		if((val = values.get("contractSaveActiveNever")) != null) setContractSaveActiveNever(__getDecimal(val));  
		if((val = values.get("contractSaveOther")) != null) setContractSaveOther(__getDecimal(val));  
	}

	protected java.lang.Integer  __revenue_statistical_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __sheet_percent ;
	protected java.math.BigDecimal  __modify_percent ;
	protected java.math.BigDecimal  __total_percent ;
	protected java.math.BigDecimal  __total_tax_revenue ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal  __current_revenue ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __rate_percent ;
	protected java.lang.String  __rate_percent_str ;
	protected java.lang.String  __sheet_percent_str ;
	protected java.lang.String  __modify_percent_str ;
	protected java.lang.String  __total_percent_str ;
	protected java.math.BigDecimal  __total_sure_percent ;
	protected java.lang.String  __total_sure_percent_str ;
	protected java.math.BigDecimal  __total_sure_revenue ;
	protected java.math.BigDecimal  __contract_save ;
	protected java.lang.Boolean  __is_locked ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __contract_save_active ;
	protected java.math.BigDecimal  __contract_save_active_un ;
	protected java.math.BigDecimal  __contract_save_active_pause ;
	protected java.math.BigDecimal  __contract_save_active_never ;
	protected java.math.BigDecimal  __contract_save_other ;
}
