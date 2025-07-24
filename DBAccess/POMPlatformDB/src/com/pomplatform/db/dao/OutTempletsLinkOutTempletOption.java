package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOutTempletsLinkOutTempletOption;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OutTempletsLinkOutTempletOption extends AbstractTable<BaseOutTempletsLinkOutTempletOption>
{

	public OutTempletsLinkOutTempletOption() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "out_templets_link_out_templet_options";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutTempletsLinkOutTempletOption.CS_OUT_TEMPLETS_LINK_OUT_TEMPLET_OPTION_ID;
		__column_names[1] = BaseOutTempletsLinkOutTempletOption.CS_OUT_TEMPLET_ID;
		__column_names[2] = BaseOutTempletsLinkOutTempletOption.CS_OUT_TEMPLET_OPTION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutTempletsLinkOutTempletOption b) {
		clear();
		setOutTempletsLinkOutTempletOptionIdClear(b.getOutTempletsLinkOutTempletOptionId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutTempletsLinkOutTempletOptionId() == null;
	}

	@Override
	public BaseOutTempletsLinkOutTempletOption generateBase(){
		BaseOutTempletsLinkOutTempletOption b = new BaseOutTempletsLinkOutTempletOption();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutTempletsLinkOutTempletOption b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutTempletsLinkOutTempletOptionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOutTempletId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOutTempletOptionId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseOutTempletsLinkOutTempletOption b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutTempletsLinkOutTempletOptionId();
		buff[count++] = b.getOutTempletId();
		buff[count++] = b.getOutTempletOptionId();
	}

	@Override
	public void setDataFromBase(BaseOutTempletsLinkOutTempletOption b){
		if(b.getOutTempletsLinkOutTempletOptionId() != null) setOutTempletsLinkOutTempletOptionIdClear(b.getOutTempletsLinkOutTempletOptionId());
		if(b.getOutTempletId() != null) setOutTempletId(b.getOutTempletId());
		if(b.getOutTempletOptionId() != null) setOutTempletOptionId(b.getOutTempletOptionId());
	}

	@Override
	public BaseOutTempletsLinkOutTempletOption generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutTempletsLinkOutTempletOption b = new BaseOutTempletsLinkOutTempletOption();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutTempletsLinkOutTempletOption __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTempletsLinkOutTempletOptionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTempletId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTempletOptionId(GenericBase.__getInt(val));
	}

	public void setOutTempletsLinkOutTempletOptionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutTempletsLinkOutTempletOptionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutTempletsLinkOutTempletOptionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOutTempletId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getOutTempletId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setOutTempletOptionId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOutTempletOptionId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionOutTempletsLinkOutTempletOptionId(String op, java.lang.Integer val) {
		setConditionOutTempletsLinkOutTempletOptionId(op, val, CONDITION_AND);
	}

	public void setConditionOutTempletsLinkOutTempletOptionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutTempletsLinkOutTempletOptionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOutTempletId(String op, java.lang.Integer val) {
		setConditionOutTempletId(op, val, CONDITION_AND);
	}

	public void setConditionOutTempletId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOutTempletId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOutTempletOptionId(String op, java.lang.Integer val) {
		setConditionOutTempletOptionId(op, val, CONDITION_AND);
	}

	public void setConditionOutTempletOptionId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOutTempletOptionId(boolean val) {
		__select_flags[2] = val;
	}


}

