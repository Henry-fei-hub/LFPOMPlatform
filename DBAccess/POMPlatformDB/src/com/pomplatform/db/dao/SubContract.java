package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseSubContract;


public class SubContract extends AbstractTable<BaseSubContract>
{

	public SubContract() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 29;

		initTables();

		__tableName            = "sub_contracts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSubContract.CS_SUB_CONTRACT_ID;
		__column_names[1] = BaseSubContract.CS_PARENT_ID;
		__column_names[2] = BaseSubContract.CS_SUB_CONTRACT_CODE;
		__column_names[3] = BaseSubContract.CS_PROJECT_CODE;
		__column_names[4] = BaseSubContract.CS_BUSINESS_TYPE;
		__column_names[5] = BaseSubContract.CS_PROJECT_TYPE;
		__column_names[6] = BaseSubContract.CS_DEPARTMENT_ID;
		__column_names[7] = BaseSubContract.CS_COMMON_AREA;
		__column_names[8] = BaseSubContract.CS_LOGISTICS_AREA;
		__column_names[9] = BaseSubContract.CS_MONEY_SUM;
		__column_names[10] = BaseSubContract.CS_CREATE_TIME;
		__column_names[11] = BaseSubContract.CS_SUB_CONTRACT_NAME;
		__column_names[12] = BaseSubContract.CS_UPDATE_TIME;
		__column_names[13] = BaseSubContract.CS_DESIGN_AREA;
		__column_names[14] = BaseSubContract.CS_ORDER_NO;
		__column_names[15] = BaseSubContract.CS_SHEET_TOTAL_INTEGRAL;
		__column_names[16] = BaseSubContract.CS_COMPLAINT_INTEGRAL;
		__column_names[17] = BaseSubContract.CS_SHEET_INTEGRAL;
		__column_names[18] = BaseSubContract.CS_COMPLAINT_PERCENTAGE;
		__column_names[19] = BaseSubContract.CS_AGREE_DATE;
		__column_names[20] = BaseSubContract.CS_INFO_CODE;
		__column_names[21] = BaseSubContract.CS_BUSINESS_STATE_RECORD_ID;
		__column_names[22] = BaseSubContract.CS_REMARK;
		__column_names[23] = BaseSubContract.CS_PROJECT_MANAGE_ID;
		__column_names[24] = BaseSubContract.CS_IS_HISTORY;
		__column_names[25] = BaseSubContract.CS_IS_AUTO;
		__column_names[26] = BaseSubContract.CS_RESERVE_SHEET_ID;
		__column_names[27] = BaseSubContract.CS_BUSINESS_LINE;
		__column_names[28] = BaseSubContract.CS_PERCENTAGE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSubContract b) {
		clear();
		setSubContractIdClear(b.getSubContractId());
	}

	public boolean isPrimaryKeyNull() {
		return getSubContractId() == null;
	}

	@Override
	public BaseSubContract generateBase(){
		BaseSubContract b = new BaseSubContract();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSubContract b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSubContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSubContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSheetIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAgreeDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessStateRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsHistory(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsAuto(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setReserveSheetId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessLine(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercentage(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setSubContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSubContractCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCommonArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLogisticsArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMoneySum(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSubContractName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUpdateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOrderNo(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSheetTotalIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setComplaintIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSheetIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setComplaintPercentage(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAgreeDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInfoCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessStateRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectManageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsHistory(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsAuto(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReserveSheetId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessLine(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPercentage(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseSubContract b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSubContractId();
		buff[count++] = b.getParentId();
		buff[count++] = b.getSubContractCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCommonArea();
		buff[count++] = b.getLogisticsArea();
		buff[count++] = b.getMoneySum();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getSubContractName();
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getDesignArea();
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getSheetTotalIntegral();
		buff[count++] = b.getComplaintIntegral();
		buff[count++] = b.getSheetIntegral();
		buff[count++] = b.getComplaintPercentage();
		buff[count++] = generateTimestampFromDate(b.getAgreeDate());
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getBusinessStateRecordId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getIsHistory();
		buff[count++] = b.getIsAuto();
		buff[count++] = b.getReserveSheetId();
		buff[count++] = b.getBusinessLine();
		buff[count++] = b.getPercentage();
	}

	@Override
	public void setDataFromBase(BaseSubContract b){
		if(b.getSubContractId() != null) setSubContractIdClear(b.getSubContractId());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getSubContractCode() != null) setSubContractCode(b.getSubContractCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCommonArea() != null) setCommonArea(b.getCommonArea());
		if(b.getLogisticsArea() != null) setLogisticsArea(b.getLogisticsArea());
		if(b.getMoneySum() != null) setMoneySum(b.getMoneySum());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getSubContractName() != null) setSubContractName(b.getSubContractName());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getDesignArea() != null) setDesignArea(b.getDesignArea());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getSheetTotalIntegral() != null) setSheetTotalIntegral(b.getSheetTotalIntegral());
		if(b.getComplaintIntegral() != null) setComplaintIntegral(b.getComplaintIntegral());
		if(b.getSheetIntegral() != null) setSheetIntegral(b.getSheetIntegral());
		if(b.getComplaintPercentage() != null) setComplaintPercentage(b.getComplaintPercentage());
		if(b.getAgreeDate() != null) setAgreeDate(b.getAgreeDate());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getBusinessStateRecordId() != null) setBusinessStateRecordId(b.getBusinessStateRecordId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getIsHistory() != null) setIsHistory(b.getIsHistory());
		if(b.getIsAuto() != null) setIsAuto(b.getIsAuto());
		if(b.getReserveSheetId() != null) setReserveSheetId(b.getReserveSheetId());
		if(b.getBusinessLine() != null) setBusinessLine(b.getBusinessLine());
		if(b.getPercentage() != null) setPercentage(b.getPercentage());
	}

	@Override
	public BaseSubContract generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSubContract b = new BaseSubContract();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSubContract __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgreeDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessStateRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHistory(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsAuto(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveSheetId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercentage(GenericBase.__getDecimal(val));
	}

	public void setSubContractId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSubContractId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSubContractIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSubContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSubContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCommonArea(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getCommonArea() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setLogisticsArea(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getLogisticsArea() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setSubContractName(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSubContractName() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setSheetTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setComplaintIntegral(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setSheetIntegral(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getSheetIntegral() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setComplaintPercentage(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setAgreeDate(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getAgreeDate() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setBusinessStateRecordId(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getBusinessStateRecordId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setIsHistory(java.lang.Boolean val) {
		setCurrentData(24, val);
	}

	public java.lang.Boolean getIsHistory() {
		return GenericBase.__getBoolean(__current_data[24]);
	}

	public void setIsAuto(java.lang.Boolean val) {
		setCurrentData(25, val);
	}

	public java.lang.Boolean getIsAuto() {
		return GenericBase.__getBoolean(__current_data[25]);
	}

	public void setReserveSheetId(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getReserveSheetId() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setBusinessLine(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getBusinessLine() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setPercentage(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getPercentage() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setConditionSubContractId(String op, java.lang.Integer val) {
		setConditionSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSubContractId(boolean val) {
		__select_flags[0] = val;
	}

	public void setSubContractIdExpression(String val) {
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

	public void setConditionSubContractCode(String op, java.lang.String val) {
		setConditionSubContractCode(op, val, CONDITION_AND);
	}

	public void setConditionSubContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSubContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setSubContractCodeExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setProjectCodeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[4] = val;
	}

	public void setBusinessTypeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[5] = val;
	}

	public void setProjectTypeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setDepartmentIdExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val) {
		setConditionCommonArea(op, val, CONDITION_AND);
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCommonArea(boolean val) {
		__select_flags[7] = val;
	}

	public void setCommonAreaExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val) {
		setConditionLogisticsArea(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLogisticsArea(boolean val) {
		__select_flags[8] = val;
	}

	public void setLogisticsAreaExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
		__select_flags[9] = val;
	}

	public void setMoneySumExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionSubContractName(String op, java.lang.String val) {
		setConditionSubContractName(op, val, CONDITION_AND);
	}

	public void setConditionSubContractName(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSubContractName(boolean val) {
		__select_flags[11] = val;
	}

	public void setSubContractNameExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setUpdateTimeExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[13] = val;
	}

	public void setDesignAreaExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[14] = val;
	}

	public void setOrderNoExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionSheetTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionSheetTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSheetTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectSheetTotalIntegral(boolean val) {
		__select_flags[15] = val;
	}

	public void setSheetTotalIntegralExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val) {
		setConditionComplaintIntegral(op, val, CONDITION_AND);
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectComplaintIntegral(boolean val) {
		__select_flags[16] = val;
	}

	public void setComplaintIntegralExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionSheetIntegral(String op, java.math.BigDecimal val) {
		setConditionSheetIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSheetIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectSheetIntegral(boolean val) {
		__select_flags[17] = val;
	}

	public void setSheetIntegralExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val) {
		setConditionComplaintPercentage(op, val, CONDITION_AND);
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectComplaintPercentage(boolean val) {
		__select_flags[18] = val;
	}

	public void setComplaintPercentageExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionAgreeDate(String op, java.util.Date val) {
		setConditionAgreeDate(op, val, CONDITION_AND);
	}

	public void setConditionAgreeDate(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAgreeDate(boolean val) {
		__select_flags[19] = val;
	}

	public void setAgreeDateExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[20] = val;
	}

	public void setInfoCodeExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionBusinessStateRecordId(String op, java.lang.Integer val) {
		setConditionBusinessStateRecordId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessStateRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectBusinessStateRecordId(boolean val) {
		__select_flags[21] = val;
	}

	public void setBusinessStateRecordIdExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[22] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[23] = val;
	}

	public void setProjectManageIdExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionIsHistory(String op, java.lang.Boolean val) {
		setConditionIsHistory(op, val, CONDITION_AND);
	}

	public void setConditionIsHistory(String op, java.lang.Boolean val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectIsHistory(boolean val) {
		__select_flags[24] = val;
	}

	public void setIsHistoryExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionIsAuto(String op, java.lang.Boolean val) {
		setConditionIsAuto(op, val, CONDITION_AND);
	}

	public void setConditionIsAuto(String op, java.lang.Boolean val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectIsAuto(boolean val) {
		__select_flags[25] = val;
	}

	public void setIsAutoExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionReserveSheetId(String op, java.lang.Integer val) {
		setConditionReserveSheetId(op, val, CONDITION_AND);
	}

	public void setConditionReserveSheetId(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectReserveSheetId(boolean val) {
		__select_flags[26] = val;
	}

	public void setReserveSheetIdExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionBusinessLine(String op, java.lang.Integer val) {
		setConditionBusinessLine(op, val, CONDITION_AND);
	}

	public void setConditionBusinessLine(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectBusinessLine(boolean val) {
		__select_flags[27] = val;
	}

	public void setBusinessLineExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val) {
		setConditionPercentage(op, val, CONDITION_AND);
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectPercentage(boolean val) {
		__select_flags[28] = val;
	}

	public void setPercentageExpression(String val) {
		__dataExpressions[28] = val;
	}


}

