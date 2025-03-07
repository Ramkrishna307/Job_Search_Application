package Company;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
        private CompanyService companyService;

		public CompanyController(CompanyService companyService) {
			super();
			this.companyService = companyService;
		}
        
        @GetMapping
		public List<Company> getAllCompanies(){
        	return companyService.getAllCompanies();
		}
        
        
}
