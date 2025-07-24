package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement;
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

public class OnLoadProjectStageSettlementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectStageSettlementHandler.class);

	public static BaseCollection<BaseOnLoadProjectStageSettlement> executeQueryOnLoadProjectStageSettlement(ConditionOnLoadProjectStageSettlement c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectStageSettlement dao = new QueryOnLoadProjectStageSettlement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectStageSettlement> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectStageSettlement c = new ConditionOnLoadProjectStageSettlement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectStageSettlement> result = executeQueryOnLoadProjectStageSettlement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectStageSettlement> result;
		ConditionOnLoadProjectStageSettlement c = new ConditionOnLoadProjectStageSettlement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectStageSettlement dao = new QueryOnLoadProjectStageSettlement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectStageSettlement.ALL_CAPTIONS);
			for(BaseOnLoadProjectStageSettlement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


