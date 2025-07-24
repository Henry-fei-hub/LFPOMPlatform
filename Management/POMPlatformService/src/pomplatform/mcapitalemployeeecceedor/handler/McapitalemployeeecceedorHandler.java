package pomplatform.mcapitalemployeeecceedor.handler;

import org.apache.log4j.Logger;
import pomplatform.mcapitalemployeeecceedor.bean.BaseMcapitalemployeeecceedor;
import pomplatform.mcapitalemployeeecceedor.bean.ConditionMcapitalemployeeecceedor;
import pomplatform.mcapitalemployeeecceedor.query.QueryMcapitalemployeeecceedor;
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

public class McapitalemployeeecceedorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McapitalemployeeecceedorHandler.class);

	public static BaseCollection<BaseMcapitalemployeeecceedor> executeQueryMcapitalemployeeecceedor(ConditionMcapitalemployeeecceedor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcapitalemployeeecceedor dao = new QueryMcapitalemployeeecceedor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcapitalemployeeecceedor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcapitalemployeeecceedor c = new ConditionMcapitalemployeeecceedor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcapitalemployeeecceedor> result = executeQueryMcapitalemployeeecceedor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcapitalemployeeecceedor> result;
		ConditionMcapitalemployeeecceedor c = new ConditionMcapitalemployeeecceedor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcapitalemployeeecceedor dao = new QueryMcapitalemployeeecceedor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcapitalemployeeecceedor.ALL_CAPTIONS);
			for(BaseMcapitalemployeeecceedor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


