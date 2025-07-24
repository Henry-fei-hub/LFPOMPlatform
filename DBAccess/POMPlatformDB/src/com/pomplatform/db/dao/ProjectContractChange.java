package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectContractChange;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectContractChange extends AbstractTable<BaseProjectContractChange>
{

	public ProjectContractChange() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "project_contract_changes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectContractChange.CS_PROJECT_CONTRACT_CHANGE_ID;
		__column_names[1] = BaseProjectContractChange.CS_PLATE_ID;
		__column_names[2] = BaseProjectContractChange.CS_PROJECT_ID;
		__column_names[3] = BaseProjectContractChange.CS_INTEGRAL;
		__column_names[4] = BaseProjectContractChange.CS_PLATE_INTEGRAL;
		__column_names[5] = BaseProjectContractChange.CS_RECORD_DATE;
		__column_names[6] = BaseProjectContractChange.CS_IS_COMPLETED;
		__column_names[7] = BaseProjectContractChange.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseProjectContractChange.CS_OPERATE_TIME;
		__column_names[9] = BaseProjectContractChange.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectContractChange b) {
		clear();
		setProjectContractChangeIdClear(b.getProjectContractChangeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectContractChangeId() == null;
	}

	@Override
	public BaseProjectContractChange generateBase(){
		BaseProjectContractChange b = new BaseProjectContractChange();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectContractChange b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectContractChangeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlateIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectContractChange b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectContractChangeId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getIntegral();
		buff[count++] = b.getPlateIntegral();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectContractChange b){
		if(b.getProjectContractChangeId() != null) setProjectContractChangeIdClear(b.getProjectContractChangeId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getIntegral() != null) setIntegral(b.getIntegral());
		if(b.getPlateIntegral() != null) setPlateIntegral(b.getPlateIntegral());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectContractChange generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectContractChange b = new BaseProjectContractChange();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectContractChange __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectContractChangeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectContractChangeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectContractChangeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectContractChangeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setPlateIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getPlateIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[6]);
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

	public void setConditionProjectContractChangeId(String op, java.lang.Integer val) {
		setConditionProjectContractChangeId(op, val, CONDITION_AND);
	}

	public void setConditionProjectContractChangeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectContractChangeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
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

	public void setConditionIntegral(String op, java.math.BigDecimal val) {
		setConditionIntegral(op, val, CONDITION_AND);
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPlateIntegral(String op, java.math.BigDecimal val) {
		setConditionPlateIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPlateIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPlateIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
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

