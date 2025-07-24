package com.pomplatform.db.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.dao.FormalContract;
import com.pomplatform.db.dao.OutDesignConsideration;

import delicacy.common.BaseHelpUtils;

public class StaticMethod {
	/**
	 * 签约公司：深圳市杰恩创意设计股份有限公司
	 */
	public static final int SIGN_COMPANY_0 = 0;

	/**
	 * 签约公司：深圳市博普森机电顾问有限公司
	 */
	public static final int SIGN_COMPANY_1 = 1;

	/**
	 * 签约公司：姜峰设计（深圳）有限公司
	 */
	public static final int SIGN_COMPANY_2 = 2;

	/**
	 * 签约公司：深圳杰加设计有限公司
	 */
	public static final int SIGN_COMPANY_3 = 3;

	/**
	 * 签约公司：深圳市杰恩创意设计股份有限公司武汉分公司
	 */
	public static final int SIGN_COMPANY_4 = 4;
	/**
	 * 签约公司：上海姜峰室内设计有限公司
	 */
	public static final int SIGN_COMPANY_5 = 5;

	/**
	 * 签约公司：北京姜峰室内设计有限公司
	 */
	public static final int SIGN_COMPANY_6 = 6;

	/**
	 * 签约公司：大连姜峰设计有限公司
	 */
	public static final int SIGN_COMPANY_7 = 7;

	/**
	 * 签约公司：杰拓设计国际有限公司
	 */
	public static final int SIGN_COMPANY_8 = 8;

	/**
	 * 签约公司：姜峰室内设计香港有限公司
	 */
	public static final int SIGN_COMPANY_9 = 9;

	/**
	 * 
	 * @param infoCode
	 * @param projectCode
	 * @return
	 * @throws SQLException
	 */
	public static List<BaseOutDesignConsideration> getBaseOutDesignConsiderationList(String infoCode,
			String projectCode) throws SQLException {
		OutDesignConsideration outDAO = new OutDesignConsideration();
		outDAO.setConditionInfoCode("=", infoCode);
		outDAO.setConditionProjectCode("=", projectCode);
		List<BaseOutDesignConsideration> l = outDAO.conditionalLoad();
		return l;
	}

	/**
	 * 统计 //现场配合(次) //服务面积(㎡) //配合费用(元) //驻场时间(月) //驻场总金额(元) 总和
	 * 
	 * @param infoCode
	 * @param projectCode
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Object> getPropertyMap(String infoCode, String projectCode) throws SQLException {
		Map<String, Object> m = new HashMap<>();
		List<BaseOutDesignConsideration> bList = getBaseOutDesignConsiderationList(infoCode, projectCode);
		if (bList.size() > 0) {
			int temp_job_mix = 0, temp_on_site_time = 0;
			double temp_service_area = 0, temp_on_site_total_money = 0, temp_with_the_amount = 0;
			for (BaseOutDesignConsideration b : bList) {

				temp_job_mix += BaseHelpUtils.getIntValue(b.getJobMix());
				temp_on_site_time += BaseHelpUtils.getIntValue(b.getOnSiteTime());
				temp_service_area += BaseHelpUtils.getDoubleValue(b.getServiceArea());
				temp_on_site_total_money += BaseHelpUtils.getIntValue(b.getOnSiteTotalMoney());
				temp_with_the_amount += BaseHelpUtils.getIntValue(b.getWithTheAmount());

			}
			m.put("jobMix", temp_job_mix);
			m.put("onSiteTime", temp_on_site_time);
			m.put("serviceArea", temp_service_area);
			m.put("withTheAmount", temp_with_the_amount);
			m.put("onSiteTotalMoney", temp_on_site_total_money);
		}
		return m;
	}

	/**
	 * 获取正式合同编号，流水号，补充协议号
	 * 
	 * @param infoCode
	 * @param projectCode
	 * @param signingCompanyName
	 * @return 正式合同编号，流水号，补充协议号
	 * @throws Exception
	 */
	public static Map<String, Object> getNumberStr(String infoCode, String projectCode, int signingCompanyName)
			throws Exception {
		Map<String, Object> m = new HashMap<String, Object>();
		FormalContract fc = new FormalContract();
		if (!BaseHelpUtils.isNullOrEmpty(infoCode)) {
			fc.setConditionCity("=", infoCode);
		}
		fc.setConditionProjectCode("=", projectCode);
		List<BaseFormalContract> bList = fc.conditionalLoad();
		int count = bList.size();
		int orderNOMax = 0;
		int serialNumberMax = 0;

		if (count > 0) {
			for (BaseFormalContract bfc : bList) {
				if (orderNOMax < BaseHelpUtils.getIntValue(bfc.getOrderNo())) {
					orderNOMax = BaseHelpUtils.getIntValue(bfc.getOrderNo());
				}
				if (serialNumberMax < BaseHelpUtils.getIntValue(bfc.getSerialNumber())) {
					serialNumberMax = BaseHelpUtils.getIntValue(bfc.getSerialNumber());
				}
			}

		}
		// 流水号
		String serialNumberStr = "000";
		serialNumberMax++;

		if (serialNumberMax <= 9) {
			serialNumberStr = "00" + serialNumberMax;
		} else if (serialNumberMax <= 99 && count > 9) {
			serialNumberStr = "0" + serialNumberMax;
		} else {
			serialNumberStr = "" + serialNumberMax;
		}
		// 补充协议号
		String orderNOMaxStr = "00";
		orderNOMax++;
		if (orderNOMax <= 9) {
			orderNOMaxStr = "0" + orderNOMax;
		} else {
			orderNOMaxStr = "" + orderNOMax;
		}

		StringBuilder sb = new StringBuilder();
		// getContractCode
		sb.append(getContractCode(signingCompanyName));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		sb.append(calendar.get(Calendar.YEAR));
		sb.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
		sb.append(serialNumberStr);
		if (count > 0) {
			sb.append("(").append(orderNOMaxStr).append(")");
		}
		m.put("serialNumberStr", serialNumberStr);
		m.put("orderNOStr", orderNOMaxStr);
		m.put("contractCode", sb.toString());
		return m;
	}

	/**
	 * 获取正式合同的流水号
	 * 
	 * @param infoCode
	 * @param projectCode
	 * @return
	 * @throws SQLException
	 */
	public static String getWaterNumber(String infoCode, String projectCode) throws SQLException {
		FormalContract fc = new FormalContract();
		fc.setConditionCity("=", infoCode);
		fc.setConditionProjectCode("=", projectCode);
		List<BaseFormalContract> bList = fc.conditionalLoad();
		int count = bList.size();
		int maxVal = 0;
		if (count > 0) {
			for (BaseFormalContract bfc : bList) {
				if (maxVal < BaseHelpUtils.getIntValue(bfc.getSerialNumber())) {
					maxVal = BaseHelpUtils.getIntValue(bfc.getSerialNumber());
				}
			}

		}

		String numStr = "000";
		maxVal++;
		if (maxVal <= 9) {
			numStr = "00" + maxVal;
		} else if (maxVal <= 99 && count > 9) {
			numStr = "0" + maxVal;
		} else {
			numStr = "" + maxVal;
		}

		return numStr;
	}

	/**
	 * 补充协议
	 * 
	 * @param infoCode
	 * @param projectCode
	 * @return
	 * @throws SQLException
	 */
	public static String getReplenishNUmber(String infoCode, String projectCode) throws SQLException {
		FormalContract fc = new FormalContract();
		fc.setConditionCity("=", infoCode);
		fc.setConditionProjectCode("=", projectCode);
		List<BaseFormalContract> bList = fc.conditionalLoad();
		int count = bList.size();
		int maxVal = 0;
		if (count > 0) {
			for (BaseFormalContract bfc : bList) {
				if (maxVal < BaseHelpUtils.getIntValue(bfc.getOrderNo())) {
					maxVal = BaseHelpUtils.getIntValue(bfc.getOrderNo());
				}
			}

		}

		String numStr = "00";
		maxVal++;
		if (maxVal <= 9) {
			numStr = "0" + maxVal;
		} else {
			numStr = "" + maxVal;
		}
		return numStr;
	}

	/**
	 * 找到合同编号的签约的开头符号
	 * 
	 * @param signingCompanyName
	 * @return
	 * @throws Exception
	 */
	public static String getContractCode(int signingCompanyName) throws Exception {
		if (!BaseHelpUtils.isNullOrEmpty(signingCompanyName)) {
			StringBuilder sb = new StringBuilder();
			switch (signingCompanyName) {
			case SIGN_COMPANY_0:
				sb.append("JA.");
				break;
			case SIGN_COMPANY_1:
				sb.append("BP.");
				break;
			case SIGN_COMPANY_2:
				sb.append("JF.");
				break;
			case SIGN_COMPANY_3:
				sb.append("JK.");
				break;
			case SIGN_COMPANY_4:
				sb.append("WH.");
				break;
			case SIGN_COMPANY_5:
				sb.append("SH.");
				break;
			case SIGN_COMPANY_6:
				sb.append("BJ.");
				break;
			case SIGN_COMPANY_7:
				sb.append("DL.");
				break;
			case SIGN_COMPANY_8:
				sb.append("JT.");
				break;
			case SIGN_COMPANY_9:
				sb.append("JH.");
				break;
			default:
				break;
			}
			return sb.toString();
		} else {
			throw new Exception("沒有选择我方签约公司，无法生成主合同编号");
		}
	}

	/**
	 * 保留2位小数的double类型
	 * 
	 * @param double2Value
	 * @return
	 */
	public static double getDouble2Value(double double2Value) {
		DecimalFormat df = new DecimalFormat("#.##");
		double get_double = Double.parseDouble(df.format(double2Value));
		return get_double;
	}

	/**
	 * 保留4位小数的double类型
	 * 
	 * @param double4Value
	 * @return
	 */
	public static double getDouble4Value(double double4Value) {
		DecimalFormat df = new DecimalFormat("#.##");
		double get_double = Double.parseDouble(df.format(double4Value));
		return get_double;
	}

	public static BigDecimal formatComma4BigDecimal(Object obj) {
		String val = String.valueOf(obj);
		if (val == null)
			return new BigDecimal("0.00");

		val = val.replaceAll(",", "");
		if (!isNumber(val))
			return new BigDecimal("0.00");

		BigDecimal decimal = new BigDecimal(val);
		decimal = decimal.setScale(2, RoundingMode.HALF_UP);

		return decimal;

	}

	private static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean isNumber(String value) {
		return isInteger(value) || isDouble(value);
	}

	
	/**
	* 字符串转换成日期
	* @param str
	* @return date
	 * @throws java.text.ParseException 
	*/
	public static Date StrToDate(String str){
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Date date = null;
	   try {
		date = format.parse(str);
	} catch (java.text.ParseException e) {
		e.printStackTrace();
	}
	   return date;
	}
	
	
	public static void main(String[] args) {
		System.out.println(StrToDate("2016-11-28 00:00:00"));
	}
	
	public static String getReplaceAll(String val){
		if(BaseHelpUtils.isNullOrEmpty(val)){
			return "";
		}
		return 
		val.replaceAll("\r", "").replaceAll("\n", "");
	}

}
