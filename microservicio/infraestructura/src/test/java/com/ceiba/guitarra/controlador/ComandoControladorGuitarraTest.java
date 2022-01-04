package com.ceiba.guitarra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.guitarra.comando.ComandoGuitarra;
import com.ceiba.guitarra.servicio.testdatabuilder.ComandoGuitarraTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorGuitarraTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una guitarra")
    void deberiaCrearUnaGuitarra() throws Exception{
        // arrange
        ComandoGuitarra guitarra = new ComandoGuitarraTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/guitarras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(guitarra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    @DisplayName("Deberia actualizar una guitarra")
    void deberiaActualizarUnaGuitarra() throws Exception{
        // arrange
        Long id = 1L;
        ComandoGuitarra guitarra = new ComandoGuitarraTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/guitarras/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(guitarra)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una guitarra")
    void deberiaEliminarUnaGuitarra() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/guitarras/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/guitarras")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
