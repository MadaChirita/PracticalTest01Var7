package ro.pub.cs.systems.eim.practicaltest01var07;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Process;

import java.sql.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

        final public static String[] actionTypes = {
                "ro.pub.cs.systems.eim.simulare_practicaltest01.arithmeticmean",
                "ro.pub.cs.systems.eim.simulare_practicaltest01.geometricmean"
        };

        private Context context = null;
        private boolean isRunning = true;

        private Random random = new Random();



        public ProcessingThread(Context context, int firstNumber, int secondNumber) {
            this.context = context;
        }

        @Override
        public void run() {
            Log.d("[Processing Thread]", "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid());
            while (isRunning) {
                sendMessage();
                sleep();
            }
            Log.d("[Processing Thread]", "Thread has stopped!");
        }

        private void sendMessage() {
            Intent intent = new Intent();
            intent.setAction(actionTypes[random.nextInt(actionTypes.length)]);
            intent.putExtra("message",
                    new Date(System.currentTimeMillis()) );
            context.sendBroadcast(intent);
        }

        private void sleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        public void stopThread() {
            isRunning = false;
        }
    }

