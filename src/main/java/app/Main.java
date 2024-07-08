package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Додавання користувачів
        userRepository.addUser(new User(1, "Alice", "alice@example.com"));
        userRepository.addUser(new User(2, "Bob", "bob@example.com"));
        userRepository.addUser(new User(3, "Charlie", "charlie@example.com"));

        // Пошук користувача за id
        Optional<User> userById = userRepository.findUserById(1);
        userById.ifPresentOrElse(
                user -> System.out.println("Користувач знайдений за id: " + user),
                () -> System.out.println("Користувача не знайдено за id.")
        );

        // Пошук користувача за email
        Optional<User> userByEmail = userRepository.findUserByEmail("bob@example.com");
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Користувач знайдений за email: " + user),
                () -> System.out.println("Користувача не знайдено за email.")
        );

        // Отримання списку всіх користувачів
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> System.out.println("Кількість користувачів у списку: " + users.size()),
                () -> System.out.println("Список користувачів порожній.")
        );
    }
}

