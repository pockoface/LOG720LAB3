package ca.etsmtl.log720.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.etsmtl.log720.lab3.dao.helper.DossierService;
import ca.etsmtl.log720.lab3.dao.helper.InfractionService;
import ca.etsmtl.log720.lab3.model.Dossier;
import ca.etsmtl.log720.lab3.model.Infraction;

@Controller
public class DossierController {
    @Autowired
    private DossierService dossierService;

    @Autowired(required = true)
    @Qualifier(value = "dossierService")
    public void setDossierService(DossierService ds) {
        this.dossierService = ds;
    }

    @Autowired
    private InfractionService infractionService;

    @Autowired(required = true)
    @Qualifier(value = "infractionService")
    public void setInfractionService(InfractionService is) {
        this.infractionService = is;
    }

    @GetMapping(value = "/dossiers")
    public String listDossiers(Model model) {
        model.addAttribute("dossier", new Dossier());
        model.addAttribute("listDossiers", this.dossierService.listDossiers());
        return "dossiers";
    }

    @GetMapping("/dossier/{id}")
    public String showDossier(@PathVariable("id") int id, Model model) {
        model.addAttribute("dossier", this.dossierService.getDossier(id));
        model.addAttribute("listInfraction", this.infractionService.listInfractions());
        return "dossier";
    }

    @GetMapping(value = "/dossier/portail")
    public String dossierManager(Model model) {
        return "dossierGestion";
    }

    @GetMapping(value = "/logout")
    public String logout(Model model) {
        return "logout";
    }

    @GetMapping(value = "/dossier/form/add")
    public String addDossier(Model model) {
        model.addAttribute("dossier", new Dossier());
        return "addDossier";
    }

    @PostMapping(value = "/dossier/add")
    public String addDossier(@ModelAttribute("dossier") Dossier dossier) {
        try {
            this.dossierService.addDossier(dossier);
            return "redirect:/dossiers";
        } catch (Exception e) {
            return "redirect:/dossiers";
        }
    }

    @PostMapping(value = "/dossier/infraction/add")
    public String addInfraction(@RequestParam int infraction, @RequestParam int dossier) {
        Dossier d = this.dossierService.getDossier(dossier);
        Infraction i = this.infractionService.getInfraction(infraction);
        System.out.println(i == null);
        if (i != null && d != null)
            this.dossierService.addInfraction(i, d);
        return "redirect:/dossier/" + dossier;
    }

}
