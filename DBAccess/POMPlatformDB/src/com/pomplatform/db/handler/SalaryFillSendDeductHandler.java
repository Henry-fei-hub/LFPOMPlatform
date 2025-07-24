package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryFillSendDeduct;
import com.pomplatform.db.dao.SalaryFillSendDeduct;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryFillSendDeductHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryFillSendDeductHandler.class);

	public static BaseSalaryFillSendDeduct getSalaryFillSendDeductById( 
		java.lang.Integer salary_fill_send_deduct_id
	) throws Exception
	{
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setSalaryFillSendDeductId(salary_fill_send_deduct_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryFillSendDeductExists( com.pomplatform.db.bean.BaseSalaryFillSendDeduct bean, String additional ) throws Exception {

		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryFillSendDeduct( com.pomplatform.db.bean.BaseSalaryFillSendDeduct bean, String additional ) throws Exception {

		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryFillSendDeduct> querySalaryFillSendDeduct( com.pomplatform.db.bean.BaseSalaryFillSendDeduct bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryFillSendDeduct> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryFillSendDeduct> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryFillSendDeduct addToSalaryFillSendDeduct ( BaseSalaryFillSendDeduct salaryfillsenddeduct )  throws Exception {
		return addToSalaryFillSendDeduct ( salaryfillsenddeduct , false);
	}

	public static BaseSalaryFillSendDeduct addToSalaryFillSendDeduct ( BaseSalaryFillSendDeduct salaryfillsenddeduct, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setDataFromBase(salaryfillsenddeduct);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryFillSendDeduct addUpdateSalaryFillSendDeduct ( BaseSalaryFillSendDeduct salaryfillsenddeduct ) throws Exception {
		return addUpdateSalaryFillSendDeduct ( salaryfillsenddeduct , false);
	}

	public static BaseSalaryFillSendDeduct addUpdateSalaryFillSendDeduct ( BaseSalaryFillSendDeduct salaryfillsenddeduct, boolean singleTransaction  ) throws Exception {
		if(salaryfillsenddeduct.getSalaryFillSendDeductId() == null) return addToSalaryFillSendDeduct(salaryfillsenddeduct);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setDataFromBase(salaryfillsenddeduct);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryfillsenddeduct); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryFillSendDeduct ( BaseSalaryFillSendDeduct bean ) throws Exception {
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryFillSendDeduct updateSalaryFillSendDeduct ( BaseSalaryFillSendDeduct salaryfillsenddeduct ) throws Exception {
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setSalaryFillSendDeductId( salaryfillsenddeduct.getSalaryFillSendDeductId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryfillsenddeduct);
			result = dao.update();
		}
		return result == 1 ? salaryfillsenddeduct : null ;
	}

	public static BaseSalaryFillSendDeduct updateSalaryFillSendDeductDirect( BaseSalaryFillSendDeduct salaryfillsenddeduct ) throws Exception {
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		int result = 0;
		dao.setDataFromBase(salaryfillsenddeduct);
		result = dao.update();
		return result == 1 ? salaryfillsenddeduct : null ;
	}

	public static int setDeleteConditions(BaseSalaryFillSendDeduct bean, SalaryFillSendDeduct dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryFillSendDeductId() != null) {
			dao.setConditionSalaryFillSendDeductId("=", bean.getSalaryFillSendDeductId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getFillFiveInsuranceOneGolds() != null) {
				dao.setConditionFillFiveInsuranceOneGolds("=", bean.getFillFiveInsuranceOneGolds());
				count++;
			}
			if(bean.getMoreDeductTax() != null) {
				dao.setConditionMoreDeductTax("=", bean.getMoreDeductTax());
				count++;
			}
			if(bean.getFillTax() != null) {
				dao.setConditionFillTax("=", bean.getFillTax());
				count++;
			}
			if(bean.getTotalAmount() != null) {
				dao.setConditionTotalAmount("=", bean.getTotalAmount());
				count++;
			}
			if(bean.getIsSended() != null) {
				dao.setConditionIsSended("=", bean.getIsSended());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryFillSendDeduct bean, SalaryFillSendDeduct dao){
		int count = 0;
		if(bean.getSalaryFillSendDeductId() != null) {
			dao.setConditionSalaryFillSendDeductId("=", bean.getSalaryFillSendDeductId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getFillFiveInsuranceOneGolds() != null) {
			if(bean.getFillFiveInsuranceOneGolds().indexOf("%") >= 0)
				dao.setConditionFillFiveInsuranceOneGolds("like", bean.getFillFiveInsuranceOneGolds());
			else
				dao.setConditionFillFiveInsuranceOneGolds("=", bean.getFillFiveInsuranceOneGolds());
			count++;
		}
		if(bean.getMoreDeductTax() != null) {
			if(bean.getMoreDeductTax().indexOf("%") >= 0)
				dao.setConditionMoreDeductTax("like", bean.getMoreDeductTax());
			else
				dao.setConditionMoreDeductTax("=", bean.getMoreDeductTax());
			count++;
		}
		if(bean.getFillTax() != null) {
			if(bean.getFillTax().indexOf("%") >= 0)
				dao.setConditionFillTax("like", bean.getFillTax());
			else
				dao.setConditionFillTax("=", bean.getFillTax());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			if(bean.getTotalAmount().indexOf("%") >= 0)
				dao.setConditionTotalAmount("like", bean.getTotalAmount());
			else
				dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getIsSended() != null) {
			dao.setConditionIsSended("=", bean.getIsSended());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BaseSalaryFillSendDeduct bean = new BaseSalaryFillSendDeduct();
		bean.setDataFromJSON(json);
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryFillSendDeduct> rlist = new BaseCollection<>();
		BaseSalaryFillSendDeduct bean = new BaseSalaryFillSendDeduct();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryFillSendDeduct> result = dao.conditionalLoad(addtion);
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
		BaseSalaryFillSendDeduct bean = new BaseSalaryFillSendDeduct();
		bean.setDataFromJSON(json);
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryFillSendDeduct bean = new BaseSalaryFillSendDeduct();
		bean.setDataFromJSON(json);
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryFillSendDeduct bean = new BaseSalaryFillSendDeduct();
		bean.setDataFromJSON(json);
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryFillSendDeduct bean = new BaseSalaryFillSendDeduct();
		bean.setDataFromJSON(json);
		SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


