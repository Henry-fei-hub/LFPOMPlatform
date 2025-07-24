package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseQueryLeaveApplyDays;
import pomplatform.workflow.personnelbusiness.bean.ConditionQueryLeaveApplyDays;
import pomplatform.workflow.personnelbusiness.query.QueryQueryLeaveApplyDays;
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

public class QueryLeaveApplyDaysHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(QueryLeaveApplyDaysHandler.class);

	public static BaseCollection<BaseQueryLeaveApplyDays> executeQueryQueryLeaveApplyDays(ConditionQueryLeaveApplyDays c, KeyValuePair[] replacements ) throws Exception {
		QueryQueryLeaveApplyDays dao = new QueryQueryLeaveApplyDays();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseQueryLeaveApplyDays> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionQueryLeaveApplyDays c = new ConditionQueryLeaveApplyDays();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseQueryLeaveApplyDays> result = executeQueryQueryLeaveApplyDays(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseQueryLeaveApplyDays> result;
		ConditionQueryLeaveApplyDays c = new ConditionQueryLeaveApplyDays();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryQueryLeaveApplyDays dao = new QueryQueryLeaveApplyDays();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseQueryLeaveApplyDays.ALL_CAPTIONS);
			for(BaseQueryLeaveApplyDays b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


