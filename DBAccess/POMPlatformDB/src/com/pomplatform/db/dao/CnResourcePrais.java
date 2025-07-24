package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourcePrais;


public class CnResourcePrais extends AbstractTable<BaseCnResourcePrais>
{

	public CnResourcePrais() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cn_resource_praises";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResourcePrais.CS_RESOURCE_PRAISE_ID;
		__column_names[1] = BaseCnResourcePrais.CS_RESOURCE_ID;
		__column_names[2] = BaseCnResourcePrais.CS_CREATOR;
		__column_names[3] = BaseCnResourcePrais.CS_CREATE_TIME;
		__column_names[4] = BaseCnResourcePrais.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourcePrais b) {
		clear();
		setResourcePraiseIdClear(b.getResourcePraiseId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourcePraiseId() == null;
	}

	@Override
	public BaseCnResourcePrais generateBase(){
		BaseCnResourcePrais b = new BaseCnResourcePrais();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourcePrais b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourcePraiseId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourcePrais b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourcePraiseId();
		buff[count++] = b.getResourceId();
		buff[count++] = b.getCreator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourcePrais b){
		if(b.getResourcePraiseId() != null) setResourcePraiseIdClear(b.getResourcePraiseId());
		if(b.getResourceId() != null) setResourceId(b.getResourceId());
		if(b.getCreator() != null) setCreator(b.getCreator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourcePrais generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourcePrais b = new BaseCnResourcePrais();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourcePrais __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourcePraiseId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourcePraiseId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourcePraiseId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourcePraiseIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setResourceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getResourceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCreator(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCreator() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionResourcePraiseId(String op, java.lang.Integer val) {
		setConditionResourcePraiseId(op, val, CONDITION_AND);
	}

	public void setConditionResourcePraiseId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourcePraiseId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionResourceId(String op, java.lang.Integer val) {
		setConditionResourceId(op, val, CONDITION_AND);
	}

	public void setConditionResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectResourceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCreator(String op, java.lang.Integer val) {
		setConditionCreator(op, val, CONDITION_AND);
	}

	public void setConditionCreator(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCreator(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[4] = val;
	}


}

