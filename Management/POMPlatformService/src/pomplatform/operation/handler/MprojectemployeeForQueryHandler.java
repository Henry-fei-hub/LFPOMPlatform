package pomplatform.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.operation.bean.BaseMprojectemployeeForQuery;
import pomplatform.operation.bean.ConditionMprojectemployeeForQuery;
import pomplatform.operation.query.QueryMprojectemployeeForQuery;
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

public class MprojectemployeeForQueryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectemployeeForQueryHandler.class);

	public static BaseCollection<BaseMprojectemployeeForQuery> executeQueryMprojectemployeeForQuery(ConditionMprojectemployeeForQuery c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectemployeeForQuery dao = new QueryMprojectemployeeForQuery();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectemployeeForQuery> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectemployeeForQuery c = new ConditionMprojectemployeeForQuery();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeeForQuery> result = executeQueryMprojectemployeeForQuery(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectemployeeForQuery> result;
		ConditionMprojectemployeeForQuery c = new ConditionMprojectemployeeForQuery();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectemployeeForQuery dao = new QueryMprojectemployeeForQuery();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectemployeeForQuery.ALL_CAPTIONS);
			for(BaseMprojectemployeeForQuery b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


