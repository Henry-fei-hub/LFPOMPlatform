package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFileTransferProgress;
import com.pomplatform.db.dao.FileTransferProgress;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FileTransferProgressHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FileTransferProgressHandler.class);

	public static BaseFileTransferProgress getFileTransferProgressById( 
		java.lang.Integer file_transfer_progress_id
	) throws Exception
	{
		FileTransferProgress dao = new FileTransferProgress();
		dao.setFileTransferProgressId(file_transfer_progress_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFileTransferProgressExists( com.pomplatform.db.bean.BaseFileTransferProgress bean, String additional ) throws Exception {

		FileTransferProgress dao = new FileTransferProgress();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFileTransferProgress( com.pomplatform.db.bean.BaseFileTransferProgress bean, String additional ) throws Exception {

		FileTransferProgress dao = new FileTransferProgress();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFileTransferProgress> queryFileTransferProgress( com.pomplatform.db.bean.BaseFileTransferProgress bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FileTransferProgress dao = new FileTransferProgress();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFileTransferProgress> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFileTransferProgress> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFileTransferProgress addToFileTransferProgress ( BaseFileTransferProgress filetransferprogress )  throws Exception {
		return addToFileTransferProgress ( filetransferprogress , false);
	}

	public static BaseFileTransferProgress addToFileTransferProgress ( BaseFileTransferProgress filetransferprogress, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FileTransferProgress dao = new FileTransferProgress();
		dao.setDataFromBase(filetransferprogress);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFileTransferProgress addUpdateFileTransferProgress ( BaseFileTransferProgress filetransferprogress ) throws Exception {
		return addUpdateFileTransferProgress ( filetransferprogress , false);
	}

	public static BaseFileTransferProgress addUpdateFileTransferProgress ( BaseFileTransferProgress filetransferprogress, boolean singleTransaction  ) throws Exception {
		if(filetransferprogress.getFileTransferProgressId() == null) return addToFileTransferProgress(filetransferprogress);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FileTransferProgress dao = new FileTransferProgress();
		dao.setDataFromBase(filetransferprogress);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(filetransferprogress); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFileTransferProgress ( BaseFileTransferProgress bean ) throws Exception {
		FileTransferProgress dao = new FileTransferProgress();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFileTransferProgress updateFileTransferProgress ( BaseFileTransferProgress filetransferprogress ) throws Exception {
		FileTransferProgress dao = new FileTransferProgress();
		dao.setFileTransferProgressId( filetransferprogress.getFileTransferProgressId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(filetransferprogress);
			result = dao.update();
		}
		return result == 1 ? filetransferprogress : null ;
	}

	public static BaseFileTransferProgress updateFileTransferProgressDirect( BaseFileTransferProgress filetransferprogress ) throws Exception {
		FileTransferProgress dao = new FileTransferProgress();
		int result = 0;
		dao.setDataFromBase(filetransferprogress);
		result = dao.update();
		return result == 1 ? filetransferprogress : null ;
	}

	public static int setDeleteConditions(BaseFileTransferProgress bean, FileTransferProgress dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFileTransferProgressId() != null) {
			dao.setConditionFileTransferProgressId("=", bean.getFileTransferProgressId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileTransferKey() != null) {
				dao.setConditionFileTransferKey("=", bean.getFileTransferKey());
				count++;
			}
			if(bean.getFullFileName() != null) {
				dao.setConditionFullFileName("=", bean.getFullFileName());
				count++;
			}
			if(bean.getFileKey() != null) {
				dao.setConditionFileKey("=", bean.getFileKey());
				count++;
			}
			if(bean.getFileSize() != null) {
				dao.setConditionFileSize("=", bean.getFileSize());
				count++;
			}
			if(bean.getTransferedSize() != null) {
				dao.setConditionTransferedSize("=", bean.getTransferedSize());
				count++;
			}
			if(bean.getRequestUserId() != null) {
				dao.setConditionRequestUserId("=", bean.getRequestUserId());
				count++;
			}
			if(bean.getRequestCompanyId() != null) {
				dao.setConditionRequestCompanyId("=", bean.getRequestCompanyId());
				count++;
			}
			if(bean.getRequestWorkplaceId() != null) {
				dao.setConditionRequestWorkplaceId("=", bean.getRequestWorkplaceId());
				count++;
			}
			if(bean.getRequestMacAddress() != null) {
				dao.setConditionRequestMacAddress("=", bean.getRequestMacAddress());
				count++;
			}
			if(bean.getRequestIpAddress() != null) {
				dao.setConditionRequestIpAddress("=", bean.getRequestIpAddress());
				count++;
			}
			if(bean.getRequestMachineName() != null) {
				dao.setConditionRequestMachineName("=", bean.getRequestMachineName());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFileTransferProgress bean, FileTransferProgress dao){
		int count = 0;
		if(bean.getFileTransferProgressId() != null) {
			dao.setConditionFileTransferProgressId("=", bean.getFileTransferProgressId());
			count++;
		}
		if(bean.getFileTransferKey() != null) {
			if(bean.getFileTransferKey().indexOf("%") >= 0)
				dao.setConditionFileTransferKey("like", bean.getFileTransferKey());
			else
				dao.setConditionFileTransferKey("=", bean.getFileTransferKey());
			count++;
		}
		if(bean.getFullFileName() != null) {
			if(bean.getFullFileName().indexOf("%") >= 0)
				dao.setConditionFullFileName("like", bean.getFullFileName());
			else
				dao.setConditionFullFileName("=", bean.getFullFileName());
			count++;
		}
		if(bean.getFileKey() != null) {
			if(bean.getFileKey().indexOf("%") >= 0)
				dao.setConditionFileKey("like", bean.getFileKey());
			else
				dao.setConditionFileKey("=", bean.getFileKey());
			count++;
		}
		if(bean.getFileSize() != null) {
			dao.setConditionFileSize("=", bean.getFileSize());
			count++;
		}
		if(bean.getTransferedSize() != null) {
			dao.setConditionTransferedSize("=", bean.getTransferedSize());
			count++;
		}
		if(bean.getTransferPercent() != null) {
			dao.setConditionTransferPercent("=", bean.getTransferPercent());
			count++;
		}
		if(bean.getRequestUserId() != null) {
			dao.setConditionRequestUserId("=", bean.getRequestUserId());
			count++;
		}
		if(bean.getRequestCompanyId() != null) {
			dao.setConditionRequestCompanyId("=", bean.getRequestCompanyId());
			count++;
		}
		if(bean.getRequestWorkplaceId() != null) {
			dao.setConditionRequestWorkplaceId("=", bean.getRequestWorkplaceId());
			count++;
		}
		if(bean.getRequestMacAddress() != null) {
			if(bean.getRequestMacAddress().indexOf("%") >= 0)
				dao.setConditionRequestMacAddress("like", bean.getRequestMacAddress());
			else
				dao.setConditionRequestMacAddress("=", bean.getRequestMacAddress());
			count++;
		}
		if(bean.getRequestIpAddress() != null) {
			if(bean.getRequestIpAddress().indexOf("%") >= 0)
				dao.setConditionRequestIpAddress("like", bean.getRequestIpAddress());
			else
				dao.setConditionRequestIpAddress("=", bean.getRequestIpAddress());
			count++;
		}
		if(bean.getRequestMachineName() != null) {
			if(bean.getRequestMachineName().indexOf("%") >= 0)
				dao.setConditionRequestMachineName("like", bean.getRequestMachineName());
			else
				dao.setConditionRequestMachineName("=", bean.getRequestMachineName());
			count++;
		}
		if(bean.getStartTransferTime() != null) {
			dao.setConditionStartTransferTime(">=", bean.getStartTransferTime());
			count++;
		}
		if(bean.getEndTransferTime() != null) {
			dao.setConditionEndTransferTime(">=", bean.getEndTransferTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFileTransferProgress bean = new BaseFileTransferProgress();
		bean.setDataFromJSON(json);
		FileTransferProgress dao = new FileTransferProgress();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFileTransferProgress> rlist = new BaseCollection<>();
		BaseFileTransferProgress bean = new BaseFileTransferProgress();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FileTransferProgress dao = new FileTransferProgress();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFileTransferProgress> result = dao.conditionalLoad(addtion);
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
		BaseFileTransferProgress bean = new BaseFileTransferProgress();
		bean.setDataFromJSON(json);
		FileTransferProgress dao = new FileTransferProgress();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFileTransferProgress bean = new BaseFileTransferProgress();
		bean.setDataFromJSON(json);
		FileTransferProgress dao = new FileTransferProgress();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFileTransferProgress bean = new BaseFileTransferProgress();
		bean.setDataFromJSON(json);
		FileTransferProgress dao = new FileTransferProgress();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFileTransferProgress bean = new BaseFileTransferProgress();
		bean.setDataFromJSON(json);
		FileTransferProgress dao = new FileTransferProgress();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


