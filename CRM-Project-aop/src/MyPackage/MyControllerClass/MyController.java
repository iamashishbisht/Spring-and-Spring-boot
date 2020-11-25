package MyPackage.MyControllerClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MyPackage.CustomerServicesClass.CustomerService;
import MyPackage.MyEntityClass.Customer;

@Controller
@RequestMapping("/customer")
public class MyController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String customerList(Model theModel) {

		// old version without no service class
		/*
		 * List<Customer> theCustomers = customerDao.getCustomerList();
		 * 
		 * System.out.println("size :" + theCustomers.size());
		 * 
		 * theModel.addAttribute("customer", theCustomers);
		 * theModel.addAttribute("size", theCustomers.size());
		 */

		// New version with service class

		List<Customer> theCustomers = customerService.getCustomerList();

		System.out.println("size :" + theCustomers.size());

		theModel.addAttribute("customer", theCustomers);
		theModel.addAttribute("size", theCustomers.size());

		return "customer-list";
	}

	@RequestMapping("/addCustomer")
	public String addCustomer(Model theModel) {

		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        
		customerService.addCustomer(theCustomer);

		/*
		 * Customer customer = new Customer(); theModel.addAttribute("customer",
		 * customer);
		 */

		return "redirect:list";
	}

	@RequestMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id, Model theModel) {
        
		// for console output
		System.out.println("c_id : " + id);

		Customer theCustomer = customerService.getCustomerById(id);
		
		theModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	/*
	 * @RequestMapping("/updateCustomer") public String
	 * updateCustomer(@ModelAttribute("customer") Customer theCustomer ) {
	 * 
	 * System.out.println("c_id : "+theCustomer.getId());
	 * 
	 * 
	 * return "updateCustomer"; }
	 */
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id, Model theModel) {
        
		// for console output
		System.out.println("c_id : " + id);

		customerService.deleteCustomer(id);
		
		
		return "redirect:list";
	}
}
