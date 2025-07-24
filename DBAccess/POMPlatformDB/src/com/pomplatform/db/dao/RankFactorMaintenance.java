package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseRankFactorMaintenance;


public class RankFactorMaintenance extends AbstractTable<BaseRankFactorMaintenance>
{

	public RankFactorMaintenance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "rank_factor_maintenances";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseRankFactorMaintenance.CS_RANK_FACTOR_MAINTENANCE_ID;
		__column_names[1] = BaseRankFactorMaintenance.CS_RANK_ID;
		__column_names[2] = BaseRankFactorMaintenance.CS_COEFFICIENT;
		__column_names[3] = BaseRankFactorMaintenance.CS_CREATE_TIME;
		__column_names[4] = BaseRankFactorMaintenance.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseRankFactorMaintenance b) {
		clear();
		setRankFactorMaintenanceIdClear(b.getRankFactorMaintenanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getRankFactorMaintenanceId() == null;
	}

	@Override
	public BaseRankFactorMaintenance generateBase(){
		BaseRankFactorMaintenance b = new BaseRankFactorMaintenance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseRankFactorMaintenance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setRankFactorMaintenanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRankId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCoefficient(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setRankFactorMaintenanceId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRankId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCoefficient(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseRankFactorMaintenance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getRankFactorMaintenanceId();
		buff[count++] = b.getRankId();
		buff[count++] = b.getCoefficient();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseRankFactorMaintenance b){
		if(b.getRankFactorMaintenanceId() != null) setRankFactorMaintenanceIdClear(b.getRankFactorMaintenanceId());
		if(b.getRankId() != null) setRankId(b.getRankId());
		if(b.getCoefficient() != null) setCoefficient(b.getCoefficient());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseRankFactorMaintenance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseRankFactorMaintenance b = new BaseRankFactorMaintenance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseRankFactorMaintenance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRankFactorMaintenanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRankId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoefficient(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setRankFactorMaintenanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getRankFactorMaintenanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setRankFactorMaintenanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setRankId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getRankId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCoefficient(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getCoefficient() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionRankFactorMaintenanceId(String op, java.lang.Integer val) {
		setConditionRankFactorMaintenanceId(op, val, CONDITION_AND);
	}

	public void setConditionRankFactorMaintenanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectRankFactorMaintenanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setRankFactorMaintenanceIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionRankId(String op, java.lang.Integer val) {
		setConditionRankId(op, val, CONDITION_AND);
	}

	public void setConditionRankId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectRankId(boolean val) {
		__select_flags[1] = val;
	}

	public void setRankIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionCoefficient(String op, java.math.BigDecimal val) {
		setConditionCoefficient(op, val, CONDITION_AND);
	}

	public void setConditionCoefficient(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCoefficient(boolean val) {
		__select_flags[2] = val;
	}

	public void setCoefficientExpression(String val) {
		__dataExpressions[2] = val;
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

	public void setCreateTimeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[4] = val;
	}


}

