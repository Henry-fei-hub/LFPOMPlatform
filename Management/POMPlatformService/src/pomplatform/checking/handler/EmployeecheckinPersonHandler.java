package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseEmployeecheckinPerson;
import pomplatform.checking.bean.ConditionEmployeecheckinPerson;
import pomplatform.checking.query.QueryEmployeecheckinPerson;
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

public class EmployeecheckinPersonHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeecheckinPersonHandler.class);

	public static BaseCollection<BaseEmployeecheckinPerson> executeQueryEmployeecheckinPerson(ConditionEmployeecheckinPerson c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeecheckinPerson dao = new QueryEmployeecheckinPerson();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeecheckinPerson> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeecheckinPerson c = new ConditionEmployeecheckinPerson();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeecheckinPerson> result = executeQueryEmployeecheckinPerson(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeecheckinPerson> result;
		ConditionEmployeecheckinPerson c = new ConditionEmployeecheckinPerson();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeecheckinPerson dao = new QueryEmployeecheckinPerson();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeecheckinPerson.ALL_CAPTIONS);
			for(BaseEmployeecheckinPerson b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


