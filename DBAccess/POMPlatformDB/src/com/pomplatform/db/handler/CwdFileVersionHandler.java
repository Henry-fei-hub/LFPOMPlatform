package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFileVersion;
import com.pomplatform.db.dao.CwdFileVersion;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFileVersionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFileVersionHandler.class);

	public static BaseCwdFileVersion getCwdFileVersionById( 
		java.lang.Integer cwd_file_version_id
	) throws Exception
	{
		CwdFileVersion dao = new CwdFileVersion();
		dao.setCwdFileVersionId(cwd_file_version_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFileVersionExists( com.pomplatform.db.bean.BaseCwdFileVersion bean, String additional ) throws Exception {

		CwdFileVersion dao = new CwdFileVersion();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFileVersion( com.pomplatform.db.bean.BaseCwdFileVersion bean, String additional ) throws Exception {

		CwdFileVersion dao = new CwdFileVersion();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFileVersion> queryCwdFileVersion( com.pomplatform.db.bean.BaseCwdFileVersion bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFileVersion dao = new CwdFileVersion();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFileVersion> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFileVersion> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFileVersion addToCwdFileVersion ( BaseCwdFileVersion cwdfileversion )  throws Exception {
		return addToCwdFileVersion ( cwdfileversion , false);
	}

	public static BaseCwdFileVersion addToCwdFileVersion ( BaseCwdFileVersion cwdfileversion, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFileVersion dao = new CwdFileVersion();
		dao.setDataFromBase(cwdfileversion);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFileVersion addUpdateCwdFileVersion ( BaseCwdFileVersion cwdfileversion ) throws Exception {
		return addUpdateCwdFileVersion ( cwdfileversion , false);
	}

	public static BaseCwdFileVersion addUpdateCwdFileVersion ( BaseCwdFileVersion cwdfileversion, boolean singleTransaction  ) throws Exception {
		if(cwdfileversion.getCwdFileVersionId() == null) return addToCwdFileVersion(cwdfileversion);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFileVersion dao = new CwdFileVersion();
		dao.setDataFromBase(cwdfileversion);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfileversion); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFileVersion ( BaseCwdFileVersion bean ) throws Exception {
		CwdFileVersion dao = new CwdFileVersion();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFileVersion updateCwdFileVersion ( BaseCwdFileVersion cwdfileversion ) throws Exception {
		CwdFileVersion dao = new CwdFileVersion();
		dao.setCwdFileVersionId( cwdfileversion.getCwdFileVersionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfileversion);
			result = dao.update();
		}
		return result == 1 ? cwdfileversion : null ;
	}

	public static BaseCwdFileVersion updateCwdFileVersionDirect( BaseCwdFileVersion cwdfileversion ) throws Exception {
		CwdFileVersion dao = new CwdFileVersion();
		int result = 0;
		dao.setDataFromBase(cwdfileversion);
		result = dao.update();
		return result == 1 ? cwdfileversion : null ;
	}

	public static int setDeleteConditions(BaseCwdFileVersion bean, CwdFileVersion dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFileVersionId() != null) {
			dao.setConditionCwdFileVersionId("=", bean.getCwdFileVersionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
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
			if(bean.getUploader() != null) {
				dao.setConditionUploader("=", bean.getUploader());
				count++;
			}
			if(bean.getUploadStatus() != null) {
				dao.setConditionUploadStatus("=", bean.getUploadStatus());
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
			if(bean.getCadVersion() != null) {
				dao.setConditionCadVersion("=", bean.getCadVersion());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getAction() != null) {
				dao.setConditionAction("=", bean.getAction());
				count++;
			}
			if(bean.getMacAddress() != null) {
				dao.setConditionMacAddress("=", bean.getMacAddress());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFileVersion bean, CwdFileVersion dao){
		int count = 0;
		if(bean.getCwdFileVersionId() != null) {
			dao.setConditionCwdFileVersionId("=", bean.getCwdFileVersionId());
			count++;
		}
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
		if(bean.getUploader() != null) {
			dao.setConditionUploader("=", bean.getUploader());
			count++;
		}
		if(bean.getUploadStartTime() != null) {
			dao.setConditionUploadStartTime(">=", bean.getUploadStartTime());
			count++;
		}
		if(bean.getUploadCompletedTime() != null) {
			dao.setConditionUploadCompletedTime(">=", bean.getUploadCompletedTime());
			count++;
		}
		if(bean.getUploadStatus() != null) {
			dao.setConditionUploadStatus("=", bean.getUploadStatus());
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
		if(bean.getCadVersion() != null) {
			if(bean.getCadVersion().indexOf("%") >= 0)
				dao.setConditionCadVersion("like", bean.getCadVersion());
			else
				dao.setConditionCadVersion("=", bean.getCadVersion());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getAction() != null) {
			dao.setConditionAction("=", bean.getAction());
			count++;
		}
		if(bean.getMacAddress() != null) {
			if(bean.getMacAddress().indexOf("%") >= 0)
				dao.setConditionMacAddress("like", bean.getMacAddress());
			else
				dao.setConditionMacAddress("=", bean.getMacAddress());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFileVersion bean = new BaseCwdFileVersion();
		bean.setDataFromJSON(json);
		CwdFileVersion dao = new CwdFileVersion();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFileVersion> rlist = new BaseCollection<>();
		BaseCwdFileVersion bean = new BaseCwdFileVersion();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFileVersion dao = new CwdFileVersion();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFileVersion> result = dao.conditionalLoad(addtion);
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
		BaseCwdFileVersion bean = new BaseCwdFileVersion();
		bean.setDataFromJSON(json);
		CwdFileVersion dao = new CwdFileVersion();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFileVersion bean = new BaseCwdFileVersion();
		bean.setDataFromJSON(json);
		CwdFileVersion dao = new CwdFileVersion();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFileVersion bean = new BaseCwdFileVersion();
		bean.setDataFromJSON(json);
		CwdFileVersion dao = new CwdFileVersion();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFileVersion bean = new BaseCwdFileVersion();
		bean.setDataFromJSON(json);
		CwdFileVersion dao = new CwdFileVersion();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


