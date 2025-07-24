package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractStageModel;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractStageModel extends AbstractTable<BaseContractStageModel>
{

	public ContractStageModel() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 24;

		initTables();

		__tableName            = "contract_stage_models";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID;
		__column_names[1] = BaseContractStageModel.CS_CONTRACT_ID;
		__column_names[2] = BaseContractStageModel.CS_STAGE_MODEL_ID;
		__column_names[3] = BaseContractStageModel.CS_STAGE_MODEL_NAME;
		__column_names[4] = BaseContractStageModel.CS_PERCENT;
		__column_names[5] = BaseContractStageModel.CS_PARENT_ID;
		__column_names[6] = BaseContractStageModel.CS_LEAF_NODE;
		__column_names[7] = BaseContractStageModel.CS_ORDER_NO;
		__column_names[8] = BaseContractStageModel.CS_NEED_MANAGER_AUDIT;
		__column_names[9] = BaseContractStageModel.CS_NEED_DESIGN_DIRECTOR_AUDIT;
		__column_names[10] = BaseContractStageModel.CS_ACTUAL_PERCENT;
		__column_names[11] = BaseContractStageModel.CS_REMARK;
		__column_names[12] = BaseContractStageModel.CS_MANAGER_COMMENT;
		__column_names[13] = BaseContractStageModel.CS_MANAGER_ID;
		__column_names[14] = BaseContractStageModel.CS_MANAGER_AUDIT_DATE;
		__column_names[15] = BaseContractStageModel.CS_DESIGN_DIRECTOR_COMMENT;
		__column_names[16] = BaseContractStageModel.CS_DESIGN_DIRECTOR_ID;
		__column_names[17] = BaseContractStageModel.CS_DESIGN_DIRECTOR_AUDIT_DATE;
		__column_names[18] = BaseContractStageModel.CS_LOCKED;
		__column_names[19] = BaseContractStageModel.CS_PROCESS_STATUS;
		__column_names[20] = BaseContractStageModel.CS_CONFIRM_DATE;
		__column_names[21] = BaseContractStageModel.CS_HAS_EVIDENCE;
		__column_names[22] = BaseContractStageModel.CS_EVIDENCE;
		__column_names[23] = BaseContractStageModel.CS_YEAR;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractStageModel b) {
		clear();
		setContractStageModelIdClear(b.getContractStageModelId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractStageModelId() == null;
	}

	@Override
	public BaseContractStageModel generateBase(){
		BaseContractStageModel b = new BaseContractStageModel();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractStageModel b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractStageModelId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageModelId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageModelName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLeafNode(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNeedManagerAudit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setNeedDesignDirectorAudit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setActualPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setManagerComment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setManagerAuditDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDesignDirectorComment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignDirectorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignDirectorAuditDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setConfirmDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHasEvidence(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setEvidence(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractStageModel b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractStageModelId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getStageModelId();
		buff[count++] = b.getStageModelName();
		buff[count++] = b.getPercent();
		buff[count++] = b.getParentId();
		buff[count++] = b.getLeafNode();
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getNeedManagerAudit();
		buff[count++] = b.getNeedDesignDirectorAudit();
		buff[count++] = b.getActualPercent();
		buff[count++] = b.getRemark();
		buff[count++] = b.getManagerComment();
		buff[count++] = b.getManagerId();
		buff[count++] = generateTimestampFromDate(b.getManagerAuditDate());
		buff[count++] = b.getDesignDirectorComment();
		buff[count++] = b.getDesignDirectorId();
		buff[count++] = generateTimestampFromDate(b.getDesignDirectorAuditDate());
		buff[count++] = b.getLocked();
		buff[count++] = b.getProcessStatus();
		buff[count++] = generateTimestampFromDate(b.getConfirmDate());
		buff[count++] = b.getHasEvidence();
		buff[count++] = b.getEvidence();
		buff[count++] = b.getYear();
	}

	@Override
	public void setDataFromBase(BaseContractStageModel b){
		if(b.getContractStageModelId() != null) setContractStageModelIdClear(b.getContractStageModelId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getStageModelId() != null) setStageModelId(b.getStageModelId());
		if(b.getStageModelName() != null) setStageModelName(b.getStageModelName());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getLeafNode() != null) setLeafNode(b.getLeafNode());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getNeedManagerAudit() != null) setNeedManagerAudit(b.getNeedManagerAudit());
		if(b.getNeedDesignDirectorAudit() != null) setNeedDesignDirectorAudit(b.getNeedDesignDirectorAudit());
		if(b.getActualPercent() != null) setActualPercent(b.getActualPercent());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getManagerComment() != null) setManagerComment(b.getManagerComment());
		if(b.getManagerId() != null) setManagerId(b.getManagerId());
		if(b.getManagerAuditDate() != null) setManagerAuditDate(b.getManagerAuditDate());
		if(b.getDesignDirectorComment() != null) setDesignDirectorComment(b.getDesignDirectorComment());
		if(b.getDesignDirectorId() != null) setDesignDirectorId(b.getDesignDirectorId());
		if(b.getDesignDirectorAuditDate() != null) setDesignDirectorAuditDate(b.getDesignDirectorAuditDate());
		if(b.getLocked() != null) setLocked(b.getLocked());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
		if(b.getConfirmDate() != null) setConfirmDate(b.getConfirmDate());
		if(b.getHasEvidence() != null) setHasEvidence(b.getHasEvidence());
		if(b.getEvidence() != null) setEvidence(b.getEvidence());
		if(b.getYear() != null) setYear(b.getYear());
	}

	@Override
	public BaseContractStageModel generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractStageModel b = new BaseContractStageModel();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractStageModel __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStageModelId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageModelId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageModelName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeafNode(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNeedManagerAudit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNeedDesignDirectorAudit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManagerComment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManagerAuditDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignDirectorComment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignDirectorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignDirectorAuditDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setConfirmDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasEvidence(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEvidence(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
	}

	public void setContractStageModelId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractStageModelId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractStageModelIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStageModelId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStageModelId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setStageModelName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getStageModelName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setLeafNode(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getLeafNode() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setNeedManagerAudit(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getNeedManagerAudit() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setNeedDesignDirectorAudit(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getNeedDesignDirectorAudit() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setActualPercent(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getActualPercent() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setManagerComment(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getManagerComment() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setManagerId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getManagerId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setManagerAuditDate(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getManagerAuditDate() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setDesignDirectorComment(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getDesignDirectorComment() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setDesignDirectorId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getDesignDirectorId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setDesignDirectorAuditDate(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getDesignDirectorAuditDate() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setLocked(java.lang.Boolean val) {
		setCurrentData(18, val);
	}

	public java.lang.Boolean getLocked() {
		return GenericBase.__getBoolean(__current_data[18]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setConfirmDate(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getConfirmDate() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setHasEvidence(java.lang.Boolean val) {
		setCurrentData(21, val);
	}

	public java.lang.Boolean getHasEvidence() {
		return GenericBase.__getBoolean(__current_data[21]);
	}

	public void setEvidence(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getEvidence() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setConditionContractStageModelId(String op, java.lang.Integer val) {
		setConditionContractStageModelId(op, val, CONDITION_AND);
	}

	public void setConditionContractStageModelId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractStageModelId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStageModelId(String op, java.lang.Integer val) {
		setConditionStageModelId(op, val, CONDITION_AND);
	}

	public void setConditionStageModelId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStageModelId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStageModelName(String op, java.lang.String val) {
		setConditionStageModelName(op, val, CONDITION_AND);
	}

	public void setConditionStageModelName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectStageModelName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionLeafNode(String op, java.lang.Boolean val) {
		setConditionLeafNode(op, val, CONDITION_AND);
	}

	public void setConditionLeafNode(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectLeafNode(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionNeedManagerAudit(String op, java.lang.Boolean val) {
		setConditionNeedManagerAudit(op, val, CONDITION_AND);
	}

	public void setConditionNeedManagerAudit(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectNeedManagerAudit(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionNeedDesignDirectorAudit(String op, java.lang.Boolean val) {
		setConditionNeedDesignDirectorAudit(op, val, CONDITION_AND);
	}

	public void setConditionNeedDesignDirectorAudit(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectNeedDesignDirectorAudit(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionActualPercent(String op, java.math.BigDecimal val) {
		setConditionActualPercent(op, val, CONDITION_AND);
	}

	public void setConditionActualPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectActualPercent(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionManagerComment(String op, java.lang.String val) {
		setConditionManagerComment(op, val, CONDITION_AND);
	}

	public void setConditionManagerComment(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectManagerComment(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionManagerId(String op, java.lang.Integer val) {
		setConditionManagerId(op, val, CONDITION_AND);
	}

	public void setConditionManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectManagerId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionManagerAuditDate(String op, java.util.Date val) {
		setConditionManagerAuditDate(op, val, CONDITION_AND);
	}

	public void setConditionManagerAuditDate(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectManagerAuditDate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDesignDirectorComment(String op, java.lang.String val) {
		setConditionDesignDirectorComment(op, val, CONDITION_AND);
	}

	public void setConditionDesignDirectorComment(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDesignDirectorComment(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionDesignDirectorId(String op, java.lang.Integer val) {
		setConditionDesignDirectorId(op, val, CONDITION_AND);
	}

	public void setConditionDesignDirectorId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectDesignDirectorId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionDesignDirectorAuditDate(String op, java.util.Date val) {
		setConditionDesignDirectorAuditDate(op, val, CONDITION_AND);
	}

	public void setConditionDesignDirectorAuditDate(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDesignDirectorAuditDate(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionLocked(String op, java.lang.Boolean val) {
		setConditionLocked(op, val, CONDITION_AND);
	}

	public void setConditionLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectLocked(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionConfirmDate(String op, java.util.Date val) {
		setConditionConfirmDate(op, val, CONDITION_AND);
	}

	public void setConditionConfirmDate(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectConfirmDate(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionHasEvidence(String op, java.lang.Boolean val) {
		setConditionHasEvidence(op, val, CONDITION_AND);
	}

	public void setConditionHasEvidence(String op, java.lang.Boolean val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectHasEvidence(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionEvidence(String op, java.lang.String val) {
		setConditionEvidence(op, val, CONDITION_AND);
	}

	public void setConditionEvidence(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectEvidence(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[23] = val;
	}


}

