import javazoom.jl.decoder.JavaLayerError;
import javazoom.jl.player.Player;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import java.util.Scanner;

public class Holamundo
{
    public static void main(String[] args) throws FileNotFoundException, IOException  
    {
        
        
        
        musica hilo0 = new musica();
        hilosprueba hilo1 = new hilosprueba();
        
        hilo0.start();
        hilo1.start();

    } 

}    

class hilosprueba extends Thread
{
    public void run()
    {
        int dato;
        float resultado=0;
        
        Scanner entrada = new Scanner(System.in);
        int digito,digito1;
        
        dato = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opcion a realizar: 1 para sumar 2 para restar y 3 para multiplcar y 4 para dividir"));
        
        switch(dato)
        {
            case 1 : System.out.println("Digite dos numeros: ");
                     System.out.println(" "); 
                     digito = entrada.nextInt();
                     digito1 = entrada.nextInt();
                     
                     resultado = digito + digito1;
                     System.out.println("El resultado de la operacion es: " + resultado);
                     break;
            
            case 2: System.out.println("Digite dos numeros: ");
                     digito = entrada.nextInt();
                     System.out.println(" "); 
                     
                     digito1 = entrada.nextInt();
                     
                     resultado = digito - digito1;
                     System.out.println("El resultado de la operacion es: " + resultado);
                     break;
                     
            case 3: System.out.println("Digite dos numeros: ");
            
                    digito = entrada.nextInt();
                     System.out.println(" "); 
                     
                     digito1 = entrada.nextInt();
                     
                     resultado = digito * digito1;
                     System.out.println("El resultado de la operacion es: " + resultado);
                     break; 
                     
            case 4: System.out.println("Digite dos numeros: ");
                    digito = entrada.nextInt();
                     System.out.println(" "); 
                     
                     digito1 = entrada.nextInt();
                     
                     resultado = digito / digito1;
                     System.out.println("El resultado de la operacion es: " + resultado);
                     break;         
            
            default: JOptionPane.showMessageDialog(null,"Operacion no se encuentra en el rango");
        }
                
    }
}

class musica extends Thread
{
    public void run()
    {
        try 
        {
            FileInputStream direccion;
            
            JFileChooser fileChooser = new JFileChooser ();
            
            if(fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                
                direccion = new FileInputStream(file.getAbsolutePath());
                
                Player player;
                BufferedInputStream bis = new BufferedInputStream (direccion);
                
                player = new Player(bis);
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Holamundo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else 
            {
                JOptionPane.showMessageDialog(null,"ningun archivo mp3 fue seleccionado");
            }
        }catch(JavaLayerException e)
        {
            e.printStackTrace();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

