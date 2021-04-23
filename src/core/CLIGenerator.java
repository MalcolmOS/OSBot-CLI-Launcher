package core;

import java.io.File;
import java.io.FileNotFoundException;

public class CLIGenerator {

    private String proxyIp, proxyPort, proxyUser, proxyPass;
    private String osbotUser, osbotPass;
    private String script, scriptArgs;
    private String botUser, botPass, botPin;
    private int world = -1;
    private int memAmount = -1;
    private boolean lowCPU, useAutoLogin;

    private String osbotPath;

    public CLIGenerator() throws FileNotFoundException {
        this.searchFiles(System.getProperty("user.home") + File.separator + "Desktop");
        if (this.osbotPath == null) {
            throw new FileNotFoundException("OSBot file could not be found...");
        }
    }

    public String getCommand() {
        final StringBuilder sb = new StringBuilder();

        sb.append(this.getClientLocation());
        sb.append(this.getOSBotLogin());
        sb.append(this.getBotLogin());
        sb.append(this.getWorld());

        if (this.useProxy()) {
            sb.append(this.getProxy());
        }
        if (this.lowCPU) {
            sb.append(this.getLowCPU());
        }
        if (this.script != null) {
            sb.append(this.getScript());
        }
        if (this.memAmount > 0) {
            sb.append(this.getMemoryUsage());
        }
        return sb.toString();
    }

    public void setOSBotLogin(String osbotUser, String osbotPass) {
        this.osbotUser = osbotUser;
        this.osbotPass = osbotPass;
    }

    public void setProxy(String proxyIp, String proxyPort, String proxyUser, String proxyPass) {
        this.proxyIp = proxyIp;
        this.proxyPort = proxyPort;
        this.proxyUser = proxyUser;
        this.proxyPass = proxyPass;
    }

    public void setBotLogin(String botUser, String botPass, String botPin) {
        this.botUser = botUser;
        this.botPass = botPass;
        this.botPin = botPin;
    }

    public void setScript(String script, String args) {
        this.script = script;
        this.scriptArgs = args;
    }

    public void setWorld(int world) {
        this.world = world;
    }

    public void setLowCPU(boolean lowCPU) {
        this.lowCPU = lowCPU;
    }

    public void setMemoryAmount(int memAmount) {
        this.memAmount = memAmount;
    }

    public void setAutoLogin(boolean useAutoLogin) {
        this.useAutoLogin = useAutoLogin;
    }

    private String getClientLocation() {
        return "java -jar \"" + this.osbotPath + "\" ";
    }

    private String getOSBotLogin() {
        if (this.useAutoLogin) {
            return "-autologin ";
        } else if (!this.osbotUser.equals("") || !this.osbotPass.equals("")) {
            return "-login " + this.osbotUser + ":" + this.osbotPass + " ";
        }
        return "";
    }

    private String getBotLogin() {
        if (this.botUser.equals("") || this.botPass.equals("")) {
            return "";
        }
        return "-bot " + this.botUser + ":" + this.botPass + ":" + this.botPin + " ";
    }

    private String getProxy() {
        if (!this.isProxyPasswordAuth()) {
            return "-proxy " + this.proxyIp + ":" + this.proxyPort + " ";
        }
        return "-proxy " + this.proxyIp + ":" + this.proxyPort + ":" + this.proxyUser + ":" + this.proxyPass + " ";
    }

    private String getLowCPU() {
        return "-allow lowcpu ";
    }

    private String getWorld() {
        return "-world " + this.world + " ";
    }

    private String getMemoryUsage() {
        return "-mem " + this.memAmount + " ";
    }

    private String getScript() {
        if (this.script.equals("")) {
            return "";
        } else if (this.scriptArgs.equals("")) {
            return "-script " + this.script + ":0 ";
        }
        return "-script " + this.script + ":" + this.scriptArgs + " ";
    }

    private boolean useProxy() {
        return !this.proxyIp.equals("") && !this.proxyPort.equals("");
    }

    private boolean isProxyPasswordAuth() {
        return !this.proxyUser.equals("") && !this.proxyPass.equals("");
    }

    private void searchFiles(String path) {
        final File file = new File(path);
        final String[] fileList = file.list();

        if (fileList != null) {
            for (String str : fileList) {
                if (this.osbotPath != null) {
                    break;
                } else if (str.toLowerCase().contains("osbot") && str.toLowerCase().contains(".jar")) {
                    this.osbotPath = path + File.separator + str;
                }
                this.searchFiles(path + File.separator + str);
            }
        }
    }
}
