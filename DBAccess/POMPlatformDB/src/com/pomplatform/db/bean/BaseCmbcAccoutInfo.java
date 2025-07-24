package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCmbcAccoutInfo extends GenericBase implements BaseFactory<BaseCmbcAccoutInfo>, Comparable<BaseCmbcAccoutInfo> 
{


	public static BaseCmbcAccoutInfo newInstance(){
		return new BaseCmbcAccoutInfo();
	}

	@Override
	public BaseCmbcAccoutInfo make(){
		BaseCmbcAccoutInfo b = new BaseCmbcAccoutInfo();
		return b;
	}

	public final static java.lang.String CS_CMBC_ACCOUT_INFO_ID = "cmbc_accout_info_id" ;
	public final static java.lang.String CS_CCYNBR = "ccynbr" ;
	public final static java.lang.String CS_C_CCYNBR = "c_ccynbr" ;
	public final static java.lang.String CS_ACCITM = "accitm" ;
	public final static java.lang.String CS_BBKNBR = "bbknbr" ;
	public final static java.lang.String CS_ACCNBR = "accnbr" ;
	public final static java.lang.String CS_ACCNAM = "accnam" ;
	public final static java.lang.String CS_ACCBLV = "accblv" ;
	public final static java.lang.String CS_ONLBLV = "onlblv" ;
	public final static java.lang.String CS_HLDBLV = "hldblv" ;
	public final static java.lang.String CS_AVLBLV = "avlblv" ;
	public final static java.lang.String CS_LMTOVR = "lmtovr" ;
	public final static java.lang.String CS_STSCOD = "stscod" ;
	public final static java.lang.String CS_INTCOD = "intcod" ;
	public final static java.lang.String CS_C_INTRAT = "c_intrat" ;
	public final static java.lang.String CS_INTRAT = "intrat" ;
	public final static java.lang.String CS_OPNDAT = "opndat" ;
	public final static java.lang.String CS_MUTDAT = "mutdat" ;
	public final static java.lang.String CS_INTTYP = "inttyp" ;
	public final static java.lang.String CS_DPSTXT = "dpstxt" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,币种(对应cmbc_codes的cmbc_curreny),币种名称,科目代码,分行号,账号,户名,上日余额,联机余额,冻结余额,可用额度,透支额度,状态 A活动 B冻结 C关户,利息码 S子公司虚拟余额,年利率,年利率(I),开户日,到期日,利率类型码 cmbc_codes 利率类型码,存期,创建时间,修改时间";

	public java.lang.Integer getCmbcAccoutInfoId() {
		return this.__cmbc_accout_info_id;
	}

	public void setCmbcAccoutInfoId( java.lang.Integer value ) {
		this.__cmbc_accout_info_id = value;
	}

	public java.lang.String getCcynbr() {
		return this.__ccynbr;
	}

	public void setCcynbr( java.lang.String value ) {
		this.__ccynbr = value;
	}

	public java.lang.String getCCcynbr() {
		return this.__c_ccynbr;
	}

	public void setCCcynbr( java.lang.String value ) {
		this.__c_ccynbr = value;
	}

	public java.lang.String getAccitm() {
		return this.__accitm;
	}

	public void setAccitm( java.lang.String value ) {
		this.__accitm = value;
	}

	public java.lang.String getBbknbr() {
		return this.__bbknbr;
	}

	public void setBbknbr( java.lang.String value ) {
		this.__bbknbr = value;
	}

	public java.lang.String getAccnbr() {
		return this.__accnbr;
	}

	public void setAccnbr( java.lang.String value ) {
		this.__accnbr = value;
	}

	public java.lang.String getAccnam() {
		return this.__accnam;
	}

	public void setAccnam( java.lang.String value ) {
		this.__accnam = value;
	}

	public java.math.BigDecimal getAccblv() {
		return this.__accblv;
	}

	public void setAccblv( java.math.BigDecimal value ) {
		this.__accblv = value;
	}

	public java.math.BigDecimal getOnlblv() {
		return this.__onlblv;
	}

	public void setOnlblv( java.math.BigDecimal value ) {
		this.__onlblv = value;
	}

	public java.math.BigDecimal getHldblv() {
		return this.__hldblv;
	}

	public void setHldblv( java.math.BigDecimal value ) {
		this.__hldblv = value;
	}

	public java.math.BigDecimal getAvlblv() {
		return this.__avlblv;
	}

	public void setAvlblv( java.math.BigDecimal value ) {
		this.__avlblv = value;
	}

	public java.math.BigDecimal getLmtovr() {
		return this.__lmtovr;
	}

	public void setLmtovr( java.math.BigDecimal value ) {
		this.__lmtovr = value;
	}

	public java.lang.String getStscod() {
		return this.__stscod;
	}

	public void setStscod( java.lang.String value ) {
		this.__stscod = value;
	}

	public java.lang.String getIntcod() {
		return this.__intcod;
	}

	public void setIntcod( java.lang.String value ) {
		this.__intcod = value;
	}

	public java.lang.String getCIntrat() {
		return this.__c_intrat;
	}

	public void setCIntrat( java.lang.String value ) {
		this.__c_intrat = value;
	}

	public java.math.BigDecimal getIntrat() {
		return this.__intrat;
	}

	public void setIntrat( java.math.BigDecimal value ) {
		this.__intrat = value;
	}

	public java.util.Date getOpndat() {
		return this.__opndat;
	}

	public void setOpndat( java.util.Date value ) {
		this.__opndat = value;
	}

	public java.util.Date getMutdat() {
		return this.__mutdat;
	}

	public void setMutdat( java.util.Date value ) {
		this.__mutdat = value;
	}

	public java.lang.String getInttyp() {
		return this.__inttyp;
	}

	public void setInttyp( java.lang.String value ) {
		this.__inttyp = value;
	}

	public java.lang.String getDpstxt() {
		return this.__dpstxt;
	}

	public void setDpstxt( java.lang.String value ) {
		this.__dpstxt = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public void cloneCopy(BaseCmbcAccoutInfo __bean){
		__bean.setCmbcAccoutInfoId(getCmbcAccoutInfoId());
		__bean.setCcynbr(getCcynbr());
		__bean.setCCcynbr(getCCcynbr());
		__bean.setAccitm(getAccitm());
		__bean.setBbknbr(getBbknbr());
		__bean.setAccnbr(getAccnbr());
		__bean.setAccnam(getAccnam());
		__bean.setAccblv(getAccblv());
		__bean.setOnlblv(getOnlblv());
		__bean.setHldblv(getHldblv());
		__bean.setAvlblv(getAvlblv());
		__bean.setLmtovr(getLmtovr());
		__bean.setStscod(getStscod());
		__bean.setIntcod(getIntcod());
		__bean.setCIntrat(getCIntrat());
		__bean.setIntrat(getIntrat());
		__bean.setOpndat(getOpndat());
		__bean.setMutdat(getMutdat());
		__bean.setInttyp(getInttyp());
		__bean.setDpstxt(getDpstxt());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCmbcAccoutInfoId() == null ? "" : getCmbcAccoutInfoId());
		sb.append(",");
		sb.append(getCcynbr() == null ? "" : getCcynbr());
		sb.append(",");
		sb.append(getCCcynbr() == null ? "" : getCCcynbr());
		sb.append(",");
		sb.append(getAccitm() == null ? "" : getAccitm());
		sb.append(",");
		sb.append(getBbknbr() == null ? "" : getBbknbr());
		sb.append(",");
		sb.append(getAccnbr() == null ? "" : getAccnbr());
		sb.append(",");
		sb.append(getAccnam() == null ? "" : getAccnam());
		sb.append(",");
		sb.append(getAccblv() == null ? "" : getAccblv());
		sb.append(",");
		sb.append(getOnlblv() == null ? "" : getOnlblv());
		sb.append(",");
		sb.append(getHldblv() == null ? "" : getHldblv());
		sb.append(",");
		sb.append(getAvlblv() == null ? "" : getAvlblv());
		sb.append(",");
		sb.append(getLmtovr() == null ? "" : getLmtovr());
		sb.append(",");
		sb.append(getStscod() == null ? "" : getStscod());
		sb.append(",");
		sb.append(getIntcod() == null ? "" : getIntcod());
		sb.append(",");
		sb.append(getCIntrat() == null ? "" : getCIntrat());
		sb.append(",");
		sb.append(getIntrat() == null ? "" : getIntrat());
		sb.append(",");
		sb.append(getOpndat() == null ? "" : sdf.format(getOpndat()));
		sb.append(",");
		sb.append(getMutdat() == null ? "" : sdf.format(getMutdat()));
		sb.append(",");
		sb.append(getInttyp() == null ? "" : getInttyp());
		sb.append(",");
		sb.append(getDpstxt() == null ? "" : getDpstxt());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCmbcAccoutInfo o) {
		return __cmbc_accout_info_id == null ? -1 : __cmbc_accout_info_id.compareTo(o.getCmbcAccoutInfoId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cmbc_accout_info_id);
		hash = 97 * hash + Objects.hashCode(this.__ccynbr);
		hash = 97 * hash + Objects.hashCode(this.__c_ccynbr);
		hash = 97 * hash + Objects.hashCode(this.__accitm);
		hash = 97 * hash + Objects.hashCode(this.__bbknbr);
		hash = 97 * hash + Objects.hashCode(this.__accnbr);
		hash = 97 * hash + Objects.hashCode(this.__accnam);
		hash = 97 * hash + Objects.hashCode(this.__accblv);
		hash = 97 * hash + Objects.hashCode(this.__onlblv);
		hash = 97 * hash + Objects.hashCode(this.__hldblv);
		hash = 97 * hash + Objects.hashCode(this.__avlblv);
		hash = 97 * hash + Objects.hashCode(this.__lmtovr);
		hash = 97 * hash + Objects.hashCode(this.__stscod);
		hash = 97 * hash + Objects.hashCode(this.__intcod);
		hash = 97 * hash + Objects.hashCode(this.__c_intrat);
		hash = 97 * hash + Objects.hashCode(this.__intrat);
		hash = 97 * hash + Objects.hashCode(this.__opndat);
		hash = 97 * hash + Objects.hashCode(this.__mutdat);
		hash = 97 * hash + Objects.hashCode(this.__inttyp);
		hash = 97 * hash + Objects.hashCode(this.__dpstxt);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCmbcAccoutInfo o = (BaseCmbcAccoutInfo)obj;
		if(!Objects.equals(this.__cmbc_accout_info_id, o.getCmbcAccoutInfoId())) return false;
		if(!Objects.equals(this.__ccynbr, o.getCcynbr())) return false;
		if(!Objects.equals(this.__c_ccynbr, o.getCCcynbr())) return false;
		if(!Objects.equals(this.__accitm, o.getAccitm())) return false;
		if(!Objects.equals(this.__bbknbr, o.getBbknbr())) return false;
		if(!Objects.equals(this.__accnbr, o.getAccnbr())) return false;
		if(!Objects.equals(this.__accnam, o.getAccnam())) return false;
		if(!Objects.equals(this.__accblv, o.getAccblv())) return false;
		if(!Objects.equals(this.__onlblv, o.getOnlblv())) return false;
		if(!Objects.equals(this.__hldblv, o.getHldblv())) return false;
		if(!Objects.equals(this.__avlblv, o.getAvlblv())) return false;
		if(!Objects.equals(this.__lmtovr, o.getLmtovr())) return false;
		if(!Objects.equals(this.__stscod, o.getStscod())) return false;
		if(!Objects.equals(this.__intcod, o.getIntcod())) return false;
		if(!Objects.equals(this.__c_intrat, o.getCIntrat())) return false;
		if(!Objects.equals(this.__intrat, o.getIntrat())) return false;
		if(!Objects.equals(this.__opndat, o.getOpndat())) return false;
		if(!Objects.equals(this.__mutdat, o.getMutdat())) return false;
		if(!Objects.equals(this.__inttyp, o.getInttyp())) return false;
		if(!Objects.equals(this.__dpstxt, o.getDpstxt())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCmbcAccoutInfoId() != null) sb.append(__wrapNumber(count++, "cmbcAccoutInfoId", getCmbcAccoutInfoId()));
		if(getCcynbr() != null) sb.append(__wrapString(count++, "ccynbr", getCcynbr()));
		if(getCCcynbr() != null) sb.append(__wrapString(count++, "cCcynbr", getCCcynbr()));
		if(getAccitm() != null) sb.append(__wrapString(count++, "accitm", getAccitm()));
		if(getBbknbr() != null) sb.append(__wrapString(count++, "bbknbr", getBbknbr()));
		if(getAccnbr() != null) sb.append(__wrapString(count++, "accnbr", getAccnbr()));
		if(getAccnam() != null) sb.append(__wrapString(count++, "accnam", getAccnam()));
		if(getAccblv() != null) sb.append(__wrapDecimal(count++, "accblv", getAccblv()));
		if(getOnlblv() != null) sb.append(__wrapDecimal(count++, "onlblv", getOnlblv()));
		if(getHldblv() != null) sb.append(__wrapDecimal(count++, "hldblv", getHldblv()));
		if(getAvlblv() != null) sb.append(__wrapDecimal(count++, "avlblv", getAvlblv()));
		if(getLmtovr() != null) sb.append(__wrapDecimal(count++, "lmtovr", getLmtovr()));
		if(getStscod() != null) sb.append(__wrapString(count++, "stscod", getStscod()));
		if(getIntcod() != null) sb.append(__wrapString(count++, "intcod", getIntcod()));
		if(getCIntrat() != null) sb.append(__wrapString(count++, "cIntrat", getCIntrat()));
		if(getIntrat() != null) sb.append(__wrapDecimal(count++, "intrat", getIntrat()));
		if(getOpndat() != null) sb.append(__wrapDate(count++, "opndat", getOpndat()));
		if(getMutdat() != null) sb.append(__wrapDate(count++, "mutdat", getMutdat()));
		if(getInttyp() != null) sb.append(__wrapString(count++, "inttyp", getInttyp()));
		if(getDpstxt() != null) sb.append(__wrapString(count++, "dpstxt", getDpstxt()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cmbcAccoutInfoId")) != null) setCmbcAccoutInfoId(__getInt(val)); 
		if((val = values.get("ccynbr")) != null) setCcynbr(__getString(val));
		if((val = values.get("cCcynbr")) != null) setCCcynbr(__getString(val));
		if((val = values.get("accitm")) != null) setAccitm(__getString(val));
		if((val = values.get("bbknbr")) != null) setBbknbr(__getString(val));
		if((val = values.get("accnbr")) != null) setAccnbr(__getString(val));
		if((val = values.get("accnam")) != null) setAccnam(__getString(val));
		if((val = values.get("accblv")) != null) setAccblv(__getDecimal(val));  
		if((val = values.get("onlblv")) != null) setOnlblv(__getDecimal(val));  
		if((val = values.get("hldblv")) != null) setHldblv(__getDecimal(val));  
		if((val = values.get("avlblv")) != null) setAvlblv(__getDecimal(val));  
		if((val = values.get("lmtovr")) != null) setLmtovr(__getDecimal(val));  
		if((val = values.get("stscod")) != null) setStscod(__getString(val));
		if((val = values.get("intcod")) != null) setIntcod(__getString(val));
		if((val = values.get("cIntrat")) != null) setCIntrat(__getString(val));
		if((val = values.get("intrat")) != null) setIntrat(__getDecimal(val));  
		if((val = values.get("opndat")) != null) setOpndat(__getDate(val)); 
		if((val = values.get("mutdat")) != null) setMutdat(__getDate(val)); 
		if((val = values.get("inttyp")) != null) setInttyp(__getString(val));
		if((val = values.get("dpstxt")) != null) setDpstxt(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cmbc_accout_info_id ;
	protected java.lang.String  __ccynbr ;
	protected java.lang.String  __c_ccynbr ;
	protected java.lang.String  __accitm ;
	protected java.lang.String  __bbknbr ;
	protected java.lang.String  __accnbr ;
	protected java.lang.String  __accnam ;
	protected java.math.BigDecimal  __accblv ;
	protected java.math.BigDecimal  __onlblv ;
	protected java.math.BigDecimal  __hldblv ;
	protected java.math.BigDecimal  __avlblv ;
	protected java.math.BigDecimal  __lmtovr ;
	protected java.lang.String  __stscod ;
	protected java.lang.String  __intcod ;
	protected java.lang.String  __c_intrat ;
	protected java.math.BigDecimal  __intrat ;
	protected java.util.Date  __opndat ;
	protected java.util.Date  __mutdat ;
	protected java.lang.String  __inttyp ;
	protected java.lang.String  __dpstxt ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
}
