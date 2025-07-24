package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectStageStorage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectStageStorage extends AbstractTable<BaseProjectStageStorage>
{

	public ProjectStageStorage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "project_stage_storages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectStageStorage.CS_PROJECT_STAGE_STORAGE_ID;
		__column_names[1] = BaseProjectStageStorage.CS_PROJECT_ID;
		__column_names[2] = BaseProjectStageStorage.CS_STAGE_ID;
		__column_names[3] = BaseProjectStageStorage.CS_PERCENT;
		__column_names[4] = BaseProjectStageStorage.CS_PROJECT_AMOUNT;
		__column_names[5] = BaseProjectStageStorage.CS_STAGE_NAME;
		__column_names[6] = BaseProjectStageStorage.CS_REMARK;
		__column_names[7] = BaseProjectStageStorage.CS_RIGINAL_PLAN;
		__column_names[8] = BaseProjectStageStorage.CS_PROJECT_CONFIRM_AMOUNT;
		__column_names[9] = BaseProjectStageStorage.CS_TAB_AMOUNT;
		__column_names[10] = BaseProjectStageStorage.CS_PROJECT_TEMPLATE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectStageStorage b) {
		clear();
		setProjectStageStorageIdClear(b.getProjectStageStorageId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectStageStorageId() == null;
	}

	@Override
	public BaseProjectStageStorage generateBase(){
		BaseProjectStageStorage b = new BaseProjectStageStorage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectStageStorage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectStageStorageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRiginalPlan(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectConfirmAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTabAmount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectTemplateId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectStageStorage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectStageStorageId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getPercent();
		buff[count++] = b.getProjectAmount();
		buff[count++] = b.getStageName();
		buff[count++] = b.getRemark();
		buff[count++] = b.getRiginalPlan();
		buff[count++] = b.getProjectConfirmAmount();
		buff[count++] = b.getTabAmount();
		buff[count++] = b.getProjectTemplateId();
	}

	@Override
	public void setDataFromBase(BaseProjectStageStorage b){
		if(b.getProjectStageStorageId() != null) setProjectStageStorageIdClear(b.getProjectStageStorageId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getProjectAmount() != null) setProjectAmount(b.getProjectAmount());
		if(b.getStageName() != null) setStageName(b.getStageName());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getRiginalPlan() != null) setRiginalPlan(b.getRiginalPlan());
		if(b.getProjectConfirmAmount() != null) setProjectConfirmAmount(b.getProjectConfirmAmount());
		if(b.getTabAmount() != null) setTabAmount(b.getTabAmount());
		if(b.getProjectTemplateId() != null) setProjectTemplateId(b.getProjectTemplateId());
	}

	@Override
	public BaseProjectStageStorage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectStageStorage b = new BaseProjectStageStorage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectStageStorage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageStorageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRiginalPlan(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectConfirmAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTabAmount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
	}

	public void setProjectStageStorageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectStageStorageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectStageStorageIdClear(java.lang.Integer val) {
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

	public void setPercent(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPercent() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProjectAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getProjectAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setStageName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getStageName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setRiginalPlan(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getRiginalPlan() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setProjectConfirmAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getProjectConfirmAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setTabAmount(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getTabAmount() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProjectTemplateId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProjectTemplateId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionProjectStageStorageId(String op, java.lang.Integer val) {
		setConditionProjectStageStorageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectStageStorageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectStageStorageId(boolean val) {
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

	public void setConditionPercent(String op, java.lang.Integer val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val) {
		setConditionProjectAmount(op, val, CONDITION_AND);
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStageName(String op, java.lang.String val) {
		setConditionStageName(op, val, CONDITION_AND);
	}

	public void setConditionStageName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStageName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRiginalPlan(String op, java.lang.Integer val) {
		setConditionRiginalPlan(op, val, CONDITION_AND);
	}

	public void setConditionRiginalPlan(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRiginalPlan(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProjectConfirmAmount(String op, java.math.BigDecimal val) {
		setConditionProjectConfirmAmount(op, val, CONDITION_AND);
	}

	public void setConditionProjectConfirmAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectConfirmAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTabAmount(String op, java.lang.Integer val) {
		setConditionTabAmount(op, val, CONDITION_AND);
	}

	public void setConditionTabAmount(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTabAmount(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val) {
		setConditionProjectTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProjectTemplateId(boolean val) {
		__select_flags[10] = val;
	}


}

