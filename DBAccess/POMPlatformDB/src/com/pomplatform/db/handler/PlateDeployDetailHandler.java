package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BasePlateDeployDetail;
import java.util.List;
import com.pomplatform.db.dao.PlateDeployDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class PlateDeployDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateDeployDetailHandler.class);

	public static BasePlateDeployDetail getPlateDeployDetailById( 
		java.lang.Integer plate_deploy_detail_id
	) throws Exception
	{
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setPlateDeployDetailId(plate_deploy_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateDeployDetailExists( com.pomplatform.db.bean.BasePlateDeployDetail bean, String additional ) throws Exception {

		PlateDeployDetail dao = new PlateDeployDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateDeployDetail( com.pomplatform.db.bean.BasePlateDeployDetail bean, String additional ) throws Exception {

		PlateDeployDetail dao = new PlateDeployDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateDeployDetail> queryPlateDeployDetail( com.pomplatform.db.bean.BasePlateDeployDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateDeployDetail dao = new PlateDeployDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateDeployDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateDeployDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateDeployDetail addToPlateDeployDetail ( BasePlateDeployDetail platedeploydetail )  throws Exception {
		return addToPlateDeployDetail ( platedeploydetail , false);
	}

	public static BasePlateDeployDetail addToPlateDeployDetail ( BasePlateDeployDetail platedeploydetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setDataFromBase(platedeploydetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateDeployDetail addUpdatePlateDeployDetail ( BasePlateDeployDetail platedeploydetail ) throws Exception {
		return addUpdatePlateDeployDetail ( platedeploydetail , false);
	}

	public static BasePlateDeployDetail addUpdatePlateDeployDetail ( BasePlateDeployDetail platedeploydetail, boolean singleTransaction  ) throws Exception {
		if(platedeploydetail.getPlateDeployDetailId() == null) return addToPlateDeployDetail(platedeploydetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setDataFromBase(platedeploydetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platedeploydetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateDeployDetail ( BasePlateDeployDetail bean ) throws Exception {
		PlateDeployDetail dao = new PlateDeployDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateDeployDetail updatePlateDeployDetail ( BasePlateDeployDetail platedeploydetail ) throws Exception {
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setPlateDeployDetailId( platedeploydetail.getPlateDeployDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platedeploydetail);
			result = dao.update();
		}
		return result == 1 ? platedeploydetail : null ;
	}

	public static BasePlateDeployDetail updatePlateDeployDetailDirect( BasePlateDeployDetail platedeploydetail ) throws Exception {
		PlateDeployDetail dao = new PlateDeployDetail();
		int result = 0;
		dao.setDataFromBase(platedeploydetail);
		result = dao.update();
		return result == 1 ? platedeploydetail : null ;
	}

	public static int setDeleteConditions(BasePlateDeployDetail bean, PlateDeployDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateDeployDetailId() != null) {
			dao.setConditionPlateDeployDetailId("=", bean.getPlateDeployDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateDeployRecordId() != null) {
				dao.setConditionPlateDeployRecordId("=", bean.getPlateDeployRecordId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateDeployDetail bean, PlateDeployDetail dao){
		int count = 0;
		if(bean.getPlateDeployDetailId() != null) {
			dao.setConditionPlateDeployDetailId("=", bean.getPlateDeployDetailId());
			count++;
		}
		if(bean.getPlateDeployRecordId() != null) {
			dao.setConditionPlateDeployRecordId("=", bean.getPlateDeployRecordId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getAdvanceIntegral() != null) {
			dao.setConditionAdvanceIntegral("=", bean.getAdvanceIntegral());
			count++;
		}
		if(bean.getAdvanceDate() != null) {
			dao.setConditionAdvanceDate(">=", bean.getAdvanceDate());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
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
		BasePlateDeployDetail bean = new BasePlateDeployDetail();
		bean.setDataFromJSON(json);
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateDeployDetail> rlist = new BaseCollection<>();
		BasePlateDeployDetail bean = new BasePlateDeployDetail();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateDeployDetail dao = new PlateDeployDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateDeployDetail> result = dao.conditionalLoad(addtion);
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
		BasePlateDeployDetail bean = new BasePlateDeployDetail();
		bean.setDataFromJSON(json);
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateDeployDetail bean = new BasePlateDeployDetail();
		bean.setDataFromJSON(json);
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateDeployDetail bean = new BasePlateDeployDetail();
		bean.setDataFromJSON(json);
		PlateDeployDetail dao = new PlateDeployDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateDeployDetail bean = new BasePlateDeployDetail();
		bean.setDataFromJSON(json);
		PlateDeployDetail dao = new PlateDeployDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


