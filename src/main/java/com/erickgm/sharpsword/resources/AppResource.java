package com.erickgm.sharpsword.resources;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Application")
@CrossOrigin(origins = "*")
public class AppResource {

	@Autowired
	private ArmaService armaService;

	@Autowired
	private ArmaduraService armaduraService;
	
	@Autowired
	private HabilidadeService habilidadeService;

	@Autowired
	private EquipamentoService equipamentoService;
	
	@Autowired
	private MunicaoService municaoService;
	
	@Autowired
	private RacaService racaService;	

	@Autowired
	private ClasseService classeService;

	@Autowired
	private AlinhamentoService alinhamentoService;

	@GetMapping("/carga_inicial")
	@ApiOperation(value = "Este método executa a carga inicial nas tabelas do sistema")
	public List<String> cargaInicial() {
		List<String> lista = new ArrayList<>();

		lista.add(racaService.cargaInicial());
		lista.add(classeService.cargaInicial());
		lista.add(alinhamentoService.cargaInicial());

		// lista.add(armaService.cargaInicial());
		// lista.add(armaduraService.cargaInicial());
		// lista.add(equipamentoService.cargaInicial());
		// lista.add(municaoService.cargaInicial());
		// lista.add(habilidadeService.cargaInicial());
		
		return lista;
	}

}