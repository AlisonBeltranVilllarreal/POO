import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TestPersona extends Fecha{


    public static Scanner lector = new Scanner(System.in);
    public static ArrayList<Factura> facturas = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Productos> productoss = new ArrayList<>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<>();


    public static ArrayList<TestPersona> testFacturas = new ArrayList<>();

    public String nombre2;
    public String apePaterno2;
    public String apeMaterno2;

    public String area2;
    public float porcentajeComision2;
    public int sueldoBase2;

    public TestPersona(String nombre2, String apePaterno2, String apeMaterno2, Fecha fechaNacimiento,
                    String area2, float porcentajeComision2, int sueldoBase2){
        super(fechaNacimiento.dia, fechaNacimiento.mes, fechaNacimiento.anio);

        this.nombre2=nombre2;
        this.apePaterno2=apePaterno2;
        this.apeMaterno2=apeMaterno2;

        this.area2=area2;
        this.porcentajeComision2=porcentajeComision2;
        this.sueldoBase2=sueldoBase2;
    }


    public static void main(String[] args) {
        int op1, op2, op3, op4, op5;

        do {
          

            System.out.println("\n MENU PRINCIPAL");
            System.out.println("1. Agregar Producto.");
            System.out.println("2. Agregar Vendedor.");
            System.out.println("3. Factura.");
            System.out.println("0. Salir.");
            System.out.print("Elegir la opcion: ");
            op1 = lector.nextInt();


            switch (op1) {
                case 1:

                    do {
                        
                        System.out.println("\n Agregar Prodcutos");
                        System.out.println("1. Agregar prodcutos.");
                        System.out.println("2. Buscar producto. ");
                        System.out.println("0. Salir.");
                        System.out.print("Elegir la opcion: ");
                        op2 = lector.nextInt();
                        switch (op2) {
                            case 1:
                                productoss.add(Productos.agregar());
                                break;

                            case 2:
                                buscar();
                                break;
                        }

                    } while (op2 != 0);



                    break;

                case 2:

                    do {
                        System.out.println(vendedores.size());
                        System.out.println("\n MENU VENDEDORES ");
                        System.out.println("1. Ingresar Vendedores.");
                        System.out.println("2. Imprimir datos de Vendedores.");
                        System.out.println("0. Salir.");
                        System.out.print("Elegir la opcion: ");
                        op4 = lector.nextInt();
                        switch (op4) {
                            case 1:
                                vendedores.add(Vendedor.leerVendedor());
                                break;

                            case 2:
                                System.out.println("Ingresa el nombre del Vendedor: ");
                                String nomVendedor = lector.next();
                                for (Vendedor p : vendedores) {
                                    if (nomVendedor.equals(p.nombre)) {
                                        p.ImprimirVendedor();
                                    }
                                }
                                break;
                        }
                    } while (op4 != 0);



                    break;

                case 3:
                    //Realizar factura_Agregar Cliente_Agregar productos


                    do {
                        System.out.println("\nREALIZAR FACTURA");
                        System.out.println("1. Registrar Cliente.");
                        System.out.println("2. Buscar Cliente.");
                        System.out.println("3. Realizar Factura de Cliente");
                        System.out.print("Elige la opcion: ");
                        op5 = lector.nextInt();
                        switch (op5) {
                            case 1:
                                clientes.add(Cliente.leerCliente());
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre del cliente: ");
                                String nomCliente = lector.next();
                                for (Cliente p : clientes) {
                                    if (nomCliente.equals(p.nombre)) {
                                        p.ImprimirCliente();
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese el nombre del cliente: ");
                                nomCliente = lector.next();
                                for (Cliente p : clientes) {
                                    if (nomCliente.equals(p.nombre)) {
                                     
                                        do {
                                            System.out.println(" Menu de factura");
                                            System.out.println("Menu del cliente: " );
                                            System.out.println("1. Agregar Productos. ");
                                            System.out.println("2. Eliminar Productos.");
                                            System.out.println("3. Agregar Vendedor");
                                            System.out.println("0. salir.");
                                            System.out.print("Elegir la opcion: ");
                                            op3 = lector.nextInt();
                                            switch (op3) {
                                                case 1:
                                                   
                                                    break;

                                                
                                               
                                            }


                                        } while (op3 != 0);


                                        }


                                    }


                        }

                    } while (op5 != 0);

            }

        } while (op1 != 0);


        listarProductos();
        listarVendedor();
        

    }



    //Buscar los productos
    public static void buscar() {

        System.out.println("Ingresa el id del producto: ");
        int buscador = lector.nextInt();
        for (Productos p : productoss) {
            if (buscador == p.id) {
                p.ImprimirDatos();
            }
        }

    }

    public static void leerBlocProductos() {


        File inpro2 = new File("C:\\Productos.txt");

        try {
            FileReader fr2 = new FileReader(inpro2); // fr  crea el flujo hacia f
            BufferedReader br2 = new BufferedReader(fr2); // br  permite la lectura
            String linea = br2.readLine(); //  linea toma el valor de la primera linea
            PrintWriter pw=new PrintWriter(inpro2);


            while(linea !=null){
                String[] itemProducto;
                itemProducto = linea.split(",");
                productoss.add(new Productos(Integer.parseInt(itemProducto[0]), itemProducto[1], Float.parseFloat(itemProducto[2])));
                linea = br2.readLine();
            }
            pw.println(productoss);

            fr2.close(); // cierra el archivo
        } catch (IOException e) {
            System.out.println("error"); // si no se pudo accede al archivo
        }

    }

    public static void leerBlocVendedor() {

        File inproven = new File("C:\\Vendedor.txt");

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
                        itemVendedor[2], new Fecha(Integer.parseInt(itemVendedor[3]), Integer.parseInt(itemVendedor[4]),
                        Integer.parseInt(itemVendedor[5])),
                        itemVendedor[6], Float.parseFloat(itemVendedor[7]), Integer.parseInt(itemVendedor[8])));
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
                File("C:\\Productos.txt");
        try {
            FileWriter fw = new FileWriter(iDP, true);
            PrintWriter pw = new PrintWriter(fw);
            {
                for (Productos p : productoss) {
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
                File("C:\\Vendedor.txt");
        try {
            FileWriter fwven = new FileWriter(iDPVEN, true);
            PrintWriter pwven = new PrintWriter(fwven);
            {
                for (Vendedor p : vendedores) {
                    pwven.println(p.nombre + "," + p.apePaterno + "," + p.apeMaterno + "," + p.fechaNacimiento.dia+","+p.fechaNacimiento.mes+","+p.fechaNacimiento.anio+ "," + p.area + "," + p.porcentajeComision + "," + p.sueldoBase);
                }
            }
            fwven.close();

        } catch (IOException lol) {
            System.out.println("Error");
        }

    }

    public static void agregarID(){


        System.out.println(" MENU AGREGAR ");
        System.out.print("Agregar por ID: ");
        int agregarID= lector.nextInt();
        for (Productos p: productoss){
            if (agregarID==p.id){
                facturas.add(new Factura(p.id, p.descripcion, p.precio));
                
            }
        }

    }

    public static void eliminarID(){

    
        //System.out.println(" MENU AGREGAR ");
        //System.out.print("Eliminar por ID: ");
        //int eliminarID= lector.nextInt();
        //for(Factura p : facturas){
            //if(eliminarID==p.id2){
               // facturas.remove(p);
            //}
        //}
    }
        



}