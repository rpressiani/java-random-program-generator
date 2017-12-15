package system.controller;

import utils.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * This class is used to run the program from the command line.
 * The source code will be executed only if required by the configuration file.
 */
public class Runner {

    private boolean run;
    private int timeout;

    Runner(boolean run, int timeout){
        this.run = run;
        this.timeout = timeout;
    }

    public void execute(String mainClass){

        if(this.run){
            String outPath = "generatedSrc/out/";
            try {
                Logger.log("runner", "Running");
                Logger.log("runner", "Executed command: java -cp "+outPath+" "+ mainClass);
                executeCommandLine("java -cp "+outPath+" "+ mainClass,this.timeout);
                Logger.log("runner", "End execution");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                Logger.log("runner", "Interrupt");
            } catch (TimeoutException e) {
                Logger.log("runner", "Timeout");
            }
        }
    }

    private int executeCommandLine(final String commandLine, final long timeout) throws IOException, InterruptedException, TimeoutException {
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
