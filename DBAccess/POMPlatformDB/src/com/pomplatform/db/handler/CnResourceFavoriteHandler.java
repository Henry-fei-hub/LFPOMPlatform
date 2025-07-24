package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResourceFavorite;
import java.util.List;
import com.pomplatform.db.dao.CnResourceFavorite;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourceFavoriteHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourceFavoriteHandler.class);

	public static BaseCnResourceFavorite getCnResourceFavoriteById( 
		java.lang.Integer resource_favorite_id
	) throws Exception
	{
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setResourceFavoriteId(resource_favorite_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourceFavoriteExists( com.pomplatform.db.bean.BaseCnResourceFavorite bean, String additional ) throws Exception {

		CnResourceFavorite dao = new CnResourceFavorite();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResourceFavorite( com.pomplatform.db.bean.BaseCnResourceFavorite bean, String additional ) throws Exception {

		CnResourceFavorite dao = new CnResourceFavorite();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResourceFavorite> queryCnResourceFavorite( com.pomplatform.db.bean.BaseCnResourceFavorite bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResourceFavorite dao = new CnResourceFavorite();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResourceFavorite> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResourceFavorite> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResourceFavorite addToCnResourceFavorite ( BaseCnResourceFavorite cnresourcefavorite )  throws Exception {
		return addToCnResourceFavorite ( cnresourcefavorite , false);
	}

	public static BaseCnResourceFavorite addToCnResourceFavorite ( BaseCnResourceFavorite cnresourcefavorite, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setDataFromBase(cnresourcefavorite);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResourceFavorite addUpdateCnResourceFavorite ( BaseCnResourceFavorite cnresourcefavorite ) throws Exception {
		return addUpdateCnResourceFavorite ( cnresourcefavorite , false);
	}

	public static BaseCnResourceFavorite addUpdateCnResourceFavorite ( BaseCnResourceFavorite cnresourcefavorite, boolean singleTransaction  ) throws Exception {
		if(cnresourcefavorite.getResourceFavoriteId() == null) return addToCnResourceFavorite(cnresourcefavorite);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setDataFromBase(cnresourcefavorite);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresourcefavorite); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResourceFavorite ( BaseCnResourceFavorite bean ) throws Exception {
		CnResourceFavorite dao = new CnResourceFavorite();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResourceFavorite updateCnResourceFavorite ( BaseCnResourceFavorite cnresourcefavorite ) throws Exception {
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setResourceFavoriteId( cnresourcefavorite.getResourceFavoriteId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresourcefavorite);
			result = dao.update();
		}
		return result == 1 ? cnresourcefavorite : null ;
	}

	public static BaseCnResourceFavorite updateCnResourceFavoriteDirect( BaseCnResourceFavorite cnresourcefavorite ) throws Exception {
		CnResourceFavorite dao = new CnResourceFavorite();
		int result = 0;
		dao.setDataFromBase(cnresourcefavorite);
		result = dao.update();
		return result == 1 ? cnresourcefavorite : null ;
	}

	public static int setDeleteConditions(BaseCnResourceFavorite bean, CnResourceFavorite dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResourceFavoriteId() != null) {
			dao.setConditionResourceFavoriteId("=", bean.getResourceFavoriteId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getDescription() != null) {
				dao.setConditionDescription("=", bean.getDescription());
				count++;
			}
			if(bean.getPrivateStatus() != null) {
				dao.setConditionPrivateStatus("=", bean.getPrivateStatus());
				count++;
			}
			if(bean.getCreator() != null) {
				dao.setConditionCreator("=", bean.getCreator());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnResourceFavorite bean, CnResourceFavorite dao){
		int count = 0;
		if(bean.getResourceFavoriteId() != null) {
			dao.setConditionResourceFavoriteId("=", bean.getResourceFavoriteId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getDescription() != null) {
			if(bean.getDescription().indexOf("%") >= 0)
				dao.setConditionDescription("like", bean.getDescription());
			else
				dao.setConditionDescription("=", bean.getDescription());
			count++;
		}
		if(bean.getPrivateStatus() != null) {
			dao.setConditionPrivateStatus("=", bean.getPrivateStatus());
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
		if(bean.getOrganizationId() != null) {
			dao.setConditionOrganizationId("=", bean.getOrganizationId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCnResourceFavorite bean = new BaseCnResourceFavorite();
		bean.setDataFromJSON(json);
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResourceFavorite> rlist = new BaseCollection<>();
		BaseCnResourceFavorite bean = new BaseCnResourceFavorite();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResourceFavorite dao = new CnResourceFavorite();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResourceFavorite> result = dao.conditionalLoad(addtion);
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
		BaseCnResourceFavorite bean = new BaseCnResourceFavorite();
		bean.setDataFromJSON(json);
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResourceFavorite bean = new BaseCnResourceFavorite();
		bean.setDataFromJSON(json);
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResourceFavorite bean = new BaseCnResourceFavorite();
		bean.setDataFromJSON(json);
		CnResourceFavorite dao = new CnResourceFavorite();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResourceFavorite bean = new BaseCnResourceFavorite();
		bean.setDataFromJSON(json);
		CnResourceFavorite dao = new CnResourceFavorite();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


