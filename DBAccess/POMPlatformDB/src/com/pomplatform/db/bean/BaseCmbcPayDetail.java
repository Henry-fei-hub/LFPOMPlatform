package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCmbcPayDetail extends GenericBase implements BaseFactory<BaseCmbcPayDetail>, Comparable<BaseCmbcPayDetail> 
{


	public static BaseCmbcPayDetail newInstance(){
		return new BaseCmbcPayDetail();
	}

	@Override
	public BaseCmbcPayDetail make(){
		BaseCmbcPayDetail b = new BaseCmbcPayDetail();
		return b;
	}

	public final static java.lang.String CS_CMBC_PAY_DETAIL_ID = "cmbc_pay_detail_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_YURREF = "yurref" ;
	public final static java.lang.String CS_EPTDAT = "eptdat" ;
	public final static java.lang.String CS_DBTACC = "dbtacc" ;
	public final static java.lang.String CS_DBTBBK = "dbtbbk" ;
	public final static java.lang.String CS_TRSAMT = "trsamt" ;
	public final static java.lang.String CS_CCYNBR = "ccynbr" ;
	public final static java.lang.String CS_STLCHN = "stlchn" ;
	public final static java.lang.String CS_NUSAGE = "nusage" ;
	public final static java.lang.String CS_BUSNAR = "busnar" ;
	public final static java.lang.String CS_CRTACC = "crtacc" ;
	public final static java.lang.String CS_CRTNAM = "crtnam" ;
	public final static java.lang.String CS_BRDNBR = "brdnbr" ;
	public final static java.lang.String CS_BNKFLG = "bnkflg" ;
	public final static java.lang.String CS_CRTBNK = "crtbnk" ;
	public final static java.lang.String CS_CTYCOD = "ctycod" ;
	public final static java.lang.String CS_CRTPVC = "crtpvc" ;
	public final static java.lang.String CS_CRTCTY = "crtcty" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_TOTAL_NUM = "total_num" ;
	public final static java.lang.String CS_CRTBBK = "crtbbk" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID = "reimbursement_package_summary_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ERROR_MSG = "error_msg" ;
	public final static java.lang.String CS_BUSCOD = "buscod" ;
	public final static java.lang.String CS_BUSMOD = "busmod" ;
	public final static java.lang.String CS_EACCTY = "eaccty" ;
	public final static java.lang.String CS_TRSTYP = "trstyp" ;
	public final static java.lang.String CS_TRSTYP_NAME = "trstyp_name" ;
	public final static java.lang.String CS_CMBC_PAYMENT_ID = "cmbc_payment_id" ;
	public final static java.lang.String CS_OBJECT_ID = "object_id" ;
	public final static java.lang.String CS_OBJECT_TYPE = "object_type" ;
	public final static java.lang.String CS_OPRDAT = "oprdat" ;
	public final static java.lang.String CS_WITHDRAW_FLAG = "withdraw_flag" ;
	public final static java.lang.String CS_WITHDRAW_ORIGIN_ID = "withdraw_origin_id" ;
	public final static java.lang.String CS_WITHDRAW_STATUS = "withdraw_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账,业务参考号,期望日,付方账号,付方开户地区代码,交易金额,币种代码,结算方式代码,用途,业务摘要,收方账号,收方账户名,自动支付收款联行号,系统内外标志,收方开户行,城市代码,收方省份,收方城市,省,市,总金额(用户记录代发与代扣),总数量(用户记录代发与代扣),收方开户地区代码,报销打包汇总表编码,报销打包表编码,,,状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票,错误信息,业务类别,业务模式,他行户口开户地,交易代码,交易代码名称,支付总表编码,员工或者收款单位主键,1员工  2收款单位,经办日期,退单标志  1 为正常支付单 2为退单重新支付单,退单来源主键,退单发起状态 1待资料补正 2可提起支付  3已提起支付";

	public java.lang.Integer getCmbcPayDetailId() {
		return this.__cmbc_pay_detail_id;
	}

	public void setCmbcPayDetailId( java.lang.Integer value ) {
		this.__cmbc_pay_detail_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getYurref() {
		return this.__yurref;
	}

	public void setYurref( java.lang.String value ) {
		this.__yurref = value;
	}

	public java.util.Date getEptdat() {
		return this.__eptdat;
	}

	public void setEptdat( java.util.Date value ) {
		this.__eptdat = value;
	}

	public java.lang.String getDbtacc() {
		return this.__dbtacc;
	}

	public void setDbtacc( java.lang.String value ) {
		this.__dbtacc = value;
	}

	public java.lang.String getDbtbbk() {
		return this.__dbtbbk;
	}

	public void setDbtbbk( java.lang.String value ) {
		this.__dbtbbk = value;
	}

	public java.math.BigDecimal getTrsamt() {
		return this.__trsamt;
	}

	public void setTrsamt( java.math.BigDecimal value ) {
		this.__trsamt = value;
	}

	public java.lang.String getCcynbr() {
		return this.__ccynbr;
	}

	public void setCcynbr( java.lang.String value ) {
		this.__ccynbr = value;
	}

	public java.lang.String getStlchn() {
		return this.__stlchn;
	}

	public void setStlchn( java.lang.String value ) {
		this.__stlchn = value;
	}

	public java.lang.String getNusage() {
		return this.__nusage;
	}

	public void setNusage( java.lang.String value ) {
		this.__nusage = value;
	}

	public java.lang.String getBusnar() {
		return this.__busnar;
	}

	public void setBusnar( java.lang.String value ) {
		this.__busnar = value;
	}

	public java.lang.String getCrtacc() {
		return this.__crtacc;
	}

	public void setCrtacc( java.lang.String value ) {
		this.__crtacc = value;
	}

	public java.lang.String getCrtnam() {
		return this.__crtnam;
	}

	public void setCrtnam( java.lang.String value ) {
		this.__crtnam = value;
	}

	public java.lang.String getBrdnbr() {
		return this.__brdnbr;
	}

	public void setBrdnbr( java.lang.String value ) {
		this.__brdnbr = value;
	}

	public java.lang.String getBnkflg() {
		return this.__bnkflg;
	}

	public void setBnkflg( java.lang.String value ) {
		this.__bnkflg = value;
	}

	public java.lang.String getCrtbnk() {
		return this.__crtbnk;
	}

	public void setCrtbnk( java.lang.String value ) {
		this.__crtbnk = value;
	}

	public java.lang.String getCtycod() {
		return this.__ctycod;
	}

	public void setCtycod( java.lang.String value ) {
		this.__ctycod = value;
	}

	public java.lang.String getCrtpvc() {
		return this.__crtpvc;
	}

	public void setCrtpvc( java.lang.String value ) {
		this.__crtpvc = value;
	}

	public java.lang.String getCrtcty() {
		return this.__crtcty;
	}

	public void setCrtcty( java.lang.String value ) {
		this.__crtcty = value;
	}

	public java.lang.Integer getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.Integer value ) {
		this.__province = value;
	}

	public java.lang.Integer getCity() {
		return this.__city;
	}

	public void setCity( java.lang.Integer value ) {
		this.__city = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.lang.Integer getTotalNum() {
		return this.__total_num;
	}

	public void setTotalNum( java.lang.Integer value ) {
		this.__total_num = value;
	}

	public java.lang.String getCrtbbk() {
		return this.__crtbbk;
	}

	public void setCrtbbk( java.lang.String value ) {
		this.__crtbbk = value;
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getErrorMsg() {
		return this.__error_msg;
	}

	public void setErrorMsg( java.lang.String value ) {
		this.__error_msg = value;
	}

	public java.lang.String getBuscod() {
		return this.__buscod;
	}

	public void setBuscod( java.lang.String value ) {
		this.__buscod = value;
	}

	public java.lang.String getBusmod() {
		return this.__busmod;
	}

	public void setBusmod( java.lang.String value ) {
		this.__busmod = value;
	}

	public java.lang.String getEaccty() {
		return this.__eaccty;
	}

	public void setEaccty( java.lang.String value ) {
		this.__eaccty = value;
	}

	public java.lang.String getTrstyp() {
		return this.__trstyp;
	}

	public void setTrstyp( java.lang.String value ) {
		this.__trstyp = value;
	}

	public java.lang.String getTrstypName() {
		return this.__trstyp_name;
	}

	public void setTrstypName( java.lang.String value ) {
		this.__trstyp_name = value;
	}

	public java.lang.Integer getCmbcPaymentId() {
		return this.__cmbc_payment_id;
	}

	public void setCmbcPaymentId( java.lang.Integer value ) {
		this.__cmbc_payment_id = value;
	}

	public java.lang.Integer getObjectId() {
		return this.__object_id;
	}

	public void setObjectId( java.lang.Integer value ) {
		this.__object_id = value;
	}

	public java.lang.Integer getObjectType() {
		return this.__object_type;
	}

	public void setObjectType( java.lang.Integer value ) {
		this.__object_type = value;
	}

	public java.util.Date getOprdat() {
		return this.__oprdat;
	}

	public void setOprdat( java.util.Date value ) {
		this.__oprdat = value;
	}

	public java.lang.Integer getWithdrawFlag() {
		return this.__withdraw_flag;
	}

	public void setWithdrawFlag( java.lang.Integer value ) {
		this.__withdraw_flag = value;
	}

	public java.lang.Integer getWithdrawOriginId() {
		return this.__withdraw_origin_id;
	}

	public void setWithdrawOriginId( java.lang.Integer value ) {
		this.__withdraw_origin_id = value;
	}

	public java.lang.Integer getWithdrawStatus() {
		return this.__withdraw_status;
	}

	public void setWithdrawStatus( java.lang.Integer value ) {
		this.__withdraw_status = value;
	}

	public void cloneCopy(BaseCmbcPayDetail __bean){
		__bean.setCmbcPayDetailId(getCmbcPayDetailId());
		__bean.setType(getType());
		__bean.setYurref(getYurref());
		__bean.setEptdat(getEptdat());
		__bean.setDbtacc(getDbtacc());
		__bean.setDbtbbk(getDbtbbk());
		__bean.setTrsamt(getTrsamt());
		__bean.setCcynbr(getCcynbr());
		__bean.setStlchn(getStlchn());
		__bean.setNusage(getNusage());
		__bean.setBusnar(getBusnar());
		__bean.setCrtacc(getCrtacc());
		__bean.setCrtnam(getCrtnam());
		__bean.setBrdnbr(getBrdnbr());
		__bean.setBnkflg(getBnkflg());
		__bean.setCrtbnk(getCrtbnk());
		__bean.setCtycod(getCtycod());
		__bean.setCrtpvc(getCrtpvc());
		__bean.setCrtcty(getCrtcty());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setTotalNum(getTotalNum());
		__bean.setCrtbbk(getCrtbbk());
		__bean.setReimbursementPackageSummaryId(getReimbursementPackageSummaryId());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperator(getOperator());
		__bean.setStatus(getStatus());
		__bean.setErrorMsg(getErrorMsg());
		__bean.setBuscod(getBuscod());
		__bean.setBusmod(getBusmod());
		__bean.setEaccty(getEaccty());
		__bean.setTrstyp(getTrstyp());
		__bean.setTrstypName(getTrstypName());
		__bean.setCmbcPaymentId(getCmbcPaymentId());
		__bean.setObjectId(getObjectId());
		__bean.setObjectType(getObjectType());
		__bean.setOprdat(getOprdat());
		__bean.setWithdrawFlag(getWithdrawFlag());
		__bean.setWithdrawOriginId(getWithdrawOriginId());
		__bean.setWithdrawStatus(getWithdrawStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCmbcPayDetailId() == null ? "" : getCmbcPayDetailId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getYurref() == null ? "" : getYurref());
		sb.append(",");
		sb.append(getEptdat() == null ? "" : sdf.format(getEptdat()));
		sb.append(",");
		sb.append(getDbtacc() == null ? "" : getDbtacc());
		sb.append(",");
		sb.append(getDbtbbk() == null ? "" : getDbtbbk());
		sb.append(",");
		sb.append(getTrsamt() == null ? "" : getTrsamt());
		sb.append(",");
		sb.append(getCcynbr() == null ? "" : getCcynbr());
		sb.append(",");
		sb.append(getStlchn() == null ? "" : getStlchn());
		sb.append(",");
		sb.append(getNusage() == null ? "" : getNusage());
		sb.append(",");
		sb.append(getBusnar() == null ? "" : getBusnar());
		sb.append(",");
		sb.append(getCrtacc() == null ? "" : getCrtacc());
		sb.append(",");
		sb.append(getCrtnam() == null ? "" : getCrtnam());
		sb.append(",");
		sb.append(getBrdnbr() == null ? "" : getBrdnbr());
		sb.append(",");
		sb.append(getBnkflg() == null ? "" : getBnkflg());
		sb.append(",");
		sb.append(getCrtbnk() == null ? "" : getCrtbnk());
		sb.append(",");
		sb.append(getCtycod() == null ? "" : getCtycod());
		sb.append(",");
		sb.append(getCrtpvc() == null ? "" : getCrtpvc());
		sb.append(",");
		sb.append(getCrtcty() == null ? "" : getCrtcty());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTotalNum() == null ? "" : getTotalNum());
		sb.append(",");
		sb.append(getCrtbbk() == null ? "" : getCrtbbk());
		sb.append(",");
		sb.append(getReimbursementPackageSummaryId() == null ? "" : getReimbursementPackageSummaryId());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getErrorMsg() == null ? "" : getErrorMsg());
		sb.append(",");
		sb.append(getBuscod() == null ? "" : getBuscod());
		sb.append(",");
		sb.append(getBusmod() == null ? "" : getBusmod());
		sb.append(",");
		sb.append(getEaccty() == null ? "" : getEaccty());
		sb.append(",");
		sb.append(getTrstyp() == null ? "" : getTrstyp());
		sb.append(",");
		sb.append(getTrstypName() == null ? "" : getTrstypName());
		sb.append(",");
		sb.append(getCmbcPaymentId() == null ? "" : getCmbcPaymentId());
		sb.append(",");
		sb.append(getObjectId() == null ? "" : getObjectId());
		sb.append(",");
		sb.append(getObjectType() == null ? "" : getObjectType());
		sb.append(",");
		sb.append(getOprdat() == null ? "" : sdf.format(getOprdat()));
		sb.append(",");
		sb.append(getWithdrawFlag() == null ? "" : getWithdrawFlag());
		sb.append(",");
		sb.append(getWithdrawOriginId() == null ? "" : getWithdrawOriginId());
		sb.append(",");
		sb.append(getWithdrawStatus() == null ? "" : getWithdrawStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCmbcPayDetail o) {
		return __cmbc_pay_detail_id == null ? -1 : __cmbc_pay_detail_id.compareTo(o.getCmbcPayDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cmbc_pay_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__yurref);
		hash = 97 * hash + Objects.hashCode(this.__eptdat);
		hash = 97 * hash + Objects.hashCode(this.__dbtacc);
		hash = 97 * hash + Objects.hashCode(this.__dbtbbk);
		hash = 97 * hash + Objects.hashCode(this.__trsamt);
		hash = 97 * hash + Objects.hashCode(this.__ccynbr);
		hash = 97 * hash + Objects.hashCode(this.__stlchn);
		hash = 97 * hash + Objects.hashCode(this.__nusage);
		hash = 97 * hash + Objects.hashCode(this.__busnar);
		hash = 97 * hash + Objects.hashCode(this.__crtacc);
		hash = 97 * hash + Objects.hashCode(this.__crtnam);
		hash = 97 * hash + Objects.hashCode(this.__brdnbr);
		hash = 97 * hash + Objects.hashCode(this.__bnkflg);
		hash = 97 * hash + Objects.hashCode(this.__crtbnk);
		hash = 97 * hash + Objects.hashCode(this.__ctycod);
		hash = 97 * hash + Objects.hashCode(this.__crtpvc);
		hash = 97 * hash + Objects.hashCode(this.__crtcty);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_num);
		hash = 97 * hash + Objects.hashCode(this.__crtbbk);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_summary_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__error_msg);
		hash = 97 * hash + Objects.hashCode(this.__buscod);
		hash = 97 * hash + Objects.hashCode(this.__busmod);
		hash = 97 * hash + Objects.hashCode(this.__eaccty);
		hash = 97 * hash + Objects.hashCode(this.__trstyp);
		hash = 97 * hash + Objects.hashCode(this.__trstyp_name);
		hash = 97 * hash + Objects.hashCode(this.__cmbc_payment_id);
		hash = 97 * hash + Objects.hashCode(this.__object_id);
		hash = 97 * hash + Objects.hashCode(this.__object_type);
		hash = 97 * hash + Objects.hashCode(this.__oprdat);
		hash = 97 * hash + Objects.hashCode(this.__withdraw_flag);
		hash = 97 * hash + Objects.hashCode(this.__withdraw_origin_id);
		hash = 97 * hash + Objects.hashCode(this.__withdraw_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCmbcPayDetail o = (BaseCmbcPayDetail)obj;
		if(!Objects.equals(this.__cmbc_pay_detail_id, o.getCmbcPayDetailId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__yurref, o.getYurref())) return false;
		if(!Objects.equals(this.__eptdat, o.getEptdat())) return false;
		if(!Objects.equals(this.__dbtacc, o.getDbtacc())) return false;
		if(!Objects.equals(this.__dbtbbk, o.getDbtbbk())) return false;
		if(!Objects.equals(this.__trsamt, o.getTrsamt())) return false;
		if(!Objects.equals(this.__ccynbr, o.getCcynbr())) return false;
		if(!Objects.equals(this.__stlchn, o.getStlchn())) return false;
		if(!Objects.equals(this.__nusage, o.getNusage())) return false;
		if(!Objects.equals(this.__busnar, o.getBusnar())) return false;
		if(!Objects.equals(this.__crtacc, o.getCrtacc())) return false;
		if(!Objects.equals(this.__crtnam, o.getCrtnam())) return false;
		if(!Objects.equals(this.__brdnbr, o.getBrdnbr())) return false;
		if(!Objects.equals(this.__bnkflg, o.getBnkflg())) return false;
		if(!Objects.equals(this.__crtbnk, o.getCrtbnk())) return false;
		if(!Objects.equals(this.__ctycod, o.getCtycod())) return false;
		if(!Objects.equals(this.__crtpvc, o.getCrtpvc())) return false;
		if(!Objects.equals(this.__crtcty, o.getCrtcty())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__total_num, o.getTotalNum())) return false;
		if(!Objects.equals(this.__crtbbk, o.getCrtbbk())) return false;
		if(!Objects.equals(this.__reimbursement_package_summary_id, o.getReimbursementPackageSummaryId())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__error_msg, o.getErrorMsg())) return false;
		if(!Objects.equals(this.__buscod, o.getBuscod())) return false;
		if(!Objects.equals(this.__busmod, o.getBusmod())) return false;
		if(!Objects.equals(this.__eaccty, o.getEaccty())) return false;
		if(!Objects.equals(this.__trstyp, o.getTrstyp())) return false;
		if(!Objects.equals(this.__trstyp_name, o.getTrstypName())) return false;
		if(!Objects.equals(this.__cmbc_payment_id, o.getCmbcPaymentId())) return false;
		if(!Objects.equals(this.__object_id, o.getObjectId())) return false;
		if(!Objects.equals(this.__object_type, o.getObjectType())) return false;
		if(!Objects.equals(this.__oprdat, o.getOprdat())) return false;
		if(!Objects.equals(this.__withdraw_flag, o.getWithdrawFlag())) return false;
		if(!Objects.equals(this.__withdraw_origin_id, o.getWithdrawOriginId())) return false;
		if(!Objects.equals(this.__withdraw_status, o.getWithdrawStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCmbcPayDetailId() != null) sb.append(__wrapNumber(count++, "cmbcPayDetailId", getCmbcPayDetailId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getYurref() != null) sb.append(__wrapString(count++, "yurref", getYurref()));
		if(getEptdat() != null) sb.append(__wrapDate(count++, "eptdat", getEptdat()));
		if(getDbtacc() != null) sb.append(__wrapString(count++, "dbtacc", getDbtacc()));
		if(getDbtbbk() != null) sb.append(__wrapString(count++, "dbtbbk", getDbtbbk()));
		if(getTrsamt() != null) sb.append(__wrapDecimal(count++, "trsamt", getTrsamt()));
		if(getCcynbr() != null) sb.append(__wrapString(count++, "ccynbr", getCcynbr()));
		if(getStlchn() != null) sb.append(__wrapString(count++, "stlchn", getStlchn()));
		if(getNusage() != null) sb.append(__wrapString(count++, "nusage", getNusage()));
		if(getBusnar() != null) sb.append(__wrapString(count++, "busnar", getBusnar()));
		if(getCrtacc() != null) sb.append(__wrapString(count++, "crtacc", getCrtacc()));
		if(getCrtnam() != null) sb.append(__wrapString(count++, "crtnam", getCrtnam()));
		if(getBrdnbr() != null) sb.append(__wrapString(count++, "brdnbr", getBrdnbr()));
		if(getBnkflg() != null) sb.append(__wrapString(count++, "bnkflg", getBnkflg()));
		if(getCrtbnk() != null) sb.append(__wrapString(count++, "crtbnk", getCrtbnk()));
		if(getCtycod() != null) sb.append(__wrapString(count++, "ctycod", getCtycod()));
		if(getCrtpvc() != null) sb.append(__wrapString(count++, "crtpvc", getCrtpvc()));
		if(getCrtcty() != null) sb.append(__wrapString(count++, "crtcty", getCrtcty()));
		if(getProvince() != null) sb.append(__wrapNumber(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(count++, "city", getCity()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTotalNum() != null) sb.append(__wrapNumber(count++, "totalNum", getTotalNum()));
		if(getCrtbbk() != null) sb.append(__wrapString(count++, "crtbbk", getCrtbbk()));
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getErrorMsg() != null) sb.append(__wrapString(count++, "errorMsg", getErrorMsg()));
		if(getBuscod() != null) sb.append(__wrapString(count++, "buscod", getBuscod()));
		if(getBusmod() != null) sb.append(__wrapString(count++, "busmod", getBusmod()));
		if(getEaccty() != null) sb.append(__wrapString(count++, "eaccty", getEaccty()));
		if(getTrstyp() != null) sb.append(__wrapString(count++, "trstyp", getTrstyp()));
		if(getTrstypName() != null) sb.append(__wrapString(count++, "trstypName", getTrstypName()));
		if(getCmbcPaymentId() != null) sb.append(__wrapNumber(count++, "cmbcPaymentId", getCmbcPaymentId()));
		if(getObjectId() != null) sb.append(__wrapNumber(count++, "objectId", getObjectId()));
		if(getObjectType() != null) sb.append(__wrapNumber(count++, "objectType", getObjectType()));
		if(getOprdat() != null) sb.append(__wrapDate(count++, "oprdat", getOprdat()));
		if(getWithdrawFlag() != null) sb.append(__wrapNumber(count++, "withdrawFlag", getWithdrawFlag()));
		if(getWithdrawOriginId() != null) sb.append(__wrapNumber(count++, "withdrawOriginId", getWithdrawOriginId()));
		if(getWithdrawStatus() != null) sb.append(__wrapNumber(count++, "withdrawStatus", getWithdrawStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cmbcPayDetailId")) != null) setCmbcPayDetailId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("eptdat")) != null) setEptdat(__getDate(val)); 
		if((val = values.get("dbtacc")) != null) setDbtacc(__getString(val));
		if((val = values.get("dbtbbk")) != null) setDbtbbk(__getString(val));
		if((val = values.get("trsamt")) != null) setTrsamt(__getDecimal(val));  
		if((val = values.get("ccynbr")) != null) setCcynbr(__getString(val));
		if((val = values.get("stlchn")) != null) setStlchn(__getString(val));
		if((val = values.get("nusage")) != null) setNusage(__getString(val));
		if((val = values.get("busnar")) != null) setBusnar(__getString(val));
		if((val = values.get("crtacc")) != null) setCrtacc(__getString(val));
		if((val = values.get("crtnam")) != null) setCrtnam(__getString(val));
		if((val = values.get("brdnbr")) != null) setBrdnbr(__getString(val));
		if((val = values.get("bnkflg")) != null) setBnkflg(__getString(val));
		if((val = values.get("crtbnk")) != null) setCrtbnk(__getString(val));
		if((val = values.get("ctycod")) != null) setCtycod(__getString(val));
		if((val = values.get("crtpvc")) != null) setCrtpvc(__getString(val));
		if((val = values.get("crtcty")) != null) setCrtcty(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("totalNum")) != null) setTotalNum(__getInt(val)); 
		if((val = values.get("crtbbk")) != null) setCrtbbk(__getString(val));
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("errorMsg")) != null) setErrorMsg(__getString(val));
		if((val = values.get("buscod")) != null) setBuscod(__getString(val));
		if((val = values.get("busmod")) != null) setBusmod(__getString(val));
		if((val = values.get("eaccty")) != null) setEaccty(__getString(val));
		if((val = values.get("trstyp")) != null) setTrstyp(__getString(val));
		if((val = values.get("trstypName")) != null) setTrstypName(__getString(val));
		if((val = values.get("cmbcPaymentId")) != null) setCmbcPaymentId(__getInt(val)); 
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("oprdat")) != null) setOprdat(__getDate(val)); 
		if((val = values.get("withdrawFlag")) != null) setWithdrawFlag(__getInt(val)); 
		if((val = values.get("withdrawOriginId")) != null) setWithdrawOriginId(__getInt(val)); 
		if((val = values.get("withdrawStatus")) != null) setWithdrawStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __cmbc_pay_detail_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __yurref ;
	protected java.util.Date  __eptdat ;
	protected java.lang.String  __dbtacc ;
	protected java.lang.String  __dbtbbk ;
	protected java.math.BigDecimal  __trsamt ;
	protected java.lang.String  __ccynbr ;
	protected java.lang.String  __stlchn ;
	protected java.lang.String  __nusage ;
	protected java.lang.String  __busnar ;
	protected java.lang.String  __crtacc ;
	protected java.lang.String  __crtnam ;
	protected java.lang.String  __brdnbr ;
	protected java.lang.String  __bnkflg ;
	protected java.lang.String  __crtbnk ;
	protected java.lang.String  __ctycod ;
	protected java.lang.String  __crtpvc ;
	protected java.lang.String  __crtcty ;
	protected java.lang.Integer  __province ;
	protected java.lang.Integer  __city ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.lang.Integer  __total_num ;
	protected java.lang.String  __crtbbk ;
	protected java.lang.Integer  __reimbursement_package_summary_id ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __error_msg ;
	protected java.lang.String  __buscod ;
	protected java.lang.String  __busmod ;
	protected java.lang.String  __eaccty ;
	protected java.lang.String  __trstyp ;
	protected java.lang.String  __trstyp_name ;
	protected java.lang.Integer  __cmbc_payment_id ;
	protected java.lang.Integer  __object_id ;
	protected java.lang.Integer  __object_type ;
	protected java.util.Date  __oprdat ;
	protected java.lang.Integer  __withdraw_flag ;
	protected java.lang.Integer  __withdraw_origin_id ;
	protected java.lang.Integer  __withdraw_status ;
}
