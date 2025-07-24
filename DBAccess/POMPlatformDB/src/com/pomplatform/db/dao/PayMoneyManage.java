package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BasePayMoneyManage;


public class PayMoneyManage extends AbstractTable<BasePayMoneyManage>
{

	public PayMoneyManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 34;

		initTables();

		__tableName            = "pay_money_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePayMoneyManage.CS_PAY_MONEY_MANAGE_ID;
		__column_names[1] = BasePayMoneyManage.CS_RECEIVE_UNIT;
		__column_names[2] = BasePayMoneyManage.CS_BANK_ACCOUNT;
		__column_names[3] = BasePayMoneyManage.CS_BANK_NAME;
		__column_names[4] = BasePayMoneyManage.CS_TITLE_NAME;
		__column_names[5] = BasePayMoneyManage.CS_PAY_AMOUNT;
		__column_names[6] = BasePayMoneyManage.CS_EMPLOYEE_ID;
		__column_names[7] = BasePayMoneyManage.CS_DEPARTMENT_ID;
		__column_names[8] = BasePayMoneyManage.CS_ATTACHMENT_FILE;
		__column_names[9] = BasePayMoneyManage.CS_REASON;
		__column_names[10] = BasePayMoneyManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[11] = BasePayMoneyManage.CS_OPERATE_TIME;
		__column_names[12] = BasePayMoneyManage.CS_COMPANY_ID;
		__column_names[13] = BasePayMoneyManage.CS_CODE;
		__column_names[14] = BasePayMoneyManage.CS_DELETE_FLAG;
		__column_names[15] = BasePayMoneyManage.CS_IS_COMPLETED;
		__column_names[16] = BasePayMoneyManage.CS_BE_PACKED;
		__column_names[17] = BasePayMoneyManage.CS_VOUCHER_NO;
		__column_names[18] = BasePayMoneyManage.CS_POSTING_DATE;
		__column_names[19] = BasePayMoneyManage.CS_CURRENCY;
		__column_names[20] = BasePayMoneyManage.CS_EXCHANGE_RATE;
		__column_names[21] = BasePayMoneyManage.CS_PROJECT_ID;
		__column_names[22] = BasePayMoneyManage.CS_PAYMENT_SEQUENCE_ID;
		__column_names[23] = BasePayMoneyManage.CS_BUDGET_MANAGEMENT_ID;
		__column_names[24] = BasePayMoneyManage.CS_BUDGET_ATTACHMENT_ID;
		__column_names[25] = BasePayMoneyManage.CS_ATTACHMENT_ID;
		__column_names[26] = BasePayMoneyManage.CS_ATTACHMENT_NAME;
		__column_names[27] = BasePayMoneyManage.CS_USE_OF_FUND;
		__column_names[28] = BasePayMoneyManage.CS_RELATED_TO_CONTRACT;
		__column_names[29] = BasePayMoneyManage.CS_CONTRACT_AMOUNT;
		__column_names[30] = BasePayMoneyManage.CS_RECEIVE_UNIT_ID;
		__column_names[31] = BasePayMoneyManage.CS_PURCHASER_DEPARTMENT;
		__column_names[32] = BasePayMoneyManage.CS_PURCHASER;
		__column_names[33] = BasePayMoneyManage.CS_PURCHASING_CATEGORY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePayMoneyManage b) {
		clear();
		setPayMoneyManageIdClear(b.getPayMoneyManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getPayMoneyManageId() == null;
	}

	@Override
	public BasePayMoneyManage generateBase(){
		BasePayMoneyManage b = new BasePayMoneyManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePayMoneyManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPayMoneyManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTitleName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentFile(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBePacked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setVoucherNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPostingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCurrency(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUseOfFund(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRelatedToContract(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaserDepartment(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaser(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchasingCategory(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePayMoneyManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPayMoneyManageId();
		buff[count++] = b.getReceiveUnit();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getBankName();
		buff[count++] = b.getTitleName();
		buff[count++] = b.getPayAmount();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getAttachmentFile();
		buff[count++] = b.getReason();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCode();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getBePacked();
		buff[count++] = b.getVoucherNo();
		buff[count++] = generateTimestampFromDate(b.getPostingDate());
		buff[count++] = b.getCurrency();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getPaymentSequenceId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getUseOfFund();
		buff[count++] = b.getRelatedToContract();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getReceiveUnitId();
		buff[count++] = b.getPurchaserDepartment();
		buff[count++] = b.getPurchaser();
		buff[count++] = b.getPurchasingCategory();
	}

	@Override
	public void setDataFromBase(BasePayMoneyManage b){
		if(b.getPayMoneyManageId() != null) setPayMoneyManageIdClear(b.getPayMoneyManageId());
		if(b.getReceiveUnit() != null) setReceiveUnit(b.getReceiveUnit());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getBankName() != null) setBankName(b.getBankName());
		if(b.getTitleName() != null) setTitleName(b.getTitleName());
		if(b.getPayAmount() != null) setPayAmount(b.getPayAmount());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getAttachmentFile() != null) setAttachmentFile(b.getAttachmentFile());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getBePacked() != null) setBePacked(b.getBePacked());
		if(b.getVoucherNo() != null) setVoucherNo(b.getVoucherNo());
		if(b.getPostingDate() != null) setPostingDate(b.getPostingDate());
		if(b.getCurrency() != null) setCurrency(b.getCurrency());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getPaymentSequenceId() != null) setPaymentSequenceId(b.getPaymentSequenceId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentId(b.getBudgetAttachmentId());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getUseOfFund() != null) setUseOfFund(b.getUseOfFund());
		if(b.getRelatedToContract() != null) setRelatedToContract(b.getRelatedToContract());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getReceiveUnitId() != null) setReceiveUnitId(b.getReceiveUnitId());
		if(b.getPurchaserDepartment() != null) setPurchaserDepartment(b.getPurchaserDepartment());
		if(b.getPurchaser() != null) setPurchaser(b.getPurchaser());
		if(b.getPurchasingCategory() != null) setPurchasingCategory(b.getPurchasingCategory());
	}

	@Override
	public BasePayMoneyManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePayMoneyManage b = new BasePayMoneyManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePayMoneyManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayMoneyManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitleName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBePacked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPostingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrency(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUseOfFund(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelatedToContract(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaserDepartment(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaser(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasingCategory(GenericBase.__getString(val));
	}

	public void setPayMoneyManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPayMoneyManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPayMoneyManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setReceiveUnit(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getReceiveUnit() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setBankName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getBankName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTitleName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getTitleName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setPayAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPayAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setAttachmentFile(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getAttachmentFile() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(15, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[15]);
	}

	public void setBePacked(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getBePacked() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setVoucherNo(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getVoucherNo() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setPostingDate(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getPostingDate() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setCurrency(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getCurrency() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setPaymentSequenceId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getPaymentSequenceId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setUseOfFund(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getUseOfFund() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setRelatedToContract(java.lang.Boolean val) {
		setCurrentData(28, val);
	}

	public java.lang.Boolean getRelatedToContract() {
		return GenericBase.__getBoolean(__current_data[28]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setReceiveUnitId(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getReceiveUnitId() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setPurchaserDepartment(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getPurchaserDepartment() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setPurchaser(java.lang.Integer val) {
		setCurrentData(32, val);
	}

	public java.lang.Integer getPurchaser() {
		return GenericBase.__getInt(__current_data[32]);
	}

	public void setPurchasingCategory(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getPurchasingCategory() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setConditionPayMoneyManageId(String op, java.lang.Integer val) {
		setConditionPayMoneyManageId(op, val, CONDITION_AND);
	}

	public void setConditionPayMoneyManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPayMoneyManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionReceiveUnit(String op, java.lang.String val) {
		setConditionReceiveUnit(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnit(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectReceiveUnit(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBankName(String op, java.lang.String val) {
		setConditionBankName(op, val, CONDITION_AND);
	}

	public void setConditionBankName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBankName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTitleName(String op, java.lang.String val) {
		setConditionTitleName(op, val, CONDITION_AND);
	}

	public void setConditionTitleName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTitleName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPayAmount(String op, java.math.BigDecimal val) {
		setConditionPayAmount(op, val, CONDITION_AND);
	}

	public void setConditionPayAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPayAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAttachmentFile(String op, java.lang.String val) {
		setConditionAttachmentFile(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentFile(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAttachmentFile(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionBePacked(String op, java.lang.Boolean val) {
		setConditionBePacked(op, val, CONDITION_AND);
	}

	public void setConditionBePacked(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectBePacked(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionVoucherNo(String op, java.lang.String val) {
		setConditionVoucherNo(op, val, CONDITION_AND);
	}

	public void setConditionVoucherNo(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectVoucherNo(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionPostingDate(String op, java.util.Date val) {
		setConditionPostingDate(op, val, CONDITION_AND);
	}

	public void setConditionPostingDate(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPostingDate(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCurrency(String op, java.lang.Integer val) {
		setConditionCurrency(op, val, CONDITION_AND);
	}

	public void setConditionCurrency(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectCurrency(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val) {
		setConditionPaymentSequenceId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectPaymentSequenceId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionUseOfFund(String op, java.lang.Integer val) {
		setConditionUseOfFund(op, val, CONDITION_AND);
	}

	public void setConditionUseOfFund(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectUseOfFund(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionRelatedToContract(String op, java.lang.Boolean val) {
		setConditionRelatedToContract(op, val, CONDITION_AND);
	}

	public void setConditionRelatedToContract(String op, java.lang.Boolean val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectRelatedToContract(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val) {
		setConditionReceiveUnitId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectReceiveUnitId(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionPurchaserDepartment(String op, java.lang.Integer val) {
		setConditionPurchaserDepartment(op, val, CONDITION_AND);
	}

	public void setConditionPurchaserDepartment(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectPurchaserDepartment(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionPurchaser(String op, java.lang.Integer val) {
		setConditionPurchaser(op, val, CONDITION_AND);
	}

	public void setConditionPurchaser(String op, java.lang.Integer val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectPurchaser(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionPurchasingCategory(String op, java.lang.String val) {
		setConditionPurchasingCategory(op, val, CONDITION_AND);
	}

	public void setConditionPurchasingCategory(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectPurchasingCategory(boolean val) {
		__select_flags[33] = val;
	}


}

