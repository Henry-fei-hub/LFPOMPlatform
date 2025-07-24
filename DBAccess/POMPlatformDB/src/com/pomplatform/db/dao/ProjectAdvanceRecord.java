package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectAdvanceRecord extends AbstractTable<BaseProjectAdvanceRecord>
{

	public ProjectAdvanceRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_advance_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectAdvanceRecord.CS_PROJECT_ADVANCE_RECORD_ID;
		__column_names[1] = BaseProjectAdvanceRecord.CS_PLATE_ID;
		__column_names[2] = BaseProjectAdvanceRecord.CS_PROJECT_ID;
		__column_names[3] = BaseProjectAdvanceRecord.CS_ADVANCE_INTEGRAL;
		__column_names[4] = BaseProjectAdvanceRecord.CS_LEFT_INTEGRAL;
		__column_names[5] = BaseProjectAdvanceRecord.CS_ADVANCE_DATE;
		__column_names[6] = BaseProjectAdvanceRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BaseProjectAdvanceRecord.CS_REMARK;
		__column_names[8] = BaseProjectAdvanceRecord.CS_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectAdvanceRecord b) {
		clear();
		setProjectAdvanceRecordIdClear(b.getProjectAdvanceRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectAdvanceRecordId() == null;
	}

	@Override
	public BaseProjectAdvanceRecord generateBase(){
		BaseProjectAdvanceRecord b = new BaseProjectAdvanceRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectAdvanceRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectAdvanceRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectAdvanceRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectAdvanceRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getAdvanceIntegral();
		buff[count++] = b.getLeftIntegral();
		buff[count++] = generateTimestampFromDate(b.getAdvanceDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getFlag();
	}

	@Override
	public void setDataFromBase(BaseProjectAdvanceRecord b){
		if(b.getProjectAdvanceRecordId() != null) setProjectAdvanceRecordIdClear(b.getProjectAdvanceRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getAdvanceIntegral() != null) setAdvanceIntegral(b.getAdvanceIntegral());
		if(b.getLeftIntegral() != null) setLeftIntegral(b.getLeftIntegral());
		if(b.getAdvanceDate() != null) setAdvanceDate(b.getAdvanceDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getFlag() != null) setFlag(b.getFlag());
	}

	@Override
	public BaseProjectAdvanceRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectAdvanceRecord b = new BaseProjectAdvanceRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectAdvanceRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAdvanceRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
	}

	public void setProjectAdvanceRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectAdvanceRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectAdvanceRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAdvanceIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setLeftIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getLeftIntegral() {
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

	public void setFlag(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionProjectAdvanceRecordId(String op, java.lang.Integer val) {
		setConditionProjectAdvanceRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectAdvanceRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectAdvanceRecordId(boolean val) {
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

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
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

	public void setConditionLeftIntegral(String op, java.math.BigDecimal val) {
		setConditionLeftIntegral(op, val, CONDITION_AND);
	}

	public void setConditionLeftIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectLeftIntegral(boolean val) {
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

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[8] = val;
	}


}

