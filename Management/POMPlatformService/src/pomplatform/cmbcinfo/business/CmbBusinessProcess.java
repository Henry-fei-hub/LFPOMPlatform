package pomplatform.cmbcinfo.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.pomplatform.db.bean.BaseCmbcAccoutInfo;
import com.pomplatform.db.bean.BaseCmbcTransInfo;
import com.pomplatform.db.dao.CmbcAccoutInfo;
import com.pomplatform.db.dao.CmbcTransInfo;

import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;

public class CmbBusinessProcess {

	private final static SimpleDateFormat SIM_SDF = new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat ALL_SDF = new SimpleDateFormat("yyyyMMddHHmmss");
	//招商银行查询最长日期不能超过100天
	private final static int DEFAULT_CHECK_DAY = 99;
	
	public static String syncAllAccountTransInfoDataToErp(Date beginDate, Date endDate, boolean checkFlag) throws Exception{
		String resultStr = CMBBankUtil.getListAccount();
		Document document = DocumentHelper.parseText(resultStr);
		Element rootElement = document.getRootElement();
		if(CMBBankUtil.checkIsSucess(rootElement)){
			List<Element> ntqList = rootElement.elements("NTQACLSTZ");
			// 获取出账号列表
			for (Element element : ntqList) {
				// 账户账号
				String accnbr = element.elementTextTrim("ACCNBR");
				// 分行号
				String bbknbr = element.elementTextTrim("BBKNBR");
				syncCmbTransInfoToErp(bbknbr, accnbr, beginDate, endDate, checkFlag);
			}
		}
		return null;
	}
	
	public static String syncCmbTransInfoToErp(String bbknbr, String accnbr, Date beginDate, Date endDate, boolean checkFlag) throws Exception{
		//对于需要进行日期检测查询的数据  则进行日期最大天数检测 
		//对于不需要进行日期检测查询的数据则进行日期进行分拆后更新数据
		if(checkFlag){
			int days = DateUtil.generateDaysBetween(endDate, beginDate);
			if(days <= DEFAULT_CHECK_DAY){
				return syncCmbTransInfoToErp(bbknbr, accnbr, beginDate, endDate);
			}else{
				return "查询日期超过范围";
			}
		}else{
			int days = DateUtil.generateDaysBetween(endDate, beginDate);
			if(days <= DEFAULT_CHECK_DAY){
				return syncCmbTransInfoToErp(bbknbr, accnbr, beginDate, endDate);
			}else{
				int addDay = 80;
				//如果日期查询超过99天  以每80天进行依次轮查 
				boolean flag = true;
				while(flag){
					Date tmpEndDate = DateUtil.getNextDayOfDay(beginDate, addDay);
					if(tmpEndDate.compareTo(endDate) >= 0){
						flag = false;
						syncCmbTransInfoToErp(bbknbr, accnbr, beginDate, endDate);
					}else{
						syncCmbTransInfoToErp(bbknbr, accnbr, beginDate, tmpEndDate);
						beginDate = DateUtil.getNextDayOfDay(beginDate, addDay);
					}
				}
				return null;
			}
		}
	}
	
	
	public static String syncCmbTransInfoToErp(String bbknbr, String accnbr, Object beginDate, Object endDate)
			throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("bbknbr", bbknbr);
		params.put("accnbr", accnbr);
		params.put("bgndat", beginDate);
		params.put("enddat", endDate);
		return syncCmbTransInfoToErp(params);
	}

	public static String syncCmbTransInfoToErp(Map<String, Object> params) throws Exception {
		String errorMsg = null;
		// 分行号
		String bbknbr = BaseHelpUtils.getStringValue(params, "bbknbr");
		// 账号
		String accnbr = BaseHelpUtils.getStringValue(params, "accnbr");
		// 起始日期
		Object bgndat = params.get("bgndat");
		// 结束日期
		Object enddat = params.get("enddat");
		if (!BaseHelpUtils.isNullOrEmpty(bbknbr) && !BaseHelpUtils.isNullOrEmpty(accnbr)
				&& !BaseHelpUtils.isNullOrEmpty(bgndat) && !BaseHelpUtils.isNullOrEmpty(enddat)) {
			if (bgndat instanceof String) {
				if (((String) bgndat).length() != 8) {
					errorMsg = String.format("开始日期参数错误 [bgndat = %1$s]", bgndat);
					return errorMsg;
				} else {
					params.put("BGNDAT", ((String) bgndat));
				}
			} else if (bgndat instanceof Date) {
				params.put("BGNDAT", SIM_SDF.format((Date) bgndat));
			}
			if (enddat instanceof String) {
				if (((String) enddat).length() != 8) {
					errorMsg = String.format("结束日期参数错误 enddat[enddat = %1$s]", enddat);
					return errorMsg;
				} else {
					params.put("ENDDAT", ((String) enddat));
				}
			} else if (enddat instanceof Date) {
				params.put("ENDDAT", SIM_SDF.format((Date) enddat));
			}
			params.put("BBKNBR", bbknbr);
			params.put("ACCNBR", accnbr);
			// 设置借贷码C：收入 D：支出
			if (null != params.get("amtcdr")) {
				params.put("AMTCDR", accnbr);
			}
			String resultStr = CMBBankUtil.getTransInfo(params);
			Document document = DocumentHelper.parseText(resultStr);
			Element rootElement = document.getRootElement();
			Date currentDate = new Date();
			// 检测是否查询成功
			if (CMBBankUtil.checkIsSucess(rootElement)) {
				List<Element> ntqList = rootElement.elements("NTQTSINFZ");
				if (ntqList.size() > 0) {
					List<Map<String, Object>> resultMapList = new ArrayList<>();
					for (Element element : ntqList) {
						Map<String, Object> resultMap = new HashMap<>();
						// 交易日(20171212)
						String etydat = element.elementTextTrim("ETYDAT");
						// 交易时间(181212)只有小时有效
						String etytim = element.elementTextTrim("ETYTIM");

						resultMap.put("etydat", etydat);
						resultMap.put("etytim", etytim);

						String transDateStr = etydat + etytim;
						Date transDate = ALL_SDF.parse(transDateStr);
						resultMap.put("transDate", transDate.getTime());
						//起息日
						String vltdat = element.elementTextTrim("VLTDAT");
						if(!BaseHelpUtils.isNullOrEmpty(vltdat)){
							resultMap.put("vltdat", SIM_SDF.parse(vltdat).getTime());
						}
						
						resultMap.put("trscod", element.elementTextTrim("TRSCOD"));
						resultMap.put("naryur", element.elementTextTrim("NARYUR"));
						resultMap.put("trsamtd", element.elementTextTrim("TRSAMTD"));
						resultMap.put("trsamtc", element.elementTextTrim("TRSAMTC"));
						resultMap.put("amtcdr", element.elementTextTrim("AMTCDR"));
						resultMap.put("trsblv", element.elementTextTrim("TRSBLV"));
						resultMap.put("refnbr", element.elementTextTrim("REFNBR"));
						resultMap.put("reqnbr", element.elementTextTrim("REQNBR"));
						resultMap.put("busnam", element.elementTextTrim("BUSNAM"));
						resultMap.put("nusage", element.elementTextTrim("NUSAGE"));
						resultMap.put("yurref", element.elementTextTrim("YURREF"));
						resultMap.put("busnar", element.elementTextTrim("BUSNAR"));
						resultMap.put("otrnar", element.elementTextTrim("OTRNAR"));
						resultMap.put("cRpybbk", element.elementTextTrim("C_RPYBBK"));
						resultMap.put("rpynam", element.elementTextTrim("RPYNAM"));
						resultMap.put("rpyacc", element.elementTextTrim("RPYACC"));
						resultMap.put("rpybbn", element.elementTextTrim("RPYBBN"));
						resultMap.put("rpybnk", element.elementTextTrim("RPYBNK"));
						resultMap.put("rpyadr", element.elementTextTrim("RPYADR"));
						resultMap.put("cGsbbbk", element.elementTextTrim("C_GSBBBK"));
						resultMap.put("gsbacc", element.elementTextTrim("GSBACC"));
						resultMap.put("gsbnam", element.elementTextTrim("GSBNAM"));
						resultMap.put("infflg", element.elementTextTrim("INFFLG"));
						resultMap.put("athflg", element.elementTextTrim("ATHFLG"));
						resultMap.put("chknbr", element.elementTextTrim("CHKNBR"));
						resultMap.put("rsvflg", element.elementTextTrim("RSVFLG"));
						resultMap.put("narext", element.elementTextTrim("NAREXT"));
						resultMap.put("trsanl", element.elementTextTrim("TRSANL"));
						resultMap.put("refsub", element.elementTextTrim("REFSUB"));  
						resultMap.put("frmcod", element.elementTextTrim("FRMCOD"));
						resultMapList.add(resultMap);
					}
					CmbcTransInfo ctiDao = new CmbcTransInfo();
					// 查询的账号+交易日（ETYDAT）+流水号（REFNBR）可以唯一确定一笔交易。
					for (Map<String, Object> map : resultMapList) {
						BaseCmbcTransInfo ctiBean = new BaseCmbcTransInfo();
						ctiBean.setDataFromMap(map);
						if(!BaseHelpUtils.isNullOrEmpty(ctiBean.getEtydat()) && !BaseHelpUtils.isNullOrEmpty(ctiBean.getRefnbr())){
							//检测交易是否唯一   如果存在就不进行插入  
							ctiDao.clear();
							ctiDao.setConditionBankAccount("=", accnbr);
							ctiDao.setConditionEtydat("=", ctiBean.getEtydat());
							ctiDao.setConditionRefnbr("=", ctiBean.getRefnbr());
							if(ctiDao.countRows() <= 0){
								ctiDao.clear();
								
								if(null != ctiBean.getAmtcdr()){
									if(ctiBean.getAmtcdr().equals("C")){
										ctiBean.setTransType(1);
									}else if(ctiBean.getAmtcdr().equals("D")){
										ctiBean.setTransType(2);
									}
								}
								ctiDao.setDataFromBase(ctiBean);
								ctiDao.setCreateTime(currentDate);
								ctiDao.setUpdateTime(currentDate);
								ctiDao.setBankAccount(accnbr);
								ctiDao.save();
							}
						}
						
					}
				}
			} else {
				errorMsg = String.format("查询失败[resultStr = %1$s]", resultStr);
			}
		} else {
			errorMsg = String.format("参数错误[params = %1$s]", params.toString());
		}
		return errorMsg;
	}

	public static void syncCmbBankInfoDataToErp() throws Exception {
		String resultStr = CMBBankUtil.getListAccount();
		Document document = DocumentHelper.parseText(resultStr);
		Element rootElement = document.getRootElement();
		if(CMBBankUtil.checkIsSucess(rootElement)){
			List<Element> ntqList = rootElement.elements("NTQACLSTZ");

			List<Map<String, Object>> paramsList = new ArrayList<>();
			// 获取出账号列表
			for (Element element : ntqList) {
				// 账户名称
				String accname = element.elementTextTrim("ACCNAM");
				// 账户账号
				String accnbr = element.elementTextTrim("ACCNBR");
				// 分行号
				String bbknbr = element.elementTextTrim("BBKNBR");
				Map<String, Object> params = new HashMap<>();
				params.put("ACCNAM", accname);
				params.put("ACCNBR", accnbr);
				params.put("BBKNBR", bbknbr);
				paramsList.add(params);

			}
			if (paramsList.size() > 0) {
				// 通过账号与分行号 查询出该账户的详细信息并保存到数据库
				String accountInfoStr = CMBBankUtil.getAccountInfo(paramsList);
				Date currentDate = new Date();
				Document accInfoDoc = DocumentHelper.parseText(accountInfoStr);
				Element accInfoRootElement = accInfoDoc.getRootElement();
				if (CMBBankUtil.checkIsSucess(accInfoRootElement)) {// 查询成功
					List<Element> ntqaccList = accInfoRootElement.elements("NTQACINFZ");
					List<Map<String, Object>> resultMapList = new ArrayList<>();
					if (ntqaccList.size() > 0) {
						for (Element element : ntqaccList) {
							Map<String, Object> resultMap = new HashMap<>();
							// 币种
							resultMap.put("ccynbr", element.elementTextTrim("CCYNBR"));
							// 币种名称
							resultMap.put("cCcynbr", element.elementTextTrim("C_CCYNBR"));
							resultMap.put("accitm", element.elementTextTrim("ACCITM"));
							resultMap.put("bbknbr", element.elementTextTrim("BBKNBR"));
							resultMap.put("accnbr", element.elementTextTrim("ACCNBR"));
							resultMap.put("accnam", element.elementTextTrim("ACCNAM"));
							resultMap.put("accblv", element.elementTextTrim("ACCBLV"));
							resultMap.put("onlblv", element.elementTextTrim("ONLBLV"));
							resultMap.put("hldblv", element.elementTextTrim("HLDBLV"));
							resultMap.put("avlblv", element.elementTextTrim("AVLBLV"));
							resultMap.put("lmtovr", element.elementTextTrim("LMTOVR"));
							resultMap.put("stscod", element.elementTextTrim("STSCOD"));
							resultMap.put("intcod", element.elementTextTrim("INTCOD"));
							resultMap.put("cIntrat", element.elementTextTrim("C_INTRAT"));
							resultMap.put("intrat", element.elementTextTrim("INTRAT"));
							// 开户日 8位数字 EP:20170202
							String opndat = element.elementTextTrim("OPNDAT");
							if (!BaseHelpUtils.isNullOrEmpty(opndat)) {
								resultMap.put("opndat", SIM_SDF.parse(opndat).getTime());
							}
							// 到期日 8位数字 EP:20170303
							String mutdat = element.elementTextTrim("MUTDAT");
							if (!BaseHelpUtils.isNullOrEmpty(mutdat)) {
								resultMap.put("mutdat", SIM_SDF.parse(mutdat).getTime());
							}
							resultMap.put("inttyp", element.elementTextTrim("INTTYP"));
							resultMap.put("dpstxt", element.elementTextTrim("DPSTXT"));
							resultMapList.add(resultMap);
						}
						CmbcAccoutInfo caiDao = new CmbcAccoutInfo();
						// 更新或者添加数据
						for (Map<String, Object> map : resultMapList) {
							BaseCmbcAccoutInfo caiBean = new BaseCmbcAccoutInfo();
							caiBean.setDataFromMap(map);
							if(!BaseHelpUtils.isNullOrEmpty(caiBean.getAccnbr())){
								//根据账号进行匹配  如果存在则更新  不存在则插入
								caiDao.setConditionAccnbr("=", caiBean.getAccnbr());
								if(null == caiDao.executeQueryOneRow()){
									caiDao.clear();
									caiDao.setDataFromBase(caiBean);
									caiDao.setCreateTime(currentDate);
									caiDao.setUpdateTime(currentDate);
									caiDao.save();
								}else{
									caiDao.setDataFromBase(caiBean);
									caiDao.setUpdateTime(currentDate);
									caiDao.update();
								}
							}
						}
					}

				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("REQNBR", "K0040000038473C");
		System.out.println(CMBBankUtil.getAgentDetail(params));
//		syncCmbBankInfoDataToErp();
//		Date beginDate = SIM_SDF.parse("20171231");
//		Date endDate = SIM_SDF.parse("20180201");
//		syncAllAccountTransInfoDataToErp(beginDate, endDate, false);
	}
}
