package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateIntegralSumRecord extends GenericBase implements BaseFactory<BasePlateIntegralSumRecord>, Comparable<BasePlateIntegralSumRecord> 
{


	public static BasePlateIntegralSumRecord newInstance(){
		return new BasePlateIntegralSumRecord();
	}

	@Override
	public BasePlateIntegralSumRecord make(){
		BasePlateIntegralSumRecord b = new BasePlateIntegralSumRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_INTEGRAL_SUM_RECORD_ID = "plate_integral_sum_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_TYPE_FLAG = "type_flag" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL_SUM = "project_integral_sum" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COST_INTEGRAL = "cost_integral" ;
	public final static java.lang.String CS_SALARY_INTEGRAL = "salary_integral" ;
	public final static java.lang.String CS_SETTLEMENT_INTEGRAL = "settlement_integral" ;
	public final static java.lang.String CS_IS_LOCK = "is_lock" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,版块编码,标志位，0项目汇总；  1部门汇总,年份,月份,价值积分,项目总积分,项目积分,预留积分,确认积分,成本积分,人工成本,结算积分,该记录是否锁定[0未锁定；   1已锁定],创建时间,修改时间";

	public java.lang.Integer getPlateIntegralSumRecordId() {
		return this.__plate_integral_sum_record_id;
	}

	public void setPlateIntegralSumRecordId( java.lang.Integer value ) {
		this.__plate_integral_sum_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getTypeFlag() {
		return this.__type_flag;
	}

	public void setTypeFlag( java.lang.Integer value ) {
		this.__type_flag = value;
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

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getProjectIntegralSum() {
		return this.__project_integral_sum;
	}

	public void setProjectIntegralSum( java.math.BigDecimal value ) {
		this.__project_integral_sum = value;
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

	public java.math.BigDecimal getCostIntegral() {
		return this.__cost_integral;
	}

	public void setCostIntegral( java.math.BigDecimal value ) {
		this.__cost_integral = value;
	}

	public java.math.BigDecimal getSalaryIntegral() {
		return this.__salary_integral;
	}

	public void setSalaryIntegral( java.math.BigDecimal value ) {
		this.__salary_integral = value;
	}

	public java.math.BigDecimal getSettlementIntegral() {
		return this.__settlement_integral;
	}

	public void setSettlementIntegral( java.math.BigDecimal value ) {
		this.__settlement_integral = value;
	}

	public java.lang.Integer getIsLock() {
		return this.__is_lock;
	}

	public void setIsLock( java.lang.Integer value ) {
		this.__is_lock = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public void cloneCopy(BasePlateIntegralSumRecord __bean){
		__bean.setPlateIntegralSumRecordId(getPlateIntegralSumRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setTypeFlag(getTypeFlag());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setProjectIntegralSum(getProjectIntegralSum());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCostIntegral(getCostIntegral());
		__bean.setSalaryIntegral(getSalaryIntegral());
		__bean.setSettlementIntegral(getSettlementIntegral());
		__bean.setIsLock(getIsLock());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateIntegralSumRecordId() == null ? "" : getPlateIntegralSumRecordId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getTypeFlag() == null ? "" : getTypeFlag());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getProjectIntegralSum() == null ? "" : getProjectIntegralSum());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCostIntegral() == null ? "" : getCostIntegral());
		sb.append(",");
		sb.append(getSalaryIntegral() == null ? "" : getSalaryIntegral());
		sb.append(",");
		sb.append(getSettlementIntegral() == null ? "" : getSettlementIntegral());
		sb.append(",");
		sb.append(getIsLock() == null ? "" : getIsLock());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateIntegralSumRecord o) {
		return __plate_integral_sum_record_id == null ? -1 : __plate_integral_sum_record_id.compareTo(o.getPlateIntegralSumRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_integral_sum_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__type_flag);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral_sum);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_integral);
		hash = 97 * hash + Objects.hashCode(this.__settlement_integral);
		hash = 97 * hash + Objects.hashCode(this.__is_lock);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateIntegralSumRecord o = (BasePlateIntegralSumRecord)obj;
		if(!Objects.equals(this.__plate_integral_sum_record_id, o.getPlateIntegralSumRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__type_flag, o.getTypeFlag())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__project_integral_sum, o.getProjectIntegralSum())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__cost_integral, o.getCostIntegral())) return false;
		if(!Objects.equals(this.__salary_integral, o.getSalaryIntegral())) return false;
		if(!Objects.equals(this.__settlement_integral, o.getSettlementIntegral())) return false;
		if(!Objects.equals(this.__is_lock, o.getIsLock())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateIntegralSumRecordId() != null) sb.append(__wrapNumber(count++, "plateIntegralSumRecordId", getPlateIntegralSumRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getTypeFlag() != null) sb.append(__wrapNumber(count++, "typeFlag", getTypeFlag()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getProjectIntegralSum() != null) sb.append(__wrapDecimal(count++, "projectIntegralSum", getProjectIntegralSum()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getCostIntegral() != null) sb.append(__wrapDecimal(count++, "costIntegral", getCostIntegral()));
		if(getSalaryIntegral() != null) sb.append(__wrapDecimal(count++, "salaryIntegral", getSalaryIntegral()));
		if(getSettlementIntegral() != null) sb.append(__wrapDecimal(count++, "settlementIntegral", getSettlementIntegral()));
		if(getIsLock() != null) sb.append(__wrapNumber(count++, "isLock", getIsLock()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateIntegralSumRecordId")) != null) setPlateIntegralSumRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("typeFlag")) != null) setTypeFlag(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegralSum")) != null) setProjectIntegralSum(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("costIntegral")) != null) setCostIntegral(__getDecimal(val));  
		if((val = values.get("salaryIntegral")) != null) setSalaryIntegral(__getDecimal(val));  
		if((val = values.get("settlementIntegral")) != null) setSettlementIntegral(__getDecimal(val));  
		if((val = values.get("isLock")) != null) setIsLock(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __plate_integral_sum_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __type_flag ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __project_integral_sum ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __cost_integral ;
	protected java.math.BigDecimal  __salary_integral ;
	protected java.math.BigDecimal  __settlement_integral ;
	protected java.lang.Integer  __is_lock ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
}
