package pomplatform.attachment.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BaseAttachmentManageEmployee;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.AttachmentManageEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.attachment.bean.BaseMcontractAttachmentCapitalCount;
import pomplatform.attachment.bean.ConditionMcontractAttachmentCapitalCount;
import pomplatform.attachment.query.QueryMcontractAttachmentCapitalCount;

public class McontractAttachmentCapitalCountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontractAttachmentCapitalCountHandler.class);

	public static BaseCollection<BaseMcontractAttachmentCapitalCount> executeQueryMcontractAttachmentCapitalCount(ConditionMcontractAttachmentCapitalCount c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontractAttachmentCapitalCount dao = new QueryMcontractAttachmentCapitalCount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontractAttachmentCapitalCount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontractAttachmentCapitalCount c = new ConditionMcontractAttachmentCapitalCount();
		c.setDataFromJSON(creteria);
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		if(null != result.get("searchDate")){
			Date searchDate = GenericBase.__getDate(result.get("searchDate"));
			Calendar cale = Calendar.getInstance();
			cale.setTime(searchDate);
			cale.add(Calendar.MONTH, 0);
			cale.set(Calendar.DAY_OF_MONTH, 1);  
			cale.set(Calendar.HOUR_OF_DAY, 0);
			cale.set(Calendar.MINUTE, 0);
			cale.set(Calendar.SECOND, 0);
			cale.set(Calendar.MILLISECOND, 0);
			Date beginDate = cale.getTime();
			cale.add(Calendar.MONTH, 1);  
	        cale.set(Calendar.DAY_OF_MONTH, 0);  
	        Date endDate = cale.getTime();
	        c.setMinHappenDate(beginDate);
	        c.setMaxHappenDate(endDate);
	        c.setBeforeSettlementDate(beginDate);
	        c.setAfterSettlementDate(endDate);
		}
		
		int checkType = BaseHelpUtils.getIntValue(result, "checkType");
		int checkEmployeeId = BaseHelpUtils.getIntValue(result, "checkEmployeeId");
		KeyValuePair kv = new KeyValuePair();
		String reSql = "AND ct.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace))";
		String reSqlAli = "SELECT contract_id FROM projects WHERE project_manage_id in (replace)";
		if(checkType > 0){
			AttachmentManage amDao = new AttachmentManage();
			List<Integer> attachmentManageIds = new ArrayList<>();
			AttachmentManageEmployee ateDao = new AttachmentManageEmployee();
			if(checkType == 1){//总监
				ateDao.setConditionEmployeeId("=", checkEmployeeId);
				List<BaseAttachmentManageEmployee> ateList = ateDao.conditionalLoad();
				for (int i = 0; i < ateList.size(); i++) {
					if(null != ateList.get(i).getAttachmentManageEmployeeId()){
						attachmentManageIds.add(ateList.get(i).getAttachmentManageEmployeeId());
					}
				}
				if(attachmentManageIds.size() > 0){
					amDao.clear();
					amDao.addCondition(BaseAttachmentManage.CS_ATTACHMENT_MANAGE_ID, "in", attachmentManageIds.toArray(new Object[attachmentManageIds.size()]));
					String contractIds = "";
					List<BaseAttachmentManage> amList = amDao.conditionalLoad();
					for (int i = 0; i < amList.size(); i++) {
						if(null != amList.get(i).getContractId()){
							if(i != 0){
								contractIds += ",";
							}
							contractIds += amList.get(i).getContractId();
						}
					}
					if(BaseHelpUtils.isNullOrEmpty(contractIds)){
						kv.setKey(reSqlAli);
						kv.setValue("-1");
					}else{
						kv.setKey(reSqlAli);
						kv.setValue(contractIds);
					}
				}else{
					kv.setKey(reSqlAli);
					kv.setValue("-1");
				}
			}else if(checkType == 2 || checkType == 3){//项目负责人与大项目负责人
				amDao.clear();
				if(checkType == 2){
					amDao.setConditionSuperProjectManageId("=", checkEmployeeId);
				}else{
					amDao.setConditionProjectManageId("=", checkEmployeeId);
				}
				String contractIds = "";
				List<BaseAttachmentManage> amList = amDao.conditionalLoad();
				for (int i = 0; i < amList.size(); i++) {
					if(null != amList.get(i).getContractId()){
						if(i != 0){
							contractIds += ",";
						}
						contractIds += amList.get(i).getContractId();
					}
				}
				if(BaseHelpUtils.isNullOrEmpty(contractIds)){
					kv.setKey(reSqlAli);
					kv.setValue("-1");
				}else{
					kv.setKey(reSqlAli);
					kv.setValue(contractIds);
				}
			}
			
		}else{//查看所有
			kv.setKey(reSql);
			kv.setValue("");
		}
		KeyValuePair[] replacements = new KeyValuePair[1];
		replacements[0] = kv;
		c.setKeyValues(replacements);
		BaseCollection<BaseMcontractAttachmentCapitalCount> resultData = executeQueryMcontractAttachmentCapitalCount(c, c.getKeyValues());
		return resultData.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontractAttachmentCapitalCount> result;
		ConditionMcontractAttachmentCapitalCount c = new ConditionMcontractAttachmentCapitalCount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcontractAttachmentCapitalCount dao = new QueryMcontractAttachmentCapitalCount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontractAttachmentCapitalCount.ALL_CAPTIONS);
			for(BaseMcontractAttachmentCapitalCount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


