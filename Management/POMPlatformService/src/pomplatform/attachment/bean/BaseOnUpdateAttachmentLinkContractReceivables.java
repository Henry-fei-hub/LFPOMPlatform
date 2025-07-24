package pomplatform.attachment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnUpdateAttachmentLinkContractReceivables extends GenericBase implements BaseFactory<BaseOnUpdateAttachmentLinkContractReceivables>, Comparable<BaseOnUpdateAttachmentLinkContractReceivables> 
{


	public static BaseOnUpdateAttachmentLinkContractReceivables newInstance(){
		return new BaseOnUpdateAttachmentLinkContractReceivables();
	}

	@Override
	public BaseOnUpdateAttachmentLinkContractReceivables make(){
		BaseOnUpdateAttachmentLinkContractReceivables b = new BaseOnUpdateAttachmentLinkContractReceivables();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_RECEIVABLE_NAME = "receivable_name" ;
	public final static java.lang.String CS_RECEIVABLE_PERCENTAGE = "receivable_percentage" ;
	public final static java.lang.String CS_RECEIVABLE_SUM_MONEY = "receivable_sum_money" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_FLAG_TYPE = "flag_type" ;
	public final static java.lang.String CS_BIND_AMOUNT = "bind_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "收款阶段编码,阶段名称,收款百分比,收款金额,收款阶段id的父节点,,";

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.lang.String getReceivableName() {
		return this.__receivable_name;
	}

	public void setReceivableName( java.lang.String value ) {
		this.__receivable_name = value;
	}

	public java.math.BigDecimal getReceivablePercentage() {
		return this.__receivable_percentage;
	}

	public void setReceivablePercentage( java.math.BigDecimal value ) {
		this.__receivable_percentage = value;
	}

	public java.math.BigDecimal getReceivableSumMoney() {
		return this.__receivable_sum_money;
	}

	public void setReceivableSumMoney( java.math.BigDecimal value ) {
		this.__receivable_sum_money = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getFlagType() {
		return this.__flag_type;
	}

	public void setFlagType( java.lang.Integer value ) {
		this.__flag_type = value;
	}

	public java.lang.Long getBindAmount() {
		return this.__bind_amount;
	}

	public void setBindAmount( java.lang.Long value ) {
		this.__bind_amount = value;
	}

	public void cloneCopy(BaseOnUpdateAttachmentLinkContractReceivables __bean){
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setReceivableName(getReceivableName());
		__bean.setReceivablePercentage(getReceivablePercentage());
		__bean.setReceivableSumMoney(getReceivableSumMoney());
		__bean.setParentId(getParentId());
		__bean.setFlagType(getFlagType());
		__bean.setBindAmount(getBindAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		sb.append(getReceivableName() == null ? "" : getReceivableName());
		sb.append(",");
		sb.append(getReceivablePercentage() == null ? "" : getReceivablePercentage());
		sb.append(",");
		sb.append(getReceivableSumMoney() == null ? "" : getReceivableSumMoney());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		String strFlagType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getFlagType()));
		sb.append(strFlagType == null ? "" : strFlagType);
		sb.append(",");
		sb.append(getBindAmount() == null ? "" : getBindAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnUpdateAttachmentLinkContractReceivables o) {
		return __contract_receivable_id == null ? -1 : __contract_receivable_id.compareTo(o.getContractReceivableId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__receivable_name);
		hash = 97 * hash + Objects.hashCode(this.__receivable_percentage);
		hash = 97 * hash + Objects.hashCode(this.__receivable_sum_money);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__flag_type);
		hash = 97 * hash + Objects.hashCode(this.__bind_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnUpdateAttachmentLinkContractReceivables o = (BaseOnUpdateAttachmentLinkContractReceivables)obj;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__receivable_name, o.getReceivableName())) return false;
		if(!Objects.equals(this.__receivable_percentage, o.getReceivablePercentage())) return false;
		if(!Objects.equals(this.__receivable_sum_money, o.getReceivableSumMoney())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__flag_type, o.getFlagType())) return false;
		if(!Objects.equals(this.__bind_amount, o.getBindAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getReceivableName() != null) sb.append(__wrapString(count++, "receivableName", getReceivableName()));
		if(getReceivablePercentage() != null) sb.append(__wrapDecimal(count++, "receivablePercentage", getReceivablePercentage()));
		if(getReceivableSumMoney() != null) sb.append(__wrapDecimal(count++, "receivableSumMoney", getReceivableSumMoney()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getFlagType() != null) sb.append(__wrapNumber(count++, "flagType", getFlagType()));
		if(getBindAmount() != null) sb.append(__wrapNumber(count++, "bindAmount", getBindAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("receivableName")) != null) setReceivableName(__getString(val));
		if((val = values.get("receivablePercentage")) != null) setReceivablePercentage(__getDecimal(val));  
		if((val = values.get("receivableSumMoney")) != null) setReceivableSumMoney(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("flagType")) != null) setFlagType(__getInt(val)); 
		if((val = values.get("bindAmount")) != null) setBindAmount(__getLong(val)); 
	}

	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.String  __receivable_name ;
	protected java.math.BigDecimal  __receivable_percentage ;
	protected java.math.BigDecimal  __receivable_sum_money ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __flag_type ;
	protected java.lang.Long  __bind_amount ;
}
