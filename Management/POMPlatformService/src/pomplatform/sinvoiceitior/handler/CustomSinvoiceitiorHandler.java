package pomplatform.sinvoiceitior.handler;

import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractReceivable;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BaseInvoicesToContractReceivable;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractReceivable;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.InvoiceApply;
import com.pomplatform.db.dao.InvoicesToContractReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceitiorcount;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceorusecount;
import pomplatform.sinvoiceitior.bean.ConditionSinvoiceitiorcount;
import pomplatform.sinvoiceitior.query.QuerySinvoiceitiorcount;
import pomplatform.sinvoiceitior.query.QuerySinvoiceorusecount;

/**
 * 
 * @ClassName: CustomSinvoiceitiorHandler 
 * @Description:  发票管理处理控制类
 * @author CL
 * @date 2016年11月3日 
 *
 */
public class CustomSinvoiceitiorHandler implements GenericProcessor, GenericDownloadProcessor {
	//0:未使用 1:正常发票。2:负数发票。;3:填开作废。4.负数作废。5.空白作废。
	private final static int SIGN_ZERO = 0;
	private final static int SIGN_ONE = 1;
	private final static int SIGN_TWO = 2;
	private final static int SIGN_THREE = 3;
	private final static int SIGN_FOUR = 4;
	private final static int SIGN_FIVE = 5;
	
	private final static int DISABLE_TYPE = 1;//不可用
	
	private final static int ENABLE_TYPE = 0;//可用
	
	private final static String GET_CONTRACT_TO_INVOICE = "getContractToInvoice";//获取主合同下拉选择项
	
	private final static String GET_INVOICE_BY_COMPANY = "getInvoiceByCompany";//根据购票公司获取发票
	
	private final static String GET_CONTRACT_RECEIVABLE_BY_CONTRACT_ID = "getContractReceivableByContractId";//根据合同编号ID阶段信息
	
	private final static String DESTORY_EMPTY_INVOICE = "destoryEmptyInvoice";//空白作废
	
	private final static String GET_INVOICEINFO_BYIDS= "getInvoiceInfoByIds";//根据逗号拼接的主键Id获取数据
	
	private final static String ADD_INVOICES = "addInvoices";// 购买发票 /发票入库
	
	private final static String ADD_SING_ONE_INVOICES = "addSingOneInvoices";//填开发票
	
	private final static String ABANDONED_INVOICES = "abandonedInvoices";//发票作废
	
	private final static String GET_INVOICES_BY_CONTRACTID = "getInvoicesByContractId";//根据合同主键获取发票信息(只含可操作的 发票)
	
	private final static String DEL_EMPTY_INVOICES = "delEmptyInvoices";//删除发票(但实际上是清空发票信息)  洗白 将发票重置为未使用
	
	private final static String UPDATE_ONE_INVOICES = "updateOneInvoices"; //单张发票信息的数据修改
	
	private final static String ADD_SIGN_TWO_INVOICES = "addSignTwoInvoices";//添加负数发票
	
	private final static String GET_CONTRACT_INFO_BY_CONTRACT = "getContractInfoByContract";//根据合同主键获取合同信息
	
	private final static String USE_INVOICES_COUNT = "useInvoicesCount";//统计正常使用的发票数据
	
	private final static String INVOICES_CONNECT_CONTRACT = "invoicesConnectContract";//给人工导入的发票关联合同
	
	//invoice_apply_status申请状态  1:已申请 2：已处理 3：已驳回
	private static final int INVOICE_APPLY_STATUS_ONE = 1;
	private static final int INVOICE_APPLY_STATUS_TWO = 2;
	private static final int INVOICE_APPLY_STATUS_THREE = 3;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
				case DESTORY_EMPTY_INVOICE:
					return destoryEmptyInvoice(result);
				case GET_INVOICEINFO_BYIDS:
					return getInvoiceInfoByIds(result);
				case ADD_INVOICES:
					return addInvoices(result);
				case GET_CONTRACT_TO_INVOICE:
					return getContractToInvoice(result);
				case ADD_SING_ONE_INVOICES:	
					return addSingOneInvoices(result);
				case GET_INVOICE_BY_COMPANY:
					return getInvoiceByCompany(result);
				case GET_CONTRACT_RECEIVABLE_BY_CONTRACT_ID:
					return getContractReceivableByContractId(result);
				case ABANDONED_INVOICES:
					return abandonedInvoices(result);
				case GET_INVOICES_BY_CONTRACTID:
					return getInvoicesByContractId(result);
				case DEL_EMPTY_INVOICES:
					return delEmptyInvoices(result);
				case UPDATE_ONE_INVOICES:
					return updateOneInvoices(result);
				case ADD_SIGN_TWO_INVOICES:
					return addSignTwoInvoices(result);
				case GET_CONTRACT_INFO_BY_CONTRACT:
					return getContractInfoByContract(result);
				case USE_INVOICES_COUNT:
					return useInvoicesCount(creteria);
				case INVOICES_CONNECT_CONTRACT:
					return invoicesConnectContract(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: invoicesConnectContract 
	 * @Description: 给人工导入的发票关联合同
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String invoicesConnectContract(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		String contractCode = BaseHelpUtils.getStringValue(result, "contractCode");
		Boolean isFillIn = BaseHelpUtils.getBoolean(result.get("isFillIn"));
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(BaseHelpUtils.isNullOrEmpty(ids)){
			status = -1;
			errorMsg = "没有获取到发票数据";
		}else{
			String [] idsArra = ids.split(",");
			Object [] objIds = new Object[idsArra.length];
			
			for (int i = 0; i < idsArra.length; i++) {
				objIds[i] = Integer.parseInt(idsArra[i]);
			}
			
			Invoice dao = new Invoice();
			dao.addCondition("invoice_id", "in", objIds);
			if(isFillIn){
				if(BaseHelpUtils.isNullOrEmpty(contractCode)){
					status = -1;
					errorMsg = "没有填写合同编号！";
				}else{
					dao.setContractCode(contractCode);
					dao.conditionalUpdate();
				}
			}else{
				if(contractId > 0){
					dao.setContractId(contractId);
					dao.conditionalUpdate();
				}else{
					status = -1;
					errorMsg = "没有选择合同！";
				}
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: useInvoicesCount 
	 * @Description: 统计正常使用的发票数据
	 * @param @param creteria
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String useInvoicesCount(String creteria) throws Exception{
		
		ConditionSinvoiceitiorcount c = new ConditionSinvoiceitiorcount();
		c.setDataFromJSON(creteria);
		QuerySinvoiceitiorcount dao = new QuerySinvoiceitiorcount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSinvoiceitiorcount> result = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseSinvoiceitiorcount> list = result.getCollections();
		
		
		BaseSinvoiceorusecount invocieAmoutCount = new BaseSinvoiceorusecount();//正数发票开票金额
		invocieAmoutCount.setInName("正数发票开票金额");
		invocieAmoutCount.setSeventeen(new BigDecimal(0));
		invocieAmoutCount.setSix(new BigDecimal(0));
		invocieAmoutCount.setFive(new BigDecimal(0));
		invocieAmoutCount.setOther(new BigDecimal(0));

		BaseSinvoiceorusecount noTaxAmountCount = new BaseSinvoiceorusecount();//正数发票不含税金额
		noTaxAmountCount.setInName("正数发票不含税金额");
		noTaxAmountCount.setSeventeen(new BigDecimal(0));
		noTaxAmountCount.setSix(new BigDecimal(0));
		noTaxAmountCount.setFive(new BigDecimal(0));
		noTaxAmountCount.setOther(new BigDecimal(0));
		
		BaseSinvoiceorusecount outputTaxCount = new BaseSinvoiceorusecount();//正数发票销项税金额
		outputTaxCount.setInName("正数发票销项税金额");
		outputTaxCount.setSeventeen(new BigDecimal(0));
		outputTaxCount.setSix(new BigDecimal(0));
		outputTaxCount.setFive(new BigDecimal(0));
		outputTaxCount.setOther(new BigDecimal(0));
		
		BaseSinvoiceorusecount negInvocieAmoutCount = new BaseSinvoiceorusecount();//正数发票开票金额
		negInvocieAmoutCount.setInName("负数发票开票金额");
		negInvocieAmoutCount.setSeventeen(new BigDecimal(0));
		negInvocieAmoutCount.setSix(new BigDecimal(0));
		negInvocieAmoutCount.setFive(new BigDecimal(0));
		negInvocieAmoutCount.setOther(new BigDecimal(0));
		
		BaseSinvoiceorusecount negNoTaxAmountCount = new BaseSinvoiceorusecount();//正数发票不含税金额
		negNoTaxAmountCount.setInName("负数发票不含税金额");
		negNoTaxAmountCount.setSeventeen(new BigDecimal(0));
		negNoTaxAmountCount.setSix(new BigDecimal(0));
		negNoTaxAmountCount.setFive(new BigDecimal(0));
		negNoTaxAmountCount.setOther(new BigDecimal(0));
		
		BaseSinvoiceorusecount negOutputTaxCount = new BaseSinvoiceorusecount();//正数发票销项税金额
		negOutputTaxCount.setInName("负数发票销项税金额");
		negOutputTaxCount.setSeventeen(new BigDecimal(0));
		negOutputTaxCount.setSix(new BigDecimal(0));
		negOutputTaxCount.setFive(new BigDecimal(0));
		negOutputTaxCount.setOther(new BigDecimal(0));
		
		int allSignOne = 0;//正数发票份数
		int allSignThree = 0;//正数作废发票份数
		int allSignTwo = 0;//负数发票
		int allSignFour = 0;//负数作废发票份数
		//进行数据统计
		for (BaseSinvoiceitiorcount baseSinvoiceitiorcount : list) {
			BigDecimal taxRate = baseSinvoiceitiorcount.getTaxRate();
			BigDecimal sevenTeenTax = new BigDecimal(17);
			BigDecimal sixTax = new BigDecimal(6);
			BigDecimal fiveTax = new BigDecimal(5);
			int sign = baseSinvoiceitiorcount.getSign();
			switch (sign) {
			case SIGN_ONE:
				allSignOne ++;
				break;
			case SIGN_TWO:
				allSignTwo ++;
				break;
			case SIGN_THREE:
				allSignThree ++;
				break;
			case SIGN_FOUR:
				allSignFour ++;
				break;
			default:
				break;
			}
			if(sign == SIGN_ONE){
				if(taxRate.compareTo(sevenTeenTax) == 0){
					invocieAmoutCount.setSeventeen(invocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					noTaxAmountCount.setSeventeen(noTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					outputTaxCount.setSeventeen(outputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}else if(taxRate.compareTo(sixTax) == 0){
					invocieAmoutCount.setSix(invocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					noTaxAmountCount.setSix(noTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					outputTaxCount.setSix(outputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}else if(taxRate.compareTo(fiveTax) == 0){
					invocieAmoutCount.setFive(invocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					noTaxAmountCount.setFive(noTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					outputTaxCount.setFive(outputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}else{
					invocieAmoutCount.setOther(invocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					noTaxAmountCount.setOther(noTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					outputTaxCount.setOther(outputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}
			}else if(sign == SIGN_TWO){
				if(taxRate.compareTo(sevenTeenTax) == 0){
					negInvocieAmoutCount.setSeventeen(negInvocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					negNoTaxAmountCount.setSeventeen(negNoTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					negOutputTaxCount.setSeventeen(negOutputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}else if(taxRate.compareTo(sixTax) == 0){
					negInvocieAmoutCount.setSix(negInvocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					negNoTaxAmountCount.setSix(negNoTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					negOutputTaxCount.setSix(negOutputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}else if(taxRate.compareTo(fiveTax) == 0){
					negInvocieAmoutCount.setFive(negInvocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					negNoTaxAmountCount.setFive(negNoTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					negOutputTaxCount.setFive(negOutputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}else{
					negInvocieAmoutCount.setOther(negInvocieAmoutCount.getSeventeen().add(baseSinvoiceitiorcount.getInvoiceAmount()));
					negNoTaxAmountCount.setOther(negNoTaxAmountCount.getSeventeen().add(baseSinvoiceitiorcount.getNoTaxAmount()));
					negOutputTaxCount.setOther(negOutputTaxCount.getSeventeen().add(baseSinvoiceitiorcount.getOutputTax()));
				}
			}
		}
		
		List<BaseSinvoiceorusecount> list2 = new ArrayList<>();
		
		//设置正数总计
		invocieAmoutCount.setAllSum(invocieAmoutCount.getSeventeen().add(invocieAmoutCount.getSix()).add(invocieAmoutCount.getFive()).add(invocieAmoutCount.getOther()));
		noTaxAmountCount.setAllSum(noTaxAmountCount.getSeventeen().add(noTaxAmountCount.getSix()).add(noTaxAmountCount.getFive()).add(noTaxAmountCount.getOther()));
		outputTaxCount.setAllSum(outputTaxCount.getSeventeen().add(outputTaxCount.getSix()).add(outputTaxCount.getFive()).add(outputTaxCount.getOther()));
		list2.add(invocieAmoutCount);
		list2.add(noTaxAmountCount);
		list2.add(outputTaxCount);
		
		//设置负数总计
		negInvocieAmoutCount.setAllSum(negInvocieAmoutCount.getSeventeen().add(negInvocieAmoutCount.getSix()).add(negInvocieAmoutCount.getFive()).add(negInvocieAmoutCount.getOther()));
		negNoTaxAmountCount.setAllSum(negNoTaxAmountCount.getSeventeen().add(negNoTaxAmountCount.getSix()).add(negNoTaxAmountCount.getFive()).add(negNoTaxAmountCount.getOther()));
		negOutputTaxCount.setAllSum(negOutputTaxCount.getSeventeen().add(negOutputTaxCount.getSix()).add(negOutputTaxCount.getFive()).add(negOutputTaxCount.getOther()));

		list2.add(negInvocieAmoutCount);
		list2.add(negNoTaxAmountCount);
		list2.add(negOutputTaxCount);
		
		BaseCollection<BaseSinvoiceorusecount> cl = new BaseCollection<>();
		cl.setCollections(list2);
		StringBuilder sb = new StringBuilder();
		sb.append("正数发票数量: ").append(allSignOne).append("(张)   ")
			.append("正数作废发票: ").append(allSignThree).append("(张)   ")
			.append("负数发票: ").append(allSignTwo).append("(张)   ")
			.append("负数作废发票: ").append(allSignFour).append("(张)   ");
		return cl.toJSON(1, sb.toString());
	}
	
	/**
	 * 
	 * @Title: getContractInfoNameByContract 
	 * @Description: 根据合同主键获取合同信息以及 该合同下已开金额
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getContractInfoByContract(Map<String, Object> result) throws Exception{
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Contract dao = new Contract();
		dao.setConditionContractId("=", contractId);
		List<BaseContract> list = dao.conditionalLoad();
		double allMoney = 0;
		if(list.size() > 0){
			if(null != list.get(0).getSigningMoneySum()){
				allMoney = StaticMethod.getDouble2Value(list.get(0).getSigningMoneySum().doubleValue());
			}
		}
		//获取该合同下的已开发票金额
		BigDecimal allUseMoney = new BigDecimal(0);
		Invoice idao = new Invoice();
		idao.setConditionContractId("=", contractId);
		idao.setConditionSign("=", SIGN_ONE);
		List<BaseInvoice> ilist = idao.conditionalLoad();
		for (BaseInvoice baseInvoice : ilist) {
			allUseMoney = allUseMoney.add(baseInvoice.getInvoiceAmount());
		}
		double allUserDMoney = StaticMethod.getDouble2Value(allUseMoney.doubleValue());//已开金额
		BaseCollection<BaseContract> cl = new BaseCollection<>();
		cl.setCollections(list);
		String allMsg = "合同总金额=" + allMoney + "    已开金额=" + allUserDMoney + "    未开金额=" + (allMoney - allUserDMoney);
		return cl.toJSON(1, allMsg);
	}
	
	/**
	 * 
	 * @Title: addSignTwoInvoices 
	 * @Description: 添加负数发票
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String addSignTwoInvoices(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		String nums = "";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("list");
		List<BaseInvoice> dataList = new ArrayList<>();
		for (Map<String, Object> map : list) {
			BaseInvoice bean = new BaseInvoice();
			bean.setDataFromMap(map);
			dataList.add(bean);
		}
		Invoice dao = new Invoice();
		boolean flag = true;
		//检测数据的合法性
		for (BaseInvoice baseInvoice : dataList) {
			dao.clear();
			dao.setInvoiceId(baseInvoice.getInvoiceId());
			if(!(dao.load()  && dao.getDisableType() == ENABLE_TYPE && dao.getSign() == SIGN_ZERO)){
				status = -1;
				nums = nums +"," + baseInvoice.getInvoiceNumber();
				flag = false;
			}
		}
		Date currentDate = new Date();
		//进行负数发票数据添加
		if(flag){
			for (BaseInvoice baseInvoice : dataList) {
				dao.clear();
				dao.setPrimaryKeyFromBase(baseInvoice);
				if(dao.load()){
					dao.setDataFromBase(baseInvoice);
					dao.setInvoiceDate(currentDate);
					dao.update();
				}
			}
		}
		errorMsg = "发票号码 在 ("+ nums+")不可使用; Cause by ：{1:发票不存在 2:发票不可被编辑 3:发票不为一张空白发票}";
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: updateOneInvoices 
	 * @Description: 修改发票信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String updateOneInvoices(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		int invoiceId = BaseHelpUtils.getIntValue(result, "invoiceId");

		Invoice dao = new Invoice();
		dao.setInvoiceId(invoiceId);
		BaseInvoice bean = new BaseInvoice();
		bean.setDataFromMap(result);
		if(invoiceId > 0 && dao.load() && dao.getDisableType() == ENABLE_TYPE){
			dao.setDataFromBase(bean);
			dao.update();
			
		}else{
			status = 1;
			errorMsg = "数据错误,没有检测到合法的发票数据!请联系运维人员! invoiceId = "+ invoiceId+"; Cause by ：{1:发票不存在 2:发票不可被编辑 }";
		}
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: delEmptyInvoices 
	 * @Description: 清空发票数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String delEmptyInvoices(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		int invoiceId = BaseHelpUtils.getIntValue(result, "invoiceId");

		Invoice dao = new Invoice();
		dao.setInvoiceId(invoiceId);
		if(invoiceId > 0 && dao.load() && dao.getDisableType() == ENABLE_TYPE){
			dao.setCustomerId(null);
			dao.setInvalidRemark(null);
			dao.setIsInvalidOperator(null);
			dao.setInfoCode(null);
			dao.setProjectCode(null);
			dao.setContractId(null);
			dao.setContractCode(null);
			dao.setTaxRate(null);
			dao.setNoTaxAmount(null);
			dao.setOutputTax(null);
			dao.setBillingOperation(null);
			dao.setInvoiceDate(null);
			dao.setRegistrationDate(null);
			dao.setSign(SIGN_ZERO);
			dao.setPrimaryInvoiceCode(null);
			dao.setPrimaryInvoiceNumber(null);
			dao.setContractReceivableId(null);
			dao.setAcknowledgeLetterId(null);
			dao.setInvoiceExpressId(null);
			dao.setInvoiceAmount(null);
			dao.update();
			
		}else{
			status = -1;
			errorMsg = "数据错误,此发票不存在或者不可操作,请刷新浏览器!如若刷新无效,请联系运维人员!";
		}
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getInvoicesByContractId 
	 * @Description: 根据合同主键获取发票信息(只含可操作的 发票)
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getInvoicesByContractId(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		List<BaseInvoice> list = new ArrayList<>();
		Contract ctDao = new Contract();
		ctDao.setContractId(contractId);
		if(contractId > 0 && ctDao.load()){
			Invoice dao = new Invoice();
			dao.setConditionContractId("=", contractId);
//			dao.setConditionDisableType("=", ENABLE_TYPE);
			list = dao.conditionalLoad();
		}else{
			status = -1;
			errorMsg = "数据错误,没有检测到合法的合同主键!请联系运维人员!";
		}
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		cl.setCollections(list);
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: abandonedInvoices 
	 * @Description: 发票作废
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String abandonedInvoices(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		int invoiceId = BaseHelpUtils.getIntValue(result, "invoiceId");
		int sign = BaseHelpUtils.getIntValue(result, "sign");
		if(invoiceId > 0 && sign > 0){
			Invoice dao = new Invoice();
			dao.setInvoiceId(invoiceId);
			if(dao.load()){
				if(sign == SIGN_THREE){//填开作废 需要检测  此发票是否为正常发票
					if(dao.getSign() == SIGN_ONE){
						dao.setSign(sign);
						dao.update();
					}else{
						status = -1;
						errorMsg = "此发票不为正常发票 invoiceId=" + invoiceId;
					}
				}else if(sign == SIGN_FOUR){//负数作废  此发票为负数发票
					if(dao.getSign() == SIGN_TWO){
						dao.setSign(sign);
						dao.update();
					}else{
						status = -1;
						errorMsg = "此发票不为负数发票 invoiceId=" + invoiceId;
					}
				}else{
					status = -1;
					errorMsg = "没有进行任何操作,请联系运维人员  [invoiceId = " + invoiceId + "]---[sign = " +sign + "]";
				}
			}else{
				status = -1;
				errorMsg = "此发票不存在 invoiceId=" + invoiceId;
			}
			
		}else{
			status = -1;
			errorMsg = "数据错误,请联系运维人员  [invoiceId = " + invoiceId + "]---[sign = " +sign + "]";
		}
		
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getInvoiceByContractCode 
	 * @Description: 根据合同编号获取阶段信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getContractReceivableByContractId(Map<String, Object> result) throws Exception{
		List<BaseContractReceivable> list = new ArrayList<>();
		int status = 1;
		String errorMsg = "";
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		if(cDao.load()){
			ContractReceivable crDao = new ContractReceivable();
		    crDao.setConditionContractId("=", contractId);
		    list = crDao.conditionalLoad(" order by contract_receivable_id");
		}
		BaseCollection<BaseContractReceivable> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getInvoiceByCompany 
	 * @Description: 根据购票公司获取未使用的发票信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getInvoiceByCompany(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = "";
		int ticketingCompany = null == result.get("ticketingCompany") ? -1: BaseHelpUtils.getIntValue(result, "ticketingCompany");
		String invoiceNumber = BaseHelpUtils.getStringValue(result, "invoiceNumber");
		int invoiceType = null == result.get("invoiceType") ? -1: BaseHelpUtils.getIntValue(result, "invoiceType");

	    Invoice iDao = new Invoice();
	    if(invoiceType >= 0){
	    	iDao.setConditionInvoiceType("=", invoiceType);
	    }
	    if(ticketingCompany >= 0){
	    	iDao.setConditionTicketingCompany("=", ticketingCompany);
	    }
	    if(!BaseHelpUtils.isNullOrEmpty(invoiceNumber)){
	    	iDao.setConditionInvoiceNumber("like", "%" + invoiceNumber + "%");
	    }
	    iDao.setConditionSign("=", SIGN_ZERO);
		List<BaseInvoice> list = iDao.conditionalLoad(" order by invoice_number");
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: addSingOneInvoices 
	 * @Description: 填开发票
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String addSingOneInvoices(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("list");//需要修改的发票数据
		String ids = BaseHelpUtils.getString(result.get("ids"));//合同阶段Id  逗号拼接
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Invoice iDao = new Invoice();
		List<BaseInvoice> invoiceList = new ArrayList<>();
//		if(contractId > 0){
//			Contract ctDao = new Contract();
//			ctDao.setContractId(contractId);
//			if(ctDao.load()){
				
				for (Map<String, Object> map : list) {
					iDao.clear();
					BaseInvoice tmpBean = new BaseInvoice();
					
					tmpBean.setDataFromMap(map);
					iDao.setInvoiceId(tmpBean.getInvoiceId());
					if(iDao.load()){
//						iDao.setContractCode(ctDao.getContractCode());
						if(contractId > 0)iDao.setContractId(contractId);
//						iDao.setInfoCode(ctDao.getInfoCode());
						iDao.setSign(SIGN_ONE);
						iDao.setInvoiceAmount(tmpBean.getInvoiceAmount());
						iDao.setTaxRate(tmpBean.getTaxRate());
						iDao.setOutputTax(tmpBean.getOutputTax());
						iDao.setNoTaxAmount(tmpBean.getNoTaxAmount());
						iDao.setInvalidRemark(tmpBean.getInvalidRemark());
						iDao.setInvoiceDate(tmpBean.getInvoiceDate());
						iDao.setCustomerId(tmpBean.getCustomerId());
						iDao.update();
					}
					invoiceList.add(tmpBean);
				}
//			}else{
//				status = -1;
//				errorMsg = "合同不存在";
//			}
//		}else{
//			status = -1;
//			errorMsg = "没有选择合同";
//		}
		
		//当有选择合同阶段 与开发票数据 则进行中间表信息关联
		if(!BaseHelpUtils.isNullOrEmpty(ids) && invoiceList.size() > 0){
			List<BaseInvoicesToContractReceivable> tmpList = new ArrayList<>();//添加关联数据
			String [] idsArr = ids.split(",");
			for (String string : idsArr) {
				for (BaseInvoice baseInvoice : invoiceList) {
					BaseInvoicesToContractReceivable tmpItcrBean = new BaseInvoicesToContractReceivable();
					tmpItcrBean.setContractReceivableId(Integer.parseInt(string));
					tmpItcrBean.setInvoiceId(baseInvoice.getInvoiceId());
					tmpItcrBean.setOperator(employeeId);
					tmpList.add(tmpItcrBean);
				}
			}
			InvoicesToContractReceivable itrDao = new InvoicesToContractReceivable();
			//插入关联数据
			if(tmpList.size() > 0){
				itrDao.save(tmpList);
			}
		}
		//如果是针对申请的数据进行开票 则进行申请状态修改
		if(status > 0){
			if(null != result.get("invoiceApplyId")){
				int invoiceApplyId = BaseHelpUtils.getIntValue(result, "invoiceApplyId");
				InvoiceApply iaDao = new InvoiceApply();
				iaDao.setInvoiceApplyId(invoiceApplyId);
				if(iaDao.load()){
					iaDao.setInvoiceApplyStatus(INVOICE_APPLY_STATUS_TWO);
					iaDao.setOperatorTime(new Date());
					iaDao.setOperatorId(employeeId);
					iaDao.update();
				}
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getContractToInvoice 
	 * @Description: 获取合同下拉选项数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getContractToInvoice(Map<String, Object> result) throws Exception{
		Contract cDao = new Contract();
		cDao.unsetSelectFlags();
		cDao.setSelectContractId(true);
		cDao.setSelectContractName(true);
		List<BaseContract> list = cDao.conditionalLoad(" order by contract_name");
		List<BaseSemployeepdror> dataList = new ArrayList<>();
		for (BaseContract baseContract : list) {
			BaseSemployeepdror tmpBean = new BaseSemployeepdror();
			tmpBean.setIdd(baseContract.getContractId());
			tmpBean.setVal(baseContract.getContractName());
			dataList.add(tmpBean);
		}
		BaseCollection<BaseSemployeepdror> cl = new BaseCollection<>();
		cl.setCollections(dataList);
		return cl.toJSON();
	}
	
	/**
	 * 
	 * @Title: addInvoices 
	 * @Description: 
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String addInvoices(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		//获取数据进行数据拆分与合并
		int count = BaseHelpUtils.getIntValue(result, "invoicCount");
		int invoiceType = BaseHelpUtils.getIntValue(result, "invoiceType");
		int ticketingCompany = BaseHelpUtils.getIntValue(result, "ticketingCompany");
		String invoiceCode = BaseHelpUtils.getStringValue(result, "invoiceCode");
		String invoiceNumber = BaseHelpUtils.getStringValue(result, "invoiceNumber");
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		if(BaseHelpUtils.isNullOrEmpty(invoiceCode) || BaseHelpUtils.isNullOrEmpty(invoiceNumber) || count == 0){
			status = -1;
			errorMsg = "数据错误！";
		}else{
			int __invoiceNumber = BaseHelpUtils.getIntValue(invoiceNumber);//发布号码连续累加
			List<BaseInvoice> finalSavaData = new ArrayList<>();
			Invoice iDao = new Invoice();
			Date currentDate = new Date();
			for (int i = 0; i < count; i++) {
				if(i != 0){
					__invoiceNumber ++;
				}
				BaseInvoice tmpBean = new BaseInvoice();
				tmpBean.setInvoiceCode(invoiceCode);
				tmpBean.setInvoiceNumber(String.format("%08d", __invoiceNumber));
				tmpBean.setTicketingCompany(ticketingCompany);
				tmpBean.setInvoiceType(invoiceType);
				tmpBean.setInStockDate(currentDate);
				tmpBean.setSign(SIGN_ZERO);
				tmpBean.setStorageOperator(employeeId);
				tmpBean.setDisableType(ENABLE_TYPE);
				//当发票号码不存在时才准许去添加发票
				iDao.clear();
				iDao.setConditionInvoiceNumber("=", tmpBean.getInvoiceNumber());
				if(iDao.countRows() <= 0){
					finalSavaData.add(tmpBean);
				}
			}
			if(finalSavaData.size() > 0){
				//批量插入
				iDao.save(finalSavaData);
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getInvoiceInfoByIds 
	 * @Description: 根据逗号拼接的主键获取发票信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	private String getInvoiceInfoByIds(Map result) throws Exception{
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		Invoice iDao = new Invoice();
		String invoiceIds = BaseHelpUtils.getStringValue(result, "invoiceIds"); 
		List<BaseInvoice> list = iDao.conditionalLoad(" invoice_id in ("+ invoiceIds +")");
		cl.setCollections(list);
		return cl.toJSON(1, "");
	}
	
	
	/**
	 * 
	 * @Title: destoryEmptyInvoice 
	 * @Description: 空白作废发票
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	private String destoryEmptyInvoice(Map result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1 ;
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("list");
		List<BaseInvoice> dataList = new ArrayList<>();
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		for (Map<String, Object> map : list) {
			BaseInvoice tmpBean = new BaseInvoice();
			tmpBean.setDataFromMap(map);
			dataList.add(tmpBean);
		}
		int _i =0;
		Invoice iDao = new Invoice();
		for (BaseInvoice baseInvoice : dataList) {
			iDao.clear();
			iDao.setInvoiceId(baseInvoice.getInvoiceId());
			if(iDao.load()){
				//检测是否为未使用发票 如为未使用发票  则可以空白作废
				if(iDao.getSign() == SIGN_ZERO){
					iDao.setSign(SIGN_FIVE);
					iDao.setInvalidRemark(baseInvoice.getInvalidRemark());
					iDao.setIsInvalidOperator(employeeId);
					iDao.update();
					_i++;
				}
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		return cl.toJSON(status, _i + "条发票已经空白作废！");
	}
	
	
	
	//导出控制 *****************************************
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}


