package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectStageTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectStageTemplate extends AbstractTable<BaseProjectStageTemplate>
{

	public ProjectStageTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "project_stage_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectStageTemplate.CS_PROJECT_STAGE_TEMPLATE_ID;
		__column_names[1] = BaseProjectStageTemplate.CS_STAGE_ID;
		__column_names[2] = BaseProjectStageTemplate.CS_PERCENT;
		__column_names[3] = BaseProjectStageTemplate.CS_STAGE_NAME;
		__column_names[4] = BaseProjectStageTemplate.CS_PROJECT_TEMPLATE_NAME;
		__column_names[5] = BaseProjectStageTemplate.CS_PROJECT_TEMPLATE_ID;
		__column_names[6] = BaseProjectStageTemplate.CS_PROJECT_AMOUNT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectStageTemplate b) {
		clear();
		setProjectStageTemplateIdClear(b.getProjectStageTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectStageTemplateId() == null;
	}

	@Override
	public BaseProjectStageTemplate generateBase(){
		BaseProjectStageTemplate b = new BaseProjectStageTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectStageTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectStageTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectTemplateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectAmount(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectStageTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectStageTemplateId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getPercent();
		buff[count++] = b.getStageName();
		buff[count++] = b.getProjectTemplateName();
		buff[count++] = b.getProjectTemplateId();
		buff[count++] = b.getProjectAmount();
	}

	@Override
	public void setDataFromBase(BaseProjectStageTemplate b){
		if(b.getProjectStageTemplateId() != null) setProjectStageTemplateIdClear(b.getProjectStageTemplateId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getStageName() != null) setStageName(b.getStageName());
		if(b.getProjectTemplateName() != null) setProjectTemplateName(b.getProjectTemplateName());
		if(b.getProjectTemplateId() != null) setProjectTemplateId(b.getProjectTemplateId());
		if(b.getProjectAmount() != null) setProjectAmount(b.getProjectAmount());
	}

	@Override
	public BaseProjectStageTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectStageTemplate b = new BaseProjectStageTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectStageTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTemplateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
	}

	public void setProjectStageTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectStageTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectStageTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPercent(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPercent() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setStageName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getStageName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectTemplateName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectTemplateName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setProjectTemplateId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProjectTemplateId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProjectAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getProjectAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setConditionProjectStageTemplateId(String op, java.lang.Integer val) {
		setConditionProjectStageTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectStageTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectStageTemplateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPercent(String op, java.lang.Integer val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStageName(String op, java.lang.String val) {
		setConditionStageName(op, val, CONDITION_AND);
	}

	public void setConditionStageName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectStageName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectTemplateName(String op, java.lang.String val) {
		setConditionProjectTemplateName(op, val, CONDITION_AND);
	}

	public void setConditionProjectTemplateName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectTemplateName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val) {
		setConditionProjectTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectTemplateId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val) {
		setConditionProjectAmount(op, val, CONDITION_AND);
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectAmount(boolean val) {
		__select_flags[6] = val;
	}


}

