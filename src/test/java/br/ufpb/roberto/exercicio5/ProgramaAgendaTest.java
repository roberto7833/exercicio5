package br.ufpb.roberto.exercicio5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramaAgendaTest {

    @Test
    public void teste()  {
        ProgramaAgenda sistema = new ProgramaAgenda();
        sistema.cadastrarContato("Roberto",03,03);
        Contato contato = sistema.pesquisaAniversariantes(03,03);
        assertEquals("Roberto", contato.getNome());
        assertEquals(03,contato.getDiaAniversario());
        assertEquals(03,contato.getMesAniversario());
    }
}
