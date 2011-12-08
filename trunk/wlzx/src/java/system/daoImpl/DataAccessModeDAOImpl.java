/**
 * 
 */
package system.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;
import system.dao.DataAccessModeDAO;
import system.entity.DataAccessModeModel;
import system.utils.StringUtils;


  
  /**
 *
 * 类名称：DataAccessModeDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-15 上午09:21:16
 * 修改人：wuyuyue
 * 修改时间：2011-4-15 上午09:21:16
 * 修改备注：
 * @version
 *
 */

public class DataAccessModeDAOImpl extends BaseDAOImpl<DataAccessModeModel>  implements DataAccessModeDAO{
//	/** 
//     * 获取某数据访问方式所属操作
//     * @param dataAccessModeModel 
//     * @return OperationModel 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public OperationModel getBelongOperation(DataAccessModeModel dataAccessModeModel){
//		return null;
//	}
	/** 
	  * 通过唯一性系统标记查询数据访问方式实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public DataAccessModeModel getDAMBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(DataAccessModeModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<DataAccessModeModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

	/** 
	  * 通过唯一性系统标记查询数据访问方式实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public DataAccessModeModel getDataAccessModeBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(DataAccessModeModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<DataAccessModeModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<DataAccessModeModel> getAllResources() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DataAccessModeModel.class);
		List<DataAccessModeModel> result = this.getListByCriteria(criteria);
		return result;
	}

	public void removeDataAccessModeBySymbol(String symbol) {
		this.remove(getDataAccessModeBySymbol(symbol));	
	}
}
