package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseNumberOfPunches;
import pomplatform.workflow.personnelbusiness.bean.ConditionNumberOfPunches;
import pomplatform.workflow.personnelbusiness.query.QueryNumberOfPunches;
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

public class NumberOfPunchesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NumberOfPunchesHandler.class);

	public static BaseCollection<BaseNumberOfPunches> executeQueryNumberOfPunches(ConditionNumberOfPunches c, KeyValuePair[] replacements ) throws Exception {
		QueryNumberOfPunches dao = new QueryNumberOfPunches();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNumberOfPunches> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNumberOfPunches c = new ConditionNumberOfPunches();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNumberOfPunches> result = executeQueryNumberOfPunches(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNumberOfPunches> result;
		ConditionNumberOfPunches c = new ConditionNumberOfPunches();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNumberOfPunches dao = new QueryNumberOfPunches();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNumberOfPunches.ALL_CAPTIONS);
			for(BaseNumberOfPunches b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


