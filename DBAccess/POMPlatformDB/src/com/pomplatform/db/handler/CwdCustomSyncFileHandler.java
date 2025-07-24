package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCwdCustomSyncFile;
import java.util.List;
import com.pomplatform.db.dao.CwdCustomSyncFile;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CwdCustomSyncFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdCustomSyncFileHandler.class);

	public static BaseCwdCustomSyncFile getCwdCustomSyncFileById( 
		java.lang.Integer custom_sync_file_id
	) throws Exception
	{
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setCustomSyncFileId(custom_sync_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdCustomSyncFileExists( com.pomplatform.db.bean.BaseCwdCustomSyncFile bean, String additional ) throws Exception {

		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdCustomSyncFile( com.pomplatform.db.bean.BaseCwdCustomSyncFile bean, String additional ) throws Exception {

		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdCustomSyncFile> queryCwdCustomSyncFile( com.pomplatform.db.bean.BaseCwdCustomSyncFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdCustomSyncFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdCustomSyncFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdCustomSyncFile addToCwdCustomSyncFile ( BaseCwdCustomSyncFile cwdcustomsyncfile )  throws Exception {
		return addToCwdCustomSyncFile ( cwdcustomsyncfile , false);
	}

	public static BaseCwdCustomSyncFile addToCwdCustomSyncFile ( BaseCwdCustomSyncFile cwdcustomsyncfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setDataFromBase(cwdcustomsyncfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdCustomSyncFile addUpdateCwdCustomSyncFile ( BaseCwdCustomSyncFile cwdcustomsyncfile ) throws Exception {
		return addUpdateCwdCustomSyncFile ( cwdcustomsyncfile , false);
	}

	public static BaseCwdCustomSyncFile addUpdateCwdCustomSyncFile ( BaseCwdCustomSyncFile cwdcustomsyncfile, boolean singleTransaction  ) throws Exception {
		if(cwdcustomsyncfile.getCustomSyncFileId() == null) return addToCwdCustomSyncFile(cwdcustomsyncfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setDataFromBase(cwdcustomsyncfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdcustomsyncfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdCustomSyncFile ( BaseCwdCustomSyncFile bean ) throws Exception {
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdCustomSyncFile updateCwdCustomSyncFile ( BaseCwdCustomSyncFile cwdcustomsyncfile ) throws Exception {
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setCustomSyncFileId( cwdcustomsyncfile.getCustomSyncFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdcustomsyncfile);
			result = dao.update();
		}
		return result == 1 ? cwdcustomsyncfile : null ;
	}

	public static BaseCwdCustomSyncFile updateCwdCustomSyncFileDirect( BaseCwdCustomSyncFile cwdcustomsyncfile ) throws Exception {
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		int result = 0;
		dao.setDataFromBase(cwdcustomsyncfile);
		result = dao.update();
		return result == 1 ? cwdcustomsyncfile : null ;
	}

	public static int setDeleteConditions(BaseCwdCustomSyncFile bean, CwdCustomSyncFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCustomSyncFileId() != null) {
			dao.setConditionCustomSyncFileId("=", bean.getCustomSyncFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdCustomSyncFile bean, CwdCustomSyncFile dao){
		int count = 0;
		if(bean.getCustomSyncFileId() != null) {
			dao.setConditionCustomSyncFileId("=", bean.getCustomSyncFileId());
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
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdCustomSyncFile bean = new BaseCwdCustomSyncFile();
		bean.setDataFromJSON(json);
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdCustomSyncFile> rlist = new BaseCollection<>();
		BaseCwdCustomSyncFile bean = new BaseCwdCustomSyncFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdCustomSyncFile> result = dao.conditionalLoad(addtion);
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
		BaseCwdCustomSyncFile bean = new BaseCwdCustomSyncFile();
		bean.setDataFromJSON(json);
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdCustomSyncFile bean = new BaseCwdCustomSyncFile();
		bean.setDataFromJSON(json);
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdCustomSyncFile bean = new BaseCwdCustomSyncFile();
		bean.setDataFromJSON(json);
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdCustomSyncFile bean = new BaseCwdCustomSyncFile();
		bean.setDataFromJSON(json);
		CwdCustomSyncFile dao = new CwdCustomSyncFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


