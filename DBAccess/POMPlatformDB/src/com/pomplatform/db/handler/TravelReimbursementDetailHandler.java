package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TravelReimbursementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementDetailHandler.class);

	public static BaseTravelReimbursementDetail getTravelReimbursementDetailById( 
		java.lang.Integer travel_reimbursement_detail_id
	) throws Exception
	{
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setTravelReimbursementDetailId(travel_reimbursement_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTravelReimbursementDetailExists( com.pomplatform.db.bean.BaseTravelReimbursementDetail bean, String additional ) throws Exception {

		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTravelReimbursementDetail( com.pomplatform.db.bean.BaseTravelReimbursementDetail bean, String additional ) throws Exception {

		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTravelReimbursementDetail> queryTravelReimbursementDetail( com.pomplatform.db.bean.BaseTravelReimbursementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTravelReimbursementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTravelReimbursementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTravelReimbursementDetail addToTravelReimbursementDetail ( BaseTravelReimbursementDetail travelreimbursementdetail )  throws Exception {
		return addToTravelReimbursementDetail ( travelreimbursementdetail , false);
	}

	public static BaseTravelReimbursementDetail addToTravelReimbursementDetail ( BaseTravelReimbursementDetail travelreimbursementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setDataFromBase(travelreimbursementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTravelReimbursementDetail addUpdateTravelReimbursementDetail ( BaseTravelReimbursementDetail travelreimbursementdetail ) throws Exception {
		return addUpdateTravelReimbursementDetail ( travelreimbursementdetail , false);
	}

	public static BaseTravelReimbursementDetail addUpdateTravelReimbursementDetail ( BaseTravelReimbursementDetail travelreimbursementdetail, boolean singleTransaction  ) throws Exception {
		if(travelreimbursementdetail.getTravelReimbursementDetailId() == null) return addToTravelReimbursementDetail(travelreimbursementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setDataFromBase(travelreimbursementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(travelreimbursementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTravelReimbursementDetail ( BaseTravelReimbursementDetail bean ) throws Exception {
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTravelReimbursementDetail updateTravelReimbursementDetail ( BaseTravelReimbursementDetail travelreimbursementdetail ) throws Exception {
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setTravelReimbursementDetailId( travelreimbursementdetail.getTravelReimbursementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(travelreimbursementdetail);
			result = dao.update();
		}
		return result == 1 ? travelreimbursementdetail : null ;
	}

	public static BaseTravelReimbursementDetail updateTravelReimbursementDetailDirect( BaseTravelReimbursementDetail travelreimbursementdetail ) throws Exception {
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		int result = 0;
		dao.setDataFromBase(travelreimbursementdetail);
		result = dao.update();
		return result == 1 ? travelreimbursementdetail : null ;
	}

	public static int setDeleteConditions(BaseTravelReimbursementDetail bean, TravelReimbursementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTravelReimbursementDetailId() != null) {
			dao.setConditionTravelReimbursementDetailId("=", bean.getTravelReimbursementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTravelReimbursementId() != null) {
				dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				count++;
			}
			if(bean.getStartAddress() != null) {
				dao.setConditionStartAddress("=", bean.getStartAddress());
				count++;
			}
			if(bean.getArrivingAddress() != null) {
				dao.setConditionArrivingAddress("=", bean.getArrivingAddress());
				count++;
			}
			if(bean.getTravelDays() != null) {
				dao.setConditionTravelDays("=", bean.getTravelDays());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTravelReimbursementDetail bean, TravelReimbursementDetail dao){
		int count = 0;
		if(bean.getTravelReimbursementDetailId() != null) {
			dao.setConditionTravelReimbursementDetailId("=", bean.getTravelReimbursementDetailId());
			count++;
		}
		if(bean.getTravelReimbursementId() != null) {
			dao.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getStartAddress() != null) {
			if(bean.getStartAddress().indexOf("%") >= 0)
				dao.setConditionStartAddress("like", bean.getStartAddress());
			else
				dao.setConditionStartAddress("=", bean.getStartAddress());
			count++;
		}
		if(bean.getArrivingAddress() != null) {
			if(bean.getArrivingAddress().indexOf("%") >= 0)
				dao.setConditionArrivingAddress("like", bean.getArrivingAddress());
			else
				dao.setConditionArrivingAddress("=", bean.getArrivingAddress());
			count++;
		}
		if(bean.getTravelDays() != null) {
			dao.setConditionTravelDays("=", bean.getTravelDays());
			count++;
		}
		if(bean.getAirfare() != null) {
			dao.setConditionAirfare("=", bean.getAirfare());
			count++;
		}
		if(bean.getCarBoatFee() != null) {
			dao.setConditionCarBoatFee("=", bean.getCarBoatFee());
			count++;
		}
		if(bean.getCityTransportation() != null) {
			dao.setConditionCityTransportation("=", bean.getCityTransportation());
			count++;
		}
		if(bean.getShippingFee() != null) {
			dao.setConditionShippingFee("=", bean.getShippingFee());
			count++;
		}
		if(bean.getAccommodationFee() != null) {
			dao.setConditionAccommodationFee("=", bean.getAccommodationFee());
			count++;
		}
		if(bean.getDrivingFee() != null) {
			dao.setConditionDrivingFee("=", bean.getDrivingFee());
			count++;
		}
		if(bean.getTravelAllowance() != null) {
			dao.setConditionTravelAllowance("=", bean.getTravelAllowance());
			count++;
		}
		if(bean.getSum() != null) {
			dao.setConditionSum("=", bean.getSum());
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
		BaseTravelReimbursementDetail bean = new BaseTravelReimbursementDetail();
		bean.setDataFromJSON(json);
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTravelReimbursementDetail> rlist = new BaseCollection<>();
		BaseTravelReimbursementDetail bean = new BaseTravelReimbursementDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTravelReimbursementDetail> result = dao.conditionalLoad(addtion);
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
		BaseTravelReimbursementDetail bean = new BaseTravelReimbursementDetail();
		bean.setDataFromJSON(json);
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTravelReimbursementDetail bean = new BaseTravelReimbursementDetail();
		bean.setDataFromJSON(json);
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTravelReimbursementDetail bean = new BaseTravelReimbursementDetail();
		bean.setDataFromJSON(json);
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTravelReimbursementDetail bean = new BaseTravelReimbursementDetail();
		bean.setDataFromJSON(json);
		TravelReimbursementDetail dao = new TravelReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


