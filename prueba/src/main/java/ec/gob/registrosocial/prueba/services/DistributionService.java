package ec.gob.registrosocial.prueba.services;

import java.util.List;

import ec.gob.registrosocial.prueba.dtos.CantonDto;
import ec.gob.registrosocial.prueba.dtos.ParroquiaDto;
import ec.gob.registrosocial.prueba.dtos.ProvinciaDto;

public interface DistributionService {
	List<ProvinciaDto> getAllProvincias();
	List<CantonDto> getCantonByProvincia(String prov);
	List<ParroquiaDto> getParroquiaByCantonAndProvincia(String prov, String canton);
}
