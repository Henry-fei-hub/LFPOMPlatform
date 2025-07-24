package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseStorageCommandDetailFile;
import com.pomplatform.db.dao.StorageCommandDetailFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class StorageCommandDetailFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StorageCommandDetailFileHandler.class);

	public static BaseStorageCommandDetailFile getStorageCommandDetailFileById( 
		java.lang.Integer storage_command_detail_id
	) throws Exception
	{
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setStorageCommandDetailId(storage_command_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStorageCommandDetailFileExists( com.pomplatform.db.bean.BaseStorageCommandDetailFile bean, String additional ) throws Exception {

		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStorageCommandDetailFile( com.pomplatform.db.bean.BaseStorageCommandDetailFile bean, String additional ) throws Exception {

		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStorageCommandDetailFile> queryStorageCommandDetailFile( com.pomplatform.db.bean.BaseStorageCommandDetailFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStorageCommandDetailFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStorageCommandDetailFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStorageCommandDetailFile addToStorageCommandDetailFile ( BaseStorageCommandDetailFile storagecommanddetailfile )  throws Exception {
		return addToStorageCommandDetailFile ( storagecommanddetailfile , false);
	}

	public static BaseStorageCommandDetailFile addToStorageCommandDetailFile ( BaseStorageCommandDetailFile storagecommanddetailfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setDataFromBase(storagecommanddetailfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStorageCommandDetailFile addUpdateStorageCommandDetailFile ( BaseStorageCommandDetailFile storagecommanddetailfile ) throws Exception {
		return addUpdateStorageCommandDetailFile ( storagecommanddetailfile , false);
	}

	public static BaseStorageCommandDetailFile addUpdateStorageCommandDetailFile ( BaseStorageCommandDetailFile storagecommanddetailfile, boolean singleTransaction  ) throws Exception {
		if(storagecommanddetailfile.getStorageCommandDetailId() == null) return addToStorageCommandDetailFile(storagecommanddetailfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setDataFromBase(storagecommanddetailfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(storagecommanddetailfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStorageCommandDetailFile ( BaseStorageCommandDetailFile bean ) throws Exception {
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStorageCommandDetailFile updateStorageCommandDetailFile ( BaseStorageCommandDetailFile storagecommanddetailfile ) throws Exception {
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setStorageCommandDetailId( storagecommanddetailfile.getStorageCommandDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(storagecommanddetailfile);
			result = dao.update();
		}
		return result == 1 ? storagecommanddetailfile : null ;
	}

	public static BaseStorageCommandDetailFile updateStorageCommandDetailFileDirect( BaseStorageCommandDetailFile storagecommanddetailfile ) throws Exception {
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		int result = 0;
		dao.setDataFromBase(storagecommanddetailfile);
		result = dao.update();
		return result == 1 ? storagecommanddetailfile : null ;
	}

	public static int setDeleteConditions(BaseStorageCommandDetailFile bean, StorageCommandDetailFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStorageCommandDetailId() != null) {
			dao.setConditionStorageCommandDetailId("=", bean.getStorageCommandDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getStorageCommandId() != null) {
				dao.setConditionStorageCommandId("=", bean.getStorageCommandId());
				count++;
			}
			if(bean.getCwdTaskProcessId() != null) {
				dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
				count++;
			}
			if(bean.getOperationType() != null) {
				dao.setConditionOperationType("=", bean.getOperationType());
				count++;
			}
			if(bean.getOriginalFileId() != null) {
				dao.setConditionOriginalFileId("=", bean.getOriginalFileId());
				count++;
			}
			if(bean.getOriginalFilePath() != null) {
				dao.setConditionOriginalFilePath("=", bean.getOriginalFilePath());
				count++;
			}
			if(bean.getNewFileId() != null) {
				dao.setConditionNewFileId("=", bean.getNewFileId());
				count++;
			}
			if(bean.getNewFilePath() != null) {
				dao.setConditionNewFilePath("=", bean.getNewFilePath());
				count++;
			}
			if(bean.getDealStatus() != null) {
				dao.setConditionDealStatus("=", bean.getDealStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStorageCommandDetailFile bean, StorageCommandDetailFile dao){
		int count = 0;
		if(bean.getStorageCommandDetailId() != null) {
			dao.setConditionStorageCommandDetailId("=", bean.getStorageCommandDetailId());
			count++;
		}
		if(bean.getStorageCommandId() != null) {
			dao.setConditionStorageCommandId("=", bean.getStorageCommandId());
			count++;
		}
		if(bean.getCwdTaskProcessId() != null) {
			dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
			count++;
		}
		if(bean.getOperationType() != null) {
			dao.setConditionOperationType("=", bean.getOperationType());
			count++;
		}
		if(bean.getOriginalFileId() != null) {
			dao.setConditionOriginalFileId("=", bean.getOriginalFileId());
			count++;
		}
		if(bean.getOriginalFilePath() != null) {
			if(bean.getOriginalFilePath().indexOf("%") >= 0)
				dao.setConditionOriginalFilePath("like", bean.getOriginalFilePath());
			else
				dao.setConditionOriginalFilePath("=", bean.getOriginalFilePath());
			count++;
		}
		if(bean.getNewFileId() != null) {
			dao.setConditionNewFileId("=", bean.getNewFileId());
			count++;
		}
		if(bean.getNewFilePath() != null) {
			if(bean.getNewFilePath().indexOf("%") >= 0)
				dao.setConditionNewFilePath("like", bean.getNewFilePath());
			else
				dao.setConditionNewFilePath("=", bean.getNewFilePath());
			count++;
		}
		if(bean.getDealStatus() != null) {
			dao.setConditionDealStatus("=", bean.getDealStatus());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getCompleteTime() != null) {
			dao.setConditionCompleteTime(">=", bean.getCompleteTime());
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
		BaseStorageCommandDetailFile bean = new BaseStorageCommandDetailFile();
		bean.setDataFromJSON(json);
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStorageCommandDetailFile> rlist = new BaseCollection<>();
		BaseStorageCommandDetailFile bean = new BaseStorageCommandDetailFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStorageCommandDetailFile> result = dao.conditionalLoad(addtion);
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
		BaseStorageCommandDetailFile bean = new BaseStorageCommandDetailFile();
		bean.setDataFromJSON(json);
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStorageCommandDetailFile bean = new BaseStorageCommandDetailFile();
		bean.setDataFromJSON(json);
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStorageCommandDetailFile bean = new BaseStorageCommandDetailFile();
		bean.setDataFromJSON(json);
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStorageCommandDetailFile bean = new BaseStorageCommandDetailFile();
		bean.setDataFromJSON(json);
		StorageCommandDetailFile dao = new StorageCommandDetailFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


