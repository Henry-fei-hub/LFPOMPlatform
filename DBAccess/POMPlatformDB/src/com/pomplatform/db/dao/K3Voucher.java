package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseK3Voucher;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class K3Voucher extends AbstractTable<BaseK3Voucher>
{

	public K3Voucher() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 39;

		initTables();

		__tableName            = "k3_vouchers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseK3Voucher.CS_K3_VOUCHER_ID;
		__column_names[1] = BaseK3Voucher.CS_PROJECT_ID;
		__column_names[2] = BaseK3Voucher.CS_COMPANY_ID;
		__column_names[3] = BaseK3Voucher.CS_SEQUENCE_NUMBER;
		__column_names[4] = BaseK3Voucher.CS_INTERNAL_SEQUENCE_NUMBER;
		__column_names[5] = BaseK3Voucher.CS_CODE_TYPE;
		__column_names[6] = BaseK3Voucher.CS_CODE_ID;
		__column_names[7] = BaseK3Voucher.CS_CODE;
		__column_names[8] = BaseK3Voucher.CS_NAME;
		__column_names[9] = BaseK3Voucher.CS_SECONDARY_CODE_TYPE;
		__column_names[10] = BaseK3Voucher.CS_SECONDARY_CODE_ID;
		__column_names[11] = BaseK3Voucher.CS_SECONDARY_CODE;
		__column_names[12] = BaseK3Voucher.CS_SECONDARY_NAME;
		__column_names[13] = BaseK3Voucher.CS_REMARK;
		__column_names[14] = BaseK3Voucher.CS_SIMPLIFY_REMARK;
		__column_names[15] = BaseK3Voucher.CS_DEBIT_SIDE;
		__column_names[16] = BaseK3Voucher.CS_CREDIT_SIDE;
		__column_names[17] = BaseK3Voucher.CS_REIMBURSEMENT_PACKAGE_CODE;
		__column_names[18] = BaseK3Voucher.CS_AMOUNT_OF_REIMBURSEMENT;
		__column_names[19] = BaseK3Voucher.CS_INPUT_TAX;
		__column_names[20] = BaseK3Voucher.CS_SELF_BANK_ACCOUNT;
		__column_names[21] = BaseK3Voucher.CS_OTHER_BANK_ACCOUNT;
		__column_names[22] = BaseK3Voucher.CS_NEED_TO_CHANGE;
		__column_names[23] = BaseK3Voucher.CS_VESTING_DATE;
		__column_names[24] = BaseK3Voucher.CS_LOCKED;
		__column_names[25] = BaseK3Voucher.CS_CREATE_TIME;
		__column_names[26] = BaseK3Voucher.CS_UPDATE_TIME;
		__column_names[27] = BaseK3Voucher.CS_LOCKED_TIME;
		__column_names[28] = BaseK3Voucher.CS_VOUCHER_TYPE;
		__column_names[29] = BaseK3Voucher.CS_LINK_ID;
		__column_names[30] = BaseK3Voucher.CS_ADDITIONAL_LINK_ID;
		__column_names[31] = BaseK3Voucher.CS_INPUT_TAX_REBATE;
		__column_names[32] = BaseK3Voucher.CS_VOUCHER_YEAR;
		__column_names[33] = BaseK3Voucher.CS_VOUCHER_MONTH;
		__column_names[34] = BaseK3Voucher.CS_PROCESS_TYPE;
		__column_names[35] = BaseK3Voucher.CS_PROCESS_ID;
		__column_names[36] = BaseK3Voucher.CS_PROCESS_INSTANCE_ID;
		__column_names[37] = BaseK3Voucher.CS_BUSINESS_ID;
		__column_names[38] = BaseK3Voucher.CS_REIMBURSEMENT_PACKAGE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseK3Voucher b) {
		clear();
		setK3VoucherIdClear(b.getK3VoucherId());
	}

	public boolean isPrimaryKeyNull() {
		return getK3VoucherId() == null;
	}

	@Override
	public BaseK3Voucher generateBase(){
		BaseK3Voucher b = new BaseK3Voucher();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseK3Voucher b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setK3VoucherId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSequenceNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInternalSequenceNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCodeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCodeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSecondaryCodeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSecondaryCodeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSecondaryCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSecondaryName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSimplifyRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDebitSide(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreditSide(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmountOfReimbursement(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNeedToChange(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLockedTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setVoucherType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAdditionalLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setVoucherYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVoucherMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseK3Voucher b, Object[] buff){
		int count = 0;
		buff[count++] = b.getK3VoucherId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getSequenceNumber();
		buff[count++] = b.getInternalSequenceNumber();
		buff[count++] = b.getCodeType();
		buff[count++] = b.getCodeId();
		buff[count++] = b.getCode();
		buff[count++] = b.getName();
		buff[count++] = b.getSecondaryCodeType();
		buff[count++] = b.getSecondaryCodeId();
		buff[count++] = b.getSecondaryCode();
		buff[count++] = b.getSecondaryName();
		buff[count++] = b.getRemark();
		buff[count++] = b.getSimplifyRemark();
		buff[count++] = b.getDebitSide();
		buff[count++] = b.getCreditSide();
		buff[count++] = b.getReimbursementPackageCode();
		buff[count++] = b.getAmountOfReimbursement();
		buff[count++] = b.getInputTax();
		buff[count++] = b.getSelfBankAccount();
		buff[count++] = b.getOtherBankAccount();
		buff[count++] = b.getNeedToChange();
		buff[count++] = generateTimestampFromDate(b.getVestingDate());
		buff[count++] = b.getLocked();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = generateTimestampFromDate(b.getLockedTime());
		buff[count++] = b.getVoucherType();
		buff[count++] = b.getLinkId();
		buff[count++] = b.getAdditionalLinkId();
		buff[count++] = b.getInputTaxRebate();
		buff[count++] = b.getVoucherYear();
		buff[count++] = b.getVoucherMonth();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getProcessId();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getReimbursementPackageId();
	}

	@Override
	public void setDataFromBase(BaseK3Voucher b){
		if(b.getK3VoucherId() != null) setK3VoucherIdClear(b.getK3VoucherId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getSequenceNumber() != null) setSequenceNumber(b.getSequenceNumber());
		if(b.getInternalSequenceNumber() != null) setInternalSequenceNumber(b.getInternalSequenceNumber());
		if(b.getCodeType() != null) setCodeType(b.getCodeType());
		if(b.getCodeId() != null) setCodeId(b.getCodeId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getSecondaryCodeType() != null) setSecondaryCodeType(b.getSecondaryCodeType());
		if(b.getSecondaryCodeId() != null) setSecondaryCodeId(b.getSecondaryCodeId());
		if(b.getSecondaryCode() != null) setSecondaryCode(b.getSecondaryCode());
		if(b.getSecondaryName() != null) setSecondaryName(b.getSecondaryName());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getSimplifyRemark() != null) setSimplifyRemark(b.getSimplifyRemark());
		if(b.getDebitSide() != null) setDebitSide(b.getDebitSide());
		if(b.getCreditSide() != null) setCreditSide(b.getCreditSide());
		if(b.getReimbursementPackageCode() != null) setReimbursementPackageCode(b.getReimbursementPackageCode());
		if(b.getAmountOfReimbursement() != null) setAmountOfReimbursement(b.getAmountOfReimbursement());
		if(b.getInputTax() != null) setInputTax(b.getInputTax());
		if(b.getSelfBankAccount() != null) setSelfBankAccount(b.getSelfBankAccount());
		if(b.getOtherBankAccount() != null) setOtherBankAccount(b.getOtherBankAccount());
		if(b.getNeedToChange() != null) setNeedToChange(b.getNeedToChange());
		if(b.getVestingDate() != null) setVestingDate(b.getVestingDate());
		if(b.getLocked() != null) setLocked(b.getLocked());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getLockedTime() != null) setLockedTime(b.getLockedTime());
		if(b.getVoucherType() != null) setVoucherType(b.getVoucherType());
		if(b.getLinkId() != null) setLinkId(b.getLinkId());
		if(b.getAdditionalLinkId() != null) setAdditionalLinkId(b.getAdditionalLinkId());
		if(b.getInputTaxRebate() != null) setInputTaxRebate(b.getInputTaxRebate());
		if(b.getVoucherYear() != null) setVoucherYear(b.getVoucherYear());
		if(b.getVoucherMonth() != null) setVoucherMonth(b.getVoucherMonth());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getReimbursementPackageId() != null) setReimbursementPackageId(b.getReimbursementPackageId());
	}

	@Override
	public BaseK3Voucher generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseK3Voucher b = new BaseK3Voucher();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseK3Voucher __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setK3VoucherId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSequenceNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInternalSequenceNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecondaryCodeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecondaryCodeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecondaryCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecondaryName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSimplifyRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDebitSide(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreditSide(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmountOfReimbursement(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNeedToChange(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLockedTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdditionalLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
	}

	public void setK3VoucherId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getK3VoucherId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setK3VoucherIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSequenceNumber(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSequenceNumber() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setInternalSequenceNumber(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getInternalSequenceNumber() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCodeType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCodeType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCodeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCodeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setSecondaryCodeType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getSecondaryCodeType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setSecondaryCodeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSecondaryCodeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSecondaryCode(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSecondaryCode() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setSecondaryName(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getSecondaryName() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setSimplifyRemark(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getSimplifyRemark() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setDebitSide(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getDebitSide() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setCreditSide(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getCreditSide() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setReimbursementPackageCode(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getReimbursementPackageCode() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setAmountOfReimbursement(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getAmountOfReimbursement() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setInputTax(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getInputTax() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setSelfBankAccount(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getSelfBankAccount() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setOtherBankAccount(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getOtherBankAccount() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setNeedToChange(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getNeedToChange() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setVestingDate(java.util.Date val) {
		setCurrentData(23, generateTimestampFromDate(val));
	}

	public java.util.Date getVestingDate() {
		return GenericBase.__getDateFromSQL(__current_data[23]);
	}

	public void setLocked(java.lang.Boolean val) {
		setCurrentData(24, val);
	}

	public java.lang.Boolean getLocked() {
		return GenericBase.__getBoolean(__current_data[24]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(25, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[25]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(26, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[26]);
	}

	public void setLockedTime(java.util.Date val) {
		setCurrentData(27, generateTimestampFromDate(val));
	}

	public java.util.Date getLockedTime() {
		return GenericBase.__getDateFromSQL(__current_data[27]);
	}

	public void setVoucherType(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getVoucherType() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setLinkId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getLinkId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setAdditionalLinkId(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getAdditionalLinkId() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setInputTaxRebate(java.math.BigDecimal val) {
		setCurrentData(31, val);
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return GenericBase.__getDecimal(__current_data[31]);
	}

	public void setVoucherYear(java.lang.Integer val) {
		setCurrentData(32, val);
	}

	public java.lang.Integer getVoucherYear() {
		return GenericBase.__getInt(__current_data[32]);
	}

	public void setVoucherMonth(java.lang.Integer val) {
		setCurrentData(33, val);
	}

	public java.lang.Integer getVoucherMonth() {
		return GenericBase.__getInt(__current_data[33]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(34, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[34]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(37, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[37]);
	}

	public void setReimbursementPackageId(java.lang.Integer val) {
		setCurrentData(38, val);
	}

	public java.lang.Integer getReimbursementPackageId() {
		return GenericBase.__getInt(__current_data[38]);
	}

	public void setConditionK3VoucherId(String op, java.lang.Integer val) {
		setConditionK3VoucherId(op, val, CONDITION_AND);
	}

	public void setConditionK3VoucherId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectK3VoucherId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
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

	public void setConditionSequenceNumber(String op, java.lang.Integer val) {
		setConditionSequenceNumber(op, val, CONDITION_AND);
	}

	public void setConditionSequenceNumber(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSequenceNumber(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInternalSequenceNumber(String op, java.lang.Integer val) {
		setConditionInternalSequenceNumber(op, val, CONDITION_AND);
	}

	public void setConditionInternalSequenceNumber(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInternalSequenceNumber(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCodeType(String op, java.lang.Integer val) {
		setConditionCodeType(op, val, CONDITION_AND);
	}

	public void setConditionCodeType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCodeType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCodeId(String op, java.lang.Integer val) {
		setConditionCodeId(op, val, CONDITION_AND);
	}

	public void setConditionCodeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCodeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSecondaryCodeType(String op, java.lang.Integer val) {
		setConditionSecondaryCodeType(op, val, CONDITION_AND);
	}

	public void setConditionSecondaryCodeType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSecondaryCodeType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSecondaryCodeId(String op, java.lang.Integer val) {
		setConditionSecondaryCodeId(op, val, CONDITION_AND);
	}

	public void setConditionSecondaryCodeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSecondaryCodeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSecondaryCode(String op, java.lang.String val) {
		setConditionSecondaryCode(op, val, CONDITION_AND);
	}

	public void setConditionSecondaryCode(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSecondaryCode(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSecondaryName(String op, java.lang.String val) {
		setConditionSecondaryName(op, val, CONDITION_AND);
	}

	public void setConditionSecondaryName(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSecondaryName(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionSimplifyRemark(String op, java.lang.String val) {
		setConditionSimplifyRemark(op, val, CONDITION_AND);
	}

	public void setConditionSimplifyRemark(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectSimplifyRemark(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDebitSide(String op, java.math.BigDecimal val) {
		setConditionDebitSide(op, val, CONDITION_AND);
	}

	public void setConditionDebitSide(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDebitSide(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCreditSide(String op, java.math.BigDecimal val) {
		setConditionCreditSide(op, val, CONDITION_AND);
	}

	public void setConditionCreditSide(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCreditSide(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionReimbursementPackageCode(String op, java.lang.String val) {
		setConditionReimbursementPackageCode(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageCode(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectReimbursementPackageCode(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionAmountOfReimbursement(String op, java.math.BigDecimal val) {
		setConditionAmountOfReimbursement(op, val, CONDITION_AND);
	}

	public void setConditionAmountOfReimbursement(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectAmountOfReimbursement(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val) {
		setConditionInputTax(op, val, CONDITION_AND);
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectInputTax(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val) {
		setConditionSelfBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectSelfBankAccount(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val) {
		setConditionOtherBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectOtherBankAccount(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionNeedToChange(String op, java.lang.Boolean val) {
		setConditionNeedToChange(op, val, CONDITION_AND);
	}

	public void setConditionNeedToChange(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectNeedToChange(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionVestingDate(String op, java.util.Date val) {
		setConditionVestingDate(op, val, CONDITION_AND);
	}

	public void setConditionVestingDate(String op, java.util.Date val, String relation) {
		addCondition(23, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectVestingDate(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionLocked(String op, java.lang.Boolean val) {
		setConditionLocked(op, val, CONDITION_AND);
	}

	public void setConditionLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectLocked(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(25, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(26, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionLockedTime(String op, java.util.Date val) {
		setConditionLockedTime(op, val, CONDITION_AND);
	}

	public void setConditionLockedTime(String op, java.util.Date val, String relation) {
		addCondition(27, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectLockedTime(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionVoucherType(String op, java.lang.Integer val) {
		setConditionVoucherType(op, val, CONDITION_AND);
	}

	public void setConditionVoucherType(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectVoucherType(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionLinkId(String op, java.lang.Integer val) {
		setConditionLinkId(op, val, CONDITION_AND);
	}

	public void setConditionLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectLinkId(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionAdditionalLinkId(String op, java.lang.Integer val) {
		setConditionAdditionalLinkId(op, val, CONDITION_AND);
	}

	public void setConditionAdditionalLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectAdditionalLinkId(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val) {
		setConditionInputTaxRebate(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectInputTaxRebate(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionVoucherYear(String op, java.lang.Integer val) {
		setConditionVoucherYear(op, val, CONDITION_AND);
	}

	public void setConditionVoucherYear(String op, java.lang.Integer val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectVoucherYear(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionVoucherMonth(String op, java.lang.Integer val) {
		setConditionVoucherMonth(op, val, CONDITION_AND);
	}

	public void setConditionVoucherMonth(String op, java.lang.Integer val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectVoucherMonth(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectReimbursementPackageId(boolean val) {
		__select_flags[38] = val;
	}


}

