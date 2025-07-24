package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseGoodsReceive;
import com.pomplatform.db.dao.GoodsReceive;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class GoodsReceiveHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(GoodsReceiveHandler.class);

	public static BaseGoodsReceive getGoodsReceiveById( 
		java.lang.Integer goods_receive_id
	) throws Exception
	{
		GoodsReceive dao = new GoodsReceive();
		dao.setGoodsReceiveId(goods_receive_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isGoodsReceiveExists( com.pomplatform.db.bean.BaseGoodsReceive bean, String additional ) throws Exception {

		GoodsReceive dao = new GoodsReceive();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countGoodsReceive( com.pomplatform.db.bean.BaseGoodsReceive bean, String additional ) throws Exception {

		GoodsReceive dao = new GoodsReceive();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseGoodsReceive> queryGoodsReceive( com.pomplatform.db.bean.BaseGoodsReceive bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		GoodsReceive dao = new GoodsReceive();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseGoodsReceive> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseGoodsReceive> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseGoodsReceive addToGoodsReceive ( BaseGoodsReceive goodsreceive )  throws Exception {
		return addToGoodsReceive ( goodsreceive , false);
	}

	public static BaseGoodsReceive addToGoodsReceive ( BaseGoodsReceive goodsreceive, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		GoodsReceive dao = new GoodsReceive();
		dao.setDataFromBase(goodsreceive);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseGoodsReceive addUpdateGoodsReceive ( BaseGoodsReceive goodsreceive ) throws Exception {
		return addUpdateGoodsReceive ( goodsreceive , false);
	}

	public static BaseGoodsReceive addUpdateGoodsReceive ( BaseGoodsReceive goodsreceive, boolean singleTransaction  ) throws Exception {
		if(goodsreceive.getGoodsReceiveId() == null) return addToGoodsReceive(goodsreceive);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		GoodsReceive dao = new GoodsReceive();
		dao.setDataFromBase(goodsreceive);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(goodsreceive); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteGoodsReceive ( BaseGoodsReceive bean ) throws Exception {
		GoodsReceive dao = new GoodsReceive();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseGoodsReceive updateGoodsReceive ( BaseGoodsReceive goodsreceive ) throws Exception {
		GoodsReceive dao = new GoodsReceive();
		dao.setGoodsReceiveId( goodsreceive.getGoodsReceiveId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(goodsreceive);
			result = dao.update();
		}
		return result == 1 ? goodsreceive : null ;
	}

	public static BaseGoodsReceive updateGoodsReceiveDirect( BaseGoodsReceive goodsreceive ) throws Exception {
		GoodsReceive dao = new GoodsReceive();
		int result = 0;
		dao.setDataFromBase(goodsreceive);
		result = dao.update();
		return result == 1 ? goodsreceive : null ;
	}

	public static int setDeleteConditions(BaseGoodsReceive bean, GoodsReceive dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getGoodsReceiveId() != null) {
			dao.setConditionGoodsReceiveId("=", bean.getGoodsReceiveId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSubject() != null) {
				dao.setConditionSubject("=", bean.getSubject());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCount() != null) {
				dao.setConditionCount("=", bean.getCount());
				count++;
			}
			if(bean.getCreatePersonId() != null) {
				dao.setConditionCreatePersonId("=", bean.getCreatePersonId());
				count++;
			}
			if(bean.getFileManageId() != null) {
				dao.setConditionFileManageId("=", bean.getFileManageId());
				count++;
			}
			if(bean.getGoodsDetail() != null) {
				dao.setConditionGoodsDetail("=", bean.getGoodsDetail());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseGoodsReceive bean, GoodsReceive dao){
		int count = 0;
		if(bean.getGoodsReceiveId() != null) {
			dao.setConditionGoodsReceiveId("=", bean.getGoodsReceiveId());
			count++;
		}
		if(bean.getSubject() != null) {
			if(bean.getSubject().indexOf("%") >= 0)
				dao.setConditionSubject("like", bean.getSubject());
			else
				dao.setConditionSubject("=", bean.getSubject());
			count++;
		}
		if(bean.getReceiveDate() != null) {
			dao.setConditionReceiveDate(">=", bean.getReceiveDate());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCount() != null) {
			dao.setConditionCount("=", bean.getCount());
			count++;
		}
		if(bean.getCreatePersonId() != null) {
			dao.setConditionCreatePersonId("=", bean.getCreatePersonId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getFileManageId() != null) {
			dao.setConditionFileManageId("=", bean.getFileManageId());
			count++;
		}
		if(bean.getGoodsDetail() != null) {
			if(bean.getGoodsDetail().indexOf("%") >= 0)
				dao.setConditionGoodsDetail("like", bean.getGoodsDetail());
			else
				dao.setConditionGoodsDetail("=", bean.getGoodsDetail());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseGoodsReceive bean = new BaseGoodsReceive();
		bean.setDataFromJSON(json);
		GoodsReceive dao = new GoodsReceive();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseGoodsReceive> rlist = new BaseCollection<>();
		BaseGoodsReceive bean = new BaseGoodsReceive();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		GoodsReceive dao = new GoodsReceive();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseGoodsReceive> result = dao.conditionalLoad(addtion);
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
		BaseGoodsReceive bean = new BaseGoodsReceive();
		bean.setDataFromJSON(json);
		GoodsReceive dao = new GoodsReceive();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseGoodsReceive bean = new BaseGoodsReceive();
		bean.setDataFromJSON(json);
		GoodsReceive dao = new GoodsReceive();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseGoodsReceive bean = new BaseGoodsReceive();
		bean.setDataFromJSON(json);
		GoodsReceive dao = new GoodsReceive();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseGoodsReceive bean = new BaseGoodsReceive();
		bean.setDataFromJSON(json);
		GoodsReceive dao = new GoodsReceive();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


