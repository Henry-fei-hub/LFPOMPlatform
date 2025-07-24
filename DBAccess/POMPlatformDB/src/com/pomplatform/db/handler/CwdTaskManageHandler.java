package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskManage;
import com.pomplatform.db.dao.CwdTaskManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskManageHandler.class);

	public static BaseCwdTaskManage getCwdTaskManageById( 
		java.lang.Integer cwd_task_manage_id
	) throws Exception
	{
		CwdTaskManage dao = new CwdTaskManage();
		dao.setCwdTaskManageId(cwd_task_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskManageExists( com.pomplatform.db.bean.BaseCwdTaskManage bean, String additional ) throws Exception {

		CwdTaskManage dao = new CwdTaskManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskManage( com.pomplatform.db.bean.BaseCwdTaskManage bean, String additional ) throws Exception {

		CwdTaskManage dao = new CwdTaskManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskManage> queryCwdTaskManage( com.pomplatform.db.bean.BaseCwdTaskManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskManage dao = new CwdTaskManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskManage addToCwdTaskManage ( BaseCwdTaskManage cwdtaskmanage )  throws Exception {
		return addToCwdTaskManage ( cwdtaskmanage , false);
	}

	public static BaseCwdTaskManage addToCwdTaskManage ( BaseCwdTaskManage cwdtaskmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskManage dao = new CwdTaskManage();
		dao.setDataFromBase(cwdtaskmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskManage addUpdateCwdTaskManage ( BaseCwdTaskManage cwdtaskmanage ) throws Exception {
		return addUpdateCwdTaskManage ( cwdtaskmanage , false);
	}

	public static BaseCwdTaskManage addUpdateCwdTaskManage ( BaseCwdTaskManage cwdtaskmanage, boolean singleTransaction  ) throws Exception {
		if(cwdtaskmanage.getCwdTaskManageId() == null) return addToCwdTaskManage(cwdtaskmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskManage dao = new CwdTaskManage();
		dao.setDataFromBase(cwdtaskmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskManage ( BaseCwdTaskManage bean ) throws Exception {
		CwdTaskManage dao = new CwdTaskManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskManage updateCwdTaskManage ( BaseCwdTaskManage cwdtaskmanage ) throws Exception {
		CwdTaskManage dao = new CwdTaskManage();
		dao.setCwdTaskManageId( cwdtaskmanage.getCwdTaskManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskmanage);
			result = dao.update();
		}
		return result == 1 ? cwdtaskmanage : null ;
	}

	public static BaseCwdTaskManage updateCwdTaskManageDirect( BaseCwdTaskManage cwdtaskmanage ) throws Exception {
		CwdTaskManage dao = new CwdTaskManage();
		int result = 0;
		dao.setDataFromBase(cwdtaskmanage);
		result = dao.update();
		return result == 1 ? cwdtaskmanage : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskManage bean, CwdTaskManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTaskName() != null) {
				dao.setConditionTaskName("=", bean.getTaskName());
				count++;
			}
			if(bean.getTaskStatus() != null) {
				dao.setConditionTaskStatus("=", bean.getTaskStatus());
				count++;
			}
			if(bean.getTaskType() != null) {
				dao.setConditionTaskType("=", bean.getTaskType());
				count++;
			}
			if(bean.getTaskLevel() != null) {
				dao.setConditionTaskLevel("=", bean.getTaskLevel());
				count++;
			}
			if(bean.getTaskContent() != null) {
				dao.setConditionTaskContent("=", bean.getTaskContent());
				count++;
			}
			if(bean.getTaskDemand() != null) {
				dao.setConditionTaskDemand("=", bean.getTaskDemand());
				count++;
			}
			if(bean.getAssignmentType() != null) {
				dao.setConditionAssignmentType("=", bean.getAssignmentType());
				count++;
			}
			if(bean.getAssignmentLinkId() != null) {
				dao.setConditionAssignmentLinkId("=", bean.getAssignmentLinkId());
				count++;
			}
			if(bean.getReviewTheWay() != null) {
				dao.setConditionReviewTheWay("=", bean.getReviewTheWay());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getOrderNum() != null) {
				dao.setConditionOrderNum("=", bean.getOrderNum());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getTaskLeader() != null) {
				dao.setConditionTaskLeader("=", bean.getTaskLeader());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCompanyNo() != null) {
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getPlanStatus() != null) {
				dao.setConditionPlanStatus("=", bean.getPlanStatus());
				count++;
			}
			if(bean.getCompletionStatus() != null) {
				dao.setConditionCompletionStatus("=", bean.getCompletionStatus());
				count++;
			}
			if(bean.getSpecialtyId() != null) {
				dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskManage bean, CwdTaskManage dao){
		int count = 0;
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
		}
		if(bean.getTaskName() != null) {
			if(bean.getTaskName().indexOf("%") >= 0)
				dao.setConditionTaskName("like", bean.getTaskName());
			else
				dao.setConditionTaskName("=", bean.getTaskName());
			count++;
		}
		if(bean.getTaskStatus() != null) {
			dao.setConditionTaskStatus("=", bean.getTaskStatus());
			count++;
		}
		if(bean.getTaskType() != null) {
			dao.setConditionTaskType("=", bean.getTaskType());
			count++;
		}
		if(bean.getTaskLevel() != null) {
			dao.setConditionTaskLevel("=", bean.getTaskLevel());
			count++;
		}
		if(bean.getTaskContent() != null) {
			if(bean.getTaskContent().indexOf("%") >= 0)
				dao.setConditionTaskContent("like", bean.getTaskContent());
			else
				dao.setConditionTaskContent("=", bean.getTaskContent());
			count++;
		}
		if(bean.getTaskDemand() != null) {
			if(bean.getTaskDemand().indexOf("%") >= 0)
				dao.setConditionTaskDemand("like", bean.getTaskDemand());
			else
				dao.setConditionTaskDemand("=", bean.getTaskDemand());
			count++;
		}
		if(bean.getAssignmentType() != null) {
			dao.setConditionAssignmentType("=", bean.getAssignmentType());
			count++;
		}
		if(bean.getAssignmentLinkId() != null) {
			dao.setConditionAssignmentLinkId("=", bean.getAssignmentLinkId());
			count++;
		}
		if(bean.getStartTime() != null) {
			dao.setConditionStartTime(">=", bean.getStartTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
			count++;
		}
		if(bean.getActualStartTime() != null) {
			dao.setConditionActualStartTime(">=", bean.getActualStartTime());
			count++;
		}
		if(bean.getActualEndTime() != null) {
			dao.setConditionActualEndTime(">=", bean.getActualEndTime());
			count++;
		}
		if(bean.getDegreeOfCompletion() != null) {
			dao.setConditionDegreeOfCompletion("=", bean.getDegreeOfCompletion());
			count++;
		}
		if(bean.getReviewTheWay() != null) {
			dao.setConditionReviewTheWay("=", bean.getReviewTheWay());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getOrderNum() != null) {
			dao.setConditionOrderNum("=", bean.getOrderNum());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getTaskLeader() != null) {
			dao.setConditionTaskLeader("=", bean.getTaskLeader());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCompanyNo() != null) {
			if(bean.getCompanyNo().indexOf("%") >= 0)
				dao.setConditionCompanyNo("like", bean.getCompanyNo());
			else
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getPlanStatus() != null) {
			dao.setConditionPlanStatus("=", bean.getPlanStatus());
			count++;
		}
		if(bean.getCompletionStatus() != null) {
			dao.setConditionCompletionStatus("=", bean.getCompletionStatus());
			count++;
		}
		if(bean.getTaskIntegral() != null) {
			dao.setConditionTaskIntegral("=", bean.getTaskIntegral());
			count++;
		}
		if(bean.getTaskIntegralPercent() != null) {
			dao.setConditionTaskIntegralPercent("=", bean.getTaskIntegralPercent());
			count++;
		}
		if(bean.getSpecialtyId() != null) {
			dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskManage bean = new BaseCwdTaskManage();
		bean.setDataFromJSON(json);
		CwdTaskManage dao = new CwdTaskManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskManage> rlist = new BaseCollection<>();
		BaseCwdTaskManage bean = new BaseCwdTaskManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskManage dao = new CwdTaskManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskManage> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseCwdTaskManage bean = new BaseCwdTaskManage();
		bean.setDataFromJSON(json);
		CwdTaskManage dao = new CwdTaskManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskManage bean = new BaseCwdTaskManage();
		bean.setDataFromJSON(json);
		CwdTaskManage dao = new CwdTaskManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskManage bean = new BaseCwdTaskManage();
		bean.setDataFromJSON(json);
		CwdTaskManage dao = new CwdTaskManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskManage bean = new BaseCwdTaskManage();
		bean.setDataFromJSON(json);
		CwdTaskManage dao = new CwdTaskManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


