package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeMoneyManage extends AbstractTable<BaseEmployeeMoneyManage>
{

	public EmployeeMoneyManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 29;

		initTables();

		__tableName            = "employee_money_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeMoneyManage.CS_EMPLOYEE_MONEY_MANAGE_ID;
		__column_names[1] = BaseEmployeeMoneyManage.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeMoneyManage.CS_DEPARTMENT_ID;
		__column_names[3] = BaseEmployeeMoneyManage.CS_BORROW_MONEY;
		__column_names[4] = BaseEmployeeMoneyManage.CS_RETURN_MONEY;
		__column_names[5] = BaseEmployeeMoneyManage.CS_BORROW_DATE;
		__column_names[6] = BaseEmployeeMoneyManage.CS_ANTICIPATED_DATE;
		__column_names[7] = BaseEmployeeMoneyManage.CS_RETURN_DATE;
		__column_names[8] = BaseEmployeeMoneyManage.CS_TITLE_NAME;
		__column_names[9] = BaseEmployeeMoneyManage.CS_REASON;
		__column_names[10] = BaseEmployeeMoneyManage.CS_FALG;
		__column_names[11] = BaseEmployeeMoneyManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[12] = BaseEmployeeMoneyManage.CS_OPERATE_TIME;
		__column_names[13] = BaseEmployeeMoneyManage.CS_COMPANY_ID;
		__column_names[14] = BaseEmployeeMoneyManage.CS_CODE;
		__column_names[15] = BaseEmployeeMoneyManage.CS_DELETE_FLAG;
		__column_names[16] = BaseEmployeeMoneyManage.CS_IS_COMPLETED;
		__column_names[17] = BaseEmployeeMoneyManage.CS_BE_PACKED;
		__column_names[18] = BaseEmployeeMoneyManage.CS_VOUCHER_NO;
		__column_names[19] = BaseEmployeeMoneyManage.CS_POSTING_DATE;
		__column_names[20] = BaseEmployeeMoneyManage.CS_EQUIVALENT_NUMBER;
		__column_names[21] = BaseEmployeeMoneyManage.CS_CURRENCY;
		__column_names[22] = BaseEmployeeMoneyManage.CS_EXCHANGE_RATE;
		__column_names[23] = BaseEmployeeMoneyManage.CS_PROJECT_ID;
		__column_names[24] = BaseEmployeeMoneyManage.CS_PAYMENT_SEQUENCE_ID;
		__column_names[25] = BaseEmployeeMoneyManage.CS_BUDGET_MANAGEMENT_ID;
		__column_names[26] = BaseEmployeeMoneyManage.CS_BUDGET_ATTACHMENT_ID;
		__column_names[27] = BaseEmployeeMoneyManage.CS_FILE_ID;
		__column_names[28] = BaseEmployeeMoneyManage.CS_ATTACHMENT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeMoneyManage b) {
		clear();
		setEmployeeMoneyManageIdClear(b.getEmployeeMoneyManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeMoneyManageId() == null;
	}

	@Override
	public BaseEmployeeMoneyManage generateBase(){
		BaseEmployeeMoneyManage b = new BaseEmployeeMoneyManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeMoneyManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeMoneyManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReturnMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBorrowDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAnticipatedDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setReturnDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTitleName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFalg(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBePacked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setVoucherNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPostingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEquivalentNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCurrency(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeMoneyManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeMoneyManageId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getBorrowMoney();
		buff[count++] = b.getReturnMoney();
		buff[count++] = generateTimestampFromDate(b.getBorrowDate());
		buff[count++] = generateTimestampFromDate(b.getAnticipatedDate());
		buff[count++] = generateTimestampFromDate(b.getReturnDate());
		buff[count++] = b.getTitleName();
		buff[count++] = b.getReason();
		buff[count++] = b.getFalg();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCode();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getBePacked();
		buff[count++] = b.getVoucherNo();
		buff[count++] = generateTimestampFromDate(b.getPostingDate());
		buff[count++] = b.getEquivalentNumber();
		buff[count++] = b.getCurrency();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getPaymentSequenceId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getFileId();
		buff[count++] = b.getAttachment();
	}

	@Override
	public void setDataFromBase(BaseEmployeeMoneyManage b){
		if(b.getEmployeeMoneyManageId() != null) setEmployeeMoneyManageIdClear(b.getEmployeeMoneyManageId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getBorrowMoney() != null) setBorrowMoney(b.getBorrowMoney());
		if(b.getReturnMoney() != null) setReturnMoney(b.getReturnMoney());
		if(b.getBorrowDate() != null) setBorrowDate(b.getBorrowDate());
		if(b.getAnticipatedDate() != null) setAnticipatedDate(b.getAnticipatedDate());
		if(b.getReturnDate() != null) setReturnDate(b.getReturnDate());
		if(b.getTitleName() != null) setTitleName(b.getTitleName());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getFalg() != null) setFalg(b.getFalg());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getBePacked() != null) setBePacked(b.getBePacked());
		if(b.getVoucherNo() != null) setVoucherNo(b.getVoucherNo());
		if(b.getPostingDate() != null) setPostingDate(b.getPostingDate());
		if(b.getEquivalentNumber() != null) setEquivalentNumber(b.getEquivalentNumber());
		if(b.getCurrency() != null) setCurrency(b.getCurrency());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getPaymentSequenceId() != null) setPaymentSequenceId(b.getPaymentSequenceId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentId(b.getBudgetAttachmentId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
	}

	@Override
	public BaseEmployeeMoneyManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeMoneyManage b = new BaseEmployeeMoneyManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeMoneyManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeMoneyManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBorrowDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnticipatedDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitleName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFalg(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBePacked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPostingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquivalentNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrency(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
	}

	public void setEmployeeMoneyManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeMoneyManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeMoneyManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBorrowMoney(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getBorrowMoney() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setReturnMoney(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getReturnMoney() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setBorrowDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getBorrowDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setAnticipatedDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getAnticipatedDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setReturnDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getReturnDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setTitleName(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getTitleName() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setFalg(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getFalg() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setBePacked(java.lang.Boolean val) {
		setCurrentData(17, val);
	}

	public java.lang.Boolean getBePacked() {
		return GenericBase.__getBoolean(__current_data[17]);
	}

	public void setVoucherNo(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getVoucherNo() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setPostingDate(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getPostingDate() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setEquivalentNumber(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getEquivalentNumber() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setCurrency(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getCurrency() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setPaymentSequenceId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getPaymentSequenceId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setConditionEmployeeMoneyManageId(String op, java.lang.Integer val) {
		setConditionEmployeeMoneyManageId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeMoneyManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeMoneyManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBorrowMoney(String op, java.math.BigDecimal val) {
		setConditionBorrowMoney(op, val, CONDITION_AND);
	}

	public void setConditionBorrowMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBorrowMoney(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionReturnMoney(String op, java.math.BigDecimal val) {
		setConditionReturnMoney(op, val, CONDITION_AND);
	}

	public void setConditionReturnMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectReturnMoney(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBorrowDate(String op, java.util.Date val) {
		setConditionBorrowDate(op, val, CONDITION_AND);
	}

	public void setConditionBorrowDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBorrowDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAnticipatedDate(String op, java.util.Date val) {
		setConditionAnticipatedDate(op, val, CONDITION_AND);
	}

	public void setConditionAnticipatedDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAnticipatedDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionReturnDate(String op, java.util.Date val) {
		setConditionReturnDate(op, val, CONDITION_AND);
	}

	public void setConditionReturnDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReturnDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTitleName(String op, java.lang.String val) {
		setConditionTitleName(op, val, CONDITION_AND);
	}

	public void setConditionTitleName(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTitleName(boolean val) {
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

	public void setConditionFalg(String op, java.lang.Integer val) {
		setConditionFalg(op, val, CONDITION_AND);
	}

	public void setConditionFalg(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectFalg(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionBePacked(String op, java.lang.Boolean val) {
		setConditionBePacked(op, val, CONDITION_AND);
	}

	public void setConditionBePacked(String op, java.lang.Boolean val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectBePacked(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionVoucherNo(String op, java.lang.String val) {
		setConditionVoucherNo(op, val, CONDITION_AND);
	}

	public void setConditionVoucherNo(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectVoucherNo(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionPostingDate(String op, java.util.Date val) {
		setConditionPostingDate(op, val, CONDITION_AND);
	}

	public void setConditionPostingDate(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPostingDate(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionEquivalentNumber(String op, java.lang.String val) {
		setConditionEquivalentNumber(op, val, CONDITION_AND);
	}

	public void setConditionEquivalentNumber(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectEquivalentNumber(boolean val) {
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

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val) {
		setConditionPaymentSequenceId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectPaymentSequenceId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[28] = val;
	}


}

