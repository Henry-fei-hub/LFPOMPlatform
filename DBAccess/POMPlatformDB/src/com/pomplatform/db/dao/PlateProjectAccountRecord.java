package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateProjectAccountRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateProjectAccountRecord extends AbstractTable<BasePlateProjectAccountRecord>
{

	public PlateProjectAccountRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "plate_project_account_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateProjectAccountRecord.CS_PLATE_PROJECT_ACCOUNT_RECORD_ID;
		__column_names[1] = BasePlateProjectAccountRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateProjectAccountRecord.CS_ACCOUNT_INTEGRAL;
		__column_names[3] = BasePlateProjectAccountRecord.CS_PROJECT_ID;
		__column_names[4] = BasePlateProjectAccountRecord.CS_STAGE_ID;
		__column_names[5] = BasePlateProjectAccountRecord.CS_ACCOUNT_DATE;
		__column_names[6] = BasePlateProjectAccountRecord.CS_REMARK;
		__column_names[7] = BasePlateProjectAccountRecord.CS_SETTLEMENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateProjectAccountRecord b) {
		clear();
		setPlateProjectAccountRecordIdClear(b.getPlateProjectAccountRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateProjectAccountRecordId() == null;
	}

	@Override
	public BasePlateProjectAccountRecord generateBase(){
		BasePlateProjectAccountRecord b = new BasePlateProjectAccountRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateProjectAccountRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateProjectAccountRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSettlementId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateProjectAccountRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateProjectAccountRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getAccountIntegral();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = generateTimestampFromDate(b.getAccountDate());
		buff[count++] = b.getRemark();
		buff[count++] = b.getSettlementId();
	}

	@Override
	public void setDataFromBase(BasePlateProjectAccountRecord b){
		if(b.getPlateProjectAccountRecordId() != null) setPlateProjectAccountRecordIdClear(b.getPlateProjectAccountRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getAccountIntegral() != null) setAccountIntegral(b.getAccountIntegral());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getAccountDate() != null) setAccountDate(b.getAccountDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getSettlementId() != null) setSettlementId(b.getSettlementId());
	}

	@Override
	public BasePlateProjectAccountRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateProjectAccountRecord b = new BasePlateProjectAccountRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateProjectAccountRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateProjectAccountRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementId(GenericBase.__getInt(val));
	}

	public void setPlateProjectAccountRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateProjectAccountRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateProjectAccountRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAccountIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getAccountIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setAccountDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getAccountDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setSettlementId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSettlementId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionPlateProjectAccountRecordId(String op, java.lang.Integer val) {
		setConditionPlateProjectAccountRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateProjectAccountRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateProjectAccountRecordId(boolean val) {
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

	public void setConditionAccountIntegral(String op, java.math.BigDecimal val) {
		setConditionAccountIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAccountIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAccountIntegral(boolean val) {
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

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAccountDate(String op, java.util.Date val) {
		setConditionAccountDate(op, val, CONDITION_AND);
	}

	public void setConditionAccountDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAccountDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSettlementId(String op, java.lang.Integer val) {
		setConditionSettlementId(op, val, CONDITION_AND);
	}

	public void setConditionSettlementId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSettlementId(boolean val) {
		__select_flags[7] = val;
	}


}

