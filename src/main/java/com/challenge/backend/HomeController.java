/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.backend;

import com.backend.dao.DaoProdutos;
import com.backend.dao.DaoUsuarios;
import com.backend.modelo.Produto;
import com.backend.modelo.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author G0041901
 */

@Controller
public class HomeController {
    
    @GetMapping("/*")
    public String home(Model model) {
                
        DaoUsuarios daoUsuario = new DaoUsuarios();
        
        ArrayList<Usuario> listaUsuarios = daoUsuario.leApiUsuarios();
        
        DaoProdutos daoProduto = new DaoProdutos();
        
        ArrayList<Produto> listaProdutos = daoProduto.leApiProdutos();
                
	model.addAttribute("lista_usuarios", listaUsuarios);
        
        model.addAttribute("lista_produtos", listaProdutos);
                
        return "home";
        
    }
    
    @GetMapping("/getImagemProduto")
    @ResponseBody
    public String getImagemProduto(int cod_produto) {
        
        DaoProdutos daoProduto = new DaoProdutos();
        
        Produto produto = daoProduto.consultaProduto(cod_produto);
                
        return produto.getJson();
        
    }
    
    @PostMapping("/finaliza_pedido")
    public String finaliza_pedido(HttpServletRequest request, Model model) {
        
        int cod_usuario = Integer.parseInt(request.getParameter("usuario"));
        DaoUsuarios daoUsuario = new DaoUsuarios();
        Usuario usuario = daoUsuario.consultaUsuario(cod_usuario);
        
        int qtd_produtos_pedido = Integer.parseInt(request.getParameter("qtd_produtos_pedido"));
        
        if(qtd_produtos_pedido > 0){
        
            ArrayList<Produto> lista = new ArrayList<Produto>();
            DaoProdutos daoProduto = new DaoProdutos();
            double totalPreco = 0;
            int totalQuantidade = 0;

            for(int i=1; i <= qtd_produtos_pedido; i++){

                Produto produto = daoProduto.consultaProduto(Integer.parseInt(request.getParameter("id_produto_"+i)));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade_produto_"+i)));

                lista.add(produto);

                totalPreco += produto.getPreco()*produto.getQuantidade();
                totalQuantidade += produto.getQuantidade();

            }
            
            model.addAttribute("usuario", usuario.getNome());
            model.addAttribute("produtos", lista);
            model.addAttribute("totalPreco", totalPreco);
            model.addAttribute("totalQuantidade", totalQuantidade);
            
            return "finaliza_pedido";
        
        }else{
            
            return "home";
            
        }
        
    }
    
}
