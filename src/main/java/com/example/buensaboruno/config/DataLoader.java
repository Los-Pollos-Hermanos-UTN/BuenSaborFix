package com.example.buensaboruno.config;

import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.repositories.LocalidadRepository;
import com.example.buensaboruno.repositories.PaisRepository;
import com.example.buensaboruno.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
            // Consume la API y guarda los datos
            RestTemplate restTemplate = new RestTemplate();

            // Suponiendo que la API devuelve una lista de países (Argentina en este caso)
            Pais argentina = new Pais();
            argentina.setNombre("Argentina");
            paisRepository.save(argentina);

            ResponseEntity<Provincia[]> provinciasResponse = restTemplate.getForEntity(PROVINCIAS_API_URL, Provincia[].class);
            Provincia[] provincias = provinciasResponse.getBody();

            if (provincias != null) {
                for (Provincia provincia : provincias) {
                    provincia.setPais(argentina);
                    provinciaRepository.save(provincia);

                    String localidadesApiUrl = String.format(LOCALIDADES_API_URL, provincia.getId());
                    ResponseEntity<Localidad[]> localidadesResponse = restTemplate.getForEntity(localidadesApiUrl, Localidad[].class);
                    Localidad[] localidades = localidadesResponse.getBody();

                    if (localidades != null) {
                        for (Localidad localidad : localidades) {
                            localidad.setProvincia(provincia);
                            localidadRepository.save(localidad);
                        }
                    }
                }
            }
        };
    }
}

