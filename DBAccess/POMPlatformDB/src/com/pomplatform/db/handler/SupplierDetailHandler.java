package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierDetail;
import com.pomplatform.db.dao.SupplierDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierDetailHandler.class);

	public static BaseSupplierDetail getSupplierDetailById( 
		java.lang.Integer supplier_detail_id
	) throws Exception
	{
		SupplierDetail dao = new SupplierDetail();
		dao.setSupplierDetailId(supplier_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierDetailExists( com.pomplatform.db.bean.BaseSupplierDetail bean, String additional ) throws Exception {

		SupplierDetail dao = new SupplierDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierDetail( com.pomplatform.db.bean.BaseSupplierDetail bean, String additional ) throws Exception {

		SupplierDetail dao = new SupplierDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierDetail> querySupplierDetail( com.pomplatform.db.bean.BaseSupplierDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierDetail dao = new SupplierDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierDetail addToSupplierDetail ( BaseSupplierDetail supplierdetail )  throws Exception {
		return addToSupplierDetail ( supplierdetail , false);
	}

	public static BaseSupplierDetail addToSupplierDetail ( BaseSupplierDetail supplierdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierDetail dao = new SupplierDetail();
		dao.setDataFromBase(supplierdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierDetail addUpdateSupplierDetail ( BaseSupplierDetail supplierdetail ) throws Exception {
		return addUpdateSupplierDetail ( supplierdetail , false);
	}

	public static BaseSupplierDetail addUpdateSupplierDetail ( BaseSupplierDetail supplierdetail, boolean singleTransaction  ) throws Exception {
		if(supplierdetail.getSupplierDetailId() == null) return addToSupplierDetail(supplierdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierDetail dao = new SupplierDetail();
		dao.setDataFromBase(supplierdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(supplierdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierDetail ( BaseSupplierDetail bean ) throws Exception {
		SupplierDetail dao = new SupplierDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierDetail updateSupplierDetail ( BaseSupplierDetail supplierdetail ) throws Exception {
		SupplierDetail dao = new SupplierDetail();
		dao.setSupplierDetailId( supplierdetail.getSupplierDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(supplierdetail);
			result = dao.update();
		}
		return result == 1 ? supplierdetail : null ;
	}

	public static BaseSupplierDetail updateSupplierDetailDirect( BaseSupplierDetail supplierdetail ) throws Exception {
		SupplierDetail dao = new SupplierDetail();
		int result = 0;
		dao.setDataFromBase(supplierdetail);
		result = dao.update();
		return result == 1 ? supplierdetail : null ;
	}

	public static int setDeleteConditions(BaseSupplierDetail bean, SupplierDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierDetailId() != null) {
			dao.setConditionSupplierDetailId("=", bean.getSupplierDetailId());
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
			if(bean.getProjectAddress() != null) {
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
				count++;
			}
			if(bean.getSupplierDuty() != null) {
				dao.setConditionSupplierDuty("=", bean.getSupplierDuty());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplierDetail bean, SupplierDetail dao){
		int count = 0;
		if(bean.getSupplierDetailId() != null) {
			dao.setConditionSupplierDetailId("=", bean.getSupplierDetailId());
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
		if(bean.getProjectAddress() != null) {
			if(bean.getProjectAddress().indexOf("%") >= 0)
				dao.setConditionProjectAddress("like", bean.getProjectAddress());
			else
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
			count++;
		}
		if(bean.getSupplierDuty() != null) {
			if(bean.getSupplierDuty().indexOf("%") >= 0)
				dao.setConditionSupplierDuty("like", bean.getSupplierDuty());
			else
				dao.setConditionSupplierDuty("=", bean.getSupplierDuty());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSupplierDetail bean = new BaseSupplierDetail();
		bean.setDataFromJSON(json);
		SupplierDetail dao = new SupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierDetail> rlist = new BaseCollection<>();
		BaseSupplierDetail bean = new BaseSupplierDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierDetail dao = new SupplierDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierDetail> result = dao.conditionalLoad(addtion);
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
		BaseSupplierDetail bean = new BaseSupplierDetail();
		bean.setDataFromJSON(json);
		SupplierDetail dao = new SupplierDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierDetail bean = new BaseSupplierDetail();
		bean.setDataFromJSON(json);
		SupplierDetail dao = new SupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierDetail bean = new BaseSupplierDetail();
		bean.setDataFromJSON(json);
		SupplierDetail dao = new SupplierDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierDetail bean = new BaseSupplierDetail();
		bean.setDataFromJSON(json);
		SupplierDetail dao = new SupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


