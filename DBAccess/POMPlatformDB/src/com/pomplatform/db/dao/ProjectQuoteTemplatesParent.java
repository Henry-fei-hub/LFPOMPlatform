package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectQuoteTemplatesParent;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectQuoteTemplatesParent extends AbstractTable<BaseProjectQuoteTemplatesParent>
{

	public ProjectQuoteTemplatesParent() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "project_quote_templates_parent";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectQuoteTemplatesParent.CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID;
		__column_names[1] = BaseProjectQuoteTemplatesParent.CS_PARENT_NAME;
		__column_names[2] = BaseProjectQuoteTemplatesParent.CS_BUSINESS_TYPE;
		__column_names[3] = BaseProjectQuoteTemplatesParent.CS_COMPANY_ID;
		__column_names[4] = BaseProjectQuoteTemplatesParent.CS_CREATE_EMPLOYEE_ID;
		__column_names[5] = BaseProjectQuoteTemplatesParent.CS_CREATE_DATE;
		__column_names[6] = BaseProjectQuoteTemplatesParent.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectQuoteTemplatesParent b) {
		clear();
		setProjectQuoteTemplatesParentIdClear(b.getProjectQuoteTemplatesParentId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectQuoteTemplatesParentId() == null;
	}

	@Override
	public BaseProjectQuoteTemplatesParent generateBase(){
		BaseProjectQuoteTemplatesParent b = new BaseProjectQuoteTemplatesParent();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectQuoteTemplatesParent b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectQuoteTemplatesParent b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectQuoteTemplatesParentId();
		buff[count++] = b.getParentName();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectQuoteTemplatesParent b){
		if(b.getProjectQuoteTemplatesParentId() != null) setProjectQuoteTemplatesParentIdClear(b.getProjectQuoteTemplatesParentId());
		if(b.getParentName() != null) setParentName(b.getParentName());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectQuoteTemplatesParent generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectQuoteTemplatesParent b = new BaseProjectQuoteTemplatesParent();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectQuoteTemplatesParent __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectQuoteTemplatesParentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectQuoteTemplatesParentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setParentName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getParentName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val) {
		setConditionProjectQuoteTemplatesParentId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectQuoteTemplatesParentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionParentName(String op, java.lang.String val) {
		setConditionParentName(op, val, CONDITION_AND);
	}

	public void setConditionParentName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectParentName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[5] = val;
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


}

