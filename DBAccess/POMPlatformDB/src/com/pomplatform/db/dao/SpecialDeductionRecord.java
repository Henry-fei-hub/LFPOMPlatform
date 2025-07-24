package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSpecialDeductionRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SpecialDeductionRecord extends AbstractTable<BaseSpecialDeductionRecord>
{

	public SpecialDeductionRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "special_deduction_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSpecialDeductionRecord.CS_SPECIAL_DEDUCTION_RECORD_ID;
		__column_names[1] = BaseSpecialDeductionRecord.CS_EMPLOYE_ID;
		__column_names[2] = BaseSpecialDeductionRecord.CS_EMPLOYEE_NAME;
		__column_names[3] = BaseSpecialDeductionRecord.CS_START_DATE;
		__column_names[4] = BaseSpecialDeductionRecord.CS_END_DATE;
		__column_names[5] = BaseSpecialDeductionRecord.CS_PROCESS_TYPE;
		__column_names[6] = BaseSpecialDeductionRecord.CS_DEPARMENT_ID;
		__column_names[7] = BaseSpecialDeductionRecord.CS_PLATE_ID;
		__column_names[8] = BaseSpecialDeductionRecord.CS_COMPANY_ID;
		__column_names[9] = BaseSpecialDeductionRecord.CS_CREATE_DATE;
		__column_names[10] = BaseSpecialDeductionRecord.CS_IS_ENABLE;
		__column_names[11] = BaseSpecialDeductionRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSpecialDeductionRecord b) {
		clear();
		setSpecialDeductionRecordIdClear(b.getSpecialDeductionRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getSpecialDeductionRecordId() == null;
	}

	@Override
	public BaseSpecialDeductionRecord generateBase(){
		BaseSpecialDeductionRecord b = new BaseSpecialDeductionRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSpecialDeductionRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeparmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSpecialDeductionRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSpecialDeductionRecordId();
		buff[count++] = b.getEmployeId();
		buff[count++] = b.getEmployeeName();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getProcessType();
		buff[count++] = b.getDeparmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getCompanyId();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getIsEnable();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSpecialDeductionRecord b){
		if(b.getSpecialDeductionRecordId() != null) setSpecialDeductionRecordIdClear(b.getSpecialDeductionRecordId());
		if(b.getEmployeId() != null) setEmployeId(b.getEmployeId());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getDeparmentId() != null) setDeparmentId(b.getDeparmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSpecialDeductionRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSpecialDeductionRecord b = new BaseSpecialDeductionRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSpecialDeductionRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeparmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSpecialDeductionRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSpecialDeductionRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSpecialDeductionRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDeparmentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDeparmentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionSpecialDeductionRecordId(String op, java.lang.Integer val) {
		setConditionSpecialDeductionRecordId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSpecialDeductionRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeId(String op, java.lang.Integer val) {
		setConditionEmployeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDeparmentId(String op, java.lang.Integer val) {
		setConditionDeparmentId(op, val, CONDITION_AND);
	}

	public void setConditionDeparmentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDeparmentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

