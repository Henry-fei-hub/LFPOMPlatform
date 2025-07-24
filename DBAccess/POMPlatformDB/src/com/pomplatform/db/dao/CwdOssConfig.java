package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdOssConfig;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdOssConfig extends AbstractTable<BaseCwdOssConfig>
{

	public CwdOssConfig() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cwd_oss_config";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdOssConfig.CS_OSS_CONFIG_ID;
		__column_names[1] = BaseCwdOssConfig.CS_OSS_ADDRESS;
		__column_names[2] = BaseCwdOssConfig.CS_OSS_BUCKET;
		__column_names[3] = BaseCwdOssConfig.CS_OSS_ACCESS_KEY_ID;
		__column_names[4] = BaseCwdOssConfig.CS_OSS_ACCESS_KEY_SECRET;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdOssConfig b) {
		clear();
		setOssConfigIdClear(b.getOssConfigId());
	}

	public boolean isPrimaryKeyNull() {
		return getOssConfigId() == null;
	}

	@Override
	public BaseCwdOssConfig generateBase(){
		BaseCwdOssConfig b = new BaseCwdOssConfig();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdOssConfig b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOssConfigId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOssAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssBucket(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssAccessKeyId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssAccessKeySecret(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdOssConfig b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOssConfigId();
		buff[count++] = b.getOssAddress();
		buff[count++] = b.getOssBucket();
		buff[count++] = b.getOssAccessKeyId();
		buff[count++] = b.getOssAccessKeySecret();
	}

	@Override
	public void setDataFromBase(BaseCwdOssConfig b){
		if(b.getOssConfigId() != null) setOssConfigIdClear(b.getOssConfigId());
		if(b.getOssAddress() != null) setOssAddress(b.getOssAddress());
		if(b.getOssBucket() != null) setOssBucket(b.getOssBucket());
		if(b.getOssAccessKeyId() != null) setOssAccessKeyId(b.getOssAccessKeyId());
		if(b.getOssAccessKeySecret() != null) setOssAccessKeySecret(b.getOssAccessKeySecret());
	}

	@Override
	public BaseCwdOssConfig generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdOssConfig b = new BaseCwdOssConfig();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdOssConfig __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssConfigId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssBucket(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssAccessKeyId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssAccessKeySecret(GenericBase.__getString(val));
	}

	public void setOssConfigId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOssConfigId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOssConfigIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOssAddress(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getOssAddress() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setOssBucket(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getOssBucket() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setOssAccessKeyId(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getOssAccessKeyId() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOssAccessKeySecret(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getOssAccessKeySecret() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionOssConfigId(String op, java.lang.Integer val) {
		setConditionOssConfigId(op, val, CONDITION_AND);
	}

	public void setConditionOssConfigId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOssConfigId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOssAddress(String op, java.lang.String val) {
		setConditionOssAddress(op, val, CONDITION_AND);
	}

	public void setConditionOssAddress(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOssAddress(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOssBucket(String op, java.lang.String val) {
		setConditionOssBucket(op, val, CONDITION_AND);
	}

	public void setConditionOssBucket(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOssBucket(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOssAccessKeyId(String op, java.lang.String val) {
		setConditionOssAccessKeyId(op, val, CONDITION_AND);
	}

	public void setConditionOssAccessKeyId(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOssAccessKeyId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOssAccessKeySecret(String op, java.lang.String val) {
		setConditionOssAccessKeySecret(op, val, CONDITION_AND);
	}

	public void setConditionOssAccessKeySecret(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOssAccessKeySecret(boolean val) {
		__select_flags[4] = val;
	}


}

