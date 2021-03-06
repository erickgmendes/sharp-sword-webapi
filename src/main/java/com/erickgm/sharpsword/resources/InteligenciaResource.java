package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.InteligenciaDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Inteligência")
@CrossOrigin(origins = "*")
public class InteligenciaResource {

    @GetMapping("/inteligencia/{valor}")
    @ApiOperation(value = "Este método retorna os cálculos para o atributo inteligência")
    public ResponseEntity<InteligenciaDtoResponse> calcularInteligencia(@PathVariable(value = "valor") int valor) {

         String idiomasAdicionais = "0";
         String chanceDeAprenderMagia = "0%";
         String magiasArcanasAdicionais = "-";

        switch (valor) {
            case 14: case 15:
                idiomasAdicionais = "1";
                chanceDeAprenderMagia = "25%";
                magiasArcanasAdicionais = "0";
                break;
            case 16: case 17:
                idiomasAdicionais = "2";
                chanceDeAprenderMagia = "35%";
                magiasArcanasAdicionais = "1 de 1º círculo";
                break;
            case 18: case 19:
                idiomasAdicionais = "3";
                chanceDeAprenderMagia = "45%";
                magiasArcanasAdicionais = "2 de 1º círculo";
                break;
            case 20: case 21:
                idiomasAdicionais = "4";
                chanceDeAprenderMagia = "55%";
                magiasArcanasAdicionais = "1 de 2º círculo e 2 de 1º círculo";
                break;
        }

        InteligenciaDtoResponse retorno = new InteligenciaDtoResponse(
            idiomasAdicionais,
            chanceDeAprenderMagia,
            magiasArcanasAdicionais
        );

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}