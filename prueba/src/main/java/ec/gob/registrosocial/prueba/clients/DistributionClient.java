package ec.gob.registrosocial.prueba.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ec.gob.registrosocial.prueba.services.UtilService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class DistributionClient {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UtilService utilService;

	public String distribution() {
		String url = utilService.createUrl();
		String json = null;
		try {
			Object res = restTemplate.getForObject(url, Object.class);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(res);

			//log.info(json);

		} catch (Exception e) {
			log.info(e);
		}

		return json;
	}

}
