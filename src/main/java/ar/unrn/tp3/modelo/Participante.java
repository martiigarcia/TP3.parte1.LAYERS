package ar.unrn.tp3.modelo;
public class Participante {

    private final String nombre, telefono, region;

    public Participante(String nombre, String telefono, String region) {

        if (verificarDatoNulo(nombre) || verificarDatoVacio(nombre))
            throw new RuntimeException("Debe cargar un nombre correctamente.");
        if (verificarDatoNulo(telefono) || verificarDatoVacio(telefono) )
            throw new RuntimeException("Debe cargar un numero de telefono correctamente.");
        if (validarTelefono(telefono))
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN.");
        if (verificarDatoNulo(region) || verificarDatoVacio(region))
            throw new RuntimeException("Debe ingresar una region correctamente.");
        if (validarRegion(region))
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa.");


        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private boolean verificarDatoVacio(String dato) {
        return dato.isEmpty();
    }

    private boolean verificarDatoNulo(String dato) {
        return dato == null;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private boolean validarRegion(String region) {
        return (!region.equals("China") && !region.equals("US") && !region.equals("Europa"));
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }
}