package cl.desafio.service.inferces;

import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

import com.previred.periodos.swagger.codegen.model.Periodo;

@Service
public interface IDesafioService {

	public Periodo executeDesafio() throws URISyntaxException;
}
