package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseBonusPaymentDetail;

public class BaseBonusApplication extends GenericBase implements BaseFactory<BaseBonusApplication>, Comparable<BaseBonusApplication> 
{


	public static BaseBonusApplication newInstance(){
		return new BaseBonusApplication();
	}

	@Override
	public BaseBonusApplication make(){
		BaseBonusApplication b = new BaseBonusApplication();
		return b;
	}

	public final static java.lang.String CS_BONUS_PAYMENT_RECORD_ID = "bonus_payment_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PAY_INTEGRAL = "pay_integral" ;
	public final static java.lang.String CS_PAY_DATE = "pay_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_APPLICANT = "applicant" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_STATE = "state" ;
	public final static java.lang.String CS_AUDITOR = "auditor" ;
	public final static java.lang.String CS_AUDITING_TIME = "auditing_time" ;
	public final static java.lang.String CS_OPINION = "opinion" ;
	public final static java.lang.String CS_IS_LEVEL_TWO = "is_level_two" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,发放积分,发放年月,备注,申请人,申请时间,审核状态  0未审核   1审核通过    2审核不通过,审核人,审核时间,审核意见,是否二级部门提交的";

	public java.lang.Integer getBonusPaymentRecordId() {
		return this.__bonus_payment_record_id;
	}

	public void setBonusPaymentRecordId( java.lang.Integer value ) {
		this.__bonus_payment_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getPayIntegral() {
		return this.__pay_integral;
	}

	public void setPayIntegral( java.math.BigDecimal value ) {
		this.__pay_integral = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.util.Date getApplyTime() {
		return this.__apply_time;
	}

	public void setApplyTime( java.util.Date value ) {
		this.__apply_time = value;
	}

	public java.lang.Integer getState() {
		return this.__state;
	}

	public void setState( java.lang.Integer value ) {
		this.__state = value;
	}

	public java.lang.Integer getAuditor() {
		return this.__auditor;
	}

	public void setAuditor( java.lang.Integer value ) {
		this.__auditor = value;
	}

	public java.util.Date getAuditingTime() {
		return this.__auditing_time;
	}

	public void setAuditingTime( java.util.Date value ) {
		this.__auditing_time = value;
	}

	public java.lang.String getOpinion() {
		return this.__opinion;
	}

	public void setOpinion( java.lang.String value ) {
		this.__opinion = value;
	}

	public java.lang.Boolean getIsLevelTwo() {
		return this.__is_level_two;
	}

	public void setIsLevelTwo( java.lang.Boolean value ) {
		this.__is_level_two = value;
	}

	public java.util.List<BaseBonusPaymentDetail> getDetailBonusPaymentDetail() {
		return this.__detailBonusPaymentDetail;
	}

	public void setDetailBonusPaymentDetail( java.util.List<BaseBonusPaymentDetail> value ) {
		this.__detailBonusPaymentDetail = value;
	}

	public void cloneCopy(BaseBonusApplication __bean){
		__bean.setBonusPaymentRecordId(getBonusPaymentRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setPayIntegral(getPayIntegral());
		__bean.setPayDate(getPayDate());
		__bean.setRemark(getRemark());
		__bean.setApplicant(getApplicant());
		__bean.setApplyTime(getApplyTime());
		__bean.setState(getState());
		__bean.setAuditor(getAuditor());
		__bean.setAuditingTime(getAuditingTime());
		__bean.setOpinion(getOpinion());
		__bean.setIsLevelTwo(getIsLevelTwo());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBonusPaymentRecordId() == null ? "" : getBonusPaymentRecordId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getPayIntegral() == null ? "" : getPayIntegral());
		sb.append(",");
		sb.append(getPayDate() == null ? "" : sdf.format(getPayDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getApplicant() == null ? "" : getApplicant());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getState() == null ? "" : getState());
		sb.append(",");
		sb.append(getAuditor() == null ? "" : getAuditor());
		sb.append(",");
		sb.append(getAuditingTime() == null ? "" : sdf.format(getAuditingTime()));
		sb.append(",");
		sb.append(getOpinion() == null ? "" : getOpinion());
		sb.append(",");
		sb.append(getIsLevelTwo() == null ? "" : getIsLevelTwo());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBonusApplication o) {
		return __bonus_payment_record_id == null ? -1 : __bonus_payment_record_id.compareTo(o.getBonusPaymentRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__pay_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__applicant);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__state);
		hash = 97 * hash + Objects.hashCode(this.__auditor);
		hash = 97 * hash + Objects.hashCode(this.__auditing_time);
		hash = 97 * hash + Objects.hashCode(this.__opinion);
		hash = 97 * hash + Objects.hashCode(this.__is_level_two);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBonusApplication o = (BaseBonusApplication)obj;
		if(!Objects.equals(this.__bonus_payment_record_id, o.getBonusPaymentRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__pay_integral, o.getPayIntegral())) return false;
		if(!Objects.equals(this.__pay_date, o.getPayDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__applicant, o.getApplicant())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__state, o.getState())) return false;
		if(!Objects.equals(this.__auditor, o.getAuditor())) return false;
		if(!Objects.equals(this.__auditing_time, o.getAuditingTime())) return false;
		if(!Objects.equals(this.__opinion, o.getOpinion())) return false;
		if(!Objects.equals(this.__is_level_two, o.getIsLevelTwo())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBonusPaymentRecordId() != null) sb.append(__wrapNumber(count++, "bonusPaymentRecordId", getBonusPaymentRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPayIntegral() != null) sb.append(__wrapDecimal(count++, "payIntegral", getPayIntegral()));
		if(getPayDate() != null) sb.append(__wrapDate(count++, "payDate", getPayDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getApplicant() != null) sb.append(__wrapNumber(count++, "applicant", getApplicant()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getState() != null) sb.append(__wrapNumber(count++, "state", getState()));
		if(getAuditor() != null) sb.append(__wrapNumber(count++, "auditor", getAuditor()));
		if(getAuditingTime() != null) sb.append(__wrapDate(count++, "auditingTime", getAuditingTime()));
		if(getOpinion() != null) sb.append(__wrapString(count++, "opinion", getOpinion()));
		if(getIsLevelTwo() != null) sb.append(__wrapBoolean(count++, "isLevelTwo", getIsLevelTwo()));
		if(getDetailBonusPaymentDetail() != null)  sb.append(__wrapList(count++, "detailBonusPaymentDetail", getDetailBonusPaymentDetail()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getBonusPaymentRecordId() != null) res.put("bonusPaymentRecordId", getBonusPaymentRecordId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getPayIntegral() != null) res.put("payIntegral", getPayIntegral());
		if(getPayDate() != null) res.put("payDate", getPayDate());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getApplicant() != null) res.put("applicant", getApplicant());
		if(getApplyTime() != null) res.put("applyTime", getApplyTime());
		if(getState() != null) res.put("state", getState());
		if(getAuditor() != null) res.put("auditor", getAuditor());
		if(getAuditingTime() != null) res.put("auditingTime", getAuditingTime());
		if(getOpinion() != null) res.put("opinion", getOpinion());
		if(getIsLevelTwo() != null) res.put("isLevelTwo", getIsLevelTwo());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bonusPaymentRecordId")) != null) setBonusPaymentRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("payIntegral")) != null) setPayIntegral(__getDecimal(val));  
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("state")) != null) setState(__getInt(val)); 
		if((val = values.get("auditor")) != null) setAuditor(__getInt(val)); 
		if((val = values.get("auditingTime")) != null) setAuditingTime(__getDate(val)); 
		if((val = values.get("opinion")) != null) setOpinion(__getString(val));
		if((val = values.get("isLevelTwo")) != null) setIsLevelTwo(__getBoolean(val));
		if((val = values.get("detailBonusPaymentDetail")) != null) setDetailBonusPaymentDetail(__getList(val, BaseBonusPaymentDetail.newInstance()));
	}

	protected java.lang.Integer  __bonus_payment_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __pay_integral ;
	protected java.util.Date  __pay_date ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __applicant ;
	protected java.util.Date  __apply_time ;
	protected java.lang.Integer  __state ;
	protected java.lang.Integer  __auditor ;
	protected java.util.Date  __auditing_time ;
	protected java.lang.String  __opinion ;
	protected java.lang.Boolean  __is_level_two ;
	protected java.util.List<BaseBonusPaymentDetail> __detailBonusPaymentDetail = null;
}
