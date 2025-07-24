package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectQuoteDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectQuoteDetail extends AbstractTable<BaseProjectQuoteDetail>
{

	public ProjectQuoteDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 14;

		initTables();

		__tableName            = "project_quote_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectQuoteDetail.CS_PROJECT_QUOTE_DETAIL_ID;
		__column_names[1] = BaseProjectQuoteDetail.CS_PROJECT_QUOTE_ID;
		__column_names[2] = BaseProjectQuoteDetail.CS_PROJECT_ID;
		__column_names[3] = BaseProjectQuoteDetail.CS_BUSINESS_TYPE;
		__column_names[4] = BaseProjectQuoteDetail.CS_DESIGN_TYPE_NAME;
		__column_names[5] = BaseProjectQuoteDetail.CS_DESIGN_CONTENT;
		__column_names[6] = BaseProjectQuoteDetail.CS_DESIGN_STAGE;
		__column_names[7] = BaseProjectQuoteDetail.CS_AREA_TYPE;
		__column_names[8] = BaseProjectQuoteDetail.CS_AREA;
		__column_names[9] = BaseProjectQuoteDetail.CS_AREA_PRICE;
		__column_names[10] = BaseProjectQuoteDetail.CS_TOTAL_PRICE;
		__column_names[11] = BaseProjectQuoteDetail.CS_TAX;
		__column_names[12] = BaseProjectQuoteDetail.CS_REMARK;
		__column_names[13] = BaseProjectQuoteDetail.CS_COMPANY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectQuoteDetail b) {
		clear();
		setProjectQuoteDetailIdClear(b.getProjectQuoteDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectQuoteDetailId() == null;
	}

	@Override
	public BaseProjectQuoteDetail generateBase(){
		BaseProjectQuoteDetail b = new BaseProjectQuoteDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectQuoteDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectQuoteDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectQuoteId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignStage(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAreaPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectQuoteDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectQuoteDetailId();
		buff[count++] = b.getProjectQuoteId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getDesignTypeName();
		buff[count++] = b.getDesignContent();
		buff[count++] = b.getDesignStage();
		buff[count++] = b.getAreaType();
		buff[count++] = b.getArea();
		buff[count++] = b.getAreaPrice();
		buff[count++] = b.getTotalPrice();
		buff[count++] = b.getTax();
		buff[count++] = b.getRemark();
		buff[count++] = b.getCompanyId();
	}

	@Override
	public void setDataFromBase(BaseProjectQuoteDetail b){
		if(b.getProjectQuoteDetailId() != null) setProjectQuoteDetailIdClear(b.getProjectQuoteDetailId());
		if(b.getProjectQuoteId() != null) setProjectQuoteId(b.getProjectQuoteId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getDesignTypeName() != null) setDesignTypeName(b.getDesignTypeName());
		if(b.getDesignContent() != null) setDesignContent(b.getDesignContent());
		if(b.getDesignStage() != null) setDesignStage(b.getDesignStage());
		if(b.getAreaType() != null) setAreaType(b.getAreaType());
		if(b.getArea() != null) setArea(b.getArea());
		if(b.getAreaPrice() != null) setAreaPrice(b.getAreaPrice());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getTax() != null) setTax(b.getTax());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
	}

	@Override
	public BaseProjectQuoteDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectQuoteDetail b = new BaseProjectQuoteDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectQuoteDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignStage(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
	}

	public void setProjectQuoteDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectQuoteDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectQuoteDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectQuoteId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectQuoteId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDesignTypeName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getDesignTypeName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDesignContent(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getDesignContent() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setDesignStage(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDesignStage() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setAreaType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getAreaType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setArea(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getArea() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setAreaPrice(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getAreaPrice() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setTax(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getTax() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setConditionProjectQuoteDetailId(String op, java.lang.Integer val) {
		setConditionProjectQuoteDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectQuoteDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectQuoteId(String op, java.lang.Integer val) {
		setConditionProjectQuoteId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectQuoteId(boolean val) {
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

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDesignTypeName(String op, java.lang.String val) {
		setConditionDesignTypeName(op, val, CONDITION_AND);
	}

	public void setConditionDesignTypeName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDesignTypeName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDesignContent(String op, java.lang.String val) {
		setConditionDesignContent(op, val, CONDITION_AND);
	}

	public void setConditionDesignContent(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDesignContent(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDesignStage(String op, java.lang.Integer val) {
		setConditionDesignStage(op, val, CONDITION_AND);
	}

	public void setConditionDesignStage(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDesignStage(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAreaType(String op, java.lang.Integer val) {
		setConditionAreaType(op, val, CONDITION_AND);
	}

	public void setConditionAreaType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAreaType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionArea(String op, java.math.BigDecimal val) {
		setConditionArea(op, val, CONDITION_AND);
	}

	public void setConditionArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectArea(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAreaPrice(String op, java.math.BigDecimal val) {
		setConditionAreaPrice(op, val, CONDITION_AND);
	}

	public void setConditionAreaPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAreaPrice(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTax(String op, java.math.BigDecimal val) {
		setConditionTax(op, val, CONDITION_AND);
	}

	public void setConditionTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTax(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[13] = val;
	}


}

