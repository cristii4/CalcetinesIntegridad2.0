package com.mycompany.calcetinesintegridad2;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MenuAdministrador {
    
    public void menuAdmin() throws IOException {
        Scanner sc = new Scanner(System.in);
        Gestor a = new Gestor();
        int op;
        
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1- Listar productos");
            System.out.println("2- Agregar producto");
            System.out.println("3- Modificar venta");
            System.out.println("4- Activar/Desactivar producto");
            System.out.println("5- Crear venta");
            System.out.println("6- Eliminar venta");
            System.out.println("7- Agregar usuario");
            System.out.println("0- Salir");
            op = sc.nextInt();

            //Para quitar el salto de linea
            sc.nextLine();
            switch(op) {
                case 1: { // Listar productos
                    System.out.println(a.leer("Productos.txt"));
                    break;
                }
                case 2: { // Agregar producto
                    String estampado = "";
                    String color = "";
                    int precio;
                    String activo = "";
                    System.out.print("Introduce el estampado del calcetin: ");
                    estampado = sc.nextLine();
                    System.out.print("Introduce el color del calcetin: ");
                    color = sc.nextLine();
                    System.out.print("Introduce el precio del calcetin: ");
                    precio = Integer.parseInt(sc.nextLine());
                    System.out.print("¿Se encuentra activo? Si / No");
                    activo = sc.nextLine();

                    Random r = new Random();
                    int idProducto = r.nextInt(9000) + 1000;

                    String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
                    System.out.print("El producto: ");
                    System.out.println(a.Agregar("Productos.txt",nuevo));
                    System.out.print(" ha sido creado.\n");
                    break;
                }
                case 3: { // Modificar venta
                    System.out.print("\nIntroduce el identificador de la venta que deseas modificar: \n");
                    System.out.println(a.leer("Ventas.txt"));
                    int idVenta;
                    idVenta = Integer.parseInt(sc.nextLine());

                    System.out.print("¿Como deseas modificarla?\n");

                    System.out.print("¿Quieres cambiar el nombre? Si / No\n");
                    String cambiarNombre = sc.nextLine();
                    String nombreAntiguo = "";
                    String nombreNuevo = "";
                    String productoAntiguo = "";
                    String productoNuevo = "";

                    if( cambiarNombre.equals("si") || cambiarNombre.equals("Si") ) {
                        nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                        System.out.print("Introduce el nuevo nombre: ");
                        nombreNuevo = sc.nextLine();
                    } else if ( cambiarNombre.equals("no") || cambiarNombre.equals("No") ) {
                        nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                        nombreNuevo = nombreAntiguo;
                    }

                    System.out.print("¿Quieres cambiar el producto? Si / No\n");
                    String cambiarCalcetin = sc.nextLine();
                    String calcetinNuevo = "";
                    if( cambiarCalcetin.equals("si") || cambiarCalcetin.equals("Si") ) {
                        productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                        System.out.print("Introduce el nuevo producto: ");
                        productoNuevo = sc.nextLine();
                    } else if ( cambiarCalcetin.equals("no") || cambiarCalcetin.equals("No") ) {
                        productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                        productoNuevo = productoAntiguo;
                    }

                    String antiguo = "";
                    String nuevo = "";

                    antiguo = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
                    nuevo = idVenta + ";" + nombreNuevo + ";" + productoNuevo;

                    System.out.print("La venta: ' " + antiguo + " ' ha sido modificada a:");
                    System.out.println(a.Modificar("Ventas.txt",antiguo,nuevo));
                    break;
                }
                case 4: { // Desactivar producto
                    System.out.print("\nIntroduce el identificador del producto: \n");
                    System.out.println(a.leer("Productos.txt"));
                    int idProducto = Integer.parseInt(sc.nextLine());

                    String estampado = "";
                    String color = "";
                    String precio = "";
                    String activo = "";

                    estampado =  a.leerVentas("Productos.txt",idProducto,1);
                    color =  a.leerVentas("Productos.txt",idProducto,2);
                    precio =  a.leerVentas("Productos.txt",idProducto,3);
                    activo =  a.leerVentas("Productos.txt",idProducto,4);

                    String antiguo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;

                    if( activo.equals("si") || activo.equals("Si") ) {
                        System.out.print("El producto se encuentra: " + activo + "\n"); // activado
                        System.out.print("¿Quieres desactivarlo? Si / No ");
                        String ActivoNuevo = sc.nextLine();
                        if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                            activo = "No";
                        } else {
                            activo = "Si";
                        }

                    } else {
                        System.out.print("El producto se encuentra: " + activo + "\n"); // desactivado
                        System.out.print("¿Quieres activarlo? Si / No ");
                        String ActivoNuevo = sc.nextLine();
                        if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                            activo = "Si";
                        } else {
                            activo = "No";
                        }
                    }
                        String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;

                        System.out.print("El estado del producto: ");
                        System.out.println(a.Modificar("Productos.txt",antiguo,nuevo));
                        System.out.print(" ha sido modoficado.");       
                        break;
                }
                case 5: { // Crear venta
                    System.out.print("\nIntroduce el nombre del comprador: \n");
                    String nombreComprador = sc.nextLine();

                    System.out.print("\nIntroduce el estampado del producto: \n");
                    String estampadoProducto = sc.nextLine();

                    Random r = new Random();
                    int idVenta = r.nextInt(9000) + 1000;

                    String nuevo = idVenta + ";" + nombreComprador + ";" + estampadoProducto;
                    System.out.print("La venta: ");
                    System.out.println(a.Agregar("Ventas.txt",nuevo));
                    System.out.print(" ha sido creada.");
                    break;
                }
                case 6: { // Eliminar venta
                    System.out.print("\nIntroduce el identificador de la venta que deseas eliminar: \n");
                    System.out.println(a.leer("Ventas.txt"));
                    int idVenta;
                    idVenta = Integer.parseInt(sc.nextLine());

                    String borrar = "";
                    String nombreAntiguo = "";;
                    String productoAntiguo = "";
                    nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                    productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);

                    borrar = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
                    System.out.print("La venta:  ");
                    System.out.println(a.Eliminar("Ventas.txt",borrar));
                    System.out.print(" ha sido eliminada.");
                    break;
                }
                case 7: { // Agregar usuario
                    System.out.print("\nIntroduce el nombre del usuario: ");
                    String nombreUsuario = sc.nextLine();
                    System.out.print("\nIntroduce el cargo a asignar:\n");
                    System.out.println("1- Administrador");
                    System.out.println("2- Asistente");
                    System.out.println("3- Vendedor");
                    int nivelUser = Integer.parseInt(sc.nextLine());
                    String nuevo = nombreUsuario + "-" + nivelUser;
                    System.out.println("El usuario ");
                    System.out.println(a.Agregar("Usuarios.txt",nuevo));
                    System.out.print("El usuario ha sido creado.");
                    break;
                }
                case 0: { // Salir
                    break;
                }

                default:{
                    System.out.println("Introduzca una opcion valida");
                }
            }
        } while (op != 0);
 
    }
    
} // CLASS

