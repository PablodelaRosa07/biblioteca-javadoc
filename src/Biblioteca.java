package dam.primero;

/*
 * Clase que representa una biblioteca con capacidad limitada para gestionar su inventario.
 * Permite registrar la entrada y salida de libros, consultar el espacio disponible
 * y conocer el estado de ocupación.
 *
 * @author Pablo
 * @version 1.0
 * @since 2026-04-27
 */

public class Biblioteca {

    private String nombre;
    private String ciudad;
    private int capacidad;
    private int librosActuales;

    /*
     * Constructor de la clase Biblioteca.
     * Inicializa la biblioteca con un nombre, una ciudad y una capacidad máxima definida.
     * La cantidad de libros iniciales se establece en 0.
     *
     * @param nombre   Nombre de la biblioteca.
     * @param ciudad   Ciudad de ubicación.
     * @param capacidad   Capacidad máxima de almacenamiento de libros.
     * @param librosActuales    Número de libros actuales.
     */

    public Biblioteca(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.librosActuales = 0;
    }

    /*
     * Agrega libros a la biblioteca.
     * Valida que la cantidad sea positiva y que no supere la capacidad máxima.
     *
     * @param cantidad    Número de libros a agregar.
     * @return true    Si la operación fue exitosa, false en caso contrario.
     */

    public boolean agregarLibro(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (librosActuales + cantidad > capacidad) {
            return false;
        }
        librosActuales += cantidad;
        return true;
    }

    public boolean retirarLibro(int cantidad) {
        if (cantidad <= 0 || cantidad > librosActuales) {
            return false;
        }
        librosActuales -= cantidad;
        return true;
    }

    /*
     *  @return get del espacio disponible.
     */
    public int getEspacioDisponible() {
        return capacidad - librosActuales;
    }

    /*
     *  @return get del porcentaje de ocupación.
     */
    public double getPorcentajeOcupacion() {
        if (capacidad == 0) return 0.0;
        return (librosActuales * 100.0) / capacidad;
    }

    /*
     *  @return boolean de si hay más libros que la capacidad permitida.
     */
    public boolean estaLlena() {
        return librosActuales >= capacidad;
    }


    /*
     *  @return get del nombre.
     */
    public String getNombre()        { return nombre; }

    /*
     *  @return get de la ciudad.
     */
    public String getCiudad()        { return ciudad; }

    /*
     *  @return get de la capacidad.
     */
    public int getCapacidad()        { return capacidad; }

    /*
     *  @return get de los libros actuales.
     */
    public int getLibrosActuales()   { return librosActuales; }


    /*
     *  @return override toString.
     */
    @Override
    public String toString() {
        return nombre + " (" + ciudad + ") - " + librosActuales + "/" + capacidad + " libros";
    }
}