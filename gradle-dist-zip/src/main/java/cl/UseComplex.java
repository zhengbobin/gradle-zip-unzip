/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cl;

import org.apache.commons.math3.complex.Complex;

public class UseComplex {
  public static void main(String[] args) {
    Complex i = new Complex(0.,  1.);
    Complex i_squared = i.multiply(i);
    System.out.println(i_squared);
  }
}
