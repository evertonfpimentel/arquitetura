package br.com.compasso.customer.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	@NotBlank
	private String name;
	@NotBlank
	private String cpf;
	@NotBlank
	private String email;
	@NotBlank
	private String gender;
}
