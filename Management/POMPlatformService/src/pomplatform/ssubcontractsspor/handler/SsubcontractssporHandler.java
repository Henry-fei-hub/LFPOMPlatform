package pomplatform.ssubcontractsspor.handler;

import org.apache.log4j.Logger;
import pomplatform.ssubcontractsspor.bean.BaseSsubcontractsspor;
import pomplatform.ssubcontractsspor.bean.ConditionSsubcontractsspor;
import pomplatform.ssubcontractsspor.query.QuerySsubcontractsspor;
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

public class SsubcontractssporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SsubcontractssporHandler.class);

	public static BaseCollection<BaseSsubcontractsspor> executeQuerySsubcontractsspor(ConditionSsubcontractsspor c, KeyValuePair[] replacements ) throws Exception {
		QuerySsubcontractsspor dao = new QuerySsubcontractsspor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSsubcontractsspor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSsubcontractsspor c = new ConditionSsubcontractsspor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSsubcontractsspor> result = executeQuerySsubcontractsspor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSsubcontractsspor> result;
		ConditionSsubcontractsspor c = new ConditionSsubcontractsspor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySsubcontractsspor dao = new QuerySsubcontractsspor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSsubcontractsspor.ALL_CAPTIONS);
			for(BaseSsubcontractsspor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


