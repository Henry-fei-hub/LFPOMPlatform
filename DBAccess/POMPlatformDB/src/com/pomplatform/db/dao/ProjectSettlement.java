package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectSettlement;


public class ProjectSettlement extends AbstractTable<BaseProjectSettlement>
{

	public ProjectSettlement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "project_settlements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectSettlement.CS_SETTLEMENT_ID;
		__column_names[1] = BaseProjectSettlement.CS_PROJECT_ID;
		__column_names[2] = BaseProjectSettlement.CS_EMPLOYEE_ID;
		__column_names[3] = BaseProjectSettlement.CS_REMARK;
		__column_names[4] = BaseProjectSettlement.CS_SETTLEMENT_DATE;
		__column_names[5] = BaseProjectSettlement.CS_TOTAL_AMOUNT;
		__column_names[6] = BaseProjectSettlement.CS_TOTAL_COST;
		__column_names[7] = BaseProjectSettlement.CS_PROJECT_AMOUNT;
		__column_names[8] = BaseProjectSettlement.CS_LEFT_AMOUNT;
		__column_names[9] = BaseProjectSettlement.CS_STATUS;
		__column_names[10] = BaseProjectSettlement.CS_STAGE_ID;
		__column_names[11] = BaseProjectSettlement.CS_SETTLEMENT_STATUS;
		__column_names[12] = BaseProjectSettlement.CS_FLAG;
		__column_names[13] = BaseProjectSettlement.CS_RESERVE_AMOUNT;
		__column_names[14] = BaseProjectSettlement.CS_FINAL_AMOUNT;
		__column_names[15] = BaseProjectSettlement.CS_TOTAL_COUNT;
		__column_names[16] = BaseProjectSettlement.CS_SURE_AMOUNT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectSettlement b) {
		clear();
		setSettlementIdClear(b.getSettlementId());
	}

	public boolean isPrimaryKeyNull() {
		return getSettlementId() == null;
	}

	@Override
	public BaseProjectSettlement generateBase(){
		BaseProjectSettlement b = new BaseProjectSettlement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectSettlement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSettlementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlementStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReserveAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSureAmount(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setSettlementId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSettlementDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalCost(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLeftAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSettlementStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFlag(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReserveAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFinalAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalCount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSureAmount(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectSettlement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSettlementId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getSettlementDate());
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getTotalCost();
		buff[count++] = b.getProjectAmount();
		buff[count++] = b.getLeftAmount();
		buff[count++] = b.getStatus();
		buff[count++] = b.getStageId();
		buff[count++] = b.getSettlementStatus();
		buff[count++] = b.getFlag();
		buff[count++] = b.getReserveAmount();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getTotalCount();
		buff[count++] = b.getSureAmount();
	}

	@Override
	public void setDataFromBase(BaseProjectSettlement b){
		if(b.getSettlementId() != null) setSettlementIdClear(b.getSettlementId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getSettlementDate() != null) setSettlementDate(b.getSettlementDate());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getTotalCost() != null) setTotalCost(b.getTotalCost());
		if(b.getProjectAmount() != null) setProjectAmount(b.getProjectAmount());
		if(b.getLeftAmount() != null) setLeftAmount(b.getLeftAmount());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getSettlementStatus() != null) setSettlementStatus(b.getSettlementStatus());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getReserveAmount() != null) setReserveAmount(b.getReserveAmount());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getTotalCount() != null) setTotalCount(b.getTotalCount());
		if(b.getSureAmount() != null) setSureAmount(b.getSureAmount());
	}

	@Override
	public BaseProjectSettlement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectSettlement b = new BaseProjectSettlement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectSettlement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureAmount(GenericBase.__getDecimal(val));
	}

	public void setSettlementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSettlementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSettlementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setSettlementDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getSettlementDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setTotalCost(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTotalCost() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setProjectAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getProjectAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setLeftAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getLeftAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSettlementStatus(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getSettlementStatus() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setReserveAmount(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getReserveAmount() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setTotalCount(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getTotalCount() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setSureAmount(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getSureAmount() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setConditionSettlementId(String op, java.lang.Integer val) {
		setConditionSettlementId(op, val, CONDITION_AND);
	}

	public void setConditionSettlementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSettlementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setSettlementIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setProjectIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionSettlementDate(String op, java.util.Date val) {
		setConditionSettlementDate(op, val, CONDITION_AND);
	}

	public void setConditionSettlementDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSettlementDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setSettlementDateExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setTotalAmountExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionTotalCost(String op, java.math.BigDecimal val) {
		setConditionTotalCost(op, val, CONDITION_AND);
	}

	public void setConditionTotalCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTotalCost(boolean val) {
		__select_flags[6] = val;
	}

	public void setTotalCostExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val) {
		setConditionProjectAmount(op, val, CONDITION_AND);
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setProjectAmountExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionLeftAmount(String op, java.math.BigDecimal val) {
		setConditionLeftAmount(op, val, CONDITION_AND);
	}

	public void setConditionLeftAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLeftAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setLeftAmountExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[9] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[10] = val;
	}

	public void setStageIdExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionSettlementStatus(String op, java.lang.Integer val) {
		setConditionSettlementStatus(op, val, CONDITION_AND);
	}

	public void setConditionSettlementStatus(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSettlementStatus(boolean val) {
		__select_flags[11] = val;
	}

	public void setSettlementStatusExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[12] = val;
	}

	public void setFlagExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionReserveAmount(String op, java.math.BigDecimal val) {
		setConditionReserveAmount(op, val, CONDITION_AND);
	}

	public void setConditionReserveAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectReserveAmount(boolean val) {
		__select_flags[13] = val;
	}

	public void setReserveAmountExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setFinalAmountExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionTotalCount(String op, java.lang.Integer val) {
		setConditionTotalCount(op, val, CONDITION_AND);
	}

	public void setConditionTotalCount(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectTotalCount(boolean val) {
		__select_flags[15] = val;
	}

	public void setTotalCountExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionSureAmount(String op, java.math.BigDecimal val) {
		setConditionSureAmount(op, val, CONDITION_AND);
	}

	public void setConditionSureAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectSureAmount(boolean val) {
		__select_flags[16] = val;
	}

	public void setSureAmountExpression(String val) {
		__dataExpressions[16] = val;
	}


}

