package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectNormalReimbursementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectNormalReimbursementDetailHandler.class);

	public static BaseProjectNormalReimbursementDetail getProjectNormalReimbursementDetailById( 
		java.lang.Integer project_normal_reimbursement_detail_id
	) throws Exception
	{
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setProjectNormalReimbursementDetailId(project_normal_reimbursement_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectNormalReimbursementDetailExists( com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail bean, String additional ) throws Exception {

		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectNormalReimbursementDetail( com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail bean, String additional ) throws Exception {

		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectNormalReimbursementDetail> queryProjectNormalReimbursementDetail( com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectNormalReimbursementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectNormalReimbursementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectNormalReimbursementDetail addToProjectNormalReimbursementDetail ( BaseProjectNormalReimbursementDetail projectnormalreimbursementdetail )  throws Exception {
		return addToProjectNormalReimbursementDetail ( projectnormalreimbursementdetail , false);
	}

	public static BaseProjectNormalReimbursementDetail addToProjectNormalReimbursementDetail ( BaseProjectNormalReimbursementDetail projectnormalreimbursementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setDataFromBase(projectnormalreimbursementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectNormalReimbursementDetail addUpdateProjectNormalReimbursementDetail ( BaseProjectNormalReimbursementDetail projectnormalreimbursementdetail ) throws Exception {
		return addUpdateProjectNormalReimbursementDetail ( projectnormalreimbursementdetail , false);
	}

	public static BaseProjectNormalReimbursementDetail addUpdateProjectNormalReimbursementDetail ( BaseProjectNormalReimbursementDetail projectnormalreimbursementdetail, boolean singleTransaction  ) throws Exception {
		if(projectnormalreimbursementdetail.getProjectNormalReimbursementDetailId() == null) return addToProjectNormalReimbursementDetail(projectnormalreimbursementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setDataFromBase(projectnormalreimbursementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectnormalreimbursementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectNormalReimbursementDetail ( BaseProjectNormalReimbursementDetail bean ) throws Exception {
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectNormalReimbursementDetail updateProjectNormalReimbursementDetail ( BaseProjectNormalReimbursementDetail projectnormalreimbursementdetail ) throws Exception {
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setProjectNormalReimbursementDetailId( projectnormalreimbursementdetail.getProjectNormalReimbursementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectnormalreimbursementdetail);
			result = dao.update();
		}
		return result == 1 ? projectnormalreimbursementdetail : null ;
	}

	public static BaseProjectNormalReimbursementDetail updateProjectNormalReimbursementDetailDirect( BaseProjectNormalReimbursementDetail projectnormalreimbursementdetail ) throws Exception {
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		int result = 0;
		dao.setDataFromBase(projectnormalreimbursementdetail);
		result = dao.update();
		return result == 1 ? projectnormalreimbursementdetail : null ;
	}

	public static int setDeleteConditions(BaseProjectNormalReimbursementDetail bean, ProjectNormalReimbursementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectNormalReimbursementDetailId() != null) {
			dao.setConditionProjectNormalReimbursementDetailId("=", bean.getProjectNormalReimbursementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectNormalReimbursementId() != null) {
				dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				count++;
			}
			if(bean.getMainItemId() != null) {
				dao.setConditionMainItemId("=", bean.getMainItemId());
				count++;
			}
			if(bean.getSubItemId() != null) {
				dao.setConditionSubItemId("=", bean.getSubItemId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIdentification() != null) {
				dao.setConditionIdentification("=", bean.getIdentification());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectNormalReimbursementDetail bean, ProjectNormalReimbursementDetail dao){
		int count = 0;
		if(bean.getProjectNormalReimbursementDetailId() != null) {
			dao.setConditionProjectNormalReimbursementDetailId("=", bean.getProjectNormalReimbursementDetailId());
			count++;
		}
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
		}
		if(bean.getMainItemId() != null) {
			dao.setConditionMainItemId("=", bean.getMainItemId());
			count++;
		}
		if(bean.getSubItemId() != null) {
			dao.setConditionSubItemId("=", bean.getSubItemId());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getReimbursementTime() != null) {
			dao.setConditionReimbursementTime(">=", bean.getReimbursementTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIdentification() != null) {
			if(bean.getIdentification().indexOf("%") >= 0)
				dao.setConditionIdentification("like", bean.getIdentification());
			else
				dao.setConditionIdentification("=", bean.getIdentification());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectNormalReimbursementDetail bean = new BaseProjectNormalReimbursementDetail();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectNormalReimbursementDetail> rlist = new BaseCollection<>();
		BaseProjectNormalReimbursementDetail bean = new BaseProjectNormalReimbursementDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectNormalReimbursementDetail> result = dao.conditionalLoad(addtion);
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
		BaseProjectNormalReimbursementDetail bean = new BaseProjectNormalReimbursementDetail();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectNormalReimbursementDetail bean = new BaseProjectNormalReimbursementDetail();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectNormalReimbursementDetail bean = new BaseProjectNormalReimbursementDetail();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectNormalReimbursementDetail bean = new BaseProjectNormalReimbursementDetail();
		bean.setDataFromJSON(json);
		ProjectNormalReimbursementDetail dao = new ProjectNormalReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


