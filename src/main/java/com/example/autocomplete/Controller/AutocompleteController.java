package com.example.autocomplete.Controller;

import com.example.autocomplete.Model.AutocompleteItem;
import com.example.autocomplete.Service.AutocompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AutocompleteController {

    private final AutocompleteService autocompleteService;

    @Autowired
    public AutocompleteController(AutocompleteService autocompleteService) {
        this.autocompleteService = autocompleteService;
    }

@GetMapping("/autocomplete")
public List<AutocompleteItem> autocomplete(
        @RequestParam(value = "input", required = false, defaultValue = "") String input) {

    return autocompleteService.autocomplete(input);
}

}
