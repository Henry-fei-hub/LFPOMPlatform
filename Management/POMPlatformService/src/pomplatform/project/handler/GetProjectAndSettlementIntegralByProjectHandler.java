package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseGetProjectAndSettlementIntegralByProject;
import pomplatform.project.bean.ConditionGetProjectAndSettlementIntegralByProject;
import pomplatform.project.query.QueryGetProjectAndSettlementIntegralByProject;
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

public class GetProjectAndSettlementIntegralByProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProjectAndSettlementIntegralByProjectHandler.class);

	public static BaseCollection<BaseGetProjectAndSettlementIntegralByProject> executeQueryGetProjectAndSettlementIntegralByProject(ConditionGetProjectAndSettlementIntegralByProject c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProjectAndSettlementIntegralByProject dao = new QueryGetProjectAndSettlementIntegralByProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProjectAndSettlementIntegralByProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProjectAndSettlementIntegralByProject c = new ConditionGetProjectAndSettlementIntegralByProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProjectAndSettlementIntegralByProject> result = executeQueryGetProjectAndSettlementIntegralByProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProjectAndSettlementIntegralByProject> result;
		ConditionGetProjectAndSettlementIntegralByProject c = new ConditionGetProjectAndSettlementIntegralByProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProjectAndSettlementIntegralByProject dao = new QueryGetProjectAndSettlementIntegralByProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProjectAndSettlementIntegralByProject.ALL_CAPTIONS);
			for(BaseGetProjectAndSettlementIntegralByProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


