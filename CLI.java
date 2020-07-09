/*
Course:  CS241 - Operating System I  - 2019
Title:   Assignment I - Command Line Interpreter
Program: CS241 - 2019 - A1
Author 1 : Fatma Ashraf Ramadan 20170192 G_3 CS
Author 1 : Mariam Makram William 20170283 G_3 CS
 */

import javafx.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CLI {
    static Parser ob = new Parser();
    public static void main(String[] args) {
        boolean resume = true;
        while (resume) {
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");

            String str = scanner.nextLine();

            if(str.equals("exit"))
                resume = false;

            if (str.contains("|"))
            {
                String[] s8 = str.split("\\|");
               // System.out.println("Before: " + Arrays.toString(s8));
                for (int i = 0; i < s8.length; i++) {
                    if(i == 0) s8[i] = s8[i].substring(0, s8[i].length()-1);
                    else if(i == (s8.length-1)) s8[i] = s8[i].substring(1, s8[i].length());
                    else s8[i] = s8[i].substring(1, s8[i].length()-1);
                }

                for (int i = 0; i < s8.length; i++)
                {
                    String k = s8[i];
                    if (ob.parse(k)) {
                        operations(k);
                    }
                }
            } else if (ob.parse(str)) {
                operations(str);
            }
        }
    }

    public static void operations(String str)
    {
        if (ob.getCmd().equals("pwd"))
        {
            Terminal pw = new Terminal();
            pw.pwd();
        }
        else if (ob.getCmd().equals("ls")) {
            Terminal ob2 = new Terminal();
            ob2.ls();
        }

        else if (ob.getCmd().equals("date")) {
            Terminal ob3 = new Terminal();
            ob3.date();
        }


        else if (ob.getCmd().equals("clear"))
        {
            Terminal ob5 = new Terminal();
            ob5.clear();
        }
        else if (ob.getCmd().equals("help"))
        {
            Terminal ob6 = new Terminal();
            ob6.help();
        }
        else if (ob.getCmd().equals("args")) {
            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[1];
            ob6.args(Parameter);
        }
        else if (ob.getCmd().equals("args_over") || ob.getCmd().equals("args_append")) {
            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[3];
            // System.out.println(ob.getCmd());
            ob6.operator_args(Parameter, ob.getCmd(), s2[1]);
        } else if (ob.getCmd().equals("date_over") || ob.getCmd().equals("date_append")) {
            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[2];
            // System.out.println(ob.getCmd());
            ob6.operator_date(Parameter, ob.getCmd());
        } else if (ob.getCmd().equals("ls_over") || ob.getCmd().equals("ls_append"))
        {
            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[2];
            //  System.out.println(ob.getCmd());
            ob6.operator_ls(Parameter, ob.getCmd());
        }
        else if (ob.getCmd().equals("mv")) {
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            String Parameter2 = s2[2];
            ob7.mv(Parameter1, Parameter2);
        } else if (ob.getCmd().equals("cp")) {
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            String Parameter2 = s2[2];
            ob7.cp(Parameter1, Parameter2);
        } else if (ob.getCmd().equals("rm")) {
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            ob7.rm(Parameter1);
        } else if (ob.getCmd().equals("cd")) {
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            ob7.cd(Parameter1);
        } else if (ob.getCmd().equals("rmdir")) {
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            ob7.rmdir(Parameter1);
        } else if (ob.getCmd().equals("mkdir")) {
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            ob7.mkdir(Parameter1);
        } else if (ob.getCmd().equals("cat")) {
            String g[] = str.split(" ");// there will not be empty strings.
            if (g.length > 2) {
                Terminal ob7 = new Terminal();
                ob7.cat(g[1]);
                ob7.cat(g[2]);
            } else {
                Terminal ob7 = new Terminal();
                String[] s2 = ob.getArguments();
                String Parameter1 = s2[1];
                ob7.cat(Parameter1);
            }

        }
        else if (ob.getCmd().equals("cat_over") || ob.getCmd().equals("cat_append")) {

            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[3];
            //   System.out.println(ob.getCmd());
            ob6.operator_cat(s2[1], Parameter, ob.getCmd());
        }
        else if (ob.getCmd().equals("help_over") || ob.getCmd().equals("help_append")) {

            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[2];
            //    System.out.println(ob.getCmd() + "here");
            ob6.operator_help(Parameter, ob.getCmd());
        }
        else if (ob.getCmd().equals("more")) {
            //    System.out.println("ccc");
            Terminal ob7 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter1 = s2[1];
            //   System.out.println("more");
            ob7.more(Parameter1);
        }
        else if (ob.getCmd().equals("more_over") || ob.getCmd().equals("more_append")) {

            Terminal ob6 = new Terminal();
            String[] s2 = ob.getArguments();
            String Parameter = s2[3];
            //   System.out.println(ob.getCmd());
            ob6.operator_more(s2[1], Parameter, ob.getCmd());
        }
    }
}