package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectIntegralSumRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectIntegralSumRecord extends AbstractTable<BaseProjectIntegralSumRecord>
{

	public ProjectIntegralSumRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "project_integral_sum_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectIntegralSumRecord.CS_PROJECT_INTEGRAL_SUM_RECORD_ID;
		__column_names[1] = BaseProjectIntegralSumRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectIntegralSumRecord.CS_PLATE_ID;
		__column_names[3] = BaseProjectIntegralSumRecord.CS_YEAR;
		__column_names[4] = BaseProjectIntegralSumRecord.CS_MONTH;
		__column_names[5] = BaseProjectIntegralSumRecord.CS_PROJECT_INTEGRAL_SUM;
		__column_names[6] = BaseProjectIntegralSumRecord.CS_RESERVE_INTEGRAL;
		__column_names[7] = BaseProjectIntegralSumRecord.CS_PROJECT_INTEGRAL;
		__column_names[8] = BaseProjectIntegralSumRecord.CS_UNDISTRIBUTED_PROJECT_INTEGRAL;
		__column_names[9] = BaseProjectIntegralSumRecord.CS_DISTRIBUTED_PROJECT_INTEGRAL;
		__column_names[10] = BaseProjectIntegralSumRecord.CS_UNSURE_INTEGRAL;
		__column_names[11] = BaseProjectIntegralSumRecord.CS_SURE_INTEGRAL;
		__column_names[12] = BaseProjectIntegralSumRecord.CS_SETTLEMENT_INTEGRAL;
		__column_names[13] = BaseProjectIntegralSumRecord.CS_PROJECT_COST;
		__column_names[14] = BaseProjectIntegralSumRecord.CS_SETTLED_PROJECT_COST;
		__column_names[15] = BaseProjectIntegralSumRecord.CS_UNSETTLED_PROJECT_COST;
		__column_names[16] = BaseProjectIntegralSumRecord.CS_IS_LOCK;
		__column_names[17] = BaseProjectIntegralSumRecord.CS_CREATE_TIME;
		__column_names[18] = BaseProjectIntegralSumRecord.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectIntegralSumRecord b) {
		clear();
		setProjectIntegralSumRecordIdClear(b.getProjectIntegralSumRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectIntegralSumRecordId() == null;
	}

	@Override
	public BaseProjectIntegralSumRecord generateBase(){
		BaseProjectIntegralSumRecord b = new BaseProjectIntegralSumRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectIntegralSumRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectIntegralSumRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUndistributedProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDistributedProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnsureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSettlementIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSettledProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnsettledProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectIntegralSumRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectIntegralSumRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getProjectIntegralSum();
		buff[count++] = b.getReserveIntegral();
		buff[count++] = b.getProjectIntegral();
		buff[count++] = b.getUndistributedProjectIntegral();
		buff[count++] = b.getDistributedProjectIntegral();
		buff[count++] = b.getUnsureIntegral();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getSettlementIntegral();
		buff[count++] = b.getProjectCost();
		buff[count++] = b.getSettledProjectCost();
		buff[count++] = b.getUnsettledProjectCost();
		buff[count++] = b.getIsLock();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseProjectIntegralSumRecord b){
		if(b.getProjectIntegralSumRecordId() != null) setProjectIntegralSumRecordIdClear(b.getProjectIntegralSumRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getProjectIntegralSum() != null) setProjectIntegralSum(b.getProjectIntegralSum());
		if(b.getReserveIntegral() != null) setReserveIntegral(b.getReserveIntegral());
		if(b.getProjectIntegral() != null) setProjectIntegral(b.getProjectIntegral());
		if(b.getUndistributedProjectIntegral() != null) setUndistributedProjectIntegral(b.getUndistributedProjectIntegral());
		if(b.getDistributedProjectIntegral() != null) setDistributedProjectIntegral(b.getDistributedProjectIntegral());
		if(b.getUnsureIntegral() != null) setUnsureIntegral(b.getUnsureIntegral());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getSettlementIntegral() != null) setSettlementIntegral(b.getSettlementIntegral());
		if(b.getProjectCost() != null) setProjectCost(b.getProjectCost());
		if(b.getSettledProjectCost() != null) setSettledProjectCost(b.getSettledProjectCost());
		if(b.getUnsettledProjectCost() != null) setUnsettledProjectCost(b.getUnsettledProjectCost());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseProjectIntegralSumRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectIntegralSumRecord b = new BaseProjectIntegralSumRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectIntegralSumRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralSumRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUndistributedProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDistributedProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnsureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettledProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnsettledProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setProjectIntegralSumRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectIntegralSumRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectIntegralSumRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProjectIntegralSum(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getProjectIntegralSum() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setUndistributedProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getUndistributedProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setDistributedProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getDistributedProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setUnsureIntegral(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getUnsureIntegral() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setSettlementIntegral(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getSettlementIntegral() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setProjectCost(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getProjectCost() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setSettledProjectCost(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getSettledProjectCost() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setUnsettledProjectCost(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getUnsettledProjectCost() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setIsLock(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getIsLock() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setConditionProjectIntegralSumRecordId(String op, java.lang.Integer val) {
		setConditionProjectIntegralSumRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralSumRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectIntegralSumRecordId(boolean val) {
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

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectIntegralSum(String op, java.math.BigDecimal val) {
		setConditionProjectIntegralSum(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralSum(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectIntegralSum(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectReserveIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionUndistributedProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionUndistributedProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionUndistributedProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectUndistributedProjectIntegral(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionDistributedProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionDistributedProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionDistributedProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDistributedProjectIntegral(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionUnsureIntegral(String op, java.math.BigDecimal val) {
		setConditionUnsureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionUnsureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectUnsureIntegral(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSettlementIntegral(String op, java.math.BigDecimal val) {
		setConditionSettlementIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSettlementIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSettlementIntegral(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val) {
		setConditionProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectProjectCost(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionSettledProjectCost(String op, java.math.BigDecimal val) {
		setConditionSettledProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionSettledProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectSettledProjectCost(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionUnsettledProjectCost(String op, java.math.BigDecimal val) {
		setConditionUnsettledProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionUnsettledProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectUnsettledProjectCost(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsLock(String op, java.lang.Integer val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[18] = val;
	}


}

