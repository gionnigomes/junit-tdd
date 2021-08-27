package br.com.gionni.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gionni.tdd.modelo.Desempenho;
import br.com.gionni.tdd.modelo.Funcionario;
import br.com.gionni.tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("==== INICIALIZAÇÃO DOS TESTES AUTOMATIZADOS ==== ");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("==== FINALIZAÇÃO DOS TESTES AUTOMATIZADOS ==== ");
	}
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Inicio do teste.");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim do teste.");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);	
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDeQuizePorCentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}


}
