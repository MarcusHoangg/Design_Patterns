package bridge;

import bridge.devices.SmartTv;
import bridge.devices.Device;
import bridge.remotes.BasicRemote;
import bridge.remotes.AdvancedRemote;
import bridge.remotes.SmartRemote;

public class Demo {

    public static void main(String[] args) {

        System.out.println("=== BASIC REMOTE + SMART TV ===");
        Device smartTv1 = new SmartTv();
        BasicRemote basicRemote = new BasicRemote(smartTv1);

        basicRemote.power();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        smartTv1.printStatus();


        System.out.println("\n=== ADVANCED REMOTE + SMART TV ===");
        Device smartTv2 = new SmartTv();
        AdvancedRemote advancedRemote = new AdvancedRemote(smartTv2);

        advancedRemote.power();
        advancedRemote.mute();
        smartTv2.printStatus();


        System.out.println("\n=== SMART REMOTE + SMART TV ===");
        SmartTv smartTv3 = new SmartTv();
        SmartRemote smartRemote = new SmartRemote(smartTv3);

        smartRemote.power();
        smartRemote.voiceControl("Open Netflix");
        smartRemote.openNetflix();
        smartRemote.browseWeb();
        smartTv3.printStatus();
    }
}