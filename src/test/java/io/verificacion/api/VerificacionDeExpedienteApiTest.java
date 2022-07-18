package io.verificacion.api;

import io.verificacion.api.VerificacionDeExpedienteApi;
import io.verificacion.client.ApiClient;
import io.verificacion.model.CatalogoEstados;
import io.verificacion.model.CatalogoSexo;
import io.verificacion.model.DomicilioPeticion;
import io.verificacion.model.Domicilios;
import io.verificacion.model.PersonaPeticion;
import io.verificacion.model.Personas;
import io.verificacion.model.PersonasPeticion;
import io.verificacion.model.Respuesta;
import okhttp3.OkHttpClient;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerificacionDeExpedienteApiTest {
	
    private final VerificacionDeExpedienteApi api = new VerificacionDeExpedienteApi();
    
    private ApiClient apiClient;
    
    private String xApiKey = "your_x_api_key";
    private String url = "the_url";
    
    
    @Before()
    public void setUp() {
        this.apiClient = api.getApiClient();
         this.apiClient.setBasePath(url);
         OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
         apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void getReporteTest() throws Exception {
        
        PersonaPeticion request = new PersonaPeticion();
        
        Personas personas = new Personas();
        
        List<PersonasPeticion> personasPeticionList = new ArrayList<PersonasPeticion>();
        
        PersonasPeticion personasPeticion = new PersonasPeticion();
        
        Domicilios domicilios = new Domicilios();
        
        List<DomicilioPeticion> domicilioPeticionList = new ArrayList<DomicilioPeticion>();
        
        DomicilioPeticion domicilioPeticion = new DomicilioPeticion();
        
        domicilioPeticion.setCiudad("INSURGENTES SUR 1007");
        domicilioPeticion.setDelegacionMunicipio(" MIGUEL HIDALGO");
        domicilioPeticion.setCiudad("MEXICO");
        domicilioPeticion.setEstado(CatalogoEstados.DF);
        domicilioPeticion.setCodigoPostal("11230");
        domicilioPeticion.setNumeroTelefono("5517207788");
        
        domicilioPeticionList.add(domicilioPeticion);
        
        domicilios.setList(domicilioPeticionList);
        
        
        personasPeticion.setNombres("JUAN");
        personasPeticion.setApellidoPaterno("PRUEBA");
        personasPeticion.setApellidoMaterno("SIETE");
        personasPeticion.setFechaNacimiento("1980-01-07");
        personasPeticion.setRFC("PUSJ800107");
        personasPeticion.setCURP("SAZR010101HCMLNS09");
        personasPeticion.setClaveElectorIFE("000000000000");
        personasPeticion.setSexo(CatalogoSexo.F);
        personasPeticion.setDomicilios(domicilios);
        
        personasPeticionList.add(personasPeticion);
        
        personas.setList(personasPeticionList);
        
        request.setFolioOtorgante("12345");
        request.setPersonas(personas);
        
        Respuesta response = api.getReporte(xApiKey, request);
        
        Assert.assertTrue(response.getPersonas().getFolio() != null);
    }
    
}
