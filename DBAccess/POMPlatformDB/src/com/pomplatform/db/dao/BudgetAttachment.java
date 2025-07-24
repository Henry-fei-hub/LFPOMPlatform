package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBudgetAttachment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BudgetAttachment extends AbstractTable<BaseBudgetAttachment>
{

	public BudgetAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "budget_attachment";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBudgetAttachment.CS_BUDGET_ATTACHMENT_ID;
		__column_names[1] = BaseBudgetAttachment.CS_BUDGET_MANAGEMENT_ID;
		__column_names[2] = BaseBudgetAttachment.CS_FILE_ID;
		__column_names[3] = BaseBudgetAttachment.CS_ATTACHMENT_NAME;
		__column_names[4] = BaseBudgetAttachment.CS_UPLOAD_EMPLOYEE_ID;
		__column_names[5] = BaseBudgetAttachment.CS_DEPARTMENT_ID;
		__column_names[6] = BaseBudgetAttachment.CS_UPLOAD_TIME;
		__column_names[7] = BaseBudgetAttachment.CS_UPLOAD_REMARK;
		__column_names[8] = BaseBudgetAttachment.CS_BUDGET_CONTRACT_AMOUNT;
		__column_names[9] = BaseBudgetAttachment.CS_BUDGET_CONTRACT_AMOUNT_USE;
		__column_names[10] = BaseBudgetAttachment.CS_BUDGET_CONTRACT_AMOUNT_REST;
		__column_names[11] = BaseBudgetAttachment.CS_RECEIVE_UNIT_MANAGE_ID;
		__column_names[12] = BaseBudgetAttachment.CS_PROJECT_ID;
		__column_names[13] = BaseBudgetAttachment.CS_INPUT_TAX_INVOICE_ID;
		__column_names[14] = BaseBudgetAttachment.CS_BDD_TYPE;
		__column_names[15] = BaseBudgetAttachment.CS_IS_APPROVAL;
		__column_names[16] = BaseBudgetAttachment.CS_IS_LOCK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBudgetAttachment b) {
		clear();
		setBudgetAttachmentIdClear(b.getBudgetAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getBudgetAttachmentId() == null;
	}

	@Override
	public BaseBudgetAttachment generateBase(){
		BaseBudgetAttachment b = new BaseBudgetAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBudgetAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUploadEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUploadRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBudgetContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBudgetContractAmountRest(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBddType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsApproval(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseBudgetAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getFileId();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getUploadEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = generateTimestampFromDate(b.getUploadTime());
		buff[count++] = b.getUploadRemark();
		buff[count++] = b.getBudgetContractAmount();
		buff[count++] = b.getBudgetContractAmountUse();
		buff[count++] = b.getBudgetContractAmountRest();
		buff[count++] = b.getReceiveUnitManageId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getInputTaxInvoiceId();
		buff[count++] = b.getBddType();
		buff[count++] = b.getIsApproval();
		buff[count++] = b.getIsLock();
	}

	@Override
	public void setDataFromBase(BaseBudgetAttachment b){
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentIdClear(b.getBudgetAttachmentId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getUploadEmployeeId() != null) setUploadEmployeeId(b.getUploadEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getUploadTime() != null) setUploadTime(b.getUploadTime());
		if(b.getUploadRemark() != null) setUploadRemark(b.getUploadRemark());
		if(b.getBudgetContractAmount() != null) setBudgetContractAmount(b.getBudgetContractAmount());
		if(b.getBudgetContractAmountUse() != null) setBudgetContractAmountUse(b.getBudgetContractAmountUse());
		if(b.getBudgetContractAmountRest() != null) setBudgetContractAmountRest(b.getBudgetContractAmountRest());
		if(b.getReceiveUnitManageId() != null) setReceiveUnitManageId(b.getReceiveUnitManageId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getInputTaxInvoiceId() != null) setInputTaxInvoiceId(b.getInputTaxInvoiceId());
		if(b.getBddType() != null) setBddType(b.getBddType());
		if(b.getIsApproval() != null) setIsApproval(b.getIsApproval());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
	}

	@Override
	public BaseBudgetAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBudgetAttachment b = new BaseBudgetAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBudgetAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetContractAmountRest(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBddType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsApproval(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBudgetAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setUploadEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getUploadEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setUploadTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getUploadTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setUploadRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getUploadRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setBudgetContractAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getBudgetContractAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setBudgetContractAmountUse(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getBudgetContractAmountUse() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setBudgetContractAmountRest(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getBudgetContractAmountRest() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setReceiveUnitManageId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setInputTaxInvoiceId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setBddType(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getBddType() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setIsApproval(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getIsApproval() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
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

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionUploadEmployeeId(String op, java.lang.Integer val) {
		setConditionUploadEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionUploadEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectUploadEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionUploadTime(String op, java.util.Date val) {
		setConditionUploadTime(op, val, CONDITION_AND);
	}

	public void setConditionUploadTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUploadTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUploadRemark(String op, java.lang.String val) {
		setConditionUploadRemark(op, val, CONDITION_AND);
	}

	public void setConditionUploadRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectUploadRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBudgetContractAmount(String op, java.math.BigDecimal val) {
		setConditionBudgetContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionBudgetContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectBudgetContractAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBudgetContractAmountUse(String op, java.math.BigDecimal val) {
		setConditionBudgetContractAmountUse(op, val, CONDITION_AND);
	}

	public void setConditionBudgetContractAmountUse(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBudgetContractAmountUse(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBudgetContractAmountRest(String op, java.math.BigDecimal val) {
		setConditionBudgetContractAmountRest(op, val, CONDITION_AND);
	}

	public void setConditionBudgetContractAmountRest(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBudgetContractAmountRest(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val) {
		setConditionReceiveUnitManageId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectReceiveUnitManageId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionInputTaxInvoiceId(String op, java.lang.Integer val) {
		setConditionInputTaxInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectInputTaxInvoiceId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionBddType(String op, java.lang.String val) {
		setConditionBddType(op, val, CONDITION_AND);
	}

	public void setConditionBddType(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectBddType(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIsApproval(String op, java.lang.Integer val) {
		setConditionIsApproval(op, val, CONDITION_AND);
	}

	public void setConditionIsApproval(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIsApproval(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[16] = val;
	}


}

