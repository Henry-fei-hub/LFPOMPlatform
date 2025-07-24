package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSoftwareUpdateVersion;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SoftwareUpdateVersion extends AbstractTable<BaseSoftwareUpdateVersion>
{

	public SoftwareUpdateVersion() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "software_update_versions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSoftwareUpdateVersion.CS_SOFTWARE_UPDATE_VERSION_ID;
		__column_names[1] = BaseSoftwareUpdateVersion.CS_VERSION_NO;
		__column_names[2] = BaseSoftwareUpdateVersion.CS_TITLE;
		__column_names[3] = BaseSoftwareUpdateVersion.CS_REMARK;
		__column_names[4] = BaseSoftwareUpdateVersion.CS_SOFTWARE_TYPE;
		__column_names[5] = BaseSoftwareUpdateVersion.CS_EMPLOYEE_ID;
		__column_names[6] = BaseSoftwareUpdateVersion.CS_CREATE_TIME;
		__column_names[7] = BaseSoftwareUpdateVersion.CS_SQL_SCRIPT;
		__column_names[8] = BaseSoftwareUpdateVersion.CS_IS_REBOOT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSoftwareUpdateVersion b) {
		clear();
		setSoftwareUpdateVersionIdClear(b.getSoftwareUpdateVersionId());
	}

	public boolean isPrimaryKeyNull() {
		return getSoftwareUpdateVersionId() == null;
	}

	@Override
	public BaseSoftwareUpdateVersion generateBase(){
		BaseSoftwareUpdateVersion b = new BaseSoftwareUpdateVersion();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSoftwareUpdateVersion b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSoftwareUpdateVersionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVersionNo(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSoftwareType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSqlScript(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsReboot(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseSoftwareUpdateVersion b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSoftwareUpdateVersionId();
		buff[count++] = b.getVersionNo();
		buff[count++] = b.getTitle();
		buff[count++] = b.getRemark();
		buff[count++] = b.getSoftwareType();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getSqlScript();
		buff[count++] = b.getIsReboot();
	}

	@Override
	public void setDataFromBase(BaseSoftwareUpdateVersion b){
		if(b.getSoftwareUpdateVersionId() != null) setSoftwareUpdateVersionIdClear(b.getSoftwareUpdateVersionId());
		if(b.getVersionNo() != null) setVersionNo(b.getVersionNo());
		if(b.getTitle() != null) setTitle(b.getTitle());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getSoftwareType() != null) setSoftwareType(b.getSoftwareType());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getSqlScript() != null) setSqlScript(b.getSqlScript());
		if(b.getIsReboot() != null) setIsReboot(b.getIsReboot());
	}

	@Override
	public BaseSoftwareUpdateVersion generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSoftwareUpdateVersion b = new BaseSoftwareUpdateVersion();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSoftwareUpdateVersion __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSoftwareUpdateVersionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVersionNo(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSoftwareType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSqlScript(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReboot(GenericBase.__getBoolean(val));
	}

	public void setSoftwareUpdateVersionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSoftwareUpdateVersionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSoftwareUpdateVersionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setVersionNo(java.math.BigDecimal val) {
		setCurrentData(1, val);
	}

	public java.math.BigDecimal getVersionNo() {
		return GenericBase.__getDecimal(__current_data[1]);
	}

	public void setTitle(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTitle() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setSoftwareType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getSoftwareType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setSqlScript(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSqlScript() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIsReboot(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsReboot() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setConditionSoftwareUpdateVersionId(String op, java.lang.Integer val) {
		setConditionSoftwareUpdateVersionId(op, val, CONDITION_AND);
	}

	public void setConditionSoftwareUpdateVersionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSoftwareUpdateVersionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionVersionNo(String op, java.math.BigDecimal val) {
		setConditionVersionNo(op, val, CONDITION_AND);
	}

	public void setConditionVersionNo(String op, java.math.BigDecimal val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectVersionNo(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTitle(String op, java.lang.String val) {
		setConditionTitle(op, val, CONDITION_AND);
	}

	public void setConditionTitle(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTitle(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSoftwareType(String op, java.lang.Integer val) {
		setConditionSoftwareType(op, val, CONDITION_AND);
	}

	public void setConditionSoftwareType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSoftwareType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
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

	public void setConditionSqlScript(String op, java.lang.String val) {
		setConditionSqlScript(op, val, CONDITION_AND);
	}

	public void setConditionSqlScript(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSqlScript(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsReboot(String op, java.lang.Boolean val) {
		setConditionIsReboot(op, val, CONDITION_AND);
	}

	public void setConditionIsReboot(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsReboot(boolean val) {
		__select_flags[8] = val;
	}


}

