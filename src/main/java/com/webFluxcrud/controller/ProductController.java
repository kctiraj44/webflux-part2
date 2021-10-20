package com.webFluxcrud.controller;


import com.webFluxcrud.dto.ProductDto;
import com.webFluxcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public Flux<ProductDto> getproducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getproduct(@PathVariable String id){
        return service.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getproductRange(@RequestParam("min") double min ,@RequestParam("max") double max){
        return service.getProductRange(min,max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct( @RequestBody Mono<ProductDto> productDtoMono){
        return service.saveProduct(productDtoMono);
    }


    @PutMapping("/update/{id}")
    public Mono<ProductDto> saveProduct( @RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id){
        return service.updateProduct(productDtoMono,id);
    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteproducts(@PathVariable String id){
        return  service.deleteProduct(id);
    }


}
