package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFile;
import com.pomplatform.db.dao.CwdFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFileHandler.class);

	public static BaseCwdFile getCwdFileById( 
		java.lang.Integer cwd_file_id
	) throws Exception
	{
		CwdFile dao = new CwdFile();
		dao.setCwdFileId(cwd_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFileExists( com.pomplatform.db.bean.BaseCwdFile bean, String additional ) throws Exception {

		CwdFile dao = new CwdFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFile( com.pomplatform.db.bean.BaseCwdFile bean, String additional ) throws Exception {

		CwdFile dao = new CwdFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFile> queryCwdFile( com.pomplatform.db.bean.BaseCwdFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFile dao = new CwdFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFile addToCwdFile ( BaseCwdFile cwdfile )  throws Exception {
		return addToCwdFile ( cwdfile , false);
	}

	public static BaseCwdFile addToCwdFile ( BaseCwdFile cwdfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFile dao = new CwdFile();
		dao.setDataFromBase(cwdfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFile addUpdateCwdFile ( BaseCwdFile cwdfile ) throws Exception {
		return addUpdateCwdFile ( cwdfile , false);
	}

	public static BaseCwdFile addUpdateCwdFile ( BaseCwdFile cwdfile, boolean singleTransaction  ) throws Exception {
		if(cwdfile.getCwdFileId() == null) return addToCwdFile(cwdfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFile dao = new CwdFile();
		dao.setDataFromBase(cwdfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFile ( BaseCwdFile bean ) throws Exception {
		CwdFile dao = new CwdFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFile updateCwdFile ( BaseCwdFile cwdfile ) throws Exception {
		CwdFile dao = new CwdFile();
		dao.setCwdFileId( cwdfile.getCwdFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfile);
			result = dao.update();
		}
		return result == 1 ? cwdfile : null ;
	}

	public static BaseCwdFile updateCwdFileDirect( BaseCwdFile cwdfile ) throws Exception {
		CwdFile dao = new CwdFile();
		int result = 0;
		dao.setDataFromBase(cwdfile);
		result = dao.update();
		return result == 1 ? cwdfile : null ;
	}

	public static int setDeleteConditions(BaseCwdFile bean, CwdFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileName() != null) {
				dao.setConditionFileName("=", bean.getFileName());
				count++;
			}
			if(bean.getFileExtension() != null) {
				dao.setConditionFileExtension("=", bean.getFileExtension());
				count++;
			}
			if(bean.getIsFolder() != null) {
				dao.setConditionIsFolder("=", bean.getIsFolder());
				count++;
			}
			if(bean.getFileType() != null) {
				dao.setConditionFileType("=", bean.getFileType());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getFileSize() != null) {
				dao.setConditionFileSize("=", bean.getFileSize());
				count++;
			}
			if(bean.getCreatePerson() != null) {
				dao.setConditionCreatePerson("=", bean.getCreatePerson());
				count++;
			}
			if(bean.getModificationPerson() != null) {
				dao.setConditionModificationPerson("=", bean.getModificationPerson());
				count++;
			}
			if(bean.getFilePath() != null) {
				dao.setConditionFilePath("=", bean.getFilePath());
				count++;
			}
			if(bean.getBucket() != null) {
				dao.setConditionBucket("=", bean.getBucket());
				count++;
			}
			if(bean.getOssKey() != null) {
				dao.setConditionOssKey("=", bean.getOssKey());
				count++;
			}
			if(bean.getFileVersionId() != null) {
				dao.setConditionFileVersionId("=", bean.getFileVersionId());
				count++;
			}
			if(bean.getFileOwner() != null) {
				dao.setConditionFileOwner("=", bean.getFileOwner());
				count++;
			}
			if(bean.getCadVersion() != null) {
				dao.setConditionCadVersion("=", bean.getCadVersion());
				count++;
			}
			if(bean.getUploadLock() != null) {
				dao.setConditionUploadLock("=", bean.getUploadLock());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
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
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getFileAttribution() != null) {
				dao.setConditionFileAttribution("=", bean.getFileAttribution());
				count++;
			}
			if(bean.getMd5() != null) {
				dao.setConditionMd5("=", bean.getMd5());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
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
			if(bean.getFolderType() != null) {
				dao.setConditionFolderType("=", bean.getFolderType());
				count++;
			}
			if(bean.getBasicFileType() != null) {
				dao.setConditionBasicFileType("=", bean.getBasicFileType());
				count++;
			}
			if(bean.getInitFilePath() != null) {
				dao.setConditionInitFilePath("=", bean.getInitFilePath());
				count++;
			}
			if(bean.getDeletePerson() != null) {
				dao.setConditionDeletePerson("=", bean.getDeletePerson());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFile bean, CwdFile dao){
		int count = 0;
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getFileName() != null) {
			if(bean.getFileName().indexOf("%") >= 0)
				dao.setConditionFileName("like", bean.getFileName());
			else
				dao.setConditionFileName("=", bean.getFileName());
			count++;
		}
		if(bean.getFileExtension() != null) {
			if(bean.getFileExtension().indexOf("%") >= 0)
				dao.setConditionFileExtension("like", bean.getFileExtension());
			else
				dao.setConditionFileExtension("=", bean.getFileExtension());
			count++;
		}
		if(bean.getIsFolder() != null) {
			dao.setConditionIsFolder("=", bean.getIsFolder());
			count++;
		}
		if(bean.getFileType() != null) {
			dao.setConditionFileType("=", bean.getFileType());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getFileSize() != null) {
			dao.setConditionFileSize("=", bean.getFileSize());
			count++;
		}
		if(bean.getCreatePerson() != null) {
			dao.setConditionCreatePerson("=", bean.getCreatePerson());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getModificationPerson() != null) {
			dao.setConditionModificationPerson("=", bean.getModificationPerson());
			count++;
		}
		if(bean.getModificationTime() != null) {
			dao.setConditionModificationTime(">=", bean.getModificationTime());
			count++;
		}
		if(bean.getFilePath() != null) {
			if(bean.getFilePath().indexOf("%") >= 0)
				dao.setConditionFilePath("like", bean.getFilePath());
			else
				dao.setConditionFilePath("=", bean.getFilePath());
			count++;
		}
		if(bean.getBucket() != null) {
			if(bean.getBucket().indexOf("%") >= 0)
				dao.setConditionBucket("like", bean.getBucket());
			else
				dao.setConditionBucket("=", bean.getBucket());
			count++;
		}
		if(bean.getOssKey() != null) {
			if(bean.getOssKey().indexOf("%") >= 0)
				dao.setConditionOssKey("like", bean.getOssKey());
			else
				dao.setConditionOssKey("=", bean.getOssKey());
			count++;
		}
		if(bean.getFileVersionId() != null) {
			dao.setConditionFileVersionId("=", bean.getFileVersionId());
			count++;
		}
		if(bean.getFileOwner() != null) {
			dao.setConditionFileOwner("=", bean.getFileOwner());
			count++;
		}
		if(bean.getCadVersion() != null) {
			if(bean.getCadVersion().indexOf("%") >= 0)
				dao.setConditionCadVersion("like", bean.getCadVersion());
			else
				dao.setConditionCadVersion("=", bean.getCadVersion());
			count++;
		}
		if(bean.getUploadLock() != null) {
			dao.setConditionUploadLock("=", bean.getUploadLock());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
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
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getFileAttribution() != null) {
			dao.setConditionFileAttribution("=", bean.getFileAttribution());
			count++;
		}
		if(bean.getMd5() != null) {
			if(bean.getMd5().indexOf("%") >= 0)
				dao.setConditionMd5("like", bean.getMd5());
			else
				dao.setConditionMd5("=", bean.getMd5());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
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
		if(bean.getFolderType() != null) {
			dao.setConditionFolderType("=", bean.getFolderType());
			count++;
		}
		if(bean.getBasicFileType() != null) {
			dao.setConditionBasicFileType("=", bean.getBasicFileType());
			count++;
		}
		if(bean.getInitFilePath() != null) {
			if(bean.getInitFilePath().indexOf("%") >= 0)
				dao.setConditionInitFilePath("like", bean.getInitFilePath());
			else
				dao.setConditionInitFilePath("=", bean.getInitFilePath());
			count++;
		}
		if(bean.getDeletePerson() != null) {
			dao.setConditionDeletePerson("=", bean.getDeletePerson());
			count++;
		}
		if(bean.getDeleteTime() != null) {
			dao.setConditionDeleteTime(">=", bean.getDeleteTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFile bean = new BaseCwdFile();
		bean.setDataFromJSON(json);
		CwdFile dao = new CwdFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFile> rlist = new BaseCollection<>();
		BaseCwdFile bean = new BaseCwdFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFile dao = new CwdFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFile> result = dao.conditionalLoad(addtion);
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
		BaseCwdFile bean = new BaseCwdFile();
		bean.setDataFromJSON(json);
		CwdFile dao = new CwdFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFile bean = new BaseCwdFile();
		bean.setDataFromJSON(json);
		CwdFile dao = new CwdFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFile bean = new BaseCwdFile();
		bean.setDataFromJSON(json);
		CwdFile dao = new CwdFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFile bean = new BaseCwdFile();
		bean.setDataFromJSON(json);
		CwdFile dao = new CwdFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


