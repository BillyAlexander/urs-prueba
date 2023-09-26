package ec.gob.registrosocial.prueba.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ec.gob.registrosocial.prueba.services.UtilService;

@Service
public class UtilServiceImpl implements UtilService {

	@Value("${urs.api.url.distribution}")
	String REQUEST_URI_COURSE;

	
	@Override
	public String createUrl() {
		return REQUEST_URI_COURSE;
	}
	
}
