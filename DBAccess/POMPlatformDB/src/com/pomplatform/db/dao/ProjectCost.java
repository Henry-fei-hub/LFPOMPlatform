package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectCost;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectCost extends AbstractTable<BaseProjectCost>
{

	public ProjectCost() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "project_cost";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectCost.CS_PROJECT_COST_ID;
		__column_names[1] = BaseProjectCost.CS_PROJECT_ID;
		__column_names[2] = BaseProjectCost.CS_EMPLOYEE_ID;
		__column_names[3] = BaseProjectCost.CS_COST_TYPE;
		__column_names[4] = BaseProjectCost.CS_COST_DATE;
		__column_names[5] = BaseProjectCost.CS_SETTLEMENT_ID;
		__column_names[6] = BaseProjectCost.CS_STATUS;
		__column_names[7] = BaseProjectCost.CS_AMOUNT;
		__column_names[8] = BaseProjectCost.CS_PROCESS_TYPE;
		__column_names[9] = BaseProjectCost.CS_BUSINESS_ID;
		__column_names[10] = BaseProjectCost.CS_PROCESS_ID;
		__column_names[11] = BaseProjectCost.CS_PROCESS_INSTANCE_ID;
		__column_names[12] = BaseProjectCost.CS_SETTLEMENT_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectCost b) {
		clear();
		setProjectCostIdClear(b.getProjectCostId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectCostId() == null;
	}

	@Override
	public BaseProjectCost generateBase(){
		BaseProjectCost b = new BaseProjectCost();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectCost b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectCostId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCostType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSettlementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlementStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectCost b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectCostId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getCostType();
		buff[count++] = generateTimestampFromDate(b.getCostDate());
		buff[count++] = b.getSettlementId();
		buff[count++] = b.getStatus();
		buff[count++] = b.getAmount();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessId();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getSettlementStatus();
	}

	@Override
	public void setDataFromBase(BaseProjectCost b){
		if(b.getProjectCostId() != null) setProjectCostIdClear(b.getProjectCostId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCostType() != null) setCostType(b.getCostType());
		if(b.getCostDate() != null) setCostDate(b.getCostDate());
		if(b.getSettlementId() != null) setSettlementId(b.getSettlementId());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getSettlementStatus() != null) setSettlementStatus(b.getSettlementStatus());
	}

	@Override
	public BaseProjectCost generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectCost b = new BaseProjectCost();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectCost __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCostId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
	}

	public void setProjectCostId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectCostId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectCostIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCostType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCostType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCostDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCostDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setSettlementId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getSettlementId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setSettlementStatus(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getSettlementStatus() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setConditionProjectCostId(String op, java.lang.Integer val) {
		setConditionProjectCostId(op, val, CONDITION_AND);
	}

	public void setConditionProjectCostId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectCostId(boolean val) {
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

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCostType(String op, java.lang.Integer val) {
		setConditionCostType(op, val, CONDITION_AND);
	}

	public void setConditionCostType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCostType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCostDate(String op, java.util.Date val) {
		setConditionCostDate(op, val, CONDITION_AND);
	}

	public void setConditionCostDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCostDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSettlementId(String op, java.lang.Integer val) {
		setConditionSettlementId(op, val, CONDITION_AND);
	}

	public void setConditionSettlementId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSettlementId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSettlementStatus(String op, java.lang.Integer val) {
		setConditionSettlementStatus(op, val, CONDITION_AND);
	}

	public void setConditionSettlementStatus(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSettlementStatus(boolean val) {
		__select_flags[12] = val;
	}


}

