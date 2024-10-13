package com.example.autocomplete.Repository;

import com.example.autocomplete.Model.AutocompleteItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepository {
    private List<AutocompleteItem> items = new ArrayList<>();

    public DemoRepository() {
        createItem("/male-icon.png", "Doctor", "John Doe");
        createItem("/female-icon.png", "Engineer", "Jane Smith");
        createItem("/male-icon.png", "Scientist", "Albert Einstein");
        createItem("/male-icon.png", "Model", "Johnny Widmore");
        createItem("/male-icon.png", "Designer", "Jack Shepherd");
        createItem("/female-icon.png", "Programmer", "Kate Austen");
        createItem("/male-icon.png", "Doctor", "Manu Reyes");
        createItem("/female-icon.png", "Designer", "Envy Braske");
        createItem("/male-icon.png", "Nurse", "Erik Grey");
        createItem("/female-icon.png", "Nurse", "Carol Allen");
        createItem("/male-icon.png", "Nurse", "Andrew White");
        createItem("/female-icon.png", "Designer", "Linda Harris");
        createItem("/female-icon.png", "Nurse", "Cielo Clark");
        createItem("/female-icon.png", "Designer", "Sarah Martin");
        createItem("/female-icon.png", "Nurse", "Betty Gonzales");
        createItem("/male-icon.png", "Programmer", "Anthony Addams");
        createItem("/male-icon.png", "Nurse", "Daniel Martinez");
        createItem("/male-icon.png", "Manager", "Erik Jackson");
        createItem("/male-icon.png", "Doctor", "James Grey");
        createItem("/male-icon.png", "Nurse", "Timothy Moore");
        createItem("/male-icon.png", "Programmer", "Michael Bruno");
        createItem("/male-icon.png", "Doctor", "Robert Miller");
        createItem("/male-icon.png", "Nurse", "John Smith");
        createItem("/male-icon.png", "Programmer", "David Torres");
        createItem("/female-icon.png", "Nurse", "Barbara Howard");
        createItem("/male-icon.png", "Designer", "Jacob Rogers ");
        createItem("/male-icon.png", "Doctor", "Jeffrey Reed ");
        createItem("/female-icon.png", "Programmer", "Amy Bassanio ");
        createItem("/male-icon.png", "Model", "Angel Stewart ");
        createItem("/female-icon.png", "Nurse", "Julia White ");
        createItem("/male-icon.png", "Manager", "Lee Chang ");
        createItem("/female-icon.png", "Designer", "Donna Mitchell ");
        createItem("/male-icon.png", "Manager", "Paul Nelson ");
        createItem("/male-icon.png", "Nurse", "Joshua Hernandez ");
        createItem("/female-icon.png", "Nurse", "Catherine Medici ");
        createItem("/female-icon.png", "Model", "Mary DeGuise ");
        createItem("/female-icon.png", "Manager", "Shirley Hall ");
    }

    public List<AutocompleteItem> getAllItems() {
        return items;
    }

    public void createItem (String imageurl, String workTitle, String name) {
        items.add(new AutocompleteItem(imageurl, workTitle, name));
    }
}
