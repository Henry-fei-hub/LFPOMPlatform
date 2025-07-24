package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSubjectProcessType;
import com.pomplatform.db.dao.SubjectProcessType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SubjectProcessTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SubjectProcessTypeHandler.class);

	public static BaseSubjectProcessType getSubjectProcessTypeById( 
		java.lang.Integer subject_process_type_id
	) throws Exception
	{
		SubjectProcessType dao = new SubjectProcessType();
		dao.setSubjectProcessTypeId(subject_process_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSubjectProcessTypeExists( com.pomplatform.db.bean.BaseSubjectProcessType bean, String additional ) throws Exception {

		SubjectProcessType dao = new SubjectProcessType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSubjectProcessType( com.pomplatform.db.bean.BaseSubjectProcessType bean, String additional ) throws Exception {

		SubjectProcessType dao = new SubjectProcessType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSubjectProcessType> querySubjectProcessType( com.pomplatform.db.bean.BaseSubjectProcessType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SubjectProcessType dao = new SubjectProcessType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSubjectProcessType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSubjectProcessType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSubjectProcessType addToSubjectProcessType ( BaseSubjectProcessType subjectprocesstype )  throws Exception {
		return addToSubjectProcessType ( subjectprocesstype , false);
	}

	public static BaseSubjectProcessType addToSubjectProcessType ( BaseSubjectProcessType subjectprocesstype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SubjectProcessType dao = new SubjectProcessType();
		dao.setDataFromBase(subjectprocesstype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSubjectProcessType addUpdateSubjectProcessType ( BaseSubjectProcessType subjectprocesstype ) throws Exception {
		return addUpdateSubjectProcessType ( subjectprocesstype , false);
	}

	public static BaseSubjectProcessType addUpdateSubjectProcessType ( BaseSubjectProcessType subjectprocesstype, boolean singleTransaction  ) throws Exception {
		if(subjectprocesstype.getSubjectProcessTypeId() == null) return addToSubjectProcessType(subjectprocesstype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SubjectProcessType dao = new SubjectProcessType();
		dao.setDataFromBase(subjectprocesstype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(subjectprocesstype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSubjectProcessType ( BaseSubjectProcessType bean ) throws Exception {
		SubjectProcessType dao = new SubjectProcessType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSubjectProcessType updateSubjectProcessType ( BaseSubjectProcessType subjectprocesstype ) throws Exception {
		SubjectProcessType dao = new SubjectProcessType();
		dao.setSubjectProcessTypeId( subjectprocesstype.getSubjectProcessTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(subjectprocesstype);
			result = dao.update();
		}
		return result == 1 ? subjectprocesstype : null ;
	}

	public static BaseSubjectProcessType updateSubjectProcessTypeDirect( BaseSubjectProcessType subjectprocesstype ) throws Exception {
		SubjectProcessType dao = new SubjectProcessType();
		int result = 0;
		dao.setDataFromBase(subjectprocesstype);
		result = dao.update();
		return result == 1 ? subjectprocesstype : null ;
	}

	public static int setDeleteConditions(BaseSubjectProcessType bean, SubjectProcessType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubjectProcessTypeId() != null) {
			dao.setConditionSubjectProcessTypeId("=", bean.getSubjectProcessTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSubjectTypeId() != null) {
				dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
				count++;
			}
			if(bean.getProcessTypeId() != null) {
				dao.setConditionProcessTypeId("=", bean.getProcessTypeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSubjectProcessType bean, SubjectProcessType dao){
		int count = 0;
		if(bean.getSubjectProcessTypeId() != null) {
			dao.setConditionSubjectProcessTypeId("=", bean.getSubjectProcessTypeId());
			count++;
		}
		if(bean.getSubjectTypeId() != null) {
			dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
			count++;
		}
		if(bean.getProcessTypeId() != null) {
			dao.setConditionProcessTypeId("=", bean.getProcessTypeId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubjectProcessType bean = new BaseSubjectProcessType();
		bean.setDataFromJSON(json);
		SubjectProcessType dao = new SubjectProcessType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubjectProcessType> rlist = new BaseCollection<>();
		BaseSubjectProcessType bean = new BaseSubjectProcessType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubjectProcessType dao = new SubjectProcessType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubjectProcessType> result = dao.conditionalLoad(addtion);
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
		BaseSubjectProcessType bean = new BaseSubjectProcessType();
		bean.setDataFromJSON(json);
		SubjectProcessType dao = new SubjectProcessType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubjectProcessType bean = new BaseSubjectProcessType();
		bean.setDataFromJSON(json);
		SubjectProcessType dao = new SubjectProcessType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubjectProcessType bean = new BaseSubjectProcessType();
		bean.setDataFromJSON(json);
		SubjectProcessType dao = new SubjectProcessType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubjectProcessType bean = new BaseSubjectProcessType();
		bean.setDataFromJSON(json);
		SubjectProcessType dao = new SubjectProcessType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


