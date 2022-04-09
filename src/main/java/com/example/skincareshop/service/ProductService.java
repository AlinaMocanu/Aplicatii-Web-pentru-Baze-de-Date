package com.example.skincareshop.service;

import com.example.skincareshop.domain.Product;
import com.example.skincareshop.dto.ProductDto;
import com.example.skincareshop.exception.ProductNotFoundException;
import com.example.skincareshop.mapper.ProductMapper;
import com.example.skincareshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(p -> productMapper.mapToDto(p)).collect(Collectors.toList());

    }

    public ProductDto getOne(String Name) {
        Optional<Product> product = Optional.ofNullable(productRepository.findProductByName(Name));
        if (product.isEmpty()) {
            throw new ProductNotFoundException("This product does not exist");
        }
        return productMapper.mapToDto(product.get());
    }

    @Transactional
    public void deleteProduct(Long id) {
        orderItemService.deleteProductReference(id);
        productRepository.deleteProduct(id);
    }

    @Transactional
    public void updateProduct(Long id, String name, Double price, Long quantity, Long supplierId) {
        productRepository.updateProduct(id, name, price, quantity, supplierId);
    }

    @Transactional
    public void removeSupplierReference(Long id) {
        productRepository.removeSupplierReference(id);
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.mapToEntity(productDto);
        Product savedProduct = productRepository.save(product);

        return productMapper.mapToDto(savedProduct);
    }
}

