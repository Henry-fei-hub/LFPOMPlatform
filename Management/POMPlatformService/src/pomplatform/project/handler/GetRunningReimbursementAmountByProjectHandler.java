package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseGetRunningReimbursementAmountByProject;
import pomplatform.project.bean.ConditionGetRunningReimbursementAmountByProject;
import pomplatform.project.query.QueryGetRunningReimbursementAmountByProject;
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

public class GetRunningReimbursementAmountByProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetRunningReimbursementAmountByProjectHandler.class);

	public static BaseCollection<BaseGetRunningReimbursementAmountByProject> executeQueryGetRunningReimbursementAmountByProject(ConditionGetRunningReimbursementAmountByProject c, KeyValuePair[] replacements ) throws Exception {
		QueryGetRunningReimbursementAmountByProject dao = new QueryGetRunningReimbursementAmountByProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetRunningReimbursementAmountByProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetRunningReimbursementAmountByProject c = new ConditionGetRunningReimbursementAmountByProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetRunningReimbursementAmountByProject> result = executeQueryGetRunningReimbursementAmountByProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetRunningReimbursementAmountByProject> result;
		ConditionGetRunningReimbursementAmountByProject c = new ConditionGetRunningReimbursementAmountByProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetRunningReimbursementAmountByProject dao = new QueryGetRunningReimbursementAmountByProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetRunningReimbursementAmountByProject.ALL_CAPTIONS);
			for(BaseGetRunningReimbursementAmountByProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


