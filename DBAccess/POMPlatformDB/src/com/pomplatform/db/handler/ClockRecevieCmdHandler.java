package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClockRecevieCmd;
import com.pomplatform.db.dao.ClockRecevieCmd;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ClockRecevieCmdHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ClockRecevieCmdHandler.class);

	public static BaseClockRecevieCmd getClockRecevieCmdById( 
		java.lang.Integer clock_recevie_cmd_id
	) throws Exception
	{
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setClockRecevieCmdId(clock_recevie_cmd_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isClockRecevieCmdExists( com.pomplatform.db.bean.BaseClockRecevieCmd bean, String additional ) throws Exception {

		ClockRecevieCmd dao = new ClockRecevieCmd();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countClockRecevieCmd( com.pomplatform.db.bean.BaseClockRecevieCmd bean, String additional ) throws Exception {

		ClockRecevieCmd dao = new ClockRecevieCmd();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseClockRecevieCmd> queryClockRecevieCmd( com.pomplatform.db.bean.BaseClockRecevieCmd bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ClockRecevieCmd dao = new ClockRecevieCmd();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseClockRecevieCmd> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseClockRecevieCmd> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseClockRecevieCmd addToClockRecevieCmd ( BaseClockRecevieCmd clockreceviecmd )  throws Exception {
		return addToClockRecevieCmd ( clockreceviecmd , false);
	}

	public static BaseClockRecevieCmd addToClockRecevieCmd ( BaseClockRecevieCmd clockreceviecmd, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setDataFromBase(clockreceviecmd);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseClockRecevieCmd addUpdateClockRecevieCmd ( BaseClockRecevieCmd clockreceviecmd ) throws Exception {
		return addUpdateClockRecevieCmd ( clockreceviecmd , false);
	}

	public static BaseClockRecevieCmd addUpdateClockRecevieCmd ( BaseClockRecevieCmd clockreceviecmd, boolean singleTransaction  ) throws Exception {
		if(clockreceviecmd.getClockRecevieCmdId() == null) return addToClockRecevieCmd(clockreceviecmd);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setDataFromBase(clockreceviecmd);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(clockreceviecmd); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteClockRecevieCmd ( BaseClockRecevieCmd bean ) throws Exception {
		ClockRecevieCmd dao = new ClockRecevieCmd();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseClockRecevieCmd updateClockRecevieCmd ( BaseClockRecevieCmd clockreceviecmd ) throws Exception {
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setClockRecevieCmdId( clockreceviecmd.getClockRecevieCmdId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(clockreceviecmd);
			result = dao.update();
		}
		return result == 1 ? clockreceviecmd : null ;
	}

	public static BaseClockRecevieCmd updateClockRecevieCmdDirect( BaseClockRecevieCmd clockreceviecmd ) throws Exception {
		ClockRecevieCmd dao = new ClockRecevieCmd();
		int result = 0;
		dao.setDataFromBase(clockreceviecmd);
		result = dao.update();
		return result == 1 ? clockreceviecmd : null ;
	}

	public static int setDeleteConditions(BaseClockRecevieCmd bean, ClockRecevieCmd dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getClockRecevieCmdId() != null) {
			dao.setConditionClockRecevieCmdId("=", bean.getClockRecevieCmdId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSn() != null) {
				dao.setConditionSn("=", bean.getSn());
				count++;
			}
			if(bean.getCmdContent() != null) {
				dao.setConditionCmdContent("=", bean.getCmdContent());
				count++;
			}
			if(bean.getCmdReturn() != null) {
				dao.setConditionCmdReturn("=", bean.getCmdReturn());
				count++;
			}
			if(bean.getProcessCount() != null) {
				dao.setConditionProcessCount("=", bean.getProcessCount());
				count++;
			}
			if(bean.getSuccessFlag() != null) {
				dao.setConditionSuccessFlag("=", bean.getSuccessFlag());
				count++;
			}
			if(bean.getReceiveData() != null) {
				dao.setConditionReceiveData("=", bean.getReceiveData());
				count++;
			}
			if(bean.getCmdType() != null) {
				dao.setConditionCmdType("=", bean.getCmdType());
				count++;
			}
			if(bean.getCmdSystem() != null) {
				dao.setConditionCmdSystem("=", bean.getCmdSystem());
				count++;
			}
			if(bean.getUpdateDb() != null) {
				dao.setConditionUpdateDb("=", bean.getUpdateDb());
				count++;
			}
			if(bean.getUserId() != null) {
				dao.setConditionUserId("=", bean.getUserId());
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
		}
		return count;
	}

	public static int setConditions(BaseClockRecevieCmd bean, ClockRecevieCmd dao){
		int count = 0;
		if(bean.getClockRecevieCmdId() != null) {
			dao.setConditionClockRecevieCmdId("=", bean.getClockRecevieCmdId());
			count++;
		}
		if(bean.getSn() != null) {
			if(bean.getSn().indexOf("%") >= 0)
				dao.setConditionSn("like", bean.getSn());
			else
				dao.setConditionSn("=", bean.getSn());
			count++;
		}
		if(bean.getCmdContent() != null) {
			if(bean.getCmdContent().indexOf("%") >= 0)
				dao.setConditionCmdContent("like", bean.getCmdContent());
			else
				dao.setConditionCmdContent("=", bean.getCmdContent());
			count++;
		}
		if(bean.getCmdCommitTime() != null) {
			dao.setConditionCmdCommitTime(">=", bean.getCmdCommitTime());
			count++;
		}
		if(bean.getCmdTransTime() != null) {
			dao.setConditionCmdTransTime(">=", bean.getCmdTransTime());
			count++;
		}
		if(bean.getCmdReturn() != null) {
			dao.setConditionCmdReturn("=", bean.getCmdReturn());
			count++;
		}
		if(bean.getProcessCount() != null) {
			dao.setConditionProcessCount("=", bean.getProcessCount());
			count++;
		}
		if(bean.getSuccessFlag() != null) {
			dao.setConditionSuccessFlag("=", bean.getSuccessFlag());
			count++;
		}
		if(bean.getReceiveData() != null) {
			if(bean.getReceiveData().indexOf("%") >= 0)
				dao.setConditionReceiveData("like", bean.getReceiveData());
			else
				dao.setConditionReceiveData("=", bean.getReceiveData());
			count++;
		}
		if(bean.getCmdType() != null) {
			dao.setConditionCmdType("=", bean.getCmdType());
			count++;
		}
		if(bean.getCmdSystem() != null) {
			dao.setConditionCmdSystem("=", bean.getCmdSystem());
			count++;
		}
		if(bean.getCmdOverTime() != null) {
			dao.setConditionCmdOverTime(">=", bean.getCmdOverTime());
			count++;
		}
		if(bean.getUpdateDb() != null) {
			if(bean.getUpdateDb().indexOf("%") >= 0)
				dao.setConditionUpdateDb("like", bean.getUpdateDb());
			else
				dao.setConditionUpdateDb("=", bean.getUpdateDb());
			count++;
		}
		if(bean.getUserId() != null) {
			dao.setConditionUserId("=", bean.getUserId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		bean.setDataFromJSON(json);
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseClockRecevieCmd> rlist = new BaseCollection<>();
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ClockRecevieCmd dao = new ClockRecevieCmd();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseClockRecevieCmd> result = dao.conditionalLoad(addtion);
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
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		bean.setDataFromJSON(json);
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		bean.setDataFromJSON(json);
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		bean.setDataFromJSON(json);
		ClockRecevieCmd dao = new ClockRecevieCmd();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseClockRecevieCmd bean = new BaseClockRecevieCmd();
		bean.setDataFromJSON(json);
		ClockRecevieCmd dao = new ClockRecevieCmd();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


