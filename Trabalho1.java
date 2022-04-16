
import java.time.temporal.ChronoUnit;
import java.time.Year;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.LocalDate;


public class Trabalho1{
	public static void main(String[] args){
		
		LocalDate ld = LocalDate.now();
		Scanner teclado = new Scanner(System.in);
		 do{
		System.out.println("*--------------------------*");
		System.out.println("Brincando com sua data de nascimento!");
		System.out.println("Escolha entre as seguintes opções: (Utilize os números disponíveis)");
		System.out.println("[1] Quanto tempo você já viveu? \n[2] Quando será seu aniversário?\n[3] Em qual dia da semana você nasceu? \n[4] Sair");
		System.out.println("*--------------------------*");
        int escolha = teclado.nextInt();
		int year = ld.getYear();
		int month = ld.getMonthValue();
		int day = ld.getDayOfMonth();
            
			//Início do programa 1;
			if(escolha == 1){
			System.out.println("Digite o ano em que você nasceu :");
			int ano1 = teclado.nextInt();
			if(ano1 > 2022 || ano1 < 1900){
				System.out.println("Você digitou um número inválido!");
                System.exit(1);
				}
			System.out.println("Digite o mês do seu nascimento :");
			int mes1 = teclado.nextInt(); 
			if(mes1 > 12 || mes1 < 1){
 				System.out.println("Você digitou um número inválido!");
                System.exit(1);
				}
			System.out.println("Digite o dia seu nascimento : ");
			int dia1 = teclado.nextInt();
			if(dia1 > 31 || dia1 < 1){
				 System.out.println("Você digitou um número inválido!");
                 System.exit(1);
				}
			System.out.println("Digite a hora do seu nascimento : ");
			int hora1 = teclado.nextInt();
			if(hora1 > 24 || hora1 < 1){
				 System.out.println("Você digitou um número inválido!");
                 System.exit(1);
			}
			System.out.println("Digite os minutos também :");
			int minutos1 = teclado.nextInt();
			if(minutos1 > 60){
				 System.out.println("Você digitou um número inválido!");
                 System.exit(1);
			}
			LocalDateTime begin = LocalDateTime.of(ano1,mes1,dia1,hora1,minutos1);
			ZonedDateTime dataatualhora = ZonedDateTime.now();
			LocalDateTime end = LocalDateTime.now();
			 			
			long days1 = ChronoUnit.DAYS.between(begin, end);
			long hours1 = ChronoUnit.HOURS.between(begin, end);
			long minutes1 = ChronoUnit.MINUTES.between(begin, end);
			System.out.println("Você viveu até hoje " +days1 + " dias!");
			System.out.println("Você viveu " + hours1 + " horas!");
			System.out.println("Você viveu "+ minutes1 + " minutos!");
			}
		//Fim do programa1;
        
		//Início do programa 2;    
        if(escolha == 2){
		int anoAtual = year;
		System.out.println("Qual o dia em que você nasceu?");
		int aniver = teclado.nextInt();
		if(aniver > 31){
		System.out.println("Você digitou um número inválido!");
		System.exit(1);
		}
		System.out.println("De qual mês você é?");
		int mesniver = teclado.nextInt();
		if(mesniver > 12){
			System.out.println("Você digitou um número inválido!");
			System.exit(1);
		}
		LocalDate aniversario = LocalDate.of(anoAtual,mesniver,aniver);
		long daysAfter = ChronoUnit.DAYS.between(ld, aniversario);
		long daysBefore = ChronoUnit.DAYS.between(aniversario, ld);
		
		if(aniversario.isEqual(ld)){
		System.out.println("Feliz aniversário!!");
		}
		else if(aniversario.isAfter(ld)){
		System.out.println("Faltam " + daysAfter + "dia(s) para seu aniversário!");
		}
		else if(aniversario.isBefore(ld)){
		System.out.println("Seu aniversário foi há " + daysBefore + " dia(s)! No dia " + aniver + " do mês " + mesniver);
		}
		}
		//Fim do programa 2;

		//Início do programa 3;
		if(escolha == 3){
		System.out.println("Em que dia você nasceu?");
		int dia = teclado.nextInt();
		if(dia > 31){
			System.out.println("Você digitou um número inválido!");
			System.exit(1);
		}
		System.out.println("Em que mês você nasceu?");
		int mes = teclado.nextInt();
		if(mes > 12){
			System.out.println("Você digitou um número inválido!");
			System.exit(1);
			}
		System.out.println("Em que ano você nasceu?");
		int ano = teclado.nextInt();
		if(ano > 2022 || ano < 1900){
			System.out.println("Você digitou um número inválido!");
			System.exit(1);
			}
		//Variáveis
		int m = 1900;
		int a = (ano - m);
		int b = (a/4);
		int c = 0;
		int d = dia - 1;
		int bI = b - 1;
		
		// Checando se o ano é um Leap year!
		if((ano % 400 == 0) || ((ano % 4 == 0) && ( ano % 100 != 0))){
		System.out.println("O ano de " + ano + " é bissexto!");
			if(mes == 1 || mes == 10){
        	int c0 = 0;
        	int calculo = (a + bI + c0 + d);
        	int divisao = (calculo % 7);
			switch(divisao){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
			}
			}
		else if(mes == 2 && dia <= 29){
			int c1 = 3;
			int calculo1 = (a + bI + c1 + d);
			int divisao1 = (calculo1 % 7);
			switch(divisao1){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
			}
		}
		else if(mes == 3 || mes == 11){
			int c7 = 3;
			int calculo7 = (a + bI + c7 + d);
			int divisao7 = (calculo7 % 7);

		switch(divisao7){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
					break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;	
		}
		}
		else if(mes == 4 || mes == 7){
			int c2 = 6;
			int calculo2 = (a + bI + c2 + d);
			int divisao2 = (calculo2 % 7);
			switch(divisao2){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;	
			}
		}
		else if(mes == 5){
			int c3 = 1;
			int calculo3 = (a + bI + c3 + d);
			int divisao3 = (calculo3 % 7);
			switch(divisao3){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
		}
		}
		else if(mes == 9 || mes == 12 ){
			int c4 = 5;
			int calculo4 = (a + bI + c4 + d);
			int divisao4 = (calculo4 % 7);
		switch(divisao4){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
					break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
		}
		}
		else if(mes == 6){
			int c5 = 4;
			int calculo5 = (a + bI + c5 + d);
			int divisao5 = (calculo5 % 7);
			switch(divisao5){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
					break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
			}
		}
		else if(mes == 8){
			int c6 = 2;
			int calculo6 = (a + bI + c6 + d);
			int divisao6 = (calculo6 % 7);
			switch(divisao6){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
				break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
				break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
				break;
				}
			}						
		}
			else if((ano % 400 != 0) || ((ano % 4 != 0) && ( ano % 100 == 0))){
			System.out.println("O ano de " + ano + " não é bissexto!");
			
		if(mes == 1 || mes == 10){
        	int c0 = 0;
        	int calculo = (a + b + c0 + d);
        	int divisao = (calculo % 7);
			switch(divisao){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
			}
			}
		else if(mes == 2 && dia <= 29){
			int c1 = 3;
			int calculo1 = (a + b + c1 + d);
			int divisao1 = (calculo1 % 7);
			switch(divisao1){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
			}
		}
		else if(mes == 3 || mes == 11){
			int c7 = 3;
			int calculo7 = (a + b + c7 + d);
			int divisao7 = (calculo7 % 7);
			switch(divisao7){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
					break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;	
		}
		}
		else if(mes == 4 || mes == 7){
			int c2 = 6;
			int calculo2 = (a + b + c2 + d);
			int divisao2 = (calculo2 % 7);
			switch(divisao2){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;	
			}
		}
		else if(mes == 5){
			int c3 = 1;
			int calculo3 = (a + b + c3 + d);
			int divisao3 = (calculo3 % 7);
			switch(divisao3){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
		}
		}
		else if(mes == 9 || mes == 12 ){
			int c4 = 5;
			int calculo4 = (a + b + c4 + d);
			int divisao4 = (calculo4 % 7);
		switch(divisao4){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
					break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
		}
		}
		else if(mes == 6){
			int c5 = 4;
			int calculo5 = (a + b + c5 + d);
			int divisao5 = (calculo5 % 7);
			switch(divisao5){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
					break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
					break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
					break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
					break;
			}
		}
		else if(mes == 8){
			int c6 = 2;
			int calculo6 = (a + b + c6 + d);
			int divisao6 = (calculo6 % 7);
			switch(divisao6){
				case 0 :
					System.out.println("Você nasceu em uma Segunda-feira!");
				break;
				case 1 :
					System.out.println("Você nasceu em uma Terça-feira!");
				break;
				case 2 :
					System.out.println("Você nasceu em uma Quarta-feira!");
				break;
				case 3 : 
					System.out.println("Você nasceu em uma Quinta-feira!");
				break;
				case 4 :
					System.out.println("Você nasceu em uma Sexta-feira!");
				break;
				case 5 :
					System.out.println("Você nasceu em um Sábado!");
				break;
				case 6 :
					System.out.println("Você nasceu em um Domingo!");
				break;
				}
				}							
			}
			} 
            if(escolha == 4){
                System.out.println("Espero que você tenha tido uma ótima experiência, até logo!");
                System.exit(1);
            }
			
	}while(true);
		}
	}	
