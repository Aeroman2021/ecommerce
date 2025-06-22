package com.project.ecommerce.controller;

import com.project.ecommerce.exception.ApiResponse;
import com.project.ecommerce.model.Dto.CardDto;
import com.project.ecommerce.service.contract.CardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cards")
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CardDto>> saveOrUpdate(@RequestBody CardDto cardDto){
        CardDto result = cardService.createOrUpdate(cardDto);
        return ResponseEntity.ok(ApiResponse.success(result,"new Card Added/updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        cardService.delete(id);
//        return ResponseEntity.noContent().build();
        return  ResponseEntity.ok(ApiResponse.success("Card deleted successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getById(@PathVariable Integer id){
        CardDto result = cardService.getById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> getAll(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam  (defaultValue = "10")int saze
    ){
        Pageable pageable = PageRequest.of(page,saze);
        List<CardDto> result = cardService.getAllCardsByPage(pageable);
        return ResponseEntity.ok(result);
    }

}
