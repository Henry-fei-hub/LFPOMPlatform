package pomplatform.ProjectStages.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectStages.bean.BaseOnLoadAttentionListOfProjectStages;
import pomplatform.ProjectStages.bean.ConditionOnLoadAttentionListOfProjectStages;
import pomplatform.ProjectStages.query.QueryOnLoadAttentionListOfProjectStages;
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

public class OnLoadAttentionListOfProjectStagesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfProjectStagesHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfProjectStages> executeQueryOnLoadAttentionListOfProjectStages(ConditionOnLoadAttentionListOfProjectStages c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfProjectStages dao = new QueryOnLoadAttentionListOfProjectStages();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfProjectStages> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfProjectStages c = new ConditionOnLoadAttentionListOfProjectStages();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfProjectStages> result = executeQueryOnLoadAttentionListOfProjectStages(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfProjectStages> result;
		ConditionOnLoadAttentionListOfProjectStages c = new ConditionOnLoadAttentionListOfProjectStages();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfProjectStages dao = new QueryOnLoadAttentionListOfProjectStages();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfProjectStages.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfProjectStages b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


