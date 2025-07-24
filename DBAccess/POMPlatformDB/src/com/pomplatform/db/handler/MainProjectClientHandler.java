package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProjectClient;
import com.pomplatform.db.dao.MainProjectClient;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class MainProjectClientHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectClientHandler.class);

	public static BaseMainProjectClient getMainProjectClientById( 
		java.lang.Integer main_project_id, 
		java.lang.Integer client_id
	) throws Exception
	{
		MainProjectClient dao = new MainProjectClient();
		dao.setMainProjectId(main_project_id);
		dao.setClientId(client_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectClientExists( com.pomplatform.db.bean.BaseMainProjectClient bean, String additional ) throws Exception {

		MainProjectClient dao = new MainProjectClient();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectClient( com.pomplatform.db.bean.BaseMainProjectClient bean, String additional ) throws Exception {

		MainProjectClient dao = new MainProjectClient();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectClient> queryMainProjectClient( com.pomplatform.db.bean.BaseMainProjectClient bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectClient dao = new MainProjectClient();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectClient> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectClient> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectClient addToMainProjectClient ( BaseMainProjectClient mainprojectclient )  throws Exception {
		return addToMainProjectClient ( mainprojectclient , false);
	}

	public static BaseMainProjectClient addToMainProjectClient ( BaseMainProjectClient mainprojectclient, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectClient dao = new MainProjectClient();
		dao.setDataFromBase(mainprojectclient);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectClient addUpdateMainProjectClient ( BaseMainProjectClient mainprojectclient ) throws Exception {
		return addUpdateMainProjectClient ( mainprojectclient , false);
	}

	public static BaseMainProjectClient addUpdateMainProjectClient ( BaseMainProjectClient mainprojectclient, boolean singleTransaction  ) throws Exception {
		if(mainprojectclient.getMainProjectId() == null) return addToMainProjectClient(mainprojectclient);
		if(mainprojectclient.getClientId() == null) return addToMainProjectClient(mainprojectclient);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectClient dao = new MainProjectClient();
		dao.setDataFromBase(mainprojectclient);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectclient); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectClient ( BaseMainProjectClient bean ) throws Exception {
		MainProjectClient dao = new MainProjectClient();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectClient updateMainProjectClient ( BaseMainProjectClient mainprojectclient ) throws Exception {
		MainProjectClient dao = new MainProjectClient();
		dao.setMainProjectId( mainprojectclient.getMainProjectId() );
		dao.setClientId( mainprojectclient.getClientId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectclient);
			result = dao.update();
		}
		return result == 1 ? mainprojectclient : null ;
	}

	public static BaseMainProjectClient updateMainProjectClientDirect( BaseMainProjectClient mainprojectclient ) throws Exception {
		MainProjectClient dao = new MainProjectClient();
		int result = 0;
		dao.setDataFromBase(mainprojectclient);
		result = dao.update();
		return result == 1 ? mainprojectclient : null ;
	}

	public static int setDeleteConditions(BaseMainProjectClient bean, MainProjectClient dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
			foundKey = true;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
		}
		return count;
	}

	public static int setConditions(BaseMainProjectClient bean, MainProjectClient dao){
		int count = 0;
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProjectClient bean = new BaseMainProjectClient();
		bean.setDataFromJSON(json);
		MainProjectClient dao = new MainProjectClient();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectClient> rlist = new BaseCollection<>();
		BaseMainProjectClient bean = new BaseMainProjectClient();
		bean.setDataFromJSON(json);
		MainProjectClient dao = new MainProjectClient();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectClient> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectClient bean = new BaseMainProjectClient();
		bean.setDataFromJSON(json);
		MainProjectClient dao = new MainProjectClient();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectClient bean = new BaseMainProjectClient();
		bean.setDataFromJSON(json);
		MainProjectClient dao = new MainProjectClient();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectClient bean = new BaseMainProjectClient();
		bean.setDataFromJSON(json);
		MainProjectClient dao = new MainProjectClient();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectClient bean = new BaseMainProjectClient();
		bean.setDataFromJSON(json);
		MainProjectClient dao = new MainProjectClient();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


