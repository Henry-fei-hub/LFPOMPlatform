package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePaymentSequence;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PaymentSequence extends AbstractTable<BasePaymentSequence>
{

	public PaymentSequence() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 24;

		initTables();

		__tableName            = "payment_sequence";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePaymentSequence.CS_PAYMENT_SEQUENCE_ID;
		__column_names[1] = BasePaymentSequence.CS_BUDGET_MANAGEMENT_ID;
		__column_names[2] = BasePaymentSequence.CS_BUDGET_ATTACHMENT_ID;
		__column_names[3] = BasePaymentSequence.CS_PAY_AMOUNT;
		__column_names[4] = BasePaymentSequence.CS_PAY_DATE;
		__column_names[5] = BasePaymentSequence.CS_PAY_STATUS;
		__column_names[6] = BasePaymentSequence.CS_PS_REMARK;
		__column_names[7] = BasePaymentSequence.CS_YEAR;
		__column_names[8] = BasePaymentSequence.CS_MONTH;
		__column_names[9] = BasePaymentSequence.CS_RECEIVE_UNIT_MANAGE_ID;
		__column_names[10] = BasePaymentSequence.CS_PROCESS_BILL_LIST_ID;
		__column_names[11] = BasePaymentSequence.CS_PROJECT_ID;
		__column_names[12] = BasePaymentSequence.CS_BIND_STATUS;
		__column_names[13] = BasePaymentSequence.CS_PAY_TYPE;
		__column_names[14] = BasePaymentSequence.CS_IS_LOCK;
		__column_names[15] = BasePaymentSequence.CS_REIMBURSEMENT_AMOUNT;
		__column_names[16] = BasePaymentSequence.CS_REVERSE_AMOUNT;
		__column_names[17] = BasePaymentSequence.CS_APPLY_PAY_DATE;
		__column_names[18] = BasePaymentSequence.CS_RETURN_AMOUNT;
		__column_names[19] = BasePaymentSequence.CS_PAY_FOR;
		__column_names[20] = BasePaymentSequence.CS_PAY_NAME;
		__column_names[21] = BasePaymentSequence.CS_REIMBURSEMENT_CODE;
		__column_names[22] = BasePaymentSequence.CS_PROCESS_TYPE;
		__column_names[23] = BasePaymentSequence.CS_PROCESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePaymentSequence b) {
		clear();
		setPaymentSequenceIdClear(b.getPaymentSequenceId());
	}

	public boolean isPrimaryKeyNull() {
		return getPaymentSequenceId() == null;
	}

	@Override
	public BasePaymentSequence generateBase(){
		BasePaymentSequence b = new BasePaymentSequence();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePaymentSequence b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPayStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPsRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBindStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setReimbursementAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReverseAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setApplyPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setReturnAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayFor(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReimbursementCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePaymentSequence b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPaymentSequenceId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getPayAmount();
		buff[count++] = generateTimestampFromDate(b.getPayDate());
		buff[count++] = b.getPayStatus();
		buff[count++] = b.getPsRemark();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getReceiveUnitManageId();
		buff[count++] = b.getProcessBillListId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getBindStatus();
		buff[count++] = b.getPayType();
		buff[count++] = b.getIsLock();
		buff[count++] = b.getReimbursementAmount();
		buff[count++] = b.getReverseAmount();
		buff[count++] = generateTimestampFromDate(b.getApplyPayDate());
		buff[count++] = b.getReturnAmount();
		buff[count++] = b.getPayFor();
		buff[count++] = b.getPayName();
		buff[count++] = b.getReimbursementCode();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getProcessId();
	}

	@Override
	public void setDataFromBase(BasePaymentSequence b){
		if(b.getPaymentSequenceId() != null) setPaymentSequenceIdClear(b.getPaymentSequenceId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentId(b.getBudgetAttachmentId());
		if(b.getPayAmount() != null) setPayAmount(b.getPayAmount());
		if(b.getPayDate() != null) setPayDate(b.getPayDate());
		if(b.getPayStatus() != null) setPayStatus(b.getPayStatus());
		if(b.getPsRemark() != null) setPsRemark(b.getPsRemark());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getReceiveUnitManageId() != null) setReceiveUnitManageId(b.getReceiveUnitManageId());
		if(b.getProcessBillListId() != null) setProcessBillListId(b.getProcessBillListId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getBindStatus() != null) setBindStatus(b.getBindStatus());
		if(b.getPayType() != null) setPayType(b.getPayType());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getReimbursementAmount() != null) setReimbursementAmount(b.getReimbursementAmount());
		if(b.getReverseAmount() != null) setReverseAmount(b.getReverseAmount());
		if(b.getApplyPayDate() != null) setApplyPayDate(b.getApplyPayDate());
		if(b.getReturnAmount() != null) setReturnAmount(b.getReturnAmount());
		if(b.getPayFor() != null) setPayFor(b.getPayFor());
		if(b.getPayName() != null) setPayName(b.getPayName());
		if(b.getReimbursementCode() != null) setReimbursementCode(b.getReimbursementCode());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
	}

	@Override
	public BasePaymentSequence generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePaymentSequence b = new BasePaymentSequence();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePaymentSequence __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPsRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBindStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReverseAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyPayDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayFor(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
	}

	public void setPaymentSequenceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPaymentSequenceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPaymentSequenceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPayAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPayAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setPayDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getPayDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setPayStatus(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPayStatus() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPsRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getPsRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setReceiveUnitManageId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProcessBillListId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProcessBillListId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setBindStatus(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getBindStatus() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setPayType(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getPayType() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setReimbursementAmount(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getReimbursementAmount() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setReverseAmount(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getReverseAmount() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setApplyPayDate(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getApplyPayDate() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setReturnAmount(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getReturnAmount() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setPayFor(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getPayFor() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setPayName(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getPayName() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setReimbursementCode(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getReimbursementCode() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val) {
		setConditionPaymentSequenceId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPaymentSequenceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPayAmount(String op, java.math.BigDecimal val) {
		setConditionPayAmount(op, val, CONDITION_AND);
	}

	public void setConditionPayAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPayAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPayDate(String op, java.util.Date val) {
		setConditionPayDate(op, val, CONDITION_AND);
	}

	public void setConditionPayDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPayDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPayStatus(String op, java.lang.Integer val) {
		setConditionPayStatus(op, val, CONDITION_AND);
	}

	public void setConditionPayStatus(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPayStatus(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPsRemark(String op, java.lang.String val) {
		setConditionPsRemark(op, val, CONDITION_AND);
	}

	public void setConditionPsRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPsRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val) {
		setConditionReceiveUnitManageId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectReceiveUnitManageId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProcessBillListId(String op, java.lang.Integer val) {
		setConditionProcessBillListId(op, val, CONDITION_AND);
	}

	public void setConditionProcessBillListId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProcessBillListId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionBindStatus(String op, java.lang.Integer val) {
		setConditionBindStatus(op, val, CONDITION_AND);
	}

	public void setConditionBindStatus(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectBindStatus(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPayType(String op, java.lang.Integer val) {
		setConditionPayType(op, val, CONDITION_AND);
	}

	public void setConditionPayType(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectPayType(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionReimbursementAmount(String op, java.math.BigDecimal val) {
		setConditionReimbursementAmount(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectReimbursementAmount(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionReverseAmount(String op, java.math.BigDecimal val) {
		setConditionReverseAmount(op, val, CONDITION_AND);
	}

	public void setConditionReverseAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectReverseAmount(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionApplyPayDate(String op, java.util.Date val) {
		setConditionApplyPayDate(op, val, CONDITION_AND);
	}

	public void setConditionApplyPayDate(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectApplyPayDate(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionReturnAmount(String op, java.math.BigDecimal val) {
		setConditionReturnAmount(op, val, CONDITION_AND);
	}

	public void setConditionReturnAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectReturnAmount(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionPayFor(String op, java.lang.Integer val) {
		setConditionPayFor(op, val, CONDITION_AND);
	}

	public void setConditionPayFor(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectPayFor(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionPayName(String op, java.lang.String val) {
		setConditionPayName(op, val, CONDITION_AND);
	}

	public void setConditionPayName(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectPayName(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionReimbursementCode(String op, java.lang.String val) {
		setConditionReimbursementCode(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementCode(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectReimbursementCode(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[23] = val;
	}


}

