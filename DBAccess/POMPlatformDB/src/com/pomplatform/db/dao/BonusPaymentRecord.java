package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBonusPaymentRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BonusPaymentRecord extends AbstractTable<BaseBonusPaymentRecord>
{

	public BonusPaymentRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "bonus_payment_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBonusPaymentRecord.CS_BONUS_PAYMENT_RECORD_ID;
		__column_names[1] = BaseBonusPaymentRecord.CS_PLATE_ID;
		__column_names[2] = BaseBonusPaymentRecord.CS_PAY_INTEGRAL;
		__column_names[3] = BaseBonusPaymentRecord.CS_PAY_DATE;
		__column_names[4] = BaseBonusPaymentRecord.CS_REMARK;
		__column_names[5] = BaseBonusPaymentRecord.CS_APPLICANT;
		__column_names[6] = BaseBonusPaymentRecord.CS_APPLY_TIME;
		__column_names[7] = BaseBonusPaymentRecord.CS_STATE;
		__column_names[8] = BaseBonusPaymentRecord.CS_AUDITOR;
		__column_names[9] = BaseBonusPaymentRecord.CS_AUDITING_TIME;
		__column_names[10] = BaseBonusPaymentRecord.CS_OPINION;
		__column_names[11] = BaseBonusPaymentRecord.CS_IS_LEVEL_TWO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBonusPaymentRecord b) {
		clear();
		setBonusPaymentRecordIdClear(b.getBonusPaymentRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getBonusPaymentRecordId() == null;
	}

	@Override
	public BaseBonusPaymentRecord generateBase(){
		BaseBonusPaymentRecord b = new BaseBonusPaymentRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBonusPaymentRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setApplicant(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setState(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAuditor(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAuditingTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOpinion(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsLevelTwo(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseBonusPaymentRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBonusPaymentRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getPayIntegral();
		buff[count++] = generateTimestampFromDate(b.getPayDate());
		buff[count++] = b.getRemark();
		buff[count++] = b.getApplicant();
		buff[count++] = generateTimestampFromDate(b.getApplyTime());
		buff[count++] = b.getState();
		buff[count++] = b.getAuditor();
		buff[count++] = generateTimestampFromDate(b.getAuditingTime());
		buff[count++] = b.getOpinion();
		buff[count++] = b.getIsLevelTwo();
	}

	@Override
	public void setDataFromBase(BaseBonusPaymentRecord b){
		if(b.getBonusPaymentRecordId() != null) setBonusPaymentRecordIdClear(b.getBonusPaymentRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getPayIntegral() != null) setPayIntegral(b.getPayIntegral());
		if(b.getPayDate() != null) setPayDate(b.getPayDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getApplicant() != null) setApplicant(b.getApplicant());
		if(b.getApplyTime() != null) setApplyTime(b.getApplyTime());
		if(b.getState() != null) setState(b.getState());
		if(b.getAuditor() != null) setAuditor(b.getAuditor());
		if(b.getAuditingTime() != null) setAuditingTime(b.getAuditingTime());
		if(b.getOpinion() != null) setOpinion(b.getOpinion());
		if(b.getIsLevelTwo() != null) setIsLevelTwo(b.getIsLevelTwo());
	}

	@Override
	public BaseBonusPaymentRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBonusPaymentRecord b = new BaseBonusPaymentRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBonusPaymentRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicant(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setState(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAuditor(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAuditingTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOpinion(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLevelTwo(GenericBase.__getBoolean(val));
	}

	public void setBonusPaymentRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBonusPaymentRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBonusPaymentRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPayIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getPayIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setPayDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getPayDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setApplicant(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getApplicant() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setApplyTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getApplyTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setState(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getState() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setAuditor(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getAuditor() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setAuditingTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getAuditingTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setOpinion(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getOpinion() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setIsLevelTwo(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getIsLevelTwo() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setConditionBonusPaymentRecordId(String op, java.lang.Integer val) {
		setConditionBonusPaymentRecordId(op, val, CONDITION_AND);
	}

	public void setConditionBonusPaymentRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBonusPaymentRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPayIntegral(String op, java.math.BigDecimal val) {
		setConditionPayIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPayIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPayIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPayDate(String op, java.util.Date val) {
		setConditionPayDate(op, val, CONDITION_AND);
	}

	public void setConditionPayDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPayDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionApplicant(String op, java.lang.Integer val) {
		setConditionApplicant(op, val, CONDITION_AND);
	}

	public void setConditionApplicant(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectApplicant(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionApplyTime(String op, java.util.Date val) {
		setConditionApplyTime(op, val, CONDITION_AND);
	}

	public void setConditionApplyTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectApplyTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionState(String op, java.lang.Integer val) {
		setConditionState(op, val, CONDITION_AND);
	}

	public void setConditionState(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectState(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAuditor(String op, java.lang.Integer val) {
		setConditionAuditor(op, val, CONDITION_AND);
	}

	public void setConditionAuditor(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAuditor(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAuditingTime(String op, java.util.Date val) {
		setConditionAuditingTime(op, val, CONDITION_AND);
	}

	public void setConditionAuditingTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAuditingTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOpinion(String op, java.lang.String val) {
		setConditionOpinion(op, val, CONDITION_AND);
	}

	public void setConditionOpinion(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOpinion(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionIsLevelTwo(String op, java.lang.Boolean val) {
		setConditionIsLevelTwo(op, val, CONDITION_AND);
	}

	public void setConditionIsLevelTwo(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIsLevelTwo(boolean val) {
		__select_flags[11] = val;
	}


}

