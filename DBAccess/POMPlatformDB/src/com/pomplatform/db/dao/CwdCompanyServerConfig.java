package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdCompanyServerConfig;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdCompanyServerConfig extends AbstractTable<BaseCwdCompanyServerConfig>
{

	public CwdCompanyServerConfig() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "cwd_company_server_configs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdCompanyServerConfig.CS_COMPANY_SERVER_CONFIG_ID;
		__column_names[1] = BaseCwdCompanyServerConfig.CS_COMPANY_ID;
		__column_names[2] = BaseCwdCompanyServerConfig.CS_COMPANY_NO;
		__column_names[3] = BaseCwdCompanyServerConfig.CS_CWD_SERVER_URL;
		__column_names[4] = BaseCwdCompanyServerConfig.CS_DATA_SERVER_URL;
		__column_names[5] = BaseCwdCompanyServerConfig.CS_OSS_URL;
		__column_names[6] = BaseCwdCompanyServerConfig.CS_OSS_BUCKET;
		__column_names[7] = BaseCwdCompanyServerConfig.CS_STS_URL;
		__column_names[8] = BaseCwdCompanyServerConfig.CS_OSS_ACCESS_KEY_ID;
		__column_names[9] = BaseCwdCompanyServerConfig.CS_OSS_ACCESS_KEY_SECRET;
		__column_names[10] = BaseCwdCompanyServerConfig.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdCompanyServerConfig b) {
		clear();
		setCompanyServerConfigIdClear(b.getCompanyServerConfigId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyServerConfigId() == null;
	}

	@Override
	public BaseCwdCompanyServerConfig generateBase(){
		BaseCwdCompanyServerConfig b = new BaseCwdCompanyServerConfig();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdCompanyServerConfig b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyServerConfigId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCwdServerUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDataServerUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssBucket(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStsUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssAccessKeyId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssAccessKeySecret(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdCompanyServerConfig b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyServerConfigId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getCwdServerUrl();
		buff[count++] = b.getDataServerUrl();
		buff[count++] = b.getOssUrl();
		buff[count++] = b.getOssBucket();
		buff[count++] = b.getStsUrl();
		buff[count++] = b.getOssAccessKeyId();
		buff[count++] = b.getOssAccessKeySecret();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseCwdCompanyServerConfig b){
		if(b.getCompanyServerConfigId() != null) setCompanyServerConfigIdClear(b.getCompanyServerConfigId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getCwdServerUrl() != null) setCwdServerUrl(b.getCwdServerUrl());
		if(b.getDataServerUrl() != null) setDataServerUrl(b.getDataServerUrl());
		if(b.getOssUrl() != null) setOssUrl(b.getOssUrl());
		if(b.getOssBucket() != null) setOssBucket(b.getOssBucket());
		if(b.getStsUrl() != null) setStsUrl(b.getStsUrl());
		if(b.getOssAccessKeyId() != null) setOssAccessKeyId(b.getOssAccessKeyId());
		if(b.getOssAccessKeySecret() != null) setOssAccessKeySecret(b.getOssAccessKeySecret());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseCwdCompanyServerConfig generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdCompanyServerConfig b = new BaseCwdCompanyServerConfig();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdCompanyServerConfig __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyServerConfigId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdServerUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDataServerUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssBucket(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStsUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssAccessKeyId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssAccessKeySecret(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setCompanyServerConfigId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyServerConfigId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyServerConfigIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCwdServerUrl(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCwdServerUrl() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setDataServerUrl(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getDataServerUrl() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setOssUrl(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getOssUrl() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setOssBucket(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getOssBucket() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setStsUrl(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getStsUrl() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setOssAccessKeyId(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getOssAccessKeyId() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setOssAccessKeySecret(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getOssAccessKeySecret() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionCompanyServerConfigId(String op, java.lang.Integer val) {
		setConditionCompanyServerConfigId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyServerConfigId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyServerConfigId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCwdServerUrl(String op, java.lang.String val) {
		setConditionCwdServerUrl(op, val, CONDITION_AND);
	}

	public void setConditionCwdServerUrl(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCwdServerUrl(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDataServerUrl(String op, java.lang.String val) {
		setConditionDataServerUrl(op, val, CONDITION_AND);
	}

	public void setConditionDataServerUrl(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDataServerUrl(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOssUrl(String op, java.lang.String val) {
		setConditionOssUrl(op, val, CONDITION_AND);
	}

	public void setConditionOssUrl(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOssUrl(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOssBucket(String op, java.lang.String val) {
		setConditionOssBucket(op, val, CONDITION_AND);
	}

	public void setConditionOssBucket(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOssBucket(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionStsUrl(String op, java.lang.String val) {
		setConditionStsUrl(op, val, CONDITION_AND);
	}

	public void setConditionStsUrl(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStsUrl(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOssAccessKeyId(String op, java.lang.String val) {
		setConditionOssAccessKeyId(op, val, CONDITION_AND);
	}

	public void setConditionOssAccessKeyId(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOssAccessKeyId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOssAccessKeySecret(String op, java.lang.String val) {
		setConditionOssAccessKeySecret(op, val, CONDITION_AND);
	}

	public void setConditionOssAccessKeySecret(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOssAccessKeySecret(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[10] = val;
	}


}

