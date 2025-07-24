package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractDistribution;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractDistribution extends AbstractTable<BaseContractDistribution>
{

	public ContractDistribution() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "contract_distributions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractDistribution.CS_CONTRACT_DISTRIBUTION_ID;
		__column_names[1] = BaseContractDistribution.CS_CONTRACT_ID;
		__column_names[2] = BaseContractDistribution.CS_PLATE_ID;
		__column_names[3] = BaseContractDistribution.CS_BUSINESS_TYPE;
		__column_names[4] = BaseContractDistribution.CS_AMOUNT;
		__column_names[5] = BaseContractDistribution.CS_OPERATOR;
		__column_names[6] = BaseContractDistribution.CS_CREATE_TIME;
		__column_names[7] = BaseContractDistribution.CS_UPDATE_TIME;
		__column_names[8] = BaseContractDistribution.CS_DELETE_FLAG;
		__column_names[9] = BaseContractDistribution.CS_CONTRACT_DATE;
		__column_names[10] = BaseContractDistribution.CS_ACTUAL_MONEY;
		__column_names[11] = BaseContractDistribution.CS_ORDER_ID;
		__column_names[12] = BaseContractDistribution.CS_OPERATION_MANAGER_ID;
		__column_names[13] = BaseContractDistribution.CS_RATE_OF_PROGRESS;
		__column_names[14] = BaseContractDistribution.CS_ORDER_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractDistribution b) {
		clear();
		setContractDistributionIdClear(b.getContractDistributionId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractDistributionId() == null;
	}

	@Override
	public BaseContractDistribution generateBase(){
		BaseContractDistribution b = new BaseContractDistribution();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractDistribution b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractDistributionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setActualMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOrderId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperationManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRateOfProgress(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOrderStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractDistribution b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractDistributionId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getAmount();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = generateTimestampFromDate(b.getContractDate());
		buff[count++] = b.getActualMoney();
		buff[count++] = b.getOrderId();
		buff[count++] = b.getOperationManagerId();
		buff[count++] = b.getRateOfProgress();
		buff[count++] = b.getOrderStatus();
	}

	@Override
	public void setDataFromBase(BaseContractDistribution b){
		if(b.getContractDistributionId() != null) setContractDistributionIdClear(b.getContractDistributionId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getContractDate() != null) setContractDate(b.getContractDate());
		if(b.getActualMoney() != null) setActualMoney(b.getActualMoney());
		if(b.getOrderId() != null) setOrderId(b.getOrderId());
		if(b.getOperationManagerId() != null) setOperationManagerId(b.getOperationManagerId());
		if(b.getRateOfProgress() != null) setRateOfProgress(b.getRateOfProgress());
		if(b.getOrderStatus() != null) setOrderStatus(b.getOrderStatus());
	}

	@Override
	public BaseContractDistribution generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractDistribution b = new BaseContractDistribution();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractDistribution __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractDistributionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRateOfProgress(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderStatus(GenericBase.__getInt(val));
	}

	public void setContractDistributionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractDistributionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractDistributionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setContractDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getContractDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setActualMoney(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getActualMoney() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setOrderId(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getOrderId() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setOperationManagerId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getOperationManagerId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setRateOfProgress(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getRateOfProgress() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOrderStatus(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOrderStatus() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setConditionContractDistributionId(String op, java.lang.Integer val) {
		setConditionContractDistributionId(op, val, CONDITION_AND);
	}

	public void setConditionContractDistributionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractDistributionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionContractDate(String op, java.util.Date val) {
		setConditionContractDate(op, val, CONDITION_AND);
	}

	public void setConditionContractDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionActualMoney(String op, java.math.BigDecimal val) {
		setConditionActualMoney(op, val, CONDITION_AND);
	}

	public void setConditionActualMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectActualMoney(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOrderId(String op, java.lang.String val) {
		setConditionOrderId(op, val, CONDITION_AND);
	}

	public void setConditionOrderId(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOrderId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOperationManagerId(String op, java.lang.Integer val) {
		setConditionOperationManagerId(op, val, CONDITION_AND);
	}

	public void setConditionOperationManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOperationManagerId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRateOfProgress(String op, java.math.BigDecimal val) {
		setConditionRateOfProgress(op, val, CONDITION_AND);
	}

	public void setConditionRateOfProgress(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectRateOfProgress(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOrderStatus(String op, java.lang.Integer val) {
		setConditionOrderStatus(op, val, CONDITION_AND);
	}

	public void setConditionOrderStatus(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOrderStatus(boolean val) {
		__select_flags[14] = val;
	}


}

