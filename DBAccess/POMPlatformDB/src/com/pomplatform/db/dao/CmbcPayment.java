package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCmbcPayment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CmbcPayment extends AbstractTable<BaseCmbcPayment>
{

	public CmbcPayment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 20;

		initTables();

		__tableName            = "cmbc_payments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCmbcPayment.CS_CMBC_PAYMENT_ID;
		__column_names[1] = BaseCmbcPayment.CS_TYPE;
		__column_names[2] = BaseCmbcPayment.CS_YURREF;
		__column_names[3] = BaseCmbcPayment.CS_TOTAL_AMOUNT;
		__column_names[4] = BaseCmbcPayment.CS_TOTAL_NUM;
		__column_names[5] = BaseCmbcPayment.CS_REIMBURSEMENT_PACKAGE_ID;
		__column_names[6] = BaseCmbcPayment.CS_PAY_STATUS;
		__column_names[7] = BaseCmbcPayment.CS_PAY_RESULT;
		__column_names[8] = BaseCmbcPayment.CS_ERROR_MSG;
		__column_names[9] = BaseCmbcPayment.CS_EPTTIM;
		__column_names[10] = BaseCmbcPayment.CS_CREATE_TIME;
		__column_names[11] = BaseCmbcPayment.CS_SUCCESS_TOTAL_AMOUNT;
		__column_names[12] = BaseCmbcPayment.CS_SUCCESS_TOTAL_NUM;
		__column_names[13] = BaseCmbcPayment.CS_REQNBR;
		__column_names[14] = BaseCmbcPayment.CS_DBTACC;
		__column_names[15] = BaseCmbcPayment.CS_DBTBBK;
		__column_names[16] = BaseCmbcPayment.CS_TRSTYP;
		__column_names[17] = BaseCmbcPayment.CS_TRSTYP_NAME;
		__column_names[18] = BaseCmbcPayment.CS_NUSAGE;
		__column_names[19] = BaseCmbcPayment.CS_OPRDAT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCmbcPayment b) {
		clear();
		setCmbcPaymentIdClear(b.getCmbcPaymentId());
	}

	public boolean isPrimaryKeyNull() {
		return getCmbcPaymentId() == null;
	}

	@Override
	public BaseCmbcPayment generateBase(){
		BaseCmbcPayment b = new BaseCmbcPayment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCmbcPayment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCmbcPaymentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYurref(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayResult(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setErrorMsg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEpttim(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSuccessTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSuccessTotalNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReqnbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDbtacc(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDbtbbk(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrstyp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrstypName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNusage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOprdat(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCmbcPayment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCmbcPaymentId();
		buff[count++] = b.getType();
		buff[count++] = b.getYurref();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getTotalNum();
		buff[count++] = b.getReimbursementPackageId();
		buff[count++] = b.getPayStatus();
		buff[count++] = b.getPayResult();
		buff[count++] = b.getErrorMsg();
		buff[count++] = generateTimestampFromDate(b.getEpttim());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getSuccessTotalAmount();
		buff[count++] = b.getSuccessTotalNum();
		buff[count++] = b.getReqnbr();
		buff[count++] = b.getDbtacc();
		buff[count++] = b.getDbtbbk();
		buff[count++] = b.getTrstyp();
		buff[count++] = b.getTrstypName();
		buff[count++] = b.getNusage();
		buff[count++] = generateTimestampFromDate(b.getOprdat());
	}

	@Override
	public void setDataFromBase(BaseCmbcPayment b){
		if(b.getCmbcPaymentId() != null) setCmbcPaymentIdClear(b.getCmbcPaymentId());
		if(b.getType() != null) setType(b.getType());
		if(b.getYurref() != null) setYurref(b.getYurref());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getTotalNum() != null) setTotalNum(b.getTotalNum());
		if(b.getReimbursementPackageId() != null) setReimbursementPackageId(b.getReimbursementPackageId());
		if(b.getPayStatus() != null) setPayStatus(b.getPayStatus());
		if(b.getPayResult() != null) setPayResult(b.getPayResult());
		if(b.getErrorMsg() != null) setErrorMsg(b.getErrorMsg());
		if(b.getEpttim() != null) setEpttim(b.getEpttim());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getSuccessTotalAmount() != null) setSuccessTotalAmount(b.getSuccessTotalAmount());
		if(b.getSuccessTotalNum() != null) setSuccessTotalNum(b.getSuccessTotalNum());
		if(b.getReqnbr() != null) setReqnbr(b.getReqnbr());
		if(b.getDbtacc() != null) setDbtacc(b.getDbtacc());
		if(b.getDbtbbk() != null) setDbtbbk(b.getDbtbbk());
		if(b.getTrstyp() != null) setTrstyp(b.getTrstyp());
		if(b.getTrstypName() != null) setTrstypName(b.getTrstypName());
		if(b.getNusage() != null) setNusage(b.getNusage());
		if(b.getOprdat() != null) setOprdat(b.getOprdat());
	}

	@Override
	public BaseCmbcPayment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCmbcPayment b = new BaseCmbcPayment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCmbcPayment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcPaymentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYurref(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayResult(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setErrorMsg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEpttim(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuccessTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuccessTotalNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReqnbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDbtacc(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDbtbbk(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrstyp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrstypName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNusage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOprdat(GenericBase.__getDateFromSQL(val));
	}

	public void setCmbcPaymentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCmbcPaymentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCmbcPaymentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYurref(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getYurref() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setTotalNum(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getTotalNum() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setReimbursementPackageId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getReimbursementPackageId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPayStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPayStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setPayResult(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPayResult() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setErrorMsg(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getErrorMsg() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setEpttim(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getEpttim() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setSuccessTotalAmount(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getSuccessTotalAmount() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setSuccessTotalNum(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getSuccessTotalNum() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setReqnbr(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getReqnbr() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setDbtacc(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getDbtacc() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setDbtbbk(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getDbtbbk() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setTrstyp(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getTrstyp() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setTrstypName(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getTrstypName() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setNusage(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getNusage() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setOprdat(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getOprdat() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setConditionCmbcPaymentId(String op, java.lang.Integer val) {
		setConditionCmbcPaymentId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcPaymentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCmbcPaymentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYurref(String op, java.lang.String val) {
		setConditionYurref(op, val, CONDITION_AND);
	}

	public void setConditionYurref(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYurref(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTotalNum(String op, java.lang.Integer val) {
		setConditionTotalNum(op, val, CONDITION_AND);
	}

	public void setConditionTotalNum(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTotalNum(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectReimbursementPackageId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPayStatus(String op, java.lang.Integer val) {
		setConditionPayStatus(op, val, CONDITION_AND);
	}

	public void setConditionPayStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPayStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPayResult(String op, java.lang.Integer val) {
		setConditionPayResult(op, val, CONDITION_AND);
	}

	public void setConditionPayResult(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPayResult(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionErrorMsg(String op, java.lang.String val) {
		setConditionErrorMsg(op, val, CONDITION_AND);
	}

	public void setConditionErrorMsg(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectErrorMsg(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEpttim(String op, java.util.Date val) {
		setConditionEpttim(op, val, CONDITION_AND);
	}

	public void setConditionEpttim(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEpttim(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSuccessTotalAmount(String op, java.math.BigDecimal val) {
		setConditionSuccessTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionSuccessTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSuccessTotalAmount(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSuccessTotalNum(String op, java.lang.Integer val) {
		setConditionSuccessTotalNum(op, val, CONDITION_AND);
	}

	public void setConditionSuccessTotalNum(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSuccessTotalNum(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionReqnbr(String op, java.lang.String val) {
		setConditionReqnbr(op, val, CONDITION_AND);
	}

	public void setConditionReqnbr(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectReqnbr(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDbtacc(String op, java.lang.String val) {
		setConditionDbtacc(op, val, CONDITION_AND);
	}

	public void setConditionDbtacc(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDbtacc(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDbtbbk(String op, java.lang.String val) {
		setConditionDbtbbk(op, val, CONDITION_AND);
	}

	public void setConditionDbtbbk(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDbtbbk(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionTrstyp(String op, java.lang.String val) {
		setConditionTrstyp(op, val, CONDITION_AND);
	}

	public void setConditionTrstyp(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectTrstyp(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionTrstypName(String op, java.lang.String val) {
		setConditionTrstypName(op, val, CONDITION_AND);
	}

	public void setConditionTrstypName(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectTrstypName(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionNusage(String op, java.lang.String val) {
		setConditionNusage(op, val, CONDITION_AND);
	}

	public void setConditionNusage(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectNusage(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionOprdat(String op, java.util.Date val) {
		setConditionOprdat(op, val, CONDITION_AND);
	}

	public void setConditionOprdat(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOprdat(boolean val) {
		__select_flags[19] = val;
	}


}

