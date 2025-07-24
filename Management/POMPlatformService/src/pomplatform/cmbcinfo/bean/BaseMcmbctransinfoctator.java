package pomplatform.cmbcinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcmbctransinfoctator extends GenericBase implements BaseFactory<BaseMcmbctransinfoctator>, Comparable<BaseMcmbctransinfoctator> 
{


	public static BaseMcmbctransinfoctator newInstance(){
		return new BaseMcmbctransinfoctator();
	}

	@Override
	public BaseMcmbctransinfoctator make(){
		BaseMcmbctransinfoctator b = new BaseMcmbctransinfoctator();
		return b;
	}

	public final static java.lang.String CS_CMBC_TRANS_INFO_ID = "cmbc_trans_info_id" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_ACCNAM = "accnam" ;
	public final static java.lang.String CS_ETYDAT = "etydat" ;
	public final static java.lang.String CS_ETYTIM = "etytim" ;
	public final static java.lang.String CS_TRANS_DATE = "trans_date" ;
	public final static java.lang.String CS_VLTDAT = "vltdat" ;
	public final static java.lang.String CS_TRSCOD = "trscod" ;
	public final static java.lang.String CS_NARYUR = "naryur" ;
	public final static java.lang.String CS_TRSAMTD = "trsamtd" ;
	public final static java.lang.String CS_TRSAMTC = "trsamtc" ;
	public final static java.lang.String CS_AMTCDR = "amtcdr" ;
	public final static java.lang.String CS_TRSBLV = "trsblv" ;
	public final static java.lang.String CS_REFNBR = "refnbr" ;
	public final static java.lang.String CS_REQNBR = "reqnbr" ;
	public final static java.lang.String CS_BUSNAM = "busnam" ;
	public final static java.lang.String CS_NUSAGE = "nusage" ;
	public final static java.lang.String CS_YURREF = "yurref" ;
	public final static java.lang.String CS_BUSNAR = "busnar" ;
	public final static java.lang.String CS_OTRNAR = "otrnar" ;
	public final static java.lang.String CS_C_RPYBBK = "c_rpybbk" ;
	public final static java.lang.String CS_RPYNAM = "rpynam" ;
	public final static java.lang.String CS_RPYACC = "rpyacc" ;
	public final static java.lang.String CS_RPYBBN = "rpybbn" ;
	public final static java.lang.String CS_RPYBNK = "rpybnk" ;
	public final static java.lang.String CS_RPYADR = "rpyadr" ;
	public final static java.lang.String CS_C_GSBBBK = "c_gsbbbk" ;
	public final static java.lang.String CS_GSBACC = "gsbacc" ;
	public final static java.lang.String CS_GSBNAM = "gsbnam" ;
	public final static java.lang.String CS_INFFLG = "infflg" ;
	public final static java.lang.String CS_ATHFLG = "athflg" ;
	public final static java.lang.String CS_CHKNBR = "chknbr" ;
	public final static java.lang.String CS_RSVFLG = "rsvflg" ;
	public final static java.lang.String CS_NAREXT = "narext" ;
	public final static java.lang.String CS_TRSANL = "trsanl" ;
	public final static java.lang.String CS_REFSUB = "refsub" ;
	public final static java.lang.String CS_FRMCOD = "frmcod" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_COMPANY_RECORD_ID = "company_record_id" ;

	public final static java.lang.String ALL_CAPTIONS = "cmbc_trans_info_id,银行账号(用来标识该条流水是哪个账号),户名,交易日,交易时间(时分秒181211 时才有准确性),交易时间,起息日,交易类型 cmbc_codes trans_code,摘要,借方金额,贷方金额,借贷标记 C贷 D借,余额,流水号,流程实例号,业务名称,用途,业务参考号,业务摘要,其它摘要,收/付方开户地区,收/付方名称,收/付方帐号,收/付方开户行行号,收/付方开户行名,收/付方开户行地址,母/子公司所在地区,母/子公司帐号,gsbnam,1表示收方帐号和子公司；为2表示收方帐号和母公司；为3表示原收方帐号和子公司,有否附件信息标志,票据号,冲账标志 *为冲帐 X为补帐,扩展摘要,交易分析码,商务支付订单号,企业识别码,创建时间,修改时间,主键编码";

	public java.lang.Integer getCmbcTransInfoId() {
		return this.__cmbc_trans_info_id;
	}

	public void setCmbcTransInfoId( java.lang.Integer value ) {
		this.__cmbc_trans_info_id = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getAccnam() {
		return this.__accnam;
	}

	public void setAccnam( java.lang.String value ) {
		this.__accnam = value;
	}

	public java.lang.String getEtydat() {
		return this.__etydat;
	}

	public void setEtydat( java.lang.String value ) {
		this.__etydat = value;
	}

	public java.lang.String getEtytim() {
		return this.__etytim;
	}

	public void setEtytim( java.lang.String value ) {
		this.__etytim = value;
	}

	public java.util.Date getTransDate() {
		return this.__trans_date;
	}

	public void setTransDate( java.util.Date value ) {
		this.__trans_date = value;
	}

	public java.util.Date getVltdat() {
		return this.__vltdat;
	}

	public void setVltdat( java.util.Date value ) {
		this.__vltdat = value;
	}

	public java.lang.String getTrscod() {
		return this.__trscod;
	}

	public void setTrscod( java.lang.String value ) {
		this.__trscod = value;
	}

	public java.lang.String getNaryur() {
		return this.__naryur;
	}

	public void setNaryur( java.lang.String value ) {
		this.__naryur = value;
	}

	public java.math.BigDecimal getTrsamtd() {
		return this.__trsamtd;
	}

	public void setTrsamtd( java.math.BigDecimal value ) {
		this.__trsamtd = value;
	}

	public java.math.BigDecimal getTrsamtc() {
		return this.__trsamtc;
	}

	public void setTrsamtc( java.math.BigDecimal value ) {
		this.__trsamtc = value;
	}

	public java.lang.String getAmtcdr() {
		return this.__amtcdr;
	}

	public void setAmtcdr( java.lang.String value ) {
		this.__amtcdr = value;
	}

	public java.math.BigDecimal getTrsblv() {
		return this.__trsblv;
	}

	public void setTrsblv( java.math.BigDecimal value ) {
		this.__trsblv = value;
	}

	public java.lang.String getRefnbr() {
		return this.__refnbr;
	}

	public void setRefnbr( java.lang.String value ) {
		this.__refnbr = value;
	}

	public java.lang.String getReqnbr() {
		return this.__reqnbr;
	}

	public void setReqnbr( java.lang.String value ) {
		this.__reqnbr = value;
	}

	public java.lang.String getBusnam() {
		return this.__busnam;
	}

	public void setBusnam( java.lang.String value ) {
		this.__busnam = value;
	}

	public java.lang.String getNusage() {
		return this.__nusage;
	}

	public void setNusage( java.lang.String value ) {
		this.__nusage = value;
	}

	public java.lang.String getYurref() {
		return this.__yurref;
	}

	public void setYurref( java.lang.String value ) {
		this.__yurref = value;
	}

	public java.lang.String getBusnar() {
		return this.__busnar;
	}

	public void setBusnar( java.lang.String value ) {
		this.__busnar = value;
	}

	public java.lang.String getOtrnar() {
		return this.__otrnar;
	}

	public void setOtrnar( java.lang.String value ) {
		this.__otrnar = value;
	}

	public java.lang.String getCRpybbk() {
		return this.__c_rpybbk;
	}

	public void setCRpybbk( java.lang.String value ) {
		this.__c_rpybbk = value;
	}

	public java.lang.String getRpynam() {
		return this.__rpynam;
	}

	public void setRpynam( java.lang.String value ) {
		this.__rpynam = value;
	}

	public java.lang.String getRpyacc() {
		return this.__rpyacc;
	}

	public void setRpyacc( java.lang.String value ) {
		this.__rpyacc = value;
	}

	public java.lang.String getRpybbn() {
		return this.__rpybbn;
	}

	public void setRpybbn( java.lang.String value ) {
		this.__rpybbn = value;
	}

	public java.lang.String getRpybnk() {
		return this.__rpybnk;
	}

	public void setRpybnk( java.lang.String value ) {
		this.__rpybnk = value;
	}

	public java.lang.String getRpyadr() {
		return this.__rpyadr;
	}

	public void setRpyadr( java.lang.String value ) {
		this.__rpyadr = value;
	}

	public java.lang.String getCGsbbbk() {
		return this.__c_gsbbbk;
	}

	public void setCGsbbbk( java.lang.String value ) {
		this.__c_gsbbbk = value;
	}

	public java.lang.String getGsbacc() {
		return this.__gsbacc;
	}

	public void setGsbacc( java.lang.String value ) {
		this.__gsbacc = value;
	}

	public java.lang.String getGsbnam() {
		return this.__gsbnam;
	}

	public void setGsbnam( java.lang.String value ) {
		this.__gsbnam = value;
	}

	public java.lang.Integer getInfflg() {
		return this.__infflg;
	}

	public void setInfflg( java.lang.Integer value ) {
		this.__infflg = value;
	}

	public java.lang.String getAthflg() {
		return this.__athflg;
	}

	public void setAthflg( java.lang.String value ) {
		this.__athflg = value;
	}

	public java.lang.String getChknbr() {
		return this.__chknbr;
	}

	public void setChknbr( java.lang.String value ) {
		this.__chknbr = value;
	}

	public java.lang.String getRsvflg() {
		return this.__rsvflg;
	}

	public void setRsvflg( java.lang.String value ) {
		this.__rsvflg = value;
	}

	public java.lang.String getNarext() {
		return this.__narext;
	}

	public void setNarext( java.lang.String value ) {
		this.__narext = value;
	}

	public java.lang.String getTrsanl() {
		return this.__trsanl;
	}

	public void setTrsanl( java.lang.String value ) {
		this.__trsanl = value;
	}

	public java.lang.String getRefsub() {
		return this.__refsub;
	}

	public void setRefsub( java.lang.String value ) {
		this.__refsub = value;
	}

	public java.lang.String getFrmcod() {
		return this.__frmcod;
	}

	public void setFrmcod( java.lang.String value ) {
		this.__frmcod = value;
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

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public void cloneCopy(BaseMcmbctransinfoctator __bean){
		__bean.setCmbcTransInfoId(getCmbcTransInfoId());
		__bean.setBankAccount(getBankAccount());
		__bean.setAccnam(getAccnam());
		__bean.setEtydat(getEtydat());
		__bean.setEtytim(getEtytim());
		__bean.setTransDate(getTransDate());
		__bean.setVltdat(getVltdat());
		__bean.setTrscod(getTrscod());
		__bean.setNaryur(getNaryur());
		__bean.setTrsamtd(getTrsamtd());
		__bean.setTrsamtc(getTrsamtc());
		__bean.setAmtcdr(getAmtcdr());
		__bean.setTrsblv(getTrsblv());
		__bean.setRefnbr(getRefnbr());
		__bean.setReqnbr(getReqnbr());
		__bean.setBusnam(getBusnam());
		__bean.setNusage(getNusage());
		__bean.setYurref(getYurref());
		__bean.setBusnar(getBusnar());
		__bean.setOtrnar(getOtrnar());
		__bean.setCRpybbk(getCRpybbk());
		__bean.setRpynam(getRpynam());
		__bean.setRpyacc(getRpyacc());
		__bean.setRpybbn(getRpybbn());
		__bean.setRpybnk(getRpybnk());
		__bean.setRpyadr(getRpyadr());
		__bean.setCGsbbbk(getCGsbbbk());
		__bean.setGsbacc(getGsbacc());
		__bean.setGsbnam(getGsbnam());
		__bean.setInfflg(getInfflg());
		__bean.setAthflg(getAthflg());
		__bean.setChknbr(getChknbr());
		__bean.setRsvflg(getRsvflg());
		__bean.setNarext(getNarext());
		__bean.setTrsanl(getTrsanl());
		__bean.setRefsub(getRefsub());
		__bean.setFrmcod(getFrmcod());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setCompanyRecordId(getCompanyRecordId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCmbcTransInfoId() == null ? "" : getCmbcTransInfoId());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getAccnam() == null ? "" : getAccnam());
		sb.append(",");
		sb.append(getEtydat() == null ? "" : getEtydat());
		sb.append(",");
		sb.append(getEtytim() == null ? "" : getEtytim());
		sb.append(",");
		sb.append(getTransDate() == null ? "" : sdf.format(getTransDate()));
		sb.append(",");
		sb.append(getVltdat() == null ? "" : sdf.format(getVltdat()));
		sb.append(",");
		sb.append(getTrscod() == null ? "" : getTrscod());
		sb.append(",");
		sb.append(getNaryur() == null ? "" : getNaryur());
		sb.append(",");
		sb.append(getTrsamtd() == null ? "" : getTrsamtd());
		sb.append(",");
		sb.append(getTrsamtc() == null ? "" : getTrsamtc());
		sb.append(",");
		sb.append(getAmtcdr() == null ? "" : getAmtcdr());
		sb.append(",");
		sb.append(getTrsblv() == null ? "" : getTrsblv());
		sb.append(",");
		sb.append(getRefnbr() == null ? "" : getRefnbr());
		sb.append(",");
		sb.append(getReqnbr() == null ? "" : getReqnbr());
		sb.append(",");
		sb.append(getBusnam() == null ? "" : getBusnam());
		sb.append(",");
		sb.append(getNusage() == null ? "" : getNusage());
		sb.append(",");
		sb.append(getYurref() == null ? "" : getYurref());
		sb.append(",");
		sb.append(getBusnar() == null ? "" : getBusnar());
		sb.append(",");
		sb.append(getOtrnar() == null ? "" : getOtrnar());
		sb.append(",");
		sb.append(getCRpybbk() == null ? "" : getCRpybbk());
		sb.append(",");
		sb.append(getRpynam() == null ? "" : getRpynam());
		sb.append(",");
		sb.append(getRpyacc() == null ? "" : getRpyacc());
		sb.append(",");
		sb.append(getRpybbn() == null ? "" : getRpybbn());
		sb.append(",");
		sb.append(getRpybnk() == null ? "" : getRpybnk());
		sb.append(",");
		sb.append(getRpyadr() == null ? "" : getRpyadr());
		sb.append(",");
		sb.append(getCGsbbbk() == null ? "" : getCGsbbbk());
		sb.append(",");
		sb.append(getGsbacc() == null ? "" : getGsbacc());
		sb.append(",");
		sb.append(getGsbnam() == null ? "" : getGsbnam());
		sb.append(",");
		sb.append(getInfflg() == null ? "" : getInfflg());
		sb.append(",");
		sb.append(getAthflg() == null ? "" : getAthflg());
		sb.append(",");
		sb.append(getChknbr() == null ? "" : getChknbr());
		sb.append(",");
		sb.append(getRsvflg() == null ? "" : getRsvflg());
		sb.append(",");
		sb.append(getNarext() == null ? "" : getNarext());
		sb.append(",");
		sb.append(getTrsanl() == null ? "" : getTrsanl());
		sb.append(",");
		sb.append(getRefsub() == null ? "" : getRefsub());
		sb.append(",");
		sb.append(getFrmcod() == null ? "" : getFrmcod());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getCompanyRecordId() == null ? "" : getCompanyRecordId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcmbctransinfoctator o) {
		return __cmbc_trans_info_id == null ? -1 : __cmbc_trans_info_id.compareTo(o.getCmbcTransInfoId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cmbc_trans_info_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__accnam);
		hash = 97 * hash + Objects.hashCode(this.__etydat);
		hash = 97 * hash + Objects.hashCode(this.__etytim);
		hash = 97 * hash + Objects.hashCode(this.__trans_date);
		hash = 97 * hash + Objects.hashCode(this.__vltdat);
		hash = 97 * hash + Objects.hashCode(this.__trscod);
		hash = 97 * hash + Objects.hashCode(this.__naryur);
		hash = 97 * hash + Objects.hashCode(this.__trsamtd);
		hash = 97 * hash + Objects.hashCode(this.__trsamtc);
		hash = 97 * hash + Objects.hashCode(this.__amtcdr);
		hash = 97 * hash + Objects.hashCode(this.__trsblv);
		hash = 97 * hash + Objects.hashCode(this.__refnbr);
		hash = 97 * hash + Objects.hashCode(this.__reqnbr);
		hash = 97 * hash + Objects.hashCode(this.__busnam);
		hash = 97 * hash + Objects.hashCode(this.__nusage);
		hash = 97 * hash + Objects.hashCode(this.__yurref);
		hash = 97 * hash + Objects.hashCode(this.__busnar);
		hash = 97 * hash + Objects.hashCode(this.__otrnar);
		hash = 97 * hash + Objects.hashCode(this.__c_rpybbk);
		hash = 97 * hash + Objects.hashCode(this.__rpynam);
		hash = 97 * hash + Objects.hashCode(this.__rpyacc);
		hash = 97 * hash + Objects.hashCode(this.__rpybbn);
		hash = 97 * hash + Objects.hashCode(this.__rpybnk);
		hash = 97 * hash + Objects.hashCode(this.__rpyadr);
		hash = 97 * hash + Objects.hashCode(this.__c_gsbbbk);
		hash = 97 * hash + Objects.hashCode(this.__gsbacc);
		hash = 97 * hash + Objects.hashCode(this.__gsbnam);
		hash = 97 * hash + Objects.hashCode(this.__infflg);
		hash = 97 * hash + Objects.hashCode(this.__athflg);
		hash = 97 * hash + Objects.hashCode(this.__chknbr);
		hash = 97 * hash + Objects.hashCode(this.__rsvflg);
		hash = 97 * hash + Objects.hashCode(this.__narext);
		hash = 97 * hash + Objects.hashCode(this.__trsanl);
		hash = 97 * hash + Objects.hashCode(this.__refsub);
		hash = 97 * hash + Objects.hashCode(this.__frmcod);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__company_record_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcmbctransinfoctator o = (BaseMcmbctransinfoctator)obj;
		if(!Objects.equals(this.__cmbc_trans_info_id, o.getCmbcTransInfoId())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__accnam, o.getAccnam())) return false;
		if(!Objects.equals(this.__etydat, o.getEtydat())) return false;
		if(!Objects.equals(this.__etytim, o.getEtytim())) return false;
		if(!Objects.equals(this.__trans_date, o.getTransDate())) return false;
		if(!Objects.equals(this.__vltdat, o.getVltdat())) return false;
		if(!Objects.equals(this.__trscod, o.getTrscod())) return false;
		if(!Objects.equals(this.__naryur, o.getNaryur())) return false;
		if(!Objects.equals(this.__trsamtd, o.getTrsamtd())) return false;
		if(!Objects.equals(this.__trsamtc, o.getTrsamtc())) return false;
		if(!Objects.equals(this.__amtcdr, o.getAmtcdr())) return false;
		if(!Objects.equals(this.__trsblv, o.getTrsblv())) return false;
		if(!Objects.equals(this.__refnbr, o.getRefnbr())) return false;
		if(!Objects.equals(this.__reqnbr, o.getReqnbr())) return false;
		if(!Objects.equals(this.__busnam, o.getBusnam())) return false;
		if(!Objects.equals(this.__nusage, o.getNusage())) return false;
		if(!Objects.equals(this.__yurref, o.getYurref())) return false;
		if(!Objects.equals(this.__busnar, o.getBusnar())) return false;
		if(!Objects.equals(this.__otrnar, o.getOtrnar())) return false;
		if(!Objects.equals(this.__c_rpybbk, o.getCRpybbk())) return false;
		if(!Objects.equals(this.__rpynam, o.getRpynam())) return false;
		if(!Objects.equals(this.__rpyacc, o.getRpyacc())) return false;
		if(!Objects.equals(this.__rpybbn, o.getRpybbn())) return false;
		if(!Objects.equals(this.__rpybnk, o.getRpybnk())) return false;
		if(!Objects.equals(this.__rpyadr, o.getRpyadr())) return false;
		if(!Objects.equals(this.__c_gsbbbk, o.getCGsbbbk())) return false;
		if(!Objects.equals(this.__gsbacc, o.getGsbacc())) return false;
		if(!Objects.equals(this.__gsbnam, o.getGsbnam())) return false;
		if(!Objects.equals(this.__infflg, o.getInfflg())) return false;
		if(!Objects.equals(this.__athflg, o.getAthflg())) return false;
		if(!Objects.equals(this.__chknbr, o.getChknbr())) return false;
		if(!Objects.equals(this.__rsvflg, o.getRsvflg())) return false;
		if(!Objects.equals(this.__narext, o.getNarext())) return false;
		if(!Objects.equals(this.__trsanl, o.getTrsanl())) return false;
		if(!Objects.equals(this.__refsub, o.getRefsub())) return false;
		if(!Objects.equals(this.__frmcod, o.getFrmcod())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__company_record_id, o.getCompanyRecordId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCmbcTransInfoId() != null) sb.append(__wrapNumber(count++, "cmbcTransInfoId", getCmbcTransInfoId()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getAccnam() != null) sb.append(__wrapString(count++, "accnam", getAccnam()));
		if(getEtydat() != null) sb.append(__wrapString(count++, "etydat", getEtydat()));
		if(getEtytim() != null) sb.append(__wrapString(count++, "etytim", getEtytim()));
		if(getTransDate() != null) sb.append(__wrapDate(count++, "transDate", getTransDate()));
		if(getVltdat() != null) sb.append(__wrapDate(count++, "vltdat", getVltdat()));
		if(getTrscod() != null) sb.append(__wrapString(count++, "trscod", getTrscod()));
		if(getNaryur() != null) sb.append(__wrapString(count++, "naryur", getNaryur()));
		if(getTrsamtd() != null) sb.append(__wrapDecimal(count++, "trsamtd", getTrsamtd()));
		if(getTrsamtc() != null) sb.append(__wrapDecimal(count++, "trsamtc", getTrsamtc()));
		if(getAmtcdr() != null) sb.append(__wrapString(count++, "amtcdr", getAmtcdr()));
		if(getTrsblv() != null) sb.append(__wrapDecimal(count++, "trsblv", getTrsblv()));
		if(getRefnbr() != null) sb.append(__wrapString(count++, "refnbr", getRefnbr()));
		if(getReqnbr() != null) sb.append(__wrapString(count++, "reqnbr", getReqnbr()));
		if(getBusnam() != null) sb.append(__wrapString(count++, "busnam", getBusnam()));
		if(getNusage() != null) sb.append(__wrapString(count++, "nusage", getNusage()));
		if(getYurref() != null) sb.append(__wrapString(count++, "yurref", getYurref()));
		if(getBusnar() != null) sb.append(__wrapString(count++, "busnar", getBusnar()));
		if(getOtrnar() != null) sb.append(__wrapString(count++, "otrnar", getOtrnar()));
		if(getCRpybbk() != null) sb.append(__wrapString(count++, "cRpybbk", getCRpybbk()));
		if(getRpynam() != null) sb.append(__wrapString(count++, "rpynam", getRpynam()));
		if(getRpyacc() != null) sb.append(__wrapString(count++, "rpyacc", getRpyacc()));
		if(getRpybbn() != null) sb.append(__wrapString(count++, "rpybbn", getRpybbn()));
		if(getRpybnk() != null) sb.append(__wrapString(count++, "rpybnk", getRpybnk()));
		if(getRpyadr() != null) sb.append(__wrapString(count++, "rpyadr", getRpyadr()));
		if(getCGsbbbk() != null) sb.append(__wrapString(count++, "cGsbbbk", getCGsbbbk()));
		if(getGsbacc() != null) sb.append(__wrapString(count++, "gsbacc", getGsbacc()));
		if(getGsbnam() != null) sb.append(__wrapString(count++, "gsbnam", getGsbnam()));
		if(getInfflg() != null) sb.append(__wrapNumber(count++, "infflg", getInfflg()));
		if(getAthflg() != null) sb.append(__wrapString(count++, "athflg", getAthflg()));
		if(getChknbr() != null) sb.append(__wrapString(count++, "chknbr", getChknbr()));
		if(getRsvflg() != null) sb.append(__wrapString(count++, "rsvflg", getRsvflg()));
		if(getNarext() != null) sb.append(__wrapString(count++, "narext", getNarext()));
		if(getTrsanl() != null) sb.append(__wrapString(count++, "trsanl", getTrsanl()));
		if(getRefsub() != null) sb.append(__wrapString(count++, "refsub", getRefsub()));
		if(getFrmcod() != null) sb.append(__wrapString(count++, "frmcod", getFrmcod()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(count++, "companyRecordId", getCompanyRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cmbcTransInfoId")) != null) setCmbcTransInfoId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("accnam")) != null) setAccnam(__getString(val));
		if((val = values.get("etydat")) != null) setEtydat(__getString(val));
		if((val = values.get("etytim")) != null) setEtytim(__getString(val));
		if((val = values.get("transDate")) != null) setTransDate(__getDate(val)); 
		if((val = values.get("vltdat")) != null) setVltdat(__getDate(val)); 
		if((val = values.get("trscod")) != null) setTrscod(__getString(val));
		if((val = values.get("naryur")) != null) setNaryur(__getString(val));
		if((val = values.get("trsamtd")) != null) setTrsamtd(__getDecimal(val));  
		if((val = values.get("trsamtc")) != null) setTrsamtc(__getDecimal(val));  
		if((val = values.get("amtcdr")) != null) setAmtcdr(__getString(val));
		if((val = values.get("trsblv")) != null) setTrsblv(__getDecimal(val));  
		if((val = values.get("refnbr")) != null) setRefnbr(__getString(val));
		if((val = values.get("reqnbr")) != null) setReqnbr(__getString(val));
		if((val = values.get("busnam")) != null) setBusnam(__getString(val));
		if((val = values.get("nusage")) != null) setNusage(__getString(val));
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("busnar")) != null) setBusnar(__getString(val));
		if((val = values.get("otrnar")) != null) setOtrnar(__getString(val));
		if((val = values.get("cRpybbk")) != null) setCRpybbk(__getString(val));
		if((val = values.get("rpynam")) != null) setRpynam(__getString(val));
		if((val = values.get("rpyacc")) != null) setRpyacc(__getString(val));
		if((val = values.get("rpybbn")) != null) setRpybbn(__getString(val));
		if((val = values.get("rpybnk")) != null) setRpybnk(__getString(val));
		if((val = values.get("rpyadr")) != null) setRpyadr(__getString(val));
		if((val = values.get("cGsbbbk")) != null) setCGsbbbk(__getString(val));
		if((val = values.get("gsbacc")) != null) setGsbacc(__getString(val));
		if((val = values.get("gsbnam")) != null) setGsbnam(__getString(val));
		if((val = values.get("infflg")) != null) setInfflg(__getInt(val)); 
		if((val = values.get("athflg")) != null) setAthflg(__getString(val));
		if((val = values.get("chknbr")) != null) setChknbr(__getString(val));
		if((val = values.get("rsvflg")) != null) setRsvflg(__getString(val));
		if((val = values.get("narext")) != null) setNarext(__getString(val));
		if((val = values.get("trsanl")) != null) setTrsanl(__getString(val));
		if((val = values.get("refsub")) != null) setRefsub(__getString(val));
		if((val = values.get("frmcod")) != null) setFrmcod(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
	}

	protected java.lang.Integer  __cmbc_trans_info_id ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __accnam ;
	protected java.lang.String  __etydat ;
	protected java.lang.String  __etytim ;
	protected java.util.Date  __trans_date ;
	protected java.util.Date  __vltdat ;
	protected java.lang.String  __trscod ;
	protected java.lang.String  __naryur ;
	protected java.math.BigDecimal  __trsamtd ;
	protected java.math.BigDecimal  __trsamtc ;
	protected java.lang.String  __amtcdr ;
	protected java.math.BigDecimal  __trsblv ;
	protected java.lang.String  __refnbr ;
	protected java.lang.String  __reqnbr ;
	protected java.lang.String  __busnam ;
	protected java.lang.String  __nusage ;
	protected java.lang.String  __yurref ;
	protected java.lang.String  __busnar ;
	protected java.lang.String  __otrnar ;
	protected java.lang.String  __c_rpybbk ;
	protected java.lang.String  __rpynam ;
	protected java.lang.String  __rpyacc ;
	protected java.lang.String  __rpybbn ;
	protected java.lang.String  __rpybnk ;
	protected java.lang.String  __rpyadr ;
	protected java.lang.String  __c_gsbbbk ;
	protected java.lang.String  __gsbacc ;
	protected java.lang.String  __gsbnam ;
	protected java.lang.Integer  __infflg ;
	protected java.lang.String  __athflg ;
	protected java.lang.String  __chknbr ;
	protected java.lang.String  __rsvflg ;
	protected java.lang.String  __narext ;
	protected java.lang.String  __trsanl ;
	protected java.lang.String  __refsub ;
	protected java.lang.String  __frmcod ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Integer  __company_record_id ;
}
