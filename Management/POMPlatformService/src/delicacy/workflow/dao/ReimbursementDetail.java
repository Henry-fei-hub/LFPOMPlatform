package delicacy.workflow.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import delicacy.workflow.bean.BaseReimbursementDetail;

public class ReimbursementDetail extends AbstractTable<BaseReimbursementDetail>
{

	public ReimbursementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "reimbursement_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReimbursementDetail.CS_REIMBURSEMENT_DETAIL_ID;
		__column_names[1] = BaseReimbursementDetail.CS_REIMBURSEMENT_ID;
		__column_names[2] = BaseReimbursementDetail.CS_ITEM_ID;
		__column_names[3] = BaseReimbursementDetail.CS_AMOUNT;
		__column_names[4] = BaseReimbursementDetail.CS_HAPPEN_DATE;
		__column_names[5] = BaseReimbursementDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReimbursementDetail b) {
		clear();
		setReimbursementDetailIdClear(b.getReimbursementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getReimbursementDetailId() == null;
	}

	@Override
	public BaseReimbursementDetail generateBase(){
		BaseReimbursementDetail b = new BaseReimbursementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReimbursementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReimbursementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseReimbursementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReimbursementDetailId();
		buff[count++] = b.getReimbursementId();
		buff[count++] = b.getItemId();
		buff[count++] = b.getAmount();
		buff[count++] = generateTimestampFromDate(b.getHappenDate());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseReimbursementDetail b){
		if(b.getReimbursementDetailId() != null) setReimbursementDetailIdClear(b.getReimbursementDetailId());
		if(b.getReimbursementId() != null) setReimbursementId(b.getReimbursementId());
		if(b.getItemId() != null) setItemId(b.getItemId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getHappenDate() != null) setHappenDate(b.getHappenDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseReimbursementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReimbursementDetail b = new BaseReimbursementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReimbursementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setReimbursementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReimbursementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReimbursementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setItemId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getItemId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setHappenDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getHappenDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionReimbursementDetailId(String op, java.lang.Integer val) {
		setConditionReimbursementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReimbursementDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionReimbursementId(String op, java.lang.Integer val) {
		setConditionReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectReimbursementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionItemId(String op, java.lang.Integer val) {
		setConditionItemId(op, val, CONDITION_AND);
	}

	public void setConditionItemId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectItemId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionHappenDate(String op, java.util.Date val) {
		setConditionHappenDate(op, val, CONDITION_AND);
	}

	public void setConditionHappenDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHappenDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}


}

