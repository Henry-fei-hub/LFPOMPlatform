package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBankCapitalCheckLink;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BankCapitalCheckLink extends AbstractTable<BaseBankCapitalCheckLink>
{

	public BankCapitalCheckLink() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "bank_capital_check_links";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBankCapitalCheckLink.CS_BANK_CAPITAL_CHECK_LINK_ID;
		__column_names[1] = BaseBankCapitalCheckLink.CS_BUSINESS_ID;
		__column_names[2] = BaseBankCapitalCheckLink.CS_BUSINESS_TYPE;
		__column_names[3] = BaseBankCapitalCheckLink.CS_LINK_TYPE;
		__column_names[4] = BaseBankCapitalCheckLink.CS_CODE;
		__column_names[5] = BaseBankCapitalCheckLink.CS_CREATE_TIME;
		__column_names[6] = BaseBankCapitalCheckLink.CS_OPERATOR;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBankCapitalCheckLink b) {
		clear();
		setBankCapitalCheckLinkIdClear(b.getBankCapitalCheckLinkId());
	}

	public boolean isPrimaryKeyNull() {
		return getBankCapitalCheckLinkId() == null;
	}

	@Override
	public BaseBankCapitalCheckLink generateBase(){
		BaseBankCapitalCheckLink b = new BaseBankCapitalCheckLink();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBankCapitalCheckLink b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBankCapitalCheckLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLinkType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseBankCapitalCheckLink b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBankCapitalCheckLinkId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getLinkType();
		buff[count++] = b.getCode();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOperator();
	}

	@Override
	public void setDataFromBase(BaseBankCapitalCheckLink b){
		if(b.getBankCapitalCheckLinkId() != null) setBankCapitalCheckLinkIdClear(b.getBankCapitalCheckLinkId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getLinkType() != null) setLinkType(b.getLinkType());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOperator() != null) setOperator(b.getOperator());
	}

	@Override
	public BaseBankCapitalCheckLink generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBankCapitalCheckLink b = new BaseBankCapitalCheckLink();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBankCapitalCheckLink __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankCapitalCheckLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLinkType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
	}

	public void setBankCapitalCheckLinkId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBankCapitalCheckLinkId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBankCapitalCheckLinkIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setLinkType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getLinkType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionBankCapitalCheckLinkId(String op, java.lang.Integer val) {
		setConditionBankCapitalCheckLinkId(op, val, CONDITION_AND);
	}

	public void setConditionBankCapitalCheckLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBankCapitalCheckLinkId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionLinkType(String op, java.lang.Integer val) {
		setConditionLinkType(op, val, CONDITION_AND);
	}

	public void setConditionLinkType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectLinkType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[6] = val;
	}


}

