package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.dao.SubjectType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SubjectTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SubjectTypeHandler.class);

	public static BaseSubjectType getSubjectTypeById( 
		java.lang.Integer subject_type_id
	) throws Exception
	{
		SubjectType dao = new SubjectType();
		dao.setSubjectTypeId(subject_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSubjectTypeExists( com.pomplatform.db.bean.BaseSubjectType bean, String additional ) throws Exception {

		SubjectType dao = new SubjectType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSubjectType( com.pomplatform.db.bean.BaseSubjectType bean, String additional ) throws Exception {

		SubjectType dao = new SubjectType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSubjectType> querySubjectType( com.pomplatform.db.bean.BaseSubjectType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SubjectType dao = new SubjectType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSubjectType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSubjectType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSubjectType addToSubjectType ( BaseSubjectType subjecttype )  throws Exception {
		return addToSubjectType ( subjecttype , false);
	}

	public static BaseSubjectType addToSubjectType ( BaseSubjectType subjecttype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SubjectType dao = new SubjectType();
		dao.setDataFromBase(subjecttype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSubjectType addUpdateSubjectType ( BaseSubjectType subjecttype ) throws Exception {
		return addUpdateSubjectType ( subjecttype , false);
	}

	public static BaseSubjectType addUpdateSubjectType ( BaseSubjectType subjecttype, boolean singleTransaction  ) throws Exception {
		if(subjecttype.getSubjectTypeId() == null) return addToSubjectType(subjecttype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SubjectType dao = new SubjectType();
		dao.setDataFromBase(subjecttype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(subjecttype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSubjectType ( BaseSubjectType bean ) throws Exception {
		SubjectType dao = new SubjectType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSubjectType updateSubjectType ( BaseSubjectType subjecttype ) throws Exception {
		SubjectType dao = new SubjectType();
		dao.setSubjectTypeId( subjecttype.getSubjectTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(subjecttype);
			result = dao.update();
		}
		return result == 1 ? subjecttype : null ;
	}

	public static BaseSubjectType updateSubjectTypeDirect( BaseSubjectType subjecttype ) throws Exception {
		SubjectType dao = new SubjectType();
		int result = 0;
		dao.setDataFromBase(subjecttype);
		result = dao.update();
		return result == 1 ? subjecttype : null ;
	}

	public static int setDeleteConditions(BaseSubjectType bean, SubjectType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubjectTypeId() != null) {
			dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getSubjectName() != null) {
				dao.setConditionSubjectName("=", bean.getSubjectName());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSubjectType bean, SubjectType dao){
		int count = 0;
		if(bean.getSubjectTypeId() != null) {
			dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getSubjectName() != null) {
			if(bean.getSubjectName().indexOf("%") >= 0)
				dao.setConditionSubjectName("like", bean.getSubjectName());
			else
				dao.setConditionSubjectName("=", bean.getSubjectName());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubjectType bean = new BaseSubjectType();
		bean.setDataFromJSON(json);
		SubjectType dao = new SubjectType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubjectType> rlist = new BaseCollection<>();
		BaseSubjectType bean = new BaseSubjectType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubjectType dao = new SubjectType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubjectType> result = dao.conditionalLoad(addtion);
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
		BaseSubjectType bean = new BaseSubjectType();
		bean.setDataFromJSON(json);
		SubjectType dao = new SubjectType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubjectType bean = new BaseSubjectType();
		bean.setDataFromJSON(json);
		SubjectType dao = new SubjectType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubjectType bean = new BaseSubjectType();
		bean.setDataFromJSON(json);
		SubjectType dao = new SubjectType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubjectType bean = new BaseSubjectType();
		bean.setDataFromJSON(json);
		SubjectType dao = new SubjectType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


