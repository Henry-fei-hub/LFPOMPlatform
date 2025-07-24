package pomplatform.outPriceListItem.handler;

import org.apache.log4j.Logger;
import pomplatform.outPriceListItem.bean.BaseOutPriceListItem;
import pomplatform.outPriceListItem.bean.ConditionOutPriceListItem;
import pomplatform.outPriceListItem.query.QueryOutPriceListItem;
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

public class OutPriceListItemHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OutPriceListItemHandler.class);

	public static BaseCollection<BaseOutPriceListItem> executeQueryOutPriceListItem(ConditionOutPriceListItem c, KeyValuePair[] replacements ) throws Exception {
		QueryOutPriceListItem dao = new QueryOutPriceListItem();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOutPriceListItem> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOutPriceListItem c = new ConditionOutPriceListItem();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOutPriceListItem> result = executeQueryOutPriceListItem(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOutPriceListItem> result;
		ConditionOutPriceListItem c = new ConditionOutPriceListItem();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOutPriceListItem dao = new QueryOutPriceListItem();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOutPriceListItem.ALL_CAPTIONS);
			for(BaseOutPriceListItem b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


