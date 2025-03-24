//package mk.finki.ukim.mk.labbiblioteka.web;
//
//
//import mk.finki.ukim.mk.labbiblioteka.model.Country;
//import mk.finki.ukim.mk.labbiblioteka.service.CountryService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/countries")
//public class CountryController {
//    private final CountryService countryService;
//
//    public CountryController(CountryService countryService) {
//        this.countryService = countryService;
//    }
//
//    @GetMapping
//    public List<Country> getAllCountries() {
//        return countryService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Country getCountryById(@PathVariable Long id) {
//        return countryService.findById(id);
//    }
//
//    @PostMapping
//    public Country createCountry(@RequestBody Country country) {
//        return countryService.save(country);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCountry(@PathVariable Long id) {
//        countryService.deleteById(id);
//    }
//}