package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResourceDownload;
import java.util.List;
import com.pomplatform.db.dao.CnResourceDownload;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourceDownloadHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourceDownloadHandler.class);

	public static BaseCnResourceDownload getCnResourceDownloadById( 
		java.lang.Integer resource_download_id
	) throws Exception
	{
		CnResourceDownload dao = new CnResourceDownload();
		dao.setResourceDownloadId(resource_download_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourceDownloadExists( com.pomplatform.db.bean.BaseCnResourceDownload bean, String additional ) throws Exception {

		CnResourceDownload dao = new CnResourceDownload();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResourceDownload( com.pomplatform.db.bean.BaseCnResourceDownload bean, String additional ) throws Exception {

		CnResourceDownload dao = new CnResourceDownload();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResourceDownload> queryCnResourceDownload( com.pomplatform.db.bean.BaseCnResourceDownload bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResourceDownload dao = new CnResourceDownload();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResourceDownload> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResourceDownload> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResourceDownload addToCnResourceDownload ( BaseCnResourceDownload cnresourcedownload )  throws Exception {
		return addToCnResourceDownload ( cnresourcedownload , false);
	}

	public static BaseCnResourceDownload addToCnResourceDownload ( BaseCnResourceDownload cnresourcedownload, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResourceDownload dao = new CnResourceDownload();
		dao.setDataFromBase(cnresourcedownload);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResourceDownload addUpdateCnResourceDownload ( BaseCnResourceDownload cnresourcedownload ) throws Exception {
		return addUpdateCnResourceDownload ( cnresourcedownload , false);
	}

	public static BaseCnResourceDownload addUpdateCnResourceDownload ( BaseCnResourceDownload cnresourcedownload, boolean singleTransaction  ) throws Exception {
		if(cnresourcedownload.getResourceDownloadId() == null) return addToCnResourceDownload(cnresourcedownload);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResourceDownload dao = new CnResourceDownload();
		dao.setDataFromBase(cnresourcedownload);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresourcedownload); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResourceDownload ( BaseCnResourceDownload bean ) throws Exception {
		CnResourceDownload dao = new CnResourceDownload();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResourceDownload updateCnResourceDownload ( BaseCnResourceDownload cnresourcedownload ) throws Exception {
		CnResourceDownload dao = new CnResourceDownload();
		dao.setResourceDownloadId( cnresourcedownload.getResourceDownloadId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresourcedownload);
			result = dao.update();
		}
		return result == 1 ? cnresourcedownload : null ;
	}

	public static BaseCnResourceDownload updateCnResourceDownloadDirect( BaseCnResourceDownload cnresourcedownload ) throws Exception {
		CnResourceDownload dao = new CnResourceDownload();
		int result = 0;
		dao.setDataFromBase(cnresourcedownload);
		result = dao.update();
		return result == 1 ? cnresourcedownload : null ;
	}

	public static int setDeleteConditions(BaseCnResourceDownload bean, CnResourceDownload dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResourceDownloadId() != null) {
			dao.setConditionResourceDownloadId("=", bean.getResourceDownloadId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getResourceId() != null) {
				dao.setConditionResourceId("=", bean.getResourceId());
				count++;
			}
			if(bean.getResourceAttachmentId() != null) {
				dao.setConditionResourceAttachmentId("=", bean.getResourceAttachmentId());
				count++;
			}
			if(bean.getDownloader() != null) {
				dao.setConditionDownloader("=", bean.getDownloader());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnResourceDownload bean, CnResourceDownload dao){
		int count = 0;
		if(bean.getResourceDownloadId() != null) {
			dao.setConditionResourceDownloadId("=", bean.getResourceDownloadId());
			count++;
		}
		if(bean.getResourceId() != null) {
			dao.setConditionResourceId("=", bean.getResourceId());
			count++;
		}
		if(bean.getResourceAttachmentId() != null) {
			dao.setConditionResourceAttachmentId("=", bean.getResourceAttachmentId());
			count++;
		}
		if(bean.getDownloader() != null) {
			dao.setConditionDownloader("=", bean.getDownloader());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOrganizationId() != null) {
			dao.setConditionOrganizationId("=", bean.getOrganizationId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCnResourceDownload bean = new BaseCnResourceDownload();
		bean.setDataFromJSON(json);
		CnResourceDownload dao = new CnResourceDownload();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResourceDownload> rlist = new BaseCollection<>();
		BaseCnResourceDownload bean = new BaseCnResourceDownload();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResourceDownload dao = new CnResourceDownload();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResourceDownload> result = dao.conditionalLoad(addtion);
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
		BaseCnResourceDownload bean = new BaseCnResourceDownload();
		bean.setDataFromJSON(json);
		CnResourceDownload dao = new CnResourceDownload();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResourceDownload bean = new BaseCnResourceDownload();
		bean.setDataFromJSON(json);
		CnResourceDownload dao = new CnResourceDownload();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResourceDownload bean = new BaseCnResourceDownload();
		bean.setDataFromJSON(json);
		CnResourceDownload dao = new CnResourceDownload();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResourceDownload bean = new BaseCnResourceDownload();
		bean.setDataFromJSON(json);
		CnResourceDownload dao = new CnResourceDownload();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


