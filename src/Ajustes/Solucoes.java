
package Ajustes;

/**
 *
 * @author EGV
 */
public class Solucoes {
    public static String ConverterData(String data){
        return data.substring(6, 10)+"/"+data.substring(3, 5)+"/"+data.substring(0, 2);
    }
    public static void main(String arg[]){
        System.out.println(Solucoes.ConverterData("02/20/2020"));
    }
    
}
