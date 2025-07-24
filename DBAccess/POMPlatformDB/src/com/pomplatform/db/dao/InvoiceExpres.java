package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInvoiceExpres;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InvoiceExpres extends AbstractTable<BaseInvoiceExpres>
{

	public InvoiceExpres() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "invoice_express";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInvoiceExpres.CS_INVOICE_EXPRESS_ID;
		__column_names[1] = BaseInvoiceExpres.CS_INFO_CODE;
		__column_names[2] = BaseInvoiceExpres.CS_PROJECT_CODE;
		__column_names[3] = BaseInvoiceExpres.CS_CONTRACT_ID;
		__column_names[4] = BaseInvoiceExpres.CS_CONTRACT_CODE;
		__column_names[5] = BaseInvoiceExpres.CS_CONTACT_ID;
		__column_names[6] = BaseInvoiceExpres.CS_TEL;
		__column_names[7] = BaseInvoiceExpres.CS_MAILING_ADDRESS;
		__column_names[8] = BaseInvoiceExpres.CS_COURIER_TYPE;
		__column_names[9] = BaseInvoiceExpres.CS_COURIER_NUMBER;
		__column_names[10] = BaseInvoiceExpres.CS_COURIER_DATE;
		__column_names[11] = BaseInvoiceExpres.CS_SIGN_STATUS;
		__column_names[12] = BaseInvoiceExpres.CS_SIGN_NAME;
		__column_names[13] = BaseInvoiceExpres.CS_SIGN_RECEIPT;
		__column_names[14] = BaseInvoiceExpres.CS_SIGN_DATE;
		__column_names[15] = BaseInvoiceExpres.CS_OPERATOR;
		__column_names[16] = BaseInvoiceExpres.CS_CREATE_DATE;
		__column_names[17] = BaseInvoiceExpres.CS_REMARK;
		__column_names[18] = BaseInvoiceExpres.CS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInvoiceExpres b) {
		clear();
		setInvoiceExpressIdClear(b.getInvoiceExpressId());
	}

	public boolean isPrimaryKeyNull() {
		return getInvoiceExpressId() == null;
	}

	@Override
	public BaseInvoiceExpres generateBase(){
		BaseInvoiceExpres b = new BaseInvoiceExpres();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInvoiceExpres b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInvoiceExpressId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMailingAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCourierType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCourierNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCourierDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSignStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignReceipt(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseInvoiceExpres b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInvoiceExpressId();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContactId();
		buff[count++] = b.getTel();
		buff[count++] = b.getMailingAddress();
		buff[count++] = b.getCourierType();
		buff[count++] = b.getCourierNumber();
		buff[count++] = generateTimestampFromDate(b.getCourierDate());
		buff[count++] = b.getSignStatus();
		buff[count++] = b.getSignName();
		buff[count++] = b.getSignReceipt();
		buff[count++] = generateTimestampFromDate(b.getSignDate());
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getRemark();
		buff[count++] = b.getType();
	}

	@Override
	public void setDataFromBase(BaseInvoiceExpres b){
		if(b.getInvoiceExpressId() != null) setInvoiceExpressIdClear(b.getInvoiceExpressId());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContactId() != null) setContactId(b.getContactId());
		if(b.getTel() != null) setTel(b.getTel());
		if(b.getMailingAddress() != null) setMailingAddress(b.getMailingAddress());
		if(b.getCourierType() != null) setCourierType(b.getCourierType());
		if(b.getCourierNumber() != null) setCourierNumber(b.getCourierNumber());
		if(b.getCourierDate() != null) setCourierDate(b.getCourierDate());
		if(b.getSignStatus() != null) setSignStatus(b.getSignStatus());
		if(b.getSignName() != null) setSignName(b.getSignName());
		if(b.getSignReceipt() != null) setSignReceipt(b.getSignReceipt());
		if(b.getSignDate() != null) setSignDate(b.getSignDate());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getType() != null) setType(b.getType());
	}

	@Override
	public BaseInvoiceExpres generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInvoiceExpres b = new BaseInvoiceExpres();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInvoiceExpres __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceExpressId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMailingAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCourierType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCourierNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCourierDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignReceipt(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
	}

	public void setInvoiceExpressId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInvoiceExpressId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInvoiceExpressIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setContactId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getContactId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setTel(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getTel() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setMailingAddress(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMailingAddress() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCourierType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCourierType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCourierNumber(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getCourierNumber() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setCourierDate(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCourierDate() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setSignStatus(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getSignStatus() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setSignName(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getSignName() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setSignReceipt(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getSignReceipt() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setSignDate(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getSignDate() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setConditionInvoiceExpressId(String op, java.lang.Integer val) {
		setConditionInvoiceExpressId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceExpressId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInvoiceExpressId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionContactId(String op, java.lang.Integer val) {
		setConditionContactId(op, val, CONDITION_AND);
	}

	public void setConditionContactId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectContactId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTel(String op, java.lang.String val) {
		setConditionTel(op, val, CONDITION_AND);
	}

	public void setConditionTel(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTel(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMailingAddress(String op, java.lang.String val) {
		setConditionMailingAddress(op, val, CONDITION_AND);
	}

	public void setConditionMailingAddress(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMailingAddress(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCourierType(String op, java.lang.Integer val) {
		setConditionCourierType(op, val, CONDITION_AND);
	}

	public void setConditionCourierType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCourierType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCourierNumber(String op, java.lang.String val) {
		setConditionCourierNumber(op, val, CONDITION_AND);
	}

	public void setConditionCourierNumber(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCourierNumber(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCourierDate(String op, java.util.Date val) {
		setConditionCourierDate(op, val, CONDITION_AND);
	}

	public void setConditionCourierDate(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCourierDate(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSignStatus(String op, java.lang.Integer val) {
		setConditionSignStatus(op, val, CONDITION_AND);
	}

	public void setConditionSignStatus(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSignStatus(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSignName(String op, java.lang.String val) {
		setConditionSignName(op, val, CONDITION_AND);
	}

	public void setConditionSignName(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSignName(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSignReceipt(String op, java.lang.String val) {
		setConditionSignReceipt(op, val, CONDITION_AND);
	}

	public void setConditionSignReceipt(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSignReceipt(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionSignDate(String op, java.util.Date val) {
		setConditionSignDate(op, val, CONDITION_AND);
	}

	public void setConditionSignDate(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSignDate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[18] = val;
	}


}

