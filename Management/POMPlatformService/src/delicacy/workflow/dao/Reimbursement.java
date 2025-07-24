package delicacy.workflow.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import delicacy.workflow.bean.BaseReimbursement;


public class Reimbursement extends AbstractTable<BaseReimbursement>
{

	public Reimbursement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "reimbursements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReimbursement.CS_REIMBURSEMENT_ID;
		__column_names[1] = BaseReimbursement.CS_EMPLOYEE_ID;
		__column_names[2] = BaseReimbursement.CS_APPLICATION_DATE;
		__column_names[3] = BaseReimbursement.CS_REIMBURSEMENT_TYPE;
		__column_names[4] = BaseReimbursement.CS_STATUS;
		__column_names[5] = BaseReimbursement.CS_AMOUNT;
		__column_names[6] = BaseReimbursement.CS_COMPLETE_DATE;
		__column_names[7] = BaseReimbursement.CS_PROCESS_INSTANCE_ID;
		__column_names[8] = BaseReimbursement.CS_SUBJECT;
		__column_names[9] = BaseReimbursement.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReimbursement b) {
		clear();
		setReimbursementIdClear(b.getReimbursementId());
	}

	public boolean isPrimaryKeyNull() {
		return getReimbursementId() == null;
	}

	@Override
	public BaseReimbursement generateBase(){
		BaseReimbursement b = new BaseReimbursement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReimbursement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplicationDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setReimbursementType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompleteDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubject(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseReimbursement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReimbursementId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getApplicationDate());
		buff[count++] = b.getReimbursementType();
		buff[count++] = b.getStatus();
		buff[count++] = b.getAmount();
		buff[count++] = generateTimestampFromDate(b.getCompleteDate());
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getSubject();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseReimbursement b){
		if(b.getReimbursementId() != null) setReimbursementIdClear(b.getReimbursementId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getApplicationDate() != null) setApplicationDate(b.getApplicationDate());
		if(b.getReimbursementType() != null) setReimbursementType(b.getReimbursementType());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getCompleteDate() != null) setCompleteDate(b.getCompleteDate());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getSubject() != null) setSubject(b.getSubject());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseReimbursement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReimbursement b = new BaseReimbursement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReimbursement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicationDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompleteDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubject(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setReimbursementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReimbursementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReimbursementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setApplicationDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getApplicationDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setReimbursementType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getReimbursementType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setCompleteDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCompleteDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setSubject(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSubject() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionReimbursementId(String op, java.lang.Integer val) {
		setConditionReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReimbursementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionApplicationDate(String op, java.util.Date val) {
		setConditionApplicationDate(op, val, CONDITION_AND);
	}

	public void setConditionApplicationDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectApplicationDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionReimbursementType(String op, java.lang.Integer val) {
		setConditionReimbursementType(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectReimbursementType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCompleteDate(String op, java.util.Date val) {
		setConditionCompleteDate(op, val, CONDITION_AND);
	}

	public void setConditionCompleteDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompleteDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSubject(String op, java.lang.String val) {
		setConditionSubject(op, val, CONDITION_AND);
	}

	public void setConditionSubject(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSubject(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

