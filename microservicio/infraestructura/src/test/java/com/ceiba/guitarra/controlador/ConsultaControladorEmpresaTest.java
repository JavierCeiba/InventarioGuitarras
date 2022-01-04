package com.ceiba.guitarra.controlador;

import com.ceiba.ApplicationMock;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorEmpresaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar empresas")
    void deberiaListarEmpresas() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/empresas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].nombre", is("Mi Guitarra")))
                .andExpect(jsonPath("$[0].nit", is("839472394")))
                .andExpect(jsonPath("$[1].nombre", is("Armonia Musical")))
                .andExpect(jsonPath("$[1].nit", is("748390565")))
                .andExpect(jsonPath("$[2].nombre", is("La Nota Musical")))
                .andExpect(jsonPath("$[2].nit", is("340622509")));
    }


}
