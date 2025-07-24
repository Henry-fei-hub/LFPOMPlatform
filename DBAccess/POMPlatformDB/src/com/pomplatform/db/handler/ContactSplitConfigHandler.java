package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContactSplitConfig;
import com.pomplatform.db.dao.ContactSplitConfig;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContactSplitConfigHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContactSplitConfigHandler.class);

	public static BaseContactSplitConfig getContactSplitConfigById( 
		java.lang.Integer contact_split_config_id
	) throws Exception
	{
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setContactSplitConfigId(contact_split_config_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContactSplitConfigExists( com.pomplatform.db.bean.BaseContactSplitConfig bean, String additional ) throws Exception {

		ContactSplitConfig dao = new ContactSplitConfig();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContactSplitConfig( com.pomplatform.db.bean.BaseContactSplitConfig bean, String additional ) throws Exception {

		ContactSplitConfig dao = new ContactSplitConfig();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContactSplitConfig> queryContactSplitConfig( com.pomplatform.db.bean.BaseContactSplitConfig bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContactSplitConfig dao = new ContactSplitConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContactSplitConfig> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContactSplitConfig> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContactSplitConfig addToContactSplitConfig ( BaseContactSplitConfig contactsplitconfig )  throws Exception {
		return addToContactSplitConfig ( contactsplitconfig , false);
	}

	public static BaseContactSplitConfig addToContactSplitConfig ( BaseContactSplitConfig contactsplitconfig, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setDataFromBase(contactsplitconfig);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContactSplitConfig addUpdateContactSplitConfig ( BaseContactSplitConfig contactsplitconfig ) throws Exception {
		return addUpdateContactSplitConfig ( contactsplitconfig , false);
	}

	public static BaseContactSplitConfig addUpdateContactSplitConfig ( BaseContactSplitConfig contactsplitconfig, boolean singleTransaction  ) throws Exception {
		if(contactsplitconfig.getContactSplitConfigId() == null) return addToContactSplitConfig(contactsplitconfig);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setDataFromBase(contactsplitconfig);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contactsplitconfig); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContactSplitConfig ( BaseContactSplitConfig bean ) throws Exception {
		ContactSplitConfig dao = new ContactSplitConfig();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContactSplitConfig updateContactSplitConfig ( BaseContactSplitConfig contactsplitconfig ) throws Exception {
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setContactSplitConfigId( contactsplitconfig.getContactSplitConfigId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contactsplitconfig);
			result = dao.update();
		}
		return result == 1 ? contactsplitconfig : null ;
	}

	public static BaseContactSplitConfig updateContactSplitConfigDirect( BaseContactSplitConfig contactsplitconfig ) throws Exception {
		ContactSplitConfig dao = new ContactSplitConfig();
		int result = 0;
		dao.setDataFromBase(contactsplitconfig);
		result = dao.update();
		return result == 1 ? contactsplitconfig : null ;
	}

	public static int setDeleteConditions(BaseContactSplitConfig bean, ContactSplitConfig dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContactSplitConfigId() != null) {
			dao.setConditionContactSplitConfigId("=", bean.getContactSplitConfigId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContactSplitConfig bean, ContactSplitConfig dao){
		int count = 0;
		if(bean.getContactSplitConfigId() != null) {
			dao.setConditionContactSplitConfigId("=", bean.getContactSplitConfigId());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getProgramme() != null) {
			dao.setConditionProgramme("=", bean.getProgramme());
			count++;
		}
		if(bean.getDeepen() != null) {
			dao.setConditionDeepen("=", bean.getDeepen());
			count++;
		}
		if(bean.getElectromechanical() != null) {
			dao.setConditionElectromechanical("=", bean.getElectromechanical());
			count++;
		}
		if(bean.getLighting() != null) {
			dao.setConditionLighting("=", bean.getLighting());
			count++;
		}
		if(bean.getService() != null) {
			dao.setConditionService("=", bean.getService());
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
		BaseContactSplitConfig bean = new BaseContactSplitConfig();
		bean.setDataFromJSON(json);
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContactSplitConfig> rlist = new BaseCollection<>();
		BaseContactSplitConfig bean = new BaseContactSplitConfig();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContactSplitConfig dao = new ContactSplitConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContactSplitConfig> result = dao.conditionalLoad(addtion);
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
		BaseContactSplitConfig bean = new BaseContactSplitConfig();
		bean.setDataFromJSON(json);
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContactSplitConfig bean = new BaseContactSplitConfig();
		bean.setDataFromJSON(json);
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContactSplitConfig bean = new BaseContactSplitConfig();
		bean.setDataFromJSON(json);
		ContactSplitConfig dao = new ContactSplitConfig();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContactSplitConfig bean = new BaseContactSplitConfig();
		bean.setDataFromJSON(json);
		ContactSplitConfig dao = new ContactSplitConfig();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


