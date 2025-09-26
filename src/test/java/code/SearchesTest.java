package code;

import org.junit.jupiter.api.Test;
import es.upm.miw.devops.code.Searches;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

class SearchesTest {
    @Test
    void testFindUserNameBySomeImproperFraction() {
        Searches searches = new Searches();

        List<String> result = searches.findUserNameBySomeImproperFraction().toList();

        assertThat(result).containsExactlyInAnyOrder("Oscar", "Ana", "Paula");
        // only Oscar, Ana and Paula and 5 has improper fractions.
    }

    @Test
    void testFindUserIdBySomeProperFraction(){
        assertThat(new Searches().findUserIdBySomeProperFraction().toList())
                .containsExactlyInAnyOrder("1", "2", "3", "5");
        // only users 1,2,3 and 5 has any proper fractions.
    }

    @Test
    void testFindUserIdByAllProperFraction(){
        assertThat(new Searches().findUserIdByAllProperFraction().toList())
                .contains("5"); // only user 5 has all proper fractions.
    }

    private final Searches searches = new Searches();

    @Test
    void testFindDecimalFractionByUserName() {
        Stream<Double> resultStream = searches.findDecimalFractionByUserName("Oscar");
        List<Double> result = resultStream.collect(Collectors.toList());

        // Fractions for Oscar (Oscar Fernandez + Oscar López)
        // Fernandez: 0/1, 1/1, 2/1  -> 0.0, 1.0, 2.0
        // López: 1/5, 3/-6, 1/2, 4/4 -> 0.2, -0.5, 0.5, 1.0
        List<Double> expected = List.of(0.0, 1.0, 2.0, 0.2, -0.5, 0.5, 1.0);

        assertEquals(expected, result);
    }
}
