package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSubContractRemark;
import com.pomplatform.db.dao.SubContractRemark;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SubContractRemarkHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SubContractRemarkHandler.class);

	public static BaseSubContractRemark getSubContractRemarkById( 
		java.lang.Integer sub_contract_remark_id
	) throws Exception
	{
		SubContractRemark dao = new SubContractRemark();
		dao.setSubContractRemarkId(sub_contract_remark_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSubContractRemarkExists( com.pomplatform.db.bean.BaseSubContractRemark bean, String additional ) throws Exception {

		SubContractRemark dao = new SubContractRemark();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSubContractRemark( com.pomplatform.db.bean.BaseSubContractRemark bean, String additional ) throws Exception {

		SubContractRemark dao = new SubContractRemark();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSubContractRemark> querySubContractRemark( com.pomplatform.db.bean.BaseSubContractRemark bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SubContractRemark dao = new SubContractRemark();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSubContractRemark> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSubContractRemark> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSubContractRemark addToSubContractRemark ( BaseSubContractRemark subcontractremark )  throws Exception {
		return addToSubContractRemark ( subcontractremark , false);
	}

	public static BaseSubContractRemark addToSubContractRemark ( BaseSubContractRemark subcontractremark, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SubContractRemark dao = new SubContractRemark();
		dao.setDataFromBase(subcontractremark);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSubContractRemark addUpdateSubContractRemark ( BaseSubContractRemark subcontractremark ) throws Exception {
		return addUpdateSubContractRemark ( subcontractremark , false);
	}

	public static BaseSubContractRemark addUpdateSubContractRemark ( BaseSubContractRemark subcontractremark, boolean singleTransaction  ) throws Exception {
		if(subcontractremark.getSubContractRemarkId() == null) return addToSubContractRemark(subcontractremark);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SubContractRemark dao = new SubContractRemark();
		dao.setDataFromBase(subcontractremark);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(subcontractremark); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSubContractRemark ( BaseSubContractRemark bean ) throws Exception {
		SubContractRemark dao = new SubContractRemark();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSubContractRemark updateSubContractRemark ( BaseSubContractRemark subcontractremark ) throws Exception {
		SubContractRemark dao = new SubContractRemark();
		dao.setSubContractRemarkId( subcontractremark.getSubContractRemarkId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(subcontractremark);
			result = dao.update();
		}
		return result == 1 ? subcontractremark : null ;
	}

	public static BaseSubContractRemark updateSubContractRemarkDirect( BaseSubContractRemark subcontractremark ) throws Exception {
		SubContractRemark dao = new SubContractRemark();
		int result = 0;
		dao.setDataFromBase(subcontractremark);
		result = dao.update();
		return result == 1 ? subcontractremark : null ;
	}

	public static int setDeleteConditions(BaseSubContractRemark bean, SubContractRemark dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubContractRemarkId() != null) {
			dao.setConditionSubContractRemarkId("=", bean.getSubContractRemarkId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getContentInfo() != null) {
				dao.setConditionContentInfo("=", bean.getContentInfo());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSubContractRemark bean, SubContractRemark dao){
		int count = 0;
		if(bean.getSubContractRemarkId() != null) {
			dao.setConditionSubContractRemarkId("=", bean.getSubContractRemarkId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getContentInfo() != null) {
			if(bean.getContentInfo().indexOf("%") >= 0)
				dao.setConditionContentInfo("like", bean.getContentInfo());
			else
				dao.setConditionContentInfo("=", bean.getContentInfo());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubContractRemark bean = new BaseSubContractRemark();
		bean.setDataFromJSON(json);
		SubContractRemark dao = new SubContractRemark();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubContractRemark> rlist = new BaseCollection<>();
		BaseSubContractRemark bean = new BaseSubContractRemark();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubContractRemark dao = new SubContractRemark();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubContractRemark> result = dao.conditionalLoad(addtion);
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
		BaseSubContractRemark bean = new BaseSubContractRemark();
		bean.setDataFromJSON(json);
		SubContractRemark dao = new SubContractRemark();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubContractRemark bean = new BaseSubContractRemark();
		bean.setDataFromJSON(json);
		SubContractRemark dao = new SubContractRemark();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubContractRemark bean = new BaseSubContractRemark();
		bean.setDataFromJSON(json);
		SubContractRemark dao = new SubContractRemark();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubContractRemark bean = new BaseSubContractRemark();
		bean.setDataFromJSON(json);
		SubContractRemark dao = new SubContractRemark();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


