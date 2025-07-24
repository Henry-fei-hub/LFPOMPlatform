package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectIntegralAssignRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectIntegralAssignRecord extends AbstractTable<BaseProjectIntegralAssignRecord>
{

	public ProjectIntegralAssignRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "project_integral_assign_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectIntegralAssignRecord.CS_PROJECT_INTEGRAL_ASSIGN_RECORD_ID;
		__column_names[1] = BaseProjectIntegralAssignRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectIntegralAssignRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BaseProjectIntegralAssignRecord.CS_BEFORE_RESERVE_INTEGRAL;
		__column_names[4] = BaseProjectIntegralAssignRecord.CS_AFTER_RESERVE_INTEGRAL;
		__column_names[5] = BaseProjectIntegralAssignRecord.CS_ASSIGN_INTEGRAL;
		__column_names[6] = BaseProjectIntegralAssignRecord.CS_ASSIGN_DATE;
		__column_names[7] = BaseProjectIntegralAssignRecord.CS_PLATE_ID;
		__column_names[8] = BaseProjectIntegralAssignRecord.CS_PLATE_EMPLOYEE_ID;
		__column_names[9] = BaseProjectIntegralAssignRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectIntegralAssignRecord b) {
		clear();
		setProjectIntegralAssignRecordIdClear(b.getProjectIntegralAssignRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectIntegralAssignRecordId() == null;
	}

	@Override
	public BaseProjectIntegralAssignRecord generateBase(){
		BaseProjectIntegralAssignRecord b = new BaseProjectIntegralAssignRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectIntegralAssignRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectIntegralAssignRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBeforeReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAfterReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectIntegralAssignRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectIntegralAssignRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getBeforeReserveIntegral();
		buff[count++] = b.getAfterReserveIntegral();
		buff[count++] = b.getAssignIntegral();
		buff[count++] = generateTimestampFromDate(b.getAssignDate());
		buff[count++] = b.getPlateId();
		buff[count++] = b.getPlateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectIntegralAssignRecord b){
		if(b.getProjectIntegralAssignRecordId() != null) setProjectIntegralAssignRecordIdClear(b.getProjectIntegralAssignRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getBeforeReserveIntegral() != null) setBeforeReserveIntegral(b.getBeforeReserveIntegral());
		if(b.getAfterReserveIntegral() != null) setAfterReserveIntegral(b.getAfterReserveIntegral());
		if(b.getAssignIntegral() != null) setAssignIntegral(b.getAssignIntegral());
		if(b.getAssignDate() != null) setAssignDate(b.getAssignDate());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getPlateEmployeeId() != null) setPlateEmployeeId(b.getPlateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectIntegralAssignRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectIntegralAssignRecord b = new BaseProjectIntegralAssignRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectIntegralAssignRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralAssignRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeforeReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAfterReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectIntegralAssignRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectIntegralAssignRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectIntegralAssignRecordIdClear(java.lang.Integer val) {
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

	public void setBeforeReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getBeforeReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAfterReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAfterReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setAssignIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAssignIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setAssignDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getAssignDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setPlateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getPlateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionProjectIntegralAssignRecordId(String op, java.lang.Integer val) {
		setConditionProjectIntegralAssignRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralAssignRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectIntegralAssignRecordId(boolean val) {
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

	public void setConditionBeforeReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionBeforeReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionBeforeReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBeforeReserveIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAfterReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionAfterReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAfterReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAfterReserveIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAssignIntegral(String op, java.math.BigDecimal val) {
		setConditionAssignIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAssignIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAssignIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAssignDate(String op, java.util.Date val) {
		setConditionAssignDate(op, val, CONDITION_AND);
	}

	public void setConditionAssignDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAssignDate(boolean val) {
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

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val) {
		setConditionPlateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPlateEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

