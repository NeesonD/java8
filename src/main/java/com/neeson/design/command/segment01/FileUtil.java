package com.neeson.design.command.segment01;

import org.apache.log4j.pattern.LineSeparatorPatternConverter;

import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:41
 * Description:
 */
public class FileUtil {

    public static void writeCommand(List<Command> commands) throws Exception{
        try (FileOutputStream fileOutputStream = new FileOutputStream("a.log");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
        ) {
            objectOutputStream.writeObject(commands);
        }
    }


    public static List<Command> readCommands() throws Exception {

        try (FileInputStream fileInputStream = new FileInputStream("a.log");
             ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream))) {
            List<Command> commands = (List<Command>) objectInputStream.readObject();
            return commands;
        }
    }

}
