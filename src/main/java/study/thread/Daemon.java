package study.thread;

import lombok.SneakyThrows;

public class Daemon {
    public static void main(String[] args){
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();

    }

    static class DaemonRunner implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            try{
                Thread.sleep(10000L);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
