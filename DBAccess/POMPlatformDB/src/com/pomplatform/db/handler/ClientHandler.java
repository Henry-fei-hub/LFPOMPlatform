package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClient;
import com.pomplatform.db.dao.Client;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ClientHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ClientHandler.class);

	public static BaseClient getClientById( 
		java.lang.Integer client_id
	) throws Exception
	{
		Client dao = new Client();
		dao.setClientId(client_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isClientExists( com.pomplatform.db.bean.BaseClient bean, String additional ) throws Exception {

		Client dao = new Client();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countClient( com.pomplatform.db.bean.BaseClient bean, String additional ) throws Exception {

		Client dao = new Client();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseClient> queryClient( com.pomplatform.db.bean.BaseClient bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Client dao = new Client();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseClient> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseClient> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseClient addToClient ( BaseClient client )  throws Exception {
		return addToClient ( client , false);
	}

	public static BaseClient addToClient ( BaseClient client, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Client dao = new Client();
		dao.setDataFromBase(client);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseClient addUpdateClient ( BaseClient client ) throws Exception {
		return addUpdateClient ( client , false);
	}

	public static BaseClient addUpdateClient ( BaseClient client, boolean singleTransaction  ) throws Exception {
		if(client.getClientId() == null) return addToClient(client);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Client dao = new Client();
		dao.setDataFromBase(client);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(client); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteClient ( BaseClient bean ) throws Exception {
		Client dao = new Client();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseClient updateClient ( BaseClient client ) throws Exception {
		Client dao = new Client();
		dao.setClientId( client.getClientId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(client);
			result = dao.update();
		}
		return result == 1 ? client : null ;
	}

	public static BaseClient updateClientDirect( BaseClient client ) throws Exception {
		Client dao = new Client();
		int result = 0;
		dao.setDataFromBase(client);
		result = dao.update();
		return result == 1 ? client : null ;
	}

	public static int setDeleteConditions(BaseClient bean, Client dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getClientName() != null) {
				dao.setConditionClientName("=", bean.getClientName());
				count++;
			}
			if(bean.getClientPhone() != null) {
				dao.setConditionClientPhone("=", bean.getClientPhone());
				count++;
			}
			if(bean.getClientCompany() != null) {
				dao.setConditionClientCompany("=", bean.getClientCompany());
				count++;
			}
			if(bean.getClientAddress() != null) {
				dao.setConditionClientAddress("=", bean.getClientAddress());
				count++;
			}
			if(bean.getClientJob() != null) {
				dao.setConditionClientJob("=", bean.getClientJob());
				count++;
			}
			if(bean.getClientWeixin() != null) {
				dao.setConditionClientWeixin("=", bean.getClientWeixin());
				count++;
			}
			if(bean.getClientQq() != null) {
				dao.setConditionClientQq("=", bean.getClientQq());
				count++;
			}
			if(bean.getClientEmail() != null) {
				dao.setConditionClientEmail("=", bean.getClientEmail());
				count++;
			}
			if(bean.getClientRole() != null) {
				dao.setConditionClientRole("=", bean.getClientRole());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseClient bean, Client dao){
		int count = 0;
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
		}
		if(bean.getClientName() != null) {
			if(bean.getClientName().indexOf("%") >= 0)
				dao.setConditionClientName("like", bean.getClientName());
			else
				dao.setConditionClientName("=", bean.getClientName());
			count++;
		}
		if(bean.getClientPhone() != null) {
			if(bean.getClientPhone().indexOf("%") >= 0)
				dao.setConditionClientPhone("like", bean.getClientPhone());
			else
				dao.setConditionClientPhone("=", bean.getClientPhone());
			count++;
		}
		if(bean.getClientCompany() != null) {
			if(bean.getClientCompany().indexOf("%") >= 0)
				dao.setConditionClientCompany("like", bean.getClientCompany());
			else
				dao.setConditionClientCompany("=", bean.getClientCompany());
			count++;
		}
		if(bean.getClientAddress() != null) {
			if(bean.getClientAddress().indexOf("%") >= 0)
				dao.setConditionClientAddress("like", bean.getClientAddress());
			else
				dao.setConditionClientAddress("=", bean.getClientAddress());
			count++;
		}
		if(bean.getClientJob() != null) {
			if(bean.getClientJob().indexOf("%") >= 0)
				dao.setConditionClientJob("like", bean.getClientJob());
			else
				dao.setConditionClientJob("=", bean.getClientJob());
			count++;
		}
		if(bean.getClientWeixin() != null) {
			if(bean.getClientWeixin().indexOf("%") >= 0)
				dao.setConditionClientWeixin("like", bean.getClientWeixin());
			else
				dao.setConditionClientWeixin("=", bean.getClientWeixin());
			count++;
		}
		if(bean.getClientQq() != null) {
			if(bean.getClientQq().indexOf("%") >= 0)
				dao.setConditionClientQq("like", bean.getClientQq());
			else
				dao.setConditionClientQq("=", bean.getClientQq());
			count++;
		}
		if(bean.getClientEmail() != null) {
			if(bean.getClientEmail().indexOf("%") >= 0)
				dao.setConditionClientEmail("like", bean.getClientEmail());
			else
				dao.setConditionClientEmail("=", bean.getClientEmail());
			count++;
		}
		if(bean.getClientRole() != null) {
			dao.setConditionClientRole("=", bean.getClientRole());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseClient> rlist = new BaseCollection<>();
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseClient> result = dao.conditionalLoad(addtion);
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
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


