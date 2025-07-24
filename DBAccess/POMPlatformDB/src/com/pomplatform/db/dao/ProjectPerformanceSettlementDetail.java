package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectPerformanceSettlementDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectPerformanceSettlementDetail extends AbstractTable<BaseProjectPerformanceSettlementDetail>
{

	public ProjectPerformanceSettlementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "project_performance_settlement_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectPerformanceSettlementDetail.CS_PROJECT_PERFORMANCE_SETTLEMENT_DETAIL_ID;
		__column_names[1] = BaseProjectPerformanceSettlementDetail.CS_PROJECT_PERFORMANCE_SETTLEMENT_ID;
		__column_names[2] = BaseProjectPerformanceSettlementDetail.CS_PROJECT_ID;
		__column_names[3] = BaseProjectPerformanceSettlementDetail.CS_EMPLOYEE_ID;
		__column_names[4] = BaseProjectPerformanceSettlementDetail.CS_RECORD_DATE;
		__column_names[5] = BaseProjectPerformanceSettlementDetail.CS_INTEGRAL;
		__column_names[6] = BaseProjectPerformanceSettlementDetail.CS_PERFORMANCE_FLAG;
		__column_names[7] = BaseProjectPerformanceSettlementDetail.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseProjectPerformanceSettlementDetail.CS_OPERATE_TIME;
		__column_names[9] = BaseProjectPerformanceSettlementDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectPerformanceSettlementDetail b) {
		clear();
		setProjectPerformanceSettlementDetailIdClear(b.getProjectPerformanceSettlementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectPerformanceSettlementDetailId() == null;
	}

	@Override
	public BaseProjectPerformanceSettlementDetail generateBase(){
		BaseProjectPerformanceSettlementDetail b = new BaseProjectPerformanceSettlementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectPerformanceSettlementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectPerformanceSettlementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectPerformanceSettlementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPerformanceFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectPerformanceSettlementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectPerformanceSettlementDetailId();
		buff[count++] = b.getProjectPerformanceSettlementId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getIntegral();
		buff[count++] = b.getPerformanceFlag();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectPerformanceSettlementDetail b){
		if(b.getProjectPerformanceSettlementDetailId() != null) setProjectPerformanceSettlementDetailIdClear(b.getProjectPerformanceSettlementDetailId());
		if(b.getProjectPerformanceSettlementId() != null) setProjectPerformanceSettlementId(b.getProjectPerformanceSettlementId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getIntegral() != null) setIntegral(b.getIntegral());
		if(b.getPerformanceFlag() != null) setPerformanceFlag(b.getPerformanceFlag());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectPerformanceSettlementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectPerformanceSettlementDetail b = new BaseProjectPerformanceSettlementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectPerformanceSettlementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectPerformanceSettlementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectPerformanceSettlementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectPerformanceSettlementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectPerformanceSettlementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectPerformanceSettlementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectPerformanceSettlementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectPerformanceSettlementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPerformanceFlag(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPerformanceFlag() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionProjectPerformanceSettlementDetailId(String op, java.lang.Integer val) {
		setConditionProjectPerformanceSettlementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProjectPerformanceSettlementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectPerformanceSettlementDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectPerformanceSettlementId(String op, java.lang.Integer val) {
		setConditionProjectPerformanceSettlementId(op, val, CONDITION_AND);
	}

	public void setConditionProjectPerformanceSettlementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectPerformanceSettlementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val) {
		setConditionIntegral(op, val, CONDITION_AND);
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPerformanceFlag(String op, java.lang.Integer val) {
		setConditionPerformanceFlag(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceFlag(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPerformanceFlag(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
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

