package pomplatform.workflow.contractstatus.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseChangeContractStatus extends GenericBase implements BaseFactory<BaseChangeContractStatus>, Comparable<BaseChangeContractStatus> 
{


	public static BaseChangeContractStatus newInstance(){
		return new BaseChangeContractStatus();
	}

	@Override
	public BaseChangeContractStatus make(){
		BaseChangeContractStatus b = new BaseChangeContractStatus();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_REVENUE_AMOUNT = "revenue_amount" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_WORKFLOW_NUM = "workflow_num" ;

	public final static java.lang.String ALL_CAPTIONS = "合同ID,合同编号,合同名称,合同状态,签约总金额,累积含税营收,开票金额,总回款金额,本合同正在进行中的合同变更流程数量";

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

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getRevenueAmount() {
		return this.__revenue_amount;
	}

	public void setRevenueAmount( java.math.BigDecimal value ) {
		this.__revenue_amount = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.Long getWorkflowNum() {
		return this.__workflow_num;
	}

	public void setWorkflowNum( java.lang.Long value ) {
		this.__workflow_num = value;
	}

	public void cloneCopy(BaseChangeContractStatus __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setContractStatus(getContractStatus());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setRevenueAmount(getRevenueAmount());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setWorkflowNum(getWorkflowNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		String strContractStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getContractStatus()));
		sb.append(strContractStatus == null ? "" : strContractStatus);
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getRevenueAmount() == null ? "" : getRevenueAmount());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getWorkflowNum() == null ? "" : getWorkflowNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseChangeContractStatus o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__revenue_amount);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__workflow_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseChangeContractStatus o = (BaseChangeContractStatus)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__revenue_amount, o.getRevenueAmount())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__workflow_num, o.getWorkflowNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getRevenueAmount() != null) sb.append(__wrapDecimal(count++, "revenueAmount", getRevenueAmount()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getWorkflowNum() != null) sb.append(__wrapNumber(count++, "workflowNum", getWorkflowNum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getContractStatus() != null) res.put("contractStatus", getContractStatus());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getRevenueAmount() != null) res.put("revenueAmount", getRevenueAmount());
		if(getInvoiceAmount() != null) res.put("invoiceAmount", getInvoiceAmount());
		if(getBorrowMoney() != null) res.put("borrowMoney", getBorrowMoney());
		if(getWorkflowNum() != null) res.put("workflowNum", getWorkflowNum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("revenueAmount")) != null) setRevenueAmount(__getDecimal(val));  
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("workflowNum")) != null) setWorkflowNum(__getLong(val)); 
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __contract_status ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __revenue_amount ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.lang.Long  __workflow_num ;
}
