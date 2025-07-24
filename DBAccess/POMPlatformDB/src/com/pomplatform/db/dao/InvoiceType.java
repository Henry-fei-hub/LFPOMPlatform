package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInvoiceType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InvoiceType extends AbstractTable<BaseInvoiceType>
{

	public InvoiceType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "invoice_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInvoiceType.CS_INVOICE_TYPE_ID;
		__column_names[1] = BaseInvoiceType.CS_TYPE_NAME;
		__column_names[2] = BaseInvoiceType.CS_SUBTRACT_REMARK;
		__column_names[3] = BaseInvoiceType.CS_TAX_RATE;
		__column_names[4] = BaseInvoiceType.CS_CREATOR;
		__column_names[5] = BaseInvoiceType.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInvoiceType b) {
		clear();
		setInvoiceTypeIdClear(b.getInvoiceTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getInvoiceTypeId() == null;
	}

	@Override
	public BaseInvoiceType generateBase(){
		BaseInvoiceType b = new BaseInvoiceType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInvoiceType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInvoiceTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSubtractRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaxRate(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseInvoiceType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInvoiceTypeId();
		buff[count++] = b.getTypeName();
		buff[count++] = b.getSubtractRemark();
		buff[count++] = b.getTaxRate();
		buff[count++] = b.getCreator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseInvoiceType b){
		if(b.getInvoiceTypeId() != null) setInvoiceTypeIdClear(b.getInvoiceTypeId());
		if(b.getTypeName() != null) setTypeName(b.getTypeName());
		if(b.getSubtractRemark() != null) setSubtractRemark(b.getSubtractRemark());
		if(b.getTaxRate() != null) setTaxRate(b.getTaxRate());
		if(b.getCreator() != null) setCreator(b.getCreator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseInvoiceType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInvoiceType b = new BaseInvoiceType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInvoiceType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubtractRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxRate(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setInvoiceTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInvoiceTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInvoiceTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTypeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTypeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setSubtractRemark(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSubtractRemark() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setTaxRate(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getTaxRate() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCreator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionInvoiceTypeId(String op, java.lang.Integer val) {
		setConditionInvoiceTypeId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInvoiceTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTypeName(String op, java.lang.String val) {
		setConditionTypeName(op, val, CONDITION_AND);
	}

	public void setConditionTypeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTypeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSubtractRemark(String op, java.lang.String val) {
		setConditionSubtractRemark(op, val, CONDITION_AND);
	}

	public void setConditionSubtractRemark(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSubtractRemark(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTaxRate(String op, java.lang.Integer val) {
		setConditionTaxRate(op, val, CONDITION_AND);
	}

	public void setConditionTaxRate(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTaxRate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreator(String op, java.lang.Integer val) {
		setConditionCreator(op, val, CONDITION_AND);
	}

	public void setConditionCreator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCreator(boolean val) {
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

