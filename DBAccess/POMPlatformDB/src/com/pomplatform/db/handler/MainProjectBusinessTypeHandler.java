package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import java.util.List;
import com.pomplatform.db.dao.MainProjectBusinessType;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MainProjectBusinessTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectBusinessTypeHandler.class);

	public static BaseMainProjectBusinessType getMainProjectBusinessTypeById( 
		java.lang.Integer main_project_business_type_id
	) throws Exception
	{
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setMainProjectBusinessTypeId(main_project_business_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectBusinessTypeExists( com.pomplatform.db.bean.BaseMainProjectBusinessType bean, String additional ) throws Exception {

		MainProjectBusinessType dao = new MainProjectBusinessType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectBusinessType( com.pomplatform.db.bean.BaseMainProjectBusinessType bean, String additional ) throws Exception {

		MainProjectBusinessType dao = new MainProjectBusinessType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectBusinessType> queryMainProjectBusinessType( com.pomplatform.db.bean.BaseMainProjectBusinessType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectBusinessType dao = new MainProjectBusinessType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectBusinessType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectBusinessType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectBusinessType addToMainProjectBusinessType ( BaseMainProjectBusinessType mainprojectbusinesstype )  throws Exception {
		return addToMainProjectBusinessType ( mainprojectbusinesstype , false);
	}

	public static BaseMainProjectBusinessType addToMainProjectBusinessType ( BaseMainProjectBusinessType mainprojectbusinesstype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setDataFromBase(mainprojectbusinesstype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectBusinessType addUpdateMainProjectBusinessType ( BaseMainProjectBusinessType mainprojectbusinesstype ) throws Exception {
		return addUpdateMainProjectBusinessType ( mainprojectbusinesstype , false);
	}

	public static BaseMainProjectBusinessType addUpdateMainProjectBusinessType ( BaseMainProjectBusinessType mainprojectbusinesstype, boolean singleTransaction  ) throws Exception {
		if(mainprojectbusinesstype.getMainProjectBusinessTypeId() == null) return addToMainProjectBusinessType(mainprojectbusinesstype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setDataFromBase(mainprojectbusinesstype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectbusinesstype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectBusinessType ( BaseMainProjectBusinessType bean ) throws Exception {
		MainProjectBusinessType dao = new MainProjectBusinessType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectBusinessType updateMainProjectBusinessType ( BaseMainProjectBusinessType mainprojectbusinesstype ) throws Exception {
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setMainProjectBusinessTypeId( mainprojectbusinesstype.getMainProjectBusinessTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectbusinesstype);
			result = dao.update();
		}
		return result == 1 ? mainprojectbusinesstype : null ;
	}

	public static BaseMainProjectBusinessType updateMainProjectBusinessTypeDirect( BaseMainProjectBusinessType mainprojectbusinesstype ) throws Exception {
		MainProjectBusinessType dao = new MainProjectBusinessType();
		int result = 0;
		dao.setDataFromBase(mainprojectbusinesstype);
		result = dao.update();
		return result == 1 ? mainprojectbusinesstype : null ;
	}

	public static int setDeleteConditions(BaseMainProjectBusinessType bean, MainProjectBusinessType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectBusinessTypeId() != null) {
			dao.setConditionMainProjectBusinessTypeId("=", bean.getMainProjectBusinessTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getOutQuotationId() != null) {
				dao.setConditionOutQuotationId("=", bean.getOutQuotationId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectBusinessType bean, MainProjectBusinessType dao){
		int count = 0;
		if(bean.getMainProjectBusinessTypeId() != null) {
			dao.setConditionMainProjectBusinessTypeId("=", bean.getMainProjectBusinessTypeId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getArea() != null) {
			dao.setConditionArea("=", bean.getArea());
			count++;
		}
		if(bean.getOutputValue() != null) {
			dao.setConditionOutputValue("=", bean.getOutputValue());
			count++;
		}
		if(bean.getOutQuotationId() != null) {
			dao.setConditionOutQuotationId("=", bean.getOutQuotationId());
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
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		bean.setDataFromJSON(json);
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectBusinessType> rlist = new BaseCollection<>();
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectBusinessType dao = new MainProjectBusinessType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectBusinessType> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		bean.setDataFromJSON(json);
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		bean.setDataFromJSON(json);
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		bean.setDataFromJSON(json);
		MainProjectBusinessType dao = new MainProjectBusinessType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		bean.setDataFromJSON(json);
		MainProjectBusinessType dao = new MainProjectBusinessType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


