package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseConfree;
import java.util.List;
import com.pomplatform.db.dao.Confree;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ConfreeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ConfreeHandler.class);

	public static BaseConfree getConfreeById( 
		java.lang.Integer conferee_id
	) throws Exception
	{
		Confree dao = new Confree();
		dao.setConfereeId(conferee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isConfreeExists( com.pomplatform.db.bean.BaseConfree bean, String additional ) throws Exception {

		Confree dao = new Confree();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countConfree( com.pomplatform.db.bean.BaseConfree bean, String additional ) throws Exception {

		Confree dao = new Confree();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseConfree> queryConfree( com.pomplatform.db.bean.BaseConfree bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Confree dao = new Confree();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseConfree> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseConfree> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseConfree addToConfree ( BaseConfree confree )  throws Exception {
		return addToConfree ( confree , false);
	}

	public static BaseConfree addToConfree ( BaseConfree confree, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Confree dao = new Confree();
		dao.setDataFromBase(confree);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseConfree addUpdateConfree ( BaseConfree confree ) throws Exception {
		return addUpdateConfree ( confree , false);
	}

	public static BaseConfree addUpdateConfree ( BaseConfree confree, boolean singleTransaction  ) throws Exception {
		if(confree.getConfereeId() == null) return addToConfree(confree);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Confree dao = new Confree();
		dao.setDataFromBase(confree);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(confree); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteConfree ( BaseConfree bean ) throws Exception {
		Confree dao = new Confree();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseConfree updateConfree ( BaseConfree confree ) throws Exception {
		Confree dao = new Confree();
		dao.setConfereeId( confree.getConfereeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(confree);
			result = dao.update();
		}
		return result == 1 ? confree : null ;
	}

	public static BaseConfree updateConfreeDirect( BaseConfree confree ) throws Exception {
		Confree dao = new Confree();
		int result = 0;
		dao.setDataFromBase(confree);
		result = dao.update();
		return result == 1 ? confree : null ;
	}

	public static int setDeleteConditions(BaseConfree bean, Confree dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getConfereeId() != null) {
			dao.setConditionConfereeId("=", bean.getConfereeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMeetingRelevanceId() != null) {
				dao.setConditionMeetingRelevanceId("=", bean.getMeetingRelevanceId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseConfree bean, Confree dao){
		int count = 0;
		if(bean.getConfereeId() != null) {
			dao.setConditionConfereeId("=", bean.getConfereeId());
			count++;
		}
		if(bean.getMeetingRelevanceId() != null) {
			dao.setConditionMeetingRelevanceId("=", bean.getMeetingRelevanceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseConfree bean = new BaseConfree();
		bean.setDataFromJSON(json);
		Confree dao = new Confree();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseConfree> rlist = new BaseCollection<>();
		BaseConfree bean = new BaseConfree();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Confree dao = new Confree();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseConfree> result = dao.conditionalLoad(addtion);
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
		BaseConfree bean = new BaseConfree();
		bean.setDataFromJSON(json);
		Confree dao = new Confree();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseConfree bean = new BaseConfree();
		bean.setDataFromJSON(json);
		Confree dao = new Confree();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseConfree bean = new BaseConfree();
		bean.setDataFromJSON(json);
		Confree dao = new Confree();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseConfree bean = new BaseConfree();
		bean.setDataFromJSON(json);
		Confree dao = new Confree();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


