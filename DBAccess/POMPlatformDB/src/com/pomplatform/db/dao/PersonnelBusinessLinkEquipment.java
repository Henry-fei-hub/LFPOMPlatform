package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment;


public class PersonnelBusinessLinkEquipment extends AbstractTable<BasePersonnelBusinessLinkEquipment>
{

	public PersonnelBusinessLinkEquipment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "personnel_business_link_equipments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePersonnelBusinessLinkEquipment.CS_PERSONNEL_BUSINESS_LINK_EQUIPMENT_ID;
		__column_names[1] = BasePersonnelBusinessLinkEquipment.CS_PARENT_ID;
		__column_names[2] = BasePersonnelBusinessLinkEquipment.CS_PROCESS_TYPE;
		__column_names[3] = BasePersonnelBusinessLinkEquipment.CS_TYPE;
		__column_names[4] = BasePersonnelBusinessLinkEquipment.CS_AMOUNT;
		__column_names[5] = BasePersonnelBusinessLinkEquipment.CS_PRICE;
		__column_names[6] = BasePersonnelBusinessLinkEquipment.CS_TOTAL_PRICE;
		__column_names[7] = BasePersonnelBusinessLinkEquipment.CS_REMARK;
		__column_names[8] = BasePersonnelBusinessLinkEquipment.CS_IS_ALLOWED;
		__column_names[9] = BasePersonnelBusinessLinkEquipment.CS_CREATE_TIME;
		__column_names[10] = BasePersonnelBusinessLinkEquipment.CS_IS_RETURN;
		__column_names[11] = BasePersonnelBusinessLinkEquipment.CS_RETURN_AMOUNT;
		__column_names[12] = BasePersonnelBusinessLinkEquipment.CS_REMAINING_RETURN;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePersonnelBusinessLinkEquipment b) {
		clear();
		setPersonnelBusinessLinkEquipmentIdClear(b.getPersonnelBusinessLinkEquipmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getPersonnelBusinessLinkEquipmentId() == null;
	}

	@Override
	public BasePersonnelBusinessLinkEquipment generateBase(){
		BasePersonnelBusinessLinkEquipment b = new BasePersonnelBusinessLinkEquipment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePersonnelBusinessLinkEquipment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessLinkEquipmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsAllowed(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setReturnAmount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemainingReturn(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setPersonnelBusinessLinkEquipmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProcessType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAmount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPrice(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalPrice(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsAllowed(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsReturn(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReturnAmount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemainingReturn(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BasePersonnelBusinessLinkEquipment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPersonnelBusinessLinkEquipmentId();
		buff[count++] = b.getParentId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getType();
		buff[count++] = b.getAmount();
		buff[count++] = b.getPrice();
		buff[count++] = b.getTotalPrice();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsAllowed();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getIsReturn();
		buff[count++] = b.getReturnAmount();
		buff[count++] = b.getRemainingReturn();
	}

	@Override
	public void setDataFromBase(BasePersonnelBusinessLinkEquipment b){
		if(b.getPersonnelBusinessLinkEquipmentId() != null) setPersonnelBusinessLinkEquipmentIdClear(b.getPersonnelBusinessLinkEquipmentId());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getType() != null) setType(b.getType());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getPrice() != null) setPrice(b.getPrice());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsAllowed() != null) setIsAllowed(b.getIsAllowed());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
		if(b.getReturnAmount() != null) setReturnAmount(b.getReturnAmount());
		if(b.getRemainingReturn() != null) setRemainingReturn(b.getRemainingReturn());
	}

	@Override
	public BasePersonnelBusinessLinkEquipment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePersonnelBusinessLinkEquipment b = new BasePersonnelBusinessLinkEquipment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePersonnelBusinessLinkEquipment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessLinkEquipmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsAllowed(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnAmount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemainingReturn(GenericBase.__getInt(val));
	}

	public void setPersonnelBusinessLinkEquipmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPersonnelBusinessLinkEquipmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPersonnelBusinessLinkEquipmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setAmount(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getAmount() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setPrice(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPrice() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIsAllowed(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsAllowed() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setReturnAmount(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getReturnAmount() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setRemainingReturn(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getRemainingReturn() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setConditionPersonnelBusinessLinkEquipmentId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessLinkEquipmentId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessLinkEquipmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPersonnelBusinessLinkEquipmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setPersonnelBusinessLinkEquipmentIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[1] = val;
	}

	public void setParentIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[2] = val;
	}

	public void setProcessTypeExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[3] = val;
	}

	public void setTypeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionAmount(String op, java.lang.Integer val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setAmountExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionPrice(String op, java.math.BigDecimal val) {
		setConditionPrice(op, val, CONDITION_AND);
	}

	public void setConditionPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPrice(boolean val) {
		__select_flags[5] = val;
	}

	public void setPriceExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
		__select_flags[6] = val;
	}

	public void setTotalPriceExpression(String val) {
		__dataExpressions[6] = val;
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

	public void setRemarkExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionIsAllowed(String op, java.lang.Boolean val) {
		setConditionIsAllowed(op, val, CONDITION_AND);
	}

	public void setConditionIsAllowed(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsAllowed(boolean val) {
		__select_flags[8] = val;
	}

	public void setIsAllowedExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[10] = val;
	}

	public void setIsReturnExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionReturnAmount(String op, java.lang.Integer val) {
		setConditionReturnAmount(op, val, CONDITION_AND);
	}

	public void setConditionReturnAmount(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectReturnAmount(boolean val) {
		__select_flags[11] = val;
	}

	public void setReturnAmountExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionRemainingReturn(String op, java.lang.Integer val) {
		setConditionRemainingReturn(op, val, CONDITION_AND);
	}

	public void setConditionRemainingReturn(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemainingReturn(boolean val) {
		__select_flags[12] = val;
	}

	public void setRemainingReturnExpression(String val) {
		__dataExpressions[12] = val;
	}


}

