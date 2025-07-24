package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseStaticIpAddress;
import com.pomplatform.db.dao.StaticIpAddress;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class StaticIpAddressHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StaticIpAddressHandler.class);

	public static BaseStaticIpAddress getStaticIpAddressById( 
		java.lang.Long start_address
	) throws Exception
	{
		StaticIpAddress dao = new StaticIpAddress();
		dao.setStartAddress(start_address);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStaticIpAddressExists( com.pomplatform.db.bean.BaseStaticIpAddress bean, String additional ) throws Exception {

		StaticIpAddress dao = new StaticIpAddress();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStaticIpAddress( com.pomplatform.db.bean.BaseStaticIpAddress bean, String additional ) throws Exception {

		StaticIpAddress dao = new StaticIpAddress();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStaticIpAddress> queryStaticIpAddress( com.pomplatform.db.bean.BaseStaticIpAddress bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		StaticIpAddress dao = new StaticIpAddress();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStaticIpAddress> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStaticIpAddress> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStaticIpAddress addToStaticIpAddress ( BaseStaticIpAddress staticipaddress )  throws Exception {
		return addToStaticIpAddress ( staticipaddress , false);
	}

	public static BaseStaticIpAddress addToStaticIpAddress ( BaseStaticIpAddress staticipaddress, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StaticIpAddress dao = new StaticIpAddress();
		dao.setDataFromBase(staticipaddress);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStaticIpAddress addUpdateStaticIpAddress ( BaseStaticIpAddress staticipaddress ) throws Exception {
		return addUpdateStaticIpAddress ( staticipaddress , false);
	}

	public static BaseStaticIpAddress addUpdateStaticIpAddress ( BaseStaticIpAddress staticipaddress, boolean singleTransaction  ) throws Exception {
		if(staticipaddress.getStartAddress() == null) return addToStaticIpAddress(staticipaddress);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		StaticIpAddress dao = new StaticIpAddress();
		dao.setDataFromBase(staticipaddress);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(staticipaddress); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStaticIpAddress ( BaseStaticIpAddress bean ) throws Exception {
		StaticIpAddress dao = new StaticIpAddress();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStaticIpAddress updateStaticIpAddress ( BaseStaticIpAddress staticipaddress ) throws Exception {
		StaticIpAddress dao = new StaticIpAddress();
		dao.setStartAddress( staticipaddress.getStartAddress() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(staticipaddress);
			result = dao.update();
		}
		return result == 1 ? staticipaddress : null ;
	}

	public static BaseStaticIpAddress updateStaticIpAddressDirect( BaseStaticIpAddress staticipaddress ) throws Exception {
		StaticIpAddress dao = new StaticIpAddress();
		int result = 0;
		dao.setDataFromBase(staticipaddress);
		result = dao.update();
		return result == 1 ? staticipaddress : null ;
	}

	public static int setDeleteConditions(BaseStaticIpAddress bean, StaticIpAddress dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStartAddress() != null) {
			dao.setConditionStartAddress("=", bean.getStartAddress());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEndAddress() != null) {
				dao.setConditionEndAddress("=", bean.getEndAddress());
				count++;
			}
			if(bean.getStartIp() != null) {
				dao.setConditionStartIp("=", bean.getStartIp());
				count++;
			}
			if(bean.getEndIp() != null) {
				dao.setConditionEndIp("=", bean.getEndIp());
				count++;
			}
			if(bean.getCountryId() != null) {
				dao.setConditionCountryId("=", bean.getCountryId());
				count++;
			}
			if(bean.getProvinceId() != null) {
				dao.setConditionProvinceId("=", bean.getProvinceId());
				count++;
			}
			if(bean.getCityId() != null) {
				dao.setConditionCityId("=", bean.getCityId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStaticIpAddress bean, StaticIpAddress dao){
		int count = 0;
		if(bean.getStartAddress() != null) {
			dao.setConditionStartAddress("=", bean.getStartAddress());
			count++;
		}
		if(bean.getEndAddress() != null) {
			dao.setConditionEndAddress("=", bean.getEndAddress());
			count++;
		}
		if(bean.getStartIp() != null) {
			if(bean.getStartIp().indexOf("%") >= 0)
				dao.setConditionStartIp("like", bean.getStartIp());
			else
				dao.setConditionStartIp("=", bean.getStartIp());
			count++;
		}
		if(bean.getEndIp() != null) {
			if(bean.getEndIp().indexOf("%") >= 0)
				dao.setConditionEndIp("like", bean.getEndIp());
			else
				dao.setConditionEndIp("=", bean.getEndIp());
			count++;
		}
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
		}
		if(bean.getCityId() != null) {
			dao.setConditionCityId("=", bean.getCityId());
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
		BaseStaticIpAddress bean = new BaseStaticIpAddress();
		bean.setDataFromJSON(json);
		StaticIpAddress dao = new StaticIpAddress();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStaticIpAddress> rlist = new BaseCollection<>();
		BaseStaticIpAddress bean = new BaseStaticIpAddress();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		StaticIpAddress dao = new StaticIpAddress();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStaticIpAddress> result = dao.conditionalLoad(addtion);
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
		BaseStaticIpAddress bean = new BaseStaticIpAddress();
		bean.setDataFromJSON(json);
		StaticIpAddress dao = new StaticIpAddress();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStaticIpAddress bean = new BaseStaticIpAddress();
		bean.setDataFromJSON(json);
		StaticIpAddress dao = new StaticIpAddress();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStaticIpAddress bean = new BaseStaticIpAddress();
		bean.setDataFromJSON(json);
		StaticIpAddress dao = new StaticIpAddress();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStaticIpAddress bean = new BaseStaticIpAddress();
		bean.setDataFromJSON(json);
		StaticIpAddress dao = new StaticIpAddress();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


