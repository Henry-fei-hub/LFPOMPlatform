package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadEmpShiftInfo;
import pomplatform.shift.bean.ConditionOnLoadEmpShiftInfo;
import pomplatform.shift.query.QueryOnLoadEmpShiftInfo;
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

public class OnLoadEmpShiftInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmpShiftInfoHandler.class);

	public static BaseCollection<BaseOnLoadEmpShiftInfo> executeQueryOnLoadEmpShiftInfo(ConditionOnLoadEmpShiftInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmpShiftInfo dao = new QueryOnLoadEmpShiftInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmpShiftInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmpShiftInfo c = new ConditionOnLoadEmpShiftInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmpShiftInfo> result = executeQueryOnLoadEmpShiftInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmpShiftInfo> result;
		ConditionOnLoadEmpShiftInfo c = new ConditionOnLoadEmpShiftInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmpShiftInfo dao = new QueryOnLoadEmpShiftInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmpShiftInfo.ALL_CAPTIONS);
			for(BaseOnLoadEmpShiftInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


