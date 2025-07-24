package pomplatform.invoiceexpresitssccmisiior.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClient;
import com.pomplatform.db.bean.BaseContractClient;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BaseInvoiceApply;
import com.pomplatform.db.bean.BaseInvoiceExpres;
import com.pomplatform.db.dao.Client;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractClient;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.InvoiceApply;
import com.pomplatform.db.dao.InvoiceExpres;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.system.executor.SelectValueCache;
import message.common.ERPWeixinUtils;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.invoiceexpresitssccmisiior.bean.BaseMinvoiceexpresitssccmisiior;
import pomplatform.invoiceexpresitssccmisiior.bean.ConditionMinvoiceexpresitssccmisiior;
import pomplatform.invoiceexpresitssccmisiior.query.QueryMinvoiceexpresitssccmisiior;

/**
 * 
 * @ClassName: CustomerMinvoiceexpresitssccmisiiorHandler 
 * @Description:  快递处理控制
 * @author CL
 * @date 2016年11月14日 
 *
 */
public class CustomerMinvoiceexpresitssccmisiiorHandler implements GenericProcessor,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomerMinvoiceexpresitssccmisiiorHandler.class);
	
	private final static int EXPRESS_TYPE_ONE = 1;//未寄送
	private final static int EXPRESS_TYPE_TWO = 2;//已寄送/待签收
	private final static int EXPRESS_TYPE_THREE = 3;//已签收
	
	private final static int DISABLE_TYPE = 1;//禁止操作
	private final static int ENABLE_TYPE = 0;//可操作
	
	private final static String ADD_INVOICE_EXPRESS = "addInvoiceExpress";//发送快递
	
	private final static String GET_CLIENTS_BY_CONTRACT = "getClientsByContract";//根据合同获取联系人数据
	
	private final static String GET_CLIENTS_BY_ID = "getClientsById"; //根据主键获取联系人数据
	
	private final static String UPDATE_EXPRESS_TYPE = "updateExpressType"; //修改快递状态
	
	private final static String GET_INVOICE_BY_CONTRACT = "getInvoiceByContract";//根据合同获取发票数据
	
	private final static String GET_INVOICE_BY_EXPRESS_ID = "getInvoiceByExpressId";//根据快递获取发票数据
	
	private final static String SIGN_INVOICE_EXPRESS = "signInvoiceExpress";//签收快递
	
	private final static String UPDATE_INVOICE_EXPRESS = "updateInvoiceExpress";//修改快递单
	
	private final static String GET_CONTCATS_BY_CONTRACT = "getContcatsByContract";
	
	private final static String DELETE_EXPRESS = "deleteExpress";//删除快递
	
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
				case ADD_INVOICE_EXPRESS:
					return addInvoiceExpress(result);
				case GET_CLIENTS_BY_CONTRACT:
					return getClientsByContract(result);
				case GET_CLIENTS_BY_ID:
					return getClientsById(result);
				case UPDATE_EXPRESS_TYPE:
					return updateExpressType(result);
				case GET_INVOICE_BY_CONTRACT:
					return getInvoiceByContract(result);
				case GET_INVOICE_BY_EXPRESS_ID:
					return getInvoiceByExpressId(result);
				case SIGN_INVOICE_EXPRESS:
					return signInvoiceExpress(result);
				case UPDATE_INVOICE_EXPRESS:	
					return updateInvoiceExpress(result);
				case GET_CONTCATS_BY_CONTRACT:
					return getContcatsByContract(result);
				case DELETE_EXPRESS:
					return deleteExpress(result);
			}
		}
		return null;
	}
	
	/**
	 * 删除快递数据
	 * @param result
	 * @return
	 * @throws Exception
	 */
	private String deleteExpress(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromMap(result);
		if(null != bean.getInvoiceExpressId()){
			InvoiceExpres ieDao = new InvoiceExpres();
			ieDao.setPrimaryKeyFromBase(bean);
			ieDao.delete();
			
			//删除关联数据
			Invoice iDao = new Invoice();
			iDao.setConditionInvoiceExpressId("=", bean.getInvoiceExpressId());
			iDao.setInvoiceExpressId(0);
			iDao.setDisableType(ENABLE_TYPE);
			iDao.conditionalUpdate();
		}
		
		return bc.toJSON(status, errorMsg);
	}
	
	private String getContcatsByContract(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");//合同主键
		Contract ctDao = new Contract();
		ctDao.setContractId(contractId);
		List<BaseSemployeepdror> selectData = new ArrayList<>(); 
		if(ctDao.load()){
			InvoiceApply iaDao = new InvoiceApply();
			iaDao.setConditionContractId("=", contractId);
			iaDao.setConditionDeleteFlag("=", 0);
			List<BaseInvoiceApply> dataList = iaDao.conditionalLoad();
				for (BaseInvoiceApply baseInvoiceApply : dataList) {
					BaseSemployeepdror tmp = new BaseSemployeepdror();
					tmp.setIdd(baseInvoiceApply.getInvoiceApplyId());
					tmp.setVal(baseInvoiceApply.getCustomerName());
					selectData.add(tmp);
				}
		}else{
			status = -1;
			errorMsg = "不存在主键为["+contractId+"]的合同信息";
		}
		
		BaseCollection<BaseSemployeepdror> cl = new BaseCollection<>();
		cl.setCollections(selectData);
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: updateInvoiceExpress 
	 * @Description: 修改快递信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String updateInvoiceExpress(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) result.get("params");
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromMap(param);
		InvoiceExpres dao = new InvoiceExpres();
		dao.setInvoiceExpressId(bean.getInvoiceExpressId());
		if(dao.load()){
			//修改主快递信息
			dao.setContactId(bean.getContactId());
			dao.setCourierType(bean.getCourierType());
			dao.setCourierNumber(bean.getCourierNumber());
			dao.setCourierDate(bean.getCourierDate());
			dao.setMailingAddress(bean.getMailingAddress());
			dao.setTel(bean.getTel());
			if(!BaseHelpUtils.isNullOrEmpty(bean.getRemark())){
				dao.setRemark(bean.getRemark());
			}
			if(null != dao.getSignStatus()){
				if(dao.getSignStatus() == EXPRESS_TYPE_THREE){
					dao.setSignName(bean.getSignName());
					dao.setSignDate(bean.getSignDate());
				}
			}
			dao.update();
			
			Invoice iDao = new Invoice();
			//修改发票信息
			String delIds = BaseHelpUtils.getStringValue(result, "delIds");
			//将移除的发票进行与快递的关联去除 且设置为可操作状态
			if(!BaseHelpUtils.isNullOrEmpty(delIds)){
				String [] idsArrStr = delIds.split(",");
				Object [] idsObj = new Object[idsArrStr.length];
				for (int i = 0; i < idsArrStr.length; i++) {
					idsObj[i] = Integer.parseInt(idsArrStr[i]);
				}
				iDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", idsObj);
				iDao.setInvoiceExpressId(0);
				iDao.setDisableType(ENABLE_TYPE);
				iDao.conditionalUpdate();
			}
			
			String addIds = BaseHelpUtils.getStringValue(result, "addIds");
			//将选择的发票关联快递信息 且 设置为不可操作状态
			if(!BaseHelpUtils.isNullOrEmpty(addIds)){
				String [] idsArrStr = addIds.split(",");
				Object [] idsObj = new Object[idsArrStr.length];
				for (int i = 0; i < idsArrStr.length; i++) {
					idsObj[i] = Integer.parseInt(idsArrStr[i]);
				}
				iDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", idsObj);
				iDao.setInvoiceExpressId(dao.getInvoiceExpressId());
				iDao.setDisableType(DISABLE_TYPE);
				iDao.conditionalUpdate();
			}
			
		}else{
			status = -1;
			errorMsg = "快递单不存在 ID = " + bean.getInvoiceExpressId();
		}
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: signInvoiceExpress 
	 * @Description: 签收快递
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String signInvoiceExpress(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = "";
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) result.get("params");
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromMap(param);
		InvoiceExpres dao = new InvoiceExpres();
		dao.setInvoiceExpressId(bean.getInvoiceExpressId());
		if(dao.load()){
			if(dao.getSignStatus() == EXPRESS_TYPE_TWO){
				dao.setSignName(bean.getSignName());
				dao.setSignDate(bean.getSignDate());
				dao.setSignStatus(EXPRESS_TYPE_THREE);
				dao.update();
				sendWeixinMsg(dao.generateBase(), 3);
			}else{
				status = -1;
				errorMsg = "快递单状态不正确  目前状态  signStatus = " + dao.getSignStatus();
			}
			
		}else{
			status = -1;
			errorMsg = "快递单不存在 ID = " + bean.getInvoiceExpressId();
		}
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getInvoiceByExpressId 
	 * @Description: 根据快递单主键获取关联的发票数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getInvoiceByExpressId(Map<String, Object> result) throws Exception{
		int invoiceExpressId = BaseHelpUtils.getIntValue(result, "invoiceExpressId");
		Invoice dao = new Invoice();
		dao.setConditionInvoiceExpressId("=", invoiceExpressId);
		List<BaseInvoice> list = dao.conditionalLoad();
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON();
	}
	
	
	/**
	 * 
	 * @Title: getInvoiceByContract 
	 * @Description: 根据合同获取发票数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getInvoiceByContract(Map<String, Object> result) throws Exception{
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		Invoice dao = new Invoice();
		dao.setConditionDisableType("=", ENABLE_TYPE);
		dao.setConditionContractId("=", contractId);
		List<BaseInvoice> list = dao.conditionalLoad();
		BaseCollection<BaseInvoice> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON();
	}
	
	/**
	 * 
	 * @Title: updateExpressType 
	 * @Description: 修改快递状态
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String updateExpressType(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = "";
		int invoiceExpressId = BaseHelpUtils.getIntValue(result, "invoiceExpressId");
		int signStatus = BaseHelpUtils.getIntValue(result, "signStatus");
		InvoiceExpres dao = new InvoiceExpres();
		dao.setInvoiceExpressId(invoiceExpressId);
		if(dao.load()){
			dao.setSignStatus(signStatus);
			dao.update();
			if(signStatus == EXPRESS_TYPE_TWO){
				sendWeixinMsg(dao.generateBase(), 2);
			}
		}else{
			status = -1;
			errorMsg = "快递信息不存在 ID = " + invoiceExpressId;
		}
		BaseCollection<BaseInvoiceExpres> cl = new BaseCollection<>();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getClientsById 
	 * @Description: 根据客户ID获取客户信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getClientsById(Map<String, Object> result) throws Exception{
		int clientId = BaseHelpUtils.getIntValue(result, "clientId");
		Client dao = new Client();
		dao.setConditionClientId("=", clientId);
		List<BaseClient> list= dao.conditionalLoad();
		BaseCollection<BaseClient> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON();
	}
	
	/**
	 * 
	 * @Title: getClientsByContract 
	 * @Description: 根据合同主键获取联系人数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String getClientsByContract(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");//合同主键
		Contract ctDao = new Contract();
		ctDao.setContractId(contractId);
		List<BaseSemployeepdror> selectData = new ArrayList<>(); 
		if(ctDao.load()){
//			MainProject mpDao = new MainProject();
//			mpDao.setConditionInfoCode("=", ctDao.getInfoCode());
//			BaseMainProject mpBean = mpDao.executeQueryOneRow();
//			if(null != mpBean){
				ContractClient ccDao = new ContractClient();
				ccDao.setConditionContractId("=", ctDao.getContractId());
				List<BaseContractClient> list = ccDao.conditionalLoad();
				if(list.size() > 0){
					Object [] ids = new Object[list.size()];
					for (int i = 0; i < list.size(); i++) {
						ids[i] = list.get(i).getClientId();
					}
					Client cDao = new Client();
					cDao.addCondition("client_id", "in", ids);
					List<BaseClient> dataList = cDao.conditionalLoad(" order by client_name ");
					for (BaseClient baseClient : dataList) {
						BaseSemployeepdror tmp = new BaseSemployeepdror();
						tmp.setIdd(baseClient.getClientId());
						tmp.setVal(baseClient.getClientName());
						selectData.add(tmp);
					}
				}
//			}else{
//				status = -1;
//				errorMsg = "主键为["+contractId+"]的合同信息信息编号为infoCode = ["+ ctDao.getInfoCode() +"]但不存在与该信息编号关联的项目信息";
//			}
		}else{
			status = -1;
			errorMsg = "不存在主键为["+contractId+"]的合同信息";
		}
		
		BaseCollection<BaseSemployeepdror> cl = new BaseCollection<>();
		cl.setCollections(selectData);
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	
	/**
	 * 
	 * @Title: addInvoiceExpress 
	 * @Description: 发送快递
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	private String addInvoiceExpress(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		if(null != result.get("params") && null != result.get("signStatus")){
			@SuppressWarnings("unchecked")
			Map<String, Object> params = (Map<String, Object>) result.get("params");
			
			int signStatus = BaseHelpUtils.getIntValue(result, "signStatus");
			int operator = BaseHelpUtils.getIntValue(result, "operator");
			//创建一个快递单信息
			BaseInvoiceExpres bean = new BaseInvoiceExpres();
			bean.setDataFromMap(params);
			bean.setSignStatus(signStatus);
			bean.setOperator(operator);
			InvoiceExpres iDao = new InvoiceExpres();
			iDao.setDataFromBase(bean);
			iDao.save();
			//将发票与快递单关联
			if(!BaseHelpUtils.isNullOrEmpty(result.get("ids"))){
				String [] ids = BaseHelpUtils.getStringValue(result, "ids").split(",");
				Object [] intIds = new Object[ids.length];
				for (int i = 0; i < ids.length; i++) {
					intIds[i] = Integer.parseInt(ids[i]);
				}
				Invoice dao = new Invoice();
				dao.setInvoiceExpressId(iDao.getInvoiceExpressId());
				dao.setDisableType(DISABLE_TYPE);
				dao.addCondition("invoice_id", "in", intIds);
				dao.conditionalUpdate();
			}
			sendWeixinMsg(iDao.generateBase(), 1);
		}else{
			status = -1;
			errorMsg = "数据错误,请联系运维人员！[params(快递基础数据) == null || ids == null || signStatus == nul] --- ids = " + BaseHelpUtils.getStringValue(result, "ids") + " signStatus =" + BaseHelpUtils.getStringValue(result, "signStatus");
		}
		BaseCollection<BaseInvoiceExpres> cl = new BaseCollection<>();
		ThreadConnection.commit();
		return cl.toJSON(status, errorMsg);
	}
	
	public void sendWeixinMsg(BaseInvoiceExpres bean, int type) throws Exception{
		//（1:发出准备/ 2: 发出/ 3:对方签收）
		String typeStr = type == 1 ? "发出准备" : type == 2 ? "发出" : "对方签收";
		Date currentDate = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BigDecimal allMoney = BigDecimal.ZERO;
		String contractName = null;//合同名称
		String contractCode = null;
		
		//设置合同名称
		Contract cDao = new Contract();
		cDao.setContractId(bean.getContractId());
		if(cDao.load()){
			contractName = cDao.getContractName();
			contractCode = cDao.getContractCode();
		}
		//快递类型
		String courierType = SelectValueCache.getSelectValue("system_dictionary_56", bean.getCourierType() + "");
		String invoiceIds = "";
		//统计总共发出多少钱快递
		Invoice iDao = new Invoice();
		iDao.setConditionInvoiceExpressId("=", bean.getInvoiceExpressId());
		List<BaseInvoice> iList = iDao.conditionalLoad();
		int i = 0;
		if(iList.size() <= 0){
			return;
		}
		for (BaseInvoice baseInvoice : iList) {
			if(null != baseInvoice.getInvoiceAmount()){
				allMoney = allMoney.add(baseInvoice.getInvoiceAmount());
				if(i != 0){
					invoiceIds += ",";
				}
				invoiceIds += baseInvoice.getInvoiceId();
				i ++;
			}
		}
		String msgT = "【快递提醒】\n合同：%2$s(%1$s)\n发票金额：%3$s\n状态为：%4$s\n状态变动日期：%5$s\n快递公司：%6$s\n快递号：%7$s";
		String msgTt = "【快递提醒】\n合同：%2$s(%1$s)\n发票金额：%3$s\n状态为：%4$s\n状态变动日期：%5$s\n快递公司：%6$s\n快递号：%7$s\n签收人：%8$s";
		DecimalFormat df = new DecimalFormat("##,###,###,###,###.00");
		String sendMsg = "";
		if(type == 3){
			sendMsg = String.format(msgTt, contractCode, contractName, df.format(allMoney), typeStr, sdf.format(currentDate), courierType, bean.getCourierNumber(), bean.getSignName());
		}else{
			sendMsg = String.format(msgT, contractCode, contractName, df.format(allMoney), typeStr, sdf.format(currentDate), courierType, bean.getCourierNumber());
		}
		//浩哥说先通知他  ; 后面再去掉
		ERPWeixinUtils.sendTextMsgToUser("qy01198a3d6874ac0028db2e5ac8", sendMsg);
		if(allMoney.compareTo(BigDecimal.ZERO) > 0 && invoiceIds.length() > 0){
			
			String sql = "select project_manage_id from attachment_manages where attachment_manage_id in ( select attachment_manage_id from attachment_link_invoices where invoice_id in (" + invoiceIds + ") )";
			
			Employee eDao = new Employee();
			List<BaseEmployee> eList = eDao.conditionalLoad(" employee_id in (" + sql + ")");
			if(eList.size() > 0){
				String departmentIds = "";
				
				Set<String> wxUserId = new HashSet<String>();
				int y = 0;
				for (BaseEmployee baseEmployee : eList) {
					if(!BaseHelpUtils.isNullOrEmpty(baseEmployee.getCompanyWeixin())){
						wxUserId.add(baseEmployee.getCompanyWeixin());
					}
					if(null != baseEmployee.getDepartmentId()){
						if(y != 0){
							departmentIds += ",";
						}
						departmentIds += baseEmployee.getDepartmentId();
						y ++;
					}
				}
				if(eList.size() > 0){
					if(departmentIds.length() > 0){
						String eSql = " select employee_id from employee_roles where role_id = 3 and department_id in (" + departmentIds + ")";
						eDao.clear();
						List<BaseEmployee> epList = eDao.conditionalLoad(" employee_id in (" + eSql + ")");
						for (BaseEmployee baseEmployee : epList) {
							if(!BaseHelpUtils.isNullOrEmpty(baseEmployee.getCompanyWeixin())){
								wxUserId.add(baseEmployee.getCompanyWeixin());
							}
						}
					}
					if(wxUserId.size() > 0){
						String touser = "";
			            int index = 0;
						for (String string : wxUserId) {
							if (index != 0) {
		                        touser += "|";
		                    }
		                    touser += string;
		                    index++;
						}
						ERPWeixinUtils.sendTextMsgToUser(touser, sendMsg);
					}
				}
				
			}
			
			
		}
		
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMinvoiceexpresitssccmisiior> result;
		ConditionMinvoiceexpresitssccmisiior c = new ConditionMinvoiceexpresitssccmisiior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMinvoiceexpresitssccmisiior dao = new QueryMinvoiceexpresitssccmisiior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMinvoiceexpresitssccmisiior.ALL_CAPTIONS);
			for(BaseMinvoiceexpresitssccmisiior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


