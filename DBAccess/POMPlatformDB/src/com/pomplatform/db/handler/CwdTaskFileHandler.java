package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskFile;
import com.pomplatform.db.dao.CwdTaskFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskFileHandler.class);

	public static BaseCwdTaskFile getCwdTaskFileById( 
		java.lang.Integer cwd_task_file_id
	) throws Exception
	{
		CwdTaskFile dao = new CwdTaskFile();
		dao.setCwdTaskFileId(cwd_task_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskFileExists( com.pomplatform.db.bean.BaseCwdTaskFile bean, String additional ) throws Exception {

		CwdTaskFile dao = new CwdTaskFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskFile( com.pomplatform.db.bean.BaseCwdTaskFile bean, String additional ) throws Exception {

		CwdTaskFile dao = new CwdTaskFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskFile> queryCwdTaskFile( com.pomplatform.db.bean.BaseCwdTaskFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskFile dao = new CwdTaskFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskFile addToCwdTaskFile ( BaseCwdTaskFile cwdtaskfile )  throws Exception {
		return addToCwdTaskFile ( cwdtaskfile , false);
	}

	public static BaseCwdTaskFile addToCwdTaskFile ( BaseCwdTaskFile cwdtaskfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskFile dao = new CwdTaskFile();
		dao.setDataFromBase(cwdtaskfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskFile addUpdateCwdTaskFile ( BaseCwdTaskFile cwdtaskfile ) throws Exception {
		return addUpdateCwdTaskFile ( cwdtaskfile , false);
	}

	public static BaseCwdTaskFile addUpdateCwdTaskFile ( BaseCwdTaskFile cwdtaskfile, boolean singleTransaction  ) throws Exception {
		if(cwdtaskfile.getCwdTaskFileId() == null) return addToCwdTaskFile(cwdtaskfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskFile dao = new CwdTaskFile();
		dao.setDataFromBase(cwdtaskfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskFile ( BaseCwdTaskFile bean ) throws Exception {
		CwdTaskFile dao = new CwdTaskFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskFile updateCwdTaskFile ( BaseCwdTaskFile cwdtaskfile ) throws Exception {
		CwdTaskFile dao = new CwdTaskFile();
		dao.setCwdTaskFileId( cwdtaskfile.getCwdTaskFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskfile);
			result = dao.update();
		}
		return result == 1 ? cwdtaskfile : null ;
	}

	public static BaseCwdTaskFile updateCwdTaskFileDirect( BaseCwdTaskFile cwdtaskfile ) throws Exception {
		CwdTaskFile dao = new CwdTaskFile();
		int result = 0;
		dao.setDataFromBase(cwdtaskfile);
		result = dao.update();
		return result == 1 ? cwdtaskfile : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskFile bean, CwdTaskFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskFileId() != null) {
			dao.setConditionCwdTaskFileId("=", bean.getCwdTaskFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskManageId() != null) {
				dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
				count++;
			}
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskFile bean, CwdTaskFile dao){
		int count = 0;
		if(bean.getCwdTaskFileId() != null) {
			dao.setConditionCwdTaskFileId("=", bean.getCwdTaskFileId());
			count++;
		}
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskFile bean = new BaseCwdTaskFile();
		bean.setDataFromJSON(json);
		CwdTaskFile dao = new CwdTaskFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskFile> rlist = new BaseCollection<>();
		BaseCwdTaskFile bean = new BaseCwdTaskFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskFile dao = new CwdTaskFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskFile> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskFile bean = new BaseCwdTaskFile();
		bean.setDataFromJSON(json);
		CwdTaskFile dao = new CwdTaskFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskFile bean = new BaseCwdTaskFile();
		bean.setDataFromJSON(json);
		CwdTaskFile dao = new CwdTaskFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskFile bean = new BaseCwdTaskFile();
		bean.setDataFromJSON(json);
		CwdTaskFile dao = new CwdTaskFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskFile bean = new BaseCwdTaskFile();
		bean.setDataFromJSON(json);
		CwdTaskFile dao = new CwdTaskFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


