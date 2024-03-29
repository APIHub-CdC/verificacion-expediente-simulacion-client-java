# verificacion-expediente-simulacion-client-java [![GitHub Packages](https://img.shields.io/badge/Maven&nbsp;package-Last&nbsp;version-lemon)](https://github.com/orgs/APIHub-CdC/packages?repo_name=ficoscore-simulacion-client-java) 


Verificacion de Expediente.<br/><img src='https://github.com/APIHub-CdC/imagenes-cdc/blob/master/circulo_de_credito-apihub.png' height='37' width='160'/></p><br/>

## Requisitos

1. Java 1.7+
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:
```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***src/test/java/io/verificacion/api/VerificacionDeExpedienteApi.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
private final VerificacionDeExpedienteApi api = new VerificacionDeExpedienteApi();
    
    private ApiClient apiClient;
    
    private String xApiKey = "your_api_key";
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
```
De igual manera, en el archivo **VerificacionDeExpedienteApi.java**, se deberá modificar el siguiente fragmento de código con los datos correspondientes:

> **NOTA:** Para más ejemplos de simulación, consulte la colección de Postman.

```java
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
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```
---
[CONDICIONES DE USO, REPRODUCCIÓN Y DISTRIBUCIÓN](https://github.com/APIHub-CdC/licencias-cdc)
