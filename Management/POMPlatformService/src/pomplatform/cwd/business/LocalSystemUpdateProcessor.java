package pomplatform.cwd.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseSoftwareUpdateVersion;
import com.pomplatform.db.dao.SoftwareUpdateVersion;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.cwd.bean.BaseSoftwareUpdateVersionWithS;
import pomplatform.cwd.dao.SoftwareUpdateVersionWithS;

public class LocalSystemUpdateProcessor implements GenericProcessor {
	
	private static final BigDecimal UNIT_VNO = new BigDecimal("0.1");
	
    // 操作类型
    private static final String OPT_TYPE = "optType";
    
    // 获取最新的版本号
    private static final String GET_NEW_VERSION_NO = "getNewVersionNo";
    
    // 保存新版本
    private static final String SAVE_NEW_VERSION = "saveNewVersion";
   
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
        
        switch (optType) {
		case GET_NEW_VERSION_NO:
			return getNewVersionNo(params);
		case SAVE_NEW_VERSION:
			return saveNewVersion(creteria);
		default:
			break;
		}
        return null;
    }
    
    /**
     * 保存新版本
     * @param json
     * @return
     * @throws Exception
     */
    private String saveNewVersion(String json) throws Exception {
    	BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		// 检测是否为最新的版本
		dao.setConditionSoftwareType("=", bean.getSoftwareType());
		dao.setConditionVersionNo(">=", bean.getVersionNo());
		if(dao.countRows() > 0) {
			throw new SQLException("该版本号不为最新的版本号,请重新添加");
		}
		dao.clear();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
    }
    
    /**
     * 获取最新可以添加的版本号
     * @return
     * @throws SQLException
     */
    private String getNewVersionNo(Map<String, Object> params) throws SQLException {
    	int softwareType = BaseHelpUtils.getIntValue(params, "softwareType");
    	SoftwareUpdateVersion dao = new SoftwareUpdateVersion();
    	dao.setConditionSoftwareType("=", softwareType);
    	BaseSoftwareUpdateVersion bean = dao.executeQueryOneRow(" order by " + BaseSoftwareUpdateVersion.CS_VERSION_NO + " DESC");
    	if(null == bean) {
    		bean = new BaseSoftwareUpdateVersion();
    		bean.setVersionNo(new BigDecimal("1.1"));
    	}else {
    		bean.setVersionNo(bean.getVersionNo().add(UNIT_VNO));
    	}
    	return bean.toOneLineJSON();
    }
    
    
}
