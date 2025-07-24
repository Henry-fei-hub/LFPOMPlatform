package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.date.util.DateUtil;
import delicacy.common.BaseFactory;

public class BaseContractStatusHistory extends GenericBase implements BaseFactory<BaseContractStatusHistory>, Comparable<BaseContractStatusHistory> 
{


	public static BaseContractStatusHistory newInstance(){
		return new BaseContractStatusHistory();
	}

	@Override
	public BaseContractStatusHistory make(){
		BaseContractStatusHistory b = new BaseContractStatusHistory();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_SIGNING_COMPANY_NAME = "signing_company_name" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编号,合同名称,客户名称,签约总金额,我方签约公司,合同状态";

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

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
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

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.util.Date getOperateTime()
	{
		return __operate_time;
	}

	public void setOperateTime(java.util.Date __operate_time)
	{
		this.__operate_time = __operate_time;
	}

	public void cloneCopy(BaseContractStatusHistory __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setSigningCompanyName(getSigningCompanyName());
		__bean.setContractStatus(getContractStatus());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll(",", "，"));
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		String strSigningCompanyName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompanyName()));
		sb.append(strSigningCompanyName == null ? "" : strSigningCompanyName);
		sb.append(",");
		String strContractStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getContractStatus()));
		sb.append(strContractStatus == null ? "" : strContractStatus);
		sb.append(",");
		sb.append(null == getOperateTime() ? "" : DateUtil.formatDateString(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractStatusHistory o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__signing_company_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractStatusHistory o = (BaseContractStatusHistory)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__signing_company_name, o.getSigningCompanyName())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getSigningCompanyName() != null) sb.append(__wrapNumber(count++, "signingCompanyName", getSigningCompanyName()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("signingCompanyName")) != null) setSigningCompanyName(__getInt(val)); 
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.Integer  __signing_company_name ;
	protected java.lang.Integer  __contract_status ;
	protected java.util.Date __operate_time;
}
