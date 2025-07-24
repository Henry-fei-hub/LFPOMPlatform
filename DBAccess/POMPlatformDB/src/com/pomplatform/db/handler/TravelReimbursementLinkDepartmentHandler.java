package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;
import com.pomplatform.db.dao.TravelReimbursementLinkDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TravelReimbursementLinkDepartmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementLinkDepartmentHandler.class);

	public static BaseTravelReimbursementLinkDepartment getTravelReimbursementLinkDepartmentById( 
		java.lang.Integer travel_reimbursement_link_department_id
	) throws Exception
	{
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setTravelReimbursementLinkDepartmentId(travel_reimbursement_link_department_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTravelReimbursementLinkDepartmentExists( com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment bean, String additional ) throws Exception {

		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTravelReimbursementLinkDepartment( com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment bean, String additional ) throws Exception {

		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTravelReimbursementLinkDepartment> queryTravelReimbursementLinkDepartment( com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTravelReimbursementLinkDepartment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTravelReimbursementLinkDepartment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTravelReimbursementLinkDepartment addToTravelReimbursementLinkDepartment ( BaseTravelReimbursementLinkDepartment travelreimbursementlinkdepartment )  throws Exception {
		return addToTravelReimbursementLinkDepartment ( travelreimbursementlinkdepartment , false);
	}

	public static BaseTravelReimbursementLinkDepartment addToTravelReimbursementLinkDepartment ( BaseTravelReimbursementLinkDepartment travelreimbursementlinkdepartment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setDataFromBase(travelreimbursementlinkdepartment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTravelReimbursementLinkDepartment addUpdateTravelReimbursementLinkDepartment ( BaseTravelReimbursementLinkDepartment travelreimbursementlinkdepartment ) throws Exception {
		return addUpdateTravelReimbursementLinkDepartment ( travelreimbursementlinkdepartment , false);
	}

	public static BaseTravelReimbursementLinkDepartment addUpdateTravelReimbursementLinkDepartment ( BaseTravelReimbursementLinkDepartment travelreimbursementlinkdepartment, boolean singleTransaction  ) throws Exception {
		if(travelreimbursementlinkdepartment.getTravelReimbursementLinkDepartmentId() == null) return addToTravelReimbursementLinkDepartment(travelreimbursementlinkdepartment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setDataFromBase(travelreimbursementlinkdepartment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(travelreimbursementlinkdepartment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTravelReimbursementLinkDepartment ( BaseTravelReimbursementLinkDepartment bean ) throws Exception {
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTravelReimbursementLinkDepartment updateTravelReimbursementLinkDepartment ( BaseTravelReimbursementLinkDepartment travelreimbursementlinkdepartment ) throws Exception {
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setTravelReimbursementLinkDepartmentId( travelreimbursementlinkdepartment.getTravelReimbursementLinkDepartmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(travelreimbursementlinkdepartment);
			result = dao.update();
		}
		return result == 1 ? travelreimbursementlinkdepartment : null ;
	}

	public static BaseTravelReimbursementLinkDepartment updateTravelReimbursementLinkDepartmentDirect( BaseTravelReimbursementLinkDepartment travelreimbursementlinkdepartment ) throws Exception {
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		int result = 0;
		dao.setDataFromBase(travelreimbursementlinkdepartment);
		result = dao.update();
		return result == 1 ? travelreimbursementlinkdepartment : null ;
	}

	public static int setDeleteConditions(BaseTravelReimbursementLinkDepartment bean, TravelReimbursementLinkDepartment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTravelReimbursementLinkDepartmentId() != null) {
			dao.setConditionTravelReimbursementLinkDepartmentId("=", bean.getTravelReimbursementLinkDepartmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTravelReimbursementId() != null) {
				dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getHaveElectronicInvoice() != null) {
				dao.setConditionHaveElectronicInvoice("=", bean.getHaveElectronicInvoice());
				count++;
			}
			if(bean.getInvoiceLinkKey() != null) {
				dao.setConditionInvoiceLinkKey("=", bean.getInvoiceLinkKey());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTravelReimbursementLinkDepartment bean, TravelReimbursementLinkDepartment dao){
		int count = 0;
		if(bean.getTravelReimbursementLinkDepartmentId() != null) {
			dao.setConditionTravelReimbursementLinkDepartmentId("=", bean.getTravelReimbursementLinkDepartmentId());
			count++;
		}
		if(bean.getTravelReimbursementId() != null) {
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getInputTax() != null) {
			dao.setConditionInputTax("=", bean.getInputTax());
			count++;
		}
		if(bean.getFinalAmount() != null) {
			dao.setConditionFinalAmount("=", bean.getFinalAmount());
			count++;
		}
		if(bean.getInputTaxRebate() != null) {
			dao.setConditionInputTaxRebate("=", bean.getInputTaxRebate());
			count++;
		}
		if(bean.getHaveElectronicInvoice() != null) {
			dao.setConditionHaveElectronicInvoice("=", bean.getHaveElectronicInvoice());
			count++;
		}
		if(bean.getInvoiceLinkKey() != null) {
			dao.setConditionInvoiceLinkKey("=", bean.getInvoiceLinkKey());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTravelReimbursementLinkDepartment bean = new BaseTravelReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTravelReimbursementLinkDepartment> rlist = new BaseCollection<>();
		BaseTravelReimbursementLinkDepartment bean = new BaseTravelReimbursementLinkDepartment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTravelReimbursementLinkDepartment> result = dao.conditionalLoad(addtion);
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
		BaseTravelReimbursementLinkDepartment bean = new BaseTravelReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTravelReimbursementLinkDepartment bean = new BaseTravelReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTravelReimbursementLinkDepartment bean = new BaseTravelReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTravelReimbursementLinkDepartment bean = new BaseTravelReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkDepartment dao = new TravelReimbursementLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


