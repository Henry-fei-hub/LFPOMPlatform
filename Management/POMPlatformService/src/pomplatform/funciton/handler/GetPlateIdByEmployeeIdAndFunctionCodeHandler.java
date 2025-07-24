package pomplatform.funciton.handler;

import org.apache.log4j.Logger;
import pomplatform.funciton.bean.BaseGetPlateIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.ConditionGetPlateIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.query.QueryGetPlateIdByEmployeeIdAndFunctionCode;
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

public class GetPlateIdByEmployeeIdAndFunctionCodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetPlateIdByEmployeeIdAndFunctionCodeHandler.class);

	public static BaseCollection<BaseGetPlateIdByEmployeeIdAndFunctionCode> executeQueryGetPlateIdByEmployeeIdAndFunctionCode(ConditionGetPlateIdByEmployeeIdAndFunctionCode c, KeyValuePair[] replacements ) throws Exception {
		QueryGetPlateIdByEmployeeIdAndFunctionCode dao = new QueryGetPlateIdByEmployeeIdAndFunctionCode();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetPlateIdByEmployeeIdAndFunctionCode> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetPlateIdByEmployeeIdAndFunctionCode c = new ConditionGetPlateIdByEmployeeIdAndFunctionCode();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetPlateIdByEmployeeIdAndFunctionCode> result = executeQueryGetPlateIdByEmployeeIdAndFunctionCode(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetPlateIdByEmployeeIdAndFunctionCode> result;
		ConditionGetPlateIdByEmployeeIdAndFunctionCode c = new ConditionGetPlateIdByEmployeeIdAndFunctionCode();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetPlateIdByEmployeeIdAndFunctionCode dao = new QueryGetPlateIdByEmployeeIdAndFunctionCode();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetPlateIdByEmployeeIdAndFunctionCode.ALL_CAPTIONS);
			for(BaseGetPlateIdByEmployeeIdAndFunctionCode b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


