package pomplatform.finance.handler;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistributionLinkDepartment;
import com.pomplatform.db.dao.CapitalDistributionLinkSubContract;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;

/**
 * 
 * @Title: CollectionDistributionHandler.java 
 * @Package pomplatform.finance.handler 
 * @Description: 收款阶段处理类
 * @author CL  
 * @date 2016年12月24日
 */
public class CollectionDistributionHandler implements GenericProcessor,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CollectionDistributionHandler.class);
	
	private static final String COLLECTION_DISTRIBUTION = "collectionDistribution"; //收款分配
	
	private static final String CHECK_CAN_DISTRIBUTION = "checkCanDistribution";//检测是否能进行回款分配
	
	private static final String GET_SYSTEM_INSTANCE_DATA = "getSystemInstanceData";//获取流程实例数据

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
				case COLLECTION_DISTRIBUTION:
					return collectionDistribution(result);
				case CHECK_CAN_DISTRIBUTION:
					return checkCanDistribution(result);
				case GET_SYSTEM_INSTANCE_DATA:
					return getSystemInstanceData(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: getSystemInstanceData 
	 * @Description: 查询出流程实例数据显示
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getSystemInstanceData(Map<String, Object> result) throws Exception {
		int status = 1;
		String errorMsg = null;
		BaseSystemProcessInstance bean = new BaseSystemProcessInstance();
		bean.setDataFromMap(result);
		SystemProcessInstance dao = new SystemProcessInstance();
		dao.setConditionBusinessId("=", bean.getBusinessId());
		dao.setConditionProcessType("=", bean.getProcessType());
		BaseCollection<BaseSystemProcessInstance> bc = new BaseCollection<>();
		List<BaseSystemProcessInstance> list = dao.conditionalLoad();
		if(list.size() > 0){
			bc.setCollections(list);
		}else{
			status = -1;
			errorMsg = "没有找到流程数据 businessId" + bean.getBusinessId();
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: checkCanDistribution 
	 * @Description: 检测是否能够回款分配
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String checkCanDistribution(Map<String, Object> result) throws Exception {
		int status = 1;
		String errorMsg = null;
		BaseCapital bean = new BaseCapital();
		bean.setDataFromMap(result);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		if(dao.load()){
			if(BaseHelpUtils.getIntValue(dao.getProcessStatus()) > 0){
				status = -1;
				errorMsg = "该收款数据已经处于回款分配中 " + bean.getCapitalId();
				return bc.toJSON(status, errorMsg);
			}
			if(BaseHelpUtils.getIntValue(dao.getContractId()) <= 0){
				status = -1;
				errorMsg = "该收款数据没有绑定合同 " + bean.getCapitalId();
				return bc.toJSON(status, errorMsg);
			}
			List<BaseCapital> list = new ArrayList<>();
			list.add(dao.generateBase());
			bc.setCollections(list);
		}else{
			status = -1;
			errorMsg = "收款数据不存在 capitalId = " + bean.getCapitalId();
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: collectionDistribution 
	 * @Description: 进行回款分配
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private String collectionDistribution(Map<String, Object> result) throws Exception {
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		int capitalId = BaseHelpUtils.getIntValue(result, "capitalId");
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		Capital cDao = new Capital();
		cDao.setCapitalId(capitalId);
		if(cDao.load()){
			Date currentDate = new Date();
			
			List<BaseCapitalDistributionLinkDepartment> depList = new ArrayList<>();
			List<BaseCapitalDistributionLinkSubContract> subcontracList = new ArrayList<>();
			
			List<Map<String, Object>> departmentList = (List<Map<String, Object>>) result.get("departmentList");
			for (Map<String, Object> map : departmentList) {
				BaseCapitalDistributionLinkDepartment tmpBean = new BaseCapitalDistributionLinkDepartment();
				tmpBean.setDataFromMap(map);
				tmpBean.setCreateTime(currentDate);
				tmpBean.setCapitalId(capitalId);
				depList.add(tmpBean);
			}
			List<Map<String, Object>> subcontractList = (List<Map<String, Object>>) result.get("subcontractList");
			for (Map<String, Object> map : subcontractList) {
				BaseCapitalDistributionLinkSubContract tmpBean = new BaseCapitalDistributionLinkSubContract();
				tmpBean.setDataFromMap(map);
				tmpBean.setCreateTime(currentDate);
				tmpBean.setCapitalId(capitalId);
				subcontracList.add(tmpBean);
			}
			if(subcontracList.size() > 0){
				CapitalDistributionLinkSubContract csDao = new CapitalDistributionLinkSubContract();
				csDao.setConditionCapitalId("=", capitalId);
				csDao.conditionalDelete();
				csDao.save(subcontracList);
			}
			
//			List<Map<String, Object>> employeeList = (List<Map<String, Object>>) result.get("employeeList");
//			for (Map<String, Object> map : employeeList) {
//				BaseCapitalEmployee tmpBean = new BaseCapitalEmployee();
//				tmpBean.setDataFromMap(map);
//				tmpBean.setCreatTime(currentDate);
//				tmpBean.setOperatorId(employeeId);
//				tmpBean.setCapitalId(capitalId);
//				empList.add(tmpBean);
//			}
//			if(employeeList.size() > 0){
//				CapitalEmployee ceDao = new CapitalEmployee();
//				ceDao.setConditionCapitalId("=", capitalId);
//				ceDao.conditionalDelete();
//				ceDao.save(empList);
//			}
			if(departmentList.size() > 0){
				CapitalDistributionLinkDepartment cdDao = new CapitalDistributionLinkDepartment();
				cdDao.setConditionCapitalId("=", capitalId);
				cdDao.conditionalDelete();
				cdDao.save(depList);
			}
			//修改收款信息为已分配收款
			if(!cDao.getHasDistributionCollection()){
				cDao.setHasDistributionCollection(true);
				cDao.setProcessStatus(3);
				cDao.update();
			}
		}else{
			status = -1;
			errorMsg = "收款信息不存在  Cause by :{ [capitalId=" + capitalId + "] }";
		}
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}
	
	
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}


