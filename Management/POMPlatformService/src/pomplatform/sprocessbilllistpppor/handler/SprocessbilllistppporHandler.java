package pomplatform.sprocessbilllistpppor.handler;

import org.apache.log4j.Logger;
import pomplatform.sprocessbilllistpppor.bean.BaseSprocessbilllistpppor;
import pomplatform.sprocessbilllistpppor.bean.ConditionSprocessbilllistpppor;
import pomplatform.sprocessbilllistpppor.query.QuerySprocessbilllistpppor;
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

public class SprocessbilllistppporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprocessbilllistppporHandler.class);

	public static BaseCollection<BaseSprocessbilllistpppor> executeQuerySprocessbilllistpppor(ConditionSprocessbilllistpppor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprocessbilllistpppor dao = new QuerySprocessbilllistpppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprocessbilllistpppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprocessbilllistpppor c = new ConditionSprocessbilllistpppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprocessbilllistpppor> result = executeQuerySprocessbilllistpppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprocessbilllistpppor> result;
		ConditionSprocessbilllistpppor c = new ConditionSprocessbilllistpppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprocessbilllistpppor dao = new QuerySprocessbilllistpppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprocessbilllistpppor.ALL_CAPTIONS);
			for(BaseSprocessbilllistpppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


