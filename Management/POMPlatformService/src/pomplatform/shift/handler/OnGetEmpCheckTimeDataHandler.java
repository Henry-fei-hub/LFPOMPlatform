package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnGetEmpCheckTimeData;
import pomplatform.shift.bean.ConditionOnGetEmpCheckTimeData;
import pomplatform.shift.query.QueryOnGetEmpCheckTimeData;
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

public class OnGetEmpCheckTimeDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnGetEmpCheckTimeDataHandler.class);

	public static BaseCollection<BaseOnGetEmpCheckTimeData> executeQueryOnGetEmpCheckTimeData(ConditionOnGetEmpCheckTimeData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnGetEmpCheckTimeData dao = new QueryOnGetEmpCheckTimeData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnGetEmpCheckTimeData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnGetEmpCheckTimeData c = new ConditionOnGetEmpCheckTimeData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnGetEmpCheckTimeData> result = executeQueryOnGetEmpCheckTimeData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnGetEmpCheckTimeData> result;
		ConditionOnGetEmpCheckTimeData c = new ConditionOnGetEmpCheckTimeData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnGetEmpCheckTimeData dao = new QueryOnGetEmpCheckTimeData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnGetEmpCheckTimeData.ALL_CAPTIONS);
			for(BaseOnGetEmpCheckTimeData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


