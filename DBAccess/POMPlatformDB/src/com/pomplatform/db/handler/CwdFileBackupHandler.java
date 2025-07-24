package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFileBackup;
import com.pomplatform.db.dao.CwdFileBackup;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFileBackupHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFileBackupHandler.class);

	public static BaseCwdFileBackup getCwdFileBackupById( 
		java.lang.Integer file_backup_id
	) throws Exception
	{
		CwdFileBackup dao = new CwdFileBackup();
		dao.setFileBackupId(file_backup_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFileBackupExists( com.pomplatform.db.bean.BaseCwdFileBackup bean, String additional ) throws Exception {

		CwdFileBackup dao = new CwdFileBackup();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFileBackup( com.pomplatform.db.bean.BaseCwdFileBackup bean, String additional ) throws Exception {

		CwdFileBackup dao = new CwdFileBackup();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFileBackup> queryCwdFileBackup( com.pomplatform.db.bean.BaseCwdFileBackup bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFileBackup dao = new CwdFileBackup();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFileBackup> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFileBackup> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFileBackup addToCwdFileBackup ( BaseCwdFileBackup cwdfilebackup )  throws Exception {
		return addToCwdFileBackup ( cwdfilebackup , false);
	}

	public static BaseCwdFileBackup addToCwdFileBackup ( BaseCwdFileBackup cwdfilebackup, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFileBackup dao = new CwdFileBackup();
		dao.setDataFromBase(cwdfilebackup);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFileBackup addUpdateCwdFileBackup ( BaseCwdFileBackup cwdfilebackup ) throws Exception {
		return addUpdateCwdFileBackup ( cwdfilebackup , false);
	}

	public static BaseCwdFileBackup addUpdateCwdFileBackup ( BaseCwdFileBackup cwdfilebackup, boolean singleTransaction  ) throws Exception {
		if(cwdfilebackup.getFileBackupId() == null) return addToCwdFileBackup(cwdfilebackup);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFileBackup dao = new CwdFileBackup();
		dao.setDataFromBase(cwdfilebackup);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilebackup); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFileBackup ( BaseCwdFileBackup bean ) throws Exception {
		CwdFileBackup dao = new CwdFileBackup();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFileBackup updateCwdFileBackup ( BaseCwdFileBackup cwdfilebackup ) throws Exception {
		CwdFileBackup dao = new CwdFileBackup();
		dao.setFileBackupId( cwdfilebackup.getFileBackupId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilebackup);
			result = dao.update();
		}
		return result == 1 ? cwdfilebackup : null ;
	}

	public static BaseCwdFileBackup updateCwdFileBackupDirect( BaseCwdFileBackup cwdfilebackup ) throws Exception {
		CwdFileBackup dao = new CwdFileBackup();
		int result = 0;
		dao.setDataFromBase(cwdfilebackup);
		result = dao.update();
		return result == 1 ? cwdfilebackup : null ;
	}

	public static int setDeleteConditions(BaseCwdFileBackup bean, CwdFileBackup dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFileBackupId() != null) {
			dao.setConditionFileBackupId("=", bean.getFileBackupId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getCwdFileVersionId() != null) {
				dao.setConditionCwdFileVersionId("=", bean.getCwdFileVersionId());
				count++;
			}
			if(bean.getBackupPath() != null) {
				dao.setConditionBackupPath("=", bean.getBackupPath());
				count++;
			}
			if(bean.getWorkplaceId() != null) {
				dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
				count++;
			}
			if(bean.getFileSize() != null) {
				dao.setConditionFileSize("=", bean.getFileSize());
				count++;
			}
			if(bean.getMd5() != null) {
				dao.setConditionMd5("=", bean.getMd5());
				count++;
			}
			if(bean.getCurrentUploadPerson() != null) {
				dao.setConditionCurrentUploadPerson("=", bean.getCurrentUploadPerson());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFileBackup bean, CwdFileBackup dao){
		int count = 0;
		if(bean.getFileBackupId() != null) {
			dao.setConditionFileBackupId("=", bean.getFileBackupId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getCwdFileVersionId() != null) {
			dao.setConditionCwdFileVersionId("=", bean.getCwdFileVersionId());
			count++;
		}
		if(bean.getBackupPath() != null) {
			if(bean.getBackupPath().indexOf("%") >= 0)
				dao.setConditionBackupPath("like", bean.getBackupPath());
			else
				dao.setConditionBackupPath("=", bean.getBackupPath());
			count++;
		}
		if(bean.getBackupTime() != null) {
			dao.setConditionBackupTime(">=", bean.getBackupTime());
			count++;
		}
		if(bean.getWorkplaceId() != null) {
			dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
			count++;
		}
		if(bean.getFileSize() != null) {
			dao.setConditionFileSize("=", bean.getFileSize());
			count++;
		}
		if(bean.getMd5() != null) {
			if(bean.getMd5().indexOf("%") >= 0)
				dao.setConditionMd5("like", bean.getMd5());
			else
				dao.setConditionMd5("=", bean.getMd5());
			count++;
		}
		if(bean.getCurrentUploadPerson() != null) {
			dao.setConditionCurrentUploadPerson("=", bean.getCurrentUploadPerson());
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
		BaseCwdFileBackup bean = new BaseCwdFileBackup();
		bean.setDataFromJSON(json);
		CwdFileBackup dao = new CwdFileBackup();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFileBackup> rlist = new BaseCollection<>();
		BaseCwdFileBackup bean = new BaseCwdFileBackup();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFileBackup dao = new CwdFileBackup();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFileBackup> result = dao.conditionalLoad(addtion);
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
		BaseCwdFileBackup bean = new BaseCwdFileBackup();
		bean.setDataFromJSON(json);
		CwdFileBackup dao = new CwdFileBackup();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFileBackup bean = new BaseCwdFileBackup();
		bean.setDataFromJSON(json);
		CwdFileBackup dao = new CwdFileBackup();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFileBackup bean = new BaseCwdFileBackup();
		bean.setDataFromJSON(json);
		CwdFileBackup dao = new CwdFileBackup();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFileBackup bean = new BaseCwdFileBackup();
		bean.setDataFromJSON(json);
		CwdFileBackup dao = new CwdFileBackup();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


