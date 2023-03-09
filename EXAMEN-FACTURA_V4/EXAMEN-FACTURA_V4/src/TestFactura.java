import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestFactura {
    public static Scanner lector = new Scanner(System.in);
    public static ArrayList<Persona> personas = new ArrayList<Persona>();
    public static ArrayList<Productos> productos = new ArrayList<Productos>();
    public static Cliente cliente;
    public static Vendedor vendedor;
    public static Factura factura;

    public static ArrayList<Vendedor> vendedores = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("MENU");
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
                    personas.add(leerCliente());
                    break;
                case 2:
                    personas.add(leerVendedor());
                    break;
                case 3:
                    productos.add(leerProducto());
                    break;
                case 4:
                    int opc2;
                    do {
                        System.out.println("SUBMENU");
                        System.out.println("1. Realizar factura a cliente");
                        System.out.println("2. Agregar producto a cliente");
                        System.out.println("3. Agregar venta al cliente");
                        System.out.println("4. Calcular atributos de factura");
                        System.out.println("0. Salir.");
                        System.out.print("Elegir la opcion: ");
                        opc2 = lector.nextInt();
                        switch (opc2) {
                            case 1:
                                System.out.println("Ingrese el rfc del cliente: ");
                                String buscarrfc = lector.next();
                                for (Persona p : personas ) {
                                    if (((Cliente) p).getRfc().equals(buscarrfc)) {
                                        //p.imprimirDatos();
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("Ingrese el rfc para agregar producto: ");
                                String buscaRfc = lector.next();
                                for (Persona p : personas ) {
                                    if (((Cliente) p).getRfc().equals(buscaRfc)) {
                                            Factura.agregarProductos();
                                    }
                                }
                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                        }

                    } while (opc2 != 0);

                    //agregarFactura();

                    //buscarDatosCliente();
                    break;
                case 5:
                    listarFacturaCliente();
                    break;
                case 6:
                    listarVentas();
                    break;
            }
        } while (op != 0);
        //escribirArchivo();
        escribirArchivoProductos();
    }

    //Permite ingresar los datos de un cliente nuevo
    public static Cliente leerCliente() {
        String nombre, apellidoPaterno, apellidoMaterno, rfc, domicilio;
        int anio, mes, dia;
        Date fechaNacimiento;
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apellidoMaterno = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("RFC");
        rfc = lector.next();
        System.out.println("Domicilio: ");
        domicilio = lector.next();
        return new Cliente(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, rfc, domicilio);
    }

    //Permite ingresar los datos de un Vendedor nuevo
    public static Vendedor leerVendedor() {
        String nombre, apellidoPaterno, apellidoMaterno, area;
        float porcentajeComision;
        int sueldoBase, dni;
        int dia, mes, anio;
        Date fechaNacimiento = new Date(-1900, -1, 00);
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apellidoPaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apellidoMaterno = lector.next();
        System.out.println("DNI: ");
        dni = lector.nextInt();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        fechaNacimiento = new Date(anio - 1900, mes - 1, dia);
        System.out.println("Area: ");
        area = lector.next();
        System.out.println("Porcentaje comision: ");
        porcentajeComision = lector.nextFloat();
        System.out.println("Sueldo base: ");
        sueldoBase = lector.nextInt();
        return new Vendedor(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, area, porcentajeComision, sueldoBase, dni);
    }

    //Permite ingresar los datos de un producto nuevo
    public static Productos leerProducto() {
        int id;
        String descripcion;
        float precio;
        System.out.println("ID del producto: ");
        id = lector.nextInt();
        System.out.println("Descripcion del Producto: ");
        descripcion = lector.next();
        System.out.println("Precio del producto: ");
        precio = lector.nextInt();
        return new Productos(id, descripcion, precio);
    }

    //Permite comenzar una factura
    public static Factura agregarFactura() {
        int anio, mes, dia;
        Date fechaFactura = new Date(-1900, -1, 00);
        float subTotal = 0, iva = 0, total = 0;
        //Arraylist de productos
        System.out.println("Dia: ");
        dia = lector.nextInt();
        System.out.println("Mes: ");
        mes = lector.nextInt();
        System.out.println("Anio: ");
        anio = lector.nextInt();
        //Añadir un for o while que permita estar agregando productos que esten en la arraylist de productos
        int op=0 , producto;
        do{
            System.out.println("Escribe el código del producto que deseas añadir:");
            producto = lector.nextInt();
            for (Productos p : productos){
                if (p.getId()==producto){
                    Factura.agregarProducto();
                }
            }
            System.out.println("Deseas añadir otro articulo? \nSi/1  No/0");
        }while (op != 0);
        System.out.println("Subtotal: ");
        //subTotal = lector.nextFloat();
        System.out.println("IVA: ");
        //iva = lector.nextFloat();
        System.out.println("Total: ");
        //total = lector.nextFloat();
        return new Factura(productos, fechaFactura, subTotal, iva, total, vendedor);
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
        String rfc;
        System.out.println("Ingrese el rfc del cliente");
        rfc = lector.next();
        for (Persona p : personas) {
            if (((Cliente) p).getRfc().equals(rfc))
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

    public static void leerArchivoProductos(){
        File f=new File("C:\\Users\\ready\\OneDrive\\Documentos/Poo2.txt");
        try
        {
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String linea= br.readLine();
            while(linea!=null)
            {
                String[] datos=linea.split(",");
                float precio =Float.parseFloat(datos[2]);
                int id= Integer.parseInt(datos[0]);
                productos.add(new Productos(id,datos[1],precio));
                linea=br.readLine();
            }
            fr.close();
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    public static void escribirArchivoProductos(){
        File f=new File("C:\\Users\\ready\\OneDrive\\Documentos/Poo2.txt");
        int pos = -1;
        for (int i = 0; i < productos.size(); i++) {
            try
            {
                FileWriter fw=new FileWriter(f);
                PrintWriter pw=new PrintWriter(fw);
                pw.println(productos.get(i).toString());
                fw.close();
            }
            catch(IOException e) {
                System.out.println("error");
            }
        }
    }
    /*public static void leerArchivo(){
        File f=new File("E:\\Vendedor.txt");
        try
        {
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String linea= br.readLine();
            while(linea!=null)
            {
                String[] datos=linea.split(",");
                Date fecha= new Date(datos[3]);
                float porcentaje =Float.parseFloat(datos[5]);
                int sueldo=Integer.parseInt(datos[6]);
                int dni=Integer.parseInt(datos[7]);
                personas.add(new Vendedor(datos[0],datos[1],datos[2], fecha, datos[4], porcentaje, sueldo, dni));
                linea=br.readLine();
            }
            fr.close();
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    public static void escribirArchivo(){
        File f=new File("E:\\Vendedor.txt");
        int pos = -1;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(pos) instanceof Vendedor) {
                try
                {
                    FileWriter fw=new FileWriter(f);
                    PrintWriter pw=new PrintWriter(fw);
                    pw.println(personas.get(i).toString());
                    fw.close();
                }
                catch(IOException e) {
                    System.out.println("error");
                }
            }
        }
    }*/
    public static void buscar() {

        System.out.println("Ingresa el id del producto: ");
        int buscador = lector.nextInt();
        for (Productos p : productos) {
            if (buscador == p.getId()) {
                p.imprimirDatos();
            }
        }

    }


    public static void leerBlocProductos() {

        File inpro2 = new File("F:\\Productos1.txt");

        try {
            FileReader fr2 = new FileReader(inpro2); // fr  crea el flujo hacia f
            BufferedReader br2 = new BufferedReader(fr2); // br  permite la lectura
            String linea = br2.readLine(); //  linea toma el valor de la primera linea
            PrintWriter pw = new PrintWriter(inpro2);


            while (linea != null) {
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
            PrintWriter pw = new PrintWriter(inproven);
            while (linea != null) // mientras haya datos en el archivo
            {
                System.out.println(linea);
                String[] itemVendedor;
                itemVendedor = linea.split(",");

                //vendedores.add( );
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
                File("F:\\Productos1.txt");
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
                    pwven.println(p.nombre + "," + p.apellidoPaterno + "," + p.apellidoMaterno + "," + p.formatFecha() + "," + p.getArea() + "," + p.getPorcentajeComision() + "," + p.getSueldoBase());
                }
            }
            fwven.close();

        } catch (IOException lol) {
            System.out.println("Error");
        }

    }
}
//dni == p.getNombre() && p instanceof Vendedor