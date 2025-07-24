package pomplatform.ProjectStages.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectStages.bean.BaseOnLoadApplyListOfProjectStages;
import pomplatform.ProjectStages.bean.ConditionOnLoadApplyListOfProjectStages;
import pomplatform.ProjectStages.query.QueryOnLoadApplyListOfProjectStages;
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

public class OnLoadApplyListOfProjectStagesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfProjectStagesHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfProjectStages> executeQueryOnLoadApplyListOfProjectStages(ConditionOnLoadApplyListOfProjectStages c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfProjectStages dao = new QueryOnLoadApplyListOfProjectStages();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfProjectStages> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfProjectStages c = new ConditionOnLoadApplyListOfProjectStages();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfProjectStages> result = executeQueryOnLoadApplyListOfProjectStages(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfProjectStages> result;
		ConditionOnLoadApplyListOfProjectStages c = new ConditionOnLoadApplyListOfProjectStages();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfProjectStages dao = new QueryOnLoadApplyListOfProjectStages();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfProjectStages.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfProjectStages b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


