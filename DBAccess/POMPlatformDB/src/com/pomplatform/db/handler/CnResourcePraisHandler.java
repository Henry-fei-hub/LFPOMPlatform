package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResourcePrais;
import java.util.List;
import com.pomplatform.db.dao.CnResourcePrais;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourcePraisHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourcePraisHandler.class);

	public static BaseCnResourcePrais getCnResourcePraisById( 
		java.lang.Integer resource_praise_id
	) throws Exception
	{
		CnResourcePrais dao = new CnResourcePrais();
		dao.setResourcePraiseId(resource_praise_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourcePraisExists( com.pomplatform.db.bean.BaseCnResourcePrais bean, String additional ) throws Exception {

		CnResourcePrais dao = new CnResourcePrais();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResourcePrais( com.pomplatform.db.bean.BaseCnResourcePrais bean, String additional ) throws Exception {

		CnResourcePrais dao = new CnResourcePrais();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResourcePrais> queryCnResourcePrais( com.pomplatform.db.bean.BaseCnResourcePrais bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResourcePrais dao = new CnResourcePrais();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResourcePrais> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResourcePrais> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResourcePrais addToCnResourcePrais ( BaseCnResourcePrais cnresourceprais )  throws Exception {
		return addToCnResourcePrais ( cnresourceprais , false);
	}

	public static BaseCnResourcePrais addToCnResourcePrais ( BaseCnResourcePrais cnresourceprais, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResourcePrais dao = new CnResourcePrais();
		dao.setDataFromBase(cnresourceprais);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResourcePrais addUpdateCnResourcePrais ( BaseCnResourcePrais cnresourceprais ) throws Exception {
		return addUpdateCnResourcePrais ( cnresourceprais , false);
	}

	public static BaseCnResourcePrais addUpdateCnResourcePrais ( BaseCnResourcePrais cnresourceprais, boolean singleTransaction  ) throws Exception {
		if(cnresourceprais.getResourcePraiseId() == null) return addToCnResourcePrais(cnresourceprais);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResourcePrais dao = new CnResourcePrais();
		dao.setDataFromBase(cnresourceprais);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresourceprais); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResourcePrais ( BaseCnResourcePrais bean ) throws Exception {
		CnResourcePrais dao = new CnResourcePrais();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResourcePrais updateCnResourcePrais ( BaseCnResourcePrais cnresourceprais ) throws Exception {
		CnResourcePrais dao = new CnResourcePrais();
		dao.setResourcePraiseId( cnresourceprais.getResourcePraiseId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresourceprais);
			result = dao.update();
		}
		return result == 1 ? cnresourceprais : null ;
	}

	public static BaseCnResourcePrais updateCnResourcePraisDirect( BaseCnResourcePrais cnresourceprais ) throws Exception {
		CnResourcePrais dao = new CnResourcePrais();
		int result = 0;
		dao.setDataFromBase(cnresourceprais);
		result = dao.update();
		return result == 1 ? cnresourceprais : null ;
	}

	public static int setDeleteConditions(BaseCnResourcePrais bean, CnResourcePrais dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResourcePraiseId() != null) {
			dao.setConditionResourcePraiseId("=", bean.getResourcePraiseId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getResourceId() != null) {
				dao.setConditionResourceId("=", bean.getResourceId());
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

	public static int setConditions(BaseCnResourcePrais bean, CnResourcePrais dao){
		int count = 0;
		if(bean.getResourcePraiseId() != null) {
			dao.setConditionResourcePraiseId("=", bean.getResourcePraiseId());
			count++;
		}
		if(bean.getResourceId() != null) {
			dao.setConditionResourceId("=", bean.getResourceId());
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
		BaseCnResourcePrais bean = new BaseCnResourcePrais();
		bean.setDataFromJSON(json);
		CnResourcePrais dao = new CnResourcePrais();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResourcePrais> rlist = new BaseCollection<>();
		BaseCnResourcePrais bean = new BaseCnResourcePrais();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResourcePrais dao = new CnResourcePrais();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResourcePrais> result = dao.conditionalLoad(addtion);
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
		BaseCnResourcePrais bean = new BaseCnResourcePrais();
		bean.setDataFromJSON(json);
		CnResourcePrais dao = new CnResourcePrais();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResourcePrais bean = new BaseCnResourcePrais();
		bean.setDataFromJSON(json);
		CnResourcePrais dao = new CnResourcePrais();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResourcePrais bean = new BaseCnResourcePrais();
		bean.setDataFromJSON(json);
		CnResourcePrais dao = new CnResourcePrais();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResourcePrais bean = new BaseCnResourcePrais();
		bean.setDataFromJSON(json);
		CnResourcePrais dao = new CnResourcePrais();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


