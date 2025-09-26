package es.upm.miw.devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {
    public Stream<String> findUserNameBySomeImproperFraction() {
        UsersDatabase usersDatabase = new UsersDatabase();

        return usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isImproper))
                .map(User::getName)
                .distinct();
    }
}

