package pomplatform.salary.handler;

import org.apache.log4j.Logger;
import pomplatform.salary.bean.BaseRepeatAnnualLeave;
import pomplatform.salary.bean.ConditionRepeatAnnualLeave;
import pomplatform.salary.query.QueryRepeatAnnualLeave;
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

public class RepeatAnnualLeaveHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RepeatAnnualLeaveHandler.class);

	public static BaseCollection<BaseRepeatAnnualLeave> executeQueryRepeatAnnualLeave(ConditionRepeatAnnualLeave c, KeyValuePair[] replacements ) throws Exception {
		QueryRepeatAnnualLeave dao = new QueryRepeatAnnualLeave();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRepeatAnnualLeave> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRepeatAnnualLeave c = new ConditionRepeatAnnualLeave();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRepeatAnnualLeave> result = executeQueryRepeatAnnualLeave(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRepeatAnnualLeave> result;
		ConditionRepeatAnnualLeave c = new ConditionRepeatAnnualLeave();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRepeatAnnualLeave dao = new QueryRepeatAnnualLeave();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRepeatAnnualLeave.ALL_CAPTIONS);
			for(BaseRepeatAnnualLeave b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


