package Company;

import java.util.List;

public interface CompanyService {
     List<Company> getAllCompanies();
     boolean UpdateCompany(long id,Company company);
     void createCompany(Company company);
     boolean deleteCompany(long id);
     Company getCompanyById(Long id);
}
