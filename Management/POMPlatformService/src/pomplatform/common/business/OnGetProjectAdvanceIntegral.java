package pomplatform.common.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectAdvanceRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 根据项目ID检索该项目的补贴总积分和剩余积分
 * @author lxf
 */
public class OnGetProjectAdvanceIntegral implements GenericProcessor {
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BigDecimal advanceIntegral = BigDecimal.ZERO;
        BigDecimal leftIntegral = BigDecimal.ZERO;
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
        ProjectAdvanceRecord projectAdvanceRecordDao = new ProjectAdvanceRecord();
        projectAdvanceRecordDao.setConditionProjectId("=",projectId);
        List<BaseProjectAdvanceRecord> projectAdvanceRecordList = projectAdvanceRecordDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(projectAdvanceRecordList) && !projectAdvanceRecordList.isEmpty()){
        	for(BaseProjectAdvanceRecord e : projectAdvanceRecordList){
        		advanceIntegral = advanceIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAdvanceIntegral()));
        		leftIntegral = leftIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getLeftIntegral()));
        	}
        }
        
        BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
        bean.setAdvanceIntegral(advanceIntegral);
        bean.setLeftIntegral(leftIntegral);
        return bean.toOneLineJSON(0,null);
    }

}
