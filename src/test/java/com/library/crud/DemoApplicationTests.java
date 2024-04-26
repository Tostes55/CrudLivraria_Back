package com.library.crud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.crud.DTO.LivroDTO;
import com.library.crud.controller.LivroController;
import com.library.crud.model.Livro;
import com.library.crud.repository.LivroRepository;
import com.library.crud.service.LivroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@InjectMocks
	private LivroController livroController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LivroService livroService;

	@MockBean
	private LivroRepository livroRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void deveListarLivros() throws Exception {

		Livro livro = new Livro(1L, "Harry Potter", "J.K.");
		LivroDTO livroDTO = new LivroDTO(1L, "Harry Potter", "J.K.");
		List<LivroDTO> listaLivroDTO = List.of(livroDTO);
		List<Livro> listaLivro = List.of(livro);
		when(livroRepository.findAll()).thenReturn(listaLivro);
		when(livroService.buscaLivros()).thenReturn(listaLivroDTO);
		mockMvc.perform(get("/livros"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].titulo", is("Harry Potter")))
				.andExpect(jsonPath("$[0].autor", is("J.K.")));
	}

	@Test
	void deveCadastrarLivros() throws Exception{

		LivroDTO livroDTO = new LivroDTO(1L, "Harry Potter", "J.K.");
		mockMvc.perform(post("/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(livroDTO)))
				.andExpect(status().isOk());

	}

	@Test
	void deveAtualizarLivros() throws Exception{

		LivroDTO livroDTO = new LivroDTO(1L, "Harry Potter", "J.K.");
		mockMvc.perform(put("/livros/{id}",1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(livroDTO)))
				.andExpect(status().isOk());

//		verify(livroService, times(1)).atualizaLivro(livroDTO,1L);
	}

	@Test
	void deveApagarLivros() throws Exception{
		mockMvc.perform(delete("/livros/{id}",1))
				.andExpect(status().isOk());
		verify(livroService, times(1)).apagaLivro(1L);

	}


}
