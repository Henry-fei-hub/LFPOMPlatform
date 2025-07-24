package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdRecentWorkedProject;
import com.pomplatform.db.dao.CwdRecentWorkedProject;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdRecentWorkedProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdRecentWorkedProjectHandler.class);

	public static BaseCwdRecentWorkedProject getCwdRecentWorkedProjectById( 
		java.lang.Integer cwd_recent_worked_project_id
	) throws Exception
	{
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setCwdRecentWorkedProjectId(cwd_recent_worked_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdRecentWorkedProjectExists( com.pomplatform.db.bean.BaseCwdRecentWorkedProject bean, String additional ) throws Exception {

		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdRecentWorkedProject( com.pomplatform.db.bean.BaseCwdRecentWorkedProject bean, String additional ) throws Exception {

		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdRecentWorkedProject> queryCwdRecentWorkedProject( com.pomplatform.db.bean.BaseCwdRecentWorkedProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdRecentWorkedProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdRecentWorkedProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdRecentWorkedProject addToCwdRecentWorkedProject ( BaseCwdRecentWorkedProject cwdrecentworkedproject )  throws Exception {
		return addToCwdRecentWorkedProject ( cwdrecentworkedproject , false);
	}

	public static BaseCwdRecentWorkedProject addToCwdRecentWorkedProject ( BaseCwdRecentWorkedProject cwdrecentworkedproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setDataFromBase(cwdrecentworkedproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdRecentWorkedProject addUpdateCwdRecentWorkedProject ( BaseCwdRecentWorkedProject cwdrecentworkedproject ) throws Exception {
		return addUpdateCwdRecentWorkedProject ( cwdrecentworkedproject , false);
	}

	public static BaseCwdRecentWorkedProject addUpdateCwdRecentWorkedProject ( BaseCwdRecentWorkedProject cwdrecentworkedproject, boolean singleTransaction  ) throws Exception {
		if(cwdrecentworkedproject.getCwdRecentWorkedProjectId() == null) return addToCwdRecentWorkedProject(cwdrecentworkedproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setDataFromBase(cwdrecentworkedproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdrecentworkedproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdRecentWorkedProject ( BaseCwdRecentWorkedProject bean ) throws Exception {
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdRecentWorkedProject updateCwdRecentWorkedProject ( BaseCwdRecentWorkedProject cwdrecentworkedproject ) throws Exception {
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setCwdRecentWorkedProjectId( cwdrecentworkedproject.getCwdRecentWorkedProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdrecentworkedproject);
			result = dao.update();
		}
		return result == 1 ? cwdrecentworkedproject : null ;
	}

	public static BaseCwdRecentWorkedProject updateCwdRecentWorkedProjectDirect( BaseCwdRecentWorkedProject cwdrecentworkedproject ) throws Exception {
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		int result = 0;
		dao.setDataFromBase(cwdrecentworkedproject);
		result = dao.update();
		return result == 1 ? cwdrecentworkedproject : null ;
	}

	public static int setDeleteConditions(BaseCwdRecentWorkedProject bean, CwdRecentWorkedProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdRecentWorkedProjectId() != null) {
			dao.setConditionCwdRecentWorkedProjectId("=", bean.getCwdRecentWorkedProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
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
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdRecentWorkedProject bean, CwdRecentWorkedProject dao){
		int count = 0;
		if(bean.getCwdRecentWorkedProjectId() != null) {
			dao.setConditionCwdRecentWorkedProjectId("=", bean.getCwdRecentWorkedProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
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
		if(bean.getWorkTime() != null) {
			dao.setConditionWorkTime(">=", bean.getWorkTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdRecentWorkedProject bean = new BaseCwdRecentWorkedProject();
		bean.setDataFromJSON(json);
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdRecentWorkedProject> rlist = new BaseCollection<>();
		BaseCwdRecentWorkedProject bean = new BaseCwdRecentWorkedProject();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdRecentWorkedProject> result = dao.conditionalLoad(addtion);
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
		BaseCwdRecentWorkedProject bean = new BaseCwdRecentWorkedProject();
		bean.setDataFromJSON(json);
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdRecentWorkedProject bean = new BaseCwdRecentWorkedProject();
		bean.setDataFromJSON(json);
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdRecentWorkedProject bean = new BaseCwdRecentWorkedProject();
		bean.setDataFromJSON(json);
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdRecentWorkedProject bean = new BaseCwdRecentWorkedProject();
		bean.setDataFromJSON(json);
		CwdRecentWorkedProject dao = new CwdRecentWorkedProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


