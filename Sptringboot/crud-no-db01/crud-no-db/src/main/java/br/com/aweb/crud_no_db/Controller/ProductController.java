package br.com.aweb.crud_no_db.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dto.ProductDTO;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private Map<Long, ProductDTO> productMap = new HashMap<>();
    private Long nextId = 1L;

    @GetMapping
    public List<ProductDTO> alProducts(){
      return new ArrayList<>(productMap.values());
    }


    // buscar produto por id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productMap.get(id);
    }

    // criar produto
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        product.setId(nextId++);
        productMap.put(product.getId(), product);
        return product;
    }


    //remover um produto
    @DeleteMapping("//{id}")
    public String deleteProduct(@PathVariable Long id) {
        if (productMap.remove(id)!= null) {
            return "Produto removido";
        } else {
        return "Produto não encontrado";
        }
    }
        
        
        //atualizar um produto (PUT)
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO updatedProduct) {
        ProductDTO existingProduct = productMap.get(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            return existingProduct;
        } else {
            return null; // Produto não encontrado
        }
       
        
    
    }
}

