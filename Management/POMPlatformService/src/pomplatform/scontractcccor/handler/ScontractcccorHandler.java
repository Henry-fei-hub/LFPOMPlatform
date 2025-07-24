package pomplatform.scontractcccor.handler;

import org.apache.log4j.Logger;
import pomplatform.scontractcccor.bean.BaseScontractcccor;
import pomplatform.scontractcccor.bean.ConditionScontractcccor;
import pomplatform.scontractcccor.query.QueryScontractcccor;
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

public class ScontractcccorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScontractcccorHandler.class);

	public static BaseCollection<BaseScontractcccor> executeQueryScontractcccor(ConditionScontractcccor c, KeyValuePair[] replacements ) throws Exception {
		QueryScontractcccor dao = new QueryScontractcccor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScontractcccor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScontractcccor c = new ConditionScontractcccor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScontractcccor> result = executeQueryScontractcccor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScontractcccor> result;
		ConditionScontractcccor c = new ConditionScontractcccor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScontractcccor dao = new QueryScontractcccor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScontractcccor.ALL_CAPTIONS);
			for(BaseScontractcccor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


