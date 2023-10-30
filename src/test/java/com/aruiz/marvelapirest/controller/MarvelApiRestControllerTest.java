package com.aruiz.marvelapirest.controller;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.aruiz.marvelapi.model.Character;
import com.aruiz.marvelapi.model.CharacterDataContainer;
import com.aruiz.marvelapi.model.CharacterDataWrapper;
import com.aruiz.marvelapirest.interfaces.IMarvelApiRestService;
import com.aruiz.marvelapirest.utils.Const;

class MarvelApiRestControllerTest {

	@InjectMocks
	private MarvelApiRestController marvelApiRestController;
	
	@Mock
	private IMarvelApiRestService iMarvelApiRestService;

	CharacterDataWrapper characterDataWrapper;

	CharacterDataWrapper characterDataWrapper2;
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		characterDataWrapper = new CharacterDataWrapper();
		characterDataWrapper.setCode(Const.CODE_200);
		characterDataWrapper.setStatus(Const.STATUS_Ok);
		CharacterDataContainer characterContainer = new  CharacterDataContainer();
		Character character = new Character();
		List<Character> ltsCharacter = new ArrayList<>();
		ltsCharacter.add(character);
		characterContainer.setResults(ltsCharacter);
		characterDataWrapper.setData(characterContainer);
		
		
		characterDataWrapper2 = new CharacterDataWrapper();
		characterDataWrapper2.setCode(Const.CODE_200);
		characterDataWrapper2.setStatus(Const.STATUS_Ok);
		CharacterDataContainer characterContainer2 = new  CharacterDataContainer();
		List<Character> ltsCharacter2 = new ArrayList<>();
		ltsCharacter2.add(character);
		ltsCharacter2.add(character);
		characterContainer2.setResults(ltsCharacter2);
		characterDataWrapper2.setData(characterContainer2);
		
	}

	@Test
	void testObtieneHeroe() {
		int idHeroe = 1009146;
		
		when(marvelApiRestController.obtenerHeroe(idHeroe)).thenReturn(characterDataWrapper);
		when(iMarvelApiRestService.obtieneHeroe(idHeroe)).thenReturn(characterDataWrapper);
		assertNotNull(characterDataWrapper);
		assertEquals(Const.STATUS_Ok, characterDataWrapper.getStatus());
		assertEquals(Const.CODE_200, characterDataWrapper.getCode());
		assertNotNull(characterDataWrapper.getData().getResults());
		assertTrue(characterDataWrapper.getData().getResults().size() == Const.UNO);
	}

	@Test
	void TestObtieneHeroes() {
		when(marvelApiRestController.listarHeroes()).thenReturn(characterDataWrapper);
		when(iMarvelApiRestService.listaHeroes()).thenReturn(characterDataWrapper);
		assertNotNull(characterDataWrapper);
		assertEquals(Const.STATUS_Ok, characterDataWrapper.getStatus());
		assertEquals(Const.CODE_200, characterDataWrapper.getCode());
		assertNotNull(characterDataWrapper.getData().getResults());
		assertTrue(characterDataWrapper.getData().getResults().size() > Const.CERO);
	}
}
