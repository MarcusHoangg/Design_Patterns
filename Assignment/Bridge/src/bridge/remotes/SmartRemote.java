package bridge.remotes;

import bridge.devices.Device;
import bridge.devices.SmartTv;

public class SmartRemote extends AdvancedRemote {
    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote: voice command -> " + command);
    }

    public void openNetflix() {
        if (device instanceof SmartTv) {
            ((SmartTv) device).openApp("Netflix");
        } else {
            System.out.println("SmartRemote: this device does not support apps.");
        }
    }

    public void browseWeb() {
        if (device instanceof SmartTv) {
            ((SmartTv) device).browseInternet();
        } else {
            System.out.println("SmartRemote: this device cannot browse the web.");
        }
    }
}