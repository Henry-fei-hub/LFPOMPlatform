package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialEmpAndPayMoney extends GenericBase implements BaseFactory<BaseFinancialEmpAndPayMoney>, Comparable<BaseFinancialEmpAndPayMoney> 
{


	public static BaseFinancialEmpAndPayMoney newInstance(){
		return new BaseFinancialEmpAndPayMoney();
	}

	@Override
	public BaseFinancialEmpAndPayMoney make(){
		BaseFinancialEmpAndPayMoney b = new BaseFinancialEmpAndPayMoney();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PROCESS_TYPE_ID = "process_type_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "归属公司,流程类型,总金额";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getProcessTypeId() {
		return this.__process_type_id;
	}

	public void setProcessTypeId( java.lang.Integer value ) {
		this.__process_type_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseFinancialEmpAndPayMoney __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setProcessTypeId(getProcessTypeId());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getProcessTypeId() == null ? "" : getProcessTypeId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialEmpAndPayMoney o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialEmpAndPayMoney o = (BaseFinancialEmpAndPayMoney)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__process_type_id, o.getProcessTypeId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getProcessTypeId() != null) sb.append(__wrapNumber(count++, "processTypeId", getProcessTypeId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("processTypeId")) != null) setProcessTypeId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __process_type_id ;
	protected java.math.BigDecimal  __amount ;
}
