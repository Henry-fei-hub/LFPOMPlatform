package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResource;
import java.util.List;
import com.pomplatform.db.dao.CnResource;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourceHandler.class);

	public static BaseCnResource getCnResourceById( 
		java.lang.Integer resource_id
	) throws Exception
	{
		CnResource dao = new CnResource();
		dao.setResourceId(resource_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourceExists( com.pomplatform.db.bean.BaseCnResource bean, String additional ) throws Exception {

		CnResource dao = new CnResource();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResource( com.pomplatform.db.bean.BaseCnResource bean, String additional ) throws Exception {

		CnResource dao = new CnResource();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResource> queryCnResource( com.pomplatform.db.bean.BaseCnResource bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResource dao = new CnResource();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResource> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResource> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResource addToCnResource ( BaseCnResource cnresource )  throws Exception {
		return addToCnResource ( cnresource , false);
	}

	public static BaseCnResource addToCnResource ( BaseCnResource cnresource, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResource dao = new CnResource();
		dao.setDataFromBase(cnresource);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResource addUpdateCnResource ( BaseCnResource cnresource ) throws Exception {
		return addUpdateCnResource ( cnresource , false);
	}

	public static BaseCnResource addUpdateCnResource ( BaseCnResource cnresource, boolean singleTransaction  ) throws Exception {
		if(cnresource.getResourceId() == null) return addToCnResource(cnresource);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResource dao = new CnResource();
		dao.setDataFromBase(cnresource);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresource); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResource ( BaseCnResource bean ) throws Exception {
		CnResource dao = new CnResource();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResource updateCnResource ( BaseCnResource cnresource ) throws Exception {
		CnResource dao = new CnResource();
		dao.setResourceId( cnresource.getResourceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresource);
			result = dao.update();
		}
		return result == 1 ? cnresource : null ;
	}

	public static BaseCnResource updateCnResourceDirect( BaseCnResource cnresource ) throws Exception {
		CnResource dao = new CnResource();
		int result = 0;
		dao.setDataFromBase(cnresource);
		result = dao.update();
		return result == 1 ? cnresource : null ;
	}

	public static int setDeleteConditions(BaseCnResource bean, CnResource dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResourceId() != null) {
			dao.setConditionResourceId("=", bean.getResourceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getResourcePackageId() != null) {
				dao.setConditionResourcePackageId("=", bean.getResourcePackageId());
				count++;
			}
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getDescription() != null) {
				dao.setConditionDescription("=", bean.getDescription());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getExternalUrl() != null) {
				dao.setConditionExternalUrl("=", bean.getExternalUrl());
				count++;
			}
			if(bean.getSourceType() != null) {
				dao.setConditionSourceType("=", bean.getSourceType());
				count++;
			}
			if(bean.getResourceType() != null) {
				dao.setConditionResourceType("=", bean.getResourceType());
				count++;
			}
			if(bean.getCreator() != null) {
				dao.setConditionCreator("=", bean.getCreator());
				count++;
			}
			if(bean.getFileManageId() != null) {
				dao.setConditionFileManageId("=", bean.getFileManageId());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnResource bean, CnResource dao){
		int count = 0;
		if(bean.getResourceId() != null) {
			dao.setConditionResourceId("=", bean.getResourceId());
			count++;
		}
		if(bean.getResourcePackageId() != null) {
			dao.setConditionResourcePackageId("=", bean.getResourcePackageId());
			count++;
		}
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getDescription() != null) {
			if(bean.getDescription().indexOf("%") >= 0)
				dao.setConditionDescription("like", bean.getDescription());
			else
				dao.setConditionDescription("=", bean.getDescription());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getExternalUrl() != null) {
			if(bean.getExternalUrl().indexOf("%") >= 0)
				dao.setConditionExternalUrl("like", bean.getExternalUrl());
			else
				dao.setConditionExternalUrl("=", bean.getExternalUrl());
			count++;
		}
		if(bean.getSourceType() != null) {
			dao.setConditionSourceType("=", bean.getSourceType());
			count++;
		}
		if(bean.getResourceType() != null) {
			dao.setConditionResourceType("=", bean.getResourceType());
			count++;
		}
		if(bean.getCreator() != null) {
			dao.setConditionCreator("=", bean.getCreator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getFileManageId() != null) {
			dao.setConditionFileManageId("=", bean.getFileManageId());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
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
		BaseCnResource bean = new BaseCnResource();
		bean.setDataFromJSON(json);
		CnResource dao = new CnResource();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResource> rlist = new BaseCollection<>();
		BaseCnResource bean = new BaseCnResource();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResource dao = new CnResource();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResource> result = dao.conditionalLoad(addtion);
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
		BaseCnResource bean = new BaseCnResource();
		bean.setDataFromJSON(json);
		CnResource dao = new CnResource();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResource bean = new BaseCnResource();
		bean.setDataFromJSON(json);
		CnResource dao = new CnResource();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResource bean = new BaseCnResource();
		bean.setDataFromJSON(json);
		CnResource dao = new CnResource();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResource bean = new BaseCnResource();
		bean.setDataFromJSON(json);
		CnResource dao = new CnResource();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


