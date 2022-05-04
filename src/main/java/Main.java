
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
/**
 *
 * @author alanc
 */
public class Main {
    
    public static void main(String[] args) {
        
        Random  random = new Random();
        Scanner input = new Scanner(System.in);
        BufferedReader almacenamiento;
        String validar = null;
        File  archivo ;
        archivo = new File("numerosRandom.txt");
        FileReader leerA;
        String cadena;
        
        FileWriter escribir;
        PrintWriter linea;

        int opciones=0;
      
        while( opciones!=6){//creamos el menu de opciones
            System.out.println("Opciones");
            System.out.println("----------------");
            System.out.println("0 - Menu");
            System.out.println("1 - Generar nuevo archivo");
            System.out.println("2 - Leer archivo generado");
            System.out.println("3 - Ordenar archivo");
            System.out.println("4 - Leer archivo Ordenado");
            System.out.println("5 - Buscar numero en archivo");
            System.out.println("6 - Salir");
            System.out.println("Seleccione una opción: ");
            
            opciones=input.nextInt(); //pedimos por consola la opcione del menu
            int cantNumeros =10; //aca se usa un numero estatico pero puede usarse random o por input
            int [] arreglo  = new int [cantNumeros];

            if(opciones==1){
                validar="S";
                System.out.println("Archivo Generado!");
               
                    for (int i = 0; i < cantNumeros; i++) {//se rellena el array
         
                    arreglo[i]=random.nextInt();
                
                    }
                    if(!archivo.exists()){
                        try {
                            archivo.createNewFile();
                            for (int i = 0; i < cantNumeros; i++) {
                            
                                escribir = new FileWriter(archivo,true); //para escriba al final del archivo existente
                                linea = new PrintWriter(escribir);
                                //se escribe en el archivo
                                linea.println(arreglo[i]);
                                linea.close();
                                escribir.close();
                            }
                        } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        try {
                            archivo.delete();
                            archivo.createNewFile();
                            for (int i = 0; i < cantNumeros; i++) {
                                escribir = new FileWriter(archivo,true); //para escriba al final del archivo existente
                                linea = new PrintWriter(escribir);
                                //se escribe en el archivo
                                linea.println(arreglo[i]); 
                                linea.close();
                                escribir.close();
                            }
                
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                
            }
             
            if(opciones==2){
                if(validar=="S"){
                System.out.println("Numero Aleatorios: \n");
                try {
                    leerA = new FileReader(archivo);
                    almacenamiento = new BufferedReader(leerA);
                    cadena = "";
                    while( cadena!=null){
                        try {
                            cadena = almacenamiento.readLine();
                            if(cadena!=null){
                                System.out.println(cadena);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try {
                        almacenamiento.close();
                        leerA.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    
                     
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else{
                    System.out.println("Por favor escoja opción 1 primero");
                }
                
            }
            if(opciones==3){
                
                if(validar=="S"){
                    System.out.println("Archivo Ordenado!");
                try {
                    leerA = new FileReader(archivo);
                    almacenamiento = new BufferedReader(leerA);
                    cadena = "";
                    
                    for(int i = 0; i < cantNumeros; i++){
                                 
                        try {
                            cadena = almacenamiento.readLine();
                            if(cadena!=null ){
                            arreglo[i]= Integer.parseInt(cadena);
                            
                          
                            }
         
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try {
                        almacenamiento.close();
                        leerA.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                Arrays.sort(arreglo);//funcion para ordenar un arreglo
         
                try {       
                            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                            bw.write("");//borramos los datos del archivo para reutilizarlo
                            bw.close();
                            
                            for (int i = 0; i < cantNumeros; i++) {
                            
                                escribir = new FileWriter(archivo,true); //para escriba al final del archivo existente
                                linea = new PrintWriter(escribir);
                                //se escribe en el archivo
                                linea.println(arreglo[i]);
                                
                                linea.close();
                                escribir.close();
                            }
                        } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                //System.out.println("numeros ordenados: " + Arrays.toString(arreglo));
               // System.out.println("\n arreglo final"+Arrays.toString(arreglo));
                }
                else{
                    System.out.println("Por favor escoja opción 1 primero");
                }
            }
            if(opciones == 4){
                if(validar=="S"){
                System.out.println("Numeros random ordenados: \n");
                 try {
                    leerA = new FileReader(archivo);
                    almacenamiento = new BufferedReader(leerA);
                    cadena = "";
                    
                    while( cadena!=null){
                        try {
                            cadena = almacenamiento.readLine();
                            if(cadena!=null){
                                System.out.println(cadena);
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                   
                    try {
                        almacenamiento.close();
                        leerA.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    
                     
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    System.out.println("Por favor escoja opción 1 primero");
                }
            }
            if(opciones==5){
                if(validar=="S"){
                    
                
                int buscarNumero=0;
                int cont =0;
                System.out.println("Ingrese numero a buscar: ");
                buscarNumero=input.nextInt();
                try {
                    leerA = new FileReader(archivo);
                    almacenamiento = new BufferedReader(leerA);
                    cadena = "";
                    while( cadena!=null){
                        try {
                            cadena = almacenamiento.readLine();
                            if(cadena!=null){
                                cont++;
                                int numero = Integer.parseInt(cadena);//transformamos a cadena para comparar
                                if(buscarNumero==numero){
                                    System.out.println("el numero que busca es este: "+ numero);
                                    System.out.println("contador: "+cont);
                                }
                                if(cont==cantNumeros && numero!=buscarNumero){
                                    System.out.println("Lo sentimos su numero no se encuentra");
                                }
                                
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    try {
                        almacenamiento.close();
                        leerA.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    
                     
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
              
               
                }
                else{
                    System.out.println("Por favor escoja opción 1 primero");
                }
            }
            if(opciones==6){
                System.out.println("Gracias hasta pronto!.");
            }
            
            
        }
  
    }
     
}


     

  
    

