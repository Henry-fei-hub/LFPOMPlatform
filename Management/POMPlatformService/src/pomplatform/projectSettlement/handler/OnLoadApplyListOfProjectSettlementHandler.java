package pomplatform.projectSettlement.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSettlement.bean.BaseOnLoadApplyListOfProjectSettlement;
import pomplatform.projectSettlement.bean.ConditionOnLoadApplyListOfProjectSettlement;
import pomplatform.projectSettlement.query.QueryOnLoadApplyListOfProjectSettlement;
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

public class OnLoadApplyListOfProjectSettlementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfProjectSettlementHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfProjectSettlement> executeQueryOnLoadApplyListOfProjectSettlement(ConditionOnLoadApplyListOfProjectSettlement c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfProjectSettlement dao = new QueryOnLoadApplyListOfProjectSettlement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfProjectSettlement> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfProjectSettlement c = new ConditionOnLoadApplyListOfProjectSettlement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfProjectSettlement> result = executeQueryOnLoadApplyListOfProjectSettlement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfProjectSettlement> result;
		ConditionOnLoadApplyListOfProjectSettlement c = new ConditionOnLoadApplyListOfProjectSettlement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfProjectSettlement dao = new QueryOnLoadApplyListOfProjectSettlement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfProjectSettlement.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfProjectSettlement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


