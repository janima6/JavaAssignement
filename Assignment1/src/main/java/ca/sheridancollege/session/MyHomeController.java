package ca.sheridancollege.session;

import lombok.*;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.Bean.DogBean;
import ca.sheridancollege.DAO.DAO;

@Controller
public class MyHomeController {
	
	
	@GetMapping("/")
	public String goAddHome() {
		return "addDog.html";
		
	}

	
	@GetMapping("/aboutus")
	public String gotoAbout() {
		return "Aboutus.html";
		
	}

	
	@GetMapping("/contactus")
	public String gotoContact() {
		return "contactus.html";
		
	}

	@GetMapping("/add")
	public String addDog(@RequestParam String dogName,
			@RequestParam String OwnerName,
			@RequestParam String breed,
			@RequestParam String group,
			@RequestParam String gender,
			@RequestParam String ranking,
			Model model
			) {
	
		
		if(!dogName.isEmpty()&&!OwnerName.isEmpty()&&!breed.isEmpty()&&!group.isEmpty()&&!gender.isEmpty()&&!ranking.isEmpty())
		{
			Random rand = new Random();
			int rand_int1 = rand.nextInt(9999); 
			DogBean b = new DogBean(rand_int1,dogName,OwnerName,breed,group, gender, ranking);
			DAO.addDog(b);
		DogBean be = new DogBean();
		String error = be.getError();
		
		if (error == null) {
			String m = "Record successfully added";
			model.addAttribute("message",m);
			model.addAttribute("key", rand_int1);
		}
		
		else {
			String m = "Please try again, we are not able to generate unique entry for this record";
			model.addAttribute("errorMessage");
			
		}
		}
		
		else {
			
			String m = "Field should not be empty";
			model.addAttribute("Error",m);
			
		}

		return "addDog.html";
		
	}
	 
	@GetMapping("/randomDogs")
	public String randomDog() {
		
		DAO.randomDogs();
	
		return "addDog.html";
	}
	
	@GetMapping("/view")
	public String showDogs(Model model) {
		
		model.addAttribute("dogList", DAO.showDogs());
		
		return "view.html";
		
	}
	
	@GetMapping("/search")
	public String goSeachPage() {
		
		return "searchPage.html";
	}
	
	@GetMapping("/searchByNumber")
	public String searchByNumber(@RequestParam String searchByNumber, Model model) {
		
		if(!searchByNumber.isEmpty() && searchByNumber.matches("^[-+]?\\d*$")) {
			
			DogBean b = new DogBean(searchByNumber);
			
			if (DAO.searchByNumber(b).isEmpty()) {
				String error = "Opps! No records are available with this entry number!";
			    model.addAttribute("err",error);
			}
			else {
			model.addAttribute("dogList", DAO.searchByNumber(b));
			}

			
		}
		
		else
		{
			String error = "Enter numbers and field should not be blank";
		    model.addAttribute("err",error);
		}
		
		
				
		return "view.html";
	}
	
@GetMapping("/searchByName")
	public String searchByName(@RequestParam String searchByName, Model model) {
	
	if(!searchByName.isEmpty() && !searchByName.matches("^[-+]?\\d*$")) {
		

		if (DAO.searchByName(searchByName).isEmpty()) {
			String error = "Opps! No records are available with this owner name!";
		    model.addAttribute("err",error);
		}
		else {
		 
		model.addAttribute("dogList", DAO.searchByName(searchByName)); 
		}
	}
	
	else
	{
		String error = "Enter alphbates and field should not be blank";
	    model.addAttribute("err",error);
	}	
	return "view.html";
}

@GetMapping("/searchByOwner")
public String searchByOwner(@RequestParam String searchByOwner, Model model ) {
	
if(!searchByOwner.isEmpty() && !searchByOwner.matches("^[-+]?\\d*$")) {
	
		
		if (DAO.searchByOwner(searchByOwner).isEmpty()) {
			String error = "Opps! No records are available with this owner name!";
		    model.addAttribute("err",error);
		}
		else {
		model.addAttribute("dogList", DAO.searchByOwner(searchByOwner));
		}
		
	}
	
	else
	{
		String error = "Enter alphbates and field should not be blank";
	    model.addAttribute("err",error);
	}	
	return "view.html";
}

@GetMapping("/searchByBreed")

public String searchByBreed(@RequestParam String searchByBreed, Model model ) {
	
if(!searchByBreed.isEmpty() && !searchByBreed.matches("^[-+]?\\d*$")) {
	
		
		if (DAO.searchByBread(searchByBreed).isEmpty()) {
			String error = "Opps! No records are available with this breed!";
		    model.addAttribute("err",error);
		}
		else {
		model.addAttribute("dogList", DAO.searchByBread(searchByBreed));
		}
		
	}
	
	else
	{
		String error = "Enter alphbates and field should not be blank";
	    model.addAttribute("err",error);
	}	
	return "view.html";
}

@GetMapping("/searchByGroup")
public String searchByGroup(@RequestParam String group, Model model) {
if(!group.isEmpty()) {
		
	System.out.println(group);
		DogBean b = new DogBean(group);
		
		if (DAO.searchBy(b).isEmpty()) {
			String error = "Opps! No records are available with this group!";
		    model.addAttribute("err",error);
		}
		else {
		model.addAttribute("dogList", DAO.searchBy(b));
		}
		
	}
	
	else
	{
		String error = "Enter alphbates and field should not be blank";
	    model.addAttribute("err",error);
	}	
	return "view.html";
}
	

@GetMapping("/showList")
public String goToshowListSearch() {
	
	return "searchForShowList.html";
}

@GetMapping("/GetListByGroup")
public String showList(@RequestParam String group, Model model) {
	
	model.addAttribute("dogList", DAO.showList(group));
	
	return  "showListSearch.html";
}
}	

