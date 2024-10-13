package com.example.autocomplete.Service;

import com.example.autocomplete.Model.AutocompleteItem;
import com.example.autocomplete.Repository.DemoRepository;
import com.example.autocomplete.Repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutocompleteService {

    private final DemoRepository repository;

    public AutocompleteService(DemoRepository repository) {
        this.repository = repository;
    }

    public List<AutocompleteItem> autocomplete(String input) {
        List<AutocompleteItem> items = repository.getAllItems();

        if (input.isEmpty()) {
            return items;
        }

        if (input.length() < 2) {
            return List.of();
        }

        return items.stream()
                .filter(item -> item.getName().toLowerCase().contains(input.toLowerCase())
                        || item.getWorkTitle().toLowerCase().contains(input.toLowerCase()))
                .collect(Collectors.toList());
    }
}
