package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectQuoteTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectQuoteTemplate extends AbstractTable<BaseProjectQuoteTemplate>
{

	public ProjectQuoteTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "project_quote_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectQuoteTemplate.CS_PROJECT_QUOTE_TEMPLATE_ID;
		__column_names[1] = BaseProjectQuoteTemplate.CS_BUSINESS_TYPE;
		__column_names[2] = BaseProjectQuoteTemplate.CS_PARENT_ID;
		__column_names[3] = BaseProjectQuoteTemplate.CS_DESIGN_TYPE_NAME;
		__column_names[4] = BaseProjectQuoteTemplate.CS_DESIGN_CONTENT;
		__column_names[5] = BaseProjectQuoteTemplate.CS_DESIGN_STAGE;
		__column_names[6] = BaseProjectQuoteTemplate.CS_AREA_TYPE;
		__column_names[7] = BaseProjectQuoteTemplate.CS_TAX;
		__column_names[8] = BaseProjectQuoteTemplate.CS_COMPANY_ID;
		__column_names[9] = BaseProjectQuoteTemplate.CS_OPERATE_TIME;
		__column_names[10] = BaseProjectQuoteTemplate.CS_REMARK;
		__column_names[11] = BaseProjectQuoteTemplate.CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectQuoteTemplate b) {
		clear();
		setProjectQuoteTemplateIdClear(b.getProjectQuoteTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectQuoteTemplateId() == null;
	}

	@Override
	public BaseProjectQuoteTemplate generateBase(){
		BaseProjectQuoteTemplate b = new BaseProjectQuoteTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectQuoteTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectQuoteTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignStage(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectQuoteTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectQuoteTemplateId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getParentId();
		buff[count++] = b.getDesignTypeName();
		buff[count++] = b.getDesignContent();
		buff[count++] = b.getDesignStage();
		buff[count++] = b.getAreaType();
		buff[count++] = b.getTax();
		buff[count++] = b.getCompanyId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getProjectQuoteTemplatesParentId();
	}

	@Override
	public void setDataFromBase(BaseProjectQuoteTemplate b){
		if(b.getProjectQuoteTemplateId() != null) setProjectQuoteTemplateIdClear(b.getProjectQuoteTemplateId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getDesignTypeName() != null) setDesignTypeName(b.getDesignTypeName());
		if(b.getDesignContent() != null) setDesignContent(b.getDesignContent());
		if(b.getDesignStage() != null) setDesignStage(b.getDesignStage());
		if(b.getAreaType() != null) setAreaType(b.getAreaType());
		if(b.getTax() != null) setTax(b.getTax());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProjectQuoteTemplatesParentId() != null) setProjectQuoteTemplatesParentId(b.getProjectQuoteTemplatesParentId());
	}

	@Override
	public BaseProjectQuoteTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectQuoteTemplate b = new BaseProjectQuoteTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectQuoteTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignStage(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
	}

	public void setProjectQuoteTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectQuoteTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectQuoteTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDesignTypeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getDesignTypeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setDesignContent(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getDesignContent() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDesignStage(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDesignStage() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setAreaType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getAreaType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setTax(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTax() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setProjectQuoteTemplatesParentId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionProjectQuoteTemplateId(String op, java.lang.Integer val) {
		setConditionProjectQuoteTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectQuoteTemplateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDesignTypeName(String op, java.lang.String val) {
		setConditionDesignTypeName(op, val, CONDITION_AND);
	}

	public void setConditionDesignTypeName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDesignTypeName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDesignContent(String op, java.lang.String val) {
		setConditionDesignContent(op, val, CONDITION_AND);
	}

	public void setConditionDesignContent(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDesignContent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDesignStage(String op, java.lang.Integer val) {
		setConditionDesignStage(op, val, CONDITION_AND);
	}

	public void setConditionDesignStage(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDesignStage(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAreaType(String op, java.lang.Integer val) {
		setConditionAreaType(op, val, CONDITION_AND);
	}

	public void setConditionAreaType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAreaType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTax(String op, java.math.BigDecimal val) {
		setConditionTax(op, val, CONDITION_AND);
	}

	public void setConditionTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTax(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val) {
		setConditionProjectQuoteTemplatesParentId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProjectQuoteTemplatesParentId(boolean val) {
		__select_flags[11] = val;
	}


}

