package CompImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import Company.Company;
import Company.CompanyRepository;
import Company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies(){
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	
	
	
}
