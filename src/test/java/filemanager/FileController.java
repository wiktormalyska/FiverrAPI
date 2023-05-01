package filemanager;

import lombok.SneakyThrows;
import org.wiktormalyska.fiverraccount.FiverrAccount;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a File Controller.
 */
public class FileController {
    private final Scanner scanner;

    /**
     * @param path The path to the file.
     */
    @SneakyThrows
    public FileController(String path){
        File file = new File(path);
        scanner = new Scanner(file);
    }

    /**
     * @return The file as a list of strings.
     */
    public List<String> readAsList(){
        List<String> output = new ArrayList<>();
        while (scanner.hasNextLine()){
            output.add(scanner.nextLine());
        }
        return output;
    }

    /**
     * @return The file as a list of FiverrAccounts.
     */
    public List<FiverrAccount> getAccounts(){
        List<FiverrAccount> accounts = new ArrayList<>();
        for (String username : readAsList()) {
            accounts.add(new FiverrAccount(username));
        }
        return accounts;
    }
}
