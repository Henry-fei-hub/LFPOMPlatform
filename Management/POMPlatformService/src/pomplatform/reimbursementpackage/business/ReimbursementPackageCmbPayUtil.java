package pomplatform.reimbursementpackage.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.pomplatform.db.bean.BaseCmbcPayDetail;
import com.pomplatform.db.bean.BaseCmbcPayment;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseReimbursementPackageSummary;
import com.pomplatform.db.dao.Area;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.CmbcCode;
import com.pomplatform.db.dao.CmbcPayDetail;
import com.pomplatform.db.dao.CmbcPayment;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ReceiveUnitManage;
import com.pomplatform.db.dao.ReimbursementPackage;
import com.pomplatform.db.dao.ReimbursementPackageSummary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.connection.ThreadConnection;
import pomplatform.cmbcinfo.business.CMBBankUtil;
import pomplatform.cmbcinfo.business.CreateCMBBankXmlUtil;
import pomplatform.reimbursementpackage.bean.BaseEmployeeSendMoneyData;
import pomplatform.reimbursementpackage.bean.ConditionEmployeeSendMoneyData;
import pomplatform.reimbursementpackage.query.QueryEmployeeSendMoneyData;

public class ReimbursementPackageCmbPayUtil {

	/**
	 * 币种名称 接口暂时只支持 10-人民币
	 */
	public final static String CCYNBR = "10";

	/**
	 * 结算方式代码 N:普通 F:快速
	 */
	public final static String STLCHN = "N";

	/**
	 * 支付
	 */
	public final static Integer PAY_TYPE_1 = 1; // 支付

	/**
	 * 代发工资
	 */
	public final static Integer PAY_TYPE_2 = 2; // 代发工资

	/**
	 * 代发奖金
	 */
	public final static Integer PAY_TYPE_3 = 3; // 代发奖金

	/**
	 * 代发其他
	 */
	public final static Integer PAY_TYPE_4 = 4; // 代发其他

	/**
	 * 内部转账
	 */
	public final static Integer PAY_TYPE_5 = 5; // 内部转账

	/**
	 * 支付业务模式 前置机查询:00001
	 */
	public final static String BUSMOD = "00001";

	/**
	 * 汇总单状态:未制单
	 */
	public final static Integer PAY_STATUS_1 = 1;

	/**
	 * 汇总单状态:已制单
	 */
	public final static Integer PAY_STATUS_2 = 2;

	/**
	 * 汇总单状态:已提交到网银
	 */
	public final static Integer PAY_STATUS_3 = 3;
	
	/**
	 * 正常支付的单子
	 */
	public final static Integer WITHDRAW_FLAG_1 = 1;
	
	/**
	 * 为退单后重新发起的支付单
	 */
	public final static Integer WITHDRAW_FLAG_2 = 2;
	
	/**
	 * 支付原始对象:个人
	 */
	public final static Integer OBJECT_TYPE_1 = 1;

	/**
	 * 支付原始对象:收款单位
	 */
	public final static Integer OBJECT_TYPE_2 = 2;
	
	/**
	 * 1:待资料补正 
	 */
	public final static Integer WITHDRAW_STATUS_1 = 1;
	
	/**
	 * 2:可提起支付 
	 */
	public final static Integer WITHDRAW_STATUS_2 = 2;
	
	/**
	 * 3:已提起支付
	 */
	public final static Integer WITHDRAW_STATUS_3 = 3;
	
	
    /**
     * 支付详情表状态:数据录入
     */
    private final static Integer DETAIL_STATUS_1 = 1;
    
    /**
     * 支付详情表状态:成功
     */
    private final static Integer DETAIL_STATUS_2 = 2;
    
    /**
     * 支付详情表状态:失败
     */
    private final static Integer DETAIL_STATUS_3 = 3;
    
    /**
     * 支付详情表状态:撤销
     */
    private final static Integer DETAIL_STATUS_4 = 4;
    
    /**
     * 支付详情表状态:退票
     */
    private final static Integer DETAIL_STATUS_5 = 5;
	
	
	public final static SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyyMMdd");

	public final static SimpleDateFormat SDF_TIME = new SimpleDateFormat("HHmmss");

	public static void main(String[] args) throws Exception {
		 makeBill(1969);
//		cmbcPay(618);
	}

	/**
	 * 对于支付失败的单 重新发起申请
	 * @param cmbcPaymentId
	 * @return
	 * @throws Exception
	 */
	public static String repayDefeatDraw(int cmbcPaymentId) throws Exception{
		int status = 1;
		String errorMsg = "";
		CmbcPayment cpDao = new CmbcPayment();
		cpDao.setCmbcPaymentId(cmbcPaymentId);
		if(cpDao.load() && cpDao.getPayStatus() == 1){
			CmbcPayDetail cpdDao = new CmbcPayDetail();
			cpdDao.setConditionCmbcPaymentId("=", cmbcPaymentId);
			BaseCmbcPayDetail baseCmbcPayDetail = cpdDao.executeQueryOneRow();
			if(null != baseCmbcPayDetail){
				Date currentDate = new Date();
				String dateStr = SDF_DATE.format(currentDate);
				List<Map<String, Object>> payList = new ArrayList<>();
				Map<String, Object> dataPar = new HashMap<>();
				dataPar.put("YURREF", baseCmbcPayDetail.getYurref());
				dataPar.put("DBTACC", baseCmbcPayDetail.getDbtacc());
				dataPar.put("DBTBBK", baseCmbcPayDetail.getDbtbbk());
				dataPar.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
				dataPar.put("CCYNBR", baseCmbcPayDetail.getCcynbr());
				dataPar.put("STLCHN", baseCmbcPayDetail.getStlchn());
				dataPar.put("BUSNAR", baseCmbcPayDetail.getBusnar());
				dataPar.put("NUSAGE", baseCmbcPayDetail.getNusage());
				dataPar.put("CRTBNK", baseCmbcPayDetail.getCrtbnk());
				dataPar.put("CRTACC", baseCmbcPayDetail.getCrtacc());
				dataPar.put("CRTNAM", baseCmbcPayDetail.getCrtnam());
				dataPar.put("BNKFLG", baseCmbcPayDetail.getBnkflg());
				dataPar.put("CRTPVC", baseCmbcPayDetail.getCrtpvc());
				dataPar.put("CRTCTY", baseCmbcPayDetail.getCrtcty());
				dataPar.put("EPTDAT", dateStr);
				payList.add(dataPar);

				Map<String, Object> sendDataMap = new HashMap<>();
				sendDataMap.put("BUSCOD", "N02030");// 支付
				sendDataMap.put("BUSMOD", BUSMOD);
				String pakageStr = CreateCMBBankXmlUtil.createPaymentXML(sendDataMap, payList);
				String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
				// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
				Document document = DocumentHelper.parseText(resultStr);
				Element rootElement = document.getRootElement();
				Element infoElement = rootElement.element("INFO");
				Element retcodeElement = infoElement.element("RETCOD");
				Element errorElement = infoElement.element("ERRMSG");

				String retcodeStr = retcodeElement.getStringValue();
				if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
					// 检测REQSTS=’FIN’ 并且
					// RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理（注意：支付请求的返回并非表示支付成功，支付是否成功一定要查询支付结果后才能取得）
					List<Element> list = rootElement.elements("NTQPAYRQZ");
					if (list.size() > 0) {
						//单笔支付  List的大小为1
						for (Element element : list) {
							boolean flag = false;
							Element sqrnbrElement = element.element("SQRNBR");
							Element yurrefElement = element.element("YURREF");
							Element reqstsElement = element.element("REQSTS");
							Element rtnflgElement = element.element("RTNFLG");
							Element errtxtElement = element.element("ERRTXT");
							String tmpErrorMsg = null;
							if (null != errtxtElement) {
								tmpErrorMsg = errtxtElement.getStringValue();
							}

							if (reqstsElement.getStringValue().equals("AUT")) {// 接口文档描述不全
																				// 在等待审批的情况
																				// 其实已经表示业务请求成功
								flag = true;
							} else if (reqstsElement.getStringValue().equals("FIN")) {
								if (!rtnflgElement.getStringValue().equals("F")) {
									flag = true;
								}
							}
							cpDao.setEpttim(currentDate);
							cpDao.setOprdat(currentDate);
							if (!flag) {
								cpDao.setPayStatus(1);
								cpDao.setErrorMsg(tmpErrorMsg);
							} else {
								cpDao.setPayStatus(2);
							}
							cpDao.update();
						}
					} else {
						cpDao.setPayStatus(1);// 通讯失败
												// 定时器在检测的时候会检测该状态的订单
						cpDao.setErrorMsg("没有找到  招商银行[NTQPAYRQZ]报文数据");
						cpDao.setEpttim(currentDate);
						cpDao.setOprdat(currentDate);
						cpDao.update();
					}
				} else if (retcodeStr.equals("1") || retcodeStr.equals("-9")) {// 交易可疑

				} else {
					cpDao.setPayStatus(1);// 通讯失败 定时器在检测的时候会忽略该状态的订单
											// //该类订单需要根据错误信息处理好后重新发起支付
					cpDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
					cpDao.setEpttim(currentDate);
					cpDao.setOprdat(currentDate);
					cpDao.update();
				}
			}else{
				status = -1;
				errorMsg = "支付单数据错误没有查询到详情支付数据 cmbcPaymentId =" + cmbcPaymentId;
			}
		}else{
			status = -1;
			errorMsg = "支付单数据错误 cmbcPaymentId =" + cmbcPaymentId;
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
	
		return bc.toJSON(status, errorMsg) ;
	}
	
	/**
	 * 退单后的重新支付
	 * @param cmbcPayDetailId
	 * @return
	 * @throws Exception
	 */
	public static String cmbcWithdrawPay(int cmbcPayDetailId) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = "";
		CmbcPayDetail cpdDao = new CmbcPayDetail();
		cpdDao.setCmbcPayDetailId(cmbcPayDetailId);
		if(cpdDao.load()){
			if(Objects.equals(cpdDao.getWithdrawStatus(), WITHDRAW_STATUS_2)){
				Date currentDate = new Date();
				String dateStr = SDF_DATE.format(currentDate);
				if (Objects.equals(cpdDao.getType(), PAY_TYPE_1)) {// 支付
					Map<String, Object> sendDataMap = new HashMap<>();
					sendDataMap.put("BUSCOD", "N02030");// 支付
					sendDataMap.put("BUSMOD", BUSMOD);
					List<Map<String, Object>> payList = new ArrayList<>();
					List<Integer> cmbcIds = new ArrayList<>();
					Map<String, Object> dataPar = new HashMap<>();
					dataPar.put("YURREF", cpdDao.getYurref());
					dataPar.put("DBTACC", cpdDao.getDbtacc());
					dataPar.put("DBTBBK", cpdDao.getDbtbbk());
					dataPar.put("TRSAMT", cpdDao.getTrsamt());
					dataPar.put("CCYNBR", cpdDao.getCcynbr());
					dataPar.put("STLCHN", cpdDao.getStlchn());
					dataPar.put("NUSAGE", cpdDao.getNusage());
					dataPar.put("BUSNAR", cpdDao.getBusnar());
					dataPar.put("CRTBNK", cpdDao.getCrtbnk());
					dataPar.put("CRTACC", cpdDao.getCrtacc());
					dataPar.put("CRTNAM", cpdDao.getCrtnam());
					dataPar.put("BNKFLG", cpdDao.getBnkflg());
					dataPar.put("CRTPVC", cpdDao.getCrtpvc());
					dataPar.put("CRTCTY", cpdDao.getCrtcty());
					dataPar.put("EPTDAT", dateStr);
					payList.add(dataPar);
					String pakageStr = CreateCMBBankXmlUtil.createPaymentXML(sendDataMap, payList);
					String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
					// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
					Document document = DocumentHelper.parseText(resultStr);
					Element rootElement = document.getRootElement();
					Element infoElement = rootElement.element("INFO");
					Element retcodeElement = infoElement.element("RETCOD");
					Element errorElement = infoElement.element("ERRMSG");

					String retcodeStr = retcodeElement.getStringValue();
					cpdDao.setEptdat(currentDate);
					cpdDao.setOprdat(currentDate);
					cpdDao.setWithdrawStatus(ReimbursementPackageCmbPayUtil.WITHDRAW_STATUS_3);
					if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
						// 检测REQSTS=’FIN’ 并且
						// RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理（注意：支付请求的返回并非表示支付成功，支付是否成功一定要查询支付结果后才能取得）
						List<Element> list = rootElement.elements("NTQPAYRQZ");
						if (list.size() > 0) {
							for (Element element : list) {
								boolean flag = false;
								Element sqrnbrElement = element.element("SQRNBR");
								Element yurrefElement = element.element("YURREF");
								Element reqstsElement = element.element("REQSTS");
								Element rtnflgElement = element.element("RTNFLG");
								Element errtxtElement = element.element("ERRTXT");
								String tmpErrorMsg = null;
								if (null != errtxtElement) {
									tmpErrorMsg = errtxtElement.getStringValue();
								}

								if (reqstsElement.getStringValue().equals("AUT")) {// 接口文档描述不全
																					// 在等待审批的情况
																					// 其实已经表示业务请求成功
									flag = true;
								} else if (reqstsElement.getStringValue().equals("FIN")) {
									if (!rtnflgElement.getStringValue().equals("F")) {
										flag = true;
									}
								}
								if (!flag) {
									cpdDao.setStatus(DETAIL_STATUS_3);
									cpdDao.setErrorMsg(tmpErrorMsg);
								} 
							}
						} else {
							cpdDao.setErrorMsg("没有找到  招商银行[NTQPAYRQZ]报文数据");
						}
					} else if (retcodeStr.equals("1") || retcodeStr.equals("-9")) {// 交易可疑
						cpdDao.setStatus(DETAIL_STATUS_3);
						cpdDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() + "--交易可疑": "交易可疑");
					} else {
						cpdDao.setStatus(DETAIL_STATUS_3);
						cpdDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
					}
				} else if (Objects.equals(cpdDao.getType(), PAY_TYPE_5)) {// 内部转账
					Map<String, Object> sendDataMap = new HashMap<>();
					sendDataMap.put("BUSCOD", "N02020");// 内部转账
					sendDataMap.put("BUSMOD", BUSMOD);
					List<Map<String, Object>> nbzzList = new ArrayList<>();
					Map<String, Object> dataPar = new HashMap<>();
					dataPar.put("YURREF", cpdDao.getYurref());
					dataPar.put("DBTACC", cpdDao.getDbtacc());
					dataPar.put("DBTBBK", cpdDao.getDbtbbk());
					dataPar.put("TRSAMT", cpdDao.getTrsamt());
					dataPar.put("CCYNBR", cpdDao.getCcynbr());
					dataPar.put("BUSNAR", cpdDao.getBusnar());
					dataPar.put("STLCHN", cpdDao.getStlchn());
					dataPar.put("NUSAGE", cpdDao.getNusage());
					dataPar.put("CRTACC", cpdDao.getCrtacc());
					dataPar.put("CRTBBK", cpdDao.getCrtbbk());
					dataPar.put("EPTDAT", dateStr);
					nbzzList.add(dataPar);
					String pakageStr = CreateCMBBankXmlUtil.createInsidePaymentXML(sendDataMap, nbzzList);
					String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
					// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
					Document document = DocumentHelper.parseText(resultStr);
					Element rootElement = document.getRootElement();
					Element infoElement = rootElement.element("INFO");
					Element retcodeElement = infoElement.element("RETCOD");
					Element errorElement = infoElement.element("ERRMSG");

					String retcodeStr = retcodeElement.getStringValue();
					cpdDao.setWithdrawStatus(ReimbursementPackageCmbPayUtil.WITHDRAW_STATUS_3);
					if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
						// 检测REQSTS=’FIN’ 并且
						// RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理（注意：支付请求的返回并非表示支付成功，支付是否成功一定要查询支付结果后才能取得）
						List<Element> list = rootElement.elements("NTQPAYRQZ");
						if (list.size() > 0) {
							for (Element element : list) {
								boolean flag = false;
								Element sqrnbrElement = element.element("SQRNBR");
								Element yurrefElement = element.element("YURREF");
								Element reqstsElement = element.element("REQSTS");
								Element rtnflgElement = element.element("RTNFLG");
								Element errtxtElement = element.element("ERRTXT");
								String tmpErrorMsg = null;
								if (null != errtxtElement) {
									tmpErrorMsg = errtxtElement.getStringValue();
								}

								if (reqstsElement.getStringValue().equals("AUT")) {// 接口文档描述不全
																					// 在等待审批的情况
																					// 其实已经表示业务请求成功
									flag = true;
								} else if (reqstsElement.getStringValue().equals("FIN")) {
									if (!rtnflgElement.getStringValue().equals("F")) {
										flag = true;
									}
								}
								cpdDao.setEptdat(currentDate);
								cpdDao.setOprdat(currentDate);
								if (!flag) {
									cpdDao.setStatus(DETAIL_STATUS_3);
									cpdDao.setErrorMsg(tmpErrorMsg);
								} 
							}
						} else {
							cpdDao.setStatus(DETAIL_STATUS_3);
						}
					} else if (retcodeStr.equals("1") || retcodeStr.equals("-9")) {// 交易可疑
						cpdDao.setStatus(DETAIL_STATUS_3);
						cpdDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() + "--交易可疑": "交易可疑");
					} else {
						cpdDao.setStatus(DETAIL_STATUS_3);
						cpdDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
					}
					
				} else if (Objects.equals(cpdDao.getType(), PAY_TYPE_2)
						|| Objects.equals(cpdDao.getType(), PAY_TYPE_3)
						|| Objects.equals(cpdDao.getType(), PAY_TYPE_4)) {// 代发
					Map<String, Object> mainDataParams = new HashMap<>();
					mainDataParams.put("BUSMOD", BUSMOD);
					mainDataParams.put("C_TRSTYP", cpdDao.getTrstypName());
					mainDataParams.put("TRSTYP", cpdDao.getTrstyp());
					mainDataParams.put("DBTACC", cpdDao.getDbtacc());
					mainDataParams.put("BBKNBR", cpdDao.getDbtbbk());
					mainDataParams.put("EPTDAT", dateStr);
					mainDataParams.put("YURREF", cpdDao.getYurref());
					mainDataParams.put("TOTAL", cpdDao.getTotalNum());
					mainDataParams.put("SUM", cpdDao.getTotalAmount());

					if (Objects.equals(cpdDao.getType(), PAY_TYPE_2)) {// 代发工资
						mainDataParams.put("BUSCOD", "N03010");
					} else {// 代发奖金与代发其他(报销)
						mainDataParams.put("BUSCOD", "N03020");
					}
					mainDataParams.put("MEMO", cpdDao.getNusage());
					mainDataParams.put("GRTFLG", "Y");
					
					List<Map<String, Object>> childList = new ArrayList<>();
					Map<String, Object> childParams = new HashMap<>();
					childParams.put("ACCNBR", cpdDao.getCrtacc());
					childParams.put("CLTNAM", cpdDao.getCrtnam());
					childParams.put("TRSAMT", cpdDao.getTrsamt());
					childParams.put("BNKFLG", cpdDao.getBnkflg());
					childParams.put("EACBNK", cpdDao.getCrtbnk());
					childParams.put("EACCTY", cpdDao.getEaccty());
					childList.add(childParams);

					// 进行代发工资与代发奖金报文发送
					String pakageStr = CreateCMBBankXmlUtil.createAgentRequestXML(mainDataParams, childList);
					String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
					// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
					Document document = DocumentHelper.parseText(resultStr);
					Element rootElement = document.getRootElement();
					Element infoElement = rootElement.element("INFO");
					Element retcodeElement = infoElement.element("RETCOD");
					Element errorElement = infoElement.element("ERRMSG");

					String retcodeStr = retcodeElement.getStringValue();
					
					cpdDao.setEptdat(currentDate);
					cpdDao.setOprdat(currentDate);
					cpdDao.setWithdrawStatus(ReimbursementPackageCmbPayUtil.WITHDRAW_STATUS_3);
					if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
					} else {
						cpdDao.setStatus(DETAIL_STATUS_3);
						cpdDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
					}
				}
				cpdDao.update();
			}else{
				status = -1;
				errorMsg = String.format("cmbcPayDetailId[%1$s]该单未处于可提交支付状态", cmbcPayDetailId);
			}
			
		}else{
			status = -1;
			errorMsg = String.format("cmbcPayDetailId[%1$s]数据错误", cmbcPayDetailId);
		}
		return bc.toJSON(status, errorMsg);
	}
	
	
	/**
	 * 新支付方法
	 * 
	 * @param packageId
	 * @return
	 * @throws Exception
	 */
	public static String cmbcPay(int packageId) throws Exception {
		// 没有开启数据库事务？
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = "";
		ReimbursementPackage rpDao = new ReimbursementPackage();
		rpDao.setReimbursementPackageId(packageId);
		if (rpDao.load()) {
			// 检测是否是已制单状态
			if (Objects.equals(rpDao.getPayStatus(), PAY_STATUS_2)) {
				// 查询招商银行支付表，是否有该报销打包单的支付信息
				CmbcPayment cpDao = new CmbcPayment();
				cpDao.setConditionReimbursementPackageId("=", packageId);
				cpDao.setConditionPayStatus("=", 0);
				List<BaseCmbcPayment> cpList = cpDao.conditionalLoad();
				if (cpList.size() > 0) {
					try {
						CMBBankUtil.getSysInfo();
					} catch (Exception e) {
						throw new Exception("前置机异常,请检查机器是否开启与网络是否畅通。");
					}
					// 更新该笔报销打包单的支付状态为发起银行支付状态
					Date currentDate = new Date();
					rpDao.setPayStatus(PAY_STATUS_3);
					rpDao.setPayTime(currentDate);
					rpDao.setIsOnlinePay(true);
					rpDao.update();
					
					String dateStr = SDF_DATE.format(currentDate);
					// 装入招行支付明细表，查询条件为打包ID和支付状态？
					CmbcPayDetail cpdDao = new CmbcPayDetail();
					cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_1);
					cpdDao.setConditionReimbursementPackageId("=", packageId);
					List<BaseCmbcPayDetail> cpdList = cpdDao.conditionalLoad();

					List<BaseCmbcPayment> payCpList = new ArrayList<>();

					List<BaseCmbcPayment> nbzzCpList = new ArrayList<>();

					for (BaseCmbcPayment baseCmbcPayment : cpList) {
						// 对于支付与内部转账需要单独汇总
						// 对于代发 直接查询子数据封装报文即可

						if (Objects.equals(baseCmbcPayment.getType(), PAY_TYPE_1)) {// 支付
							payCpList.add(baseCmbcPayment);
						} else if (Objects.equals(baseCmbcPayment.getType(), PAY_TYPE_5)) {// 内部转账
							nbzzCpList.add(baseCmbcPayment);
						} else if (Objects.equals(baseCmbcPayment.getType(), PAY_TYPE_2)
								|| Objects.equals(baseCmbcPayment.getType(), PAY_TYPE_3)
								|| Objects.equals(baseCmbcPayment.getType(), PAY_TYPE_4)) {// 代发
 
							Map<String, Object> mainDataParams = new HashMap<>();
							mainDataParams.put("BUSMOD", BUSMOD);
							mainDataParams.put("C_TRSTYP", baseCmbcPayment.getTrstypName());
							mainDataParams.put("TRSTYP", baseCmbcPayment.getTrstyp());
							mainDataParams.put("DBTACC", baseCmbcPayment.getDbtacc());
							mainDataParams.put("BBKNBR", baseCmbcPayment.getDbtbbk());
							mainDataParams.put("EPTDAT", dateStr);
							mainDataParams.put("YURREF", baseCmbcPayment.getYurref());
							mainDataParams.put("TOTAL", baseCmbcPayment.getTotalNum());
							mainDataParams.put("SUM", baseCmbcPayment.getTotalAmount());

							if (Objects.equals(baseCmbcPayment.getType(), PAY_TYPE_2)) {// 代发工资
								mainDataParams.put("BUSCOD", "N03010");
							} else {// 代发奖金与代发其他(报销)
								mainDataParams.put("BUSCOD", "N03020");
							}
							mainDataParams.put("MEMO", baseCmbcPayment.getNusage());
							mainDataParams.put("GRTFLG", "Y");
							// 批量代发报文封装
							List<Map<String, Object>> childList = new ArrayList<>();
							for (BaseCmbcPayDetail baseCmbcPayDetail : cpdList) {
								if (Objects.equals(baseCmbcPayment.getCmbcPaymentId(),
										baseCmbcPayDetail.getCmbcPaymentId())) {
									Map<String, Object> childParams = new HashMap<>();
									childParams.put("ACCNBR", baseCmbcPayDetail.getCrtacc());
									childParams.put("CLTNAM", baseCmbcPayDetail.getCrtnam());
									childParams.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
									childParams.put("BNKFLG", baseCmbcPayDetail.getBnkflg());
									childParams.put("EACBNK", baseCmbcPayDetail.getCrtbnk());
									childParams.put("EACCTY", baseCmbcPayDetail.getEaccty());
									childList.add(childParams);
								}
							}
							// 进行代发工资与代发奖金报文发送
							String pakageStr = CreateCMBBankXmlUtil.createAgentRequestXML(mainDataParams, childList);
							String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
							// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
							Document document = DocumentHelper.parseText(resultStr);
							Element rootElement = document.getRootElement();
							Element infoElement = rootElement.element("INFO");
							Element retcodeElement = infoElement.element("RETCOD");
							Element errorElement = infoElement.element("ERRMSG");

							String retcodeStr = retcodeElement.getStringValue();
							if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
								cpDao.clear();
								cpDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
								cpDao.setEpttim(currentDate);
								cpDao.setOprdat(currentDate);
								cpDao.setPayStatus(2);// 通讯成功 定时器在检测的时候会检测该状态的订单
								cpDao.conditionalUpdate();
							} else {
								cpDao.clear();
								cpDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
								cpDao.setEpttim(currentDate);
								cpDao.setOprdat(currentDate);
								cpDao.setPayStatus(1);// 通讯失败 定时器在检测的时候会忽略该状态的订单
														// //该类订单需要根据错误信息处理好后重新发起支付
								cpDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
								cpDao.conditionalUpdate();
							}
						}
					}
					// 处理支付报文 //每一条主表对应一条详细信息
					// 支付/内部转账与代发不同 批量时 支付/内部转账每一笔都需要一个业务参考号 ; 代发只需要一个
					// 支付与转账 优化 //限制最大30笔一起批量支付 (接口限制) 公司业务一个汇总单暂时没有这么多支付流水
					// 但需要优化
					if (payCpList.size() > 0) {
						// 支付
						List<Map<String, Object>> payList = new ArrayList<>();
						List<Integer> cmbcIds = new ArrayList<>();
						for (BaseCmbcPayment baseCmbcPayment : payCpList) {
							for (BaseCmbcPayDetail baseCmbcPayDetail : cpdList) {
								if (baseCmbcPayment.getCmbcPaymentId().equals(baseCmbcPayDetail.getCmbcPaymentId())) {
									Map<String, Object> dataPar = new HashMap<>();
									dataPar.put("YURREF", baseCmbcPayDetail.getYurref());
									dataPar.put("DBTACC", baseCmbcPayDetail.getDbtacc());
									dataPar.put("DBTBBK", baseCmbcPayDetail.getDbtbbk());
									dataPar.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
									dataPar.put("CCYNBR", baseCmbcPayDetail.getCcynbr());
									dataPar.put("STLCHN", baseCmbcPayDetail.getStlchn());
									dataPar.put("NUSAGE", baseCmbcPayDetail.getNusage());
									dataPar.put("BUSNAR", baseCmbcPayDetail.getBusnar());
									dataPar.put("CRTBNK", baseCmbcPayDetail.getCrtbnk());
									dataPar.put("CRTACC", baseCmbcPayDetail.getCrtacc());
									dataPar.put("CRTNAM", baseCmbcPayDetail.getCrtnam());
									dataPar.put("BNKFLG", baseCmbcPayDetail.getBnkflg());
									dataPar.put("CRTPVC", baseCmbcPayDetail.getCrtpvc());
									dataPar.put("CRTCTY", baseCmbcPayDetail.getCrtcty());
									dataPar.put("EPTDAT", dateStr);
									payList.add(dataPar);
									cmbcIds.add(baseCmbcPayment.getCmbcPaymentId());
									break;
								}
							}
						}
						if (payList.size() > 0) {
							Map<String, Object> sendDataMap = new HashMap<>();
							sendDataMap.put("BUSCOD", "N02030");// 支付
							sendDataMap.put("BUSMOD", BUSMOD);
							String pakageStr = CreateCMBBankXmlUtil.createPaymentXML(sendDataMap, payList);
							String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
							// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
							Document document = DocumentHelper.parseText(resultStr);
							Element rootElement = document.getRootElement();
							Element infoElement = rootElement.element("INFO");
							Element retcodeElement = infoElement.element("RETCOD");
							Element errorElement = infoElement.element("ERRMSG");

							String retcodeStr = retcodeElement.getStringValue();
							if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
								// 检测REQSTS=’FIN’ 并且
								// RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理（注意：支付请求的返回并非表示支付成功，支付是否成功一定要查询支付结果后才能取得）
								List<Element> list = rootElement.elements("NTQPAYRQZ");
								if (list.size() > 0) {
									for (Element element : list) {
										boolean flag = false;
										Element sqrnbrElement = element.element("SQRNBR");
										Element yurrefElement = element.element("YURREF");
										Element reqstsElement = element.element("REQSTS");
										Element rtnflgElement = element.element("RTNFLG");
										Element errtxtElement = element.element("ERRTXT");
										String tmpErrorMsg = null;
										if (null != errtxtElement) {
											tmpErrorMsg = errtxtElement.getStringValue();
										}

										if (reqstsElement.getStringValue().equals("AUT")) {// 接口文档描述不全
																							// 在等待审批的情况
																							// 其实已经表示业务请求成功
											flag = true;
										} else if (reqstsElement.getStringValue().equals("FIN")) {
											if (!rtnflgElement.getStringValue().equals("F")) {
												flag = true;
											}
										}
										cpDao.clear();
										cpDao.setConditionYurref("=", yurrefElement.getStringValue());
										cpDao.setEpttim(currentDate);
										cpDao.setOprdat(currentDate);
										if (!flag) {
											cpDao.setPayStatus(1);
											cpDao.setErrorMsg(tmpErrorMsg);
										} else {
											cpDao.setPayStatus(2);
										}
										cpDao.conditionalUpdate();
									}
								} else {
									cpDao.clear();
									cpDao.addCondition(BaseCmbcPayDetail.CS_CMBC_PAYMENT_ID, "in", cmbcIds.toArray());
									cpDao.setPayStatus(1);// 通讯失败
															// 定时器在检测的时候会检测该状态的订单
									cpDao.setErrorMsg("没有找到  招商银行[NTQPAYRQZ]报文数据");
									cpDao.setEpttim(currentDate);
									cpDao.setOprdat(currentDate);
									cpDao.conditionalUpdate();
								}
							} else if (retcodeStr.equals("1") || retcodeStr.equals("-9")) {// 交易可疑

							} else {
								cpDao.clear();
								cpDao.addCondition(BaseCmbcPayDetail.CS_CMBC_PAYMENT_ID, "in", cmbcIds.toArray());
								cpDao.setPayStatus(1);// 通讯失败 定时器在检测的时候会忽略该状态的订单
														// //该类订单需要根据错误信息处理好后重新发起支付
								cpDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
								cpDao.setEpttim(currentDate);
								cpDao.setOprdat(currentDate);
								cpDao.conditionalUpdate();
							}
						}
					}
					if (nbzzCpList.size() > 0) {
						// 内部转账
						List<Map<String, Object>> nbzzList = new ArrayList<>();
						List<Integer> cmbcIds = new ArrayList<>();
						for (BaseCmbcPayment baseCmbcPayment : nbzzCpList) {
							for (BaseCmbcPayDetail baseCmbcPayDetail : cpdList) {
								if (baseCmbcPayment.getCmbcPaymentId().equals(baseCmbcPayDetail.getCmbcPaymentId())) {
									Map<String, Object> dataPar = new HashMap<>();
									dataPar.put("YURREF", baseCmbcPayDetail.getYurref());
									dataPar.put("DBTACC", baseCmbcPayDetail.getDbtacc());
									dataPar.put("DBTBBK", baseCmbcPayDetail.getDbtbbk());
									dataPar.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
									dataPar.put("CCYNBR", baseCmbcPayDetail.getCcynbr());
									dataPar.put("STLCHN", baseCmbcPayDetail.getStlchn());
									dataPar.put("NUSAGE", baseCmbcPayDetail.getNusage());
									dataPar.put("BUSNAR", baseCmbcPayDetail.getBusnar());
									dataPar.put("CRTACC", baseCmbcPayDetail.getCrtacc());
									dataPar.put("CRTBBK", baseCmbcPayDetail.getCrtbbk());
									dataPar.put("EPTDAT", dateStr);
									nbzzList.add(dataPar);
									cmbcIds.add(baseCmbcPayment.getCmbcPaymentId());
									break;
								}
							}
						}
						// 进行内部转账报文发送
						if (nbzzList.size() > 0) {
							Map<String, Object> sendDataMap = new HashMap<>();
							sendDataMap.put("BUSCOD", "N02020");// 内部转账
							sendDataMap.put("BUSMOD", BUSMOD);
							String pakageStr = CreateCMBBankXmlUtil.createInsidePaymentXML(sendDataMap, nbzzList);
							String resultStr = CMBBankUtil.sendPackageToCMB(pakageStr);
							// 根据返回结果处理状态数据 //对详细结果进入定时器进行查询
							Document document = DocumentHelper.parseText(resultStr);
							Element rootElement = document.getRootElement();
							Element infoElement = rootElement.element("INFO");
							Element retcodeElement = infoElement.element("RETCOD");
							Element errorElement = infoElement.element("ERRMSG");

							String retcodeStr = retcodeElement.getStringValue();
							if (retcodeStr.equals("0")) {// 表示与前置机通讯成功
								// 检测REQSTS=’FIN’ 并且
								// RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理（注意：支付请求的返回并非表示支付成功，支付是否成功一定要查询支付结果后才能取得）
								List<Element> list = rootElement.elements("NTQPAYRQZ");
								if (list.size() > 0) {
									for (Element element : list) {
										boolean flag = false;
										Element sqrnbrElement = element.element("SQRNBR");
										Element yurrefElement = element.element("YURREF");
										Element reqstsElement = element.element("REQSTS");
										Element rtnflgElement = element.element("RTNFLG");
										Element errtxtElement = element.element("ERRTXT");
										String tmpErrorMsg = null;
										if (null != errtxtElement) {
											tmpErrorMsg = errtxtElement.getStringValue();
										}

										if (reqstsElement.getStringValue().equals("AUT")) {// 接口文档描述不全
																							// 在等待审批的情况
																							// 其实已经表示业务请求成功
											flag = true;
										} else if (reqstsElement.getStringValue().equals("FIN")) {
											if (!rtnflgElement.getStringValue().equals("F")) {
												flag = true;
											}
										}
										cpDao.clear();
										cpDao.setConditionYurref("=", yurrefElement.getStringValue());
										cpDao.setEpttim(currentDate);
										cpDao.setOprdat(currentDate);
										if (!flag) {
											cpDao.setPayStatus(1);
											cpDao.setErrorMsg(tmpErrorMsg);
										} else {
											cpDao.setPayStatus(2);
										}
										cpDao.conditionalUpdate();
									}
								} else {
									cpDao.clear();
									cpDao.addCondition(BaseCmbcPayDetail.CS_CMBC_PAYMENT_ID, "in", cmbcIds.toArray());
									cpDao.setPayStatus(1);// 通讯失败
															// 定时器在检测的时候忽略该状态的订
									cpDao.setErrorMsg("没有找到  招商银行[NTQPAYRQZ]报文数据");
									cpDao.setEpttim(currentDate);
									cpDao.setOprdat(currentDate);
									cpDao.conditionalUpdate();
								}
							} else if (retcodeStr.equals("1") || retcodeStr.equals("-9")) {// 交易可疑

							} else {
								cpDao.clear();
								cpDao.addCondition(BaseCmbcPayDetail.CS_CMBC_PAYMENT_ID, "in", cmbcIds.toArray());
								cpDao.setPayStatus(1);// 通讯失败 定时器在检测的时候会忽略该状态的订单
														// //该类订单需要根据错误信息处理好后重新发起支付
								cpDao.setErrorMsg(null != errorElement ? errorElement.getStringValue() : null);
								cpDao.setEpttim(currentDate);
								cpDao.setOprdat(currentDate);
								cpDao.conditionalUpdate();
							}
						}
					}

				}
			}
		} else {
			status = -1;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	public static String getRemarkBySummaryId(int summaryId) throws SQLException{
		String remark = "";
		ReimbursementPackageSummary rpsDao = new ReimbursementPackageSummary();
		rpsDao.setReimbursementPackageSummaryId(summaryId);
		if(rpsDao.load()){
			StringBuilder sql = new StringBuilder();
			sql.append(BaseProcessBillList.CS_PROCESS_BILL_LIST_ID)
				.append(" in (SELECT process_bill_list_id FROM reimbursement_package_details where reimbursement_package_id = ")
				.append(rpsDao.getReimbursementPackageId())
				.append(" and self_bank_account ='")
				.append(rpsDao.getSelfBankAccount())
				.append("')");
			ProcessBillList pblDao = new ProcessBillList();
			List<BaseProcessBillList> processBillList = pblDao.conditionalLoad(sql.toString());
			int index = 0;
			for (BaseProcessBillList baseProcessBillList : processBillList) {
				if(!BaseHelpUtils.isNullOrEmpty(baseProcessBillList.getRemark())){
					if(index != 0){
						remark += "|";
					}
					remark += baseProcessBillList.getRemark();
					index ++;
				}
			}
		}
		return remark;
	}
	
	/**
	 * 检测与分拆发放金额 对于超过10万的金额需要进行分拆
	 * @param summaryId
	 * @param salaryList
	 * @return
	 * @throws SQLException 
	 */
	public static BaseCollection<BaseEmployeeSendMoneyData> checkAndGetSendMoneyData(BaseReimbursementPackageSummary baseReimbursementPackageSummary) throws SQLException{
		QueryEmployeeSendMoneyData dao = new QueryEmployeeSendMoneyData();
		ConditionEmployeeSendMoneyData c = new ConditionEmployeeSendMoneyData();
		c.setEmployeeFundIssuanceId(baseReimbursementPackageSummary.getEmployeeFundIssuanceId());
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		BaseCollection<BaseEmployeeSendMoneyData> result = dao.executeQuery(c.getKeyValues(),
				c);
		List<BaseEmployeeSendMoneyData> salaryList = result.getCollections();
		List<BaseEmployeeSendMoneyData> list = new ArrayList<>();
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseEmployeeSendMoneyData> bc = new BaseCollection<>();
		BigDecimal checkTotalMoney = BigDecimal.ZERO;
		// 过滤掉不合格的数据与检测数据是否初步合格与超过代发金额分拆
		for (BaseEmployeeSendMoneyData baseSalarySendDataPay : salaryList) {
			if (null != baseSalarySendDataPay.getFactSalary() && baseSalarySendDataPay.getFactSalary().compareTo(BigDecimal.ZERO) > 0) {
				if (!BaseHelpUtils.isNullOrEmpty(baseSalarySendDataPay.getBankAccount())) {
					BigDecimal payAmount = baseSalarySendDataPay.getFactSalary();
					checkTotalMoney = checkTotalMoney.add(payAmount);
					if(payAmount.compareTo(ReimbursementPackageProcessor.MAX_MONEY) > 0) {
						boolean flag = true;
						while(flag){
							BaseEmployeeSendMoneyData tmpSendMoneyData = new BaseEmployeeSendMoneyData();
							baseSalarySendDataPay.cloneCopy(tmpSendMoneyData);
							tmpSendMoneyData.setFactSalary(ReimbursementPackageProcessor.MAX_MONEY);
							list.add(tmpSendMoneyData);
							payAmount = payAmount.subtract(ReimbursementPackageProcessor.MAX_MONEY);
							if(payAmount.compareTo(BigDecimal.ZERO) > 0){
								if(payAmount.compareTo(ReimbursementPackageProcessor.MAX_MONEY) <= 0){
									flag = false;
									BaseEmployeeSendMoneyData finalSendMoneyData = new BaseEmployeeSendMoneyData();
									baseSalarySendDataPay.cloneCopy(finalSendMoneyData);
									finalSendMoneyData.setFactSalary(payAmount);
									list.add(finalSendMoneyData);
								}
							}else{
								flag = false;
							}
						}
					} else {
						list.add(baseSalarySendDataPay);
					}
					
				} else {
					status = -1;
					errorMsg += String.format(
							"summaryid[%1$s] employeeId[%2$s-%3$s]  没有找到默认银行卡号;",
							baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
							baseSalarySendDataPay.getEmployeeId(),
							baseSalarySendDataPay.getEmployeeName());
					break;
				}
			}
		}
		// 总金额比较进行资金校正
		if(status > 0) {
			if(checkTotalMoney.compareTo(baseReimbursementPackageSummary.getPaymentAmount()) != 0) {
				status = -1;
				errorMsg += String.format(
						"summaryid[%1$s] %4$s年%5$s月份薪资发放 报销付款总金额[%2$s]与实际付款金额[%3$s]不匹配, 请联系薪资管理人员进行检查;",
						baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
						baseReimbursementPackageSummary.getPaymentAmount().setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
						checkTotalMoney.toString(),
						baseReimbursementPackageSummary.getYear(),
						baseReimbursementPackageSummary.getMonth());
			}
		}
		bc.setCollections(list);
		bc.setStatus(status);
		bc.setMessage(errorMsg);
		return bc;
	}

	/**
	 * 制单
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static String makeBill(int packageId) throws Exception {
		ThreadConnection.beginTransaction();
		// int pakageId = BaseHelpUtils.getIntValue(params, "pakageId");
		ReimbursementPackage rpDao = new ReimbursementPackage();
		rpDao.setReimbursementPackageId(packageId);
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status = 1;
		String errorMsg = "";
		if (rpDao.load()) {
			ReimbursementPackageSummary rbsDao = new ReimbursementPackageSummary();
			rbsDao.setConditionReimbursementPackageId("=", packageId);
			List<BaseReimbursementPackageSummary> summaryList = rbsDao.conditionalLoad();

			Date currentDate = new Date();

			List<BaseCmbcPayDetail> dataList = new ArrayList<>();
			// 对于代发其他的数据需要进行汇总后才进行支付
			List<BaseCmbcPayDetail> dfqtList = new ArrayList<>();

			// 检测付款账号是否齐全
			CardManage cmDao = new CardManage();

			// CMBC 附录代码
			CmbcCode ccDao = new CmbcCode();
			// 城市
			Area areaCode = new Area();
			// 收款单位
			ReceiveUnitManage rumDao = new ReceiveUnitManage();

			// 支付主表
			CmbcPayment cpDao = new CmbcPayment();

			int orderNum = 1;
			String errorLog = "";
			String companyCode = "JA";
			CompanyRecord crDao = new CompanyRecord();
			crDao.setCompanyRecordId(rpDao.getCompanyId());
			if(crDao.load() && !BaseHelpUtils.isNullOrEmpty(crDao.getCompanyCode())) {
				companyCode = crDao.getCompanyCode();
			}
			
			String dfqtYurref = getYurref(companyCode, currentDate, packageId, 0);
			for (BaseReimbursementPackageSummary baseReimbursementPackageSummary : summaryList) {
				// 1、检测付款账号为真实收付款账号 为真实收付款账号进行线上转账
				// 2、检测付款账号是否加入付方开户地区码且为真实收款账号
				if (!BaseHelpUtils.isNullOrEmpty(baseReimbursementPackageSummary.getOtherBankAccount())) {
					cmDao.clear();
					cmDao.setConditionBankAccount("=", baseReimbursementPackageSummary.getOtherBankAccount());
					cmDao.setConditionObjectType("=", 2);
					if (null != cmDao.executeQueryOneRow()) {
						if (null == cmDao.getTruePayment() || !cmDao.getTruePayment()) {
							continue;
						} else {
							if (null == cmDao.getCmbcCodeId()) {
								status = -1;
								errorMsg += String.format("summaryid[%1$s]下, 付款方银行账号[%2$s] 没有设置开户行地区代码 请检查;",
										baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
										baseReimbursementPackageSummary.getOtherBankAccount());
								break;
							}
						}
					} else {
						// status = -1;
						// errorMsg += String.format("summaryid[%1$s]下,
						// 付款方银行账号[%2$s] 没有在公司卡号中搜索到 请检查;",
						// baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
						// baseReimbursementPackageSummary.getOtherBankAccount());
						continue;
					}
				} else {
					status = -1;
					errorMsg += String.format("summaryid[%1$s]下, 没有设置付款方银行账号 请检查;",
							baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
					break;
				}

				if (null != baseReimbursementPackageSummary.getOtherBankAccount()
						&& null != baseReimbursementPackageSummary.getPaymentAmount()
						&& baseReimbursementPackageSummary.getPaymentAmount().compareTo(BigDecimal.ZERO) > 0) {
					// 业务参考号
					String yurref = getYurref(companyCode, currentDate,
							baseReimbursementPackageSummary.getReimbursementPackageSummaryId(), orderNum);
					BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
					bean.setReimbursementPackageId(baseReimbursementPackageSummary.getReimbursementPackageId());
					bean.setReimbursementPackageSummaryId(
							baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
					bean.setWithdrawFlag(WITHDRAW_FLAG_1);
					bean.setWithdrawStatus(WITHDRAW_STATUS_1);
					bean.setStatus(DETAIL_STATUS_1);
					// 区分代发工资、代发奖金、支付、内部转账
					cmDao.clear();
					cmDao.setConditionBankAccount("=", baseReimbursementPackageSummary.getOtherBankAccount());
					Integer cmCodeId = cmDao.executeQueryOneRow().getCmbcCodeId();
					ccDao.clear();
					ccDao.setCmbcCodeId(cmCodeId);
					ccDao.load();
					String codeIdStr = ccDao.getCodeId();
					if (baseReimbursementPackageSummary.getPayFor() == 1) {// 个人
																			// 代发其他(代发报销)
						cmDao.clear();
						cmDao.setConditionObjectId("=", baseReimbursementPackageSummary.getEmployeeOrCompanyId());
						cmDao.setConditionObjectType("=", 1);
						cmDao.setConditionDefaultCard("=", true);
						if (null != cmDao.executeQueryOneRow()) {
							BaseCmbcPayDetail dfqtBean = new BaseCmbcPayDetail();
							dfqtBean.setReimbursementPackageId(
									baseReimbursementPackageSummary.getReimbursementPackageId());
							dfqtBean.setReimbursementPackageSummaryId(
									baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
							dfqtBean.setBuscod("N03020");
							dfqtBean.setYurref(dfqtYurref);
							dfqtBean.setTrstyp("BYBK");
							dfqtBean.setTrstypName("代发其他");
							dfqtBean.setEptdat(currentDate);
							dfqtBean.setDbtacc(baseReimbursementPackageSummary.getOtherBankAccount());
							dfqtBean.setDbtbbk(codeIdStr);
							dfqtBean.setTotalAmount(baseReimbursementPackageSummary.getPaymentAmount());
							dfqtBean.setType(PAY_TYPE_4);
							dfqtBean.setTotalNum(1);
							dfqtBean.setEptdat(currentDate);
							dfqtBean.setCcynbr(CCYNBR);
							dfqtBean.setStlchn(STLCHN);
							dfqtBean.setCrtnam(baseReimbursementPackageSummary.getPayeeName());
							dfqtBean.setTrsamt(baseReimbursementPackageSummary.getPaymentAmount());
							dfqtBean.setObjectId(baseReimbursementPackageSummary.getEmployeeOrCompanyId());
							dfqtBean.setObjectType(OBJECT_TYPE_1);
							dfqtBean.setNusage("报销 ");
							dfqtBean.setCrtacc(cmDao.getBankAccount().replaceAll(" ", "").replaceAll("\\u00A0", ""));
							dfqtBean.setCrtbnk(baseReimbursementPackageSummary.getSelfBankName());
							dfqtBean.setWithdrawFlag(WITHDRAW_FLAG_1);
							dfqtBean.setWithdrawStatus(WITHDRAW_STATUS_1);
							dfqtBean.setStatus(DETAIL_STATUS_1);
							if (cmDao.getBankId() == 1) {
								dfqtBean.setBnkflg("Y");
							} else {
								dfqtBean.setBnkflg("N");
								dfqtBean.setCrtbnk(cmDao.getBankName());
								dfqtBean.setEaccty(cmDao.getBankAddress());
							}

							dfqtList.add(dfqtBean);

						} else {
							status = -1;
							errorMsg += String.format("summaryid[%1$s]下,进行个人 代发报销,没有设置员工默认银行账号 请检查;",
									baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
							break;
						}

					} else if (baseReimbursementPackageSummary.getPayFor() == 2) {// 收款单位
						bean.setYurref(yurref);
						bean.setEptdat(currentDate);
						bean.setDbtacc(baseReimbursementPackageSummary.getOtherBankAccount());
						bean.setDbtbbk(codeIdStr);
						bean.setTrsamt(baseReimbursementPackageSummary.getPaymentAmount());
						bean.setObjectId(baseReimbursementPackageSummary.getEmployeeOrCompanyId());
						bean.setObjectType(OBJECT_TYPE_2);
						bean.setEptdat(currentDate);
						bean.setCcynbr(CCYNBR);
						bean.setStlchn(STLCHN);
						bean.setCrtacc(baseReimbursementPackageSummary.getSelfBankAccount().replaceAll(" ", "").replaceAll("\\u00A0", ""));
						bean.setCrtnam(baseReimbursementPackageSummary.getPayeeName().replaceAll(" ", "").replaceAll("\\u00A0", ""));
						if (baseReimbursementPackageSummary.getSelfBankName().contains("招行")
								|| baseReimbursementPackageSummary.getSelfBankName().contains("招商行")
								|| baseReimbursementPackageSummary.getSelfBankName().contains("招商银行")) {
							bean.setBnkflg("Y");
						} else {
							bean.setBnkflg("N");
						}
						bean.setCrtbnk(baseReimbursementPackageSummary.getSelfBankName());
						// 根据收款方账号检测是否为内部转账(内部转账 公司业务 按支付走)
//						cmDao.setConditionBankAccount("=", baseReimbursementPackageSummary.getSelfBankAccount());
//						cmDao.setConditionObjectType("=", 2);
						// cmDao.setConditionTruePayment("=", Boolean.TRUE);
//						if (null != cmDao.executeQueryOneRow()) {// 能查出则为内部转账
//							if (null != cmDao.getTruePayment() && cmDao.getTruePayment()) {
//								bean.setType(PAY_TYPE_5);
//								bean.setNusage("内部转账");
//								bean.setBuscod("N02020");
//								if (null != cmDao.getCmbcCodeId()) {
//									ccDao.clear();
//									ccDao.setCmbcCodeId(cmDao.getCmbcCodeId());
//									ccDao.load();
//									bean.setCrtbbk(ccDao.getCodeId());
//								} else {
//									status = -1;
//									errorMsg += String.format("summaryid[%1$s]下,进行内部转账[%2$s],没有设置开户地区 请检查;",
//											baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
//											baseReimbursementPackageSummary.getSelfBankAccount());
//									break;
//								}
//							} else {
//								// 为手动进行转账的账户 (募投账户一类)
//								continue;
//							}
//
//						} else {
							// 区分是代发工资还是代发奖金或支付
							if (null == baseReimbursementPackageSummary.getPayType()
									|| baseReimbursementPackageSummary.getPayType() == 0) {// 支付
								bean.setType(PAY_TYPE_1);
								String remark = getRemarkBySummaryId(baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
								if(BaseHelpUtils.isNullOrEmpty(remark)){
									bean.setNusage("支付");
								}else{
									bean.setNusage(remark);
								}
								bean.setBuscod("N02030");
								// 设置收方省份与收方城市 支持简写
								rumDao.clear();
								rumDao.setConditionBankAccount("=",
										baseReimbursementPackageSummary.getSelfBankAccount());
								if (null != rumDao.executeQueryOneRow()) {
									if (null != rumDao.getProvince() && null != rumDao.getCity()) {
										areaCode.clear();
										areaCode.setAreaId(rumDao.getProvince());
										areaCode.load();
										// 设置收方省份
										bean.setCrtpvc(areaCode.getAreaName());
										areaCode.clear();
										areaCode.setAreaId(rumDao.getCity());
										areaCode.load();
										// 设置收方城市
										bean.setCrtcty(areaCode.getAreaName());
									} else {
										status = -1;
										errorMsg += String.format(
												"summaryid[%1$s] 下 没有检索到收款单位[%2$s]收方账号[%3$s]设置省与城市数据 ,请检查收款单位数据并设置完整再进行制单;",
												baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
												baseReimbursementPackageSummary.getPayeeName(),
												baseReimbursementPackageSummary.getSelfBankAccount());
										break;
									}
								} else {
									status = -1;
									errorMsg += String.format(
											"summaryid[%1$s] 下没有 检索到收方账号为[%2$s]的收款单位数据 ,请根据收款账号搜索收款单位进行检查;",
											baseReimbursementPackageSummary.getReimbursementPackageSummaryId(),
											baseReimbursementPackageSummary.getSelfBankAccount());
									break;
								}

							} else if (baseReimbursementPackageSummary.getPayType() == 1) {// 代发工资
								if (null != baseReimbursementPackageSummary.getCompanyId()
										&& null != baseReimbursementPackageSummary.getYear()
										&& null != baseReimbursementPackageSummary.getMonth()
										&& !BaseHelpUtils.isNullOrZero(baseReimbursementPackageSummary.getEmployeeFundIssuanceId())) {
									// 根据年份、月份、归属公司获当月每个员工应发工资详细(从薪资发放表查找)  原有需求 2019-04-22后改变
//									QuerySalarySendDataPay dao = new QuerySalarySendDataPay();
//									ConditionSalarySendDataPay c = new ConditionSalarySendDataPay();
//									c.setYear(baseReimbursementPackageSummary.getYear());
//									c.setMonth(baseReimbursementPackageSummary.getMonth());
//									c.setCompanyId(baseReimbursementPackageSummary.getCompanyId());
//									dao.setCurrentPage(0);
//									dao.setPageLines(1);
//									BaseCollection<BaseSalarySendDataPay> result = dao.executeQuery(c.getKeyValues(),
//											c);
//									List<BaseSalarySendDataPay> salaryList = result.getCollections();
//									List<BaseSalarySendDataPay> list = new ArrayList<>();
//									//过滤掉不合格的数据
//									for (BaseSalarySendDataPay baseSalarySendDataPay : salaryList) {
//										if (null != baseSalarySendDataPay.getFactSalary() && baseSalarySendDataPay
//												.getFactSalary().compareTo(BigDecimal.ZERO) > 0) {
//											if (null != baseSalarySendDataPay.getBankAccount()) {
//												list.add(baseSalarySendDataPay);
//											}
//										}
//									}
									
									List<BaseEmployeeSendMoneyData> list = new ArrayList<>();
									// 现从具体发放表进行数据抓取
									// 过滤掉不合格的数据与检测数据是否初步合格与超过10万代发金额分拆
									BaseCollection<BaseEmployeeSendMoneyData> sendMoneyDataBc = checkAndGetSendMoneyData(baseReimbursementPackageSummary);
									if(sendMoneyDataBc.getStatus() > 0) {
										if(sendMoneyDataBc.getCollections().size() > 0) {
											list.addAll(sendMoneyDataBc.getCollections());
										}
									} else {
										status = -1;
										errorMsg = sendMoneyDataBc.getMessage();
									}
									
									if (status > 0 && list.size() > 0) {
										// 创建支付主表数据
										cpDao.clear();
										cpDao.setYurref(yurref);
										cpDao.setTotalAmount(baseReimbursementPackageSummary.getPaymentAmount());
										cpDao.setType(PAY_TYPE_2);
										cpDao.setTrstyp("BYSA");
										cpDao.setTrstypName("代发工资");
										cpDao.setNusage("工资");
										cpDao.setDbtacc(baseReimbursementPackageSummary.getOtherBankAccount());
										cpDao.setDbtbbk(codeIdStr);
										cpDao.setTotalNum(list.size());
										cpDao.setReimbursementPackageId(packageId);
										cpDao.save();
										bean.setCmbcPaymentId(cpDao.getCmbcPaymentId());// 设置支付主表与子表关联数据
										// 关联付款来源数据与支付主表数据
										rbsDao.clear();
										rbsDao.setReimbursementPackageSummaryId(
												baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
										rbsDao.load();
										rbsDao.setCmbcPaymentId(cpDao.getCmbcPaymentId());
										rbsDao.update();
										for (BaseEmployeeSendMoneyData baseSalarySendDataPay : list) {
											if (null != baseSalarySendDataPay.getFactSalary() && baseSalarySendDataPay
													.getFactSalary().compareTo(BigDecimal.ZERO) > 0) {
												if (null != baseSalarySendDataPay.getBankAccount()) {
													BaseCmbcPayDetail tmpBean = new BaseCmbcPayDetail();
													tmpBean.setReimbursementPackageId(baseReimbursementPackageSummary
															.getReimbursementPackageId());
													tmpBean.setReimbursementPackageSummaryId(
															baseReimbursementPackageSummary
																	.getReimbursementPackageSummaryId());
													tmpBean.setBuscod("N03010");
													tmpBean.setObjectId(baseSalarySendDataPay.getEmployeeId());
													tmpBean.setObjectType(OBJECT_TYPE_1);
													tmpBean.setYurref(yurref);
													tmpBean.setTrstyp("BYSA");
													tmpBean.setCmbcPaymentId(cpDao.getCmbcPaymentId());
													tmpBean.setTrstypName("代发工资");
													tmpBean.setEptdat(currentDate);
													tmpBean.setDbtacc(
															baseReimbursementPackageSummary.getOtherBankAccount());
													tmpBean.setDbtbbk(codeIdStr);
													tmpBean.setTotalAmount(
															baseReimbursementPackageSummary.getPaymentAmount());
													tmpBean.setTotalNum(list.size());
													tmpBean.setEptdat(currentDate);
													tmpBean.setType(PAY_TYPE_2);
													tmpBean.setCcynbr(CCYNBR);
													tmpBean.setStlchn(STLCHN);
													tmpBean.setCrtnam(baseSalarySendDataPay.getEmployeeName());
													tmpBean.setTrsamt(baseSalarySendDataPay.getFactSalary());
													tmpBean.setNusage("工资");
													tmpBean.setCrtacc(baseSalarySendDataPay.getBankAccount());
													tmpBean.setCrtbnk(baseSalarySendDataPay.getBankName());
													tmpBean.setWithdrawFlag(WITHDRAW_FLAG_1);
													tmpBean.setWithdrawStatus(WITHDRAW_STATUS_1);
													tmpBean.setStatus(DETAIL_STATUS_1);
													if (baseSalarySendDataPay.getBankId() == 1) {
														tmpBean.setBnkflg("Y");
													} else {
														tmpBean.setBnkflg("N");
														tmpBean.setEaccty(baseSalarySendDataPay.getBankAddress());
													}
													dataList.add(tmpBean);
												} else {
													status = -1;
													errorMsg += String.format(
															"summaryid[%1$s] employeeId[%2$s]  没有找到默认银行卡号;",
															baseReimbursementPackageSummary
																	.getReimbursementPackageSummaryId(),
															baseSalarySendDataPay.getEmployeeId());
													break;
												}
											}
										}

									} else {
										status = -1;
										errorMsg += String.format("summaryid[%1$s] 下 没有找到薪资发放数据,或薪资发放数与实际数据不匹配  数据不全 请检查;",
												baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
									}

									if (status < 0) {
										break;
									}
								} else {
									status = -1;
									errorMsg += String.format("summaryid[%1$s] 下 companyId||year||month  数据不全 请检查;",
											baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
									break;
								}
							} else if (baseReimbursementPackageSummary.getPayType() == 2) {// 代发奖金
								if (null != baseReimbursementPackageSummary.getCompanyId()
										&& null != baseReimbursementPackageSummary.getYear()
										&& null != baseReimbursementPackageSummary.getMonth()
										&& !BaseHelpUtils.isNullOrZero(baseReimbursementPackageSummary.getEmployeeFundIssuanceId())) {
									// 根据年份、月份、归属公司以及流程的ID获每一批流程每个员工应发奖金详细(从奖金发放表查找)
//									ConditionSalaryBonusSendDataPay c = new ConditionSalaryBonusSendDataPay();
//									QuerySalaryBonusSendDataPay dao = new QuerySalaryBonusSendDataPay();
//									c.setYear(baseReimbursementPackageSummary.getYear());
//									c.setMonth(baseReimbursementPackageSummary.getMonth());
//									c.setCompanyId(baseReimbursementPackageSummary.getCompanyId());
//									c.setPersonnelBusinessId(baseReimbursementPackageSummary.getPersonnelBusinessId());
//									dao.setCurrentPage(0);
//									dao.setPageLines(1);
//									BaseCollection<BaseSalaryBonusSendDataPay> result = dao
//											.executeQuery(c.getKeyValues(), c);
//									List<BaseSalaryBonusSendDataPay> list = result.getCollections();
									
									List<BaseEmployeeSendMoneyData> list = new ArrayList<>();
									// 现从具体发放表进行数据抓取
									// 过滤掉不合格的数据与检测数据是否初步合格与超过10万代发金额分拆
									BaseCollection<BaseEmployeeSendMoneyData> sendMoneyDataBc = checkAndGetSendMoneyData(baseReimbursementPackageSummary);
									if(sendMoneyDataBc.getStatus() > 0) {
										if(sendMoneyDataBc.getCollections().size() > 0) {
											list.addAll(sendMoneyDataBc.getCollections());
										}
									} else {
										status = -1;
										errorMsg = sendMoneyDataBc.getMessage();
									}
									
									if (status > 0 && list.size() > 0) {
										// 创建支付主表数据
										cpDao.clear();
										cpDao.setYurref(yurref);
										cpDao.setTotalAmount(baseReimbursementPackageSummary.getPaymentAmount());
										cpDao.setType(PAY_TYPE_3);
										cpDao.setTrstyp("BYBK");
										cpDao.setTrstypName("代发其他");
										cpDao.setDbtacc(baseReimbursementPackageSummary.getOtherBankAccount());
										cpDao.setDbtbbk(codeIdStr);
										cpDao.setNusage("奖金");
										cpDao.setTotalNum(list.size());
										cpDao.setReimbursementPackageId(packageId);
										cpDao.save();
										bean.setCmbcPaymentId(cpDao.getCmbcPaymentId());// 设置支付主表与子表关联数据
										// 关联付款来源数据与支付主表数据
										rbsDao.clear();
										rbsDao.setReimbursementPackageSummaryId(
												baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
										rbsDao.load();
										rbsDao.setCmbcPaymentId(cpDao.getCmbcPaymentId());
										rbsDao.update();
										for (BaseEmployeeSendMoneyData baseSalarySendDataPay : list) {
											if (null != baseSalarySendDataPay && baseSalarySendDataPay.getFactSalary()
													.compareTo(BigDecimal.ZERO) > 0) {
												if (null != baseSalarySendDataPay.getBankAccount()) {
													BaseCmbcPayDetail tmpBean = new BaseCmbcPayDetail();
													tmpBean.setReimbursementPackageId(baseReimbursementPackageSummary
															.getReimbursementPackageId());
													tmpBean.setReimbursementPackageSummaryId(
															baseReimbursementPackageSummary
																	.getReimbursementPackageSummaryId());
													tmpBean.setBuscod("N03020");
													tmpBean.setObjectId(baseSalarySendDataPay.getEmployeeId());
													tmpBean.setObjectType(OBJECT_TYPE_1);
													tmpBean.setYurref(yurref);
													tmpBean.setTrstyp("BYBK");
													tmpBean.setCmbcPaymentId(cpDao.getCmbcPaymentId());
													tmpBean.setTrstypName("代发其他");
													tmpBean.setEptdat(currentDate);
													tmpBean.setType(PAY_TYPE_3);
													tmpBean.setDbtacc(
															baseReimbursementPackageSummary.getOtherBankAccount());
													tmpBean.setDbtbbk(codeIdStr);
													tmpBean.setTotalAmount(
															baseReimbursementPackageSummary.getPaymentAmount());
													tmpBean.setTotalNum(list.size());
													tmpBean.setEptdat(currentDate);
													tmpBean.setCcynbr(CCYNBR);
													tmpBean.setStlchn(STLCHN);
													tmpBean.setCrtnam(baseSalarySendDataPay.getEmployeeName());
													tmpBean.setTrsamt(baseSalarySendDataPay.getFactSalary());
													tmpBean.setNusage("奖金");
													tmpBean.setCrtacc(baseSalarySendDataPay.getBankAccount());
													tmpBean.setCrtbnk(baseSalarySendDataPay.getBankName());
													tmpBean.setWithdrawFlag(WITHDRAW_FLAG_1);
													tmpBean.setWithdrawStatus(WITHDRAW_STATUS_1);
													tmpBean.setStatus(DETAIL_STATUS_1);
													if (baseSalarySendDataPay.getBankId() == 1) {
														tmpBean.setBnkflg("Y");
													} else {
														tmpBean.setBnkflg("N");
														tmpBean.setEaccty(baseSalarySendDataPay.getBankAddress());
													}
													dataList.add(tmpBean);
												} else {
													status = -1;
													errorMsg += String.format(
															"summaryid[%1$s] employeeId[%2$s]  没有找到默认银行卡号;",
															baseReimbursementPackageSummary
																	.getReimbursementPackageSummaryId(),
															baseSalarySendDataPay.getEmployeeId());
													break;
												}
											}
										}
									} else {
										status = -1;
										errorMsg += String.format("summaryid[%1$s] 下 没有找到奖金发放数据,或奖金发放数与实际数据不匹配  数据不全 请检查;",
												baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
									}

									if (status < 0) {
										break;
									}
								} else {
									status = -1;
									errorMsg += String.format("summaryid[%1$s] 下 companyId||year||month  数据不全 请检查;",
											baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
									break;
								}
							}
//						}
					}
					if (status > 0 && null != bean.getType()) {
						cpDao.clear();
						// 创建支付主表数据
						cpDao.setYurref(bean.getYurref());
						cpDao.setTotalAmount(bean.getTrsamt());
						cpDao.setType(bean.getType());
						cpDao.setTotalNum(1);
						cpDao.setReimbursementPackageId(packageId);
						cpDao.setTrstyp(bean.getTrstyp());
						cpDao.setTrstypName(bean.getTrstypName());
						cpDao.setDbtacc(bean.getDbtacc());
						cpDao.setDbtbbk(bean.getDbtbbk());
						cpDao.setNusage(bean.getNusage());
						cpDao.save();
						bean.setCmbcPaymentId(cpDao.getCmbcPaymentId());// 设置支付主表与子表关联数据
						// 关联付款来源数据与支付主表数据
						rbsDao.clear();
						rbsDao.setReimbursementPackageSummaryId(
								baseReimbursementPackageSummary.getReimbursementPackageSummaryId());
						rbsDao.load();
						rbsDao.setCmbcPaymentId(cpDao.getCmbcPaymentId());
						rbsDao.update();

						dataList.add(bean);
						orderNum++;
					}
				}

			}
			if (status > 0 && (dataList.size() > 0 || dfqtList.size() > 0)) {
				rpDao.setPayStatus(PAY_STATUS_2);// 已制单
				rpDao.setMakeBillTime(currentDate);
				rpDao.update();

				if (dfqtList.size() > 0) {
					List<Integer> summaryIds = new ArrayList<>();
					cpDao.clear();
					cpDao.setYurref(dfqtYurref);
					cpDao.save();
					cpDao.setReimbursementPackageId(packageId);
					cpDao.setType(dfqtList.get(0).getType());
					cpDao.setTrstyp("BYBK");
					cpDao.setTrstypName("代发其他");
					cpDao.setDbtacc(dfqtList.get(0).getDbtacc());
					cpDao.setDbtbbk(dfqtList.get(0).getDbtbbk());
					cpDao.setNusage("报销");
					cpDao.setTotalNum(dfqtList.size());
					BigDecimal dfqtAllMoney = BigDecimal.ZERO;
					// 处理代发其他(报销数据) 对于同一个汇总单 代发是一次代发 (同一个业务参考号)
					for (BaseCmbcPayDetail baseCmbcPayDetail : dfqtList) {
						baseCmbcPayDetail.setCmbcPaymentId(cpDao.getCmbcPaymentId());
						dfqtAllMoney = dfqtAllMoney.add(baseCmbcPayDetail.getTrsamt());
						summaryIds.add(baseCmbcPayDetail.getReimbursementPackageSummaryId());
					}
					cpDao.setTotalAmount(dfqtAllMoney);
					cpDao.update();
					rbsDao.clear();
					rbsDao.setCmbcPaymentId(cpDao.getCmbcPaymentId());
					rbsDao.addCondition(BaseCmbcPayDetail.CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID, "in",
							summaryIds.toArray());
					rbsDao.conditionalUpdate();
				}

				CmbcPayDetail cpdDao = new CmbcPayDetail();
				if (dfqtList.size() > 0) {
					dataList.addAll(dfqtList);
				}
				cpdDao.save(dataList);
				ThreadConnection.commit();
			} else {
				ThreadConnection.rollback();
			}
		} else {
			status = -1;
			errorMsg = String.format("汇总单数据错误 packageId = %1$s", packageId);
		}
		return bc.toJSON(status, errorMsg);

	}

	/**
	 * 获取业务参考号
	 * 
	 * @param date
	 * @param summaryId
	 * @return
	 */
	public static String getYurref(String companyCode, Date date, int summaryId, int orderNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		String yurref = String.format("%1$s%2$s-%3$s-%4$s", companyCode, sdf.format(date), summaryId, orderNum);
		return yurref;
	}

	// 老支付方法
	// public String cmbcPay(int packageId) throws Exception{
	// BaseCollection<GenericBase> bc = new BaseCollection<>();
	// int status = 1;
	// String errorMsg = "";
	// ReimbursementPackage rpDao = new ReimbursementPackage();
	// rpDao.setReimbursementPackageId(packageId);
	// if(rpDao.load()){
	// //检测是否是已制单状态
	// CmbcPayDetail cpdDao = new CmbcPayDetail();
	// cpdDao.setConditionReimbursementPackageId("=", packageId);
	// List<BaseCmbcPayDetail> list = cpdDao.conditionalLoad();
	//
	// if(list.size() > 0){
	// //整理数据 分为 支付、代发工资、代发奖金、代发其他、内部转账
	// //支付
	// List<Map<String, Object>> payList = new ArrayList<>();
	// //内部转账
	// List<Map<String, Object>> nbzzList = new ArrayList<>();
	//
	//
	//
	// //代发其他制单详情详情
	// List<BaseCmbcPayDetail> dfqtPayList = new ArrayList<>();
	//
	// //代发奖金与代发工资
	// Set<String> yurrefSet = new HashSet<>();
	// for (BaseCmbcPayDetail baseCmbcPayDetail : list) {
	// if(Objects.equals(baseCmbcPayDetail.getType(), PAY_TYPE_1)){//支付
	// Map<String, Object> dataPar = new HashMap<>();
	// dataPar.put("YURREF", baseCmbcPayDetail.getYurref());
	// dataPar.put("DBTACC", baseCmbcPayDetail.getDbtacc());
	// dataPar.put("DBTBBK", baseCmbcPayDetail.getDbtbbk());
	// dataPar.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
	// dataPar.put("CCYNBR", baseCmbcPayDetail.getCcynbr());
	// dataPar.put("STLCHN", baseCmbcPayDetail.getStlchn());
	// dataPar.put("NUSAGE", baseCmbcPayDetail.getNusage());
	// dataPar.put("CRTACC", baseCmbcPayDetail.getCrtacc());
	// dataPar.put("CRTNAM", baseCmbcPayDetail.getCrtnam());
	// dataPar.put("CRTBNK", baseCmbcPayDetail.getCrtbnk());
	// dataPar.put("BNKFLG", baseCmbcPayDetail.getBnkflg());
	// dataPar.put("CRTPVC", baseCmbcPayDetail.getCrtpvc());
	// dataPar.put("CRTCTY", baseCmbcPayDetail.getCrtcty());
	// payList.add(dataPar);
	// }else if(Objects.equals(baseCmbcPayDetail.getType(), PAY_TYPE_2)){//代发工资
	// yurrefSet.add(baseCmbcPayDetail.getYurref());
	// }else if(Objects.equals(baseCmbcPayDetail.getType(), PAY_TYPE_3)){//代发奖金
	// yurrefSet.add(baseCmbcPayDetail.getYurref());
	// }else if(Objects.equals(baseCmbcPayDetail.getType(),
	// PAY_TYPE_4)){//代发其他（报销）
	// dfqtPayList.add(baseCmbcPayDetail);
	// }else if(Objects.equals(baseCmbcPayDetail.getType(), PAY_TYPE_5)){//内部转账
	// Map<String, Object> dataPar = new HashMap<>();
	// dataPar.put("YURREF", baseCmbcPayDetail.getYurref());
	// dataPar.put("DBTACC", baseCmbcPayDetail.getDbtacc());
	// dataPar.put("DBTBBK", baseCmbcPayDetail.getDbtbbk());
	// dataPar.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
	// dataPar.put("CCYNBR", baseCmbcPayDetail.getCcynbr());
	// dataPar.put("STLCHN", baseCmbcPayDetail.getStlchn());
	// dataPar.put("NUSAGE", baseCmbcPayDetail.getNusage());
	// dataPar.put("CRTACC", baseCmbcPayDetail.getCrtacc());
	// dataPar.put("CRTBBK", baseCmbcPayDetail.getCrtbbk());
	// nbzzList.add(dataPar);
	// }
	// }
	//
	// //根据业务号预付类型进行规整 将相同业务参考号的代发工资与代发奖金进行报文合并
	// for (String string : yurrefSet) {
	// //每个业务号作为同一笔支付 对于奖金与工资的发放是需要将多笔进行XML子节点拼接
	// //当一个包中存在不同月份的奖金或工资付款时 业务参考号是不同的
	// BaseCmbcPayDetail bean = null;
	// //批量代发报文封装
	// List<Map<String, Object>> childList = new ArrayList<>();
	// for (BaseCmbcPayDetail baseCmbcPayDetail : list) {
	// if(string.equals(baseCmbcPayDetail.getYurref())){
	// if(null == bean){
	// bean = baseCmbcPayDetail;
	// }
	// Map<String, Object> childParams = new HashMap<>();
	// childParams.put("ACCNBR", baseCmbcPayDetail.getCrtacc());
	// childParams.put("CLTNAM", baseCmbcPayDetail.getCrtnam());
	// childParams.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
	// childParams.put("BNKFLG", baseCmbcPayDetail.getBnkflg());
	// childParams.put("EACBNK", baseCmbcPayDetail.getCrtbnk());
	// childParams.put("EACCTY", baseCmbcPayDetail.getEaccty());
	// childList.add(childParams);
	// }
	// }
	// Map<String, Object> mianDataParams = new HashMap<>();
	// mianDataParams.put("C_TRSTYP", bean.getTrstypName());
	// mianDataParams.put("TRSTYP", bean.getTrstyp());
	// mianDataParams.put("DBTACC", bean.getDbtacc());
	// mianDataParams.put("BBKNBR", bean.getDbtbbk());
	// mianDataParams.put("YURREF", bean.getYurref());
	// mianDataParams.put("TOTAL", bean.getTotalNum());
	// mianDataParams.put("SUM", bean.getTotalAmount());
	// if(Objects.equals(bean.getType(), PAY_TYPE_2)){//代发工资
	// mianDataParams.put("BUSCOD", "N03010");
	// }else if(Objects.equals(bean.getType(), PAY_TYPE_3)){//代发奖金
	// mianDataParams.put("BUSCOD", "N03020");
	// }
	// mianDataParams.put("MEMO", bean.getNusage());
	// mianDataParams.put("GRTFLG", "Y");
	//
	// //进行代发工资与代发奖金报文发送
	// String pakageStr =
	// CreateCMBBankXmlUtil.createAgentRequestXML(mianDataParams, childList);
	// CMBBankUtil.sendPackageToCMB(pakageStr);
	//
	// }
	// //进行支付报文发送
	// if(payList.size() > 0){
	// Map<String, Object> sendDataMap = new HashMap<>();
	// sendDataMap.put("BUSCOD", "N02030");//支付
	// sendDataMap.put("BUSMOD", BUSMOD);
	// String pakageStr = CreateCMBBankXmlUtil.createPaymentXML(sendDataMap,
	// payList);
	// CMBBankUtil.sendPackageToCMB(pakageStr);
	// }
	// //进行代发其他(报销)报文发送
	// if(dfqtPayList.size() > 0){
	// //封装代发其他的报文
	// Map<String, Object> dfqtParams = new HashMap<>();
	// dfqtParams.put("BUSCOD", "N03020");
	// dfqtParams.put("C_TRSTYP", dfqtPayList.get(0).getTrstypName());
	// dfqtParams.put("TRSTYP", dfqtPayList.get(0).getTrstyp());
	// dfqtParams.put("DBTACC", dfqtPayList.get(0).getDbtacc());
	// dfqtParams.put("BBKNBR", dfqtPayList.get(0).getDbtbbk());
	// dfqtParams.put("YURREF", dfqtPayList.get(0).getYurref());
	// dfqtParams.put("TOTAL", dfqtPayList.size());
	// BigDecimal allMoney = BigDecimal.ZERO;
	//
	// //代发其他收款方信息
	// List<Map<String, Object>> dfqtList = new ArrayList<>();
	//
	// for (BaseCmbcPayDetail baseCmbcPayDetail : dfqtPayList) {
	// allMoney = allMoney.add(baseCmbcPayDetail.getTrsamt());
	// Map<String, Object> childParams = new HashMap<>();
	// childParams.put("ACCNBR", baseCmbcPayDetail.getCrtacc());
	// childParams.put("CLTNAM", baseCmbcPayDetail.getCrtnam());
	// childParams.put("TRSAMT", baseCmbcPayDetail.getTrsamt());
	// childParams.put("BNKFLG", baseCmbcPayDetail.getBnkflg());
	// childParams.put("EACBNK", baseCmbcPayDetail.getCrtbnk());
	// childParams.put("EACCTY", baseCmbcPayDetail.getEaccty());
	// dfqtList.add(childParams);
	// }
	// dfqtParams.put("SUM", allMoney);
	// dfqtParams.put("MEMO", dfqtPayList.get(0).getNusage());
	// dfqtParams.put("GRTFLG", "Y");
	// String pakageStr = CreateCMBBankXmlUtil.createAgentRequestXML(dfqtParams,
	// dfqtList);
	// CMBBankUtil.sendPackageToCMB(pakageStr);
	// }
	// //进行内部转账报文发送
	// if(nbzzList.size() > 0){
	// Map<String, Object> sendDataMap = new HashMap<>();
	// sendDataMap.put("BUSCOD", "N02020");//内部转账
	// sendDataMap.put("BUSMOD", BUSMOD);
	// String pakageStr =
	// CreateCMBBankXmlUtil.createInsidePaymentXML(sendDataMap, nbzzList);
	// CMBBankUtil.sendPackageToCMB(pakageStr);
	// }
	// }else{
	// status = -1;
	// errorMsg = "没有支付数据";
	// }
	//
	//
	// }
	// return bc.toJSON(status, errorMsg);
	// }
}
