package Classe_Java_3;

import java.util.ArrayList;

public class Carro {

    private String marca;
    private Pessoa dono;
    private ArrayList<Pessoa> dirigidoPor = new ArrayList<>();

    public Carro() {
    }

    public Carro(String marca) {
        this.marca = marca;
    }

    public void novoDono(Pessoa dono) {
        this.dono = dono;
        this.dirigidoPor.add(dono);
    }

    public void adicionarMotorista(Pessoa motorista) {
        this.dirigidoPor.add(motorista);
    }

    public int totalMotorista() {
        return this.dirigidoPor.size();
    }

    public String getMarca() {
        return this.marca;
    }
}

class Pessoa {

    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    private ArrayList<Carro> carros;

    public Pessoa() {
        this.carros = new ArrayList<>();
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.carros = new ArrayList<>();
    }

    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
        this.carros = new ArrayList<>();
    }

    public void comprarCarro(Carro carro) {
        carro.adicionarMotorista(this);
        this.carros.add(carro);
    }

    public void venderCarro() {
        if (this.carros.isEmpty()) {
            System.out.println("Essa pessoa não possui nenhum carro");
        } else {
            this.carros.remove(0);
        }
    }

    public void todosOsCarros() {
        if (this.carros.isEmpty()) {
            System.out.println("Nenhum carro");
        } else {
            for(Carro c : this.carros) {
                System.out.println(c.getMarca());
            }
        }
    }

    public void adicionarPai(Pessoa pai) {
        this.pai = pai;
    }

    public void adicionarMae(Pessoa mae) {
        this.mae = mae;
    }

    public Pessoa chamarPai() {
        return this.pai;
    }

    public Pessoa chamarMae() {
        return this.mae;
    }
}

class Principal {

    public static void main(String[] args) {
        Pessoa pai = new Pessoa("Fernando");
        Pessoa mae = new Pessoa("Julia");

        Pessoa filho = new Pessoa("Fernando", pai, mae);

        System.out.print("Total de carros do filho: ");
        filho.todosOsCarros();

        System.out.println("=======================ADD CARRO======================");

        Carro carro = new Carro("Gol");

        System.out.println("Carro: " + carro.getMarca());
        System.out.println("Dirigido por " + carro.totalMotorista() + " motorista(s)");

        System.out.println("==========================ATUALIZACAO==================================");

        filho.comprarCarro(carro);

        System.out.print("Total de carros do filho: ");
        filho.todosOsCarros();

        System.out.println("Carro: " + carro.getMarca());
        System.out.println("Dirigido por " + carro.totalMotorista() + " motorista(s)");
    }

}