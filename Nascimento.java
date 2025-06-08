import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Nascimento {
    private static final Scanner TECLADO = new Scanner(System.in);
    private static final String[] MESES = {
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    private static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");

    public static void main(String[] args) {
        Usuario usuario = criarUsuario();
        int opcao;
        
        do {
            opcao = exibirMenu();
            switch(opcao) {
                case 1: calcularDiasVividos(usuario); break;
                case 2: verificarAniversario(usuario); break;
                case 3: mostrarDiaSemana(usuario); break;
                case 4: exibirDados(usuario); break;
            }
        } while(opcao != 0);
        
        System.out.println("Até logo, espero que você tenha tido uma ótima experiência!");
        TECLADO.close();
    }

    private static Usuario criarUsuario() {
        System.out.print("Qual o seu nome? ");
        String nome = TECLADO.nextLine();
        
        System.out.print("Data de nascimento (DD MM AAAA): ");
        int dia = TECLADO.nextInt();
        int mes = TECLADO.nextInt();
        int ano = TECLADO.nextInt();
        TECLADO.nextLine();  // Limpar buffer
        
        return new Usuario(nome, dia, mes, ano);
    }

    private static int exibirMenu() {
        System.out.println("\n--- Menu Interativo ---");
        System.out.println("[1] Dias Vividos");
        System.out.println("[2] Aniversário");
        System.out.println("[3] Dia da semana");
        System.out.println("[4] Mostrar Dados");
        System.out.println("[0] Sair");
        System.out.print("Opção: ");
        
        return TECLADO.nextInt();
    }

    private static void calcularDiasVividos(Usuario usuario) {
        System.out.print("Hora de nascimento (HH MM): ");
        int hora = TECLADO.nextInt();
        int minutos = TECLADO.nextInt();
        
        if (!validarHora(hora, minutos)) {
            System.out.println("Hora inválida!");
            return;
        }

        LocalDateTime nascimento = LocalDateTime.of(
            usuario.getAno(),
            usuario.getMes(),
            usuario.getDia(),
            hora,
            minutos
        );
        
        long dias = ChronoUnit.DAYS.between(nascimento, LocalDateTime.now());
        System.out.printf("Você já viveu %,d dias%n", dias);
        aguardarEntrada();
    }

    private static void verificarAniversario(Usuario usuario) {
        LocalDate hoje = LocalDate.now();
        LocalDate proximoAniversario = LocalDate.of(
            hoje.getYear(),
            usuario.getMes(),
            usuario.getDia()
        );

        if (proximoAniversario.isBefore(hoje)) {
            proximoAniversario = proximoAniversario.plusYears(1);
        }

        long diasRestantes = ChronoUnit.DAYS.between(hoje, proximoAniversario);
        
        if (diasRestantes == 0) {
            System.out.println("Feliz aniversário!!");
        } else {
            String mes = MESES[usuario.getMes() - 1];
            System.out.printf("Faltam %d dias para seu aniversário (%d de %s)%n", 
                             diasRestantes, usuario.getDia(), mes);
        }
        aguardarEntrada();
    }

    private static void mostrarDiaSemana(Usuario usuario) {
        String nomeDia = usuario.getDiaDaSemana()
            .getDisplayName(TextStyle.FULL, LOCALE_BR);
        System.out.println("Você nasceu em um(a): " + nomeDia);
        aguardarEntrada();
    }

    private static void exibirDados(Usuario usuario) {
        System.out.println("\n--- Dados do Usuário ---");
        System.out.println(usuario);
        aguardarEntrada();
    }

    private static boolean validarHora(int hora, int minutos) {
        return hora >= 0 && hora < 24 && minutos >= 0 && minutos < 60;
    }

    private static void aguardarEntrada() {
        System.out.print("\nPressione Enter para continuar...");
        TECLADO.nextLine();
        System.out.print("\f");
    }
}