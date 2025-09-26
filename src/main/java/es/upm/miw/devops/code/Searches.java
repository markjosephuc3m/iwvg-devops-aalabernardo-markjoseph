package es.upm.miw.devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {
    // First four characters of hash: a15c

    // Search A
    public Stream<String> findUserNameBySomeImproperFraction() {
        UsersDatabase usersDatabase = new UsersDatabase();

        return usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isImproper))
                .map(User::getName)
                .distinct();
    }

    // Search 1
    public Stream<String> findUserIdBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .filter(Objects::nonNull)
                        .anyMatch(Fraction::isProper))
                .map(User::getId);
    }


    // Search 5
    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .filter(Objects::nonNull)
                        .allMatch(Fraction::isProper))
                .map(User::getId);
    }
}

