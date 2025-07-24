package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskProcessFile;
import com.pomplatform.db.dao.CwdTaskProcessFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskProcessFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskProcessFileHandler.class);

	public static BaseCwdTaskProcessFile getCwdTaskProcessFileById( 
		java.lang.Integer cwd_task_process_file_id
	) throws Exception
	{
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setCwdTaskProcessFileId(cwd_task_process_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskProcessFileExists( com.pomplatform.db.bean.BaseCwdTaskProcessFile bean, String additional ) throws Exception {

		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskProcessFile( com.pomplatform.db.bean.BaseCwdTaskProcessFile bean, String additional ) throws Exception {

		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskProcessFile> queryCwdTaskProcessFile( com.pomplatform.db.bean.BaseCwdTaskProcessFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskProcessFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskProcessFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskProcessFile addToCwdTaskProcessFile ( BaseCwdTaskProcessFile cwdtaskprocessfile )  throws Exception {
		return addToCwdTaskProcessFile ( cwdtaskprocessfile , false);
	}

	public static BaseCwdTaskProcessFile addToCwdTaskProcessFile ( BaseCwdTaskProcessFile cwdtaskprocessfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setDataFromBase(cwdtaskprocessfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskProcessFile addUpdateCwdTaskProcessFile ( BaseCwdTaskProcessFile cwdtaskprocessfile ) throws Exception {
		return addUpdateCwdTaskProcessFile ( cwdtaskprocessfile , false);
	}

	public static BaseCwdTaskProcessFile addUpdateCwdTaskProcessFile ( BaseCwdTaskProcessFile cwdtaskprocessfile, boolean singleTransaction  ) throws Exception {
		if(cwdtaskprocessfile.getCwdTaskProcessFileId() == null) return addToCwdTaskProcessFile(cwdtaskprocessfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setDataFromBase(cwdtaskprocessfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskprocessfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskProcessFile ( BaseCwdTaskProcessFile bean ) throws Exception {
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskProcessFile updateCwdTaskProcessFile ( BaseCwdTaskProcessFile cwdtaskprocessfile ) throws Exception {
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setCwdTaskProcessFileId( cwdtaskprocessfile.getCwdTaskProcessFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskprocessfile);
			result = dao.update();
		}
		return result == 1 ? cwdtaskprocessfile : null ;
	}

	public static BaseCwdTaskProcessFile updateCwdTaskProcessFileDirect( BaseCwdTaskProcessFile cwdtaskprocessfile ) throws Exception {
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		int result = 0;
		dao.setDataFromBase(cwdtaskprocessfile);
		result = dao.update();
		return result == 1 ? cwdtaskprocessfile : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskProcessFile bean, CwdTaskProcessFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskProcessFileId() != null) {
			dao.setConditionCwdTaskProcessFileId("=", bean.getCwdTaskProcessFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskProcessId() != null) {
				dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
				count++;
			}
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getCwdFilingManageDetailId() != null) {
				dao.setConditionCwdFilingManageDetailId("=", bean.getCwdFilingManageDetailId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskProcessFile bean, CwdTaskProcessFile dao){
		int count = 0;
		if(bean.getCwdTaskProcessFileId() != null) {
			dao.setConditionCwdTaskProcessFileId("=", bean.getCwdTaskProcessFileId());
			count++;
		}
		if(bean.getCwdTaskProcessId() != null) {
			dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getCwdFilingManageDetailId() != null) {
			dao.setConditionCwdFilingManageDetailId("=", bean.getCwdFilingManageDetailId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskProcessFile bean = new BaseCwdTaskProcessFile();
		bean.setDataFromJSON(json);
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskProcessFile> rlist = new BaseCollection<>();
		BaseCwdTaskProcessFile bean = new BaseCwdTaskProcessFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskProcessFile> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskProcessFile bean = new BaseCwdTaskProcessFile();
		bean.setDataFromJSON(json);
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskProcessFile bean = new BaseCwdTaskProcessFile();
		bean.setDataFromJSON(json);
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskProcessFile bean = new BaseCwdTaskProcessFile();
		bean.setDataFromJSON(json);
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskProcessFile bean = new BaseCwdTaskProcessFile();
		bean.setDataFromJSON(json);
		CwdTaskProcessFile dao = new CwdTaskProcessFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


