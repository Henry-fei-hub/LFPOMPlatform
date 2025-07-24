package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskTemplateDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskTemplateDetail extends AbstractTable<BaseCwdTaskTemplateDetail>
{

	public CwdTaskTemplateDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "cwd_task_template_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskTemplateDetail.CS_CWD_TASK_TEMPLATE_DETAIL_ID;
		__column_names[1] = BaseCwdTaskTemplateDetail.CS_CWD_TASK_TEMPLATE_ID;
		__column_names[2] = BaseCwdTaskTemplateDetail.CS_TASK_NAME;
		__column_names[3] = BaseCwdTaskTemplateDetail.CS_TASK_CONTENT;
		__column_names[4] = BaseCwdTaskTemplateDetail.CS_TASK_DEMAND;
		__column_names[5] = BaseCwdTaskTemplateDetail.CS_NUMBER_OF_DAY;
		__column_names[6] = BaseCwdTaskTemplateDetail.CS_PARENT_ID;
		__column_names[7] = BaseCwdTaskTemplateDetail.CS_ORDER_NUM;
		__column_names[8] = BaseCwdTaskTemplateDetail.CS_TASK_TYPE;
		__column_names[9] = BaseCwdTaskTemplateDetail.CS_TASK_LEVEL;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskTemplateDetail b) {
		clear();
		setCwdTaskTemplateDetailIdClear(b.getCwdTaskTemplateDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskTemplateDetailId() == null;
	}

	@Override
	public BaseCwdTaskTemplateDetail generateBase(){
		BaseCwdTaskTemplateDetail b = new BaseCwdTaskTemplateDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskTemplateDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskTemplateDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaskContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaskDemand(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNumberOfDay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskLevel(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskTemplateDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskTemplateDetailId();
		buff[count++] = b.getCwdTaskTemplateId();
		buff[count++] = b.getTaskName();
		buff[count++] = b.getTaskContent();
		buff[count++] = b.getTaskDemand();
		buff[count++] = b.getNumberOfDay();
		buff[count++] = b.getParentId();
		buff[count++] = b.getOrderNum();
		buff[count++] = b.getTaskType();
		buff[count++] = b.getTaskLevel();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskTemplateDetail b){
		if(b.getCwdTaskTemplateDetailId() != null) setCwdTaskTemplateDetailIdClear(b.getCwdTaskTemplateDetailId());
		if(b.getCwdTaskTemplateId() != null) setCwdTaskTemplateId(b.getCwdTaskTemplateId());
		if(b.getTaskName() != null) setTaskName(b.getTaskName());
		if(b.getTaskContent() != null) setTaskContent(b.getTaskContent());
		if(b.getTaskDemand() != null) setTaskDemand(b.getTaskDemand());
		if(b.getNumberOfDay() != null) setNumberOfDay(b.getNumberOfDay());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
		if(b.getTaskType() != null) setTaskType(b.getTaskType());
		if(b.getTaskLevel() != null) setTaskLevel(b.getTaskLevel());
	}

	@Override
	public BaseCwdTaskTemplateDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskTemplateDetail b = new BaseCwdTaskTemplateDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskTemplateDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskTemplateDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskDemand(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfDay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskLevel(GenericBase.__getInt(val));
	}

	public void setCwdTaskTemplateDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskTemplateDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskTemplateDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskTemplateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskTemplateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTaskName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTaskName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setTaskContent(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getTaskContent() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTaskDemand(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getTaskDemand() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setNumberOfDay(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getNumberOfDay() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setTaskType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getTaskType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setTaskLevel(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getTaskLevel() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setConditionCwdTaskTemplateDetailId(String op, java.lang.Integer val) {
		setConditionCwdTaskTemplateDetailId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskTemplateDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskTemplateDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskTemplateId(String op, java.lang.Integer val) {
		setConditionCwdTaskTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskTemplateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTaskName(String op, java.lang.String val) {
		setConditionTaskName(op, val, CONDITION_AND);
	}

	public void setConditionTaskName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTaskName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTaskContent(String op, java.lang.String val) {
		setConditionTaskContent(op, val, CONDITION_AND);
	}

	public void setConditionTaskContent(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTaskContent(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTaskDemand(String op, java.lang.String val) {
		setConditionTaskDemand(op, val, CONDITION_AND);
	}

	public void setConditionTaskDemand(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTaskDemand(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionNumberOfDay(String op, java.lang.Integer val) {
		setConditionNumberOfDay(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfDay(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectNumberOfDay(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTaskType(String op, java.lang.Integer val) {
		setConditionTaskType(op, val, CONDITION_AND);
	}

	public void setConditionTaskType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTaskType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTaskLevel(String op, java.lang.Integer val) {
		setConditionTaskLevel(op, val, CONDITION_AND);
	}

	public void setConditionTaskLevel(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTaskLevel(boolean val) {
		__select_flags[9] = val;
	}


}

