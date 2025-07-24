package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMainProjectStage;


public class MainProjectStage extends AbstractTable<BaseMainProjectStage>
{

	public MainProjectStage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "main_project_stages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectStage.CS_MAIN_PROJECT_STAGE_ID;
		__column_names[1] = BaseMainProjectStage.CS_MAIN_STAGE_ID;
		__column_names[2] = BaseMainProjectStage.CS_MAIN_STAGE_CODE;
		__column_names[3] = BaseMainProjectStage.CS_MAIN_STAGE_NAME;
		__column_names[4] = BaseMainProjectStage.CS_REMARK;
		__column_names[5] = BaseMainProjectStage.CS_PERCENT;
		__column_names[6] = BaseMainProjectStage.CS_PARENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectStage b) {
		clear();
		setMainProjectStageIdClear(b.getMainProjectStageId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectStageId() == null;
	}

	@Override
	public BaseMainProjectStage generateBase(){
		BaseMainProjectStage b = new BaseMainProjectStage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectStage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainStageCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainStageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMainProjectStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainStageCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainStageName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPercent(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectStage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectStageId();
		buff[count++] = b.getMainStageId();
		buff[count++] = b.getMainStageCode();
		buff[count++] = b.getMainStageName();
		buff[count++] = b.getRemark();
		buff[count++] = b.getPercent();
		buff[count++] = b.getParentId();
	}

	@Override
	public void setDataFromBase(BaseMainProjectStage b){
		if(b.getMainProjectStageId() != null) setMainProjectStageIdClear(b.getMainProjectStageId());
		if(b.getMainStageId() != null) setMainStageId(b.getMainStageId());
		if(b.getMainStageCode() != null) setMainStageCode(b.getMainStageCode());
		if(b.getMainStageName() != null) setMainStageName(b.getMainStageName());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getParentId() != null) setParentId(b.getParentId());
	}

	@Override
	public BaseMainProjectStage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectStage b = new BaseMainProjectStage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectStage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainStageCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainStageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
	}

	public void setMainProjectStageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectStageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectStageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainStageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainStageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainStageCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getMainStageCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setMainStageName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getMainStageName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionMainProjectStageId(String op, java.lang.Integer val) {
		setConditionMainProjectStageId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectStageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectStageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMainProjectStageIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMainStageId(String op, java.lang.Integer val) {
		setConditionMainStageId(op, val, CONDITION_AND);
	}

	public void setConditionMainStageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainStageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setMainStageIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionMainStageCode(String op, java.lang.String val) {
		setConditionMainStageCode(op, val, CONDITION_AND);
	}

	public void setConditionMainStageCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMainStageCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setMainStageCodeExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionMainStageName(String op, java.lang.String val) {
		setConditionMainStageName(op, val, CONDITION_AND);
	}

	public void setConditionMainStageName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMainStageName(boolean val) {
		__select_flags[3] = val;
	}

	public void setMainStageNameExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[5] = val;
	}

	public void setPercentExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setParentIdExpression(String val) {
		__dataExpressions[6] = val;
	}


}

