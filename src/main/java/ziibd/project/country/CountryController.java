package ziibd.project.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    //Zwróć wszystkie państwa
    @RequestMapping("/countries")
    public String getCountries(Model model) {
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("country",new Country());
        return "countries/countries";
    }

    //Dodaj państwo
    @PostMapping("/addCountry")
    public String addCountry(@ModelAttribute("country") Country country){
        CountryThread countryThread1 = new CountryThread(country,"addCountry(Controller) CountryThread");
        countryThread1.start();
        countryService.addCountry(country);
        return "redirect:/countries";
    }

    //Pobierz i zapisz państwo o zadanym id i zwróć widok edycji państwa
    @RequestMapping("/editCountry/{id}")
    public String updateCountryById(@PathVariable String id, Model model){
        CountryThread countryThread2 = new CountryThread(countryService.getCountry(id),"updateCountryById(Controller) CountryThread");
        countryThread2.start();
        model.addAttribute("retrievedcountry",countryService.getCountry(id));
        return "countries/countryEdit";
    }

    //Edytuj państwo
    @PostMapping("/editCountry")
    public String updateCountry(@ModelAttribute("retrievedcountry") Country country){
        CountryThread countryThread3 = new CountryThread(country,"updateCountry(Controller) CountryThread");
        countryThread3.start();
        countryService.updateCountry(country);
        return "redirect:/countries";
    }

    //Usuń państwo
    @Transactional
    @RequestMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable String id){
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }

}
