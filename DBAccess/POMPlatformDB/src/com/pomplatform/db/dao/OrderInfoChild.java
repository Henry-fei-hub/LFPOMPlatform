package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOrderInfoChild;
import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;


public class OrderInfoChild extends AbstractTable<BaseOrderInfoChild>
{

	public OrderInfoChild() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 31;

		initTables();

		__tableName            = "order_info_child";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOrderInfoChild.CS_ORDER_INFO_CHILD_ID;
		__column_names[1] = BaseOrderInfoChild.CS_SUB_CONTRACT_ID;
		__column_names[2] = BaseOrderInfoChild.CS_PARENT_ID;
		__column_names[3] = BaseOrderInfoChild.CS_SUB_CONTRACT_CODE;
		__column_names[4] = BaseOrderInfoChild.CS_PROJECT_CODE;
		__column_names[5] = BaseOrderInfoChild.CS_BUSINESS_TYPE;
		__column_names[6] = BaseOrderInfoChild.CS_PROJECT_TYPE;
		__column_names[7] = BaseOrderInfoChild.CS_DEPARTMENT_ID;
		__column_names[8] = BaseOrderInfoChild.CS_COMMON_AREA;
		__column_names[9] = BaseOrderInfoChild.CS_LOGISTICS_AREA;
		__column_names[10] = BaseOrderInfoChild.CS_MONEY_SUM;
		__column_names[11] = BaseOrderInfoChild.CS_CREATE_TIME;
		__column_names[12] = BaseOrderInfoChild.CS_SUB_CONTRACT_NAME;
		__column_names[13] = BaseOrderInfoChild.CS_UPDATE_TIME;
		__column_names[14] = BaseOrderInfoChild.CS_PROJECT_ID;
		__column_names[15] = BaseOrderInfoChild.CS_SHEET_TOTAL_INTEGRAL;
		__column_names[16] = BaseOrderInfoChild.CS_DESIGN_AREA;
		__column_names[17] = BaseOrderInfoChild.CS_COMPLAINT_PERCENTAGE;
		__column_names[18] = BaseOrderInfoChild.CS_COMPLAINT_INTEGRAL;
		__column_names[19] = BaseOrderInfoChild.CS_SHEET_INTEGRAL;
		__column_names[20] = BaseOrderInfoChild.CS_PERCENTAGE;
		__column_names[21] = BaseOrderInfoChild.CS_ORDER_INFO_ID;
		__column_names[22] = BaseOrderInfoChild.CS_PROJECT_MANAGE_ID;
		__column_names[23] = BaseOrderInfoChild.CS_IS_HISTORY;
		__column_names[24] = BaseOrderInfoChild.CS_BUSINESS_STATE_RECORD_ID;
		__column_names[25] = BaseOrderInfoChild.CS_RESERVE_SHEET_ID;
		__column_names[26] = BaseOrderInfoChild.CS_BUSINESS_LINE;
		__column_names[27] = BaseOrderInfoChild.CS_IS_AUTO;
		__column_names[28] = BaseOrderInfoChild.CS_ORDER_NO;
		__column_names[29] = BaseOrderInfoChild.CS_AGREE_DATE;
		__column_names[30] = BaseOrderInfoChild.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOrderInfoChild b) {
		clear();
		setOrderInfoChildIdClear(b.getOrderInfoChildId());
	}

	public boolean isPrimaryKeyNull() {
		return getOrderInfoChildId() == null;
	}

	@Override
	public BaseOrderInfoChild generateBase(){
		BaseOrderInfoChild b = new BaseOrderInfoChild();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOrderInfoChild b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOrderInfoChildId(GenericBase.__getInt(val));
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
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSheetIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOrderInfoId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsHistory(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBusinessStateRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReserveSheetId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessLine(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsAuto(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAgreeDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setOrderInfoChildId(GenericBase.__getInt(val));
		}
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
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSheetTotalIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setComplaintPercentage(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setPercentage(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOrderInfoId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setBusinessStateRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReserveSheetId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessLine(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsAuto(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOrderNo(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAgreeDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseOrderInfoChild b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOrderInfoChildId();
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
		buff[count++] = b.getProjectId();
		buff[count++] = b.getSheetTotalIntegral();
		buff[count++] = b.getDesignArea();
		buff[count++] = b.getComplaintPercentage();
		buff[count++] = b.getComplaintIntegral();
		buff[count++] = b.getSheetIntegral();
		buff[count++] = b.getPercentage();
		buff[count++] = b.getOrderInfoId();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getIsHistory();
		buff[count++] = b.getBusinessStateRecordId();
		buff[count++] = b.getReserveSheetId();
		buff[count++] = b.getBusinessLine();
		buff[count++] = b.getIsAuto();
		buff[count++] = b.getOrderNo();
		buff[count++] = generateTimestampFromDate(b.getAgreeDate());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseOrderInfoChild b){
		if(b.getOrderInfoChildId() != null) setOrderInfoChildIdClear(b.getOrderInfoChildId());
		if(b.getSubContractId() != null) setSubContractId(b.getSubContractId());
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
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getSheetTotalIntegral() != null) setSheetTotalIntegral(b.getSheetTotalIntegral());
		if(b.getDesignArea() != null) setDesignArea(b.getDesignArea());
		if(b.getComplaintPercentage() != null) setComplaintPercentage(b.getComplaintPercentage());
		if(b.getComplaintIntegral() != null) setComplaintIntegral(b.getComplaintIntegral());
		if(b.getSheetIntegral() != null) setSheetIntegral(b.getSheetIntegral());
		if(b.getPercentage() != null) setPercentage(b.getPercentage());
		if(b.getOrderInfoId() != null) setOrderInfoId(b.getOrderInfoId());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getIsHistory() != null) setIsHistory(b.getIsHistory());
		if(b.getBusinessStateRecordId() != null) setBusinessStateRecordId(b.getBusinessStateRecordId());
		if(b.getReserveSheetId() != null) setReserveSheetId(b.getReserveSheetId());
		if(b.getBusinessLine() != null) setBusinessLine(b.getBusinessLine());
		if(b.getIsAuto() != null) setIsAuto(b.getIsAuto());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getAgreeDate() != null) setAgreeDate(b.getAgreeDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseOrderInfoChild generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOrderInfoChild b = new BaseOrderInfoChild();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOrderInfoChild __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderInfoChildId(GenericBase.__getInt(val));
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
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderInfoId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHistory(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessStateRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveSheetId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessLine(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsAuto(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgreeDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setOrderInfoChildId(Integer val) {
		setCurrentData(0, val);
	}

	public Integer getOrderInfoChildId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOrderInfoChildIdClear(Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSubContractId(Integer val) {
		setCurrentData(1, val);
	}

	public Integer getSubContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setParentId(Integer val) {
		setCurrentData(2, val);
	}

	public Integer getParentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSubContractCode(String val) {
		setCurrentData(3, val);
	}

	public String getSubContractCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectCode(String val) {
		setCurrentData(4, val);
	}

	public String getProjectCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setBusinessType(Integer val) {
		setCurrentData(5, val);
	}

	public Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProjectType(Integer val) {
		setCurrentData(6, val);
	}

	public Integer getProjectType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDepartmentId(Integer val) {
		setCurrentData(7, val);
	}

	public Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCommonArea(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getCommonArea() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setLogisticsArea(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getLogisticsArea() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setSubContractName(String val) {
		setCurrentData(12, val);
	}

	public String getSubContractName() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setProjectId(Integer val) {
		setCurrentData(14, val);
	}

	public Integer getProjectId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setSheetTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setComplaintPercentage(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setComplaintIntegral(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setSheetIntegral(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getSheetIntegral() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setPercentage(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getPercentage() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setOrderInfoId(Integer val) {
		setCurrentData(21, val);
	}

	public Integer getOrderInfoId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setProjectManageId(Integer val) {
		setCurrentData(22, val);
	}

	public Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setIsHistory(Boolean val) {
		setCurrentData(23, val);
	}

	public Boolean getIsHistory() {
		return GenericBase.__getBoolean(__current_data[23]);
	}

	public void setBusinessStateRecordId(Integer val) {
		setCurrentData(24, val);
	}

	public Integer getBusinessStateRecordId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setReserveSheetId(Integer val) {
		setCurrentData(25, val);
	}

	public Integer getReserveSheetId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setBusinessLine(String val) {
		setCurrentData(26, val);
	}

	public String getBusinessLine() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setIsAuto(Boolean val) {
		setCurrentData(27, val);
	}

	public Boolean getIsAuto() {
		return GenericBase.__getBoolean(__current_data[27]);
	}

	public void setOrderNo(Integer val) {
		setCurrentData(28, val);
	}

	public Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setAgreeDate(java.util.Date val) {
		setCurrentData(29, generateTimestampFromDate(val));
	}

	public java.util.Date getAgreeDate() {
		return GenericBase.__getDateFromSQL(__current_data[29]);
	}

	public void setRemark(String val) {
		setCurrentData(30, val);
	}

	public String getRemark() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setConditionOrderInfoChildId(String op, Integer val) {
		setConditionOrderInfoChildId(op, val, CONDITION_AND);
	}

	public void setConditionOrderInfoChildId(String op, Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOrderInfoChildId(boolean val) {
		__select_flags[0] = val;
	}

	public void setOrderInfoChildIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionSubContractId(String op, Integer val) {
		setConditionSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractId(String op, Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSubContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setSubContractIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionParentId(String op, Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setParentIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionSubContractCode(String op, String val) {
		setConditionSubContractCode(op, val, CONDITION_AND);
	}

	public void setConditionSubContractCode(String op, String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSubContractCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setSubContractCodeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionProjectCode(String op, String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setProjectCodeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionBusinessType(String op, Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[5] = val;
	}

	public void setBusinessTypeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionProjectType(String op, Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[6] = val;
	}

	public void setProjectTypeExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionDepartmentId(String op, Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[7] = val;
	}

	public void setDepartmentIdExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val) {
		setConditionCommonArea(op, val, CONDITION_AND);
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCommonArea(boolean val) {
		__select_flags[8] = val;
	}

	public void setCommonAreaExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val) {
		setConditionLogisticsArea(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectLogisticsArea(boolean val) {
		__select_flags[9] = val;
	}

	public void setLogisticsAreaExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
		__select_flags[10] = val;
	}

	public void setMoneySumExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionSubContractName(String op, String val) {
		setConditionSubContractName(op, val, CONDITION_AND);
	}

	public void setConditionSubContractName(String op, String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSubContractName(boolean val) {
		__select_flags[12] = val;
	}

	public void setSubContractNameExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setUpdateTimeExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionProjectId(String op, Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[14] = val;
	}

	public void setProjectIdExpression(String val) {
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

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[16] = val;
	}

	public void setDesignAreaExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val) {
		setConditionComplaintPercentage(op, val, CONDITION_AND);
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectComplaintPercentage(boolean val) {
		__select_flags[17] = val;
	}

	public void setComplaintPercentageExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val) {
		setConditionComplaintIntegral(op, val, CONDITION_AND);
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectComplaintIntegral(boolean val) {
		__select_flags[18] = val;
	}

	public void setComplaintIntegralExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionSheetIntegral(String op, java.math.BigDecimal val) {
		setConditionSheetIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSheetIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectSheetIntegral(boolean val) {
		__select_flags[19] = val;
	}

	public void setSheetIntegralExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val) {
		setConditionPercentage(op, val, CONDITION_AND);
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectPercentage(boolean val) {
		__select_flags[20] = val;
	}

	public void setPercentageExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionOrderInfoId(String op, Integer val) {
		setConditionOrderInfoId(op, val, CONDITION_AND);
	}

	public void setConditionOrderInfoId(String op, Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectOrderInfoId(boolean val) {
		__select_flags[21] = val;
	}

	public void setOrderInfoIdExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionProjectManageId(String op, Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[22] = val;
	}

	public void setProjectManageIdExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionIsHistory(String op, Boolean val) {
		setConditionIsHistory(op, val, CONDITION_AND);
	}

	public void setConditionIsHistory(String op, Boolean val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectIsHistory(boolean val) {
		__select_flags[23] = val;
	}

	public void setIsHistoryExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionBusinessStateRecordId(String op, Integer val) {
		setConditionBusinessStateRecordId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessStateRecordId(String op, Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectBusinessStateRecordId(boolean val) {
		__select_flags[24] = val;
	}

	public void setBusinessStateRecordIdExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionReserveSheetId(String op, Integer val) {
		setConditionReserveSheetId(op, val, CONDITION_AND);
	}

	public void setConditionReserveSheetId(String op, Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectReserveSheetId(boolean val) {
		__select_flags[25] = val;
	}

	public void setReserveSheetIdExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionBusinessLine(String op, String val) {
		setConditionBusinessLine(op, val, CONDITION_AND);
	}

	public void setConditionBusinessLine(String op, String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectBusinessLine(boolean val) {
		__select_flags[26] = val;
	}

	public void setBusinessLineExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionIsAuto(String op, Boolean val) {
		setConditionIsAuto(op, val, CONDITION_AND);
	}

	public void setConditionIsAuto(String op, Boolean val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectIsAuto(boolean val) {
		__select_flags[27] = val;
	}

	public void setIsAutoExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionOrderNo(String op, Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[28] = val;
	}

	public void setOrderNoExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionAgreeDate(String op, java.util.Date val) {
		setConditionAgreeDate(op, val, CONDITION_AND);
	}

	public void setConditionAgreeDate(String op, java.util.Date val, String relation) {
		addCondition(29, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAgreeDate(boolean val) {
		__select_flags[29] = val;
	}

	public void setAgreeDateExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionRemark(String op, String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[30] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[30] = val;
	}


}

