package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateIntegralSumRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateIntegralSumRecord extends AbstractTable<BasePlateIntegralSumRecord>
{

	public PlateIntegralSumRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "plate_integral_sum_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateIntegralSumRecord.CS_PLATE_INTEGRAL_SUM_RECORD_ID;
		__column_names[1] = BasePlateIntegralSumRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateIntegralSumRecord.CS_TYPE_FLAG;
		__column_names[3] = BasePlateIntegralSumRecord.CS_YEAR;
		__column_names[4] = BasePlateIntegralSumRecord.CS_MONTH;
		__column_names[5] = BasePlateIntegralSumRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[6] = BasePlateIntegralSumRecord.CS_PROJECT_INTEGRAL_SUM;
		__column_names[7] = BasePlateIntegralSumRecord.CS_PROJECT_INTEGRAL;
		__column_names[8] = BasePlateIntegralSumRecord.CS_RESERVE_INTEGRAL;
		__column_names[9] = BasePlateIntegralSumRecord.CS_SURE_INTEGRAL;
		__column_names[10] = BasePlateIntegralSumRecord.CS_COST_INTEGRAL;
		__column_names[11] = BasePlateIntegralSumRecord.CS_SALARY_INTEGRAL;
		__column_names[12] = BasePlateIntegralSumRecord.CS_SETTLEMENT_INTEGRAL;
		__column_names[13] = BasePlateIntegralSumRecord.CS_IS_LOCK;
		__column_names[14] = BasePlateIntegralSumRecord.CS_CREATE_TIME;
		__column_names[15] = BasePlateIntegralSumRecord.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateIntegralSumRecord b) {
		clear();
		setPlateIntegralSumRecordIdClear(b.getPlateIntegralSumRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateIntegralSumRecordId() == null;
	}

	@Override
	public BasePlateIntegralSumRecord generateBase(){
		BasePlateIntegralSumRecord b = new BasePlateIntegralSumRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateIntegralSumRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateIntegralSumRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTypeFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCostIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSettlementIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateIntegralSumRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateIntegralSumRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getTypeFlag();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getProjectIntegralSum();
		buff[count++] = b.getProjectIntegral();
		buff[count++] = b.getReserveIntegral();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getCostIntegral();
		buff[count++] = b.getSalaryIntegral();
		buff[count++] = b.getSettlementIntegral();
		buff[count++] = b.getIsLock();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BasePlateIntegralSumRecord b){
		if(b.getPlateIntegralSumRecordId() != null) setPlateIntegralSumRecordIdClear(b.getPlateIntegralSumRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getTypeFlag() != null) setTypeFlag(b.getTypeFlag());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getProjectIntegralSum() != null) setProjectIntegralSum(b.getProjectIntegralSum());
		if(b.getProjectIntegral() != null) setProjectIntegral(b.getProjectIntegral());
		if(b.getReserveIntegral() != null) setReserveIntegral(b.getReserveIntegral());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getCostIntegral() != null) setCostIntegral(b.getCostIntegral());
		if(b.getSalaryIntegral() != null) setSalaryIntegral(b.getSalaryIntegral());
		if(b.getSettlementIntegral() != null) setSettlementIntegral(b.getSettlementIntegral());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BasePlateIntegralSumRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateIntegralSumRecord b = new BasePlateIntegralSumRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateIntegralSumRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateIntegralSumRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTypeFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setPlateIntegralSumRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateIntegralSumRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateIntegralSumRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTypeFlag(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getTypeFlag() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setProjectIntegralSum(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getProjectIntegralSum() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setCostIntegral(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getCostIntegral() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setSalaryIntegral(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getSalaryIntegral() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setSettlementIntegral(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getSettlementIntegral() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setIsLock(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getIsLock() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setConditionPlateIntegralSumRecordId(String op, java.lang.Integer val) {
		setConditionPlateIntegralSumRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateIntegralSumRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateIntegralSumRecordId(boolean val) {
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

	public void setConditionTypeFlag(String op, java.lang.Integer val) {
		setConditionTypeFlag(op, val, CONDITION_AND);
	}

	public void setConditionTypeFlag(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTypeFlag(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProjectIntegralSum(String op, java.math.BigDecimal val) {
		setConditionProjectIntegralSum(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralSum(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectIntegralSum(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectReserveIntegral(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCostIntegral(String op, java.math.BigDecimal val) {
		setConditionCostIntegral(op, val, CONDITION_AND);
	}

	public void setConditionCostIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCostIntegral(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSalaryIntegral(String op, java.math.BigDecimal val) {
		setConditionSalaryIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSalaryIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSalaryIntegral(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSettlementIntegral(String op, java.math.BigDecimal val) {
		setConditionSettlementIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSettlementIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSettlementIntegral(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionIsLock(String op, java.lang.Integer val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[15] = val;
	}


}

