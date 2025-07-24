package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalsToContractReceivable;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalsToContractReceivable extends AbstractTable<BaseCapitalsToContractReceivable>
{

	public CapitalsToContractReceivable() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "capitals_to_contract_receivables";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalsToContractReceivable.CS_CAPITALS_TO_CONTRACT_RECEIVABLE_ID;
		__column_names[1] = BaseCapitalsToContractReceivable.CS_CONTRACT_RECEIVABLE_ID;
		__column_names[2] = BaseCapitalsToContractReceivable.CS_CAPITAL_ID;
		__column_names[3] = BaseCapitalsToContractReceivable.CS_OPERATOR;
		__column_names[4] = BaseCapitalsToContractReceivable.CS_CREATE_DATE;
		__column_names[5] = BaseCapitalsToContractReceivable.CS_STAGE_PERCENTAGE;
		__column_names[6] = BaseCapitalsToContractReceivable.CS_STAGE_SUM_MONEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalsToContractReceivable b) {
		clear();
		setCapitalsToContractReceivableIdClear(b.getCapitalsToContractReceivableId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalsToContractReceivableId() == null;
	}

	@Override
	public BaseCapitalsToContractReceivable generateBase(){
		BaseCapitalsToContractReceivable b = new BaseCapitalsToContractReceivable();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalsToContractReceivable b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalsToContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStagePercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStageSumMoney(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalsToContractReceivable b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalsToContractReceivableId();
		buff[count++] = b.getContractReceivableId();
		buff[count++] = b.getCapitalId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getStagePercentage();
		buff[count++] = b.getStageSumMoney();
	}

	@Override
	public void setDataFromBase(BaseCapitalsToContractReceivable b){
		if(b.getCapitalsToContractReceivableId() != null) setCapitalsToContractReceivableIdClear(b.getCapitalsToContractReceivableId());
		if(b.getContractReceivableId() != null) setContractReceivableId(b.getContractReceivableId());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getStagePercentage() != null) setStagePercentage(b.getStagePercentage());
		if(b.getStageSumMoney() != null) setStageSumMoney(b.getStageSumMoney());
	}

	@Override
	public BaseCapitalsToContractReceivable generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalsToContractReceivable b = new BaseCapitalsToContractReceivable();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalsToContractReceivable __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalsToContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStagePercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageSumMoney(GenericBase.__getDecimal(val));
	}

	public void setCapitalsToContractReceivableId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalsToContractReceivableId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalsToContractReceivableIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractReceivableId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractReceivableId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setStagePercentage(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getStagePercentage() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setStageSumMoney(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getStageSumMoney() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setConditionCapitalsToContractReceivableId(String op, java.lang.Integer val) {
		setConditionCapitalsToContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalsToContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalsToContractReceivableId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val) {
		setConditionContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractReceivableId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStagePercentage(String op, java.math.BigDecimal val) {
		setConditionStagePercentage(op, val, CONDITION_AND);
	}

	public void setConditionStagePercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStagePercentage(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStageSumMoney(String op, java.math.BigDecimal val) {
		setConditionStageSumMoney(op, val, CONDITION_AND);
	}

	public void setConditionStageSumMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStageSumMoney(boolean val) {
		__select_flags[6] = val;
	}


}

