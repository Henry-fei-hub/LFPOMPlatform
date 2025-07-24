package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTrainingManagementDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TrainingManagementDetail extends AbstractTable<BaseTrainingManagementDetail>
{

	public TrainingManagementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "training_management_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTrainingManagementDetail.CS_TRAINING_MANAGEMENT_DETAIL_ID;
		__column_names[1] = BaseTrainingManagementDetail.CS_TRAINING_MANAGEMENT_ID;
		__column_names[2] = BaseTrainingManagementDetail.CS_SIGN_IN_TIME;
		__column_names[3] = BaseTrainingManagementDetail.CS_SIGN_OUT_TIME;
		__column_names[4] = BaseTrainingManagementDetail.CS_SIGN_OUT_FLAG;
		__column_names[5] = BaseTrainingManagementDetail.CS_EMPLOYEE_ID;
		__column_names[6] = BaseTrainingManagementDetail.CS_EMPLOYEE_NUMBER;
		__column_names[7] = BaseTrainingManagementDetail.CS_DEPARTMENT_ID;
		__column_names[8] = BaseTrainingManagementDetail.CS_TRAINING_CONTENT;
		__column_names[9] = BaseTrainingManagementDetail.CS_TRAINING_METHOD;
		__column_names[10] = BaseTrainingManagementDetail.CS_TRAINING_FREQUENCY;
		__column_names[11] = BaseTrainingManagementDetail.CS_TRAINING_PERIOD;
		__column_names[12] = BaseTrainingManagementDetail.CS_SPARE_TIME_TRAINING;
		__column_names[13] = BaseTrainingManagementDetail.CS_SUGGEST;
		__column_names[14] = BaseTrainingManagementDetail.CS_COURSE_EVALUATION;
		__column_names[15] = BaseTrainingManagementDetail.CS_GUIDING_FUNCTION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTrainingManagementDetail b) {
		clear();
		setTrainingManagementDetailIdClear(b.getTrainingManagementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getTrainingManagementDetailId() == null;
	}

	@Override
	public BaseTrainingManagementDetail generateBase(){
		BaseTrainingManagementDetail b = new BaseTrainingManagementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTrainingManagementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTrainingManagementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignInTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSignOutTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSignOutFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingContent(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingMethod(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingFrequency(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTrainingPeriod(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSpareTimeTraining(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSuggest(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCourseEvaluation(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGuidingFunction(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseTrainingManagementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTrainingManagementDetailId();
		buff[count++] = b.getTrainingManagementId();
		buff[count++] = generateTimestampFromDate(b.getSignInTime());
		buff[count++] = generateTimestampFromDate(b.getSignOutTime());
		buff[count++] = b.getSignOutFlag();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNumber();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getTrainingContent();
		buff[count++] = b.getTrainingMethod();
		buff[count++] = b.getTrainingFrequency();
		buff[count++] = b.getTrainingPeriod();
		buff[count++] = b.getSpareTimeTraining();
		buff[count++] = b.getSuggest();
		buff[count++] = b.getCourseEvaluation();
		buff[count++] = b.getGuidingFunction();
	}

	@Override
	public void setDataFromBase(BaseTrainingManagementDetail b){
		if(b.getTrainingManagementDetailId() != null) setTrainingManagementDetailIdClear(b.getTrainingManagementDetailId());
		if(b.getTrainingManagementId() != null) setTrainingManagementId(b.getTrainingManagementId());
		if(b.getSignInTime() != null) setSignInTime(b.getSignInTime());
		if(b.getSignOutTime() != null) setSignOutTime(b.getSignOutTime());
		if(b.getSignOutFlag() != null) setSignOutFlag(b.getSignOutFlag());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNumber() != null) setEmployeeNumber(b.getEmployeeNumber());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getTrainingContent() != null) setTrainingContent(b.getTrainingContent());
		if(b.getTrainingMethod() != null) setTrainingMethod(b.getTrainingMethod());
		if(b.getTrainingFrequency() != null) setTrainingFrequency(b.getTrainingFrequency());
		if(b.getTrainingPeriod() != null) setTrainingPeriod(b.getTrainingPeriod());
		if(b.getSpareTimeTraining() != null) setSpareTimeTraining(b.getSpareTimeTraining());
		if(b.getSuggest() != null) setSuggest(b.getSuggest());
		if(b.getCourseEvaluation() != null) setCourseEvaluation(b.getCourseEvaluation());
		if(b.getGuidingFunction() != null) setGuidingFunction(b.getGuidingFunction());
	}

	@Override
	public BaseTrainingManagementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTrainingManagementDetail b = new BaseTrainingManagementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTrainingManagementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingManagementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignInTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignOutTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignOutFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingContent(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingMethod(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingFrequency(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrainingPeriod(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpareTimeTraining(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuggest(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCourseEvaluation(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGuidingFunction(GenericBase.__getInt(val));
	}

	public void setTrainingManagementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTrainingManagementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTrainingManagementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTrainingManagementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTrainingManagementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSignInTime(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getSignInTime() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setSignOutTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getSignOutTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setSignOutFlag(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getSignOutFlag() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setEmployeeNumber(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getEmployeeNumber() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setTrainingContent(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getTrainingContent() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setTrainingMethod(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getTrainingMethod() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setTrainingFrequency(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getTrainingFrequency() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setTrainingPeriod(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getTrainingPeriod() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setSpareTimeTraining(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getSpareTimeTraining() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setSuggest(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getSuggest() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setCourseEvaluation(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getCourseEvaluation() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setGuidingFunction(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getGuidingFunction() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setConditionTrainingManagementDetailId(String op, java.lang.Integer val) {
		setConditionTrainingManagementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionTrainingManagementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTrainingManagementDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTrainingManagementId(String op, java.lang.Integer val) {
		setConditionTrainingManagementId(op, val, CONDITION_AND);
	}

	public void setConditionTrainingManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTrainingManagementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSignInTime(String op, java.util.Date val) {
		setConditionSignInTime(op, val, CONDITION_AND);
	}

	public void setConditionSignInTime(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSignInTime(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSignOutTime(String op, java.util.Date val) {
		setConditionSignOutTime(op, val, CONDITION_AND);
	}

	public void setConditionSignOutTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSignOutTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSignOutFlag(String op, java.lang.Integer val) {
		setConditionSignOutFlag(op, val, CONDITION_AND);
	}

	public void setConditionSignOutFlag(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSignOutFlag(boolean val) {
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

	public void setConditionEmployeeNumber(String op, java.lang.String val) {
		setConditionEmployeeNumber(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNumber(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeNumber(boolean val) {
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

	public void setConditionTrainingContent(String op, java.lang.Integer val) {
		setConditionTrainingContent(op, val, CONDITION_AND);
	}

	public void setConditionTrainingContent(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTrainingContent(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTrainingMethod(String op, java.lang.Integer val) {
		setConditionTrainingMethod(op, val, CONDITION_AND);
	}

	public void setConditionTrainingMethod(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTrainingMethod(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTrainingFrequency(String op, java.lang.Integer val) {
		setConditionTrainingFrequency(op, val, CONDITION_AND);
	}

	public void setConditionTrainingFrequency(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTrainingFrequency(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTrainingPeriod(String op, java.lang.Integer val) {
		setConditionTrainingPeriod(op, val, CONDITION_AND);
	}

	public void setConditionTrainingPeriod(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTrainingPeriod(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSpareTimeTraining(String op, java.lang.Integer val) {
		setConditionSpareTimeTraining(op, val, CONDITION_AND);
	}

	public void setConditionSpareTimeTraining(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSpareTimeTraining(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSuggest(String op, java.lang.String val) {
		setConditionSuggest(op, val, CONDITION_AND);
	}

	public void setConditionSuggest(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSuggest(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCourseEvaluation(String op, java.lang.Integer val) {
		setConditionCourseEvaluation(op, val, CONDITION_AND);
	}

	public void setConditionCourseEvaluation(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCourseEvaluation(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionGuidingFunction(String op, java.lang.Integer val) {
		setConditionGuidingFunction(op, val, CONDITION_AND);
	}

	public void setConditionGuidingFunction(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectGuidingFunction(boolean val) {
		__select_flags[15] = val;
	}


}

