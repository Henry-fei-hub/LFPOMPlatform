package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseTravelReimbursement;


public class TravelReimbursement extends AbstractTable<BaseTravelReimbursement>
{

	public TravelReimbursement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 39;

		initTables();

		__tableName            = "travel_reimbursements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTravelReimbursement.CS_TRAVEL_REIMBURSEMENT_ID;
		__column_names[1] = BaseTravelReimbursement.CS_CODE;
		__column_names[2] = BaseTravelReimbursement.CS_PROCESS_INSTANCE_ID;
		__column_names[3] = BaseTravelReimbursement.CS_TITLE;
		__column_names[4] = BaseTravelReimbursement.CS_APPLICANT;
		__column_names[5] = BaseTravelReimbursement.CS_DRAFTER;
		__column_names[6] = BaseTravelReimbursement.CS_DEPARTMENT_ID;
		__column_names[7] = BaseTravelReimbursement.CS_REIMBURSEMENT_TIME;
		__column_names[8] = BaseTravelReimbursement.CS_START_DATE;
		__column_names[9] = BaseTravelReimbursement.CS_END_DATE;
		__column_names[10] = BaseTravelReimbursement.CS_AMOUNT;
		__column_names[11] = BaseTravelReimbursement.CS_STRIKE_A_BALANCE;
		__column_names[12] = BaseTravelReimbursement.CS_REMARK;
		__column_names[13] = BaseTravelReimbursement.CS_APPLY_TIME;
		__column_names[14] = BaseTravelReimbursement.CS_COMPLETE_TIME;
		__column_names[15] = BaseTravelReimbursement.CS_ATTACHMENT;
		__column_names[16] = BaseTravelReimbursement.CS_ATTACHMENT_NUMBER;
		__column_names[17] = BaseTravelReimbursement.CS_STATUS;
		__column_names[18] = BaseTravelReimbursement.CS_COMPANY_ID;
		__column_names[19] = BaseTravelReimbursement.CS_IS_PROJECT;
		__column_names[20] = BaseTravelReimbursement.CS_DELETE_FLAG;
		__column_names[21] = BaseTravelReimbursement.CS_CURRENCY;
		__column_names[22] = BaseTravelReimbursement.CS_IS_COMPLETED;
		__column_names[23] = BaseTravelReimbursement.CS_BE_PACKED;
		__column_names[24] = BaseTravelReimbursement.CS_VOUCHER_NO;
		__column_names[25] = BaseTravelReimbursement.CS_POSTING_DATE;
		__column_names[26] = BaseTravelReimbursement.CS_EXCHANGE_RATE;
		__column_names[27] = BaseTravelReimbursement.CS_PAYMENT_SEQUENCE_ID;
		__column_names[28] = BaseTravelReimbursement.CS_BUDGET_MANAGEMENT_ID;
		__column_names[29] = BaseTravelReimbursement.CS_BUDGET_ATTACHMENT_ID;
		__column_names[30] = BaseTravelReimbursement.CS_WHITE_STRIP;
		__column_names[31] = BaseTravelReimbursement.CS_ATTACHMENT_ID;
		__column_names[32] = BaseTravelReimbursement.CS_ATTACHMENT_NAME;
		__column_names[33] = BaseTravelReimbursement.CS_RELATED_TO_CONTRACT;
		__column_names[34] = BaseTravelReimbursement.CS_CONTRACT_AMOUNT;
		__column_names[35] = BaseTravelReimbursement.CS_RECEIVE_UNIT_ID;
		__column_names[36] = BaseTravelReimbursement.CS_PURCHASER_DEPARTMENT;
		__column_names[37] = BaseTravelReimbursement.CS_PURCHASER;
		__column_names[38] = BaseTravelReimbursement.CS_PURCHASING_CATEGORY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTravelReimbursement b) {
		clear();
		setTravelReimbursementIdClear(b.getTravelReimbursementId());
	}

	public boolean isPrimaryKeyNull() {
		return getTravelReimbursementId() == null;
	}

	@Override
	public BaseTravelReimbursement generateBase(){
		BaseTravelReimbursement b = new BaseTravelReimbursement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTravelReimbursement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTravelReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setApplicant(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDrafter(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStrikeABalance(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCurrency(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBePacked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setVoucherNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPostingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWhiteStrip(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelatedToContract(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaserDepartment(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaser(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchasingCategory(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTravelReimbursement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTravelReimbursementId();
		buff[count++] = b.getCode();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getTitle();
		buff[count++] = b.getApplicant();
		buff[count++] = b.getDrafter();
		buff[count++] = b.getDepartmentId();
		buff[count++] = generateTimestampFromDate(b.getReimbursementTime());
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getAmount();
		buff[count++] = b.getStrikeABalance();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getApplyTime());
		buff[count++] = generateTimestampFromDate(b.getCompleteTime());
		buff[count++] = b.getAttachment();
		buff[count++] = b.getAttachmentNumber();
		buff[count++] = b.getStatus();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getIsProject();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getCurrency();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getBePacked();
		buff[count++] = b.getVoucherNo();
		buff[count++] = generateTimestampFromDate(b.getPostingDate());
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getPaymentSequenceId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getWhiteStrip();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getRelatedToContract();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getReceiveUnitId();
		buff[count++] = b.getPurchaserDepartment();
		buff[count++] = b.getPurchaser();
		buff[count++] = b.getPurchasingCategory();
	}

	@Override
	public void setDataFromBase(BaseTravelReimbursement b){
		if(b.getTravelReimbursementId() != null) setTravelReimbursementIdClear(b.getTravelReimbursementId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getTitle() != null) setTitle(b.getTitle());
		if(b.getApplicant() != null) setApplicant(b.getApplicant());
		if(b.getDrafter() != null) setDrafter(b.getDrafter());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getReimbursementTime() != null) setReimbursementTime(b.getReimbursementTime());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getStrikeABalance() != null) setStrikeABalance(b.getStrikeABalance());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getApplyTime() != null) setApplyTime(b.getApplyTime());
		if(b.getCompleteTime() != null) setCompleteTime(b.getCompleteTime());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
		if(b.getAttachmentNumber() != null) setAttachmentNumber(b.getAttachmentNumber());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getIsProject() != null) setIsProject(b.getIsProject());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCurrency() != null) setCurrency(b.getCurrency());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getBePacked() != null) setBePacked(b.getBePacked());
		if(b.getVoucherNo() != null) setVoucherNo(b.getVoucherNo());
		if(b.getPostingDate() != null) setPostingDate(b.getPostingDate());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getPaymentSequenceId() != null) setPaymentSequenceId(b.getPaymentSequenceId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentId(b.getBudgetAttachmentId());
		if(b.getWhiteStrip() != null) setWhiteStrip(b.getWhiteStrip());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getRelatedToContract() != null) setRelatedToContract(b.getRelatedToContract());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getReceiveUnitId() != null) setReceiveUnitId(b.getReceiveUnitId());
		if(b.getPurchaserDepartment() != null) setPurchaserDepartment(b.getPurchaserDepartment());
		if(b.getPurchaser() != null) setPurchaser(b.getPurchaser());
		if(b.getPurchasingCategory() != null) setPurchasingCategory(b.getPurchasingCategory());
	}

	@Override
	public BaseTravelReimbursement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTravelReimbursement b = new BaseTravelReimbursement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTravelReimbursement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicant(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDrafter(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStrikeABalance(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrency(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBePacked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPostingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWhiteStrip(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelatedToContract(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaserDepartment(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaser(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasingCategory(GenericBase.__getString(val));
	}

	public void setTravelReimbursementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTravelReimbursementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTravelReimbursementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTitle(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getTitle() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setApplicant(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getApplicant() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDrafter(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDrafter() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setReimbursementTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getReimbursementTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setStrikeABalance(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getStrikeABalance() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setApplyTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getApplyTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setCompleteTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getCompleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setAttachmentNumber(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getAttachmentNumber() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setIsProject(java.lang.Boolean val) {
		setCurrentData(19, val);
	}

	public java.lang.Boolean getIsProject() {
		return GenericBase.__getBoolean(__current_data[19]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setCurrency(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getCurrency() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setBePacked(java.lang.Boolean val) {
		setCurrentData(23, val);
	}

	public java.lang.Boolean getBePacked() {
		return GenericBase.__getBoolean(__current_data[23]);
	}

	public void setVoucherNo(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getVoucherNo() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setPostingDate(java.util.Date val) {
		setCurrentData(25, generateTimestampFromDate(val));
	}

	public java.util.Date getPostingDate() {
		return GenericBase.__getDateFromSQL(__current_data[25]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setPaymentSequenceId(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getPaymentSequenceId() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setWhiteStrip(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getWhiteStrip() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setRelatedToContract(java.lang.Boolean val) {
		setCurrentData(33, val);
	}

	public java.lang.Boolean getRelatedToContract() {
		return GenericBase.__getBoolean(__current_data[33]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(34, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[34]);
	}

	public void setReceiveUnitId(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getReceiveUnitId() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setPurchaserDepartment(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getPurchaserDepartment() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setPurchaser(java.lang.Integer val) {
		setCurrentData(37, val);
	}

	public java.lang.Integer getPurchaser() {
		return GenericBase.__getInt(__current_data[37]);
	}

	public void setPurchasingCategory(java.lang.String val) {
		setCurrentData(38, val);
	}

	public java.lang.String getPurchasingCategory() {
		return GenericBase.__getString(__current_data[38]);
	}

	public void setConditionTravelReimbursementId(String op, java.lang.Integer val) {
		setConditionTravelReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionTravelReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTravelReimbursementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTitle(String op, java.lang.String val) {
		setConditionTitle(op, val, CONDITION_AND);
	}

	public void setConditionTitle(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTitle(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionApplicant(String op, java.lang.Integer val) {
		setConditionApplicant(op, val, CONDITION_AND);
	}

	public void setConditionApplicant(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectApplicant(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDrafter(String op, java.lang.Integer val) {
		setConditionDrafter(op, val, CONDITION_AND);
	}

	public void setConditionDrafter(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDrafter(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionReimbursementTime(String op, java.util.Date val) {
		setConditionReimbursementTime(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReimbursementTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionStrikeABalance(String op, java.lang.Boolean val) {
		setConditionStrikeABalance(op, val, CONDITION_AND);
	}

	public void setConditionStrikeABalance(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectStrikeABalance(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionApplyTime(String op, java.util.Date val) {
		setConditionApplyTime(op, val, CONDITION_AND);
	}

	public void setConditionApplyTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectApplyTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCompleteTime(String op, java.util.Date val) {
		setConditionCompleteTime(op, val, CONDITION_AND);
	}

	public void setConditionCompleteTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompleteTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionAttachmentNumber(String op, java.lang.Integer val) {
		setConditionAttachmentNumber(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentNumber(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectAttachmentNumber(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionIsProject(String op, java.lang.Boolean val) {
		setConditionIsProject(op, val, CONDITION_AND);
	}

	public void setConditionIsProject(String op, java.lang.Boolean val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectIsProject(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCurrency(String op, java.lang.Integer val) {
		setConditionCurrency(op, val, CONDITION_AND);
	}

	public void setConditionCurrency(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectCurrency(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionBePacked(String op, java.lang.Boolean val) {
		setConditionBePacked(op, val, CONDITION_AND);
	}

	public void setConditionBePacked(String op, java.lang.Boolean val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectBePacked(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionVoucherNo(String op, java.lang.String val) {
		setConditionVoucherNo(op, val, CONDITION_AND);
	}

	public void setConditionVoucherNo(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectVoucherNo(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionPostingDate(String op, java.util.Date val) {
		setConditionPostingDate(op, val, CONDITION_AND);
	}

	public void setConditionPostingDate(String op, java.util.Date val, String relation) {
		addCondition(25, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPostingDate(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val) {
		setConditionPaymentSequenceId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectPaymentSequenceId(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionWhiteStrip(String op, java.math.BigDecimal val) {
		setConditionWhiteStrip(op, val, CONDITION_AND);
	}

	public void setConditionWhiteStrip(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectWhiteStrip(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionRelatedToContract(String op, java.lang.Boolean val) {
		setConditionRelatedToContract(op, val, CONDITION_AND);
	}

	public void setConditionRelatedToContract(String op, java.lang.Boolean val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectRelatedToContract(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val) {
		setConditionReceiveUnitId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectReceiveUnitId(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionPurchaserDepartment(String op, java.lang.Integer val) {
		setConditionPurchaserDepartment(op, val, CONDITION_AND);
	}

	public void setConditionPurchaserDepartment(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectPurchaserDepartment(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionPurchaser(String op, java.lang.Integer val) {
		setConditionPurchaser(op, val, CONDITION_AND);
	}

	public void setConditionPurchaser(String op, java.lang.Integer val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectPurchaser(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionPurchasingCategory(String op, java.lang.String val) {
		setConditionPurchasingCategory(op, val, CONDITION_AND);
	}

	public void setConditionPurchasingCategory(String op, java.lang.String val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectPurchasingCategory(boolean val) {
		__select_flags[38] = val;
	}


}

