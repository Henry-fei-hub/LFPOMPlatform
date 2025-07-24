package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSoftwareUpdateFile;
import com.pomplatform.db.dao.SoftwareUpdateFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SoftwareUpdateFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SoftwareUpdateFileHandler.class);

	public static BaseSoftwareUpdateFile getSoftwareUpdateFileById( 
		java.lang.Integer software_update_file_id
	) throws Exception
	{
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setSoftwareUpdateFileId(software_update_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSoftwareUpdateFileExists( com.pomplatform.db.bean.BaseSoftwareUpdateFile bean, String additional ) throws Exception {

		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSoftwareUpdateFile( com.pomplatform.db.bean.BaseSoftwareUpdateFile bean, String additional ) throws Exception {

		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSoftwareUpdateFile> querySoftwareUpdateFile( com.pomplatform.db.bean.BaseSoftwareUpdateFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSoftwareUpdateFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSoftwareUpdateFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSoftwareUpdateFile addToSoftwareUpdateFile ( BaseSoftwareUpdateFile softwareupdatefile )  throws Exception {
		return addToSoftwareUpdateFile ( softwareupdatefile , false);
	}

	public static BaseSoftwareUpdateFile addToSoftwareUpdateFile ( BaseSoftwareUpdateFile softwareupdatefile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setDataFromBase(softwareupdatefile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSoftwareUpdateFile addUpdateSoftwareUpdateFile ( BaseSoftwareUpdateFile softwareupdatefile ) throws Exception {
		return addUpdateSoftwareUpdateFile ( softwareupdatefile , false);
	}

	public static BaseSoftwareUpdateFile addUpdateSoftwareUpdateFile ( BaseSoftwareUpdateFile softwareupdatefile, boolean singleTransaction  ) throws Exception {
		if(softwareupdatefile.getSoftwareUpdateFileId() == null) return addToSoftwareUpdateFile(softwareupdatefile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setDataFromBase(softwareupdatefile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(softwareupdatefile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSoftwareUpdateFile ( BaseSoftwareUpdateFile bean ) throws Exception {
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSoftwareUpdateFile updateSoftwareUpdateFile ( BaseSoftwareUpdateFile softwareupdatefile ) throws Exception {
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setSoftwareUpdateFileId( softwareupdatefile.getSoftwareUpdateFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(softwareupdatefile);
			result = dao.update();
		}
		return result == 1 ? softwareupdatefile : null ;
	}

	public static BaseSoftwareUpdateFile updateSoftwareUpdateFileDirect( BaseSoftwareUpdateFile softwareupdatefile ) throws Exception {
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		int result = 0;
		dao.setDataFromBase(softwareupdatefile);
		result = dao.update();
		return result == 1 ? softwareupdatefile : null ;
	}

	public static int setDeleteConditions(BaseSoftwareUpdateFile bean, SoftwareUpdateFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSoftwareUpdateFileId() != null) {
			dao.setConditionSoftwareUpdateFileId("=", bean.getSoftwareUpdateFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getToFilePath() != null) {
				dao.setConditionToFilePath("=", bean.getToFilePath());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSoftwareUpdateVersionId() != null) {
				dao.setConditionSoftwareUpdateVersionId("=", bean.getSoftwareUpdateVersionId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSoftwareUpdateFile bean, SoftwareUpdateFile dao){
		int count = 0;
		if(bean.getSoftwareUpdateFileId() != null) {
			dao.setConditionSoftwareUpdateFileId("=", bean.getSoftwareUpdateFileId());
			count++;
		}
		if(bean.getToFilePath() != null) {
			if(bean.getToFilePath().indexOf("%") >= 0)
				dao.setConditionToFilePath("like", bean.getToFilePath());
			else
				dao.setConditionToFilePath("=", bean.getToFilePath());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getSoftwareUpdateVersionId() != null) {
			dao.setConditionSoftwareUpdateVersionId("=", bean.getSoftwareUpdateVersionId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSoftwareUpdateFile bean = new BaseSoftwareUpdateFile();
		bean.setDataFromJSON(json);
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSoftwareUpdateFile> rlist = new BaseCollection<>();
		BaseSoftwareUpdateFile bean = new BaseSoftwareUpdateFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSoftwareUpdateFile> result = dao.conditionalLoad(addtion);
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
		BaseSoftwareUpdateFile bean = new BaseSoftwareUpdateFile();
		bean.setDataFromJSON(json);
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSoftwareUpdateFile bean = new BaseSoftwareUpdateFile();
		bean.setDataFromJSON(json);
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSoftwareUpdateFile bean = new BaseSoftwareUpdateFile();
		bean.setDataFromJSON(json);
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSoftwareUpdateFile bean = new BaseSoftwareUpdateFile();
		bean.setDataFromJSON(json);
		SoftwareUpdateFile dao = new SoftwareUpdateFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


