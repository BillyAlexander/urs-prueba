package ec.gob.registrosocial.prueba.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ProvinciaDto {
	String code;
	String name;
	
	//public Set<CantonDto> roles = new HashSet<>();
}
