package br.com.aweb.sistama_produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistama_produto.model.Client;
import br.com.aweb.sistama_produto.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public boolean emailInUse(String email, Long id) {
        return id == null ? clientRepository.existsByEmail(email) : clientRepository.existsByEmailAndIdNot(email, id);
    }

    public boolean cpfInUse(String cpf, Long id) {
        return id == null ? clientRepository.existsByCpf(cpf) : clientRepository.existsByCpfAndIdNot(cpf, id);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setFullName(client.getFullName());
            existingClient.setEmail(client.getEmail());
            existingClient.setCpf(client.getCpf());
            existingClient.setPhone(client.getPhone());
            existingClient.setAddress(client.getAddress());
            return clientRepository.save(existingClient);
        }
        return null;
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
