package pomplatform.ht.handler;

import org.apache.log4j.Logger;
import pomplatform.ht.bean.BaseSformalcontractcccor;
import pomplatform.ht.bean.ConditionSformalcontractcccor;
import pomplatform.ht.query.QuerySformalcontractcccor;
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

public class SformalcontractcccorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SformalcontractcccorHandler.class);

	public static BaseCollection<BaseSformalcontractcccor> executeQuerySformalcontractcccor(ConditionSformalcontractcccor c, KeyValuePair[] replacements ) throws Exception {
		QuerySformalcontractcccor dao = new QuerySformalcontractcccor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSformalcontractcccor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSformalcontractcccor c = new ConditionSformalcontractcccor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSformalcontractcccor> result = executeQuerySformalcontractcccor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSformalcontractcccor> result;
		ConditionSformalcontractcccor c = new ConditionSformalcontractcccor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySformalcontractcccor dao = new QuerySformalcontractcccor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSformalcontractcccor.ALL_CAPTIONS);
			for(BaseSformalcontractcccor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


