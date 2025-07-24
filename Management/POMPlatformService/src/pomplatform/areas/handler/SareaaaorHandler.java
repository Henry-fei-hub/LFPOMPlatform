package pomplatform.areas.handler;

import org.apache.log4j.Logger;
import pomplatform.areas.bean.BaseSareaaaor;
import pomplatform.areas.bean.ConditionSareaaaor;
import pomplatform.areas.query.QuerySareaaaor;
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

public class SareaaaorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SareaaaorHandler.class);

	public static BaseCollection<BaseSareaaaor> executeQuerySareaaaor(ConditionSareaaaor c, KeyValuePair[] replacements ) throws Exception {
		QuerySareaaaor dao = new QuerySareaaaor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSareaaaor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSareaaaor c = new ConditionSareaaaor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSareaaaor> result = executeQuerySareaaaor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSareaaaor> result;
		ConditionSareaaaor c = new ConditionSareaaaor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySareaaaor dao = new QuerySareaaaor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSareaaaor.ALL_CAPTIONS);
			for(BaseSareaaaor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


