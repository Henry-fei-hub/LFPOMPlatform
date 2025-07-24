package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCwdProjectPermission;
import java.util.List;
import com.pomplatform.db.dao.CwdProjectPermission;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CwdProjectPermissionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdProjectPermissionHandler.class);

	public static BaseCwdProjectPermission getCwdProjectPermissionById( 
		java.lang.Integer cwd_project_permission_id
	) throws Exception
	{
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setCwdProjectPermissionId(cwd_project_permission_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdProjectPermissionExists( com.pomplatform.db.bean.BaseCwdProjectPermission bean, String additional ) throws Exception {

		CwdProjectPermission dao = new CwdProjectPermission();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdProjectPermission( com.pomplatform.db.bean.BaseCwdProjectPermission bean, String additional ) throws Exception {

		CwdProjectPermission dao = new CwdProjectPermission();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdProjectPermission> queryCwdProjectPermission( com.pomplatform.db.bean.BaseCwdProjectPermission bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdProjectPermission dao = new CwdProjectPermission();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdProjectPermission> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdProjectPermission> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdProjectPermission addToCwdProjectPermission ( BaseCwdProjectPermission cwdprojectpermission )  throws Exception {
		return addToCwdProjectPermission ( cwdprojectpermission , false);
	}

	public static BaseCwdProjectPermission addToCwdProjectPermission ( BaseCwdProjectPermission cwdprojectpermission, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setDataFromBase(cwdprojectpermission);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdProjectPermission addUpdateCwdProjectPermission ( BaseCwdProjectPermission cwdprojectpermission ) throws Exception {
		return addUpdateCwdProjectPermission ( cwdprojectpermission , false);
	}

	public static BaseCwdProjectPermission addUpdateCwdProjectPermission ( BaseCwdProjectPermission cwdprojectpermission, boolean singleTransaction  ) throws Exception {
		if(cwdprojectpermission.getCwdProjectPermissionId() == null) return addToCwdProjectPermission(cwdprojectpermission);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setDataFromBase(cwdprojectpermission);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdprojectpermission); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdProjectPermission ( BaseCwdProjectPermission bean ) throws Exception {
		CwdProjectPermission dao = new CwdProjectPermission();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdProjectPermission updateCwdProjectPermission ( BaseCwdProjectPermission cwdprojectpermission ) throws Exception {
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setCwdProjectPermissionId( cwdprojectpermission.getCwdProjectPermissionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdprojectpermission);
			result = dao.update();
		}
		return result == 1 ? cwdprojectpermission : null ;
	}

	public static BaseCwdProjectPermission updateCwdProjectPermissionDirect( BaseCwdProjectPermission cwdprojectpermission ) throws Exception {
		CwdProjectPermission dao = new CwdProjectPermission();
		int result = 0;
		dao.setDataFromBase(cwdprojectpermission);
		result = dao.update();
		return result == 1 ? cwdprojectpermission : null ;
	}

	public static int setDeleteConditions(BaseCwdProjectPermission bean, CwdProjectPermission dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdProjectPermissionId() != null) {
			dao.setConditionCwdProjectPermissionId("=", bean.getCwdProjectPermissionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getPermissionType() != null) {
				dao.setConditionPermissionType("=", bean.getPermissionType());
				count++;
			}
			if(bean.getOperatePerson() != null) {
				dao.setConditionOperatePerson("=", bean.getOperatePerson());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdProjectPermission bean, CwdProjectPermission dao){
		int count = 0;
		if(bean.getCwdProjectPermissionId() != null) {
			dao.setConditionCwdProjectPermissionId("=", bean.getCwdProjectPermissionId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getPermissionType() != null) {
			dao.setConditionPermissionType("=", bean.getPermissionType());
			count++;
		}
		if(bean.getOperatePerson() != null) {
			dao.setConditionOperatePerson("=", bean.getOperatePerson());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdProjectPermission bean = new BaseCwdProjectPermission();
		bean.setDataFromJSON(json);
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdProjectPermission> rlist = new BaseCollection<>();
		BaseCwdProjectPermission bean = new BaseCwdProjectPermission();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdProjectPermission dao = new CwdProjectPermission();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdProjectPermission> result = dao.conditionalLoad(addtion);
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
		BaseCwdProjectPermission bean = new BaseCwdProjectPermission();
		bean.setDataFromJSON(json);
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdProjectPermission bean = new BaseCwdProjectPermission();
		bean.setDataFromJSON(json);
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdProjectPermission bean = new BaseCwdProjectPermission();
		bean.setDataFromJSON(json);
		CwdProjectPermission dao = new CwdProjectPermission();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdProjectPermission bean = new BaseCwdProjectPermission();
		bean.setDataFromJSON(json);
		CwdProjectPermission dao = new CwdProjectPermission();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


