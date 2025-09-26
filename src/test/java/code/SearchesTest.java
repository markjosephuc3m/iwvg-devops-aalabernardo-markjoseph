package code;

import org.junit.jupiter.api.Test;
import es.upm.miw.devops.code.Searches;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SearchesTest {
    @Test
    void testFindUserNameBySomeImproperFraction() {
        Searches searches = new Searches();

        List<String> result = searches.findUserNameBySomeImproperFraction().toList();

        assertThat(result).containsExactlyInAnyOrder("Oscar", "Ana", "Paula");
    }
}
