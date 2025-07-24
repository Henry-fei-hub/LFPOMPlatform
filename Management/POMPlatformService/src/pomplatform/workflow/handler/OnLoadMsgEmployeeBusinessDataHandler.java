package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadMsgEmployeeBusinessData;
import pomplatform.workflow.bean.ConditionOnLoadMsgEmployeeBusinessData;
import pomplatform.workflow.query.QueryOnLoadMsgEmployeeBusinessData;
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

public class OnLoadMsgEmployeeBusinessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMsgEmployeeBusinessDataHandler.class);

	public static BaseCollection<BaseOnLoadMsgEmployeeBusinessData> executeQueryOnLoadMsgEmployeeBusinessData(ConditionOnLoadMsgEmployeeBusinessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMsgEmployeeBusinessData dao = new QueryOnLoadMsgEmployeeBusinessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMsgEmployeeBusinessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMsgEmployeeBusinessData c = new ConditionOnLoadMsgEmployeeBusinessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMsgEmployeeBusinessData> result = executeQueryOnLoadMsgEmployeeBusinessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMsgEmployeeBusinessData> result;
		ConditionOnLoadMsgEmployeeBusinessData c = new ConditionOnLoadMsgEmployeeBusinessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMsgEmployeeBusinessData dao = new QueryOnLoadMsgEmployeeBusinessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMsgEmployeeBusinessData.ALL_CAPTIONS);
			for(BaseOnLoadMsgEmployeeBusinessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


