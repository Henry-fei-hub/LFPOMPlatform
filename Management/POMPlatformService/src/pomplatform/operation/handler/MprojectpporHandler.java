package pomplatform.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.operation.bean.BaseMprojectppor;
import pomplatform.operation.bean.ConditionMprojectppor;
import pomplatform.operation.query.QueryMprojectppor;
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

public class MprojectpporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectpporHandler.class);

	public static BaseCollection<BaseMprojectppor> executeQueryMprojectppor(ConditionMprojectppor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectppor dao = new QueryMprojectppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectppor c = new ConditionMprojectppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectppor> result = executeQueryMprojectppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectppor> result;
		ConditionMprojectppor c = new ConditionMprojectppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectppor dao = new QueryMprojectppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseMprojectppor.ALL_CAPTIONS);
			for(BaseMprojectppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


