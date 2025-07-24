package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseApproveProjectStageStorage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ApproveProjectStageStorage extends AbstractTable<BaseApproveProjectStageStorage>
{

	public ApproveProjectStageStorage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 14;

		initTables();

		__tableName            = "approve_project_stage_storages";

		__key_columns          = new int[1];
		__key_columns[0] = 9;

		__column_names[0] = BaseApproveProjectStageStorage.CS_PROJECT_ID;
		__column_names[1] = BaseApproveProjectStageStorage.CS_CONTRACT_CODE;
		__column_names[2] = BaseApproveProjectStageStorage.CS_PROJECT_CODE;
		__column_names[3] = BaseApproveProjectStageStorage.CS_PROJECT_NAME;
		__column_names[4] = BaseApproveProjectStageStorage.CS_PROJECT_TYPE;
		__column_names[5] = BaseApproveProjectStageStorage.CS_PLATE_ID;
		__column_names[6] = BaseApproveProjectStageStorage.CS_PROJECT_MANAGE_ID;
		__column_names[7] = BaseApproveProjectStageStorage.CS_PLATE_MANAGER_ID;
		__column_names[8] = BaseApproveProjectStageStorage.CS_DEPARTMENT_MANAGER_ID;
		__column_names[9] = BaseApproveProjectStageStorage.CS_APPROVE_PROJECT_STAGE_STORAGE_ID;
		__column_names[10] = BaseApproveProjectStageStorage.CS_PROCESS_TYPE;
		__column_names[11] = BaseApproveProjectStageStorage.CS_DELETE_FLAG;
		__column_names[12] = BaseApproveProjectStageStorage.CS_CREATE_TIME;
		__column_names[13] = BaseApproveProjectStageStorage.CS_EMPLOYEE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseApproveProjectStageStorage b) {
		clear();
		setApproveProjectStageStorageIdClear(b.getApproveProjectStageStorageId());
	}

	public boolean isPrimaryKeyNull() {
		return getApproveProjectStageStorageId() == null;
	}

	@Override
	public BaseApproveProjectStageStorage generateBase(){
		BaseApproveProjectStageStorage b = new BaseApproveProjectStageStorage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseApproveProjectStageStorage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApproveProjectStageStorageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseApproveProjectStageStorage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getPlateManagerId();
		buff[count++] = b.getDepartmentManagerId();
		buff[count++] = b.getApproveProjectStageStorageId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getEmployeeId();
	}

	@Override
	public void setDataFromBase(BaseApproveProjectStageStorage b){
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getPlateManagerId() != null) setPlateManagerId(b.getPlateManagerId());
		if(b.getDepartmentManagerId() != null) setDepartmentManagerId(b.getDepartmentManagerId());
		if(b.getApproveProjectStageStorageId() != null) setApproveProjectStageStorageIdClear(b.getApproveProjectStageStorageId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
	}

	@Override
	public BaseApproveProjectStageStorage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseApproveProjectStageStorage b = new BaseApproveProjectStageStorage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseApproveProjectStageStorage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApproveProjectStageStorageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}
	


	public void setContractCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setPlateManagerId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPlateManagerId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setDepartmentManagerId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDepartmentManagerId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setApproveProjectStageStorageId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getApproveProjectStageStorageId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setApproveProjectStageStorageIdClear(java.lang.Integer val) {
		__backup_data[9] = __current_data[9] =  val;
		__modified_flags[9] = false;
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}
	
	
	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(13, val);
	}
	
	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[13]);
	}
	
	
	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[13] = val;
	}
	

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPlateManagerId(String op, java.lang.Integer val) {
		setConditionPlateManagerId(op, val, CONDITION_AND);
	}

	public void setConditionPlateManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPlateManagerId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDepartmentManagerId(String op, java.lang.Integer val) {
		setConditionDepartmentManagerId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDepartmentManagerId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionApproveProjectStageStorageId(String op, java.lang.Integer val) {
		setConditionApproveProjectStageStorageId(op, val, CONDITION_AND);
	}

	public void setConditionApproveProjectStageStorageId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectApproveProjectStageStorageId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[12] = val;
	}
	
	


}

