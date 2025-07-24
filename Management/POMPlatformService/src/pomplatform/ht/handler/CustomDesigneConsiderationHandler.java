package pomplatform.ht.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.CustomBaseDesignConsideration;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.PreProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
public class CustomDesigneConsiderationHandler implements GenericProcessor, GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomDesigneConsiderationHandler.class);
	/**
	 * 成功的报价单的总金额
	 */
	private static final String SELECT_SUCCESS_QUOTATION = "selectSuccessQuotation";
	
	/**
	 * 没有报价单默认创建一个报价单子
	 */
	private static final String SETTING_DEFAULT_QUOTATION = "settingDefaultQuotation";

	/**
	 * 设置最终报价单
	 */
	private static final String SET_FINAL_QUOTATION = "setFinalQuotation";
	/**
	 * 根据项目infoCode projectCode 查询拆分价数据
	 */
	private static final String GET_DESIGN_CONSIDERATION_LIST = "getDesignConsiderationList";
	private static final String GET_CHECK_DESIGN_CONSIDERATION_LIST="getCheckDesignConsiderationList";

	/**
	 * 修改或保存拆分价数据
	 */
	private static final String SAVE_OR_UPDATE_DESIGN_CONSIDERATION = "saveOrUpdateDesignConsideration";

	/**
	 * 删除拆分价
	 */
	private static final String DELETE_DESIGN_CONSIDERATION = "deleteDesignConsideration";
	
	/**
	 * 检查拆分价不能大于报价单的总价
	 */
	private static final String CHECK_NOT_SUM_MONEY = "checkSumMoney";
	
	/**
	 * 移动拆分价
	 */
	private static final String MOVE_DESIGNER_CONSIDERATIONS = "moveDesignConsideration";
	/**
	 * 创建补充协议
	 */
	private static final String ON_CREATE_SUPPLEMENT_AGREEMENT = "onCreateSupplementAgreement";
	
	/**
	 * 拆分价提交   改变项目拥有拆分价的状态   且将合同流转到运营
	 */
	private static final String SUBMIT_CONSIDERATION = "submitConsideration";

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
			case GET_DESIGN_CONSIDERATION_LIST:
				return getDesignConsiderationList(result);
			case GET_CHECK_DESIGN_CONSIDERATION_LIST:
				return getCheckDesignConsiderationList(result);
			case SAVE_OR_UPDATE_DESIGN_CONSIDERATION:
				return saveOrUpdateDesignConsideration(creteria);
			case DELETE_DESIGN_CONSIDERATION:
				return deleteDesignConsideration(result);
			case CHECK_NOT_SUM_MONEY:
				return CheckSumMoney(result);
			case SET_FINAL_QUOTATION:
				return setFinalQuotation(result);
			case MOVE_DESIGNER_CONSIDERATIONS:
				return moveDesignConsideration(result);
			case SETTING_DEFAULT_QUOTATION:
				return settingDefaultQuotation(result);
			case SELECT_SUCCESS_QUOTATION:
				return selectSuccessQuotation(result);
			case ON_CREATE_SUPPLEMENT_AGREEMENT:
				return onCreateSupplementAgreement(result);
			case SUBMIT_CONSIDERATION:
				return submitConsideration(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: submitConsideration 
	 * @Description: 拆分价提交   改变项目拥有拆分价的状态   且将合同流转到运营
	 * @param @param param
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	public String submitConsideration(Map<String, Object> param) throws SQLException{
		int status = 1;
		String errorMsg = null;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String infoCode = BaseHelpUtils.getStringValue(param, "infoCode");
		if(BaseHelpUtils.isNullOrEmpty(infoCode)){
			status = -1;
			errorMsg = "信息编号为空";
		}else{
			MainProject mpDao = new MainProject();
			mpDao.setConditionInfoCode("=", infoCode);
			mpDao.setHasSplitPriceTime(new Date());
			mpDao.setHasSplitPrice(true);
			mpDao.conditionalUpdate();
			//获取成功报价单的金额 作为合同的总金额
			OutQuotation oqDao = new OutQuotation();
			oqDao.setConditionInfoCode("=", infoCode);
			oqDao.setConditionQuotationStatus("=", StaticUtils.QUOTATION_STATUS_ONE);
			oqDao.executeQueryOneRow();
			
			Contract ctDao = new Contract();
			if(null != oqDao.getMoneySum()){
				ctDao.setSigningMoneySum(oqDao.getMoneySum());
				ctDao.setContractPrice(oqDao.getMoneySum());
			}
			ctDao.setConditionInfoCode("=", infoCode);
			ctDao.setConditionFlowStatus("=", StaticUtils.FLOW_STATUS_99);
			ctDao.setFlowStatus(StaticUtils.FLOW_STATUS_0);
			ctDao.conditionalUpdate();
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
     * 创建补充协议
     * @param param
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("rawtypes")
	public String onCreateSupplementAgreement(Map<String, Object> param) throws SQLException{
    	//获取主项目主键ID
    	int mainProjectId = BaseHelpUtils.getIntValue(param, "mainProjectId");
    	MainProject mainProjectDao = new MainProject();
    	mainProjectDao.setMainProjectId(mainProjectId);
    	ThreadConnection.beginTransaction();
    	if(mainProjectDao.load()){
    		BaseMainProject mainProjectBean = mainProjectDao.generateBase();
    		//获取项目的信息编号
    		String infoCode = mainProjectBean.getInfoCode();
    		String projectCode = mainProjectBean.getProjectCode();
    		//根据信息编号去检索目前创建到了第几个补充协议了
    		mainProjectDao.clear();
    		mainProjectDao.setConditionInfoCode("=",infoCode);
    		mainProjectDao.setConditionProjectCode("=",projectCode);
    		List<BaseMainProject> mainProjectList = mainProjectDao.conditionalLoad();
    		int serialyNumber = 0;
    		//遍历序列号，保证能取到序列号最大的值
    		for(BaseMainProject e : mainProjectList){
    			if(e.getSerialNumber() > serialyNumber){
    				serialyNumber = e.getSerialNumber();
    			}
    		}
    		serialyNumber++;
    		//更新当前合同的序列号
    		mainProjectDao.setSerialNumber(serialyNumber);
    		mainProjectDao.conditionalUpdate();
    		//重新赋予新的补充协议的数据集
    		mainProjectBean.setParentId(mainProjectId);
    		mainProjectBean.setSerialNumber(serialyNumber);
    		//初始化
    		//获取项目编号
//    		String projectCode = mainProjectBean.getProjectCode();
    		String projectName = mainProjectBean.getProjectName();
    		projectName = String.format("%1$s%2$s%3$s%4$s",projectName,"补充协议(",getSerialyNumberCh(serialyNumber),")");
    		projectCode = String.format("%1$s%2$s%3$s%4$s",projectCode,"(0",serialyNumber,")");
    		String newInfoCode = String.format("%1$s%2$s%3$s%4$s",infoCode,"(0",serialyNumber,")");
    		mainProjectBean.setInfoCode(newInfoCode);
    		mainProjectBean.setProjectCode(projectCode);
    		mainProjectBean.setProjectName(projectName);
    		mainProjectBean.setHasOutQuotations(Boolean.FALSE);
    		mainProjectBean.setHasSplitPrice(Boolean.FALSE);
    		mainProjectBean.setHasFormalContracts(Boolean.FALSE);
    		mainProjectDao.clear();
    		mainProjectDao.setDataFromBase(mainProjectBean);
    		mainProjectDao.save();
    		//根据信息编号去合同表中检索数据，并把合同信息复制一份做为新的补充协议的合同信息
    		Contract contractDao = new Contract();
    		contractDao.setConditionInfoCode("=",infoCode);
    		contractDao.setConditionProjectCode("=",projectCode);
    		BaseContract contractBean = contractDao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(contractBean)){
    			//获取合同编号
    			String contractCode = contractBean.getContractCode();
    			//获取合同名称
    			String contractName = contractBean.getContractName();
    			//重置合同编号和合同名称
    			contractCode = String.format("%1$s%2$s%3$s%4$s",contractCode,"(0",serialyNumber,")");
    			contractName = String.format("%1$s%2$s%3$s%4$s",contractName,"补充协议(",getSerialyNumberCh(serialyNumber),")");
    			contractBean.setInfoCode(newInfoCode);
    			contractBean.setContractCode(contractCode);
    			contractBean.setContractName(contractName);
    			contractBean.setProjectCode(projectCode);
    			contractBean.setSigningMoneySum(BigDecimal.ZERO);
    			contractBean.setFlowStatus(0);
    			contractBean.setContractDate(null);
    			contractBean.setSendingDate(null);
    			contractBean.setContractSigningStatus(null);
    			contractBean.setServiceSuggestBook(null);
    			contractBean.setServiceSuggestBookId(0);
    			Date date = new Date();
    			contractBean.setCreateTime(date);
    			contractBean.setUpdateTime(date);
    			contractDao.clear();
    			//设置合同的状态（解决默认为已经签订的状态，会自动计算到提成分配中）
    			contractBean.setContractSigningStatus(null);
    			contractBean.setSendingDate(null);
    			contractDao.setDataFromBase(contractBean);
    			contractDao.save();
    		}
    	}else{
    		throw new SQLException("该项目不存在");
    	}
    	ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection();
		return bc.toJSON(0, null);
    }
    
	/**
	 * 没有报价单默认创建一个报价单子
	 * 1:先判断这个项目有报价单没有，没有创建一个空的报价单子
	 * @param result
	 * @return
	 * @throws SQLException
	 */
    private String settingDefaultQuotation(Map<String, Object> result) throws SQLException {
		//获取信息编号
		String infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
		if(BaseHelpUtils.isNullOrEmpty(infoCode)) {
			throw new SQLException("操作异常：获取信息编号失败");
		}
		//获取信息编号
		String projectCode=BaseHelpUtils.getStringValue(result, "projectCode");
		if(BaseHelpUtils.isNullOrEmpty(projectCode)) {
			throw new SQLException("操作异常：获取订单编号失败");
		}
		//根据信息编号去检索前期项目，如果没有(像补充协议是没有前期项目的)，则可正常创建报价单，如果有，则需要判断该项目是否已关闭，如果已关闭，则不可创建报价单
//		PreProject pDao = new PreProject();
//		pDao.setConditionInfoCode("=",infoCode);
//		BasePreProject pBean = pDao.executeQueryOneRow();
//		if(!BaseHelpUtils.isNullOrEmpty(pBean)) {
			//立项/关闭的流程状态(1：立项进行中，2：已立项，5：立项失败，4：关闭进行中，5：已关闭，6：关闭失败)
//			int status = BaseHelpUtils.getIntValue(pBean.getStatus()); 
//			if(status == 4) {
//				throw new SQLException("操作异常：该项目关闭进行中，不可进行报价操作");
//			}else if(status == 5) {
//				throw new SQLException("操作异常：该项目已关闭，不可进行报价操作");
//			}
//		}
		
		
		MainProject mDao = new MainProject();
		mDao.setConditionProjectCode("=", projectCode);
		BaseMainProject mBean = mDao.executeQueryOneRow();
		if(BaseHelpUtils.isNullOrEmpty(mBean)) {
			throw new SQLException("操作异常：该项目("+projectCode+")获取失败！");
		}
		
		int employeeId=BaseHelpUtils.getIntValue(result, "employeeId");
		BaseCollection<BaseOutQuotation> bc = new BaseCollection<>();
		OutQuotation o=new OutQuotation();
		o.setConditionInfoCode("=", infoCode);
		o.setConditionProjectCode("=", projectCode);
		int outQuotationId = 0;
		if(o.countRows()<=0){
			String bh=CustomQuotationNumber.getQuotationNumber(projectCode,infoCode);
			BaseOutQuotation b=new BaseOutQuotation();
			b.setInfoCode(infoCode);
			b.setProjectCode(projectCode);
			b.setQuotationStatus(StaticUtils.QUOTATION_STATUS);
			b.setQuotationName("报价单"+bh);
			b.setQuotationNumber(bh);
			b.setEmployeeId(employeeId);
			o.setDataFromBase(b);
			o.save();
		}
		
		
		
		return bc.toJSON(0,"");
	}
	/**
	 * 
	 * @Title: moveDesignConsideration 
	 * @Description: 移动报价单子项
	 * @param @param result
	 * @param @return
	 * @param @throws SQLException    
	 * @return String   
	 * @throws
	 */
	private String moveDesignConsideration(Map<String, Object> result) throws SQLException {
		int res=1;
		String move = BaseHelpUtils.getStringValue(result, "moveType");
		int designConsiderationId = BaseHelpUtils.getIntValue(result, "designConsiderationId");
		DesignConsideration dao = new DesignConsideration();
		dao.setDesignConsiderationId(designConsiderationId);
		String errorMsg = "";
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		if(dao.load()){
			int fromNum = BaseHelpUtils.getIntValue(dao.getOrderNum());
			int outQuotationId = dao.getOutQuotationId();
			dao.clear();
			dao.setConditionOutQuotationId("=", outQuotationId);
			String descOrAsc = "";
			if(move.equals("up")){
				dao.setConditionOrderNum("<", fromNum);
				descOrAsc = "DESC";
				errorMsg = "已经在最顶部了";
			}
			if(move.equals("down")){
				dao.setConditionOrderNum(">", fromNum);
				descOrAsc = "ASC";
				errorMsg = "已经在最低部了";
			}
			BaseDesignConsideration bean = dao.executeQueryOneRow(" order by order_num " + descOrAsc);
			if(BaseHelpUtils.isNullOrEmpty(bean)){
				res = -1;
			}else{
				int toNum = BaseHelpUtils.getIntValue(bean.getOrderNum());
				dao.clear();
				//修改与当前选定数据相互交换位置的orderNum
				dao.setDataFromBase(bean);
				dao.setPrimaryKeyFromBase(bean);
				dao.setOrderNum(fromNum);
				dao.update();
				dao.clear();
				//修改当前选定的orderNum
				dao.setDesignConsiderationId(designConsiderationId);
				if(dao.load()){
					dao.setOrderNum(toNum);
					dao.update();
				}
				bc.setCollections(getReturnDesignConsiderationList(outQuotationId));
			}
		}else{
			res = -1;
			errorMsg = "数据错误";
		}
		return bc.toJSON(res, errorMsg);
	}
	/**
	 * 创建合同的时候需要知道该成功报价单的金额来填充合同的金额
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	
	private String selectSuccessQuotation(Map<String, Object> result) throws SQLException {
		int res=-1;
		String errorStr="";
		String infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
		int parentId = BaseHelpUtils.getIntValue(result, "parentId");
		OutQuotation o=new OutQuotation();
		o.setConditionInfoCode("=", infoCode);
		o.setConditionQuotationStatus("=", 1);
		BaseOutQuotation bq=o.executeQueryOneRow();
		String contractCode = "";
		//parentId>0,说明是补充协议，则去主项目表中查询
		if(parentId > 0){
			MainProject mainProjectDao = new MainProject();
			mainProjectDao.setMainProjectId(parentId);
			if(mainProjectDao.load()){
				//获取序列号
				int serialNumber = mainProjectDao.getSerialNumber();
				//获取信息编号
				String parentInfoCode = mainProjectDao.getInfoCode();
				//根据主项目的订单信息去检索合同表数据得到其合同编号
				Contract contractDao = new Contract();
				contractDao.setConditionInfoCode("=",parentInfoCode);
				BaseContract contractBean = contractDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(contractBean)){
					//获取合同编号
					contractCode = BaseHelpUtils.getString(contractBean.getContractCode());
					if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
						contractCode = String.format("%1$s%2$s%3$s%4$s",contractCode,"(0",serialNumber,")");
					}
				}
			}
		}
		if(BaseHelpUtils.isNullOrEmpty(bq)){
			res=-1;
			errorStr="没有报价单";
		}else{
			//用项目编号暂存合同编号
			bq.setProjectCode(contractCode);
			res=1;
		}
		return bq.toOneLineJSON(res,errorStr);
	}
	/**
	 * 设置最终报价
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String setFinalQuotation(Map<String, Object> result) throws SQLException {
		String newCreateQuotationName=BaseHelpUtils.getString(result.get("newCreateQuotationName")).trim();
//		int outTempletId=BaseHelpUtils.getIntValue(result, "outTempletId");
//		int businessType=BaseHelpUtils.getIntValue(result, "businessType");
		int outQuotationId=BaseHelpUtils.getIntValue(result, "outQuotationId");
		double finalizedMoney=BaseHelpUtils.getDoubleValue(result.get("finalizedMoney"));
		List<BaseOutDesignConsideration> outCxl = new ArrayList<>();
		OutDesignConsideration out = new OutDesignConsideration();
		out.setConditionOutQuotationId("=", outQuotationId);
//		out.setConditionBusinessType("=", businessType);
//		out.setConditionOutTempletId("=", outTempletId);
//		out.setConditionNewCreateQuotationName("=", newCreateQuotationName);
		outCxl = out.conditionalLoad(" order by order_num ");
		if(outCxl.size()>0){
			for(BaseOutDesignConsideration b:outCxl){
				b.setFinalizedMoney(StaticMethod.formatComma4BigDecimal(finalizedMoney));
				OutDesignConsideration od=new OutDesignConsideration();
				od.setDataFromBase(b);
				od.update();
			}
			 
		}
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		return bc.toJSON(1, "");
	}
	/**
	 * 检查拆分价不能大于报价单的总价
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String CheckSumMoney(Map<String, Object> result) throws SQLException {
		int designConsiderationId=BaseHelpUtils.getIntValue(result, "designConsiderationId");
		String infoCode,projectCode;
		infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
		projectCode=BaseHelpUtils.getStringValue(result, "projectCode");
		//报价单总价
		double sumMoney__=BaseHelpUtils.getDoubleValue(result.get("sumMoney__"));
		//当前追加的金额
		double nowMoney=BaseHelpUtils.getDoubleValue(result.get("nowMoney"));
		//保存数据库中的拆分金额
		double checkNowMoney=CheckSumMoney(designConsiderationId,infoCode, projectCode);
		
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		
		System.out.println("拆分金额大于报价单的总金额="+(nowMoney+checkNowMoney));
		//拆分金额大于报价单的总金额
		if((nowMoney+checkNowMoney)>sumMoney__){
			return bc.toJSON(-1, "拆分金额("+(nowMoney+checkNowMoney)+")大于报价单的总金额("+sumMoney__+")");
		}else{
			return bc.toJSON(1, "");
		}
	}
	
	/**
	 * 拆分价总计
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private double CheckSumMoney(int designConsiderationId,String infoCode,String projectCode) throws SQLException {
		double tempSumMoney=0.0;
		DesignConsideration desDao=new DesignConsideration();
		desDao.setConditionInfoCode("=", infoCode);
		desDao.setConditionProjectCode("=", projectCode);
		List<BaseDesignConsideration> baseList=desDao.conditionalLoad();
		if(baseList.size()>0){
			for(BaseDesignConsideration b:baseList){
				if(designConsiderationId!=b.getDesignConsiderationId()){
					double tempMoneySum=0,tempWithTheAmount=0,tempOnSiteTotalMoney=0;
					if(!BaseHelpUtils.isNullOrEmpty(b.getMoneySum())){
						tempMoneySum=b.getMoneySum().doubleValue();
					}if(!BaseHelpUtils.isNullOrEmpty(b.getWithTheAmount())){
						tempWithTheAmount=b.getWithTheAmount().doubleValue();
					}if(!BaseHelpUtils.isNullOrEmpty(b.getOnSiteTotalMoney())){
						tempOnSiteTotalMoney=b.getOnSiteTotalMoney().doubleValue();
					}
					tempSumMoney+=(tempMoneySum+tempWithTheAmount+tempOnSiteTotalMoney);
				}
			}
		}
		return tempSumMoney;
	}
	/**
	 * 删除拆分价
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */

	private String deleteDesignConsideration(Map<String, Object> result) throws SQLException {
		ThreadConnection.beginTransaction();
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		int outDesignConsiderationId = BaseHelpUtils.getIntValue(result,"outDesignConsiderationId");
		if(outDesignConsiderationId <= 0) {
			throw new SQLException("删除异常：获取报价单编码失败");
		}
		DesignConsideration sDao=new DesignConsideration();
		sDao.setConditionOutDesignConsiderationId("=",outDesignConsiderationId);
		sDao.setConditionDisableType("=",1);//不能删除
		if(sDao.isExist()) {
			throw new SQLException("删除异常：已创建订单，不可进行删除操作");
		}
		sDao.clear();
		sDao.setConditionOutDesignConsiderationId("=",outDesignConsiderationId);
		sDao.conditionalDelete();
		
		ThreadConnection.commit();
		return bc.toJSON(0,"");
	}
	
	private List<BaseDesignConsideration> getReturnDesignConsiderationList(int outQuotationId) throws SQLException {
		DesignConsideration descDao = new DesignConsideration();
		descDao.setConditionOutQuotationId("=",outQuotationId);
		List<BaseDesignConsideration> ds = descDao.conditionalLoad(" order by order_num");
		
		List<BaseDesignConsideration> resList = new ArrayList<>();
		double totalMoney=0,outTotalMoney=0;
		for(BaseDesignConsideration d:ds){
			//标识正常的数据1，合计统计数据2和最终报价统计数据3
			d.setJobMix(1);
			
			//单位换算为万元的字段
			double sumMoney=BaseHelpUtils.getDoubleValue(d.getMoneySum());
			if(sumMoney>0){
				//统计报价单
				double tempCount=sumMoney;
				d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				outTotalMoney+=tempCount;
			}
			double interiorSumMoney=BaseHelpUtils.getDoubleValue(d.getInteriorMoneySum());
			if(interiorSumMoney>0){
				double tempCount=interiorSumMoney;
				d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				totalMoney+=tempCount;
			}
			resList.add(d);
		}
		//添加合计 (万元)
		BaseDesignConsideration bdc=new BaseDesignConsideration();
		//标识正常的数据1，合计统计数据2和最终报价统计数据3
		bdc.setJobMix(2);
		bdc.setMainDesignAreaName("总计：");
		bdc.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(totalMoney));
		bdc.setMoneySum(StaticMethod.formatComma4BigDecimal(outTotalMoney));
		resList.add(bdc);
		return resList;
	}
	/**
	 * 根据项目infoCode projectCode 查询拆分价数据 (查看)
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getCheckDesignConsiderationList(Map<String, Object> result) throws SQLException {
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");
		OutQuotation out=new OutQuotation();
		out.setConditionInfoCode("=", infoCode);
		out.setConditionQuotationStatus("=", 1);
		BaseOutQuotation baseOut=out.executeQueryOneRow();
		int outQuotationId=baseOut.getOutQuotationId();
		DesignConsideration descDao = new DesignConsideration();
		descDao.setConditionOutQuotationId("=",outQuotationId);
		descDao.setConditionInfoCode("=", infoCode);
		List<BaseDesignConsideration> ds = descDao.conditionalLoad(" order by order_num");
		
		//遍历
		double totalMoney=0,outTotalMoney=0;
		List<BaseDesignConsideration> resList = new ArrayList<>();
		for(BaseDesignConsideration d:ds){
			//标识正常的数据1，合计统计数据2和最终报价统计数据3
			d.setJobMix(1);
			
			//单位换算为万元的字段
			double sumMoney=d.getMoneySum().doubleValue();
			if(sumMoney>0){
				//统计报价单
				double tempCount=sumMoney;
				d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				outTotalMoney+=tempCount;
			}
			double interiorSumMoney=d.getInteriorMoneySum().doubleValue();
			if(interiorSumMoney>0){
				double tempCount=interiorSumMoney;
				d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				totalMoney+=tempCount;
			}
			resList.add(d);
		}
		//添加合计 (万元)
		BaseDesignConsideration bdc=new BaseDesignConsideration();
		//标识正常的数据1，合计统计数据2和最终报价统计数据3
		bdc.setJobMix(2);
		bdc.setMainDesignAreaName("总计：");
		bdc.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(totalMoney));
		bdc.setMoneySum(StaticMethod.formatComma4BigDecimal(outTotalMoney));
		resList.add(bdc);
		
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, getCountMoney(infoCode, projectCode,outQuotationId));
	}
	/**
	 * 根据项目infoCode projectCode 查询拆分价数据
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getDesignConsiderationList(Map<String, Object> result) throws SQLException {
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");
		OutQuotation out=new OutQuotation();
		out.setConditionInfoCode("=", infoCode);
		out.setConditionQuotationStatus("=", 1);
		BaseOutQuotation baseOut=out.executeQueryOneRow();
		int outQuotationId=baseOut.getOutQuotationId();
		
		DesignConsideration descDao = new DesignConsideration();
		descDao.setConditionOutQuotationId("=",outQuotationId);
		List<BaseDesignConsideration> ds = descDao.conditionalLoad(" order by order_num");
		
		//遍历
		double totalMoney=0,outTotalMoney=0,totalSplitPrice=0;
		List<BaseDesignConsideration> resList = new ArrayList<>();
		for(BaseDesignConsideration d:ds){
			//标识正常的数据1，合计统计数据2和最终报价统计数据3
			d.setJobMix(1);
			
			//单位换算为万元的字段
			double sumMoney=d.getMoneySum().doubleValue();
			if(sumMoney>0){
				//统计报价单
				double tempCount=sumMoney;
				d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				outTotalMoney+=tempCount;
			}
			double interiorSumMoney=d.getInteriorMoneySum().doubleValue();
			if(interiorSumMoney>0){
				double tempCount=interiorSumMoney;
				d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				totalMoney+=tempCount;
			}
			//拆分价
			double splitPrice=BaseHelpUtils.getDoubleValue(d.getSplitPrice());
			if(splitPrice>0){
				double tempCount=splitPrice;
				d.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				if(d.getParentId()==0){
					totalSplitPrice+=tempCount;
				}
			}
			
			resList.add(d);
		}
		//添加合计 (万元)
//		BaseDesignConsideration bdc=new BaseDesignConsideration();
		//标识正常的数据1，合计统计数据2和最终报价统计数据3
//		bdc.setJobMix(2);
//		bdc.setParentId(0);
//		bdc.setMainDesignAreaName("总计：");
//		bdc.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(totalMoney));
//		bdc.setMoneySum(StaticMethod.formatComma4BigDecimal(outTotalMoney));
//		bdc.setSplitPrice(StaticMethod.formatComma4BigDecimal(totalSplitPrice));
//		resList.add(bdc);
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, getCountMoney(infoCode, projectCode,outQuotationId));
	}
	/**
	 * 修改或保存拆分价数据
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */

	private String saveOrUpdateDesignConsideration(String json) throws Exception {
		BaseDesignConsideration bean = new BaseDesignConsideration();
		bean.setDataFromJSON(json);
		bean.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(bean.getInteriorMoneySum())));
		bean.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(bean.getMoneySum())));
		bean.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(bean.getSplitPrice())));
		OutQuotation o=new OutQuotation();
		o.setConditionInfoCode("=", bean.getInfoCode());
		o.setConditionQuotationStatus("=", 1);
		BaseOutQuotation bout=o.executeQueryOneRow();
		bean.setOutQuotationId(bout.getOutQuotationId());//成功报价单id
		
		DesignConsideration dao = new DesignConsideration();
		dao.setDataFromBase(bean);
		int num = 0;
		ThreadConnection.beginTransaction();
		if (dao.isPrimaryKeyNull()) {
			//判断orderNum>0
			if(BaseHelpUtils.getIntValue(dao.getOrderNum())>0){
				//传过来的orderNum 都++
				DesignConsideration b=new DesignConsideration();
				b.setConditionOutQuotationId("=", dao.getOutQuotationId());
				if(BaseHelpUtils.getIntValue(dao.getOnSiteTime())==1){//向下
					b.setConditionOrderNum(">", dao.getOrderNum());
				}else{
					b.setConditionOrderNum(">=", dao.getOrderNum());
				}
				
				b.setConditionInfoCode("=", dao.getInfoCode());
				List<BaseDesignConsideration> l=b.conditionalLoad();
				if(l.size()>0){
					for(BaseDesignConsideration based:l){
						b.clear();
						b.setOrderNum(based.getOrderNum()+1);
						b.setConditionDesignConsiderationId("=", based.getDesignConsiderationId());
						b.conditionalUpdate();
					}
				}
				//当上向下添加需要将当前的orderNum++
				if(BaseHelpUtils.getIntValue(dao.getOnSiteTime())==1){
					dao.setOrderNum(dao.getOrderNum()+1);
				}
				num = dao.save();
			}else{
				num = dao.save();
				dao.setOrderNum(dao.getDesignConsiderationId());
				dao.update();
			}
			
		} else if (dao.load()) {
			dao.setDataFromBase(bean);
			num = dao.update();
		}
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}
	 
	/**
     * 统计业务类别的金额
     * @param result
     * @return
     * @throws SQLException
     */
      
    private String getCountMoney(String infoCode,String projectCode,int outQuotationId) throws SQLException{
    	StringBuilder resStr=new StringBuilder();
    	
    	Map<Integer,Double> resultMap=new HashMap<>();
    	//有多少个业务类型
    	Map<Integer,Integer> typeMap=new HashMap<>();
    	Map<Integer,BaseDesignConsideration> tempResultMap=new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(infoCode)){
    		DesignConsideration dao = new DesignConsideration();
    		dao.setConditionOutQuotationId("=", outQuotationId);
    		dao.setConditionInfoCode("=", infoCode);
//    		dao.setConditionProjectCode("=", projectCode);
        	List<BaseDesignConsideration> ds = dao.conditionalLoad();
        	//计算每一行的金额总价
        	if(ds.size()>0){
        		for(BaseDesignConsideration baseDes:ds){
            		//业务类型
            		int businessType=BaseHelpUtils.getIntValue(baseDes.getBusinessType());
            		//设计面积*设计单价的金额
            		double designMoney=BaseHelpUtils.getDoubleValue(baseDes.getMoneySum());
            		//配合金额
            		double withAmountMoney=BaseHelpUtils.getDoubleValue(baseDes.getWithTheAmount());
            		//驻场金额
            		double onSiteTotalMoney=BaseHelpUtils.getDoubleValue(baseDes.getOnSiteTotalMoney());
            		//统计金额
            		double tempSunMoney=designMoney+withAmountMoney+onSiteTotalMoney;
            		baseDes.setMoneySum(new java.math.BigDecimal(tempSunMoney));
            		tempResultMap.put(baseDes.getDesignConsiderationId(), baseDes);
            		typeMap.put(baseDes.getBusinessType(), baseDes.getBusinessType());
            	}
        	}
        	
        	
        	
        	//各个业务类型总金额
        	if(typeMap.size()>0){
        		for (Entry<Integer, Integer> entry : typeMap.entrySet()) {
        			double tempMoney=0;
        			if(tempResultMap.size()>0){
        				for (Entry<Integer, BaseDesignConsideration> entry1 : tempResultMap.entrySet()) {
        					BaseDesignConsideration b=entry1.getValue();
        	             	  if(b.getBusinessType()==entry.getKey()){
        	             		 tempMoney+=BaseHelpUtils.getDoubleValue((b.getMoneySum()).stripTrailingZeros().toPlainString());
                     			 
        	             	  }
        				}
        			}
        			resultMap.put(entry.getKey(), tempMoney);
            	}
        	}
        	double tempSum=0;
        	//遍历resultMap
        	for (Map.Entry<Integer,Double> entry : resultMap.entrySet()) {
  			   String tempValue=CustomOutDesigneConsiderationHandler.getSysYWTypeList(entry.getKey());
  			   resStr.append(BaseHelpUtils.isNullOrEmpty(tempValue)?"0":tempValue);
  			   resStr.append(" : ");
  			   tempSum+=entry.getValue();
  			   resStr.append(StaticMethod.getDouble4Value(entry.getValue()));
        	}
        	resStr.append("合计:");
        	resStr.append(StaticMethod.getDouble4Value(tempSum));
    	}
    	return BaseHelpUtils.getString(resStr);
    }
    
    /**
     * 序列号转换
     * @param serialyNumber
     * @return
     */
    public static String getSerialyNumberCh(int serialyNumber){
    	String serialyNumberCh ="";
    	switch (serialyNumber) {
		case 1:
			serialyNumberCh = "一";
			break;
		case 2:
			serialyNumberCh = "二";
			break;
		case 3:
			serialyNumberCh = "三";
			break;
		case 4:
			serialyNumberCh = "四";
			break;
		case 5:
			serialyNumberCh = "五";
			break;
		case 6:
			serialyNumberCh = "六";
			break;
		case 7:
			serialyNumberCh = "七";
			break;
		case 8:
			serialyNumberCh = "八";
			break;
		case 9:
			serialyNumberCh = "九";
			break;
		case 10:
			serialyNumberCh = "十";
			break;
		default:
			break;
		}
    	return serialyNumberCh;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			Map<String, Object> result = null;
			if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
				@SuppressWarnings("rawtypes")
				JSON parser = new JSON(new StringReader(creteria));
				result = (Map<String, Object>) parser.parse(new BasicHandler());
			}
			String infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
			OutQuotation o=new OutQuotation();
			o.setConditionInfoCode("=", infoCode);
			o.setConditionQuotationStatus("=", 1);
			BaseOutQuotation baseout=o.executeQueryOneRow();
			
			int outQuotationId = BaseHelpUtils.getIntValue(baseout.getOutQuotationId());
			if(outQuotationId > 0){
				List<BaseDesignConsideration> list=getReturnDesignConsiderationList(outQuotationId);
				try(PrintStream ps = new PrintStream(downFile, "GBK")){
					ps.println(CustomBaseDesignConsideration.ALL_CAPTIONS);
					for (BaseDesignConsideration b : list) {
						CustomBaseDesignConsideration bb = new CustomBaseDesignConsideration();
						bb.getDataFromFather(b);
						ps.println(bb.toCSVString());
					}
				}
			}
		
	}
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}
