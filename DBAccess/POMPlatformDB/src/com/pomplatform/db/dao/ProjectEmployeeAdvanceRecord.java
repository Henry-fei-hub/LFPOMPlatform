package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectEmployeeAdvanceRecord extends AbstractTable<BaseProjectEmployeeAdvanceRecord>
{

	public ProjectEmployeeAdvanceRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_employee_advance_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectEmployeeAdvanceRecord.CS_PROJECT_EMPLOYEE_ADVANCE_RECORD_ID;
		__column_names[1] = BaseProjectEmployeeAdvanceRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectEmployeeAdvanceRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BaseProjectEmployeeAdvanceRecord.CS_ADVANCE_INTEGRAL;
		__column_names[4] = BaseProjectEmployeeAdvanceRecord.CS_ADVANCED_INTEGRAL;
		__column_names[5] = BaseProjectEmployeeAdvanceRecord.CS_ADVANCE_DATE;
		__column_names[6] = BaseProjectEmployeeAdvanceRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BaseProjectEmployeeAdvanceRecord.CS_REMARK;
		__column_names[8] = BaseProjectEmployeeAdvanceRecord.CS_IS_RETURN;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectEmployeeAdvanceRecord b) {
		clear();
		setProjectEmployeeAdvanceRecordIdClear(b.getProjectEmployeeAdvanceRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectEmployeeAdvanceRecordId() == null;
	}

	@Override
	public BaseProjectEmployeeAdvanceRecord generateBase(){
		BaseProjectEmployeeAdvanceRecord b = new BaseProjectEmployeeAdvanceRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectEmployeeAdvanceRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectEmployeeAdvanceRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAdvancedIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectEmployeeAdvanceRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectEmployeeAdvanceRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getAdvanceIntegral();
		buff[count++] = b.getAdvancedIntegral();
		buff[count++] = generateTimestampFromDate(b.getAdvanceDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsReturn();
	}

	@Override
	public void setDataFromBase(BaseProjectEmployeeAdvanceRecord b){
		if(b.getProjectEmployeeAdvanceRecordId() != null) setProjectEmployeeAdvanceRecordIdClear(b.getProjectEmployeeAdvanceRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getAdvanceIntegral() != null) setAdvanceIntegral(b.getAdvanceIntegral());
		if(b.getAdvancedIntegral() != null) setAdvancedIntegral(b.getAdvancedIntegral());
		if(b.getAdvanceDate() != null) setAdvanceDate(b.getAdvanceDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
	}

	@Override
	public BaseProjectEmployeeAdvanceRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectEmployeeAdvanceRecord b = new BaseProjectEmployeeAdvanceRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectEmployeeAdvanceRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectEmployeeAdvanceRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvancedIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
	}

	public void setProjectEmployeeAdvanceRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectEmployeeAdvanceRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectEmployeeAdvanceRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAdvanceIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAdvancedIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAdvancedIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setAdvanceDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getAdvanceDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setConditionProjectEmployeeAdvanceRecordId(String op, java.lang.Integer val) {
		setConditionProjectEmployeeAdvanceRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectEmployeeAdvanceRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectEmployeeAdvanceRecordId(boolean val) {
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

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAdvanceIntegral(String op, java.math.BigDecimal val) {
		setConditionAdvanceIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAdvanceIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAdvanceIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAdvancedIntegral(String op, java.math.BigDecimal val) {
		setConditionAdvancedIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAdvancedIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAdvancedIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAdvanceDate(String op, java.util.Date val) {
		setConditionAdvanceDate(op, val, CONDITION_AND);
	}

	public void setConditionAdvanceDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAdvanceDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
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

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[8] = val;
	}


}

