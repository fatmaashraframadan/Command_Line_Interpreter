//import com.sun.scenario.effect.impl.sw.java.JSWBlend_SOFT_LIGHTPeer;
import javafx.scene.input.TouchEvent;
import javafx.util.Pair;

import java.beans.PropertyEditorSupport;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.io.*;
import java.net.UnknownHostException;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javafx.util.Pair;
import java.util.ArrayList;

public class Terminal {
    public Terminal() {
    }

    ;

    //Print directory.
    public String pwd() {
        String currentDirectory = System.getProperty("user.dir");
        String s = currentDirectory;
        System.out.println("The current working directory is " + currentDirectory);
        return s;
    }

    //list files in this directory.
    public Set<String> ls() {
        String currentDirectory = System.getProperty("user.dir");
        String s = currentDirectory;
        Stream<Path> walk = null;
        try {
            walk = Files.walk(Paths.get(currentDirectory));
        } catch (IOException e) {
            e.printStackTrace();
        };

        List<String> result = walk.filter(Files::isRegularFile)
                .map(x -> x.toString()).collect(Collectors.toList());

        result.forEach(System.out::println);
        //return result;
        Set<String>set = new HashSet<String>(result);
        set = new HashSet<String>(result);
        return set;
    }

    public void date()
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dt.format(now));
    }


    public void clear()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void help()
    {
        System.out.println("Command ls : " + "prints contents of a directory");
        System.out.println("Command pwd : " + "prints the location of your current working directory");
        System.out.println("Command clear : " + "clear terminal");
        System.out.println("Command mv : " + "used to move or rename directories and files");
        System.out.println("Command cp : " + "copy files and directories ");
        System.out.println("Command cd : " + "print contents of a directory");
        System.out.println("Command rm : " + "used to remove directory or files");
        System.out.println("Command mkdir : " + "used to make a new directory in linux");
        System.out.println("Command rmdir : " + "to remove a directory");
        System.out.println("Command cat : " + "print the contents of a file to the screen");
        System.out.println("Command more : " + "used to view the text files in the command prompt, displaying one screen at a time in case the file is large");
        System.out.println("Command date : " + "used to display the system date and time.");
        System.out.println("Command args : " + "list all parameters on the command line, numbers or strings for specific command.");
        System.out.println("Command help : " + "displays information about shell built-in commands.");

    }

    public void cd(String parameter)
    {
        System.setProperty("user.dir", parameter);
        File file = new File("").getAbsoluteFile();
        System.out.print("New path: ");
        System.out.println(file.getPath());

    }

    public void args(String parameter)
    {
        if (parameter.equals("pwd"))
            System.out.println("0");
        else if (parameter.equals("ls"))
            System.out.println("0");
        else if (parameter.equals("help"))
            System.out.println("0");
        else if (parameter.equals("date"))
            System.out.println("0");
        else if (parameter.equals("clear"))
            System.out.println("0");

        else if (parameter.equals("mv"))
            System.out.println("arg1: SourcePath, arg2: DestinationPath");
        else if (parameter.equals("cp"))
            System.out.println("arg1: SourcePath, arg2: DestinationPath");
        else if (parameter.equals("rm"))
            System.out.println("arg1: filename.txt");
        else if (parameter.equals("mkdir"))
            System.out.println("arg1: new directory name.");
        else if (parameter.equals("cat"))
            System.out.println("arg1: filename1.txt , arg2: filename2.txt");
        else if (parameter.equals("more"))
            System.out.println("arg1: filename.txt");
        else if (parameter.equals("cd"))
            System.out.println("arg1:Directoryname");
        else if (parameter.equals("rmdir"))
            System.out.println("arg1: name of empty directory");
        else
            System.out.println("This is not linux command");
    }

    //C:\\Users\\fatma\\info.txt C:\\Users\\fatma\\Workspace\\File.txt (test cp ,mv).
    public void mv(String d1, String d2)
    {
        //works move only and move and rename .
        try
        {
            Path temp = Files.move(Paths.get(d1), Paths.get(d2));
        }
        catch (IOException x)
        {
            System.out.println("File Doesn't Exist.");
            System.exit(0);
            //  x.printStackTrace();
        }
    }

    public void cp(String d1, String d2)
    {
        try
        {
            Path temp = Files.copy(Paths.get(d1), Paths.get(d2));
        }
        catch (IOException x)
        {
            System.out.println("There's a file with the same name.");
            //x.printStackTrace();
        }
    }

    public void rm(String d1)
    {
        try
        {
            Files.deleteIfExists(Paths.get(d1));
        }
        catch (IOException x)
        {
            System.out.println("File Doesn't Exist.");
            //  x.printStackTrace();
        }
    }

    public void mkdir(String d1)
    {
        try
        {
            Path path = Paths.get(d1);//takes string returns path
            Files.createDirectories(path);
        }
        catch (IOException e)
        {
            //System.out.println("File Doesn't Exist.");
            //  e.printStackTrace();
        }
    }

    public void rmdir(String d)///test : C:\Directory1
    {
        File directory = new File(d);
        directory.delete();
    }


    public void cat(String filename)
    {
        File file = new File(filename);
        if(!file.exists())
        {
            System.out.println("file doesn't exist");
            System.exit(0);
        }
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null)
            {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }

    //Cat >> done , >
    public void operator_cat(String src , String des , String cmd)
    {
        File file = new File(des);
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Con't create file !");
                System.exit(0);
                //e.printStackTrace();
            }
        }
        if(cmd == "cat_append")
        {
            try
            {
                FileReader fr = new FileReader(src);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(des, true);
                String s;
                while ((s = br.readLine()) != null)
                { // read a line
                    fw.write(s); // write to output file
                    fw.flush();
                }
                br.close();
                fw.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else {
            try
            {
                File g = new File(src);
                if(!g.exists()){
                    System.out.println("error");
                }
                FileReader fr = new FileReader(src);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(des, false);
                String s;
                while ((s = br.readLine()) != null)
                { // read a line
                    fw.write(s); // write to output file
                    fw.flush();
                }
                br.close();
                fw.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //ls >>  , > cmd - >3shan t3rf ht override wla ht append.
    public void operator_ls(String des , String cmd)
    {//append
        System.out.println("here"+cmd);
        Stream<Path> walk = null;
        try
        {
            walk = Files.walk(Paths.get(this.pwd()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        };

        List<String> result = walk.filter(Files::isRegularFile)
                .map(x -> x.toString()).collect(Collectors.toList());

        //return result;
        Set<String>set = new HashSet<String>(result);

        set = new HashSet<String>(result);
        if(cmd.equals("ls_append"))
        {

            FileWriter writer;
            try{
                writer = new FileWriter(des, true);
                writer.write(String.valueOf(set));
                writer.close();
            }
            catch(IOException ioException){
                System.out.println("Error.");
            }
        }
        else
        {
            FileWriter writer;
            try{
                writer = new FileWriter(des, false);
                writer.write(String.valueOf(set) );
                writer.close();
            }
            catch(IOException ioException){
                System.out.println("Error.");
            }
        }

    }

    //more >>  , > cmd - >3shan t3rf ht override wla ht append.
    public void operator_date(String des , String cmd)  {//append
       // System.out.println(cmd);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        File file2 = new File(des);
        if(!file2.exists())
        {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                System.out.println("Con't create file !");
                //e.printStackTrace();
            }
        }
        String t = dt.format(now);
        if(cmd == "date_append" )
        {
            File file = new File(des);

            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                fr.write(t);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            File file = new File(des);
            if(!file.exists())
            {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(t);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //more >>  , > cmd - >3shan t3rf ht override wla ht append.
    public void operator_help(String des , String cmd)  {//append
        if(cmd == "help_append" )
        {
            String text ="Command ls : " + "prints contents of a directory"+"\n"+"Command pwd : " + "prints the location of your current working directory"+"\n"+"Command clear : " + "clear terminal"+"\n"+"Command mv : " + "used to move or rename directories and files"+"\n"+"Command cp : " + "copy files and directories" + "\n" + "Command cd : " + "print contents of a directory" + "\n" + "Command rm : " + "used to remove directory or files" + "\n" + "Command mkdir : " + "used to make a new directory in linux" + "\n" + "Command rmdir : " + "to remove a directory" + "\n" + "Command cat : " + "print the contents of a file to the screen" + "\n" + "Command more : " + "used to view the text files in the command prompt, displaying one screen at a time in case the file is large" + "\n" + "Command date : " + "used to display the system date and time." + "\n" + "Command args : " + "list all parameters on the command line, numbers or strings for specific command." + "\n" + "Command help : " + " displays information about shell built-in commands.";
            File file = new File(des);
            if(!file.exists())
            {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("here3");
                    e.printStackTrace();
                }
            }
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(text);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            String text ="Command ls : " + "prints contents of a directory"+"\n"+"Command pwd : " + "prints the location of your current working directory"+"\n"+"Command clear : " + "clear terminal"+"\n"+"Command mv : " + "used to move or rename directories and files"+"\n"+"Command cp : " + "copy files and directories" + "\n" + "Command cd : " + "print contents of a directory" + "\n" + "Command rm : " + "used to remove directory or files" + "\n" + "Command mkdir : " + "used to make a new directory in linux" + "\n" + "Command rmdir : " + "to remove a directory" + "\n" + "Command cat : " + "print the contents of a file to the screen" + "\n" + "Command more : " + "used to view the text files in the command prompt, displaying one screen at a time in case the file is large" + "\n" + "Command date : " + "used to display the system date and time." + "\n" + "Command args : " + "list all parameters on the command line, numbers or strings for specific command." + "\n" + "Command help : " + " displays information about shell built-in commands.";
            File file = new File(des);
            if(!file.exists())
            {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("here3");
                    e.printStackTrace();
                }
            }
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(text);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //more >>  , > cmd - >3shan t3rf ht override wla ht append.
    public void operator_args(String des , String cmd , String parameter)  {//append
        if(cmd == "args_append")
        {
            if (parameter.equals("pwd") ||parameter.equals("ls") || parameter.equals("help") || parameter.equals("date") ||parameter.equals("clear") )
            {
                String h = "0";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println("here3");
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            else if (parameter.equals("mv") ||parameter.equals("cp")  )
            {
                String h = "arg1: SourcePath, arg2: DestinationPath";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("rm")  )
            {
                String h = "arg1: filename.txt";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println("here");
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("cat")  )
            {
                String h = "arg1: filename1.txt , arg2: filename2.txt";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("more")  )
            {
                String h = "arg1: filename.txt";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("mkdir")  )
            {
                String h = "arg1: new directory name.";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("rmdir")  )
            {
                String h = "arg1: name of empty directory";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("cd")  )
            {
                String h = "arg1:Directoryname";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (parameter.equals("cd")  )
            {
                String h = "This is not linux command";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        else {
            if (parameter.equals("pwd") ||parameter.equals("ls") || parameter.equals("help") || parameter.equals("date") ||parameter.equals("clear") )
            {
                System.out.println("here1");
                String h = "0";
                File file = new File(des);
                if(!file.exists())
                {  System.out.println("here2");
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println("here3");
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            else if (parameter.equals("mv") ||parameter.equals("cp")  )
            {
                String h = "arg1: SourcePath, arg2: DestinationPath";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("rm")  )
            {
                String h = "arg1: filename.txt";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println("here");
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("cat")  )
            {
                String h = "arg1: filename1.txt , arg2: filename2.txt";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("more")  )
            {
                String h = "arg1: filename.txt";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("mkdir")  )
            {
                String h = "arg1: new directory name.";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("rmdir")  )
            {
                String h = "arg1: name of empty directory";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (parameter.equals("cd")  )
            {
                String h = "arg1:Directoryname";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (parameter.equals("cd")  )
            {
                String h = "This is not linux command";
                File file = new File(des);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fr.write(h);
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //more >>  , > cmd - >3shan t3rf ht override wla ht append.

    public static void more(String filename)
    {
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            String currentLine = reader.readLine();
            for (int i = 0; i < 10; i++) {
                if (currentLine != null)
                    System.out.println(currentLine);
                currentLine = reader.readLine();
            }
            Scanner scan = new Scanner(System.in);
            boolean resume = true;
            while (resume) {
                System.out.println("Type cont to show more..");
                String s = scan.nextLine();
                if (s.equalsIgnoreCase("cont")) {
                    for (int i = 0; i < 10; i++) {
                        currentLine = reader.readLine();
                        if (currentLine == null) {
                            System.out.println("You've reached the end of file.");
                            resume = false;
                            break;
                        }
                        System.out.println(currentLine);
                    }
                }
                else {
                    break;
                }
            }reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void operator_more(  String src, String des , String cmd) {
        File file = new File(des);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Con't create file !");
                System.exit(0);
                //e.printStackTrace();
            }
        }
        if (cmd == "more_append") {

            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader(src));
                String currentLine = reader.readLine();
                FileWriter fw = new FileWriter(des, true);

                for (int i = 0; i < 10; i++) {
                    if (currentLine != null)
                    {
                        fw.write(currentLine); // write to output file
                        fw.flush();
                    }
                    currentLine = reader.readLine();
                }
                Scanner scan = new Scanner(System.in);
                boolean resume = true;
                while (resume) {
                    System.out.println("Type cont to show more..");
                    String s = scan.nextLine();
                    if (s.equalsIgnoreCase("cont")) {
                        for (int i = 0; i < 10; i++) {
                            currentLine = reader.readLine();
                            if (currentLine == null) {
                                System.out.println("You've reached the end of file.");
                                resume = false;
                                break;
                            }
                            fw.write(currentLine); // write to output file
                            fw.flush();

                        }
                    }
                    else
                    {
                        break;
                    }
                }reader.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



        } else {
            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader(src));
                String currentLine = reader.readLine();
                FileWriter fw = new FileWriter(des, false);

                for (int i = 0; i < 10; i++) {
                    if (currentLine != null)
                    {
                        fw.write(currentLine); // write to output file
                        fw.flush();
                    }
                    currentLine = reader.readLine();
                }
                Scanner scan = new Scanner(System.in);
                boolean resume = true;
                while (resume) {
                    System.out.println("Type cont to show more..");
                    String s = scan.nextLine();
                    if (s.equalsIgnoreCase("cont")) {
                        for (int i = 0; i < 10; i++) {
                            currentLine = reader.readLine();
                            if (currentLine == null) {
                                System.out.println("You've reached the end of file.");
                                resume = false;
                                break;
                            }
                            fw.write(currentLine); // write to output file
                            fw.flush();

                        }
                    }
                    else
                    {
                        break;
                    }
                }reader.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
