package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyWorkplace;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyWorkplace extends AbstractTable<BaseCompanyWorkplace>
{

	public CompanyWorkplace() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "company_workplaces";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyWorkplace.CS_COMPANY_WORKPLACE_ID;
		__column_names[1] = BaseCompanyWorkplace.CS_COMPANY_ID;
		__column_names[2] = BaseCompanyWorkplace.CS_WORKPLACE_NAME;
		__column_names[3] = BaseCompanyWorkplace.CS_COUNTRY_ID;
		__column_names[4] = BaseCompanyWorkplace.CS_PROVINCE_ID;
		__column_names[5] = BaseCompanyWorkplace.CS_CITY_ID;
		__column_names[6] = BaseCompanyWorkplace.CS_ACTIVE;
		__column_names[7] = BaseCompanyWorkplace.CS_WORKPLACE_DIR;
		__column_names[8] = BaseCompanyWorkplace.CS_WORKPLACE_TYPE;
		__column_names[9] = BaseCompanyWorkplace.CS_HAS_INIT;
		__column_names[10] = BaseCompanyWorkplace.CS_BACKUP_DIR;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyWorkplace b) {
		clear();
		setCompanyWorkplaceIdClear(b.getCompanyWorkplaceId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyWorkplaceId() == null;
	}

	@Override
	public BaseCompanyWorkplace generateBase(){
		BaseCompanyWorkplace b = new BaseCompanyWorkplace();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyWorkplace b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCountryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvinceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCityId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setActive(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceDir(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHasInit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBackupDir(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyWorkplace b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyWorkplaceId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getWorkplaceName();
		buff[count++] = b.getCountryId();
		buff[count++] = b.getProvinceId();
		buff[count++] = b.getCityId();
		buff[count++] = b.getActive();
		buff[count++] = b.getWorkplaceDir();
		buff[count++] = b.getWorkplaceType();
		buff[count++] = b.getHasInit();
		buff[count++] = b.getBackupDir();
	}

	@Override
	public void setDataFromBase(BaseCompanyWorkplace b){
		if(b.getCompanyWorkplaceId() != null) setCompanyWorkplaceIdClear(b.getCompanyWorkplaceId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getWorkplaceName() != null) setWorkplaceName(b.getWorkplaceName());
		if(b.getCountryId() != null) setCountryId(b.getCountryId());
		if(b.getProvinceId() != null) setProvinceId(b.getProvinceId());
		if(b.getCityId() != null) setCityId(b.getCityId());
		if(b.getActive() != null) setActive(b.getActive());
		if(b.getWorkplaceDir() != null) setWorkplaceDir(b.getWorkplaceDir());
		if(b.getWorkplaceType() != null) setWorkplaceType(b.getWorkplaceType());
		if(b.getHasInit() != null) setHasInit(b.getHasInit());
		if(b.getBackupDir() != null) setBackupDir(b.getBackupDir());
	}

	@Override
	public BaseCompanyWorkplace generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyWorkplace b = new BaseCompanyWorkplace();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyWorkplace __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActive(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceDir(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasInit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBackupDir(GenericBase.__getString(val));
	}

	public void setCompanyWorkplaceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyWorkplaceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyWorkplaceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setWorkplaceName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getWorkplaceName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCountryId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCountryId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProvinceId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProvinceId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCityId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCityId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setActive(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getActive() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setWorkplaceDir(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getWorkplaceDir() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setWorkplaceType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getWorkplaceType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setHasInit(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getHasInit() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setBackupDir(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getBackupDir() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setConditionCompanyWorkplaceId(String op, java.lang.Integer val) {
		setConditionCompanyWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyWorkplaceId(boolean val) {
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

	public void setConditionWorkplaceName(String op, java.lang.String val) {
		setConditionWorkplaceName(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectWorkplaceName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCountryId(String op, java.lang.Integer val) {
		setConditionCountryId(op, val, CONDITION_AND);
	}

	public void setConditionCountryId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCountryId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProvinceId(String op, java.lang.Integer val) {
		setConditionProvinceId(op, val, CONDITION_AND);
	}

	public void setConditionProvinceId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProvinceId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCityId(String op, java.lang.Integer val) {
		setConditionCityId(op, val, CONDITION_AND);
	}

	public void setConditionCityId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCityId(boolean val) {
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

	public void setConditionWorkplaceDir(String op, java.lang.String val) {
		setConditionWorkplaceDir(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceDir(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectWorkplaceDir(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionWorkplaceType(String op, java.lang.Integer val) {
		setConditionWorkplaceType(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectWorkplaceType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionHasInit(String op, java.lang.Boolean val) {
		setConditionHasInit(op, val, CONDITION_AND);
	}

	public void setConditionHasInit(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectHasInit(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBackupDir(String op, java.lang.String val) {
		setConditionBackupDir(op, val, CONDITION_AND);
	}

	public void setConditionBackupDir(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBackupDir(boolean val) {
		__select_flags[10] = val;
	}


}

