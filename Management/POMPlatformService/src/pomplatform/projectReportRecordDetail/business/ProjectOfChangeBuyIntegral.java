package pomplatform.projectReportRecordDetail.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 采买订单汇总
 *
 * @author 
 */
public class ProjectOfChangeBuyIntegral implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");
    //获取未结束的采买成本订单
    private final static String GET_WILL_CHANGE_INTEGRAL_PROJECT = "changeIntegralProject";
    //保存订单额度变化的订单
    private final static String SAVE_CHANGE_INTEGRAL_PROJECT = "saveChangeIntegralProject";
    
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
			case GET_WILL_CHANGE_INTEGRAL_PROJECT:
				return changeIntegralProject(result);
			case SAVE_CHANGE_INTEGRAL_PROJECT:
				return saveChangeIntegralProject(result);
			}
		}
		return null;
    }

    
    /**
     * 保存订单额度变化的订单
     * @param result
     * @return
     * @throws SQLException 
     */
    @SuppressWarnings("unchecked")
	private String saveChangeIntegralProject(Map<String, Object> result) throws SQLException {
    	ThreadConnection.beginTransaction();
    	Project dao = new Project();
    	//需要增加额度的订单
    	List<Map<String,Object>> list = (List<Map<String, Object>>) result.get("list");
    	BigDecimal total = BigDecimal.ZERO;
    	if(BaseHelpUtils.isNullOrEmpty(list) && list.size() ==0){
    		throw new SQLException("操作异常:没有额度变化");
    	}
    	for(Map<String,Object> e : list){
    		//获取增加的额度
    		BigDecimal changeIntegral = BaseHelpUtils.getBigDecimalValue(e.get("changeIntegral"));
    		//获取原来额度
    		BigDecimal totalIntegral = BaseHelpUtils.getBigDecimalValue(e.get("totalIntegral"));
    		//获取项目id
    		int projectId = BaseHelpUtils.getIntValue(e.get("projectId"));
    		dao.clear();
    		dao.setProjectId(projectId);
    		if(dao.load()){
    			//修改增加后的额度
    			dao.setTotalIntegral(changeIntegral.add(totalIntegral));
    			dao.update();
    		}
    		total = total.add(changeIntegral);
    	}
    	
    	//修改移出额度的订单的剩余额度
    	int fromProjectId = BaseHelpUtils.getIntValue(result.get("fromProjectId"));
    	dao.clear();
    	dao.setProjectId(fromProjectId);
    	if(dao.load()){
    		BigDecimal totalIntegral = dao.getTotalIntegral();
    		dao.setTotalIntegral(totalIntegral.subtract(total));
    		dao.update();
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}


	/**
     * 获取未结束的采买成本订单
     * @param result
     * @return
     * @throws SQLException 
     */
	private String changeIntegralProject(Map<String, Object> result) throws SQLException {
		Project dao = new Project();
    	dao.setConditionProjectType("=", 30);//项目类型为采买成本
    	dao.setConditionStatus("<>", 11);//取未结束的项目
    	dao.unsetSelectFlags();
    	dao.setSelectProjectId(true);
    	dao.setSelectContractCode(true);
    	dao.setSelectProjectName(true);
    	dao.setSelectTotalIntegral(true);
    	List<BaseProject> list = dao.conditionalLoad();
    	BaseCollection<BaseProject> bc = new BaseCollection<>();
    	if(!BaseHelpUtils.isNullOrEmpty(list)){
    		bc.setCollections(list);
    	}
        return bc.toJSON(0, null);
	}

}
