package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectStage;


public class ProjectStage extends AbstractTable<BaseProjectStage>
{

	public ProjectStage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "project_stages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectStage.CS_PROJECT_STAGE_ID;
		__column_names[1] = BaseProjectStage.CS_PROJECT_ID;
		__column_names[2] = BaseProjectStage.CS_STAGE_ID;
		__column_names[3] = BaseProjectStage.CS_PERCENT;
		__column_names[4] = BaseProjectStage.CS_PROJECT_AMOUNT;
		__column_names[5] = BaseProjectStage.CS_STAGE_NAME;
		__column_names[6] = BaseProjectStage.CS_REMARK;
		__column_names[7] = BaseProjectStage.CS_MAIN_PROJECT_ID;
		__column_names[8] = BaseProjectStage.CS_PROJECT_TEMPLATE_ID;
		__column_names[9] = BaseProjectStage.CS_CONTRACT_ID;
		__column_names[10] = BaseProjectStage.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectStage b) {
		clear();
		setProjectStageIdClear(b.getProjectStageId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectStageId() == null;
	}

	@Override
	public BaseProjectStage generateBase(){
		BaseProjectStage b = new BaseProjectStage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectStage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setProjectStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPercent(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStageName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectTemplateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectStage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectStageId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getPercent();
		buff[count++] = b.getProjectAmount();
		buff[count++] = b.getStageName();
		buff[count++] = b.getRemark();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getProjectTemplateId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseProjectStage b){
		if(b.getProjectStageId() != null) setProjectStageIdClear(b.getProjectStageId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getProjectAmount() != null) setProjectAmount(b.getProjectAmount());
		if(b.getStageName() != null) setStageName(b.getStageName());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getProjectTemplateId() != null) setProjectTemplateId(b.getProjectTemplateId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseProjectStage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectStage b = new BaseProjectStage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectStage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setProjectStageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectStageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectStageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setProjectAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getProjectAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setStageName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getStageName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setProjectTemplateId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getProjectTemplateId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionProjectStageId(String op, java.lang.Integer val) {
		setConditionProjectStageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectStageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectStageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProjectStageIdExpression(String val) {
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

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setStageIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[3] = val;
	}

	public void setPercentExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val) {
		setConditionProjectAmount(op, val, CONDITION_AND);
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setProjectAmountExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionStageName(String op, java.lang.String val) {
		setConditionStageName(op, val, CONDITION_AND);
	}

	public void setConditionStageName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStageName(boolean val) {
		__select_flags[5] = val;
	}

	public void setStageNameExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[7] = val;
	}

	public void setMainProjectIdExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val) {
		setConditionProjectTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectTemplateId(boolean val) {
		__select_flags[8] = val;
	}

	public void setProjectTemplateIdExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[9] = val;
	}

	public void setContractIdExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[10] = val;
	}


}

