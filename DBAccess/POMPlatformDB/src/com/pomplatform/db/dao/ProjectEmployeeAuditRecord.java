package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectEmployeeAuditRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectEmployeeAuditRecord extends AbstractTable<BaseProjectEmployeeAuditRecord>
{

	public ProjectEmployeeAuditRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "project_employee_audit_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectEmployeeAuditRecord.CS_PROJECT_EMPLOYEE_AUDIT_RECORDS_ID;
		__column_names[1] = BaseProjectEmployeeAuditRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectEmployeeAuditRecord.CS_STAGE_ID;
		__column_names[3] = BaseProjectEmployeeAuditRecord.CS_EMPLOYEE_ID;
		__column_names[4] = BaseProjectEmployeeAuditRecord.CS_CHECK_EMPLOYEE_ID;
		__column_names[5] = BaseProjectEmployeeAuditRecord.CS_PLAN_INTEGRAL;
		__column_names[6] = BaseProjectEmployeeAuditRecord.CS_OLD_PLAN_INTEGRAL;
		__column_names[7] = BaseProjectEmployeeAuditRecord.CS_STATUS;
		__column_names[8] = BaseProjectEmployeeAuditRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[9] = BaseProjectEmployeeAuditRecord.CS_OPERATE_TIME;
		__column_names[10] = BaseProjectEmployeeAuditRecord.CS_REMARK;
		__column_names[11] = BaseProjectEmployeeAuditRecord.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectEmployeeAuditRecord b) {
		clear();
		setProjectEmployeeAuditRecordsIdClear(b.getProjectEmployeeAuditRecordsId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectEmployeeAuditRecordsId() == null;
	}

	@Override
	public BaseProjectEmployeeAuditRecord generateBase(){
		BaseProjectEmployeeAuditRecord b = new BaseProjectEmployeeAuditRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectEmployeeAuditRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectEmployeeAuditRecordsId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCheckEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOldPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectEmployeeAuditRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectEmployeeAuditRecordsId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getCheckEmployeeId();
		buff[count++] = b.getPlanIntegral();
		buff[count++] = b.getOldPlanIntegral();
		buff[count++] = b.getStatus();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseProjectEmployeeAuditRecord b){
		if(b.getProjectEmployeeAuditRecordsId() != null) setProjectEmployeeAuditRecordsIdClear(b.getProjectEmployeeAuditRecordsId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCheckEmployeeId() != null) setCheckEmployeeId(b.getCheckEmployeeId());
		if(b.getPlanIntegral() != null) setPlanIntegral(b.getPlanIntegral());
		if(b.getOldPlanIntegral() != null) setOldPlanIntegral(b.getOldPlanIntegral());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseProjectEmployeeAuditRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectEmployeeAuditRecord b = new BaseProjectEmployeeAuditRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectEmployeeAuditRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectEmployeeAuditRecordsId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOldPlanIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setProjectEmployeeAuditRecordsId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectEmployeeAuditRecordsId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectEmployeeAuditRecordsIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCheckEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCheckEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setPlanIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPlanIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setOldPlanIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getOldPlanIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionProjectEmployeeAuditRecordsId(String op, java.lang.Integer val) {
		setConditionProjectEmployeeAuditRecordsId(op, val, CONDITION_AND);
	}

	public void setConditionProjectEmployeeAuditRecordsId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectEmployeeAuditRecordsId(boolean val) {
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

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
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

	public void setConditionCheckEmployeeId(String op, java.lang.Integer val) {
		setConditionCheckEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCheckEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCheckEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPlanIntegral(String op, java.math.BigDecimal val) {
		setConditionPlanIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPlanIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPlanIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOldPlanIntegral(String op, java.math.BigDecimal val) {
		setConditionOldPlanIntegral(op, val, CONDITION_AND);
	}

	public void setConditionOldPlanIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOldPlanIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[11] = val;
	}


}

