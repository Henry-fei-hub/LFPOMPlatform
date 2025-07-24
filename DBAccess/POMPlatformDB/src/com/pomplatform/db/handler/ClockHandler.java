package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClock;
import com.pomplatform.db.dao.Clock;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ClockHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ClockHandler.class);

	public static BaseClock getClockById( 
		java.lang.Integer clock_id
	) throws Exception
	{
		Clock dao = new Clock();
		dao.setClockId(clock_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isClockExists( com.pomplatform.db.bean.BaseClock bean, String additional ) throws Exception {

		Clock dao = new Clock();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countClock( com.pomplatform.db.bean.BaseClock bean, String additional ) throws Exception {

		Clock dao = new Clock();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseClock> queryClock( com.pomplatform.db.bean.BaseClock bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Clock dao = new Clock();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseClock> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseClock> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseClock addToClock ( BaseClock clock )  throws Exception {
		return addToClock ( clock , false);
	}

	public static BaseClock addToClock ( BaseClock clock, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Clock dao = new Clock();
		dao.setDataFromBase(clock);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseClock addUpdateClock ( BaseClock clock ) throws Exception {
		return addUpdateClock ( clock , false);
	}

	public static BaseClock addUpdateClock ( BaseClock clock, boolean singleTransaction  ) throws Exception {
		if(clock.getClockId() == null) return addToClock(clock);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Clock dao = new Clock();
		dao.setDataFromBase(clock);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(clock); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteClock ( BaseClock bean ) throws Exception {
		Clock dao = new Clock();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseClock updateClock ( BaseClock clock ) throws Exception {
		Clock dao = new Clock();
		dao.setClockId( clock.getClockId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(clock);
			result = dao.update();
		}
		return result == 1 ? clock : null ;
	}

	public static BaseClock updateClockDirect( BaseClock clock ) throws Exception {
		Clock dao = new Clock();
		int result = 0;
		dao.setDataFromBase(clock);
		result = dao.update();
		return result == 1 ? clock : null ;
	}

	public static int setDeleteConditions(BaseClock bean, Clock dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getClockId() != null) {
			dao.setConditionClockId("=", bean.getClockId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSn() != null) {
				dao.setConditionSn("=", bean.getSn());
				count++;
			}
			if(bean.getClockTypeId() != null) {
				dao.setConditionClockTypeId("=", bean.getClockTypeId());
				count++;
			}
			if(bean.getFwVersion() != null) {
				dao.setConditionFwVersion("=", bean.getFwVersion());
				count++;
			}
			if(bean.getDeviceName() != null) {
				dao.setConditionDeviceName("=", bean.getDeviceName());
				count++;
			}
			if(bean.getAlias() != null) {
				dao.setConditionAlias("=", bean.getAlias());
				count++;
			}
			if(bean.getFpCount() != null) {
				dao.setConditionFpCount("=", bean.getFpCount());
				count++;
			}
			if(bean.getUserCount() != null) {
				dao.setConditionUserCount("=", bean.getUserCount());
				count++;
			}
			if(bean.getMaxUserCount() != null) {
				dao.setConditionMaxUserCount("=", bean.getMaxUserCount());
				count++;
			}
			if(bean.getMaxFingerCount() != null) {
				dao.setConditionMaxFingerCount("=", bean.getMaxFingerCount());
				count++;
			}
			if(bean.getMaxAttlogCount() != null) {
				dao.setConditionMaxAttlogCount("=", bean.getMaxAttlogCount());
				count++;
			}
			if(bean.getMaxCommSize() != null) {
				dao.setConditionMaxCommSize("=", bean.getMaxCommSize());
				count++;
			}
			if(bean.getMaxCommCount() != null) {
				dao.setConditionMaxCommCount("=", bean.getMaxCommCount());
				count++;
			}
			if(bean.getFlashSize() != null) {
				dao.setConditionFlashSize("=", bean.getFlashSize());
				count++;
			}
			if(bean.getFreeFlashSize() != null) {
				dao.setConditionFreeFlashSize("=", bean.getFreeFlashSize());
				count++;
			}
			if(bean.getLanguage() != null) {
				dao.setConditionLanguage("=", bean.getLanguage());
				count++;
			}
			if(bean.getLngEncode() != null) {
				dao.setConditionLngEncode("=", bean.getLngEncode());
				count++;
			}
			if(bean.getVolume() != null) {
				dao.setConditionVolume("=", bean.getVolume());
				count++;
			}
			if(bean.getPlatform() != null) {
				dao.setConditionPlatform("=", bean.getPlatform());
				count++;
			}
			if(bean.getBrightness() != null) {
				dao.setConditionBrightness("=", bean.getBrightness());
				count++;
			}
			if(bean.getOemVendor() != null) {
				dao.setConditionOemVendor("=", bean.getOemVendor());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getAgentIpaddress() != null) {
				dao.setConditionAgentIpaddress("=", bean.getAgentIpaddress());
				count++;
			}
			if(bean.getIpaddress() != null) {
				dao.setConditionIpaddress("=", bean.getIpaddress());
				count++;
			}
			if(bean.getIpPort() != null) {
				dao.setConditionIpPort("=", bean.getIpPort());
				count++;
			}
			if(bean.getComPort() != null) {
				dao.setConditionComPort("=", bean.getComPort());
				count++;
			}
			if(bean.getBaudrate() != null) {
				dao.setConditionBaudrate("=", bean.getBaudrate());
				count++;
			}
			if(bean.getComAddress() != null) {
				dao.setConditionComAddress("=", bean.getComAddress());
				count++;
			}
			if(bean.getCommPwd() != null) {
				dao.setConditionCommPwd("=", bean.getCommPwd());
				count++;
			}
			if(bean.getAcpanelType() != null) {
				dao.setConditionAcpanelType("=", bean.getAcpanelType());
				count++;
			}
			if(bean.getSyncTime() != null) {
				dao.setConditionSyncTime("=", bean.getSyncTime());
				count++;
			}
			if(bean.getMainTime() != null) {
				dao.setConditionMainTime("=", bean.getMainTime());
				count++;
			}
			if(bean.getTransactionCount() != null) {
				dao.setConditionTransactionCount("=", bean.getTransactionCount());
				count++;
			}
			if(bean.getTransTimes() != null) {
				dao.setConditionTransTimes("=", bean.getTransTimes());
				count++;
			}
			if(bean.getTransInterval() != null) {
				dao.setConditionTransInterval("=", bean.getTransInterval());
				count++;
			}
			if(bean.getLogStamp() != null) {
				dao.setConditionLogStamp("=", bean.getLogStamp());
				count++;
			}
			if(bean.getOplogStamp() != null) {
				dao.setConditionOplogStamp("=", bean.getOplogStamp());
				count++;
			}
			if(bean.getPhotoStamp() != null) {
				dao.setConditionPhotoStamp("=", bean.getPhotoStamp());
				count++;
			}
			if(bean.getFpversion() != null) {
				dao.setConditionFpversion("=", bean.getFpversion());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
			if(bean.getRealtime() != null) {
				dao.setConditionRealtime("=", bean.getRealtime());
				count++;
			}
			if(bean.getDelay() != null) {
				dao.setConditionDelay("=", bean.getDelay());
				count++;
			}
			if(bean.getDstimeId() != null) {
				dao.setConditionDstimeId("=", bean.getDstimeId());
				count++;
			}
			if(bean.getUpdateDb() != null) {
				dao.setConditionUpdateDb("=", bean.getUpdateDb());
				count++;
			}
			if(bean.getChangeOperator() != null) {
				dao.setConditionChangeOperator("=", bean.getChangeOperator());
				count++;
			}
			if(bean.getCreateOperator() != null) {
				dao.setConditionCreateOperator("=", bean.getCreateOperator());
				count++;
			}
			if(bean.getDeleteOperator() != null) {
				dao.setConditionDeleteOperator("=", bean.getDeleteOperator());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getTzadj() != null) {
				dao.setConditionTzadj("=", bean.getTzadj());
				count++;
			}
			if(bean.getEncrypt() != null) {
				dao.setConditionEncrypt("=", bean.getEncrypt());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseClock bean, Clock dao){
		int count = 0;
		if(bean.getClockId() != null) {
			dao.setConditionClockId("=", bean.getClockId());
			count++;
		}
		if(bean.getSn() != null) {
			if(bean.getSn().indexOf("%") >= 0)
				dao.setConditionSn("like", bean.getSn());
			else
				dao.setConditionSn("=", bean.getSn());
			count++;
		}
		if(bean.getClockTypeId() != null) {
			dao.setConditionClockTypeId("=", bean.getClockTypeId());
			count++;
		}
		if(bean.getFwVersion() != null) {
			if(bean.getFwVersion().indexOf("%") >= 0)
				dao.setConditionFwVersion("like", bean.getFwVersion());
			else
				dao.setConditionFwVersion("=", bean.getFwVersion());
			count++;
		}
		if(bean.getDeviceName() != null) {
			if(bean.getDeviceName().indexOf("%") >= 0)
				dao.setConditionDeviceName("like", bean.getDeviceName());
			else
				dao.setConditionDeviceName("=", bean.getDeviceName());
			count++;
		}
		if(bean.getAlias() != null) {
			if(bean.getAlias().indexOf("%") >= 0)
				dao.setConditionAlias("like", bean.getAlias());
			else
				dao.setConditionAlias("=", bean.getAlias());
			count++;
		}
		if(bean.getFpCount() != null) {
			dao.setConditionFpCount("=", bean.getFpCount());
			count++;
		}
		if(bean.getUserCount() != null) {
			dao.setConditionUserCount("=", bean.getUserCount());
			count++;
		}
		if(bean.getMaxUserCount() != null) {
			dao.setConditionMaxUserCount("=", bean.getMaxUserCount());
			count++;
		}
		if(bean.getMaxFingerCount() != null) {
			dao.setConditionMaxFingerCount("=", bean.getMaxFingerCount());
			count++;
		}
		if(bean.getMaxAttlogCount() != null) {
			dao.setConditionMaxAttlogCount("=", bean.getMaxAttlogCount());
			count++;
		}
		if(bean.getMaxCommSize() != null) {
			dao.setConditionMaxCommSize("=", bean.getMaxCommSize());
			count++;
		}
		if(bean.getMaxCommCount() != null) {
			dao.setConditionMaxCommCount("=", bean.getMaxCommCount());
			count++;
		}
		if(bean.getFlashSize() != null) {
			if(bean.getFlashSize().indexOf("%") >= 0)
				dao.setConditionFlashSize("like", bean.getFlashSize());
			else
				dao.setConditionFlashSize("=", bean.getFlashSize());
			count++;
		}
		if(bean.getFreeFlashSize() != null) {
			if(bean.getFreeFlashSize().indexOf("%") >= 0)
				dao.setConditionFreeFlashSize("like", bean.getFreeFlashSize());
			else
				dao.setConditionFreeFlashSize("=", bean.getFreeFlashSize());
			count++;
		}
		if(bean.getLanguage() != null) {
			if(bean.getLanguage().indexOf("%") >= 0)
				dao.setConditionLanguage("like", bean.getLanguage());
			else
				dao.setConditionLanguage("=", bean.getLanguage());
			count++;
		}
		if(bean.getLngEncode() != null) {
			if(bean.getLngEncode().indexOf("%") >= 0)
				dao.setConditionLngEncode("like", bean.getLngEncode());
			else
				dao.setConditionLngEncode("=", bean.getLngEncode());
			count++;
		}
		if(bean.getVolume() != null) {
			if(bean.getVolume().indexOf("%") >= 0)
				dao.setConditionVolume("like", bean.getVolume());
			else
				dao.setConditionVolume("=", bean.getVolume());
			count++;
		}
		if(bean.getPlatform() != null) {
			if(bean.getPlatform().indexOf("%") >= 0)
				dao.setConditionPlatform("like", bean.getPlatform());
			else
				dao.setConditionPlatform("=", bean.getPlatform());
			count++;
		}
		if(bean.getBrightness() != null) {
			if(bean.getBrightness().indexOf("%") >= 0)
				dao.setConditionBrightness("like", bean.getBrightness());
			else
				dao.setConditionBrightness("=", bean.getBrightness());
			count++;
		}
		if(bean.getOemVendor() != null) {
			if(bean.getOemVendor().indexOf("%") >= 0)
				dao.setConditionOemVendor("like", bean.getOemVendor());
			else
				dao.setConditionOemVendor("=", bean.getOemVendor());
			count++;
		}
		if(bean.getCity() != null) {
			dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getAgentIpaddress() != null) {
			if(bean.getAgentIpaddress().indexOf("%") >= 0)
				dao.setConditionAgentIpaddress("like", bean.getAgentIpaddress());
			else
				dao.setConditionAgentIpaddress("=", bean.getAgentIpaddress());
			count++;
		}
		if(bean.getIpaddress() != null) {
			if(bean.getIpaddress().indexOf("%") >= 0)
				dao.setConditionIpaddress("like", bean.getIpaddress());
			else
				dao.setConditionIpaddress("=", bean.getIpaddress());
			count++;
		}
		if(bean.getIpPort() != null) {
			dao.setConditionIpPort("=", bean.getIpPort());
			count++;
		}
		if(bean.getComPort() != null) {
			dao.setConditionComPort("=", bean.getComPort());
			count++;
		}
		if(bean.getBaudrate() != null) {
			dao.setConditionBaudrate("=", bean.getBaudrate());
			count++;
		}
		if(bean.getComAddress() != null) {
			dao.setConditionComAddress("=", bean.getComAddress());
			count++;
		}
		if(bean.getCommPwd() != null) {
			if(bean.getCommPwd().indexOf("%") >= 0)
				dao.setConditionCommPwd("like", bean.getCommPwd());
			else
				dao.setConditionCommPwd("=", bean.getCommPwd());
			count++;
		}
		if(bean.getAcpanelType() != null) {
			dao.setConditionAcpanelType("=", bean.getAcpanelType());
			count++;
		}
		if(bean.getSyncTime() != null) {
			dao.setConditionSyncTime("=", bean.getSyncTime());
			count++;
		}
		if(bean.getMainTime() != null) {
			if(bean.getMainTime().indexOf("%") >= 0)
				dao.setConditionMainTime("like", bean.getMainTime());
			else
				dao.setConditionMainTime("=", bean.getMainTime());
			count++;
		}
		if(bean.getTransactionCount() != null) {
			dao.setConditionTransactionCount("=", bean.getTransactionCount());
			count++;
		}
		if(bean.getLastActivity() != null) {
			dao.setConditionLastActivity(">=", bean.getLastActivity());
			count++;
		}
		if(bean.getTransTimes() != null) {
			if(bean.getTransTimes().indexOf("%") >= 0)
				dao.setConditionTransTimes("like", bean.getTransTimes());
			else
				dao.setConditionTransTimes("=", bean.getTransTimes());
			count++;
		}
		if(bean.getTransInterval() != null) {
			dao.setConditionTransInterval("=", bean.getTransInterval());
			count++;
		}
		if(bean.getLogStamp() != null) {
			if(bean.getLogStamp().indexOf("%") >= 0)
				dao.setConditionLogStamp("like", bean.getLogStamp());
			else
				dao.setConditionLogStamp("=", bean.getLogStamp());
			count++;
		}
		if(bean.getOplogStamp() != null) {
			if(bean.getOplogStamp().indexOf("%") >= 0)
				dao.setConditionOplogStamp("like", bean.getOplogStamp());
			else
				dao.setConditionOplogStamp("=", bean.getOplogStamp());
			count++;
		}
		if(bean.getPhotoStamp() != null) {
			if(bean.getPhotoStamp().indexOf("%") >= 0)
				dao.setConditionPhotoStamp("like", bean.getPhotoStamp());
			else
				dao.setConditionPhotoStamp("=", bean.getPhotoStamp());
			count++;
		}
		if(bean.getFpversion() != null) {
			if(bean.getFpversion().indexOf("%") >= 0)
				dao.setConditionFpversion("like", bean.getFpversion());
			else
				dao.setConditionFpversion("=", bean.getFpversion());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		if(bean.getRealtime() != null) {
			dao.setConditionRealtime("=", bean.getRealtime());
			count++;
		}
		if(bean.getDelay() != null) {
			dao.setConditionDelay("=", bean.getDelay());
			count++;
		}
		if(bean.getDstimeId() != null) {
			dao.setConditionDstimeId("=", bean.getDstimeId());
			count++;
		}
		if(bean.getUpdateDb() != null) {
			if(bean.getUpdateDb().indexOf("%") >= 0)
				dao.setConditionUpdateDb("like", bean.getUpdateDb());
			else
				dao.setConditionUpdateDb("=", bean.getUpdateDb());
			count++;
		}
		if(bean.getChangeOperator() != null) {
			dao.setConditionChangeOperator("=", bean.getChangeOperator());
			count++;
		}
		if(bean.getChangeTime() != null) {
			dao.setConditionChangeTime(">=", bean.getChangeTime());
			count++;
		}
		if(bean.getCreateOperator() != null) {
			dao.setConditionCreateOperator("=", bean.getCreateOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteOperator() != null) {
			dao.setConditionDeleteOperator("=", bean.getDeleteOperator());
			count++;
		}
		if(bean.getDeleteTime() != null) {
			dao.setConditionDeleteTime(">=", bean.getDeleteTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getTzadj() != null) {
			dao.setConditionTzadj("=", bean.getTzadj());
			count++;
		}
		if(bean.getEncrypt() != null) {
			dao.setConditionEncrypt("=", bean.getEncrypt());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseClock bean = new BaseClock();
		bean.setDataFromJSON(json);
		Clock dao = new Clock();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseClock> rlist = new BaseCollection<>();
		BaseClock bean = new BaseClock();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Clock dao = new Clock();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseClock> result = dao.conditionalLoad(addtion);
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
		BaseClock bean = new BaseClock();
		bean.setDataFromJSON(json);
		Clock dao = new Clock();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseClock bean = new BaseClock();
		bean.setDataFromJSON(json);
		Clock dao = new Clock();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseClock bean = new BaseClock();
		bean.setDataFromJSON(json);
		Clock dao = new Clock();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseClock bean = new BaseClock();
		bean.setDataFromJSON(json);
		Clock dao = new Clock();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


