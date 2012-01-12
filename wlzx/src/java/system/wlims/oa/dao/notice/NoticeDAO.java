package system.wlims.oa.dao.notice;



import system.BaseDAO;
import system.DAOException;
import system.PaginationSupport;
import system.wlims.oa.entity.notice.NoticeModel;

public interface NoticeDAO  extends BaseDAO<NoticeModel>{

//	public List<NoticeModel> getNoticesByConditions(String userId, String type,
//			String scope, String emergence, String deparmentId, String title,
//			String beginDate, String endDate) ;
	
	public PaginationSupport<NoticeModel> getNoticesByConditions(String type,String scope,String emergence,String deparmentIds,
			String title, String beginDate,String endDate, Integer pageSize, Integer startIndex )throws DAOException;
}
