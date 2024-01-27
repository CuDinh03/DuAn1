/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.utils;

import duan1_nhom1.model.TaiKhoan;

/**
 *
 * @author WEB
 */
public class Auth {
    public static  TaiKhoan user=null;
  public static  void clear(){
  Auth.user=null;
  }
  public static boolean isLogin(){
  return Auth.user !=null;
  }
  public static  boolean isManager(){
  return Auth.isLogin();
  }
}
