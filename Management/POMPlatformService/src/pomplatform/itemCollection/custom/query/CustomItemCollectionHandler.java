package pomplatform.itemCollection.custom.query;

import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCapitalsToContractReceivable;
import com.pomplatform.db.bean.BaseCapitalsToInvoice;
import com.pomplatform.db.bean.BaseContractReceivable;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistribution;
import com.pomplatform.db.dao.CapitalsToContractReceivable;
import com.pomplatform.db.dao.CapitalsToInvoice;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractReceivable;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import message.common.ERPWeixinUtils;
import pomplatform.capitaldistribution.business.CapitalDistributionMsg;
import pomplatform.common.utils.StaticUtils;
import pomplatform.itemCollection.custom.bean.BaseonLoadCapitalAmountOfContract;
import pomplatform.itemCollection.custom.bean.ConditiononLoadCapitalAmountOfContract;
import pomplatform.tmpcapitalsListItem.bean.BaseTmpcapitalstoinvoicecior;
import pomplatform.tmpcapitalsListItem.bean.ConditionTmpcapitalstoinvoicecior;
import pomplatform.tmpcapitalsListItem.query.QueryTmpcapitalstoinvoicecior;
import pomplatform.workflow.contractstatus.utils.ContractStatusUtils;

public class CustomItemCollectionHandler implements GenericProcessor, GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomItemCollectionHandler.class);

	/**
	 * 为合同发票解绑流水账
	 */
	private static final String EXIT_INVOICE="exitInvoice";
	/**
	 * 为流水账绑定合同
	 */
	private static final String BING_CONTRACT = "bingContract";
	/**
	 * 为选中的合同阶段设置回款
	 */
	private static final String SET_CONTRACT_RECEIVABLE = "setContractReceivable";
	/**
	 * 加载没有回款合同项目阶段
	 */
	private static final String LOAD_NOT_CONTRACT_RECEIVABLE = "loadNotContractReceivable";
	/**
	 * 为选中的发票设置回款
	 */
	private static final String SET_INVOICE_RECEIVABLE = "setInvoiceReceivable";
	/**
	 * 加载没有回款发票
	 */
	private static final String LOAD_NOT_INVOICE_LIST = "loadNotInvoiceList";

	/**
	 * 加载回款发票
	 */
	private static final String LOAD_INVOICE_LIST = "loadInvoiceList";
	/**
	 * 加载合同项目阶段
	 */
	private static final String LOAD_CONTRACT_RECEIVABLE = "loadContractReceivable";
	/**
	 * 加载合同项目回款流水账
	 */
	private static final String LOAD_CONTRACT_ITEM_COLLECTION = "loadContractItemCollection";
	/**
	 * 加载合同项目全部回款流水账
	 */
	private static final String LOAD_CONTRACT_ALL_ITEM_COLLECTION = "loadContractAllItemCollection";

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
			case LOAD_CONTRACT_ITEM_COLLECTION:
				return loadContractItemCollection(result);
			case LOAD_CONTRACT_RECEIVABLE:
				return loadContractReceivable(result);
			case LOAD_INVOICE_LIST:
				return loadInvoiceList(result);
			case LOAD_NOT_INVOICE_LIST:
				return loadNotInvoiceList2(result);
			case SET_INVOICE_RECEIVABLE:
				return setInvoiceReceivable(result);
			case LOAD_NOT_CONTRACT_RECEIVABLE:
				return loadNotContractReceivable2(result);
			case SET_CONTRACT_RECEIVABLE:
				return setContractReceivable(result);
			case BING_CONTRACT:
				return bingContract(result);
			case LOAD_CONTRACT_ALL_ITEM_COLLECTION:
				return loadContractAllItemCollection(result);
			case EXIT_INVOICE:
				return exitInvoice(result);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	public String exitInvoice(Map<String, Object> result) throws SQLException{
		int res=1;
		String errorStr="";
		//流水账id
		int capitalId=BaseHelpUtils.getIntValue(result, "capitalId");
		ThreadConnection.beginTransaction();
		CapitalsToInvoice cti=new CapitalsToInvoice();
		cti.setConditionCapitalId("=", capitalId);
		int count=cti.conditionalDelete();//1.删除这笔流水账的中间记录表
		if(count>0){
			//2.将这笔流水绑定发票的状态改为false
			Capital c=new Capital();
			c.setCapitalId(capitalId);
			if(c.load()){
				c.setHasInvoices(false);
				c.update();
				res=1;
				ThreadConnection.commit();
			}
		}else{
			res=-1;
			errorStr="没有绑定发票";
			ThreadConnection.rollback();
		}
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		bc.setCollections(null);
		return bc.toJSON(res, errorStr);
	}
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	public static String bingContract(Map<String, Object> result) throws Exception {
		ThreadConnection.beginTransaction();
		//获取账单流水id数据集
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		if(BaseHelpUtils.isNullOrEmpty(ids)) {
			throw new SQLException("操作异常：没有选中流水账");
		}
		//获取合同id
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(contractId <= 0) {
			throw new SQLException("操作异常：获取合同编码失败");
		}
		Contract c = new Contract();
		c.unsetSelectFlags();
		c.setSelectContractId(true);
		c.setSelectContractName(true);
		c.setSelectContractCode(true);
		c.setSelectInfoCode(true);
		c.setSelectContractName(true);
		c.setSelectSigningMoneySum(true);
		c.setContractId(contractId);
		if(!c.load()) {
			throw new SQLException("操作异常：加载合同信息失败");
		}
		//获取操作人
		int operator = BaseHelpUtils.getIntValue(result, "operator");
		Employee eDao = new Employee();
		eDao.setEmployeeId(operator);
		String empName = "";
		if(eDao.load()) {
			empName = BaseHelpUtils.getString(eDao.getEmployeeName());
		}
		String[] id = ids.split(",");
		//获取合同编号
		String contractCode = BaseHelpUtils.getString(c.getContractCode());
		//获取项目编号
		String projectCode = BaseHelpUtils.getString(c.getProjectCode());
		//获取信息编号
		String infoCode = BaseHelpUtils.getString(c.getInfoCode());
		//获取合同名称
		String contractName = BaseHelpUtils.getString(c.getContractName());
		Capital cap = new Capital();
		CapitalDistribution dao = new CapitalDistribution();
		CapitalDistributionMsg msgUtil = new CapitalDistributionMsg();
		Date currentDate = new Date();
		//定义员合同id
		int oldContractId = 0;
		for (int i = 0; i < id.length; i++) {
			int tmpId = BaseHelpUtils.getIntValue(id[i]);
			if (tmpId <= 0) {
				continue;
			}
			cap.clear();
			cap.setCapitalId(tmpId);
			if(!cap.load()) {
				continue;
			}
			//获取原合同id
			oldContractId = BaseHelpUtils.getIntValue(cap.getContractId());
			StringBuilder sb = new StringBuilder();
			DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
			sb.append(empName).append("于").append(DateUtil.formatDateTimeString(currentDate)).append("将").append(df.format(cap.getBorrowMoney())).append("的回款");
			String newContractInfo = contractName + "(" + contractCode + ")";
			if(oldContractId > 0){//说明是之前有绑定过合同，现在重新绑定到了新的合同
				//检测改笔回款是否已做分配，如果已分配，则需删除
				dao.clear();
				dao.setConditionCapitalId("=", tmpId);
				if(dao.isExist()) {
					dao.setDeleteFlag(StaticUtils.HAS_DELETE);
					dao.conditionalUpdate();
				}
				c.clear();
				c.setContractId(oldContractId);
				if(c.load()) {//加载原绑定的合同信息
					//获取原合同编号
					String oldContractCode = BaseHelpUtils.getString(c.getContractCode());
					//获取原合同名称
					String oldContractName = BaseHelpUtils.getString(c.getContractName());
					sb.append("从合同：").append(oldContractName).append("(").append(oldContractCode).append(")中解绑，并重新绑定到合同：").append(newContractInfo).append("上，请相关负责人及时进行回款分配信息确认");
					msgUtil.sendToAllProjectManager(oldContractId, sb.toString());
				}else {
					sb.append("重新绑定到合同：").append(newContractInfo).append("上，请相关负责人及时进行回款分配信息确认");
				}
			}else {//说明是新绑定合同
				sb.append("绑定到合同：").append(newContractInfo).append("上，请相关负责人及时进行回款分配信息确认");
			}
			msgUtil.sendToAllProjectManager(contractId, sb.toString());
			//更新回款信息
			cap.setContractId(contractId);
			cap.setContractCode(contractCode);
			cap.setInfoCode(infoCode);
			cap.setProjectCode(projectCode);
			cap.update();
//			onDistributiveCapitalToProject(contractId,tmpId);
			cap.clear();
			cap.setConditionContractId("=", contractId);
			cap.setConditionMoneyAttribute("=", StaticUtils.CAPITAL_MONEY_ATTRIBUTION_1);
			List<BaseCapital> capitalList = cap.conditionalLoad();
			BigDecimal capitalAmount = BigDecimal.ZERO;
			for(BaseCapital obj : capitalList) {
				if(null != obj.getBorrowMoney()) {
					capitalAmount = capitalAmount.add(obj.getBorrowMoney());
				}
			}
			if(null != c.getSigningMoneySum() && c.getSigningMoneySum().compareTo(BigDecimal.ZERO) > 0 
					&& capitalAmount.divide(c.getSigningMoneySum(), 2, BigDecimal.ROUND_DOWN).compareTo(new BigDecimal("0.9")) >= 0) {
				ContractStatusUtils util = new ContractStatusUtils();
				util.updateContractAndProjectStatusWithLog(contractId, StaticUtils.CONTRACT_STATUS_7, operator, "合同回款大于或等于合同额的90%，系统自动将合同状态改为合同运行—收尾");
				Project pDao = new Project();
				pDao.setSelectProjectManageId(true);
				pDao.setConditionContractId("=", contractId);
				pDao.setConditionProjectType("=", StaticUtils.PROJECT_TYPE_16);
				List<BaseProject> pList = pDao.conditionalLoad();
				for(BaseProject pBean : pList) {
					if(null != pBean.getProjectManageId()) {
						ERPWeixinUtils.sendWXMsgToUser(pBean.getProjectManageId(), String.format("合同编号：%1$s\r\n合同名称：%2$s\r\n若该合同仅剩尾款，请尽快收取尾款", c.getContractCode(), c.getContractName()));
					}
				}
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		return bc.toJSON(0,"");
	}
	
	/**
	 * 根据项目进度计算回款到对应的项目上
	 * 自动回款分配到合同下相关项目
	 * @param contractId
	 * @throws SQLException
	 */
	public static void onDistributiveCapitalToProject(int contractId,int tmpId) throws SQLException {
		Capital dao = new Capital();
		dao.setCapitalId(tmpId);
		if(!dao.load()) {
			return;
		}
		//获取这一次回款金额
		BigDecimal thisCapitalAmount = BaseHelpUtils.getBigDecimalValue(dao.getBorrowMoney());
		//根据合同ID去检索该合同下的订单信息
		QueryonLoadCapitalAmountOfContract query = new QueryonLoadCapitalAmountOfContract();
		ConditiononLoadCapitalAmountOfContract con = new ConditiononLoadCapitalAmountOfContract();
		con.setContractId(contractId);
		BaseCollection<BaseonLoadCapitalAmountOfContract> result = query.executeQuery(null, con);
		if(BaseHelpUtils.isNullOrEmpty(result)) {
			__logger.info(String.format("回款自动结算****************：未获取到合同ID(%1$s)下的订单信息",contractId));
			return;
		}
		List<BaseonLoadCapitalAmountOfContract> pList = result.getCollections();
		if(BaseHelpUtils.isNullOrEmpty(pList) || pList.size() == 0) {
			__logger.info(String.format("回款自动结算****************：未获取到合同ID(%1$s)下的订单信息",contractId));
			return;
		}
		Date currentDate = new Date();
		//定义List存放该合同下产生营收的所有订单
		List<BaseonLoadCapitalAmountOfContract> hasList = new ArrayList<>();
		//定义该合同下所有产生营收的订单的营收累计数
		BigDecimal totalRevenue = BigDecimal.ZERO;
		CapitalDistribution cdDao = new CapitalDistribution();
		//定义该合同下产生营收的订单的历史回款金额累计数
		BigDecimal totalHistoryAmount = BigDecimal.ZERO;
		//定义该合同下产生营收的订单的回款金额累计数=totalHistoryAmount+这一次回款的回款金额
		BigDecimal totalCapitalAmount = BigDecimal.ZERO;
		//定义该合同下所有订单的回款金额累计数
		BigDecimal totalCapitalAmountAll = BigDecimal.ZERO;
		//定义该合同下的所有订单的合同金额
		BigDecimal totalSheetAmount = BigDecimal.ZERO;
		for(BaseonLoadCapitalAmountOfContract e : pList) {
			//获取营收
			BigDecimal revenueAmount = BaseHelpUtils.getBigDecimalValue(e.getRevenueAmount());
			//获取回款金额
			BigDecimal capitalAmount = BaseHelpUtils.getBigDecimalValue(e.getCapitalAmount());
			//获取合同金额
			BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(e.getSheetAmount());
			if(revenueAmount.compareTo(BigDecimal.ZERO) > 0) {
				totalRevenue = totalRevenue.add(revenueAmount);
				totalHistoryAmount = totalHistoryAmount.add(capitalAmount);
				hasList.add(e);
			}
			totalCapitalAmountAll = totalCapitalAmountAll.add(capitalAmount);
			totalSheetAmount = totalSheetAmount.add(sheetAmount);
		}//项目for循环结束
		
		//设置累计回款金额=订单历史回款金额+这一次回款金额
		totalCapitalAmount = totalHistoryAmount.add(thisCapitalAmount);
		totalCapitalAmountAll = totalCapitalAmountAll.add(thisCapitalAmount);
		//定义List来存放这一次参与回款分配的订单
		List<BaseonLoadCapitalAmountOfContract> joinList = new ArrayList<>();
		//如果该合同下的订单累计营收为0，则说明该合同下没有订单产生营收，则根据订单的合同金额占比来分摊回款金额
		if(totalRevenue.compareTo(BigDecimal.ZERO) == 0) {//说明该合同下订单没产生营收
			//该合同下的订单个数
			int size = pList.size();
			int i = 0;
			//订单营收占比累计数
			BigDecimal totalPercent = BigDecimal.ZERO;
			//该合同下产生营收的订单的累计回款金额
			BigDecimal totalCapital = BigDecimal.ZERO;
			//遍历该合同下的所有订单
			for(BaseonLoadCapitalAmountOfContract e : pList) {
				i++;
				//获取合同金额
				BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(e.getSheetAmount());
				//设置订单合同额占比=订单合同额/累计合同额
				BigDecimal percent = BigDecimal.ZERO;
				if(i == size) {//说明是最后一个订单
					percent = BigDecimal.ONE.subtract(totalPercent);
				}else {
					percent = BaseHelpUtils.format(sheetAmount.divide(totalSheetAmount,4,BigDecimal.ROUND_HALF_UP), 4);
//					percent = sheetAmount.divide(totalSheetAmount,4,BigDecimal.ROUND_DOWN);
				}
				totalPercent = totalPercent.add(percent);
				//设置每个订单累计回款金额=累计回款金额*订单合同额占比
				BigDecimal capital = BigDecimal.ZERO;
				if(i == size) {
					capital = totalCapitalAmountAll.subtract(totalCapital);
				}else {
					capital = BaseHelpUtils.format(totalCapitalAmountAll.multiply(percent),2);
				}
				totalCapital = totalCapital.add(capital);
				//获取订单历史回款金额
				BigDecimal historyCapital = BaseHelpUtils.getBigDecimalValue(e.getCapitalAmount());
				if(capital.compareTo(historyCapital) > 0) {//只有当前计算的累计回款金额大于历史回款金额，这个订单才参与回款分配
					joinList.add(e);
				}else {//如果不参与，则减去该订单的合同金额和回款金额
					totalSheetAmount = totalSheetAmount.subtract(sheetAmount);
					totalCapitalAmountAll = totalCapitalAmountAll.subtract(historyCapital);
				}
			}
			//遍历参与回款的订单
			i = 0;
			//参与回款分配的订单个数
			size = joinList.size();
			totalPercent = BigDecimal.ZERO;
			//定义累计回款金额
			totalCapital = BigDecimal.ZERO;
			for(BaseonLoadCapitalAmountOfContract e : joinList) {
				i++;
				//获取合同金额
				BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(e.getSheetAmount());
				//设置订单合同额占比=订单合同额/累计合同额
				BigDecimal percent = BigDecimal.ZERO;
				if(i == size) {//说明是最后一个订单
					percent = BigDecimal.ONE.subtract(totalPercent);
				}else {
					percent = BaseHelpUtils.format(sheetAmount.divide(totalSheetAmount,4,BigDecimal.ROUND_HALF_UP), 4);
//					percent = sheetAmount.divide(totalSheetAmount,4,BigDecimal.ROUND_DOWN);
				}
				totalPercent = totalPercent.add(percent);
				//设置每个订单累计回款金额=累计回款金额*订单合同额占比
				BigDecimal capital = BigDecimal.ZERO;
				if(i == size) {
					capital = totalCapitalAmountAll.subtract(totalCapital);
				}else {
					capital = BaseHelpUtils.format(totalCapitalAmountAll.multiply(percent),2);
				}
				totalCapital = totalCapital.add(capital);
				//获取订单历史回款金额
				BigDecimal historyCapital = BaseHelpUtils.getBigDecimalValue(e.getCapitalAmount());
				//设置该订单在这一次可回款金额=累计回款金额-历史回款金额
				BigDecimal thisCanCapitalAmount = capital.subtract(historyCapital);
				if(thisCanCapitalAmount.compareTo(BigDecimal.ZERO) > 0) {
					int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
					//插入项目回款表数据
					cdDao.clear();
					cdDao.setCapitalId(tmpId);
					cdDao.setPlateId(plateId);
					cdDao.setProjectId(e.getProjectId());
					cdDao.setDistributionAmount(thisCanCapitalAmount);
					cdDao.setContractId(contractId);
					cdDao.setType(2);
					cdDao.setTotalAmount(thisCapitalAmount);
					cdDao.setCreateTime(currentDate);
					cdDao.save();
				}
			}
		}else {//说明该合同下订单产生营收
			//该合同下产生营收的订单个数
			int size = hasList.size();
			int i = 0;
			//定义每个订单营收占比累计数
			BigDecimal totalPercent = BigDecimal.ZERO;
			//定义每个订单累计回款金额累计数
			BigDecimal totalCapital = BigDecimal.ZERO;
			//循环产生营收的订单信息
			for(BaseonLoadCapitalAmountOfContract e : hasList) {
				i++;
				//获取营收
				BigDecimal revenueAmount = BaseHelpUtils.getBigDecimalValue(e.getRevenueAmount());
				//获取订单历史回款金额
				BigDecimal historyCapital = BaseHelpUtils.getBigDecimalValue(e.getCapitalAmount());
				//每个订单的营收占比
				BigDecimal percent = BigDecimal.ZERO;
				if(i == size) {//说明是最后一个订单
					percent = BigDecimal.ONE.subtract(totalPercent);
				}else {//说明不是最后一个订单
					percent = BaseHelpUtils.format(revenueAmount.divide(totalRevenue,4, BigDecimal.ROUND_HALF_UP),4);
//					percent = revenueAmount.divide(totalRevenue,4,BigDecimal.ROUND_DOWN);
				}
				totalPercent = totalPercent.add(percent);
				//计算每个订单的累计回款金额=累计回款金额*订单营收占比
				BigDecimal capital = BigDecimal.ZERO;
				if(i == size) {//说明是最后一个订单
					capital = totalCapitalAmount.subtract(totalCapital);
				}else {//说明不是最后一个订单
					capital = BaseHelpUtils.format(totalCapitalAmount.multiply(percent),2);
				}
				totalCapital = totalCapital.add(capital);
				//如果计算出的累计回款金额<=该订单的历史回款金额，则不参与回款分配
				if(capital.compareTo(historyCapital) > 0) {
					joinList.add(e);
				}else {//如果不参与，则取减去该订单的历史回款金额和营收
					totalPercent = totalPercent.subtract(revenueAmount);
					totalCapitalAmount = totalCapitalAmount.subtract(historyCapital);
				}
			}
			//遍历计算参与回款分配的订单信息
			size = joinList.size();
			i = 0;
			//定义每个订单营收占比累计数
			totalPercent = BigDecimal.ZERO;
			//定义每个订单累计回款金额累计数
			totalCapital = BigDecimal.ZERO;
			for(BaseonLoadCapitalAmountOfContract e : hasList) {
				i++;
				//获取营收
				BigDecimal revenueAmount = BaseHelpUtils.getBigDecimalValue(e.getRevenueAmount());
				//获取订单历史回款金额
				BigDecimal historyCapital = BaseHelpUtils.getBigDecimalValue(e.getCapitalAmount());
				//每个订单的营收占比
				BigDecimal percent = BigDecimal.ZERO;
				if(i == size) {//说明是最后一个订单
					percent = BigDecimal.ONE.subtract(totalPercent);
				}else {//说明不是最后一个订单
					percent = BaseHelpUtils.format(revenueAmount.divide(totalRevenue,4, BigDecimal.ROUND_HALF_UP),4);
//					percent = revenueAmount.divide(totalRevenue,4,BigDecimal.ROUND_DOWN);
				}
				totalPercent = totalPercent.add(percent);
				//计算每个订单的累计回款金额=累计回款金额*订单营收占比
				BigDecimal capital = BigDecimal.ZERO;
				if(i == size) {//说明是最后一个订单
					capital = totalCapitalAmount.subtract(totalCapital);
				}else {//说明不是最后一个订单
					capital = BaseHelpUtils.format(totalCapitalAmount.multiply(percent),2);
				}
				totalCapital = totalCapital.add(capital);
				//计算这一次可回款金额=订单累计回款金额-历史回款金额
				BigDecimal thisCanCapitalAmount = capital.subtract(historyCapital);
				if(thisCanCapitalAmount.compareTo(BigDecimal.ZERO) > 0) {
					int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
					//插入项目回款表数据
					cdDao.clear();
					cdDao.setCapitalId(tmpId);
					cdDao.setPlateId(plateId);
					cdDao.setProjectId(e.getProjectId());
					cdDao.setDistributionAmount(thisCanCapitalAmount);
					cdDao.setContractId(contractId);
					cdDao.setType(2);
					cdDao.setTotalAmount(thisCapitalAmount);
					cdDao.setCreateTime(currentDate);
					cdDao.save();
				}
			}
		}
		//把该笔回款标识为已回款
		dao.setProcessStatus(2);//设置为分配完成
		dao.setHasDistributionCollection(Boolean.TRUE);
		dao.update();
	}

	public String loadNotContractReceivable2(Map<String, Object> result) throws SQLException {
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		ContractReceivable c = new ContractReceivable();
		c.setConditionContractId("=", contractId);
		List<BaseContractReceivable> list = c.conditionalLoad(" order by contract_receivable_id,parent_id ASC ");
		List<BaseContractReceivable> resList = new ArrayList<>();
		// 检索出还有完全回款的发票和没有回款的发票
		if (list.size() > 0) {
			for (BaseContractReceivable baseContractReceivable : list) {
				CapitalsToContractReceivable cti = new CapitalsToContractReceivable();
				cti.setConditionContractReceivableId("=", baseContractReceivable.getContractReceivableId());
				List<BaseCapitalsToContractReceivable> l = cti.conditionalLoad();
				if (l.size() > 0) {
					// 阶段回款金额
					double stage_sum_money = 0;
					// 阶段回款百分比
					double stage_percentage = 0;
					for (BaseCapitalsToContractReceivable b : l) {
						stage_sum_money += BaseHelpUtils.getDoubleValue(b.getStageSumMoney());
						stage_percentage += BaseHelpUtils.getDoubleValue(b.getStagePercentage());
					}
					// 相等说明该合同阶段回款完成
					if (stage_sum_money >= StaticMethod.getDouble2Value(
							BaseHelpUtils.getDoubleValue(baseContractReceivable.getReceivableSumMoney()))) {
						// 回款完成的合同阶段不必显示出来
					} else {
						baseContractReceivable.setStageSumMoney(StaticMethod.formatComma4BigDecimal(stage_sum_money));// 回款金额
						baseContractReceivable
								.setStagePercentage(StaticMethod.formatComma4BigDecimal(stage_percentage));// 回款百分比
						resList.add(baseContractReceivable);
					}
				} else {
					baseContractReceivable.setStageSumMoney(StaticMethod.formatComma4BigDecimal(0));// 回款金额
					baseContractReceivable.setStagePercentage(StaticMethod.formatComma4BigDecimal(0));// 回款百分比
					resList.add(baseContractReceivable);
				}
			}
		}
		BaseCollection<BaseContractReceivable> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "");

	}

	private String loadNotContractReceivable(Map<String, Object> result) throws SQLException {
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		ContractReceivable c = new ContractReceivable();
		c.setConditionContractId("=", contractId);
		List<BaseContractReceivable> list = c.conditionalLoad(" order by contract_receivable_id,parent_id ASC ");

		StringBuffer __tempIds = new StringBuffer();
		if (list.size() > 0) {
			for (BaseContractReceivable b : list) {
				if (BaseHelpUtils.isNullOrEmpty(__tempIds)) {
					__tempIds.append(b.getContractReceivableId());
				} else {
					__tempIds.append(",");
					__tempIds.append(b.getContractReceivableId());
				}
			}
		}

		// 全额回款的合同阶段ID
		CapitalsToContractReceivable ctc = new CapitalsToContractReceivable();
		List<BaseCapitalsToContractReceivable> l = ctc
				.conditionalLoad(" contract_receivable_id in (" + __tempIds + ") and stage_percentage=100 ");
		// 未全额回款的合同阶段ID
		CapitalsToContractReceivable baseCapitalsToContractReceivable = new CapitalsToContractReceivable();
		List<BaseCapitalsToContractReceivable> ll = baseCapitalsToContractReceivable
				.conditionalLoad(" contract_receivable_id in (" + __tempIds + ") and stage_percentage<100 ");

		// 从新构建合同的阶段
		Map<Integer, BaseContractReceivable> map = new LinkedHashMap<>();
		if (list.size() > 0) {
			for (BaseContractReceivable b : list) {
				// 未还款的合同阶段
				b.setStagePercentage(StaticMethod.formatComma4BigDecimal(0));// 回款金额
				b.setStageSumMoney(StaticMethod.formatComma4BigDecimal(0));// 回款百分比
				map.put(b.getContractReceivableId(), b);

				// 未全额回款的合同阶段
				if (ll.size() > 0) {
					for (BaseCapitalsToContractReceivable bc : ll) {
						if (b.getContractReceivableId() == bc.getContractReceivableId()) {
							b.setStagePercentage(bc.getStagePercentage());// 回款百分比
							b.setStageSumMoney(bc.getStageSumMoney());// 回款金额
							map.put(b.getContractReceivableId(), b);
						}
					}
				}
			}
			// clear 全额回款的合同阶段
			if (l.size() > 0) {
				for (BaseCapitalsToContractReceivable bc : l) {
					map.remove(bc.getContractReceivableId());
				}
			}
		}
		List<BaseContractReceivable> resList = new ArrayList<>();
		if (map.size() > 0) {
			for (Iterator i = map.values().iterator(); i.hasNext();) {
				BaseContractReceivable baseContractReceivable = (BaseContractReceivable) i.next();
				resList.add(baseContractReceivable);
			}
		}

		BaseCollection<BaseContractReceivable> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "");
	}

	/**
	 * 1:绑定合同阶段回款 2:修改该流水账是否绑定合同阶段的状态为true 如果这笔回款没有没有合同阶段来抵消则提示合同阶段金额不够
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String setContractReceivable(Map<String, Object> result) throws SQLException {
		int res = -1;
		String errorMsg = "";
		int capitalId = BaseHelpUtils.getIntValue(result, "capitalId");
		String contractReceivableIds = BaseHelpUtils.getStringValue(result, "contractReceivableIds");
		String balances = BaseHelpUtils.getStringValue(result, "balances");
		String receivableSumMoneys = BaseHelpUtils.getStringValue(result, "receivableSumMoneys");
		double lsSum = BaseHelpUtils.getDoubleValue(result.get("lsSum"));
		int operator = BaseHelpUtils.getIntValue(result, "operator");// 操作人

		System.out.println("start ================================");
		System.out.println("capitalId=" + capitalId);
		System.out.println("contractReceivableIds=" + contractReceivableIds);
		System.out.println("balances=" + balances);
		System.out.println("receivableSumMoneys=" + receivableSumMoneys);
		System.out.println("lsSum=" + lsSum);
		System.out.println("end   ================================");

		ThreadConnection.beginTransaction();
		CapitalsToContractReceivable capitalsToContractReceivable = new CapitalsToContractReceivable();
		List<BaseCapitalsToContractReceivable> l = new ArrayList<>();
		String[] contractReceivableId;
		String[] balance;
		String[] receivableSumMoney;
		if (!BaseHelpUtils.isNullOrEmpty(contractReceivableIds)) {
			contractReceivableId = contractReceivableIds.split(",");// 发票id
			balance = balances.split(",");// 回款总金额
			receivableSumMoney = receivableSumMoneys.split(",");// 发票金额
			if (contractReceivableId.length > 0) {
				// 检验这些合同阶段总金额是不是不够这这笔回款
				double tempreceivableSumMoney = 0;
				for (int i = 0; i < contractReceivableId.length; i++) {
					tempreceivableSumMoney += StaticMethod
							.getDouble2Value(BaseHelpUtils.getDoubleValue(receivableSumMoney[i]));
				}
				if (lsSum > tempreceivableSumMoney) {
					res = -1;
					errorMsg = "合同阶段总金额不够,不能绑定该笔回款";
				} else {
					for (int i = 0; i < contractReceivableId.length; i++) {
						BaseCapitalsToContractReceivable bc = new BaseCapitalsToContractReceivable();
						bc.setCapitalId(capitalId);
						bc.setContractReceivableId(BaseHelpUtils.getIntValue(contractReceivableId[i]));
						bc.setOperator(operator);

						double tempLsSum = 0;
						double tmp = BaseHelpUtils.getDoubleValue(receivableSumMoney[i])
								- BaseHelpUtils.getDoubleValue(balance[i]);
						tempLsSum = lsSum;
						lsSum -= tmp;
						// 这里简单的判断这笔余款剩余的金额够不够这张发票
						if (lsSum >= 0) {// 说明这笔款有多或刚好
							double tmp1 = tmp * 100 / BaseHelpUtils.getDoubleValue(receivableSumMoney[i]);
							if (tmp1 == 0 || tmp1 == 1) {
								bc.setStagePercentage(new BigDecimal(100));
								bc.setStageSumMoney(new BigDecimal(tmp));

								System.out.println("100  1------" + tmp);

								l.add(bc);
							} else {
								bc.setStagePercentage(new BigDecimal(tmp1));
								bc.setStageSumMoney(new BigDecimal(tmp));

								System.out.println(tmp1 + "    2-----------" + tmp);
								l.add(bc);
							}
						} else {
							if (tempLsSum > 0) {
								if ((lsSum + tmp) != tmp) {
									double tmp1 = (lsSum + tmp) * 100
											/ BaseHelpUtils.getDoubleValue(receivableSumMoney[i]);
									bc.setStagePercentage(new BigDecimal(tmp1));
									bc.setStageSumMoney(new BigDecimal(lsSum + tmp));
									System.out.println(tmp1 + "  3------" + (lsSum + tmp));
									l.add(bc);
								}
							} else {
								System.out.println(tempLsSum + "-----4------" + tmp);
								break;
							}
						}
					}
					capitalsToContractReceivable.save(l);
				}
			}
			// 2:
			Capital cap = new Capital();
			cap.setCapitalId(capitalId);
			if (cap.load()) {
				cap.setHasContractReceivable(true);
				cap.update();
			}
			// 发票金额不够
			if (lsSum > 0 && BaseHelpUtils.isNullOrEmpty(errorMsg)) {
				res = -1;
				errorMsg = "合同阶段总金额不够,不能绑定该笔回款";
				ThreadConnection.rollback();
			} else if (!BaseHelpUtils.isNullOrEmpty(errorMsg)) {
				res = -1;
				ThreadConnection.rollback();
			} else {
				res = 1;
				ThreadConnection.commit();
			}
		}
		BaseCollection<BaseCapitalsToContractReceivable> bc = new BaseCollection<>();
		bc.setCollections(l);
		return bc.toJSON(res, errorMsg);
	}

	/**
	 * 1:绑定发票回款 2:修改该流水账是否绑定发票的状态为true 如果这笔回款没有发票来抵消则提示发票金额不够
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String setInvoiceReceivable(Map<String, Object> result) throws SQLException {
		int res = -1;
		String errorMsg = "";
		int capitalId = BaseHelpUtils.getIntValue(result, "capitalId");
		String invoiceIds = BaseHelpUtils.getStringValue(result, "invoiceIds");
		String balances = BaseHelpUtils.getStringValue(result, "balances");
		String stagePer = BaseHelpUtils.getStringValue(result, "stagePer");
		String invoiceMoneys = BaseHelpUtils.getStringValue(result, "invoiceMoneys");
		double lsSum = BaseHelpUtils.getDoubleValue(result.get("lsSum"));
		int operator = BaseHelpUtils.getIntValue(result, "operator");// 操作人

		System.out.println("start ================================");
		System.out.println("capitalId=" + capitalId);
		System.out.println("invoiceIds=" + invoiceIds);
		System.out.println("balances=" + balances);
		System.out.println("invoiceMoneys=" + invoiceMoneys);
		System.out.println("lsSum=" + lsSum);
		System.out.println("stagePer=" + stagePer);
		System.out.println("end   ================================");

		ThreadConnection.beginTransaction();
		CapitalsToInvoice capitalsToInvoice = new CapitalsToInvoice();
		List<BaseCapitalsToInvoice> l = new ArrayList<>();
		String[] invoiceId;
		String[] balance;
		String[] invoiceMoney;
		String[] stagePercentage;
		if (!BaseHelpUtils.isNullOrEmpty(invoiceIds)) {
			invoiceId = invoiceIds.split(",");// 发票id
			balance = balances.split(",");// 回款总金额
			stagePercentage = stagePer.split(",");// 回款百分比
			invoiceMoney = invoiceMoneys.split(",");// 发票金额
			if (invoiceId.length > 0) {
				// 检验这些发票的总金额是不是不够这这笔回款
				double tempInvoiceMoney = 0;
				for (int i = 0; i < invoiceId.length; i++) {
					double finMoney = BaseHelpUtils.getDoubleValue(invoiceMoney[i])
							- BaseHelpUtils.getDoubleValue(balance[i]);
					tempInvoiceMoney += StaticMethod.getDouble2Value(finMoney);
				}
				if (lsSum > tempInvoiceMoney) {
					res = -1;
					errorMsg = "发票总金额不够,不能绑定该笔回款";
				} else {
					for (int i = 0; i < invoiceId.length; i++) {
						BaseCapitalsToInvoice bc = new BaseCapitalsToInvoice();
						bc.setCapitalId(capitalId);
						bc.setInvoiceId(BaseHelpUtils.getIntValue(invoiceId[i]));
						bc.setOperator(operator);

						double tempLsSum = 0;
						double tmp = BaseHelpUtils.getDoubleValue(invoiceMoney[i])
								- BaseHelpUtils.getDoubleValue(balance[i]);
						tempLsSum = lsSum;
						lsSum -= tmp;
						// 这里简单的判断这笔余款剩余的金额够不够这张发票
						if (lsSum >= 0) {// 说明这笔款有多或刚好
							double tmp1 = tmp * 100 / BaseHelpUtils.getDoubleValue(invoiceMoney[i]);
							if (tmp1 == 0 || tmp1 == 1) {
								bc.setStagePercentage(new BigDecimal(100));
								bc.setStageSumMoney(new BigDecimal(tmp));

								System.out.println("100  1------" + tmp);

								l.add(bc);
							} else {
								bc.setStagePercentage(new BigDecimal(tmp1));
								bc.setStageSumMoney(new BigDecimal(tmp));

								System.out.println(tmp1 + "    2-----------" + tmp);
								l.add(bc);
							}
						} else {
							// 说明 lsSum金额还有，tempLsSum为负数了说明lsSum没有钱了
							if (tempLsSum > 0) {
								if ((lsSum + tmp) != tmp) {
									double tmp1 = (lsSum + tmp) * 100 / BaseHelpUtils.getDoubleValue(invoiceMoney[i]);
									bc.setStagePercentage(new BigDecimal(tmp1));
									bc.setStageSumMoney(new BigDecimal(lsSum + tmp));
									System.out.println(tmp1 + "  3------" + (lsSum + tmp));
									l.add(bc);
								}
							} else {
								// 直接退出for
								System.out
										.println(tempLsSum + "------4------" + lsSum + "   invoiceId=" + invoiceId[i]);
								break;
							}

						}
					}
					capitalsToInvoice.save(l);
				}
			}
			// 2:
			Capital cap = new Capital();
			cap.setCapitalId(capitalId);
			if (cap.load()) {
				cap.setHasInvoices(true);
				cap.update();
			}
			// 发票金额不够
			if (lsSum > 0 && BaseHelpUtils.isNullOrEmpty(errorMsg)) {
				res = -1;
				errorMsg = "发票总金额不够,不能绑定该笔回款";
				ThreadConnection.rollback();
			} else if (!BaseHelpUtils.isNullOrEmpty(errorMsg)) {
				res = -1;
				ThreadConnection.rollback();
			} else {
				res = 1;
				ThreadConnection.commit();
			}
		}
		BaseCollection<BaseCapitalsToInvoice> bc = new BaseCollection<>();
		bc.setCollections(l);
		return bc.toJSON(res, errorMsg);
	}

	// 检索出没有百分之百回款的发票
	public String loadNotInvoiceList2(Map<String, Object> result) throws SQLException {
		List<BaseInvoice> resList = new ArrayList<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Invoice invo = new Invoice();
		invo.setConditionContractId("=", contractId);
		invo.setConditionSign("=", 2);// 正常的发票，2表示负数发票
		List<BaseInvoice> ll = invo.conditionalLoad(" order by invoice_number ASC");
		StringBuilder primaryInvoiceCode = new StringBuilder();
		StringBuilder primaryInvoiceNumber = new StringBuilder();

		if (ll.size() > 0) {
			for (BaseInvoice baseInvo : ll) {
				if (!BaseHelpUtils.isNullOrEmpty(baseInvo.getPrimaryInvoiceCode())
						&& !BaseHelpUtils.isNullOrEmpty(baseInvo.getPrimaryInvoiceNumber())) {
					if (BaseHelpUtils.isNullOrEmpty(primaryInvoiceCode)) {
						primaryInvoiceCode.append("'");
						primaryInvoiceCode.append(baseInvo.getPrimaryInvoiceCode());
						primaryInvoiceCode.append("'");
						primaryInvoiceNumber.append("'");
						primaryInvoiceNumber.append(baseInvo.getPrimaryInvoiceNumber());
						primaryInvoiceNumber.append("'");
					} else {
						primaryInvoiceCode.append(",");
						primaryInvoiceCode.append("'");
						primaryInvoiceCode.append(baseInvo.getPrimaryInvoiceCode());
						primaryInvoiceCode.append("'");
						primaryInvoiceNumber.append(",");
						primaryInvoiceNumber.append("'");
						primaryInvoiceNumber.append(baseInvo.getPrimaryInvoiceNumber());
						primaryInvoiceNumber.append("'");
					}
				}
			}
		}
		// 对应合同的发票
		Invoice invoice = new Invoice();
		invoice.setConditionContractId("=", contractId);
		invoice.setConditionSign("=", 1);// 正常的发票
		List<BaseInvoice> list = new ArrayList<>();
		if (BaseHelpUtils.isNullOrEmpty(primaryInvoiceCode) && BaseHelpUtils.isNullOrEmpty(primaryInvoiceNumber)) {
			list = invoice.conditionalLoad(" order by invoice_number ASC");
		} else {
			list = invoice.conditionalLoad(" invoice_number not in (" + primaryInvoiceNumber.toString() + ")  order by invoice_number ASC");
		}
		// 检索出还有完全回款的发票和没有回款的发票
		if (list.size() > 0) {
			for (BaseInvoice baseInvoice : list) {
				CapitalsToInvoice cti = new CapitalsToInvoice();
				cti.setConditionInvoiceId("=", baseInvoice.getInvoiceId());
				List<BaseCapitalsToInvoice> l = cti.conditionalLoad();
				if (l.size() > 0) {
					// 阶段回款金额
					double stage_sum_money = 0;
					// 阶段回款百分比
					double stage_percentage = 0;
					for (BaseCapitalsToInvoice b : l) {
						stage_sum_money += BaseHelpUtils.getDoubleValue(b.getStageSumMoney());
						stage_percentage += BaseHelpUtils.getDoubleValue(b.getStagePercentage());
					}
					// 相等说明该发票回款完成
					if (stage_sum_money >= StaticMethod
							.getDouble2Value(BaseHelpUtils.getDoubleValue(baseInvoice.getInvoiceAmount()))) {
						// 回款完成的发票不必显示出来
					} else {
						baseInvoice.setOutputTax(StaticMethod.formatComma4BigDecimal(stage_sum_money));// 回款金额
						baseInvoice.setTaxRate(StaticMethod.formatComma4BigDecimal(stage_percentage));// 回款百分比
						resList.add(baseInvoice);
					}
				} else {
					baseInvoice.setOutputTax(StaticMethod.formatComma4BigDecimal(0));// 回款金额
					baseInvoice.setTaxRate(StaticMethod.formatComma4BigDecimal(0));// 回款百分比
					resList.add(baseInvoice);
				}
			}
		}
		BaseCollection<BaseInvoice> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "");
	}

	// history
	private String loadNotInvoiceList(Map<String, Object> result) throws SQLException {
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		// 对应合同的发票
		Invoice invoice = new Invoice();
		invoice.setConditionContractId("=", contractId);
		List<BaseInvoice> list = invoice.conditionalLoad(" order by invoice_number ASC");
		StringBuffer __tempIds = new StringBuffer();
		if (list.size() > 0) {
			for (BaseInvoice b : list) {
				if (BaseHelpUtils.isNullOrEmpty(__tempIds)) {
					__tempIds.append(b.getInvoiceId());
				} else {
					__tempIds.append(",");
					__tempIds.append(b.getInvoiceId());
				}
			}
		}

		// 全额回款的发票ID
		CapitalsToInvoice cti = new CapitalsToInvoice();
		List<BaseCapitalsToInvoice> l = cti
				.conditionalLoad(" invoice_id in (" + __tempIds + ") and stage_percentage=100 ");
		// 未全额回款的发票ID
		CapitalsToInvoice capitalsToInvoice = new CapitalsToInvoice();
		List<BaseCapitalsToInvoice> ll = capitalsToInvoice
				.conditionalLoad(" invoice_id in (" + __tempIds + ") and stage_percentage<100 ");

		// 从新构建合同的发票
		Map<Integer, BaseInvoice> map = new LinkedHashMap<>();
		if (list.size() > 0) {
			for (BaseInvoice b : list) {
				// 未还款的发票
				b.setOutputTax(StaticMethod.formatComma4BigDecimal(0));// 回款金额
				b.setTaxRate(StaticMethod.formatComma4BigDecimal(0));// 回款百分比
				map.put(b.getInvoiceId(), b);

				// 未全额回款的发票
				if (ll.size() > 0) {
					for (BaseCapitalsToInvoice c : ll) {
						if (b.getInvoiceId() == c.getInvoiceId()) {
							b.setOutputTax(c.getStageSumMoney());// 回款金额
							b.setTaxRate(c.getStagePercentage());// 回款百分比
							map.put(b.getInvoiceId(), b);
						}
					}
				}
			}

			// 全额回款的发票
			if (l.size() > 0) {
				for (BaseCapitalsToInvoice c : l) {
					map.remove(c.getInvoiceId());
				}
			}

		}
		List<BaseInvoice> resList = new ArrayList<>();
		if (map.size() > 0) {
			for (Iterator i = map.values().iterator(); i.hasNext();) {
				BaseInvoice baseInvoice = (BaseInvoice) i.next();
				resList.add(baseInvoice);
			}
		}

		BaseCollection<BaseInvoice> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "");

	}

	/**
	 * 将合(同款/回款)来绑定发票的回款 当这次的(同款/回款)的余款不够发票的余额，下次的(合同款/回款)来补 对象(合同款/回款) 与 对象(发票)
	 * ————> 多对多的关系
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String loadInvoiceList(Map<String, Object> result) throws SQLException {
		List<BaseInvoice> resList = new ArrayList<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Invoice invo = new Invoice();
		invo.setConditionContractId("=", contractId);
		invo.setConditionSign("=", 2);// 正常的发票，2表示负数发票
		List<BaseInvoice> ll = invo.conditionalLoad(" order by invoice_number ASC");
		StringBuilder primaryInvoiceCode = new StringBuilder();
		StringBuilder primaryInvoiceNumber = new StringBuilder();

		if (ll.size() > 0) {
			for (BaseInvoice baseInvo : ll) {
				if (!BaseHelpUtils.isNullOrEmpty(baseInvo.getPrimaryInvoiceCode())
						&& !BaseHelpUtils.isNullOrEmpty(baseInvo.getPrimaryInvoiceNumber())) {
					if (BaseHelpUtils.isNullOrEmpty(primaryInvoiceCode)) {
						primaryInvoiceCode.append("'");
						primaryInvoiceCode.append(baseInvo.getPrimaryInvoiceCode());
						primaryInvoiceCode.append("'");
						primaryInvoiceNumber.append("'");
						primaryInvoiceNumber.append(baseInvo.getPrimaryInvoiceNumber());
						primaryInvoiceNumber.append("'");
					} else {
						primaryInvoiceCode.append(",");
						primaryInvoiceCode.append("'");
						primaryInvoiceCode.append(baseInvo.getPrimaryInvoiceCode());
						primaryInvoiceCode.append("'");
						primaryInvoiceNumber.append(",");
						primaryInvoiceNumber.append("'");
						primaryInvoiceNumber.append(baseInvo.getPrimaryInvoiceNumber());
						primaryInvoiceNumber.append("'");
					}
				}
			}
		}
		// 对应合同的发票
		Invoice invoice = new Invoice();
		invoice.setConditionContractId("=", contractId);
		invoice.setConditionSign("=", 1);// 正常的发票
		List<BaseInvoice> list = new ArrayList<>();
		if (BaseHelpUtils.isNullOrEmpty(primaryInvoiceCode) && BaseHelpUtils.isNullOrEmpty(primaryInvoiceNumber)) {
			list = invoice.conditionalLoad(" order by invoice_number ASC");
		} else {
			list = invoice.conditionalLoad(" invoice_number not in (" + primaryInvoiceNumber.toString() + ")  order by invoice_number ASC");
		}
		// 检索出还有完全回款的发票和没有回款的发票
		if (list.size() > 0) {
			for (BaseInvoice baseInvoice : list) {
				ConditionTmpcapitalstoinvoicecior c = new ConditionTmpcapitalstoinvoicecior();
				c.setInvoiceId(baseInvoice.getInvoiceId());
				QueryTmpcapitalstoinvoicecior dao = new QueryTmpcapitalstoinvoicecior();
				BaseCollection<BaseTmpcapitalstoinvoicecior> baseRes = dao.executeQuery(c.getKeyValues(), c);

				// CapitalsToInvoice cti = new CapitalsToInvoice();
				// cti.setConditionInvoiceId("=", baseInvoice.getInvoiceId());
				// List<BaseCapitalsToInvoice> l = cti.conditionalLoad();
				List<BaseTmpcapitalstoinvoicecior> l = baseRes.getCollections();
				if (l.size() > 0) {
					// 阶段回款金额
					double stage_sum_money = 0;
					// 阶段回款百分比
					double stage_percentage = 0;
					for (BaseTmpcapitalstoinvoicecior b : l) {
						stage_sum_money += BaseHelpUtils.getDoubleValue(b.getStageSumMoney());
						stage_percentage += BaseHelpUtils.getDoubleValue(b.getStagePercentage());
						// 发票回款日期
						baseInvoice.setRegistrationDate(b.getHappenDate());
					}
					baseInvoice.setOutputTax(StaticMethod.formatComma4BigDecimal(stage_sum_money));// 回款金额
					baseInvoice.setTaxRate(StaticMethod.formatComma4BigDecimal(stage_percentage));// 回款百分比
					resList.add(baseInvoice);
				} else {
					baseInvoice.setOutputTax(StaticMethod.formatComma4BigDecimal(0));// 回款金额
					baseInvoice.setTaxRate(StaticMethod.formatComma4BigDecimal(0));// 回款百分比
					baseInvoice.setRegistrationDate(null);
					resList.add(baseInvoice);
				}
			}
		}
		BaseCollection<BaseInvoice> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "");
	}

	/**
	 * 将(同款/回款)来绑定合同阶段的回款 当这次的(同款/回款)的余款不够合同阶段的款，下次的(合同款/回款)来补 对象(合同款/回款) 与
	 * 对象(合同阶段) ————> 多对多的关系
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String loadContractReceivable(Map<String, Object> result) throws SQLException {
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		ContractReceivable c = new ContractReceivable();
		c.setConditionContractId("=", contractId);
		List<BaseContractReceivable> list = c.conditionalLoad(" order by contract_receivable_id,parent_id ASC ");
		List<BaseContractReceivable> resList = new ArrayList<>();
		// 检索出还有完全回款的发票和没有回款的发票
		if (list.size() > 0) {
			for (BaseContractReceivable baseContractReceivable : list) {
				CapitalsToContractReceivable cti = new CapitalsToContractReceivable();
				cti.setConditionContractReceivableId("=", baseContractReceivable.getContractReceivableId());
				List<BaseCapitalsToContractReceivable> l = cti.conditionalLoad();
				if (l.size() > 0) {
					// 阶段回款金额
					double stage_sum_money = 0;
					// 阶段回款百分比
					double stage_percentage = 0;
					for (BaseCapitalsToContractReceivable b : l) {
						stage_sum_money += BaseHelpUtils.getDoubleValue(b.getStageSumMoney());
						stage_percentage += BaseHelpUtils.getDoubleValue(b.getStagePercentage());
					}
					baseContractReceivable.setStageSumMoney(StaticMethod.formatComma4BigDecimal(stage_sum_money));// 回款金额
					baseContractReceivable.setStagePercentage(StaticMethod.formatComma4BigDecimal(stage_percentage));// 回款百分比
					resList.add(baseContractReceivable);
				} else {
					baseContractReceivable.setStageSumMoney(StaticMethod.formatComma4BigDecimal(0));// 回款金额
					baseContractReceivable.setStagePercentage(StaticMethod.formatComma4BigDecimal(0));// 回款百分比
					resList.add(baseContractReceivable);
				}
			}
		}
		BaseCollection<BaseContractReceivable> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "");
	}

	private String loadContractAllItemCollection(Map<String, Object> result) throws SQLException {
		double sum = 0;
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Capital c = new Capital();
		c.setConditionContractId("=", contractId);
		c.setConditionMoneyAttribute("=", 1);// 项目回款

		List<BaseCapital> resList = c.conditionalLoad(" order by create_date desc ");
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "" + sum);
	}

	private String loadContractItemCollection(Map<String, Object> result) throws SQLException {
		double sum = 0;
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		boolean isFlag = BaseHelpUtils.getBoolean(result.get("isFlag"));
		Capital c = new Capital();
		c.setConditionContractId("=", contractId);
		c.setConditionMoneyAttribute("=", 1);// 项目回款
		if (isFlag) {
			c.setConditionHasContractReceivable("=", false);// 没有绑定合同阶段
		} else {
			c.setConditionHasInvoices("=", false);// 没有绑定发票
		}

		List<BaseCapital> resList = c.conditionalLoad(" order by create_date desc ");
		for (BaseCapital b : resList) {
			sum += BaseHelpUtils.getDoubleValue(b.getBorrowMoney());
		}

		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, "" + sum);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
		CustomItemCollectionHandler.onDistributiveCapitalToProject(181, 17767);
	}
	
}
