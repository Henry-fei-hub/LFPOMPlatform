package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractIncomeLedger extends GenericBase implements BaseFactory<BaseContractIncomeLedger>, Comparable<BaseContractIncomeLedger> 
{


	public static BaseContractIncomeLedger newInstance(){
		return new BaseContractIncomeLedger();
	}

	@Override
	public BaseContractIncomeLedger make(){
		BaseContractIncomeLedger b = new BaseContractIncomeLedger();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_INCOME_LEDGER_ID = "contract_income_ledger_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_PLATE_MANAGER = "plate_manager" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_RECEIVE_CONTRACT_AMOUNT = "receive_contract_amount" ;
	public final static java.lang.String CS_UNRECEIVED_CONTRACT_AMOUNT = "unreceived_contract_amount" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_INVOICE_STAGE = "invoice_stage" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_CURRENT_RECEIVE_AMOUNT = "current_receive_amount" ;
	public final static java.lang.String CS_CURRENT_RECEIVE_DATE = "current_receive_date" ;
	public final static java.lang.String CS_CURRENT_RECEIVE_REMARK = "current_receive_remark" ;
	public final static java.lang.String CS_PROJECT_STATUS = "project_status" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CONTACTS = "contacts" ;
	public final static java.lang.String CS_LEDGER_YEAR = "ledger_year" ;
	public final static java.lang.String CS_LEDGER_MONTH = "ledger_month" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编码,合同编号,合同名称,合同签约公司,客户,项目经理,项目负责人,合同签约金额,累计收款,未收款,开票日期,发票号码,开票阶段,开票金额,当月收款金额,当月收款日期,当月收款备注,项目状态,备注,联系人,台账年份,台账月份,创建时间,修改时间,是否锁定";

	public java.lang.Integer getContractIncomeLedgerId() {
		return this.__contract_income_ledger_id;
	}

	public void setContractIncomeLedgerId( java.lang.Integer value ) {
		this.__contract_income_ledger_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public java.lang.String getPlateManager() {
		return this.__plate_manager;
	}

	public void setPlateManager( java.lang.String value ) {
		this.__plate_manager = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getReceiveContractAmount() {
		return this.__receive_contract_amount;
	}

	public void setReceiveContractAmount( java.math.BigDecimal value ) {
		this.__receive_contract_amount = value;
	}

	public java.math.BigDecimal getUnreceivedContractAmount() {
		return this.__unreceived_contract_amount;
	}

	public void setUnreceivedContractAmount( java.math.BigDecimal value ) {
		this.__unreceived_contract_amount = value;
	}

	public java.lang.String getInvoiceDate() {
		return this.__invoice_date;
	}

	public void setInvoiceDate( java.lang.String value ) {
		this.__invoice_date = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number;
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.lang.String getInvoiceStage() {
		return this.__invoice_stage;
	}

	public void setInvoiceStage( java.lang.String value ) {
		this.__invoice_stage = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getCurrentReceiveAmount() {
		return this.__current_receive_amount;
	}

	public void setCurrentReceiveAmount( java.math.BigDecimal value ) {
		this.__current_receive_amount = value;
	}

	public java.lang.String getCurrentReceiveDate() {
		return this.__current_receive_date;
	}

	public void setCurrentReceiveDate( java.lang.String value ) {
		this.__current_receive_date = value;
	}

	public java.lang.String getCurrentReceiveRemark() {
		return this.__current_receive_remark;
	}

	public void setCurrentReceiveRemark( java.lang.String value ) {
		this.__current_receive_remark = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getContacts() {
		return this.__contacts;
	}

	public void setContacts( java.lang.String value ) {
		this.__contacts = value;
	}

	public java.lang.Integer getLedgerYear() {
		return this.__ledger_year;
	}

	public void setLedgerYear( java.lang.Integer value ) {
		this.__ledger_year = value;
	}

	public java.lang.Integer getLedgerMonth() {
		return this.__ledger_month;
	}

	public void setLedgerMonth( java.lang.Integer value ) {
		this.__ledger_month = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}

	public void cloneCopy(BaseContractIncomeLedger __bean){
		__bean.setContractIncomeLedgerId(getContractIncomeLedgerId());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCompanyId(getCompanyId());
		__bean.setClientId(getClientId());
		__bean.setProjectManager(getProjectManager());
		__bean.setPlateManager(getPlateManager());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setReceiveContractAmount(getReceiveContractAmount());
		__bean.setUnreceivedContractAmount(getUnreceivedContractAmount());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setInvoiceStage(getInvoiceStage());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setCurrentReceiveAmount(getCurrentReceiveAmount());
		__bean.setCurrentReceiveDate(getCurrentReceiveDate());
		__bean.setCurrentReceiveRemark(getCurrentReceiveRemark());
		__bean.setProjectStatus(getProjectStatus());
		__bean.setRemark(getRemark());
		__bean.setContacts(getContacts());
		__bean.setLedgerYear(getLedgerYear());
		__bean.setLedgerMonth(getLedgerMonth());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setIsLocked(getIsLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractIncomeLedgerId() == null ? "" : getContractIncomeLedgerId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strClientId = delicacy.system.executor.SelectValueCache.getSelectValue("customers", String.valueOf(getClientId()));
		sb.append(strClientId == null ? "" : strClientId);
		sb.append(",");
		String strProjectManager = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManager()));
		sb.append(strProjectManager == null ? "" : strProjectManager);
		sb.append(",");
		sb.append(getPlateManager() == null ? "" : getPlateManager());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getReceiveContractAmount() == null ? "" : getReceiveContractAmount());
		sb.append(",");
		sb.append(getUnreceivedContractAmount() == null ? "" : getUnreceivedContractAmount());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : getInvoiceDate());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		sb.append(getInvoiceStage() == null ? "" : getInvoiceStage());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getCurrentReceiveAmount() == null ? "" : getCurrentReceiveAmount());
		sb.append(",");
		sb.append(getCurrentReceiveDate() == null ? "" : getCurrentReceiveDate());
		sb.append(",");
		sb.append(getCurrentReceiveRemark() == null ? "" : getCurrentReceiveRemark());
		sb.append(",");
		sb.append(getProjectStatus() == null ? "" : getProjectStatus());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getContacts() == null ? "" : getContacts());
		sb.append(",");
		sb.append(getLedgerYear() == null ? "" : getLedgerYear());
		sb.append(",");
		sb.append(getLedgerMonth() == null ? "" : getLedgerMonth());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getIsLocked() == null ? "" : getIsLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractIncomeLedger o) {
		return __contract_income_ledger_id == null ? -1 : __contract_income_ledger_id.compareTo(o.getContractIncomeLedgerId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_income_ledger_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__receive_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__unreceived_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__invoice_stage);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__current_receive_amount);
		hash = 97 * hash + Objects.hashCode(this.__current_receive_date);
		hash = 97 * hash + Objects.hashCode(this.__current_receive_remark);
		hash = 97 * hash + Objects.hashCode(this.__project_status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__contacts);
		hash = 97 * hash + Objects.hashCode(this.__ledger_year);
		hash = 97 * hash + Objects.hashCode(this.__ledger_month);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractIncomeLedger o = (BaseContractIncomeLedger)obj;
		if(!Objects.equals(this.__contract_income_ledger_id, o.getContractIncomeLedgerId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__plate_manager, o.getPlateManager())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__receive_contract_amount, o.getReceiveContractAmount())) return false;
		if(!Objects.equals(this.__unreceived_contract_amount, o.getUnreceivedContractAmount())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__invoice_stage, o.getInvoiceStage())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__current_receive_amount, o.getCurrentReceiveAmount())) return false;
		if(!Objects.equals(this.__current_receive_date, o.getCurrentReceiveDate())) return false;
		if(!Objects.equals(this.__current_receive_remark, o.getCurrentReceiveRemark())) return false;
		if(!Objects.equals(this.__project_status, o.getProjectStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__contacts, o.getContacts())) return false;
		if(!Objects.equals(this.__ledger_year, o.getLedgerYear())) return false;
		if(!Objects.equals(this.__ledger_month, o.getLedgerMonth())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractIncomeLedgerId() != null) sb.append(__wrapNumber(count++, "contractIncomeLedgerId", getContractIncomeLedgerId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		if(getPlateManager() != null) sb.append(__wrapString(count++, "plateManager", getPlateManager()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getReceiveContractAmount() != null) sb.append(__wrapDecimal(count++, "receiveContractAmount", getReceiveContractAmount()));
		if(getUnreceivedContractAmount() != null) sb.append(__wrapDecimal(count++, "unreceivedContractAmount", getUnreceivedContractAmount()));
		if(getInvoiceDate() != null) sb.append(__wrapString(count++, "invoiceDate", getInvoiceDate()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getInvoiceStage() != null) sb.append(__wrapString(count++, "invoiceStage", getInvoiceStage()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getCurrentReceiveAmount() != null) sb.append(__wrapDecimal(count++, "currentReceiveAmount", getCurrentReceiveAmount()));
		if(getCurrentReceiveDate() != null) sb.append(__wrapString(count++, "currentReceiveDate", getCurrentReceiveDate()));
		if(getCurrentReceiveRemark() != null) sb.append(__wrapString(count++, "currentReceiveRemark", getCurrentReceiveRemark()));
		if(getProjectStatus() != null) sb.append(__wrapString(count++, "projectStatus", getProjectStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getContacts() != null) sb.append(__wrapString(count++, "contacts", getContacts()));
		if(getLedgerYear() != null) sb.append(__wrapNumber(count++, "ledgerYear", getLedgerYear()));
		if(getLedgerMonth() != null) sb.append(__wrapNumber(count++, "ledgerMonth", getLedgerMonth()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractIncomeLedgerId() != null) res.put("contractIncomeLedgerId", getContractIncomeLedgerId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getClientId() != null) res.put("clientId", getClientId());
		if(getProjectManager() != null) res.put("projectManager", getProjectManager());
		if(getPlateManager() != null) res.put("plateManager", getPlateManager());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getReceiveContractAmount() != null) res.put("receiveContractAmount", getReceiveContractAmount());
		if(getUnreceivedContractAmount() != null) res.put("unreceivedContractAmount", getUnreceivedContractAmount());
		if(getInvoiceDate() != null) res.put("invoiceDate", getInvoiceDate());
		if(getInvoiceNumber() != null) res.put("invoiceNumber", getInvoiceNumber());
		if(getInvoiceStage() != null) res.put("invoiceStage", getInvoiceStage());
		if(getInvoiceAmount() != null) res.put("invoiceAmount", getInvoiceAmount());
		if(getCurrentReceiveAmount() != null) res.put("currentReceiveAmount", getCurrentReceiveAmount());
		if(getCurrentReceiveDate() != null) res.put("currentReceiveDate", getCurrentReceiveDate());
		if(getCurrentReceiveRemark() != null) res.put("currentReceiveRemark", getCurrentReceiveRemark());
		if(getProjectStatus() != null) res.put("projectStatus", getProjectStatus());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getContacts() != null) res.put("contacts", getContacts());
		if(getLedgerYear() != null) res.put("ledgerYear", getLedgerYear());
		if(getLedgerMonth() != null) res.put("ledgerMonth", getLedgerMonth());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getIsLocked() != null) res.put("isLocked", getIsLocked());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractIncomeLedgerId")) != null) setContractIncomeLedgerId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("plateManager")) != null) setPlateManager(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("receiveContractAmount")) != null) setReceiveContractAmount(__getDecimal(val));  
		if((val = values.get("unreceivedContractAmount")) != null) setUnreceivedContractAmount(__getDecimal(val));  
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("invoiceStage")) != null) setInvoiceStage(__getString(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("currentReceiveAmount")) != null) setCurrentReceiveAmount(__getDecimal(val));  
		if((val = values.get("currentReceiveDate")) != null) setCurrentReceiveDate(__getString(val));
		if((val = values.get("currentReceiveRemark")) != null) setCurrentReceiveRemark(__getString(val));
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("contacts")) != null) setContacts(__getString(val));
		if((val = values.get("ledgerYear")) != null) setLedgerYear(__getInt(val)); 
		if((val = values.get("ledgerMonth")) != null) setLedgerMonth(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
	}

	protected java.lang.Integer  __contract_income_ledger_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __client_id ;
	protected java.lang.String  __project_manager ;
	protected java.lang.String  __plate_manager ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __receive_contract_amount ;
	protected java.math.BigDecimal  __unreceived_contract_amount ;
	protected java.lang.String  __invoice_date ;
	protected java.lang.String  __invoice_number ;
	protected java.lang.String  __invoice_stage ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __current_receive_amount ;
	protected java.lang.String  __current_receive_date ;
	protected java.lang.String  __current_receive_remark ;
	protected java.lang.String  __project_status ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __contacts ;
	protected java.lang.Integer  __ledger_year ;
	protected java.lang.Integer  __ledger_month ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Boolean  __is_locked ;
}
