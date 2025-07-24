package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;


public class ProjectSettlementDetail extends AbstractTable<BaseProjectSettlementDetail>
{

	public ProjectSettlementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "project_settlement_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectSettlementDetail.CS_SETTLEMENT_DETAIL_ID;
		__column_names[1] = BaseProjectSettlementDetail.CS_SETTLEMENT_ID;
		__column_names[2] = BaseProjectSettlementDetail.CS_PROJECT_ID;
		__column_names[3] = BaseProjectSettlementDetail.CS_EMPLOYEE_ID;
		__column_names[4] = BaseProjectSettlementDetail.CS_WORK_CONTENT;
		__column_names[5] = BaseProjectSettlementDetail.CS_SETTLEMENT_DATE;
		__column_names[6] = BaseProjectSettlementDetail.CS_PLAN_AMOUNT;
		__column_names[7] = BaseProjectSettlementDetail.CS_REAL_AMOUNT;
		__column_names[8] = BaseProjectSettlementDetail.CS_PROJECT_COST;
		__column_names[9] = BaseProjectSettlementDetail.CS_FINAL_AMOUNT;
		__column_names[10] = BaseProjectSettlementDetail.CS_STATUS;
		__column_names[11] = BaseProjectSettlementDetail.CS_FINISH_PERCENT;
		__column_names[12] = BaseProjectSettlementDetail.CS_IS_RETURN;
		__column_names[13] = BaseProjectSettlementDetail.CS_ADJUSTED_AMOUNT;
		__column_names[14] = BaseProjectSettlementDetail.CS_SETTLEMENT_STATUS;
		__column_names[15] = BaseProjectSettlementDetail.CS_SURE_INTEGRAL;
		__column_names[16] = BaseProjectSettlementDetail.CS_COST;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectSettlementDetail b) {
		clear();
		setSettlementDetailIdClear(b.getSettlementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getSettlementDetailId() == null;
	}

	@Override
	public BaseProjectSettlementDetail generateBase(){
		BaseProjectSettlementDetail b = new BaseProjectSettlementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectSettlementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSettlementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlanAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRealAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setAdjustedAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSettlementStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCost(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setSettlementDetailId(GenericBase.__getInt(val));
		}
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
			if(val != null && !val.isEmpty()) setWorkContent(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSettlementDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlanAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRealAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCost(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFinalAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFinishPercent(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsReturn(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAdjustedAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSettlementStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSureIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCost(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectSettlementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSettlementDetailId();
		buff[count++] = b.getSettlementId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getWorkContent();
		buff[count++] = generateTimestampFromDate(b.getSettlementDate());
		buff[count++] = b.getPlanAmount();
		buff[count++] = b.getRealAmount();
		buff[count++] = b.getProjectCost();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getStatus();
		buff[count++] = b.getFinishPercent();
		buff[count++] = b.getIsReturn();
		buff[count++] = b.getAdjustedAmount();
		buff[count++] = b.getSettlementStatus();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getCost();
	}

	@Override
	public void setDataFromBase(BaseProjectSettlementDetail b){
		if(b.getSettlementDetailId() != null) setSettlementDetailIdClear(b.getSettlementDetailId());
		if(b.getSettlementId() != null) setSettlementId(b.getSettlementId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getWorkContent() != null) setWorkContent(b.getWorkContent());
		if(b.getSettlementDate() != null) setSettlementDate(b.getSettlementDate());
		if(b.getPlanAmount() != null) setPlanAmount(b.getPlanAmount());
		if(b.getRealAmount() != null) setRealAmount(b.getRealAmount());
		if(b.getProjectCost() != null) setProjectCost(b.getProjectCost());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getFinishPercent() != null) setFinishPercent(b.getFinishPercent());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
		if(b.getAdjustedAmount() != null) setAdjustedAmount(b.getAdjustedAmount());
		if(b.getSettlementStatus() != null) setSettlementStatus(b.getSettlementStatus());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getCost() != null) setCost(b.getCost());
	}

	@Override
	public BaseProjectSettlementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectSettlementDetail b = new BaseProjectSettlementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectSettlementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdjustedAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCost(GenericBase.__getDecimal(val));
	}

	public void setSettlementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSettlementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSettlementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSettlementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSettlementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setWorkContent(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getWorkContent() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setSettlementDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getSettlementDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setPlanAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPlanAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRealAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getRealAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setProjectCost(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getProjectCost() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setFinishPercent(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getFinishPercent() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setAdjustedAmount(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getAdjustedAmount() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setSettlementStatus(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getSettlementStatus() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setCost(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getCost() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setConditionSettlementDetailId(String op, java.lang.Integer val) {
		setConditionSettlementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionSettlementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSettlementDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setSettlementDetailIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionSettlementId(String op, java.lang.Integer val) {
		setConditionSettlementId(op, val, CONDITION_AND);
	}

	public void setConditionSettlementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSettlementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setSettlementIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setProjectIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionWorkContent(String op, java.lang.String val) {
		setConditionWorkContent(op, val, CONDITION_AND);
	}

	public void setConditionWorkContent(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectWorkContent(boolean val) {
		__select_flags[4] = val;
	}

	public void setWorkContentExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionSettlementDate(String op, java.util.Date val) {
		setConditionSettlementDate(op, val, CONDITION_AND);
	}

	public void setConditionSettlementDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSettlementDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setSettlementDateExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionPlanAmount(String op, java.math.BigDecimal val) {
		setConditionPlanAmount(op, val, CONDITION_AND);
	}

	public void setConditionPlanAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPlanAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setPlanAmountExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionRealAmount(String op, java.math.BigDecimal val) {
		setConditionRealAmount(op, val, CONDITION_AND);
	}

	public void setConditionRealAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRealAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setRealAmountExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val) {
		setConditionProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectCost(boolean val) {
		__select_flags[8] = val;
	}

	public void setProjectCostExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[9] = val;
	}

	public void setFinalAmountExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionFinishPercent(String op, java.math.BigDecimal val) {
		setConditionFinishPercent(op, val, CONDITION_AND);
	}

	public void setConditionFinishPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectFinishPercent(boolean val) {
		__select_flags[11] = val;
	}

	public void setFinishPercentExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[12] = val;
	}

	public void setIsReturnExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionAdjustedAmount(String op, java.math.BigDecimal val) {
		setConditionAdjustedAmount(op, val, CONDITION_AND);
	}

	public void setConditionAdjustedAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectAdjustedAmount(boolean val) {
		__select_flags[13] = val;
	}

	public void setAdjustedAmountExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionSettlementStatus(String op, java.lang.Integer val) {
		setConditionSettlementStatus(op, val, CONDITION_AND);
	}

	public void setConditionSettlementStatus(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectSettlementStatus(boolean val) {
		__select_flags[14] = val;
	}

	public void setSettlementStatusExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[15] = val;
	}

	public void setSureIntegralExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionCost(String op, java.math.BigDecimal val) {
		setConditionCost(op, val, CONDITION_AND);
	}

	public void setConditionCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCost(boolean val) {
		__select_flags[16] = val;
	}

	public void setCostExpression(String val) {
		__dataExpressions[16] = val;
	}


}

