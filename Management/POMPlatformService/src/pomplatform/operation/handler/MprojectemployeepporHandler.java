package pomplatform.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.operation.bean.BaseMprojectemployeeppor;
import pomplatform.operation.bean.ConditionMprojectemployeeppor;
import pomplatform.operation.query.QueryMprojectemployeeppor;
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

public class MprojectemployeepporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectemployeepporHandler.class);

	public static BaseCollection<BaseMprojectemployeeppor> executeQueryMprojectemployeeppor(ConditionMprojectemployeeppor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectemployeeppor dao = new QueryMprojectemployeeppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectemployeeppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectemployeeppor c = new ConditionMprojectemployeeppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeeppor> result = executeQueryMprojectemployeeppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectemployeeppor> result;
		ConditionMprojectemployeeppor c = new ConditionMprojectemployeeppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectemployeeppor dao = new QueryMprojectemployeeppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectemployeeppor.ALL_CAPTIONS);
			for(BaseMprojectemployeeppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


