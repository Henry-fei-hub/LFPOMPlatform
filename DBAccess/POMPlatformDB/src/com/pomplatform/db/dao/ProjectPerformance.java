package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectPerformance;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectPerformance extends AbstractTable<BaseProjectPerformance>
{

	public ProjectPerformance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "project_performances";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectPerformance.CS_PROJECT_PERFORMANCE_ID;
		__column_names[1] = BaseProjectPerformance.CS_CONTRACT_ID;
		__column_names[2] = BaseProjectPerformance.CS_PROJECT_ID;
		__column_names[3] = BaseProjectPerformance.CS_INTEGRAL;
		__column_names[4] = BaseProjectPerformance.CS_PERCENT;
		__column_names[5] = BaseProjectPerformance.CS_PERFORMANCE_INTEGRAL;
		__column_names[6] = BaseProjectPerformance.CS_EMPLOYEE_ID;
		__column_names[7] = BaseProjectPerformance.CS_RECORD_DATE;
		__column_names[8] = BaseProjectPerformance.CS_CLIENT_COMPLAINT;
		__column_names[9] = BaseProjectPerformance.CS_REASON;
		__column_names[10] = BaseProjectPerformance.CS_IS_SUBMIT;
		__column_names[11] = BaseProjectPerformance.CS_PERFORMANCE_FLAG;
		__column_names[12] = BaseProjectPerformance.CS_BUSINESS_TYPE;
		__column_names[13] = BaseProjectPerformance.CS_OPERATE_EMPLOYEE_ID;
		__column_names[14] = BaseProjectPerformance.CS_OPERATE_TIME;
		__column_names[15] = BaseProjectPerformance.CS_REMARK;
		__column_names[16] = BaseProjectPerformance.CS_TYPE;
		__column_names[17] = BaseProjectPerformance.CS_IS_SETTLEMENT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectPerformance b) {
		clear();
		setProjectPerformanceIdClear(b.getProjectPerformanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectPerformanceId() == null;
	}

	@Override
	public BaseProjectPerformance generateBase(){
		BaseProjectPerformance b = new BaseProjectPerformance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectPerformance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectPerformanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPerformanceIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setClientComplaint(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSubmit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setPerformanceFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsSettlement(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectPerformance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectPerformanceId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getIntegral();
		buff[count++] = b.getPercent();
		buff[count++] = b.getPerformanceIntegral();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getClientComplaint();
		buff[count++] = b.getReason();
		buff[count++] = b.getIsSubmit();
		buff[count++] = b.getPerformanceFlag();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getType();
		buff[count++] = b.getIsSettlement();
	}

	@Override
	public void setDataFromBase(BaseProjectPerformance b){
		if(b.getProjectPerformanceId() != null) setProjectPerformanceIdClear(b.getProjectPerformanceId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getIntegral() != null) setIntegral(b.getIntegral());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getPerformanceIntegral() != null) setPerformanceIntegral(b.getPerformanceIntegral());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getClientComplaint() != null) setClientComplaint(b.getClientComplaint());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getIsSubmit() != null) setIsSubmit(b.getIsSubmit());
		if(b.getPerformanceFlag() != null) setPerformanceFlag(b.getPerformanceFlag());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getType() != null) setType(b.getType());
		if(b.getIsSettlement() != null) setIsSettlement(b.getIsSettlement());
	}

	@Override
	public BaseProjectPerformance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectPerformance b = new BaseProjectPerformance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectPerformance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectPerformanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientComplaint(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSubmit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSettlement(GenericBase.__getBoolean(val));
	}

	public void setProjectPerformanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectPerformanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectPerformanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setPerformanceIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPerformanceIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setClientComplaint(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getClientComplaint() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setIsSubmit(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsSubmit() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setPerformanceFlag(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getPerformanceFlag() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setIsSettlement(java.lang.Boolean val) {
		setCurrentData(17, val);
	}

	public java.lang.Boolean getIsSettlement() {
		return GenericBase.__getBoolean(__current_data[17]);
	}

	public void setConditionProjectPerformanceId(String op, java.lang.Integer val) {
		setConditionProjectPerformanceId(op, val, CONDITION_AND);
	}

	public void setConditionProjectPerformanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectPerformanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val) {
		setConditionIntegral(op, val, CONDITION_AND);
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPerformanceIntegral(String op, java.math.BigDecimal val) {
		setConditionPerformanceIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPerformanceIntegral(boolean val) {
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

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionClientComplaint(String op, java.lang.String val) {
		setConditionClientComplaint(op, val, CONDITION_AND);
	}

	public void setConditionClientComplaint(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectClientComplaint(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionIsSubmit(String op, java.lang.Boolean val) {
		setConditionIsSubmit(op, val, CONDITION_AND);
	}

	public void setConditionIsSubmit(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsSubmit(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionPerformanceFlag(String op, java.lang.Integer val) {
		setConditionPerformanceFlag(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceFlag(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPerformanceFlag(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionIsSettlement(String op, java.lang.Boolean val) {
		setConditionIsSettlement(op, val, CONDITION_AND);
	}

	public void setConditionIsSettlement(String op, java.lang.Boolean val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectIsSettlement(boolean val) {
		__select_flags[17] = val;
	}


}

