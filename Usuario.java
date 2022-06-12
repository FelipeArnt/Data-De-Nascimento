public class Usuario{
    private String nome;
    private int idade, dia, mes, ano;



public Usuario(String nomeInicial, int idadeInicial, int diaInical, int mesInicial, int anoInicial){
    nome = nomeInicial;
    idade = idadeInicial;
    dia = diaInical;
    mes = mesInicial;
    ano = anoInicial;
}

public void setNome(String novoNome){nome = novoNome;}
public void setIdade(int novaIdade){idade = novaIdade;}
public void setDia(int novoDia){dia = novoDia;}
public void setMes(int novoMes){mes = novoMes;}
public void setAno(int novoAno){ano = novoAno;}
//=================//=================//
//========//Metodos Getters//========//
public String getNome(){return nome;}
public int getIdade(){return idade;}
public int getDia(){return dia;}
public int getMes(){return mes;}
public int getAno(){return ano;}
//=================//=================//

public String toString(){
    
    return " \n Nome : " + nome +
        "\n Idade do Usuário : " + idade +
        "\n Data de Nascimento : " + 
        "\n Dia: " + dia+
        "\n Mês: " + mes +    
        "\n Ano : " + ano;
    }














}
