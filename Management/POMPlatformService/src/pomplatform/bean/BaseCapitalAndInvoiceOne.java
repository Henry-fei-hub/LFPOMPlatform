package pomplatform.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCapitalAndInvoiceOne extends GenericBase implements BaseFactory<BaseCapitalAndInvoiceOne>, Comparable<BaseCapitalAndInvoiceOne> 
{


	public static BaseCapitalAndInvoiceOne newInstance(){
		return new BaseCapitalAndInvoiceOne();
	}

	@Override
	public BaseCapitalAndInvoiceOne make(){
		BaseCapitalAndInvoiceOne b = new BaseCapitalAndInvoiceOne();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_HAS_INVOICES = "has_invoices" ;
	public final static java.lang.String CS_HAS_CONTRACT_RECEIVABLE = "has_contract_receivable" ;
	public final static java.lang.String CS_HAS_DISTRIBUTION_COLLECTION = "has_distribution_collection" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_IS_HAVING_INVOICE = "is_having_invoice" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;

	public final static java.lang.String ALL_CAPTIONS = "资金表id,信息编号,项目编号,合同,合同编号,借（增加）,操作人id,是否绑定了发票,是否绑定了合同阶段付款,有分配回款,流程状态 0 未处于流程  1审批中 2审批完成,回款分配编码,是否对应发票,发生日期";

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
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

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Boolean getHasInvoices() {
		return this.__has_invoices;
	}

	public void setHasInvoices( java.lang.Boolean value ) {
		this.__has_invoices = value;
	}

	public java.lang.Boolean getHasContractReceivable() {
		return this.__has_contract_receivable;
	}

	public void setHasContractReceivable( java.lang.Boolean value ) {
		this.__has_contract_receivable = value;
	}

	public java.lang.Boolean getHasDistributionCollection() {
		return this.__has_distribution_collection;
	}

	public void setHasDistributionCollection( java.lang.Boolean value ) {
		this.__has_distribution_collection = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.lang.Integer getIsHavingInvoice() {
		return this.__is_having_invoice;
	}

	public void setIsHavingInvoice( java.lang.Integer value ) {
		this.__is_having_invoice = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public void cloneCopy(BaseCapitalAndInvoiceOne __bean){
		__bean.setCapitalId(getCapitalId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setOperator(getOperator());
		__bean.setHasInvoices(getHasInvoices());
		__bean.setHasContractReceivable(getHasContractReceivable());
		__bean.setHasDistributionCollection(getHasDistributionCollection());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setIsHavingInvoice(getIsHavingInvoice());
		__bean.setHappenDate(getHappenDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getHasInvoices() == null ? "" : getHasInvoices());
		sb.append(",");
		sb.append(getHasContractReceivable() == null ? "" : getHasContractReceivable());
		sb.append(",");
		sb.append(getHasDistributionCollection() == null ? "" : getHasDistributionCollection());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getCapitalDistributionId() == null ? "" : getCapitalDistributionId());
		sb.append(",");
		sb.append(getIsHavingInvoice() == null ? "" : getIsHavingInvoice());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCapitalAndInvoiceOne o) {
		return __capital_id == null ? -1 : __capital_id.compareTo(o.getCapitalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__has_invoices);
		hash = 97 * hash + Objects.hashCode(this.__has_contract_receivable);
		hash = 97 * hash + Objects.hashCode(this.__has_distribution_collection);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__is_having_invoice);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCapitalAndInvoiceOne o = (BaseCapitalAndInvoiceOne)obj;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__has_invoices, o.getHasInvoices())) return false;
		if(!Objects.equals(this.__has_contract_receivable, o.getHasContractReceivable())) return false;
		if(!Objects.equals(this.__has_distribution_collection, o.getHasDistributionCollection())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__is_having_invoice, o.getIsHavingInvoice())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getHasInvoices() != null) sb.append(__wrapBoolean(count++, "hasInvoices", getHasInvoices()));
		if(getHasContractReceivable() != null) sb.append(__wrapBoolean(count++, "hasContractReceivable", getHasContractReceivable()));
		if(getHasDistributionCollection() != null) sb.append(__wrapBoolean(count++, "hasDistributionCollection", getHasDistributionCollection()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getIsHavingInvoice() != null) sb.append(__wrapNumber(count++, "isHavingInvoice", getIsHavingInvoice()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("hasInvoices")) != null) setHasInvoices(__getBoolean(val));
		if((val = values.get("hasContractReceivable")) != null) setHasContractReceivable(__getBoolean(val));
		if((val = values.get("hasDistributionCollection")) != null) setHasDistributionCollection(__getBoolean(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("isHavingInvoice")) != null) setIsHavingInvoice(__getInt(val)); 
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
	}

	protected java.lang.Integer  __capital_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.lang.Integer  __operator ;
	protected java.lang.Boolean  __has_invoices ;
	protected java.lang.Boolean  __has_contract_receivable ;
	protected java.lang.Boolean  __has_distribution_collection ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __capital_distribution_id ;
	protected java.lang.Integer  __is_having_invoice ;
	protected java.util.Date  __happen_date ;
}
