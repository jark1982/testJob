package cl.desafio.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.periodos.swagger.codegen.model.Periodo;

import cl.desafio.service.inferces.IDesafioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@Api(value = "desafio", produces = "application/json")
@RequestMapping("/desafio")
public class DesafioController {

	@Autowired
	IDesafioService iDesafioService;

	@ApiOperation(value = "${DesafioController.postDesafio}")
	@PostMapping("/response")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Something went wrong"),
			@ApiResponse(code = 200, message = "successfully"),
			@ApiResponse(code = 403, message = "Invalid JWT Token") })

	public ResponseEntity<Periodo> postDesafio() throws URISyntaxException {
		Periodo periodo = iDesafioService.executeDesafio();
		ResponseEntity<Periodo> response = new ResponseEntity<>(periodo, HttpStatus.OK);
		return response;

	}
	
	@ApiOperation(value = "${DesafioController.getDesafio}")
	@GetMapping("/response")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Something went wrong"),
			@ApiResponse(code = 200, message = "successfully"),
			@ApiResponse(code = 403, message = "Invalid JWT Token") })

	public ResponseEntity<Periodo> getDesafio() throws URISyntaxException {
		Periodo periodo = iDesafioService.executeDesafio();
		ResponseEntity<Periodo> response = new ResponseEntity<>(periodo, HttpStatus.OK);
		return response;

	}
}
