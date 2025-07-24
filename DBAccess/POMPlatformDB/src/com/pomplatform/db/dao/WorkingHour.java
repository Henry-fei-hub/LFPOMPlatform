package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseWorkingHour;


public class WorkingHour extends AbstractTable<BaseWorkingHour>
{

	public WorkingHour() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "working_hours";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseWorkingHour.CS_WORKING_HOUR_ID;
		__column_names[1] = BaseWorkingHour.CS_PROJECT_ID;
		__column_names[2] = BaseWorkingHour.CS_PROJECT_CODE;
		__column_names[3] = BaseWorkingHour.CS_PROJECT_NAME;
		__column_names[4] = BaseWorkingHour.CS_EMPLOYEE_ID;
		__column_names[5] = BaseWorkingHour.CS_EMPLOYEE_NO;
		__column_names[6] = BaseWorkingHour.CS_EMPLOYEE_NAME;
		__column_names[7] = BaseWorkingHour.CS_DEPARTMENT_ID;
		__column_names[8] = BaseWorkingHour.CS_PLATE_ID;
		__column_names[9] = BaseWorkingHour.CS_COMPANY_ID;
		__column_names[10] = BaseWorkingHour.CS_WORK_HOUR;
		__column_names[11] = BaseWorkingHour.CS_WORK_DATE;
		__column_names[12] = BaseWorkingHour.CS_REMARK;
		__column_names[13] = BaseWorkingHour.CS_CREATE_TIME;
		__column_names[14] = BaseWorkingHour.CS_IS_LOCK;
		__column_names[15] = BaseWorkingHour.CS_PERSONNEL_BUSINESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseWorkingHour b) {
		clear();
		setWorkingHourIdClear(b.getWorkingHourId());
	}

	public boolean isPrimaryKeyNull() {
		return getWorkingHourId() == null;
	}

	@Override
	public BaseWorkingHour generateBase(){
		BaseWorkingHour b = new BaseWorkingHour();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseWorkingHour b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setWorkingHourId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkHour(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWorkDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWorkingHourId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeNo(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCompanyId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWorkHour(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWorkDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsLock(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPersonnelBusinessId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseWorkingHour b, Object[] buff){
		int count = 0;
		buff[count++] = b.getWorkingHourId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getWorkHour();
		buff[count++] = generateTimestampFromDate(b.getWorkDate());
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getIsLock();
		buff[count++] = b.getPersonnelBusinessId();
	}

	@Override
	public void setDataFromBase(BaseWorkingHour b){
		if(b.getWorkingHourId() != null) setWorkingHourIdClear(b.getWorkingHourId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getWorkHour() != null) setWorkHour(b.getWorkHour());
		if(b.getWorkDate() != null) setWorkDate(b.getWorkDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
	}

	@Override
	public BaseWorkingHour generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseWorkingHour b = new BaseWorkingHour();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseWorkingHour __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkingHourId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkHour(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
	}

	public void setWorkingHourId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getWorkingHourId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setWorkingHourIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
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

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setWorkHour(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getWorkHour() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setWorkDate(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getWorkDate() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setConditionWorkingHourId(String op, java.lang.Integer val) {
		setConditionWorkingHourId(op, val, CONDITION_AND);
	}

	public void setConditionWorkingHourId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectWorkingHourId(boolean val) {
		__select_flags[0] = val;
	}

	public void setWorkingHourIdExpression(String val) {
		__dataExpressions[0] = val;
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

	public void setProjectIdExpression(String val) {
		__dataExpressions[1] = val;
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

	public void setProjectCodeExpression(String val) {
		__dataExpressions[2] = val;
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

	public void setProjectNameExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[5] = val;
	}

	public void setEmployeeNoExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[6] = val;
	}

	public void setEmployeeNameExpression(String val) {
		__dataExpressions[6] = val;
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

	public void setDepartmentIdExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[8] = val;
	}

	public void setPlateIdExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[9] = val;
	}

	public void setCompanyIdExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionWorkHour(String op, java.math.BigDecimal val) {
		setConditionWorkHour(op, val, CONDITION_AND);
	}

	public void setConditionWorkHour(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectWorkHour(boolean val) {
		__select_flags[10] = val;
	}

	public void setWorkHourExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionWorkDate(String op, java.util.Date val) {
		setConditionWorkDate(op, val, CONDITION_AND);
	}

	public void setConditionWorkDate(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectWorkDate(boolean val) {
		__select_flags[11] = val;
	}

	public void setWorkDateExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[12] = val;
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

	public void setCreateTimeExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[14] = val;
	}

	public void setIsLockExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[15] = val;
	}

	public void setPersonnelBusinessIdExpression(String val) {
		__dataExpressions[15] = val;
	}


}

