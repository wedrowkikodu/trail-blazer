package pl.wedrowkikodu.trailblazer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.wedrowkikodu.trailblazer.mapper.TravelerMapper;
import pl.wedrowkikodu.trailblazer.model.dto.TravelerDto;
import pl.wedrowkikodu.trailblazer.model.entity.Traveler;
import pl.wedrowkikodu.trailblazer.service.TravelerService;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TravelerController.class)
public class TravelerControllerTest {

    private static final String TEST_EMAIL = "test@email.com";
    private static final String TRAVELER_NAME = "John";

    @MockBean
    private TravelerMapper travelerMapper;

    @MockBean
    private TravelerService travelerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnTraveler() throws Exception {
        given(travelerService.findById(1L))
            .willReturn(Optional.of(createTraveler()));
        given(travelerMapper.mapToDto(createTraveler()))
            .willReturn(createTravelerDto());

        mockMvc.perform(get("/travelers/1")
                .contentType("application/json"))
            .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnExceptionWhenTravelerNotFound() throws Exception {
        given(travelerService.findById(1L))
            .willReturn(Optional.empty());

        mockMvc.perform(get("/travelers/1")
                .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnAllTravelers() throws Exception {
        final Traveler traveler = createTraveler();
        given(travelerService.findAll())
            .willReturn(Collections.singletonList(traveler));
        given(travelerMapper.mapToDto(traveler))
            .willReturn(createTravelerDto());

        mockMvc.perform(get("/travelers")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].name").value(TRAVELER_NAME))
            .andExpect(jsonPath("$[0].email").value(TEST_EMAIL));
    }

    @Test
    public void shouldCreateTraveler() throws Exception {
        final String travelerJson = """
                            {
                                "id": 1,
                                "name": "%s",
                                "email": "%s"
                            }""".formatted(TRAVELER_NAME, TEST_EMAIL);

        given(travelerService.save(any(Traveler.class)))
            .willReturn(createTraveler());
        given(travelerMapper.mapToDto(any(Traveler.class)))
            .willReturn(createTravelerDto());

        mockMvc.perform(post("/travelers")
                .contentType("application/json")
                .content(travelerJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value(TRAVELER_NAME))
            .andExpect(jsonPath("$.email").value(TEST_EMAIL));
    }

    @Test
    public void shouldUpdateTraveler() throws Exception {
        given(travelerService.update(eq(1L), any(Traveler.class)))
            .willReturn(createTraveler());
        given(travelerMapper.mapToDto(any(Traveler.class)))
            .willReturn(createTravelerDto());

        mockMvc.perform(put("/travelers/1")
                .contentType("application/json")
                .content("""
                        {
                            "id": 1,
                            "name": "%s",
                            "email": "%s"
                        }""".formatted(TRAVELER_NAME, TEST_EMAIL))
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value(TRAVELER_NAME))
            .andExpect(jsonPath("$.email").value(TEST_EMAIL));
    }

    @Test
    public void shouldDeleteTraveler() throws Exception {
        willDoNothing().given(travelerService).delete(1L);

        mockMvc.perform(delete("/travelers/1")
                .contentType("application/json"))
            .andExpect(status().isNoContent());
    }

    private TravelerDto createTravelerDto() {
        return new TravelerDto(1L, TRAVELER_NAME, TEST_EMAIL, Collections.emptyList());
    }

    private Traveler createTraveler() {
        Traveler traveler = new Traveler();
        traveler.setId(1L);
        traveler.setName(TRAVELER_NAME);
        traveler.setEmail(TEST_EMAIL);
        return traveler;
    }
}
