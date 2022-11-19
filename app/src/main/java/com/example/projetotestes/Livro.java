package com.example.projetotestes;

public class Livro {
    private String titulo, sinopse, editora;
    private Integer ano, isbn, foto;

    public Livro(String titulo, String sinopse, String editora, Integer foto, Integer ano, Integer isbn) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.editora = editora;
        this.foto = foto;
        this.ano = ano;
        this.isbn = isbn;
    }

    public Livro(String titulo, String sinopse, String editora, Integer ano, Integer isbn) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.editora = editora;
        this.ano = ano;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
}
