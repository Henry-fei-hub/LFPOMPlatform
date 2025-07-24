package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePreProjectRecord;
import com.pomplatform.db.dao.PreProjectRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PreProjectRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PreProjectRecordHandler.class);

	public static BasePreProjectRecord getPreProjectRecordById( 
		java.lang.Integer pre_project_record_id
	) throws Exception
	{
		PreProjectRecord dao = new PreProjectRecord();
		dao.setPreProjectRecordId(pre_project_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPreProjectRecordExists( com.pomplatform.db.bean.BasePreProjectRecord bean, String additional ) throws Exception {

		PreProjectRecord dao = new PreProjectRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPreProjectRecord( com.pomplatform.db.bean.BasePreProjectRecord bean, String additional ) throws Exception {

		PreProjectRecord dao = new PreProjectRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePreProjectRecord> queryPreProjectRecord( com.pomplatform.db.bean.BasePreProjectRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PreProjectRecord dao = new PreProjectRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePreProjectRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePreProjectRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePreProjectRecord addToPreProjectRecord ( BasePreProjectRecord preprojectrecord )  throws Exception {
		return addToPreProjectRecord ( preprojectrecord , false);
	}

	public static BasePreProjectRecord addToPreProjectRecord ( BasePreProjectRecord preprojectrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PreProjectRecord dao = new PreProjectRecord();
		dao.setDataFromBase(preprojectrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePreProjectRecord addUpdatePreProjectRecord ( BasePreProjectRecord preprojectrecord ) throws Exception {
		return addUpdatePreProjectRecord ( preprojectrecord , false);
	}

	public static BasePreProjectRecord addUpdatePreProjectRecord ( BasePreProjectRecord preprojectrecord, boolean singleTransaction  ) throws Exception {
		if(preprojectrecord.getPreProjectRecordId() == null) return addToPreProjectRecord(preprojectrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PreProjectRecord dao = new PreProjectRecord();
		dao.setDataFromBase(preprojectrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(preprojectrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePreProjectRecord ( BasePreProjectRecord bean ) throws Exception {
		PreProjectRecord dao = new PreProjectRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePreProjectRecord updatePreProjectRecord ( BasePreProjectRecord preprojectrecord ) throws Exception {
		PreProjectRecord dao = new PreProjectRecord();
		dao.setPreProjectRecordId( preprojectrecord.getPreProjectRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(preprojectrecord);
			result = dao.update();
		}
		return result == 1 ? preprojectrecord : null ;
	}

	public static BasePreProjectRecord updatePreProjectRecordDirect( BasePreProjectRecord preprojectrecord ) throws Exception {
		PreProjectRecord dao = new PreProjectRecord();
		int result = 0;
		dao.setDataFromBase(preprojectrecord);
		result = dao.update();
		return result == 1 ? preprojectrecord : null ;
	}

	public static int setDeleteConditions(BasePreProjectRecord bean, PreProjectRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPreProjectRecordId() != null) {
			dao.setConditionPreProjectRecordId("=", bean.getPreProjectRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getRelevantEmployees() != null) {
				dao.setConditionRelevantEmployees("=", bean.getRelevantEmployees());
				count++;
			}
			if(bean.getInformationType() != null) {
				dao.setConditionInformationType("=", bean.getInformationType());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getRegisterEmployee() != null) {
				dao.setConditionRegisterEmployee("=", bean.getRegisterEmployee());
				count++;
			}
			if(bean.getTrackCode() != null) {
				dao.setConditionTrackCode("=", bean.getTrackCode());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getFileName() != null) {
				dao.setConditionFileName("=", bean.getFileName());
				count++;
			}
			if(bean.getRelevantEmployeesDisplayValue() != null) {
				dao.setConditionRelevantEmployeesDisplayValue("=", bean.getRelevantEmployeesDisplayValue());
				count++;
			}
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getWinRate() != null) {
				dao.setConditionWinRate("=", bean.getWinRate());
				count++;
			}
			if(bean.getContractSignStatus() != null) {
				dao.setConditionContractSignStatus("=", bean.getContractSignStatus());
				count++;
			}
			if(bean.getDesignPrice() != null) {
				dao.setConditionDesignPrice("=", bean.getDesignPrice());
				count++;
			}
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePreProjectRecord bean, PreProjectRecord dao){
		int count = 0;
		if(bean.getPreProjectRecordId() != null) {
			dao.setConditionPreProjectRecordId("=", bean.getPreProjectRecordId());
			count++;
		}
		if(bean.getRelevantEmployees() != null) {
			if(bean.getRelevantEmployees().indexOf("%") >= 0)
				dao.setConditionRelevantEmployees("like", bean.getRelevantEmployees());
			else
				dao.setConditionRelevantEmployees("=", bean.getRelevantEmployees());
			count++;
		}
		if(bean.getTrackDate() != null) {
			dao.setConditionTrackDate(">=", bean.getTrackDate());
			count++;
		}
		if(bean.getInformationType() != null) {
			dao.setConditionInformationType("=", bean.getInformationType());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		if(bean.getRegisterEmployee() != null) {
			dao.setConditionRegisterEmployee("=", bean.getRegisterEmployee());
			count++;
		}
		if(bean.getRegisterDate() != null) {
			dao.setConditionRegisterDate(">=", bean.getRegisterDate());
			count++;
		}
		if(bean.getTrackCode() != null) {
			if(bean.getTrackCode().indexOf("%") >= 0)
				dao.setConditionTrackCode("like", bean.getTrackCode());
			else
				dao.setConditionTrackCode("=", bean.getTrackCode());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getFileName() != null) {
			if(bean.getFileName().indexOf("%") >= 0)
				dao.setConditionFileName("like", bean.getFileName());
			else
				dao.setConditionFileName("=", bean.getFileName());
			count++;
		}
		if(bean.getRelevantEmployeesDisplayValue() != null) {
			if(bean.getRelevantEmployeesDisplayValue().indexOf("%") >= 0)
				dao.setConditionRelevantEmployeesDisplayValue("like", bean.getRelevantEmployeesDisplayValue());
			else
				dao.setConditionRelevantEmployeesDisplayValue("=", bean.getRelevantEmployeesDisplayValue());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getWinRate() != null) {
			if(bean.getWinRate().indexOf("%") >= 0)
				dao.setConditionWinRate("like", bean.getWinRate());
			else
				dao.setConditionWinRate("=", bean.getWinRate());
			count++;
		}
		if(bean.getContractSignStatus() != null) {
			dao.setConditionContractSignStatus("=", bean.getContractSignStatus());
			count++;
		}
		if(bean.getContractAmount() != null) {
			dao.setConditionContractAmount("=", bean.getContractAmount());
			count++;
		}
		if(bean.getDesignPrice() != null) {
			if(bean.getDesignPrice().indexOf("%") >= 0)
				dao.setConditionDesignPrice("like", bean.getDesignPrice());
			else
				dao.setConditionDesignPrice("=", bean.getDesignPrice());
			count++;
		}
		if(bean.getAttachmentId() != null) {
			dao.setConditionAttachmentId("=", bean.getAttachmentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePreProjectRecord> rlist = new BaseCollection<>();
		BasePreProjectRecord bean = new BasePreProjectRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PreProjectRecord dao = new PreProjectRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePreProjectRecord> result = dao.conditionalLoad(addtion);
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
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


