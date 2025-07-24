package pomplatform.cmbcinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.cmbcinfo.bean.BaseMcmbctransinfoctator;
import pomplatform.cmbcinfo.bean.ConditionMcmbctransinfoctator;
import pomplatform.cmbcinfo.query.QueryMcmbctransinfoctator;
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

public class McmbctransinfoctatorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McmbctransinfoctatorHandler.class);

	public static BaseCollection<BaseMcmbctransinfoctator> executeQueryMcmbctransinfoctator(ConditionMcmbctransinfoctator c, KeyValuePair[] replacements ) throws Exception {
		QueryMcmbctransinfoctator dao = new QueryMcmbctransinfoctator();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcmbctransinfoctator> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcmbctransinfoctator c = new ConditionMcmbctransinfoctator();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcmbctransinfoctator> result = executeQueryMcmbctransinfoctator(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcmbctransinfoctator> result;
		ConditionMcmbctransinfoctator c = new ConditionMcmbctransinfoctator();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcmbctransinfoctator dao = new QueryMcmbctransinfoctator();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcmbctransinfoctator.ALL_CAPTIONS);
			for(BaseMcmbctransinfoctator b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


