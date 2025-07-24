package pomplatform.stageIntegral.handler;

import org.apache.log4j.Logger;
import pomplatform.stageIntegral.bean.BaseMprojectStageIntegralTotal;
import pomplatform.stageIntegral.bean.ConditionMprojectStageIntegralTotal;
import pomplatform.stageIntegral.query.QueryMprojectStageIntegralTotal;
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

public class MprojectStageIntegralTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectStageIntegralTotalHandler.class);

	public static BaseCollection<BaseMprojectStageIntegralTotal> executeQueryMprojectStageIntegralTotal(ConditionMprojectStageIntegralTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectStageIntegralTotal dao = new QueryMprojectStageIntegralTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectStageIntegralTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectStageIntegralTotal c = new ConditionMprojectStageIntegralTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectStageIntegralTotal> result = executeQueryMprojectStageIntegralTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectStageIntegralTotal> result;
		ConditionMprojectStageIntegralTotal c = new ConditionMprojectStageIntegralTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectStageIntegralTotal dao = new QueryMprojectStageIntegralTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectStageIntegralTotal.ALL_CAPTIONS);
			for(BaseMprojectStageIntegralTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


