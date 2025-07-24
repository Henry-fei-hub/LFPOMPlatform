package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseGetProjectECMCEmployeeInfo;
import pomplatform.preProjects.bean.ConditionGetProjectECMCEmployeeInfo;
import pomplatform.preProjects.query.QueryGetProjectECMCEmployeeInfo;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class GetProjectECMCEmployeeInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProjectECMCEmployeeInfoHandler.class);

	public static BaseCollection<BaseGetProjectECMCEmployeeInfo> executeQueryGetProjectECMCEmployeeInfo(ConditionGetProjectECMCEmployeeInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProjectECMCEmployeeInfo dao = new QueryGetProjectECMCEmployeeInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProjectECMCEmployeeInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProjectECMCEmployeeInfo c = new ConditionGetProjectECMCEmployeeInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProjectECMCEmployeeInfo> result = executeQueryGetProjectECMCEmployeeInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProjectECMCEmployeeInfo> result;
		ConditionGetProjectECMCEmployeeInfo c = new ConditionGetProjectECMCEmployeeInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProjectECMCEmployeeInfo dao = new QueryGetProjectECMCEmployeeInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProjectECMCEmployeeInfo.ALL_CAPTIONS);
			for(BaseGetProjectECMCEmployeeInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


