package pomplatform.funciton.handler;

import org.apache.log4j.Logger;
import pomplatform.funciton.bean.BaseGetDepartmentIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.ConditionGetDepartmentIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.query.QueryGetDepartmentIdByEmployeeIdAndFunctionCode;
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

public class GetDepartmentIdByEmployeeIdAndFunctionCodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetDepartmentIdByEmployeeIdAndFunctionCodeHandler.class);

	public static BaseCollection<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> executeQueryGetDepartmentIdByEmployeeIdAndFunctionCode(ConditionGetDepartmentIdByEmployeeIdAndFunctionCode c, KeyValuePair[] replacements ) throws Exception {
		QueryGetDepartmentIdByEmployeeIdAndFunctionCode dao = new QueryGetDepartmentIdByEmployeeIdAndFunctionCode();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetDepartmentIdByEmployeeIdAndFunctionCode c = new ConditionGetDepartmentIdByEmployeeIdAndFunctionCode();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> result = executeQueryGetDepartmentIdByEmployeeIdAndFunctionCode(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> result;
		ConditionGetDepartmentIdByEmployeeIdAndFunctionCode c = new ConditionGetDepartmentIdByEmployeeIdAndFunctionCode();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetDepartmentIdByEmployeeIdAndFunctionCode dao = new QueryGetDepartmentIdByEmployeeIdAndFunctionCode();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetDepartmentIdByEmployeeIdAndFunctionCode.ALL_CAPTIONS);
			for(BaseGetDepartmentIdByEmployeeIdAndFunctionCode b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


