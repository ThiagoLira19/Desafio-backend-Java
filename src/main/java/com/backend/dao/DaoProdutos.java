/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.dao;

import com.backend.modelo.Produto;
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
public class DaoProdutos {
    
    public ArrayList<Produto> leApiProdutos(){
        
        // TODO add your handling code here:
        String url = "https://fakestoreapi.com/products";
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
            
            ArrayList<Produto> lista = new ArrayList();
            
            for(int i = 0; i < tamanho; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                Produto produto = new Produto();
                
                produto.setCod_produto(Integer.parseInt(jsonObject.getString("id")));
                produto.setTitulo(jsonObject.getString("title"));
                produto.setPreco(Float.parseFloat(jsonObject.getString("price")));
                produto.setDescricao(jsonObject.getString("description"));
                produto.setCategoria(jsonObject.getString("category"));
                produto.setImagem(jsonObject.getString("image"));
                
                lista.add(produto);

            }
            
            return lista;

        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public String consultaFotoProduto(int cod_produto){
        
        // TODO add your handling code here:
        String url = "https://fakestoreapi.com/products";
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
                
                if(cod_produto == Integer.parseInt(jsonObject.getString("id"))){

                    return jsonObject.getString("image");
                
                }

            }
            
            return "Foto do produto não encontrada!";

        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public Produto consultaProduto(int cod_produto){
        
        // TODO add your handling code here:
        String url = "https://fakestoreapi.com/products";
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
                
                if(cod_produto == Integer.parseInt(jsonObject.getString("id"))){
                    
                    Produto produto = new Produto();

                    produto.setCod_produto(Integer.parseInt(jsonObject.getString("id")));
                    produto.setTitulo(jsonObject.getString("title"));
                    produto.setPreco(Float.parseFloat(jsonObject.getString("price")));
                    produto.setDescricao(jsonObject.getString("description"));
                    produto.setCategoria(jsonObject.getString("category"));
                    produto.setImagem(jsonObject.getString("image"));
                    
                    return produto;
                
                }

            }
            
            return null;

        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
}



