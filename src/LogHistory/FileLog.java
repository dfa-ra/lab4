package LogHistory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class FileLog {
    static public void writeLog(String text){
        Log.getInstance().getOut().println(text);
    }

    static public void closeLog(){
        Log.getInstance().getOut().close();
    }
        static public class Log {
            private static Log Instance;
            private PrintWriter out;
            private Log(){
                try{
                    this.out = new PrintWriter("Logs.txt");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            public static Log getInstance() {
                if (Instance == null){
                    Instance = new Log();
                }
                return Instance;
            }

            public PrintWriter getOut(){
                return out;
            }

            public void closeOut(){
                out.close();
            }

        }
}
