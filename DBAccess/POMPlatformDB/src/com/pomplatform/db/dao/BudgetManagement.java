package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBudgetManagement;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BudgetManagement extends AbstractTable<BaseBudgetManagement>
{

	public BudgetManagement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 23;

		initTables();

		__tableName            = "budget_management";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBudgetManagement.CS_BUDGET_MANAGEMENT_ID;
		__column_names[1] = BaseBudgetManagement.CS_BD_CODE;
		__column_names[2] = BaseBudgetManagement.CS_BD_TYPE;
		__column_names[3] = BaseBudgetManagement.CS_BD_TOTAL_AMOUNT;
		__column_names[4] = BaseBudgetManagement.CS_BD_USE_AMOUNT;
		__column_names[5] = BaseBudgetManagement.CS_BD_REST_AMOUNT;
		__column_names[6] = BaseBudgetManagement.CS_BD_APPLY_EMPLOYEE_ID;
		__column_names[7] = BaseBudgetManagement.CS_BD_APPLY_TIME;
		__column_names[8] = BaseBudgetManagement.CS_BD_ESTIMATECLOSE_TIME;
		__column_names[9] = BaseBudgetManagement.CS_BD_STATUS;
		__column_names[10] = BaseBudgetManagement.CS_PROJECT_ID;
		__column_names[11] = BaseBudgetManagement.CS_BD_REMARK;
		__column_names[12] = BaseBudgetManagement.CS_INPUT_TAX_INVOICE_ID;
		__column_names[13] = BaseBudgetManagement.CS_DEPARTMENT_ID;
		__column_names[14] = BaseBudgetManagement.CS_COMPANY_ID;
		__column_names[15] = BaseBudgetManagement.CS_COST_BEARING;
		__column_names[16] = BaseBudgetManagement.CS_OUT_SOURCE_TYPE;
		__column_names[17] = BaseBudgetManagement.CS_FILE_ID;
		__column_names[18] = BaseBudgetManagement.CS_BD_ATTACHMENT_NAME;
		__column_names[19] = BaseBudgetManagement.CS_BD_UPLOAD_REMARK;
		__column_names[20] = BaseBudgetManagement.CS_BD_SUPPLIER_PERSON;
		__column_names[21] = BaseBudgetManagement.CS_BD_SUPPLIER_COMPANY;
		__column_names[22] = BaseBudgetManagement.CS_IS_PROCESS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBudgetManagement b) {
		clear();
		setBudgetManagementIdClear(b.getBudgetManagementId());
	}

	public boolean isPrimaryKeyNull() {
		return getBudgetManagementId() == null;
	}

	@Override
	public BaseBudgetManagement generateBase(){
		BaseBudgetManagement b = new BaseBudgetManagement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBudgetManagement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBdCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBdType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBdTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBdUseAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBdRestAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBdApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBdApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setBdEstimatecloseTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setBdStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBdRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCostBearing(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOutSourceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBdAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBdUploadRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBdSupplierPerson(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBdSupplierCompany(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsProcess(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseBudgetManagement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBdCode();
		buff[count++] = b.getBdType();
		buff[count++] = b.getBdTotalAmount();
		buff[count++] = b.getBdUseAmount();
		buff[count++] = b.getBdRestAmount();
		buff[count++] = b.getBdApplyEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getBdApplyTime());
		buff[count++] = generateTimestampFromDate(b.getBdEstimatecloseTime());
		buff[count++] = b.getBdStatus();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getBdRemark();
		buff[count++] = b.getInputTaxInvoiceId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCostBearing();
		buff[count++] = b.getOutSourceType();
		buff[count++] = b.getFileId();
		buff[count++] = b.getBdAttachmentName();
		buff[count++] = b.getBdUploadRemark();
		buff[count++] = b.getBdSupplierPerson();
		buff[count++] = b.getBdSupplierCompany();
		buff[count++] = b.getIsProcess();
	}

	@Override
	public void setDataFromBase(BaseBudgetManagement b){
		if(b.getBudgetManagementId() != null) setBudgetManagementIdClear(b.getBudgetManagementId());
		if(b.getBdCode() != null) setBdCode(b.getBdCode());
		if(b.getBdType() != null) setBdType(b.getBdType());
		if(b.getBdTotalAmount() != null) setBdTotalAmount(b.getBdTotalAmount());
		if(b.getBdUseAmount() != null) setBdUseAmount(b.getBdUseAmount());
		if(b.getBdRestAmount() != null) setBdRestAmount(b.getBdRestAmount());
		if(b.getBdApplyEmployeeId() != null) setBdApplyEmployeeId(b.getBdApplyEmployeeId());
		if(b.getBdApplyTime() != null) setBdApplyTime(b.getBdApplyTime());
		if(b.getBdEstimatecloseTime() != null) setBdEstimatecloseTime(b.getBdEstimatecloseTime());
		if(b.getBdStatus() != null) setBdStatus(b.getBdStatus());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getBdRemark() != null) setBdRemark(b.getBdRemark());
		if(b.getInputTaxInvoiceId() != null) setInputTaxInvoiceId(b.getInputTaxInvoiceId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCostBearing() != null) setCostBearing(b.getCostBearing());
		if(b.getOutSourceType() != null) setOutSourceType(b.getOutSourceType());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getBdAttachmentName() != null) setBdAttachmentName(b.getBdAttachmentName());
		if(b.getBdUploadRemark() != null) setBdUploadRemark(b.getBdUploadRemark());
		if(b.getBdSupplierPerson() != null) setBdSupplierPerson(b.getBdSupplierPerson());
		if(b.getBdSupplierCompany() != null) setBdSupplierCompany(b.getBdSupplierCompany());
		if(b.getIsProcess() != null) setIsProcess(b.getIsProcess());
	}

	@Override
	public BaseBudgetManagement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBudgetManagement b = new BaseBudgetManagement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBudgetManagement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdUseAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdRestAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdApplyEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdApplyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdEstimatecloseTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostBearing(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutSourceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdUploadRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdSupplierPerson(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdSupplierCompany(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsProcess(GenericBase.__getBoolean(val));
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBudgetManagementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBdCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBdCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setBdType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBdType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBdTotalAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getBdTotalAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setBdUseAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getBdUseAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setBdRestAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getBdRestAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setBdApplyEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getBdApplyEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setBdApplyTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getBdApplyTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setBdEstimatecloseTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getBdEstimatecloseTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setBdStatus(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getBdStatus() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setBdRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getBdRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setInputTaxInvoiceId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setCostBearing(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getCostBearing() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setOutSourceType(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getOutSourceType() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setBdAttachmentName(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getBdAttachmentName() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setBdUploadRemark(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getBdUploadRemark() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setBdSupplierPerson(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getBdSupplierPerson() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setBdSupplierCompany(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getBdSupplierCompany() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setIsProcess(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getIsProcess() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBdCode(String op, java.lang.String val) {
		setConditionBdCode(op, val, CONDITION_AND);
	}

	public void setConditionBdCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBdCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBdType(String op, java.lang.Integer val) {
		setConditionBdType(op, val, CONDITION_AND);
	}

	public void setConditionBdType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBdType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBdTotalAmount(String op, java.math.BigDecimal val) {
		setConditionBdTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionBdTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBdTotalAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBdUseAmount(String op, java.math.BigDecimal val) {
		setConditionBdUseAmount(op, val, CONDITION_AND);
	}

	public void setConditionBdUseAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBdUseAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBdRestAmount(String op, java.math.BigDecimal val) {
		setConditionBdRestAmount(op, val, CONDITION_AND);
	}

	public void setConditionBdRestAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBdRestAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBdApplyEmployeeId(String op, java.lang.Integer val) {
		setConditionBdApplyEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionBdApplyEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBdApplyEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBdApplyTime(String op, java.util.Date val) {
		setConditionBdApplyTime(op, val, CONDITION_AND);
	}

	public void setConditionBdApplyTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBdApplyTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBdEstimatecloseTime(String op, java.util.Date val) {
		setConditionBdEstimatecloseTime(op, val, CONDITION_AND);
	}

	public void setConditionBdEstimatecloseTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBdEstimatecloseTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBdStatus(String op, java.lang.Integer val) {
		setConditionBdStatus(op, val, CONDITION_AND);
	}

	public void setConditionBdStatus(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBdStatus(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionBdRemark(String op, java.lang.String val) {
		setConditionBdRemark(op, val, CONDITION_AND);
	}

	public void setConditionBdRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectBdRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionInputTaxInvoiceId(String op, java.lang.Integer val) {
		setConditionInputTaxInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectInputTaxInvoiceId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCostBearing(String op, java.lang.String val) {
		setConditionCostBearing(op, val, CONDITION_AND);
	}

	public void setConditionCostBearing(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectCostBearing(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOutSourceType(String op, java.lang.Integer val) {
		setConditionOutSourceType(op, val, CONDITION_AND);
	}

	public void setConditionOutSourceType(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOutSourceType(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionBdAttachmentName(String op, java.lang.String val) {
		setConditionBdAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionBdAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectBdAttachmentName(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionBdUploadRemark(String op, java.lang.String val) {
		setConditionBdUploadRemark(op, val, CONDITION_AND);
	}

	public void setConditionBdUploadRemark(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectBdUploadRemark(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionBdSupplierPerson(String op, java.lang.String val) {
		setConditionBdSupplierPerson(op, val, CONDITION_AND);
	}

	public void setConditionBdSupplierPerson(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectBdSupplierPerson(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionBdSupplierCompany(String op, java.lang.String val) {
		setConditionBdSupplierCompany(op, val, CONDITION_AND);
	}

	public void setConditionBdSupplierCompany(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectBdSupplierCompany(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionIsProcess(String op, java.lang.Boolean val) {
		setConditionIsProcess(op, val, CONDITION_AND);
	}

	public void setConditionIsProcess(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectIsProcess(boolean val) {
		__select_flags[22] = val;
	}


}

