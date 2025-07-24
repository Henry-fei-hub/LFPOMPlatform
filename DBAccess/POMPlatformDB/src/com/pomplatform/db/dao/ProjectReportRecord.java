package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectReportRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectReportRecord extends AbstractTable<BaseProjectReportRecord>
{

	public ProjectReportRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "project_report_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectReportRecord.CS_PROJECT_REPORT_RECORD_ID;
		__column_names[1] = BaseProjectReportRecord.CS_PLATE_ID;
		__column_names[2] = BaseProjectReportRecord.CS_PROJECT_ID;
		__column_names[3] = BaseProjectReportRecord.CS_SUBTRACT_COMPLAINT_INTEGRAL;
		__column_names[4] = BaseProjectReportRecord.CS_SURE_INTEGRAL;
		__column_names[5] = BaseProjectReportRecord.CS_PROJECT_COST;
		__column_names[6] = BaseProjectReportRecord.CS_RECORD_DATE;
		__column_names[7] = BaseProjectReportRecord.CS_IS_LOCK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectReportRecord b) {
		clear();
		setProjectReportRecordIdClear(b.getProjectReportRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectReportRecordId() == null;
	}

	@Override
	public BaseProjectReportRecord generateBase(){
		BaseProjectReportRecord b = new BaseProjectReportRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectReportRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectReportRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubtractComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectReportRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectReportRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getSubtractComplaintIntegral();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getProjectCost();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getIsLock();
	}

	@Override
	public void setDataFromBase(BaseProjectReportRecord b){
		if(b.getProjectReportRecordId() != null) setProjectReportRecordIdClear(b.getProjectReportRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getSubtractComplaintIntegral() != null) setSubtractComplaintIntegral(b.getSubtractComplaintIntegral());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getProjectCost() != null) setProjectCost(b.getProjectCost());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
	}

	@Override
	public BaseProjectReportRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectReportRecord b = new BaseProjectReportRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectReportRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectReportRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubtractComplaintIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
	}

	public void setProjectReportRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectReportRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectReportRecordIdClear(java.lang.Integer val) {
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

	public void setSubtractComplaintIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getSubtractComplaintIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setProjectCost(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getProjectCost() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setConditionProjectReportRecordId(String op, java.lang.Integer val) {
		setConditionProjectReportRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectReportRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectReportRecordId(boolean val) {
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

	public void setConditionSubtractComplaintIntegral(String op, java.math.BigDecimal val) {
		setConditionSubtractComplaintIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSubtractComplaintIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSubtractComplaintIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val) {
		setConditionProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectCost(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[7] = val;
	}


}

