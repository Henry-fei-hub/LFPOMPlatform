package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadEmployeeMonthCheck;
import pomplatform.shift.bean.ConditionOnLoadEmployeeMonthCheck;
import pomplatform.shift.query.QueryOnLoadEmployeeMonthCheck;
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

public class OnLoadEmployeeMonthCheckHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeeMonthCheckHandler.class);

	public static BaseCollection<BaseOnLoadEmployeeMonthCheck> executeQueryOnLoadEmployeeMonthCheck(ConditionOnLoadEmployeeMonthCheck c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeeMonthCheck dao = new QueryOnLoadEmployeeMonthCheck();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeeMonthCheck> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeeMonthCheck c = new ConditionOnLoadEmployeeMonthCheck();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeeMonthCheck> result = executeQueryOnLoadEmployeeMonthCheck(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeeMonthCheck> result;
		ConditionOnLoadEmployeeMonthCheck c = new ConditionOnLoadEmployeeMonthCheck();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeeMonthCheck dao = new QueryOnLoadEmployeeMonthCheck();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeeMonthCheck.ALL_CAPTIONS);
			for(BaseOnLoadEmployeeMonthCheck b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


