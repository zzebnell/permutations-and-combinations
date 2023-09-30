import java.util.ArrayList;

public class Permutacion {
   
   private ArrayList<String> concatPrefijo(char prefijo, ArrayList<String> lista, int i) {
      ArrayList<String> res = new ArrayList<String>();
      
      if (i == lista.size() - 1 || lista.size() == 0) {
         res.add("" + prefijo + ((lista.size() == 0) ? "" : lista.get(i)));
      } else {
         res.add("" + prefijo + lista.get(i));
         res.addAll(concatPrefijo(prefijo, lista, i + 1));
      }
      
      return res;
   }

   private String removerElem(char clave, String cadena, int i) {
      String res;
      
      if (i > cadena.length() - 1) {
         res = "";
      } else {
         if (cadena.charAt(i) == clave) {
            res = cadena.substring(0, i) + cadena.substring(i + 1);
            
         } else {
            res = removerElem(clave, cadena, i + 1);
         }
      }
      
      return res;
   }
   
   public ArrayList<String> permutaciones(String coleccion) {
      return permutaciones(coleccion, coleccion.length(), 0);
   }
   
   private ArrayList<String> permutaciones(String coleccion, int n, int i) {
      ArrayList<String> res = new ArrayList<String>();
      
      if (i >= n) {
         return res;
      } else {
         char prefijo = coleccion.charAt(i);
         ArrayList<String> primerSet = concatPrefijo(prefijo, permutaciones(removerElem(prefijo, coleccion, 0), n - 1, 0), 0);
         res.addAll(primerSet);
         ArrayList<String> elResto = permutaciones(coleccion, n, i + 1);
         res.addAll(elResto);
      }
      
      return res;
   }
   
}