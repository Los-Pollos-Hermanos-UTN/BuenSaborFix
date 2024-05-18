package com.example.buensaboruno.config;

import com.example.buensaboruno.domain.dtos.LocalidadDTO;
import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.domain.responses.LocalidadResponse;
import com.example.buensaboruno.domain.responses.ProvinciaResponse;
import com.example.buensaboruno.repositories.LocalidadRepository;
import com.example.buensaboruno.repositories.PaisRepository;
import com.example.buensaboruno.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    // URL de la API de provincias de Argentina
    private static final String PROVINCIAS_API_URL = "https://apis.datos.gob.ar/georef/api/provincias?campos=id,nombre";

    // URL de la API de localidades por provincia
    private static final String LOCALIDADES_API_URL = "https://apis.datos.gob.ar/georef/api/localidades?provincia=%s&campos=id,nombre&max=100";

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();

            // Suponiendo que la API devuelve una lista de países (Argentina en este caso)
            Pais argentina = new Pais();
            argentina.setNombre("Argentina");
            paisRepository.save(argentina);

            ResponseEntity<ProvinciaResponse> provinciasResponse = restTemplate.getForEntity(PROVINCIAS_API_URL, ProvinciaResponse.class);
            ProvinciaResponse provinciaResponse = provinciasResponse.getBody();

            if (provinciaResponse != null && provinciaResponse.getProvincias() != null) {
                List<ProvinciaDTO> provinciaDTOs = provinciaResponse.getProvincias();

                for (ProvinciaDTO provinciaDTO : provinciaDTOs) {
                    Provincia provincia = new Provincia();
                    provincia.setNombre(provinciaDTO.getNombre());
                    provincia.setPais(argentina);
                    provinciaRepository.save(provincia);

                    String localidadesApiUrl = String.format(LOCALIDADES_API_URL, provinciaDTO.getId());
                    ResponseEntity<LocalidadResponse> localidadesResponse = restTemplate.getForEntity(localidadesApiUrl, LocalidadResponse.class);
                    LocalidadResponse localidadResponse = localidadesResponse.getBody();

                    if (localidadResponse != null && localidadResponse.getLocalidades() != null) {
                        List<LocalidadDTO> localidadDTOs = localidadResponse.getLocalidades();

                        for (LocalidadDTO localidadDTO : localidadDTOs) {
                            Localidad localidad = new Localidad();
                            localidad.setNombre(localidadDTO.getNombre());
                            localidad.setProvincia(provincia);
                            localidadRepository.save(localidad);
                        }
                    }
                }
            }
        };
    }
}

