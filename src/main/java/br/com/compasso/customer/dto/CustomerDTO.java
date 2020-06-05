package br.com.compasso.customer.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	@NotBlank(message = "Field Name cannot be null!")
	private String name;
	@NotBlank(message = "Field cpf cannot be null!")
	private String cpf;
	@NotBlank(message = "Field email cannot be null!")
	private String email;
	@NotBlank(message = "Field gender cannot be null!")
	private String gender;
}
