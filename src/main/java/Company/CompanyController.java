package Company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        
        
        @PutMapping("/{id}")
        public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company ){
        	boolean b=companyService.UpdateCompany(id, company);
        	if(b)
        	return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
        	else
        		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        	
        }
        
        
        @PostMapping
        public ResponseEntity<String> createCompany(@RequestBody Company company){
        	
        	companyService.createCompany(company);
        	
        	return new ResponseEntity("Company Created Successfully", HttpStatus.OK);
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        	boolean b=companyService.deleteCompany(id);
        	if(b) {
        	return new ResponseEntity("Company Deleted Successfully",HttpStatus.OK);
        	}
        	else {
        		return new ResponseEntity("Not Found",HttpStatus.NOT_FOUND);
        	}
        }
        
        public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        	Company c=companyService.getCompanyById(id);
        	if(c!=null) {
        	    return new ResponseEntity(c,HttpStatus.OK);
        	}else {
        		return new ResponseEntity("Company not found",HttpStatus.NOT_FOUND);
        	}
        }
        
}
