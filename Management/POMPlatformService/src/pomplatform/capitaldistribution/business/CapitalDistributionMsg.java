package pomplatform.capitaldistribution.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pomplatform.db.bean.BaseProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.KeyValuePair;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employees.bean.BaseGetEmployeeByRoleAndPlate;
import pomplatform.employees.bean.ConditionGetEmployeeByRoleAndPlate;
import pomplatform.employees.query.QueryGetEmployeeByRoleAndPlate;
import pomplatform.project.bean.BaseGetProjectManagerByContractId;
import pomplatform.project.bean.ConditionGetProjectManagerByContractId;
import pomplatform.project.query.QueryGetProjectManagerByContractId;

public class CapitalDistributionMsg {

	/**
	 * 发送指定内容的消息，给某个合同下面的所有专业负责人、部门经理和事业部负责人
	 * @param contractId
	 * @param content
	 * @throws Exception
	 */
	public void sendToAllProjectManager(Integer contractId, String content) throws Exception{
		if(!BaseHelpUtils.isNullOrZero(contractId) && !BaseHelpUtils.isNullOrEmpty(content)){
			//根据合同ID查询出该合同下的所有专业负责人（超级管理员除外）
			ConditionGetProjectManagerByContractId condition = new ConditionGetProjectManagerByContractId();
			condition.setContractId(contractId);
			QueryGetProjectManagerByContractId query = new QueryGetProjectManagerByContractId();
			BaseCollection<BaseGetProjectManagerByContractId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
				List<BaseGetProjectManagerByContractId> list = bc.getCollections();
				Set<Integer> plateIdSet = new HashSet<>();
				for(BaseGetProjectManagerByContractId bean : list){
					if(null != bean.getPlateId()){
						plateIdSet.add(bean.getPlateId());
					}
				}
				Map<Integer, Map<Integer, String>> departmentManagerMap = new HashMap<>();
				Map<Integer, Map<Integer, String>> plateManagerMap = new HashMap<>();
				//根据业务部门ID，查找出该业务部门的部门经理和事业部负责人的employeeId和企业微信号
				getDepartmentManagerAndPlateManagerByPlate(plateIdSet, departmentManagerMap, plateManagerMap);
				Set<Integer> sendPlateIdSet = new HashSet<>();
				Map<Integer,String> receiverMap = new HashMap<>();
				for(BaseGetProjectManagerByContractId bean : list){
					if(!BaseHelpUtils.isNullOrEmpty(bean.getProjectManagerWeixin())){
						//专业负责人						
						receiverMap.put(bean.getProjectManageId(), bean.getProjectManagerWeixin());
					}
					Integer plateId = bean.getPlateId();
					if(!BaseHelpUtils.isNullOrZero(plateId) && !sendPlateIdSet.contains(plateId)){
						sendPlateIdSet.add(plateId);
						//部门经理
						if(null != departmentManagerMap.get(bean.getPlateId())){
							receiverMap.putAll(departmentManagerMap.get(bean.getPlateId()));
						}
						//事业部负责人
						if(null != plateManagerMap.get(bean.getPlateId())){
							receiverMap.putAll(plateManagerMap.get(bean.getPlateId()));
						}
					}
				}
				//开始发送消息
				if(null != receiverMap && receiverMap.size() > 0){
					StringBuilder sb = new StringBuilder();
					for(Integer key : receiverMap.keySet()){
						if(null != receiverMap.get(key)){
							if(sb.length() > 0){
								sb.append("|");
							}
							sb.append(receiverMap.get(key));
						}
					}
					if(sb.length() > 0){
						ERPWeixinUtils.sendTextMsgToUser(sb.toString(), content);
					}
				}
			}
		}
	}
	
	/**
	 * 回款分配发生变动时，发送消息给该订单所在合同的所有在职的专业负责人和部门经理
	 * @param contractId
	 * @param content
	 * @param projectMap
	 * @throws Exception
	 */
	public void sendToProjectAndDepartmentManagerByContractId(Integer contractId, String content, Map<Integer, BaseProject> projectMap) throws Exception{
		if(!BaseHelpUtils.isNullOrZero(contractId) && !BaseHelpUtils.isNullOrEmpty(content)){
			//根据合同ID查询出该合同下的所有专业负责人（超级管理员除外）
			ConditionGetProjectManagerByContractId condition = new ConditionGetProjectManagerByContractId();
			condition.setContractId(contractId);
			QueryGetProjectManagerByContractId query = new QueryGetProjectManagerByContractId();
			BaseCollection<BaseGetProjectManagerByContractId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
				List<BaseGetProjectManagerByContractId> list = bc.getCollections();
				Set<Integer> plateIdSet = new HashSet<>();
				for(BaseGetProjectManagerByContractId bean : list){
					if(null != bean.getPlateId()){
						plateIdSet.add(bean.getPlateId());
					}
				}
				Map<Integer, Map<Integer, String>> departmentManagerMap = new HashMap<>();
				Map<Integer, Map<Integer, String>> plateManagerMap = new HashMap<>();
				//根据业务部门ID，查找出该业务部门的部门经理和事业部负责人的employeeId和企业微信号
				getDepartmentManagerAndPlateManagerByPlate(plateIdSet, departmentManagerMap, plateManagerMap);
				Map<Integer,String> projectManager = new HashMap<>();
				Set<Integer> sendPlateIdSet = new HashSet<>();
				for(BaseGetProjectManagerByContractId bean : list){
					if(!BaseHelpUtils.isNullOrZero(bean.getProjectManageId())){
						projectManager.put(bean.getProjectManageId(), bean.getProjectManagerWeixin());
					}
					Map<Integer,String> departmentManager = null;
					Integer plateId = bean.getPlateId();
					if(!BaseHelpUtils.isNullOrZero(plateId) && !sendPlateIdSet.contains(plateId)){
						sendPlateIdSet.add(plateId);
						departmentManager = departmentManagerMap.get(bean.getPlateId());
						//发消息给部门经理
						if(null != departmentManager && departmentManager.size() > 0){
							sendCustomDistributionMsgToDepartmentManager(departmentManager, projectMap, plateId, content);
						}
						departmentManager = plateManagerMap.get(bean.getPlateId());
						//发消息给事业部负责人
						if(null != departmentManager && departmentManager.size() > 0){
							sendCustomDistributionMsgToDepartmentManager(departmentManager, projectMap, plateId, content);
						}
					}
					//发消息给专业负责人
					if(null != projectManager && projectManager.size() > 0){
						sendCustomDistributionMsgToProjectManager(projectManager, projectMap, content);
					}
				}
			}
		}
	}
	
	/**
	 * 根据项目ID，发送消息给在职的项目专业负责人和部门经理
	 * @param projects
	 * @param content
	 * @throws Exception
	 */
	public void sendToProjectAndDepartmentManagerByProjectIdSet(Set<Integer> projects, String content, Map<Integer, BaseProject> projectMap) throws Exception{
		if(null != projects && projects.size() > 0){
			StringBuilder sb = new StringBuilder();
			for(Integer id : projects){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(id);
			}
			ConditionGetProjectManagerByContractId condition = new ConditionGetProjectManagerByContractId();
			KeyValuePair[] keyValues = new KeyValuePair[1];
			KeyValuePair keyValue = new KeyValuePair();
			keyValue.setKey("a.contract_id = ? ");
			keyValue.setValue("a.contract_id = ? and a.project_id in (" + sb.toString() + ")");
			keyValues[0] = keyValue;
			QueryGetProjectManagerByContractId query = new QueryGetProjectManagerByContractId();
			BaseCollection<BaseGetProjectManagerByContractId> bc = query.executeQuery(keyValues, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
				List<BaseGetProjectManagerByContractId> list = bc.getCollections();
				Set<Integer> plateIdSet = new HashSet<>();
				for(BaseGetProjectManagerByContractId bean : list){
					if(null != bean.getPlateId()){
						plateIdSet.add(bean.getPlateId());
					}
				}
				Map<Integer, Map<Integer, String>> departmentManagerMap = new HashMap<>();
				Map<Integer, Map<Integer, String>> plateManagerMap = new HashMap<>();
				//根据业务部门ID，查找出该业务部门的部门经理和事业部负责人的employeeId和企业微信号
				getDepartmentManagerAndPlateManagerByPlate(plateIdSet, departmentManagerMap, plateManagerMap);
				Map<Integer,String> projectManager = new HashMap<>();
				Set<Integer> sendPlateIdSet = new HashSet<>();
				for(BaseGetProjectManagerByContractId bean : list){
					if(!BaseHelpUtils.isNullOrZero(bean.getProjectManageId())){
						projectManager.put(bean.getProjectManageId(), bean.getProjectManagerWeixin());
					}
					Map<Integer,String> departmentManager = null;
					Integer plateId = bean.getPlateId();
					if(!BaseHelpUtils.isNullOrZero(plateId) && !sendPlateIdSet.contains(plateId)){
						sendPlateIdSet.add(plateId);
						departmentManager = departmentManagerMap.get(bean.getPlateId());
						//发消息给部门经理
						if(null != departmentManager && departmentManager.size() > 0){
							sendCustomDistributionMsgToDepartmentManager(departmentManager, projectMap, plateId, content);
						}
						departmentManager = plateManagerMap.get(bean.getPlateId());
						//发消息给事业部负责人
						if(null != departmentManager && departmentManager.size() > 0){
							sendCustomDistributionMsgToDepartmentManager(departmentManager, projectMap, plateId, content);
						}
					}
				}
				//发消息给专业负责人
				if(null != projectManager && projectManager.size() > 0){
					sendCustomDistributionMsgToProjectManager(projectManager, projectMap, content);
				}
			}
		}
	}
	
	/**
	 * 发送特定内容的消息给专业负责人/部门经理
	 * @param type		type的取值	0:发消息给专业负责人		1:发消息给部门经理
	 * @param employees
	 * @param projectMap
	 * @param content
	 * @throws Exception
	 */
	public void sendCustomDistributionMsgToProjectManager(Map<Integer, String> employees, Map<Integer, BaseProject> projectMap, String content) throws Exception{
		if(null != employees && !employees.isEmpty()){
			for(Integer employeeId : employees.keySet()){
				StringBuilder sb = new StringBuilder();
				int index = 1;
				for(Integer key : projectMap.keySet()){
					BaseProject bean = projectMap.get(key);
					if(null != bean.getProjectManageId() && bean.getProjectManageId().equals(employeeId) && null != bean.getTotalAmount() && bean.getTotalAmount().compareTo(BigDecimal.ZERO) != 0){
						if(sb.length() == 0){
							sb.append("\r\n  请注意！与您相关的订单回款变动信息如下：");
						}
						sb.append("\r\n  ").append(index++).append("、").append(bean.getProjectName()).append("(").append(bean.getContractCode()).append(")金额");
						if(bean.getTotalAmount().compareTo(BigDecimal.ZERO) > 0){
							sb.append("增加了").append(bean.getTotalAmount());
						}else{
							sb.append("减少了").append(bean.getTotalAmount().negate());
						}
					}
				}
				if(sb.length() > 0 && !BaseHelpUtils.isNullOrEmpty(employees.get(employeeId))){
					ERPWeixinUtils.sendTextMsgToUser(employees.get(employeeId), content + sb.toString());
	//				System.out.println("发送企业微信消息给："+employeeId+"; 消息内容："+content + sb.toString());
				}
			}
		}
	}
	public void sendCustomDistributionMsgToDepartmentManager(Map<Integer, String> employees, Map<Integer, BaseProject> projectMap, Integer plateId, String content) throws Exception{
		if(null != employees && !employees.isEmpty()){
			for(Integer employeeId : employees.keySet()){
				StringBuilder sb = new StringBuilder();
				int index = 1;
				for(Integer key : projectMap.keySet()){
					BaseProject bean = projectMap.get(key);
					if(null != bean.getPlateId() && bean.getPlateId().equals(plateId) && null != bean.getTotalAmount() && bean.getTotalAmount().compareTo(BigDecimal.ZERO) != 0){
						if(sb.length() == 0){
							sb.append("\r\n  请注意！与您部门相关的订单回款变动信息如下：");
						}
						sb.append("\r\n  ").append(index++).append("、").append(bean.getProjectName()).append("(").append(bean.getContractCode()).append(")金额");
						if(bean.getTotalAmount().compareTo(BigDecimal.ZERO) > 0){
							sb.append("增加了").append(bean.getTotalAmount());
						}else{
							sb.append("减少了").append(bean.getTotalAmount().negate());
						}
					}
				}
				if(sb.length() > 0 && !BaseHelpUtils.isNullOrEmpty(employees.get(employeeId))){
					ERPWeixinUtils.sendTextMsgToUser(employees.get(employeeId), content + sb.toString());
	//				System.out.println("发送企业微信消息给："+employeeId+"; 消息内容："+content + sb.toString());
				}
			}
		}
	}
	
	/**
	 * 根据业务部门ID，查找出该业务部门的部门经理和事业部负责人的employeeId和企业微信号
	 * @param plateIdSet
	 * @param departmentManagerMap
	 * @param plateManagerMap
	 * @throws Exception
	 */
	public void getDepartmentManagerAndPlateManagerByPlate(Set<Integer> plateIdSet, Map<Integer, Map<Integer, String>> departmentManagerMap, Map<Integer, Map<Integer, String>> plateManagerMap) throws Exception{
		if(plateIdSet.size() > 0){
			//查找出与该合同有关的订单的业务部门的部门经理
			ConditionGetEmployeeByRoleAndPlate condition2 = new ConditionGetEmployeeByRoleAndPlate();
			condition2.setRoleId(StaticUtils.ROLE_OPERATIONS_MANAGER);
			condition2.setStatus(StaticUtils.EMPLOYEE_NORMAL);
			QueryGetEmployeeByRoleAndPlate query2 = new QueryGetEmployeeByRoleAndPlate();
			BaseCollection<BaseGetEmployeeByRoleAndPlate> collection2 = null;
			KeyValuePair[] keyValueArr = new KeyValuePair[1];
			if(plateIdSet.size() == 1){
				for(Integer plateId : plateIdSet){
					condition2.setPlateId(plateId);
				}
				collection2 = query2.executeQuery(null, condition2);
			}else{
				StringBuilder plateIdSb = new StringBuilder();
				for(Integer plateId : plateIdSet){
					if(plateIdSb.length() > 0){
						plateIdSb.append(",");
					}
					plateIdSb.append(plateId);
				}
				KeyValuePair keyValue = new KeyValuePair();
				keyValue.setKey("plate_id = ?");
				keyValue.setValue("plate_id = ? and plate_id in (" + plateIdSb.toString() + ")");
				keyValueArr[0] = keyValue;
				collection2 = query2.executeQuery(keyValueArr, condition2);
			}
			//将相关的部门经理按照plateId分组存放到departmentManagerMap中
			if(null != collection2 && null != collection2.getCollections() && !collection2.getCollections().isEmpty()){
				List<BaseGetEmployeeByRoleAndPlate> list2 = collection2.getCollections();
				for(BaseGetEmployeeByRoleAndPlate obj : list2){
					if(null != obj.getCompanyWeixin()){
						Map<Integer,String> tempMap = null;
						if(null != departmentManagerMap.get(obj.getPlateId())){
							tempMap = departmentManagerMap.get(obj.getPlateId());
						}else{
							tempMap = new HashMap<>();
						}
						tempMap.put(obj.getEmployeeId(), obj.getCompanyWeixin());
						departmentManagerMap.put(obj.getPlateId(), tempMap);
					}
				}
			}
			//查找出与该合同有关的订单的业务部门的事业部负责人
			condition2.setRoleId(StaticUtils.ROLE_PLATE_MANAGER);
			if(plateIdSet.size() == 1){
				collection2 = query2.executeQuery(null, condition2);
			}else{
				collection2 = query2.executeQuery(keyValueArr, condition2);
			}
			//将相关的事业部负责人按照plateId分组存放到plateManagerMap中
			if(null != collection2 && null != collection2.getCollections() && !collection2.getCollections().isEmpty()){
				List<BaseGetEmployeeByRoleAndPlate> list2 = collection2.getCollections();
				for(BaseGetEmployeeByRoleAndPlate obj : list2){
					if(null != obj.getCompanyWeixin()){
						Map<Integer,String> tempMap = null;
						if(null != plateManagerMap.get(obj.getPlateId())){
							tempMap = plateManagerMap.get(obj.getPlateId());
						}else{
							tempMap = new HashMap<>();
						}
						tempMap.put(obj.getEmployeeId(), obj.getCompanyWeixin());
						plateManagerMap.put(obj.getPlateId(), tempMap);
					}
				}
			}
		}
	}
}
