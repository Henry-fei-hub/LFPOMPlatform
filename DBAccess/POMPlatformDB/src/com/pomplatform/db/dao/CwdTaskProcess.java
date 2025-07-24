package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskProcess;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskProcess extends AbstractTable<BaseCwdTaskProcess>
{

	public CwdTaskProcess() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "cwd_task_processes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskProcess.CS_CWD_TASK_PROCESS_ID;
		__column_names[1] = BaseCwdTaskProcess.CS_PROCESS_TYPE;
		__column_names[2] = BaseCwdTaskProcess.CS_EMPLOYEE_ID;
		__column_names[3] = BaseCwdTaskProcess.CS_EMPLOYEE_NO;
		__column_names[4] = BaseCwdTaskProcess.CS_DEPARTMENT_ID;
		__column_names[5] = BaseCwdTaskProcess.CS_COMPANY_ID;
		__column_names[6] = BaseCwdTaskProcess.CS_COMPANY_NO;
		__column_names[7] = BaseCwdTaskProcess.CS_CWD_TASK_MANAGE_ID;
		__column_names[8] = BaseCwdTaskProcess.CS_MAIN_PROJECT_ID;
		__column_names[9] = BaseCwdTaskProcess.CS_PROCESS_STATUS;
		__column_names[10] = BaseCwdTaskProcess.CS_REMARK;
		__column_names[11] = BaseCwdTaskProcess.CS_CREATE_TIME;
		__column_names[12] = BaseCwdTaskProcess.CS_COMPLETE_TIME;
		__column_names[13] = BaseCwdTaskProcess.CS_DELETE_FLAG;
		__column_names[14] = BaseCwdTaskProcess.CS_TITLE;
		__column_names[15] = BaseCwdTaskProcess.CS_DOCUMENT_TYPE;
		__column_names[16] = BaseCwdTaskProcess.CS_BASIC_FILE_TYPE;
		__column_names[17] = BaseCwdTaskProcess.CS_SPECIALTY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskProcess b) {
		clear();
		setCwdTaskProcessIdClear(b.getCwdTaskProcessId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskProcessId() == null;
	}

	@Override
	public BaseCwdTaskProcess generateBase(){
		BaseCwdTaskProcess b = new BaseCwdTaskProcess();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskProcess b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDocumentType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBasicFileType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSpecialtyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskProcess b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskProcessId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getCwdTaskManageId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getProcessStatus();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getCompleteTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getTitle();
		buff[count++] = b.getDocumentType();
		buff[count++] = b.getBasicFileType();
		buff[count++] = b.getSpecialtyId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskProcess b){
		if(b.getCwdTaskProcessId() != null) setCwdTaskProcessIdClear(b.getCwdTaskProcessId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getCwdTaskManageId() != null) setCwdTaskManageId(b.getCwdTaskManageId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCompleteTime() != null) setCompleteTime(b.getCompleteTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getTitle() != null) setTitle(b.getTitle());
		if(b.getDocumentType() != null) setDocumentType(b.getDocumentType());
		if(b.getBasicFileType() != null) setBasicFileType(b.getBasicFileType());
		if(b.getSpecialtyId() != null) setSpecialtyId(b.getSpecialtyId());
	}

	@Override
	public BaseCwdTaskProcess generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskProcess b = new BaseCwdTaskProcess();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskProcess __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDocumentType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicFileType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialtyId(GenericBase.__getInt(val));
	}

	public void setCwdTaskProcessId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskProcessIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setCwdTaskManageId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCwdTaskManageId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setCompleteTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getCompleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setTitle(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getTitle() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setDocumentType(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getDocumentType() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setBasicFileType(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getBasicFileType() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setSpecialtyId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getSpecialtyId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val) {
		setConditionCwdTaskProcessId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskProcessId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val) {
		setConditionCwdTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCwdTaskManageId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCompleteTime(String op, java.util.Date val) {
		setConditionCompleteTime(op, val, CONDITION_AND);
	}

	public void setConditionCompleteTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompleteTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTitle(String op, java.lang.String val) {
		setConditionTitle(op, val, CONDITION_AND);
	}

	public void setConditionTitle(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTitle(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDocumentType(String op, java.lang.Integer val) {
		setConditionDocumentType(op, val, CONDITION_AND);
	}

	public void setConditionDocumentType(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDocumentType(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionBasicFileType(String op, java.lang.Integer val) {
		setConditionBasicFileType(op, val, CONDITION_AND);
	}

	public void setConditionBasicFileType(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectBasicFileType(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionSpecialtyId(String op, java.lang.Integer val) {
		setConditionSpecialtyId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialtyId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectSpecialtyId(boolean val) {
		__select_flags[17] = val;
	}


}

