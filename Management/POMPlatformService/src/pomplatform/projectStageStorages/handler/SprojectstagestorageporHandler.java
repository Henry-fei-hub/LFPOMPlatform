package pomplatform.projectStageStorages.handler;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import pomplatform.projectStageStorages.bean.BaseSprojectstagestoragepor;
import pomplatform.projectStageStorages.bean.ConditionSprojectstagestoragepor;
import pomplatform.projectStageStorages.query.QuerySprojectstagestoragepor;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class SprojectstagestorageporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectstagestorageporHandler.class);

	public static BaseCollection<BaseSprojectstagestoragepor> executeQuerySprojectstagestoragepor(ConditionSprojectstagestoragepor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectstagestoragepor dao = new QuerySprojectstagestoragepor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectstagestoragepor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectstagestoragepor c = new ConditionSprojectstagestoragepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectstagestoragepor> result = executeQuerySprojectstagestoragepor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectstagestoragepor> result;
		ConditionSprojectstagestoragepor c = new ConditionSprojectstagestoragepor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectstagestoragepor dao = new QuerySprojectstagestoragepor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectstagestoragepor.ALL_CAPTIONS);
			for(BaseSprojectstagestoragepor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


