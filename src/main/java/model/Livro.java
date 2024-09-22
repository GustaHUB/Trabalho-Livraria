package model;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String nome;
    private String autor;
    private LocalDate dataCriacao;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Livro(int id, String nome, String autor, LocalDate dataCriacao, Status status) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
        this.status = status;
    }
    public Livro() {}

    // Getters e Setters

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                '}';
    }
}
