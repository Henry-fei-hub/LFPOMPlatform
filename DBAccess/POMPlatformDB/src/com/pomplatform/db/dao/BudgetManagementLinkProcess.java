package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBudgetManagementLinkProcess;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BudgetManagementLinkProcess extends AbstractTable<BaseBudgetManagementLinkProcess>
{

	public BudgetManagementLinkProcess() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "budget_management_link_process";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBudgetManagementLinkProcess.CS_BUDGET_MANAGEMENT_LINK_PROCESS_ID;
		__column_names[1] = BaseBudgetManagementLinkProcess.CS_BUDGET_MANAGEMENT_ID;
		__column_names[2] = BaseBudgetManagementLinkProcess.CS_BUSINESS_ID;
		__column_names[3] = BaseBudgetManagementLinkProcess.CS_PROCESS_ID;
		__column_names[4] = BaseBudgetManagementLinkProcess.CS_PROCESS_TYPE;
		__column_names[5] = BaseBudgetManagementLinkProcess.CS_PROCESS_INSTANCE_ID;
		__column_names[6] = BaseBudgetManagementLinkProcess.CS_EMPLOYEE_ID;
		__column_names[7] = BaseBudgetManagementLinkProcess.CS_EMPLOYEE_NO;
		__column_names[8] = BaseBudgetManagementLinkProcess.CS_DEPARTMENT_ID;
		__column_names[9] = BaseBudgetManagementLinkProcess.CS_TOTAL_PRICE;
		__column_names[10] = BaseBudgetManagementLinkProcess.CS_CREATE_TIME;
		__column_names[11] = BaseBudgetManagementLinkProcess.CS_REASON;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBudgetManagementLinkProcess b) {
		clear();
		setBudgetManagementLinkProcessIdClear(b.getBudgetManagementLinkProcessId());
	}

	public boolean isPrimaryKeyNull() {
		return getBudgetManagementLinkProcessId() == null;
	}

	@Override
	public BaseBudgetManagementLinkProcess generateBase(){
		BaseBudgetManagementLinkProcess b = new BaseBudgetManagementLinkProcess();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBudgetManagementLinkProcess b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBudgetManagementLinkProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseBudgetManagementLinkProcess b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBudgetManagementLinkProcessId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getTotalPrice();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getReason();
	}

	@Override
	public void setDataFromBase(BaseBudgetManagementLinkProcess b){
		if(b.getBudgetManagementLinkProcessId() != null) setBudgetManagementLinkProcessIdClear(b.getBudgetManagementLinkProcessId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getReason() != null) setReason(b.getReason());
	}

	@Override
	public BaseBudgetManagementLinkProcess generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBudgetManagementLinkProcess b = new BaseBudgetManagementLinkProcess();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBudgetManagementLinkProcess __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementLinkProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
	}

	public void setBudgetManagementLinkProcessId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBudgetManagementLinkProcessId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBudgetManagementLinkProcessIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionBudgetManagementLinkProcessId(String op, java.lang.Integer val) {
		setConditionBudgetManagementLinkProcessId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementLinkProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBudgetManagementLinkProcessId(boolean val) {
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

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
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

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
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

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[11] = val;
	}


}

