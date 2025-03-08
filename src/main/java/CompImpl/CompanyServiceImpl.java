package CompImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Company.Company;
import Company.CompanyRepository;
import Company.CompanyService;
import Job.Job;

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

	@Override
	public boolean UpdateCompany(long id, Company company) {
		// TODO Auto-generated method stub

		Optional<Company> companyOptional = companyRepository.findById(id);

		if (companyOptional.isPresent()) {
			Company CompanyTemp = companyOptional.get();
			CompanyTemp.setName(company.getName());

			CompanyTemp.setDescription(company.getDescription());

			companyRepository.save(CompanyTemp);
			return true;

		}
		return false;

	}

	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
		
	}
	
	
	
	
	

	
	
	
}
