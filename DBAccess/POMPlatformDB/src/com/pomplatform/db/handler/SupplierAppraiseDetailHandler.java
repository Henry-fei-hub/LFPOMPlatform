package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierAppraiseDetail;
import com.pomplatform.db.dao.SupplierAppraiseDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierAppraiseDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierAppraiseDetailHandler.class);

	public static BaseSupplierAppraiseDetail getSupplierAppraiseDetailById( 
		java.lang.Integer supplier_appraise_detail_id
	) throws Exception
	{
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setSupplierAppraiseDetailId(supplier_appraise_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierAppraiseDetailExists( com.pomplatform.db.bean.BaseSupplierAppraiseDetail bean, String additional ) throws Exception {

		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierAppraiseDetail( com.pomplatform.db.bean.BaseSupplierAppraiseDetail bean, String additional ) throws Exception {

		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierAppraiseDetail> querySupplierAppraiseDetail( com.pomplatform.db.bean.BaseSupplierAppraiseDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierAppraiseDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierAppraiseDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierAppraiseDetail addToSupplierAppraiseDetail ( BaseSupplierAppraiseDetail supplierappraisedetail )  throws Exception {
		return addToSupplierAppraiseDetail ( supplierappraisedetail , false);
	}

	public static BaseSupplierAppraiseDetail addToSupplierAppraiseDetail ( BaseSupplierAppraiseDetail supplierappraisedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setDataFromBase(supplierappraisedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierAppraiseDetail addUpdateSupplierAppraiseDetail ( BaseSupplierAppraiseDetail supplierappraisedetail ) throws Exception {
		return addUpdateSupplierAppraiseDetail ( supplierappraisedetail , false);
	}

	public static BaseSupplierAppraiseDetail addUpdateSupplierAppraiseDetail ( BaseSupplierAppraiseDetail supplierappraisedetail, boolean singleTransaction  ) throws Exception {
		if(supplierappraisedetail.getSupplierAppraiseDetailId() == null) return addToSupplierAppraiseDetail(supplierappraisedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setDataFromBase(supplierappraisedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(supplierappraisedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierAppraiseDetail ( BaseSupplierAppraiseDetail bean ) throws Exception {
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierAppraiseDetail updateSupplierAppraiseDetail ( BaseSupplierAppraiseDetail supplierappraisedetail ) throws Exception {
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setSupplierAppraiseDetailId( supplierappraisedetail.getSupplierAppraiseDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(supplierappraisedetail);
			result = dao.update();
		}
		return result == 1 ? supplierappraisedetail : null ;
	}

	public static BaseSupplierAppraiseDetail updateSupplierAppraiseDetailDirect( BaseSupplierAppraiseDetail supplierappraisedetail ) throws Exception {
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		int result = 0;
		dao.setDataFromBase(supplierappraisedetail);
		result = dao.update();
		return result == 1 ? supplierappraisedetail : null ;
	}

	public static int setDeleteConditions(BaseSupplierAppraiseDetail bean, SupplierAppraiseDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierAppraiseDetailId() != null) {
			dao.setConditionSupplierAppraiseDetailId("=", bean.getSupplierAppraiseDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getSupplierAppraiseId() != null) {
				dao.setConditionSupplierAppraiseId("=", bean.getSupplierAppraiseId());
				count++;
			}
			if(bean.getAppraiseType() != null) {
				dao.setConditionAppraiseType("=", bean.getAppraiseType());
				count++;
			}
			if(bean.getScoreType() != null) {
				dao.setConditionScoreType("=", bean.getScoreType());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplierAppraiseDetail bean, SupplierAppraiseDetail dao){
		int count = 0;
		if(bean.getSupplierAppraiseDetailId() != null) {
			dao.setConditionSupplierAppraiseDetailId("=", bean.getSupplierAppraiseDetailId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getSupplierAppraiseId() != null) {
			dao.setConditionSupplierAppraiseId("=", bean.getSupplierAppraiseId());
			count++;
		}
		if(bean.getAppraiseType() != null) {
			dao.setConditionAppraiseType("=", bean.getAppraiseType());
			count++;
		}
		if(bean.getScoreType() != null) {
			dao.setConditionScoreType("=", bean.getScoreType());
			count++;
		}
		if(bean.getScore() != null) {
			dao.setConditionScore("=", bean.getScore());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSupplierAppraiseDetail bean = new BaseSupplierAppraiseDetail();
		bean.setDataFromJSON(json);
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierAppraiseDetail> rlist = new BaseCollection<>();
		BaseSupplierAppraiseDetail bean = new BaseSupplierAppraiseDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierAppraiseDetail> result = dao.conditionalLoad(addtion);
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
		BaseSupplierAppraiseDetail bean = new BaseSupplierAppraiseDetail();
		bean.setDataFromJSON(json);
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierAppraiseDetail bean = new BaseSupplierAppraiseDetail();
		bean.setDataFromJSON(json);
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierAppraiseDetail bean = new BaseSupplierAppraiseDetail();
		bean.setDataFromJSON(json);
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierAppraiseDetail bean = new BaseSupplierAppraiseDetail();
		bean.setDataFromJSON(json);
		SupplierAppraiseDetail dao = new SupplierAppraiseDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


