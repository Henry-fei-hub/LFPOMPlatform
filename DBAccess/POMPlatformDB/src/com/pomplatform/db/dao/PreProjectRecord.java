package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePreProjectRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PreProjectRecord extends AbstractTable<BasePreProjectRecord>
{

	public PreProjectRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "pre_project_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePreProjectRecord.CS_PRE_PROJECT_RECORD_ID;
		__column_names[1] = BasePreProjectRecord.CS_RELEVANT_EMPLOYEES;
		__column_names[2] = BasePreProjectRecord.CS_TRACK_DATE;
		__column_names[3] = BasePreProjectRecord.CS_INFORMATION_TYPE;
		__column_names[4] = BasePreProjectRecord.CS_REMARK;
		__column_names[5] = BasePreProjectRecord.CS_ATTACHMENT_NAME;
		__column_names[6] = BasePreProjectRecord.CS_REGISTER_EMPLOYEE;
		__column_names[7] = BasePreProjectRecord.CS_REGISTER_DATE;
		__column_names[8] = BasePreProjectRecord.CS_TRACK_CODE;
		__column_names[9] = BasePreProjectRecord.CS_MAIN_PROJECT_ID;
		__column_names[10] = BasePreProjectRecord.CS_FILE_NAME;
		__column_names[11] = BasePreProjectRecord.CS_RELEVANT_EMPLOYEES_DISPLAY_VALUE;
		__column_names[12] = BasePreProjectRecord.CS_PRE_PROJECT_ID;
		__column_names[13] = BasePreProjectRecord.CS_WIN_RATE;
		__column_names[14] = BasePreProjectRecord.CS_CONTRACT_SIGN_STATUS;
		__column_names[15] = BasePreProjectRecord.CS_CONTRACT_AMOUNT;
		__column_names[16] = BasePreProjectRecord.CS_DESIGN_PRICE;
		__column_names[17] = BasePreProjectRecord.CS_ATTACHMENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePreProjectRecord b) {
		clear();
		setPreProjectRecordIdClear(b.getPreProjectRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPreProjectRecordId() == null;
	}

	@Override
	public BasePreProjectRecord generateBase(){
		BasePreProjectRecord b = new BasePreProjectRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePreProjectRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPreProjectRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrackDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInformationType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRegisterEmployee(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTrackCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelevantEmployeesDisplayValue(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWinRate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractSignStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignPrice(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePreProjectRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPreProjectRecordId();
		buff[count++] = b.getRelevantEmployees();
		buff[count++] = generateTimestampFromDate(b.getTrackDate());
		buff[count++] = b.getInformationType();
		buff[count++] = b.getRemark();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getRegisterEmployee();
		buff[count++] = generateTimestampFromDate(b.getRegisterDate());
		buff[count++] = b.getTrackCode();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getRelevantEmployeesDisplayValue();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getWinRate();
		buff[count++] = b.getContractSignStatus();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getDesignPrice();
		buff[count++] = b.getAttachmentId();
	}

	@Override
	public void setDataFromBase(BasePreProjectRecord b){
		if(b.getPreProjectRecordId() != null) setPreProjectRecordIdClear(b.getPreProjectRecordId());
		if(b.getRelevantEmployees() != null) setRelevantEmployees(b.getRelevantEmployees());
		if(b.getTrackDate() != null) setTrackDate(b.getTrackDate());
		if(b.getInformationType() != null) setInformationType(b.getInformationType());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getRegisterEmployee() != null) setRegisterEmployee(b.getRegisterEmployee());
		if(b.getRegisterDate() != null) setRegisterDate(b.getRegisterDate());
		if(b.getTrackCode() != null) setTrackCode(b.getTrackCode());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getRelevantEmployeesDisplayValue() != null) setRelevantEmployeesDisplayValue(b.getRelevantEmployeesDisplayValue());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getWinRate() != null) setWinRate(b.getWinRate());
		if(b.getContractSignStatus() != null) setContractSignStatus(b.getContractSignStatus());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getDesignPrice() != null) setDesignPrice(b.getDesignPrice());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
	}

	@Override
	public BasePreProjectRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePreProjectRecord b = new BasePreProjectRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePreProjectRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrackDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInformationType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegisterEmployee(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrackCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelevantEmployeesDisplayValue(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWinRate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSignStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignPrice(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
	}

	public void setPreProjectRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPreProjectRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPreProjectRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setRelevantEmployees(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getRelevantEmployees() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setTrackDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getTrackDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setInformationType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getInformationType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setRegisterEmployee(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getRegisterEmployee() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRegisterDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getRegisterDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setTrackCode(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getTrackCode() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setFileName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getFileName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setRelevantEmployeesDisplayValue(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRelevantEmployeesDisplayValue() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setWinRate(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getWinRate() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setContractSignStatus(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getContractSignStatus() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setDesignPrice(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getDesignPrice() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setConditionPreProjectRecordId(String op, java.lang.Integer val) {
		setConditionPreProjectRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPreProjectRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionRelevantEmployees(String op, java.lang.String val) {
		setConditionRelevantEmployees(op, val, CONDITION_AND);
	}

	public void setConditionRelevantEmployees(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectRelevantEmployees(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTrackDate(String op, java.util.Date val) {
		setConditionTrackDate(op, val, CONDITION_AND);
	}

	public void setConditionTrackDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTrackDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionInformationType(String op, java.lang.Integer val) {
		setConditionInformationType(op, val, CONDITION_AND);
	}

	public void setConditionInformationType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectInformationType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRegisterEmployee(String op, java.lang.Integer val) {
		setConditionRegisterEmployee(op, val, CONDITION_AND);
	}

	public void setConditionRegisterEmployee(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRegisterEmployee(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRegisterDate(String op, java.util.Date val) {
		setConditionRegisterDate(op, val, CONDITION_AND);
	}

	public void setConditionRegisterDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRegisterDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTrackCode(String op, java.lang.String val) {
		setConditionTrackCode(op, val, CONDITION_AND);
	}

	public void setConditionTrackCode(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTrackCode(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionFileName(String op, java.lang.String val) {
		setConditionFileName(op, val, CONDITION_AND);
	}

	public void setConditionFileName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectFileName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRelevantEmployeesDisplayValue(String op, java.lang.String val) {
		setConditionRelevantEmployeesDisplayValue(op, val, CONDITION_AND);
	}

	public void setConditionRelevantEmployeesDisplayValue(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRelevantEmployeesDisplayValue(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val) {
		setConditionPreProjectId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectPreProjectId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionWinRate(String op, java.lang.String val) {
		setConditionWinRate(op, val, CONDITION_AND);
	}

	public void setConditionWinRate(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectWinRate(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionContractSignStatus(String op, java.lang.Integer val) {
		setConditionContractSignStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractSignStatus(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectContractSignStatus(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionDesignPrice(String op, java.lang.String val) {
		setConditionDesignPrice(op, val, CONDITION_AND);
	}

	public void setConditionDesignPrice(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectDesignPrice(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[17] = val;
	}


}

