package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractReceivable;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractReceivable extends AbstractTable<BaseContractReceivable>
{

	public ContractReceivable() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 14;

		initTables();

		__tableName            = "contract_receivables";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractReceivable.CS_CONTRACT_RECEIVABLE_ID;
		__column_names[1] = BaseContractReceivable.CS_INFO_CODE;
		__column_names[2] = BaseContractReceivable.CS_PROJECT_CODE;
		__column_names[3] = BaseContractReceivable.CS_CONTRACT_ID;
		__column_names[4] = BaseContractReceivable.CS_CONTRACT_CODE;
		__column_names[5] = BaseContractReceivable.CS_RECEIVABLE_NAME;
		__column_names[6] = BaseContractReceivable.CS_RECEIVABLE_PERCENTAGE;
		__column_names[7] = BaseContractReceivable.CS_RECEIVABLE_SUM_MONEY;
		__column_names[8] = BaseContractReceivable.CS_IS_CONFIRMATION_LETTER;
		__column_names[9] = BaseContractReceivable.CS_REMARK;
		__column_names[10] = BaseContractReceivable.CS_PARENT_ID;
		__column_names[11] = BaseContractReceivable.CS_OPERATOR;
		__column_names[12] = BaseContractReceivable.CS_CREATE_TIME;
		__column_names[13] = BaseContractReceivable.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractReceivable b) {
		clear();
		setContractReceivableIdClear(b.getContractReceivableId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractReceivableId() == null;
	}

	@Override
	public BaseContractReceivable generateBase(){
		BaseContractReceivable b = new BaseContractReceivable();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractReceivable b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceivableName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceivablePercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReceivableSumMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsConfirmationLetter(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractReceivable b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractReceivableId();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getReceivableName();
		buff[count++] = b.getReceivablePercentage();
		buff[count++] = b.getReceivableSumMoney();
		buff[count++] = b.getIsConfirmationLetter();
		buff[count++] = b.getRemark();
		buff[count++] = b.getParentId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseContractReceivable b){
		if(b.getContractReceivableId() != null) setContractReceivableIdClear(b.getContractReceivableId());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getReceivableName() != null) setReceivableName(b.getReceivableName());
		if(b.getReceivablePercentage() != null) setReceivablePercentage(b.getReceivablePercentage());
		if(b.getReceivableSumMoney() != null) setReceivableSumMoney(b.getReceivableSumMoney());
		if(b.getIsConfirmationLetter() != null) setIsConfirmationLetter(b.getIsConfirmationLetter());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseContractReceivable generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractReceivable b = new BaseContractReceivable();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractReceivable __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivableName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivableSumMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsConfirmationLetter(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setContractReceivableId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractReceivableId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractReceivableIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setReceivableName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getReceivableName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setReceivablePercentage(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getReceivablePercentage() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setReceivableSumMoney(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getReceivableSumMoney() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setIsConfirmationLetter(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsConfirmationLetter() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val) {
		setConditionContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractReceivableId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReceivableName(String op, java.lang.String val) {
		setConditionReceivableName(op, val, CONDITION_AND);
	}

	public void setConditionReceivableName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectReceivableName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionReceivablePercentage(String op, java.math.BigDecimal val) {
		setConditionReceivablePercentage(op, val, CONDITION_AND);
	}

	public void setConditionReceivablePercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectReceivablePercentage(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionReceivableSumMoney(String op, java.math.BigDecimal val) {
		setConditionReceivableSumMoney(op, val, CONDITION_AND);
	}

	public void setConditionReceivableSumMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectReceivableSumMoney(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsConfirmationLetter(String op, java.lang.Boolean val) {
		setConditionIsConfirmationLetter(op, val, CONDITION_AND);
	}

	public void setConditionIsConfirmationLetter(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsConfirmationLetter(boolean val) {
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

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[13] = val;
	}


}

