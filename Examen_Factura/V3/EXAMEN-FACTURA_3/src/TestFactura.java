import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class TestFactura {
    public static Scanner lector = new Scanner(System.in);

    public static ArrayList<Persona> personas = new ArrayList<>();
    public static ArrayList<Productos> productos = new ArrayList<>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<>();
    public static ArrayList<Factura> facturas = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
   

    public static Cliente cliente;
    public static Vendedor vendedor;
    public static Factura factura;

    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("1.- Alta clientes ");
            System.out.println("2.- Alta vendedores");
            System.out.println("3.- Alta productos");
            System.out.println("4.- Realizar venta");
            System.out.println("5.- Listar facturas a determinado cliente");
            System.out.println("6.- Buscar vendedor");
            System.out.println("0.- Salir");
            System.out.println("Seleccione opción: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    personas.add(Cliente.leerCliente());
                    break;
                case 2:
                    personas.add(Vendedor.leerVendedor());
                    break;
                case 3:
                    productos.add(Productos.leerProducto());
                    break;
                case 4:
                boolean repetir = true;
                do {
                    try {
                        System.out.println("Ingrese el RFC del cliente: ");
                        String RFC = lector.next();
                        for (Persona p : personas)
                            if (p instanceof Cliente) {
                                if (((Cliente) p).getRfc().equals(RFC)) {
                                    Factura.agregarFactura();
                                }
                            }
                        repetir = false;
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error");
                    }
                } while (repetir != false);
                    break;
                case 5:
                System.out.println("Metodo examen:");
                System.out.println("Cuantas facturas tiene un cliente:");
                System.out.println("Ingrese el RFC del cliente: ");
                        String RFC = lector.next();
                    for (Persona p : personas)
                    if (p instanceof Cliente) {
                        if (((Cliente) p).getRfc().equals(RFC)) {
                            cliente.facturasAcumuladas.add(facturas);
                            System.out.println("Cliente: " + p.getNombre());
                        }
                    }
                    
                    break;
                case 6:
                    listarVentas();
                    break;
            }
        } while (op != 0);
        listarProductos();
        listarVendedor();
        leerBlocProductos();
        leerBlocVendedor();
    }

    //BUSCAR VENDEDOR, LISTAR SUS VENTAS, MOSTRAR SU COMISION Y SU SUELDO NETO
    public static void resultadoVendedor() {
        System.out.println("Ingresa el DNI del vendedor que deseas buscar:");
        int dni = lector.nextInt();
        for (Persona p : personas) {
            if (((Vendedor) p).getDni() == dni) ;
            //Listar ventas de el vendedor
            System.out.println((vendedor).getPorcentajeComision());
            System.out.println((vendedor).getSueldoBase());
        }
    }

    //Lista las facturas de determinado cliente
    public static void listarFacturaCliente() {
        String buscarNombre;
        System.out.println("Ingrese el nombre del cliente");
        buscarNombre = lector.next();
        for (Cliente p : clientes) {
            if (buscarNombre.equals(p.nombre))
                factura.imprimirFactura();
        }
    }

    //Lista las ventas de un vendedor
    public static void listarVentas() {
        int dni;
        System.out.println("Ingrese el nombre del vendedor");
        dni = lector.nextInt();
        for (Persona p : personas) {
            if (((Vendedor) p).getDni() == dni)
                factura.imprimirFactura();
        }
    }

    public static void leerBlocProductos() {


        File inpro2 = new File("F:\\Productos.txt");

        try {
            FileReader fr2 = new FileReader(inpro2); // fr  crea el flujo hacia f
            BufferedReader br2 = new BufferedReader(fr2); // br  permite la lectura
            String linea = br2.readLine(); //  linea toma el valor de la primera linea
            PrintWriter pw=new PrintWriter(inpro2);


            while(linea !=null){
                String[] itemProducto;
                itemProducto = linea.split(",");
                productos.add(new Productos(Integer.parseInt(itemProducto[0]), itemProducto[1], Float.parseFloat(itemProducto[2])));
                linea = br2.readLine();
            }
            pw.println(productos);

            fr2.close(); // cierra el archivo
        } catch (IOException e) {
            System.out.println("error"); // si no se pudo accede al archivo
        }

    }

    public static void leerBlocVendedor() {

        File inproven = new File("F:\\Vendedor.txt");

        try {
            FileReader frven = new FileReader(inproven); // fr  crea el flujo hacia f
            BufferedReader brven = new BufferedReader(frven); // br  permite la lectura
            String linea = brven.readLine(); //  linea toma el valor de la primera linea
            PrintWriter pw=new PrintWriter(inproven);
            while (linea != null) // mientras haya datos en el archivo
            {

                String[] itemVendedor;
                itemVendedor = linea.split(",");
                vendedores.add(new Vendedor(itemVendedor[0], itemVendedor[1],
                itemVendedor[2], new Date(Integer.parseInt(itemVendedor[3]), Integer.parseInt(itemVendedor[4]),
                Integer.parseInt(itemVendedor[5])),
                itemVendedor[6], Float.parseFloat(itemVendedor[7]), Integer.parseInt(itemVendedor[8]),Integer.parseInt(itemVendedor[9])));
                linea = brven.readLine();

            }

            pw.println(vendedores);

            frven.close();


        } catch (IOException r) {
            System.out.println("ERROR");
        }

    }

    //Imprimir en BlocNotas
    public static void listarProductos() {
        File iDP = new
                File("F:\\Productos.txt");
        try {
            FileWriter fw = new FileWriter(iDP, true);
            PrintWriter pw = new PrintWriter(fw);
            {
                for (Productos p : productos) {
                    pw.println(p.getId() + "," + p.getDescripcion() + "," + p.getPrecio());
                }
            }
            fw.close();

        } catch (IOException lol) {
            System.out.println("Error");
        }

    }

    // Imprimir en BlocNotas
    public static void listarVendedor() {
        File iDPVEN = new
                File("F:\\Vendedor.txt");
        try {
            FileWriter fwven = new FileWriter(iDPVEN, true);
            PrintWriter pwven = new PrintWriter(fwven);
            {
                for (Vendedor p : vendedores) {
                    pwven.println(p.nombre + "," + p.apellidoPaterno + "," + p.apellidoMaterno + "," +
                            p.formatFecha() + "," + p.getArea() + "," + p.getPorcentajeComision() + "," + p.getSueldoBase());
                }
            }
            fwven.close();

        } catch (IOException lol) {
            System.out.println("Error");
        }

    }
}
