package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.bean.ConditionOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.query.QueryOnloadPreprojectDataForMobile2;
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

public class OnloadPreprojectDataForMobile2Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnloadPreprojectDataForMobile2Handler.class);

	public static BaseCollection<BaseOnloadPreprojectDataForMobile2> executeQueryOnloadPreprojectDataForMobile2(ConditionOnloadPreprojectDataForMobile2 c, KeyValuePair[] replacements ) throws Exception {
		QueryOnloadPreprojectDataForMobile2 dao = new QueryOnloadPreprojectDataForMobile2();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnloadPreprojectDataForMobile2> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnloadPreprojectDataForMobile2 c = new ConditionOnloadPreprojectDataForMobile2();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnloadPreprojectDataForMobile2> result = executeQueryOnloadPreprojectDataForMobile2(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnloadPreprojectDataForMobile2> result;
		ConditionOnloadPreprojectDataForMobile2 c = new ConditionOnloadPreprojectDataForMobile2();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnloadPreprojectDataForMobile2 dao = new QueryOnloadPreprojectDataForMobile2();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnloadPreprojectDataForMobile2.ALL_CAPTIONS);
			for(BaseOnloadPreprojectDataForMobile2 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


