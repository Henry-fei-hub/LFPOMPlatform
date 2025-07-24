package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateRecordHandler.class);

	public static BasePlateRecord getPlateRecordById( 
		java.lang.Integer plate_record_id
	) throws Exception
	{
		PlateRecord dao = new PlateRecord();
		dao.setPlateRecordId(plate_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateRecordExists( com.pomplatform.db.bean.BasePlateRecord bean, String additional ) throws Exception {

		PlateRecord dao = new PlateRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateRecord( com.pomplatform.db.bean.BasePlateRecord bean, String additional ) throws Exception {

		PlateRecord dao = new PlateRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateRecord> queryPlateRecord( com.pomplatform.db.bean.BasePlateRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateRecord dao = new PlateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateRecord addToPlateRecord ( BasePlateRecord platerecord )  throws Exception {
		return addToPlateRecord ( platerecord , false);
	}

	public static BasePlateRecord addToPlateRecord ( BasePlateRecord platerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateRecord dao = new PlateRecord();
		dao.setDataFromBase(platerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateRecord addUpdatePlateRecord ( BasePlateRecord platerecord ) throws Exception {
		return addUpdatePlateRecord ( platerecord , false);
	}

	public static BasePlateRecord addUpdatePlateRecord ( BasePlateRecord platerecord, boolean singleTransaction  ) throws Exception {
		if(platerecord.getPlateRecordId() == null) return addToPlateRecord(platerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateRecord dao = new PlateRecord();
		dao.setDataFromBase(platerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateRecord ( BasePlateRecord bean ) throws Exception {
		PlateRecord dao = new PlateRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateRecord updatePlateRecord ( BasePlateRecord platerecord ) throws Exception {
		PlateRecord dao = new PlateRecord();
		dao.setPlateRecordId( platerecord.getPlateRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platerecord);
			result = dao.update();
		}
		return result == 1 ? platerecord : null ;
	}

	public static BasePlateRecord updatePlateRecordDirect( BasePlateRecord platerecord ) throws Exception {
		PlateRecord dao = new PlateRecord();
		int result = 0;
		dao.setDataFromBase(platerecord);
		result = dao.update();
		return result == 1 ? platerecord : null ;
	}

	public static int setDeleteConditions(BasePlateRecord bean, PlateRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateRecordId() != null) {
			dao.setConditionPlateRecordId("=", bean.getPlateRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getPlateCode() != null) {
				dao.setConditionPlateCode("=", bean.getPlateCode());
				count++;
			}
			if(bean.getPlateName() != null) {
				dao.setConditionPlateName("=", bean.getPlateName());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getPlateType() != null) {
				dao.setConditionPlateType("=", bean.getPlateType());
				count++;
			}
			if(bean.getPlateManagerId() != null) {
				dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
				count++;
			}
			if(bean.getHrCode() != null) {
				dao.setConditionHrCode("=", bean.getHrCode());
				count++;
			}
			if(bean.getPlateVoucherType() != null) {
				dao.setConditionPlateVoucherType("=", bean.getPlateVoucherType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateRecord bean, PlateRecord dao){
		int count = 0;
		if(bean.getPlateRecordId() != null) {
			dao.setConditionPlateRecordId("=", bean.getPlateRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getPlateCode() != null) {
			if(bean.getPlateCode().indexOf("%") >= 0)
				dao.setConditionPlateCode("like", bean.getPlateCode());
			else
				dao.setConditionPlateCode("=", bean.getPlateCode());
			count++;
		}
		if(bean.getPlateName() != null) {
			if(bean.getPlateName().indexOf("%") >= 0)
				dao.setConditionPlateName("like", bean.getPlateName());
			else
				dao.setConditionPlateName("=", bean.getPlateName());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getPlateType() != null) {
			dao.setConditionPlateType("=", bean.getPlateType());
			count++;
		}
		if(bean.getPlateManagerId() != null) {
			dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
			count++;
		}
		if(bean.getHrCode() != null) {
			if(bean.getHrCode().indexOf("%") >= 0)
				dao.setConditionHrCode("like", bean.getHrCode());
			else
				dao.setConditionHrCode("=", bean.getHrCode());
			count++;
		}
		if(bean.getPlateVoucherType() != null) {
			dao.setConditionPlateVoucherType("=", bean.getPlateVoucherType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateRecord> rlist = new BaseCollection<>();
		BasePlateRecord bean = new BasePlateRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateRecord dao = new PlateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


