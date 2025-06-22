import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.Dto.InventoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = ECommerceApplication.class)
@AutoConfigureMockMvc
public class InventoryControllTest {


        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        public void testCreateInventory() throws Exception {
            InventoryDto dto = new InventoryDto();
            dto.setCardId(1); // مقدار درست و موجود
            dto.setCode("1111222233334444");

            mockMvc.perform(post("/api/inventories")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(dto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.data.code").value("1111222233334444"));
        }


}
