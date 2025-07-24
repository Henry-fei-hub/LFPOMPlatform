package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalDistribution;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalDistribution extends AbstractTable<BaseCapitalDistribution>
{

	public CapitalDistribution() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "capital_distributions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalDistribution.CS_CAPITAL_DISTRIBUTION_ID;
		__column_names[1] = BaseCapitalDistribution.CS_TYPE;
		__column_names[2] = BaseCapitalDistribution.CS_CONTRACT_ID;
		__column_names[3] = BaseCapitalDistribution.CS_CAPITAL_ID;
		__column_names[4] = BaseCapitalDistribution.CS_PROJECT_ID;
		__column_names[5] = BaseCapitalDistribution.CS_TOTAL_AMOUNT;
		__column_names[6] = BaseCapitalDistribution.CS_DISTRIBUTION_AMOUNT;
		__column_names[7] = BaseCapitalDistribution.CS_OPERATOR;
		__column_names[8] = BaseCapitalDistribution.CS_CREATE_TIME;
		__column_names[9] = BaseCapitalDistribution.CS_LOCKED;
		__column_names[10] = BaseCapitalDistribution.CS_DELETE_FLAG;
		__column_names[11] = BaseCapitalDistribution.CS_PLATE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalDistribution b) {
		clear();
		setCapitalDistributionIdClear(b.getCapitalDistributionId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalDistributionId() == null;
	}

	@Override
	public BaseCapitalDistribution generateBase(){
		BaseCapitalDistribution b = new BaseCapitalDistribution();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalDistribution b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalDistribution b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalDistributionId();
		buff[count++] = b.getType();
		buff[count++] = b.getContractId();
		buff[count++] = b.getCapitalId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getDistributionAmount();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getLocked();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getPlateId();
	}

	@Override
	public void setDataFromBase(BaseCapitalDistribution b){
		if(b.getCapitalDistributionId() != null) setCapitalDistributionIdClear(b.getCapitalDistributionId());
		if(b.getType() != null) setType(b.getType());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getDistributionAmount() != null) setDistributionAmount(b.getDistributionAmount());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getLocked() != null) setLocked(b.getLocked());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
	}

	@Override
	public BaseCapitalDistribution generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalDistribution b = new BaseCapitalDistribution();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalDistribution __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
	}

	public void setCapitalDistributionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalDistributionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalDistributionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setDistributionAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getDistributionAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setLocked(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getLocked() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val) {
		setConditionCapitalDistributionId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalDistributionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDistributionAmount(String op, java.math.BigDecimal val) {
		setConditionDistributionAmount(op, val, CONDITION_AND);
	}

	public void setConditionDistributionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDistributionAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
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

	public void setConditionLocked(String op, java.lang.Boolean val) {
		setConditionLocked(op, val, CONDITION_AND);
	}

	public void setConditionLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectLocked(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[11] = val;
	}


}

