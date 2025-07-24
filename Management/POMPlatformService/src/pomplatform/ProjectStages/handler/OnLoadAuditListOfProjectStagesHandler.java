package pomplatform.ProjectStages.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectStages.bean.BaseOnLoadAuditListOfProjectStages;
import pomplatform.ProjectStages.bean.ConditionOnLoadAuditListOfProjectStages;
import pomplatform.ProjectStages.query.QueryOnLoadAuditListOfProjectStages;
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

public class OnLoadAuditListOfProjectStagesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfProjectStagesHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfProjectStages> executeQueryOnLoadAuditListOfProjectStages(ConditionOnLoadAuditListOfProjectStages c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfProjectStages dao = new QueryOnLoadAuditListOfProjectStages();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfProjectStages> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfProjectStages c = new ConditionOnLoadAuditListOfProjectStages();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfProjectStages> result = executeQueryOnLoadAuditListOfProjectStages(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfProjectStages> result;
		ConditionOnLoadAuditListOfProjectStages c = new ConditionOnLoadAuditListOfProjectStages();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfProjectStages dao = new QueryOnLoadAuditListOfProjectStages();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfProjectStages.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfProjectStages b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


