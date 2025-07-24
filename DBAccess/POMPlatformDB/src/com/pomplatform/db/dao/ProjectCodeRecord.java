package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectCodeRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectCodeRecord extends AbstractTable<BaseProjectCodeRecord>
{

	public ProjectCodeRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "project_code_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectCodeRecord.CS_PROJECT_CODE_RECORD_ID;
		__column_names[1] = BaseProjectCodeRecord.CS_PLATE_ID;
		__column_names[2] = BaseProjectCodeRecord.CS_CODE;
		__column_names[3] = BaseProjectCodeRecord.CS_PROJECT_CODE;
		__column_names[4] = BaseProjectCodeRecord.CS_NAME;
		__column_names[5] = BaseProjectCodeRecord.CS_YEAR;
		__column_names[6] = BaseProjectCodeRecord.CS_MONTH;
		__column_names[7] = BaseProjectCodeRecord.CS_SERIAL_NUMBER;
		__column_names[8] = BaseProjectCodeRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[9] = BaseProjectCodeRecord.CS_OPERATE_TIME;
		__column_names[10] = BaseProjectCodeRecord.CS_REMARK;
		__column_names[11] = BaseProjectCodeRecord.CS_PROJECT_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectCodeRecord b) {
		clear();
		setProjectCodeRecordIdClear(b.getProjectCodeRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectCodeRecordId() == null;
	}

	@Override
	public BaseProjectCodeRecord generateBase(){
		BaseProjectCodeRecord b = new BaseProjectCodeRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectCodeRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectCodeRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectCodeRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectCodeRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getName();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getSerialNumber();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getProjectFlag();
	}

	@Override
	public void setDataFromBase(BaseProjectCodeRecord b){
		if(b.getProjectCodeRecordId() != null) setProjectCodeRecordIdClear(b.getProjectCodeRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProjectFlag() != null) setProjectFlag(b.getProjectFlag());
	}

	@Override
	public BaseProjectCodeRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectCodeRecord b = new BaseProjectCodeRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectCodeRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCodeRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectFlag(GenericBase.__getInt(val));
	}

	public void setProjectCodeRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectCodeRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectCodeRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSerialNumber(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSerialNumber() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setProjectFlag(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProjectFlag() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionProjectCodeRecordId(String op, java.lang.Integer val) {
		setConditionProjectCodeRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectCodeRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectCodeRecordId(boolean val) {
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

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProjectFlag(String op, java.lang.Integer val) {
		setConditionProjectFlag(op, val, CONDITION_AND);
	}

	public void setConditionProjectFlag(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProjectFlag(boolean val) {
		__select_flags[11] = val;
	}


}

