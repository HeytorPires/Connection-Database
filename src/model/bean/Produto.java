/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;


/**
 *
 * @author heyto
 */
public class Produto {
    private int id;
    private String descricao;
    private int quantd;
    private double preco;
    
    public Produto() {
        // Você pode inicializar os atributos com valores padrão aqui, se necessário
    }
    
    public Produto(String descricao, int quantd, double preco) {
        this.descricao = descricao;
        this.quantd = quantd;
        this.preco = preco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantd() {
        return quantd;
    }

    public void setQuantd(int quantd) {
        this.quantd = quantd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
    
    
    
}
