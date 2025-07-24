package delicacy.workflow.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseReimbursementDetail extends GenericBase implements BaseFactory<BaseReimbursementDetail>, Comparable<BaseReimbursementDetail> 
{


	public static BaseReimbursementDetail newInstance(){
		return new BaseReimbursementDetail();
	}

	@Override
	public BaseReimbursementDetail make(){
		BaseReimbursementDetail b = new BaseReimbursementDetail();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_DETAIL_ID = "reimbursement_detail_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_ID = "reimbursement_id" ;
	public final static java.lang.String CS_ITEM_ID = "item_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "明细代码,报销代码,所属项目代码,金额,发生日期,报销详细说明";

	public java.lang.Integer getReimbursementDetailId() {
		return this.__reimbursement_detail_id;
	}

	public void setReimbursementDetailId( java.lang.Integer value ) {
		this.__reimbursement_detail_id = value;
	}

	public java.lang.Integer getReimbursementId() {
		return this.__reimbursement_id;
	}

	public void setReimbursementId( java.lang.Integer value ) {
		this.__reimbursement_id = value;
	}

	public java.lang.Integer getItemId() {
		return this.__item_id;
	}

	public void setItemId( java.lang.Integer value ) {
		this.__item_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseReimbursementDetail __bean){
		__bean.setReimbursementDetailId(getReimbursementDetailId());
		__bean.setReimbursementId(getReimbursementId());
		__bean.setItemId(getItemId());
		__bean.setAmount(getAmount());
		__bean.setHappenDate(getHappenDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementDetailId() == null ? "" : getReimbursementDetailId());
		sb.append(",");
		sb.append(getReimbursementId() == null ? "" : getReimbursementId());
		sb.append(",");
		sb.append(getItemId() == null ? "" : getItemId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReimbursementDetail o) {
		return __reimbursement_detail_id == null ? -1 : __reimbursement_detail_id.compareTo(o.getReimbursementDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__item_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReimbursementDetail o = (BaseReimbursementDetail)obj;
		if(!Objects.equals(this.__reimbursement_detail_id, o.getReimbursementDetailId())) return false;
		if(!Objects.equals(this.__reimbursement_id, o.getReimbursementId())) return false;
		if(!Objects.equals(this.__item_id, o.getItemId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementDetailId() != null) sb.append(__wrapNumber(count++, "reimbursementDetailId", getReimbursementDetailId()));
		if(getReimbursementId() != null) sb.append(__wrapNumber(count++, "reimbursementId", getReimbursementId()));
		if(getItemId() != null) sb.append(__wrapNumber(count++, "itemId", getItemId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementDetailId")) != null) setReimbursementDetailId(__getInt(val)); 
		if((val = values.get("reimbursementId")) != null) setReimbursementId(__getInt(val)); 
		if((val = values.get("itemId")) != null) setItemId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __reimbursement_detail_id ;
	protected java.lang.Integer  __reimbursement_id ;
	protected java.lang.Integer  __item_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.util.Date  __happen_date ;
	protected java.lang.String  __remark ;
}
