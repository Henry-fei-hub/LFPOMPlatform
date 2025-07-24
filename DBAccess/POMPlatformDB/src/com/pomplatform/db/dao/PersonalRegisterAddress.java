package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePersonalRegisterAddress;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PersonalRegisterAddress extends AbstractTable<BasePersonalRegisterAddress>
{

	public PersonalRegisterAddress() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "personal_register_addresses";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePersonalRegisterAddress.CS_PERSONAL_REGISTER_ADDRESS_ID;
		__column_names[1] = BasePersonalRegisterAddress.CS_EMPLOYEE_ID;
		__column_names[2] = BasePersonalRegisterAddress.CS_IP_ADDRESS;
		__column_names[3] = BasePersonalRegisterAddress.CS_MAC_ADDRESS;
		__column_names[4] = BasePersonalRegisterAddress.CS_WORKPLACE_ID;
		__column_names[5] = BasePersonalRegisterAddress.CS_REGISTER_TIME;
		__column_names[6] = BasePersonalRegisterAddress.CS_ACTIVE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePersonalRegisterAddress b) {
		clear();
		setPersonalRegisterAddressIdClear(b.getPersonalRegisterAddressId());
	}

	public boolean isPrimaryKeyNull() {
		return getPersonalRegisterAddressId() == null;
	}

	@Override
	public BasePersonalRegisterAddress generateBase(){
		BasePersonalRegisterAddress b = new BasePersonalRegisterAddress();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePersonalRegisterAddress b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPersonalRegisterAddressId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIpAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMacAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setActive(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BasePersonalRegisterAddress b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPersonalRegisterAddressId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getIpAddress();
		buff[count++] = b.getMacAddress();
		buff[count++] = b.getWorkplaceId();
		buff[count++] = generateTimestampFromDate(b.getRegisterTime());
		buff[count++] = b.getActive();
	}

	@Override
	public void setDataFromBase(BasePersonalRegisterAddress b){
		if(b.getPersonalRegisterAddressId() != null) setPersonalRegisterAddressIdClear(b.getPersonalRegisterAddressId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getIpAddress() != null) setIpAddress(b.getIpAddress());
		if(b.getMacAddress() != null) setMacAddress(b.getMacAddress());
		if(b.getWorkplaceId() != null) setWorkplaceId(b.getWorkplaceId());
		if(b.getRegisterTime() != null) setRegisterTime(b.getRegisterTime());
		if(b.getActive() != null) setActive(b.getActive());
	}

	@Override
	public BasePersonalRegisterAddress generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePersonalRegisterAddress b = new BasePersonalRegisterAddress();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePersonalRegisterAddress __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalRegisterAddressId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIpAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMacAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegisterTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActive(GenericBase.__getBoolean(val));
	}

	public void setPersonalRegisterAddressId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPersonalRegisterAddressId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPersonalRegisterAddressIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setIpAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getIpAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setMacAddress(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getMacAddress() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setWorkplaceId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getWorkplaceId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRegisterTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getRegisterTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setActive(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getActive() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setConditionPersonalRegisterAddressId(String op, java.lang.Integer val) {
		setConditionPersonalRegisterAddressId(op, val, CONDITION_AND);
	}

	public void setConditionPersonalRegisterAddressId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPersonalRegisterAddressId(boolean val) {
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

	public void setConditionIpAddress(String op, java.lang.String val) {
		setConditionIpAddress(op, val, CONDITION_AND);
	}

	public void setConditionIpAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectIpAddress(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMacAddress(String op, java.lang.String val) {
		setConditionMacAddress(op, val, CONDITION_AND);
	}

	public void setConditionMacAddress(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMacAddress(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val) {
		setConditionWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectWorkplaceId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRegisterTime(String op, java.util.Date val) {
		setConditionRegisterTime(op, val, CONDITION_AND);
	}

	public void setConditionRegisterTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRegisterTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionActive(String op, java.lang.Boolean val) {
		setConditionActive(op, val, CONDITION_AND);
	}

	public void setConditionActive(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectActive(boolean val) {
		__select_flags[6] = val;
	}


}

