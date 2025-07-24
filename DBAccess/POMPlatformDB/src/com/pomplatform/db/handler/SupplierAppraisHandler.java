package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierApprais;
import com.pomplatform.db.dao.SupplierApprais;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierAppraisHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierAppraisHandler.class);

	public static BaseSupplierApprais getSupplierAppraisById( 
		java.lang.Integer supplier_appraise_id
	) throws Exception
	{
		SupplierApprais dao = new SupplierApprais();
		dao.setSupplierAppraiseId(supplier_appraise_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierAppraisExists( com.pomplatform.db.bean.BaseSupplierApprais bean, String additional ) throws Exception {

		SupplierApprais dao = new SupplierApprais();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierApprais( com.pomplatform.db.bean.BaseSupplierApprais bean, String additional ) throws Exception {

		SupplierApprais dao = new SupplierApprais();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierApprais> querySupplierApprais( com.pomplatform.db.bean.BaseSupplierApprais bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierApprais dao = new SupplierApprais();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierApprais> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierApprais> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierApprais addToSupplierApprais ( BaseSupplierApprais supplierapprais )  throws Exception {
		return addToSupplierApprais ( supplierapprais , false);
	}

	public static BaseSupplierApprais addToSupplierApprais ( BaseSupplierApprais supplierapprais, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierApprais dao = new SupplierApprais();
		dao.setDataFromBase(supplierapprais);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierApprais addUpdateSupplierApprais ( BaseSupplierApprais supplierapprais ) throws Exception {
		return addUpdateSupplierApprais ( supplierapprais , false);
	}

	public static BaseSupplierApprais addUpdateSupplierApprais ( BaseSupplierApprais supplierapprais, boolean singleTransaction  ) throws Exception {
		if(supplierapprais.getSupplierAppraiseId() == null) return addToSupplierApprais(supplierapprais);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierApprais dao = new SupplierApprais();
		dao.setDataFromBase(supplierapprais);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(supplierapprais); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierApprais ( BaseSupplierApprais bean ) throws Exception {
		SupplierApprais dao = new SupplierApprais();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierApprais updateSupplierApprais ( BaseSupplierApprais supplierapprais ) throws Exception {
		SupplierApprais dao = new SupplierApprais();
		dao.setSupplierAppraiseId( supplierapprais.getSupplierAppraiseId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(supplierapprais);
			result = dao.update();
		}
		return result == 1 ? supplierapprais : null ;
	}

	public static BaseSupplierApprais updateSupplierAppraisDirect( BaseSupplierApprais supplierapprais ) throws Exception {
		SupplierApprais dao = new SupplierApprais();
		int result = 0;
		dao.setDataFromBase(supplierapprais);
		result = dao.update();
		return result == 1 ? supplierapprais : null ;
	}

	public static int setDeleteConditions(BaseSupplierApprais bean, SupplierApprais dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierAppraiseId() != null) {
			dao.setConditionSupplierAppraiseId("=", bean.getSupplierAppraiseId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getProvideProduct() != null) {
				dao.setConditionProvideProduct("=", bean.getProvideProduct());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getAppraiseStatus() != null) {
				dao.setConditionAppraiseStatus("=", bean.getAppraiseStatus());
				count++;
			}
			if(bean.getAdvice() != null) {
				dao.setConditionAdvice("=", bean.getAdvice());
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

	public static int setConditions(BaseSupplierApprais bean, SupplierApprais dao){
		int count = 0;
		if(bean.getSupplierAppraiseId() != null) {
			dao.setConditionSupplierAppraiseId("=", bean.getSupplierAppraiseId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getProvideProduct() != null) {
			if(bean.getProvideProduct().indexOf("%") >= 0)
				dao.setConditionProvideProduct("like", bean.getProvideProduct());
			else
				dao.setConditionProvideProduct("=", bean.getProvideProduct());
			count++;
		}
		if(bean.getScore() != null) {
			dao.setConditionScore("=", bean.getScore());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getAppraiseStatus() != null) {
			dao.setConditionAppraiseStatus("=", bean.getAppraiseStatus());
			count++;
		}
		if(bean.getAdvice() != null) {
			if(bean.getAdvice().indexOf("%") >= 0)
				dao.setConditionAdvice("like", bean.getAdvice());
			else
				dao.setConditionAdvice("=", bean.getAdvice());
			count++;
		}
		if(bean.getFinishTime() != null) {
			dao.setConditionFinishTime(">=", bean.getFinishTime());
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
		BaseSupplierApprais bean = new BaseSupplierApprais();
		bean.setDataFromJSON(json);
		SupplierApprais dao = new SupplierApprais();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierApprais> rlist = new BaseCollection<>();
		BaseSupplierApprais bean = new BaseSupplierApprais();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierApprais dao = new SupplierApprais();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierApprais> result = dao.conditionalLoad(addtion);
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
		BaseSupplierApprais bean = new BaseSupplierApprais();
		bean.setDataFromJSON(json);
		SupplierApprais dao = new SupplierApprais();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierApprais bean = new BaseSupplierApprais();
		bean.setDataFromJSON(json);
		SupplierApprais dao = new SupplierApprais();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierApprais bean = new BaseSupplierApprais();
		bean.setDataFromJSON(json);
		SupplierApprais dao = new SupplierApprais();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierApprais bean = new BaseSupplierApprais();
		bean.setDataFromJSON(json);
		SupplierApprais dao = new SupplierApprais();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


