package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSubjectDepartment;
import com.pomplatform.db.dao.SubjectDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SubjectDepartmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SubjectDepartmentHandler.class);

	public static BaseSubjectDepartment getSubjectDepartmentById( 
		java.lang.Integer subject_department_id
	) throws Exception
	{
		SubjectDepartment dao = new SubjectDepartment();
		dao.setSubjectDepartmentId(subject_department_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSubjectDepartmentExists( com.pomplatform.db.bean.BaseSubjectDepartment bean, String additional ) throws Exception {

		SubjectDepartment dao = new SubjectDepartment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSubjectDepartment( com.pomplatform.db.bean.BaseSubjectDepartment bean, String additional ) throws Exception {

		SubjectDepartment dao = new SubjectDepartment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSubjectDepartment> querySubjectDepartment( com.pomplatform.db.bean.BaseSubjectDepartment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SubjectDepartment dao = new SubjectDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSubjectDepartment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSubjectDepartment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSubjectDepartment addToSubjectDepartment ( BaseSubjectDepartment subjectdepartment )  throws Exception {
		return addToSubjectDepartment ( subjectdepartment , false);
	}

	public static BaseSubjectDepartment addToSubjectDepartment ( BaseSubjectDepartment subjectdepartment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SubjectDepartment dao = new SubjectDepartment();
		dao.setDataFromBase(subjectdepartment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSubjectDepartment addUpdateSubjectDepartment ( BaseSubjectDepartment subjectdepartment ) throws Exception {
		return addUpdateSubjectDepartment ( subjectdepartment , false);
	}

	public static BaseSubjectDepartment addUpdateSubjectDepartment ( BaseSubjectDepartment subjectdepartment, boolean singleTransaction  ) throws Exception {
		if(subjectdepartment.getSubjectDepartmentId() == null) return addToSubjectDepartment(subjectdepartment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SubjectDepartment dao = new SubjectDepartment();
		dao.setDataFromBase(subjectdepartment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(subjectdepartment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSubjectDepartment ( BaseSubjectDepartment bean ) throws Exception {
		SubjectDepartment dao = new SubjectDepartment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSubjectDepartment updateSubjectDepartment ( BaseSubjectDepartment subjectdepartment ) throws Exception {
		SubjectDepartment dao = new SubjectDepartment();
		dao.setSubjectDepartmentId( subjectdepartment.getSubjectDepartmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(subjectdepartment);
			result = dao.update();
		}
		return result == 1 ? subjectdepartment : null ;
	}

	public static BaseSubjectDepartment updateSubjectDepartmentDirect( BaseSubjectDepartment subjectdepartment ) throws Exception {
		SubjectDepartment dao = new SubjectDepartment();
		int result = 0;
		dao.setDataFromBase(subjectdepartment);
		result = dao.update();
		return result == 1 ? subjectdepartment : null ;
	}

	public static int setDeleteConditions(BaseSubjectDepartment bean, SubjectDepartment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubjectDepartmentId() != null) {
			dao.setConditionSubjectDepartmentId("=", bean.getSubjectDepartmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSubjectTypeId() != null) {
				dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSubjectDepartment bean, SubjectDepartment dao){
		int count = 0;
		if(bean.getSubjectDepartmentId() != null) {
			dao.setConditionSubjectDepartmentId("=", bean.getSubjectDepartmentId());
			count++;
		}
		if(bean.getSubjectTypeId() != null) {
			dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubjectDepartment bean = new BaseSubjectDepartment();
		bean.setDataFromJSON(json);
		SubjectDepartment dao = new SubjectDepartment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubjectDepartment> rlist = new BaseCollection<>();
		BaseSubjectDepartment bean = new BaseSubjectDepartment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubjectDepartment dao = new SubjectDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubjectDepartment> result = dao.conditionalLoad(addtion);
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
		BaseSubjectDepartment bean = new BaseSubjectDepartment();
		bean.setDataFromJSON(json);
		SubjectDepartment dao = new SubjectDepartment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubjectDepartment bean = new BaseSubjectDepartment();
		bean.setDataFromJSON(json);
		SubjectDepartment dao = new SubjectDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubjectDepartment bean = new BaseSubjectDepartment();
		bean.setDataFromJSON(json);
		SubjectDepartment dao = new SubjectDepartment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubjectDepartment bean = new BaseSubjectDepartment();
		bean.setDataFromJSON(json);
		SubjectDepartment dao = new SubjectDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


