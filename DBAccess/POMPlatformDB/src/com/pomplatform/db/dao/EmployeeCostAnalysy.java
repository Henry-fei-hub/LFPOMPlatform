package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeCostAnalysy;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeCostAnalysy extends AbstractTable<BaseEmployeeCostAnalysy>
{

	public EmployeeCostAnalysy() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "employee_cost_analysis";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeCostAnalysy.CS_EMPLOYEE_COST_ANALYSIS_ID;
		__column_names[1] = BaseEmployeeCostAnalysy.CS_PLATE_ID;
		__column_names[2] = BaseEmployeeCostAnalysy.CS_YEAR;
		__column_names[3] = BaseEmployeeCostAnalysy.CS_MONTH;
		__column_names[4] = BaseEmployeeCostAnalysy.CS_THIS_MONTH_PAY;
		__column_names[5] = BaseEmployeeCostAnalysy.CS_LAST_MONTH_PAY;
		__column_names[6] = BaseEmployeeCostAnalysy.CS_PAY_RAISE;
		__column_names[7] = BaseEmployeeCostAnalysy.CS_THIS_MONTH_INSURANCE;
		__column_names[8] = BaseEmployeeCostAnalysy.CS_LAST_MONTH_INSURANCE;
		__column_names[9] = BaseEmployeeCostAnalysy.CS_INSURANCE_RAISE;
		__column_names[10] = BaseEmployeeCostAnalysy.CS_PAY_REMARK;
		__column_names[11] = BaseEmployeeCostAnalysy.CS_INSURANCE_REMARK;
		__column_names[12] = BaseEmployeeCostAnalysy.CS_IS_LOCKED;
		__column_names[13] = BaseEmployeeCostAnalysy.CS_OPERATE_EMPLOYEE_ID;
		__column_names[14] = BaseEmployeeCostAnalysy.CS_OPERATE_TIME;
		__column_names[15] = BaseEmployeeCostAnalysy.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeCostAnalysy b) {
		clear();
		setEmployeeCostAnalysisIdClear(b.getEmployeeCostAnalysisId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeCostAnalysisId() == null;
	}

	@Override
	public BaseEmployeeCostAnalysy generateBase(){
		BaseEmployeeCostAnalysy b = new BaseEmployeeCostAnalysy();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeCostAnalysy b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeCostAnalysisId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThisMonthPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLastMonthPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayRaise(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setThisMonthInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLastMonthInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInsuranceRaise(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPayRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInsuranceRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeCostAnalysy b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeCostAnalysisId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getThisMonthPay();
		buff[count++] = b.getLastMonthPay();
		buff[count++] = b.getPayRaise();
		buff[count++] = b.getThisMonthInsurance();
		buff[count++] = b.getLastMonthInsurance();
		buff[count++] = b.getInsuranceRaise();
		buff[count++] = b.getPayRemark();
		buff[count++] = b.getInsuranceRemark();
		buff[count++] = b.getIsLocked();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseEmployeeCostAnalysy b){
		if(b.getEmployeeCostAnalysisId() != null) setEmployeeCostAnalysisIdClear(b.getEmployeeCostAnalysisId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getThisMonthPay() != null) setThisMonthPay(b.getThisMonthPay());
		if(b.getLastMonthPay() != null) setLastMonthPay(b.getLastMonthPay());
		if(b.getPayRaise() != null) setPayRaise(b.getPayRaise());
		if(b.getThisMonthInsurance() != null) setThisMonthInsurance(b.getThisMonthInsurance());
		if(b.getLastMonthInsurance() != null) setLastMonthInsurance(b.getLastMonthInsurance());
		if(b.getInsuranceRaise() != null) setInsuranceRaise(b.getInsuranceRaise());
		if(b.getPayRemark() != null) setPayRemark(b.getPayRemark());
		if(b.getInsuranceRemark() != null) setInsuranceRemark(b.getInsuranceRemark());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseEmployeeCostAnalysy generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeCostAnalysy b = new BaseEmployeeCostAnalysy();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeCostAnalysy __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeCostAnalysisId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThisMonthPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastMonthPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayRaise(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThisMonthInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastMonthInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsuranceRaise(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsuranceRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setEmployeeCostAnalysisId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeCostAnalysisId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeCostAnalysisIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setThisMonthPay(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getThisMonthPay() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setLastMonthPay(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getLastMonthPay() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPayRaise(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getPayRaise() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setThisMonthInsurance(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getThisMonthInsurance() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setLastMonthInsurance(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getLastMonthInsurance() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setInsuranceRaise(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getInsuranceRaise() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setPayRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getPayRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setInsuranceRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getInsuranceRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setConditionEmployeeCostAnalysisId(String op, java.lang.Integer val) {
		setConditionEmployeeCostAnalysisId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeCostAnalysisId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeCostAnalysisId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionThisMonthPay(String op, java.math.BigDecimal val) {
		setConditionThisMonthPay(op, val, CONDITION_AND);
	}

	public void setConditionThisMonthPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectThisMonthPay(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionLastMonthPay(String op, java.math.BigDecimal val) {
		setConditionLastMonthPay(op, val, CONDITION_AND);
	}

	public void setConditionLastMonthPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectLastMonthPay(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPayRaise(String op, java.lang.String val) {
		setConditionPayRaise(op, val, CONDITION_AND);
	}

	public void setConditionPayRaise(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPayRaise(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionThisMonthInsurance(String op, java.math.BigDecimal val) {
		setConditionThisMonthInsurance(op, val, CONDITION_AND);
	}

	public void setConditionThisMonthInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectThisMonthInsurance(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionLastMonthInsurance(String op, java.math.BigDecimal val) {
		setConditionLastMonthInsurance(op, val, CONDITION_AND);
	}

	public void setConditionLastMonthInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLastMonthInsurance(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionInsuranceRaise(String op, java.lang.String val) {
		setConditionInsuranceRaise(op, val, CONDITION_AND);
	}

	public void setConditionInsuranceRaise(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectInsuranceRaise(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPayRemark(String op, java.lang.String val) {
		setConditionPayRemark(op, val, CONDITION_AND);
	}

	public void setConditionPayRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectPayRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionInsuranceRemark(String op, java.lang.String val) {
		setConditionInsuranceRemark(op, val, CONDITION_AND);
	}

	public void setConditionInsuranceRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectInsuranceRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[15] = val;
	}


}

