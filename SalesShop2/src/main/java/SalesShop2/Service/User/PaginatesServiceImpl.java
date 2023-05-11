package SalesShop2.Service.User;

import org.springframework.stereotype.Service;

import SalesShop2.Dto.PaginatesDto;
@Service
public class PaginatesServiceImpl {
	public PaginatesDto GetInforPaginates(int totalData, int limit, int currentPage)
	{
		PaginatesDto paginate= new PaginatesDto();
		paginate.setLimit(limit);
		paginate.setTotalPage(SetInforTotalPage(totalData, limit));
		paginate.setCurrentPage(checkCurrentPage(currentPage,paginate.getTotalPage()));
		
		
		int start=findStart(paginate.getCurrentPage(),limit);
		paginate.setStart(start);
		int end=findEnd(paginate.getStart(),limit,totalData);;
		paginate.setEnd(end);
		return paginate;
	}

	

	private int findEnd(int start, int limit, int totalData) {
		return start+limit >totalData ? totalData :(start+limit)-1;
	}



	private int findStart(int currentPage, int limit) {
		
		return ((currentPage-1)*limit)+1;
	}

	private int SetInforTotalPage(Integer totalData, Integer limit) {
		int totalPage=0;
		totalPage=totalData / limit;
		totalPage=totalPage * limit < totalData ? totalPage+1 : totalPage;
		return totalPage;
	}
	public int checkCurrentPage(int currentPage, int totalPage)
	{
		if(currentPage<1)
		{
			return 1;
		}
		if(currentPage> totalPage)
		{
			return totalPage;
		}
		return currentPage;
	}
		
		
	
}
 