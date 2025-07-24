package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePersonnelBusinessLinkTaxAmount;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PersonnelBusinessLinkTaxAmount extends AbstractTable<BasePersonnelBusinessLinkTaxAmount>
{

	public PersonnelBusinessLinkTaxAmount() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "personnel_business_link_tax_amount";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePersonnelBusinessLinkTaxAmount.CS_PERSONNEL_BUSINESS_LINK_TAX_AMOUNT_ID;
		__column_names[1] = BasePersonnelBusinessLinkTaxAmount.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BasePersonnelBusinessLinkTaxAmount.CS_COMPANY_ID;
		__column_names[3] = BasePersonnelBusinessLinkTaxAmount.CS_TAX_AMOUNT;
		__column_names[4] = BasePersonnelBusinessLinkTaxAmount.CS_OPERATOR;
		__column_names[5] = BasePersonnelBusinessLinkTaxAmount.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePersonnelBusinessLinkTaxAmount b) {
		clear();
		setPersonnelBusinessLinkTaxAmountIdClear(b.getPersonnelBusinessLinkTaxAmountId());
	}

	public boolean isPrimaryKeyNull() {
		return getPersonnelBusinessLinkTaxAmountId() == null;
	}

	@Override
	public BasePersonnelBusinessLinkTaxAmount generateBase(){
		BasePersonnelBusinessLinkTaxAmount b = new BasePersonnelBusinessLinkTaxAmount();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePersonnelBusinessLinkTaxAmount b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessLinkTaxAmountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BasePersonnelBusinessLinkTaxAmount b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPersonnelBusinessLinkTaxAmountId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getTaxAmount();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BasePersonnelBusinessLinkTaxAmount b){
		if(b.getPersonnelBusinessLinkTaxAmountId() != null) setPersonnelBusinessLinkTaxAmountIdClear(b.getPersonnelBusinessLinkTaxAmountId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getTaxAmount() != null) setTaxAmount(b.getTaxAmount());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BasePersonnelBusinessLinkTaxAmount generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePersonnelBusinessLinkTaxAmount b = new BasePersonnelBusinessLinkTaxAmount();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePersonnelBusinessLinkTaxAmount __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessLinkTaxAmountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setPersonnelBusinessLinkTaxAmountId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPersonnelBusinessLinkTaxAmountId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPersonnelBusinessLinkTaxAmountIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTaxAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getTaxAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionPersonnelBusinessLinkTaxAmountId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessLinkTaxAmountId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessLinkTaxAmountId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPersonnelBusinessLinkTaxAmountId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val) {
		setConditionTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTaxAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
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


}

