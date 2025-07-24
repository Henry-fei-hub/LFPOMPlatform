package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCmbcPayment extends GenericBase implements BaseFactory<BaseCmbcPayment>, Comparable<BaseCmbcPayment> 
{


	public static BaseCmbcPayment newInstance(){
		return new BaseCmbcPayment();
	}

	@Override
	public BaseCmbcPayment make(){
		BaseCmbcPayment b = new BaseCmbcPayment();
		return b;
	}

	public final static java.lang.String CS_CMBC_PAYMENT_ID = "cmbc_payment_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_YURREF = "yurref" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_TOTAL_NUM = "total_num" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_PAY_STATUS = "pay_status" ;
	public final static java.lang.String CS_PAY_RESULT = "pay_result" ;
	public final static java.lang.String CS_ERROR_MSG = "error_msg" ;
	public final static java.lang.String CS_EPTTIM = "epttim" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_SUCCESS_TOTAL_AMOUNT = "success_total_amount" ;
	public final static java.lang.String CS_SUCCESS_TOTAL_NUM = "success_total_num" ;
	public final static java.lang.String CS_REQNBR = "reqnbr" ;
	public final static java.lang.String CS_DBTACC = "dbtacc" ;
	public final static java.lang.String CS_DBTBBK = "dbtbbk" ;
	public final static java.lang.String CS_TRSTYP = "trstyp" ;
	public final static java.lang.String CS_TRSTYP_NAME = "trstyp_name" ;
	public final static java.lang.String CS_NUSAGE = "nusage" ;
	public final static java.lang.String CS_OPRDAT = "oprdat" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账,业务参考号,总金额(用户记录代发与代扣),总数量(用户记录代发与代扣),报销打包表编码,3支付完成(已返回处理结果),4失败,错误信息,期望时间,创建时间,成功总金额,成功总笔数,流程实例号 用于查询详细,付方账号,付方开户地区代码,交易代码,交易代码名称,用途,经办日期";

	public java.lang.Integer getCmbcPaymentId() {
		return this.__cmbc_payment_id;
	}

	public void setCmbcPaymentId( java.lang.Integer value ) {
		this.__cmbc_payment_id = value;
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

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
	}

	public java.lang.Integer getPayResult() {
		return this.__pay_result;
	}

	public void setPayResult( java.lang.Integer value ) {
		this.__pay_result = value;
	}

	public java.lang.String getErrorMsg() {
		return this.__error_msg;
	}

	public void setErrorMsg( java.lang.String value ) {
		this.__error_msg = value;
	}

	public java.util.Date getEpttim() {
		return this.__epttim;
	}

	public void setEpttim( java.util.Date value ) {
		this.__epttim = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.math.BigDecimal getSuccessTotalAmount() {
		return this.__success_total_amount;
	}

	public void setSuccessTotalAmount( java.math.BigDecimal value ) {
		this.__success_total_amount = value;
	}

	public java.lang.Integer getSuccessTotalNum() {
		return this.__success_total_num;
	}

	public void setSuccessTotalNum( java.lang.Integer value ) {
		this.__success_total_num = value;
	}

	public java.lang.String getReqnbr() {
		return this.__reqnbr;
	}

	public void setReqnbr( java.lang.String value ) {
		this.__reqnbr = value;
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

	public java.lang.String getNusage() {
		return this.__nusage;
	}

	public void setNusage( java.lang.String value ) {
		this.__nusage = value;
	}

	public java.util.Date getOprdat() {
		return this.__oprdat;
	}

	public void setOprdat( java.util.Date value ) {
		this.__oprdat = value;
	}

	public void cloneCopy(BaseCmbcPayment __bean){
		__bean.setCmbcPaymentId(getCmbcPaymentId());
		__bean.setType(getType());
		__bean.setYurref(getYurref());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setTotalNum(getTotalNum());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setPayStatus(getPayStatus());
		__bean.setPayResult(getPayResult());
		__bean.setErrorMsg(getErrorMsg());
		__bean.setEpttim(getEpttim());
		__bean.setCreateTime(getCreateTime());
		__bean.setSuccessTotalAmount(getSuccessTotalAmount());
		__bean.setSuccessTotalNum(getSuccessTotalNum());
		__bean.setReqnbr(getReqnbr());
		__bean.setDbtacc(getDbtacc());
		__bean.setDbtbbk(getDbtbbk());
		__bean.setTrstyp(getTrstyp());
		__bean.setTrstypName(getTrstypName());
		__bean.setNusage(getNusage());
		__bean.setOprdat(getOprdat());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCmbcPaymentId() == null ? "" : getCmbcPaymentId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getYurref() == null ? "" : getYurref());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTotalNum() == null ? "" : getTotalNum());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getPayStatus() == null ? "" : getPayStatus());
		sb.append(",");
		sb.append(getPayResult() == null ? "" : getPayResult());
		sb.append(",");
		sb.append(getErrorMsg() == null ? "" : getErrorMsg());
		sb.append(",");
		sb.append(getEpttim() == null ? "" : sdf.format(getEpttim()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getSuccessTotalAmount() == null ? "" : getSuccessTotalAmount());
		sb.append(",");
		sb.append(getSuccessTotalNum() == null ? "" : getSuccessTotalNum());
		sb.append(",");
		sb.append(getReqnbr() == null ? "" : getReqnbr());
		sb.append(",");
		sb.append(getDbtacc() == null ? "" : getDbtacc());
		sb.append(",");
		sb.append(getDbtbbk() == null ? "" : getDbtbbk());
		sb.append(",");
		sb.append(getTrstyp() == null ? "" : getTrstyp());
		sb.append(",");
		sb.append(getTrstypName() == null ? "" : getTrstypName());
		sb.append(",");
		sb.append(getNusage() == null ? "" : getNusage());
		sb.append(",");
		sb.append(getOprdat() == null ? "" : sdf.format(getOprdat()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCmbcPayment o) {
		return __cmbc_payment_id == null ? -1 : __cmbc_payment_id.compareTo(o.getCmbcPaymentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cmbc_payment_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__yurref);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_num);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_status);
		hash = 97 * hash + Objects.hashCode(this.__pay_result);
		hash = 97 * hash + Objects.hashCode(this.__error_msg);
		hash = 97 * hash + Objects.hashCode(this.__epttim);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__success_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__success_total_num);
		hash = 97 * hash + Objects.hashCode(this.__reqnbr);
		hash = 97 * hash + Objects.hashCode(this.__dbtacc);
		hash = 97 * hash + Objects.hashCode(this.__dbtbbk);
		hash = 97 * hash + Objects.hashCode(this.__trstyp);
		hash = 97 * hash + Objects.hashCode(this.__trstyp_name);
		hash = 97 * hash + Objects.hashCode(this.__nusage);
		hash = 97 * hash + Objects.hashCode(this.__oprdat);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCmbcPayment o = (BaseCmbcPayment)obj;
		if(!Objects.equals(this.__cmbc_payment_id, o.getCmbcPaymentId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__yurref, o.getYurref())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__total_num, o.getTotalNum())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__pay_status, o.getPayStatus())) return false;
		if(!Objects.equals(this.__pay_result, o.getPayResult())) return false;
		if(!Objects.equals(this.__error_msg, o.getErrorMsg())) return false;
		if(!Objects.equals(this.__epttim, o.getEpttim())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__success_total_amount, o.getSuccessTotalAmount())) return false;
		if(!Objects.equals(this.__success_total_num, o.getSuccessTotalNum())) return false;
		if(!Objects.equals(this.__reqnbr, o.getReqnbr())) return false;
		if(!Objects.equals(this.__dbtacc, o.getDbtacc())) return false;
		if(!Objects.equals(this.__dbtbbk, o.getDbtbbk())) return false;
		if(!Objects.equals(this.__trstyp, o.getTrstyp())) return false;
		if(!Objects.equals(this.__trstyp_name, o.getTrstypName())) return false;
		if(!Objects.equals(this.__nusage, o.getNusage())) return false;
		if(!Objects.equals(this.__oprdat, o.getOprdat())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCmbcPaymentId() != null) sb.append(__wrapNumber(count++, "cmbcPaymentId", getCmbcPaymentId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getYurref() != null) sb.append(__wrapString(count++, "yurref", getYurref()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTotalNum() != null) sb.append(__wrapNumber(count++, "totalNum", getTotalNum()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getPayStatus() != null) sb.append(__wrapNumber(count++, "payStatus", getPayStatus()));
		if(getPayResult() != null) sb.append(__wrapNumber(count++, "payResult", getPayResult()));
		if(getErrorMsg() != null) sb.append(__wrapString(count++, "errorMsg", getErrorMsg()));
		if(getEpttim() != null) sb.append(__wrapDate(count++, "epttim", getEpttim()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getSuccessTotalAmount() != null) sb.append(__wrapDecimal(count++, "successTotalAmount", getSuccessTotalAmount()));
		if(getSuccessTotalNum() != null) sb.append(__wrapNumber(count++, "successTotalNum", getSuccessTotalNum()));
		if(getReqnbr() != null) sb.append(__wrapString(count++, "reqnbr", getReqnbr()));
		if(getDbtacc() != null) sb.append(__wrapString(count++, "dbtacc", getDbtacc()));
		if(getDbtbbk() != null) sb.append(__wrapString(count++, "dbtbbk", getDbtbbk()));
		if(getTrstyp() != null) sb.append(__wrapString(count++, "trstyp", getTrstyp()));
		if(getTrstypName() != null) sb.append(__wrapString(count++, "trstypName", getTrstypName()));
		if(getNusage() != null) sb.append(__wrapString(count++, "nusage", getNusage()));
		if(getOprdat() != null) sb.append(__wrapDate(count++, "oprdat", getOprdat()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cmbcPaymentId")) != null) setCmbcPaymentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("totalNum")) != null) setTotalNum(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
		if((val = values.get("payResult")) != null) setPayResult(__getInt(val)); 
		if((val = values.get("errorMsg")) != null) setErrorMsg(__getString(val));
		if((val = values.get("epttim")) != null) setEpttim(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("successTotalAmount")) != null) setSuccessTotalAmount(__getDecimal(val));  
		if((val = values.get("successTotalNum")) != null) setSuccessTotalNum(__getInt(val)); 
		if((val = values.get("reqnbr")) != null) setReqnbr(__getString(val));
		if((val = values.get("dbtacc")) != null) setDbtacc(__getString(val));
		if((val = values.get("dbtbbk")) != null) setDbtbbk(__getString(val));
		if((val = values.get("trstyp")) != null) setTrstyp(__getString(val));
		if((val = values.get("trstypName")) != null) setTrstypName(__getString(val));
		if((val = values.get("nusage")) != null) setNusage(__getString(val));
		if((val = values.get("oprdat")) != null) setOprdat(__getDate(val)); 
	}

	protected java.lang.Integer  __cmbc_payment_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __yurref ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.lang.Integer  __total_num ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.lang.Integer  __pay_status ;
	protected java.lang.Integer  __pay_result ;
	protected java.lang.String  __error_msg ;
	protected java.util.Date  __epttim ;
	protected java.util.Date  __create_time ;
	protected java.math.BigDecimal  __success_total_amount ;
	protected java.lang.Integer  __success_total_num ;
	protected java.lang.String  __reqnbr ;
	protected java.lang.String  __dbtacc ;
	protected java.lang.String  __dbtbbk ;
	protected java.lang.String  __trstyp ;
	protected java.lang.String  __trstyp_name ;
	protected java.lang.String  __nusage ;
	protected java.util.Date  __oprdat ;
}
