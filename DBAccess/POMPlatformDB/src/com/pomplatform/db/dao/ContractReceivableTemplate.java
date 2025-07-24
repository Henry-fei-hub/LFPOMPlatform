package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseContractReceivableTemplate;


public class ContractReceivableTemplate extends AbstractTable<BaseContractReceivableTemplate>
{

	public ContractReceivableTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "contract_receivable_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractReceivableTemplate.CS_CONTRACT_RECEIVABLE_TEMPLATE_ID;
		__column_names[1] = BaseContractReceivableTemplate.CS_RECEIVABLE_NAME;
		__column_names[2] = BaseContractReceivableTemplate.CS_REMARK;
		__column_names[3] = BaseContractReceivableTemplate.CS_PARENT_ID;
		__column_names[4] = BaseContractReceivableTemplate.CS_OPERATOR;
		__column_names[5] = BaseContractReceivableTemplate.CS_CREATE_TIME;
		__column_names[6] = BaseContractReceivableTemplate.CS_UPDATE_TIME;
		__column_names[7] = BaseContractReceivableTemplate.CS_RECEIVABLE_PERCENTAGE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractReceivableTemplate b) {
		clear();
		setContractReceivableTemplateIdClear(b.getContractReceivableTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractReceivableTemplateId() == null;
	}

	@Override
	public BaseContractReceivableTemplate generateBase(){
		BaseContractReceivableTemplate b = new BaseContractReceivableTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractReceivableTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractReceivableTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceivableName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setReceivablePercentage(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setContractReceivableTemplateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReceivableName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperator(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUpdateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReceivablePercentage(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseContractReceivableTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractReceivableTemplateId();
		buff[count++] = b.getReceivableName();
		buff[count++] = b.getRemark();
		buff[count++] = b.getParentId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getReceivablePercentage();
	}

	@Override
	public void setDataFromBase(BaseContractReceivableTemplate b){
		if(b.getContractReceivableTemplateId() != null) setContractReceivableTemplateIdClear(b.getContractReceivableTemplateId());
		if(b.getReceivableName() != null) setReceivableName(b.getReceivableName());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getReceivablePercentage() != null) setReceivablePercentage(b.getReceivablePercentage());
	}

	@Override
	public BaseContractReceivableTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractReceivableTemplate b = new BaseContractReceivableTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractReceivableTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivableName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
	}

	public void setContractReceivableTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractReceivableTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractReceivableTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setReceivableName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getReceivableName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setReceivablePercentage(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getReceivablePercentage() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setConditionContractReceivableTemplateId(String op, java.lang.Integer val) {
		setConditionContractReceivableTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractReceivableTemplateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setContractReceivableTemplateIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionReceivableName(String op, java.lang.String val) {
		setConditionReceivableName(op, val, CONDITION_AND);
	}

	public void setConditionReceivableName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectReceivableName(boolean val) {
		__select_flags[1] = val;
	}

	public void setReceivableNameExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[2] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setParentIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[4] = val;
	}

	public void setOperatorExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setUpdateTimeExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionReceivablePercentage(String op, java.math.BigDecimal val) {
		setConditionReceivablePercentage(op, val, CONDITION_AND);
	}

	public void setConditionReceivablePercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectReceivablePercentage(boolean val) {
		__select_flags[7] = val;
	}

	public void setReceivablePercentageExpression(String val) {
		__dataExpressions[7] = val;
	}


}

