import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static Scanner lector = new Scanner(System.in);
    public static ArrayList<Productos> productos = new ArrayList<>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Factura> facturas = new ArrayList<>();

    static File productosArchivo = new File("F:\\Productos.txt");
    static File vendedoresArchivo = new File("F:\\vendedores.txt");

    public static void main(String[] args) throws IOException {
        String st;

        //leer productos
        BufferedReader br = new BufferedReader(new FileReader(productosArchivo));
        while ((st = br.readLine()) != null) {
            String[] productosArray = st.split(",");
            productos.add(new Productos(Integer.parseInt(productosArray[0]), productosArray[1], Float.parseFloat(productosArray[2])));
        }

        // productos.forEach((item) -> item.imprimirDatos());


        //leer vendedores
        BufferedReader br2 = new BufferedReader(new FileReader(vendedoresArchivo));
        while ((st = br2.readLine()) != null) {
            String[] vendedoresArray = st.split(",");
            vendedores.add(new Vendedor( Integer.parseInt(vendedoresArray[0]),vendedoresArray[1],vendedoresArray[2],vendedoresArray[3], new Date((Integer.parseInt(vendedoresArray[4]))),
            vendedoresArray[5],
                            Float.parseFloat(vendedoresArray[6]),
                            Integer.parseInt(vendedoresArray[7])));
        }

        //vendedores.forEach((item) -> item.imprimirDatos());

        int op;
        do {
            System.out.println("1.- Dar de alta un Cliente");
            System.out.println("2.- Dar de alta un Vendedor");
            System.out.println("3.- Dar de alta un Producto");
            System.out.println("4.- Realizar Venta");//factura
            System.out.println("5.- Listar Factura a determinado Cliente");
            System.out.println("6.- Buscar Vendedor");//listar sus ventas, mostrar su comision y su sueldo neto//
            System.out.println("0.- Salir");
            System.out.println("Opcion: ");
            op = lector.nextInt();

            switch (op) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    crearVendedor();
                    break;
                case 3:
                    crearProducto();
                    break;
                case 4:
                    crearFactura();
                    break;
                case 5:
                    listaFacturas();
                    break;
                case 6:
                    listarVenta();
                    break;
                default:
                    break;
            }


        } while (op != 0);
    }

    public static void crearCliente() {
        String rfc, domicilio;
        int  dia, mes, anio;
        String nombre, apellidoPaterno, apellidoMaterno, area;
        System.out.println("Nombre del Cliente: ");
        nombre = lector.next();
        System.out.println("Apellido paterno del Cliente: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido materno del Cliente: ");
        apellidoMaterno = lector.next();
        System.out.println("Dia de nacimiento del Cliente: ");
        dia = lector.nextInt();
        System.out.println("Mes de nacimiento del Cliente: ");
        mes = lector.nextInt();
        System.out.println("Año de nacimiento del Cliente: ");
        anio = lector.nextInt();
        Date fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("RFC del cliente: ");
        rfc = lector.next();
        System.out.println("Domicilio del cliente: ");
        domicilio = lector.next();
        clientes.add(new Cliente(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, rfc, domicilio, new ArrayList<Factura>()));
    }

    public static void crearVendedor() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        int id, dia, mes, anio, sueldoBase;
        String nombre, apellidoPaterno, apellidoMaterno, area;
        float porcentajeComision;
        System.out.println("Id del vendedor: ");
        id = lector.nextInt();
        System.out.println("Nombre del vendedor: ");
        nombre = lector.next();
        System.out.println("Apellido paterno del vendedor: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido materno del vendedor: ");
        apellidoMaterno = lector.next();
        System.out.println("Dia de nacimiento del vendedor: ");
        dia = lector.nextInt();
        System.out.println("Mes de nacimiento del vendedor: ");
        mes = lector.nextInt();
        System.out.println("Año de nacimiento del vendedor: ");
        anio = lector.nextInt();
        Date fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("Area del vendedor: ");
        area = lector.next();
        System.out.println("Porcentaje de comision del vendedor: ");
        porcentajeComision = lector.nextFloat();
        System.out.println("Sueldo base del vendedor: ");
        sueldoBase = lector.nextInt();
        vendedores.add( new Vendedor( id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, area, porcentajeComision, sueldoBase));

        // sobreescribir el archivo
        try {
            String data = "ID: " + id+"\nNombre: "+nombre+"\nApellido Paterno: "+apellidoPaterno+"\nApellido Materno: "+apellidoMaterno+"\nFecha Nacimiento: "+fechaNacimiento+"\nArea: "+area+"\nPorcentaje Comision: "+porcentajeComision+"\nSueldo Base: "+sueldoBase;
            fw = new FileWriter(vendedoresArchivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void crearProducto() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        int id;
        String descripcion;
        float precio;
        System.out.println("ID del producto: ");
        id = lector.nextInt();
        System.out.println("Descripcion del producto: ");
        descripcion = lector.next();
        System.out.println("Precio del producto: ");
        precio = lector.nextFloat();
        productos.add(new Productos(id, descripcion, precio));

        // sobreescribir en el archivo
        try {
            String data = "ID: "+ id +"\nDescripcion: "+ descripcion +"\nPrecio: "+precio+ "\n";
            fw = new FileWriter(productosArchivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void crearFactura() {
        int opc1 = 1;
        String RFC;
        Cliente cliente = null;
        Vendedor vendedor = null;
        Date fechaFactura = null;
        float subTotal = 0, iva = 0, total = 0;
        ArrayList<Productos> productosComprados = new ArrayList<>();

        System.out.println("RFC del cliente:");
        RFC = lector.next();

        for (Cliente c : clientes){
            if (c.getRfc().equals(RFC)) {
                cliente = c;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        do {
            System.out.println("1.- Agregar Producto");
            System.out.println("2.- Eliminar Producto");
            System.out.println("0.- Salir");
            System.out.println("Ingresa Opcion: ");
            opc1 = lector.nextInt();

            switch (opc1) {
                case 1:
                    int agregarID;
                    Productos agregar = null;

                    System.out.println("ID del producto que deseas agregar: ");
                    agregarID = lector.nextInt();

                    for (Productos p : productos){
                        if (p.getId() == agregarID) {
                            agregar = p;
                        }
                    }

                    if (agregar == null) {
                        System.out.println("No Existe ese producto.");
                        System.out.println();
                    } else {
                        productosComprados.add(agregar);
                    }

                    break;
                case 2:
                int eliminarID;
                Productos eliminar = null;
                    System.out.print("ID del producto que deseas eliminar: ");
                     eliminarID = lector.nextInt();
                    for (Productos p : productos){
                        if (p.getId() == eliminarID) {
                            eliminar = p;
                        }
                    }

                    if (eliminar == null) {
                        System.out.println("No Existe ese producto.");
                        System.out.println();
                    } else {
                        productosComprados.remove(eliminar);
                    }
                    break;

                default:
                System.out.println("La Opcion introducida no es valida.");
                    break;
            }
        } while (opc1 != 0);

        int idVendedor;
        System.out.println("ID del Vendedor: ");
        idVendedor = lector.nextInt();

        for (Vendedor item : vendedores){
            if (item.getId() == idVendedor) {
                vendedor = item;
            }
        }

        if (vendedor == null) {
            System.out.println("No existe Vendedor");
            return;
        }

        /*/ fecha factura
        Date date = new Date();
        // formatear horario local
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anio = localDate.getYear();
        int mes = localDate.getMonthValue();
        int dia = localDate.getDayOfMonth();
        fechaFactura = new (dia, mes, anio);*/

        // Calcular datos de la Factura
        for (Productos p : productosComprados){
            subTotal += p.getPrecio();
        }
        iva = (float) (subTotal * 0.16);
        total = subTotal + iva;

        facturas.add(
                new Factura(
                        facturas.size() + 1,
                        cliente,
                        fechaFactura,
                        subTotal,
                        iva,
                        total,
                        productosComprados,
                        vendedor
                )
        );
    }

    public static void listaFacturas() {
        String rfc;
        System.out.println("Introduce RFC del cliente: ");
        rfc = lector.next();

        for (Factura f : facturas){
            if (f.getCliente().getRfc().equals(rfc)) {
                f.imprimirDatos();
            }
        }
        System.out.println();
    }

    public static void listarVenta() {
        int id;
        float totalFactura = 0;
        float totalComisiones = 0;
        Vendedor vendedor = null;
        System.out.println("ID del Vendedor: ");
        id = lector.nextInt();

        for (Vendedor v : vendedores) {
            if (v.getId() == id) {
                vendedor = v;
            }
        }

        if (vendedor == null) {
            System.out.println("Vendedor no Existe. ");
            return;
        }

        System.out.println();
        System.out.println("Vendedor: ");
        vendedor.imprimirDatos();
        System.out.println();
        System.out.println("Facturas: ");
        for (Factura item : facturas) {
            if (item.getVendedor().getId() == vendedor.getId()) {
                totalFactura += item.getTotal();
                item.imprimirDatos();
            }
        }
        System.out.println();

        totalComisiones = (float) (totalFactura * (vendedor.getPorcentajeComision() * 0.01));
        Float sueldoNeto = vendedor.getSueldoBase() + totalComisiones;
        System.out.println("Sueldo: ");
        System.out.println("Total Comisiones: "+ totalComisiones);
        System.out.println("Sueldo neto: "+ sueldoNeto);
        System.out.println();
    }

    public String formatFecha() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = sfd.format(new Date());
        return fechaFormat;
    }
}
