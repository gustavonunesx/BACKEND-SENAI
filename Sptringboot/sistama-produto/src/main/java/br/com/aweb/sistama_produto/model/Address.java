package br.com.aweb.sistama_produto.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Embeddable
public class Address {

    @NotBlank(message = "Logradouro is mandatory!🤬")
    private String street;

    private String number;

    private String complement;

    @NotBlank(message = "Bairro is mandatory!🤬")
    private String neighborhood;

    @NotBlank(message = "Cidade is mandatory!🤬")
    private String city;

    @NotBlank(message = "UF is mandatory!🤬")
    @Size(min = 2, max = 2, message = "UF must have 2 letters!🤬")
    @Pattern(regexp = "[A-Za-z]{2}", message = "UF must contain only letters!🤬")
    private String state;

    @NotBlank(message = "CEP is mandatory!🤬")
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP must be in the format 00000-000!🤬")
    private String zipCode;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
