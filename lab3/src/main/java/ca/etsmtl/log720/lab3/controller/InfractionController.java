package ca.etsmtl.log720.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.etsmtl.log720.lab3.dao.helper.InfractionService;
import ca.etsmtl.log720.lab3.model.Dossier;
import ca.etsmtl.log720.lab3.model.Infraction;

@Controller
public class InfractionController {
	@Autowired
	private InfractionService infractionService;
	
	@Autowired(required=true)
	@Qualifier(value="infractionService")
	public void setInfractionService(InfractionService is){
		this.infractionService = is;
	}
	
	@RequestMapping(value = "/infraction/portail", method = RequestMethod.GET)
	public String dossierManager(Model model) {
		return "infractionGestion";
	}
	
	@RequestMapping(value = "/infractions", method = RequestMethod.GET)
	public String listDossiers(Model model) {
		model.addAttribute("listInfractions", this.infractionService.listInfractions());
		return "infractions";
	}
	
	@RequestMapping(value = "/infractions/form/add", method = RequestMethod.GET)
	public String showaddform(Model model) {
		model.addAttribute("infraction", new Infraction());
		return "addInfraction";
	}
	
	@RequestMapping(value="/infraction/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("infraction") Infraction infraction){
		this.infractionService.addInfraction(infraction);
		return "redirect:/infractions";
	}
}
