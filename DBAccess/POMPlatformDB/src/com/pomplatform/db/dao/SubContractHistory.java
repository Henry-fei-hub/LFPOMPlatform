package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSubContractHistory;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SubContractHistory extends AbstractTable<BaseSubContractHistory>
{

	public SubContractHistory() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "sub_contract_historys";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSubContractHistory.CS_SUB_CONTRACT_HISTORY_ID;
		__column_names[1] = BaseSubContractHistory.CS_PARENT_ID;
		__column_names[2] = BaseSubContractHistory.CS_SUB_CONTRACT_CODE;
		__column_names[3] = BaseSubContractHistory.CS_PROJECT_CODE;
		__column_names[4] = BaseSubContractHistory.CS_BUSINESS_TYPE;
		__column_names[5] = BaseSubContractHistory.CS_PROJECT_TYPE;
		__column_names[6] = BaseSubContractHistory.CS_DEPARTMENT_ID;
		__column_names[7] = BaseSubContractHistory.CS_COMMON_AREA;
		__column_names[8] = BaseSubContractHistory.CS_LOGISTICS_AREA;
		__column_names[9] = BaseSubContractHistory.CS_MONEY_SUM;
		__column_names[10] = BaseSubContractHistory.CS_CREATE_TIME;
		__column_names[11] = BaseSubContractHistory.CS_SUB_CONTRACT_NAME;
		__column_names[12] = BaseSubContractHistory.CS_UPDATE_TIME;
		__column_names[13] = BaseSubContractHistory.CS_DESIGN_AREA;
		__column_names[14] = BaseSubContractHistory.CS_ORDER_NO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSubContractHistory b) {
		clear();
		setSubContractHistoryIdClear(b.getSubContractHistoryId());
	}

	public boolean isPrimaryKeyNull() {
		return getSubContractHistoryId() == null;
	}

	@Override
	public BaseSubContractHistory generateBase(){
		BaseSubContractHistory b = new BaseSubContractHistory();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSubContractHistory b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSubContractHistoryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSubContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSubContractHistory b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSubContractHistoryId();
		buff[count++] = b.getParentId();
		buff[count++] = b.getSubContractCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCommonArea();
		buff[count++] = b.getLogisticsArea();
		buff[count++] = b.getMoneySum();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getSubContractName();
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getDesignArea();
		buff[count++] = b.getOrderNo();
	}

	@Override
	public void setDataFromBase(BaseSubContractHistory b){
		if(b.getSubContractHistoryId() != null) setSubContractHistoryIdClear(b.getSubContractHistoryId());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getSubContractCode() != null) setSubContractCode(b.getSubContractCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCommonArea() != null) setCommonArea(b.getCommonArea());
		if(b.getLogisticsArea() != null) setLogisticsArea(b.getLogisticsArea());
		if(b.getMoneySum() != null) setMoneySum(b.getMoneySum());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getSubContractName() != null) setSubContractName(b.getSubContractName());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getDesignArea() != null) setDesignArea(b.getDesignArea());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
	}

	@Override
	public BaseSubContractHistory generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSubContractHistory b = new BaseSubContractHistory();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSubContractHistory __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractHistoryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
	}

	public void setSubContractHistoryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSubContractHistoryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSubContractHistoryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSubContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSubContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCommonArea(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getCommonArea() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setLogisticsArea(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getLogisticsArea() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setSubContractName(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSubContractName() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setConditionSubContractHistoryId(String op, java.lang.Integer val) {
		setConditionSubContractHistoryId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractHistoryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSubContractHistoryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSubContractCode(String op, java.lang.String val) {
		setConditionSubContractCode(op, val, CONDITION_AND);
	}

	public void setConditionSubContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSubContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
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

	public void setConditionCommonArea(String op, java.math.BigDecimal val) {
		setConditionCommonArea(op, val, CONDITION_AND);
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCommonArea(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val) {
		setConditionLogisticsArea(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLogisticsArea(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
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

	public void setConditionSubContractName(String op, java.lang.String val) {
		setConditionSubContractName(op, val, CONDITION_AND);
	}

	public void setConditionSubContractName(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSubContractName(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[14] = val;
	}


}

