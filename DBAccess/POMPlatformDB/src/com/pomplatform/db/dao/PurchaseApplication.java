package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePurchaseApplication;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PurchaseApplication extends AbstractTable<BasePurchaseApplication>
{

	public PurchaseApplication() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "purchase_applications";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePurchaseApplication.CS_PURCHASE_APPLICATION_ID;
		__column_names[1] = BasePurchaseApplication.CS_MAJOR_TITLE;
		__column_names[2] = BasePurchaseApplication.CS_APPLY_EMPLOYEE_ID;
		__column_names[3] = BasePurchaseApplication.CS_APPLY_DEPARTMENT_ID;
		__column_names[4] = BasePurchaseApplication.CS_PURCHASE_AMOUNT;
		__column_names[5] = BasePurchaseApplication.CS_APPLY_REASON;
		__column_names[6] = BasePurchaseApplication.CS_PLAN_ARRIVAL_DATE;
		__column_names[7] = BasePurchaseApplication.CS_CREATE_EMPLOYEE_ID;
		__column_names[8] = BasePurchaseApplication.CS_CREATE_TIME;
		__column_names[9] = BasePurchaseApplication.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePurchaseApplication b) {
		clear();
		setPurchaseApplicationIdClear(b.getPurchaseApplicationId());
	}

	public boolean isPrimaryKeyNull() {
		return getPurchaseApplicationId() == null;
	}

	@Override
	public BasePurchaseApplication generateBase(){
		BasePurchaseApplication b = new BasePurchaseApplication();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePurchaseApplication b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPurchaseApplicationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMajorTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplyDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaseAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setApplyReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlanArrivalDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePurchaseApplication b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPurchaseApplicationId();
		buff[count++] = b.getMajorTitle();
		buff[count++] = b.getApplyEmployeeId();
		buff[count++] = b.getApplyDepartmentId();
		buff[count++] = b.getPurchaseAmount();
		buff[count++] = b.getApplyReason();
		buff[count++] = generateTimestampFromDate(b.getPlanArrivalDate());
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePurchaseApplication b){
		if(b.getPurchaseApplicationId() != null) setPurchaseApplicationIdClear(b.getPurchaseApplicationId());
		if(b.getMajorTitle() != null) setMajorTitle(b.getMajorTitle());
		if(b.getApplyEmployeeId() != null) setApplyEmployeeId(b.getApplyEmployeeId());
		if(b.getApplyDepartmentId() != null) setApplyDepartmentId(b.getApplyDepartmentId());
		if(b.getPurchaseAmount() != null) setPurchaseAmount(b.getPurchaseAmount());
		if(b.getApplyReason() != null) setApplyReason(b.getApplyReason());
		if(b.getPlanArrivalDate() != null) setPlanArrivalDate(b.getPlanArrivalDate());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePurchaseApplication generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePurchaseApplication b = new BasePurchaseApplication();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePurchaseApplication __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseApplicationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMajorTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanArrivalDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPurchaseApplicationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPurchaseApplicationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPurchaseApplicationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMajorTitle(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getMajorTitle() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setApplyEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getApplyEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setApplyDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getApplyDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPurchaseAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setApplyReason(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getApplyReason() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setPlanArrivalDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getPlanArrivalDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionPurchaseApplicationId(String op, java.lang.Integer val) {
		setConditionPurchaseApplicationId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseApplicationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPurchaseApplicationId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMajorTitle(String op, java.lang.String val) {
		setConditionMajorTitle(op, val, CONDITION_AND);
	}

	public void setConditionMajorTitle(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMajorTitle(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val) {
		setConditionApplyEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectApplyEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionApplyDepartmentId(String op, java.lang.Integer val) {
		setConditionApplyDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionApplyDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectApplyDepartmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPurchaseAmount(String op, java.math.BigDecimal val) {
		setConditionPurchaseAmount(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPurchaseAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionApplyReason(String op, java.lang.String val) {
		setConditionApplyReason(op, val, CONDITION_AND);
	}

	public void setConditionApplyReason(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectApplyReason(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPlanArrivalDate(String op, java.util.Date val) {
		setConditionPlanArrivalDate(op, val, CONDITION_AND);
	}

	public void setConditionPlanArrivalDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPlanArrivalDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

