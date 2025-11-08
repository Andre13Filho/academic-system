// Classe abstrata ou base para Student e Teacher (por Herança)
// Atributos comuns: nome, cpf, email, dataNascimento, matricula
// Métodos comuns: getters e setters
package model;
public class Person {
    //private String matricula;
    private String nome;
    private String cpf;
    String datanascimento;
    protected String email;

    public Person(String nome, String cpf, String datanascimento, String email){ 
        this.nome = nome;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.email = email;
    }

    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        if (nome != null){
            this.nome = nome;
        }
        else{
            System.out.println("Nome inválido");
        }
    }
    public String getcpf(){
        return cpf;
    }
    public void setcpf(String cpf){
        if (cpf != null && cpf.length() == 11){
            this.cpf = cpf;
        }
        else{
            System.out.println("CPF inválido");
        }
    }
    public String getdatanascimento(){
        return datanascimento;
    }
    public void setdatanascimento(String datanascimento){
        if (datanascimento != null){
            this.datanascimento = datanascimento;
        }
        else{
            System.out.println("Data de nascimento inválida");
        }
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        if (email != null && email.contains("@")){
            this.email = email;
        }
        else{
            System.out.println("Email inválido");
        }
    }
}
