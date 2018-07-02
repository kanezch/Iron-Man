package me.kanezheng.app;

public class MicroService {
    private String msName;
    private String msTeam;
    private String msMaintainer;
    private String msDesc;

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
}
