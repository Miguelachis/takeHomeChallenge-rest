package controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class AccreditationcontrolerTest {
    @Autowired
    private MockMvc mockMvc;

//    @Test
//     void createAccreditation() throws Exception {
//
//        final Document document = Document.builder()
//                .id("1")
//                .Name("doc1")
//                .content("test")
//                .build();
//        final Accreditation accreditation = Accreditation.builder()
//                .ID("1")
//                .accreditation_type(AccreditationType.BY_INCOME)
//                .status(AccreditationStatus.PENDING)
//                .document(document)
//                .build();
//
//        final ObjectMapper objectMapper = new ObjectMapper();
//        final String json = objectMapper.writeValueAsString(accreditation);
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/user/accreditation").contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}
