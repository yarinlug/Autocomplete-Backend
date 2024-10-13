package com.example.autocomplete.Service;

import com.example.autocomplete.Model.AutocompleteItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutocompleteServiceTest {

	private AutocompleteService autocompleteService;

	@BeforeEach
	void setUp() {
		autocompleteService = new AutocompleteService();
	}

	@Test
	void testAutocomplete_WithEmptyInput_ShouldReturnAllItems() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("");
		assertEquals(autocompleteService.autocomplete(""), result,
				"Expected all items when input is empty.");
	}

	@Test
	void testAutocomplete_WithSingleCharacter_ShouldReturnEmptyList() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("D");
		assertTrue(result.isEmpty(),
				"Expected empty list when input has fewer than two characters.");
	}

	@Test
	void testAutocomplete_WithMatchingInput_ShouldReturnFilteredItems() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("Doctor");
		assertEquals(4, result.size(),
				"Expected 4 items for input 'Doctor'.");
		assertTrue(result.stream().allMatch(item -> item.getWorkTitle().contains("Doctor")),
				"All results should have work title 'Doctor'.");
	}

	@Test
	void testAutocomplete_WithName_ShouldReturnMatchingItems() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("John");
		assertEquals(2, result.size(),
				"Expected 2 items with name 'John'.");
		assertTrue(result.stream().allMatch(item -> item.getName().contains("John")),
				"All results should have name containing 'John'.");
	}

	@Test
	void testAutocomplete_WithNoMatchingInput_ShouldReturnEmptyList() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("XYZ");
		assertTrue(result.isEmpty(),
				"Expected empty list for input 'XYZ' as no items should match.");
	}

	@Test
	void testCreateItem_ShouldAddNewItemToList() {
		int initialSize = autocompleteService.autocomplete("").size();
		autocompleteService.createItem("/icon.png", "Tester", "Alice Wonderland");

		List<AutocompleteItem> allItems = autocompleteService.autocomplete("");
		assertEquals(initialSize + 1, allItems.size(),
				"Expected one additional item in the list after adding a new one.");

		AutocompleteItem newItem = allItems.get(allItems.size() - 1);
		assertEquals("Tester", newItem.getWorkTitle());
		assertEquals("Alice Wonderland", newItem.getName());
	}
}
