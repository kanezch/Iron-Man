package me.kanezheng.app;

public class MicroService {
    private String msName;
    private String msTeam;
    private String msMaintainer;
    private String msDesc;
    private String codeLang;
    private Boolean bIsRestWS;
    private int servicePort;

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

    public String getMsTeam() {
        return msTeam;
    }

    public void setMsTeam(String msTeam) {
        this.msTeam = msTeam;
    }

    public String getMsMaintainer() {
        return msMaintainer;
    }

    public void setMsMaintainer(String msMaintainer) {
        this.msMaintainer = msMaintainer;
    }

    public String getMsDesc() {
        return msDesc;
    }

    public void setMsDesc(String msDesc) {
        this.msDesc = msDesc;
    }

    public String getCodeLang() { return codeLang; }

    public void setCodeLang(String codeLang) { this.codeLang = codeLang; }

    public Boolean getbIsRestWS() { return bIsRestWS; }

    public void setbIsRestWS(Boolean bIsRestWS) { this.bIsRestWS = bIsRestWS; }

    public int getServicePort() { return servicePort; }

    public void setServicePort(int servicePort) { this.servicePort = servicePort; }

    @Override
    public String toString() {
        return "MicroService{" +
                "msName='" + msName + '\'' +
                ", msTeam='" + msTeam + '\'' +
                ", msMaintainer='" + msMaintainer + '\'' +
                ", msDesc='" + msDesc + '\'' +
                ", codeLang='" + codeLang + '\'' +
                ", bIsRestWS=" + bIsRestWS +
                ", servicePort=" + servicePort +
                '}';
    }
}
