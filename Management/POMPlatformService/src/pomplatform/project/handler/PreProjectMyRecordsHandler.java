package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BasePreProjectMyRecords;
import pomplatform.project.bean.BasepreProjectRecordRemark;
import pomplatform.project.bean.ConditionPreProjectMyRecords;
import pomplatform.project.query.QueryPreProjectMyRecords;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class PreProjectMyRecordsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PreProjectMyRecordsHandler.class);

	public static BaseCollection<BasePreProjectMyRecords> executeQueryPreProjectMyRecords(ConditionPreProjectMyRecords c, KeyValuePair[] replacements ) throws Exception {
		QueryPreProjectMyRecords dao = new QueryPreProjectMyRecords();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectMyRecords> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPreProjectMyRecords c = new ConditionPreProjectMyRecords();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePreProjectMyRecords> result = executeQueryPreProjectMyRecords(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePreProjectMyRecords> result;
		ConditionPreProjectMyRecords c = new ConditionPreProjectMyRecords();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPreProjectMyRecords dao = new QueryPreProjectMyRecords();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePreProjectMyRecords.ALL_CAPTIONS);
			String infoCode = "";
			List<BasePreProjectMyRecords> list=result.getCollections();
			//判断前期项目中字段infoCode在上下文是否有重复的，如果有重复，那么在下文中就set为null
			for(BasePreProjectMyRecords bean : list) {
				if(BaseHelpUtils.getString(bean.getInfoCode()).equals(infoCode)) {
					bean.setDepartmentId(null);;
					bean.setApplyEmployeeId(null);
					bean.setRegisterDate(null);
					bean.setInfoCode(null);
					bean.setProjectName(null);
					bean.setBusinessType(null);
					bean.setCustomerName(null);
					bean.setProvince(null);
					bean.setCity(null);
					bean.setEstimateTheDesignAreas(null);
					bean.setProjectLeader(null);
				    bean.setProjectBaseOn(null);
				    bean.setProjectLevel(null);
				    bean.setProcessStatus(null);
				    bean.setStatus(null);
				    bean.setProjectStatus(null);
				    bean.setDesignTeam(null);
					bean.setProjectManager(null);
					bean.setWinRate(null);
					bean.setProjectApprovalTime(null);
					bean.setProjectOrigination(null);
				}else {
					infoCode = bean.getInfoCode();
				}
				ps.println(bean.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


