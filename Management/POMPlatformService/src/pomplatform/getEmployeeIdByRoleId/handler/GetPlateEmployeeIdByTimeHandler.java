package pomplatform.getEmployeeIdByRoleId.handler;

import org.apache.log4j.Logger;
import pomplatform.getEmployeeIdByRoleId.bean.BaseGetPlateEmployeeIdByTime;
import pomplatform.getEmployeeIdByRoleId.bean.ConditionGetPlateEmployeeIdByTime;
import pomplatform.getEmployeeIdByRoleId.query.QueryGetPlateEmployeeIdByTime;
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

public class GetPlateEmployeeIdByTimeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetPlateEmployeeIdByTimeHandler.class);

	public static BaseCollection<BaseGetPlateEmployeeIdByTime> executeQueryGetPlateEmployeeIdByTime(ConditionGetPlateEmployeeIdByTime c, KeyValuePair[] replacements ) throws Exception {
		QueryGetPlateEmployeeIdByTime dao = new QueryGetPlateEmployeeIdByTime();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetPlateEmployeeIdByTime> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetPlateEmployeeIdByTime c = new ConditionGetPlateEmployeeIdByTime();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetPlateEmployeeIdByTime> result = executeQueryGetPlateEmployeeIdByTime(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetPlateEmployeeIdByTime> result;
		ConditionGetPlateEmployeeIdByTime c = new ConditionGetPlateEmployeeIdByTime();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetPlateEmployeeIdByTime dao = new QueryGetPlateEmployeeIdByTime();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetPlateEmployeeIdByTime.ALL_CAPTIONS);
			for(BaseGetPlateEmployeeIdByTime b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


