package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompany;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Company extends AbstractTable<BaseCompany>
{

	public Company() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "companies";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompany.CS_COMPANY_ID;
		__column_names[1] = BaseCompany.CS_COMPANY_NAME;
		__column_names[2] = BaseCompany.CS_COMPANY_ADDRESS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompany b) {
		clear();
		setCompanyIdClear(b.getCompanyId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyId() == null;
	}

	@Override
	public BaseCompany generateBase(){
		BaseCompany b = new BaseCompany();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompany b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyAddress(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompany b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyName();
		buff[count++] = b.getCompanyAddress();
	}

	@Override
	public void setDataFromBase(BaseCompany b){
		if(b.getCompanyId() != null) setCompanyIdClear(b.getCompanyId());
		if(b.getCompanyName() != null) setCompanyName(b.getCompanyName());
		if(b.getCompanyAddress() != null) setCompanyAddress(b.getCompanyAddress());
	}

	@Override
	public BaseCompany generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompany b = new BaseCompany();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompany __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyAddress(GenericBase.__getString(val));
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCompanyName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCompanyAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCompanyAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyName(String op, java.lang.String val) {
		setConditionCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyAddress(String op, java.lang.String val) {
		setConditionCompanyAddress(op, val, CONDITION_AND);
	}

	public void setConditionCompanyAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyAddress(boolean val) {
		__select_flags[2] = val;
	}


}

