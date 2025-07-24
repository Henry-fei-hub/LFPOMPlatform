package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseStaticIpAddress;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class StaticIpAddress extends AbstractTable<BaseStaticIpAddress>
{

	public StaticIpAddress() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "static_ip_addresses";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStaticIpAddress.CS_START_ADDRESS;
		__column_names[1] = BaseStaticIpAddress.CS_END_ADDRESS;
		__column_names[2] = BaseStaticIpAddress.CS_START_IP;
		__column_names[3] = BaseStaticIpAddress.CS_END_IP;
		__column_names[4] = BaseStaticIpAddress.CS_COUNTRY_ID;
		__column_names[5] = BaseStaticIpAddress.CS_PROVINCE_ID;
		__column_names[6] = BaseStaticIpAddress.CS_CITY_ID;
		__column_names[7] = BaseStaticIpAddress.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseStaticIpAddress b) {
		clear();
		setStartAddressClear(b.getStartAddress());
	}

	public boolean isPrimaryKeyNull() {
		return getStartAddress() == null;
	}

	@Override
	public BaseStaticIpAddress generateBase(){
		BaseStaticIpAddress b = new BaseStaticIpAddress();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStaticIpAddress b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStartAddress(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setEndAddress(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setStartIp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEndIp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCountryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvinceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCityId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseStaticIpAddress b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStartAddress();
		buff[count++] = b.getEndAddress();
		buff[count++] = b.getStartIp();
		buff[count++] = b.getEndIp();
		buff[count++] = b.getCountryId();
		buff[count++] = b.getProvinceId();
		buff[count++] = b.getCityId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseStaticIpAddress b){
		if(b.getStartAddress() != null) setStartAddressClear(b.getStartAddress());
		if(b.getEndAddress() != null) setEndAddress(b.getEndAddress());
		if(b.getStartIp() != null) setStartIp(b.getStartIp());
		if(b.getEndIp() != null) setEndIp(b.getEndIp());
		if(b.getCountryId() != null) setCountryId(b.getCountryId());
		if(b.getProvinceId() != null) setProvinceId(b.getProvinceId());
		if(b.getCityId() != null) setCityId(b.getCityId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseStaticIpAddress generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStaticIpAddress b = new BaseStaticIpAddress();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStaticIpAddress __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartAddress(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndAddress(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartIp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndIp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setStartAddress(java.lang.Long val) {
		setCurrentData(0, val);
	}

	public java.lang.Long getStartAddress() {
		return GenericBase.__getLong(__current_data[0]);
	}

	public void setStartAddressClear(java.lang.Long val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEndAddress(java.lang.Long val) {
		setCurrentData(1, val);
	}

	public java.lang.Long getEndAddress() {
		return GenericBase.__getLong(__current_data[1]);
	}

	public void setStartIp(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getStartIp() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEndIp(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEndIp() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCountryId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCountryId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProvinceId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProvinceId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCityId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCityId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionStartAddress(String op, java.lang.Long val) {
		setConditionStartAddress(op, val, CONDITION_AND);
	}

	public void setConditionStartAddress(String op, java.lang.Long val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStartAddress(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEndAddress(String op, java.lang.Long val) {
		setConditionEndAddress(op, val, CONDITION_AND);
	}

	public void setConditionEndAddress(String op, java.lang.Long val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEndAddress(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStartIp(String op, java.lang.String val) {
		setConditionStartIp(op, val, CONDITION_AND);
	}

	public void setConditionStartIp(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStartIp(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEndIp(String op, java.lang.String val) {
		setConditionEndIp(op, val, CONDITION_AND);
	}

	public void setConditionEndIp(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEndIp(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCountryId(String op, java.lang.Integer val) {
		setConditionCountryId(op, val, CONDITION_AND);
	}

	public void setConditionCountryId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCountryId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProvinceId(String op, java.lang.Integer val) {
		setConditionProvinceId(op, val, CONDITION_AND);
	}

	public void setConditionProvinceId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProvinceId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCityId(String op, java.lang.Integer val) {
		setConditionCityId(op, val, CONDITION_AND);
	}

	public void setConditionCityId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCityId(boolean val) {
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


}

