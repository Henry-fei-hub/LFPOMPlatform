package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePurchasePayment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PurchasePayment extends AbstractTable<BasePurchasePayment>
{

	public PurchasePayment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "purchase_payments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePurchasePayment.CS_PURCHASE_PAYMENT_ID;
		__column_names[1] = BasePurchasePayment.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BasePurchasePayment.CS_PAYMENT_DATE;
		__column_names[3] = BasePurchasePayment.CS_PAYMENT_NAME;
		__column_names[4] = BasePurchasePayment.CS_PAYMENT_CONDITION;
		__column_names[5] = BasePurchasePayment.CS_PAYMENT_RATIO;
		__column_names[6] = BasePurchasePayment.CS_PAYMENT_AMOUNT;
		__column_names[7] = BasePurchasePayment.CS_REMARK;
		__column_names[8] = BasePurchasePayment.CS_CREATE_TIME;
		__column_names[9] = BasePurchasePayment.CS_PURCHASE_CONTRACT_ID;
		__column_names[10] = BasePurchasePayment.CS_PURCHASE_PAYMENT_STATUS;
		__column_names[11] = BasePurchasePayment.CS_PERSON_IN_CHARGE;
		__column_names[12] = BasePurchasePayment.CS_OPERATOR_ID;
		__column_names[13] = BasePurchasePayment.CS_REAL_PAYMENT_DATE;
		__column_names[14] = BasePurchasePayment.CS_REAL_PAYMENT_AMOUNT;
		__column_names[15] = BasePurchasePayment.CS_PROCESS_BUSINESS_ID;
		__column_names[16] = BasePurchasePayment.CS_DEAL_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePurchasePayment b) {
		clear();
		setPurchasePaymentIdClear(b.getPurchasePaymentId());
	}

	public boolean isPrimaryKeyNull() {
		return getPurchasePaymentId() == null;
	}

	@Override
	public BasePurchasePayment generateBase(){
		BasePurchasePayment b = new BasePurchasePayment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePurchasePayment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPurchasePaymentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPaymentDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPaymentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentCondition(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchasePaymentStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonInCharge(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRealPaymentDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRealPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProcessBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDealStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePurchasePayment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPurchasePaymentId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = generateTimestampFromDate(b.getPaymentDate());
		buff[count++] = b.getPaymentName();
		buff[count++] = b.getPaymentCondition();
		buff[count++] = b.getPaymentRatio();
		buff[count++] = b.getPaymentAmount();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getPurchaseContractId();
		buff[count++] = b.getPurchasePaymentStatus();
		buff[count++] = b.getPersonInCharge();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getRealPaymentDate());
		buff[count++] = b.getRealPaymentAmount();
		buff[count++] = b.getProcessBusinessId();
		buff[count++] = b.getDealStatus();
	}

	@Override
	public void setDataFromBase(BasePurchasePayment b){
		if(b.getPurchasePaymentId() != null) setPurchasePaymentIdClear(b.getPurchasePaymentId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getPaymentDate() != null) setPaymentDate(b.getPaymentDate());
		if(b.getPaymentName() != null) setPaymentName(b.getPaymentName());
		if(b.getPaymentCondition() != null) setPaymentCondition(b.getPaymentCondition());
		if(b.getPaymentRatio() != null) setPaymentRatio(b.getPaymentRatio());
		if(b.getPaymentAmount() != null) setPaymentAmount(b.getPaymentAmount());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getPurchaseContractId() != null) setPurchaseContractId(b.getPurchaseContractId());
		if(b.getPurchasePaymentStatus() != null) setPurchasePaymentStatus(b.getPurchasePaymentStatus());
		if(b.getPersonInCharge() != null) setPersonInCharge(b.getPersonInCharge());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getRealPaymentDate() != null) setRealPaymentDate(b.getRealPaymentDate());
		if(b.getRealPaymentAmount() != null) setRealPaymentAmount(b.getRealPaymentAmount());
		if(b.getProcessBusinessId() != null) setProcessBusinessId(b.getProcessBusinessId());
		if(b.getDealStatus() != null) setDealStatus(b.getDealStatus());
	}

	@Override
	public BasePurchasePayment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePurchasePayment b = new BasePurchasePayment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePurchasePayment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasePaymentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentCondition(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasePaymentStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonInCharge(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealPaymentDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealPaymentAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDealStatus(GenericBase.__getInt(val));
	}

	public void setPurchasePaymentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPurchasePaymentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPurchasePaymentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPaymentDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getPaymentDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setPaymentName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getPaymentName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPaymentCondition(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getPaymentCondition() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setPaymentRatio(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPaymentRatio() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPaymentAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPaymentAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setPurchaseContractId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getPurchaseContractId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setPurchasePaymentStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getPurchasePaymentStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setPersonInCharge(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getPersonInCharge() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setRealPaymentDate(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getRealPaymentDate() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setRealPaymentAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getRealPaymentAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setProcessBusinessId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getProcessBusinessId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setDealStatus(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getDealStatus() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setConditionPurchasePaymentId(String op, java.lang.Integer val) {
		setConditionPurchasePaymentId(op, val, CONDITION_AND);
	}

	public void setConditionPurchasePaymentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPurchasePaymentId(boolean val) {
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

	public void setConditionPaymentDate(String op, java.util.Date val) {
		setConditionPaymentDate(op, val, CONDITION_AND);
	}

	public void setConditionPaymentDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPaymentDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPaymentName(String op, java.lang.String val) {
		setConditionPaymentName(op, val, CONDITION_AND);
	}

	public void setConditionPaymentName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPaymentName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPaymentCondition(String op, java.lang.String val) {
		setConditionPaymentCondition(op, val, CONDITION_AND);
	}

	public void setConditionPaymentCondition(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPaymentCondition(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPaymentRatio(String op, java.math.BigDecimal val) {
		setConditionPaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionPaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPaymentRatio(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPaymentAmount(String op, java.math.BigDecimal val) {
		setConditionPaymentAmount(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPaymentAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val) {
		setConditionPurchaseContractId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPurchaseContractId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPurchasePaymentStatus(String op, java.lang.Integer val) {
		setConditionPurchasePaymentStatus(op, val, CONDITION_AND);
	}

	public void setConditionPurchasePaymentStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectPurchasePaymentStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionPersonInCharge(String op, java.lang.Integer val) {
		setConditionPersonInCharge(op, val, CONDITION_AND);
	}

	public void setConditionPersonInCharge(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPersonInCharge(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRealPaymentDate(String op, java.util.Date val) {
		setConditionRealPaymentDate(op, val, CONDITION_AND);
	}

	public void setConditionRealPaymentDate(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRealPaymentDate(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionRealPaymentAmount(String op, java.math.BigDecimal val) {
		setConditionRealPaymentAmount(op, val, CONDITION_AND);
	}

	public void setConditionRealPaymentAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectRealPaymentAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionProcessBusinessId(String op, java.lang.Integer val) {
		setConditionProcessBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProcessBusinessId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionDealStatus(String op, java.lang.Integer val) {
		setConditionDealStatus(op, val, CONDITION_AND);
	}

	public void setConditionDealStatus(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectDealStatus(boolean val) {
		__select_flags[16] = val;
	}


}

