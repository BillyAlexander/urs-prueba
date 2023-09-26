package ec.gob.registrosocial.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.registrosocial.prueba.dtos.CantonDto;
import ec.gob.registrosocial.prueba.dtos.ParroquiaDto;
import ec.gob.registrosocial.prueba.dtos.ProvinciaDto;
import ec.gob.registrosocial.prueba.services.DistributionService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@CrossOrigin(origins  = "*", maxAge = 3600)
@RequestMapping("/distribution")
public class DistributionController {

	@Autowired
	DistributionService distributionService;

	@GetMapping
	public ResponseEntity<List<ProvinciaDto>> getAllProvincias() {

		log.info(distributionService.getAllProvincias());

		return ResponseEntity.status(HttpStatus.OK).body(distributionService.getAllProvincias());
	}

	@GetMapping("/{provId}")
	public ResponseEntity<List<CantonDto>> getCantonesbyProvincia(@PathVariable(value = "provId") String provId) {

		log.info(distributionService.getCantonByProvincia(provId));

		return ResponseEntity.status(HttpStatus.OK).body(distributionService.getCantonByProvincia(provId));
	}

	@GetMapping("/{provId}/{cantonId}")
	public ResponseEntity<List<ParroquiaDto>> getParroquiasbyProvinciaCanton(
			@PathVariable(value = "provId") String provId, @PathVariable(value = "cantonId") String cantonId) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(distributionService.getParroquiaByCantonAndProvincia(provId, cantonId));
	}

}
