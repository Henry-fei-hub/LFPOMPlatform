package pomplatform.contractincome.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractIncomeLedgerList extends GenericCondition{

	public ConditionContractIncomeLedgerList(){
		setParameterCount(12);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
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

	public java.lang.String getProjectManager() {
		return this.__project_manager == null ? null : (this.__project_manager.indexOf("%") >= 0 ? this.__project_manager : "%"+this.__project_manager+"%");
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public java.lang.String getPlateManager() {
		return this.__plate_manager == null ? null : (this.__plate_manager.indexOf("%") >= 0 ? this.__plate_manager : "%"+this.__plate_manager+"%");
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

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}

	public java.lang.Integer getContractYear() {
		return __contract_year;
	}

	public void setContractYear(java.lang.Integer value) {
		this.__contract_year = value;
	}

	public java.lang.Integer getPlateId() {
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getProjectManager() != null) sb.append(__wrapString(1, "projectManager", getProjectManager()));
		if(getPlateManager() != null) sb.append(__wrapString(1, "plateManager", getPlateManager()));
		if(getSigningMoneySum() != null) sb.append(__wrapNumber(1, "signingMoneySum", getSigningMoneySum()));
		if(getLedgerYear() != null) sb.append(__wrapNumber(1, "ledgerYear", getLedgerYear()));
		if(getLedgerMonth() != null) sb.append(__wrapNumber(1, "ledgerMonth", getLedgerMonth()));
		if(getClientId() != null) sb.append(__wrapNumber(1, "clientId", getClientId()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(1, "isLocked", getIsLocked()));
		if(getContractYear() != null) sb.append(__wrapNumber(1, "contractYear", getContractYear()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("plateManager")) != null) setPlateManager(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("ledgerYear")) != null) setLedgerYear(__getInt(val)); 
		if((val = values.get("ledgerMonth")) != null) setLedgerMonth(__getInt(val)); 
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
		if((val = values.get("contractYear")) != null) setContractYear(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __company_id = null;
	private java.lang.String __project_manager = null;
	private java.lang.String __plate_manager = null;
	private java.math.BigDecimal __signing_money_sum = null;
	private java.lang.Integer __ledger_year = null;
	private java.lang.Integer __ledger_month = null;
	private java.lang.Integer __client_id = null;
	private java.lang.Boolean __is_locked = null;
	private java.lang.Integer __contract_year = null;
	private java.lang.Integer __plate_id = null;
	
}

