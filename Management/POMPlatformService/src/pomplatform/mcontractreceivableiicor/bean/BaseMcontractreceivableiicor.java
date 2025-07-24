package pomplatform.mcontractreceivableiicor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcontractreceivableiicor extends GenericBase implements BaseFactory<BaseMcontractreceivableiicor>, Comparable<BaseMcontractreceivableiicor> 
{


	public static BaseMcontractreceivableiicor newInstance(){
		return new BaseMcontractreceivableiicor();
	}

	@Override
	public BaseMcontractreceivableiicor make(){
		BaseMcontractreceivableiicor b = new BaseMcontractreceivableiicor();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_RECEIVABLE_NAME = "receivable_name" ;
	public final static java.lang.String CS_RECEIVABLE_PERCENTAGE = "receivable_percentage" ;
	public final static java.lang.String CS_RECEIVABLE_SUM_MONEY = "receivable_sum_money" ;
	public final static java.lang.String CS_IS_CONFIRMATION_LETTER = "is_confirmation_letter" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_RECEIVABLE_APPLY_MONEY = "receivable_apply_money" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "合同id,合同阶段id,阶段名称,收款百分比,收款金额,是否已经被用做过确认函,收款阶段备注,收款阶段id的父节点,阶段申请的金额,创建时间";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

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

	public java.lang.Boolean getIsConfirmationLetter() {
		return this.__is_confirmation_letter;
	}

	public void setIsConfirmationLetter( java.lang.Boolean value ) {
		this.__is_confirmation_letter = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.math.BigDecimal getReceivableApplyMoney() {
		return this.__receivable_apply_money;
	}

	public void setReceivableApplyMoney( java.math.BigDecimal value ) {
		this.__receivable_apply_money = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseMcontractreceivableiicor __bean){
		__bean.setContractId(getContractId());
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setReceivableName(getReceivableName());
		__bean.setReceivablePercentage(getReceivablePercentage());
		__bean.setReceivableSumMoney(getReceivableSumMoney());
		__bean.setIsConfirmationLetter(getIsConfirmationLetter());
		__bean.setRemark(getRemark());
		__bean.setParentId(getParentId());
		__bean.setReceivableApplyMoney(getReceivableApplyMoney());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		sb.append(getReceivableName() == null ? "" : getReceivableName());
		sb.append(",");
		sb.append(getReceivablePercentage() == null ? "" : getReceivablePercentage());
		sb.append(",");
		sb.append(getReceivableSumMoney() == null ? "" : getReceivableSumMoney());
		sb.append(",");
		sb.append(getIsConfirmationLetter() == null ? "" : getIsConfirmationLetter());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getReceivableApplyMoney() == null ? "" : getReceivableApplyMoney());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcontractreceivableiicor o) {
		return __contract_receivable_id == null ? -1 : __contract_receivable_id.compareTo(o.getContractReceivableId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__receivable_name);
		hash = 97 * hash + Objects.hashCode(this.__receivable_percentage);
		hash = 97 * hash + Objects.hashCode(this.__receivable_sum_money);
		hash = 97 * hash + Objects.hashCode(this.__is_confirmation_letter);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__receivable_apply_money);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcontractreceivableiicor o = (BaseMcontractreceivableiicor)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__receivable_name, o.getReceivableName())) return false;
		if(!Objects.equals(this.__receivable_percentage, o.getReceivablePercentage())) return false;
		if(!Objects.equals(this.__receivable_sum_money, o.getReceivableSumMoney())) return false;
		if(!Objects.equals(this.__is_confirmation_letter, o.getIsConfirmationLetter())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__receivable_apply_money, o.getReceivableApplyMoney())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getReceivableName() != null) sb.append(__wrapString(count++, "receivableName", getReceivableName()));
		if(getReceivablePercentage() != null) sb.append(__wrapDecimal(count++, "receivablePercentage", getReceivablePercentage()));
		if(getReceivableSumMoney() != null) sb.append(__wrapDecimal(count++, "receivableSumMoney", getReceivableSumMoney()));
		if(getIsConfirmationLetter() != null) sb.append(__wrapBoolean(count++, "isConfirmationLetter", getIsConfirmationLetter()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getReceivableApplyMoney() != null) sb.append(__wrapDecimal(count++, "receivableApplyMoney", getReceivableApplyMoney()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("receivableName")) != null) setReceivableName(__getString(val));
		if((val = values.get("receivablePercentage")) != null) setReceivablePercentage(__getDecimal(val));  
		if((val = values.get("receivableSumMoney")) != null) setReceivableSumMoney(__getDecimal(val));  
		if((val = values.get("isConfirmationLetter")) != null) setIsConfirmationLetter(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("receivableApplyMoney")) != null) setReceivableApplyMoney(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.String  __receivable_name ;
	protected java.math.BigDecimal  __receivable_percentage ;
	protected java.math.BigDecimal  __receivable_sum_money ;
	protected java.lang.Boolean  __is_confirmation_letter ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __parent_id ;
	protected java.math.BigDecimal  __receivable_apply_money ;
	protected java.util.Date  __create_time ;
}
