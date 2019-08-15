package cl.desafio.service.inferces;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.previred.periodos.swagger.codegen.model.Periodo;
@Service
public interface IProxyDelegate {
	
	public ResponseEntity<Periodo> getPeriodo() throws URISyntaxException;

}
