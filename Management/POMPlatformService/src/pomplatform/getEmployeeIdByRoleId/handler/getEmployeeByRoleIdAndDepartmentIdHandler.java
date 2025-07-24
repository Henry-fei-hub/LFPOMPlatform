package pomplatform.getEmployeeIdByRoleId.handler;

import org.apache.log4j.Logger;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeByRoleIdAndDepartmentId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeByRoleIdAndDepartmentId;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeByRoleIdAndDepartmentId;
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

public class getEmployeeByRoleIdAndDepartmentIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(getEmployeeByRoleIdAndDepartmentIdHandler.class);

	public static BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> executeQuerygetEmployeeByRoleIdAndDepartmentId(ConditiongetEmployeeByRoleIdAndDepartmentId c, KeyValuePair[] replacements ) throws Exception {
		QuerygetEmployeeByRoleIdAndDepartmentId dao = new QuerygetEmployeeByRoleIdAndDepartmentId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditiongetEmployeeByRoleIdAndDepartmentId c = new ConditiongetEmployeeByRoleIdAndDepartmentId();
		c.setDataFromJSON(creteria);
		BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> result = executeQuerygetEmployeeByRoleIdAndDepartmentId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> result;
		ConditiongetEmployeeByRoleIdAndDepartmentId c = new ConditiongetEmployeeByRoleIdAndDepartmentId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerygetEmployeeByRoleIdAndDepartmentId dao = new QuerygetEmployeeByRoleIdAndDepartmentId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasegetEmployeeByRoleIdAndDepartmentId.ALL_CAPTIONS);
			for(BasegetEmployeeByRoleIdAndDepartmentId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


