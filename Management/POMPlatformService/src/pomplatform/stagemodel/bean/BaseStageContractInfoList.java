package pomplatform.stagemodel.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseStageContractInfoList extends GenericBase implements BaseFactory<BaseStageContractInfoList>, Comparable<BaseStageContractInfoList> 
{


	public static BaseStageContractInfoList newInstance(){
		return new BaseStageContractInfoList();
	}

	@Override
	public BaseStageContractInfoList make(){
		BaseStageContractInfoList b = new BaseStageContractInfoList();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;
	public final static java.lang.String CS_REVENUE = "revenue" ;
	public final static java.lang.String CS_ACTUAL_PERCENT = "actual_percent" ;
	public final static java.lang.String CS_CALCULATE_PERCENT = "calculate_percent" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_CAPITAL_AMOUNT = "capital_amount" ;
	public final static java.lang.String CS_RECORD_NO = "record_no" ;
	public final static java.lang.String CS_REVENUE_PERCENT = "revenue_percent" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编码,合同编号,合同名称,签约总金额,合同状态,累积营收,小节点百分比,计算出来的百分比,累积发票,累积回款,业态数量,营收百分比";

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

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.math.BigDecimal getRevenue() {
		return this.__revenue;
	}

	public void setRevenue( java.math.BigDecimal value ) {
		this.__revenue = value;
	}

	public java.math.BigDecimal getActualPercent() {
		return this.__actual_percent;
	}

	public void setActualPercent( java.math.BigDecimal value ) {
		this.__actual_percent = value;
	}

	public java.math.BigDecimal getCalculatePercent() {
		return __calculate_percent;
	}

	public void setCalculatePercent(java.math.BigDecimal value) {
		this.__calculate_percent = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getCapitalAmount() {
		return this.__capital_amount;
	}

	public void setCapitalAmount( java.math.BigDecimal value ) {
		this.__capital_amount = value;
	}

	public java.lang.Long getRecordNo() {
		return this.__record_no;
	}

	public void setRecordNo( java.lang.Long value ) {
		this.__record_no = value;
	}

	public java.math.BigDecimal getRevenuePercent() {
		return this.__revenue_percent;
	}

	public void setRevenuePercent( java.math.BigDecimal value ) {
		this.__revenue_percent = value;
	}

	public void cloneCopy(BaseStageContractInfoList __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setContractStatus(getContractStatus());
		__bean.setRevenue(getRevenue());
		__bean.setActualPercent(getActualPercent());
		__bean.setCalculatePercent(getCalculatePercent());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setCapitalAmount(getCapitalAmount());
		__bean.setRecordNo(getRecordNo());
		__bean.setRevenuePercent(getRevenuePercent());
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
		String strContractStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getContractStatus()));
		sb.append(strContractStatus == null ? "" : strContractStatus);
		sb.append(",");
		sb.append(getRevenue() == null ? "" : getRevenue());
		sb.append(",");
		sb.append(getActualPercent() == null ? "" : getActualPercent());
		sb.append(",");
		sb.append(getCalculatePercent() == null ? "" : getCalculatePercent());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getCapitalAmount() == null ? "" : getCapitalAmount());
		sb.append(",");
		sb.append(getRecordNo() == null ? "" : getRecordNo());
		sb.append(",");
		sb.append(getRevenuePercent() == null ? "" : getRevenuePercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStageContractInfoList o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__revenue);
		hash = 97 * hash + Objects.hashCode(this.__actual_percent);
		hash = 97 * hash + Objects.hashCode(this.__calculate_percent);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__capital_amount);
		hash = 97 * hash + Objects.hashCode(this.__record_no);
		hash = 97 * hash + Objects.hashCode(this.__revenue_percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStageContractInfoList o = (BaseStageContractInfoList)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__revenue, o.getRevenue())) return false;
		if(!Objects.equals(this.__actual_percent, o.getActualPercent())) return false;
		if(!Objects.equals(this.__calculate_percent, o.getCalculatePercent())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__capital_amount, o.getCapitalAmount())) return false;
		if(!Objects.equals(this.__record_no, o.getRecordNo())) return false;
		if(!Objects.equals(this.__revenue_percent, o.getRevenuePercent())) return false;
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
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getRevenue() != null) sb.append(__wrapDecimal(count++, "revenue", getRevenue()));
		if(getActualPercent() != null) sb.append(__wrapDecimal(count++, "actualPercent", getActualPercent()));
		if(getCalculatePercent() != null) sb.append(__wrapDecimal(count++, "calculatePercent", getCalculatePercent()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getCapitalAmount() != null) sb.append(__wrapDecimal(count++, "capitalAmount", getCapitalAmount()));
		if(getRecordNo() != null) sb.append(__wrapNumber(count++, "recordNo", getRecordNo()));
		if(getRevenuePercent() != null) sb.append(__wrapDecimal(count++, "revenuePercent", getRevenuePercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("revenue")) != null) setRevenue(__getDecimal(val));  
		if((val = values.get("actualPercent")) != null) setActualPercent(__getDecimal(val));  
		if((val = values.get("calculatePercent")) != null) setCalculatePercent(__getDecimal(val));  
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("capitalAmount")) != null) setCapitalAmount(__getDecimal(val));  
		if((val = values.get("recordNo")) != null) setRecordNo(__getLong(val)); 
		if((val = values.get("revenuePercent")) != null) setRevenuePercent(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.Integer  __contract_status ;
	protected java.math.BigDecimal  __revenue ;
	protected java.math.BigDecimal  __actual_percent ;
	protected java.math.BigDecimal  __calculate_percent ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __capital_amount ;
	protected java.lang.Long  __record_no ;
	protected java.math.BigDecimal  __revenue_percent ;
}
