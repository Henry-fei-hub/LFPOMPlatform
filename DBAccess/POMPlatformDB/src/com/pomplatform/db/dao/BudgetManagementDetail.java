package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBudgetManagementDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BudgetManagementDetail extends AbstractTable<BaseBudgetManagementDetail>
{

	public BudgetManagementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "budget_management_detail";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBudgetManagementDetail.CS_BUDGET_MANAGEMENT_DETAIL_ID;
		__column_names[1] = BaseBudgetManagementDetail.CS_BUDGET_MANAGEMENT_ID;
		__column_names[2] = BaseBudgetManagementDetail.CS_BD_CODE;
		__column_names[3] = BaseBudgetManagementDetail.CS_BDD_TYPE;
		__column_names[4] = BaseBudgetManagementDetail.CS_BDD_AMOUNT;
		__column_names[5] = BaseBudgetManagementDetail.CS_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBudgetManagementDetail b) {
		clear();
		setBudgetManagementDetailIdClear(b.getBudgetManagementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getBudgetManagementDetailId() == null;
	}

	@Override
	public BaseBudgetManagementDetail generateBase(){
		BaseBudgetManagementDetail b = new BaseBudgetManagementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBudgetManagementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBudgetManagementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBdCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBddType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBddAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseBudgetManagementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBudgetManagementDetailId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBdCode();
		buff[count++] = b.getBddType();
		buff[count++] = b.getBddAmount();
		buff[count++] = b.getProjectId();
	}

	@Override
	public void setDataFromBase(BaseBudgetManagementDetail b){
		if(b.getBudgetManagementDetailId() != null) setBudgetManagementDetailIdClear(b.getBudgetManagementDetailId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBdCode() != null) setBdCode(b.getBdCode());
		if(b.getBddType() != null) setBddType(b.getBddType());
		if(b.getBddAmount() != null) setBddAmount(b.getBddAmount());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
	}

	@Override
	public BaseBudgetManagementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBudgetManagementDetail b = new BaseBudgetManagementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBudgetManagementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBdCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBddType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBddAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
	}

	public void setBudgetManagementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBudgetManagementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBudgetManagementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBdCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBdCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setBddType(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getBddType() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBddAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getBddAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionBudgetManagementDetailId(String op, java.lang.Integer val) {
		setConditionBudgetManagementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBudgetManagementDetailId(boolean val) {
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

	public void setConditionBdCode(String op, java.lang.String val) {
		setConditionBdCode(op, val, CONDITION_AND);
	}

	public void setConditionBdCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBdCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBddType(String op, java.lang.String val) {
		setConditionBddType(op, val, CONDITION_AND);
	}

	public void setConditionBddType(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBddType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBddAmount(String op, java.math.BigDecimal val) {
		setConditionBddAmount(op, val, CONDITION_AND);
	}

	public void setConditionBddAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBddAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[5] = val;
	}


}

