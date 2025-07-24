package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseScapitalipcor;
import pomplatform.financialStatements.bean.ConditionScapitalipcor;
import pomplatform.financialStatements.query.QueryScapitalipcor;
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

public class ScapitalipcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScapitalipcorHandler.class);

	public static BaseCollection<BaseScapitalipcor> executeQueryScapitalipcor(ConditionScapitalipcor c, KeyValuePair[] replacements ) throws Exception {
		QueryScapitalipcor dao = new QueryScapitalipcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScapitalipcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScapitalipcor c = new ConditionScapitalipcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScapitalipcor> result = executeQueryScapitalipcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScapitalipcor> result;
		ConditionScapitalipcor c = new ConditionScapitalipcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScapitalipcor dao = new QueryScapitalipcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScapitalipcor.ALL_CAPTIONS);
			for(BaseScapitalipcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


