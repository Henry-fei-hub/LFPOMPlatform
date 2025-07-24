package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResourcePackage;
import java.util.List;
import com.pomplatform.db.dao.CnResourcePackage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourcePackageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourcePackageHandler.class);

	public static BaseCnResourcePackage getCnResourcePackageById( 
		java.lang.Integer resource_package_id
	) throws Exception
	{
		CnResourcePackage dao = new CnResourcePackage();
		dao.setResourcePackageId(resource_package_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourcePackageExists( com.pomplatform.db.bean.BaseCnResourcePackage bean, String additional ) throws Exception {

		CnResourcePackage dao = new CnResourcePackage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResourcePackage( com.pomplatform.db.bean.BaseCnResourcePackage bean, String additional ) throws Exception {

		CnResourcePackage dao = new CnResourcePackage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResourcePackage> queryCnResourcePackage( com.pomplatform.db.bean.BaseCnResourcePackage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResourcePackage dao = new CnResourcePackage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResourcePackage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResourcePackage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResourcePackage addToCnResourcePackage ( BaseCnResourcePackage cnresourcepackage )  throws Exception {
		return addToCnResourcePackage ( cnresourcepackage , false);
	}

	public static BaseCnResourcePackage addToCnResourcePackage ( BaseCnResourcePackage cnresourcepackage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResourcePackage dao = new CnResourcePackage();
		dao.setDataFromBase(cnresourcepackage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResourcePackage addUpdateCnResourcePackage ( BaseCnResourcePackage cnresourcepackage ) throws Exception {
		return addUpdateCnResourcePackage ( cnresourcepackage , false);
	}

	public static BaseCnResourcePackage addUpdateCnResourcePackage ( BaseCnResourcePackage cnresourcepackage, boolean singleTransaction  ) throws Exception {
		if(cnresourcepackage.getResourcePackageId() == null) return addToCnResourcePackage(cnresourcepackage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResourcePackage dao = new CnResourcePackage();
		dao.setDataFromBase(cnresourcepackage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresourcepackage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResourcePackage ( BaseCnResourcePackage bean ) throws Exception {
		CnResourcePackage dao = new CnResourcePackage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResourcePackage updateCnResourcePackage ( BaseCnResourcePackage cnresourcepackage ) throws Exception {
		CnResourcePackage dao = new CnResourcePackage();
		dao.setResourcePackageId( cnresourcepackage.getResourcePackageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresourcepackage);
			result = dao.update();
		}
		return result == 1 ? cnresourcepackage : null ;
	}

	public static BaseCnResourcePackage updateCnResourcePackageDirect( BaseCnResourcePackage cnresourcepackage ) throws Exception {
		CnResourcePackage dao = new CnResourcePackage();
		int result = 0;
		dao.setDataFromBase(cnresourcepackage);
		result = dao.update();
		return result == 1 ? cnresourcepackage : null ;
	}

	public static int setDeleteConditions(BaseCnResourcePackage bean, CnResourcePackage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResourcePackageId() != null) {
			dao.setConditionResourcePackageId("=", bean.getResourcePackageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPackageName() != null) {
				dao.setConditionPackageName("=", bean.getPackageName());
				count++;
			}
			if(bean.getPackageCode() != null) {
				dao.setConditionPackageCode("=", bean.getPackageCode());
				count++;
			}
			if(bean.getCreator() != null) {
				dao.setConditionCreator("=", bean.getCreator());
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

	public static int setConditions(BaseCnResourcePackage bean, CnResourcePackage dao){
		int count = 0;
		if(bean.getResourcePackageId() != null) {
			dao.setConditionResourcePackageId("=", bean.getResourcePackageId());
			count++;
		}
		if(bean.getPackageName() != null) {
			if(bean.getPackageName().indexOf("%") >= 0)
				dao.setConditionPackageName("like", bean.getPackageName());
			else
				dao.setConditionPackageName("=", bean.getPackageName());
			count++;
		}
		if(bean.getPackageCode() != null) {
			if(bean.getPackageCode().indexOf("%") >= 0)
				dao.setConditionPackageCode("like", bean.getPackageCode());
			else
				dao.setConditionPackageCode("=", bean.getPackageCode());
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
		BaseCnResourcePackage bean = new BaseCnResourcePackage();
		bean.setDataFromJSON(json);
		CnResourcePackage dao = new CnResourcePackage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResourcePackage> rlist = new BaseCollection<>();
		BaseCnResourcePackage bean = new BaseCnResourcePackage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResourcePackage dao = new CnResourcePackage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResourcePackage> result = dao.conditionalLoad(addtion);
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
		BaseCnResourcePackage bean = new BaseCnResourcePackage();
		bean.setDataFromJSON(json);
		CnResourcePackage dao = new CnResourcePackage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResourcePackage bean = new BaseCnResourcePackage();
		bean.setDataFromJSON(json);
		CnResourcePackage dao = new CnResourcePackage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResourcePackage bean = new BaseCnResourcePackage();
		bean.setDataFromJSON(json);
		CnResourcePackage dao = new CnResourcePackage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResourcePackage bean = new BaseCnResourcePackage();
		bean.setDataFromJSON(json);
		CnResourcePackage dao = new CnResourcePackage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


