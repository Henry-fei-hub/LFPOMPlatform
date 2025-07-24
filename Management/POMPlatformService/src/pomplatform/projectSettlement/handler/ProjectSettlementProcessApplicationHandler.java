package pomplatform.projectSettlement.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSettlement.bean.BaseProjectSettlementProcessApplication;
import pomplatform.projectSettlement.bean.ConditionProjectSettlementProcessApplication;
import pomplatform.projectSettlement.query.QueryProjectSettlementProcessApplication;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import delicacy.common.BaseCollection;

public class ProjectSettlementProcessApplicationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectSettlementProcessApplicationHandler.class);

	public static BaseCollection<BaseProjectSettlementProcessApplication> executeQueryProjectSettlementProcessApplication(ConditionProjectSettlementProcessApplication c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectSettlementProcessApplication dao = new QueryProjectSettlementProcessApplication();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectSettlementProcessApplication> result = dao.execute( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectSettlementDetail daoProjectSettlementDetail = new ProjectSettlementDetail();
			for(BaseProjectSettlementProcessApplication bean : result.getCollections()){
				daoProjectSettlementDetail.setConditionSettlementId("=", bean.getSettlementId());
				bean.setDetailProjectSettlementDetail(daoProjectSettlementDetail.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectSettlementProcessApplication c = new ConditionProjectSettlementProcessApplication();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectSettlementProcessApplication> result = executeQueryProjectSettlementProcessApplication(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectSettlementProcessApplication> result;
		ConditionProjectSettlementProcessApplication c = new ConditionProjectSettlementProcessApplication();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectSettlementProcessApplication dao = new QueryProjectSettlementProcessApplication();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectSettlementProcessApplication.ALL_CAPTIONS);
			for(BaseProjectSettlementProcessApplication b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


