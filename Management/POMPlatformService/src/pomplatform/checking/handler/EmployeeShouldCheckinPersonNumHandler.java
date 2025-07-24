package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseEmployeeShouldCheckinPersonNum;
import pomplatform.checking.bean.ConditionEmployeeShouldCheckinPersonNum;
import pomplatform.checking.query.QueryEmployeeShouldCheckinPersonNum;
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

public class EmployeeShouldCheckinPersonNumHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeShouldCheckinPersonNumHandler.class);

	public static BaseCollection<BaseEmployeeShouldCheckinPersonNum> executeQueryEmployeeShouldCheckinPersonNum(ConditionEmployeeShouldCheckinPersonNum c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeShouldCheckinPersonNum dao = new QueryEmployeeShouldCheckinPersonNum();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeShouldCheckinPersonNum> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeShouldCheckinPersonNum c = new ConditionEmployeeShouldCheckinPersonNum();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeShouldCheckinPersonNum> result = executeQueryEmployeeShouldCheckinPersonNum(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeShouldCheckinPersonNum> result;
		ConditionEmployeeShouldCheckinPersonNum c = new ConditionEmployeeShouldCheckinPersonNum();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeShouldCheckinPersonNum dao = new QueryEmployeeShouldCheckinPersonNum();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeShouldCheckinPersonNum.ALL_CAPTIONS);
			for(BaseEmployeeShouldCheckinPersonNum b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


