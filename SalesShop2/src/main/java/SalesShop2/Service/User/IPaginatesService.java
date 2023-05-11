package SalesShop2.Service.User;

import org.springframework.stereotype.Service;

import SalesShop2.Dto.PaginatesDto;

@Service
public interface IPaginatesService {
	public PaginatesDto GetInforPaginates(int totalData, int limit, int currentPage);
	
} 
