package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMarketingCommissionDetail;
import com.pomplatform.db.dao.MarketingCommissionDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class MarketingCommissionDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MarketingCommissionDetailHandler.class);

	public static BaseMarketingCommissionDetail getMarketingCommissionDetailById( 
		java.lang.Short marketing_commission_detail_id
	) throws Exception
	{
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setMarketingCommissionDetailId(marketing_commission_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMarketingCommissionDetailExists( com.pomplatform.db.bean.BaseMarketingCommissionDetail bean, String additional ) throws Exception {

		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMarketingCommissionDetail( com.pomplatform.db.bean.BaseMarketingCommissionDetail bean, String additional ) throws Exception {

		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMarketingCommissionDetail> queryMarketingCommissionDetail( com.pomplatform.db.bean.BaseMarketingCommissionDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMarketingCommissionDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMarketingCommissionDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMarketingCommissionDetail addToMarketingCommissionDetail ( BaseMarketingCommissionDetail marketingcommissiondetail )  throws Exception {
		return addToMarketingCommissionDetail ( marketingcommissiondetail , false);
	}

	public static BaseMarketingCommissionDetail addToMarketingCommissionDetail ( BaseMarketingCommissionDetail marketingcommissiondetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setDataFromBase(marketingcommissiondetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMarketingCommissionDetail addUpdateMarketingCommissionDetail ( BaseMarketingCommissionDetail marketingcommissiondetail ) throws Exception {
		return addUpdateMarketingCommissionDetail ( marketingcommissiondetail , false);
	}

	public static BaseMarketingCommissionDetail addUpdateMarketingCommissionDetail ( BaseMarketingCommissionDetail marketingcommissiondetail, boolean singleTransaction  ) throws Exception {
		if(marketingcommissiondetail.getMarketingCommissionDetailId() == null) return addToMarketingCommissionDetail(marketingcommissiondetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setDataFromBase(marketingcommissiondetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(marketingcommissiondetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMarketingCommissionDetail ( BaseMarketingCommissionDetail bean ) throws Exception {
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMarketingCommissionDetail updateMarketingCommissionDetail ( BaseMarketingCommissionDetail marketingcommissiondetail ) throws Exception {
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setMarketingCommissionDetailId( marketingcommissiondetail.getMarketingCommissionDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(marketingcommissiondetail);
			result = dao.update();
		}
		return result == 1 ? marketingcommissiondetail : null ;
	}

	public static BaseMarketingCommissionDetail updateMarketingCommissionDetailDirect( BaseMarketingCommissionDetail marketingcommissiondetail ) throws Exception {
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		int result = 0;
		dao.setDataFromBase(marketingcommissiondetail);
		result = dao.update();
		return result == 1 ? marketingcommissiondetail : null ;
	}

	public static int setDeleteConditions(BaseMarketingCommissionDetail bean, MarketingCommissionDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMarketingCommissionDetailId() != null) {
			dao.setConditionMarketingCommissionDetailId("=", bean.getMarketingCommissionDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMarketingCommissionId() != null) {
				dao.setConditionMarketingCommissionId("=", bean.getMarketingCommissionId());
				count++;
			}
			if(bean.getUserId() != null) {
				dao.setConditionUserId("=", bean.getUserId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMarketingCommissionDetail bean, MarketingCommissionDetail dao){
		int count = 0;
		if(bean.getMarketingCommissionDetailId() != null) {
			dao.setConditionMarketingCommissionDetailId("=", bean.getMarketingCommissionDetailId());
			count++;
		}
		if(bean.getMarketingCommissionId() != null) {
			dao.setConditionMarketingCommissionId("=", bean.getMarketingCommissionId());
			count++;
		}
		if(bean.getUserId() != null) {
			dao.setConditionUserId("=", bean.getUserId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getRevenue() != null) {
			dao.setConditionRevenue("=", bean.getRevenue());
			count++;
		}
		if(bean.getCommissionDate() != null) {
			dao.setConditionCommissionDate(">=", bean.getCommissionDate());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMarketingCommissionDetail bean = new BaseMarketingCommissionDetail();
		bean.setDataFromJSON(json);
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMarketingCommissionDetail> rlist = new BaseCollection<>();
		BaseMarketingCommissionDetail bean = new BaseMarketingCommissionDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMarketingCommissionDetail> result = dao.conditionalLoad(addtion);
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
		BaseMarketingCommissionDetail bean = new BaseMarketingCommissionDetail();
		bean.setDataFromJSON(json);
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMarketingCommissionDetail bean = new BaseMarketingCommissionDetail();
		bean.setDataFromJSON(json);
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMarketingCommissionDetail bean = new BaseMarketingCommissionDetail();
		bean.setDataFromJSON(json);
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMarketingCommissionDetail bean = new BaseMarketingCommissionDetail();
		bean.setDataFromJSON(json);
		MarketingCommissionDetail dao = new MarketingCommissionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


