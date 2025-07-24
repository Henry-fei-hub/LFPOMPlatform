package pomplatform.projectprice;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import pomplatform.projectprice.bean.BaseSprojectunitpricepagor;
import pomplatform.projectprice.bean.ConditionSprojectunitpricepagor;
import pomplatform.projectprice.query.QuerySprojectunitpricepagor;

/**
 *
 * @author lxf
 */
public class ProjectPriceCalculation {

	private static final Logger __logger = Logger.getLogger(ProjectPriceCalculation.class);

	public static void main(String[] args) {
		try {
			System.out.println(calculateProjectPrice(1, 3, 0, 1, BigDecimal.valueOf(18000)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

        /**
         * 设定项目的总积分、项目积分和预留积分
         * 目前计算流程(项目总积分*投诉折算比例=投诉保证金;项目总积分*核算比例=预留积分;;项目总积分-预留积分=项目积分;预留积分-投诉保证金=预留积分)
         * 正规计算流程(项目总积分*投诉折算比例=投诉保证金;项目总积分=项目总积分-投诉保证金;项目总积分*核算比例=预留积分;项目总积分-预留积分=项目积分)
         * @param bean
         * @param totalAmount	项目总积分
         * @param percent 		核算比例
         * @throws java.sql.SQLException 
         */
	public static void commonCalculation(BaseProject bean, BigDecimal totalAmount, BigDecimal percent) throws SQLException {
		BigDecimal oneHundred = new BigDecimal(100);
        //投诉折算比例
        BigDecimal complaintPercentage = new BigDecimal(5);
        if(null==bean.getComplaintPercentage()){
        	bean.setComplaintPercentage(complaintPercentage);
        }else{
        	complaintPercentage = bean.getComplaintPercentage();
        }
        //项目遗留折算比例
        BigDecimal oldDiscount = null == bean.getOldProjectDiscount() ? BigDecimal.ZERO : bean.getOldProjectDiscount().divide(oneHundred,5,BigDecimal.ROUND_DOWN);
		if (oldDiscount.compareTo(BigDecimal.ZERO) > 0) {
			totalAmount = totalAmount.multiply(oldDiscount);
		}
        totalAmount = BaseHelpUtils.format(totalAmount, 2);
//                获取项目最新的项目总积分，检索该项目运行期间进行的追加积分的操作，累加追加的积分
//                int projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
//                根据项目id去检索该项目追加的积分
//                ProjectAppendIntegralRecord appendIntegralDao = new ProjectAppendIntegralRecord();
//                appendIntegralDao.setConditionProjectId("=", projectId);
//                List<BaseProjectAppendIntegralRecord> listAppendIntegral = appendIntegralDao.conditionalLoad();
//                double appendTotalIntegral = 0;//初始化追加的项目总积分
//                double appendProjectIntegral = 0;//初始化追加的项目积分
//                double appendReserveIntegral = 0;//初始化追加的预留积分
//                if(!BaseHelpUtils.isNullOrEmpty(appendIntegralDao) && listAppendIntegral.size() > 0){
//                    for(BaseProjectAppendIntegralRecord e : listAppendIntegral){
//                        //获取追加的项目积分
//                        double appendIntegral = Math.round(BaseHelpUtils.getDoubleValue(e.getAppendIntegral()));
//                        appendTotalIntegral += appendIntegral;
//                        //获取追加积分的核算比例
//                        double percentage = BaseHelpUtils.getDoubleValue(e.getPercentage());
//                        //根据核算比例去获取预留积分
//                        double reserveInte = Math.round(appendIntegral*percentage/100);//根据追加积分和核算比例计算出的预留积分
//                        appendReserveIntegral += reserveInte;
//                        appendProjectIntegral += appendIntegral - reserveInte;
//                    }
//                }
//                根据项目id去检索调整的积分(即将预留积分调整到项目积分)
//                ProjectIntegralChangeRecord changeIntegralDao = new ProjectIntegralChangeRecord();
//                changeIntegralDao.setConditionProjectId("=", projectId);
//                List<BaseProjectIntegralChangeRecord> listChangeIntegral = changeIntegralDao.conditionalLoad();
////                double changeIntegral = 0;//初始化调整的积分
//                if(!BaseHelpUtils.isNullOrEmpty(listChangeIntegral) && listChangeIntegral.size() > 0){
//                    for(BaseProjectIntegralChangeRecord e : listChangeIntegral){
//                        changeIntegral += Math.round(BaseHelpUtils.getDoubleValue(e.getTransferIntegral()));
//                    }
//                }
//                根据项目id去检索转移给别的项目的积分(即项目该项目A的预留积分转移到B的预留积分)
//                ProjectIntegralTransferRecord transferIntegralDao = new ProjectIntegralTransferRecord();
//                transferIntegralDao.setConditionFromProjectId("=", projectId);
//                List<BaseProjectIntegralTransferRecord> listTransferIntegralFrom = transferIntegralDao.conditionalLoad();
////                double toReserveIntegral = 0;//初始化转移出去的预留积分
//                if(!BaseHelpUtils.isNullOrEmpty(listTransferIntegralFrom) && listTransferIntegralFrom.size() > 0){
//                    for(BaseProjectIntegralTransferRecord e : listTransferIntegralFrom){
//                        toReserveIntegral += Math.round(BaseHelpUtils.getDoubleValue(e.getTransferIntegral()));
//                    }
//                }
//                根据项目id去检索转移从别的项目转移来的积分(即项目从项目A的预留积分转移到该项目B的预留积分)
//                transferIntegralDao.clear();
//                transferIntegralDao.setConditionToProjectId("=", projectId);
//                List<BaseProjectIntegralTransferRecord> listTransferIntegralTo = transferIntegralDao.conditionalLoad();
////                double fromReserveIntegral = 0;//初始化转移进来的预留积分
//                if(!BaseHelpUtils.isNullOrEmpty(listTransferIntegralTo) && listTransferIntegralTo.size() > 0){
//                    for(BaseProjectIntegralTransferRecord e : listTransferIntegralTo){
//                        fromReserveIntegral += Math.round(BaseHelpUtils.getDoubleValue(e.getTransferIntegral()));
//                    }
//                }
//                根据项目id去检索该项目已经发放出去的预留积分
//                ProjectIntegralAssignRecord assignIntegralDao = new ProjectIntegralAssignRecord();
//                assignIntegralDao.setConditionProjectId("=", projectId);
//                List<BaseProjectIntegralAssignRecord> listAssignIntegral = assignIntegralDao.conditionalLoad();
//                double assignIntegral = 0;//初始化项目发放的预留积分
//                if(!BaseHelpUtils.isNullOrEmpty(listAssignIntegral) && listAssignIntegral.size() > 0){
//                    for(BaseProjectIntegralAssignRecord e : listAssignIntegral){
//                        assignIntegral += BaseHelpUtils.getDoubleValue(e.getAssignIntegral());
//                    }
//                }
//      旧：设置项目总积分，即计算得出的项目总积分+追加的项目积分
//		bean.setTotalIntegral(BigDecimal.valueOf(totalAmount+appendTotalIntegral));
//		新：设置项目总积分，即计算得出的项目总积分
		bean.setTotalIntegral(totalAmount);
//      旧：获取投诉保证金，即项目总积分*投诉折算比例
//      double complaintIntegral = Math.round((totalAmount+appendTotalIntegral) * complaintPercentage / 100.0);
//		新：获取投诉保证金，即项目总积分*投诉折算比例
        BigDecimal complaintIntegral = totalAmount.multiply(complaintPercentage).divide(oneHundred, 2, BigDecimal.ROUND_DOWN);
		BigDecimal reserved = BigDecimal.ZERO;
		//设置投诉保证金
		bean.setComplaintIntegral(complaintIntegral);
		if(bean.getParentId()==0){//630项目
			reserved = BaseHelpUtils.format(totalAmount.multiply(percent), 2);
//			旧：设置项目的预留积分，即计算得出的预留积分+追加的预留积分-调整积分-转移出去的预留积分+转移进来的预留积分-发放出去的积分-投诉保证金
//			bean.setReserveIntegral(BigDecimal.valueOf(reserved+appendReserveIntegral-changeIntegral-toReserveIntegral+fromReserveIntegral-assignIntegral-complaintIntegral));
//			旧：设置项目的预留积分，即计算得出的预留积分-投诉保证金
			bean.setReserveIntegral(reserved.subtract(complaintIntegral));
//			旧：设置项目的项目积分，即计算得出的项目积分+追加的项目积分+调整积分
//			bean.setProjectIntegral(BigDecimal.valueOf(totalAmount - reserved+appendProjectIntegral+changeIntegral));
			bean.setProjectIntegral(totalAmount.subtract(reserved));
		}else{//不是630项目
			reserved = BaseHelpUtils.format((totalAmount.subtract(complaintIntegral)).multiply(percent), 2);
//			旧：设置项目的预留积分，即计算得出的预留积分+追加的预留积分-调整积分-转移出去的预留积分+转移进来的预留积分-发放出去的积分
//			bean.setReserveIntegral(BigDecimal.valueOf(reserved+appendReserveIntegral-changeIntegral-toReserveIntegral+fromReserveIntegral-assignIntegral));
			bean.setReserveIntegral(reserved);
//			旧：设置项目的项目积分，即计算得出的项目积分+追加的项目积分+调整积分
//			bean.setProjectIntegral(BigDecimal.valueOf(totalAmount - reserved - complaintIntegral+appendProjectIntegral+changeIntegral));
//			新：设置项目的项目积分，即计算得出的项目积分=总积分-预留积分-投诉保证金
			bean.setProjectIntegral(totalAmount.subtract(reserved).subtract(complaintIntegral));
		}
	}
        
        /**
         * 计算项目积分
         * @param bean
         * @throws SQLException 
         */
	public static void calculateProjectPrice(BaseProject bean) throws SQLException {
		BigDecimal totalAmount = BigDecimal.ZERO;//项目总积分
		BigDecimal percent = BigDecimal.valueOf(0.3);//核算比例
		percent = (bean.getPercentage() == null ?BigDecimal.ZERO : BaseHelpUtils.format(bean.getPercentage().divide(BigDecimal.valueOf(100)),5));
		BigDecimal humanAmount = BaseHelpUtils.getBigDecimalValue(bean.getHumanAmount());
		if(humanAmount.compareTo(BigDecimal.ZERO) > 0){
			totalAmount = humanAmount;
			commonCalculation(bean, totalAmount,percent);
			return;
		}
		switch (bean.getPlateId()) {
			case 1: // 商业
				totalAmount = calculateProjectPrice(bean.getPlateId(), bean.getProjectLevel(), 0, 1, bean.getCommonArea());
				if (bean.getLogisticsArea().doubleValue() > 0.0) {
					totalAmount = totalAmount.add(calculateProjectPrice(bean.getPlateId(), bean.getProjectLevel(), 1, 1, bean.getLogisticsArea())) ;
				}
				if (bean.getBimArea().doubleValue() > 0.0) {
					totalAmount = totalAmount.add(calculateProjectPrice(bean.getPlateId(), 0, 0, 2, bean.getBimArea()));
				}
				if (bean.getCadArea().doubleValue() > 0.0) {
					totalAmount = totalAmount.add(calculateProjectPrice(bean.getPlateId(), 0, 1, 3, bean.getCadArea())) ;
				}
				commonCalculation(bean, totalAmount,percent);
				break;
			case 6: // 制图中心
				totalAmount = calculateProjectPrice(bean.getPlateId(), bean.getProjectLevel(), 0, 0, bean.getCommonArea());
				if (bean.getLogisticsArea().doubleValue() > 0) {
					totalAmount = totalAmount.add(calculateProjectPrice(bean.getPlateId(), bean.getProjectLevel(), 1, 0, bean.getLogisticsArea()));
				}
				commonCalculation(bean, totalAmount, percent);
				break;
			case 2: // 酒店
				totalAmount = bean.getTotalAmount().multiply(BigDecimal.valueOf(0.7));
				commonCalculation(bean,totalAmount, percent);
				break;
			case 3: // 办公
				switch (bean.getDesignType()) {
					case 30: //公共类
						totalAmount = (bean.getTotalAmount() == null ? BigDecimal.ZERO : bean.getTotalAmount()).multiply(BigDecimal.valueOf(0.45));
						break;
					default:
						totalAmount = calculateProjectPrice(bean.getPlateId(), 0, bean.getDesignType(), 0, bean.getCommonArea() == null ? BigDecimal.ZERO : bean.getCommonArea());
						break;
				}
				commonCalculation(bean, totalAmount, percent);
				break;
			case 4: // 地铁
				totalAmount = (bean.getTotalAmount() == null ? BigDecimal.ZERO : bean.getTotalAmount()).multiply(BigDecimal.valueOf(0.4));
				commonCalculation(bean, totalAmount,percent);
				break;
			case 5: // 机电
				if (bean.getDesignType() == 48) {
					totalAmount = bean.getTotalAmount().multiply(BigDecimal.valueOf(0.01));
					commonCalculation(bean,totalAmount,percent);
					break;
				}
				if (bean.getCommonArea().compareTo(BigDecimal.valueOf(5000)) < 0 
					|| bean.getDesignType() == 46
					|| bean.getDesignType() == 47) {
					totalAmount = bean.getTotalAmount().multiply(BigDecimal.valueOf(0.4));
					commonCalculation(bean,totalAmount,percent);
					break;
				}
				totalAmount = calculateProjectPrice(bean.getPlateId(), bean.getDesignType(), bean.getProjectType(), 0, bean.getCommonArea());
				commonCalculation(bean,totalAmount,percent);
				break;
		}
	}

	public static BigDecimal calculateProjectPrice(int plate_id, int grade_id, int area_id, int square_id, BigDecimal square) throws SQLException {
		QuerySprojectunitpricepagor pup = new QuerySprojectunitpricepagor();
		ConditionSprojectunitpricepagor c = new ConditionSprojectunitpricepagor();
		c.setAreaId(area_id);
		c.setGradeId(grade_id);
		c.setPlateId(plate_id);
		if (square_id > 0) {
			c.setSquareId(square_id);
		}
		c.setSquare(square);
		BaseCollection<BaseSprojectunitpricepagor> pups = pup.executeQuery(null, c);
		BigDecimal amount = BigDecimal.ZERO;
		int count = 0;
		for (BaseSprojectunitpricepagor bpup : pups.getCollections()) {
			__logger.debug(String.format("No.%1$d", count++));
			BigDecimal min = bpup.getMinSquare() == null ? BigDecimal.ZERO : bpup.getMinSquare();
			BigDecimal max = bpup.getMaxSquare() == null ? BigDecimal.ZERO : bpup.getMaxSquare();
			BigDecimal unitPrice = bpup.getUnitPrice() == null ?BigDecimal.ZERO : bpup.getUnitPrice();
			__logger.debug(String.format("PID:%1$d,AID:%2$d,PLD:%3$d, MIN:%4$.0f, MAX:%5$.0f, PRICE:%6$.0f", bpup.getPlateId(), bpup.getAreaId(), bpup.getGradeId(), bpup.getMinSquare().doubleValue(), bpup.getMaxSquare().doubleValue(), bpup.getUnitPrice().doubleValue()));
			if (min.compareTo(BigDecimal.valueOf(100)) < 0) {
				if (area_id == 0) {
					amount = amount.add(unitPrice) ;
				} else {
					amount = amount.add(unitPrice.multiply((square.compareTo(max) > 0  ? max : square)));
					if (square.compareTo(max) < 0) {
						break;
					}
				}
				continue;
			}
			if (square.compareTo(max) <= 0 && square.compareTo(min) > 0) {
				amount = amount.add(square.subtract(min).multiply(unitPrice));
				break;
			}
			amount = amount.add(max.subtract(min).multiply(unitPrice));
		}
		return amount;
	}

}
