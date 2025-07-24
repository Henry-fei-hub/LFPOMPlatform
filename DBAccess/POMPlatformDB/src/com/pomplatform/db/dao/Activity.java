package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseActivity;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Activity extends AbstractTable<BaseActivity>
{

	public Activity() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 22;

		initTables();

		__tableName            = "activities";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseActivity.CS_ACTIVITIE_ID;
		__column_names[1] = BaseActivity.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseActivity.CS_CUSTOMER_ID;
		__column_names[3] = BaseActivity.CS_CUSTOMER_NAME;
		__column_names[4] = BaseActivity.CS_PROJECT_NAME;
		__column_names[5] = BaseActivity.CS_MEET_TYPE;
		__column_names[6] = BaseActivity.CS_MEET_TIME;
		__column_names[7] = BaseActivity.CS_MEET_ADDRESS;
		__column_names[8] = BaseActivity.CS_MEET_TITLE;
		__column_names[9] = BaseActivity.CS_MEET_TARGET;
		__column_names[10] = BaseActivity.CS_CONTACT_NAME;
		__column_names[11] = BaseActivity.CS_THEIR_REQUIRE;
		__column_names[12] = BaseActivity.CS_THEIR_EMPLOYEES;
		__column_names[13] = BaseActivity.CS_OUR_EMPLOYEES;
		__column_names[14] = BaseActivity.CS_OPERATE_EMPLOYEE_ID;
		__column_names[15] = BaseActivity.CS_OPERATE_TIME;
		__column_names[16] = BaseActivity.CS_REMARK;
		__column_names[17] = BaseActivity.CS_OUR_DESIGNER_EMPLOYEES;
		__column_names[18] = BaseActivity.CS_PROVINCE;
		__column_names[19] = BaseActivity.CS_CITY;
		__column_names[20] = BaseActivity.CS_OUT_TIME_START;
		__column_names[21] = BaseActivity.CS_OUT_TIME_END;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseActivity b) {
		clear();
		setActivitieIdClear(b.getActivitieId());
	}

	public boolean isPrimaryKeyNull() {
		return getActivitieId() == null;
	}

	@Override
	public BaseActivity generateBase(){
		BaseActivity b = new BaseActivity();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseActivity b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setActivitieId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMeetAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetTarget(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTheirRequire(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTheirEmployees(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOurEmployees(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOurDesignerEmployees(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOutTimeStart(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOutTimeEnd(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseActivity b, Object[] buff){
		int count = 0;
		buff[count++] = b.getActivitieId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getCustomerId();
		buff[count++] = b.getCustomerName();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getMeetType();
		buff[count++] = generateTimestampFromDate(b.getMeetTime());
		buff[count++] = b.getMeetAddress();
		buff[count++] = b.getMeetTitle();
		buff[count++] = b.getMeetTarget();
		buff[count++] = b.getContactName();
		buff[count++] = b.getTheirRequire();
		buff[count++] = b.getTheirEmployees();
		buff[count++] = b.getOurEmployees();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getOurDesignerEmployees();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = generateTimestampFromDate(b.getOutTimeStart());
		buff[count++] = generateTimestampFromDate(b.getOutTimeEnd());
	}

	@Override
	public void setDataFromBase(BaseActivity b){
		if(b.getActivitieId() != null) setActivitieIdClear(b.getActivitieId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCustomerId() != null) setCustomerId(b.getCustomerId());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getMeetType() != null) setMeetType(b.getMeetType());
		if(b.getMeetTime() != null) setMeetTime(b.getMeetTime());
		if(b.getMeetAddress() != null) setMeetAddress(b.getMeetAddress());
		if(b.getMeetTitle() != null) setMeetTitle(b.getMeetTitle());
		if(b.getMeetTarget() != null) setMeetTarget(b.getMeetTarget());
		if(b.getContactName() != null) setContactName(b.getContactName());
		if(b.getTheirRequire() != null) setTheirRequire(b.getTheirRequire());
		if(b.getTheirEmployees() != null) setTheirEmployees(b.getTheirEmployees());
		if(b.getOurEmployees() != null) setOurEmployees(b.getOurEmployees());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOurDesignerEmployees() != null) setOurDesignerEmployees(b.getOurDesignerEmployees());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getOutTimeStart() != null) setOutTimeStart(b.getOutTimeStart());
		if(b.getOutTimeEnd() != null) setOutTimeEnd(b.getOutTimeEnd());
	}

	@Override
	public BaseActivity generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseActivity b = new BaseActivity();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseActivity __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActivitieId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetTarget(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTheirRequire(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTheirEmployees(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOurEmployees(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOurDesignerEmployees(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTimeStart(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTimeEnd(GenericBase.__getDateFromSQL(val));
	}

	public void setActivitieId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getActivitieId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setActivitieIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCustomerId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCustomerId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setMeetType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getMeetType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMeetTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getMeetTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setMeetAddress(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMeetAddress() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setMeetTitle(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getMeetTitle() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setMeetTarget(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getMeetTarget() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setContactName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getContactName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setTheirRequire(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getTheirRequire() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setTheirEmployees(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getTheirEmployees() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setOurEmployees(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getOurEmployees() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setOurDesignerEmployees(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getOurDesignerEmployees() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setProvince(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getProvince() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setCity(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getCity() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setOutTimeStart(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getOutTimeStart() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setOutTimeEnd(java.util.Date val) {
		setCurrentData(21, generateTimestampFromDate(val));
	}

	public java.util.Date getOutTimeEnd() {
		return GenericBase.__getDateFromSQL(__current_data[21]);
	}

	public void setConditionActivitieId(String op, java.lang.Integer val) {
		setConditionActivitieId(op, val, CONDITION_AND);
	}

	public void setConditionActivitieId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectActivitieId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCustomerId(String op, java.lang.Integer val) {
		setConditionCustomerId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCustomerId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMeetType(String op, java.lang.Integer val) {
		setConditionMeetType(op, val, CONDITION_AND);
	}

	public void setConditionMeetType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMeetType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMeetTime(String op, java.util.Date val) {
		setConditionMeetTime(op, val, CONDITION_AND);
	}

	public void setConditionMeetTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMeetTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMeetAddress(String op, java.lang.String val) {
		setConditionMeetAddress(op, val, CONDITION_AND);
	}

	public void setConditionMeetAddress(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMeetAddress(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMeetTitle(String op, java.lang.String val) {
		setConditionMeetTitle(op, val, CONDITION_AND);
	}

	public void setConditionMeetTitle(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMeetTitle(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMeetTarget(String op, java.lang.String val) {
		setConditionMeetTarget(op, val, CONDITION_AND);
	}

	public void setConditionMeetTarget(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMeetTarget(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionContactName(String op, java.lang.String val) {
		setConditionContactName(op, val, CONDITION_AND);
	}

	public void setConditionContactName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectContactName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTheirRequire(String op, java.lang.String val) {
		setConditionTheirRequire(op, val, CONDITION_AND);
	}

	public void setConditionTheirRequire(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTheirRequire(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTheirEmployees(String op, java.lang.String val) {
		setConditionTheirEmployees(op, val, CONDITION_AND);
	}

	public void setConditionTheirEmployees(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTheirEmployees(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOurEmployees(String op, java.lang.String val) {
		setConditionOurEmployees(op, val, CONDITION_AND);
	}

	public void setConditionOurEmployees(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectOurEmployees(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOurDesignerEmployees(String op, java.lang.String val) {
		setConditionOurDesignerEmployees(op, val, CONDITION_AND);
	}

	public void setConditionOurDesignerEmployees(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectOurDesignerEmployees(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionProvince(String op, java.lang.String val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCity(String op, java.lang.String val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOutTimeStart(String op, java.util.Date val) {
		setConditionOutTimeStart(op, val, CONDITION_AND);
	}

	public void setConditionOutTimeStart(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOutTimeStart(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionOutTimeEnd(String op, java.util.Date val) {
		setConditionOutTimeEnd(op, val, CONDITION_AND);
	}

	public void setConditionOutTimeEnd(String op, java.util.Date val, String relation) {
		addCondition(21, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOutTimeEnd(boolean val) {
		__select_flags[21] = val;
	}


}

