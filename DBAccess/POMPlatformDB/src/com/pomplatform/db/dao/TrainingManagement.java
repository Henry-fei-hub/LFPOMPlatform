package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTrainingManagement;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TrainingManagement extends AbstractTable<BaseTrainingManagement>
{

	public TrainingManagement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 26;

		initTables();

		__tableName            = "training_managements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTrainingManagement.CS_TRAINING_MANAGEMENT_ID;
		__column_names[1] = BaseTrainingManagement.CS_SUBJECT;
		__column_names[2] = BaseTrainingManagement.CS_START_TIME;
		__column_names[3] = BaseTrainingManagement.CS_END_TIME;
		__column_names[4] = BaseTrainingManagement.CS_COMPERE_TYPE;
		__column_names[5] = BaseTrainingManagement.CS_COMPERE;
		__column_names[6] = BaseTrainingManagement.CS_EMPLOYEE_ID;
		__column_names[7] = BaseTrainingManagement.CS_DEPARTMENT_ID;
		__column_names[8] = BaseTrainingManagement.CS_SIGN_IN_DELAY;
		__column_names[9] = BaseTrainingManagement.CS_SIGN_OUT_DELAY;
		__column_names[10] = BaseTrainingManagement.CS_COURSE_SCORE;
		__column_names[11] = BaseTrainingManagement.CS_DETAIL;
		__column_names[12] = BaseTrainingManagement.CS_CREATE_PERSON_ID;
		__column_names[13] = BaseTrainingManagement.CS_CREATE_TIME;
		__column_names[14] = BaseTrainingManagement.CS_FILE_MANAGE_ID;
		__column_names[15] = BaseTrainingManagement.CS_STATUS;
		__column_names[16] = BaseTrainingManagement.CS_SITE;
		__column_names[17] = BaseTrainingManagement.CS_PLATE_ID;
		__column_names[18] = BaseTrainingManagement.CS_IS_SITE;
		__column_names[19] = BaseTrainingManagement.CS_TRAINING_TYPE;
		__column_names[20] = BaseTrainingManagement.CS_TRAINING_FEE;
		__column_names[21] = BaseTrainingManagement.CS_FILE_ID;
		__column_names[22] = BaseTrainingManagement.CS_FILE_URL;
		__column_names[23] = BaseTrainingManagement.CS_IS_SEND;
		__column_names[24] = BaseTrainingManagement.CS_PLATEIDS;
		__column_names[25] = BaseTrainingManagement.CS_DEPARTMENTIDS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTrainingManagement b) {
		clear();
		setTrainingManagementIdClear(b.getTrainingManagementId());
	}

	public boolean isPrimaryKeyNull() {
		return getTrainingManagementId() == null;
	}

	@Override
	public BaseTrainingManagement generateBase(){
		BaseTrainingManagement b = new BaseTrainingManagement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTrainingManagement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTrainingManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubject(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompereType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompere(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignInDelay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignOutDelay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCourseScore(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDetail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreatePersonId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFileManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSite(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsSite(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingFee(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSend(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateids(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentids(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTrainingManagement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTrainingManagementId();
		buff[count++] = b.getSubject();
		buff[count++] = generateTimestampFromDate(b.getStartTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = b.getCompereType();
		buff[count++] = b.getCompere();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getSignInDelay();
		buff[count++] = b.getSignOutDelay();
		buff[count++] = b.getCourseScore();
		buff[count++] = b.getDetail();
		buff[count++] = b.getCreatePersonId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getFileManageId();
		buff[count++] = b.getStatus();
		buff[count++] = b.getSite();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getIsSite();
		buff[count++] = b.getTrainingType();
		buff[count++] = b.getTrainingFee();
		buff[count++] = b.getFileId();
		buff[count++] = b.getFileUrl();
		buff[count++] = b.getIsSend();
		buff[count++] = b.getPlateids();
		buff[count++] = b.getDepartmentids();
	}

	@Override
	public void setDataFromBase(BaseTrainingManagement b){
		if(b.getTrainingManagementId() != null) setTrainingManagementIdClear(b.getTrainingManagementId());
		if(b.getSubject() != null) setSubject(b.getSubject());
		if(b.getStartTime() != null) setStartTime(b.getStartTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getCompereType() != null) setCompereType(b.getCompereType());
		if(b.getCompere() != null) setCompere(b.getCompere());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getSignInDelay() != null) setSignInDelay(b.getSignInDelay());
		if(b.getSignOutDelay() != null) setSignOutDelay(b.getSignOutDelay());
		if(b.getCourseScore() != null) setCourseScore(b.getCourseScore());
		if(b.getDetail() != null) setDetail(b.getDetail());
		if(b.getCreatePersonId() != null) setCreatePersonId(b.getCreatePersonId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getFileManageId() != null) setFileManageId(b.getFileManageId());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getSite() != null) setSite(b.getSite());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getIsSite() != null) setIsSite(b.getIsSite());
		if(b.getTrainingType() != null) setTrainingType(b.getTrainingType());
		if(b.getTrainingFee() != null) setTrainingFee(b.getTrainingFee());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getFileUrl() != null) setFileUrl(b.getFileUrl());
		if(b.getIsSend() != null) setIsSend(b.getIsSend());
		if(b.getPlateids() != null) setPlateids(b.getPlateids());
		if(b.getDepartmentids() != null) setDepartmentids(b.getDepartmentids());
	}

	@Override
	public BaseTrainingManagement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTrainingManagement b = new BaseTrainingManagement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTrainingManagement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubject(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompereType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompere(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignInDelay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignOutDelay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCourseScore(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatePersonId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSite(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSite(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingFee(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSend(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateids(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentids(GenericBase.__getString(val));
	}

	public void setTrainingManagementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTrainingManagementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTrainingManagementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSubject(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSubject() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setStartTime(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getStartTime() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setCompereType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCompereType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCompere(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getCompere() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setSignInDelay(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getSignInDelay() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setSignOutDelay(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getSignOutDelay() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setCourseScore(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getCourseScore() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setDetail(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getDetail() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setCreatePersonId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCreatePersonId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setFileManageId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getFileManageId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setSite(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getSite() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setIsSite(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getIsSite() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setTrainingType(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getTrainingType() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setTrainingFee(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getTrainingFee() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setFileUrl(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getFileUrl() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setIsSend(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getIsSend() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setPlateids(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getPlateids() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setDepartmentids(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getDepartmentids() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setConditionTrainingManagementId(String op, java.lang.Integer val) {
		setConditionTrainingManagementId(op, val, CONDITION_AND);
	}

	public void setConditionTrainingManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTrainingManagementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSubject(String op, java.lang.String val) {
		setConditionSubject(op, val, CONDITION_AND);
	}

	public void setConditionSubject(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSubject(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStartTime(String op, java.util.Date val) {
		setConditionStartTime(op, val, CONDITION_AND);
	}

	public void setConditionStartTime(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartTime(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCompereType(String op, java.lang.Integer val) {
		setConditionCompereType(op, val, CONDITION_AND);
	}

	public void setConditionCompereType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompereType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompere(String op, java.lang.String val) {
		setConditionCompere(op, val, CONDITION_AND);
	}

	public void setConditionCompere(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompere(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSignInDelay(String op, java.lang.Integer val) {
		setConditionSignInDelay(op, val, CONDITION_AND);
	}

	public void setConditionSignInDelay(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSignInDelay(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSignOutDelay(String op, java.lang.Integer val) {
		setConditionSignOutDelay(op, val, CONDITION_AND);
	}

	public void setConditionSignOutDelay(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSignOutDelay(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCourseScore(String op, java.lang.Integer val) {
		setConditionCourseScore(op, val, CONDITION_AND);
	}

	public void setConditionCourseScore(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCourseScore(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDetail(String op, java.lang.String val) {
		setConditionDetail(op, val, CONDITION_AND);
	}

	public void setConditionDetail(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDetail(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCreatePersonId(String op, java.lang.Integer val) {
		setConditionCreatePersonId(op, val, CONDITION_AND);
	}

	public void setConditionCreatePersonId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCreatePersonId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionFileManageId(String op, java.lang.Integer val) {
		setConditionFileManageId(op, val, CONDITION_AND);
	}

	public void setConditionFileManageId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectFileManageId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionSite(String op, java.lang.String val) {
		setConditionSite(op, val, CONDITION_AND);
	}

	public void setConditionSite(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectSite(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionIsSite(String op, java.lang.Integer val) {
		setConditionIsSite(op, val, CONDITION_AND);
	}

	public void setConditionIsSite(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectIsSite(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionTrainingType(String op, java.lang.Integer val) {
		setConditionTrainingType(op, val, CONDITION_AND);
	}

	public void setConditionTrainingType(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectTrainingType(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionTrainingFee(String op, java.lang.Integer val) {
		setConditionTrainingFee(op, val, CONDITION_AND);
	}

	public void setConditionTrainingFee(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectTrainingFee(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionFileUrl(String op, java.lang.String val) {
		setConditionFileUrl(op, val, CONDITION_AND);
	}

	public void setConditionFileUrl(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectFileUrl(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionIsSend(String op, java.lang.Integer val) {
		setConditionIsSend(op, val, CONDITION_AND);
	}

	public void setConditionIsSend(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectIsSend(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionPlateids(String op, java.lang.String val) {
		setConditionPlateids(op, val, CONDITION_AND);
	}

	public void setConditionPlateids(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectPlateids(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionDepartmentids(String op, java.lang.String val) {
		setConditionDepartmentids(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentids(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectDepartmentids(boolean val) {
		__select_flags[25] = val;
	}


}

