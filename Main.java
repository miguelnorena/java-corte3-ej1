enum CategoriaProducto {
    ELECTRONICA, COMPUTADORAS, TELEVISORES;
    }
    // Definir la interfaz de Producto
    interface Producto {
    double calcularPrecioFinal();
    String getNombre();
    }
    // Clase base abstracta ProductoBase
abstract class ProductoBase implements Producto {
    protected String nombre;
    protected double precioBase;
    protected CategoriaProducto categoria;
    public ProductoBase(String nombre, double precioBase, CategoriaProducto categoria) {
    this.nombre = nombre;
    this.precioBase = precioBase;
    this.categoria = categoria;
    }
    public String getNombre() {
    return nombre;
    }
    // M´etodo abstracto que se implementar´a en las subclases
    public abstract double calcularPrecioFinal();
    }
    // Subclase para Laptop
    class Laptop extends ProductoBase {
    private double descuento;
    public Laptop(String nombre, double precioBase, double descuento) {
    super(nombre, precioBase, CategoriaProducto.COMPUTADORAS);
    this.descuento = descuento;
    }
    @Override
    public double calcularPrecioFinal() {
    return precioBase - (precioBase * descuento / 100);
    }
    }
    // Subclase para Televisor
    class Televisor extends ProductoBase {
    private double impuesto;
    public Televisor(String nombre, double precioBase, double impuesto) {
    super(nombre, precioBase, CategoriaProducto.TELEVISORES);
    this.impuesto = impuesto;
    }
    @Override
    public double calcularPrecioFinal() {
    return precioBase + (precioBase * impuesto / 100);
    }
    }
    //subclase smartphone
    class Smartphone extends ProductoBase {
        private boolean soporte5G;
        public Smartphone(String nombre, double precioBase, boolean soporte5G) {
            super(nombre, precioBase, CategoriaProducto.ELECTRONICA);
            
            this.soporte5G = soporte5G;
        }
        public boolean tieneSoporte5G() {
            return soporte5G;
        }
        @Override
       public double calcularPrecioFinal() {
        double precioFinal = precioBase;
        precioFinal -= (precioFinal * 5 / 100);
        if (soporte5G) {
            precioFinal += (precioFinal * 5 / 100);  
        }
        return precioFinal;
       }
    }
    // Clase Principal para demostrar polimorfismo
    public class Main {public static void main(String[] args) {
        Producto laptop = new Laptop("Laptop HP", 1000, 10); // 10% de descuento
        Producto televisor = new Televisor("Televisor LG", 1500, 15); // 15% de impuesto
        Producto Smartphone = new Smartphone("Iphone", 800, true);
        mostrarDetallesProducto(laptop);
        mostrarDetallesProducto(televisor);
        mostrarDetallesProducto(Smartphone);
        }
        public static void mostrarDetallesProducto(Producto producto) {
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Precio Final: $" + producto.calcularPrecioFinal());
        System.out.println("-----------------------------");
        }
        }
        