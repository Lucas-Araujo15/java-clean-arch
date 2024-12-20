package br.com.alura.codechella.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String zipCode;
    private Integer number;
    private String city;
    private String state;
    private String neighborhood;
}
