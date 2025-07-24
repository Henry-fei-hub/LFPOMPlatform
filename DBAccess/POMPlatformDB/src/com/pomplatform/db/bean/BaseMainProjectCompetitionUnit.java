package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMainProjectCompetitionUnit extends GenericBase implements BaseFactory<BaseMainProjectCompetitionUnit>, Comparable<BaseMainProjectCompetitionUnit>
{


	public static BaseMainProjectCompetitionUnit newInstance(){
		return new BaseMainProjectCompetitionUnit();
	}

	@Override
	public BaseMainProjectCompetitionUnit make(){
		BaseMainProjectCompetitionUnit b = new BaseMainProjectCompetitionUnit();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_COMPETITION_UNIT_ID = "main_project_competition_unit_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_COMPETITION_UNIT_ID = "competition_unit_id" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_BIDDING_INFORMATION = "bidding_information" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,前期项目id,竞争单位,前期项目id,备注（报价/其他竞争信息）";

	public java.lang.Integer getMainProjectCompetitionUnitId() {
		return this.__main_project_competition_unit_id;
	}

	public void setMainProjectCompetitionUnitId( java.lang.Integer value ) {
		this.__main_project_competition_unit_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getCompetitionUnitId() {
		return this.__competition_unit_id;
	}

	public void setCompetitionUnitId( java.lang.Integer value ) {
		this.__competition_unit_id = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getBiddingInformation() {
		return this.__bidding_information;
	}

	public void setBiddingInformation( java.lang.String value ) {
		this.__bidding_information = value;
	}

	public void cloneCopy(BaseMainProjectCompetitionUnit __bean){
		__bean.setMainProjectCompetitionUnitId(getMainProjectCompetitionUnitId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCompetitionUnitId(getCompetitionUnitId());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setBiddingInformation(getBiddingInformation());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectCompetitionUnitId() == null ? "" : getMainProjectCompetitionUnitId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCompetitionUnitId() == null ? "" : getCompetitionUnitId());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getBiddingInformation() == null ? "" : getBiddingInformation());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectCompetitionUnit o) {
		return __main_project_competition_unit_id == null ? -1 : __main_project_competition_unit_id.compareTo(o.getMainProjectCompetitionUnitId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_competition_unit_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__competition_unit_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__bidding_information);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectCompetitionUnit o = (BaseMainProjectCompetitionUnit)obj;
		if(!Objects.equals(this.__main_project_competition_unit_id, o.getMainProjectCompetitionUnitId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__competition_unit_id, o.getCompetitionUnitId())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__bidding_information, o.getBiddingInformation())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectCompetitionUnitId() != null) sb.append(__wrapNumber(count++, "mainProjectCompetitionUnitId", getMainProjectCompetitionUnitId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCompetitionUnitId() != null) sb.append(__wrapNumber(count++, "competitionUnitId", getCompetitionUnitId()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getBiddingInformation() != null) sb.append(__wrapString(count++, "biddingInformation", getBiddingInformation()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectCompetitionUnitId() != null) res.put("mainProjectCompetitionUnitId", getMainProjectCompetitionUnitId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getCompetitionUnitId() != null) res.put("competitionUnitId", getCompetitionUnitId());
		if(getPreProjectId() != null) res.put("preProjectId", getPreProjectId());
		if(getBiddingInformation() != null) res.put("biddingInformation", getBiddingInformation());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectCompetitionUnitId")) != null) setMainProjectCompetitionUnitId(__getInt(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val));
		if((val = values.get("competitionUnitId")) != null) setCompetitionUnitId(__getInt(val));
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val));
		if((val = values.get("biddingInformation")) != null) setBiddingInformation(__getString(val));
	}

	protected java.lang.Integer  __main_project_competition_unit_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __competition_unit_id ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __bidding_information ;
}
