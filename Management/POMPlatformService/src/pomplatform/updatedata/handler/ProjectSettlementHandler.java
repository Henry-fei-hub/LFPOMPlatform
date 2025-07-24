package pomplatform.updatedata.handler;

import org.apache.log4j.Logger;
import pomplatform.updatedata.bean.BaseProjectSettlement;
import pomplatform.updatedata.bean.ConditionProjectSettlement;
import pomplatform.updatedata.query.QueryProjectSettlement;
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

public class ProjectSettlementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectSettlementHandler.class);

	public static BaseCollection<BaseProjectSettlement> executeQueryProjectSettlement(ConditionProjectSettlement c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectSettlement dao = new QueryProjectSettlement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectSettlement> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectSettlement c = new ConditionProjectSettlement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectSettlement> result = executeQueryProjectSettlement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectSettlement> result;
		ConditionProjectSettlement c = new ConditionProjectSettlement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectSettlement dao = new QueryProjectSettlement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectSettlement.ALL_CAPTIONS);
			for(BaseProjectSettlement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


