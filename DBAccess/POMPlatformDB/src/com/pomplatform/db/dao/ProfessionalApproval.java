package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProfessionalApproval;


public class ProfessionalApproval extends AbstractTable<BaseProfessionalApproval>
{

	public ProfessionalApproval() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 28;

		initTables();

		__tableName            = "professional_approval";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProfessionalApproval.CS_PROFESSIONAL_APPROVAL__ID;
		__column_names[1] = BaseProfessionalApproval.CS_EMPLOYEE_ID;
		__column_names[2] = BaseProfessionalApproval.CS_EMPLOYEE_NO;
		__column_names[3] = BaseProfessionalApproval.CS_START_DATE;
		__column_names[4] = BaseProfessionalApproval.CS_DELETE_FLAG;
		__column_names[5] = BaseProfessionalApproval.CS_PROJECT_ID;
		__column_names[6] = BaseProfessionalApproval.CS_PROJECT_CODE;
		__column_names[7] = BaseProfessionalApproval.CS_PROJECT_NAME;
		__column_names[8] = BaseProfessionalApproval.CS_CONTRACT_ID;
		__column_names[9] = BaseProfessionalApproval.CS_CONTRACT_CODE;
		__column_names[10] = BaseProfessionalApproval.CS_CONTRACT_NAME;
		__column_names[11] = BaseProfessionalApproval.CS_PLATE_ID;
		__column_names[12] = BaseProfessionalApproval.CS_DESIGN_TYPE;
		__column_names[13] = BaseProfessionalApproval.CS_PROJECT_TYPE;
		__column_names[14] = BaseProfessionalApproval.CS_PLATE_MANAGER_ID;
		__column_names[15] = BaseProfessionalApproval.CS_PROJECT_LEVEL;
		__column_names[16] = BaseProfessionalApproval.CS_DEPARTMENT_MANAGER_ID;
		__column_names[17] = BaseProfessionalApproval.CS_PROJECT_MANAGE_ID;
		__column_names[18] = BaseProfessionalApproval.CS_PROJECT_MANAGE_NAME;
		__column_names[19] = BaseProfessionalApproval.CS_PROJECT_MANAGE_DEPARTMENT_ID;
		__column_names[20] = BaseProfessionalApproval.CS_COMMON_AREA;
		__column_names[21] = BaseProfessionalApproval.CS_LOGISTICS_AREA;
		__column_names[22] = BaseProfessionalApproval.CS_CAD_AREA;
		__column_names[23] = BaseProfessionalApproval.CS_TOTAL_INTEGRAL;
		__column_names[24] = BaseProfessionalApproval.CS_PROJECT_INTEGRAL;
		__column_names[25] = BaseProfessionalApproval.CS_RESERVE_INTEGRAL;
		__column_names[26] = BaseProfessionalApproval.CS_PERCENTAGE;
		__column_names[27] = BaseProfessionalApproval.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProfessionalApproval b) {
		clear();
		setProfessionalApproval_idClear(b.getProfessionalApproval_id());
	}

	public boolean isPrimaryKeyNull() {
		return getProfessionalApproval_id() == null;
	}

	@Override
	public BaseProfessionalApproval generateBase(){
		BaseProfessionalApproval b = new BaseProfessionalApproval();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProfessionalApproval b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProfessionalApproval_id(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectManageDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCadArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setProfessionalApproval_id(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setStartDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDeleteFlag(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateManagerId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectLevel(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentManagerId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectManageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectManageName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectManageDepartmentId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setCadArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReserveIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPercentage(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProfessionalApproval b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProfessionalApproval_id();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContractName();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDesignType();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getPlateManagerId();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getDepartmentManagerId();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getProjectManageName();
		buff[count++] = b.getProjectManageDepartmentId();
		buff[count++] = b.getCommonArea();
		buff[count++] = b.getLogisticsArea();
		buff[count++] = b.getCadArea();
		buff[count++] = b.getTotalIntegral();
		buff[count++] = b.getProjectIntegral();
		buff[count++] = b.getReserveIntegral();
		buff[count++] = b.getPercentage();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseProfessionalApproval b){
		if(b.getProfessionalApproval_id() != null) setProfessionalApproval_idClear(b.getProfessionalApproval_id());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDesignType() != null) setDesignType(b.getDesignType());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getPlateManagerId() != null) setPlateManagerId(b.getPlateManagerId());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getDepartmentManagerId() != null) setDepartmentManagerId(b.getDepartmentManagerId());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getProjectManageName() != null) setProjectManageName(b.getProjectManageName());
		if(b.getProjectManageDepartmentId() != null) setProjectManageDepartmentId(b.getProjectManageDepartmentId());
		if(b.getCommonArea() != null) setCommonArea(b.getCommonArea());
		if(b.getLogisticsArea() != null) setLogisticsArea(b.getLogisticsArea());
		if(b.getCadArea() != null) setCadArea(b.getCadArea());
		if(b.getTotalIntegral() != null) setTotalIntegral(b.getTotalIntegral());
		if(b.getProjectIntegral() != null) setProjectIntegral(b.getProjectIntegral());
		if(b.getReserveIntegral() != null) setReserveIntegral(b.getReserveIntegral());
		if(b.getPercentage() != null) setPercentage(b.getPercentage());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseProfessionalApproval generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProfessionalApproval b = new BaseProfessionalApproval();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProfessionalApproval __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalApproval_id(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setProfessionalApproval_id(Integer val) {
		setCurrentData(0, val);
	}

	public Integer getProfessionalApproval_id() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProfessionalApproval_idClear(Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(Integer val) {
		setCurrentData(1, val);
	}

	public Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeNo(String val) {
		setCurrentData(2, val);
	}

	public String getEmployeeNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setDeleteFlag(Integer val) {
		setCurrentData(4, val);
	}

	public Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProjectId(Integer val) {
		setCurrentData(5, val);
	}

	public Integer getProjectId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProjectCode(String val) {
		setCurrentData(6, val);
	}

	public String getProjectCode() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setProjectName(String val) {
		setCurrentData(7, val);
	}

	public String getProjectName() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setContractId(Integer val) {
		setCurrentData(8, val);
	}

	public Integer getContractId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setContractCode(String val) {
		setCurrentData(9, val);
	}

	public String getContractCode() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setContractName(String val) {
		setCurrentData(10, val);
	}

	public String getContractName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setPlateId(Integer val) {
		setCurrentData(11, val);
	}

	public Integer getPlateId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setDesignType(Integer val) {
		setCurrentData(12, val);
	}

	public Integer getDesignType() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setProjectType(Integer val) {
		setCurrentData(13, val);
	}

	public Integer getProjectType() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setPlateManagerId(Integer val) {
		setCurrentData(14, val);
	}

	public Integer getPlateManagerId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setProjectLevel(Integer val) {
		setCurrentData(15, val);
	}

	public Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setDepartmentManagerId(Integer val) {
		setCurrentData(16, val);
	}

	public Integer getDepartmentManagerId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setProjectManageId(Integer val) {
		setCurrentData(17, val);
	}

	public Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setProjectManageName(String val) {
		setCurrentData(18, val);
	}

	public String getProjectManageName() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setProjectManageDepartmentId(Integer val) {
		setCurrentData(19, val);
	}

	public Integer getProjectManageDepartmentId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setCommonArea(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getCommonArea() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setLogisticsArea(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getLogisticsArea() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setCadArea(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getCadArea() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(23, val);
	}

	public java.math.BigDecimal getTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[23]);
	}

	public void setProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(24, val);
	}

	public java.math.BigDecimal getProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[24]);
	}

	public void setReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(25, val);
	}

	public java.math.BigDecimal getReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[25]);
	}

	public void setPercentage(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getPercentage() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setStatus(Integer val) {
		setCurrentData(27, val);
	}

	public Integer getStatus() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setConditionProfessionalApproval_id(String op, Integer val) {
		setConditionProfessionalApproval_id(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalApproval_id(String op, Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProfessionalApproval_id(boolean val) {
		__select_flags[0] = val;
	}

	public void setProfessionalApproval_idExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionEmployeeId(String op, Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionEmployeeNo(String op, String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[2] = val;
	}

	public void setEmployeeNoExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setStartDateExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionDeleteFlag(String op, Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[4] = val;
	}

	public void setDeleteFlagExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionProjectId(String op, Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[5] = val;
	}

	public void setProjectIdExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionProjectCode(String op, String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[6] = val;
	}

	public void setProjectCodeExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionProjectName(String op, String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[7] = val;
	}

	public void setProjectNameExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionContractId(String op, Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[8] = val;
	}

	public void setContractIdExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionContractCode(String op, String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[9] = val;
	}

	public void setContractCodeExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionContractName(String op, String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[10] = val;
	}

	public void setContractNameExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionPlateId(String op, Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[11] = val;
	}

	public void setPlateIdExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionDesignType(String op, Integer val) {
		setConditionDesignType(op, val, CONDITION_AND);
	}

	public void setConditionDesignType(String op, Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDesignType(boolean val) {
		__select_flags[12] = val;
	}

	public void setDesignTypeExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionProjectType(String op, Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[13] = val;
	}

	public void setProjectTypeExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionPlateManagerId(String op, Integer val) {
		setConditionPlateManagerId(op, val, CONDITION_AND);
	}

	public void setConditionPlateManagerId(String op, Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectPlateManagerId(boolean val) {
		__select_flags[14] = val;
	}

	public void setPlateManagerIdExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionProjectLevel(String op, Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[15] = val;
	}

	public void setProjectLevelExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionDepartmentManagerId(String op, Integer val) {
		setConditionDepartmentManagerId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentManagerId(String op, Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectDepartmentManagerId(boolean val) {
		__select_flags[16] = val;
	}

	public void setDepartmentManagerIdExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionProjectManageId(String op, Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[17] = val;
	}

	public void setProjectManageIdExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionProjectManageName(String op, String val) {
		setConditionProjectManageName(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageName(String op, String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectProjectManageName(boolean val) {
		__select_flags[18] = val;
	}

	public void setProjectManageNameExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionProjectManageDepartmentId(String op, Integer val) {
		setConditionProjectManageDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageDepartmentId(String op, Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectProjectManageDepartmentId(boolean val) {
		__select_flags[19] = val;
	}

	public void setProjectManageDepartmentIdExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val) {
		setConditionCommonArea(op, val, CONDITION_AND);
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCommonArea(boolean val) {
		__select_flags[20] = val;
	}

	public void setCommonAreaExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val) {
		setConditionLogisticsArea(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectLogisticsArea(boolean val) {
		__select_flags[21] = val;
	}

	public void setLogisticsAreaExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionCadArea(String op, java.math.BigDecimal val) {
		setConditionCadArea(op, val, CONDITION_AND);
	}

	public void setConditionCadArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectCadArea(boolean val) {
		__select_flags[22] = val;
	}

	public void setCadAreaExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectTotalIntegral(boolean val) {
		__select_flags[23] = val;
	}

	public void setTotalIntegralExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectProjectIntegral(boolean val) {
		__select_flags[24] = val;
	}

	public void setProjectIntegralExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectReserveIntegral(boolean val) {
		__select_flags[25] = val;
	}

	public void setReserveIntegralExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val) {
		setConditionPercentage(op, val, CONDITION_AND);
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectPercentage(boolean val) {
		__select_flags[26] = val;
	}

	public void setPercentageExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionStatus(String op, Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[27] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[27] = val;
	}


}

