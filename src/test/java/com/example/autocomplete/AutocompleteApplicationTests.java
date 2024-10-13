package com.example.autocomplete.Service;

import com.example.autocomplete.Model.AutocompleteItem;
import com.example.autocomplete.Repository.DemoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AutocompleteServiceTest {

	@Mock
	private DemoRepository demoRepository;

	@InjectMocks
	private AutocompleteService autocompleteService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		List<AutocompleteItem> items = List.of(
				new AutocompleteItem("/male-icon.png", "Doctor", "John Doe"),
				new AutocompleteItem("/female-icon.png", "Engineer", "Jane Smith"),
				new AutocompleteItem("/male-icon.png", "Doctor", "Manu Reyes"),
				new AutocompleteItem("/female-icon.png", "Nurse", "Cielo Clark"),
				new AutocompleteItem("/male-icon.png", "Doctor", "James Grey"),
				new AutocompleteItem("/male-icon.png", "Programmer", "John Smith")
		);

		when(demoRepository.getAllItems()).thenReturn(items);
	}

	@Test
	void testAutocomplete_WithEmptyInput_ShouldReturnAllItems() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("");
		assertEquals(6, result.size(), "Expected all items when input is empty.");
	}

	@Test
	void testAutocomplete_WithSingleCharacter_ShouldReturnEmptyList() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("D");
		assertTrue(result.isEmpty(), "Expected empty list when input has fewer than two characters.");
	}

	@Test
	void testAutocomplete_WithMatchingInput_ShouldReturnFilteredItems() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("Doctor");
		assertEquals(3, result.size(), "Expected 3 items for input 'Doctor'.");
		assertTrue(result.stream().allMatch(item -> item.getWorkTitle().contains("Doctor")),
				"All results should have work title 'Doctor'.");
	}

	@Test
	void testAutocomplete_WithName_ShouldReturnMatchingItems() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("John");
		assertEquals(2, result.size(), "Expected 2 items with name 'John'.");
		assertTrue(result.stream().allMatch(item -> item.getName().contains("John")),
				"All results should have name containing 'John'.");
	}

	@Test
	void testAutocomplete_WithNoMatchingInput_ShouldReturnEmptyList() {
		List<AutocompleteItem> result = autocompleteService.autocomplete("XYZ");
		assertTrue(result.isEmpty(), "Expected empty list for input 'XYZ' as no items should match.");
	}
}
