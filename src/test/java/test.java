import com.dataphysics.basequantity.BaseQuantities;

import java.io.IOException;

/**
 * Created by Administrator on 2015/11/5.
 */
public class test {
 public static void main(String args[]) throws IOException {
     double[] core = {1,2,1};
     double[] force = {1,1};
     BaseQuantities atom = new BaseQuantities(1,1,core,force);
     System.out.println(atom.getObjectCore()[1]);
 }
}
