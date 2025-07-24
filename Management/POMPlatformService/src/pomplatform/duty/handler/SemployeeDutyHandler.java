package pomplatform.duty.handler;

import org.apache.log4j.Logger;
import pomplatform.duty.bean.BaseSemployeeDuty;
import pomplatform.duty.bean.ConditionSemployeeDuty;
import pomplatform.duty.query.QuerySemployeeDuty;
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

public class SemployeeDutyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SemployeeDutyHandler.class);

	public static BaseCollection<BaseSemployeeDuty> executeQuerySemployeeDuty(ConditionSemployeeDuty c, KeyValuePair[] replacements ) throws Exception {
		QuerySemployeeDuty dao = new QuerySemployeeDuty();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSemployeeDuty> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSemployeeDuty c = new ConditionSemployeeDuty();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSemployeeDuty> result = executeQuerySemployeeDuty(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSemployeeDuty> result;
		ConditionSemployeeDuty c = new ConditionSemployeeDuty();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySemployeeDuty dao = new QuerySemployeeDuty();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSemployeeDuty.ALL_CAPTIONS);
			for(BaseSemployeeDuty b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


