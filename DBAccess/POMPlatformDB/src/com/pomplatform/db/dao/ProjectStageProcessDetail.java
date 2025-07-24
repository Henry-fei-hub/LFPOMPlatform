package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;


public class ProjectStageProcessDetail extends AbstractTable<BaseProjectStageProcessDetail>
{

	public ProjectStageProcessDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "project_stage_process_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectStageProcessDetail.CS_PROJECT_STAGE_PROCESS_DETAIL_ID;
		__column_names[1] = BaseProjectStageProcessDetail.CS_PROJECT_STAGE_PROCESS_RECORD_ID;
		__column_names[2] = BaseProjectStageProcessDetail.CS_STAGE_ID;
		__column_names[3] = BaseProjectStageProcessDetail.CS_PERCENT;
		__column_names[4] = BaseProjectStageProcessDetail.CS_PROJECT_AMOUNT;
		__column_names[5] = BaseProjectStageProcessDetail.CS_STAGE_NAME;
		__column_names[6] = BaseProjectStageProcessDetail.CS_CONTRACT_ID;
		__column_names[7] = BaseProjectStageProcessDetail.CS_MAIN_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectStageProcessDetail b) {
		clear();
		setProjectStageProcessDetailIdClear(b.getProjectStageProcessDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectStageProcessDetailId() == null;
	}

	@Override
	public BaseProjectStageProcessDetail generateBase(){
		BaseProjectStageProcessDetail b = new BaseProjectStageProcessDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectStageProcessDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectStageProcessDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectStageProcessRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setProjectStageProcessDetailId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectStageProcessRecordId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectStageProcessDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectStageProcessDetailId();
		buff[count++] = b.getProjectStageProcessRecordId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getPercent();
		buff[count++] = b.getProjectAmount();
		buff[count++] = b.getStageName();
		buff[count++] = b.getContractId();
		buff[count++] = b.getMainProjectId();
	}

	@Override
	public void setDataFromBase(BaseProjectStageProcessDetail b){
		if(b.getProjectStageProcessDetailId() != null) setProjectStageProcessDetailIdClear(b.getProjectStageProcessDetailId());
		if(b.getProjectStageProcessRecordId() != null) setProjectStageProcessRecordId(b.getProjectStageProcessRecordId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getProjectAmount() != null) setProjectAmount(b.getProjectAmount());
		if(b.getStageName() != null) setStageName(b.getStageName());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
	}

	@Override
	public BaseProjectStageProcessDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectStageProcessDetail b = new BaseProjectStageProcessDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectStageProcessDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageProcessDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageProcessRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
	}

	public void setProjectStageProcessDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectStageProcessDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectStageProcessDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectStageProcessRecordId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectStageProcessRecordId() {
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

	public void setContractId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionProjectStageProcessDetailId(String op, java.lang.Integer val) {
		setConditionProjectStageProcessDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProjectStageProcessDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectStageProcessDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProjectStageProcessDetailIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionProjectStageProcessRecordId(String op, java.lang.Integer val) {
		setConditionProjectStageProcessRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectStageProcessRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectStageProcessRecordId(boolean val) {
		__select_flags[1] = val;
	}

	public void setProjectStageProcessRecordIdExpression(String val) {
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

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[6] = val;
	}

	public void setContractIdExpression(String val) {
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


}

