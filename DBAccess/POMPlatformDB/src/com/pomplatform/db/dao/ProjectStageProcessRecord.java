package com.pomplatform.db.dao;

import java.util.List;
import java.util.Map;
import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import delicacy.common.CommonUtils;
import com.pomplatform.db.bean.BaseProjectStageProcessRecord;


public class ProjectStageProcessRecord extends AbstractTable<BaseProjectStageProcessRecord>
{

	public ProjectStageProcessRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	public static int count(Map params) throws java.sql.SQLException {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setConditionFromMap(CommonUtils.preprocess(params));
		return dao.countRows();
	}

	public static boolean exists(Map params) throws java.sql.SQLException {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setConditionFromMap(CommonUtils.preprocess(params));
		return dao.isExist();
	}

	public static List<BaseProjectStageProcessRecord> select(Map params) throws java.sql.SQLException {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		params = CommonUtils.preprocess(params);
		if(params.containsKey(GenericBase.NAME_CURRENT_PAGE)) dao.setCurrentPage(GenericBase.__getInt(params.get(GenericBase.NAME_CURRENT_PAGE)));
		if(params.containsKey(GenericBase.NAME_PAGE_LINES)) dao.setPageLines(GenericBase.__getInt(params.get(GenericBase.NAME_PAGE_LINES)));
		dao.setConditionFromMap(params);
		return dao.conditionalLoad();
	}

	public static BaseProjectStageProcessRecord selectOne(Map params) throws java.sql.SQLException {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setConditionFromMap(CommonUtils.preprocess(params));
		return dao.selectOne();
	}

	public static int saveOrUpdate(Map params, String columns) throws Exception {
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromMap(CommonUtils.preprocess(params));
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		return dao.saveOrUpdate(bean, columns);
	}

	public static int update(Map params) throws Exception {
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromMap(CommonUtils.preprocess(params));
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		return dao.saveOrUpdate(bean, dao.getKeyColumnName());
	}

	public static BaseProjectStageProcessRecord save(Map params) throws java.sql.SQLException {
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromMap(CommonUtils.preprocess(params));
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setDataFromBase(bean);
		dao.save();
		dao.setDataToBase(bean);
		return bean;
	}

	public static int delete(Map params) throws java.sql.SQLException {
		if(params == null || params.isEmpty()) return 0;
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		if(dao.setConditionFromMap(params) == 0) return 0;
		return dao.conditionalDelete();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 14;

		initTables();

		__tableName            = "project_stage_process_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectStageProcessRecord.CS_PROJECT_STAGE_PROCESS_RECORD_ID;
		__column_names[1] = BaseProjectStageProcessRecord.CS_CONTRACT_ID;
		__column_names[2] = BaseProjectStageProcessRecord.CS_MAIN_PROJECT_ID;
		__column_names[3] = BaseProjectStageProcessRecord.CS_PROJECT_NAME;
		__column_names[4] = BaseProjectStageProcessRecord.CS_PROJECT_CODE;
		__column_names[5] = BaseProjectStageProcessRecord.CS_PROJECT_AMOUNT_SUM;
		__column_names[6] = BaseProjectStageProcessRecord.CS_APPLY_AMOUNT;
		__column_names[7] = BaseProjectStageProcessRecord.CS_FILE_ID;
		__column_names[8] = BaseProjectStageProcessRecord.CS_FILE_URL;
		__column_names[9] = BaseProjectStageProcessRecord.CS_REMARK;
		__column_names[10] = BaseProjectStageProcessRecord.CS_EMPLOYEE_ID;
		__column_names[11] = BaseProjectStageProcessRecord.CS_EMPLOYEE_NO;
		__column_names[12] = BaseProjectStageProcessRecord.CS_CREATE_TIME;
		__column_names[13] = BaseProjectStageProcessRecord.CS_CURRENT_APPLY_RATE;
		__column_lens[0] = 32;
		__column_lens[1] = 32;
		__column_lens[2] = 32;
		__column_lens[3] = 128;
		__column_lens[4] = 128;
		__column_lens[5] = 12;
		__column_lens[6] = 12;
		__column_lens[7] = 32;
		__column_lens[8] = 128;
		__column_lens[9] = 256;
		__column_lens[10] = 32;
		__column_lens[11] = 32;
		__column_lens[12] = 0;
		__column_lens[13] = 32;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectStageProcessRecord b) {
		clear();
		setProjectStageProcessRecordIdClear(b.getProjectStageProcessRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectStageProcessRecordId() == null;
	}

	@Override
	public BaseProjectStageProcessRecord generateBase(){
		BaseProjectStageProcessRecord b = new BaseProjectStageProcessRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectStageProcessRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectStageProcessRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectAmountSum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setApplyAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCurrentApplyRate(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setProjectStageProcessRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectAmountSum(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setApplyAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileUrl(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeNo(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCurrentApplyRate(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectStageProcessRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectStageProcessRecordId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectAmountSum();
		buff[count++] = b.getApplyAmount();
		buff[count++] = b.getFileId();
		buff[count++] = b.getFileUrl();
		buff[count++] = b.getRemark();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getCurrentApplyRate();
	}

	@Override
	public void setDataFromBase(BaseProjectStageProcessRecord b){
		if(b.getProjectStageProcessRecordId() != null) setProjectStageProcessRecordIdClear(b.getProjectStageProcessRecordId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectAmountSum() != null) setProjectAmountSum(b.getProjectAmountSum());
		if(b.getApplyAmount() != null) setApplyAmount(b.getApplyAmount());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getFileUrl() != null) setFileUrl(b.getFileUrl());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCurrentApplyRate() != null) setCurrentApplyRate(b.getCurrentApplyRate());
	}

	public void setNullFromBase(BaseProjectStageProcessRecord b){
		if(b.getContractId() == null) setContractId(null);
		if(b.getMainProjectId() == null) setMainProjectId(null);
		if(b.getProjectName() == null) setProjectName(null);
		if(b.getProjectCode() == null) setProjectCode(null);
		if(b.getProjectAmountSum() == null) setProjectAmountSum(null);
		if(b.getApplyAmount() == null) setApplyAmount(null);
		if(b.getFileId() == null) setFileId(null);
		if(b.getFileUrl() == null) setFileUrl(null);
		if(b.getRemark() == null) setRemark(null);
		if(b.getEmployeeId() == null) setEmployeeId(null);
		if(b.getEmployeeNo() == null) setEmployeeNo(null);
		if(b.getCreateTime() == null) setCreateTime(null);
		if(b.getCurrentApplyRate() == null) setCurrentApplyRate(null);
	}

	@Override
	public void setFromBase(BaseProjectStageProcessRecord b){
		if(b.getProjectStageProcessRecordId() != null) setProjectStageProcessRecordIdClear(b.getProjectStageProcessRecordId());
		setContractId(b.getContractId());
		setMainProjectId(b.getMainProjectId());
		setProjectName(b.getProjectName());
		setProjectCode(b.getProjectCode());
		setProjectAmountSum(b.getProjectAmountSum());
		setApplyAmount(b.getApplyAmount());
		setFileId(b.getFileId());
		setFileUrl(b.getFileUrl());
		setRemark(b.getRemark());
		setEmployeeId(b.getEmployeeId());
		setEmployeeNo(b.getEmployeeNo());
		setCreateTime(b.getCreateTime());
		setCurrentApplyRate(b.getCurrentApplyRate());
	}

	@Override
	public BaseProjectStageProcessRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectStageProcessRecord b = new BaseProjectStageProcessRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectStageProcessRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageProcessRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmountSum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentApplyRate(GenericBase.__getDecimal(val));
	}

	public void setProjectStageProcessRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectStageProcessRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectStageProcessRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setProjectAmountSum(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getProjectAmountSum() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setApplyAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getApplyAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setFileUrl(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getFileUrl() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setCurrentApplyRate(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getCurrentApplyRate() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setConditionProjectStageProcessRecordId(String op, java.lang.Integer val) {
		addSingleCondition(0, op, val);
	}

	public void setConditionProjectStageProcessRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, new Object[] { val });
	}

	public void setSelectProjectStageProcessRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProjectStageProcessRecordIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		addSingleCondition(1, op, val);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, new Object[] { val });
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setContractIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		addSingleCondition(2, op, val);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, new Object[] { val });
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setMainProjectIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		addSingleCondition(3, op, val);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, new Object[] { val });
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setProjectNameExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		addSingleCondition(4, op, val);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, new Object[] { val });
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setProjectCodeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionProjectAmountSum(String op, java.math.BigDecimal val) {
		addSingleCondition(5, op, val);
	}

	public void setConditionProjectAmountSum(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, new Object[] { val });
	}

	public void setSelectProjectAmountSum(boolean val) {
		__select_flags[5] = val;
	}

	public void setProjectAmountSumExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionApplyAmount(String op, java.math.BigDecimal val) {
		addSingleCondition(6, op, val);
	}

	public void setConditionApplyAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, new Object[] { val });
	}

	public void setSelectApplyAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setApplyAmountExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		addSingleCondition(7, op, val);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, new Object[] { val });
	}

	public void setSelectFileId(boolean val) {
		__select_flags[7] = val;
	}

	public void setFileIdExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionFileUrl(String op, java.lang.String val) {
		addSingleCondition(8, op, val);
	}

	public void setConditionFileUrl(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, new Object[] { val });
	}

	public void setSelectFileUrl(boolean val) {
		__select_flags[8] = val;
	}

	public void setFileUrlExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		addSingleCondition(9, op, val);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, new Object[] { val });
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		addSingleCondition(10, op, val);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, new Object[] { val });
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		addSingleCondition(11, op, val);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, new Object[] { val });
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[11] = val;
	}

	public void setEmployeeNoExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		addSingleCondition(12, op, val);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, new Object[] { generateTimestampFromDate(val) });
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionCurrentApplyRate(String op, java.math.BigDecimal val) {
		addSingleCondition(13, op, val);
	}

	public void setConditionCurrentApplyRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, new Object[] { val });
	}

	public void setSelectCurrentApplyRate(boolean val) {
		__select_flags[13] = val;
	}

	public void setCurrentApplyRateExpression(String val) {
		__dataExpressions[13] = val;
	}


}

