package pomplatform.stagemodel.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractStageModel;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractStageModel;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.common.bean.BaseKeyValue;
import pomplatform.common.utils.BaseTree;
import pomplatform.common.utils.StaticUtils;
import pomplatform.common.utils.TreeUtils;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.stagemodel.bean.BaseContractStageModelAuditData;
import pomplatform.stagemodel.bean.BaseGetContractStageModelByParentId;
import pomplatform.stagemodel.bean.BaseGetStageModelByParentId;
import pomplatform.stagemodel.bean.BaseStageContractInfoList;
import pomplatform.stagemodel.bean.ConditionGetContractStageModelByParentId;
import pomplatform.stagemodel.bean.ConditionGetStageModelByParentId;
import pomplatform.stagemodel.bean.ConditionStageContractInfoList;
import pomplatform.stagemodel.query.QueryGetContractStageModelByParentId;
import pomplatform.stagemodel.query.QueryGetStageModelByParentId;
import pomplatform.stagemodel.query.QueryStageContractInfoList;
import pomplatform.updatedata.bean.BaseProjectSettlement;
import pomplatform.updatedata.bean.ConditionProjectSettlement;
import pomplatform.updatedata.query.QueryProjectSettlement;

public class StageModelProcessor implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //根据模板，新建合同小节点
    private static final String CREATE_NEW_CONTRACT_STAGE_MODEL = "createNewContractStageModel";
    //计算可发布节点
    private static final String CALCULATE_NODES = "calculateNodes";
    //计算所有合同的可发布节点
    private static final String CALCULATE_ALL_CONTRACTS = "calculateAllContracts";
    //发布节点
    private static final String PUBLISH_NODES = "publishNodes";
    //加锁解锁
    private static final String CHANGE_LOCK_STATUS = "changeLockStatus";
    //项目经理审批
    private static final String MANAGER_AUDIT = "managerAudit";
    //设计总监审批
    private static final String DESIGN_DIRECTOR_AUDIT = "designDirectorAudit";
    //查看/打印
    private static final String GET_PRINT_HTML = "getPrintHtml";
    //选择订单的专业负责人作为项目经理，事业部负责人作为设计总监
    private static final String SELECT_PROJECT_EMPLOYEE_AS_MANAGER = "selectProjectEmployeeAsManager";
    //直接指定某个职员作为项目经理，其所在事业部的事业部负责人作为设计总监
    private static final String SELECT_EMPLOYEE_AS_MANAGER = "selectEmployeeAsManager";
    //选定证据
    private static final String SELECT_EVIDENCE = "selectEvidence";
    //加载审批页面的数据
    private static final String LOAD_AUDIT_DATA = "loadAuditData";
    //打印某个合同2017的小节点信息
    private static final String GET_2017_PRINT_HTML = "get2017PrintHtml";
    //突破到此节点
    private static final String GO_TO_THIS_LINE = "goToThisLine";
    //取消突破到此节点
    private static final String CANCEL_FROM_THIS_LINE = "cancelFromThisLine";
    //打印指定年度的合同小节点信息
    private static final String GET_PRINT_HTML_BY_YEAR = "getPrintHtmlByYear";
    //打印指定年度的合同的最后一个小节点信息
    private static final String GET_LAST_POINT_PRINT_HTML_BY_YEAR = "getLastPointPrintHtmlByYear";
    /**
     * 合同小节点流程状态：新建
     */
    private final int CONTRACT_STAGE_PROCESS_STATUS_0 = 0;
    /**
     * 合同小节点流程状态：运行中
     */
    private final int CONTRACT_STAGE_PROCESS_STATUS_1 = 1;
    /**
     * 合同小节点流程状态：结束
     */
    private final int CONTRACT_STAGE_PROCESS_STATUS_3 = 3;
    /**
     * 现场服务
     */
    private final String ON_SITE_SERVICE = "现场服务";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        switch(optType) {
        case CREATE_NEW_CONTRACT_STAGE_MODEL:
        	return createNewContractStageModel(params);
        case CALCULATE_NODES:
        	return calculateNodes(params);
        case CALCULATE_ALL_CONTRACTS:
        	return calculateAllContracts();
        case PUBLISH_NODES:
	    	return publishNodes(params);
        case CHANGE_LOCK_STATUS:
	    	return changeLockStatus(params);
        case MANAGER_AUDIT:
	    	return managerAudit(params);
        case DESIGN_DIRECTOR_AUDIT:
	    	return designDirectorAudit(params);
        case GET_PRINT_HTML:
	    	return getPrintHtml(params);
        case SELECT_PROJECT_EMPLOYEE_AS_MANAGER:
	    	return selectProjectEmployeeAsManager(params);
        case SELECT_EMPLOYEE_AS_MANAGER:
	    	return selectEmployeeAsManager(params);
        case SELECT_EVIDENCE:
	    	return selectEvidence(params);
        case LOAD_AUDIT_DATA:
	    	return loadAuditData(params);
        case GET_2017_PRINT_HTML:
	    	return get2017PrintHtml(params);
        case GO_TO_THIS_LINE:
	    	return goToThisLine(params);
        case CANCEL_FROM_THIS_LINE:
	    	return cancelFromThisLine(params);
        case GET_PRINT_HTML_BY_YEAR:
        	return getPrintHtmlByYear(params);
        case GET_LAST_POINT_PRINT_HTML_BY_YEAR:
        	return getLastPointPrintHtmlByYear(params);
    	default:
    		return null;
        }
    }
    
    /**
     * 根据模板，新建合同小节点
     * @return
     * @throws Exception 
     */
    public String createNewContractStageModel(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	String modelIds = BaseHelpUtils.getString(params.get("stageModelId"));
    	Integer contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    	Integer[] modelIdArr = getIntegerArrFromString(modelIds);
    	if(modelIdArr.length > 0){
    		ThreadConnection.beginTransaction();
    		for(Integer modelIdStr : modelIdArr){
		    	ConditionGetStageModelByParentId condition = new ConditionGetStageModelByParentId();
		    	condition.setStageModelId(modelIdStr);
		    	QueryGetStageModelByParentId query = new QueryGetStageModelByParentId();
		    	BaseCollection<BaseGetStageModelByParentId> stageModelCollection = query.executeQuery(null, condition);
		    	int depth = 0;
		    	for(BaseGetStageModelByParentId obj : stageModelCollection.getCollections()){
		    		if(BaseHelpUtils.getIntValue(obj.getDepth()) > depth){
		    			depth = obj.getDepth();
		    		}
		    	}
		    	Integer[] parentIdArr = new Integer[depth];
		    	for(BaseGetStageModelByParentId obj : stageModelCollection.getCollections()){
		    		BaseContractStageModel bean = new BaseContractStageModel();
		    		bean.setDataFromJSON(obj.toJSON());
		    		ContractStageModel dao = new ContractStageModel();
		    		dao.setDataFromBase(bean);
		    		dao.setContractId(contractId);
		    		int tempDepth = BaseHelpUtils.getIntValue(obj.getDepth());
		    		if(BaseHelpUtils.getIntValue(obj.getDepth()) == 1){
		    			dao.save();
		    			parentIdArr[tempDepth - 1] = dao.getContractStageModelId();
		    		}else{
		    			dao.setParentId(parentIdArr[tempDepth - 2]);
		    			dao.save();
		    			parentIdArr[tempDepth - 1] = dao.getContractStageModelId();
		    		}
		    	}
    		}
    		ThreadConnection.commit();
    	}else{
    		return bc.toJSON(-1, "参数有误");
    	}
        return bc.toJSON();
    }
    
    /**
     * 根据合同ID，计算出该合同的可发布节点
     * @return
     * @throws Exception 
     */
    public String calculateNodes(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	Integer contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    	ContractStageModel dao = new ContractStageModel();
    	dao.unsetSelectFlags();
    	dao.setSelectContractStageModelId(true);
    	dao.setConditionParentId("=", 0);
    	dao.setConditionContractId("=", contractId);
    	if(dao.countRows() == 0){
    		return bc.toJSON(-1, "该合同没有业态节点");
    	}else if(dao.countRows() > 1){
    		return bc.toJSON(-1, "该合同有多个业态节点，系统无法自动计算可发布节点");
    	}else{
    		ConditionStageContractInfoList condition1 = new ConditionStageContractInfoList();
    		condition1.setContractId(contractId);
    		QueryStageContractInfoList query1 = new QueryStageContractInfoList();
    		BaseCollection<BaseStageContractInfoList> collection1 = query1.executeQuery(null, condition1);
    		if(null != collection1 && null != collection1.getCollections() && !collection1.getCollections().isEmpty()){
    			BaseStageContractInfoList contractInfo = collection1.getCollections().get(0);
    			if(contractInfo.getRecordNo() == 0){
    				return bc.toJSON(-1, "该合同没有业态节点");
    			}else if(contractInfo.getRecordNo() > 1){
    				return bc.toJSON(-1, "该合同有多个业态节点，系统无法自动计算可发布节点");
    			}else if(null == contractInfo.getRevenuePercent() || contractInfo.getRevenuePercent().compareTo(BigDecimal.ZERO) == 0){
    				return bc.toJSON(-1, "该合同的营收百分比为0.00%，无需计算");
    			}else{
    				ThreadConnection.beginTransaction();
    				calculateNodePercent(contractInfo);
    				ThreadConnection.commit();
    			}
    		}else{
    			return bc.toJSON(-1, "该合同没有营收，无需计算");
    		}
    		
    	}
    	return bc.toJSON();
    }
    
    public String calculateAllContracts() throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	ConditionStageContractInfoList condition1 = new ConditionStageContractInfoList();
		QueryStageContractInfoList query1 = new QueryStageContractInfoList();
		BaseCollection<BaseStageContractInfoList> collection1 = query1.executeQuery(null, condition1);
		if(null != collection1 && null != collection1.getCollections() && !collection1.getCollections().isEmpty()){
			List<BaseStageContractInfoList> list = collection1.getCollections();
			ThreadConnection.beginTransaction();
			for(BaseStageContractInfoList bean : list){
				//只针对只有1个业态模板，并且营收百分比大于0的合同做节点计算
				if(bean.getRecordNo() == 1 && null != bean.getRevenuePercent() && bean.getRevenuePercent().compareTo(BigDecimal.ZERO) > 0){
					if(null != bean.getCalculatePercent() && bean.getCalculatePercent().compareTo(bean.getRevenuePercent()) == 0){
						//如果原先计算出来的节点百分比之和已经和现有的营收百分比相等了，则无需再次计算
						continue;
					}
					calculateNodePercent(bean);
				}
			}
			ThreadConnection.commit();
		}
    	return bc.toJSON();
    }
    
    public void calculateNodePercent(BaseStageContractInfoList bean) throws Exception{
    	//计算出营收百分比
		BigDecimal percent = bean.getRevenuePercent();
		ContractStageModel dao = new ContractStageModel();
    	dao.unsetSelectFlags();
    	dao.setSelectContractStageModelId(true);
    	dao.setConditionParentId("=", 0);
    	dao.setConditionContractId("=", bean.getContractId());
		Integer parentId = dao.executeQueryOneRow().getContractStageModelId();
		ConditionGetContractStageModelByParentId condition2 = new ConditionGetContractStageModelByParentId();
		condition2.setContractStageModelId(parentId);
		QueryGetContractStageModelByParentId query2 = new QueryGetContractStageModelByParentId();
		BaseCollection<BaseGetContractStageModelByParentId> collection2 = query2.executeQuery(null, condition2);
		if(null != collection2 && null != collection2.getCollections() && !collection2.getCollections().isEmpty()){
			List<BaseGetContractStageModelByParentId> list = collection2.getCollections();
			List<BaseTree> tempTreeList = new ArrayList<>();
			List<BaseTree> treeList = new ArrayList<>();
			for(BaseGetContractStageModelByParentId obj : list){
				BaseTree treeNode = new BaseTree();
				treeNode.setId(obj.getContractStageModelId());
				treeNode.setParentId(obj.getParentId());
				treeNode.setData(obj);
				tempTreeList.add(treeNode);
			}
			treeList = TreeUtils.formatTree(tempTreeList);
			calculateDataFromTree(percent, treeList);
		}
    }
    
    public BigDecimal calculateDataFromTree(BigDecimal percent, List<BaseTree> treeList) throws Exception{
    	if(null != percent && percent.compareTo(BigDecimal.ZERO) > 0){
	    	for(BaseTree obj : treeList){
				if(null != obj.getChildren()){
					List<BaseTree> tempList = obj.getChildren();
					BaseGetContractStageModelByParentId bean = (BaseGetContractStageModelByParentId) tempList.get(0).getData();
					if(bean.getLeafNode()){
						for(BaseTree tempTreeBean : tempList){
							BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId) tempTreeBean.getData();
							if(data.getLocked()){
								//已锁定
								percent = percent.subtract(data.getActualPercent());
							}else{
								//未锁定
								ContractStageModel dao = new ContractStageModel();
								dao.setContractStageModelId(data.getContractStageModelId());
								dao.load();
								if(percent.compareTo(data.getPercent()) >= 0){
									percent = percent.subtract(data.getPercent());
									dao.setActualPercent(data.getPercent());
									dao.update();
									if(percent.compareTo(BigDecimal.ZERO) <= 0){
										return BigDecimal.ZERO;
									}
								}else{
									dao.setActualPercent(percent);
									dao.update();
									return BigDecimal.ZERO;
								}
							}
						}
						if(percent.compareTo(BigDecimal.ZERO) > 0){
							/**
							 * 如果不需要证据，直接跨过阶段计算可发布节点的话，把下面4行代码注释掉即可
							 */
							if(!((BaseGetContractStageModelByParentId)obj.getData()).getHasEvidence()){
								//没有取得证据，不可以继续
								return BigDecimal.ZERO;
							}
						}else{
							return percent;
						}
					}else{
						percent = calculateDataFromTree(percent, tempList);
						if(percent.compareTo(BigDecimal.ZERO) <= 0){
							return BigDecimal.ZERO;
						}
					}
				}
			}
	    	return percent;
    	}else{
    		return BigDecimal.ZERO;
    	}
    }
    
    /**
     * 发布节点
     * @return
     * @throws Exception 
     */
    public String publishNodes(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	String ids = BaseHelpUtils.getString(params.get("id"));
    	if(BaseHelpUtils.isNullOrEmpty(ids)){
    		return bc.toJSON(-1, "请选择需要发布的节点");
    	}else{
    		Integer[] idArr = getIntegerArrFromString(ids);
    		ContractStageModel dao = new ContractStageModel();
    		dao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", (Object[]) idArr);
    		dao.setConditionProcessStatus("=", CONTRACT_STAGE_PROCESS_STATUS_0);
    		if(dao.countRows() > 0){
	    		List<BaseContractStageModel> list = dao.conditionalLoad();
	    		dao.setProcessStatus(CONTRACT_STAGE_PROCESS_STATUS_1);
	    		dao.conditionalUpdate();
//	    		 发送企业微信消息
	    		Set<Integer> employees = new HashSet<>();
    			for(BaseContractStageModel obj : list){
    				if(obj.getNeedManagerAudit()){
    					if(null != obj.getManagerId()){
    						employees.add(obj.getManagerId());
    					}
    				}else if(obj.getNeedDesignDirectorAudit()){
    					if(null != obj.getDesignDirectorId()){
    						employees.add(obj.getDesignDirectorId());
    					}
    				}
    			}
    			if(employees.size() > 0){
    				for(Integer employeeId : employees){
//    					WeixinUtils.sendWXMsgToUser(employeeId, "您好，有合同业态节点需要您在ERP进行审批，请及时处理，谢谢！");
    					System.out.println("您好"+ employeeId +"，有合同业态节点需要您在ERP进行审批，请及时处理，谢谢！");
    				}
    			}
    			return bc.toJSON();
    		}else{
    			return bc.toJSON(-1, "查不到实体数据/选中的节点已发布");
    		}
    	}
    }
    
    /**
     * 加锁/解锁
     * @return
     * @throws Exception 
     */
    public String changeLockStatus(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	String ids = BaseHelpUtils.getString(params.get("id"));
    	if(BaseHelpUtils.isNullOrEmpty(ids)){
    		return bc.toJSON(-1, "请选择需要加锁/解锁的节点");
    	}else{
    		Integer[] idArr = getIntegerArrFromString(ids);
    		boolean lock = BaseHelpUtils.getBoolean(params.get("lock"));
    		ContractStageModel dao = new ContractStageModel();
    		dao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", (Object[]) idArr);
    		dao.setLocked(lock);
    		dao.conditionalUpdate();
			return bc.toJSON();
    	}
    }

    /**
     * 项目经理审批
     * @return
     * @throws Exception 
     */
    public String managerAudit(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	BaseContractStageModel bean = new BaseContractStageModel();
    	bean.setDataFromMap(params);
    	ContractStageModel dao = new ContractStageModel();
    	dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){
			boolean firstAudit = true;
			if(null != dao.getManagerAuditDate()){
				firstAudit = false;
			}
			dao.setDataFromBase(bean); 
			ThreadConnection.beginTransaction();
			if(firstAudit){
				dao.setManagerAuditDate(new Date());
				if(BaseHelpUtils.getString(dao.getStageModelName()).contains(ON_SITE_SERVICE) || !dao.getNeedDesignDirectorAudit()){
					//现场服务，则表明这是最后一个审批节点
					dao.setProcessStatus(CONTRACT_STAGE_PROCESS_STATUS_3);
					ContractStageModel parentDao = new ContractStageModel();
					parentDao.setContractStageModelId(dao.getParentId());
					if(parentDao.load()){
						parentDao.setActualPercent(BaseHelpUtils.getBigDecimalValue(parentDao.getActualPercent()).add(dao.getActualPercent()));
						parentDao.update();
					}
				}else{
					if(dao.getNeedDesignDirectorAudit() && null != dao.getDesignDirectorId() && null == dao.getDesignDirectorAuditDate()){
						if(dao.getDesignDirectorId().equals(dao.getManagerId())){
							dao.setManagerAuditDate(new Date());
							dao.setProcessStatus(CONTRACT_STAGE_PROCESS_STATUS_3);
							ContractStageModel parentDao = new ContractStageModel();
							parentDao.setContractStageModelId(dao.getParentId());
							if(parentDao.load()){
								parentDao.setActualPercent(BaseHelpUtils.getBigDecimalValue(parentDao.getActualPercent()).add(dao.getActualPercent()));
								parentDao.update();
							}
						}else{
//							WeixinUtils.sendWXMsgToUser(dao.getDesignDirectorId(), "您好，有合同业态节点需要您在ERP进行审批，请及时处理，谢谢！");
							System.out.println("您好"+ dao.getDesignDirectorId() +"，有合同业态节点需要您在ERP进行审批，请及时处理，谢谢！");
						}
					}
				}
			}
			num = dao.update(); 
			ThreadConnection.commit();
		}
		return bc.toJSON(num, null);
    }
    
    /**
     * 驻场、设计总监审批
     * @return
     * @throws Exception 
     */
    public String designDirectorAudit(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	BaseContractStageModel bean = new BaseContractStageModel();
    	bean.setDataFromMap(params);
    	ContractStageModel dao = new ContractStageModel();
    	dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){
			boolean firstAudit = true;
			if(null != dao.getDesignDirectorAuditDate()){
				firstAudit = false;
			}
			dao.setDataFromBase(bean); 
			ThreadConnection.beginTransaction();
			if(firstAudit){
				dao.setDesignDirectorAuditDate(new Date());
				if(BaseHelpUtils.getString(dao.getStageModelName()).contains(ON_SITE_SERVICE)){
					//现场服务，则表明这里是驻场人员审批，后续还需要项目经理审批
					if(dao.getNeedManagerAudit() && null != dao.getManagerId() && null == dao.getManagerAuditDate()){
						if(dao.getDesignDirectorId().equals(dao.getManagerId())){
							dao.setManagerAuditDate(new Date());
							ContractStageModel parentDao = new ContractStageModel();
							parentDao.setContractStageModelId(dao.getParentId());
							if(parentDao.load()){
								parentDao.setActualPercent(BaseHelpUtils.getBigDecimalValue(parentDao.getActualPercent()).add(dao.getActualPercent()));
								parentDao.update();
							}
						}else{
//							WeixinUtils.sendWXMsgToUser(dao.getManagerId(), "您好，有合同业态节点需要您在ERP进行审批，请及时处理，谢谢！");
							System.out.println("您好"+ dao.getManagerId() +"，有合同业态节点需要您在ERP进行审批，请及时处理，谢谢！");
						}
					}
				}else{
					dao.setProcessStatus(CONTRACT_STAGE_PROCESS_STATUS_3);
					ContractStageModel parentDao = new ContractStageModel();
					parentDao.setContractStageModelId(dao.getParentId());
					if(parentDao.load()){
						parentDao.setActualPercent(BaseHelpUtils.getBigDecimalValue(parentDao.getActualPercent()).add(dao.getActualPercent()));
						parentDao.update();
					}
				}
			}
			num = dao.update(); 
			ThreadConnection.commit();
		}
		return bc.toJSON(num, null);
    }
    
    public ContractStageModel getSuperStageInfo(Integer id) throws Exception{
    	ContractStageModel dao = new ContractStageModel();
    	dao.setContractStageModelId(id);
    	if(dao.load()){
    		if(BaseHelpUtils.getIntValue(dao.getParentId()) == 0){
    			return dao;
    		}else{
    			return getSuperStageInfo(dao.getParentId());
    		}
    	}else{
    		return null;
    	}
    }
    
    public String getSuperStageName(Integer id) throws Exception{
    	ContractStageModel dao = getSuperStageInfo(id);
    	if(null != dao){
    		return BaseHelpUtils.getString(dao.getStageModelName());
    	}
		return "";
    }
    
    public Integer getSuperStageId(Integer id) throws Exception{
    	ContractStageModel dao = getSuperStageInfo(id);
    	if(null != dao){
    		return BaseHelpUtils.getIntValue(dao.getContractStageModelId());
    	}
		return null;
    }
    /**
     * 节点打印数据
     * @return
     * @throws Exception 
     */
    public String getPrintHtml(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseKeyValue> bc = new BaseCollection<>();
    	int id = BaseHelpUtils.getIntValue(params.get("contractStageModelId"));
    	ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
		condition.setContractStageModelId(id);
		QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
		BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
		if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
			List<BaseGetContractStageModelByParentId> list = collection.getCollections();
			List<BaseTree> tempTreeList = new ArrayList<>();
			List<BaseTree> treeList = new ArrayList<>();
			Set<Integer> employeeIdSet = new HashSet<>();
			for(BaseGetContractStageModelByParentId obj : list){
				if(null != obj.getManagerId()){
					employeeIdSet.add(obj.getManagerId());
				}
				if(null != obj.getDesignDirectorId()){
					employeeIdSet.add(obj.getDesignDirectorId());
				}
				BaseTree treeNode = new BaseTree();
				treeNode.setId(obj.getContractStageModelId());
				treeNode.setParentId(obj.getParentId());
				treeNode.setData(obj);
				tempTreeList.add(treeNode);
			}
			treeList = TreeUtils.formatTree(tempTreeList);
			StringBuilder sb = new StringBuilder();
			BaseGetContractStageModelByParentId superParent = (BaseGetContractStageModelByParentId) treeList.get(0).getData();
			String businessType = getSuperStageName(id).split("：")[0];
			Contract contractDao = new Contract();
			contractDao.setContractId(BaseHelpUtils.getIntValue(superParent.getContractId()));
			contractDao.unsetSelectFlags();
			contractDao.setSelectContractCode(true);
			contractDao.setSelectContractName(true);
			contractDao.setSelectProjectAddress(true);
			contractDao.load();
			//获取相关人员的名字
			Map<Integer, String> employeeMap = new HashMap<>();
			if(employeeIdSet.size() > 0){
				Employee employeeDao = new Employee();
				employeeDao.unsetSelectFlags();
				employeeDao.setSelectEmployeeId(true);
				employeeDao.setSelectEmployeeName(true);
				employeeDao.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", employeeIdSet.toArray());
				List<BaseEmployee> employeeList = employeeDao.conditionalLoad();
				for(BaseEmployee employeeBean : employeeList){
					employeeMap.put(employeeBean.getEmployeeId(), employeeBean.getEmployeeName());
				}
			}
			sb.append("<style> *{font-family:'微软雅黑';} th{font-weight:normal;} td{text-align:center;} .print_page_split{page-break-after:always;} </style>");
			if(null == treeList.get(0).getChildren()){
				//单节点打印
				generateSingleBeanPrintHtml(sb, list.get(0), businessType, contractDao, employeeMap);
			}else{
				//带子节点打印
				generatePrintHtml(sb, treeList, businessType, contractDao, employeeMap);
			}
			BaseKeyValue bean = new BaseKeyValue();
			bean.setKey("htmlStr");
			int position = sb.toString().lastIndexOf("print_page_split");
			bean.setValue(sb.toString().substring(0, position)+sb.toString().substring(position+16));
			List<BaseKeyValue> tempList = new ArrayList<>();
			tempList.add(bean);
			bc.setCollections(tempList);
			return bc.toJSON();
		}else{
			return bc.toJSON(-1, "找不到实体数据");
		}
	
    }
    
    public void generatePrintHtml(StringBuilder sb, List<BaseTree> list, String businessType, Contract contractDao, Map<Integer, String> employeeMap) throws Exception{
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    	for(BaseTree obj : list){
    		if(obj.getChildren() != null){
    			List<BaseTree> childList = obj.getChildren(); 
    			if(((BaseGetContractStageModelByParentId)childList.get(0).getData()).getLeafNode()){
    				//叶子节点的上一级
    				BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId) obj.getData();
    				ContractStageModel dao = new ContractStageModel();
    				dao.setContractStageModelId(data.getParentId());
    				dao.unsetSelectFlags();
    				dao.setSelectStageModelName(true);
    				dao.load();
    				String parentStageName = BaseHelpUtils.getString(dao.getStageModelName());
    				String stageName = data.getStageModelName();
    				int height = 1097;
    				if(null != stageName && !stageName.contains("现场") && !stageName.contains("竣工")){
    					sb.append("<div style='clear:both;'></div>");
    					sb.append("<div style='height:1082px; min-height:1082px; max-height:1082px; width:750px; position: relative;' class='print_page_split'>")
    					.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
    					.append("<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
    					.append(stageName)
    					.append("策划进度表</caption>")
    					.append("<tr style='font-size:15px;'>")
    					.append("<td width='90' height='42'>项目名称</td>")
    					.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractName())).append("</td>")
    					.append("<td width='90' height='42'>合同编号</td>")
    					.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractCode())).append("</td>")
    					.append("</tr>")
    					.append("<tr style='font-size:15px;'>")
    					.append("<td width='90' height='42'>项目类别</td>")
    					.append("<td width='285' height='42'>").append(businessType).append("</td>")
    					.append("<td width='90' height='42'>项目地点</td>")
    					.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getProjectAddress())).append("</td>")
    					.append("</tr>")
    					.append("<tr style='font-size:15px;'><td width='90' height='42' colspan='4'>").append(stageName).append("完成时点（");
    					height = height - 44 * 3 - 75;
    					if(null != data.getConfirmDate()){
    						sb.append(dateFormat.format(data.getConfirmDate()));
    					}
    					sb.append("）</td></tr>");
    					sb.append("</table>");
    					int trSize = 0;
    					StringBuilder tempSb = new StringBuilder();
    					StringBuilder tempChildSb = new StringBuilder();
    					for(int i = 0; i < childList.size(); i++){
    						BaseTree child = childList.get(i);
    						BaseGetContractStageModelByParentId childData = (BaseGetContractStageModelByParentId) child.getData();
    						String childStageName = BaseHelpUtils.getString(childData.getStageModelName());
    						if(childStageName.equals("策划")){
    							continue;
    						}
    						if(childStageName.contains("输出") || childStageName.contains("评审")){
    							if(trSize == 0){
    								height -= 88;
    								sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    								.append("<tr style='font-size:15px;'>");
    								tempSb.delete(0, tempSb.length());
    								tempSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    								.append("<tr style='font-size:15px;'>");
    							}
    							sb.append("<td width='187.5' height='42'>").append(BaseHelpUtils.getString(childData.getStageModelName())).append("</td>");
    							if(BaseHelpUtils.getIntValue(childData.getProcessStatus()) == CONTRACT_STAGE_PROCESS_STATUS_3){
    								tempSb.append("<td width='187.5' height='42'>已完成</td>");
    							}else{
    								tempSb.append("<td width='187.5' height='42'>未完成</td>");
    							}
    							if(trSize < 3){
    								trSize++;
    								if(i == childList.size() - 1){
    									sb.append("</tr>").append("</table>");
        								sb.append(tempSb.toString()).append("</tr>").append("</table>");
    								}
    							}else{
    								sb.append("</tr>").append("</table>");
    								sb.append(tempSb.toString()).append("</tr>").append("</table>");
    								trSize = 0;
    							}
    						}
    						tempChildSb.append("<div style='clear:both;'></div>");
    						tempChildSb.append("<div style='height:1082px; min-height:1082px; max-height:1082px; width:750px; position: relative;' class='print_page_split'>")
        					.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
        					.append("<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
        					.append(stageName)
        					.append(childStageName)
        					.append("</caption>")
        					.append("<tr style='font-size:15px;'>")
        					.append("<td width='90' height='42'>项目名称</td>")
        					.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractName())).append("</td>")
        					.append("<td width='90' height='42'>合同编号</td>")
        					.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractCode())).append("</td>")
        					.append("</tr>")
        					.append("<tr style='font-size:15px;'>")
        					.append("<td width='90' height='42'>项目类别</td>")
        					.append("<td width='285' height='42'>").append(businessType).append("</td>")
        					.append("<td width='90' height='42'>设计阶段</td>")
        					.append("<td width='285' height='42'>").append(parentStageName).append("-").append(stageName).append("</td>")
        					.append("</tr>");
    						if(childStageName.contains("输入")||childStageName.contains("输出")||childStageName.contains("评审")){
    							tempChildSb.append("<tr style='font-size:15px;'>")
    							.append("<td width='90' height='425'>");
    							if(childStageName.contains("评审")){
    								tempChildSb.append("评<br>审<br>结<br>论");
    							}else if(childStageName.contains("输出")){
    								tempChildSb.append("设<br>计<br>输<br>出<br>信<br>息");
    							}else if(childStageName.contains("输入")){
    								tempChildSb.append("设<br>计<br>输<br>入<br>信<br>息");
    							}
    							tempChildSb.append("</td>");
    							tempChildSb.append("<td width='660' height='450' colspan='3' style='text-align:left; padding-left:5px; padding-right:5px; line-height:25px;'>")
    							.append(BaseHelpUtils.getString(childData.getRemark()).replaceAll("\r\n", "<br>"))
    							.append("</td>")
    							.append("</tr>");
    						}
    						tempChildSb.append("</table>");
    						int childAuditHeight = 0;
        					if(childData.getNeedManagerAudit() && childData.getNeedDesignDirectorAudit()){
        						childAuditHeight = 225;
        					}else{
        						childAuditHeight = 450;
        					}
        					if(!childData.getNeedManagerAudit() && !childData.getNeedDesignDirectorAudit()){
        						tempChildSb.append("<div style='width:748px; margin-top:-2px; height:").append(childAuditHeight).append("px; border:1px solid;'></div>");
        					}else{
	    						if(childStageName.contains(ON_SITE_SERVICE)){
	    							if(childData.getNeedDesignDirectorAudit()){
	    								tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
	    								.append("<tr style='font-size:15px;'>")
	    								.append("<td width='750' height='").append(childAuditHeight).append("'>")
	    								.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>现场驻场人员（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getDesignDirectorId()))).append("</div>")
	    								.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
	    								if(null != childData.getDesignDirectorAuditDate()){
	    									tempChildSb.append(dateFormat.format(childData.getDesignDirectorAuditDate()));
	    								}
	    								tempChildSb.append("</div></td>").append("</tr>").append("</table>");
	    							}
	    							if(childData.getNeedManagerAudit()){
	    								tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
		    	    					.append("<tr style='font-size:15px;'>")
		    	    					.append("<td width='750' height='").append(childAuditHeight).append("'>")
		    	    					.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getManagerId()))).append("</div>")
		    	    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
		    	    					if(null != childData.getManagerAuditDate()){
		    	    						tempChildSb.append(dateFormat.format(childData.getManagerAuditDate()));
		    	    					}
		    	    					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
		        					}
	    						}else{
		    						if(childData.getNeedManagerAudit()){
		    							tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
		    	    					.append("<tr style='font-size:15px;'>")
		    	    					.append("<td width='750' height='").append(childAuditHeight).append("'>");
		    	    					if(!BaseHelpUtils.isNullOrEmpty(childData.getManagerComment())){
		    	    						tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(childData.getManagerComment()).replaceAll("\r\n", "<br>")).append("</div>");
		    	    					}
		    	    					tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getManagerId()))).append("</div>")
		    	    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
		    	    					if(null != childData.getManagerAuditDate()){
		    	    						tempChildSb.append(dateFormat.format(childData.getManagerAuditDate()));
		    	    					}
		    	    					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
		        					}
		        					if(childData.getNeedDesignDirectorAudit()){
		        						tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
		    	    					.append("<tr style='font-size:15px;'>")
		    	    					.append("<td width='750' height='").append(childAuditHeight).append("'>");
		    	    					if(!BaseHelpUtils.isNullOrEmpty(childData.getDesignDirectorComment())){
		    	    						tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(childData.getDesignDirectorComment()).replaceAll("\r\n", "<br>")).append("</div>");
		    	    					}
		    	    					tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>设计总监（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getDesignDirectorId()))).append("</div>")
		    	    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
		    	    					if(null != childData.getDesignDirectorAuditDate()){
		    	    						tempChildSb.append(dateFormat.format(childData.getDesignDirectorAuditDate()));
		    	    					}
		    	    					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
		        					}
	    						}
        					}
    						tempChildSb.append("</div>");
    					}
    					int auditHeight = height - 50;
    					if(data.getNeedManagerAudit() && data.getNeedDesignDirectorAudit()){
    						auditHeight = auditHeight / 2;
    					}
    					if(!data.getNeedManagerAudit() && !data.getNeedDesignDirectorAudit()){
    						sb.append("<div style='width:748px; margin-top:-2px; height:").append(auditHeight).append("px; border:1px solid;'></div>");
    						height -= auditHeight;
    					}else{
	    					if(data.getNeedManagerAudit()){
		    					sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
		    					.append("<tr style='font-size:15px;'>")
		    					.append("<td width='750' height='").append(auditHeight).append("'>")
		    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(data.getManagerComment()).replaceAll("\r\n", "<br>")).append("</div>")
		    					.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(data.getManagerId()))).append("</div>")
		    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
		    					if(null != data.getManagerAuditDate()){
		    						sb.append(dateFormat.format(data.getManagerAuditDate()));
		    					}
		    					sb.append("</div></td>").append("</tr>").append("</table>");
		    					height -= auditHeight;
	    					}
	    					if(data.getNeedDesignDirectorAudit()){
		    					sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
		    					.append("<tr style='font-size:15px;'>")
		    					.append("<td width='750' height='").append(auditHeight).append("'>")
		    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(data.getDesignDirectorComment()).replaceAll("\r\n", "<br>")).append("</div>")
		    					.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>设计总监（签字）：").append(BaseHelpUtils.getString(employeeMap.get(data.getDesignDirectorId()))).append("</div>")
		    					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
		    					if(null != data.getDesignDirectorAuditDate()){
		    						sb.append(dateFormat.format(data.getDesignDirectorAuditDate()));
		    					}
		    					sb.append("</div></td>").append("</tr>").append("</table>");
		    					height -= auditHeight;
	    					}
    					}
    					sb.append("</div>");
    					sb.append(tempChildSb.toString());
    				}
    			}else{
    				generatePrintHtml(sb, childList, businessType, contractDao, employeeMap);
    			}
    		}
    	}
    }
    
    public void generateSingleBeanPrintHtml(StringBuilder sb, BaseGetContractStageModelByParentId childData, String businessType, Contract contractDao, Map<Integer, String> employeeMap) throws Exception{
    	String childStageName = BaseHelpUtils.getString(childData.getStageModelName());
    	if(!childStageName.equals("策划") && childData.getLeafNode()){
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			ContractStageModel dao = new ContractStageModel();
			dao.setContractStageModelId(childData.getParentId());
			dao.unsetSelectFlags();
			dao.setSelectStageModelName(true);
			dao.setSelectParentId(true);
			dao.load();
			String stageName = BaseHelpUtils.getString(dao.getStageModelName());
			String parentStageName = "";
			if(null != dao.getParentId()){
				dao.setContractStageModelId(dao.getParentId());
				dao.load();
				parentStageName = BaseHelpUtils.getString(dao.getStageModelName());
			}
			sb.append("<div style='clear:both;'></div>");
			sb.append("<div style='height:1072px; min-height:1072px; max-height:1072px; width:750px; position: relative;'>")
			.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
			.append("<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
			.append(stageName)
			.append(childStageName)
			.append("</caption>")
			.append("<tr style='font-size:15px;'>")
			.append("<td width='90' height='42'>项目名称</td>")
			.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractName())).append("</td>")
			.append("<td width='90' height='42'>合同编号</td>")
			.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractCode())).append("</td>")
			.append("</tr>")
			.append("<tr style='font-size:15px;'>")
			.append("<td width='90' height='42'>项目类别</td>")
			.append("<td width='285' height='42'>").append(businessType).append("</td>")
			.append("<td width='90' height='42'>设计阶段</td>")
			.append("<td width='285' height='42'>").append(parentStageName).append("-").append(stageName).append("</td>")
			.append("</tr>");
			if(childStageName.contains("输入")||childStageName.contains("输出")||childStageName.contains("评审")){
				sb.append("<tr style='font-size:15px;'>")
				.append("<td width='90' height='425'>");
				if(childStageName.contains("评审")){
					sb.append("评<br>审<br>结<br>论");
				}else if(childStageName.contains("输出")){
					sb.append("设<br>计<br>输<br>出<br>信<br>息");
				}else if(childStageName.contains("输入")){
					sb.append("设<br>计<br>输<br>入<br>信<br>息");
				}
				sb.append("</td>");
				sb.append("<td width='660' height='450' colspan='3' style='text-align:left; padding-left:5px; padding-right:5px;'>")
				.append(BaseHelpUtils.getString(childData.getRemark()).replaceAll("\r\n", "<br>"))
				.append("</td>")
				.append("</tr>");
			}
			sb.append("</table>");
			int childAuditHeight = 0;
			if(childData.getNeedManagerAudit() && childData.getNeedDesignDirectorAudit()){
				childAuditHeight = 225;
			}else{
				childAuditHeight = 450;
			}
			if(!childData.getNeedManagerAudit() && !childData.getNeedDesignDirectorAudit()){
				sb.append("<div style='width:748px; margin-top:-2px; height:").append(childAuditHeight).append("px; border:1px solid;'></div>");
			}else{
				if(childStageName.contains(ON_SITE_SERVICE)){
					if(childData.getNeedDesignDirectorAudit()){
						sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
						.append("<tr style='font-size:15px;'>")
						.append("<td width='750' height='").append(childAuditHeight).append("'>")
						.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>现场驻场人员（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getDesignDirectorId()))).append("</div>")
						.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
						if(null != childData.getDesignDirectorAuditDate()){
							sb.append(dateFormat.format(childData.getDesignDirectorAuditDate()));
						}
						sb.append("</div></td>").append("</tr>").append("</table>");
					}
					if(childData.getNeedManagerAudit()){
						sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
						.append("<tr style='font-size:15px;'>")
						.append("<td width='750' height='").append(childAuditHeight).append("'>")
						.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getManagerId()))).append("</div>")
						.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
						if(null != childData.getManagerAuditDate()){
							sb.append(dateFormat.format(childData.getManagerAuditDate()));
						}
						sb.append("</div></td>").append("</tr>").append("</table>");
					}
				}else{
					if(childData.getNeedManagerAudit()){
						sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
						.append("<tr style='font-size:15px;'>")
						.append("<td width='750' height='").append(childAuditHeight).append("'>");
						if(!BaseHelpUtils.isNullOrEmpty(childData.getManagerComment())){
							sb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(childData.getManagerComment()).replaceAll("\r\n", "<br>")).append("</div>");
						}
						sb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getManagerId()))).append("</div>")
						.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
						if(null != childData.getManagerAuditDate()){
							sb.append(dateFormat.format(childData.getManagerAuditDate()));
						}
						sb.append("</div></td>").append("</tr>").append("</table>");
					}
					if(childData.getNeedDesignDirectorAudit()){
						sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
						.append("<tr style='font-size:15px;'>")
						.append("<td width='750' height='").append(childAuditHeight).append("'>");
						if(!BaseHelpUtils.isNullOrEmpty(childData.getDesignDirectorComment())){
							sb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(childData.getDesignDirectorComment()).replaceAll("\r\n", "<br>")).append("</div>");
						}
						sb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>设计总监（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getDesignDirectorId()))).append("</div>")
						.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
						if(null != childData.getDesignDirectorAuditDate()){
							sb.append(dateFormat.format(childData.getDesignDirectorAuditDate()));
						}
						sb.append("</div></td>").append("</tr>").append("</table>");
					}
				}
			}
			sb.append("</div>");
		}
    }
   
    public String selectProjectEmployeeAsManager(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	Integer[] ids = getIntegerArrFromString(BaseHelpUtils.getString(params.get("ids")));
    	if(null == ids){
    		return bc.toJSON(-1, "请先选择需要设定项目经理的节点");
    	}
    	Integer projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
    	Project dao = new Project();
    	dao.unsetSelectFlags();
    	dao.setSelectProjectManageId(true);
    	dao.setSelectPlateManagerId(true);
    	dao.setProjectId(projectId);
    	if(dao.load()){
    		Integer projectManager = dao.getProjectManageId();
    		Integer plateManager = dao.getPlateManagerId();
    		ContractStageModel modelDao = new ContractStageModel();
    		modelDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", (Object[]) ids);
    		List<BaseContractStageModel> list = modelDao.conditionalLoad();
    		for(BaseContractStageModel obj : list){
    			modelDao.clear();
    			modelDao.setDataFromBase(obj);
    			modelDao.clearModifiedFlags();
    			if(modelDao.getNeedManagerAudit()){
    				modelDao.setManagerId(projectManager);
    			}
    			//排除掉现场服务，是因为现场服务只需要项目经理和驻场人员审批，无需设计总监审批
    			if(modelDao.getNeedDesignDirectorAudit() && !BaseHelpUtils.getString(modelDao.getStageModelName()).contains(ON_SITE_SERVICE)){
    				modelDao.setDesignDirectorId(plateManager);
    			}
    			if(modelDao.isThisObjectModified()){
    				modelDao.update();
    			}
    		}
    		return bc.toJSON();
    	}else{
    		return bc.toJSON(-1, "订单不存在");
    	}
    }
    
    public String selectEmployeeAsManager(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	Integer[] ids = getIntegerArrFromString(BaseHelpUtils.getString(params.get("ids")));
    	if(null == ids){
    		return bc.toJSON(-1, "请先选择需要设定项目经理的节点");
    	}
    	Integer projectManager = BaseHelpUtils.getIntValue(params.get("employeeId"));
    	Employee employeeDao = new Employee();
    	employeeDao.setEmployeeId(projectManager);
    	employeeDao.unsetSelectFlags();
    	employeeDao.setSelectPlateId(true);
    	if(employeeDao.load()){
    		Integer plateManager = null;
    		ConditiongetEmployeeIdByRoleIdWithoutPlateRecord condition = new ConditiongetEmployeeIdByRoleIdWithoutPlateRecord();
    		condition.setPlateId(employeeDao.getPlateId());
    		condition.setRoleId(StaticUtils.ROLE_PLATE_MANAGER);
    		QuerygetEmployeeIdByRoleIdWithoutPlateRecord query = new QuerygetEmployeeIdByRoleIdWithoutPlateRecord();
    		BaseCollection<BasegetEmployeeIdByRoleId> collection = query.executeQuery(null, condition);
    		if (null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
    			plateManager = collection.getCollections().get(0).getEmployeeId();
    		}
    		ContractStageModel modelDao = new ContractStageModel();
    		modelDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", (Object[]) ids);
    		List<BaseContractStageModel> list = modelDao.conditionalLoad();
    		for(BaseContractStageModel obj : list){
    			modelDao.clear();
    			modelDao.setDataFromBase(obj);
    			modelDao.clearModifiedFlags();
    			if(modelDao.getNeedManagerAudit()){
    				modelDao.setManagerId(projectManager);
    			}
    			//排除掉现场服务，是因为现场服务只需要项目经理和驻场人员审批，无需设计总监审批
    			if(modelDao.getNeedDesignDirectorAudit() && !BaseHelpUtils.getString(modelDao.getStageModelName()).contains(ON_SITE_SERVICE) && null != plateManager){
    				modelDao.setDesignDirectorId(plateManager);
    			}
    			if(modelDao.isThisObjectModified()){
    				modelDao.update();
    			}
    		}
    		return bc.toJSON();
    		
    	}else{
    		return bc.toJSON(-1, "找不到该职员的信息");
    	}
    }
    
    public String selectEvidence(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	Integer[] ids = getIntegerArrFromString(BaseHelpUtils.getString(params.get("ids")));
    	if(null == ids){
    		return bc.toJSON(-1, "请选择需要证据佐证的节点");
    	}
    	String evidence = BaseHelpUtils.getString(params.get("evidence"));
    	Date date = new Date(BaseHelpUtils.getLongValue(params.get("confirmDate")));
    	Set<Integer> set = new HashSet<>();
		for(Integer id : ids){
			set.add(id);
			ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
			condition.setContractStageModelId(id);
			QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
			BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
			if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
				for(BaseGetContractStageModelByParentId tempBean : collection.getCollections()){
					if(null != tempBean.getContractStageModelId() && null == tempBean.getConfirmDate()){
						set.add(tempBean.getContractStageModelId());
					}
				}
			}
		}
    	if(set.size() > 0){
    		ContractStageModel dao = new ContractStageModel();
    		dao.clear();
    		dao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set.toArray());
        	dao.setEvidence(evidence);
        	dao.setConfirmDate(date);
        	dao.setHasEvidence(true);
        	dao.conditionalUpdate();
        	List<BaseContractStageModel> list = dao.conditionalLoad();
        	Random random = new Random();
        	for(BaseContractStageModel bean : list){
        		if(null != bean.getStageModelName() && (bean.getStageModelName().contains("现场服务50") || bean.getStageModelName().contains("现场服务100"))){
        			if(bean.getNeedDesignDirectorAudit() && null == bean.getDesignDirectorAuditDate()){
        				bean.setDesignDirectorAuditDate(date);
        			}
        			if(bean.getNeedManagerAudit() && null == bean.getManagerAuditDate()){
        				bean.setManagerAuditDate(date);
        			}
        		}else{
        			if(bean.getNeedDesignDirectorAudit() && null == bean.getDesignDirectorAuditDate()){
        				int result = random.nextInt(4);
        				bean.setDesignDirectorAuditDate(DateUtil.getNextDayOfDay(date, result));
        				bean.setDesignDirectorComment(0 == result % 2 ? "同意" : "通过");
        			}
        			if(bean.getNeedManagerAudit() && null == bean.getManagerAuditDate()){
        				bean.setManagerAuditDate(date);
        				bean.setManagerComment(0 == random.nextInt(2) ? "同意" : "通过");
        			}
        		}
        		if((bean.getLeafNode() && bean.getStageModelName().contains("评审"))){
        			bean.setRemark(0 == random.nextInt(2) ? "同意" : "通过");
        		}
        		dao.clear();
        		dao.setDataFromBase(bean);
        		dao.update();
        	}
    	}
    	return bc.toJSON();
    }
    
    public String loadAuditData(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseContractStageModelAuditData> bc = new BaseCollection<>();
    	ContractStageModel dao = new ContractStageModel();
    	dao.setContractStageModelId(BaseHelpUtils.getIntValue(params.get("contractStageModelId")));
    	if(dao.load()){
    		BaseContractStageModelAuditData bean = new BaseContractStageModelAuditData();
    		bean.setDataFromJSON(dao.generateBase().toJSON());
    		dao.clear();
			dao.setContractStageModelId(bean.getParentId());
			dao.unsetSelectFlags();
			dao.setSelectStageModelName(true);
			dao.setSelectParentId(true);
			dao.load();
			String stageName = BaseHelpUtils.getString(dao.getStageModelName());
			String parentStageName = "";
			if(null != dao.getParentId()){
				dao.setContractStageModelId(dao.getParentId());
				dao.load();
				parentStageName = BaseHelpUtils.getString(dao.getStageModelName());
			}
			bean.setParentStageName(parentStageName+"-"+stageName);
			bean.setBusinessType(getSuperStageName(bean.getContractStageModelId()).split("：")[0]);
			List<BaseContractStageModelAuditData> list = new ArrayList<>();
			list.add(bean);
			bc.setCollections(list);
			return bc.toJSON();
    	}else{
    		return bc.toJSON(-1, "找不到实体数据");
    	}
    }
    
    public Integer[] getIntegerArrFromString(String ids){
    	if(BaseHelpUtils.isNullOrEmpty(ids)){
    		return null;
    	}
    	String[] idStrArr = ids.split(",");
    	int length = idStrArr.length;
		Integer[] idArr = new Integer[length];
		for(int i = 0; i < length; i++){
			idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
		}
		return idArr;
    }
    
    public void 临时刷数据的方法(BigDecimal percent, Integer ContractStageModelId, int year) throws Exception{
    	//计算出营收百分比
		ConditionGetContractStageModelByParentId condition2 = new ConditionGetContractStageModelByParentId();
		condition2.setContractStageModelId(ContractStageModelId);
		QueryGetContractStageModelByParentId query2 = new QueryGetContractStageModelByParentId();
		BaseCollection<BaseGetContractStageModelByParentId> collection2 = query2.executeQuery(null, condition2);
		if(null != collection2 && null != collection2.getCollections() && !collection2.getCollections().isEmpty()){
			List<BaseGetContractStageModelByParentId> list = collection2.getCollections();
			List<BaseTree> tempTreeList = new ArrayList<>();
			List<BaseTree> treeList = new ArrayList<>();
			for(BaseGetContractStageModelByParentId obj : list){
				BaseTree treeNode = new BaseTree();
				treeNode.setId(obj.getContractStageModelId());
				treeNode.setParentId(obj.getParentId());
				treeNode.setData(obj);
				tempTreeList.add(treeNode);
			}
			treeList = TreeUtils.formatTree(tempTreeList);
			临时刷数据的方法calculateDataFromTree1(percent, treeList, year);
		}
    }
    
    
    public BigDecimal 临时刷数据的方法calculateDataFromTree1(BigDecimal percent, List<BaseTree> treeList, int year) throws Exception{
    	if(null != percent && percent.compareTo(BigDecimal.ZERO) > 0){
	    	for(BaseTree obj : treeList){
				if(null != obj.getChildren()){
					List<BaseTree> tempList = obj.getChildren();
					BaseGetContractStageModelByParentId bean = (BaseGetContractStageModelByParentId) tempList.get(0).getData();
					if(bean.getLeafNode()){
						for(BaseTree tempTreeBean : tempList){
							BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId) tempTreeBean.getData();
							if(data.getLocked()){
								//已锁定
//								percent = percent.subtract(data.getActualPercent());
								percent = percent.subtract(data.getPercent());
							}else{
								//未锁定
								ContractStageModel dao = new ContractStageModel();
								dao.setContractStageModelId(data.getContractStageModelId());
								dao.load();
								if(percent.compareTo(data.getPercent()) >= 0){
									percent = percent.subtract(data.getPercent());
									dao.setActualPercent(data.getPercent());
									dao.setYear(year);
									dao.setLocked(true);
									dao.update();
									if(percent.compareTo(BigDecimal.ZERO) <= 0){
										return BigDecimal.ZERO;
									}
								}else{
									dao.setActualPercent(percent);
									dao.setYear(year);
									dao.setLocked(true);
									dao.update();
									return BigDecimal.ZERO;
								}
							}
						}
						if(percent.compareTo(BigDecimal.ZERO) > 0){
							/**
							 * 如果不需要证据，直接跨过阶段计算可发布节点的话，把下面4行代码注释掉即可
							 */
//							if(!((BaseGetContractStageModelByParentId)obj.getData()).getHasEvidence()){
//								//没有取得证据，不可以继续
//								return BigDecimal.ZERO;
//							}
						}else{
							return percent;
						}
					}else{
						percent = 临时刷数据的方法calculateDataFromTree1(percent, tempList, year);
						if(percent.compareTo(BigDecimal.ZERO) <= 0){
							return BigDecimal.ZERO;
						}
					}
				}
			}
	    	return percent;
    	}else{
    		return BigDecimal.ZERO;
    	}
    }
    
    public void 临时刷父节点完成状态的方法(Integer ContractStageModelId) throws Exception{
    	//计算出营收百分比
    	ConditionGetContractStageModelByParentId condition2 = new ConditionGetContractStageModelByParentId();
    	condition2.setContractStageModelId(ContractStageModelId);
    	QueryGetContractStageModelByParentId query2 = new QueryGetContractStageModelByParentId();
    	BaseCollection<BaseGetContractStageModelByParentId> collection2 = query2.executeQuery(null, condition2);
    	if(null != collection2 && null != collection2.getCollections() && !collection2.getCollections().isEmpty()){
    		List<BaseGetContractStageModelByParentId> list = collection2.getCollections();
    		List<BaseTree> tempTreeList = new ArrayList<>();
    		List<BaseTree> treeList = new ArrayList<>();
    		for(BaseGetContractStageModelByParentId obj : list){
    			BaseTree treeNode = new BaseTree();
    			treeNode.setId(obj.getContractStageModelId());
    			treeNode.setParentId(obj.getParentId());
    			treeNode.setData(obj);
    			tempTreeList.add(treeNode);
    		}
    		treeList = TreeUtils.formatTree(tempTreeList);
    		临时刷父节点完成状态的方法calculateDataFromTree1(treeList);
    	}
    }
    
    
	public void 临时刷父节点完成状态的方法calculateDataFromTree1(List<BaseTree> treeList) throws Exception {
		Random aa = new Random();
		for (BaseTree obj : treeList) {
			if (null != obj.getChildren()) {
				List<BaseTree> tempList = obj.getChildren();
				BaseGetContractStageModelByParentId bean = (BaseGetContractStageModelByParentId) tempList.get(0)
						.getData();
				if (bean.getLeafNode()) {
					int size = tempList.size();
					Date date = null;
					int num = 0;
					for (int i = 0; i < size; i++) {
						BaseTree tempTreeBean = tempList.get(i);
						BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId) tempTreeBean
								.getData();
						if (data.getProcessStatus() == 3) {
							num++;
						}
						if (i == size - 1) {
							date = data.getConfirmDate();
						}
					}
					if (num == size) {
						// 该节点下的所有叶子节点都已经审批完成，则父节点也改为审批完成
						BaseGetContractStageModelByParentId parentBean = (BaseGetContractStageModelByParentId) obj
								.getData();
						ContractStageModel dao = new ContractStageModel();
						dao.setConditionContractStageModelId("=", parentBean.getContractStageModelId());
						dao.setProcessStatus(3);
						if(null != date){
							if(parentBean.getNeedManagerAudit() && null == parentBean.getManagerAuditDate()){
								dao.setManagerAuditDate(date);
							}
							if(parentBean.getNeedDesignDirectorAudit() && null == parentBean.getDesignDirectorAuditDate()){
								dao.setDesignDirectorAuditDate(DateUtil.getNextDayOfDay(date, aa.nextInt(4)));
							}
							dao.setConfirmDate(date);
						}
						dao.conditionalUpdate();
					}
				} else {
					临时刷父节点完成状态的方法calculateDataFromTree1(tempList);
				}
			}
		}
	}
    
    public void 临时刷数据日期的方法(BigDecimal percent, Integer contractId, Date date, boolean updateYear) throws Exception{
    	ContractStageModel dao = new ContractStageModel();
    	dao.setConditionContractId("=", contractId);
    	dao.setConditionParentId("=", 0);
    	Integer ContractStageModelId = dao.executeQueryOneRow().getContractStageModelId();
    	//计算出营收百分比
		ConditionGetContractStageModelByParentId condition2 = new ConditionGetContractStageModelByParentId();
		condition2.setContractStageModelId(ContractStageModelId);
		QueryGetContractStageModelByParentId query2 = new QueryGetContractStageModelByParentId();
		BaseCollection<BaseGetContractStageModelByParentId> collection2 = query2.executeQuery(null, condition2);
		if(null != collection2 && null != collection2.getCollections() && !collection2.getCollections().isEmpty()){
			List<BaseGetContractStageModelByParentId> list = collection2.getCollections();
			List<BaseTree> tempTreeList = new ArrayList<>();
			List<BaseTree> treeList = new ArrayList<>();
			for(BaseGetContractStageModelByParentId obj : list){
				BaseTree treeNode = new BaseTree();
				treeNode.setId(obj.getContractStageModelId());
				treeNode.setParentId(obj.getParentId());
				treeNode.setData(obj);
				tempTreeList.add(treeNode);
			}
			treeList = TreeUtils.formatTree(tempTreeList);
			临时刷数据日期的方法calculateDataFromTree1(percent, treeList, date, updateYear);
		}
    }
    
    public BigDecimal 临时刷数据日期的方法calculateDataFromTree1(BigDecimal percent, List<BaseTree> treeList, Date date, boolean updateYear) throws Exception{
    	if(null != percent && percent.compareTo(BigDecimal.ZERO) > 0){
    		Random random=new Random();
	    	for(BaseTree obj : treeList){
				if(null != obj.getChildren()){
					List<BaseTree> tempList = obj.getChildren();
					BaseGetContractStageModelByParentId bean = (BaseGetContractStageModelByParentId) tempList.get(0).getData();
					if(bean.getLeafNode()){
						for(BaseTree tempTreeBean : tempList){
							BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId) tempTreeBean.getData();
							if(data.getLocked()){
								//已锁定
//								percent = percent.subtract(data.getActualPercent());
								percent = percent.subtract(data.getPercent());
								if(null == data.getConfirmDate()){
									ContractStageModel dao = new ContractStageModel();
									dao.setContractStageModelId(data.getContractStageModelId());
									dao.load();
									dao.setConfirmDate(date);
									if(updateYear){
										dao.setYear(date.getYear()+1900);
									}
									if(data.getStageModelName().contains("现场服务50%") || data.getStageModelName().contains("现场服务100%")){
										if(data.getNeedDesignDirectorAudit()){
											dao.setDesignDirectorAuditDate(date);
											if(data.getNeedManagerAudit()){
												int result=random.nextInt(4);
												dao.setManagerAuditDate(DateUtil.getNextDayOfDay(date, result));
											}
										}
									}else{
										if(data.getNeedManagerAudit()){
											dao.setManagerAuditDate(date);
											if(data.getNeedDesignDirectorAudit()){
												int result=random.nextInt(4);
												dao.setDesignDirectorAuditDate(DateUtil.getNextDayOfDay(date, result));
											}
										}
									}
									dao.update();
								}
								if(percent.compareTo(BigDecimal.ZERO) <= 0){
									return BigDecimal.ZERO;
								}
							}
						}
						if(percent.compareTo(BigDecimal.ZERO) > 0){
							/**
							 * 如果不需要证据，直接跨过阶段计算可发布节点的话，把下面4行代码注释掉即可
							 */
//							if(!((BaseGetContractStageModelByParentId)obj.getData()).getHasEvidence()){
//								//没有取得证据，不可以继续
//								return BigDecimal.ZERO;
//							}
						}else{
							return percent;
						}
					}else{
						percent = 临时刷数据日期的方法calculateDataFromTree1(percent, tempList, date, updateYear);
						if(percent.compareTo(BigDecimal.ZERO) <= 0){
							return BigDecimal.ZERO;
						}
					}
				}
			}
	    	return percent;
    	}else{
    		return BigDecimal.ZERO;
    	}
    }
    
    public String getLastPointPrintHtmlByYear(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseKeyValue> bc = new BaseCollection<>();
    	int year = BaseHelpUtils.getIntValue(params.get("year"));
    	ContractStageModel stageDao = new ContractStageModel();
    	stageDao.setConditionYear("=", year);
    	List<BaseContractStageModel> stageList = stageDao.conditionalLoad();
    	Set<Integer> contractIdSet = new HashSet<>();
    	for(BaseContractStageModel stage : stageList) {
    		if(null != stage.getContractId()) {
    			contractIdSet.add(stage.getContractId());
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append("<style> *{font-family:'微软雅黑';} th{font-weight:normal;} td{text-align:center;} .print_page_split{page-break-after:always;} </style>");
    	for(Integer contractId : contractIdSet) {
    		stageDao.clear();
        	stageDao.setConditionContractId("=", contractId);
        	stageDao.setConditionYear("=", year);
        	Set<Integer> employeeIdSet = new HashSet<>();
        	BaseContractStageModel bean = stageDao.executeQueryOneRow("order by " + BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID + " desc");
        	if(null == bean){
        		continue;
        	}
        	if(null != bean.getManagerId()){
				employeeIdSet.add(bean.getManagerId());
			}
			if(null != bean.getDesignDirectorId()){
				employeeIdSet.add(bean.getDesignDirectorId());
			}
			//获取相关人员的名字
			Map<Integer, String> employeeMap = new HashMap<>();
			if(employeeIdSet.size() > 0){
				Employee employeeDao = new Employee();
				employeeDao.unsetSelectFlags();
				employeeDao.setSelectEmployeeId(true);
				employeeDao.setSelectEmployeeName(true);
				employeeDao.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", employeeIdSet.toArray());
				List<BaseEmployee> employeeList = employeeDao.conditionalLoad();
				for(BaseEmployee employeeBean : employeeList){
					employeeMap.put(employeeBean.getEmployeeId(), employeeBean.getEmployeeName());
				}
			}
			Contract contractDao = new Contract();
			contractDao.setContractId(contractId);
			contractDao.load();
			stageDao.clear();
        	stageDao.setConditionContractId("=", contractId);
        	stageDao.setConditionParentId("=", 0);
        	BaseContractStageModel k = stageDao.executeQueryOneRow();
			String businessType = k.getStageModelName().split("：")[0];
			//生成打印的html
			generateLastPointPrintHtmlByYear(sb, bean, businessType, contractDao, employeeMap, year);
    	}
    	BaseKeyValue bean = new BaseKeyValue();
    	bean.setKey("htmlStr");
    	int position = sb.toString().lastIndexOf("print_page_split");
    	bean.setValue(sb.toString().substring(0, position)+sb.toString().substring(position+16));
    	List<BaseKeyValue> tempList = new ArrayList<>();
    	tempList.add(bean);
    	bc.setCollections(tempList);
    	return bc.toJSON();
    	
    }
    /**
     * 打印指定年度的合同小节点信息
     * @param params
     * @return
     * @throws Exception
     */
    public String getPrintHtmlByYear(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseKeyValue> bc = new BaseCollection<>();
    	int year = BaseHelpUtils.getIntValue(params.get("year"));
    	String contractIds = BaseHelpUtils.getString(params.get("contractIds"));
    	ContractStageModel stageDao = new ContractStageModel();
    	stageDao.setConditionYear("=", year);
    	stageDao.setConditionLeafNode("=", true);
    	StringBuilder contractSB = new StringBuilder();
    	if(!BaseHelpUtils.isNullOrEmpty(contractIds)) {
    		contractSB.append(BaseContractStageModel.CS_CONTRACT_ID).append(" in (").append(contractIds).append(")");
    	}
    	List<BaseContractStageModel> stageList = stageDao.conditionalLoad(contractSB.toString());
    	if(null == stageList || stageList.isEmpty()) {
    		return bc.toJSON(-1, year + "年没有数据可以打印");
    	}
    	Set<Integer> contractIdSet = new HashSet<>();
    	for(BaseContractStageModel stage : stageList) {
    		if(null != stage.getContractId()) {
    			contractIdSet.add(stage.getContractId());
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append("<style> *{font-family:'微软雅黑';} th{font-weight:normal;} td{text-align:center;} .print_page_split{page-break-after:always;} </style>");
    	for(Integer contractId : contractIdSet) {
    		stageDao.clear();
        	stageDao.setConditionContractId("=", contractId);
        	stageDao.setConditionParentId("=", 0);
        	stageList = stageDao.conditionalLoad();
        	if(null == stageList || stageList.isEmpty()){
        		continue;
        	}
    		for(BaseContractStageModel stage : stageList){
    			ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
    			condition.setContractStageModelId(stage.getContractStageModelId());
    			QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
    			BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
    			if(null == collection || null == collection.getCollections() || collection.getCollections().isEmpty()) {
    				continue;
    			}
				List<BaseGetContractStageModelByParentId> list = collection.getCollections();
				List<BaseTree> tempTreeList = new ArrayList<>();
				List<BaseTree> treeList = new ArrayList<>();
				Set<Integer> employeeIdSet = new HashSet<>();
				for(BaseGetContractStageModelByParentId obj : list){
					if(null != obj.getManagerId()){
						employeeIdSet.add(obj.getManagerId());
					}
					if(null != obj.getDesignDirectorId()){
						employeeIdSet.add(obj.getDesignDirectorId());
					}
					BaseTree treeNode = new BaseTree();
					treeNode.setId(obj.getContractStageModelId());
					treeNode.setParentId(obj.getParentId());
					treeNode.setData(obj);
					tempTreeList.add(treeNode);
				}
				treeList = TreeUtils.formatTree(tempTreeList);
				BaseGetContractStageModelByParentId superParent = (BaseGetContractStageModelByParentId) treeList.get(0).getData();
				String businessType = getSuperStageName(contractId).split("：")[0];
				Contract contractDao = new Contract();
				contractDao.setContractId(BaseHelpUtils.getIntValue(superParent.getContractId()));
				contractDao.unsetSelectFlags();
				contractDao.setSelectContractCode(true);
				contractDao.setSelectContractName(true);
				contractDao.setSelectProjectAddress(true);
				contractDao.load();
				//获取相关人员的名字
				Map<Integer, String> employeeMap = new HashMap<>();
				if(employeeIdSet.size() > 0){
					Employee employeeDao = new Employee();
					employeeDao.unsetSelectFlags();
					employeeDao.setSelectEmployeeId(true);
					employeeDao.setSelectEmployeeName(true);
					employeeDao.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", employeeIdSet.toArray());
					List<BaseEmployee> employeeList = employeeDao.conditionalLoad();
					for(BaseEmployee employeeBean : employeeList){
						employeeMap.put(employeeBean.getEmployeeId(), employeeBean.getEmployeeName());
					}
				}
				//带子节点打印
				generatePrintHtmlByYear(sb, treeList, businessType, contractDao, employeeMap, year);
    		}
    	}
    	BaseKeyValue bean = new BaseKeyValue();
    	bean.setKey("htmlStr");
    	int position = sb.toString().lastIndexOf("print_page_split");
    	bean.setValue(sb.toString().substring(0, position)+sb.toString().substring(position+16));
    	List<BaseKeyValue> tempList = new ArrayList<>();
    	tempList.add(bean);
    	bc.setCollections(tempList);
    	return bc.toJSON();
    }
    /**
     * 打印合同下的2017年所有已完成节点的信息
     * @param params
     * @return
     * @throws Exception
     */
    public String get2017PrintHtml(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseKeyValue> bc = new BaseCollection<>();
    	int id = BaseHelpUtils.getIntValue(params.get("contractId"));
    	int year = 2017;
    	ContractStageModel stageDao = new ContractStageModel();
    	stageDao.setConditionContractId("=", id);
    	stageDao.setConditionYear("=", year);
    	if(stageDao.countRows() == 0){
    		return bc.toJSON(-1, "该合同2017年没有数据可供打印");
    	}
    	stageDao.clear();
    	stageDao.setConditionContractId("=", id);
    	stageDao.setConditionParentId("=", 0);
    	List<BaseContractStageModel> stageList = stageDao.conditionalLoad();
    	if(null != stageList && !stageList.isEmpty()){
    		StringBuilder sb = new StringBuilder();
    		for(BaseContractStageModel stage : stageList){
    			ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
    			condition.setContractStageModelId(stage.getContractStageModelId());
    			QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
    			BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
    			if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
    				List<BaseGetContractStageModelByParentId> list = collection.getCollections();
    				List<BaseTree> tempTreeList = new ArrayList<>();
    				List<BaseTree> treeList = new ArrayList<>();
    				Set<Integer> employeeIdSet = new HashSet<>();
    				for(BaseGetContractStageModelByParentId obj : list){
    					if(null != obj.getManagerId()){
    						employeeIdSet.add(obj.getManagerId());
    					}
    					if(null != obj.getDesignDirectorId()){
    						employeeIdSet.add(obj.getDesignDirectorId());
    					}
    					BaseTree treeNode = new BaseTree();
    					treeNode.setId(obj.getContractStageModelId());
    					treeNode.setParentId(obj.getParentId());
    					treeNode.setData(obj);
    					tempTreeList.add(treeNode);
    				}
    				treeList = TreeUtils.formatTree(tempTreeList);
    				BaseGetContractStageModelByParentId superParent = (BaseGetContractStageModelByParentId) treeList.get(0).getData();
    				String businessType = getSuperStageName(id).split("：")[0];
    				Contract contractDao = new Contract();
    				contractDao.setContractId(BaseHelpUtils.getIntValue(superParent.getContractId()));
    				contractDao.unsetSelectFlags();
    				contractDao.setSelectContractCode(true);
    				contractDao.setSelectContractName(true);
    				contractDao.setSelectProjectAddress(true);
    				contractDao.load();
    				//获取相关人员的名字
    				Map<Integer, String> employeeMap = new HashMap<>();
    				if(employeeIdSet.size() > 0){
    					Employee employeeDao = new Employee();
    					employeeDao.unsetSelectFlags();
    					employeeDao.setSelectEmployeeId(true);
    					employeeDao.setSelectEmployeeName(true);
    					employeeDao.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", employeeIdSet.toArray());
    					List<BaseEmployee> employeeList = employeeDao.conditionalLoad();
    					for(BaseEmployee employeeBean : employeeList){
    						employeeMap.put(employeeBean.getEmployeeId(), employeeBean.getEmployeeName());
    					}
    				}
    				sb.append("<style> *{font-family:'微软雅黑';} th{font-weight:normal;} td{text-align:center;} .print_page_split{page-break-after:always;} </style>");
					//带子节点打印
    				generatePrintHtmlByYear(sb, treeList, businessType, contractDao, employeeMap, year);
    			}else{
    				return bc.toJSON(-1, "找不到实体数据");
    			}
    		}
    		BaseKeyValue bean = new BaseKeyValue();
    		bean.setKey("htmlStr");
    		int position = sb.toString().lastIndexOf("print_page_split");
    		bean.setValue(sb.toString().substring(0, position)+sb.toString().substring(position+16));
    		List<BaseKeyValue> tempList = new ArrayList<>();
    		tempList.add(bean);
    		bc.setCollections(tempList);
    		return bc.toJSON();
    	}else{
			return bc.toJSON(-1, "找不到实体数据");
		}
    }
    public void generateLastPointPrintHtmlByYear(StringBuilder sb, BaseContractStageModel bean, String businessType, Contract contractDao, Map<Integer, String> employeeMap, int year) throws Exception{
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    	//叶子节点的上一级
		String parentStageName = BaseHelpUtils.getString("未知的父级名称");
		ContractStageModel dao = new ContractStageModel();
		dao.setContractStageModelId(bean.getParentId());
		dao.load();
		String stageName = dao.getStageModelName();
		if(dao.getParentId().intValue() != 0) {
			dao.setContractStageModelId(dao.getParentId());
			dao.load();
			parentStageName = dao.getStageModelName() + "-" + stageName;
		}
		int height = 1097;
		StringBuilder tempChildSb = new StringBuilder();
		String childStageName = BaseHelpUtils.getString(bean.getStageModelName());
		tempChildSb.append("<div style='clear:both;'></div>");
		tempChildSb.append("<div style='height:1082px; min-height:1082px; max-height:1082px; width:750px; position: relative;' class='print_page_split'>")
		.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
		.append("<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
		.append(stageName)
		.append(childStageName)
		.append("</caption>")
		.append("<tr style='font-size:15px;'>")
		.append("<td width='90' height='42'>项目名称</td>")
		.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractName())).append("</td>")
		.append("<td width='90' height='42'>合同编号</td>")
		.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractCode())).append("</td>")
		.append("</tr>")
		.append("<tr style='font-size:15px;'>")
		.append("<td width='90' height='42'>项目类别</td>")
		.append("<td width='285' height='42'>").append(businessType).append("</td>")
		.append("<td width='90' height='42'>设计阶段</td>")
		.append("<td width='285' height='42'>").append(parentStageName).append("</td>")
		.append("</tr>");
		if(childStageName.contains("输入")||childStageName.contains("输出")||childStageName.contains("评审")){
			tempChildSb.append("<tr style='font-size:15px;'>")
			.append("<td width='90' height='425'>");
			if(childStageName.contains("评审")){
				tempChildSb.append("评<br>审<br>结<br>论");
			}else if(childStageName.contains("输出")){
				tempChildSb.append("设<br>计<br>输<br>出<br>信<br>息");
			}else if(childStageName.contains("输入")){
				tempChildSb.append("设<br>计<br>输<br>入<br>信<br>息");
			}
			tempChildSb.append("</td>");
			tempChildSb.append("<td width='660' height='450' colspan='3' style='text-align:left; padding-left:5px; padding-right:5px; line-height:25px;'>")
			.append(BaseHelpUtils.getString(bean.getRemark()).replaceAll("\r\n", "<br>"))
			.append("</td>")
			.append("</tr>");
		}
		tempChildSb.append("</table>");
		int childAuditHeight = 0;
		if(bean.getNeedManagerAudit() && bean.getNeedDesignDirectorAudit()){
			childAuditHeight = 225;
		}else{
			childAuditHeight = 450;
		}
		if(!bean.getNeedManagerAudit() && !bean.getNeedDesignDirectorAudit()){
			tempChildSb.append("<div style='width:748px; margin-top:-2px; height:").append(childAuditHeight).append("px; border:1px solid;'></div>");
		}else{
			if(childStageName.contains(ON_SITE_SERVICE)){
				if(bean.getNeedDesignDirectorAudit()){
					tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
					.append("<tr style='font-size:15px;'>")
					.append("<td width='750' height='").append(childAuditHeight).append("'>")
					.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>现场驻场人员（签字）：").append(BaseHelpUtils.getString(employeeMap.get(bean.getDesignDirectorId()))).append("</div>")
					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
					if(null != bean.getDesignDirectorAuditDate()){
						tempChildSb.append(dateFormat.format(bean.getDesignDirectorAuditDate()));
					}
					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
				}
				if(bean.getNeedManagerAudit()){
					tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
					.append("<tr style='font-size:15px;'>")
					.append("<td width='750' height='").append(childAuditHeight).append("'>")
					.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(bean.getManagerId()))).append("</div>")
					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
					if(null != bean.getManagerAuditDate()){
						tempChildSb.append(dateFormat.format(bean.getManagerAuditDate()));
					}
					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
				}
			}else{
				if(bean.getNeedManagerAudit()){
					tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
					.append("<tr style='font-size:15px;'>")
					.append("<td width='750' height='").append(childAuditHeight).append("'>");
					if(!BaseHelpUtils.isNullOrEmpty(bean.getManagerComment())){
						tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(bean.getManagerComment()).replaceAll("\r\n", "<br>")).append("</div>");
					}
					tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(bean.getManagerId()))).append("</div>")
					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
					if(null != bean.getManagerAuditDate()){
						tempChildSb.append(dateFormat.format(bean.getManagerAuditDate()));
					}
					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
				}
				if(bean.getNeedDesignDirectorAudit()){
					tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
					.append("<tr style='font-size:15px;'>")
					.append("<td width='750' height='").append(childAuditHeight).append("'>");
					if(!BaseHelpUtils.isNullOrEmpty(bean.getDesignDirectorComment())){
						tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(bean.getDesignDirectorComment()).replaceAll("\r\n", "<br>")).append("</div>");
					}
					tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>设计总监（签字）：").append(BaseHelpUtils.getString(employeeMap.get(bean.getDesignDirectorId()))).append("</div>")
					.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
					if(null != bean.getDesignDirectorAuditDate()){
						tempChildSb.append(dateFormat.format(bean.getDesignDirectorAuditDate()));
					}
					tempChildSb.append("</div></td>").append("</tr>").append("</table>");
				}
			}
		}
		tempChildSb.append("</div>");
		int auditHeight = height - 50;
		if(bean.getNeedManagerAudit() && bean.getNeedDesignDirectorAudit()){
			auditHeight = auditHeight / 2;
		}
		sb.append(tempChildSb.toString());
    }
    
    
    public void generatePrintHtmlByYear(StringBuilder sb, List<BaseTree> list, String businessType, Contract contractDao, Map<Integer, String> employeeMap, int year) throws Exception{
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    	for(BaseTree obj : list){
    		if(obj.getChildren() != null){
    			List<BaseTree> childList = obj.getChildren(); 
    			if(((BaseGetContractStageModelByParentId)childList.get(0).getData()).getLeafNode()){
    				boolean status = false;
    				for(BaseTree treeBean : childList){
    					BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId)(treeBean.getData());
    					if(null != data.getYear() && data.getYear().intValue() == year){
    						status = true;
    						break;
    					}
    				}
    				if(status){
    					//叶子节点的上一级
    					BaseGetContractStageModelByParentId data = (BaseGetContractStageModelByParentId) obj.getData();
    					ContractStageModel dao = new ContractStageModel();
    					dao.setContractStageModelId(data.getParentId());
    					dao.unsetSelectFlags();
    					dao.setSelectStageModelName(true);
    					dao.load();
    					String parentStageName = BaseHelpUtils.getString(dao.getStageModelName());
    					String stageName = data.getStageModelName();
    					int height = 1097;
    					if(null != stageName && !stageName.contains("现场") && !stageName.contains("竣工")){
    						sb.append("<div style='clear:both;'></div>");
    						sb.append("<div style='height:1082px; min-height:1082px; max-height:1082px; width:750px; position: relative;' class='print_page_split'>")
    						.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
    						.append("<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
    						.append(stageName)
    						.append("策划进度表</caption>")
    						.append("<tr style='font-size:15px;'>")
    						.append("<td width='90' height='42'>项目名称</td>")
    						.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractName())).append("</td>")
    						.append("<td width='90' height='42'>合同编号</td>")
    						.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractCode())).append("</td>")
    						.append("</tr>")
    						.append("<tr style='font-size:15px;'>")
    						.append("<td width='90' height='42'>项目类别</td>")
    						.append("<td width='285' height='42'>").append(businessType).append("</td>")
    						.append("<td width='90' height='42'>项目地点</td>")
    						.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getProjectAddress())).append("</td>")
    						.append("</tr>")
    						.append("<tr style='font-size:15px;'><td width='90' height='42' colspan='4'>").append(stageName).append("完成时点（");
    						height = height - 44 * 3 - 75;
    						if(null != data.getConfirmDate()){
    							sb.append(dateFormat.format(data.getConfirmDate()));
    						}
    						sb.append("）</td></tr>");
    						sb.append("</table>");
    						int trSize = 0;
    						StringBuilder tempSb = new StringBuilder();
    						StringBuilder tempChildSb = new StringBuilder();
    						for(int i = 0; i < childList.size(); i++){
    							BaseTree child = childList.get(i);
    							BaseGetContractStageModelByParentId childData = (BaseGetContractStageModelByParentId) child.getData();
    							String childStageName = BaseHelpUtils.getString(childData.getStageModelName());
    							if(childStageName.equals("策划")){
    								continue;
    							}
    							if(childStageName.contains("输出") || childStageName.contains("评审")){
    								if(trSize == 0){
    									height -= 88;
    									sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    									.append("<tr style='font-size:15px;'>");
    									tempSb.delete(0, tempSb.length());
    									tempSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    									.append("<tr style='font-size:15px;'>");
    								}
    								sb.append("<td width='187.5' height='42'>").append(BaseHelpUtils.getString(childData.getStageModelName())).append("</td>");
    								if(BaseHelpUtils.getIntValue(childData.getProcessStatus()) == CONTRACT_STAGE_PROCESS_STATUS_3){
    									tempSb.append("<td width='187.5' height='42'>已完成</td>");
    								}else{
    									tempSb.append("<td width='187.5' height='42'>未完成</td>");
    								}
    								if(trSize < 3){
    									trSize++;
    									if(i == childList.size() - 1){
    										sb.append("</tr>").append("</table>");
    										sb.append(tempSb.toString()).append("</tr>").append("</table>");
    									}
    								}else{
    									sb.append("</tr>").append("</table>");
    									sb.append(tempSb.toString()).append("</tr>").append("</table>");
    									trSize = 0;
    								}
    							}
    							if(null == childData.getYear() || childData.getYear().intValue() != year){
    								continue;
    							}
    							tempChildSb.append("<div style='clear:both;'></div>");
    							tempChildSb.append("<div style='height:1082px; min-height:1082px; max-height:1082px; width:750px; position: relative;' class='print_page_split'>")
    							.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>")
    							.append("<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>")
    							.append(stageName)
    							.append(childStageName)
    							.append("</caption>")
    							.append("<tr style='font-size:15px;'>")
    							.append("<td width='90' height='42'>项目名称</td>")
    							.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractName())).append("</td>")
    							.append("<td width='90' height='42'>合同编号</td>")
    							.append("<td width='285' height='42'>").append(BaseHelpUtils.getString(contractDao.getContractCode())).append("</td>")
    							.append("</tr>")
    							.append("<tr style='font-size:15px;'>")
    							.append("<td width='90' height='42'>项目类别</td>")
    							.append("<td width='285' height='42'>").append(businessType).append("</td>")
    							.append("<td width='90' height='42'>设计阶段</td>")
    							.append("<td width='285' height='42'>").append(parentStageName).append("-").append(stageName).append("</td>")
    							.append("</tr>");
    							if(childStageName.contains("输入")||childStageName.contains("输出")||childStageName.contains("评审")){
    								tempChildSb.append("<tr style='font-size:15px;'>")
    								.append("<td width='90' height='425'>");
    								if(childStageName.contains("评审")){
    									tempChildSb.append("评<br>审<br>结<br>论");
    								}else if(childStageName.contains("输出")){
    									tempChildSb.append("设<br>计<br>输<br>出<br>信<br>息");
    								}else if(childStageName.contains("输入")){
    									tempChildSb.append("设<br>计<br>输<br>入<br>信<br>息");
    								}
    								tempChildSb.append("</td>");
    								tempChildSb.append("<td width='660' height='450' colspan='3' style='text-align:left; padding-left:5px; padding-right:5px; line-height:25px;'>")
    								.append(BaseHelpUtils.getString(childData.getRemark()).replaceAll("\r\n", "<br>"))
    								.append("</td>")
    								.append("</tr>");
    							}
    							tempChildSb.append("</table>");
    							int childAuditHeight = 0;
    							if(childData.getNeedManagerAudit() && childData.getNeedDesignDirectorAudit()){
    								childAuditHeight = 225;
    							}else{
    								childAuditHeight = 450;
    							}
    							if(!childData.getNeedManagerAudit() && !childData.getNeedDesignDirectorAudit()){
    								tempChildSb.append("<div style='width:748px; margin-top:-2px; height:").append(childAuditHeight).append("px; border:1px solid;'></div>");
    							}else{
    								if(childStageName.contains(ON_SITE_SERVICE)){
    									if(childData.getNeedDesignDirectorAudit()){
    										tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    										.append("<tr style='font-size:15px;'>")
    										.append("<td width='750' height='").append(childAuditHeight).append("'>")
    										.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>现场驻场人员（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getDesignDirectorId()))).append("</div>")
    										.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
    										if(null != childData.getDesignDirectorAuditDate()){
    											tempChildSb.append(dateFormat.format(childData.getDesignDirectorAuditDate()));
    										}
    										tempChildSb.append("</div></td>").append("</tr>").append("</table>");
    									}
    									if(childData.getNeedManagerAudit()){
    										tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    										.append("<tr style='font-size:15px;'>")
    										.append("<td width='750' height='").append(childAuditHeight).append("'>")
    										.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getManagerId()))).append("</div>")
    										.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
    										if(null != childData.getManagerAuditDate()){
    											tempChildSb.append(dateFormat.format(childData.getManagerAuditDate()));
    										}
    										tempChildSb.append("</div></td>").append("</tr>").append("</table>");
    									}
    								}else{
    									if(childData.getNeedManagerAudit()){
    										tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    										.append("<tr style='font-size:15px;'>")
    										.append("<td width='750' height='").append(childAuditHeight).append("'>");
    										if(!BaseHelpUtils.isNullOrEmpty(childData.getManagerComment())){
    											tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(childData.getManagerComment()).replaceAll("\r\n", "<br>")).append("</div>");
    										}
    										tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getManagerId()))).append("</div>")
    										.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
    										if(null != childData.getManagerAuditDate()){
    											tempChildSb.append(dateFormat.format(childData.getManagerAuditDate()));
    										}
    										tempChildSb.append("</div></td>").append("</tr>").append("</table>");
    									}
    									if(childData.getNeedDesignDirectorAudit()){
    										tempChildSb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    										.append("<tr style='font-size:15px;'>")
    										.append("<td width='750' height='").append(childAuditHeight).append("'>");
    										if(!BaseHelpUtils.isNullOrEmpty(childData.getDesignDirectorComment())){
    											tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(childData.getDesignDirectorComment()).replaceAll("\r\n", "<br>")).append("</div>");
    										}
    										tempChildSb.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>设计总监（签字）：").append(BaseHelpUtils.getString(employeeMap.get(childData.getDesignDirectorId()))).append("</div>")
    										.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
    										if(null != childData.getDesignDirectorAuditDate()){
    											tempChildSb.append(dateFormat.format(childData.getDesignDirectorAuditDate()));
    										}
    										tempChildSb.append("</div></td>").append("</tr>").append("</table>");
    									}
    								}
    							}
    							tempChildSb.append("</div>");
    						}
    						int auditHeight = height - 50;
    						if(data.getNeedManagerAudit() && data.getNeedDesignDirectorAudit()){
    							auditHeight = auditHeight / 2;
    						}
    						if(!data.getNeedManagerAudit() && !data.getNeedDesignDirectorAudit()){
    							sb.append("<div style='width:748px; margin-top:-2px; height:").append(auditHeight).append("px; border:1px solid;'></div>");
    							height -= auditHeight;
    						}else{
    							if(data.getNeedManagerAudit()){
    								sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    								.append("<tr style='font-size:15px;'>")
    								.append("<td width='750' height='").append(auditHeight).append("'>")
    								.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(data.getManagerComment()).replaceAll("\r\n", "<br>")).append("</div>")
    								.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>项目经理（签字）：").append(BaseHelpUtils.getString(employeeMap.get(data.getManagerId()))).append("</div>")
    								.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
    								if(null != data.getManagerAuditDate()){
    									sb.append(dateFormat.format(data.getManagerAuditDate()));
    								}
    								sb.append("</div></td>").append("</tr>").append("</table>");
    								height -= auditHeight;
    							}
    							if(data.getNeedDesignDirectorAudit()){
    								sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>")
    								.append("<tr style='font-size:15px;'>")
    								.append("<td width='750' height='").append(auditHeight).append("'>")
    								.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>审批意见：").append(BaseHelpUtils.getString(data.getDesignDirectorComment()).replaceAll("\r\n", "<br>")).append("</div>")
    								.append("<div style='margin-left:5px; margin-right:5px; line-height:50px; text-align:left;'>设计总监（签字）：").append(BaseHelpUtils.getString(employeeMap.get(data.getDesignDirectorId()))).append("</div>")
    								.append("<div style='margin-left:5px; margin-right:5px; line-height:25px; text-align:left;'>时间：");
    								if(null != data.getDesignDirectorAuditDate()){
    									sb.append(dateFormat.format(data.getDesignDirectorAuditDate()));
    								}
    								sb.append("</div></td>").append("</tr>").append("</table>");
    								height -= auditHeight;
    							}
    						}
    						sb.append("</div>");
    						sb.append(tempChildSb.toString());
    					}
    				}
    			}else{
    				generatePrintHtmlByYear(sb, childList, businessType, contractDao, employeeMap, year);
    			}
    		}
    	}
    }
    
    public String goToThisLine(Map<String, Object> params) throws Exception{
    	int contractStageModelId = BaseHelpUtils.getIntValue(params.get("contractStageModelId"));
    	int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    	int parentId = BaseHelpUtils.getIntValue(params.get("rootId"));
    	ContractStageModel dao = new ContractStageModel();
    	if(parentId != 0){
    		Random random = new Random();
    		ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
			condition.setContractStageModelId(parentId);
			QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
			BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
			if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
				List<BaseGetContractStageModelByParentId> list = collection.getCollections();
				for(BaseGetContractStageModelByParentId obj : list){
					dao.clear();
					dao.setContractStageModelId(obj.getContractStageModelId());
					dao.load();
					if(dao.getNeedManagerAudit() || dao.getLeafNode()){
						dao.setActualPercent(dao.getPercent());
						dao.setLocked(true);
						dao.setProcessStatus(3);
						if(dao.getNeedManagerAudit() && null == dao.getManagerComment()){
							dao.setManagerComment(random.nextInt(2) + 1 == 1 ? "同意" : "通过");
						}
						if(dao.getNeedDesignDirectorAudit() && null == dao.getDesignDirectorComment()){
							dao.setDesignDirectorComment(random.nextInt(2) + 1 == 1 ? "同意" : "通过");
						}
						if(dao.getStageModelName().contains("评审")){
							dao.setRemark(random.nextInt(2) + 1 == 1 ? "同意" : "通过");
						}
					}
					dao.update();
					if(obj.getContractStageModelId().intValue() == contractStageModelId){
						break;
					}
				}
//				根据业态和合同确定小节点的项目经理和设计总监
				updateManagerByContractId(contractId);
				临时刷父节点完成状态的方法(parentId);
				dao.clear();
				dao.setConditionContractId("=", contractId);
				dao.setConditionParentId("=", 0);
				//单业态才刷确定时间
				if(dao.countRows() == 1){
					updateConfirmTime(contractId);
				}
			}
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON();
    }
    
    public String cancelFromThisLine(Map<String, Object> params) throws Exception{
    	int contractStageModelId = BaseHelpUtils.getIntValue(params.get("contractStageModelId"));
    	ContractStageModel dao = new ContractStageModel();
    	Integer parentId = getSuperStageId(contractStageModelId);
    	if(null != parentId && parentId.intValue() != 0){
    		ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
			condition.setContractStageModelId(parentId);
			QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
			BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
			if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
				List<BaseGetContractStageModelByParentId> list = collection.getCollections();
				boolean status = false;
				List<BaseGetContractStageModelByParentId> result = new ArrayList<>();
				for(BaseGetContractStageModelByParentId obj : list){
					if(BaseHelpUtils.getIntValue(obj.getContractStageModelId()) == contractStageModelId){
						status = true;
					}
					if(status){
						result.add(obj);
					}
				}
				for(BaseGetContractStageModelByParentId obj : result){
					dao.clear();
					dao.setContractStageModelId(obj.getContractStageModelId());
					dao.load();
					dao.setManagerAuditDate(null);
					dao.setDesignDirectorAuditDate(null);
					dao.setProcessStatus(0);
					dao.setYear(null);
					dao.setActualPercent(null);
					dao.setConfirmDate(null);
					dao.update();
				}
			}
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON();
    }
    
    public void updateManagerByContractId(Integer contractId) throws Exception{
		//根据合同找到业态
		ContractStageModel modelDao = new ContractStageModel();
		modelDao.setConditionContractId("=", contractId);
		modelDao.setConditionParentId("=", 0);
		List<BaseContractStageModel> list = modelDao.conditionalLoad();
		if(null != list){
			for(BaseContractStageModel obj : list){
				Set<Integer> set = new HashSet<>();
				Integer projectManager = null;
				Integer plateManager = null;
				Project dao = new Project();
				dao.setConditionContractId("=", contractId);
				dao.setConditionProjectType("=", 16);
				if(dao.countRows() > 0){
					BaseProject bean = dao.executeQueryOneRow();
					projectManager = bean.getProjectManageId();
					plateManager = bean.getPlateManagerId();
				}
				if(null == projectManager){
					if(obj.getStageModelName().contains("商业空间")){
						set.add(1);
						set.add(52);
						set.add(53);
						set.add(54);
						dao.clear();
						dao.setConditionContractId("=", contractId);
						dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
						if(dao.countRows() > 0){
							BaseProject bean = dao.executeQueryOneRow();
							projectManager = bean.getProjectManageId();
							plateManager = bean.getPlateManagerId();
						}
					}else if (obj.getStageModelName().contains("办公")){
						set.add(3);
						set.add(28);
						set.add(29);
						set.add(67);
						set.add(56);
						dao.clear();
						dao.setConditionContractId("=", contractId);
						dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
						if(dao.countRows() > 0){
							BaseProject bean = dao.executeQueryOneRow();
							projectManager = bean.getProjectManageId();
							plateManager = bean.getPlateManagerId();
						}
					}else if(obj.getStageModelName().contains("酒店")){
						set.add(2);
						set.add(15);
						set.add(45);
						set.add(46);
						set.add(47);
						dao.clear();
						dao.setConditionContractId("=", contractId);
						dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
						if(dao.countRows() > 0){
							BaseProject bean = dao.executeQueryOneRow();
							projectManager = bean.getProjectManageId();
							plateManager = bean.getPlateManagerId();
						}
					}else if(obj.getStageModelName().contains("地铁")){
						set.add(4);
						set.add(73);
						set.add(74);
						set.add(75);
						dao.clear();
						dao.setConditionContractId("=", contractId);
						dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
						if(dao.countRows() > 0){
							BaseProject bean = dao.executeQueryOneRow();
							projectManager = bean.getProjectManageId();
							plateManager = bean.getPlateManagerId();
						}
					}else if(obj.getStageModelName().contains("机电设计")){
						set.add(5);
						set.add(65);
						set.add(66);
						dao.clear();
						dao.setConditionContractId("=", contractId);
						dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
						if(dao.countRows() > 0){
							BaseProject bean = dao.executeQueryOneRow();
							projectManager = bean.getProjectManageId();
							plateManager = bean.getPlateManagerId();
						}
					}
				}
				if(null == projectManager){
					set.add(1);
					set.add(52);
					set.add(53);
					set.add(54);
					dao.clear();
					dao.setConditionContractId("=", contractId);
					dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
					if(dao.countRows() > 0){
						BaseProject bean = dao.executeQueryOneRow();
						projectManager = bean.getProjectManageId();
						plateManager = bean.getPlateManagerId();
					}else{
						set.add(3);
						set.add(28);
						set.add(29);
						set.add(67);
						set.add(56);
						dao.clear();
						dao.setConditionContractId("=", contractId);
						dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
						if(dao.countRows() > 0){
							BaseProject bean = dao.executeQueryOneRow();
							projectManager = bean.getProjectManageId();
							plateManager = bean.getPlateManagerId();
						}else{
							set.add(2);
							set.add(15);
							set.add(45);
							set.add(46);
							set.add(47);
							dao.clear();
							dao.setConditionContractId("=", contractId);
							dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
							if(dao.countRows() > 0){
								BaseProject bean = dao.executeQueryOneRow();
								projectManager = bean.getProjectManageId();
								plateManager = bean.getPlateManagerId();
							}else{
								set.add(4);
								set.add(73);
								set.add(74);
								set.add(75);
								dao.clear();
								dao.setConditionContractId("=", contractId);
								dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
								if(dao.countRows() > 0){
									BaseProject bean = dao.executeQueryOneRow();
									projectManager = bean.getProjectManageId();
									plateManager = bean.getPlateManagerId();
								}else{
									set.add(5);
									set.add(65);
									set.add(66);
									dao.clear();
									dao.setConditionContractId("=", contractId);
									dao.addCondition(BaseProject.CS_PLATE_ID, "in", set.toArray());
									if(dao.countRows() > 0){
										BaseProject bean = dao.executeQueryOneRow();
										projectManager = bean.getProjectManageId();
										plateManager = bean.getPlateManagerId();
									}else{
										dao.clear();
										dao.setConditionContractId("=", contractId);
										if(dao.countRows() > 0){
											BaseProject bean = dao.executeQueryOneRow();
											projectManager = bean.getProjectManageId();
											plateManager = bean.getPlateManagerId();
										}
									}
									
								}
							}
						}
					}
				}
				Set<Integer> set1 = new HashSet<>();
				ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
				condition.setContractStageModelId(obj.getContractStageModelId());
				QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
				BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
				if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
					for(BaseGetContractStageModelByParentId tempBean : collection.getCollections()){
						if(null != tempBean.getContractStageModelId() && null == tempBean.getConfirmDate()){
							set1.add(tempBean.getContractStageModelId());
						}
					}
				}
				if(null != projectManager){
					//现场服务50%和100%的项目经理和驻场（设计总监）设置为已找到的项目经理
					ContractStageModel stageDao = new ContractStageModel();
					stageDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set1.toArray());
					List<BaseContractStageModel> tempList1 = stageDao.conditionalLoad("(stage_model_name like '现场服务50' or stage_model_name like '现场服务100')");
					if(null != tempList1 && !tempList1.isEmpty()){
						Set<Integer> set2 = new HashSet<>();
						for(BaseContractStageModel base : tempList1){
							set2.add(base.getContractStageModelId());
						}
						if(set2.size() > 0){
							stageDao.clear();
							stageDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set2.toArray());
							stageDao.setManagerId(projectManager);
							stageDao.setDesignDirectorId(projectManager);
							stageDao.conditionalUpdate();
						}
					}
					//非现场服务50%和100%的项目经理设置为找到的项目经理
					stageDao.clear();
					stageDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set1.toArray());
					stageDao.setConditionNeedManagerAudit("=", true);
					List<BaseContractStageModel> tempList2 = stageDao.conditionalLoad("stage_model_name != '现场服务50%' and stage_model_name != '现场服务100%'");
					if(null != tempList2 && !tempList2.isEmpty()){
						Set<Integer> set2 = new HashSet<>();
						for(BaseContractStageModel base : tempList2){
							set2.add(base.getContractStageModelId());
						}
						if(set2.size() > 0){
							stageDao.clear();
							stageDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set2.toArray());
							stageDao.setManagerId(projectManager);
							stageDao.conditionalUpdate();
						}
					}
				}
				if(null != plateManager){
					//非现场服务50%和100%的设计总监设置为已找到的plateManager
					ContractStageModel stageDao = new ContractStageModel();
					stageDao.setConditionNeedDesignDirectorAudit("=", true);
					stageDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set1.toArray());
					List<BaseContractStageModel> tempList1 = stageDao.conditionalLoad("stage_model_name != '现场服务50%' and stage_model_name != '现场服务100%'");
					if(null != tempList1 && !tempList1.isEmpty()){
						Set<Integer> set2 = new HashSet<>();
						for(BaseContractStageModel base : tempList1){
							set2.add(base.getContractStageModelId());
						}
						if(set2.size() > 0){
							stageDao.clear();
							stageDao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set2.toArray());
							stageDao.setDesignDirectorId(plateManager);
							stageDao.conditionalUpdate();
						}
					}
				}
			}
		}
    }
    
    /**
     * 单业态自动刷新时间
     * @param contractId
     * @throws Exception
     */
    public void updateConfirmTime(Integer contractId) throws Exception{
		Project dao = new Project();
		dao.setConditionContractId("=", contractId);
		List<BaseProject> list = dao.conditionalLoad();
		if(null != list && !list.isEmpty()){
			BigDecimal totalInteger = BigDecimal.ZERO;
			for(BaseProject obj : list){
				if(null != obj.getProjectIntegral()){
					totalInteger = totalInteger.add(obj.getProjectIntegral());
				}
			}
			ConditionProjectSettlement condition = new ConditionProjectSettlement();
			condition.setContractId(contractId);
			QueryProjectSettlement query = new QueryProjectSettlement();
			BaseCollection<BaseProjectSettlement> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
				BigDecimal sum = BigDecimal.ZERO;
				for(BaseProjectSettlement obj : bc.getCollections()){
					if(null != obj.getSettlement()){
						sum = sum.add(obj.getSettlement());
						BigDecimal percent = sum.divide(totalInteger, BigDecimal.ROUND_DOWN, 4);
						临时刷数据日期的方法(percent, contractId, obj.getSettlementDate(), true);
					}
				}
			}
		}
	
    }
    public static void main(String[] args) {
    	Map<String, Object> param = new HashMap<>();
    	param.put("contractId", 180);
    	String aaa = "{\"optType\":\"cancelFromThisLine\",\"contractId\":250,\"contractStageModelId\":29080}";
		StageModelProcessor a = new StageModelProcessor();
		try{
//			a.calculateNodes(param);
//			a.calculateAllContracts();
			a.execute(aaa, null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
  
}
