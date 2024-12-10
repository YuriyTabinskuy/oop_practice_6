import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            
            Path directory = Paths.get("users_data");
            if (!Files.exists(directory)) {
                Files.createDirectory(directory);
                System.out.println("Директорія створена: " + directory.toAbsolutePath());
            } else {
                System.out.println("Директорія вже існує: " + directory.toAbsolutePath());
            }

            
            Path usersFile = directory.resolve("users_info.txt");
            Path backupFile = directory.resolve("backup_users_info.txt");

            
            List<String> users = new ArrayList<>();
            users.add("Ім'я: Anna, Вік: 30, Стать: Жіноча");
            users.add("Ім'я: Michael, Вік: 45, Стать: Чоловіча");
            users.add("Ім'я: Emma, Вік: 25, Стать: Жіноча");

            
            Files.write(usersFile, users, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Дані записані у файл: " + usersFile.toAbsolutePath());

            
            List<String> readUsers = Files.readAllLines(usersFile);
            System.out.println("Дані у файлі:");
            for (String user : readUsers) {
                System.out.println(user);
            }
            System.out.println("Кількість записів у файлі: " + readUsers.size());

            
            Files.copy(usersFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Дані успішно скопійовані до файлу: " + backupFile.toAbsolutePath());

        } catch (IOException e) {
            
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
