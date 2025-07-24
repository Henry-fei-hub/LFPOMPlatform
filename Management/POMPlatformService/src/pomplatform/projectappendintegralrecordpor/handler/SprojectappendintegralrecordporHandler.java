package pomplatform.projectappendintegralrecordpor.handler;

import org.apache.log4j.Logger;
import pomplatform.projectappendintegralrecordpor.bean.BaseSprojectappendintegralrecordpor;
import pomplatform.projectappendintegralrecordpor.bean.ConditionSprojectappendintegralrecordpor;
import pomplatform.projectappendintegralrecordpor.query.QuerySprojectappendintegralrecordpor;
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

public class SprojectappendintegralrecordporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectappendintegralrecordporHandler.class);

	public static BaseCollection<BaseSprojectappendintegralrecordpor> executeQuerySprojectappendintegralrecordpor(ConditionSprojectappendintegralrecordpor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectappendintegralrecordpor dao = new QuerySprojectappendintegralrecordpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectappendintegralrecordpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectappendintegralrecordpor c = new ConditionSprojectappendintegralrecordpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectappendintegralrecordpor> result = executeQuerySprojectappendintegralrecordpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectappendintegralrecordpor> result;
		ConditionSprojectappendintegralrecordpor c = new ConditionSprojectappendintegralrecordpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectappendintegralrecordpor dao = new QuerySprojectappendintegralrecordpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectappendintegralrecordpor.ALL_CAPTIONS);
			for(BaseSprojectappendintegralrecordpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


