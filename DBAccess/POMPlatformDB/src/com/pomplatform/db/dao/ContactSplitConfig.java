package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContactSplitConfig;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContactSplitConfig extends AbstractTable<BaseContactSplitConfig>
{

	public ContactSplitConfig() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "contact_split_configs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContactSplitConfig.CS_CONTACT_SPLIT_CONFIG_ID;
		__column_names[1] = BaseContactSplitConfig.CS_NAME;
		__column_names[2] = BaseContactSplitConfig.CS_PROGRAMME;
		__column_names[3] = BaseContactSplitConfig.CS_DEEPEN;
		__column_names[4] = BaseContactSplitConfig.CS_ELECTROMECHANICAL;
		__column_names[5] = BaseContactSplitConfig.CS_LIGHTING;
		__column_names[6] = BaseContactSplitConfig.CS_SERVICE;
		__column_names[7] = BaseContactSplitConfig.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContactSplitConfig b) {
		clear();
		setContactSplitConfigIdClear(b.getContactSplitConfigId());
	}

	public boolean isPrimaryKeyNull() {
		return getContactSplitConfigId() == null;
	}

	@Override
	public BaseContactSplitConfig generateBase(){
		BaseContactSplitConfig b = new BaseContactSplitConfig();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContactSplitConfig b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContactSplitConfigId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProgramme(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDeepen(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setElectromechanical(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLighting(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setService(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseContactSplitConfig b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContactSplitConfigId();
		buff[count++] = b.getName();
		buff[count++] = b.getProgramme();
		buff[count++] = b.getDeepen();
		buff[count++] = b.getElectromechanical();
		buff[count++] = b.getLighting();
		buff[count++] = b.getService();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseContactSplitConfig b){
		if(b.getContactSplitConfigId() != null) setContactSplitConfigIdClear(b.getContactSplitConfigId());
		if(b.getName() != null) setName(b.getName());
		if(b.getProgramme() != null) setProgramme(b.getProgramme());
		if(b.getDeepen() != null) setDeepen(b.getDeepen());
		if(b.getElectromechanical() != null) setElectromechanical(b.getElectromechanical());
		if(b.getLighting() != null) setLighting(b.getLighting());
		if(b.getService() != null) setService(b.getService());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseContactSplitConfig generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContactSplitConfig b = new BaseContactSplitConfig();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContactSplitConfig __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactSplitConfigId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProgramme(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeepen(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setElectromechanical(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLighting(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setService(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setContactSplitConfigId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContactSplitConfigId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContactSplitConfigIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProgramme(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getProgramme() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setDeepen(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getDeepen() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setElectromechanical(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getElectromechanical() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setLighting(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getLighting() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setService(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getService() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionContactSplitConfigId(String op, java.lang.Integer val) {
		setConditionContactSplitConfigId(op, val, CONDITION_AND);
	}

	public void setConditionContactSplitConfigId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContactSplitConfigId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProgramme(String op, java.math.BigDecimal val) {
		setConditionProgramme(op, val, CONDITION_AND);
	}

	public void setConditionProgramme(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProgramme(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDeepen(String op, java.math.BigDecimal val) {
		setConditionDeepen(op, val, CONDITION_AND);
	}

	public void setConditionDeepen(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDeepen(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionElectromechanical(String op, java.math.BigDecimal val) {
		setConditionElectromechanical(op, val, CONDITION_AND);
	}

	public void setConditionElectromechanical(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectElectromechanical(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionLighting(String op, java.math.BigDecimal val) {
		setConditionLighting(op, val, CONDITION_AND);
	}

	public void setConditionLighting(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectLighting(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionService(String op, java.math.BigDecimal val) {
		setConditionService(op, val, CONDITION_AND);
	}

	public void setConditionService(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectService(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}


}

