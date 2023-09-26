package ec.gob.registrosocial.prueba.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ec.gob.registrosocial.prueba.clients.DistributionClient;
import ec.gob.registrosocial.prueba.dtos.CantonDto;
import ec.gob.registrosocial.prueba.dtos.ParroquiaDto;
import ec.gob.registrosocial.prueba.dtos.ProvinciaDto;
import ec.gob.registrosocial.prueba.services.DistributionService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DistributionServiceImpl implements DistributionService {

	@Autowired
	DistributionClient distributionClient;

	@Value("${urs.prov.max}")
	int provMax;

	@Value("${urs.prov.min}")
	int provMin;

	@Value("${urs.canton.max}")
	int cantonMax;

	@Value("${urs.canton.min}")
	int cantonMin;
	
	@Value("${urs.parroq.max}")
	int parroMax;

	@Value("${urs.parroq.min}")
	int parroMin;

	@Override
	public List<ProvinciaDto> getAllProvincias() {
		String json = distributionClient.distribution();

		return parseDataProv(json);
	}

	@Override
	public List<CantonDto> getCantonByProvincia(String prov) {
		String json = distributionClient.distribution();
		return parseDataCanton(json, prov);
	}

	@Override
	public List<ParroquiaDto> getParroquiaByCantonAndProvincia(String prov, String canton) {
		String json = distributionClient.distribution();


		return parseDataParroquia(json, prov, canton);
	}

	private List<ProvinciaDto> parseDataProv(String json) {
		List<ProvinciaDto> provs = new ArrayList<>();
		for (int i = provMin; i < provMax; i++) {
			JSONObject myjson = new JSONObject(json);
			JSONObject the_json_array = myjson.getJSONObject("" + i);
			ProvinciaDto p = new ProvinciaDto(i + "", the_json_array.get("provincia").toString());
			provs.add(p);
		}
		// log.info(provs);
		return provs;
	}

	private List<CantonDto> parseDataCanton(String json, String prov) {
		List<CantonDto> cants = new ArrayList<>();

		JSONObject myjson = new JSONObject(json);
		JSONObject the_json_array = myjson.getJSONObject(prov);

		JSONObject cantones = the_json_array.getJSONObject("cantones");
		log.info(cantones);
		for (int i = cantonMin; i < cantonMax; i++) {
			String codeCanton = (i < 10) ? prov + "0" + i : prov + i;
			try {
				JSONObject arrCant = cantones.getJSONObject(codeCanton);
				CantonDto cant = new CantonDto(codeCanton, arrCant.get("canton").toString());
				cants.add(cant);
				// log.info(arrCant);
			} catch (Exception e) {
				break;
			}
		}

		return cants;
	}

	private List<ParroquiaDto> parseDataParroquia(String json, String prov, String canton) {
	 List<ParroquiaDto> parroqs = new ArrayList<>();

		JSONObject myjson = new JSONObject(json);
		JSONObject the_json_array = myjson.getJSONObject(prov);

		JSONObject cantones = the_json_array.getJSONObject("cantones");
		//log.info(cantones);

		JSONObject arrCant = cantones.getJSONObject(canton);
		JSONObject parroqu = arrCant.getJSONObject("parroquias");
		
		for (int i = parroMin; i < parroMax; i++) {
			String codeParr = (i < 10) ? canton+ "0" + i : canton + i;
			try {
				parroqu.get(codeParr);
				ParroquiaDto parroq = new ParroquiaDto(codeParr,parroqu.get(codeParr).toString());
				parroqs.add(parroq);
				//log.info(parroqu.get(codeParr));
			} catch (Exception e) {
				continue;
				
			}

		}

		return parroqs;
	}

}
