package pomplatform.getEmployeeIdByRoleId.handler;

import org.apache.log4j.Logger;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleId;
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

public class getEmployeeIdByRoleIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(getEmployeeIdByRoleIdHandler.class);

	public static BaseCollection<BasegetEmployeeIdByRoleId> executeQuerygetEmployeeIdByRoleId(ConditiongetEmployeeIdByRoleId c, KeyValuePair[] replacements ) throws Exception {
		QuerygetEmployeeIdByRoleId dao = new QuerygetEmployeeIdByRoleId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasegetEmployeeIdByRoleId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditiongetEmployeeIdByRoleId c = new ConditiongetEmployeeIdByRoleId();
		c.setDataFromJSON(creteria);
		BaseCollection<BasegetEmployeeIdByRoleId> result = executeQuerygetEmployeeIdByRoleId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasegetEmployeeIdByRoleId> result;
		ConditiongetEmployeeIdByRoleId c = new ConditiongetEmployeeIdByRoleId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerygetEmployeeIdByRoleId dao = new QuerygetEmployeeIdByRoleId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasegetEmployeeIdByRoleId.ALL_CAPTIONS);
			for(BasegetEmployeeIdByRoleId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


