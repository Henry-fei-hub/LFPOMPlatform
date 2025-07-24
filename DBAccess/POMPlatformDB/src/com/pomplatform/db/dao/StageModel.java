package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseStageModel;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class StageModel extends AbstractTable<BaseStageModel>
{

	public StageModel() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "stage_models";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStageModel.CS_STAGE_MODEL_ID;
		__column_names[1] = BaseStageModel.CS_STAGE_MODEL_NAME;
		__column_names[2] = BaseStageModel.CS_PERCENT;
		__column_names[3] = BaseStageModel.CS_PARENT_ID;
		__column_names[4] = BaseStageModel.CS_LEAF_NODE;
		__column_names[5] = BaseStageModel.CS_ORDER_NO;
		__column_names[6] = BaseStageModel.CS_NEED_MANAGER_AUDIT;
		__column_names[7] = BaseStageModel.CS_NEED_DESIGN_DIRECTOR_AUDIT;
		__column_names[8] = BaseStageModel.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseStageModel b) {
		clear();
		setStageModelIdClear(b.getStageModelId());
	}

	public boolean isPrimaryKeyNull() {
		return getStageModelId() == null;
	}

	@Override
	public BaseStageModel generateBase(){
		BaseStageModel b = new BaseStageModel();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStageModel b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStageModelId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageModelName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLeafNode(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNeedManagerAudit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setNeedDesignDirectorAudit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseStageModel b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStageModelId();
		buff[count++] = b.getStageModelName();
		buff[count++] = b.getPercent();
		buff[count++] = b.getParentId();
		buff[count++] = b.getLeafNode();
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getNeedManagerAudit();
		buff[count++] = b.getNeedDesignDirectorAudit();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseStageModel b){
		if(b.getStageModelId() != null) setStageModelIdClear(b.getStageModelId());
		if(b.getStageModelName() != null) setStageModelName(b.getStageModelName());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getLeafNode() != null) setLeafNode(b.getLeafNode());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getNeedManagerAudit() != null) setNeedManagerAudit(b.getNeedManagerAudit());
		if(b.getNeedDesignDirectorAudit() != null) setNeedDesignDirectorAudit(b.getNeedDesignDirectorAudit());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseStageModel generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStageModel b = new BaseStageModel();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStageModel __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageModelId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageModelName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeafNode(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNeedManagerAudit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNeedDesignDirectorAudit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setStageModelId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getStageModelId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setStageModelIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setStageModelName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getStageModelName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setLeafNode(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getLeafNode() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setNeedManagerAudit(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getNeedManagerAudit() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setNeedDesignDirectorAudit(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getNeedDesignDirectorAudit() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionStageModelId(String op, java.lang.Integer val) {
		setConditionStageModelId(op, val, CONDITION_AND);
	}

	public void setConditionStageModelId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStageModelId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionStageModelName(String op, java.lang.String val) {
		setConditionStageModelName(op, val, CONDITION_AND);
	}

	public void setConditionStageModelName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectStageModelName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[2] = val;
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

	public void setConditionLeafNode(String op, java.lang.Boolean val) {
		setConditionLeafNode(op, val, CONDITION_AND);
	}

	public void setConditionLeafNode(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectLeafNode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionNeedManagerAudit(String op, java.lang.Boolean val) {
		setConditionNeedManagerAudit(op, val, CONDITION_AND);
	}

	public void setConditionNeedManagerAudit(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectNeedManagerAudit(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionNeedDesignDirectorAudit(String op, java.lang.Boolean val) {
		setConditionNeedDesignDirectorAudit(op, val, CONDITION_AND);
	}

	public void setConditionNeedDesignDirectorAudit(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectNeedDesignDirectorAudit(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}


}

