package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAcknowledgeLetter extends GenericBase implements BaseFactory<BaseAcknowledgeLetter>, Comparable<BaseAcknowledgeLetter> 
{


	public static BaseAcknowledgeLetter newInstance(){
		return new BaseAcknowledgeLetter();
	}

	@Override
	public BaseAcknowledgeLetter make(){
		BaseAcknowledgeLetter b = new BaseAcknowledgeLetter();
		return b;
	}

	public final static java.lang.String CS_ACKNOWLEDGE_LETTER_ID = "acknowledge_letter_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_RECEIVABLE_IDS = "receivable_ids" ;
	public final static java.lang.String CS_SIGN_COMPANY = "sign_company" ;
	public final static java.lang.String CS_SIGNATORY = "signatory" ;
	public final static java.lang.String CS_SIGN_DATE = "sign_date" ;
	public final static java.lang.String CS_REGISTRATION_DATE = "registration_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ACKNOWLEDGE_LETTER_FILE = "acknowledge_letter_file" ;
	public final static java.lang.String CS_HAS_INVOICES = "has_invoices" ;

	public final static java.lang.String ALL_CAPTIONS = "合同阶段id,信息编号,项目编号,合同主编号,项目名称,选中阶段id字符串拼接,拟签约公司,签约人,签约日期,确认函的登记日期,成果包含content,确认函原文件上传,是否已经开了发票";

	public java.lang.Integer getAcknowledgeLetterId() {
		return this.__acknowledge_letter_id;
	}

	public void setAcknowledgeLetterId( java.lang.Integer value ) {
		this.__acknowledge_letter_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getReceivableIds() {
		return this.__receivable_ids;
	}

	public void setReceivableIds( java.lang.String value ) {
		this.__receivable_ids = value;
	}

	public java.lang.Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( java.lang.Integer value ) {
		this.__sign_company = value;
	}

	public java.lang.String getSignatory() {
		return this.__signatory;
	}

	public void setSignatory( java.lang.String value ) {
		this.__signatory = value;
	}

	public java.util.Date getSignDate() {
		return this.__sign_date;
	}

	public void setSignDate( java.util.Date value ) {
		this.__sign_date = value;
	}

	public java.util.Date getRegistrationDate() {
		return this.__registration_date;
	}

	public void setRegistrationDate( java.util.Date value ) {
		this.__registration_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getAcknowledgeLetterFile() {
		return this.__acknowledge_letter_file;
	}

	public void setAcknowledgeLetterFile( java.lang.String value ) {
		this.__acknowledge_letter_file = value;
	}

	public java.lang.Boolean getHasInvoices() {
		return this.__has_invoices;
	}

	public void setHasInvoices( java.lang.Boolean value ) {
		this.__has_invoices = value;
	}

	public void cloneCopy(BaseAcknowledgeLetter __bean){
		__bean.setAcknowledgeLetterId(getAcknowledgeLetterId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setReceivableIds(getReceivableIds());
		__bean.setSignCompany(getSignCompany());
		__bean.setSignatory(getSignatory());
		__bean.setSignDate(getSignDate());
		__bean.setRegistrationDate(getRegistrationDate());
		__bean.setRemark(getRemark());
		__bean.setAcknowledgeLetterFile(getAcknowledgeLetterFile());
		__bean.setHasInvoices(getHasInvoices());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAcknowledgeLetterId() == null ? "" : getAcknowledgeLetterId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getReceivableIds() == null ? "" : getReceivableIds());
		sb.append(",");
		sb.append(getSignCompany() == null ? "" : getSignCompany());
		sb.append(",");
		sb.append(getSignatory() == null ? "" : getSignatory());
		sb.append(",");
		sb.append(getSignDate() == null ? "" : sdf.format(getSignDate()));
		sb.append(",");
		sb.append(getRegistrationDate() == null ? "" : sdf.format(getRegistrationDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAcknowledgeLetterFile() == null ? "" : getAcknowledgeLetterFile());
		sb.append(",");
		sb.append(getHasInvoices() == null ? "" : getHasInvoices());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAcknowledgeLetter o) {
		return __acknowledge_letter_id == null ? -1 : __acknowledge_letter_id.compareTo(o.getAcknowledgeLetterId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__acknowledge_letter_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__receivable_ids);
		hash = 97 * hash + Objects.hashCode(this.__sign_company);
		hash = 97 * hash + Objects.hashCode(this.__signatory);
		hash = 97 * hash + Objects.hashCode(this.__sign_date);
		hash = 97 * hash + Objects.hashCode(this.__registration_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__acknowledge_letter_file);
		hash = 97 * hash + Objects.hashCode(this.__has_invoices);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAcknowledgeLetter o = (BaseAcknowledgeLetter)obj;
		if(!Objects.equals(this.__acknowledge_letter_id, o.getAcknowledgeLetterId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__receivable_ids, o.getReceivableIds())) return false;
		if(!Objects.equals(this.__sign_company, o.getSignCompany())) return false;
		if(!Objects.equals(this.__signatory, o.getSignatory())) return false;
		if(!Objects.equals(this.__sign_date, o.getSignDate())) return false;
		if(!Objects.equals(this.__registration_date, o.getRegistrationDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__acknowledge_letter_file, o.getAcknowledgeLetterFile())) return false;
		if(!Objects.equals(this.__has_invoices, o.getHasInvoices())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAcknowledgeLetterId() != null) sb.append(__wrapNumber(count++, "acknowledgeLetterId", getAcknowledgeLetterId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getReceivableIds() != null) sb.append(__wrapString(count++, "receivableIds", getReceivableIds()));
		if(getSignCompany() != null) sb.append(__wrapNumber(count++, "signCompany", getSignCompany()));
		if(getSignatory() != null) sb.append(__wrapString(count++, "signatory", getSignatory()));
		if(getSignDate() != null) sb.append(__wrapDate(count++, "signDate", getSignDate()));
		if(getRegistrationDate() != null) sb.append(__wrapDate(count++, "registrationDate", getRegistrationDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAcknowledgeLetterFile() != null) sb.append(__wrapString(count++, "acknowledgeLetterFile", getAcknowledgeLetterFile()));
		if(getHasInvoices() != null) sb.append(__wrapBoolean(count++, "hasInvoices", getHasInvoices()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("acknowledgeLetterId")) != null) setAcknowledgeLetterId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("receivableIds")) != null) setReceivableIds(__getString(val));
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val)); 
		if((val = values.get("signatory")) != null) setSignatory(__getString(val));
		if((val = values.get("signDate")) != null) setSignDate(__getDate(val)); 
		if((val = values.get("registrationDate")) != null) setRegistrationDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("acknowledgeLetterFile")) != null) setAcknowledgeLetterFile(__getString(val));
		if((val = values.get("hasInvoices")) != null) setHasInvoices(__getBoolean(val));
	}

	protected java.lang.Integer  __acknowledge_letter_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __receivable_ids ;
	protected java.lang.Integer  __sign_company ;
	protected java.lang.String  __signatory ;
	protected java.util.Date  __sign_date ;
	protected java.util.Date  __registration_date ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __acknowledge_letter_file ;
	protected java.lang.Boolean  __has_invoices ;
}
