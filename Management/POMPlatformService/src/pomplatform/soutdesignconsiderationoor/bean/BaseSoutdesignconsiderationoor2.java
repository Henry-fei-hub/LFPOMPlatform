package pomplatform.soutdesignconsiderationoor.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseOutDesignConsideration;

public class BaseSoutdesignconsiderationoor2 extends GenericBase implements BaseFactory<BaseSoutdesignconsiderationoor2>, Comparable<BaseSoutdesignconsiderationoor2> 
{


	public static BaseSoutdesignconsiderationoor2 newInstance(){
		return new BaseSoutdesignconsiderationoor2();
	}

	@Override
	public BaseSoutdesignconsiderationoor2 make(){
		BaseSoutdesignconsiderationoor2 b = new BaseSoutdesignconsiderationoor2();
		return b;
	}

	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_DATA_COUNT = "data_count" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_INTERIOR_MONEY_SUM = "interior_money_sum" ;
	public final static java.lang.String CS_OUT_TEMPLET_ID = "out_templet_id" ;
	public final static java.lang.String CS_NEW_CREATE_QUOTATION_NAME = "new_create_quotation_name" ;
	public final static java.lang.String CS_FINALIZED_MONEY = "finalized_money" ;
	public final static java.lang.String CS_TYPE = "type" ;

	public final static java.lang.String ALL_CAPTIONS = "信息编号,项目编号,报价单编码,,设计面积,报价单总金额,内部设计面积总金额,模板id,新建的报价单名称,最终报价,类型1设计类型 2建筑";

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

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.Long getDataCount() {
		return this.__data_count;
	}

	public void setDataCount( java.lang.Long value ) {
		this.__data_count = value;
	}

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return this.__interior_money_sum;
	}

	public void setInteriorMoneySum( java.math.BigDecimal value ) {
		this.__interior_money_sum = value;
	}

	public java.lang.Integer getOutTempletId() {
		return this.__out_templet_id;
	}

	public void setOutTempletId( java.lang.Integer value ) {
		this.__out_templet_id = value;
	}

	public java.lang.String getNewCreateQuotationName() {
		return this.__new_create_quotation_name;
	}

	public void setNewCreateQuotationName( java.lang.String value ) {
		this.__new_create_quotation_name = value;
	}

	public java.math.BigDecimal getFinalizedMoney() {
		return this.__finalized_money;
	}

	public void setFinalizedMoney( java.math.BigDecimal value ) {
		this.__finalized_money = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.util.List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detailOutDesignConsideration;
	}

	public void setDetailOutDesignConsideration( java.util.List<BaseOutDesignConsideration> value ) {
		this.__detailOutDesignConsideration = value;
	}

	public void cloneCopy(BaseSoutdesignconsiderationoor2 __bean){
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setDataCount(getDataCount());
		__bean.setDesignArea(getDesignArea());
		__bean.setMoneySum(getMoneySum());
		__bean.setInteriorMoneySum(getInteriorMoneySum());
		__bean.setOutTempletId(getOutTempletId());
		__bean.setNewCreateQuotationName(getNewCreateQuotationName());
		__bean.setFinalizedMoney(getFinalizedMoney());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getDataCount() == null ? "" : getDataCount());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		sb.append(",");
		sb.append(getOutTempletId() == null ? "" : getOutTempletId());
		sb.append(",");
		sb.append(getNewCreateQuotationName() == null ? "" : getNewCreateQuotationName());
		sb.append(",");
		sb.append(getFinalizedMoney() == null ? "" : getFinalizedMoney());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSoutdesignconsiderationoor2 o) {
		return __out_quotation_id == null ? -1 : __out_quotation_id.compareTo(o.getOutQuotationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__data_count);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__interior_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__out_templet_id);
		hash = 97 * hash + Objects.hashCode(this.__new_create_quotation_name);
		hash = 97 * hash + Objects.hashCode(this.__finalized_money);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSoutdesignconsiderationoor2 o = (BaseSoutdesignconsiderationoor2)obj;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__data_count, o.getDataCount())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__interior_money_sum, o.getInteriorMoneySum())) return false;
		if(!Objects.equals(this.__out_templet_id, o.getOutTempletId())) return false;
		if(!Objects.equals(this.__new_create_quotation_name, o.getNewCreateQuotationName())) return false;
		if(!Objects.equals(this.__finalized_money, o.getFinalizedMoney())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getDataCount() != null) sb.append(__wrapNumber(count++, "dataCount", getDataCount()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getInteriorMoneySum() != null) sb.append(__wrapDecimal(count++, "interiorMoneySum", getInteriorMoneySum()));
		if(getOutTempletId() != null) sb.append(__wrapNumber(count++, "outTempletId", getOutTempletId()));
		if(getNewCreateQuotationName() != null) sb.append(__wrapString(count++, "newCreateQuotationName", getNewCreateQuotationName()));
		if(getFinalizedMoney() != null) sb.append(__wrapDecimal(count++, "finalizedMoney", getFinalizedMoney()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getDetailOutDesignConsideration() != null)  sb.append(__wrapList(count++, "detailOutDesignConsideration", getDetailOutDesignConsideration()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getOutQuotationId() != null) res.put("outQuotationId", getOutQuotationId());
		if(getDataCount() != null) res.put("dataCount", getDataCount());
		if(getDesignArea() != null) res.put("designArea", getDesignArea());
		if(getMoneySum() != null) res.put("moneySum", getMoneySum());
		if(getInteriorMoneySum() != null) res.put("interiorMoneySum", getInteriorMoneySum());
		if(getOutTempletId() != null) res.put("outTempletId", getOutTempletId());
		if(getNewCreateQuotationName() != null) res.put("newCreateQuotationName", getNewCreateQuotationName());
		if(getFinalizedMoney() != null) res.put("finalizedMoney", getFinalizedMoney());
		if(getType() != null) res.put("type", getType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("dataCount")) != null) setDataCount(__getLong(val)); 
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("interiorMoneySum")) != null) setInteriorMoneySum(__getDecimal(val));  
		if((val = values.get("outTempletId")) != null) setOutTempletId(__getInt(val)); 
		if((val = values.get("newCreateQuotationName")) != null) setNewCreateQuotationName(__getString(val));
		if((val = values.get("finalizedMoney")) != null) setFinalizedMoney(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("detailOutDesignConsideration")) != null) setDetailOutDesignConsideration(__getList(val, BaseOutDesignConsideration.newInstance()));
	}

	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.Long  __data_count ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.math.BigDecimal  __interior_money_sum ;
	protected java.lang.Integer  __out_templet_id ;
	protected java.lang.String  __new_create_quotation_name ;
	protected java.math.BigDecimal  __finalized_money ;
	protected java.lang.Integer  __type ;
	protected java.util.List<BaseOutDesignConsideration> __detailOutDesignConsideration = null;
}
