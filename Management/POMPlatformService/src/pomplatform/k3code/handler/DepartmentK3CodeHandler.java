package pomplatform.k3code.handler;

import org.apache.log4j.Logger;
import pomplatform.k3code.bean.BaseDepartmentK3Code;
import pomplatform.k3code.bean.ConditionDepartmentK3Code;
import pomplatform.k3code.query.QueryDepartmentK3Code;
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

public class DepartmentK3CodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DepartmentK3CodeHandler.class);

	public static BaseCollection<BaseDepartmentK3Code> executeQueryDepartmentK3Code(ConditionDepartmentK3Code c, KeyValuePair[] replacements ) throws Exception {
		QueryDepartmentK3Code dao = new QueryDepartmentK3Code();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDepartmentK3Code> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDepartmentK3Code c = new ConditionDepartmentK3Code();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDepartmentK3Code> result = executeQueryDepartmentK3Code(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDepartmentK3Code> result;
		ConditionDepartmentK3Code c = new ConditionDepartmentK3Code();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDepartmentK3Code dao = new QueryDepartmentK3Code();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDepartmentK3Code.ALL_CAPTIONS);
			for(BaseDepartmentK3Code b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


