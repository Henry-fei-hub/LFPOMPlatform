package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseGoodsReceiveDetail;
import com.pomplatform.db.dao.GoodsReceiveDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class GoodsReceiveDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(GoodsReceiveDetailHandler.class);

	public static BaseGoodsReceiveDetail getGoodsReceiveDetailById( 
		java.lang.Integer goods_receive_detail_id
	) throws Exception
	{
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setGoodsReceiveDetailId(goods_receive_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isGoodsReceiveDetailExists( com.pomplatform.db.bean.BaseGoodsReceiveDetail bean, String additional ) throws Exception {

		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countGoodsReceiveDetail( com.pomplatform.db.bean.BaseGoodsReceiveDetail bean, String additional ) throws Exception {

		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseGoodsReceiveDetail> queryGoodsReceiveDetail( com.pomplatform.db.bean.BaseGoodsReceiveDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseGoodsReceiveDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseGoodsReceiveDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseGoodsReceiveDetail addToGoodsReceiveDetail ( BaseGoodsReceiveDetail goodsreceivedetail )  throws Exception {
		return addToGoodsReceiveDetail ( goodsreceivedetail , false);
	}

	public static BaseGoodsReceiveDetail addToGoodsReceiveDetail ( BaseGoodsReceiveDetail goodsreceivedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setDataFromBase(goodsreceivedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseGoodsReceiveDetail addUpdateGoodsReceiveDetail ( BaseGoodsReceiveDetail goodsreceivedetail ) throws Exception {
		return addUpdateGoodsReceiveDetail ( goodsreceivedetail , false);
	}

	public static BaseGoodsReceiveDetail addUpdateGoodsReceiveDetail ( BaseGoodsReceiveDetail goodsreceivedetail, boolean singleTransaction  ) throws Exception {
		if(goodsreceivedetail.getGoodsReceiveDetailId() == null) return addToGoodsReceiveDetail(goodsreceivedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setDataFromBase(goodsreceivedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(goodsreceivedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteGoodsReceiveDetail ( BaseGoodsReceiveDetail bean ) throws Exception {
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseGoodsReceiveDetail updateGoodsReceiveDetail ( BaseGoodsReceiveDetail goodsreceivedetail ) throws Exception {
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setGoodsReceiveDetailId( goodsreceivedetail.getGoodsReceiveDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(goodsreceivedetail);
			result = dao.update();
		}
		return result == 1 ? goodsreceivedetail : null ;
	}

	public static BaseGoodsReceiveDetail updateGoodsReceiveDetailDirect( BaseGoodsReceiveDetail goodsreceivedetail ) throws Exception {
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		int result = 0;
		dao.setDataFromBase(goodsreceivedetail);
		result = dao.update();
		return result == 1 ? goodsreceivedetail : null ;
	}

	public static int setDeleteConditions(BaseGoodsReceiveDetail bean, GoodsReceiveDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getGoodsReceiveDetailId() != null) {
			dao.setConditionGoodsReceiveDetailId("=", bean.getGoodsReceiveDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getGoodsReceiveId() != null) {
				dao.setConditionGoodsReceiveId("=", bean.getGoodsReceiveId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNumber() != null) {
				dao.setConditionEmployeeNumber("=", bean.getEmployeeNumber());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getIsReceive() != null) {
				dao.setConditionIsReceive("=", bean.getIsReceive());
				count++;
			}
			if(bean.getReceiveCount() != null) {
				dao.setConditionReceiveCount("=", bean.getReceiveCount());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseGoodsReceiveDetail bean, GoodsReceiveDetail dao){
		int count = 0;
		if(bean.getGoodsReceiveDetailId() != null) {
			dao.setConditionGoodsReceiveDetailId("=", bean.getGoodsReceiveDetailId());
			count++;
		}
		if(bean.getGoodsReceiveId() != null) {
			dao.setConditionGoodsReceiveId("=", bean.getGoodsReceiveId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNumber() != null) {
			if(bean.getEmployeeNumber().indexOf("%") >= 0)
				dao.setConditionEmployeeNumber("like", bean.getEmployeeNumber());
			else
				dao.setConditionEmployeeNumber("=", bean.getEmployeeNumber());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getReceiveTime() != null) {
			dao.setConditionReceiveTime(">=", bean.getReceiveTime());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getIsReceive() != null) {
			dao.setConditionIsReceive("=", bean.getIsReceive());
			count++;
		}
		if(bean.getReceiveCount() != null) {
			dao.setConditionReceiveCount("=", bean.getReceiveCount());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseGoodsReceiveDetail bean = new BaseGoodsReceiveDetail();
		bean.setDataFromJSON(json);
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseGoodsReceiveDetail> rlist = new BaseCollection<>();
		BaseGoodsReceiveDetail bean = new BaseGoodsReceiveDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseGoodsReceiveDetail> result = dao.conditionalLoad(addtion);
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
		BaseGoodsReceiveDetail bean = new BaseGoodsReceiveDetail();
		bean.setDataFromJSON(json);
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseGoodsReceiveDetail bean = new BaseGoodsReceiveDetail();
		bean.setDataFromJSON(json);
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseGoodsReceiveDetail bean = new BaseGoodsReceiveDetail();
		bean.setDataFromJSON(json);
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseGoodsReceiveDetail bean = new BaseGoodsReceiveDetail();
		bean.setDataFromJSON(json);
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


