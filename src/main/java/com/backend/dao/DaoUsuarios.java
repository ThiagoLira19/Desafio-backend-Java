/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.dao;

import com.backend.modelo.Usuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author G0041901
 */
public class DaoUsuarios {
    
    public ArrayList<Usuario> leApiUsuarios(){
        
        // TODO add your handling code here:
        String url = "https://fakestoreapi.com/users";
        URL obj = null;
        try {
            
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();

            String texto_json = response.toString();

            JSONArray jsonArray = new JSONArray(texto_json);
            int tamanho = jsonArray.length();
            
            ArrayList<Usuario> lista = new ArrayList();
            
            for(int i = 0; i < tamanho; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                Usuario usuario = new Usuario();
                
                usuario.setCod_usuario(Integer.parseInt(jsonObject.getString("id")));
                usuario.setEmail(jsonObject.getString("email"));
                
                JSONObject jsonObjectNome = jsonObject.getJSONObject("name");
                
                usuario.setNome(jsonObjectNome.getString("firstname")+" "+jsonObjectNome.getString("lastname"));
                usuario.setSenha(jsonObject.getString("password"));
                usuario.setTelefone(jsonObject.getString("phone"));
                
                lista.add(usuario);

            }
            
            return lista;

        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
    public Usuario consultaUsuario(int cod_usuario){
        
        // TODO add your handling code here:
        String url = "https://fakestoreapi.com/users";
        URL obj = null;
        try {
            
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();
            
            String texto_json = response.toString();
            
            JSONArray jsonArray = new JSONArray(texto_json);
            int tamanho = jsonArray.length();
                        
            for(int i = 0; i < tamanho; i++){
                
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                if(cod_usuario == Integer.parseInt(jsonObject.getString("id"))){
                    
                    Usuario usuario = new Usuario();
                
                    usuario.setCod_usuario(Integer.parseInt(jsonObject.getString("id")));
                    usuario.setEmail(jsonObject.getString("email"));

                    JSONObject jsonObjectNome = jsonObject.getJSONObject("name");

                    usuario.setNome(jsonObjectNome.getString("firstname")+" "+jsonObjectNome.getString("lastname"));
                    usuario.setSenha(jsonObject.getString("password"));
                    usuario.setTelefone(jsonObject.getString("phone"));

                    return usuario;
                
                }

            }
            
            return null;

        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
}
