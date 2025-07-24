package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialSubjectMoney extends GenericBase implements BaseFactory<BaseFinancialSubjectMoney>, Comparable<BaseFinancialSubjectMoney> 
{


	public static BaseFinancialSubjectMoney newInstance(){
		return new BaseFinancialSubjectMoney();
	}

	@Override
	public BaseFinancialSubjectMoney make(){
		BaseFinancialSubjectMoney b = new BaseFinancialSubjectMoney();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_MAIN_ITEM_ID = "main_item_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "归属公司,一级报销科目,总金额";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getMainItemId() {
		return this.__main_item_id;
	}

	public void setMainItemId( java.lang.Integer value ) {
		this.__main_item_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseFinancialSubjectMoney __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setMainItemId(getMainItemId());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getMainItemId() == null ? "" : getMainItemId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialSubjectMoney o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__main_item_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialSubjectMoney o = (BaseFinancialSubjectMoney)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__main_item_id, o.getMainItemId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getMainItemId() != null) sb.append(__wrapNumber(count++, "mainItemId", getMainItemId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("mainItemId")) != null) setMainItemId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __main_item_id ;
	protected java.math.BigDecimal  __amount ;
}
