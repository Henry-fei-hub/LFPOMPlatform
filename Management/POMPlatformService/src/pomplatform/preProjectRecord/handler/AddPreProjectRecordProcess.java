package pomplatform.preProjectRecord.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BasePreProjectRecord;
import com.pomplatform.db.bean.BaseSystemInitLog;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;

public class AddPreProjectRecordProcess implements GenericProcessor{

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		int id=1;
		PreProjectRecord dao = new PreProjectRecord();
        BasePreProjectRecord bean1 = new BasePreProjectRecord();
        bean1=  dao.executeQueryOneRow("ORDER BY pre_project_record_id DESC ");
        if (!BaseHelpUtils.isNullOrEmpty(bean1)) {
            id=bean1.getPreProjectRecordId()+1;
		}
        BasePreProjectRecord bean = new BasePreProjectRecord();
        bean.setDataFromJSON(creteria);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(new Date());
        bean.setTrackCode("跟踪记录["+dateStr+"]-"+id);
        dao.clear();
        dao.setDataFromBase(bean);
        if(bean.getInformationType() == 2){
        	dao.setMainProjectId(bean.getPreProjectId());
        }
        dao.setRegisterDate(new Date());
        ThreadConnection.beginTransaction();
        if(null != dao.getAttachmentId()) {
        	FileManageProcessor.addTimesById(dao.getAttachmentId());
        }
        dao.save();
        ThreadConnection.commit();
        
//        int preProjectId = dao.getPreProjectId();
//        PreProject pdao = new PreProject();
//        pdao.setPreProjectId(preProjectId);
//        String projectName = "";
//        if(pdao.load()){
//        	pdao.setWinRate(dao.getWinRate());
//        	pdao.update();
//        	projectName = pdao.getProjectName();
//        }
//        
//        
//        //发短信通知相关人员
//        String employees = dao.getRelevantEmployees();
//        Object[] employee = employees.split(",");
//        ERPWeixinUtils.sendWXMsgToUser(String.format(WeixinStatics.MSG_PRE_PROJECT_FOLLOW_MSG,projectName), employee);
//        
//        
//        BigDecimal contractAmount = bean.getContractAmount();
//        if(contractAmount.compareTo(new BigDecimal(4000000))>=0) {
//    		JSON parser = new JSON(new StringReader(creteria));
//    		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
//    		int applyEmployeeId = BaseHelpUtils.getIntValue(param.get("applyEmployeeId"));
//    		String applyEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", applyEmployeeId+"");
//    		String projectSalesTeam = BaseHelpUtils.getString(param.get("projectSalesTeam"));
//    		
//    		//发短信通知运营组人员
//    		Employee edao = new Employee();
//            edao.setConditionStatus("=", 0);
//            edao.setConditionPlateId("=", StaticUtils.plate_59);
//    		List<BaseEmployee> conditionalLoad = edao.conditionalLoad();
//    		if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()>0) {
//    			for (BaseEmployee baseEmployee : conditionalLoad) {
//    				ERPWeixinUtils.sendWXMsgToUser(baseEmployee.getEmployeeId(), String.format(WeixinStatics.MSG_PRE_PROJECT_FOLLOW,projectName,contractAmount,applyEmployeeName,projectSalesTeam));
//    			}
//    		}
//        }
        
        BaseCollection<BaseSystemInitLog> bc = new BaseCollection<>();
        return bc.toJSON(0, null);
	}
	

}
