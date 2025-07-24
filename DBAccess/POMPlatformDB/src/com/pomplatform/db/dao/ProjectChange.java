package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectChange;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectChange extends AbstractTable<BaseProjectChange>
{

	public ProjectChange() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 20;

		initTables();

		__tableName            = "project_changes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectChange.CS_PROJECT_CHANGE_ID;
		__column_names[1] = BaseProjectChange.CS_CONTRACT_CHANGE_ID;
		__column_names[2] = BaseProjectChange.CS_PROJECT_ID;
		__column_names[3] = BaseProjectChange.CS_SHEET_AMOUNT;
		__column_names[4] = BaseProjectChange.CS_SHEET_CHANGE_AMOUNT;
		__column_names[5] = BaseProjectChange.CS_SHEET_FINAL_AMOUNT;
		__column_names[6] = BaseProjectChange.CS_SHEET_CHANGE_VIEW;
		__column_names[7] = BaseProjectChange.CS_TOTAL_INTEGRAL;
		__column_names[8] = BaseProjectChange.CS_TOTAL_CHANGE_INTEGRAL;
		__column_names[9] = BaseProjectChange.CS_TOTAL_FINAL_INTEGRAL;
		__column_names[10] = BaseProjectChange.CS_TOTAL_CHANGE_VIEW;
		__column_names[11] = BaseProjectChange.CS_COMMON_AREA;
		__column_names[12] = BaseProjectChange.CS_LOGISTICS_AREA;
		__column_names[13] = BaseProjectChange.CS_DESIGN_AREA;
		__column_names[14] = BaseProjectChange.CS_COMPLAINT_PERCENTAGE;
		__column_names[15] = BaseProjectChange.CS_COMPLAINT_INTEGRAL;
		__column_names[16] = BaseProjectChange.CS_FLAG;
		__column_names[17] = BaseProjectChange.CS_OPERATE_EMPLOYEE_ID;
		__column_names[18] = BaseProjectChange.CS_OPERATE_TIME;
		__column_names[19] = BaseProjectChange.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectChange b) {
		clear();
		setProjectChangeIdClear(b.getProjectChangeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectChangeId() == null;
	}

	@Override
	public BaseProjectChange generateBase(){
		BaseProjectChange b = new BaseProjectChange();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectChange b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectChangeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractChangeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSheetChangeAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSheetFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSheetChangeView(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalChangeIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalFinalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalChangeView(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectChange b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectChangeId();
		buff[count++] = b.getContractChangeId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getSheetAmount();
		buff[count++] = b.getSheetChangeAmount();
		buff[count++] = b.getSheetFinalAmount();
		buff[count++] = b.getSheetChangeView();
		buff[count++] = b.getTotalIntegral();
		buff[count++] = b.getTotalChangeIntegral();
		buff[count++] = b.getTotalFinalIntegral();
		buff[count++] = b.getTotalChangeView();
		buff[count++] = b.getCommonArea();
		buff[count++] = b.getLogisticsArea();
		buff[count++] = b.getDesignArea();
		buff[count++] = b.getComplaintPercentage();
		buff[count++] = b.getComplaintIntegral();
		buff[count++] = b.getFlag();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectChange b){
		if(b.getProjectChangeId() != null) setProjectChangeIdClear(b.getProjectChangeId());
		if(b.getContractChangeId() != null) setContractChangeId(b.getContractChangeId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getSheetAmount() != null) setSheetAmount(b.getSheetAmount());
		if(b.getSheetChangeAmount() != null) setSheetChangeAmount(b.getSheetChangeAmount());
		if(b.getSheetFinalAmount() != null) setSheetFinalAmount(b.getSheetFinalAmount());
		if(b.getSheetChangeView() != null) setSheetChangeView(b.getSheetChangeView());
		if(b.getTotalIntegral() != null) setTotalIntegral(b.getTotalIntegral());
		if(b.getTotalChangeIntegral() != null) setTotalChangeIntegral(b.getTotalChangeIntegral());
		if(b.getTotalFinalIntegral() != null) setTotalFinalIntegral(b.getTotalFinalIntegral());
		if(b.getTotalChangeView() != null) setTotalChangeView(b.getTotalChangeView());
		if(b.getCommonArea() != null) setCommonArea(b.getCommonArea());
		if(b.getLogisticsArea() != null) setLogisticsArea(b.getLogisticsArea());
		if(b.getDesignArea() != null) setDesignArea(b.getDesignArea());
		if(b.getComplaintPercentage() != null) setComplaintPercentage(b.getComplaintPercentage());
		if(b.getComplaintIntegral() != null) setComplaintIntegral(b.getComplaintIntegral());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectChange generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectChange b = new BaseProjectChange();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectChange __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectChangeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractChangeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetChangeAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetChangeView(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalChangeIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalFinalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalChangeView(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectChangeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectChangeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectChangeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractChangeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractChangeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSheetAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getSheetAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setSheetChangeAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getSheetChangeAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setSheetFinalAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getSheetFinalAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setSheetChangeView(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getSheetChangeView() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setTotalChangeIntegral(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getTotalChangeIntegral() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setTotalFinalIntegral(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getTotalFinalIntegral() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setTotalChangeView(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getTotalChangeView() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setCommonArea(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getCommonArea() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setLogisticsArea(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getLogisticsArea() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setComplaintPercentage(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setComplaintIntegral(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setConditionProjectChangeId(String op, java.lang.Integer val) {
		setConditionProjectChangeId(op, val, CONDITION_AND);
	}

	public void setConditionProjectChangeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectChangeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractChangeId(String op, java.lang.Integer val) {
		setConditionContractChangeId(op, val, CONDITION_AND);
	}

	public void setConditionContractChangeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractChangeId(boolean val) {
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

	public void setConditionSheetAmount(String op, java.math.BigDecimal val) {
		setConditionSheetAmount(op, val, CONDITION_AND);
	}

	public void setConditionSheetAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSheetAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSheetChangeAmount(String op, java.math.BigDecimal val) {
		setConditionSheetChangeAmount(op, val, CONDITION_AND);
	}

	public void setConditionSheetChangeAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSheetChangeAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSheetFinalAmount(String op, java.math.BigDecimal val) {
		setConditionSheetFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionSheetFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSheetFinalAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSheetChangeView(String op, java.lang.String val) {
		setConditionSheetChangeView(op, val, CONDITION_AND);
	}

	public void setConditionSheetChangeView(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSheetChangeView(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTotalIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTotalChangeIntegral(String op, java.math.BigDecimal val) {
		setConditionTotalChangeIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTotalChangeIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTotalChangeIntegral(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTotalFinalIntegral(String op, java.math.BigDecimal val) {
		setConditionTotalFinalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTotalFinalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTotalFinalIntegral(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTotalChangeView(String op, java.lang.String val) {
		setConditionTotalChangeView(op, val, CONDITION_AND);
	}

	public void setConditionTotalChangeView(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTotalChangeView(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val) {
		setConditionCommonArea(op, val, CONDITION_AND);
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCommonArea(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val) {
		setConditionLogisticsArea(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectLogisticsArea(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val) {
		setConditionComplaintPercentage(op, val, CONDITION_AND);
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectComplaintPercentage(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val) {
		setConditionComplaintIntegral(op, val, CONDITION_AND);
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectComplaintIntegral(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[19] = val;
	}


}

