package com.mycompany.calcetinesintegridad2;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int Nivel; //1=(Administrador) 2(Asistente) 3(Vendedor)
        Gestor a = new Gestor();
  
        String Integridad;
        Integridad =(a.Integridad("Usuarios.txt","Integridad_Usuarios.txt"));
        
        if( Integridad.equals("no") ) {
            System.out.println("Se ha detectado un problema en la integridad del sistema, que deseas hacer?");
            System.out.println("¿Que deseas hacer?:");
            System.out.print("1. Eliminar el dato\n");
            System.out.print("2. Marcar el original como perdida de integridad\n");
            System.out.print("3. Regenerar la integridad\n");
            String opcionIntegridad = scan.nextLine();
            
            if(opcionIntegridad.equals("1")){
                  System.out.println(a.Regenerar("Usuarios.txt","Integridad_Usuarios.txt"));
            }if(opcionIntegridad.equals("2")){
                  System.out.println(a.RegenerarYMarcar("Usuarios.txt","Integridad_Usuarios.txt"));
            }if(opcionIntegridad.equals("3")){
                System.out.println(a.Regenerar("Usuarios.txt","Integridad_Usuarios.txt"));
            }
        }

        System.out.print("Hola! Introduce tu nombre\n" );
        System.out.println(a.leerNombres("Usuarios.txt"));
        String nombre = scan.nextLine();
        System.out.print("Hola " + nombre +"\n");
        Nivel =(a.Nivel("Usuarios.txt",nombre));

        System.out.print("\nTienes nivel: " + Nivel +"\n");

        if( Nivel == 1 ) {
            MenuAdministrador ma = new MenuAdministrador();
            ma.menuAdmin();
        }
        if( Nivel == 2 ) {
            MenuAsistente ms = new MenuAsistente();
            ms.menuAsistente();
        }
        if( Nivel == 3 ) {
            MenuVendedor mv = new MenuVendedor();
            mv.menuVendedor();
        }

    } // MAIN
    
} // CLASS
