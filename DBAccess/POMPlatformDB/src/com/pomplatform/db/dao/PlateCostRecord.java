package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateCostRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateCostRecord extends AbstractTable<BasePlateCostRecord>
{

	public PlateCostRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "plate_cost_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateCostRecord.CS_PLATE_COST_RECORD_ID;
		__column_names[1] = BasePlateCostRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateCostRecord.CS_COST_INTEGRAL;
		__column_names[3] = BasePlateCostRecord.CS_SALARY_INTEGRAL;
		__column_names[4] = BasePlateCostRecord.CS_REMARK;
		__column_names[5] = BasePlateCostRecord.CS_IS_SETTLEMENT;
		__column_names[6] = BasePlateCostRecord.CS_YEAR;
		__column_names[7] = BasePlateCostRecord.CS_MONTH;
		__column_names[8] = BasePlateCostRecord.CS_COST_DATE;
		__column_names[9] = BasePlateCostRecord.CS_PROCESS_TYPE;
		__column_names[10] = BasePlateCostRecord.CS_BUSINESS_ID;
		__column_names[11] = BasePlateCostRecord.CS_PROCESS_ID;
		__column_names[12] = BasePlateCostRecord.CS_PROCESS_INSTANCE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateCostRecord b) {
		clear();
		setPlateCostRecordIdClear(b.getPlateCostRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateCostRecordId() == null;
	}

	@Override
	public BasePlateCostRecord generateBase(){
		BasePlateCostRecord b = new BasePlateCostRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateCostRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateCostRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCostIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSettlement(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateCostRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateCostRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getCostIntegral();
		buff[count++] = b.getSalaryIntegral();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsSettlement();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getCostDate());
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessId();
		buff[count++] = b.getProcessInstanceId();
	}

	@Override
	public void setDataFromBase(BasePlateCostRecord b){
		if(b.getPlateCostRecordId() != null) setPlateCostRecordIdClear(b.getPlateCostRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getCostIntegral() != null) setCostIntegral(b.getCostIntegral());
		if(b.getSalaryIntegral() != null) setSalaryIntegral(b.getSalaryIntegral());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsSettlement() != null) setIsSettlement(b.getIsSettlement());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getCostDate() != null) setCostDate(b.getCostDate());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
	}

	@Override
	public BasePlateCostRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateCostRecord b = new BasePlateCostRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateCostRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateCostRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSettlement(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
	}

	public void setPlateCostRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateCostRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateCostRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCostIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getCostIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setSalaryIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getSalaryIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setIsSettlement(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getIsSettlement() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCostDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCostDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setConditionPlateCostRecordId(String op, java.lang.Integer val) {
		setConditionPlateCostRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateCostRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateCostRecordId(boolean val) {
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

	public void setConditionCostIntegral(String op, java.math.BigDecimal val) {
		setConditionCostIntegral(op, val, CONDITION_AND);
	}

	public void setConditionCostIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCostIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSalaryIntegral(String op, java.math.BigDecimal val) {
		setConditionSalaryIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSalaryIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSalaryIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionIsSettlement(String op, java.lang.Boolean val) {
		setConditionIsSettlement(op, val, CONDITION_AND);
	}

	public void setConditionIsSettlement(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIsSettlement(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCostDate(String op, java.util.Date val) {
		setConditionCostDate(op, val, CONDITION_AND);
	}

	public void setConditionCostDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCostDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[12] = val;
	}


}

