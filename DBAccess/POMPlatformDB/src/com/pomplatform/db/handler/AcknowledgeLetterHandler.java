package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAcknowledgeLetter;
import com.pomplatform.db.dao.AcknowledgeLetter;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AcknowledgeLetterHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AcknowledgeLetterHandler.class);

	public static BaseAcknowledgeLetter getAcknowledgeLetterById( 
		java.lang.Integer acknowledge_letter_id
	) throws Exception
	{
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setAcknowledgeLetterId(acknowledge_letter_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAcknowledgeLetterExists( com.pomplatform.db.bean.BaseAcknowledgeLetter bean, String additional ) throws Exception {

		AcknowledgeLetter dao = new AcknowledgeLetter();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAcknowledgeLetter( com.pomplatform.db.bean.BaseAcknowledgeLetter bean, String additional ) throws Exception {

		AcknowledgeLetter dao = new AcknowledgeLetter();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAcknowledgeLetter> queryAcknowledgeLetter( com.pomplatform.db.bean.BaseAcknowledgeLetter bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AcknowledgeLetter dao = new AcknowledgeLetter();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAcknowledgeLetter> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAcknowledgeLetter> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAcknowledgeLetter addToAcknowledgeLetter ( BaseAcknowledgeLetter acknowledgeletter )  throws Exception {
		return addToAcknowledgeLetter ( acknowledgeletter , false);
	}

	public static BaseAcknowledgeLetter addToAcknowledgeLetter ( BaseAcknowledgeLetter acknowledgeletter, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setDataFromBase(acknowledgeletter);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAcknowledgeLetter addUpdateAcknowledgeLetter ( BaseAcknowledgeLetter acknowledgeletter ) throws Exception {
		return addUpdateAcknowledgeLetter ( acknowledgeletter , false);
	}

	public static BaseAcknowledgeLetter addUpdateAcknowledgeLetter ( BaseAcknowledgeLetter acknowledgeletter, boolean singleTransaction  ) throws Exception {
		if(acknowledgeletter.getAcknowledgeLetterId() == null) return addToAcknowledgeLetter(acknowledgeletter);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setDataFromBase(acknowledgeletter);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(acknowledgeletter); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAcknowledgeLetter ( BaseAcknowledgeLetter bean ) throws Exception {
		AcknowledgeLetter dao = new AcknowledgeLetter();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAcknowledgeLetter updateAcknowledgeLetter ( BaseAcknowledgeLetter acknowledgeletter ) throws Exception {
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setAcknowledgeLetterId( acknowledgeletter.getAcknowledgeLetterId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(acknowledgeletter);
			result = dao.update();
		}
		return result == 1 ? acknowledgeletter : null ;
	}

	public static BaseAcknowledgeLetter updateAcknowledgeLetterDirect( BaseAcknowledgeLetter acknowledgeletter ) throws Exception {
		AcknowledgeLetter dao = new AcknowledgeLetter();
		int result = 0;
		dao.setDataFromBase(acknowledgeletter);
		result = dao.update();
		return result == 1 ? acknowledgeletter : null ;
	}

	public static int setDeleteConditions(BaseAcknowledgeLetter bean, AcknowledgeLetter dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAcknowledgeLetterId() != null) {
			dao.setConditionAcknowledgeLetterId("=", bean.getAcknowledgeLetterId());
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
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getReceivableIds() != null) {
				dao.setConditionReceivableIds("=", bean.getReceivableIds());
				count++;
			}
			if(bean.getSignCompany() != null) {
				dao.setConditionSignCompany("=", bean.getSignCompany());
				count++;
			}
			if(bean.getSignatory() != null) {
				dao.setConditionSignatory("=", bean.getSignatory());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getAcknowledgeLetterFile() != null) {
				dao.setConditionAcknowledgeLetterFile("=", bean.getAcknowledgeLetterFile());
				count++;
			}
			if(bean.getHasInvoices() != null) {
				dao.setConditionHasInvoices("=", bean.getHasInvoices());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAcknowledgeLetter bean, AcknowledgeLetter dao){
		int count = 0;
		if(bean.getAcknowledgeLetterId() != null) {
			dao.setConditionAcknowledgeLetterId("=", bean.getAcknowledgeLetterId());
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
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getReceivableIds() != null) {
			if(bean.getReceivableIds().indexOf("%") >= 0)
				dao.setConditionReceivableIds("like", bean.getReceivableIds());
			else
				dao.setConditionReceivableIds("=", bean.getReceivableIds());
			count++;
		}
		if(bean.getSignCompany() != null) {
			dao.setConditionSignCompany("=", bean.getSignCompany());
			count++;
		}
		if(bean.getSignatory() != null) {
			if(bean.getSignatory().indexOf("%") >= 0)
				dao.setConditionSignatory("like", bean.getSignatory());
			else
				dao.setConditionSignatory("=", bean.getSignatory());
			count++;
		}
		if(bean.getSignDate() != null) {
			dao.setConditionSignDate(">=", bean.getSignDate());
			count++;
		}
		if(bean.getRegistrationDate() != null) {
			dao.setConditionRegistrationDate(">=", bean.getRegistrationDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getAcknowledgeLetterFile() != null) {
			if(bean.getAcknowledgeLetterFile().indexOf("%") >= 0)
				dao.setConditionAcknowledgeLetterFile("like", bean.getAcknowledgeLetterFile());
			else
				dao.setConditionAcknowledgeLetterFile("=", bean.getAcknowledgeLetterFile());
			count++;
		}
		if(bean.getHasInvoices() != null) {
			dao.setConditionHasInvoices("=", bean.getHasInvoices());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAcknowledgeLetter bean = new BaseAcknowledgeLetter();
		bean.setDataFromJSON(json);
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAcknowledgeLetter> rlist = new BaseCollection<>();
		BaseAcknowledgeLetter bean = new BaseAcknowledgeLetter();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AcknowledgeLetter dao = new AcknowledgeLetter();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAcknowledgeLetter> result = dao.conditionalLoad(addtion);
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
		BaseAcknowledgeLetter bean = new BaseAcknowledgeLetter();
		bean.setDataFromJSON(json);
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAcknowledgeLetter bean = new BaseAcknowledgeLetter();
		bean.setDataFromJSON(json);
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAcknowledgeLetter bean = new BaseAcknowledgeLetter();
		bean.setDataFromJSON(json);
		AcknowledgeLetter dao = new AcknowledgeLetter();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAcknowledgeLetter bean = new BaseAcknowledgeLetter();
		bean.setDataFromJSON(json);
		AcknowledgeLetter dao = new AcknowledgeLetter();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


