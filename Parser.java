import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class  Parser {
    public String cmd = "";
    public String[] args;
    public static String defaultDir = "F:\\Assignment.1_OS\\CMD_v3.0\\";

    public Parser() {
    }

    public boolean parse(String input) {

        if (input.equals("pwd")) {
            cmd = "pwd";
            return true;
        }


        else if (input.equals("ls"))
        {
            cmd = "ls";
            return true;
        }


        else if (input.equals("date"))
        {
            cmd = "date";
            // if (from == "main") {
            return true;
            //  }
        }


        else if (input.equals("clear"))
        {
            cmd = "clear";
            return true;
        }

        else if (input.equals("help")) {
            cmd = "help";
            return true;
        }


        else if ((!input.contains("|"))) {
            args = input.split(" ", -1);// there will not be empty strings.

            int counter = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '>')
                    counter++;
            }

            cmd = args[0];

            /*if ((cmd.equals("pwd") || cmd.equals("clear") || cmd.equals("ls") || cmd.equals("date") || cmd.equals("help")) && counter == 0)
            {
                System.out.println("This command takes no parameters.");
                return false;
            }*/


            if ((cmd.equals("ls"))) {
                if (counter == 1) {

                    if (args.length > 3 || args.length <= 2)//2->command,parameter.
                    {
                        System.out.println("This command takes no parameters.");
                        return false;
                    } else {
                        File test2 = new File(args[2]);
                        boolean exists2 = test2.exists();

                        if (!test2.isFile() || !exists2) {
                            try {
                                test2.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                // e.printStackTrace();
                            }
                        }
                        cmd = "ls_over";
                        return true;
                    }

                } else if (counter == 2) {
                    if (args.length > 3 || args.length <= 2)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[2]);
                        boolean exists = test.exists();
                        if (!test.isFile() || !exists) {
                            try {
                                test.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                //e.printStackTrace();
                            }
                        }
                        cmd = "ls_append";
                        return true;
                    }
                }
            } else if (cmd.equals("date")) {
                if (counter == 1) {
                    if (args.length > 3 || args.length <= 2)//2->command,parameter.
                    {
                        System.out.println("This command takes no parameters.");
                        return false;
                    } else {
                        File test = new File(args[2]);
                        boolean exists = test.exists();

                        if (!test.isFile() || !exists) {
                            File test2 = new File(args[2]);
                            try {
                                test2.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                //e.printStackTrace();
                            }
                            cmd = "date_over";
                            return true;
                        } else {
                            cmd = "date_over";
                            return true;
                        }
                    }
                } else if (counter == 2) {
                    // System.out.println("kokokokok");
                    if (args.length > 3 || args.length <= 2)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[2]);
                        boolean exists = test.exists();
                        if (!test.isFile() || !exists) {
                            try {
                                test.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                //e.printStackTrace();
                            }
                            cmd = "date_append";
                            return true;
                        } else {
                            cmd = "date_append";
                            return true;
                        }
                    }

                }
            }


/*****************/
            else if (cmd.equals("help")) {
                if (counter == 1) {
                    if (args.length - 1 > 3 || args.length - 1 <= 2)//2->command,parameter.
                    {
                        System.out.println("This command takes no parameters.");
                        return false;
                    } else {
                        File test = new File(args[2]);
                        boolean exists = test.exists();

                        if (!test.isFile() || !exists) {
                            File test2 = new File(args[2]);
                            try {
                                test2.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                // e.printStackTrace();
                            }
                            cmd = "help_over";
                            return true;
                        }
                    }
                } else if (counter == 2) {
                    if (args.length - 1 > 3 || args.length - 1 <= 2)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    }
                    File test = new File(args[2]);
                    boolean exists = test.exists();
                    if (!test.isFile() || !exists) {
                        try {
                            test.createNewFile();
                        } catch (IOException e) {
                            System.out.println("can't create file");
                            return false;
                            //e.printStackTrace();
                        }
                        cmd = "help_append";
                        return true;
                    }
                }
            } else if (cmd.equals("args")) {
                if (!input.contains(">") && !input.contains(">>")) {
                    if (args.length > 2 || args.length <= 1)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    }
                    cmd = "args";
                    return true;
                } else if (counter == 1) {
                    if (args.length > 4 || args.length <= 3)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[3]);
                        boolean exists = test.exists();
                        if (!test.isFile() || !exists) {
                            try {
                                test.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                //   e.printStackTrace();
                            }
                            cmd = "args_over";
                            return true;
                        } else {
                            cmd = "args_over";
                            return true;
                        }
                    }

                } else if (counter == 2) {
                    if (args.length > 4 || args.length <= 3)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[3]);
                        boolean exists = test.exists();
                        if (!test.isFile() || !exists) {
                            try {
                                test.createNewFile();
                            } catch (IOException e) {
                                System.out.println("can't create file");
                                return false;
                                //   e.printStackTrace();
                            }
                            cmd = "args_append";
                            return true;
                        } else {
                            cmd = "args_append";
                            return true;
                        }

                    }
                }

            } else if (cmd.equals("mv")) {
                if (args.length > 3 || args.length <= 2)//2->command,parameter.
                {
                    System.out.println("This command takes two parameters.");
                    return false;
                } else {
                    File test = new File(args[1]);
                    boolean exists = test.exists();
                    if (!test.isFile() || !exists) {
                        String p = defaultDir + args[1];
                        File test2 = new File(args[1]);
                        boolean exists2 = test2.exists();
                        if (!test2.isFile() || !exists2) {
                            System.out.println("This is not a file name ... or this file may be doen not exist");
                            return false;
                        }

                    }
                    cmd = "mv";
                    return true;
                }
            } else if (cmd.equals("rm")) {
                if (args.length > 2 || args.length <= 1)//2->command,parameter.
                {
                    System.out.println("This command takes only one parameter.");
                    return false;
                } else {
                    File test = new File(args[1]);
                    boolean exists = test.exists();

                    if (!test.isFile() || !exists) {
                        String str = defaultDir + args[1];
                        File test2 = new File(args[1]);
                        boolean exists2 = test2.exists();
                        if (!test2.isFile() || !exists2) {
                            System.out.println("This is not a file name ... or this file may be doen not exist");
                            return false;
                        }
                    }

                    cmd = "rm";
                    return true;
                }
            } else if (cmd.equals("cd")) {
                if (args.length > 2 || args.length <= 1)//2->command,parameter.
                {
                    System.out.println("This command takes only one parameter.");
                    return false;
                } else {
                    File test = new File(args[1]);
                    boolean exists = test.exists();
                    if (!test.isDirectory() || !exists) {
                        System.out.println("This is not a Directory !");
                        return false;
                    }
                    cmd = "cd";
                    return true;
                }
            } else if (cmd.equals("cp")) {
                if (args.length > 3 || args.length <= 2)//2->command,parameter.
                {
                    System.out.println("This command takes two parameters.");
                    return false;
                }
                else
                    {
                    File test = new File(args[1]);
                    boolean exists = test.exists();
                    if (!test.isFile() || !exists)
                    {
                        String h = defaultDir + args[1];
                        File test2 = new File(h);
                        boolean exists2 = test2.exists();
                        if (!test2.isFile() || !exists2)
                        {
                            System.out.println("This is not a file name ... or this file may be does not exist");
                            return false;
                        }

                    }
                    cmd = "cp";
                    return true;
                }
            } else if (cmd.equals("rmdir")) {
                if (args.length > 2 || args.length <= 1)//2->command,parameter.
                {
                    System.out.println("This command takes only one parameter.");
                    return false;
                } else {
                    File test = new File(args[1]);
                    boolean exists = test.exists();
                    if (!test.isDirectory() || !exists) {
                        System.out.println("This is not a Directory name ... or this Directory may be does not exist");
                        return false;
                    }
                    cmd = "rmdir";
                    return true;
                }
            } else if (cmd.equals("mkdir")) {
                if (args.length > 2 || args.length <= 1)//2->command,parameter.
                {
                    System.out.println("This command takes only one parameter.");
                    return false;
                } else {
                    String[] name = args[1].split("\\\\");
                    String s = "";
                    for (int i = 0; i < name.length - 1; i++) {
                        name[i] += '\\';
                        s += name[i];
                    }
                    //System.out.println(s + "   " + Arrays.toString(args));
                    File test = new File(s);
                    File test2 = new File(args[1]);
                    if (!args[1].contains(":")) {
                        String k = defaultDir + args[1];
                        File tmp = new File(k);
                        cmd = "mkdir";
                        return true;
                    }

                    boolean exists = test.exists();
                    boolean exists5 = test2.exists();
                    //System.out.println(!test.isDirectory()+"  "+ !exists + "  "+  exists5);

                    if (!test.isDirectory() || !exists || exists5 || test2.isFile()) {
                        System.out.println("This is not a Directory name ... or this Directory may be does not exist");
                        return false;
                    }
                    cmd = "mkdir";
                    return true;
                }
            } else if (cmd.equals("cat")) {
                if (!input.contains(">") && !input.contains(">>")) {
                    System.out.println(args.length);
                    if (args.length > 3 || args.length <= 1)//2->command,parameter.
                    {
                        System.out.println("This command takes one or two parameters.");
                        return false;
                    } else {
                        File test = new File(args[1]);
                        boolean exists = test.exists();

                        if (!test.isFile() || !exists) {
                            //String tmp = defaultDir + args[1];
                            File test2 = new File(args[1]);
                            boolean exists2 = test2.exists();
                            if (!test2.isFile() || !exists2) {
                                System.out.println("This is not a File name ... or this file may be does not exist");
                                return false;
                            }
                        }
                        cmd = "cat";
                        return true;
                    }
                } else if (counter == 1)
                {
                    if (args.length > 4 || args.length <= 3)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    }
                    File test = new File(args[1]);
                    boolean exists = test.exists();

                    File test3 = new File(args[3]);
                    boolean exists3 = test.exists();

                    if (!args[1].contains(":"))
                    {
                        String tmp = defaultDir + args[1];
                        File n = new File(tmp);
                        System.out.println(tmp+"   "+!n.exists() + "    " + !n.isFile());
                        if (!n.isFile() || !n.exists())
                        {
                            System.out.println("This is not a File name ... or this file may be does not exist");
                            return false;
                        }
                    }
                    else {
                        if (!test.isFile() || !exists) {
                            System.out.println("This is not a File name ... or this file may be does not exist");
                            return false;
                        }
                    }

                    if (!test3.isFile() || !exists3) {

                        String tmp2 = defaultDir + args[3];
                        File m = new File(tmp2);
                        if (!m.isFile() || !m.exists()) {
                            try {
                                m.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    cmd = "cat_over";
                    return true;
                }
                else if (counter == 2)
                {
                    if (args.length > 4 || args.length <= 3)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    }
                    File test = new File(args[1]);
                    boolean exists = test.exists();

                    File test3 = new File(args[3]);
                    boolean exists3 = test.exists();

                    if (!args[1].contains(":"))
                    {
                        String tmp = defaultDir + args[1];
                        File n = new File(tmp);
                        if (!n.isFile() || !n.exists())
                        {
                            System.out.println("This is not a File name ... or this file may be does not exist");
                            return false;
                        }
                    }
                    else
                        {
                        if (!test.isFile() || !exists)
                        {
                            System.out.println("This is not a File name ... or this file may be does not exist");
                            return false;
                        }
                    }

                    if (!test3.isFile() || !exists3)
                    {
                        String tmp2 = defaultDir + args[3];
                        File m = new File(tmp2);
                        if (!m.isFile() || !m.exists()) {
                            try {
                                m.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    cmd = "cat_append";
                    return true;
                }

            } else if (cmd.equals("more")) {
                if (!input.contains(">") && !input.contains(">>")) {
                    if (args.length > 2 || args.length <= 1)   //2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[1]);
                        boolean exists = test.exists();
                        if (!test.isFile() || !exists) {
                            System.out.println("This is not a file name ... or this file may be does not exist");
                            return false;
                        } else {
                            StringBuilder filename = new StringBuilder();
                            for (int i = 5; i < input.length(); i++) {
                                filename.append(input.charAt(i));
                            }
                            cmd = "more";
                            return true;
                        }
                    }
                } else if (counter == 1) {

                    if (args.length > 4 || args.length <= 3)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[1]);
                        boolean exists = test.exists();

                        File test3 = new File(args[3]);
                        boolean exists3 = test.exists();

                        if (!args[1].contains(":")) {
                            String tmp = defaultDir + args[1];
                            File n = new File(tmp);
                            if (!n.isFile() || !n.exists()) {
                                System.out.println("This is not a File name ... or this file may be does not exist");
                                return false;
                            }
                        } else {
                            if (!test.isFile() || !exists) {
                                System.out.println("This is not a File name ... or this file may be does not exist");
                                return false;
                            }
                        }

                        if (!test3.isFile() || !exists3) {

                            String tmp2 = defaultDir + args[3];
                            File m = new File(tmp2);
                            if (!m.isFile() || !m.exists()) {
                                try {
                                    m.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                        cmd = "more_over";
                        return true;
                    }

                } else if (counter == 2) {

                    if (args.length > 4 || args.length <= 3)//2->command,parameter.
                    {
                        System.out.println("This command takes only one parameter.");
                        return false;
                    } else {
                        File test = new File(args[1]);
                        boolean exists = test.exists();

                        File test3 = new File(args[3]);
                        boolean exists3 = test.exists();

                        if (!args[1].contains(":")) {
                            String tmp = defaultDir + args[1];
                            File n = new File(tmp);
                            if (!n.isFile() || !n.exists()) {
                                System.out.println("This is not a File name ... or this file may be does not exist");
                                return false;
                            }
                        } else {
                            if (!test.isFile() || !exists) {
                                System.out.println("This is not a File name ... or this file may be does not exist");
                                return false;
                            }
                        }

                        if (!test3.isFile() || !exists3) {

                            String tmp2 = defaultDir + args[3];
                            File m = new File(tmp2);
                            if (!m.isFile() || !m.exists()) {
                                try {
                                    m.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                        cmd = "more_append";
                        return true;
                    }

                }
            }
        }
        return true;
    }


    //return false;
    public String getCmd()
    {
        return cmd;
    }

    public String[] getArguments()
    {
        return args;
    }

}