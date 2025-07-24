package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateProjectIntegralRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateProjectIntegralRecord extends AbstractTable<BasePlateProjectIntegralRecord>
{

	public PlateProjectIntegralRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "plate_project_integral_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateProjectIntegralRecord.CS_PLATE_PROJECT_INTEGRAL_RECORD_ID;
		__column_names[1] = BasePlateProjectIntegralRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateProjectIntegralRecord.CS_SEND_INTEGRAL;
		__column_names[3] = BasePlateProjectIntegralRecord.CS_PROJECT_ID;
		__column_names[4] = BasePlateProjectIntegralRecord.CS_SEND_DATE;
		__column_names[5] = BasePlateProjectIntegralRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateProjectIntegralRecord b) {
		clear();
		setPlateProjectIntegralRecordIdClear(b.getPlateProjectIntegralRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateProjectIntegralRecordId() == null;
	}

	@Override
	public BasePlateProjectIntegralRecord generateBase(){
		BasePlateProjectIntegralRecord b = new BasePlateProjectIntegralRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateProjectIntegralRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateProjectIntegralRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateProjectIntegralRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateProjectIntegralRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getSendIntegral();
		buff[count++] = b.getProjectId();
		buff[count++] = generateTimestampFromDate(b.getSendDate());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateProjectIntegralRecord b){
		if(b.getPlateProjectIntegralRecordId() != null) setPlateProjectIntegralRecordIdClear(b.getPlateProjectIntegralRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getSendIntegral() != null) setSendIntegral(b.getSendIntegral());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getSendDate() != null) setSendDate(b.getSendDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateProjectIntegralRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateProjectIntegralRecord b = new BasePlateProjectIntegralRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateProjectIntegralRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateProjectIntegralRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateProjectIntegralRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateProjectIntegralRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateProjectIntegralRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSendIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getSendIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSendDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getSendDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionPlateProjectIntegralRecordId(String op, java.lang.Integer val) {
		setConditionPlateProjectIntegralRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateProjectIntegralRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateProjectIntegralRecordId(boolean val) {
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

	public void setConditionSendIntegral(String op, java.math.BigDecimal val) {
		setConditionSendIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSendIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSendIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSendDate(String op, java.util.Date val) {
		setConditionSendDate(op, val, CONDITION_AND);
	}

	public void setConditionSendDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}


}

