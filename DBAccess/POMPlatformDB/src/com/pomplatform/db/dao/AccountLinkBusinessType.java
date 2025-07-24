package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAccountLinkBusinessType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AccountLinkBusinessType extends AbstractTable<BaseAccountLinkBusinessType>
{

	public AccountLinkBusinessType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "account_link_business_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAccountLinkBusinessType.CS_ACCOUNT_LINK_BUSINESS_TYPE_ID;
		__column_names[1] = BaseAccountLinkBusinessType.CS_ACCOUNT_TYPE;
		__column_names[2] = BaseAccountLinkBusinessType.CS_BUSINESS_TYPE_ID;
		__column_names[3] = BaseAccountLinkBusinessType.CS_IS_DEBIT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAccountLinkBusinessType b) {
		clear();
		setAccountLinkBusinessTypeIdClear(b.getAccountLinkBusinessTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountLinkBusinessTypeId() == null;
	}

	@Override
	public BaseAccountLinkBusinessType generateBase(){
		BaseAccountLinkBusinessType b = new BaseAccountLinkBusinessType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAccountLinkBusinessType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountLinkBusinessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsDebit(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseAccountLinkBusinessType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountLinkBusinessTypeId();
		buff[count++] = b.getAccountType();
		buff[count++] = b.getBusinessTypeId();
		buff[count++] = b.getIsDebit();
	}

	@Override
	public void setDataFromBase(BaseAccountLinkBusinessType b){
		if(b.getAccountLinkBusinessTypeId() != null) setAccountLinkBusinessTypeIdClear(b.getAccountLinkBusinessTypeId());
		if(b.getAccountType() != null) setAccountType(b.getAccountType());
		if(b.getBusinessTypeId() != null) setBusinessTypeId(b.getBusinessTypeId());
		if(b.getIsDebit() != null) setIsDebit(b.getIsDebit());
	}

	@Override
	public BaseAccountLinkBusinessType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAccountLinkBusinessType b = new BaseAccountLinkBusinessType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAccountLinkBusinessType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountLinkBusinessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsDebit(GenericBase.__getBoolean(val));
	}

	public void setAccountLinkBusinessTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAccountLinkBusinessTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAccountLinkBusinessTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAccountType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAccountType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessTypeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessTypeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setIsDebit(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsDebit() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setConditionAccountLinkBusinessTypeId(String op, java.lang.Integer val) {
		setConditionAccountLinkBusinessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionAccountLinkBusinessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAccountLinkBusinessTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAccountType(String op, java.lang.Integer val) {
		setConditionAccountType(op, val, CONDITION_AND);
	}

	public void setConditionAccountType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAccountType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val) {
		setConditionBusinessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessTypeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsDebit(String op, java.lang.Boolean val) {
		setConditionIsDebit(op, val, CONDITION_AND);
	}

	public void setConditionIsDebit(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsDebit(boolean val) {
		__select_flags[3] = val;
	}


}

