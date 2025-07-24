package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.TravelReimbursementLinkProject;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TravelReimbursementLinkProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementLinkProjectHandler.class);

	public static BaseTravelReimbursementLinkProject getTravelReimbursementLinkProjectById( 
		java.lang.Integer travel_reimbursement_link_project_id
	) throws Exception
	{
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setTravelReimbursementLinkProjectId(travel_reimbursement_link_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTravelReimbursementLinkProjectExists( com.pomplatform.db.bean.BaseTravelReimbursementLinkProject bean, String additional ) throws Exception {

		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTravelReimbursementLinkProject( com.pomplatform.db.bean.BaseTravelReimbursementLinkProject bean, String additional ) throws Exception {

		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTravelReimbursementLinkProject> queryTravelReimbursementLinkProject( com.pomplatform.db.bean.BaseTravelReimbursementLinkProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTravelReimbursementLinkProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTravelReimbursementLinkProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTravelReimbursementLinkProject addToTravelReimbursementLinkProject ( BaseTravelReimbursementLinkProject travelreimbursementlinkproject )  throws Exception {
		return addToTravelReimbursementLinkProject ( travelreimbursementlinkproject , false);
	}

	public static BaseTravelReimbursementLinkProject addToTravelReimbursementLinkProject ( BaseTravelReimbursementLinkProject travelreimbursementlinkproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setDataFromBase(travelreimbursementlinkproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTravelReimbursementLinkProject addUpdateTravelReimbursementLinkProject ( BaseTravelReimbursementLinkProject travelreimbursementlinkproject ) throws Exception {
		return addUpdateTravelReimbursementLinkProject ( travelreimbursementlinkproject , false);
	}

	public static BaseTravelReimbursementLinkProject addUpdateTravelReimbursementLinkProject ( BaseTravelReimbursementLinkProject travelreimbursementlinkproject, boolean singleTransaction  ) throws Exception {
		if(travelreimbursementlinkproject.getTravelReimbursementLinkProjectId() == null) return addToTravelReimbursementLinkProject(travelreimbursementlinkproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setDataFromBase(travelreimbursementlinkproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(travelreimbursementlinkproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTravelReimbursementLinkProject ( BaseTravelReimbursementLinkProject bean ) throws Exception {
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTravelReimbursementLinkProject updateTravelReimbursementLinkProject ( BaseTravelReimbursementLinkProject travelreimbursementlinkproject ) throws Exception {
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setTravelReimbursementLinkProjectId( travelreimbursementlinkproject.getTravelReimbursementLinkProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(travelreimbursementlinkproject);
			result = dao.update();
		}
		return result == 1 ? travelreimbursementlinkproject : null ;
	}

	public static BaseTravelReimbursementLinkProject updateTravelReimbursementLinkProjectDirect( BaseTravelReimbursementLinkProject travelreimbursementlinkproject ) throws Exception {
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		int result = 0;
		dao.setDataFromBase(travelreimbursementlinkproject);
		result = dao.update();
		return result == 1 ? travelreimbursementlinkproject : null ;
	}

	public static int setDeleteConditions(BaseTravelReimbursementLinkProject bean, TravelReimbursementLinkProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTravelReimbursementLinkProjectId() != null) {
			dao.setConditionTravelReimbursementLinkProjectId("=", bean.getTravelReimbursementLinkProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTravelReimbursementId() != null) {
				dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getIsPersonalFee() != null) {
				dao.setConditionIsPersonalFee("=", bean.getIsPersonalFee());
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

	public static int setConditions(BaseTravelReimbursementLinkProject bean, TravelReimbursementLinkProject dao){
		int count = 0;
		if(bean.getTravelReimbursementLinkProjectId() != null) {
			dao.setConditionTravelReimbursementLinkProjectId("=", bean.getTravelReimbursementLinkProjectId());
			count++;
		}
		if(bean.getTravelReimbursementId() != null) {
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		if(bean.getIsPersonalFee() != null) {
			dao.setConditionIsPersonalFee("=", bean.getIsPersonalFee());
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
		BaseTravelReimbursementLinkProject bean = new BaseTravelReimbursementLinkProject();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTravelReimbursementLinkProject> rlist = new BaseCollection<>();
		BaseTravelReimbursementLinkProject bean = new BaseTravelReimbursementLinkProject();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTravelReimbursementLinkProject> result = dao.conditionalLoad(addtion);
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
		BaseTravelReimbursementLinkProject bean = new BaseTravelReimbursementLinkProject();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTravelReimbursementLinkProject bean = new BaseTravelReimbursementLinkProject();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTravelReimbursementLinkProject bean = new BaseTravelReimbursementLinkProject();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTravelReimbursementLinkProject bean = new BaseTravelReimbursementLinkProject();
		bean.setDataFromJSON(json);
		TravelReimbursementLinkProject dao = new TravelReimbursementLinkProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


