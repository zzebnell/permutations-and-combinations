import java.util.ArrayList;

public class Combinatoria {

   private ArrayList<ArrayList<Integer>> anadirPrefijo(int pref, ArrayList<ArrayList<Integer>> lista, int i) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      
      if (lista.size() == 0) {
         ArrayList<Integer> tmp = new ArrayList<Integer>();
         tmp.add(pref);
         res.add(tmp);
      } else if (i == lista.size()) {
         return res;
      } else {
         ArrayList<Integer> tmp = lista.get(i);
         tmp.add(0, pref);
         
         res.add(tmp);
         res.addAll(anadirPrefijo(pref, lista, i + 1));
      }
      
      return res;
   }
   
   private ArrayList<Integer> sublista(ArrayList<Integer> lista, int i, int j) {
      ArrayList<Integer> res = new ArrayList<Integer>();
      
      if (i == j || lista.size() == 0) {
         return res;
      } else {
         res.add(lista.get(i));
         res.addAll(sublista(lista, i + 1, j));
      }
      
      return res;
   }
   
   public ArrayList<ArrayList<Integer>> combinaciones(ArrayList<Integer> coleccion, int k) {
      return combinaciones(coleccion, coleccion.size(), k);
   }
   
   private ArrayList<ArrayList<Integer>> combinaciones(ArrayList<Integer> coleccion, int n, int k) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      
      if (n == k) {
         res.add(coleccion);
      } else if (k == 0) {
         return res;
      } else {
         int tmp = coleccion.get(0);
         res.addAll(anadirPrefijo(tmp, combinaciones(sublista(coleccion, 1, n), n - 1, k - 1), 0));
         res.addAll(combinaciones(sublista(coleccion, 1, n), n - 1, k));
      }
      
      return res;
   }

}