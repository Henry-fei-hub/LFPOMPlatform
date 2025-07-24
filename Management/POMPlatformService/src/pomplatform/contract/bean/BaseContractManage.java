package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractManage extends GenericBase implements BaseFactory<BaseContractManage>, Comparable<BaseContractManage> 
{


	public static BaseContractManage newInstance(){
		return new BaseContractManage();
	}

	@Override
	public BaseContractManage make(){
		BaseContractManage b = new BaseContractManage();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_SIGNING_COMPANY_NAME = "signing_company_name" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_FINANCIAL_CONTRACT_CODE = "financial_contract_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,合同编号,合同名称,签约总金额,签约公司,修改时间,信息编号,操作人,财务合同编号";

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

	public java.lang.Integer getSigningCompanyName() {
		return this.__signing_company_name;
	}

	public void setSigningCompanyName( java.lang.Integer value ) {
		this.__signing_company_name = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.String getFinancialContractCode() {
		return this.__financial_contract_code;
	}

	public void setFinancialContractCode( java.lang.String value ) {
		this.__financial_contract_code = value;
	}

	public java.lang.Integer getCustomerId() {
		return __customer_id;
	}

	public void setCustomerId(java.lang.Integer __customer_id) {
		this.__customer_id = __customer_id;
	}

	public java.lang.String getCustomerName() {
		return __customer_name;
	}

	public void setCustomerName(java.lang.String __customer_name) {
		this.__customer_name = __customer_name;
	}

	public void cloneCopy(BaseContractManage __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setSigningCompanyName(getSigningCompanyName());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setInfoCode(getInfoCode());
		__bean.setOperator(getOperator());
		__bean.setFinancialContractCode(getFinancialContractCode());
		__bean.setCustomerId(getCustomerId());
		__bean.setCustomerName(getCustomerName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		String strSigningCompanyName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompanyName()));
		sb.append(strSigningCompanyName == null ? "" : strSigningCompanyName);
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getFinancialContractCode() == null ? "" : getFinancialContractCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractManage o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__signing_company_name);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__financial_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractManage o = (BaseContractManage)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__signing_company_name, o.getSigningCompanyName())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__financial_contract_code, o.getFinancialContractCode())) return false;
		if(!Objects.equals(this.__customer_id, o.getFinancialContractCode())) return false;
		if(!Objects.equals(this.__customer_name, o.getFinancialContractCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getSigningCompanyName() != null) sb.append(__wrapNumber(count++, "signingCompanyName", getSigningCompanyName()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getFinancialContractCode() != null) sb.append(__wrapString(count++, "financialContractCode", getFinancialContractCode()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("signingCompanyName")) != null) setSigningCompanyName(__getInt(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("financialContractCode")) != null) setFinancialContractCode(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.Integer  __signing_company_name ;
	protected java.util.Date  __update_time ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __operator ;
	protected java.lang.String  __financial_contract_code ;
	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __customer_name ;
}
