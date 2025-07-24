package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResourceFavoriteDetail;
import java.util.List;
import com.pomplatform.db.dao.CnResourceFavoriteDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourceFavoriteDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourceFavoriteDetailHandler.class);

	public static BaseCnResourceFavoriteDetail getCnResourceFavoriteDetailById( 
		java.lang.Integer resource_favorite_detail_id
	) throws Exception
	{
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setResourceFavoriteDetailId(resource_favorite_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourceFavoriteDetailExists( com.pomplatform.db.bean.BaseCnResourceFavoriteDetail bean, String additional ) throws Exception {

		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResourceFavoriteDetail( com.pomplatform.db.bean.BaseCnResourceFavoriteDetail bean, String additional ) throws Exception {

		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResourceFavoriteDetail> queryCnResourceFavoriteDetail( com.pomplatform.db.bean.BaseCnResourceFavoriteDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResourceFavoriteDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResourceFavoriteDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResourceFavoriteDetail addToCnResourceFavoriteDetail ( BaseCnResourceFavoriteDetail cnresourcefavoritedetail )  throws Exception {
		return addToCnResourceFavoriteDetail ( cnresourcefavoritedetail , false);
	}

	public static BaseCnResourceFavoriteDetail addToCnResourceFavoriteDetail ( BaseCnResourceFavoriteDetail cnresourcefavoritedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setDataFromBase(cnresourcefavoritedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResourceFavoriteDetail addUpdateCnResourceFavoriteDetail ( BaseCnResourceFavoriteDetail cnresourcefavoritedetail ) throws Exception {
		return addUpdateCnResourceFavoriteDetail ( cnresourcefavoritedetail , false);
	}

	public static BaseCnResourceFavoriteDetail addUpdateCnResourceFavoriteDetail ( BaseCnResourceFavoriteDetail cnresourcefavoritedetail, boolean singleTransaction  ) throws Exception {
		if(cnresourcefavoritedetail.getResourceFavoriteDetailId() == null) return addToCnResourceFavoriteDetail(cnresourcefavoritedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setDataFromBase(cnresourcefavoritedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresourcefavoritedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResourceFavoriteDetail ( BaseCnResourceFavoriteDetail bean ) throws Exception {
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResourceFavoriteDetail updateCnResourceFavoriteDetail ( BaseCnResourceFavoriteDetail cnresourcefavoritedetail ) throws Exception {
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setResourceFavoriteDetailId( cnresourcefavoritedetail.getResourceFavoriteDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresourcefavoritedetail);
			result = dao.update();
		}
		return result == 1 ? cnresourcefavoritedetail : null ;
	}

	public static BaseCnResourceFavoriteDetail updateCnResourceFavoriteDetailDirect( BaseCnResourceFavoriteDetail cnresourcefavoritedetail ) throws Exception {
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		int result = 0;
		dao.setDataFromBase(cnresourcefavoritedetail);
		result = dao.update();
		return result == 1 ? cnresourcefavoritedetail : null ;
	}

	public static int setDeleteConditions(BaseCnResourceFavoriteDetail bean, CnResourceFavoriteDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResourceFavoriteDetailId() != null) {
			dao.setConditionResourceFavoriteDetailId("=", bean.getResourceFavoriteDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getResourceFavoriteId() != null) {
				dao.setConditionResourceFavoriteId("=", bean.getResourceFavoriteId());
				count++;
			}
			if(bean.getResourceId() != null) {
				dao.setConditionResourceId("=", bean.getResourceId());
				count++;
			}
			if(bean.getDescription() != null) {
				dao.setConditionDescription("=", bean.getDescription());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnResourceFavoriteDetail bean, CnResourceFavoriteDetail dao){
		int count = 0;
		if(bean.getResourceFavoriteDetailId() != null) {
			dao.setConditionResourceFavoriteDetailId("=", bean.getResourceFavoriteDetailId());
			count++;
		}
		if(bean.getResourceFavoriteId() != null) {
			dao.setConditionResourceFavoriteId("=", bean.getResourceFavoriteId());
			count++;
		}
		if(bean.getResourceId() != null) {
			dao.setConditionResourceId("=", bean.getResourceId());
			count++;
		}
		if(bean.getDescription() != null) {
			if(bean.getDescription().indexOf("%") >= 0)
				dao.setConditionDescription("like", bean.getDescription());
			else
				dao.setConditionDescription("=", bean.getDescription());
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
		BaseCnResourceFavoriteDetail bean = new BaseCnResourceFavoriteDetail();
		bean.setDataFromJSON(json);
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResourceFavoriteDetail> rlist = new BaseCollection<>();
		BaseCnResourceFavoriteDetail bean = new BaseCnResourceFavoriteDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResourceFavoriteDetail> result = dao.conditionalLoad(addtion);
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
		BaseCnResourceFavoriteDetail bean = new BaseCnResourceFavoriteDetail();
		bean.setDataFromJSON(json);
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResourceFavoriteDetail bean = new BaseCnResourceFavoriteDetail();
		bean.setDataFromJSON(json);
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResourceFavoriteDetail bean = new BaseCnResourceFavoriteDetail();
		bean.setDataFromJSON(json);
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResourceFavoriteDetail bean = new BaseCnResourceFavoriteDetail();
		bean.setDataFromJSON(json);
		CnResourceFavoriteDetail dao = new CnResourceFavoriteDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


