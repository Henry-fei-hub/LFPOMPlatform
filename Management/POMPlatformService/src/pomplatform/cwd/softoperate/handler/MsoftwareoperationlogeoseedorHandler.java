package pomplatform.cwd.softoperate.handler;

import org.apache.log4j.Logger;
import pomplatform.cwd.softoperate.bean.BaseMsoftwareoperationlogeoseedor;
import pomplatform.cwd.softoperate.bean.ConditionMsoftwareoperationlogeoseedor;
import pomplatform.cwd.softoperate.query.QueryMsoftwareoperationlogeoseedor;
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

public class MsoftwareoperationlogeoseedorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MsoftwareoperationlogeoseedorHandler.class);

	public static BaseCollection<BaseMsoftwareoperationlogeoseedor> executeQueryMsoftwareoperationlogeoseedor(ConditionMsoftwareoperationlogeoseedor c, KeyValuePair[] replacements ) throws Exception {
		QueryMsoftwareoperationlogeoseedor dao = new QueryMsoftwareoperationlogeoseedor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMsoftwareoperationlogeoseedor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMsoftwareoperationlogeoseedor c = new ConditionMsoftwareoperationlogeoseedor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMsoftwareoperationlogeoseedor> result = executeQueryMsoftwareoperationlogeoseedor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMsoftwareoperationlogeoseedor> result;
		ConditionMsoftwareoperationlogeoseedor c = new ConditionMsoftwareoperationlogeoseedor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMsoftwareoperationlogeoseedor dao = new QueryMsoftwareoperationlogeoseedor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMsoftwareoperationlogeoseedor.ALL_CAPTIONS);
			for(BaseMsoftwareoperationlogeoseedor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


