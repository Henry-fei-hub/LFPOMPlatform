package pomplatform.mcontracticcacccor.handler;

import org.apache.log4j.Logger;
import pomplatform.mcontracticcacccor.bean.BaseMcontracticcacccor;
import pomplatform.mcontracticcacccor.bean.ConditionMcontracticcacccor;
import pomplatform.mcontracticcacccor.query.QueryMcontracticcacccor;
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

public class McontracticcacccorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontracticcacccorHandler.class);

	public static BaseCollection<BaseMcontracticcacccor> executeQueryMcontracticcacccor(ConditionMcontracticcacccor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontracticcacccor dao = new QueryMcontracticcacccor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontracticcacccor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontracticcacccor c = new ConditionMcontracticcacccor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcontracticcacccor> result = executeQueryMcontracticcacccor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontracticcacccor> result;
		ConditionMcontracticcacccor c = new ConditionMcontracticcacccor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcontracticcacccor dao = new QueryMcontracticcacccor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontracticcacccor.ALL_CAPTIONS_2);
			for(BaseMcontracticcacccor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


