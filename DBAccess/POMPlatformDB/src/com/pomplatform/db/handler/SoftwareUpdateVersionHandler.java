package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSoftwareUpdateVersion;
import com.pomplatform.db.dao.SoftwareUpdateVersion;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SoftwareUpdateVersionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SoftwareUpdateVersionHandler.class);

	public static BaseSoftwareUpdateVersion getSoftwareUpdateVersionById( 
		java.lang.Integer software_update_version_id
	) throws Exception
	{
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setSoftwareUpdateVersionId(software_update_version_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSoftwareUpdateVersionExists( com.pomplatform.db.bean.BaseSoftwareUpdateVersion bean, String additional ) throws Exception {

		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSoftwareUpdateVersion( com.pomplatform.db.bean.BaseSoftwareUpdateVersion bean, String additional ) throws Exception {

		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSoftwareUpdateVersion> querySoftwareUpdateVersion( com.pomplatform.db.bean.BaseSoftwareUpdateVersion bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSoftwareUpdateVersion> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSoftwareUpdateVersion> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSoftwareUpdateVersion addToSoftwareUpdateVersion ( BaseSoftwareUpdateVersion softwareupdateversion )  throws Exception {
		return addToSoftwareUpdateVersion ( softwareupdateversion , false);
	}

	public static BaseSoftwareUpdateVersion addToSoftwareUpdateVersion ( BaseSoftwareUpdateVersion softwareupdateversion, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setDataFromBase(softwareupdateversion);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSoftwareUpdateVersion addUpdateSoftwareUpdateVersion ( BaseSoftwareUpdateVersion softwareupdateversion ) throws Exception {
		return addUpdateSoftwareUpdateVersion ( softwareupdateversion , false);
	}

	public static BaseSoftwareUpdateVersion addUpdateSoftwareUpdateVersion ( BaseSoftwareUpdateVersion softwareupdateversion, boolean singleTransaction  ) throws Exception {
		if(softwareupdateversion.getSoftwareUpdateVersionId() == null) return addToSoftwareUpdateVersion(softwareupdateversion);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setDataFromBase(softwareupdateversion);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(softwareupdateversion); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSoftwareUpdateVersion ( BaseSoftwareUpdateVersion bean ) throws Exception {
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSoftwareUpdateVersion updateSoftwareUpdateVersion ( BaseSoftwareUpdateVersion softwareupdateversion ) throws Exception {
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setSoftwareUpdateVersionId( softwareupdateversion.getSoftwareUpdateVersionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(softwareupdateversion);
			result = dao.update();
		}
		return result == 1 ? softwareupdateversion : null ;
	}

	public static BaseSoftwareUpdateVersion updateSoftwareUpdateVersionDirect( BaseSoftwareUpdateVersion softwareupdateversion ) throws Exception {
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		int result = 0;
		dao.setDataFromBase(softwareupdateversion);
		result = dao.update();
		return result == 1 ? softwareupdateversion : null ;
	}

	public static int setDeleteConditions(BaseSoftwareUpdateVersion bean, SoftwareUpdateVersion dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSoftwareUpdateVersionId() != null) {
			dao.setConditionSoftwareUpdateVersionId("=", bean.getSoftwareUpdateVersionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSoftwareType() != null) {
				dao.setConditionSoftwareType("=", bean.getSoftwareType());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getSqlScript() != null) {
				dao.setConditionSqlScript("=", bean.getSqlScript());
				count++;
			}
			if(bean.getIsReboot() != null) {
				dao.setConditionIsReboot("=", bean.getIsReboot());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSoftwareUpdateVersion bean, SoftwareUpdateVersion dao){
		int count = 0;
		if(bean.getSoftwareUpdateVersionId() != null) {
			dao.setConditionSoftwareUpdateVersionId("=", bean.getSoftwareUpdateVersionId());
			count++;
		}
		if(bean.getVersionNo() != null) {
			dao.setConditionVersionNo("=", bean.getVersionNo());
			count++;
		}
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getSoftwareType() != null) {
			dao.setConditionSoftwareType("=", bean.getSoftwareType());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getSqlScript() != null) {
			if(bean.getSqlScript().indexOf("%") >= 0)
				dao.setConditionSqlScript("like", bean.getSqlScript());
			else
				dao.setConditionSqlScript("=", bean.getSqlScript());
			count++;
		}
		if(bean.getIsReboot() != null) {
			dao.setConditionIsReboot("=", bean.getIsReboot());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSoftwareUpdateVersion bean = new BaseSoftwareUpdateVersion();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSoftwareUpdateVersion> rlist = new BaseCollection<>();
		BaseSoftwareUpdateVersion bean = new BaseSoftwareUpdateVersion();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSoftwareUpdateVersion> result = dao.conditionalLoad(addtion);
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
		BaseSoftwareUpdateVersion bean = new BaseSoftwareUpdateVersion();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSoftwareUpdateVersion bean = new BaseSoftwareUpdateVersion();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSoftwareUpdateVersion bean = new BaseSoftwareUpdateVersion();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSoftwareUpdateVersion bean = new BaseSoftwareUpdateVersion();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


