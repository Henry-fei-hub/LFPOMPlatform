package pomplatform.goodsreceive.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseGoodsReceive;
import com.pomplatform.db.bean.BaseGoodsReceiveDetail;
import com.pomplatform.db.dao.GoodsReceive;
import com.pomplatform.db.dao.GoodsReceiveDetail;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class GoodsReceiveProcess implements GenericProcessor {
	//判断是否领取
	private final static String GETFLAG = "getFlag";
	//领取
	private final static String GETGOODS = "getGoods";
	//根据goodsReceiveId 查询详细的信息
	private final static String SHOWGOODSRECEIVE = "showGoodsReceive";
	//查询所有还未开始的物品领取
	private final static String SHOWALL = "showAll";
	//根据employeeId查询已经领取的物品
	private final static String SHOWMYALL = "showMyAll";
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "optType");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GETFLAG:
				return getFlag(result);
			case GETGOODS:
				return getGoods(result);
			case SHOWGOODSRECEIVE:
			 	return showGoodsReceive(result);
			case  SHOWALL:
				return showAll(result);
			case SHOWMYALL:
				return showMyAll(result);
			default:
				break;
			}
		}
		return null;
	}
	
	/**
	 * 查询本人领取的物品
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showMyAll(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<BaseGoodsReceive> bCollection = new BaseCollection<>();
		int employeeId = BaseHelpUtils.getIntValue(result.get("employeeId"));
		GoodsReceiveDetail dao = new GoodsReceiveDetail();
		dao.setConditionEmployeeId("=", employeeId);
		List<BaseGoodsReceiveDetail> lists = dao.conditionalLoad();
		List<BaseGoodsReceive> baseGoodsReceives = new ArrayList<>();
		if (lists.size() != 0) {
			for (BaseGoodsReceiveDetail baseGoodsReceiveDetail : lists) {
				int receiveGoodsId = baseGoodsReceiveDetail.getGoodsReceiveId();
				GoodsReceive goodsReceive = new GoodsReceive();
				goodsReceive.setGoodsReceiveId(receiveGoodsId);
				goodsReceive.load();
				baseGoodsReceives.add(goodsReceive.generateBase());
			}
			status = 1;
			bCollection.setCollections(baseGoodsReceives);
		}
		return bCollection.toJSON(status,"");
	}

	/**
	 * 查询所有还未开始的领取
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showAll(Map<String, Object> result) throws SQLException {
		int status = -1;
		GoodsReceive dao = new GoodsReceive();
		BaseCollection<BaseGoodsReceive> collection = new BaseCollection<>();
		dao.setConditionReceiveDate(">", new Date());
		List<BaseGoodsReceive> goodsReceives = dao.conditionalLoad();
		if (goodsReceives.size() != 0) {
			status = 1;
			collection.setCollections(goodsReceives);
		}
		return collection.toJSON(status,"");
	}

	/**
	 * 查询详细的信息
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showGoodsReceive(Map<String, Object> result) throws SQLException {
		int status = 1;
		String errorMsg = "";
		BaseCollection<BaseGoodsReceive> baseCollection = new BaseCollection<>();
		GoodsReceive grDao = new GoodsReceive();
		grDao.setGoodsReceiveId(BaseHelpUtils.getIntValue(result.get("goodsReceiveId")));
		grDao.load();
		BaseGoodsReceive baseGoodsReceive = grDao.generateBase();
		return baseGoodsReceive.toJSON();
	}

	/**
	 * 领取物品
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String getGoods(Map<String, Object> result) throws SQLException {
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> baseCollection = new BaseCollection<>();
		GoodsReceiveDetail grdDao = new GoodsReceiveDetail();
		grdDao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result.get("employeeId")));
		grdDao.setConditionGoodsReceiveId("=", BaseHelpUtils.getIntValue(result.get("goodsReceiveId")));
		BaseGoodsReceiveDetail baseGoodsReceiveDetail = grdDao.executeQueryOneRow();
		if (baseGoodsReceiveDetail == null) {
			grdDao.setGoodsReceiveId(BaseHelpUtils.getIntValue(result.get("goodsReceiveId")));
			grdDao.setEmployeeId(BaseHelpUtils.getIntValue(result.get("employeeId")));
			grdDao.setEmployeeNumber(result.get("employeeNumber").toString());
			grdDao.setDepartmentId(BaseHelpUtils.getIntValue(result.get("departmentId")));
			grdDao.setReceiveTime(new Date());
//			grdDao.setEmployeeName(result.get("employeeName").toString());
			grdDao.setReceiveCount(BaseHelpUtils.getIntValue(result.get("receiveCount")));
			grdDao.save();
			return baseCollection.toJSON(status,null);
		}else{
			status = -1;
			return baseCollection.toJSON(status,"您已经领取物品，不能重复领取");
		}
	}

	/**
	 * 判断是否已经领取
	 * @param request
	 * @return
	 * @throws SQLException 
	 */
	private String getFlag(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<BaseGoodsReceiveDetail> baseCollection = new BaseCollection<>();
		GoodsReceiveDetail grdDao = new GoodsReceiveDetail();
		grdDao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result.get("employeeId")));
		grdDao.setConditionGoodsReceiveId("=", BaseHelpUtils.getIntValue(result.get("goodsReceiveId")));
		BaseGoodsReceiveDetail goodsReceiveDetail = grdDao.executeQueryOneRow();
		if (goodsReceiveDetail != null) {
			status = 1;
		}
		return baseCollection.toJSON(status,null);
	}
	
	public static void main(String[] args) throws Exception {
		String ss = "{\"optType\": \"getGoods\",\"employeeId\":0,\"goodsReceiveId\":21}";
		GoodsReceiveProcess p = new GoodsReceiveProcess();
		System.out.println(p.execute(ss, null));
		
	}

}
