package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskManage extends AbstractTable<BaseCwdTaskManage>
{

	public CwdTaskManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 31;

		initTables();

		__tableName            = "cwd_task_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskManage.CS_CWD_TASK_MANAGE_ID;
		__column_names[1] = BaseCwdTaskManage.CS_TASK_NAME;
		__column_names[2] = BaseCwdTaskManage.CS_TASK_STATUS;
		__column_names[3] = BaseCwdTaskManage.CS_TASK_TYPE;
		__column_names[4] = BaseCwdTaskManage.CS_TASK_LEVEL;
		__column_names[5] = BaseCwdTaskManage.CS_TASK_CONTENT;
		__column_names[6] = BaseCwdTaskManage.CS_TASK_DEMAND;
		__column_names[7] = BaseCwdTaskManage.CS_ASSIGNMENT_TYPE;
		__column_names[8] = BaseCwdTaskManage.CS_ASSIGNMENT_LINK_ID;
		__column_names[9] = BaseCwdTaskManage.CS_START_TIME;
		__column_names[10] = BaseCwdTaskManage.CS_END_TIME;
		__column_names[11] = BaseCwdTaskManage.CS_ACTUAL_START_TIME;
		__column_names[12] = BaseCwdTaskManage.CS_ACTUAL_END_TIME;
		__column_names[13] = BaseCwdTaskManage.CS_DEGREE_OF_COMPLETION;
		__column_names[14] = BaseCwdTaskManage.CS_REVIEW_THE_WAY;
		__column_names[15] = BaseCwdTaskManage.CS_MAIN_PROJECT_ID;
		__column_names[16] = BaseCwdTaskManage.CS_CONTRACT_ID;
		__column_names[17] = BaseCwdTaskManage.CS_PARENT_ID;
		__column_names[18] = BaseCwdTaskManage.CS_ORDER_NUM;
		__column_names[19] = BaseCwdTaskManage.CS_PROCESS_ID;
		__column_names[20] = BaseCwdTaskManage.CS_OPERATOR;
		__column_names[21] = BaseCwdTaskManage.CS_CREATE_TIME;
		__column_names[22] = BaseCwdTaskManage.CS_TASK_LEADER;
		__column_names[23] = BaseCwdTaskManage.CS_COMPANY_ID;
		__column_names[24] = BaseCwdTaskManage.CS_COMPANY_NO;
		__column_names[25] = BaseCwdTaskManage.CS_PROJECT_ID;
		__column_names[26] = BaseCwdTaskManage.CS_PLAN_STATUS;
		__column_names[27] = BaseCwdTaskManage.CS_COMPLETION_STATUS;
		__column_names[28] = BaseCwdTaskManage.CS_TASK_INTEGRAL;
		__column_names[29] = BaseCwdTaskManage.CS_TASK_INTEGRAL_PERCENT;
		__column_names[30] = BaseCwdTaskManage.CS_SPECIALTY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskManage b) {
		clear();
		setCwdTaskManageIdClear(b.getCwdTaskManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskManageId() == null;
	}

	@Override
	public BaseCwdTaskManage generateBase(){
		BaseCwdTaskManage b = new BaseCwdTaskManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaskStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaskDemand(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAssignmentType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAssignmentLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setActualStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setActualEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDegreeOfCompletion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReviewTheWay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTaskLeader(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlanStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompletionStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaskIntegralPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialtyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskManageId();
		buff[count++] = b.getTaskName();
		buff[count++] = b.getTaskStatus();
		buff[count++] = b.getTaskType();
		buff[count++] = b.getTaskLevel();
		buff[count++] = b.getTaskContent();
		buff[count++] = b.getTaskDemand();
		buff[count++] = b.getAssignmentType();
		buff[count++] = b.getAssignmentLinkId();
		buff[count++] = generateTimestampFromDate(b.getStartTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = generateTimestampFromDate(b.getActualStartTime());
		buff[count++] = generateTimestampFromDate(b.getActualEndTime());
		buff[count++] = b.getDegreeOfCompletion();
		buff[count++] = b.getReviewTheWay();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getParentId();
		buff[count++] = b.getOrderNum();
		buff[count++] = b.getProcessId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getTaskLeader();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getPlanStatus();
		buff[count++] = b.getCompletionStatus();
		buff[count++] = b.getTaskIntegral();
		buff[count++] = b.getTaskIntegralPercent();
		buff[count++] = b.getSpecialtyId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskManage b){
		if(b.getCwdTaskManageId() != null) setCwdTaskManageIdClear(b.getCwdTaskManageId());
		if(b.getTaskName() != null) setTaskName(b.getTaskName());
		if(b.getTaskStatus() != null) setTaskStatus(b.getTaskStatus());
		if(b.getTaskType() != null) setTaskType(b.getTaskType());
		if(b.getTaskLevel() != null) setTaskLevel(b.getTaskLevel());
		if(b.getTaskContent() != null) setTaskContent(b.getTaskContent());
		if(b.getTaskDemand() != null) setTaskDemand(b.getTaskDemand());
		if(b.getAssignmentType() != null) setAssignmentType(b.getAssignmentType());
		if(b.getAssignmentLinkId() != null) setAssignmentLinkId(b.getAssignmentLinkId());
		if(b.getStartTime() != null) setStartTime(b.getStartTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getActualStartTime() != null) setActualStartTime(b.getActualStartTime());
		if(b.getActualEndTime() != null) setActualEndTime(b.getActualEndTime());
		if(b.getDegreeOfCompletion() != null) setDegreeOfCompletion(b.getDegreeOfCompletion());
		if(b.getReviewTheWay() != null) setReviewTheWay(b.getReviewTheWay());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getTaskLeader() != null) setTaskLeader(b.getTaskLeader());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getPlanStatus() != null) setPlanStatus(b.getPlanStatus());
		if(b.getCompletionStatus() != null) setCompletionStatus(b.getCompletionStatus());
		if(b.getTaskIntegral() != null) setTaskIntegral(b.getTaskIntegral());
		if(b.getTaskIntegralPercent() != null) setTaskIntegralPercent(b.getTaskIntegralPercent());
		if(b.getSpecialtyId() != null) setSpecialtyId(b.getSpecialtyId());
	}

	@Override
	public BaseCwdTaskManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskManage b = new BaseCwdTaskManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskDemand(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignmentType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignmentLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualStartTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDegreeOfCompletion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReviewTheWay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskLeader(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompletionStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskIntegralPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialtyId(GenericBase.__getInt(val));
	}

	public void setCwdTaskManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTaskName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTaskName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setTaskStatus(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getTaskStatus() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTaskType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getTaskType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setTaskLevel(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getTaskLevel() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setTaskContent(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getTaskContent() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setTaskDemand(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getTaskDemand() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setAssignmentType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getAssignmentType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setAssignmentLinkId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getAssignmentLinkId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setStartTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getStartTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setActualStartTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getActualStartTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setActualEndTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getActualEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setDegreeOfCompletion(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getDegreeOfCompletion() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setReviewTheWay(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getReviewTheWay() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(21, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[21]);
	}

	public void setTaskLeader(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getTaskLeader() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setPlanStatus(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getPlanStatus() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setCompletionStatus(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getCompletionStatus() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setTaskIntegral(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getTaskIntegral() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setTaskIntegralPercent(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getTaskIntegralPercent() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setSpecialtyId(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getSpecialtyId() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val) {
		setConditionCwdTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTaskName(String op, java.lang.String val) {
		setConditionTaskName(op, val, CONDITION_AND);
	}

	public void setConditionTaskName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTaskName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTaskStatus(String op, java.lang.Integer val) {
		setConditionTaskStatus(op, val, CONDITION_AND);
	}

	public void setConditionTaskStatus(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTaskStatus(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTaskType(String op, java.lang.Integer val) {
		setConditionTaskType(op, val, CONDITION_AND);
	}

	public void setConditionTaskType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTaskType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTaskLevel(String op, java.lang.Integer val) {
		setConditionTaskLevel(op, val, CONDITION_AND);
	}

	public void setConditionTaskLevel(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTaskLevel(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTaskContent(String op, java.lang.String val) {
		setConditionTaskContent(op, val, CONDITION_AND);
	}

	public void setConditionTaskContent(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTaskContent(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTaskDemand(String op, java.lang.String val) {
		setConditionTaskDemand(op, val, CONDITION_AND);
	}

	public void setConditionTaskDemand(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTaskDemand(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAssignmentType(String op, java.lang.Integer val) {
		setConditionAssignmentType(op, val, CONDITION_AND);
	}

	public void setConditionAssignmentType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAssignmentType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAssignmentLinkId(String op, java.lang.Integer val) {
		setConditionAssignmentLinkId(op, val, CONDITION_AND);
	}

	public void setConditionAssignmentLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAssignmentLinkId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionStartTime(String op, java.util.Date val) {
		setConditionStartTime(op, val, CONDITION_AND);
	}

	public void setConditionStartTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionActualStartTime(String op, java.util.Date val) {
		setConditionActualStartTime(op, val, CONDITION_AND);
	}

	public void setConditionActualStartTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectActualStartTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionActualEndTime(String op, java.util.Date val) {
		setConditionActualEndTime(op, val, CONDITION_AND);
	}

	public void setConditionActualEndTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectActualEndTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDegreeOfCompletion(String op, java.math.BigDecimal val) {
		setConditionDegreeOfCompletion(op, val, CONDITION_AND);
	}

	public void setConditionDegreeOfCompletion(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDegreeOfCompletion(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionReviewTheWay(String op, java.lang.Integer val) {
		setConditionReviewTheWay(op, val, CONDITION_AND);
	}

	public void setConditionReviewTheWay(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectReviewTheWay(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(21, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionTaskLeader(String op, java.lang.Integer val) {
		setConditionTaskLeader(op, val, CONDITION_AND);
	}

	public void setConditionTaskLeader(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectTaskLeader(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionPlanStatus(String op, java.lang.Integer val) {
		setConditionPlanStatus(op, val, CONDITION_AND);
	}

	public void setConditionPlanStatus(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectPlanStatus(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionCompletionStatus(String op, java.lang.Integer val) {
		setConditionCompletionStatus(op, val, CONDITION_AND);
	}

	public void setConditionCompletionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectCompletionStatus(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionTaskIntegral(String op, java.math.BigDecimal val) {
		setConditionTaskIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTaskIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectTaskIntegral(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionTaskIntegralPercent(String op, java.math.BigDecimal val) {
		setConditionTaskIntegralPercent(op, val, CONDITION_AND);
	}

	public void setConditionTaskIntegralPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectTaskIntegralPercent(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionSpecialtyId(String op, java.lang.Integer val) {
		setConditionSpecialtyId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialtyId(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectSpecialtyId(boolean val) {
		__select_flags[30] = val;
	}


}

