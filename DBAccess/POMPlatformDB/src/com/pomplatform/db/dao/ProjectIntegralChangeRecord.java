package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectIntegralChangeRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectIntegralChangeRecord extends AbstractTable<BaseProjectIntegralChangeRecord>
{

	public ProjectIntegralChangeRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "project_integral_change_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectIntegralChangeRecord.CS_PROJECT_INTEGRAL_CHANGE_RECORD_ID;
		__column_names[1] = BaseProjectIntegralChangeRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectIntegralChangeRecord.CS_BEFORE_PROJECT_INTEGRAL;
		__column_names[3] = BaseProjectIntegralChangeRecord.CS_AFTER_PROJECT_INTEGRAL;
		__column_names[4] = BaseProjectIntegralChangeRecord.CS_BEFORE_RESERVE_INTEGRAL;
		__column_names[5] = BaseProjectIntegralChangeRecord.CS_AFTER_RESERVE_INTEGRAL;
		__column_names[6] = BaseProjectIntegralChangeRecord.CS_TRANSFER_INTEGRAL;
		__column_names[7] = BaseProjectIntegralChangeRecord.CS_TRANSFER_DATE;
		__column_names[8] = BaseProjectIntegralChangeRecord.CS_PLATE_ID;
		__column_names[9] = BaseProjectIntegralChangeRecord.CS_PLATE_EMPLOYEE_ID;
		__column_names[10] = BaseProjectIntegralChangeRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectIntegralChangeRecord b) {
		clear();
		setProjectIntegralChangeRecordIdClear(b.getProjectIntegralChangeRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectIntegralChangeRecordId() == null;
	}

	@Override
	public BaseProjectIntegralChangeRecord generateBase(){
		BaseProjectIntegralChangeRecord b = new BaseProjectIntegralChangeRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectIntegralChangeRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectIntegralChangeRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBeforeProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAfterProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBeforeReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAfterReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTransferIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTransferDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectIntegralChangeRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectIntegralChangeRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getBeforeProjectIntegral();
		buff[count++] = b.getAfterProjectIntegral();
		buff[count++] = b.getBeforeReserveIntegral();
		buff[count++] = b.getAfterReserveIntegral();
		buff[count++] = b.getTransferIntegral();
		buff[count++] = generateTimestampFromDate(b.getTransferDate());
		buff[count++] = b.getPlateId();
		buff[count++] = b.getPlateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectIntegralChangeRecord b){
		if(b.getProjectIntegralChangeRecordId() != null) setProjectIntegralChangeRecordIdClear(b.getProjectIntegralChangeRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getBeforeProjectIntegral() != null) setBeforeProjectIntegral(b.getBeforeProjectIntegral());
		if(b.getAfterProjectIntegral() != null) setAfterProjectIntegral(b.getAfterProjectIntegral());
		if(b.getBeforeReserveIntegral() != null) setBeforeReserveIntegral(b.getBeforeReserveIntegral());
		if(b.getAfterReserveIntegral() != null) setAfterReserveIntegral(b.getAfterReserveIntegral());
		if(b.getTransferIntegral() != null) setTransferIntegral(b.getTransferIntegral());
		if(b.getTransferDate() != null) setTransferDate(b.getTransferDate());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getPlateEmployeeId() != null) setPlateEmployeeId(b.getPlateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectIntegralChangeRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectIntegralChangeRecord b = new BaseProjectIntegralChangeRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectIntegralChangeRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralChangeRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeforeProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAfterProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeforeReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAfterReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectIntegralChangeRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectIntegralChangeRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectIntegralChangeRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBeforeProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getBeforeProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setAfterProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAfterProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setBeforeReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getBeforeReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setAfterReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAfterReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setTransferIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTransferIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setTransferDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getTransferDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setPlateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getPlateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setConditionProjectIntegralChangeRecordId(String op, java.lang.Integer val) {
		setConditionProjectIntegralChangeRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralChangeRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectIntegralChangeRecordId(boolean val) {
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

	public void setConditionBeforeProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionBeforeProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionBeforeProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBeforeProjectIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAfterProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionAfterProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAfterProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAfterProjectIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBeforeReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionBeforeReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionBeforeReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBeforeReserveIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAfterReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionAfterReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAfterReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAfterReserveIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTransferIntegral(String op, java.math.BigDecimal val) {
		setConditionTransferIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTransferIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTransferIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTransferDate(String op, java.util.Date val) {
		setConditionTransferDate(op, val, CONDITION_AND);
	}

	public void setConditionTransferDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTransferDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val) {
		setConditionPlateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPlateEmployeeId(boolean val) {
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


}

