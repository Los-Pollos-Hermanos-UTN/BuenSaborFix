package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.domain.dtos.OrdersByCategoryDTO;
import com.example.buensaboruno.domain.dtos.TopSellingProductDTO;
import com.example.buensaboruno.repositories.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);


    @GetMapping(value = "/empresa/{id}/top-selling-products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TopSellingProductDTO>> getTopSellingProducts(
            @PathVariable Long id,
            @RequestParam(defaultValue = "5") int limit) {
        Pageable pageable = PageRequest.of(0, limit); // Página 0, con el límite especificado
        List<TopSellingProductDTO> topSellingProducts = pedidoRepository.findTopSellingProducts(id, pageable);
        return new ResponseEntity<>(topSellingProducts, HttpStatus.OK);
    }

    @GetMapping(value = "/empresa/{id}/orders-by-category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrdersByCategoryDTO>> getOrdersByCategory(
            @PathVariable Long id) {
        List<OrdersByCategoryDTO> ordersByCategory = pedidoRepository.findOrdersByCategory(id);
        logger.info("Orders by category: {}", ordersByCategory); // Log the result
        return new ResponseEntity<>(ordersByCategory, HttpStatus.OK);
    }
}
