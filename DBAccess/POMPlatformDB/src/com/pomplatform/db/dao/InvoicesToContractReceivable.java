package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInvoicesToContractReceivable;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InvoicesToContractReceivable extends AbstractTable<BaseInvoicesToContractReceivable>
{

	public InvoicesToContractReceivable() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "invoices_to_contract_receivables";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInvoicesToContractReceivable.CS_CENTER_ID;
		__column_names[1] = BaseInvoicesToContractReceivable.CS_CONTRACT_RECEIVABLE_ID;
		__column_names[2] = BaseInvoicesToContractReceivable.CS_INVOICE_ID;
		__column_names[3] = BaseInvoicesToContractReceivable.CS_OPERATOR;
		__column_names[4] = BaseInvoicesToContractReceivable.CS_CREATE_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInvoicesToContractReceivable b) {
		clear();
		setCenterIdClear(b.getCenterId());
	}

	public boolean isPrimaryKeyNull() {
		return getCenterId() == null;
	}

	@Override
	public BaseInvoicesToContractReceivable generateBase(){
		BaseInvoicesToContractReceivable b = new BaseInvoicesToContractReceivable();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInvoicesToContractReceivable b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCenterId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseInvoicesToContractReceivable b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCenterId();
		buff[count++] = b.getContractReceivableId();
		buff[count++] = b.getInvoiceId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
	}

	@Override
	public void setDataFromBase(BaseInvoicesToContractReceivable b){
		if(b.getCenterId() != null) setCenterIdClear(b.getCenterId());
		if(b.getContractReceivableId() != null) setContractReceivableId(b.getContractReceivableId());
		if(b.getInvoiceId() != null) setInvoiceId(b.getInvoiceId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
	}

	@Override
	public BaseInvoicesToContractReceivable generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInvoicesToContractReceivable b = new BaseInvoicesToContractReceivable();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInvoicesToContractReceivable __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCenterId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
	}

	public void setCenterId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCenterId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCenterIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractReceivableId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractReceivableId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInvoiceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getInvoiceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setConditionCenterId(String op, java.lang.Integer val) {
		setConditionCenterId(op, val, CONDITION_AND);
	}

	public void setConditionCenterId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCenterId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val) {
		setConditionContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractReceivableId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val) {
		setConditionInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInvoiceId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[4] = val;
	}


}

