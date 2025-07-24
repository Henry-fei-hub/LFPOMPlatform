package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseStorage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Storage extends AbstractTable<BaseStorage>
{

	public Storage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "storages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStorage.CS_STORAGE_ID;
		__column_names[1] = BaseStorage.CS_STORAGE_CODE;
		__column_names[2] = BaseStorage.CS_STORAGE_NAME;
		__column_names[3] = BaseStorage.CS_STORAGE_TYPE;
		__column_names[4] = BaseStorage.CS_STORAGE_AREA_ID;
		__column_names[5] = BaseStorage.CS_COUNTRY;
		__column_names[6] = BaseStorage.CS_PROVINCE;
		__column_names[7] = BaseStorage.CS_CITY;
		__column_names[8] = BaseStorage.CS_ADDRESS;
		__column_names[9] = BaseStorage.CS_CONTACT_EMPLOYEE_ID;
		__column_names[10] = BaseStorage.CS_CONTACT_PHONE;
		__column_names[11] = BaseStorage.CS_PARENT_ID;
		__column_names[12] = BaseStorage.CS_CREATE_EMPLOYEE_ID;
		__column_names[13] = BaseStorage.CS_CREATE_TIME;
		__column_names[14] = BaseStorage.CS_IS_ENABLED;
		__column_names[15] = BaseStorage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseStorage b) {
		clear();
		setStorageIdClear(b.getStorageId());
	}

	public boolean isPrimaryKeyNull() {
		return getStorageId() == null;
	}

	@Override
	public BaseStorage generateBase(){
		BaseStorage b = new BaseStorage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStorage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStorageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStorageCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStorageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStorageType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStorageAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCountry(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContactPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseStorage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStorageId();
		buff[count++] = b.getStorageCode();
		buff[count++] = b.getStorageName();
		buff[count++] = b.getStorageType();
		buff[count++] = b.getStorageAreaId();
		buff[count++] = b.getCountry();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getAddress();
		buff[count++] = b.getContactEmployeeId();
		buff[count++] = b.getContactPhone();
		buff[count++] = b.getParentId();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getIsEnabled();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseStorage b){
		if(b.getStorageId() != null) setStorageIdClear(b.getStorageId());
		if(b.getStorageCode() != null) setStorageCode(b.getStorageCode());
		if(b.getStorageName() != null) setStorageName(b.getStorageName());
		if(b.getStorageType() != null) setStorageType(b.getStorageType());
		if(b.getStorageAreaId() != null) setStorageAreaId(b.getStorageAreaId());
		if(b.getCountry() != null) setCountry(b.getCountry());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getAddress() != null) setAddress(b.getAddress());
		if(b.getContactEmployeeId() != null) setContactEmployeeId(b.getContactEmployeeId());
		if(b.getContactPhone() != null) setContactPhone(b.getContactPhone());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseStorage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStorage b = new BaseStorage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStorage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountry(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setStorageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getStorageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setStorageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setStorageCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getStorageCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setStorageName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getStorageName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setStorageType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getStorageType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setStorageAreaId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getStorageAreaId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCountry(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCountry() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProvince(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getProvince() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCity(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCity() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setAddress(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getAddress() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setContactEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getContactEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setContactPhone(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getContactPhone() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setConditionStorageId(String op, java.lang.Integer val) {
		setConditionStorageId(op, val, CONDITION_AND);
	}

	public void setConditionStorageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStorageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionStorageCode(String op, java.lang.String val) {
		setConditionStorageCode(op, val, CONDITION_AND);
	}

	public void setConditionStorageCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectStorageCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStorageName(String op, java.lang.String val) {
		setConditionStorageName(op, val, CONDITION_AND);
	}

	public void setConditionStorageName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStorageName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStorageType(String op, java.lang.Integer val) {
		setConditionStorageType(op, val, CONDITION_AND);
	}

	public void setConditionStorageType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectStorageType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionStorageAreaId(String op, java.lang.Integer val) {
		setConditionStorageAreaId(op, val, CONDITION_AND);
	}

	public void setConditionStorageAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStorageAreaId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCountry(String op, java.lang.Integer val) {
		setConditionCountry(op, val, CONDITION_AND);
	}

	public void setConditionCountry(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCountry(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProvince(String op, java.lang.Integer val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCity(String op, java.lang.Integer val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAddress(String op, java.lang.String val) {
		setConditionAddress(op, val, CONDITION_AND);
	}

	public void setConditionAddress(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAddress(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionContactEmployeeId(String op, java.lang.Integer val) {
		setConditionContactEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionContactEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectContactEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionContactPhone(String op, java.lang.String val) {
		setConditionContactPhone(op, val, CONDITION_AND);
	}

	public void setConditionContactPhone(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectContactPhone(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val) {
		setConditionIsEnabled(op, val, CONDITION_AND);
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsEnabled(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[15] = val;
	}


}

