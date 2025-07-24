package pomplatform.contractchange.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractChangeList extends GenericBase implements BaseFactory<BaseContractChangeList>, Comparable<BaseContractChangeList> 
{


	public static BaseContractChangeList newInstance(){
		return new BaseContractChangeList();
	}

	@Override
	public BaseContractChangeList make(){
		BaseContractChangeList b = new BaseContractChangeList();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_CHANGE_ID = "contract_change_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "合同变更编码,合同编码,合同编号,合同名称,客户名称,签约总金额,状态,操作时间";

	public java.lang.Integer getContractChangeId() {
		return this.__contract_change_id;
	}

	public void setContractChangeId( java.lang.Integer value ) {
		this.__contract_change_id = value;
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

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}
	
	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public void cloneCopy(BaseContractChangeList __bean){
		__bean.setContractChangeId(getContractChangeId());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setFlag(getFlag());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractChangeId() == null ? "" : getContractChangeId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		String strFlag = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getFlag()));
		sb.append(strFlag == null ? "" : strFlag);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractChangeList o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_change_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractChangeList o = (BaseContractChangeList)obj;
		if(!Objects.equals(this.__contract_change_id, o.getContractChangeId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractChangeId() != null) sb.append(__wrapNumber(count++, "contractChangeId", getContractChangeId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractChangeId")) != null) setContractChangeId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __contract_change_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.Integer  __flag ;
	protected java.util.Date  __operate_time ;
}
