package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectTransition;


public class ProjectTransition extends AbstractTable<BaseProjectTransition>
{

	public ProjectTransition() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_transitions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectTransition.CS_PROJECT_TRANSITION_ID;
		__column_names[1] = BaseProjectTransition.CS_PROJECT_ID;
		__column_names[2] = BaseProjectTransition.CS_PERCENT;
		__column_names[3] = BaseProjectTransition.CS_PROJECT_MANAGE_ID;
		__column_names[4] = BaseProjectTransition.CS_IS_OR_NOT;
		__column_names[5] = BaseProjectTransition.CS_INITIATE_DESIGN;
		__column_names[6] = BaseProjectTransition.CS_STATUS;
		__column_names[7] = BaseProjectTransition.CS_OPERATOR;
		__column_names[8] = BaseProjectTransition.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectTransition b) {
		clear();
		setProjectTransitionIdClear(b.getProjectTransitionId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectTransitionId() == null;
	}

	@Override
	public BaseProjectTransition generateBase(){
		BaseProjectTransition b = new BaseProjectTransition();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectTransition b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectTransitionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsOrNot(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setInitiateDesign(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
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
			if(val != null && !val.isEmpty()) setProjectTransitionId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPercent(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectManageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsOrNot(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInitiateDesign(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperator(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectTransition b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectTransitionId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getPercent();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getIsOrNot();
		buff[count++] = b.getInitiateDesign();
		buff[count++] = b.getStatus();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseProjectTransition b){
		if(b.getProjectTransitionId() != null) setProjectTransitionIdClear(b.getProjectTransitionId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getIsOrNot() != null) setIsOrNot(b.getIsOrNot());
		if(b.getInitiateDesign() != null) setInitiateDesign(b.getInitiateDesign());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseProjectTransition generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectTransition b = new BaseProjectTransition();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectTransition __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTransitionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOrNot(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInitiateDesign(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setProjectTransitionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectTransitionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectTransitionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setIsOrNot(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getIsOrNot() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setInitiateDesign(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getInitiateDesign() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setConditionProjectTransitionId(String op, java.lang.Integer val) {
		setConditionProjectTransitionId(op, val, CONDITION_AND);
	}

	public void setConditionProjectTransitionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectTransitionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProjectTransitionIdExpression(String val) {
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

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[2] = val;
	}

	public void setPercentExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[3] = val;
	}

	public void setProjectManageIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionIsOrNot(String op, java.lang.Boolean val) {
		setConditionIsOrNot(op, val, CONDITION_AND);
	}

	public void setConditionIsOrNot(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectIsOrNot(boolean val) {
		__select_flags[4] = val;
	}

	public void setIsOrNotExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionInitiateDesign(String op, java.lang.Integer val) {
		setConditionInitiateDesign(op, val, CONDITION_AND);
	}

	public void setConditionInitiateDesign(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInitiateDesign(boolean val) {
		__select_flags[5] = val;
	}

	public void setInitiateDesignExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[7] = val;
	}

	public void setOperatorExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[8] = val;
	}


}

