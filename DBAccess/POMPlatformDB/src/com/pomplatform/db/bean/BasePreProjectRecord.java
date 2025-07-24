package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePreProjectRecord extends GenericBase implements BaseFactory<BasePreProjectRecord>, Comparable<BasePreProjectRecord> 
{


	public static BasePreProjectRecord newInstance(){
		return new BasePreProjectRecord();
	}

	@Override
	public BasePreProjectRecord make(){
		BasePreProjectRecord b = new BasePreProjectRecord();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_RECORD_ID = "pre_project_record_id" ;
	public final static java.lang.String CS_RELEVANT_EMPLOYEES = "relevant_employees" ;
	public final static java.lang.String CS_TRACK_DATE = "track_date" ;
	public final static java.lang.String CS_INFORMATION_TYPE = "information_type" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_REGISTER_EMPLOYEE = "register_employee" ;
	public final static java.lang.String CS_REGISTER_DATE = "register_date" ;
	public final static java.lang.String CS_TRACK_CODE = "track_code" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_RELEVANT_EMPLOYEES_DISPLAY_VALUE = "relevant_employees_display_value" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_WIN_RATE = "win_rate" ;
	public final static java.lang.String CS_CONTRACT_SIGN_STATUS = "contract_sign_status" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_DESIGN_PRICE = "design_price" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,相关人员,跟踪时间,信息类型（1项目信息  2合同信息）,情况描述,附件,登记人,登记时间,跟踪编号,项目id,附件名称,相关人员名字,前期项目id,赢率,合同状态,预估合同金额,设计报价,附件编码";

	public java.lang.Integer getPreProjectRecordId() {
		return this.__pre_project_record_id;
	}

	public void setPreProjectRecordId( java.lang.Integer value ) {
		this.__pre_project_record_id = value;
	}

	public java.lang.String getRelevantEmployees() {
		return this.__relevant_employees;
	}

	public void setRelevantEmployees( java.lang.String value ) {
		this.__relevant_employees = value;
	}

	public java.util.Date getTrackDate() {
		return this.__track_date;
	}

	public void setTrackDate( java.util.Date value ) {
		this.__track_date = value;
	}

	public java.lang.Integer getInformationType() {
		return this.__information_type;
	}

	public void setInformationType( java.lang.Integer value ) {
		this.__information_type = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.Integer getRegisterEmployee() {
		return this.__register_employee;
	}

	public void setRegisterEmployee( java.lang.Integer value ) {
		this.__register_employee = value;
	}

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}

	public java.lang.String getTrackCode() {
		return this.__track_code;
	}

	public void setTrackCode( java.lang.String value ) {
		this.__track_code = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getFileName() {
		return this.__file_name;
	}

	public void setFileName( java.lang.String value ) {
		this.__file_name = value;
	}

	public java.lang.String getRelevantEmployeesDisplayValue() {
		return this.__relevant_employees_display_value;
	}

	public void setRelevantEmployeesDisplayValue( java.lang.String value ) {
		this.__relevant_employees_display_value = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getWinRate() {
		return this.__win_rate;
	}

	public void setWinRate( java.lang.String value ) {
		this.__win_rate = value;
	}

	public java.lang.Integer getContractSignStatus() {
		return this.__contract_sign_status;
	}

	public void setContractSignStatus( java.lang.Integer value ) {
		this.__contract_sign_status = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.String getDesignPrice() {
		return this.__design_price;
	}

	public void setDesignPrice( java.lang.String value ) {
		this.__design_price = value;
	}

	public java.lang.Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( java.lang.Integer value ) {
		this.__attachment_id = value;
	}

	public void cloneCopy(BasePreProjectRecord __bean){
		__bean.setPreProjectRecordId(getPreProjectRecordId());
		__bean.setRelevantEmployees(getRelevantEmployees());
		__bean.setTrackDate(getTrackDate());
		__bean.setInformationType(getInformationType());
		__bean.setRemark(getRemark());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setRegisterEmployee(getRegisterEmployee());
		__bean.setRegisterDate(getRegisterDate());
		__bean.setTrackCode(getTrackCode());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setFileName(getFileName());
		__bean.setRelevantEmployeesDisplayValue(getRelevantEmployeesDisplayValue());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setWinRate(getWinRate());
		__bean.setContractSignStatus(getContractSignStatus());
		__bean.setContractAmount(getContractAmount());
		__bean.setDesignPrice(getDesignPrice());
		__bean.setAttachmentId(getAttachmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectRecordId() == null ? "" : getPreProjectRecordId());
		sb.append(",");
		sb.append(getRelevantEmployees() == null ? "" : getRelevantEmployees());
		sb.append(",");
		sb.append(getTrackDate() == null ? "" : sdf.format(getTrackDate()));
		sb.append(",");
		sb.append(getInformationType() == null ? "" : getInformationType());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getRegisterEmployee() == null ? "" : getRegisterEmployee());
		sb.append(",");
		sb.append(getRegisterDate() == null ? "" : sdf.format(getRegisterDate()));
		sb.append(",");
		sb.append(getTrackCode() == null ? "" : getTrackCode());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		sb.append(",");
		sb.append(getRelevantEmployeesDisplayValue() == null ? "" : getRelevantEmployeesDisplayValue());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getWinRate() == null ? "" : getWinRate());
		sb.append(",");
		sb.append(getContractSignStatus() == null ? "" : getContractSignStatus());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getDesignPrice() == null ? "" : getDesignPrice());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePreProjectRecord o) {
		return __pre_project_record_id == null ? -1 : __pre_project_record_id.compareTo(o.getPreProjectRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_record_id);
		hash = 97 * hash + Objects.hashCode(this.__relevant_employees);
		hash = 97 * hash + Objects.hashCode(this.__track_date);
		hash = 97 * hash + Objects.hashCode(this.__information_type);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__register_employee);
		hash = 97 * hash + Objects.hashCode(this.__register_date);
		hash = 97 * hash + Objects.hashCode(this.__track_code);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__relevant_employees_display_value);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__win_rate);
		hash = 97 * hash + Objects.hashCode(this.__contract_sign_status);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__design_price);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePreProjectRecord o = (BasePreProjectRecord)obj;
		if(!Objects.equals(this.__pre_project_record_id, o.getPreProjectRecordId())) return false;
		if(!Objects.equals(this.__relevant_employees, o.getRelevantEmployees())) return false;
		if(!Objects.equals(this.__track_date, o.getTrackDate())) return false;
		if(!Objects.equals(this.__information_type, o.getInformationType())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__register_employee, o.getRegisterEmployee())) return false;
		if(!Objects.equals(this.__register_date, o.getRegisterDate())) return false;
		if(!Objects.equals(this.__track_code, o.getTrackCode())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__relevant_employees_display_value, o.getRelevantEmployeesDisplayValue())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__win_rate, o.getWinRate())) return false;
		if(!Objects.equals(this.__contract_sign_status, o.getContractSignStatus())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__design_price, o.getDesignPrice())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectRecordId() != null) sb.append(__wrapNumber(count++, "preProjectRecordId", getPreProjectRecordId()));
		if(getRelevantEmployees() != null) sb.append(__wrapString(count++, "relevantEmployees", getRelevantEmployees()));
		if(getTrackDate() != null) sb.append(__wrapDate(count++, "trackDate", getTrackDate()));
		if(getInformationType() != null) sb.append(__wrapNumber(count++, "informationType", getInformationType()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getRegisterEmployee() != null) sb.append(__wrapNumber(count++, "registerEmployee", getRegisterEmployee()));
		if(getRegisterDate() != null) sb.append(__wrapDate(count++, "registerDate", getRegisterDate()));
		if(getTrackCode() != null) sb.append(__wrapString(count++, "trackCode", getTrackCode()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getRelevantEmployeesDisplayValue() != null) sb.append(__wrapString(count++, "relevantEmployeesDisplayValue", getRelevantEmployeesDisplayValue()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getWinRate() != null) sb.append(__wrapString(count++, "winRate", getWinRate()));
		if(getContractSignStatus() != null) sb.append(__wrapNumber(count++, "contractSignStatus", getContractSignStatus()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getDesignPrice() != null) sb.append(__wrapString(count++, "designPrice", getDesignPrice()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectRecordId")) != null) setPreProjectRecordId(__getInt(val)); 
		if((val = values.get("relevantEmployees")) != null) setRelevantEmployees(__getString(val));
		if((val = values.get("trackDate")) != null) setTrackDate(__getDate(val)); 
		if((val = values.get("informationType")) != null) setInformationType(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("registerEmployee")) != null) setRegisterEmployee(__getInt(val)); 
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val)); 
		if((val = values.get("trackCode")) != null) setTrackCode(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("relevantEmployeesDisplayValue")) != null) setRelevantEmployeesDisplayValue(__getString(val));
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("winRate")) != null) setWinRate(__getString(val));
		if((val = values.get("contractSignStatus")) != null) setContractSignStatus(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("designPrice")) != null) setDesignPrice(__getString(val));
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
	}

	protected java.lang.Integer  __pre_project_record_id ;
	protected java.lang.String  __relevant_employees ;
	protected java.util.Date  __track_date ;
	protected java.lang.Integer  __information_type ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.Integer  __register_employee ;
	protected java.util.Date  __register_date ;
	protected java.lang.String  __track_code ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.String  __relevant_employees_display_value ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __win_rate ;
	protected java.lang.Integer  __contract_sign_status ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.String  __design_price ;
	protected java.lang.Integer  __attachment_id ;
}
