package pomplatform.orderplacement.handler;

import org.apache.log4j.Logger;
import pomplatform.orderplacement.bean.BaseOrderPlacement;
import pomplatform.orderplacement.bean.ConditionOrderPlacement;
import pomplatform.orderplacement.query.QueryOrderPlacement;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.dao.OrderInfoChild;
import delicacy.common.BaseCollection;

public class OrderPlacementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OrderPlacementHandler.class);

	public static BaseCollection<BaseOrderPlacement> executeQueryOrderPlacement(ConditionOrderPlacement c, KeyValuePair[] replacements ) throws Exception {
		QueryOrderPlacement dao = new QueryOrderPlacement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOrderPlacement> result = dao.execute( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			OrderInfoChild daoOrderInfoChild = new OrderInfoChild();
			for(BaseOrderPlacement bean : result.getCollections()){
				daoOrderInfoChild.setConditionOrderInfoId("=", bean.getOrderInfoId());
				bean.setDetailOrderInfoChild(daoOrderInfoChild.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOrderPlacement c = new ConditionOrderPlacement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOrderPlacement> result = executeQueryOrderPlacement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOrderPlacement> result;
		ConditionOrderPlacement c = new ConditionOrderPlacement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOrderPlacement dao = new QueryOrderPlacement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOrderPlacement.ALL_CAPTIONS);
			for(BaseOrderPlacement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


