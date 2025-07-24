package pomplatform.contractincome.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractIncomeBasicInfo extends GenericBase implements BaseFactory<BaseContractIncomeBasicInfo>, Comparable<BaseContractIncomeBasicInfo> 
{


	public static BaseContractIncomeBasicInfo newInstance(){
		return new BaseContractIncomeBasicInfo();
	}

	@Override
	public BaseContractIncomeBasicInfo make(){
		BaseContractIncomeBasicInfo b = new BaseContractIncomeBasicInfo();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_RECEIVE_CONTRACT_AMOUNT = "receive_contract_amount" ;
	public final static java.lang.String CS_UNRECEIVED_CONTRACT_AMOUNT = "unreceived_contract_amount" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_CURRENT_RECEIVE_AMOUNT = "current_receive_amount" ;
	public final static java.lang.String CS_CURRENT_RECEIVE_DATE = "current_receive_date" ;
	public final static java.lang.String CS_CURRENT_RECEIVE_REMARK = "current_receive_remark" ;
	public final static java.lang.String CS_PLATE_MANAGER = "plate_manager" ;
	public final static java.lang.String CS_COPY_INCOME_LEDGER = "copy_income_ledger" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;

	public final static java.lang.String ALL_CAPTIONS = "归属公司,项目经理,合同ID,合同编号,合同名称,签约总金额,累计收款,未收款,开票金额,当月收款金额,当月收款日期,当月收款备注,项目负责人,是否复制上月的合同收入台账数据,";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
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

	public java.lang.String getPlateManager() {
		return this.__plate_manager;
	}

	public void setPlateManager( java.lang.String value ) {
		this.__plate_manager = value;
	}

	public java.lang.Boolean getCopyIncomeLedger() {
		return this.__copy_income_ledger;
	}

	public void setCopyIncomeLedger( java.lang.Boolean value ) {
		this.__copy_income_ledger = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public void cloneCopy(BaseContractIncomeBasicInfo __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setProjectManager(getProjectManager());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setReceiveContractAmount(getReceiveContractAmount());
		__bean.setUnreceivedContractAmount(getUnreceivedContractAmount());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setCurrentReceiveAmount(getCurrentReceiveAmount());
		__bean.setCurrentReceiveDate(getCurrentReceiveDate());
		__bean.setCurrentReceiveRemark(getCurrentReceiveRemark());
		__bean.setPlateManager(getPlateManager());
		__bean.setCopyIncomeLedger(getCopyIncomeLedger());
		__bean.setClientId(getClientId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strProjectManager = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManager()));
		sb.append(strProjectManager == null ? "" : strProjectManager);
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getReceiveContractAmount() == null ? "" : getReceiveContractAmount());
		sb.append(",");
		sb.append(getUnreceivedContractAmount() == null ? "" : getUnreceivedContractAmount());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getCurrentReceiveAmount() == null ? "" : getCurrentReceiveAmount());
		sb.append(",");
		sb.append(getCurrentReceiveDate() == null ? "" : getCurrentReceiveDate());
		sb.append(",");
		sb.append(getCurrentReceiveRemark() == null ? "" : getCurrentReceiveRemark());
		sb.append(",");
		sb.append(getPlateManager() == null ? "" : getPlateManager());
		sb.append(",");
		sb.append(getCopyIncomeLedger() == null ? "" : getCopyIncomeLedger());
		sb.append(",");
		String strClientId = delicacy.system.executor.SelectValueCache.getSelectValue("customers", String.valueOf(getClientId()));
		sb.append(strClientId == null ? "" : strClientId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractIncomeBasicInfo o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__receive_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__unreceived_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__current_receive_amount);
		hash = 97 * hash + Objects.hashCode(this.__current_receive_date);
		hash = 97 * hash + Objects.hashCode(this.__current_receive_remark);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager);
		hash = 97 * hash + Objects.hashCode(this.__copy_income_ledger);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractIncomeBasicInfo o = (BaseContractIncomeBasicInfo)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__receive_contract_amount, o.getReceiveContractAmount())) return false;
		if(!Objects.equals(this.__unreceived_contract_amount, o.getUnreceivedContractAmount())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__current_receive_amount, o.getCurrentReceiveAmount())) return false;
		if(!Objects.equals(this.__current_receive_date, o.getCurrentReceiveDate())) return false;
		if(!Objects.equals(this.__current_receive_remark, o.getCurrentReceiveRemark())) return false;
		if(!Objects.equals(this.__plate_manager, o.getPlateManager())) return false;
		if(!Objects.equals(this.__copy_income_ledger, o.getCopyIncomeLedger())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getReceiveContractAmount() != null) sb.append(__wrapDecimal(count++, "receiveContractAmount", getReceiveContractAmount()));
		if(getUnreceivedContractAmount() != null) sb.append(__wrapDecimal(count++, "unreceivedContractAmount", getUnreceivedContractAmount()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getCurrentReceiveAmount() != null) sb.append(__wrapDecimal(count++, "currentReceiveAmount", getCurrentReceiveAmount()));
		if(getCurrentReceiveDate() != null) sb.append(__wrapString(count++, "currentReceiveDate", getCurrentReceiveDate()));
		if(getCurrentReceiveRemark() != null) sb.append(__wrapString(count++, "currentReceiveRemark", getCurrentReceiveRemark()));
		if(getPlateManager() != null) sb.append(__wrapString(count++, "plateManager", getPlateManager()));
		if(getCopyIncomeLedger() != null) sb.append(__wrapBoolean(count++, "copyIncomeLedger", getCopyIncomeLedger()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getProjectManager() != null) res.put("projectManager", getProjectManager());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getReceiveContractAmount() != null) res.put("receiveContractAmount", getReceiveContractAmount());
		if(getUnreceivedContractAmount() != null) res.put("unreceivedContractAmount", getUnreceivedContractAmount());
		if(getInvoiceAmount() != null) res.put("invoiceAmount", getInvoiceAmount());
		if(getCurrentReceiveAmount() != null) res.put("currentReceiveAmount", getCurrentReceiveAmount());
		if(getCurrentReceiveDate() != null) res.put("currentReceiveDate", getCurrentReceiveDate());
		if(getCurrentReceiveRemark() != null) res.put("currentReceiveRemark", getCurrentReceiveRemark());
		if(getPlateManager() != null) res.put("plateManager", getPlateManager());
		if(getCopyIncomeLedger() != null) res.put("copyIncomeLedger", getCopyIncomeLedger());
		if(getClientId() != null) res.put("clientId", getClientId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("receiveContractAmount")) != null) setReceiveContractAmount(__getDecimal(val));  
		if((val = values.get("unreceivedContractAmount")) != null) setUnreceivedContractAmount(__getDecimal(val));  
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("currentReceiveAmount")) != null) setCurrentReceiveAmount(__getDecimal(val));  
		if((val = values.get("currentReceiveDate")) != null) setCurrentReceiveDate(__getString(val));
		if((val = values.get("currentReceiveRemark")) != null) setCurrentReceiveRemark(__getString(val));
		if((val = values.get("plateManager")) != null) setPlateManager(__getString(val));
		if((val = values.get("copyIncomeLedger")) != null) setCopyIncomeLedger(__getBoolean(val));
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __project_manager ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __receive_contract_amount ;
	protected java.math.BigDecimal  __unreceived_contract_amount ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __current_receive_amount ;
	protected java.lang.String  __current_receive_date ;
	protected java.lang.String  __current_receive_remark ;
	protected java.lang.String  __plate_manager ;
	protected java.lang.Boolean  __copy_income_ledger ;
	protected java.lang.Integer  __client_id ;
}
