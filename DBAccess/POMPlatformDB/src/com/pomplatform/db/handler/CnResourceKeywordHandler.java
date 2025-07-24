package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnResourceKeyword;
import java.util.List;
import com.pomplatform.db.dao.CnResourceKeyword;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnResourceKeywordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnResourceKeywordHandler.class);

	public static BaseCnResourceKeyword getCnResourceKeywordById( 

	) throws Exception
	{
		CnResourceKeyword dao = new CnResourceKeyword();
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnResourceKeywordExists( com.pomplatform.db.bean.BaseCnResourceKeyword bean, String additional ) throws Exception {

		CnResourceKeyword dao = new CnResourceKeyword();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnResourceKeyword( com.pomplatform.db.bean.BaseCnResourceKeyword bean, String additional ) throws Exception {

		CnResourceKeyword dao = new CnResourceKeyword();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnResourceKeyword> queryCnResourceKeyword( com.pomplatform.db.bean.BaseCnResourceKeyword bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnResourceKeyword dao = new CnResourceKeyword();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnResourceKeyword> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnResourceKeyword> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnResourceKeyword addToCnResourceKeyword ( BaseCnResourceKeyword cnresourcekeyword )  throws Exception {
		return addToCnResourceKeyword ( cnresourcekeyword , false);
	}

	public static BaseCnResourceKeyword addToCnResourceKeyword ( BaseCnResourceKeyword cnresourcekeyword, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnResourceKeyword dao = new CnResourceKeyword();
		dao.setDataFromBase(cnresourcekeyword);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnResourceKeyword addUpdateCnResourceKeyword ( BaseCnResourceKeyword cnresourcekeyword ) throws Exception {
		return addUpdateCnResourceKeyword ( cnresourcekeyword , false);
	}

	public static BaseCnResourceKeyword addUpdateCnResourceKeyword ( BaseCnResourceKeyword cnresourcekeyword, boolean singleTransaction  ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnResourceKeyword dao = new CnResourceKeyword();
		dao.setDataFromBase(cnresourcekeyword);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnresourcekeyword); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnResourceKeyword ( BaseCnResourceKeyword bean ) throws Exception {
		CnResourceKeyword dao = new CnResourceKeyword();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnResourceKeyword updateCnResourceKeyword ( BaseCnResourceKeyword cnresourcekeyword ) throws Exception {
		CnResourceKeyword dao = new CnResourceKeyword();
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnresourcekeyword);
			result = dao.update();
		}
		return result == 1 ? cnresourcekeyword : null ;
	}

	public static BaseCnResourceKeyword updateCnResourceKeywordDirect( BaseCnResourceKeyword cnresourcekeyword ) throws Exception {
		CnResourceKeyword dao = new CnResourceKeyword();
		int result = 0;
		dao.setDataFromBase(cnresourcekeyword);
		result = dao.update();
		return result == 1 ? cnresourcekeyword : null ;
	}

	public static int setDeleteConditions(BaseCnResourceKeyword bean, CnResourceKeyword dao){
		int count = 0;
		boolean foundKey = false;
		if(!foundKey) {
			if(bean.getResourceKeywordId() != null) {
				dao.setConditionResourceKeywordId("=", bean.getResourceKeywordId());
				count++;
			}
			if(bean.getKeyName() != null) {
				dao.setConditionKeyName("=", bean.getKeyName());
				count++;
			}
			if(bean.getResourceId() != null) {
				dao.setConditionResourceId("=", bean.getResourceId());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnResourceKeyword bean, CnResourceKeyword dao){
		int count = 0;
		if(bean.getResourceKeywordId() != null) {
			dao.setConditionResourceKeywordId("=", bean.getResourceKeywordId());
			count++;
		}
		if(bean.getKeyName() != null) {
			if(bean.getKeyName().indexOf("%") >= 0)
				dao.setConditionKeyName("like", bean.getKeyName());
			else
				dao.setConditionKeyName("=", bean.getKeyName());
			count++;
		}
		if(bean.getResourceId() != null) {
			dao.setConditionResourceId("=", bean.getResourceId());
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
		BaseCnResourceKeyword bean = new BaseCnResourceKeyword();
		bean.setDataFromJSON(json);
		CnResourceKeyword dao = new CnResourceKeyword();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnResourceKeyword> rlist = new BaseCollection<>();
		BaseCnResourceKeyword bean = new BaseCnResourceKeyword();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnResourceKeyword dao = new CnResourceKeyword();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnResourceKeyword> result = dao.conditionalLoad(addtion);
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
		BaseCnResourceKeyword bean = new BaseCnResourceKeyword();
		bean.setDataFromJSON(json);
		CnResourceKeyword dao = new CnResourceKeyword();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnResourceKeyword bean = new BaseCnResourceKeyword();
		bean.setDataFromJSON(json);
		CnResourceKeyword dao = new CnResourceKeyword();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnResourceKeyword bean = new BaseCnResourceKeyword();
		bean.setDataFromJSON(json);
		CnResourceKeyword dao = new CnResourceKeyword();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnResourceKeyword bean = new BaseCnResourceKeyword();
		bean.setDataFromJSON(json);
		CnResourceKeyword dao = new CnResourceKeyword();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


