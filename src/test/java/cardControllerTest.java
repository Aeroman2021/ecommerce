import ch.qos.logback.core.encoder.EchoEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.Dto.CardDto;
import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.entity.CardType;
import com.project.ecommerce.model.entity.Region;
import com.project.ecommerce.model.entity.embedables.Description;
import com.project.ecommerce.service.contract.CardTypeService;
import com.project.ecommerce.service.contract.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = ECommerceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class cardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CardTypeService cardTypeService;

    @Autowired
    private RegionService regionService;


    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testCreatedCard() throws Exception {

        CardDto cardDto = CardDto.builder()
                .price(new BigDecimal(100))
                .irPrice(new BigDecimal(800000))
                .regionId(1)
                .cardTypeId(1)
                .descriptionFa("توضیحات فارسی")
                .descriptionEn("English description")
                .build();

        String cardJson = objectMapper.writeValueAsString(cardDto);

        mockMvc.perform(post("/api/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cardJson))
                .andExpect(status().isOk());

    }
}
