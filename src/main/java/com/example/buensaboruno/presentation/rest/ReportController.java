package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.domain.dtos.OrdersByCategoryDTO;
import com.example.buensaboruno.domain.dtos.TopSellingProductDTO;
import com.example.buensaboruno.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/report")
public class ReportController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(value = "/top-selling-products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TopSellingProductDTO>> getTopSellingProducts(@RequestParam(defaultValue = "5") int limit) {
        Pageable pageable = PageRequest.of(0, limit); // Página 0, con el límite especificado
        List<TopSellingProductDTO> topSellingProducts = pedidoRepository.findTopSellingProducts(pageable);
        return new ResponseEntity<>(topSellingProducts, HttpStatus.OK);
    }

    @GetMapping(value = "/orders-by-category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrdersByCategoryDTO>> getOrdersByCategory() {
        List<OrdersByCategoryDTO> ordersByCategory = pedidoRepository.findOrdersByCategory();
        return new ResponseEntity<>(ordersByCategory, HttpStatus.OK);
    }
}
