package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectEmployeeIntegralRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectEmployeeIntegralRecord extends AbstractTable<BaseProjectEmployeeIntegralRecord>
{

	public ProjectEmployeeIntegralRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_employee_integral_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectEmployeeIntegralRecord.CS_PROJECT_EMPLOYEE_INTEGRAL_RECORD_ID;
		__column_names[1] = BaseProjectEmployeeIntegralRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectEmployeeIntegralRecord.CS_STAGE_ID;
		__column_names[3] = BaseProjectEmployeeIntegralRecord.CS_EMPLOYEE_ID;
		__column_names[4] = BaseProjectEmployeeIntegralRecord.CS_SURE_INTEGRAL;
		__column_names[5] = BaseProjectEmployeeIntegralRecord.CS_INPUT_SURE_INTEGRAL;
		__column_names[6] = BaseProjectEmployeeIntegralRecord.CS_STATUS;
		__column_names[7] = BaseProjectEmployeeIntegralRecord.CS_SURE_DATE;
		__column_names[8] = BaseProjectEmployeeIntegralRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectEmployeeIntegralRecord b) {
		clear();
		setProjectEmployeeIntegralRecordIdClear(b.getProjectEmployeeIntegralRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectEmployeeIntegralRecordId() == null;
	}

	@Override
	public BaseProjectEmployeeIntegralRecord generateBase(){
		BaseProjectEmployeeIntegralRecord b = new BaseProjectEmployeeIntegralRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectEmployeeIntegralRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectEmployeeIntegralRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSureDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectEmployeeIntegralRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectEmployeeIntegralRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getInputSureIntegral();
		buff[count++] = b.getStatus();
		buff[count++] = generateTimestampFromDate(b.getSureDate());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectEmployeeIntegralRecord b){
		if(b.getProjectEmployeeIntegralRecordId() != null) setProjectEmployeeIntegralRecordIdClear(b.getProjectEmployeeIntegralRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getInputSureIntegral() != null) setInputSureIntegral(b.getInputSureIntegral());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getSureDate() != null) setSureDate(b.getSureDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectEmployeeIntegralRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectEmployeeIntegralRecord b = new BaseProjectEmployeeIntegralRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectEmployeeIntegralRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectEmployeeIntegralRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectEmployeeIntegralRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectEmployeeIntegralRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectEmployeeIntegralRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setInputSureIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getInputSureIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSureDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getSureDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionProjectEmployeeIntegralRecordId(String op, java.lang.Integer val) {
		setConditionProjectEmployeeIntegralRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectEmployeeIntegralRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectEmployeeIntegralRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInputSureIntegral(String op, java.math.BigDecimal val) {
		setConditionInputSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionInputSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInputSureIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSureDate(String op, java.util.Date val) {
		setConditionSureDate(op, val, CONDITION_AND);
	}

	public void setConditionSureDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSureDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}


}

