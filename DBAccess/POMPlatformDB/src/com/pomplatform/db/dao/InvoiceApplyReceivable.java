package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInvoiceApplyReceivable;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InvoiceApplyReceivable extends AbstractTable<BaseInvoiceApplyReceivable>
{

	public InvoiceApplyReceivable() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "invoice_apply_receivables";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInvoiceApplyReceivable.CS_INVOICE_APPLY_RECEIVABLE_ID;
		__column_names[1] = BaseInvoiceApplyReceivable.CS_CONTRACT_ID;
		__column_names[2] = BaseInvoiceApplyReceivable.CS_INVOICE_APPLY_ID;
		__column_names[3] = BaseInvoiceApplyReceivable.CS_CONTRACT_RECEIVABLE_ID;
		__column_names[4] = BaseInvoiceApplyReceivable.CS_RECEIVABLE_APPLY_MONEY;
		__column_names[5] = BaseInvoiceApplyReceivable.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInvoiceApplyReceivable b) {
		clear();
		setInvoiceApplyReceivableIdClear(b.getInvoiceApplyReceivableId());
	}

	public boolean isPrimaryKeyNull() {
		return getInvoiceApplyReceivableId() == null;
	}

	@Override
	public BaseInvoiceApplyReceivable generateBase(){
		BaseInvoiceApplyReceivable b = new BaseInvoiceApplyReceivable();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInvoiceApplyReceivable b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInvoiceApplyReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceApplyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceivableApplyMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseInvoiceApplyReceivable b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInvoiceApplyReceivableId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getInvoiceApplyId();
		buff[count++] = b.getContractReceivableId();
		buff[count++] = b.getReceivableApplyMoney();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseInvoiceApplyReceivable b){
		if(b.getInvoiceApplyReceivableId() != null) setInvoiceApplyReceivableIdClear(b.getInvoiceApplyReceivableId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getInvoiceApplyId() != null) setInvoiceApplyId(b.getInvoiceApplyId());
		if(b.getContractReceivableId() != null) setContractReceivableId(b.getContractReceivableId());
		if(b.getReceivableApplyMoney() != null) setReceivableApplyMoney(b.getReceivableApplyMoney());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseInvoiceApplyReceivable generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInvoiceApplyReceivable b = new BaseInvoiceApplyReceivable();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInvoiceApplyReceivable __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceApplyReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceApplyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivableApplyMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setInvoiceApplyReceivableId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInvoiceApplyReceivableId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInvoiceApplyReceivableIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInvoiceApplyId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getInvoiceApplyId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContractReceivableId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractReceivableId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setReceivableApplyMoney(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getReceivableApplyMoney() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionInvoiceApplyReceivableId(String op, java.lang.Integer val) {
		setConditionInvoiceApplyReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceApplyReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInvoiceApplyReceivableId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInvoiceApplyId(String op, java.lang.Integer val) {
		setConditionInvoiceApplyId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceApplyId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInvoiceApplyId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val) {
		setConditionContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractReceivableId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionReceivableApplyMoney(String op, java.math.BigDecimal val) {
		setConditionReceivableApplyMoney(op, val, CONDITION_AND);
	}

	public void setConditionReceivableApplyMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectReceivableApplyMoney(boolean val) {
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

