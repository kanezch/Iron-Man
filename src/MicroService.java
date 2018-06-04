public class MicroService {
    private String msname;
    private String msteam;
    private String msmaintainer;
    private String description;

    public MicroService() {
    }

    public MicroService(String msname, String msteam, String msmaintainer, String description) {
        this.msname = msname;
        this.msteam = msteam;
        this.msmaintainer = msmaintainer;
        this.description = description;
    }

    public String getMsname() {
        return msname;
    }

    public void setMsname(String msname) {
        this.msname = msname;
    }

    public String getMsteam() {
        return msteam;
    }

    public void setMsteam(String msteam) {
        this.msteam = msteam;
    }

    public String getMsmaintainer() {
        return msmaintainer;
    }

    public void setMsmaintainer(String msmaintainer) {
        this.msmaintainer = msmaintainer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
