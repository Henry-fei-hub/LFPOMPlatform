package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectEmployee;


public class ProjectEmployee extends AbstractTable<BaseProjectEmployee>
{

	public ProjectEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 23;

		initTables();

		__tableName            = "project_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectEmployee.CS_PROJECT_EMPLOYEE_ID;
		__column_names[1] = BaseProjectEmployee.CS_PROJECT_ID;
		__column_names[2] = BaseProjectEmployee.CS_EMPLOYEE_ID;
		__column_names[3] = BaseProjectEmployee.CS_DESIGN_PHASE;
		__column_names[4] = BaseProjectEmployee.CS_PLAN_WORK_HOURS;
		__column_names[5] = BaseProjectEmployee.CS_REAL_WORK_HOURS;
		__column_names[6] = BaseProjectEmployee.CS_PLAN_INTEGRAL;
		__column_names[7] = BaseProjectEmployee.CS_REAL_INTEGRAL;
		__column_names[8] = BaseProjectEmployee.CS_PLAN_START_DATE;
		__column_names[9] = BaseProjectEmployee.CS_PLAN_END_DATE;
		__column_names[10] = BaseProjectEmployee.CS_START_DATE;
		__column_names[11] = BaseProjectEmployee.CS_END_DATE;
		__column_names[12] = BaseProjectEmployee.CS_WORK_CONTENT;
		__column_names[13] = BaseProjectEmployee.CS_ALTERNATE_FIELD1;
		__column_names[14] = BaseProjectEmployee.CS_ALTERNATE_FIELD2;
		__column_names[15] = BaseProjectEmployee.CS_ALTERNATE_FIELD3;
		__column_names[16] = BaseProjectEmployee.CS_STATUS;
		__column_names[17] = BaseProjectEmployee.CS_COST;
		__column_names[18] = BaseProjectEmployee.CS_SETTLEMENT;
		__column_names[19] = BaseProjectEmployee.CS_EMPLOYEE_ACHIEVE_INTEGRAL_RETURN;
		__column_names[20] = BaseProjectEmployee.CS_STAGE_ID;
		__column_names[21] = BaseProjectEmployee.CS_FLAG;
		__column_names[22] = BaseProjectEmployee.CS_BUSINESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectEmployee b) {
		clear();
		setProjectEmployeeIdClear(b.getProjectEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectEmployeeId() == null;
	}

	@Override
	public BaseProjectEmployee generateBase(){
		BaseProjectEmployee b = new BaseProjectEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignPhase(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlanWorkHours(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRealWorkHours(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setWorkContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField1(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField2(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField3(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSettlement(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setProjectEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignPhase(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlanWorkHours(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRealWorkHours(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlanIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRealIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlanStartDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlanEndDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStartDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWorkContent(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAlternateField1(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAlternateField2(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAlternateField3(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCost(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSettlement(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFlag(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectEmployeeId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDesignPhase();
		buff[count++] = b.getPlanWorkHours();
		buff[count++] = b.getRealWorkHours();
		buff[count++] = b.getPlanIntegral();
		buff[count++] = b.getRealIntegral();
		buff[count++] = generateTimestampFromDate(b.getPlanStartDate());
		buff[count++] = generateTimestampFromDate(b.getPlanEndDate());
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getWorkContent();
		buff[count++] = b.getAlternateField1();
		buff[count++] = b.getAlternateField2();
		buff[count++] = b.getAlternateField3();
		buff[count++] = b.getStatus();
		buff[count++] = b.getCost();
		buff[count++] = b.getSettlement();
		buff[count++] = b.getEmployeeAchieveIntegralReturn();
		buff[count++] = b.getStageId();
		buff[count++] = b.getFlag();
		buff[count++] = b.getBusinessId();
	}

	@Override
	public void setDataFromBase(BaseProjectEmployee b){
		if(b.getProjectEmployeeId() != null) setProjectEmployeeIdClear(b.getProjectEmployeeId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDesignPhase() != null) setDesignPhase(b.getDesignPhase());
		if(b.getPlanWorkHours() != null) setPlanWorkHours(b.getPlanWorkHours());
		if(b.getRealWorkHours() != null) setRealWorkHours(b.getRealWorkHours());
		if(b.getPlanIntegral() != null) setPlanIntegral(b.getPlanIntegral());
		if(b.getRealIntegral() != null) setRealIntegral(b.getRealIntegral());
		if(b.getPlanStartDate() != null) setPlanStartDate(b.getPlanStartDate());
		if(b.getPlanEndDate() != null) setPlanEndDate(b.getPlanEndDate());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getWorkContent() != null) setWorkContent(b.getWorkContent());
		if(b.getAlternateField1() != null) setAlternateField1(b.getAlternateField1());
		if(b.getAlternateField2() != null) setAlternateField2(b.getAlternateField2());
		if(b.getAlternateField3() != null) setAlternateField3(b.getAlternateField3());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getCost() != null) setCost(b.getCost());
		if(b.getSettlement() != null) setSettlement(b.getSettlement());
		if(b.getEmployeeAchieveIntegralReturn() != null) setEmployeeAchieveIntegralReturn(b.getEmployeeAchieveIntegralReturn());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
	}

	@Override
	public BaseProjectEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectEmployee b = new BaseProjectEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanWorkHours(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealWorkHours(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlement(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
	}

	public void setProjectEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDesignPhase(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDesignPhase() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPlanWorkHours(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPlanWorkHours() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRealWorkHours(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getRealWorkHours() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPlanIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPlanIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRealIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getRealIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setPlanStartDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getPlanStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setPlanEndDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getPlanEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setWorkContent(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getWorkContent() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setAlternateField1(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getAlternateField1() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setAlternateField2(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getAlternateField2() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setAlternateField3(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getAlternateField3() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setCost(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getCost() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setSettlement(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getSettlement() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setEmployeeAchieveIntegralReturn(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getEmployeeAchieveIntegralReturn() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setConditionProjectEmployeeId(String op, java.lang.Integer val) {
		setConditionProjectEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionProjectEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProjectEmployeeIdExpression(String val) {
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

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val) {
		setConditionDesignPhase(op, val, CONDITION_AND);
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDesignPhase(boolean val) {
		__select_flags[3] = val;
	}

	public void setDesignPhaseExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionPlanWorkHours(String op, java.lang.Integer val) {
		setConditionPlanWorkHours(op, val, CONDITION_AND);
	}

	public void setConditionPlanWorkHours(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPlanWorkHours(boolean val) {
		__select_flags[4] = val;
	}

	public void setPlanWorkHoursExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionRealWorkHours(String op, java.lang.Integer val) {
		setConditionRealWorkHours(op, val, CONDITION_AND);
	}

	public void setConditionRealWorkHours(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRealWorkHours(boolean val) {
		__select_flags[5] = val;
	}

	public void setRealWorkHoursExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionPlanIntegral(String op, java.math.BigDecimal val) {
		setConditionPlanIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPlanIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPlanIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setPlanIntegralExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionRealIntegral(String op, java.math.BigDecimal val) {
		setConditionRealIntegral(op, val, CONDITION_AND);
	}

	public void setConditionRealIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRealIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setRealIntegralExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionPlanStartDate(String op, java.util.Date val) {
		setConditionPlanStartDate(op, val, CONDITION_AND);
	}

	public void setConditionPlanStartDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPlanStartDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setPlanStartDateExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionPlanEndDate(String op, java.util.Date val) {
		setConditionPlanEndDate(op, val, CONDITION_AND);
	}

	public void setConditionPlanEndDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPlanEndDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setPlanEndDateExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[10] = val;
	}

	public void setStartDateExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[11] = val;
	}

	public void setEndDateExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionWorkContent(String op, java.lang.String val) {
		setConditionWorkContent(op, val, CONDITION_AND);
	}

	public void setConditionWorkContent(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectWorkContent(boolean val) {
		__select_flags[12] = val;
	}

	public void setWorkContentExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionAlternateField1(String op, java.lang.String val) {
		setConditionAlternateField1(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField1(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectAlternateField1(boolean val) {
		__select_flags[13] = val;
	}

	public void setAlternateField1Expression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionAlternateField2(String op, java.lang.String val) {
		setConditionAlternateField2(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField2(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectAlternateField2(boolean val) {
		__select_flags[14] = val;
	}

	public void setAlternateField2Expression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionAlternateField3(String op, java.lang.String val) {
		setConditionAlternateField3(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField3(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectAlternateField3(boolean val) {
		__select_flags[15] = val;
	}

	public void setAlternateField3Expression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[16] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionCost(String op, java.math.BigDecimal val) {
		setConditionCost(op, val, CONDITION_AND);
	}

	public void setConditionCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCost(boolean val) {
		__select_flags[17] = val;
	}

	public void setCostExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionSettlement(String op, java.math.BigDecimal val) {
		setConditionSettlement(op, val, CONDITION_AND);
	}

	public void setConditionSettlement(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectSettlement(boolean val) {
		__select_flags[18] = val;
	}

	public void setSettlementExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionEmployeeAchieveIntegralReturn(String op, java.math.BigDecimal val) {
		setConditionEmployeeAchieveIntegralReturn(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeAchieveIntegralReturn(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectEmployeeAchieveIntegralReturn(boolean val) {
		__select_flags[19] = val;
	}

	public void setEmployeeAchieveIntegralReturnExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[20] = val;
	}

	public void setStageIdExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[21] = val;
	}

	public void setFlagExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[22] = val;
	}

	public void setBusinessIdExpression(String val) {
		__dataExpressions[22] = val;
	}


}

