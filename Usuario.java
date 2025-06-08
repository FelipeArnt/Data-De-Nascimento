import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

public class Usuario {
    private final String nome;
    private final LocalDate dataNascimento;
    private static final DateTimeFormatter DATE_FORMATTER = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Usuario(String nome, int dia, int mes, int ano) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        
        try {
            this.dataNascimento = LocalDate.of(ano, mes, dia);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Data de nascimento inválida", e);
        }
        
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura");
        }
    }

    // Getters otimizados
    public int getDia() { 
        return dataNascimento.getDayOfMonth(); 
    }
    
    public int getMes() { 
        return dataNascimento.getMonthValue(); 
    }
    
    public String getMesExtenso() {
        return dataNascimento.getMonth()
            .getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-BR"));
    }
    
    public int getAno() { 
        return dataNascimento.getYear(); 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return String.format(
            "Nome: %s%nData de Nascimento: %s",
            nome,
            dataNascimento.format(DATE_FORMATTER)
        );
    }
    
    // Métodos adicionais para melhorar a funcionalidade
    public DayOfWeek getDiaDaSemana() {
        return dataNascimento.getDayOfWeek();
    }
    
    public long calcularIdade() {
        return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }
    
    public long calcularDiasVividos() {
        return ChronoUnit.DAYS.between(dataNascimento, LocalDate.now());
    }
}
