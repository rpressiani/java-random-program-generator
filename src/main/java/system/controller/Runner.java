package system.controller;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Runner {

    boolean run;
    int timeout;

    public Runner(boolean run, int timeout){

        this.run = run;
        this.timeout = timeout;
    }

    public void execute(String mainClass){

        if(this.run){
            String outPath = "generatedSrc/out/";
            try {
                System.out.println("Running");
                System.out.println("java -cp "+outPath+" "+ mainClass);
                executeCommandLine("java -cp "+outPath+" "+ mainClass,this.timeout);
                System.out.println("End execution");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } catch (InterruptedException e) {
                System.out.println("Interrupt");
                e.printStackTrace();
                return;
            } catch (TimeoutException e) {
                System.out.println("Timeout");
                e.printStackTrace();
                return;
            }
        }
    }

    public int executeCommandLine(final String commandLine, final long timeout) throws IOException, InterruptedException, TimeoutException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(commandLine);
        Worker worker = new Worker(process);
        worker.start();
        try {
            worker.join(timeout);
            if (worker.exit != null)
                return worker.exit;
            else
                throw new TimeoutException();
        } catch(InterruptedException ex) {
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw ex;
        } finally {
            process.destroy();
        }
    }
}
