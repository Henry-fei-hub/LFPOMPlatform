package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClockSendCmd;
import com.pomplatform.db.dao.ClockSendCmd;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ClockSendCmdHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ClockSendCmdHandler.class);

	public static BaseClockSendCmd getClockSendCmdById( 
		java.lang.Integer clock_send_cmd_id
	) throws Exception
	{
		ClockSendCmd dao = new ClockSendCmd();
		dao.setClockSendCmdId(clock_send_cmd_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isClockSendCmdExists( com.pomplatform.db.bean.BaseClockSendCmd bean, String additional ) throws Exception {

		ClockSendCmd dao = new ClockSendCmd();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countClockSendCmd( com.pomplatform.db.bean.BaseClockSendCmd bean, String additional ) throws Exception {

		ClockSendCmd dao = new ClockSendCmd();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseClockSendCmd> queryClockSendCmd( com.pomplatform.db.bean.BaseClockSendCmd bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ClockSendCmd dao = new ClockSendCmd();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseClockSendCmd> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseClockSendCmd> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseClockSendCmd addToClockSendCmd ( BaseClockSendCmd clocksendcmd )  throws Exception {
		return addToClockSendCmd ( clocksendcmd , false);
	}

	public static BaseClockSendCmd addToClockSendCmd ( BaseClockSendCmd clocksendcmd, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ClockSendCmd dao = new ClockSendCmd();
		dao.setDataFromBase(clocksendcmd);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseClockSendCmd addUpdateClockSendCmd ( BaseClockSendCmd clocksendcmd ) throws Exception {
		return addUpdateClockSendCmd ( clocksendcmd , false);
	}

	public static BaseClockSendCmd addUpdateClockSendCmd ( BaseClockSendCmd clocksendcmd, boolean singleTransaction  ) throws Exception {
		if(clocksendcmd.getClockSendCmdId() == null) return addToClockSendCmd(clocksendcmd);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ClockSendCmd dao = new ClockSendCmd();
		dao.setDataFromBase(clocksendcmd);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(clocksendcmd); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteClockSendCmd ( BaseClockSendCmd bean ) throws Exception {
		ClockSendCmd dao = new ClockSendCmd();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseClockSendCmd updateClockSendCmd ( BaseClockSendCmd clocksendcmd ) throws Exception {
		ClockSendCmd dao = new ClockSendCmd();
		dao.setClockSendCmdId( clocksendcmd.getClockSendCmdId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(clocksendcmd);
			result = dao.update();
		}
		return result == 1 ? clocksendcmd : null ;
	}

	public static BaseClockSendCmd updateClockSendCmdDirect( BaseClockSendCmd clocksendcmd ) throws Exception {
		ClockSendCmd dao = new ClockSendCmd();
		int result = 0;
		dao.setDataFromBase(clocksendcmd);
		result = dao.update();
		return result == 1 ? clocksendcmd : null ;
	}

	public static int setDeleteConditions(BaseClockSendCmd bean, ClockSendCmd dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getClockSendCmdId() != null) {
			dao.setConditionClockSendCmdId("=", bean.getClockSendCmdId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSn() != null) {
				dao.setConditionSn("=", bean.getSn());
				count++;
			}
			if(bean.getCount() != null) {
				dao.setConditionCount("=", bean.getCount());
				count++;
			}
			if(bean.getTransContext() != null) {
				dao.setConditionTransContext("=", bean.getTransContext());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseClockSendCmd bean, ClockSendCmd dao){
		int count = 0;
		if(bean.getClockSendCmdId() != null) {
			dao.setConditionClockSendCmdId("=", bean.getClockSendCmdId());
			count++;
		}
		if(bean.getSn() != null) {
			if(bean.getSn().indexOf("%") >= 0)
				dao.setConditionSn("like", bean.getSn());
			else
				dao.setConditionSn("=", bean.getSn());
			count++;
		}
		if(bean.getCount() != null) {
			dao.setConditionCount("=", bean.getCount());
			count++;
		}
		if(bean.getTransContext() != null) {
			if(bean.getTransContext().indexOf("%") >= 0)
				dao.setConditionTransContext("like", bean.getTransContext());
			else
				dao.setConditionTransContext("=", bean.getTransContext());
			count++;
		}
		if(bean.getTranstime() != null) {
			dao.setConditionTranstime(">=", bean.getTranstime());
			count++;
		}
		if(bean.getFlag() != null) {
			if(bean.getFlag().indexOf("%") >= 0)
				dao.setConditionFlag("like", bean.getFlag());
			else
				dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseClockSendCmd bean = new BaseClockSendCmd();
		bean.setDataFromJSON(json);
		ClockSendCmd dao = new ClockSendCmd();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseClockSendCmd> rlist = new BaseCollection<>();
		BaseClockSendCmd bean = new BaseClockSendCmd();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ClockSendCmd dao = new ClockSendCmd();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseClockSendCmd> result = dao.conditionalLoad(addtion);
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
		BaseClockSendCmd bean = new BaseClockSendCmd();
		bean.setDataFromJSON(json);
		ClockSendCmd dao = new ClockSendCmd();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseClockSendCmd bean = new BaseClockSendCmd();
		bean.setDataFromJSON(json);
		ClockSendCmd dao = new ClockSendCmd();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseClockSendCmd bean = new BaseClockSendCmd();
		bean.setDataFromJSON(json);
		ClockSendCmd dao = new ClockSendCmd();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseClockSendCmd bean = new BaseClockSendCmd();
		bean.setDataFromJSON(json);
		ClockSendCmd dao = new ClockSendCmd();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


