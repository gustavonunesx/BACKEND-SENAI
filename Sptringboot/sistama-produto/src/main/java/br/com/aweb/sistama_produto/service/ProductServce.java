package br.com.aweb.sistama_produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistama_produto.model.Product;
import br.com.aweb.sistama_produto.repository.ProductRepository;

@Service
public class ProductServce {

    @Autowired
    private ProductRepository productRepository;

    // buscar produtos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // buscar produto por id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // salvar produto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // atualizar produto
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantity(product.getQuantity());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    // excluir produto
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
