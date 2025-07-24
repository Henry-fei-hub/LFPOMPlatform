package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseprojectQuoteAreaRange;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class projectQuoteAreaRange extends AbstractTable<BaseprojectQuoteAreaRange>
{

	public projectQuoteAreaRange() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "project_quote_area_range";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseprojectQuoteAreaRange.CS_PROJECT_QUOTE_AREA_RANGE_ID;
		__column_names[1] = BaseprojectQuoteAreaRange.CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID;
		__column_names[2] = BaseprojectQuoteAreaRange.CS_PROJECT_QUOTE_TEMPLATE_ID;
		__column_names[3] = BaseprojectQuoteAreaRange.CS_AREA_RANGE_START;
		__column_names[4] = BaseprojectQuoteAreaRange.CS_AREA_RANGE_END;
		__column_names[5] = BaseprojectQuoteAreaRange.CS_AREA_PRICE;
		__column_names[6] = BaseprojectQuoteAreaRange.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseprojectQuoteAreaRange b) {
		clear();
		setProjectQuoteAreaRangeIdClear(b.getProjectQuoteAreaRangeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectQuoteAreaRangeId() == null;
	}

	@Override
	public BaseprojectQuoteAreaRange generateBase(){
		BaseprojectQuoteAreaRange b = new BaseprojectQuoteAreaRange();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseprojectQuoteAreaRange b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectQuoteAreaRangeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectQuoteTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaRangeStart(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAreaRangeEnd(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAreaPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseprojectQuoteAreaRange b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectQuoteAreaRangeId();
		buff[count++] = b.getProjectQuoteTemplatesParentId();
		buff[count++] = b.getProjectQuoteTemplateId();
		buff[count++] = b.getAreaRangeStart();
		buff[count++] = b.getAreaRangeEnd();
		buff[count++] = b.getAreaPrice();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseprojectQuoteAreaRange b){
		if(b.getProjectQuoteAreaRangeId() != null) setProjectQuoteAreaRangeIdClear(b.getProjectQuoteAreaRangeId());
		if(b.getProjectQuoteTemplatesParentId() != null) setProjectQuoteTemplatesParentId(b.getProjectQuoteTemplatesParentId());
		if(b.getProjectQuoteTemplateId() != null) setProjectQuoteTemplateId(b.getProjectQuoteTemplateId());
		if(b.getAreaRangeStart() != null) setAreaRangeStart(b.getAreaRangeStart());
		if(b.getAreaRangeEnd() != null) setAreaRangeEnd(b.getAreaRangeEnd());
		if(b.getAreaPrice() != null) setAreaPrice(b.getAreaPrice());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseprojectQuoteAreaRange generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseprojectQuoteAreaRange b = new BaseprojectQuoteAreaRange();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseprojectQuoteAreaRange __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteAreaRangeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaRangeStart(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaRangeEnd(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectQuoteAreaRangeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectQuoteAreaRangeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectQuoteAreaRangeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectQuoteTemplatesParentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectQuoteTemplateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectQuoteTemplateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAreaRangeStart(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAreaRangeStart() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAreaRangeEnd(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAreaRangeEnd() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setAreaPrice(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAreaPrice() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionProjectQuoteAreaRangeId(String op, java.lang.Integer val) {
		setConditionProjectQuoteAreaRangeId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteAreaRangeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectQuoteAreaRangeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val) {
		setConditionProjectQuoteTemplatesParentId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectQuoteTemplatesParentId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectQuoteTemplateId(String op, java.lang.Integer val) {
		setConditionProjectQuoteTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectQuoteTemplateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAreaRangeStart(String op, java.math.BigDecimal val) {
		setConditionAreaRangeStart(op, val, CONDITION_AND);
	}

	public void setConditionAreaRangeStart(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAreaRangeStart(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAreaRangeEnd(String op, java.math.BigDecimal val) {
		setConditionAreaRangeEnd(op, val, CONDITION_AND);
	}

	public void setConditionAreaRangeEnd(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAreaRangeEnd(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAreaPrice(String op, java.math.BigDecimal val) {
		setConditionAreaPrice(op, val, CONDITION_AND);
	}

	public void setConditionAreaPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAreaPrice(boolean val) {
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

