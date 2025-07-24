package pomplatform.contract.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.bean.BaseSubContractRemark;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.dao.SubContractRemark;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.bean.BaseSubContractInfo;
import pomplatform.outQuotations.bean.BaseOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.bean.ConditionOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.query.QueryOnLoadMainProjectBusinessTypeByContract;
import pomplatform.subContractInfo.bean.BaseOnLoadSubContractRemark;
import pomplatform.subContractInfo.bean.ConditionOnLoadSubContractRemark;
import pomplatform.subContractInfo.query.QueryOnLoadSubContractRemark;
/**
 * 
 * @Title: CustomSubContractHandler.java 
 * @Package pomplatform.contract.handler 
 * @Description: 报价单与子合同信息查询处理
 * @author CL  
 * @date 2016年9月19日
 */
public class CustomSubContractHandler implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger(CustomSubContractHandler.class);
    /**
     * 添加ALL订单的备注
     */
    private static final String SAVE_CONTENT_INFO="saveContentInfo";
    
    private static final String GET_SUB_CONTRACT = "getSubContract";//根据主合同信息获取子合同信息
    
    private static final String GET_CONSIDERATIONS_BY_CTR ="getConsiderationsByCtr";//根据子合同获取报价单信息
    
    private static final String UPDATE_SUB_CONTART= "updateChildContart";//修改子合同
    
    private static final String GET_CONSIDER_BY_CONTRACT = "getConsiderByContract";//根据主合同与子合同主键获取拆分价信息
    
    private static final String ADD_SUB_CONTRACT = "addSubContract";//添加子合同
    
    private static final String DELETE_SUB_CONTRACT = "delelteSubContract";//删除子合同
    
    private static final String ADD_PROJECT_MANAGE_SUB_CONTRACT="addProjectManageSubContract";//新增项目管理费的子合同
    
    private static final String CONSIDERATE_BIND_SUBCONTRACT = "considerateBindSubcontract";//拆分价绑定子合同
    
    private static final String CHANGE_SUB_CONTRACT_CODE = "changeSubContractCode";//修改订单编号(项目管理费，物料费)
    
    private static final String ON_CREATE_RESERVE_SHEET = "onCreateReserveSheet";//创建部门预留订单
    
    private static final String ON_UPDATE_RESERVE_SHEET = "onUpdateReserveSheet";//更新部门预留订单
    
    private static final String ON_ADD_RESERVE_SHEET = "onAddReserveSheet";//追加绑定部门预留订单
    
    private static final String ON_CANCEL_RESERVE_SHEET = "onCancelReserveSheet";//取消绑定部门预留订单
    
    private static final String ON_LOAD_MAIN_PROJECT_BUSINESS_TYPE_BY_CONTRACT= "onLoadMainProjectBusinessTypeByContract";//根据主合同与子合同主键  获取项目信息（main_project_business_types）
    
    private static final String ADD_SUB_CONTRACT_BY_MAIN_PROJECT_BUSINESS_TYPE= "addSubContractByMainProjectBusinessType";//  获取项目信息（main_project_business_types）
   
    private static final String ON_LOAD_SUB_CONTRACT_REMARK= "onLoadSubContractRemark";//  加载备注
    
    private static final String CAL_MONTY_SUM_AND_SHEET_INTEGRAL= "calMoneySumAndSheetIntegral";//子订单占比计算合同金额和产值
    
	
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
        if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType))
			switch (optType) {
    		case GET_CONSIDERATIONS_BY_CTR:
    			return getConsiderationsByCtr(result);
    		case GET_SUB_CONTRACT:
        		return getSubContract(result);
    		case UPDATE_SUB_CONTART:
    			return updateChildContart(creteria, result);
    		case GET_CONSIDER_BY_CONTRACT:
    			return getConsiderByContract(result);
    		case ADD_SUB_CONTRACT:
    			return addSubContract(result);
    		case DELETE_SUB_CONTRACT:
    			return delelteSubContract(result);
    		case ADD_PROJECT_MANAGE_SUB_CONTRACT:
    			return addProjectManageSubContract(result);
    		case SAVE_CONTENT_INFO:
    			return saveContentInfo(result);
    		case CONSIDERATE_BIND_SUBCONTRACT:
    			return considerateBindSubcontract(result);
    		case CHANGE_SUB_CONTRACT_CODE:
    			return changeSubContractCode(creteria,result);
    		case ON_CREATE_RESERVE_SHEET:
    			return onCreateReserveSheet(result);
    		case ON_UPDATE_RESERVE_SHEET:
    			return onUpdateReserveSheet(result);
    		case ON_ADD_RESERVE_SHEET:
    			return onAddReserveSheet(result);
    		case ON_CANCEL_RESERVE_SHEET:
    			return onCancelReserveSheet(result);
    		case ON_LOAD_MAIN_PROJECT_BUSINESS_TYPE_BY_CONTRACT:
    			return onLoadMainProjectBusinessTypeByContract(result);
    		case ADD_SUB_CONTRACT_BY_MAIN_PROJECT_BUSINESS_TYPE:
    			return addSubContractByMainProjectBusinessType(result);
    		case ON_LOAD_SUB_CONTRACT_REMARK:
    			return onLoadSubContractRemark(result);
    		case CAL_MONTY_SUM_AND_SHEET_INTEGRAL:
    			return calMoneySumAndSheetIntegral(result);
    		}
    	return null;
    }
    
    
    
    
    /**
     *
     * @param result
     * @return
     * @throws Exception 
     */
	private String calMoneySumAndSheetIntegral(Map<String, Object> result) throws Exception {
		
		int status = 1;
		String msg ="";
		List<BaseSubContract> ds  = new ArrayList<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		int subContractId = BaseHelpUtils.getIntValue(result, "subContractId");
		if(contractId<=0||subContractId<=0) {
			status = -1;
			msg="请选择一条数据";
		}else {
			SubContract sbDao = new SubContract();
			sbDao.setConditionParentId("=", contractId);
			sbDao.setConditionSubContractId("!=", subContractId);
			String con = String.format("project_type not in(%1$s,%2$s,%3$s) order by sub_contract_id",StaticUtils.PROJECT_TYPE_16, StaticUtils.PROJECT_TYPE_30, StaticUtils.PROJECT_TYPE_27);
			ds = sbDao.conditionalLoad(con);
		}
		BaseCollection<BaseSubContract> collection = new BaseCollection<>();
		collection.setCollections(ds);
		return collection.toJSON(status, msg);
	}
    
    
	/**
	 *
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String onLoadSubContractRemark(Map<String, Object> result) throws SQLException{
		
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		QueryOnLoadSubContractRemark query =new QueryOnLoadSubContractRemark();
		ConditionOnLoadSubContractRemark condition =new ConditionOnLoadSubContractRemark();
		condition.setContractId(contractId);
		BaseCollection<BaseOnLoadSubContractRemark> collection = query.execute(null, condition);
		return collection.toJSON(0,"");
	}
    
    
    /**
     * 根据主合同获取项目信息 （原拆分价列表）（main_project_business_types）
     * @param result
     * @return
     * @throws SQLException
     */
    private String addSubContractByMainProjectBusinessType(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String msg = "";
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		int mainProjectId = BaseHelpUtils.getIntValue(result, "mainProjectId");
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		if(contractId<=0||outQuotationId<=0||mainProjectId<=0){
			status = -1 ;
			msg="";
		}else{
			Contract mainDao = new Contract();
			mainDao.setContractId(contractId);
			if(mainDao.load()){
				String projectCode = mainDao.getProjectCode();
				BigDecimal allDesignArea = BigDecimal.ZERO;//总设计面积
				BigDecimal allMoneySum = BigDecimal.ZERO;
				double splitPriceSum =0;//合同总价
				
				BigDecimal allServiceArea = BigDecimal.ZERO;//服务总面积
				BigDecimal allSiteTotalMoney = BigDecimal.ZERO;//总驻场金额
				BigDecimal allWithAmountMoney = BigDecimal.ZERO;//总配合金额
				BigDecimal allCommonArea = BigDecimal.ZERO;//总公区面积
				BigDecimal logisticsArea = BigDecimal.ZERO;//总后勤面积
				//创建子合同
				SubContract subDao = new SubContract();
				BaseSubContract subBean = new BaseSubContract();
				if(allDesignArea.compareTo(BigDecimal.ZERO) >= 0)
					subBean.setDesignArea(allDesignArea);
				
				if(allServiceArea.compareTo(BigDecimal.ZERO) >= 0)
					subBean.setLogisticsArea(allServiceArea);
				if(logisticsArea.compareTo(BigDecimal.ZERO) >= 0)
					subBean.setLogisticsArea(logisticsArea);
				//当总驻场金额大于0时  加入设计总金额
				if(allSiteTotalMoney.compareTo(BigDecimal.ZERO) >= 0)
					allMoneySum = allMoneySum.add(allSiteTotalMoney);
				//当配合总金额大于0时  加入设计总金额
				if(allWithAmountMoney.compareTo(BigDecimal.ZERO) >= 0)
					allMoneySum = allMoneySum.add(allWithAmountMoney);
				//子合同总金额 = 拆分价设计总金额 + 拆分价驻场总金额 + 拆分价配合总金额
				if(splitPriceSum> 0)
					//					subBean.setMoneySum(allMoneySum);
					subBean.setMoneySum(StaticMethod.formatComma4BigDecimal(splitPriceSum));
				String mainName = mainDao.getContractName();
				subBean.setProjectType(0);
				subBean.setBusinessType(0);
				subBean.setParentId(contractId);
				subBean.setProjectCode(projectCode);
				//创建子合同名称
				String subName = createSubName(subBean, mainName);
				subBean.setSubContractName(subName);
				Date currentDate = new Date();
				subDao.setDataFromBase(subBean);
				subDao.setSheetTotalIntegral(BigDecimal.ZERO);
				subDao.setSheetIntegral(BigDecimal.ZERO);
				subDao.setComplaintPercentage(BigDecimal.ZERO);
				subDao.setComplaintIntegral(BigDecimal.ZERO);
				subDao.setCreateTime(currentDate);
				subDao.save();
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
    	return bc.toJSON(status, msg);
	}
    
	
	/**
	 * 根据主合同获取项目信息 （原拆分价列表）（main_project_business_types）
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String onLoadMainProjectBusinessTypeByContract(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(BaseHelpUtils.isNullOrZero(contractId))
			throw new SQLException("操作异常：没有获取到合同编码");
		Contract dao = new Contract();
		dao.setContractId(contractId);
		if(dao.load()){
			//判断当前合同是否存在
			QueryOnLoadMainProjectBusinessTypeByContract query =new QueryOnLoadMainProjectBusinessTypeByContract();
			ConditionOnLoadMainProjectBusinessTypeByContract condition =new ConditionOnLoadMainProjectBusinessTypeByContract();
			condition.setContractId(contractId);
			condition.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_2);
			BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> execute = query.execute(null, condition);
			if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
				List<BaseOnLoadMainProjectBusinessTypeByContract> list = execute.getCollections();
				
				BigDecimal outputValueSum = list.get(0).getOutputValueSum();
				//如果产值等于0 则表示，已经全部拆分成子订单了，那么项目信息列表则不显示数据
				if(outputValueSum.compareTo(BigDecimal.ZERO)<=0) {
					list=new ArrayList<>();
				}
				
				bc.setCollections(list);
				
			}
		} else
			throw new SQLException("操作异常：没有找到到合同,合同id="+contractId);
		ThreadConnection.commit();
		return bc.toJSON(0,"");
	}
	
	/**
	 * 取消绑定部门预留订单
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String onCancelReserveSheet(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int subContractId = BaseHelpUtils.getIntValue(result, "subContractId");
		if(BaseHelpUtils.isNullOrZero(subContractId))
			throw new SQLException("操作异常：没有获取到子合同编码");
		SubContract subDao = new SubContract();
		subDao.setSubContractId(subContractId);
		if(subDao.load()){
			//判断当前订单是否已下达，如果已下达，则不可撤销
			boolean isHistory = BaseHelpUtils.getBoolean(subDao.getIsHistory());
			if(isHistory)
				throw new SQLException("操作异常：该部门预留订单已下达，不可进行撤销操作");
			subDao.delete();
			//更新关联表
			subDao.clear();
			subDao.setConditionReserveSheetId("=",subContractId);
			if(subDao.isExist()){
				subDao.setReserveSheetId(0);
				subDao.conditionalUpdate();
			}
		} else
			throw new SQLException("操作异常：没有找到到子合同,子合同id="+subContractId);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}
	
	/**
	 * 追加绑定部门预留订单
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String onAddReserveSheet(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int subContractId = BaseHelpUtils.getIntValue(result, "subContractId");
		if(BaseHelpUtils.isNullOrZero(subContractId))
			throw new SQLException("操作异常：没有获取到子合同编码");
		SubContract subDao = new SubContract();
		subDao.setSubContractId(subContractId);
		if(subDao.load()){
			String ids = BaseHelpUtils.getStringValue(result, "ids");
			if(BaseHelpUtils.isNullOrEmpty(ids))
				throw new SQLException("操作异常：没有获取绑定的子订单数据集");
			String[] idsArr = ids.split(",");
			for(String id : idsArr){
				subDao.clear();
				subDao.setSubContractId(BaseHelpUtils.getIntValue(id));
				if(subDao.load()){
					subDao.setReserveSheetId(subContractId);
					subDao.update();
				}
			}
		} else
			throw new SQLException("操作异常：没有找到到子合同,子合同id="+subContractId);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}
	
	/**
	 * 更新部门预留订单
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String onUpdateReserveSheet(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int subContractId = BaseHelpUtils.getIntValue(result, "subContractId");
		if(BaseHelpUtils.isNullOrZero(subContractId))
			throw new SQLException("操作异常：没有获取到子合同编码");
		SubContract subDao = new SubContract();
		subDao.setSubContractId(subContractId);
		if(subDao.load()){
			BaseSubContract subBean = new BaseSubContract();
			subBean.setDataFromMap(result);
			//获取业务类别
			int businessType = BaseHelpUtils.getIntValue(result, "businessType");
			if(businessType > 0){
				int contractId = subDao.getParentId();
				//生成订单编号
				subBean.setDepartmentId(subDao.getDepartmentId());
				subBean.setProjectType(subDao.getProjectType());
				subBean.setParentId(contractId);
				String sheetCode = createSubCode(subBean);
				subBean.setSubContractCode(sheetCode);
				Contract dao = new Contract();
				dao.setContractId(contractId);
				if(dao.load()){
					//创建子合同名称
					String subName = createSubName(subBean, dao.getContractName());
					subBean.setSubContractName(subName);
				}
			}
			subDao.setDataFromBase(subBean);
			subDao.update();
		} else
			throw new SQLException("操作异常：没有找到到子合同,子合同id="+subContractId);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}
	
	/**
	 * 创建部门预留订单
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String onCreateReserveSheet(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(BaseHelpUtils.isNullOrZero(contractId))
			throw new SQLException("操作异常：没有获取到合同编码");
		//获取业务部门Id
		int plateId = BaseHelpUtils.getIntValue(result, "plateId");
		//获取关联订单Id数据集
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		if(BaseHelpUtils.isNullOrEmpty(ids))
			throw new SQLException("操作异常：没有获取绑定的子订单数据集");
		List<BaseSubContract> resulist = null;
		//获取合同的name
		Contract c=new Contract();
		c.unsetSelectFlags();
		c.setSelectContractCode(true);
		c.setSelectContractName(true);
		c.setSelectProjectCode(true);
		c.setContractId(contractId);
		if(c.load()){
			SubContract subDao = new SubContract();
			//加载当前业务部门是否有部门预留的单子
			subDao.setConditionProjectType("=",StaticUtils.PROJECT_TYPE_27);
			subDao.setConditionParentId("=", contractId);
			subDao.setConditionDepartmentId("=",plateId);
			String mainName = c.getContractName();
			BaseSubContract subBean = null;
			Date currentDate = new Date();
			if(subDao.countRows() == 0){
				subBean = new BaseSubContract();
				subBean.setProjectType(StaticUtils.PROJECT_TYPE_27);//物料
				subBean.setDepartmentId(plateId);//承接部门
				subBean.setComplaintPercentage(BigDecimal.ZERO);//保证金比例0
				subBean.setParentId(contractId);
				subBean.setProjectCode(c.getProjectCode());
				//创建子合同名称
				String subName = createSubName(subBean, mainName);
				subBean.setSubContractName(subName);
				subBean.setCreateTime(currentDate);
				subBean.setCommonArea(BigDecimal.ZERO);
				subBean.setLogisticsArea(BigDecimal.ZERO);
				subBean.setMoneySum(BigDecimal.ZERO);
				subBean.setIsAuto(Boolean.TRUE);
				subDao.setDataFromBase(subBean);
				subDao.save();
				int businessId = subDao.getSubContractId();
				//更新关联订单
				String[] idsArr = ids.split(",");
				if(!BaseHelpUtils.isNullOrEmpty(idsArr) && idsArr.length > 0)
					for(String id : idsArr){
						subDao.clear();
						subDao.setSubContractId(BaseHelpUtils.getIntValue(id));
						if(subDao.load()){
							subDao.setReserveSheetId(businessId);
							subDao.update();
						}
					}
			} else
				throw new SQLException("操作异常：该部门下已有部门预留订单");
			subDao.clear();
			subDao.setConditionParentId("=",contractId);
			subDao.setConditionProjectType("=",StaticUtils.PROJECT_TYPE_27);
			resulist = subDao.conditionalLoad("order by sub_contract_id");
		} else
			throw new SQLException("操作异常：没有找到到合同,合同id="+contractId);
		ThreadConnection.commit();
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
		bc.setCollections(resulist);
    	return bc.toJSON(0,"");
	}
	
	
	public static void main(String[] args) throws Exception {
//		 {"subContractId":4890,"parentId":2049,"subContractCode":"KB.2019-021B-03","projectCode":"KB.2019-021B","businessType":1,"projectType":16,"departmentId":6,"commonArea":0,"logisticsArea":0,"moneySum":0,"createTime":1574683026357,"subContractName":"(项目管理)测试20191125","orderNo":0,"sheetTotalIntegral":50,"complaintIntegral":0,"sheetIntegral":0,"complaintPercentage":0,"agreeDate":1574611200000,"businessStateRecordId":0,"projectManageId":13,"isHistory":true,"isAuto":true,"reserveSheetId":0,"businessLine":0,"opt_type":"changeSubContractCode"}
		CustomSubContractHandler a =new CustomSubContractHandler();
		 Map<String, Object> result = new HashMap<>();
		 result.put("subContractId", 4890);
		 result.put("projectManageId", 13);
		 result.put("isHistory", true);
		 a.changeSubContractCode("",result);
	}
	
	
	/**
	 * 修改订单编号(项目管理费，物料费)
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	private  String changeSubContractCode(String creteria,Map<String, Object> result) throws Exception {
		BaseSubContract bean = new BaseSubContract();
		List<BaseSubContract> list = new ArrayList<>();
		bean.setDataFromMap(result);
		Integer projectManageId =BaseHelpUtils.getIntValue(bean.getProjectManageId());
		if(projectManageId>0) {//说明有更新项目经理，那么承接部门也要一起更新
			Employee eDao =new Employee();
			eDao.setConditionEmployeeId("=", projectManageId);
			eDao.setEmployeeId(projectManageId);
			if(eDao.load()) {
				Integer departmentId = eDao.getDepartmentId();
				bean.setDepartmentId(departmentId);
			}
		}else {
			bean.setDepartmentId(0);
		}
		
		String subContractCode = "";
		SubContract dao = new SubContract();
		if(null != bean.getSubContractId() && bean.getSubContractId() > 0){
			dao.setSubContractId(bean.getSubContractId());
			if (dao.load()) {
				if(dao.getIsHistory()){
					dao.setSheetTotalIntegral(bean.getSheetTotalIntegral());
            		dao.setSheetIntegral(bean.getSheetIntegral());
//            		dao.setCommonArea(bean.getCommonArea());
//            		dao.setDesignArea(bean.getDesignArea());
//            		dao.setLogisticsArea(bean.getLogisticsArea());
            		dao.setMoneySum(bean.getMoneySum());
            		dao.setComplaintIntegral(bean.getComplaintIntegral());
				} else if(!BaseHelpUtils.isNullOrZero(bean.getDepartmentId())){
					if (!Objects.equals(dao.getDepartmentId(), bean.getDepartmentId())) {
						String subCode = createSubCode(bean);
						bean.setSubContractCode(subCode);
					}
					dao.setDataFromBase(bean);
				}
				dao.update();
	        }
		}else{
			dao.setDataFromBase(bean);
			if(!BaseHelpUtils.isNullOrEmpty(bean.getDepartmentId())){
				subContractCode = createSubCode(bean);
				dao.setSubContractCode(subContractCode);
				dao.update();
			}
		}
		
		BaseSubContract generateBase = dao.generateBase();
		Integer parentId = generateBase.getParentId();
		dao.clear();
		dao.setConditionParentId("=", parentId);
		dao.setConditionProjectType("=", 16);
		dao.setConditionSheetTotalIntegral(">", BigDecimal.ZERO);
		List<BaseSubContract> conditionalLoad = dao.conditionalLoad();
		if(conditionalLoad.size()>0) {
			BigDecimal sheetTotalIntegralSum = BigDecimal.ZERO;//总积分
			for (BaseSubContract baseSubContract : conditionalLoad) {
				 sheetTotalIntegralSum = sheetTotalIntegralSum.add(BaseHelpUtils.getBigDecimalValue(baseSubContract.getSheetTotalIntegral()));
			}
			
			BigDecimal percentSum =BigDecimal.ZERO;
			for (int i = 0; i < conditionalLoad.size(); i++) {
				BaseSubContract baseSubContract = conditionalLoad.get(i);
				if(i==(conditionalLoad.size()-1)) {
					BigDecimal bigDecimal = new BigDecimal(100);
					baseSubContract.setPercentage(bigDecimal.subtract(percentSum));
				}else {
					BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseSubContract.getSheetTotalIntegral());
					BigDecimal percent = bigDecimalValue.divide(sheetTotalIntegralSum,4,BigDecimal.ROUND_HALF_DOWN);
					percentSum =percentSum.add(percent.multiply(new BigDecimal(100)));
					baseSubContract.setPercentage(percent.multiply(new BigDecimal(100)));
				}
				dao.clear();
				dao.setDataFromBase(baseSubContract);
				dao.update();
			}
		}
		
		dao.clear();
		dao.setConditionParentId("=", parentId);
		dao.setConditionProjectType("=", 16);
		dao.setConditionSheetTotalIntegral("<=", BigDecimal.ZERO);
		List<BaseSubContract> conditionalLoad2 = dao.conditionalLoad();
		if(conditionalLoad2.size()>0) {
			for (BaseSubContract baseSubContract : conditionalLoad2) {
				baseSubContract.setPercentage(BigDecimal.ZERO);
				dao.clear();
				dao.setDataFromBase(baseSubContract);
				dao.update();
			}
		}
		
		list.addAll(conditionalLoad);
		list.addAll(conditionalLoad2);
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON();
	}
	/**
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String saveContentInfo(Map<String, Object> result) throws SQLException{
		Integer contractId=BaseHelpUtils.getIntValue(result, "contractId");
		String contentInfo=BaseHelpUtils.getStringValue(result, "contentInfo");
		int attachmentId=BaseHelpUtils.getIntValue(result, "attachmentId");//file_id
		String attachment=BaseHelpUtils.getStringValue(result, "attachment");//file_url
		
		BaseCollection<BaseSubContractRemark> bc = new BaseCollection<>();
		Contract dao =new Contract();
		BaseContract contract =new BaseContract();
		SubContractRemark sc=new SubContractRemark();
		BaseSubContractRemark baseSC=new BaseSubContractRemark();
		BaseSubContractRemark tmp=new BaseSubContractRemark();
		//处理一下contentInfo中的/r/n
		if(!BaseHelpUtils.isNullOrEmpty(result.get("contentInfo"))){
			result.put("contentInfo", StaticMethod.getReplaceAll(result.get("contentInfo")+""));
			baseSC.setDataFromMap(result);
		}
		
		int res=-1;
		dao.setConditionContractId("=", contractId);
		dao.setContractId(contractId);
		contract = dao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(contract)){
			if(/*!BaseHelpUtils.isNullOrEmpty(attachmentId)&&*/!BaseHelpUtils.isNullOrEmpty(attachment)) {
				dao.setFileId(attachmentId);
				dao.setFileUrl(attachment);
				dao.update();
			}
			
			sc.setConditionContractId("=", contractId);
			tmp=sc.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(tmp)){
				sc.setConditionContractId("=", contractId);
				baseSC=sc.executeQueryOneRow();
				baseSC.setContentInfo(contentInfo);
				sc.setDataFromBase(baseSC);
				res=1;
				sc.update();
			}else{
				sc.setDataFromBase(baseSC);
				res=sc.save();
			}
		}
		

		
		
		
		
		
		return bc.toJSON(res, "fail");
	}
	
	/**
	 * @throws Exception 
	 * 
	 * @Title: delelteSubContract 
	 * @Description: 删除子合同
	 * @param @param result
	 * @param @return
	 * @param @throws SQLException    
	 * @return String   
	 * @throws
	 */
	private String delelteSubContract(Map<String, Object> result) throws Exception{
		ThreadConnection.beginTransaction();
		int status = 1;
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		int subContratId = BaseHelpUtils.getIntValue(result, "subContractId");
		int type = BaseHelpUtils.getIntValue(result, "type");
		if(subContratId<=0||contractId<=0)
			status = -1;
		else if(type == 0){ //type = 0时 删除子订单   type = 1时只取消绑定
			SubContract subDao = new SubContract();
			subDao.setConditionSubContractId("=", subContratId);
			subDao.conditionalDelete();
			
		     //判断现在的子订单是否已经完全分配完了合同金额和产值
			List<BaseSubContractInfo> infoList = getSubContractInfoList(result);
			BigDecimal sheetTotalIntegral =BigDecimal.ZERO;
			BigDecimal moneySum =BigDecimal.ZERO;
			BigDecimal percentage =BigDecimal.ZERO;
			BigDecimal hundred =new BigDecimal(100);
			if(infoList.size()>0) {
				for (BaseSubContractInfo baseSubContractInfo : infoList) {
					 sheetTotalIntegral =sheetTotalIntegral.add( BaseHelpUtils.getBigDecimalValue(baseSubContractInfo.getSheetTotalIntegral()));
					 moneySum =moneySum .add(BaseHelpUtils.getBigDecimalValue(baseSubContractInfo.getMoneySum()));
					 percentage = percentage .add(BaseHelpUtils.getBigDecimalValue(baseSubContractInfo.getPercentage()));
				}
			}
			
			//获取合同金额和产值
			BaseOnLoadMainProjectBusinessTypeByContract base =new BaseOnLoadMainProjectBusinessTypeByContract();
			BigDecimal signingMoneySum =BigDecimal.ZERO;
			BigDecimal outputValueSum =BigDecimal.ZERO;
			int mainProjectId = 0 ;
			int outQuotationId = 0 ;
			QueryOnLoadMainProjectBusinessTypeByContract query =new QueryOnLoadMainProjectBusinessTypeByContract();
			ConditionOnLoadMainProjectBusinessTypeByContract condition =new ConditionOnLoadMainProjectBusinessTypeByContract();
			condition.setContractId(contractId);
//			condition.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_2);
			BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> execute = query.execute(null, condition);
			if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
				base = execute.getCollections().get(0);
				signingMoneySum  = BaseHelpUtils.getBigDecimalValue(base.getSigningMoneySum());
				outputValueSum = BaseHelpUtils.getBigDecimalValue(base.getOutputValueSum());
				mainProjectId=BaseHelpUtils.getIntValue(base.getMainProjectId());
				outQuotationId=BaseHelpUtils.getIntValue(base.getOutQuotationId());
			}
			
			if(percentage.compareTo(hundred)<0) {
				MainProjectBusinessType mDao = new MainProjectBusinessType();
				mDao.setConditionMainProjectId("=", mainProjectId);
				mDao.setConditionOutQuotationId("=", outQuotationId);
				mDao.setConditionStatus("=",StaticUtils.BUSINESS_TYPE_STATUS_3);//表示已拆分成子订单了
				mDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_2);//表示已拆分成子订单了
				mDao.conditionalUpdate();
			}
			
			
		}
		ThreadConnection.commit();
    	return bc.toJSON(status, "");
	}
	/**
	 * 添加项目管理费
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String addProjectManageSubContract(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		int status = 1;
		String errStr="";
		List<BaseSubContract> subList=new ArrayList<>();
		if(BaseHelpUtils.isNullOrZero(contractId)){
			status = -1 ;
			errStr="没有获取到合同id";
		}else{
			//获取合同的name
			Contract c=new Contract();
			c.unsetSelectFlags();
			c.setSelectContractCode(true);
			c.setSelectContractName(true);
			c.setSelectProjectCode(true);
			c.setContractId(contractId);
			if(c.load()){
    			List<BaseSubContract> paramList = GenericBase.__getList(result.get("twoSubContract"), BaseSubContract.newInstance());
				if (!BaseHelpUtils.isNullOrEmpty(paramList) && paramList.size() > 0) {
					SubContract subDao =new SubContract();
					Date currentDate =new Date(); 
					for (BaseSubContract e : paramList) {
						//如果项目管理费、采买成本和条线管理订单不存在则新增  存在则修改
							subDao.clear();
							if(null != e.getSubContractId() && e.getSubContractId() > 0){
								subDao.setSubContractId(e.getSubContractId());
								if(subDao.load()){
									subDao.setDataFromBase(e);
									subDao.update();
								}else{
									subDao.setDataFromBase(e);
									subDao.setCreateTime(currentDate);
									subDao.setParentId(contractId);
									subDao.save();
								}
							}else{
								subDao.setDataFromBase(e);
								subDao.setCreateTime(currentDate);
								subDao.setParentId(contractId);
								subDao.save();
							}
					}
				}
			}else{
				status = -1 ;
				errStr="没有找到到合同,合同id="+contractId;
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
		bc.setCollections(subList);
    	return bc.toJSON(status, errStr);
	}
	
	/**
	 * 
	 * @Title: considerateBindSubcontract 
	 * @Description: 拆分价绑定历史订单
	 * @param @param result
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	public String considerateBindSubcontract(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		int subContractId = BaseHelpUtils.getIntValue(result, "subContractId");
		if(BaseHelpUtils.isNullOrEmpty(ids) || BaseHelpUtils.isNullOrZero(contractId) || BaseHelpUtils.isNullOrZero(subContractId))
			status = -1 ;
		else{
			Contract mainDao = new Contract();
			mainDao.setContractId(contractId);
			//创建子合同
			SubContract subDao = new SubContract();
			subDao.setSubContractId(subContractId);
			if(mainDao.load() && subDao.load()){
				String projectCode = mainDao.getProjectCode();
				
				DesignConsideration dao = new DesignConsideration();
				List<BaseDesignConsideration> list= dao.conditionalLoad(" design_consideration_id in ("+ids+")");
				BigDecimal allDesignArea = BigDecimal.ZERO;//总设计面积
				BigDecimal allMoneySum = BigDecimal.ZERO;
				double splitPriceSum =0;//合同总价
				
				BigDecimal allServiceArea = BigDecimal.ZERO;//服务总面积
				BigDecimal allSiteTotalMoney = BigDecimal.ZERO;//总驻场金额
				BigDecimal allWithAmountMoney = BigDecimal.ZERO;//总配合金额
				BigDecimal allCommonArea = BigDecimal.ZERO;//总公区面积
				BigDecimal logisticsArea = BigDecimal.ZERO;//总后勤面积
				for (BaseDesignConsideration tmpBean : list) {
					BigDecimal designArea = tmpBean.getDesignArea();
					BigDecimal moneySum = tmpBean.getMoneySum();
					BigDecimal splitPrice = tmpBean.getSplitPrice();
					BigDecimal serviceArea = tmpBean.getServiceArea();
					BigDecimal siteTotalMoney = tmpBean.getOnSiteTotalMoney();
					BigDecimal withAmountMoney = tmpBean.getWithTheAmount();
					int decoStatus = null == tmpBean.getDecorationStatus() ? -1 : tmpBean.getDecorationStatus();
					if(null != designArea){
						if(decoStatus == -1)
							allDesignArea = allDesignArea.add(designArea);
						//精装设计面积为公区面积  简装为后勤面积
						if(decoStatus == StaticUtils.DECORATION_STATUS_0)
							allCommonArea = allCommonArea.add(designArea);
						else if(decoStatus == StaticUtils.DECORATION_STATUS_1)
							logisticsArea = logisticsArea.add(designArea);
					}
					
					if(null != splitPrice)
						splitPriceSum += BaseHelpUtils.getDoubleValue(splitPrice);
					if(null != moneySum)
						allMoneySum = allMoneySum.add(moneySum);
					if(null != serviceArea)
						allServiceArea = allServiceArea.add(serviceArea);
					if(null != siteTotalMoney)
						allSiteTotalMoney = allSiteTotalMoney.add(siteTotalMoney);
					if(null != withAmountMoney)
						allWithAmountMoney = allWithAmountMoney.add(withAmountMoney);
				}
				
				BaseSubContract subBean = new BaseSubContract();
				if(allDesignArea.compareTo(BigDecimal.ZERO) > 0)
					subBean.setDesignArea(allDesignArea);
				
				if(allServiceArea.compareTo(BigDecimal.ZERO) > 0)
					subBean.setLogisticsArea(allServiceArea);
				if(logisticsArea.compareTo(BigDecimal.ZERO) > 0)
					subBean.setLogisticsArea(logisticsArea);
				//当总驻场金额大于0时  加入设计总金额
				if(allSiteTotalMoney.compareTo(BigDecimal.ZERO) > 0)
					allMoneySum = allMoneySum.add(allSiteTotalMoney);
				//当配合总金额大于0时  加入设计总金额
				if(allWithAmountMoney.compareTo(BigDecimal.ZERO) > 0)
					allMoneySum = allMoneySum.add(allWithAmountMoney);
				//子合同总金额 = 拆分价设计总金额 + 拆分价驻场总金额 + 拆分价配合总金额
				if(splitPriceSum >= 0)
					//					subBean.setMoneySum(allMoneySum);
					subBean.setMoneySum(StaticMethod.formatComma4BigDecimal(splitPriceSum));
				subBean.setParentId(contractId);
				subBean.setProjectCode(projectCode);
				subDao.setDataFromBase(subBean);
				subDao.update();
				//将历史子订单拥有的拆分价解除绑定
				dao.clear();
				dao.setConditionSubContractId("=", subContractId);
				dao.setSubContractId(0);
				dao.setDisableType(0);
				dao.conditionalUpdate();
				//将拆分价与子合同想关联
				dao.clear();
				String[]  idsArr = ids.split(",");
				Object [] intIdsArr = new Object[idsArr.length];
				for (int i = 0; i < idsArr.length; i++)
					intIdsArr[i] = Integer.parseInt(idsArr[i]);
				
				dao.addCondition("design_consideration_id", "in", intIdsArr);
				dao.setDisableType(1);
				dao.setSubContractId(subContractId);
				dao.conditionalUpdate();
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
    	return bc.toJSON(status, "");
	}
	
	/**
	 * 
	 * @Title: addSubContract 
	 * @Description: 根据拆分价生成子合同
	 * @param @param result
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	private String addSubContract(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(BaseHelpUtils.isNullOrEmpty(ids) || BaseHelpUtils.isNullOrZero(contractId))
			status = -1 ;
		else{
			Contract mainDao = new Contract();
			mainDao.setContractId(contractId);
			if(mainDao.load()){
				String projectCode = mainDao.getProjectCode();
				
				DesignConsideration dao = new DesignConsideration();
				List<BaseDesignConsideration> list= dao.conditionalLoad(" design_consideration_id in ("+ids+")");
				BigDecimal allDesignArea = BigDecimal.ZERO;//总设计面积
				BigDecimal allMoneySum = BigDecimal.ZERO;
				double splitPriceSum =0;//合同总价
				
				BigDecimal allServiceArea = BigDecimal.ZERO;//服务总面积
				BigDecimal allSiteTotalMoney = BigDecimal.ZERO;//总驻场金额
				BigDecimal allWithAmountMoney = BigDecimal.ZERO;//总配合金额
				BigDecimal allCommonArea = BigDecimal.ZERO;//总公区面积
				BigDecimal logisticsArea = BigDecimal.ZERO;//总后勤面积
				for (BaseDesignConsideration tmpBean : list) {
					BigDecimal designArea = tmpBean.getDesignArea();
					BigDecimal moneySum = tmpBean.getMoneySum();
					BigDecimal splitPrice = tmpBean.getSplitPrice();
					BigDecimal serviceArea = tmpBean.getServiceArea();
					BigDecimal siteTotalMoney = tmpBean.getOnSiteTotalMoney();
					BigDecimal withAmountMoney = tmpBean.getWithTheAmount();
					int decoStatus = null == tmpBean.getDecorationStatus() ? -1 : tmpBean.getDecorationStatus();
					if(null != designArea){
						if(decoStatus == -1)
							allDesignArea = allDesignArea.add(designArea);
						//精装设计面积为公区面积  简装为后勤面积
						if(decoStatus == StaticUtils.DECORATION_STATUS_0)
							allCommonArea = allCommonArea.add(designArea);
						else if(decoStatus == StaticUtils.DECORATION_STATUS_1)
							logisticsArea = logisticsArea.add(designArea);
					}
					
					if(null != splitPrice)
						splitPriceSum += BaseHelpUtils.getDoubleValue(splitPrice);
					if(null != moneySum)
						allMoneySum = allMoneySum.add(moneySum);
					if(null != serviceArea)
						allServiceArea = allServiceArea.add(serviceArea);
					if(null != siteTotalMoney)
						allSiteTotalMoney = allSiteTotalMoney.add(siteTotalMoney);
					if(null != withAmountMoney)
						allWithAmountMoney = allWithAmountMoney.add(withAmountMoney);
				}
				//创建子合同
				SubContract subDao = new SubContract();
				BaseSubContract subBean = new BaseSubContract();
				if(allDesignArea.compareTo(BigDecimal.ZERO) > 0)
					subBean.setDesignArea(allDesignArea);
				
				if(allServiceArea.compareTo(BigDecimal.ZERO) > 0)
					subBean.setLogisticsArea(allServiceArea);
				if(logisticsArea.compareTo(BigDecimal.ZERO) > 0)
					subBean.setLogisticsArea(logisticsArea);
				//当总驻场金额大于0时  加入设计总金额
				if(allSiteTotalMoney.compareTo(BigDecimal.ZERO) > 0)
					allMoneySum = allMoneySum.add(allSiteTotalMoney);
				//当配合总金额大于0时  加入设计总金额
				if(allWithAmountMoney.compareTo(BigDecimal.ZERO) > 0)
					allMoneySum = allMoneySum.add(allWithAmountMoney);
				//子合同总金额 = 拆分价设计总金额 + 拆分价驻场总金额 + 拆分价配合总金额
				if(splitPriceSum> 0)
					//					subBean.setMoneySum(allMoneySum);
					subBean.setMoneySum(StaticMethod.formatComma4BigDecimal(splitPriceSum));
				String mainName = mainDao.getContractName();
				//判断数据是否全部为同一业务类型
				boolean isOneBussiness = checkIsOneBussiness(list);
				if(isOneBussiness){
					int bType = list.get(0).getBusinessType();
					switch (list.get(0).getBusinessType()) {
					case 4:
						bType = 6;
						break;
					case 5:
						bType = 4;
					case 6:
						bType = 5;
					case 7:
						bType = 8;
						break;
					default:
						break;
					}
					subBean.setBusinessType(bType);
				}
				//判断数据是否全部为项目类型
				boolean isOneProjectType = checkIsOneProjectType(list);
				if(isOneProjectType)
					subBean.setProjectType(list.get(0).getProjectType());
				subBean.setParentId(contractId);
				subBean.setProjectCode(projectCode);
				//创建子合同名称
				String subName = createSubName(subBean, mainName);
				subBean.setSubContractName(subName);
				Date currentDate = new Date();
				subDao.setDataFromBase(subBean);
				subDao.setComplaintPercentage(BigDecimal.ZERO);
				subDao.setComplaintIntegral(BigDecimal.ZERO);
				subDao.setCreateTime(currentDate);
				subDao.save();
				//获取新插入的子合同的主键
				int subContractId = subDao.getSubContractId();
				//将拆分价与子合同想关联
				dao.clear();
				String[]  idsArr = ids.split(",");
				Integer [] intIdsArr = new Integer[idsArr.length];
				for (int i = 0; i < idsArr.length; i++)
					intIdsArr[i] = Integer.parseInt(idsArr[i]);
				
				dao.addCondition("design_consideration_id", "in", (Object[]) intIdsArr);
				dao.setDisableType(1);
				dao.setSubContractId(subContractId);
				dao.conditionalUpdate();
			}
		}
		ThreadConnection.commit();
		BaseCollection<BaseSubContract> bc = new BaseCollection<>();
    	return bc.toJSON(status, "");
	}
	
	/**
	 * 
	 * @Title: checkIsOneProjectType 
	 * @Description: 检测拆分价是否为同一种项目类型
	 * @param @param list
	 * @param @return    
	 * @return boolean   
	 * @throws
	 */
	private boolean checkIsOneProjectType(List<BaseDesignConsideration> list){
		boolean flag = true;
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			int type = list.get(0).getProjectType();
			for (BaseDesignConsideration baseDesignConsideration : list)
				if(type != baseDesignConsideration.getProjectType()){
					flag = false;
					break;
				}
		} else
			flag = false;
		return flag;
	}
	
	/**
	 * 
	 * @Title: checkIsOneBussiness 
	 * @Description: 检测拆分价是否为同一种商业类型
	 * @param @param list
	 * @param @return   
	 * @return boolean   
	 * @throws
	 */
	private boolean checkIsOneBussiness(List<BaseDesignConsideration> list){
		boolean flag = true;
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			int type = list.get(0).getBusinessType();
			for (BaseDesignConsideration baseDesignConsideration : list)
				if(type != baseDesignConsideration.getBusinessType()){
					flag = false;
					break;
				}
		} else
			flag = false;
		return flag;
	}
	
	/**
	 * @throws Exception
	 * 
	 * @Title: getSubContract @Description: 根据主合同获取子合同信息 @param @param
	 * result @param @return @param @throws SQLException @return String @throws
	 */
	private String getSubContract(Map<String, Object> result) throws Exception {
		List<BaseSubContractInfo> infoList = getSubContractInfoList(result);
		BaseCollection<BaseSubContractInfo> bc = new BaseCollection<>();
		bc.setCollections(infoList);
		return bc.toJSON(0,"");
	}


	private  List<BaseSubContractInfo> getSubContractInfoList(Map<String, Object> result) throws Exception {
		List<BaseSubContractInfo> infoList = new ArrayList<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		BigDecimal htDdPercentage = BigDecimal.ZERO;// 订单总积分/合同金额占比
		SubContract sbDao = new SubContract();
		sbDao.setConditionParentId("=", contractId);
		boolean isLoadAll = BaseHelpUtils.getBoolean(result.get("isLoadAll"));
		String con = " order by sub_contract_id ";
		if(!isLoadAll){//不加载项目管理费、采买订单和部门预留订单
			con = String.format("project_type not in(%1$s,%2$s,%3$s) order by sub_contract_id",StaticUtils.PROJECT_TYPE_16,StaticUtils.PROJECT_TYPE_30,StaticUtils.PROJECT_TYPE_27);
		}
		List<BaseSubContract> ds = sbDao.conditionalLoad(con);
		if (ds.size() > 0) {
			BigDecimal signingMoneySum = BigDecimal.ZERO, // 合同金额
					totalMoneySum = BigDecimal.ZERO, // 订单总积分
					totalMoneySumPercentage = BigDecimal.ZERO, // 每项合同金额占比
					sheetTotalIntegralPercentage = BigDecimal.ZERO;// 项目总积分占比
			BigDecimal hundred = new BigDecimal("100");
			// 先统计出合同总金额，订单总积分
			for (BaseSubContract bs : ds) {
				signingMoneySum = signingMoneySum.add(BaseHelpUtils.getBigDecimalValue(bs.getMoneySum()));
				totalMoneySum = totalMoneySum.add(BaseHelpUtils.getBigDecimalValue(bs.getSheetTotalIntegral()));
			}
			
			for (BaseSubContract bs : ds) {
				BaseSubContractInfo info = new BaseSubContractInfo();
				String tmp = bs.toJSON();
				info.setDataFromJSON(tmp);
				BigDecimal moneySun = BaseHelpUtils.getBigDecimalValue(bs.getMoneySum());
				if (moneySun.compareTo(BigDecimal.ZERO) > 0) {
					totalMoneySumPercentage = moneySun.multiply(hundred).divide(signingMoneySum,2,BigDecimal.ROUND_UP);
					info.setHtPercentage(totalMoneySumPercentage);
				}
				BigDecimal sheetTotalIntegral = BaseHelpUtils.getBigDecimalValue(bs.getSheetTotalIntegral());
				if (sheetTotalIntegral.compareTo(BigDecimal.ZERO) > 0) {
					sheetTotalIntegralPercentage = sheetTotalIntegral.multiply(hundred).divide(totalMoneySum,2,BigDecimal.ROUND_UP);
					info.setDdPercentage(sheetTotalIntegralPercentage);
				}
				infoList.add(info);
			}
		}
		
		return infoList;
	}
	
    
    /**
     * 
     * @Title: getConsiderationsByCtr 
     * @Description: 根据子合同获取子合同下的报价单信息
     * @param @param result
     * @param @return
     * @param @throws SQLException   
     * @return String   
     * @throws
     */
    private String getConsiderationsByCtr(Map<String, Object> result) throws SQLException{
    	int subContractId = BaseHelpUtils.getIntValue(result,"subContractId");
    	int contractId=BaseHelpUtils.getIntValue(result,"contractId");
    	DesignConsideration sbDao = new DesignConsideration();
    	sbDao.setConditionSubContractId("=", subContractId);
    	List<BaseDesignConsideration> ds = sbDao.conditionalLoad();
    	BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
    	bc.setCollections(ds);
    	 
    	return bc.toJSON(1, "");
    }
    
    /**
     * @throws SQLException 
     * 合同编号 -部门编号 如：KB.2019-001E-31
     * @Title: createSubCode 
     * @Description: 创建子合同编号
     * @param @param bean
     * @param @return    
     * @return String   
     * @throws
     */
    public String createSubCode(BaseSubContract bean) throws SQLException{
    	StringBuilder sb = new StringBuilder();
    	Contract mainDao = new Contract();
    	mainDao.setContractId(bean.getParentId());
    	String mainCode = "";
    	if(mainDao.load())
			mainCode = mainDao.getContractCode();
    	int departmentId = bean.getDepartmentId();
    	String rePCode ="";//承接部门code
    	PlateRecord pd=new PlateRecord();
    	pd.setConditionPlateId("=", departmentId);
    	BasePlateRecord basePD=pd.executeQueryOneRow();
    	rePCode=BaseHelpUtils.getString(basePD.getPlateCode());
    	sb.append(mainCode).
    	append("-")
    	.append(rePCode);
    	SubContract sbDao = new SubContract();
    	sbDao.setConditionSubContractCode("=", sb.toString());
    	if(sbDao.countRows() > 0){
    		sbDao.clear();
    		sbDao.setConditionSubContractCode("like", sb.toString() + "%");
        	int count = sbDao.countRows();
        	if(count > 0)
				sb.append("/").append((char)(count + 64));
    	}
    	return sb.toString();
    }
    
    /**
     * 
     * @Title: createSubName 
     * @Description: 根据生成规则生成子合同名称
     * @param @param bean
     * @param @param contractName
     * @param @return    
     * @return String   
     * @throws
     */
    private String createSubName(BaseSubContract bean, String contractName){
    	int businessType = BaseHelpUtils.getIntValue(bean.getBusinessType());
    	int projectType = BaseHelpUtils.getIntValue(bean.getProjectType());
    	StringBuilder sb = new StringBuilder();// 子合同名称
		if (!BaseHelpUtils.isNullOrEmpty(businessType))
			switch (businessType) {
			case StaticUtils.BUSINESS_TYPE_1:
				sb.append("商业");
				break;
			case StaticUtils.BUSINESS_TYPE_2:
				sb.append("酒店");
				break;
			case StaticUtils.BUSINESS_TYPE_3:
				sb.append("办公");
				break;
			case StaticUtils.BUSINESS_TYPE_4:
				sb.append("轨道交通");
				break;
			case StaticUtils.BUSINESS_TYPE_5:
				sb.append("医养");
				break;
			case StaticUtils.BUSINESS_TYPE_6:
				sb.append("公共建筑");
				break;
			case StaticUtils.BUSINESS_TYPE_7:
				sb.append("综合体");
				break;
			case StaticUtils.BUSINESS_TYPE_91:
				sb.append("采买");
				break;
			case StaticUtils.BUSINESS_TYPE_99:
				sb.append("其他");
				break;
			case StaticUtils.BUSINESS_TYPE_8:
				sb.append("住宅");
				break;
			default:
				break;
			}
		if (!BaseHelpUtils.isNullOrEmpty(projectType))
			switch (projectType) {
			case StaticUtils.PROJECT_TYPE_1:
				sb.append("方案");
				break;
			case StaticUtils.PROJECT_TYPE_2:
				sb.append("深化");
				break;
			case StaticUtils.PROJECT_TYPE_3:
				sb.append("方案+深化");
				break;
			case StaticUtils.PROJECT_TYPE_4:
				sb.append("机电普通配合");
				break;
			case StaticUtils.PROJECT_TYPE_5:
				sb.append("机电二次设计");
				break;
			case StaticUtils.PROJECT_TYPE_6:
				sb.append("灯光设计");
				break;
			case StaticUtils.PROJECT_TYPE_7:
				sb.append("导向标识");
				break;
			case StaticUtils.PROJECT_TYPE_8:
				sb.append("陈设设计");
				break;
			case StaticUtils.PROJECT_TYPE_9:
				sb.append("采买");
				break;
			case StaticUtils.PROJECT_TYPE_10:
				sb.append("外包");
				break;
			case StaticUtils.PROJECT_TYPE_11:
				sb.append("智能化");
				break;
			case StaticUtils.PROJECT_TYPE_12:
				sb.append("机电顾问");
				break;
			case StaticUtils.PROJECT_TYPE_13:
				sb.append("现场配合");
				break;
			case StaticUtils.PROJECT_TYPE_14:
				sb.append("深化+现场配合");
				break;
			case StaticUtils.PROJECT_TYPE_15:
				sb.append("方案+深化+现场配合");
				break;
			case StaticUtils.PROJECT_TYPE_16:
				sb.append("项目管理");
				break;
			case StaticUtils.PROJECT_TYPE_27:
				sb.append("物料");
				break;
			case StaticUtils.PROJECT_TYPE_30:
				sb.append("采买成本");
				break;
			case StaticUtils.PROJECT_TYPE_33:
				sb.append("条线管理");
				break;
			case StaticUtils.PROJECT_TYPE_88:
				sb.append("部门预留");
				break;
			default:
				break;
			}
		if (sb.length() > 0) {
			sb.insert(0, "(");
			sb.insert(sb.length(), ")");
		}
		sb.append(contractName);
    	return sb.toString();
    }
    
    /**
     * 
     * @Title: updateChildContart 
     * @Description: 修改子合同信息
     * @param @param json
     * @param @return
     * @param @throws Exception   
     * @return String   
     * @throws
     */
    private String updateChildContart(String json, Map<String, Object> result) throws Exception{
    	String createSubCode = "";
    	if(null != result.get("createSubCode"))
			createSubCode = BaseHelpUtils.getStringValue(result, "createSubCode");
    	BaseSubContract bean = new BaseSubContract();
        bean.setDataFromJSON(json);
        SubContract dao = new SubContract();
        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        ThreadConnection.beginTransaction();
        if (dao.load()) {
        	 //如果是在修改承接部门时 且业务类别 项目类别 承接部门有改变时  改变订单编号
            if(!BaseHelpUtils.isNullOrEmpty(createSubCode) ){
            	if(createSubCode.equals("createSubCode")){
            		//在选择好承接部门的时候 开始创建子合同编号
                	if(!BaseHelpUtils.isNullOrZero(bean.getDepartmentId())) {
						if (!Objects.equals(dao.getDepartmentId(), bean.getDepartmentId())) {
							String subCode = createSubCode(bean);//合同编号
							bean.setSubContractCode(subCode);
						}
						dao.setDataFromBase(bean);
						dao.setSheetIntegral(bean.getSheetTotalIntegral());
					}
            	}else if(createSubCode.equals("updateHistory")){//如果是修改历史订单只允许修改订单总积分
            		dao.setSheetTotalIntegral(bean.getSheetTotalIntegral());
            		dao.setSheetIntegral(bean.getSheetTotalIntegral());
//            		dao.setCommonArea(bean.getCommonArea());
//            		dao.setDesignArea(bean.getDesignArea());
//            		dao.setLogisticsArea(bean.getLogisticsArea());
            		dao.setMoneySum(bean.getMoneySum());
            		dao.setComplaintIntegral(bean.getComplaintIntegral());
//            		dao.setBusinessLine(bean.getBusinessLine());
            	}
            	
            } else
            	dao.setDataFromBase(bean);
            	dao.setSheetIntegral(bean.getSheetTotalIntegral());
            num = dao.update();
        }
        dao.setDataToBase(bean);
        
        BigDecimal hundred =new BigDecimal(100);
        int contractId = BaseHelpUtils.getIntValue(dao.getParentId());
        
        //判断现在的子订单是否已经完全分配完了合同金额和产值
		SubContract sbDao = new SubContract();
		sbDao.setConditionParentId("=", contractId);
		String con = String.format("project_type not in(%1$s,%2$s,%3$s) order by sub_contract_id",StaticUtils.PROJECT_TYPE_16,StaticUtils.PROJECT_TYPE_30,StaticUtils.PROJECT_TYPE_27);
		List<BaseSubContract>  infoList = sbDao.conditionalLoad(con);
		List<BaseSubContractInfo> infoList1 = getSubContractInfoList(result);
		BigDecimal sheetTotalIntegral =BigDecimal.ZERO;
		BigDecimal moneySum =BigDecimal.ZERO;
		BigDecimal percentage =BigDecimal.ZERO;
		if(infoList1.size()>0) {
			for (BaseSubContractInfo baseSubContractInfo : infoList1) {
				 sheetTotalIntegral =sheetTotalIntegral.add( BaseHelpUtils.getBigDecimalValue(baseSubContractInfo.getSheetTotalIntegral()));
				 moneySum =moneySum .add(BaseHelpUtils.getBigDecimalValue(baseSubContractInfo.getMoneySum()));
				 percentage = percentage .add(BaseHelpUtils.getBigDecimalValue(baseSubContractInfo.getPercentage()));
			}
		}
		
		//获取合同金额和产值
		BaseOnLoadMainProjectBusinessTypeByContract base =new BaseOnLoadMainProjectBusinessTypeByContract();
		BigDecimal signingMoneySum =BigDecimal.ZERO;
		BigDecimal outputValueSum =BigDecimal.ZERO;
		int mainProjectId = 0 ;
		int outQuotationId = 0 ;
		QueryOnLoadMainProjectBusinessTypeByContract query =new QueryOnLoadMainProjectBusinessTypeByContract();
		ConditionOnLoadMainProjectBusinessTypeByContract condition =new ConditionOnLoadMainProjectBusinessTypeByContract();
		condition.setContractId(contractId);
		BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> execute = query.execute(null, condition);
		if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
			base = execute.getCollections().get(0);
			signingMoneySum  = BaseHelpUtils.getBigDecimalValue(base.getSigningMoneySum());
			outputValueSum = BaseHelpUtils.getBigDecimalValue(base.getOutputValueSum());
			mainProjectId=BaseHelpUtils.getIntValue(base.getMainProjectId());
			outQuotationId=BaseHelpUtils.getIntValue(base.getOutQuotationId());
		}
		
		
		if(percentage.compareTo(hundred)>0) {//占比大于100提示错误
		    throw new SQLException("子订单总占比不能大于100");	
		}else if(percentage.compareTo(hundred)==0){//占比等于100时，则再校验产值和合同金额是否相等
			if(mainProjectId>0 && outQuotationId>0 ) {//数据无异常，更新main_project_business_type 的status字段
				MainProjectBusinessType mDao = new MainProjectBusinessType();
				mDao.setConditionMainProjectId("=", mainProjectId);
				mDao.setConditionOutQuotationId("=", outQuotationId);
				mDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_3);//表示已拆分成子订单了
				mDao.conditionalUpdate();
			}else {
				 throw new SQLException("合同金额总和或产值总和不等于报价单的值");	
			}
		}else {
			if(mainProjectId>0 && outQuotationId>0 ) {//数据无异常，更新main_project_business_type 的status字段
				MainProjectBusinessType mDao = new MainProjectBusinessType();
				mDao.setConditionMainProjectId("=", mainProjectId);
				mDao.setConditionOutQuotationId("=", outQuotationId);
				mDao.setConditionStatus("=",StaticUtils.BUSINESS_TYPE_STATUS_3);
				mDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_2);
				mDao.conditionalUpdate();
			}else {
				 throw new SQLException("合同金额总和或产值总和不等于报价单的值");	
			}
		}
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }
    
    /**
     * 
     * @Title: getConsiderByContract 
     * @Description: 根据主合同与子合同主键获取拆分价信息
     * @param @param result
     * @param @return
     * @param @throws SQLException   
     * @return String   
     * @throws
     */
    private String getConsiderByContract(Map<String, Object> result) throws SQLException{
    	int contractId = BaseHelpUtils.getIntValue(result,"contractId");
    	int subContractId = BaseHelpUtils.getIntValue(result,"subContractId");
    	BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
    	StringBuilder totalMsg = new StringBuilder("拆分价= ");//统计信息
    	//根据合同id找到成功的报价单id
    	OutQuotation oq=new OutQuotation();
    	//根据信息编号找到成功状态的报价单
    	Contract cDao = new Contract();
    	cDao.setContractId(contractId);
    	if(cDao.load()){
    		oq.setConditionInfoCode("=", cDao.getInfoCode());
    		oq.setConditionQuotationStatus("=", StaticUtils.QUOTATION_STATUS_ONE);
    		BaseOutQuotation baseOQ = oq.executeQueryOneRow();
    		DesignConsideration sbDao = new DesignConsideration();
        	sbDao.setConditionOutQuotationId("=", baseOQ.getOutQuotationId());
        	sbDao.setConditionSubContractId("=", subContractId);
        	List<BaseDesignConsideration> ds = sbDao.conditionalLoad(" order by business_type");
        	//遍历
    		List<BaseDesignConsideration> resList = new ArrayList<>();
    		for(BaseDesignConsideration d:ds){
    			//标识正常的数据1，合计统计数据2和最终报价统计数据3
    			d.setJobMix(1);
    			
    			//单位换算为万元的字段
    			double sumMoney=BaseHelpUtils.getDoubleValue(d.getMoneySum());
    			if(sumMoney > 0){
    				//统计报价单
    				double tempCount=sumMoney;
    				d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
    			}
    			double interiorSumMoney=BaseHelpUtils.getDoubleValue(d.getInteriorMoneySum());
    			if(interiorSumMoney > 0){
    				double tempCount=interiorSumMoney;
    				d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
    			}
    			double splitPrice=BaseHelpUtils.getDoubleValue(d.getSplitPrice());
    			if(splitPrice > 0){
    				double tempCount=splitPrice;
    				d.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
    			}
    			//2装饰
    			if(d.getOptionType() == 2 && d.getParentId() ==  0)
					System.out.println("父结构 "+d.getMainDesignAreaName());
				else
					resList.add(d);
    		}
        	bc.setCollections(resList);
        	//统计数据
        	if(ds.size() > 0){
        		double cfj=0;
        		for (BaseDesignConsideration baseDesignConsideration : ds)
					if(baseDesignConsideration.getParentId()==0)
						cfj+=BaseHelpUtils.getDoubleValue(baseDesignConsideration.getSplitPrice());
        		totalMsg.append(cfj);
        	}
    	}
    	return bc.toJSON(-1, totalMsg.toString());
    }
    
}
