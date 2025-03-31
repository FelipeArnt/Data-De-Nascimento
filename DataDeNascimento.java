
import java.time.temporal.ChronoUnit;
import java.time.Year;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.LocalDate;

public class DataDeNascimento{

    public static Usuario criarUsuario(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual o seu nome ? ");
        String nome = teclado.nextLine();
        System.out.println("Qual a sua idade ? ");
        int idade = teclado.nextInt();
        
        System.out.println("Digite o dia em que você nasceu :");
        int dia = teclado.nextInt();
        
        System.out.println("Digite o mês do seu nascimento :");
        int mes = teclado.nextInt(); 
        
        System.out.println("Digite o ano do seu nascimento : ");
        int ano = teclado.nextInt();
            
            return new Usuario(nome,idade,dia,mes,ano);
            }
    public static void main(String[] args){
        
        LocalDate ld = LocalDate.now();
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();

        Usuario interativo = criarUsuario();
        Scanner teclado = new Scanner(System.in);

        int optInterativo = 0;
        do{
            optInterativo = menuInterativo();
            
            switch(optInterativo){
                case 1: diasVividos(interativo);break;
                case 2: contagemTempo(interativo);break;
                case 3: diaSemana(interativo);break;
                case 4: printDados(interativo);break;
                }
            }while(optInterativo != 0);

            System.out.println("Ate logo, espero que voce tenha tido uma otima experiencia!");    
    }
public static void diasVividos(Usuario interativo){
    Scanner teclado = new Scanner(System.in);
    LocalDate dataAtual = LocalDate.now(); // Obter data atual aqui
    
    int ano1 = interativo.getAno();
    int dia1 = interativo.getDia();
    int mes1 = interativo.getMes(); 
        
    System.out.println("Digite a hora do seu nascimento : ");
    int hora1 = teclado.nextInt();
    System.out.println("Digite os minutos também :");
    int minutos1 = teclado.nextInt();
    
    // Usar dataAtual.getYear() em vez de ld.getYear()
    if(ano1 > dataAtual.getYear() || ano1 < 1900 || minutos1 > 60 || 
       mes1 > 12 || mes1 < 1 || dia1 > 31 || dia1 < 1 || 
       hora1 > 24 || hora1 < 1) {
        System.out.println("Você digitou um número inválido!");
    }
    
    LocalDateTime begin = LocalDateTime.of(ano1, mes1, dia1, hora1, minutos1);
    ZonedDateTime dataatualhora = ZonedDateTime.now();
    LocalDateTime end = LocalDateTime.now();
    
    System.out.println(dataatualhora);            
    long days1 = ChronoUnit.DAYS.between(begin, end);
    long hours1 = ChronoUnit.HOURS.between(begin, end);
    long minutes1 = ChronoUnit.MINUTES.between(begin, end);
    
    System.out.println("Você viveu até hoje " + days1 + " dias!");
    System.out.println("Você viveu " + hours1 + " horas!");
    System.out.println("Você viveu "+ minutes1 + " minutos!");
    
    System.out.println("Pressione qualquer tecla para prosseguir!");
    teclado.next();
    System.out.println("\f");
}
       public static void printDados(Usuario interativo){
            Scanner teclado = new Scanner(System.in);
        System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println(interativo);
        System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("\n [Pressione qualquer tecla para continuar]");
        teclado.next();
        System.out.println("\f");
        }

        
        //Início do programa 2;    
        public static void contagemTempo(Usuario interativo){
        LocalDate ld = LocalDate.now();
        
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        
        Scanner teclado = new Scanner(System.in);
        int anoAtual = year;
        
        int aniver = interativo.getDia();
        
        if(aniver > 31){System.out.println("Você digitou um número inválido!");}//menuInterativo();}
        int mesniver = interativo.getMes();
        String mesExtenso = "";
        if(mesniver == 1){mesExtenso = "Janeiro";}
        if(mesniver == 2){mesExtenso = "Fevereiro";}
        if(mesniver == 3){mesExtenso = "Março";}
        if(mesniver == 4){mesExtenso = "Abril";}
        if(mesniver == 5){mesExtenso = "Maio";}
        if(mesniver == 6){mesExtenso = "Junho";}
        if(mesniver == 7){mesExtenso = "Julho";}
        if(mesniver == 8){mesExtenso = "Agosto";}
        if(mesniver == 9){mesExtenso = "Setembro";}
        if(mesniver == 10){mesExtenso = "Outubro";}
        if(mesniver == 11){mesExtenso = "Novembro";}
        if(mesniver == 12){mesExtenso = "Dezembro";}
        
        if(mesniver > 12){System.out.println("Você digitou um número inválido!");}//amenuInterativo();}
        
        LocalDate aniversario = LocalDate.of(anoAtual,mesniver,aniver);
        long daysAfter = ChronoUnit.DAYS.between(ld, aniversario);
        long daysBefore = ChronoUnit.DAYS.between(aniversario, ld);
        
        if(aniversario.isEqual(ld)){System.out.println("Feliz aniversário!!");}
        else if(aniversario.isAfter(ld)){System.out.println("Faltam " + daysAfter + " dia(s) para seu aniversário!");}
        else if(aniversario.isBefore(ld)){System.out.println("Seu aniversário foi há " + daysBefore + " dia(s)! No dia " + aniver + " do mês " + mesExtenso);}
        }
        
        //Fim do programa 2;

        public static int menuInterativo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("\f");
        System.out.println("\n|-=-=-=-=//Brincado com sua data de nascimenteo//-=-=-=-=-|");
        System.out.println("[1] Dias Vividos");
        System.out.println("[2] Aniversário");   
        System.out.println("[3] Dia da semana");
        System.out.println("[4] Mostrar Dados");
        System.out.println("[0] Sair");
        System.out.println("|-=-=-=-=-=-=-//-=-=-=-=-=-=-=-=-//=-=-=-=-=-=-=-=//-=-=-=-=-|");

        int escolhaMenu = teclado.nextInt();
        if(escolhaMenu != 0 && escolhaMenu != 1 && escolhaMenu != 2 && escolhaMenu != 3 && escolhaMenu != 4){
            System.out.println("\n Opcao Invalida");
            System.out.println("\n [Pressione qualquer tecla para continuar]");
            teclado.next();
            menuInterativo();
        } return escolhaMenu;
}

    public static void diaSemana(Usuario interativo){
        LocalDate ld = LocalDate.now();
        int year = ld.getYear();
        int m = 1900; 
        int anoGet = interativo.getAno();
        int diaGet = interativo.getDia();
        int mesGet = interativo.getMes();
             
        int a = (anoGet - m);
        int b = (a/4); 
        int d = diaGet - 1 ;
        int bI = b - 1;
        int c = 0;

        if(mesGet == 1){c = 0;}
        if(mesGet == 2){c = 3;}
        if(mesGet == 3){c = 3;}
        if(mesGet == 4){c = 6;}
        if(mesGet == 5){c = 1;}
        if(mesGet == 6){c = 4;}
        if(mesGet == 7){c = 6;}
        if(mesGet == 8){c = 2;}
        if(mesGet == 9){c = 5;}
        if(mesGet == 10){c = 0;}
        if(mesGet == 11){c = 3;}
        if(mesGet == 12){c = 5;}

        int resultadoCalculo = a + b + c + d;
        int dividindo = resultadoCalculo % 7;
    
        //if((anoGet % 400 == 0) || ((anoGet % 4 == 0) && ( anoGet % 100 != 0))){System.out.println("O ano de " + anoGet + " é bissexto!");}
        if(anoGet % 400 == 0 || anoGet % 4 == 0 && anoGet % 100 != 0 && diaGet >= 29 && mesGet == 2){
        int resultadoCalculoBI = a + bI + c + d;
        int dividindoBI = resultadoCalculoBI % 7;
            switch(dividindoBI){
               case 0 : System.out.println("Você nasceu em uma Segunda-feira!");break;
               case 1 : System.out.println("Você nasceu em uma Terça-feira!");break;
               case 2 : System.out.println("Você nasceu em uma Quarta-feira!");break;
               case 3 : System.out.println("Você nasceu em uma Quinta-feira!");break;
               case 4 : System.out.println("Você nasceu em uma Sexta-feira!");break;
               case 5 : System.out.println("Você nasceu em um Sábado!");break;
               case 6 : System.out.println("Você nasceu em um Domingo!"); break;
            }
        }
        else{
           switch(dividindo){
               case 0 : System.out.println("Você nasceu em uma Segunda-feira!");break;
               case 1 : System.out.println("Você nasceu em uma Terça-feira!");break;
               case 2 : System.out.println("Você nasceu em uma Quarta-feira!");break;
               case 3 : System.out.println("Você nasceu em uma Quinta-feira!");break;
               case 4 : System.out.println("Você nasceu em uma Sexta-feira!");break;
               case 5 : System.out.println("Você nasceu em um Sábado!");break;
               case 6 : System.out.println("Você nasceu em um Domingo!"); break;
               }
        }
    }
}
