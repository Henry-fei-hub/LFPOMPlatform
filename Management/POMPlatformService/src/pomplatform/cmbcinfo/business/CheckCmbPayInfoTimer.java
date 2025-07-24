package pomplatform.cmbcinfo.business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.pomplatform.db.bean.BaseCmbcPayDetail;
import com.pomplatform.db.bean.BaseCmbcPayment;
import com.pomplatform.db.dao.CmbcPayDetail;
import com.pomplatform.db.dao.CmbcPayment;
import com.pomplatform.db.dao.ReimbursementPackage;

import delicacy.date.util.DateUtil;
import pomplatform.reimbursementpackage.business.ReimbursementPackageCmbPayUtil;

/**
 *
 * @author 
 */
public class CheckCmbPayInfoTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(CheckCmbPayInfoTimer.class);
    
    private BaseCmbcPayment searchBean;
    
    /**
     * 支付状态 : 通讯成功(表示前置机已收到并等待处理该请求)
     */
    private final static Integer PAY_STATUS_2 = 2;
    
    /**
     * 支付状态 : 处理成功(表示前置机已跟银行终端通讯处理过该请求)
     */
    private final static Integer PAY_STATUS_3 = 3;
    
    /**
     * 支付状态 : 业务处理成功(网银已返回结果)
     */
    private final static Integer PAY_STATUS_4 = 4;
    
    /**
     * 支付结果:完全成功
     */
    private final static Integer PAY_RESULT_1 = 1;
    
    /**
     * 支付结果:退票
     */
    private final static Integer PAY_RESULT_2 = 2;
    
    /**
     * 支付结果:部分成功 (对于批量代发中存在该情况,  支付不存在)
     */
    private final static Integer PAY_RESULT_3 = 3;
    
    /**
     * 支付结果:失败 (失败后 可以用相同业务参考号进行再一次提交支付)
     */
    private final static Integer PAY_RESULT_4 = 4;
    
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
    
	/**
	 * 正常支付的单子
	 */
	public final static Integer WITHDRAW_FLAG_1 = 1;
	
	/**
	 * 为退单后重新发起的支付单
	 */
	public final static Integer WITHDRAW_FLAG_2 = 2;
    
    
    public final static SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyyMMdd");
	
	public final static SimpleDateFormat SDF_TIME = new SimpleDateFormat("HHmmss");
	
	/**
	 * A：经办日期；
	 * B：期望日期  
	 * 空默认为A
	 */
	public final static String DATFLG = "A"; 
    
    @Override
    public void run() {
    	try {
    		CmbcPayment cpDao = new CmbcPayment();
    		//手动操作设置条件 可以根据汇总单和单条支付主数据进行支付数据检索
    		if(null != searchBean){
    			if(null != searchBean.getReimbursementPackageId()){
    				cpDao.setConditionReimbursementPackageId("=", searchBean.getReimbursementPackageId());
    			}
    		}
    		//处理前置机接收处理但没有收到结果请求的业务
    		//根据业务参考号与期望日期作为查询(由于在当前设计中业务参考号是唯一的   所以查询结果最多为一条) PS:正式运行中以经办日期的前后两天作为查询条件 ,测试时银行服务器时间有问题
    		
    		cpDao.setConditionPayStatus("=", PAY_STATUS_2);
    		List<BaseCmbcPayment> rpsList = cpDao.conditionalLoad();
    		if(rpsList.size() > 0){
    			CmbcPayDetail cpdDao = new CmbcPayDetail();
    			ReimbursementPackage rbpDao = new ReimbursementPackage();
    			for (BaseCmbcPayment baseCmbcPayment : rpsList) {
    				String yurref = baseCmbcPayment.getYurref();
    				Date eptTime = baseCmbcPayment.getEpttim();
    				Date beginDate = DateUtil.getNextDayOfDay(eptTime, -2);
    				Date endDate = DateUtil.getNextDayOfDay(eptTime, 2);
    				String beginDateStr = SDF_DATE.format(beginDate);
    				String endDateStr = SDF_DATE.format(endDate);
    				Map<String, Object> params = new HashMap<>();
    				params.put("BGNDAT", beginDateStr);//开始日期
					params.put("ENDDAT", endDateStr);//结束日期
					params.put("DATFLG", DATFLG);//日期类型   A:经办日期  B:期望日期
					params.put("YURREF", yurref);//业务参考号
    				if(Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_1)
    						|| Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_5)){//支付
    					
    					if(Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_1)){
    						params.put("BUSCOD", "N02030");
    					}else{
    						params.put("BUSCOD", "N02020");
    					}
    					String packageStr = CreateCMBBankXmlUtil.createGetPaymentInfoXML(params);
    					String resultStr = CMBBankUtil.sendPackageToCMB(packageStr);
    					Document document = DocumentHelper.parseText(resultStr);
    					Element rootElement = document.getRootElement();
    					Element infoElement = rootElement.element("INFO");
    					Element retcodElement = infoElement.element("RETCOD");//返回代码
    					Element errmsgElement = infoElement.element("ERRMSG");//错误信息
    					String errorMsg = null != errmsgElement ? errmsgElement.getStringValue() : null;
    					if(retcodElement.getStringValue().equals("0")){
    						//4.根据业务参考号查询成功，但是返回记录数不止一条。由于失败的业务参考号可以重用，因此当用户使用同一业务参考号发送失败多次后，
    						//有可能会产生相同业务参考号的多笔记录，用户可以通过返回信息的REQNBR(流程实例号)的大小判断最近一次经办的结果（最大的流程实例号为最近一次经办的结果）。
    						List<Element> ntqpayqyzElementList = rootElement.elements("NTQPAYQYZ");
    						if(ntqpayqyzElementList.size() > 0){
    							Element fiElement = null;
    							Long reqnber = null;
    							for (Element element : ntqpayqyzElementList) {
    								Element reqnbrElement = element.element("REQNBR");
    								Long checkReq = Long.parseLong(reqnbrElement.getStringValue());
    								if(null == fiElement){
    									fiElement = element;
    								}
    								if(null == reqnber){
    									reqnber = checkReq;
    								}else{
    									if(checkReq.compareTo(reqnber) > 0){
    										fiElement =  element;
    									}
    								}
								}
    							//3.查询成功，返回数据判断方法：返回的每笔信息中REQSTS如果不等于’FIN’表示该笔支付银行还在处理中，
    							//REQSTS=’FIN’时再判断RTNFLG，RTNFLG为’S’时表示成功，’B’表示退票，其他作为失败处理；
    							Element reqstsElement = fiElement.element("REQSTS");
    							if(reqstsElement.getStringValue().equals("FIN")){//处理银行终端已经审批的业务
    								Element rtnflgElement = fiElement.element("RTNFLG");
    								cpDao.clear();
    								cpDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
    								cpDao.setPayStatus(PAY_STATUS_3);//设置支付状态为完成  表示银行终端已处理
    								cpdDao.clear();
    								cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_1);
    								cpdDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
    								if(rtnflgElement.getStringValue().equals("S")){//完全成功
    									cpDao.setPayResult(PAY_RESULT_1);
    									cpdDao.setStatus(DETAIL_STATUS_2);
    								}else if(rtnflgElement.getStringValue().equals("B")){//退票
    									cpDao.setPayResult(PAY_RESULT_2);
    									cpdDao.setStatus(DETAIL_STATUS_5);
    								}else{//失败
    									cpDao.setPayResult(PAY_RESULT_4);
    									cpdDao.setStatus(DETAIL_STATUS_3);
    								}
    								//结果摘要 支付结算业务处理的结果描述，如失败原因、退票原因等
    								Element rtnnarElement = fiElement.element("RTNNAR");
    								if(null != rtnnarElement){
    									errorMsg = rtnnarElement.getStringValue();
    								}
    								cpDao.setErrorMsg(errorMsg);
    								cpDao.conditionalUpdate();
    								cpdDao.setErrorMsg(errorMsg);
    								cpdDao.conditionalUpdate();
    								
    								rbpDao.clear();
    								rbpDao.setConditionReimbursementPackageId("=", baseCmbcPayment.getReimbursementPackageId());
    								rbpDao.setPayStatus(PAY_STATUS_4);
    								rbpDao.conditionalUpdate();
    							}
    						}else{//没有查询到该单业务  视为失败
    							
    							cpDao.clear();
								cpDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
								cpDao.setPayStatus(PAY_STATUS_3);//设置支付状态为完成  表示银行终端已处理
								cpDao.setPayResult(PAY_RESULT_4);
								cpDao.setErrorMsg("从银行没有查询到该单业务情况, 视为失败");
								cpDao.conditionalUpdate();
								cpdDao.clear();
								cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_1);
								cpdDao.setConditionCmbcPaymentId("=", cpDao.getCmbcPaymentId());
								cpdDao.setStatus(DETAIL_STATUS_3);
								cpdDao.conditionalUpdate();
    						}
    					}else{//查询失败  这里应该将错误发送消息给 IT管理人员;  对业务单不做任何处理;系统级错误
    						String errmsg = String.format("通过前置机查询支付信息失败;cmbMsg:[%1$s];cmbcPaymentId[%2$s]", 
    								errorMsg, 
    								baseCmbcPayment.getCmbcPaymentId());
//    						WeixinUtils.sendTextMsgToUser(WeixinUtils.TEST_USERID, errmsg);
    					}
    					
					}else if(Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_2) || 
								Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_3) ||
								Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_4)){//代发
						if(Objects.equals(baseCmbcPayment.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_2)){
							params.put("BUSCOD", "N03010");
						}else {
							params.put("BUSCOD", "N03020");
						}
						//对于代发查询   需要通过 4.3 根据业务参考号查询出 流程实例号后再通过4.4查询出所有详细交易进行处理
						String packageStr = CreateCMBBankXmlUtil.createGetAgentInfoXML(params);
    					String resultStr = CMBBankUtil.sendPackageToCMB(packageStr);
    					Document document = DocumentHelper.parseText(resultStr);
    					Element rootElement = document.getRootElement();
    					Element infoElement = rootElement.element("INFO");
    					Element retcodElement = infoElement.element("RETCOD");//返回代码
    					Element errmsgElement = infoElement.element("ERRMSG");//错误信息
    					String errorMsg = null != errmsgElement ? errmsgElement.getStringValue() : null;
    					if(retcodElement.getStringValue().equals("0")){
    						//4.根据业务参考号查询成功，但是返回记录数不止一条。由于失败的业务参考号可以重用，因此当用户使用同一业务参考号发送失败多次后，
    						//有可能会产生相同业务参考号的多笔记录，用户可以通过返回信息的REQNBR(流程实例号)的大小判断最近一次经办的结果（最大的流程实例号为最近一次经办的结果）。
    						List<Element> ntqpayqyzElementList = rootElement.elements("NTQATSQYZ");
    						if(ntqpayqyzElementList.size() > 0){
    							Element fiElement = null;
    							Long reqnber = null;
    							for (Element element : ntqpayqyzElementList) {
    								Element reqnbrElement = element.element("REQNBR");
    								Long checkReq = Long.parseLong(reqnbrElement.getStringValue());
    								if(null == fiElement){
    									fiElement = element;
    								}
    								if(null == reqnber){
    									reqnber = checkReq;
    								}else{
    									if(checkReq.compareTo(reqnber) > 0){
    										fiElement =  element;
    									}
    								}
								}
    							//3.查询成功，返回数据判断方法：返回的每笔信息中REQSTS如果不等于’FIN’表示该笔支付银行还在处理中，
    							//REQSTS=’FIN’时再判断RTNFLG，RTNFLG为’S’时表示成功，’B’表示退票，其他作为失败处理；
    							Element reqstsElement = fiElement.element("REQSTA");
    							Element reqnbrElement = fiElement.element("REQNBR");
    							String reqnbr = reqnbrElement.getStringValue();
    							if(reqstsElement.getStringValue().equals("FIN")){//处理银行终端已经审批的业务
    								Element rtnflgElement = fiElement.element("RTNFLG");
    								cpDao.clear();
    								cpDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
    								cpDao.setPayStatus(PAY_STATUS_3);//设置支付状态为完成  表示银行终端已处理
    								cpDao.setErrorMsg(errorMsg);
    								//设置成功的笔数与金额
									Element sucnumElement = fiElement.element("SUCNUM");//成功笔数
									Element sucamtElement = fiElement.element("SUCAMT");//成功金额
									if(null != sucnumElement){
										cpDao.setSuccessTotalNum(Integer.parseInt(sucnumElement.getStringValue()));
									}
									if(null != sucamtElement){
										cpDao.setSuccessTotalAmount(new BigDecimal(sucamtElement.getStringValue()));
									}
    								if(rtnflgElement.getStringValue().equals("S")){//成功(包含完全成与部分成功)
    									//当REQSTA=FIN且RTNFLG=S需检查RSV62Z第一位是否为’P’，是表示部分成功，否则表示全部成功。
    									//部分成功时需要查询详细接口进行单条数据匹配
    									Element rsv62zElement = fiElement.element("RSV62Z");
    									//没有数值返回的时候为完全成功
    									if(null == rsv62zElement || null == rsv62zElement.getStringValue()){
    										cpDao.setPayResult(PAY_RESULT_1);
    									}else{
    										//当为部分成功时  只有查询到支付详细信息且匹配更新状态后  才将主支付信息状态改为已处理 否则把状态更新为待处理
	    									String checkChar = rsv62zElement.getStringValue().substring(0, 1);
	    									if(checkChar.equals("P")){//P:部分成功 根据流程实例号查询查询代发详细接口进行匹配检查
	    										Map<String, Object> detailParams = new HashMap<>();
	    										detailParams.put("REQNBR", reqnbr);
	    										String detailPackageStr = CreateCMBBankXmlUtil.createGetAgentDetailXML(detailParams);
	    										String detailResultStr = CMBBankUtil.sendPackageToCMB(detailPackageStr);
	    				    					Document detailDocument = DocumentHelper.parseText(detailResultStr);
	    				    					Element detailRootElement = detailDocument.getRootElement();
	    				    					Element detailInfoElement = detailRootElement.element("INFO");
	    				    					Element detailRetcodElement = detailInfoElement.element("RETCOD");//返回代码
	    				    					Element detailRrrmsgElement = detailInfoElement.element("ERRMSG");//错误信息
	    				    					if(detailRetcodElement.getStringValue().equals("0")){
	    				    						List<Element> ntqatdqyzList = detailRootElement.elements("NTQATDQYZ");
	    				    						if(ntqatdqyzList.size() > 0){
	    				    							for (Element element : ntqatdqyzList) {
	    				    								//账号
	    				    								Element accnbrElement = element.element("ACCNBR");
	    				    								//户名
	    				    								Element cltnamElement = element.element("CLTNAM");
	    				    								//金额
	    				    								Element trsamtElement = element.element("TRSAMT");
	    				    								//注释
	    				    								Element trsdspElement = element.element("TRSDSP");
	    				    								//状态
	    				    								Element stscodElement = element.element("STSCOD");
	    				    								String stscode = stscodElement.getStringValue();
	    				    								cpdDao.clear();
	    				    								cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_1);
	    				    								cpdDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
	    				    								cpdDao.setConditionCrtacc("=", accnbrElement.getStringValue());
	    				    								cpdDao.setConditionCrtnam("=", cltnamElement.getStringValue());
	    				    								cpdDao.setConditionTrsamt("=", new BigDecimal(trsamtElement.getStringValue()));
	    				    								if(stscode.equals("S")){
	    				    									cpdDao.setStatus(DETAIL_STATUS_2);
	    				    								}else if(stscode.equals("F")){
	    				    									cpdDao.setStatus(DETAIL_STATUS_3);
	    				    								}else if(stscode.equals("C")){
	    				    									cpdDao.setStatus(DETAIL_STATUS_4);
	    				    								}else if(stscode.equals("I")){
	    				    									cpdDao.setStatus(DETAIL_STATUS_1);
	    				    								}
	    				    								if(null != trsdspElement){
	    				    									cpdDao.setErrorMsg(trsdspElement.getStringValue());
	    				    								}
	    				    								cpdDao.conditionalUpdate();
														}
	    				    							cpDao.setPayResult(PAY_RESULT_3);
	    				    						}else{
	    				    							cpDao.setPayStatus(PAY_STATUS_2);//支付正在处理
	    				    							cpDao.setErrorMsg("支付数据已经被银行处理(部分成功),但没有找到代发详细数据情况");
	    				    						}
	    				    					}else{
	    				    						cpDao.setPayStatus(PAY_STATUS_2);//支付正在处理
	    				    						cpDao.setErrorMsg("支付数据已经被银行处理(部分成功),但没有找到代发详细数据情况");
	    				    					}
	    									}else{//完全成功
	    										cpDao.setPayResult(PAY_RESULT_1);
	    									}
    									}
    									
    								}else if(rtnflgElement.getStringValue().equals("F")){//失败
    									cpDao.setPayResult(PAY_RESULT_4);
    								}else{
    									cpDao.setPayResult(PAY_RESULT_4);
    									cpDao.setErrorMsg("该单有可能被驳回或其他处理 RTNFLG=" + rtnflgElement.getStringValue());
    								}
    								cpDao.setReqnbr(reqnbr);
    								cpDao.conditionalUpdate();
    								if(Objects.equals(cpDao.getPayResult(), PAY_RESULT_4)){//失败
    									cpdDao.clear();
    									cpdDao.setErrorMsg(errorMsg);
    									cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_1);
	    								cpdDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
	    								cpdDao.setStatus(DETAIL_STATUS_3);
	    								cpdDao.conditionalUpdate();
    								}else if(Objects.equals(cpDao.getPayResult(), PAY_RESULT_1)){//完全成功
    									cpdDao.clear();
    									cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_1);
    									cpdDao.setErrorMsg(errorMsg);
	    								cpdDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
	    								cpdDao.setStatus(DETAIL_STATUS_2);
	    								cpdDao.conditionalUpdate();
    								}
    								rbpDao.clear();
    								rbpDao.setConditionReimbursementPackageId("=", baseCmbcPayment.getReimbursementPackageId());
    								rbpDao.setPayStatus(PAY_STATUS_4);
    								rbpDao.conditionalUpdate();
    							}
    						}else{//没有查询到该单业务  视为失败
    							cpDao.clear();
								cpDao.setConditionCmbcPaymentId("=", baseCmbcPayment.getCmbcPaymentId());
								cpDao.setPayStatus(PAY_STATUS_3);//设置支付状态为完成  表示银行终端已处理
								cpDao.setPayResult(PAY_RESULT_4);
								cpDao.setErrorMsg("从银行没有查询到该单业务情况, 视为失败");
								cpDao.conditionalUpdate();
    						}
    					}else{//查询失败  这里应该将错误发送消息给 IT管理人员;  对业务单不做任何处理;系统级错误
    						String errmsg = String.format("通过前置机查询代发信息失败;cmbMsg:[%1$s];cmbcPaymentId[%2$s]", 
    								errorMsg, 
    								baseCmbcPayment.getCmbcPaymentId());
//    						WeixinUtils.sendTextMsgToUser(WeixinUtils.TEST_USERID, errmsg);
    					}
					}
				}
    		}
    		
    		
    		
    		/******************************  退单业务的重新查询 ***************************/
    		//处理前置机通信过后返回为退单的业务 
    		//退单后的订单会经过改正数据进行重新提交   查询  状态为数据录入,退单标志为2(退单重新发起单) 退单发起标志为3(已提起支付)
    		CmbcPayDetail cpdDao = new CmbcPayDetail();
    		cpdDao.setConditionStatus("=", DETAIL_STATUS_1);
    		cpdDao.setConditionWithdrawFlag("=", WITHDRAW_FLAG_2);
    		cpdDao.setConditionWithdrawStatus("=", 3);
    		List<BaseCmbcPayDetail> cpdList = cpdDao.conditionalLoad();
    		for (BaseCmbcPayDetail baseCmbcPayDetail : cpdList) {
    			cpdDao.clear();
    			cpdDao.setCmbcPayDetailId(baseCmbcPayDetail.getCmbcPayDetailId());
    			if(!cpdDao.load()){
    				continue;
    			}
    			
				String yurref = baseCmbcPayDetail.getYurref();
				Date eptTime = baseCmbcPayDetail.getEptdat();
				Date beginDate = DateUtil.getNextDayOfDay(eptTime, -2);
				Date endDate = DateUtil.getNextDayOfDay(eptTime, 2);
				String beginDateStr = SDF_DATE.format(beginDate);
				String endDateStr = SDF_DATE.format(endDate);
				Map<String, Object> params = new HashMap<>();
				params.put("BGNDAT", beginDateStr);//开始日期
				params.put("ENDDAT", endDateStr);//结束日期
				params.put("DATFLG", DATFLG);//日期类型   A:经办日期  B:期望日期
				params.put("YURREF", yurref);//业务参考号
				if(Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_1)
						|| Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_5)){//支付
					
					if(Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_1)){
						params.put("BUSCOD", "N02030");
					}else{
						params.put("BUSCOD", "N02020");
					}
					String packageStr = CreateCMBBankXmlUtil.createGetPaymentInfoXML(params);
					String resultStr = CMBBankUtil.sendPackageToCMB(packageStr);
					Document document = DocumentHelper.parseText(resultStr);
					Element rootElement = document.getRootElement();
					Element infoElement = rootElement.element("INFO");
					Element retcodElement = infoElement.element("RETCOD");//返回代码
					Element errmsgElement = infoElement.element("ERRMSG");//错误信息
					String errorMsg = null != errmsgElement ? errmsgElement.getStringValue() : null;
					if(retcodElement.getStringValue().equals("0")){
						//4.根据业务参考号查询成功，但是返回记录数不止一条。由于失败的业务参考号可以重用，因此当用户使用同一业务参考号发送失败多次后，
						//有可能会产生相同业务参考号的多笔记录，用户可以通过返回信息的REQNBR(流程实例号)的大小判断最近一次经办的结果（最大的流程实例号为最近一次经办的结果）。
						List<Element> ntqpayqyzElementList = rootElement.elements("NTQPAYQYZ");
						if(ntqpayqyzElementList.size() > 0){
							Element fiElement = null;
							Long reqnber = null;
							for (Element element : ntqpayqyzElementList) {
								Element reqnbrElement = element.element("REQNBR");
								Long checkReq = Long.parseLong(reqnbrElement.getStringValue());
								if(null == fiElement){
									fiElement = element;
								}
								if(null == reqnber){
									reqnber = checkReq;
								}else{
									if(checkReq.compareTo(reqnber) > 0){
										fiElement =  element;
									}
								}
							}
							//3.查询成功，返回数据判断方法：返回的每笔信息中REQSTS如果不等于’FIN’表示该笔支付银行还在处理中，
							//REQSTS=’FIN’时再判断RTNFLG，RTNFLG为’S’时表示成功，’B’表示退票，其他作为失败处理；
							Element reqstsElement = fiElement.element("REQSTS");
							if(reqstsElement.getStringValue().equals("FIN")){//处理银行终端已经审批的业务
								Element rtnflgElement = fiElement.element("RTNFLG");
								if(rtnflgElement.getStringValue().equals("S")){//完全成功
									cpdDao.setStatus(DETAIL_STATUS_2);
								}else if(rtnflgElement.getStringValue().equals("B")){//退票
									cpdDao.setStatus(DETAIL_STATUS_5);
								}else{//失败
									cpdDao.setStatus(DETAIL_STATUS_3);
								}
								//结果摘要 支付结算业务处理的结果描述，如失败原因、退票原因等
								Element rtnnarElement = fiElement.element("RTNNAR");
								if(null != rtnnarElement){
									errorMsg = rtnnarElement.getStringValue();
								}
							}
						}else{//没有查询到该单业务  视为失败
							cpdDao.setStatus(DETAIL_STATUS_3);
						}
						cpdDao.setErrorMsg(errorMsg);
					}else{//查询失败  这里应该将错误发送消息给 IT管理人员;  对业务单不做任何处理;系统级错误
						String errmsg = String.format("通过前置机查询支付信息失败;cmbMsg:[%1$s];cmbcPayDetailId[%2$s]", 
								errorMsg, 
										baseCmbcPayDetail.getCmbcPayDetailId());
//						WeixinUtils.sendTextMsgToUser(WeixinUtils.TEST_USERID, errmsg);
					}
					
				}else if(Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_2) || 
							Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_3) ||
							Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_4)){//代发
					if(Objects.equals(baseCmbcPayDetail.getType(), ReimbursementPackageCmbPayUtil.PAY_TYPE_2)){
						params.put("BUSCOD", "N03010");
					}else {
						params.put("BUSCOD", "N03020");
					}
					//对于代发查询   需要通过 4.3 根据业务参考号查询出 流程实例号后再通过4.4查询出所有详细交易进行处理
					String packageStr = CreateCMBBankXmlUtil.createGetAgentInfoXML(params);
					String resultStr = CMBBankUtil.sendPackageToCMB(packageStr);
					Document document = DocumentHelper.parseText(resultStr);
					Element rootElement = document.getRootElement();
					Element infoElement = rootElement.element("INFO");
					Element retcodElement = infoElement.element("RETCOD");//返回代码
					Element errmsgElement = infoElement.element("ERRMSG");//错误信息
					String errorMsg = null != errmsgElement ? errmsgElement.getStringValue() : null;
					if(retcodElement.getStringValue().equals("0")){
						//4.根据业务参考号查询成功，但是返回记录数不止一条。由于失败的业务参考号可以重用，因此当用户使用同一业务参考号发送失败多次后，
						//有可能会产生相同业务参考号的多笔记录，用户可以通过返回信息的REQNBR(流程实例号)的大小判断最近一次经办的结果（最大的流程实例号为最近一次经办的结果）。
						List<Element> ntqpayqyzElementList = rootElement.elements("NTQATSQYZ");
						if(ntqpayqyzElementList.size() > 0){
							Element fiElement = null;
							Long reqnber = null;
							for (Element element : ntqpayqyzElementList) {
								Element reqnbrElement = element.element("REQNBR");
								Long checkReq = Long.parseLong(reqnbrElement.getStringValue());
								if(null == fiElement){
									fiElement = element;
								}
								if(null == reqnber){
									reqnber = checkReq;
								}else{
									if(checkReq.compareTo(reqnber) > 0){
										fiElement =  element;
									}
								}
							}
							//3.查询成功，返回数据判断方法：返回的每笔信息中REQSTS如果不等于’FIN’表示该笔支付银行还在处理中，
							//REQSTS=’FIN’时再判断RTNFLG，RTNFLG为’S’时表示成功，’B’表示退票，其他作为失败处理；
							Element reqstsElement = fiElement.element("REQSTA");
							Element reqnbrElement = fiElement.element("REQNBR");
							String reqnbr = reqnbrElement.getStringValue();
							if(reqstsElement.getStringValue().equals("FIN")){//处理银行终端已经审批的业务
								Element rtnflgElement = fiElement.element("RTNFLG");
								if(rtnflgElement.getStringValue().equals("S")){//成功(包含完全成与部分成功)
									cpdDao.setStatus(DETAIL_STATUS_2);
//									//当REQSTA=FIN且RTNFLG=S需检查RSV62Z第一位是否为’P’，是表示部分成功，否则表示全部成功。
//									//部分成功时需要查询详细接口进行单条数据匹配
//									Element rsv62zElement = fiElement.element("RSV62Z");
//									//设置成功的笔数与金额
//									Element sucnumElement = fiElement.element("SUCNUM");//成功笔数
//									Element sucamtElement = fiElement.element("SUCAMT");//成功金额
//									//没有数值返回的时候为成功
//									if(null == rsv62zElement || null == rsv62zElement.getStringValue()){
//										cpdDao.setStatus(DETAIL_STATUS_2);
//									}else{
//										//当为部分成功时  只有查询到支付详细信息且匹配更新状态后  才将主支付信息状态改为已处理 否则把状态更新为待处理
//    									String checkChar = rsv62zElement.getStringValue().substring(0, 1);
//    									if(checkChar.equals("P")){//P:部分成功 根据流程实例号查询查询代发详细接口进行匹配检查
//    										//退单是单笔付没有部分成功的情况  只有成功与失败
//    										cpdDao.setStatus(DETAIL_STATUS_3);
//    									}else{//完全成功
//    										cpdDao.setStatus(DETAIL_STATUS_2);
//    									}
//									}
									
								}else if(rtnflgElement.getStringValue().equals("F")){//失败
									cpdDao.setStatus(DETAIL_STATUS_3);
								}
							}
						}else{//没有查询到该单业务  视为失败
							cpdDao.setStatus(DETAIL_STATUS_3);
							cpdDao.setErrorMsg("从银行没有查询到该单业务情况, 视为失败");
						}
						cpdDao.setErrorMsg(errorMsg);
					}else{//查询失败  这里应该将错误发送消息给 IT管理人员;  对业务单不做任何处理;系统级错误
						String errmsg = String.format("通过前置机查询代发信息失败;cmbMsg:[%1$s];cmbcPayDetailId[%2$s]", 
								errorMsg, 
										baseCmbcPayDetail.getCmbcPayDetailId());
//						WeixinUtils.sendTextMsgToUser(WeixinUtils.TEST_USERID, errmsg);
					}
				}
				cpdDao.update();
			}
		} catch (Exception e) {
			e.printStackTrace();
			__logger.error("查询交易结果异常", e);
		}
       
    }

	public BaseCmbcPayment getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(BaseCmbcPayment searchBean) {
		this.searchBean = searchBean;
	}
	
	public static void main(String[] args) {
		CheckCmbPayInfoTimer timer = new CheckCmbPayInfoTimer();
		timer.run();
	}
}
