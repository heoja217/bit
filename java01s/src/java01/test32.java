/* Wrapper class
 byte :java.lang.Byte
 short : java.lang.Short
 int : java.lang.Integer
 long : java.lang.Long
 float : java.lang.Float
 double : java.lang.Double
 boolean : java.lang.Boolean
 chat : java.lang.Character
 * */
package java01;

public class test32 {

  public static void main(String[] args) {
    byte pb = 10;
    Byte b = new Byte(pb);
    
    short ps = 20;
    Short s = new Short(ps);
    Integer i = new Integer(30);
    Long l = new Long(40);
    Float f = new Float(20.0f);
    
    String str = b.toString();
    Double d = new Double(10);
    double d2 = b.doubleValue();
    
    Boolean bool = new Boolean(true);
    Character c = new Character('A');
    }

}
