package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOutRedesignConsideration;
import com.pomplatform.db.dao.OutRedesignConsideration;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OutRedesignConsiderationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OutRedesignConsiderationHandler.class);

	public static BaseOutRedesignConsideration getOutRedesignConsiderationById( 
		java.lang.Integer out_redesign_consideration_id
	) throws Exception
	{
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setOutRedesignConsiderationId(out_redesign_consideration_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOutRedesignConsiderationExists( com.pomplatform.db.bean.BaseOutRedesignConsideration bean, String additional ) throws Exception {

		OutRedesignConsideration dao = new OutRedesignConsideration();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOutRedesignConsideration( com.pomplatform.db.bean.BaseOutRedesignConsideration bean, String additional ) throws Exception {

		OutRedesignConsideration dao = new OutRedesignConsideration();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOutRedesignConsideration> queryOutRedesignConsideration( com.pomplatform.db.bean.BaseOutRedesignConsideration bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OutRedesignConsideration dao = new OutRedesignConsideration();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOutRedesignConsideration> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOutRedesignConsideration> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOutRedesignConsideration addToOutRedesignConsideration ( BaseOutRedesignConsideration outredesignconsideration )  throws Exception {
		return addToOutRedesignConsideration ( outredesignconsideration , false);
	}

	public static BaseOutRedesignConsideration addToOutRedesignConsideration ( BaseOutRedesignConsideration outredesignconsideration, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setDataFromBase(outredesignconsideration);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOutRedesignConsideration addUpdateOutRedesignConsideration ( BaseOutRedesignConsideration outredesignconsideration ) throws Exception {
		return addUpdateOutRedesignConsideration ( outredesignconsideration , false);
	}

	public static BaseOutRedesignConsideration addUpdateOutRedesignConsideration ( BaseOutRedesignConsideration outredesignconsideration, boolean singleTransaction  ) throws Exception {
		if(outredesignconsideration.getOutRedesignConsiderationId() == null) return addToOutRedesignConsideration(outredesignconsideration);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setDataFromBase(outredesignconsideration);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(outredesignconsideration); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOutRedesignConsideration ( BaseOutRedesignConsideration bean ) throws Exception {
		OutRedesignConsideration dao = new OutRedesignConsideration();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOutRedesignConsideration updateOutRedesignConsideration ( BaseOutRedesignConsideration outredesignconsideration ) throws Exception {
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setOutRedesignConsiderationId( outredesignconsideration.getOutRedesignConsiderationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(outredesignconsideration);
			result = dao.update();
		}
		return result == 1 ? outredesignconsideration : null ;
	}

	public static BaseOutRedesignConsideration updateOutRedesignConsiderationDirect( BaseOutRedesignConsideration outredesignconsideration ) throws Exception {
		OutRedesignConsideration dao = new OutRedesignConsideration();
		int result = 0;
		dao.setDataFromBase(outredesignconsideration);
		result = dao.update();
		return result == 1 ? outredesignconsideration : null ;
	}

	public static int setDeleteConditions(BaseOutRedesignConsideration bean, OutRedesignConsideration dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutRedesignConsiderationId() != null) {
			dao.setConditionOutRedesignConsiderationId("=", bean.getOutRedesignConsiderationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getMainDesignAreaName() != null) {
				dao.setConditionMainDesignAreaName("=", bean.getMainDesignAreaName());
				count++;
			}
			if(bean.getDecorationStatus() != null) {
				dao.setConditionDecorationStatus("=", bean.getDecorationStatus());
				count++;
			}
			if(bean.getSubContractId() != null) {
				dao.setConditionSubContractId("=", bean.getSubContractId());
				count++;
			}
			if(bean.getJobMix() != null) {
				dao.setConditionJobMix("=", bean.getJobMix());
				count++;
			}
			if(bean.getOnSiteTime() != null) {
				dao.setConditionOnSiteTime("=", bean.getOnSiteTime());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getDisableType() != null) {
				dao.setConditionDisableType("=", bean.getDisableType());
				count++;
			}
			if(bean.getOutQuotationId() != null) {
				dao.setConditionOutQuotationId("=", bean.getOutQuotationId());
				count++;
			}
			if(bean.getOptionType() != null) {
				dao.setConditionOptionType("=", bean.getOptionType());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOutRedesignConsideration bean, OutRedesignConsideration dao){
		int count = 0;
		if(bean.getOutRedesignConsiderationId() != null) {
			dao.setConditionOutRedesignConsiderationId("=", bean.getOutRedesignConsiderationId());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getMainDesignAreaName() != null) {
			if(bean.getMainDesignAreaName().indexOf("%") >= 0)
				dao.setConditionMainDesignAreaName("like", bean.getMainDesignAreaName());
			else
				dao.setConditionMainDesignAreaName("=", bean.getMainDesignAreaName());
			count++;
		}
		if(bean.getDecorationStatus() != null) {
			dao.setConditionDecorationStatus("=", bean.getDecorationStatus());
			count++;
		}
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getDesignUnitPrice() != null) {
			dao.setConditionDesignUnitPrice("=", bean.getDesignUnitPrice());
			count++;
		}
		if(bean.getMoneySum() != null) {
			dao.setConditionMoneySum("=", bean.getMoneySum());
			count++;
		}
		if(bean.getSubContractId() != null) {
			dao.setConditionSubContractId("=", bean.getSubContractId());
			count++;
		}
		if(bean.getJobMix() != null) {
			dao.setConditionJobMix("=", bean.getJobMix());
			count++;
		}
		if(bean.getServiceArea() != null) {
			dao.setConditionServiceArea("=", bean.getServiceArea());
			count++;
		}
		if(bean.getWithTheAmount() != null) {
			dao.setConditionWithTheAmount("=", bean.getWithTheAmount());
			count++;
		}
		if(bean.getOnSiteTime() != null) {
			dao.setConditionOnSiteTime("=", bean.getOnSiteTime());
			count++;
		}
		if(bean.getOnSitePrice() != null) {
			dao.setConditionOnSitePrice("=", bean.getOnSitePrice());
			count++;
		}
		if(bean.getOnSiteTotalMoney() != null) {
			dao.setConditionOnSiteTotalMoney("=", bean.getOnSiteTotalMoney());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getDisableType() != null) {
			dao.setConditionDisableType("=", bean.getDisableType());
			count++;
		}
		if(bean.getOutQuotationId() != null) {
			dao.setConditionOutQuotationId("=", bean.getOutQuotationId());
			count++;
		}
		if(bean.getInteriorPrice() != null) {
			dao.setConditionInteriorPrice("=", bean.getInteriorPrice());
			count++;
		}
		if(bean.getInteriorMoneySum() != null) {
			dao.setConditionInteriorMoneySum("=", bean.getInteriorMoneySum());
			count++;
		}
		if(bean.getOptionType() != null) {
			dao.setConditionOptionType("=", bean.getOptionType());
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
		BaseOutRedesignConsideration bean = new BaseOutRedesignConsideration();
		bean.setDataFromJSON(json);
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutRedesignConsideration> rlist = new BaseCollection<>();
		BaseOutRedesignConsideration bean = new BaseOutRedesignConsideration();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutRedesignConsideration dao = new OutRedesignConsideration();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutRedesignConsideration> result = dao.conditionalLoad(addtion);
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
		BaseOutRedesignConsideration bean = new BaseOutRedesignConsideration();
		bean.setDataFromJSON(json);
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutRedesignConsideration bean = new BaseOutRedesignConsideration();
		bean.setDataFromJSON(json);
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutRedesignConsideration bean = new BaseOutRedesignConsideration();
		bean.setDataFromJSON(json);
		OutRedesignConsideration dao = new OutRedesignConsideration();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutRedesignConsideration bean = new BaseOutRedesignConsideration();
		bean.setDataFromJSON(json);
		OutRedesignConsideration dao = new OutRedesignConsideration();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


