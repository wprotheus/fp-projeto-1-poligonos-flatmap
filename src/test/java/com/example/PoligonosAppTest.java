package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Testes unitários para a classe {@link PoligonosApp},
 * que verifica se os métodos da classe estão funcionando corretamente.
 * Você não deve alterar este arquivo.
 */
class PoligonosAppTest {
    private final PoligonosApp app = new PoligonosApp();

    @Test
    void perimetros() {
        // Diferença máxima aceitável (para mais ou para menos) entre o valor esperado e o valor retornado
        final double delta = 1.0;
        final List<Double> expected = List.of(400.0, 500.0, 323.0, 341.0, 382.0);
        final List<Double> perimetros = app.perimetros();
        assertThat(perimetros).isNotEmpty();
        for (int i = 0; i < perimetros.size(); i++) {
            assertEquals(expected.get(i), perimetros.get(i), delta, "Perímetro do polígono %d incorreto".formatted(i));
        }
    }

    @Test
    void tipoPoligonos() {
        final var resultList = app.tipoPoligonos().stream().map(String::toLowerCase).map(String::trim).toList();
        assertThat(resultList).isEqualTo(List.of("quadrilátero", "quadrilátero", "triângulo", "pentágono", "hexágono"));
    }

    @Test
    void perimetrosRetornaListaImutavel() {
        final var perimetros = app.perimetros();
        assertThrows(UnsupportedOperationException.class, () -> perimetros.add(0.0), "A lista retornada não deveria permitir modificações");
    }

    @Test
    void tipoPoligonosRetornaListaImutavel() {
        final var tipoPoligonos = app.tipoPoligonos();
        assertThrows(UnsupportedOperationException.class, () -> tipoPoligonos.add(""), "A lista retornada não deveria permitir modificações");
    }

}