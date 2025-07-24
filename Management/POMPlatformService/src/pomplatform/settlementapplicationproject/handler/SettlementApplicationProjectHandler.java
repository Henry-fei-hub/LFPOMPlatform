package pomplatform.settlementapplicationproject.handler;

import org.apache.log4j.Logger;
import pomplatform.settlementapplicationproject.bean.BaseSettlementApplicationProject;
import pomplatform.settlementapplicationproject.bean.ConditionSettlementApplicationProject;
import pomplatform.settlementapplicationproject.query.QuerySettlementApplicationProject;
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

public class SettlementApplicationProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SettlementApplicationProjectHandler.class);

	public static BaseCollection<BaseSettlementApplicationProject> executeQuerySettlementApplicationProject(ConditionSettlementApplicationProject c, KeyValuePair[] replacements ) throws Exception {
		QuerySettlementApplicationProject dao = new QuerySettlementApplicationProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSettlementApplicationProject> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSettlementApplicationProject c = new ConditionSettlementApplicationProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSettlementApplicationProject> result = executeQuerySettlementApplicationProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSettlementApplicationProject> result;
		ConditionSettlementApplicationProject c = new ConditionSettlementApplicationProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySettlementApplicationProject dao = new QuerySettlementApplicationProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSettlementApplicationProject.ALL_CAPTIONS);
			for(BaseSettlementApplicationProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


