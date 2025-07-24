package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseManageProject;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ManageProject extends AbstractTable<BaseManageProject>
{

	public ManageProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "manage_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseManageProject.CS_MANAGE_PROJECT_ID;
		__column_names[1] = BaseManageProject.CS_MANAGE_PROJECT_NAME;
		__column_names[2] = BaseManageProject.CS_TOTAL_INTEGRAL;
		__column_names[3] = BaseManageProject.CS_PLATE_ID;
		__column_names[4] = BaseManageProject.CS_PROJECT_DATE;
		__column_names[5] = BaseManageProject.CS_REMARK;
		__column_names[6] = BaseManageProject.CS_LEFT_INTEGRAL;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseManageProject b) {
		clear();
		setManageProjectIdClear(b.getManageProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getManageProjectId() == null;
	}

	@Override
	public BaseManageProject generateBase(){
		BaseManageProject b = new BaseManageProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseManageProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setManageProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setManageProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLeftIntegral(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseManageProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getManageProjectId();
		buff[count++] = b.getManageProjectName();
		buff[count++] = b.getTotalIntegral();
		buff[count++] = b.getPlateId();
		buff[count++] = generateTimestampFromDate(b.getProjectDate());
		buff[count++] = b.getRemark();
		buff[count++] = b.getLeftIntegral();
	}

	@Override
	public void setDataFromBase(BaseManageProject b){
		if(b.getManageProjectId() != null) setManageProjectIdClear(b.getManageProjectId());
		if(b.getManageProjectName() != null) setManageProjectName(b.getManageProjectName());
		if(b.getTotalIntegral() != null) setTotalIntegral(b.getTotalIntegral());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getProjectDate() != null) setProjectDate(b.getProjectDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getLeftIntegral() != null) setLeftIntegral(b.getLeftIntegral());
	}

	@Override
	public BaseManageProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseManageProject b = new BaseManageProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseManageProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManageProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManageProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
	}

	public void setManageProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getManageProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setManageProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setManageProjectName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getManageProjectName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProjectDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getProjectDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setLeftIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getLeftIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setConditionManageProjectId(String op, java.lang.Integer val) {
		setConditionManageProjectId(op, val, CONDITION_AND);
	}

	public void setConditionManageProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectManageProjectId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionManageProjectName(String op, java.lang.String val) {
		setConditionManageProjectName(op, val, CONDITION_AND);
	}

	public void setConditionManageProjectName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectManageProjectName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTotalIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectDate(String op, java.util.Date val) {
		setConditionProjectDate(op, val, CONDITION_AND);
	}

	public void setConditionProjectDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProjectDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionLeftIntegral(String op, java.math.BigDecimal val) {
		setConditionLeftIntegral(op, val, CONDITION_AND);
	}

	public void setConditionLeftIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectLeftIntegral(boolean val) {
		__select_flags[6] = val;
	}


}

