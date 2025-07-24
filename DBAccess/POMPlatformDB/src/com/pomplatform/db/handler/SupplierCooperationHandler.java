package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierCooperation;
import com.pomplatform.db.dao.SupplierCooperation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierCooperationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierCooperationHandler.class);

	public static BaseSupplierCooperation getSupplierCooperationById( 
		java.lang.Integer supplier_cooperation_id
	) throws Exception
	{
		SupplierCooperation dao = new SupplierCooperation();
		dao.setSupplierCooperationId(supplier_cooperation_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierCooperationExists( com.pomplatform.db.bean.BaseSupplierCooperation bean, String additional ) throws Exception {

		SupplierCooperation dao = new SupplierCooperation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierCooperation( com.pomplatform.db.bean.BaseSupplierCooperation bean, String additional ) throws Exception {

		SupplierCooperation dao = new SupplierCooperation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierCooperation> querySupplierCooperation( com.pomplatform.db.bean.BaseSupplierCooperation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierCooperation dao = new SupplierCooperation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierCooperation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierCooperation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierCooperation addToSupplierCooperation ( BaseSupplierCooperation suppliercooperation )  throws Exception {
		return addToSupplierCooperation ( suppliercooperation , false);
	}

	public static BaseSupplierCooperation addToSupplierCooperation ( BaseSupplierCooperation suppliercooperation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierCooperation dao = new SupplierCooperation();
		dao.setDataFromBase(suppliercooperation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierCooperation addUpdateSupplierCooperation ( BaseSupplierCooperation suppliercooperation ) throws Exception {
		return addUpdateSupplierCooperation ( suppliercooperation , false);
	}

	public static BaseSupplierCooperation addUpdateSupplierCooperation ( BaseSupplierCooperation suppliercooperation, boolean singleTransaction  ) throws Exception {
		if(suppliercooperation.getSupplierCooperationId() == null) return addToSupplierCooperation(suppliercooperation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierCooperation dao = new SupplierCooperation();
		dao.setDataFromBase(suppliercooperation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(suppliercooperation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierCooperation ( BaseSupplierCooperation bean ) throws Exception {
		SupplierCooperation dao = new SupplierCooperation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierCooperation updateSupplierCooperation ( BaseSupplierCooperation suppliercooperation ) throws Exception {
		SupplierCooperation dao = new SupplierCooperation();
		dao.setSupplierCooperationId( suppliercooperation.getSupplierCooperationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(suppliercooperation);
			result = dao.update();
		}
		return result == 1 ? suppliercooperation : null ;
	}

	public static BaseSupplierCooperation updateSupplierCooperationDirect( BaseSupplierCooperation suppliercooperation ) throws Exception {
		SupplierCooperation dao = new SupplierCooperation();
		int result = 0;
		dao.setDataFromBase(suppliercooperation);
		result = dao.update();
		return result == 1 ? suppliercooperation : null ;
	}

	public static int setDeleteConditions(BaseSupplierCooperation bean, SupplierCooperation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierCooperationId() != null) {
			dao.setConditionSupplierCooperationId("=", bean.getSupplierCooperationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectLeader() != null) {
				dao.setConditionProjectLeader("=", bean.getProjectLeader());
				count++;
			}
			if(bean.getSupplierEvaluate() != null) {
				dao.setConditionSupplierEvaluate("=", bean.getSupplierEvaluate());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplierCooperation bean, SupplierCooperation dao){
		int count = 0;
		if(bean.getSupplierCooperationId() != null) {
			dao.setConditionSupplierCooperationId("=", bean.getSupplierCooperationId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectLeader() != null) {
			if(bean.getProjectLeader().indexOf("%") >= 0)
				dao.setConditionProjectLeader("like", bean.getProjectLeader());
			else
				dao.setConditionProjectLeader("=", bean.getProjectLeader());
			count++;
		}
		if(bean.getSupplierEvaluate() != null) {
			if(bean.getSupplierEvaluate().indexOf("%") >= 0)
				dao.setConditionSupplierEvaluate("like", bean.getSupplierEvaluate());
			else
				dao.setConditionSupplierEvaluate("=", bean.getSupplierEvaluate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSupplierCooperation bean = new BaseSupplierCooperation();
		bean.setDataFromJSON(json);
		SupplierCooperation dao = new SupplierCooperation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierCooperation> rlist = new BaseCollection<>();
		BaseSupplierCooperation bean = new BaseSupplierCooperation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierCooperation dao = new SupplierCooperation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierCooperation> result = dao.conditionalLoad(addtion);
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
		BaseSupplierCooperation bean = new BaseSupplierCooperation();
		bean.setDataFromJSON(json);
		SupplierCooperation dao = new SupplierCooperation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierCooperation bean = new BaseSupplierCooperation();
		bean.setDataFromJSON(json);
		SupplierCooperation dao = new SupplierCooperation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierCooperation bean = new BaseSupplierCooperation();
		bean.setDataFromJSON(json);
		SupplierCooperation dao = new SupplierCooperation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierCooperation bean = new BaseSupplierCooperation();
		bean.setDataFromJSON(json);
		SupplierCooperation dao = new SupplierCooperation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


