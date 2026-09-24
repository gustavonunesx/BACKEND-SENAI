package br.com.aweb.sistama_produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aweb.sistama_produto.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
