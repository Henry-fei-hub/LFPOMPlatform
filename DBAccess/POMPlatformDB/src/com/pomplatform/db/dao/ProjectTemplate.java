package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectTemplate extends AbstractTable<BaseProjectTemplate>
{

	public ProjectTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "project_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectTemplate.CS_PROJECT_TEMPLATE_ID;
		__column_names[1] = BaseProjectTemplate.CS_PROJECT_TEMPLATE_NAME;
		__column_names[2] = BaseProjectTemplate.CS_PROJECT_TYPE;
		__column_names[3] = BaseProjectTemplate.CS_PLATE_ID;
		__column_names[4] = BaseProjectTemplate.CS_BUSINESS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectTemplate b) {
		clear();
		setProjectTemplateIdClear(b.getProjectTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectTemplateId() == null;
	}

	@Override
	public BaseProjectTemplate generateBase(){
		BaseProjectTemplate b = new BaseProjectTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectTemplateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectTemplateId();
		buff[count++] = b.getProjectTemplateName();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getBusinessType();
	}

	@Override
	public void setDataFromBase(BaseProjectTemplate b){
		if(b.getProjectTemplateId() != null) setProjectTemplateIdClear(b.getProjectTemplateId());
		if(b.getProjectTemplateName() != null) setProjectTemplateName(b.getProjectTemplateName());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
	}

	@Override
	public BaseProjectTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectTemplate b = new BaseProjectTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTemplateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
	}

	public void setProjectTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectTemplateName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getProjectTemplateName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val) {
		setConditionProjectTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectTemplateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectTemplateName(String op, java.lang.String val) {
		setConditionProjectTemplateName(op, val, CONDITION_AND);
	}

	public void setConditionProjectTemplateName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectTemplateName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[4] = val;
	}


}

