package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdUserConfig;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdUserConfig extends AbstractTable<BaseCwdUserConfig>
{

	public CwdUserConfig() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "cwd_user_configs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdUserConfig.CS_USER_CONFIG_ID;
		__column_names[1] = BaseCwdUserConfig.CS_EMPLOYEE_ID;
		__column_names[2] = BaseCwdUserConfig.CS_MAC_ADDRESS;
		__column_names[3] = BaseCwdUserConfig.CS_IP_ADDRESS;
		__column_names[4] = BaseCwdUserConfig.CS_NAME_OF_HOST;
		__column_names[5] = BaseCwdUserConfig.CS_OS_TYPE;
		__column_names[6] = BaseCwdUserConfig.CS_WORK_DIR;
		__column_names[7] = BaseCwdUserConfig.CS_LABEL;
		__column_names[8] = BaseCwdUserConfig.CS_IS_DEFAULT;
		__column_names[9] = BaseCwdUserConfig.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdUserConfig b) {
		clear();
		setUserConfigIdClear(b.getUserConfigId());
	}

	public boolean isPrimaryKeyNull() {
		return getUserConfigId() == null;
	}

	@Override
	public BaseCwdUserConfig generateBase(){
		BaseCwdUserConfig b = new BaseCwdUserConfig();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdUserConfig b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setUserConfigId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMacAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIpAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNameOfHost(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOsType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkDir(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLabel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsDefault(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdUserConfig b, Object[] buff){
		int count = 0;
		buff[count++] = b.getUserConfigId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getMacAddress();
		buff[count++] = b.getIpAddress();
		buff[count++] = b.getNameOfHost();
		buff[count++] = b.getOsType();
		buff[count++] = b.getWorkDir();
		buff[count++] = b.getLabel();
		buff[count++] = b.getIsDefault();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdUserConfig b){
		if(b.getUserConfigId() != null) setUserConfigIdClear(b.getUserConfigId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getMacAddress() != null) setMacAddress(b.getMacAddress());
		if(b.getIpAddress() != null) setIpAddress(b.getIpAddress());
		if(b.getNameOfHost() != null) setNameOfHost(b.getNameOfHost());
		if(b.getOsType() != null) setOsType(b.getOsType());
		if(b.getWorkDir() != null) setWorkDir(b.getWorkDir());
		if(b.getLabel() != null) setLabel(b.getLabel());
		if(b.getIsDefault() != null) setIsDefault(b.getIsDefault());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdUserConfig generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdUserConfig b = new BaseCwdUserConfig();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdUserConfig __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserConfigId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMacAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIpAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNameOfHost(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOsType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkDir(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLabel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsDefault(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setUserConfigId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getUserConfigId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setUserConfigIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
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

	public void setNameOfHost(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getNameOfHost() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setOsType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOsType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setWorkDir(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getWorkDir() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setLabel(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getLabel() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIsDefault(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsDefault() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setConditionUserConfigId(String op, java.lang.Integer val) {
		setConditionUserConfigId(op, val, CONDITION_AND);
	}

	public void setConditionUserConfigId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectUserConfigId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
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

	public void setConditionNameOfHost(String op, java.lang.String val) {
		setConditionNameOfHost(op, val, CONDITION_AND);
	}

	public void setConditionNameOfHost(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectNameOfHost(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOsType(String op, java.lang.Integer val) {
		setConditionOsType(op, val, CONDITION_AND);
	}

	public void setConditionOsType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOsType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionWorkDir(String op, java.lang.String val) {
		setConditionWorkDir(op, val, CONDITION_AND);
	}

	public void setConditionWorkDir(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectWorkDir(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionLabel(String op, java.lang.String val) {
		setConditionLabel(op, val, CONDITION_AND);
	}

	public void setConditionLabel(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectLabel(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsDefault(String op, java.lang.Boolean val) {
		setConditionIsDefault(op, val, CONDITION_AND);
	}

	public void setConditionIsDefault(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsDefault(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}


}

