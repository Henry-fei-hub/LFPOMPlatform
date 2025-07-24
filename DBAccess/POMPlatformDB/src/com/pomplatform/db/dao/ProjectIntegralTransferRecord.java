package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectIntegralTransferRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectIntegralTransferRecord extends AbstractTable<BaseProjectIntegralTransferRecord>
{

	public ProjectIntegralTransferRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "project_integral_transfer_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectIntegralTransferRecord.CS_PROJECT_INTEGRAL_TRANSFER_RECORD_ID;
		__column_names[1] = BaseProjectIntegralTransferRecord.CS_FROM_PROJECT_ID;
		__column_names[2] = BaseProjectIntegralTransferRecord.CS_TO_PROJECT_ID;
		__column_names[3] = BaseProjectIntegralTransferRecord.CS_TRANSFER_INTEGRAL;
		__column_names[4] = BaseProjectIntegralTransferRecord.CS_TRANSFER_DATE;
		__column_names[5] = BaseProjectIntegralTransferRecord.CS_PLATE_ID;
		__column_names[6] = BaseProjectIntegralTransferRecord.CS_PLATE_EMPLOYEE_ID;
		__column_names[7] = BaseProjectIntegralTransferRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectIntegralTransferRecord b) {
		clear();
		setProjectIntegralTransferRecordIdClear(b.getProjectIntegralTransferRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectIntegralTransferRecordId() == null;
	}

	@Override
	public BaseProjectIntegralTransferRecord generateBase(){
		BaseProjectIntegralTransferRecord b = new BaseProjectIntegralTransferRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectIntegralTransferRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectIntegralTransferRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFromProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setToProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTransferIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTransferDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectIntegralTransferRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectIntegralTransferRecordId();
		buff[count++] = b.getFromProjectId();
		buff[count++] = b.getToProjectId();
		buff[count++] = b.getTransferIntegral();
		buff[count++] = generateTimestampFromDate(b.getTransferDate());
		buff[count++] = b.getPlateId();
		buff[count++] = b.getPlateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectIntegralTransferRecord b){
		if(b.getProjectIntegralTransferRecordId() != null) setProjectIntegralTransferRecordIdClear(b.getProjectIntegralTransferRecordId());
		if(b.getFromProjectId() != null) setFromProjectId(b.getFromProjectId());
		if(b.getToProjectId() != null) setToProjectId(b.getToProjectId());
		if(b.getTransferIntegral() != null) setTransferIntegral(b.getTransferIntegral());
		if(b.getTransferDate() != null) setTransferDate(b.getTransferDate());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getPlateEmployeeId() != null) setPlateEmployeeId(b.getPlateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectIntegralTransferRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectIntegralTransferRecord b = new BaseProjectIntegralTransferRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectIntegralTransferRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralTransferRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectIntegralTransferRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectIntegralTransferRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectIntegralTransferRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFromProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFromProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setToProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getToProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTransferIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getTransferIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setTransferDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getTransferDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPlateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPlateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionProjectIntegralTransferRecordId(String op, java.lang.Integer val) {
		setConditionProjectIntegralTransferRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralTransferRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectIntegralTransferRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFromProjectId(String op, java.lang.Integer val) {
		setConditionFromProjectId(op, val, CONDITION_AND);
	}

	public void setConditionFromProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFromProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionToProjectId(String op, java.lang.Integer val) {
		setConditionToProjectId(op, val, CONDITION_AND);
	}

	public void setConditionToProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectToProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTransferIntegral(String op, java.math.BigDecimal val) {
		setConditionTransferIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTransferIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTransferIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTransferDate(String op, java.util.Date val) {
		setConditionTransferDate(op, val, CONDITION_AND);
	}

	public void setConditionTransferDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTransferDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val) {
		setConditionPlateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPlateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}


}

