package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFileProject;
import com.pomplatform.db.dao.CwdFileProject;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFileProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFileProjectHandler.class);

	public static BaseCwdFileProject getCwdFileProjectById( 
		java.lang.Integer cwd_file_project_id
	) throws Exception
	{
		CwdFileProject dao = new CwdFileProject();
		dao.setCwdFileProjectId(cwd_file_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFileProjectExists( com.pomplatform.db.bean.BaseCwdFileProject bean, String additional ) throws Exception {

		CwdFileProject dao = new CwdFileProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFileProject( com.pomplatform.db.bean.BaseCwdFileProject bean, String additional ) throws Exception {

		CwdFileProject dao = new CwdFileProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFileProject> queryCwdFileProject( com.pomplatform.db.bean.BaseCwdFileProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFileProject dao = new CwdFileProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFileProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFileProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFileProject addToCwdFileProject ( BaseCwdFileProject cwdfileproject )  throws Exception {
		return addToCwdFileProject ( cwdfileproject , false);
	}

	public static BaseCwdFileProject addToCwdFileProject ( BaseCwdFileProject cwdfileproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFileProject dao = new CwdFileProject();
		dao.setDataFromBase(cwdfileproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFileProject addUpdateCwdFileProject ( BaseCwdFileProject cwdfileproject ) throws Exception {
		return addUpdateCwdFileProject ( cwdfileproject , false);
	}

	public static BaseCwdFileProject addUpdateCwdFileProject ( BaseCwdFileProject cwdfileproject, boolean singleTransaction  ) throws Exception {
		if(cwdfileproject.getCwdFileProjectId() == null) return addToCwdFileProject(cwdfileproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFileProject dao = new CwdFileProject();
		dao.setDataFromBase(cwdfileproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfileproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFileProject ( BaseCwdFileProject bean ) throws Exception {
		CwdFileProject dao = new CwdFileProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFileProject updateCwdFileProject ( BaseCwdFileProject cwdfileproject ) throws Exception {
		CwdFileProject dao = new CwdFileProject();
		dao.setCwdFileProjectId( cwdfileproject.getCwdFileProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfileproject);
			result = dao.update();
		}
		return result == 1 ? cwdfileproject : null ;
	}

	public static BaseCwdFileProject updateCwdFileProjectDirect( BaseCwdFileProject cwdfileproject ) throws Exception {
		CwdFileProject dao = new CwdFileProject();
		int result = 0;
		dao.setDataFromBase(cwdfileproject);
		result = dao.update();
		return result == 1 ? cwdfileproject : null ;
	}

	public static int setDeleteConditions(BaseCwdFileProject bean, CwdFileProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFileProjectId() != null) {
			dao.setConditionCwdFileProjectId("=", bean.getCwdFileProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFileProject bean, CwdFileProject dao){
		int count = 0;
		if(bean.getCwdFileProjectId() != null) {
			dao.setConditionCwdFileProjectId("=", bean.getCwdFileProjectId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFileProject bean = new BaseCwdFileProject();
		bean.setDataFromJSON(json);
		CwdFileProject dao = new CwdFileProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFileProject> rlist = new BaseCollection<>();
		BaseCwdFileProject bean = new BaseCwdFileProject();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFileProject dao = new CwdFileProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFileProject> result = dao.conditionalLoad(addtion);
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
		BaseCwdFileProject bean = new BaseCwdFileProject();
		bean.setDataFromJSON(json);
		CwdFileProject dao = new CwdFileProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFileProject bean = new BaseCwdFileProject();
		bean.setDataFromJSON(json);
		CwdFileProject dao = new CwdFileProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFileProject bean = new BaseCwdFileProject();
		bean.setDataFromJSON(json);
		CwdFileProject dao = new CwdFileProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFileProject bean = new BaseCwdFileProject();
		bean.setDataFromJSON(json);
		CwdFileProject dao = new CwdFileProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


