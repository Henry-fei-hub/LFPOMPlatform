package pomplatform.project.handler;

import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.project.bean.BaseOnLoadProjectOverview;
import pomplatform.project.bean.ConditionOnLoadProjectOverview;
import pomplatform.project.query.QueryOnLoadProjectOverview;

public class OnLoadProjectOverviewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectOverviewHandler.class);

	public static BaseCollection<BaseOnLoadProjectOverview> executeQueryOnLoadProjectOverview(ConditionOnLoadProjectOverview c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectOverview dao = new QueryOnLoadProjectOverview();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectOverview> result = dao.execute( c.getKeyValues(), c) ;
		List<BaseOnLoadProjectOverview> collections =new ArrayList<BaseOnLoadProjectOverview>();
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			BaseOnLoadProjectOverview projectOverview = result.getCollections().get(0);
			//已经流程通过了的阶段的占比之和
			BigDecimal percent = BaseHelpUtils.getBigDecimalValue(projectOverview.getPercent());
			//订单积分
			BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(projectOverview.getProjectIntegral());
			//预留积分
			BigDecimal reserveIntegral = BaseHelpUtils.getBigDecimalValue(projectOverview.getReserveIntegral());
			//流程完成的已结算积分
			BigDecimal totalAmount = BaseHelpUtils.getBigDecimalValue(projectOverview.getTotalAmount());
			
			//页面显示已结算积分
			projectOverview.setSureAmount(totalAmount);
			//页面显示本次结算积分默认为0
			projectOverview.setTotalAmount(BigDecimal.ZERO);
//			if(percent.compareTo(new BigDecimal(100))==0) {
//				projectOverview.setProjectAmount(BigDecimal.ZERO);
//				projectOverview.setLeftAmount(BigDecimal.ZERO);
//				projectOverview.setReserveAmount(reserveIntegral);
//			}else {
//			}
				 projectIntegral = percent.multiply(projectIntegral).multiply(new BigDecimal(0.01)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				 reserveIntegral = percent.multiply(reserveIntegral).multiply(new BigDecimal(0.01)).setScale(2, BigDecimal.ROUND_HALF_DOWN); 
				 projectOverview.setReserveAmount(reserveIntegral);
				 projectOverview.setProjectAmount((projectIntegral.subtract(totalAmount)).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:projectIntegral.subtract(totalAmount) );
				 projectOverview.setLeftAmount((projectIntegral.subtract(totalAmount)).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:projectIntegral.subtract(totalAmount) );
			
			collections.add(projectOverview);
		}
		result.setCollections(collections);
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectOverview c = new ConditionOnLoadProjectOverview();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectOverview> result = executeQueryOnLoadProjectOverview(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectOverview> result;
		ConditionOnLoadProjectOverview c = new ConditionOnLoadProjectOverview();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectOverview dao = new QueryOnLoadProjectOverview();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectOverview.ALL_CAPTIONS);
			for(BaseOnLoadProjectOverview b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


