package FileManager;

import lombok.SneakyThrows;
import org.wiktormalyska.fiverraccount.FiverrAccount;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {
    private final Scanner scanner;
    @SneakyThrows
    public FileController(String path){
        File file = new File(path);
        scanner = new Scanner(file);
    }

    public List<String> readAsList(){
        List<String> output = new ArrayList<>();
        while (scanner.hasNextLine()){
            output.add(scanner.nextLine());
        }
        return output;
    }

    public List<FiverrAccount> getAccounts(){
        List<FiverrAccount> accounts = new ArrayList<>();
        for (String username : readAsList()) {
            accounts.add(new FiverrAccount(username));
        }
        return accounts;
    }
}
