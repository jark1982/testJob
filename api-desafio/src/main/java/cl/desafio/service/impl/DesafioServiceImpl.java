package cl.desafio.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.previred.periodos.swagger.codegen.model.Periodo;

import cl.desafio.service.inferces.IDesafioService;
import cl.desafio.service.inferces.IProxyDelegate;

@Service
public class DesafioServiceImpl implements IProxyDelegate, IDesafioService {

	private static final String uri = "http://127.0.0.1:8080/periodos/api";

	@Override
	public Periodo executeDesafio() throws URISyntaxException {

		ResponseEntity<Periodo> entity = getPeriodo();
		Periodo periodo = entity.getBody();
		LocalDate creacion = periodo.getFechaCreacion();
		LocalDate fin = periodo.getFechaFin();
		List<LocalDate> fechas = periodo.getFechas();
		List<LocalDate> intervalo = new ArrayList<LocalDate>();
		int i = 0;
		LocalDate localDate = null;
		do {
			localDate = creacion.plusMonths(i++);
			intervalo.add(localDate);
		} while (localDate.compareTo(fin) != 0);
		Set<LocalDate> ad = new HashSet<LocalDate>(intervalo);
		Set<LocalDate> bd = new HashSet<LocalDate>(fechas);
		ad.removeAll(bd);

		List<LocalDate> fechasfaltantes = new ArrayList<LocalDate>(ad);

		Periodo desafio = new Periodo();
		desafio.setFechaCreacion(creacion);
		desafio.setFechaFin(fin);
		desafio.setFechas(fechasfaltantes);
		desafio.setId(1l);
		return desafio;
	}

	@Override
	public ResponseEntity<Periodo> getPeriodo() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		URI url = new URI(uri);
		ResponseEntity<Periodo> responseEntity = restTemplate.getForEntity(url, Periodo.class);
		return responseEntity;
	}

}
