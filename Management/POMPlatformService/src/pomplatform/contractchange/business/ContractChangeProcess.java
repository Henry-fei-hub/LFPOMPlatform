package pomplatform.contractchange.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractChange;
import com.pomplatform.db.bean.BaseContractLog;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectChange;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractChange;
import com.pomplatform.db.dao.ContractLog;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectChange;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contractchange.bean.ConditionProjectChangeRecord;
import pomplatform.contractchange.query.QueryProjectChangeRecord;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.project.business.OnProjectCommonProcess;

public class ContractChangeProcess implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //查看合同是否有待审核的变更记录
    private static final String IS_OK_TO_CHANGE_CONTRACT_INFO = "isOkToChangeContractInfo";
    //查询合同的变更记录
    private static final String QUERY_CONTRACT_CHANGE_RECORD = "queryContractChangeRecord";
    //查询设计项目的变更记录
    private static final String QUERY_PROJECT_CHANGE_RECORD = "queryProjectChangeRecord";
    //保存合同和订单的变更信息
    private static final String SAVE_CONTRACT_AND_PROJECT_CHANGE = "saveContractAndProjectChange";
    //根据合同变更ID查看合同变更记录
    private static final String GET_INFO_BY_CONTRACT_CHANGE_ID = "getInfoByContractChangeId";
    //根据合同ID批量修改合同状态
    private static final String CHANGE_CONTRACT_STATUS = "changeContractStatus";
    //合同附件上传
    private static final String UPDATE_SERVICE_SUGGEST_BOOK = "updateServiceSuggestBook";
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        if(IS_OK_TO_CHANGE_CONTRACT_INFO.equals(optType)){
        	return isOkToChangeContractInfo(params);
        }else if(QUERY_CONTRACT_CHANGE_RECORD.equals(optType)){
        	return queryContractChangeRecord(params);
        }else if(QUERY_PROJECT_CHANGE_RECORD.equals(optType)){
        	return queryProjectChangeRecord(params);
        }else if(SAVE_CONTRACT_AND_PROJECT_CHANGE.equals(optType)){
        	return saveContractAndProjectChange(params);
        }else if(GET_INFO_BY_CONTRACT_CHANGE_ID.equals(optType)){
        	return getInfoByContractChangeId(params);
        }else if(CHANGE_CONTRACT_STATUS.equals(optType)){
        	return changeContractStatus(params); 
        }else if(UPDATE_SERVICE_SUGGEST_BOOK.equals(optType)) {
        	return updateServiceSuggestBook(params);
        }
        return null;
    }
    
    public String isOkToChangeContractInfo(Map<String, Object> params) throws Exception{
    	BaseCollection bc = new BaseCollection<>();
    	if(null != params && !params.isEmpty()){
    		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    		if(contractId > 0){
    			ContractChange dao = new ContractChange();
    			dao.setConditionContractId("=", contractId);
    			dao.setConditionFlag("=", StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_3);
    			return bc.toJSON(dao.countRows(),null);
    		}
    	}
    	return bc.toJSON(-1, null);
	}
    
    public String queryContractChangeRecord(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseContractChange> bc = new BaseCollection<>();
    	if(null != params && !params.isEmpty()){
    		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    		int flag = BaseHelpUtils.getIntValue(params.get("flag"));
    		if(contractId > 0 && flag > 0){
    			//获取合同信息
    			Contract cDao = new Contract();
    			cDao.unsetSelectFlags();
    			cDao.setSelectContractCode(true);
    			cDao.setSelectContractName(true);
    			cDao.setContractId(contractId);
    			if(cDao.load()) {
    				//获取合同编号和名称
    				String contractCode = BaseHelpUtils.getString(cDao.getContractCode());
    				String contractName = BaseHelpUtils.getString(cDao.getContractName());
    				Map<String,Object> userData = new HashMap<>();
    				userData.put("contractCode", contractCode);
    				userData.put("contractName", contractName);
    				bc.setUserData(userData);
    			}
    			ContractChange dao = new ContractChange();
    			dao.setConditionContractId("=", contractId);
    			dao.setConditionFlag("=", flag);
    			List<BaseContractChange> list = dao.conditionalLoad();
    			bc.setCollections(list);
    			return bc.toJSON();
    		}
    	}
    	return bc.toJSON(-1, null);
	}
    
    public String queryProjectChangeRecord(Map<String, Object> params) throws Exception{
    	BaseCollection bc = new BaseCollection();
    	if(null != params && !params.isEmpty()){
    		int contractChangeId = BaseHelpUtils.getIntValue(params.get("contractChangeId"));
    		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    		int flag = BaseHelpUtils.getIntValue(params.get("flag"));
    		if(contractChangeId > 0 && flag > 0){
    			ProjectChange dao = new ProjectChange();
    			dao.setConditionContractChangeId("=", contractChangeId);
    			dao.setConditionFlag("=", flag);
    			List<BaseProjectChange> list = dao.conditionalLoad();
    			bc.setCollections(list);
    			return bc.toJSON();
    		}else if(contractId > 0 && flag > 0){
    			//获取合同信息
    			Contract cDao = new Contract();
    			cDao.unsetSelectFlags();
    			cDao.setSelectContractCode(true);
    			cDao.setSelectContractName(true);
    			cDao.setContractId(contractId);
    			if(cDao.load()) {
    				//获取合同编号和名称
    				String contractCode = BaseHelpUtils.getString(cDao.getContractCode());
    				String contractName = BaseHelpUtils.getString(cDao.getContractName());
    				Map<String,Object> userData = new HashMap<>();
    				userData.put("contractCode", contractCode);
    				userData.put("contractName", contractName);
    				bc.setUserData(userData);
    			}
    			ConditionProjectChangeRecord condition = new ConditionProjectChangeRecord();
    			condition.setContractId(contractId);
    			condition.setFlag(flag);
    			QueryProjectChangeRecord query = new QueryProjectChangeRecord();
    			bc = query.executeQuery(null, condition);
    			return bc.toJSON();
    		}
    	}
    	return bc.toJSON(-1, null);
	}
    
    public String saveContractAndProjectChange(Map<String, Object> params) throws Exception{
    	BaseCollection bc = new BaseCollection();
    	if(null != params && !params.isEmpty()){
    		int flag = BaseHelpUtils.getIntValue(params.get("flag"));
    		if(flag > 0){
	    		ThreadConnection.beginTransaction();
	    		Date date = new Date();
	    		BaseContractChange baseContractChange = new BaseContractChange();
	    		baseContractChange.setDataFromMap(params);
	    		ContractChange contractChangeDao = new ContractChange();
	    		if(null != baseContractChange.getContractChangeId()){
	    			contractChangeDao.setPrimaryKeyFromBase(baseContractChange);
	    			if(contractChangeDao.load()){
	    				contractChangeDao.setDataFromBase(baseContractChange);
	    				contractChangeDao.setOperateTime(date);
	    				contractChangeDao.update();
	    			}else{
	    				throw new Exception("无法找到合同变更数据");
	    			}
	    		}else{
	    			contractChangeDao.setDataFromBase(baseContractChange);
	    			contractChangeDao.setOperateTime(date);
	    			contractChangeDao.save();
	    		}
	    		int contractChangeId = contractChangeDao.getContractChangeId();
	    		List<BaseProjectChange> projectChangeList = GenericBase.__getList(params.get("projectChangeList"),
	    				BaseProjectChange.newInstance());
	    		if(flag == StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_4){
					if(null != baseContractChange.getContractChangeAmount() && baseContractChange.getContractChangeAmount().compareTo(BigDecimal.ZERO) != 0){
						Contract contractDao = new Contract();
						contractDao.setConditionContractId("=", baseContractChange.getContractId());
						contractDao.setSigningMoneySum(baseContractChange.getContractFinalAmount());
						contractDao.conditionalUpdate();
					}
				}
	    		if(null != projectChangeList && !projectChangeList.isEmpty()){
	    			int size = projectChangeList.size();
	    			Integer[] projectIds = new Integer[size];
	    			for(int i = 0; i < size; i++){
	    				BaseProjectChange obj = projectChangeList.get(i);
	    				projectIds[i] = obj.getProjectId();
	    				ProjectChange dao = new ProjectChange();
	    				if(null != obj.getProjectChangeId()){
	    					dao.setPrimaryKeyFromBase(obj);
	    					if(dao.load()){
	    						dao.setDataFromBase(obj);
	    						dao.setOperateTime(date);
	    						dao.update();
	    					}else{
	    						throw new Exception("无法找到项目变更数据");
	    					}
	    				}else{
	    					dao.setDataFromBase(obj);
	    					dao.setContractChangeId(contractChangeId);
	    					dao.setOperateTime(date);
	    					dao.save();
	    				}
	    				if(flag == StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_4){
	    					OnProjectCommonProcess.onProjectChange(obj.getProjectId(), obj.getTotalChangeIntegral(), (null == obj.getSheetChangeAmount() || (null != obj.getSheetChangeAmount() && obj.getSheetChangeAmount().compareTo(BigDecimal.ZERO) == 0)) ? obj.getSheetAmount() : obj.getSheetFinalAmount(), obj.getDesignArea(), obj.getCommonArea(), obj.getLogisticsArea());
	    				}
	    			}
	    			Project project = new Project();
	    			project.addCondition(BaseProject.CS_PROJECT_ID, "in", (Object[]) projectIds);
	    			if(flag == StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_1 || flag == StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_3){
	    				project.setIsLock(true);
	    			}else if(flag == StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_2 || flag == StaticUtils.CONTRACT_OR_PROJECT_CHANGE_FLAG_4){
	    				project.setIsLock(false);
	    			}
	    			project.conditionalUpdate();
	    		}
	    		ThreadConnection.commit();
	    		return bc.toJSON();
    		}
    	}
    	return bc.toJSON(-1, null);
	}
    
    public String getInfoByContractChangeId(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseContractChange> bc = new BaseCollection<>();
    	if(null != params && !params.isEmpty()){
    		int contractChangeId = BaseHelpUtils.getIntValue(params.get("contractChangeId"));
    		if(contractChangeId > 0){
    			ContractChange dao = new ContractChange();
    			dao.setContractChangeId(contractChangeId);
    			if(dao.load()){
    				BaseContractChange bean = dao.generateBase();
    				List<BaseContractChange> list = new ArrayList<>();
    				list.add(bean);
    				bc.setCollections(list);
        			return bc.toJSON();
    			}
    		}
    	}
    	return bc.toJSON(-1, null);
	}
    
    public String changeContractStatus(Map<String, Object> params) throws Exception{
    	BaseCollection bc = new BaseCollection<>();
    	if(null != params && !params.isEmpty()){
    		String contractIds = BaseHelpUtils.getString(params.get("contractIds"));
    		String[] contractIdStrArr = contractIds.split(",");
    		int size = contractIdStrArr.length;
    		Integer[] contractIdArr = new Integer[size];
    		for(int i = 0; i < size; i++){
    			contractIdArr[i] = BaseHelpUtils.getIntValue(contractIdStrArr[i]);
    		}
			Contract dao = new Contract();
			dao.addCondition(BaseContract.CS_CONTRACT_ID, "in", (Object[]) contractIdArr);
			List<BaseContract> list = dao.conditionalLoad();
			int contractStatus = BaseHelpUtils.getIntValue(params.get("contractStatus"));
			dao.setContractStatus(contractStatus);
			ThreadConnection.beginTransaction();
			int num = dao.conditionalUpdate();
			int operatorId = BaseHelpUtils.getIntValue(params.get("operatorId"));
			List<BaseContractLog> logList = new ArrayList<>();
			for(BaseContract obj : list){
				BaseContractLog bean = new BaseContractLog();
				bean.setContractId(obj.getContractId());
				bean.setOriginalStatus(obj.getContractStatus());
				bean.setNewStatus(contractStatus);
				bean.setOperator(operatorId);
				logList.add(bean);
			}
			ContractLog logDao = new ContractLog();
			logDao.save(logList);
			ThreadConnection.commit();
			return bc.toJSON(num,null);
    	}
    	return bc.toJSON(-1, "修改合同状态失败");
	}
    
    public String updateServiceSuggestBook(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	if(!params.containsKey("contractId")) {
    		return bc.toJSON(-1, "参数【contractId】为空");
    	}
		BaseContract bean = new BaseContract();
		bean.setDataFromMap(params);
		Contract dao = new Contract();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) {
			dao.setDataFromBase(bean);
			ColumnChangedData changed = dao.getColumnChangedData(BaseContract.CS_SERVICE_SUGGEST_BOOK_ID);
			ThreadConnection.beginTransaction();
			FileManageProcessor.upadteTimesByColumnChangedData(changed);
			dao.update();
			ThreadConnection.commit();
			return bc.toJSON();
		}else {
			return bc.toJSON(-1, "无法获取合同相关信息");
		}
    }
    
    public static void main(String[] args) throws Exception {
    	Map<String, Object> map = new HashMap<>();
    	map.put("contractChangeId", 3);
    	map.put("contractId", 676);
    	map.put("contractAmount", 0);
    	map.put("contractChangeAmount", 1);
    	map.put("contractFinalAmount", 1);
    	map.put("flag", 1);
    	map.put("operateEmployeeId", -1);
    	map.put("contractCode", "JA.201701015");
    	map.put("contractChangeView", "0(+1)→1");
    	map.put("optType", "saveContractAndProjectChange");
    	ContractChangeProcess a = new ContractChangeProcess();
    	a.saveContractAndProjectChange(map);
	}

}
