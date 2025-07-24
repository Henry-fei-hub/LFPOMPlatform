package pomplatform.role.handler;

import org.apache.log4j.Logger;
import pomplatform.role.bean.BaseEmployeeRoleInfo;
import pomplatform.role.bean.ConditionEmployeeRoleInfo;
import pomplatform.role.query.QueryEmployeeRoleInfo;
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

public class EmployeeRoleInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeRoleInfoHandler.class);

	public static BaseCollection<BaseEmployeeRoleInfo> executeQueryEmployeeRoleInfo(ConditionEmployeeRoleInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeRoleInfo dao = new QueryEmployeeRoleInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeRoleInfo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeRoleInfo c = new ConditionEmployeeRoleInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeRoleInfo> result = executeQueryEmployeeRoleInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeRoleInfo> result;
		ConditionEmployeeRoleInfo c = new ConditionEmployeeRoleInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeRoleInfo dao = new QueryEmployeeRoleInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeRoleInfo.ALL_CAPTIONS);
			for(BaseEmployeeRoleInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


