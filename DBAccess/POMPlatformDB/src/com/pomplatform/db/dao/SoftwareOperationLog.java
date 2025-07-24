package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSoftwareOperationLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SoftwareOperationLog extends AbstractTable<BaseSoftwareOperationLog>
{

	public SoftwareOperationLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "software_operation_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSoftwareOperationLog.CS_SOFTWARE_OPERATION_LOG_ID;
		__column_names[1] = BaseSoftwareOperationLog.CS_OPERATION_TYPE;
		__column_names[2] = BaseSoftwareOperationLog.CS_MAC_ADDRESS;
		__column_names[3] = BaseSoftwareOperationLog.CS_IP_ADDRESS;
		__column_names[4] = BaseSoftwareOperationLog.CS_MACHINE_NAME;
		__column_names[5] = BaseSoftwareOperationLog.CS_SOFTWARE_TYPE;
		__column_names[6] = BaseSoftwareOperationLog.CS_LOCAL_OPERATION_TIME;
		__column_names[7] = BaseSoftwareOperationLog.CS_LOCAL_REQUEST_TIME;
		__column_names[8] = BaseSoftwareOperationLog.CS_CREATE_TIME;
		__column_names[9] = BaseSoftwareOperationLog.CS_CURRENT_VERSION_NO;
		__column_names[10] = BaseSoftwareOperationLog.CS_OPERATOR;
		__column_names[11] = BaseSoftwareOperationLog.CS_ORI_VERSION_NO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSoftwareOperationLog b) {
		clear();
		setSoftwareOperationLogIdClear(b.getSoftwareOperationLogId());
	}

	public boolean isPrimaryKeyNull() {
		return getSoftwareOperationLogId() == null;
	}

	@Override
	public BaseSoftwareOperationLog generateBase(){
		BaseSoftwareOperationLog b = new BaseSoftwareOperationLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSoftwareOperationLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSoftwareOperationLogId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperationType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMacAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIpAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMachineName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSoftwareType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLocalOperationTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLocalRequestTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCurrentVersionNo(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriVersionNo(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseSoftwareOperationLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSoftwareOperationLogId();
		buff[count++] = b.getOperationType();
		buff[count++] = b.getMacAddress();
		buff[count++] = b.getIpAddress();
		buff[count++] = b.getMachineName();
		buff[count++] = b.getSoftwareType();
		buff[count++] = generateTimestampFromDate(b.getLocalOperationTime());
		buff[count++] = generateTimestampFromDate(b.getLocalRequestTime());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getCurrentVersionNo();
		buff[count++] = b.getOperator();
		buff[count++] = b.getOriVersionNo();
	}

	@Override
	public void setDataFromBase(BaseSoftwareOperationLog b){
		if(b.getSoftwareOperationLogId() != null) setSoftwareOperationLogIdClear(b.getSoftwareOperationLogId());
		if(b.getOperationType() != null) setOperationType(b.getOperationType());
		if(b.getMacAddress() != null) setMacAddress(b.getMacAddress());
		if(b.getIpAddress() != null) setIpAddress(b.getIpAddress());
		if(b.getMachineName() != null) setMachineName(b.getMachineName());
		if(b.getSoftwareType() != null) setSoftwareType(b.getSoftwareType());
		if(b.getLocalOperationTime() != null) setLocalOperationTime(b.getLocalOperationTime());
		if(b.getLocalRequestTime() != null) setLocalRequestTime(b.getLocalRequestTime());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCurrentVersionNo() != null) setCurrentVersionNo(b.getCurrentVersionNo());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getOriVersionNo() != null) setOriVersionNo(b.getOriVersionNo());
	}

	@Override
	public BaseSoftwareOperationLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSoftwareOperationLog b = new BaseSoftwareOperationLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSoftwareOperationLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSoftwareOperationLogId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMacAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIpAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMachineName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSoftwareType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLocalOperationTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLocalRequestTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentVersionNo(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriVersionNo(GenericBase.__getDecimal(val));
	}

	public void setSoftwareOperationLogId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSoftwareOperationLogId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSoftwareOperationLogIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOperationType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getOperationType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMacAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getMacAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIpAddress(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getIpAddress() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setMachineName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getMachineName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setSoftwareType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getSoftwareType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setLocalOperationTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getLocalOperationTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setLocalRequestTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getLocalRequestTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setCurrentVersionNo(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getCurrentVersionNo() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOriVersionNo(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getOriVersionNo() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setConditionSoftwareOperationLogId(String op, java.lang.Integer val) {
		setConditionSoftwareOperationLogId(op, val, CONDITION_AND);
	}

	public void setConditionSoftwareOperationLogId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSoftwareOperationLogId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOperationType(String op, java.lang.Integer val) {
		setConditionOperationType(op, val, CONDITION_AND);
	}

	public void setConditionOperationType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOperationType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMacAddress(String op, java.lang.String val) {
		setConditionMacAddress(op, val, CONDITION_AND);
	}

	public void setConditionMacAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMacAddress(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIpAddress(String op, java.lang.String val) {
		setConditionIpAddress(op, val, CONDITION_AND);
	}

	public void setConditionIpAddress(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIpAddress(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMachineName(String op, java.lang.String val) {
		setConditionMachineName(op, val, CONDITION_AND);
	}

	public void setConditionMachineName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMachineName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSoftwareType(String op, java.lang.Integer val) {
		setConditionSoftwareType(op, val, CONDITION_AND);
	}

	public void setConditionSoftwareType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSoftwareType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionLocalOperationTime(String op, java.util.Date val) {
		setConditionLocalOperationTime(op, val, CONDITION_AND);
	}

	public void setConditionLocalOperationTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectLocalOperationTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionLocalRequestTime(String op, java.util.Date val) {
		setConditionLocalRequestTime(op, val, CONDITION_AND);
	}

	public void setConditionLocalRequestTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectLocalRequestTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCurrentVersionNo(String op, java.math.BigDecimal val) {
		setConditionCurrentVersionNo(op, val, CONDITION_AND);
	}

	public void setConditionCurrentVersionNo(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCurrentVersionNo(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOriVersionNo(String op, java.math.BigDecimal val) {
		setConditionOriVersionNo(op, val, CONDITION_AND);
	}

	public void setConditionOriVersionNo(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOriVersionNo(boolean val) {
		__select_flags[11] = val;
	}


}

