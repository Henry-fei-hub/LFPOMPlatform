package pomplatform.project.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnProjectManageStatus extends GenericBase implements BaseFactory<BaseOnProjectManageStatus>, Comparable<BaseOnProjectManageStatus> 
{


	public static BaseOnProjectManageStatus newInstance(){
		return new BaseOnProjectManageStatus();
	}

	@Override
	public BaseOnProjectManageStatus make(){
		BaseOnProjectManageStatus b = new BaseOnProjectManageStatus();
		return b;
	}

	public final static String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static String CS_INFO_CODE = "info_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_HAS_OUT_QUOTATIONS = "has_out_quotations" ;
	public final static String CS_HAS_SPLIT_PRICE = "has_split_price" ;
	public final static String CS_HAS_SEND_SHEET = "has_send_sheet" ;
	public final static String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static String CS_HAS_OUT_QUOTATIONS_TIME = "has_out_quotations_time" ;
	public final static String CS_HAS_SPLIT_PRICE_TIME = "has_split_price_time" ;
	public final static String CS_HAS_SEND_SHEET_TIME = "has_send_sheet_time" ;
	public final static String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static String CS_BID_TYPE = "bid_type" ;
	public final static String CS_WINNING_TIME = "winning_time" ;

	public final static String ALL_CAPTIONS = "主键编码,信息编号,项目名称,是否有报价单,是否有拆分价 true 有，反之,,正式立项时间,,有拆分价的时间,,立项依据0未知、  1投标立项、 2合同立项、  3委托函立项,对应于字典表128),中标时间";

	public Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( Integer value ) {
		this.__main_project_id = value;
	}

	public String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Boolean getHasOutQuotations() {
		return this.__has_out_quotations;
	}

	public void setHasOutQuotations( Boolean value ) {
		this.__has_out_quotations = value;
	}

	public Boolean getHasSplitPrice() {
		return this.__has_split_price;
	}

	public void setHasSplitPrice( Boolean value ) {
		this.__has_split_price = value;
	}

	public Boolean getHasSendSheet() {
		return this.__has_send_sheet;
	}

	public void setHasSendSheet( Boolean value ) {
		this.__has_send_sheet = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.util.Date getHasOutQuotationsTime() {
		return this.__has_out_quotations_time;
	}

	public void setHasOutQuotationsTime( java.util.Date value ) {
		this.__has_out_quotations_time = value;
	}

	public java.util.Date getHasSplitPriceTime() {
		return this.__has_split_price_time;
	}

	public void setHasSplitPriceTime( java.util.Date value ) {
		this.__has_split_price_time = value;
	}

	public java.util.Date getHasSendSheetTime() {
		return this.__has_send_sheet_time;
	}

	public void setHasSendSheetTime( java.util.Date value ) {
		this.__has_send_sheet_time = value;
	}

	public Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( Integer value ) {
		this.__project_base_on = value;
	}

	public Integer getBidType() {
		return this.__bid_type;
	}

	public void setBidType( Integer value ) {
		this.__bid_type = value;
	}

	public java.util.Date getWinningTime() {
		return this.__winning_time;
	}

	public void setWinningTime( java.util.Date value ) {
		this.__winning_time = value;
	}

	public void cloneCopy(BaseOnProjectManageStatus __bean){
		__bean.setMainProjectId(getMainProjectId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectName(getProjectName());
		__bean.setHasOutQuotations(getHasOutQuotations());
		__bean.setHasSplitPrice(getHasSplitPrice());
		__bean.setHasSendSheet(getHasSendSheet());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setHasOutQuotationsTime(getHasOutQuotationsTime());
		__bean.setHasSplitPriceTime(getHasSplitPriceTime());
		__bean.setHasSendSheetTime(getHasSendSheetTime());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setBidType(getBidType());
		__bean.setWinningTime(getWinningTime());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getHasOutQuotations() == null ? "" : getHasOutQuotations());
		sb.append(",");
		sb.append(getHasSplitPrice() == null ? "" : getHasSplitPrice());
		sb.append(",");
		sb.append(getHasSendSheet() == null ? "" : getHasSendSheet());
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getHasOutQuotationsTime() == null ? "" : sdf.format(getHasOutQuotationsTime()));
		sb.append(",");
		sb.append(getHasSplitPriceTime() == null ? "" : sdf.format(getHasSplitPriceTime()));
		sb.append(",");
		sb.append(getHasSendSheetTime() == null ? "" : sdf.format(getHasSendSheetTime()));
		sb.append(",");
		sb.append(getProjectBaseOn() == null ? "" : getProjectBaseOn());
		sb.append(",");
		sb.append(getBidType() == null ? "" : getBidType());
		sb.append(",");
		sb.append(getWinningTime() == null ? "" : sdf.format(getWinningTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnProjectManageStatus o) {
		return __main_project_id == null ? -1 : __main_project_id.compareTo(o.getMainProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__has_out_quotations);
		hash = 97 * hash + Objects.hashCode(this.__has_split_price);
		hash = 97 * hash + Objects.hashCode(this.__has_send_sheet);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__has_out_quotations_time);
		hash = 97 * hash + Objects.hashCode(this.__has_split_price_time);
		hash = 97 * hash + Objects.hashCode(this.__has_send_sheet_time);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__bid_type);
		hash = 97 * hash + Objects.hashCode(this.__winning_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnProjectManageStatus o = (BaseOnProjectManageStatus)obj;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__has_out_quotations, o.getHasOutQuotations())) return false;
		if(!Objects.equals(this.__has_split_price, o.getHasSplitPrice())) return false;
		if(!Objects.equals(this.__has_send_sheet, o.getHasSendSheet())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__has_out_quotations_time, o.getHasOutQuotationsTime())) return false;
		if(!Objects.equals(this.__has_split_price_time, o.getHasSplitPriceTime())) return false;
		if(!Objects.equals(this.__has_send_sheet_time, o.getHasSendSheetTime())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__bid_type, o.getBidType())) return false;
		if(!Objects.equals(this.__winning_time, o.getWinningTime())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getHasOutQuotations() != null) sb.append(__wrapBoolean(count++, "hasOutQuotations", getHasOutQuotations()));
		if(getHasSplitPrice() != null) sb.append(__wrapBoolean(count++, "hasSplitPrice", getHasSplitPrice()));
		if(getHasSendSheet() != null) sb.append(__wrapBoolean(count++, "hasSendSheet", getHasSendSheet()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getHasOutQuotationsTime() != null) sb.append(__wrapDate(count++, "hasOutQuotationsTime", getHasOutQuotationsTime()));
		if(getHasSplitPriceTime() != null) sb.append(__wrapDate(count++, "hasSplitPriceTime", getHasSplitPriceTime()));
		if(getHasSendSheetTime() != null) sb.append(__wrapDate(count++, "hasSendSheetTime", getHasSendSheetTime()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getBidType() != null) sb.append(__wrapNumber(count++, "bidType", getBidType()));
		if(getWinningTime() != null) sb.append(__wrapDate(count++, "winningTime", getWinningTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getHasOutQuotations() != null) res.put("hasOutQuotations", getHasOutQuotations());
		if(getHasSplitPrice() != null) res.put("hasSplitPrice", getHasSplitPrice());
		if(getHasSendSheet() != null) res.put("hasSendSheet", getHasSendSheet());
		if(getProjectApprovalTime() != null) res.put("projectApprovalTime", getProjectApprovalTime());
		if(getHasOutQuotationsTime() != null) res.put("hasOutQuotationsTime", getHasOutQuotationsTime());
		if(getHasSplitPriceTime() != null) res.put("hasSplitPriceTime", getHasSplitPriceTime());
		if(getHasSendSheetTime() != null) res.put("hasSendSheetTime", getHasSendSheetTime());
		if(getProjectBaseOn() != null) res.put("projectBaseOn", getProjectBaseOn());
		if(getBidType() != null) res.put("bidType", getBidType());
		if(getWinningTime() != null) res.put("winningTime", getWinningTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("hasOutQuotations")) != null) setHasOutQuotations(__getBoolean(val));
		if((val = values.get("hasSplitPrice")) != null) setHasSplitPrice(__getBoolean(val));
		if((val = values.get("hasSendSheet")) != null) setHasSendSheet(__getBoolean(val));
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("hasOutQuotationsTime")) != null) setHasOutQuotationsTime(__getDate(val)); 
		if((val = values.get("hasSplitPriceTime")) != null) setHasSplitPriceTime(__getDate(val)); 
		if((val = values.get("hasSendSheetTime")) != null) setHasSendSheetTime(__getDate(val)); 
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("bidType")) != null) setBidType(__getInt(val)); 
		if((val = values.get("winningTime")) != null) setWinningTime(__getDate(val)); 
	}

	protected Integer  __main_project_id ;
	protected String  __info_code ;
	protected String  __project_name ;
	protected Boolean  __has_out_quotations ;
	protected Boolean  __has_split_price ;
	protected Boolean  __has_send_sheet ;
	protected java.util.Date  __project_approval_time ;
	protected java.util.Date  __has_out_quotations_time ;
	protected java.util.Date  __has_split_price_time ;
	protected java.util.Date  __has_send_sheet_time ;
	protected Integer  __project_base_on ;
	protected Integer  __bid_type ;
	protected java.util.Date  __winning_time ;
}
