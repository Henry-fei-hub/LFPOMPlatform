package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnLeaveSubsidysData;
import pomplatform.payment.bean.ConditionOnLeaveSubsidysData;
import pomplatform.payment.query.QueryOnLeaveSubsidysData;
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

public class OnLeaveSubsidysDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLeaveSubsidysDataHandler.class);

	public static BaseCollection<BaseOnLeaveSubsidysData> executeQueryOnLeaveSubsidysData(ConditionOnLeaveSubsidysData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLeaveSubsidysData dao = new QueryOnLeaveSubsidysData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLeaveSubsidysData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLeaveSubsidysData c = new ConditionOnLeaveSubsidysData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLeaveSubsidysData> result = executeQueryOnLeaveSubsidysData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLeaveSubsidysData> result;
		ConditionOnLeaveSubsidysData c = new ConditionOnLeaveSubsidysData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLeaveSubsidysData dao = new QueryOnLeaveSubsidysData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLeaveSubsidysData.ALL_CAPTIONS);
			for(BaseOnLeaveSubsidysData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


